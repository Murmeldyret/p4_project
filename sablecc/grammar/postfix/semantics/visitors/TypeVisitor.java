package postfix.semantics.visitors;

import postfix.node.AExprValPrime2Expr;
import postfix.node.AExprValPrimeExpr;
import postfix.node.AVariableDeclarationInitializationDcl;
import postfix.node.PVal;
import postfix.node.TBopNot;
import postfix.semantics.SymbolTable;

public class TypeVisitor extends SemanticVisitor {

    public TypeVisitor() {
    }

    public TypeVisitor(SymbolTable symbolTable) {
        super(symbolTable);
    }

    protected String outerType;
    protected TBopNot bopNot;
    protected PVal value;

    /**
     * Tests if an expression produces a valid value
     * @param node The expression node to test
     */
    private boolean typeCheckExpression(AExprValPrimeExpr node) {
        boolean res = false;

        TBopNot bopNot;
        PVal value;
        String LHSType;
        String RHSType;
        


        return res;
    }

    @Override
    public void inAVariableDeclarationInitializationDcl(AVariableDeclarationInitializationDcl node) {
        // TODO Auto-generated method stub
        super.inAVariableDeclarationInitializationDcl(node);
    }

    @Override
    public void inAExprValPrimeExpr(AExprValPrimeExpr node) {
        String outerType;
        TBopNot bopNot;
        PVal value;

        node.getBopNot().apply(this);
        node.getVal().apply(this);
        node.getExprPrime().apply(this);

    }

}
