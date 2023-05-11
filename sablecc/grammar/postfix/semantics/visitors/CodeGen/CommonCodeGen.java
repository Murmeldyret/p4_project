package postfix.semantics.visitors.CodeGen;

import postfix.analysis.DepthFirstAdapter;
import postfix.node.AAddToArrayArrayOp;
import postfix.node.AAssignStmt;
import postfix.node.ABlockStmtBlock;
import postfix.node.AControlStatementStmt;
import postfix.node.ADeclarationStmt;
import postfix.node.AElifStatementInControlStmt;
import postfix.node.AElseBlockStatementElseStatement;
import postfix.node.AExprValPrimeExpr;
import postfix.node.AForLoopStmt;
import postfix.node.AFunctionCallStmt;
import postfix.node.APrintStatementStmt;
import postfix.node.AVariableDeclarationArrayDcl;
import postfix.node.AVariableDeclarationDcl;
import postfix.node.AExprPrimeOperatorValPrimeExprPrime;
import postfix.node.AVariableDeclarationInitializationDcl;
import postfix.node.AWhileLoopStmt;
import postfix.semantics.SymbolTable;

public class CommonCodeGen extends DepthFirstAdapter {
    // Variables
    SymbolTable symbolTable;

    public String program;

    // Constructor
    public CommonCodeGen() {
    };

    public CommonCodeGen(SymbolTable symbolTable, String program) {
        this.symbolTable = symbolTable;
        this.program = program;
    }

    @Override
    public void outADeclarationStmt(ADeclarationStmt node) {
        program += ";";
    }

    @Override
    public void inAAssignStmt(AAssignStmt node) {
        program += node.getId().getText().toString();

        node.getIndexing().apply(this);
        node.setIndexing(null);
        program += " = ";
    }

    @Override
    public void outAAssignStmt(AAssignStmt node) {
        program += ";";
    }

    @Override
    public void outAFunctionCallStmt(AFunctionCallStmt node) {
        program += ";";
    }

    @Override
    public void inAWhileLoopStmt(AWhileLoopStmt node) {

        program += "while (";
        node.getExpr().apply(this);
        node.setExpr(null);
        program += ")";

    }

    @Override
    public void inAControlStatementStmt(AControlStatementStmt node) {
        program += "if (";
        node.getExpr().apply(this);
        node.setExpr(null);
        program += ") ";
    }

    @Override
    public void inAPrintStatementStmt(APrintStatementStmt node) {
        program += "System.out.println(";
    }

    @Override
    public void outAPrintStatementStmt(APrintStatementStmt node) {
        program += ");";
    }

    @Override
    public void inAVariableDeclarationInitializationDcl(AVariableDeclarationInitializationDcl node) {
        if (!symbolTable.DeclaredLocally(node.getId().getText().toString())) {
            
            String type = typeSwitch(node.getType().getText().toString());

            program += type + node.getId().getText().toString() + " = ";
        }
    }

    @Override
    public void inABlockStmtBlock(ABlockStmtBlock node) {
        program += "{";
    }
    
    @Override
    public void outABlockStmtBlock(ABlockStmtBlock node) {
        program += "}";
    }

    @Override
    public void inAElifStatementInControlStmt(AElifStatementInControlStmt node) {
        program += "else if (";
        node.getExpr().apply(this);
        node.setExpr(null);
        program += ") ";
    }

    @Override
    public void inAElseBlockStatementElseStatement(AElseBlockStatementElseStatement node) {
        program += "else ";
    }

    @Override
    public void inAExprValPrimeExpr(AExprValPrimeExpr node) {
        if (node.getBopNot() != null)
            program += "!";

        program += node.getVal().toString();
    }

    @Override
    public void inAVariableDeclarationDcl(AVariableDeclarationDcl node) {
        program += " " + typeSwitch(node.getType().getText()) + node.getId().getText();
    }


    private String typeSwitch(String type) {
        switch (type) {
            case "int":
                return "int";
            case "float":
                return "double";
            case "bool":
                return "boolean";
            case "string":
                return "String";
            case "char":
                return "char";
        }
        return "";
    }

    @Override
    public void inAExprPrimeOperatorValPrimeExprPrime(AExprPrimeOperatorValPrimeExprPrime node) {
        String expr = "";

        expr += node.getBinInfixOp().toString();
        expr += node.getVal().toString();

        program += expr;
    }
    
    @Override
    public void inAForLoopStmt(AForLoopStmt node) {
        program += "for ( " + symbolTable.get(node.getId().getText()).getType().getText() + " " + node.getId().getText() + " : ";

        node.getVal().apply(this);
        node.setVal(null);

        program += ") ";

    }

    @Override
    public void inAVariableDeclarationArrayDcl(AVariableDeclarationArrayDcl node) {
        if (typeSwitch(node.getType().getText()) == "int")
        {
            program += "ArrayList<Integer> " + node.getId().getText() + " = new ArrayList<Integer>()";
        } else if (typeSwitch(node.getType().getText()) == "double") {
            program += "ArrayList<Double> " + node.getId().getText() + " = new ArrayList<Double>()";
        } else {
            program += "ArrayList<" + typeSwitch(node.getType().getText()) + "> " + node.getId().getText() + " = new ArrayList<" + typeSwitch(node.getType().getText()) + ">()";
        }
        
    }

    @Override
    public void inAAddToArrayArrayOp(AAddToArrayArrayOp node) {
        Object o = node.getArrayExpr();

        if (o instanceof String)
        {
            program += node.getId().getText() + ".add(\"" + node.getArrayExpr().toString().strip() + "\");";
        } else {
            program += node.getId().getText() + ".add(" + node.getArrayExpr().toString().strip() + ");";
        }
        
    }

}
