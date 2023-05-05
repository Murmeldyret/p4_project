package postfix.semantics.visitors;

import postfix.analysis.DepthFirstAdapter;
import postfix.node.*;
import postfix.semantics.QueueList;
import postfix.semantics.SymbolTable;
import postfix.semantics.Exceptions.invalidFunctionCallException;

public class SemanticVisitor extends DepthFirstAdapter {

    // TODO Kapitel 8.8 i fischer bogen
    public SemanticVisitor() {

    }

    public SemanticVisitor(SymbolTable symbolTable) {
        this.symbolTable = symbolTable;
        functionParameterTypeList = new QueueList<>();
    }

    protected SymbolTable symbolTable;
    protected QueueList<String> functionParameterTypeList;

    @Override
    public void inStart(Start node) {
        this.symbolTable = new SymbolTable(null, SymbolTable.Scopekind.block);
    }

    @Override
    public void inAImportWithoutSeperatorStmt(AImportWithoutSeperatorStmt node) {
        // add to symbol table
    }

    @Override
    public void inAImportWithSeperatorStmt(AImportWithSeperatorStmt node) {
        // add to symbol table
    }

    @Override
    public void inADeclarationStmt(ADeclarationStmt node) {
        TopDclVisitor dclVisitor = new TopDclVisitor(symbolTable);
        node.apply(dclVisitor);

    }

    @Override
    public void inAAssignStmt(AAssignStmt node) {
        String variableId = node.getId().getText();
        PExpr expression = node.getExpr();

        if (!symbolTable.containsKey(variableId)) {
            throw new RuntimeException("Variable " + variableId + " is not declared.");
        }

        String variableType = symbolTable.get(variableId).getType().getText();

        TypeVisitor typeVisitor = new TypeVisitor(symbolTable);
        expression.apply(typeVisitor);

        String expressionType = "";
        if (!typeVisitor.typeQueue.isEmpty()) {
            expressionType = typeVisitor.typeQueue.remove();
        }

        if (!variableType.equals(expressionType)) {
            throw new RuntimeException("Type mismatch: Cannot assign a value of type " + expressionType
                    + " to variable " + variableId + " of type " + variableType + ".");
        }
    }

    // @Override
    // public void outAFunctionDeclarationDcl(AFunctionDeclarationDcl node) {
    // // TODO Auto-generated method stub
    // super.outAFunctionDeclarationDcl(node);
    // }

    @Override
    public void inAForLoopStmt(AForLoopStmt node) {
        // Type Visitor
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
            throw new invalidFunctionCallException("Cannot pass parameters to a function that does not take any parameters");
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
            AFunctionCallFunctionCall functionCallNode = (AFunctionCallFunctionCall)parent;
            throw new invalidFunctionCallException("Cannot pass " +i + " parameters to a function that only takes " +symbolTable.get(functionCallNode.getId().getText()).getParameterTypeListAsQueueList().size()+ " parameters");
        }
        node.getExpr().apply(new TypeVisitor(symbolTable, functionParameterTypeList.remove()));
    }

    @Override
    public void outAFunctionCallFunctionCall(AFunctionCallFunctionCall node) {
        if (!functionParameterTypeList.isEmpty()) {
            throw new invalidFunctionCallException("Function" +node.getId().getText()+"()" + " takes "+ functionParameterTypeList.size() +" more parameters"+ " at line " + node.getId().getLine());
        }
        // symbolTable = symbolTable.getOuterSymbolTable();
    }
}
