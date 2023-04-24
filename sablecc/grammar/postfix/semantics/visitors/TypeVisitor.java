package postfix.semantics.visitors;

import java.util.HashMap;
import java.util.Queue;
import java.util.Stack;

import postfix.node.AExprValPrime2Expr;
import postfix.node.AExprValPrimeExpr;
import postfix.node.AFunctionCallFunctionCall;
import postfix.node.AValBoolVal;
import postfix.node.AValFloatnumVal;
import postfix.node.AValFunctionCallVal;
import postfix.node.AValIdVal;
import postfix.node.AValIntnumVal;
import postfix.node.AValStringVal;
import postfix.node.AVariableDeclarationInitializationDcl;
import postfix.node.PVal;
import postfix.node.TBopNot;
import postfix.node.TId;
import postfix.semantics.SymbolTable;

public class TypeVisitor extends SemanticVisitor {

    public TypeVisitor() {
    }

    public TypeVisitor(SymbolTable symbolTable) {
        super(symbolTable);
        typeStack = new Stack<String>();
    }

    protected Stack<String> typeStack;
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

        return res;
    }

    @Override
    public void inAVariableDeclarationInitializationDcl(AVariableDeclarationInitializationDcl node) {
        node.getExpr().apply(this);
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

}
