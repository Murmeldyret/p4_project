package postfix.semantics.visitors;

import java.util.Queue;
import java.util.Stack;

import postfix.semantics.SymbolTable;
import postfix.semantics.Exceptions.InvalidExpressionException;
import postfix.node.*;;

/**
 * TODO lav doc
 */
public class TypeVisitor extends SemanticVisitor {

    public TypeVisitor() {
    }

    /**
     * Should be called once at every new expression, not the top of the tree
     * 
     * @param symbolTable
     */
    public TypeVisitor(SymbolTable symbolTable) {
        super(symbolTable);
        typeStack = new Stack<String>();
        operatorStack = new Stack<String>();
    }

    protected Stack<String> typeStack;
    protected Stack<String> operatorStack;
    protected TBopNot bopNot;
    protected PVal value;

    /**
     * Gets the type of a PVal node
     * 
     * @param val the node whose type will be returned
     * @return
     */
    private String getValType(PVal val) {
        return "";

    }

    /**
     * Gets the type of of a subexpression of type ExprPrime
     * 
     * @param node The node whose type will be returned
     * @return
     * @deprecated
     */
    @Deprecated
    private String getSubExprType(PExprPrime node) {
        String res = "";

        if (node instanceof AExprPrimeOperatorValPrimeExprPrime) {
            res = getAExprPrimeOperatorValPrimeExprPrimeType((AExprPrimeOperatorValPrimeExprPrime) node);
        }
        return res;
    }

    /**
     * Helper method to {@link #getSubExprType(PExprPrime)}
     * 
     * @param node
     * @return
     */
    private String getAExprPrimeOperatorValPrimeExprPrimeType(AExprPrimeOperatorValPrimeExprPrime node) {

        // operatorStack.push(getBinInfixOperator(node.getBinInfixOp()));

        // node.getVal().apply(this);
        return "";
    }

    /**
     * Tests if an expression produces a valid value
     * 
     * @param node The expression node to test
     * @return true if the expression produces a valid value under the current type
     *         system.
     */
    private boolean typeCheckExpression(AExprValPrimeExpr node) {
        boolean res = false;

        TBopNot bopNot;
        PVal value;
        String LHSType = getValType(node.getVal());
        String RHSType;
        if (node.getExprPrime() != null) {

        }

        return res;
    }

    // @Override
    // public void inAVariableDeclarationInitializationDcl(AVariableDeclarationInitializationDcl node) {
    //     node.getExpr().apply(this);
    // }

    @Override
    public void inAExprValPrimeExpr(AExprValPrimeExpr node) {

        if (node.getBopNot() != null) {
            operatorStack.push(node.getBopNot().getText());
        }
    }

    @Override
    public void outAExprValPrimeExpr(AExprValPrimeExpr node) {
        if (!typeCheckExpression(node)) {
            throw new InvalidExpressionException("Expression does not produce a valid type", node);
        }
    }

    // @Override
    // public void inAExprPrimeOperatorValPrimeExprPrime(AExprPrimeOperatorValPrimeExprPrime node) {
    //     node.getBinInfixOp().apply(this);
    //     node.getVal().apply(this);
    //     node.getExprPrime().apply(this);
    // }

    // PVal nodes
    @Override
    public void inAValBoolVal(AValBoolVal node) {
        typeStack.push("bool");
    }

    @Override
    public void inAValFloatnumVal(AValFloatnumVal node) {
        typeStack.push("float");
    }

    @Override
    public void inAValFunctionCallVal(AValFunctionCallVal node) {
        // TODO virker med garanti ikke, skal have funktionens identifier
        node.getFunctionCall().apply(this);
    }

    @Override
    public void inAValIdVal(AValIdVal node) {
        // Seems legit
        typeStack.push(symbolTable.get(node.getId().getText()).getType().getText());
    }

    @Override
    public void inAValIntnumVal(AValIntnumVal node) {
        typeStack.push("int");
    }

    @Override
    public void inAValStringVal(AValStringVal node) {
        typeStack.push("string");
    }

    @Override
    public void inAFunctionCallFunctionCall(AFunctionCallFunctionCall node) {
        typeStack.push(symbolTable.get(node.getId().getText()).getType().getText());
    }

    // --PBinInfixOp nodes--
    // Hvis operators var token vil dette være en metode, oh well
    @Override
    public void inADivisionInfixBinInfixOp(ADivisionInfixBinInfixOp node) {
        operatorStack.push(node.getOpDiv().getText());
    }

    @Override
    public void inAEqualityInfixBinInfixOp(AEqualityInfixBinInfixOp node) {
        operatorStack.push(node.getBopEq().getText());
    }

    @Override
    public void inAGreaterThanEqualInfixBinInfixOp(AGreaterThanEqualInfixBinInfixOp node) {
        operatorStack.push(node.getBopGethan().getText());
    }

    @Override
    public void inAGreaterThanInfixBinInfixOp(AGreaterThanInfixBinInfixOp node) {
        operatorStack.push(node.getBopGthan().getText());
    }

    @Override
    public void inALessThanEqualInfixBinInfixOp(ALessThanEqualInfixBinInfixOp node) {
        operatorStack.push(node.getBopLethan().getText());
    }

    @Override
    public void inALessThanInfixBinInfixOp(ALessThanInfixBinInfixOp node) {
        operatorStack.push(node.getBopLthan().getText());
    }

    @Override
    public void inAMinusInfixBinInfixOp(AMinusInfixBinInfixOp node) {
        operatorStack.push(node.getOpMinus().getText());
    }

    @Override
    public void inAModuloInfixBinInfixOp(AModuloInfixBinInfixOp node) {
        operatorStack.push(node.getOpMod().getText());
    }

    @Override
    public void inAMultiplicationInfixBinInfixOp(AMultiplicationInfixBinInfixOp node) {
        operatorStack.push(node.getOpMult().getText());
    }

    @Override
    public void inANotEqualInfixBinInfixOp(ANotEqualInfixBinInfixOp node) {
        operatorStack.push(node.getBopNeq().getText());
    }

    @Override
    public void inAOrInfixBinInfixOp(AOrInfixBinInfixOp node) {
        operatorStack.push(node.getBopOr().getText());
    }

    @Override
    public void inAPlusInfixBinInfixOp(APlusInfixBinInfixOp node) {
        operatorStack.push(node.getOpPlus().getText());
    }

    @Override
    public void inAAndInfixBinInfixOp(AAndInfixBinInfixOp node) {
        operatorStack.push(node.getBopAnd().getText());
    }

}
