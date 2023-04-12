import postfix.analysis.DepthFirstAdapter;
import postfix.lexer.*;
import postfix.parser.*;
import postfix.node.*;

import java.io.*;



public class Visitor extends DepthFirstAdapter {

    static final int indent = 4;
    int indent_count = 0;

    @Override
    public void inAValIntnumVal(AValIntnumVal node) {
        System.out.print(node.toString());
    }

    @Override
    public void inAWhileLoopStmt(AWhileLoopStmt node) {
        print_indent();
        System.out.print(node.getKwWhile().toString());
    }

    @Override
    public void inABlockStmtBlock(ABlockStmtBlock node) {
        print_indent();
        System.out.println(node.getLCbrack().toString());
        indent_count += indent;
    }

    @Override
    public void outABlockStmtBlock(ABlockStmtBlock node) {
        indent_count -= indent;
        print_indent();
        System.out.println(node.getRCbrack().toString());
    }

    @Override
    public void outAStatementsStmts(AStatementsStmts node) {
        System.out.println("\n");
    }

    @Override
    public void inAExprValPrimeExpr(AExprValPrimeExpr node) {
        if(node.getBopNot() != null) {
            System.out.print("!");
        }
    }

    @Override
    public void inAExprPrimeOperatorValPrimeExprPrime(AExprPrimeOperatorValPrimeExprPrime node) {
        System.out.print(node.getBinInfixOp().toString());
    }

    private void print_indent() {
        for(int i = 0; i < indent_count; i++) {
            System.out.print(" ");
        }
    }
}