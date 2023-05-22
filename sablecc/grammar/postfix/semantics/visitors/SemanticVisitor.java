package postfix.semantics.visitors;

import org.testng.xml.IFileParser;

import postfix.analysis.DepthFirstAdapter;
import postfix.node.*;
import postfix.semantics.IdAttributes;
import postfix.semantics.QueueList;
import postfix.semantics.SymbolTable;
import postfix.semantics.Exceptions.*;
import postfix.semantics.IdAttributes.Attributes;
import postfix.semantics.SymbolTable.Scopekind;

/**
 * Responsible for verifying that a program is semantically correct
 */
public class SemanticVisitor extends DepthFirstAdapter {
    public SemanticVisitor() {
        symbolTable = new SymbolTable(null, SymbolTable.Scopekind.block);
    }

    public SemanticVisitor(SymbolTable symbolTable) {
        this.symbolTable = symbolTable;
    }

    protected SymbolTable symbolTable;
    protected QueueList<String> functionParameterTypeList;

    @Override
    public void inStart(Start node) {
    }

    // TODO: Check igennem den her igen, og se om der er noget der skal ændres
    @Override
    public void inAImportWithoutSeperatorStmt(AImportWithoutSeperatorStmt node) {
        node.apply(new TopDclVisitor(symbolTable));
    }

    @Override
    public void inAImportWithSeperatorStmt(AImportWithSeperatorStmt node) {
        node.apply(new TopDclVisitor(symbolTable));
    }

    @Override
    public void inAExportStatementStmt(AExportStatementStmt node) {
        String filePath = node.getExpr().toString().trim(); // TODO virker ikke nødvendigvis
        String variableId = node.getId().getText();

        if (!symbolTable.containsKey(variableId)) {
            throw new RuntimeException("Variable is not declared.");
        }

        TType type = new TType("string");
        String value = filePath;

        IdAttributes fileAttributes = new IdAttributes(node.getId(), type, value, IdAttributes.Attributes.variable);

        symbolTable.put(filePath, fileAttributes);
    }

    @Override
    public void inAPrintStatementStmt(APrintStatementStmt node) {
        // TODO: Mangler expression validation..
        PExpr expression = node.getExpr();
        System.out.print(expression);
        super.inAPrintStatementStmt(node);
    }

    @Override
    public void inABreakStatementStmt(ABreakStatementStmt node) {
        // TODO skal være i break-able block
        if (symbolTable.getOuterSymbolTable() == null) {
            throw new InvalidBreakStatement("Cannot break when not within a loop or if block", node);
        }
    }

    @Override
    public void inAReturnStmt(AReturnStmt node) {
        // TODO skal være i funktionsblock
        try {
            symbolTable.getReturnType();
        } catch (IllegalArgumentException e) {
            // Sejt hack
            throw new invalidReturnExpression("Cannot return when not inside a funciton block", node);
        }
    }

    @Override
    public void inADeclarationStmt(ADeclarationStmt node) {
        TopDclVisitor dclVisitor = new TopDclVisitor(symbolTable);
        node.apply(dclVisitor);

    }

    @Override
    public void inABlockStmtBlock(ABlockStmtBlock node) {
        symbolTable = new SymbolTable(symbolTable, Scopekind.block);
    }

    @Override
    public void outABlockStmtBlock(ABlockStmtBlock node) {
        symbolTable = symbolTable.getOuterSymbolTable();
        if (symbolTable == null) {
            // Burde aldrig ske
            throw new Error("cannot set symbol table to null");
        }
    }

    @Override
    public void inAIndexingIndexing(AIndexingIndexing node) {
        // indeksering med andet end heltal er fy fy
        node.getExpr().apply(new TypeVisitor(symbolTable, "int"));
    }

    @Override
    public void inAArrayExprValPrimeArrayExpr(AArrayExprValPrimeArrayExpr node) {
        // node.apply(new TypeVisitor(symbolTable,null)); //TODO ?
        // ! Vent til omskrivning af grammatik
    }

    @Override
    public void inAAddToArrayArrayOp(AAddToArrayArrayOp node) {
        IdAttributes arr = symbolTable.get(node.getId().getText());
        if (arr.getAttributes() != Attributes.array) {
            throw new InvalidExpressionException("Cannot add to a non array type [Line " + node.getId().getLine()
                    + ", Pos " + node.getId().getPos() + "]");
        }
        node.getArrayExpr().apply(new TypeVisitor(symbolTable, arr.getType().getText()));
        // ? mere idk
    }

    @Override
    public void inARemoveFromArrayArrayOp(ARemoveFromArrayArrayOp node) {
        IdAttributes arr = symbolTable.get(node.getId().getText());
        if (arr.getAttributes() != Attributes.array) {
            throw new InvalidExpressionException("Cannot add to a non array type [Line " + node.getId().getLine()
                    + ", Pos " + node.getId().getPos() + "]");
        }
        // ? ig det er det der er ikke andet at tjekke
    }

    @Override
    public void inARemoveAtFromArrayArrayOp(ARemoveAtFromArrayArrayOp node) {
        IdAttributes arr = symbolTable.get(node.getId().getText());
        if (arr.getAttributes() != Attributes.array) {
            throw new InvalidExpressionException("Cannot add to a non array type [Line " + node.getId().getLine()
                    + ", Pos " + node.getId().getPos() + "]");
        }
        // indexing bliver type checked af inAIndexingIndexing i SemanticVisitor
    }

    @Override
    public void inAInsertToArrayArrayOp(AInsertToArrayArrayOp node) {
        IdAttributes arr = symbolTable.get(node.getId().getText());
        if (arr.getAttributes() != Attributes.array) {
            throw new InvalidExpressionException("Cannot add to a non array type [Line " + node.getId().getLine()
                    + ", Pos " + node.getId().getPos() + "]");
        }
        node.getExpr().apply(new TypeVisitor(symbolTable,arr.getType().getText()));
    }

    @Override
    public void inAAssignStmt(AAssignStmt node) {
        String variableId = node.getId().getText();
        PExpr expression = node.getExpr();

        if (!symbolTable.containsKey(variableId)) {
            throw new RuntimeException("Variable " + variableId + " is not declared.");
        }

        String variableType = symbolTable.get(variableId).getType().getText();

        TypeVisitor typeVisitor = new TypeVisitor(symbolTable, variableType);
        expression.apply(typeVisitor);
    }

    // @Override
    // public void outAFunctionDeclarationDcl(AFunctionDeclarationDcl node) {
    // // TODO Auto-generated method stub
    // super.outAFunctionDeclarationDcl(node);
    // }

    @Override
    public void inAForLoopStmt(AForLoopStmt node) {
        // !Grammatikken for skal omskrives, så vent med at implementere denne.
    }

    @Override
    public void inAWhileLoopStmt(AWhileLoopStmt node) {
        // the condition expression must be boolean
        node.getExpr().apply(new TypeVisitor(symbolTable, "bool"));
    }

    @Override
    public void inAControlStatementStmt(AControlStatementStmt node) {
        node.getExpr().apply(new TypeVisitor(symbolTable, "bool"));
    }

    @Override
    public void caseAFunctionDeclarationDcl(AFunctionDeclarationDcl node) {
        inAFunctionDeclarationDcl(node);
        if (node.getType() != null) {
            node.getType().apply(this);
        }
        if (node.getKwFunction() != null) {
            node.getKwFunction().apply(this);
        }
        if (node.getId() != null) {
            node.getId().apply(this);
        }
        // ! uh oh
        // TODO kan godt være at denne ikke er nødvendig længere
        symbolTable = symbolTable.getFunctionSymbolTable(node.getId().getText());
        if (node.getFunctionParam() != null) {
            node.getFunctionParam().apply(this);
        }
        if (node.getBlock() != null) {
            node.getBlock().apply(this);
        }
        outAFunctionDeclarationDcl(node);
    }
    @Override
    public void inAFunctionCallFunctionCall(AFunctionCallFunctionCall node) {
        // funktionsparametre

        functionParameterTypeList = symbolTable.get(node.getId().getText()).getParameterTypeListAsQueueList();
        // skal først træde ind i funktionsblock når man kommer til stmts
        // symbolTable = symbolTable.getFunctionSymbolTable(node.getId().getText());
    }

    @Override
    public void inAFunctionCallParamFunctionCallParam(AFunctionCallParamFunctionCallParam node) {
        // TODO antal af givne parametre skal stemme overens med den erklærede funktion
        if (functionParameterTypeList.isEmpty()) {
            throw new invalidFunctionCallException(
                    "Cannot pass parameters to a function that does not take any parameters", node);
        }
        node.getExpr().apply(new TypeVisitor(symbolTable, functionParameterTypeList.remove()));

    }

    @Override
    public void inAFunctionCallParamPrimeFunctionCallParamPrime(AFunctionCallParamPrimeFunctionCallParamPrime node) {
        if (functionParameterTypeList.isEmpty()) {
            int i = 1;
            Node parent = node.parent();
            while (!(parent instanceof AFunctionCallFunctionCall)) {
                i++;
                parent = parent.parent();
            }
            AFunctionCallFunctionCall functionCallNode = (AFunctionCallFunctionCall) parent;
            throw new invalidFunctionCallException("Cannot pass " + i + " parameters to a function that only takes "
                    + symbolTable.get(functionCallNode.getId().getText()).getParameterTypeListAsQueueList().size()
                    + " parameters", node);
        }
        node.getExpr().apply(new TypeVisitor(symbolTable, functionParameterTypeList.remove()));
    }

    @Override
    public void outAFunctionCallFunctionCall(AFunctionCallFunctionCall node) {
        if (!functionParameterTypeList.isEmpty()) {
            throw new invalidFunctionCallException("Function" + node.getId().getText() + "()" + " takes "
                    + functionParameterTypeList.size() + " more parameters" + " at line " + node.getId().getLine());
        }
        // symbolTable = symbolTable.getOuterSymbolTable();
    }

    // --special syntax--
    // @Override
    // public void inAExprSpecialExpr(AExprSpecialExpr node) {
    // }

    @Override
    public void inAExprSpecialExpr(AExprSpecialExpr node) {
        PSpecialExpr specialExpr = node.getSpecialExpr();
        String id = node.getId().getText();
        String idType = symbolTable.get(id).getType().getText();

        if (symbolTable.get(node.getId().getText()).getAttributes()!= Attributes.csv) {
            throw new InvalidExpressionException(idType);
        }

        specialExpr.apply(new TypeVisitor(symbolTable, idType));
    }

    @Override
    public void inAFilterSpecialSyntax(AFilterSpecialSyntax node) {
        PExpr expr = node.getExpr();
        expr.apply(new TypeVisitor(symbolTable, "bool"));
    }
    
    @Override
    public void inASortAscSpecialSyntax(ASortAscSpecialSyntax node) {
        node.getExpr().apply(new TypeVisitor(symbolTable, "string"));
    }

    @Override
    public void inASortDescSpecialSyntax(ASortDescSpecialSyntax node) {
        node.getExpr().apply(new TypeVisitor(symbolTable, "string"));
    }

    @Override
    public void inASortSpecialSyntax(ASortSpecialSyntax node) {
        node.getExpr().apply(new TypeVisitor(symbolTable, "string"));
    }

}
