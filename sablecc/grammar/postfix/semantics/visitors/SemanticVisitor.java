package postfix.semantics.visitors;

import postfix.analysis.DepthFirstAdapter;
import postfix.node.*;
import postfix.semantics.IdAttributes;
import postfix.semantics.QueueList;
import postfix.semantics.SymbolTable;
import postfix.semantics.Exceptions.invalidFunctionCallException;

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

    @Override
    public void inAImportWithoutSeperatorStmt(AImportWithoutSeperatorStmt node) {
        String filePath = node.getString().getText();
        String variableId = node.getId().getText();

        // Remove quotes from filepath string
        if (filePath.length() > 2) {
            filePath = filePath.substring(1, filePath.length() - 1);
        }

        TType type = new TType("string");
        String value = filePath;

        IdAttributes idAttributes = new IdAttributes(node.getId(), type, value, IdAttributes.Attributes.variable);

        symbolTable.put(variableId, idAttributes);
    }

    @Override
    public void inAImportWithSeperatorStmt(AImportWithSeperatorStmt node) {
        // ? Måske skal path string være expr i stedet, med type check for at godkende
        // at det er en string
        // add to symbol table
    }

    @Override
    public void inAExportStatementStmt(AExportStatementStmt node) {
        String filePath = node.getExpr().toString().trim();
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
    }

    @Override
    public void inAReturnStmt(AReturnStmt node) {
        // TODO skal være i funktionsblock
    }

    @Override
    public void inADeclarationStmt(ADeclarationStmt node) {
        TopDclVisitor dclVisitor = new TopDclVisitor(symbolTable);
        node.apply(dclVisitor);

    }

    @Override
    public void inAElseBlockStatementElseStatement(AElseBlockStatementElseStatement node) {
        // TODO ny undersymboltabel
    }

    @Override
    public void outAElseBlockStatementElseStatement(AElseBlockStatementElseStatement node) {
        // TODO tilbage til ydre tabel
    }

    @Override
    public void inAIndexingIndexing(AIndexingIndexing node) {
        // indeksering med andet end heltal er fy fy
        node.getExpr().apply(new TypeVisitor(symbolTable, "int"));
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
        //! uh oh
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
                    "Cannot pass parameters to a function that does not take any parameters",node);
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
                    + " parameters",node);
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
    public void inAFilterSpecialSyntax(AFilterSpecialSyntax node) {
        super.inAFilterSpecialSyntax(node);
    }

    @Override
    public void inASortAscSpecialSyntax(ASortAscSpecialSyntax node) {
        node.getExpr().apply(new TypeVisitor(symbolTable, "csv"));
    }

    @Override
    public void inASortDescSpecialSyntax(ASortDescSpecialSyntax node) {
        node.getExpr().apply(new TypeVisitor(symbolTable, "csv"));
    }

    @Override
    public void inASortSpecialSyntax(ASortSpecialSyntax node) {
        node.getExpr().apply(new TypeVisitor(symbolTable, "csv"));
    }

}
