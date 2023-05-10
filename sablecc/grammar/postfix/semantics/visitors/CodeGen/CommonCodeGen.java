package postfix.semantics.visitors.CodeGen;

import java.util.List;

import postfix.analysis.DepthFirstAdapter;
import postfix.node.AAssignStmt;
import postfix.node.ADeclarationStmt;
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
    public void outADeclarationStmt(ADeclarationStmt node) {
        program += ";";
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
        if (!symbolTable.DeclaredLocally(node.getId().getText().toString()))
        {
            // Call function here.
            String type = typeSwitch(node.getType().getText().toString());

            program += type + node.getId().getText().toString() + " = ";
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
        program += typeSwitch(node.getType().getText()) + node.getId().getText();
    }


    private String typeSwitch(String type) {
            switch (type) {
                case "int":
                    return "int ";
                case "float":
                    return "double ";
                case "bool":
                    return "boolean ";
                case "string":
                    return "String ";
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
    
    @Override
    public void inAForLoopStmt(AForLoopStmt node) {
        program += "for ( " + symbolTable.get(node.getId().getText()).getType().getText() + " " + node.getId().getText() + " : ";

        node.getVal().apply(this);
        node.setVal(null);

        program += ") ";

    }

}
