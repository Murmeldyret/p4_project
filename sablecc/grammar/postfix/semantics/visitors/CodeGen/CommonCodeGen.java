package postfix.semantics.visitors.CodeGen;

import java.util.List;

import postfix.analysis.DepthFirstAdapter;
import postfix.node.AExprValPrimeExpr;
import postfix.node.APrintStatementStmt;
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
    public void inAExprValPrimeExpr(AExprValPrimeExpr node) {
        if (node.getBopNot() != null)
            program += node.getBopNot().getText().toString();

        program += node.getVal().toString();
    }
}
