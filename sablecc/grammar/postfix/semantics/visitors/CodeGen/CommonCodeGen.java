package postfix.semantics.visitors.CodeGen;

import java.util.List;

import postfix.analysis.DepthFirstAdapter;
import postfix.node.AAssignStmt;
import postfix.node.AExprValPrimeExpr;
import postfix.node.AForLoopStmt;
import postfix.node.APrintStatementStmt;
import postfix.node.AVariableDeclarationDcl;
import postfix.node.AExprPrimeOperatorValPrimeExprPrime;
import postfix.node.AExprValPrimeExpr;
import postfix.node.AFunctionDeclarationDcl;
import postfix.node.APrintStatementStmt;
import postfix.node.AStatementsStmts;
import postfix.node.AVariableDeclarationInitializationDcl;
import postfix.semantics.SymbolTable;

public class CommonCodeGen extends DepthFirstAdapter {
    // Variables
    SymbolTable symbolTable;

    public String program;
    
    //Constructor
    public CommonCodeGen() {};

    public CommonCodeGen(SymbolTable symbolTable, String program) {
        this.symbolTable = symbolTable;
        this.program = program;
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
        if (!symbolTable.isDeclared(node.getId().getText().toString()))
        {
            // Call function here.
        }
    }

    @Override
    public void inAExprValPrimeExpr(AExprValPrimeExpr node) {
        if (node.getBopNot() != null)
            program += "!";

        program += node.getVal().toString();
    }

    @Override
    public void inAVariableDeclarationDcl(AVariableDeclarationDcl node) {
        if (symbolTable.isDeclared(node.getId().getText())) {
            System.out.println("variable" + node.getId().getText() + " is already declared");
        } else {
            typeSwitch(node.getType().getText().toString());
        }
    }

    @Override
    public void outAVariableDeclarationDcl(AVariableDeclarationDcl node) {
        program += ";";
    }

    private String typeSwitch(String type) {
            switch (type) {
                case "int":
                    return "int ";
                case "float":
                    return "double ";
                case "bool":
                    return "bool ";
                case "string":
                    return "string ";
                case "csv":
                    return "csv ";
                case "char":
                    return "char ";
                case "array":
                    return "array ";
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
}
