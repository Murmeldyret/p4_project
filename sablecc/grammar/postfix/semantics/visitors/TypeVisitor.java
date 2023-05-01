package postfix.semantics.visitors;

import java.util.ArrayList;

import postfix.semantics.QueueList;
import postfix.semantics.SymbolTable;
import postfix.semantics.TypeSystem;
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
        typeQueue = new QueueList<String>();
        operatorQueue = new QueueList<String>();
    }

    protected QueueList<String> typeQueue;
    protected QueueList<String> operatorQueue;

    // Skal ikke bruges
    protected TBopNot bopNot;
    protected PVal value;

    //
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

        // operatorQueue.add(getBinInfixOperator(node.getBinInfixOp()));

        // node.getVal().apply(this);
        return "";
    }

    /**
     * 
     * @param node
     * @return
     */
    private boolean typeCheckFunctionParmams(AFunctionCallFunctionCall node) {
        boolean res = false;
        // TODO gør noget

        return res;
    }

    /**
     * Tests if an expression produces a valid value
     * 
     * @param node The expression node to test
     * @return true if the expression produces a valid value under the current type
     *         system.
     * @throws invalidExpressionException if the given expression does not produce a
     *                                    valid value
     */
    private boolean typeCheckExpression(AExprValPrimeExpr node) {
        boolean res = false;
        TypeSystem typeSystem = new TypeSystem();

        QueueList<String> SimplifiedExpressionTypeQueue = new QueueList<>();

        if (node.getExprPrime() != null) {
            try {

                Boolean isBinaryInFixOp;
                while (!operatorQueue.isEmpty()) {
                    String operator = operatorQueue.remove();

                    // TODO skal faktisk tjekke om operatoren er en binInfixOp
                    isBinaryInFixOp = true;
                    if (isBinaryInFixOp) {
                        String LhsType = SimplifiedExpressionTypeQueue.isEmpty() ? typeQueue.remove()
                                : SimplifiedExpressionTypeQueue.remove();
                        String RhsType = typeQueue.remove();
                        // System.out.print(
                        // "Operands are: " + LhsType + " and " + RhsType + " with operator: " +
                        // operator + ",");
                        SimplifiedExpressionTypeQueue.add(typeSystem.LookupResultingType(LhsType, RhsType, operator));
                        // System.out.println("and evaluated to type " +
                        // SimplifiedExpressionTypeQueue.element());
                    }

                }
                res = true;
            } catch (IllegalArgumentException e) {
                // TODO: handle exception
                throw new InvalidExpressionException("Expression does not produce a valid value", node);
            }

        }
        // System.out.println(
        // "Expression evaluating to type " + SimplifiedExpressionTypeQueue.element() +
        // " Returning " + res);
        return res;
    }

    // @Override
    // public void
    // inAVariableDeclarationInitializationDcl(AVariableDeclarationInitializationDcl
    // node) {
    // node.getExpr().apply(this);
    // }

    @Override
    public void inAExprValPrimeExpr(AExprValPrimeExpr node) {

        if (node.getBopNot() != null) {
            operatorQueue.add(node.getBopNot().getText());
        }
    }

    @Override
    public void outAExprValPrimeExpr(AExprValPrimeExpr node) {
        if (!typeCheckExpression(node)) {
            throw new InvalidExpressionException("Expression does not produce a valid type", node);
        }
    }

    // @Override
    // public void
    // inAExprPrimeOperatorValPrimeExprPrime(AExprPrimeOperatorValPrimeExprPrime
    // node) {
    // node.getBinInfixOp().apply(this);
    // node.getVal().apply(this);
    // node.getExprPrime().apply(this);
    // }

    // PVal nodes
    @Override
    public void inAValBoolVal(AValBoolVal node) {
        typeQueue.add("bool");
    }

    @Override
    public void inAValFloatnumVal(AValFloatnumVal node) {
        typeQueue.add("float");
    }

    // @Override
    // public void inAValFunctionCallVal(AValFunctionCallVal node) {
    // // TODO virker med garanti ikke, skal have funktionens identifier
    // node.getFunctionCall().apply(this);
    // }

    @Override
    public void inAValIdVal(AValIdVal node) {
        // Seems legit
        typeQueue.add(symbolTable.get(node.getId().getText()).getType().getText());
    }

    @Override
    public void inAValIntnumVal(AValIntnumVal node) {
        typeQueue.add("int");
    }

    @Override
    public void inAValStringVal(AValStringVal node) {
        typeQueue.add("string");
    }

    @Override
    public void inAFunctionCallFunctionCall(AFunctionCallFunctionCall node) {
        typeQueue.add(symbolTable.get(node.getId().getText()).getType().getText());

    }

    // --PBinInfixOp nodes--
    // Hvis operators var token vil dette være en metode, oh well
    @Override
    public void inADivisionInfixBinInfixOp(ADivisionInfixBinInfixOp node) {
        operatorQueue.add(node.getOpDiv().getText());
    }

    @Override
    public void inAEqualityInfixBinInfixOp(AEqualityInfixBinInfixOp node) {
        operatorQueue.add(node.getBopEq().getText());
    }

    @Override
    public void inAGreaterThanEqualInfixBinInfixOp(AGreaterThanEqualInfixBinInfixOp node) {
        operatorQueue.add(node.getBopGethan().getText());
    }

    @Override
    public void inAGreaterThanInfixBinInfixOp(AGreaterThanInfixBinInfixOp node) {
        operatorQueue.add(node.getBopGthan().getText());
    }

    @Override
    public void inALessThanEqualInfixBinInfixOp(ALessThanEqualInfixBinInfixOp node) {
        operatorQueue.add(node.getBopLethan().getText());
    }

    @Override
    public void inALessThanInfixBinInfixOp(ALessThanInfixBinInfixOp node) {
        operatorQueue.add(node.getBopLthan().getText());
    }

    @Override
    public void inAMinusInfixBinInfixOp(AMinusInfixBinInfixOp node) {
        operatorQueue.add(node.getOpMinus().getText());
    }

    @Override
    public void inAModuloInfixBinInfixOp(AModuloInfixBinInfixOp node) {
        operatorQueue.add(node.getOpMod().getText());
    }

    @Override
    public void inAMultiplicationInfixBinInfixOp(AMultiplicationInfixBinInfixOp node) {
        operatorQueue.add(node.getOpMult().getText());
    }

    @Override
    public void inANotEqualInfixBinInfixOp(ANotEqualInfixBinInfixOp node) {
        operatorQueue.add(node.getBopNeq().getText());
    }

    @Override
    public void inAOrInfixBinInfixOp(AOrInfixBinInfixOp node) {
        operatorQueue.add(node.getBopOr().getText());
    }

    @Override
    public void inAPlusInfixBinInfixOp(APlusInfixBinInfixOp node) {
        operatorQueue.add(node.getOpPlus().getText());
    }

    @Override
    public void inAAndInfixBinInfixOp(AAndInfixBinInfixOp node) {
        operatorQueue.add(node.getBopAnd().getText());
    }

}
