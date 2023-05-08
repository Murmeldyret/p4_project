package postfix.semantics.visitors;

import postfix.semantics.*;
import postfix.semantics.Exceptions.*;
import postfix.node.*;

/**
 * Represents a type checker whose responsibilty is to type check expressions
 * and verify that they produce a valid value.
 * Should be called once at every expression in the AST
 * 
 * @see {@link postfix.semantics.TypeSystem}
 */
public class TypeVisitor extends SemanticVisitor {

    private TypeSystem typeSystem = new TypeSystem();

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

    /**
     * Should be used when visiting assignments (or declarations with assignments)
     * or functions
     * 
     * @param symbolTable The symboltable for this scope
     * @param type        The type that a resulting expression should produce (i.e
     *                    from function return statements or assignments)
     */
    public TypeVisitor(SymbolTable symbolTable, String type) {
        this(symbolTable);
        expressionType = type;
    }

    protected QueueList<String> typeQueue;
    protected QueueList<String> operatorQueue;

    /** The type that an expression or return statement must return */
    protected String expressionType;

    @Override
    public void inAReturnStmt(AReturnStmt node) {
        // TODO Auto-generated method stub
        super.inAReturnStmt(node);
    }

    @Override
    public void outAReturnStmt(AReturnStmt node) {
        // TODO skal lige testes
        String expr = typeCheckExpression();
        if (!expr.equals(expressionType)) {
            throw new invalidReturnExpression(
                    "Cannot return a value of type " + expr + " on a function whose return type is " + expressionType);
        }
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
        String resultingType = typeCheckExpression();

        // Validate the resulting type and throw an exception if it's invalid
        if ("INVALID_TYPE".equals(resultingType)) {
            throw new InvalidExpressionException("Invalid expression type detected", node);
        }
    }

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
    // public void
    // inAExprPrimeOperatorValPrimeExprPrime(AExprPrimeOperatorValPrimeExprPrime
    // node) {
    // node.getBinInfixOp().apply(this);
    // node.getVal().apply(this);
    // node.getExprPrime().apply(this);
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

    // @Override
    // public void inAValFunctionCallVal(AValFunctionCallVal node) {
    // // TODO virker med garanti ikke, skal have funktionens identifier
    // node.getFunctionCall().apply(this);
    // }

    @Override
    public void inAValStringVal(AValStringVal node) {
        typeQueue.add("string");
    }

    @Override
    public void inAFunctionCallFunctionCall(AFunctionCallFunctionCall node) {
        typeQueue.add(symbolTable.get(node.getId().getText()).getType().getText());
        // symbolTable =
        // symbolTable.getFunctionSymbolTable(symbolTable.get(node.getId().getText()).getId().getText());
    }
    @Override
    public void inAFunctionCallParamFunctionCallParam(AFunctionCallParamFunctionCallParam node) {
        // // TODO Auto-generated method stub
        // super.inAFunctionCallParamFunctionCallParam(node);
        //! Vigtig, skal være her
        defaultIn(node);
    }
    @Override
    public void inAFunctionCallParamPrimeFunctionCallParamPrime(AFunctionCallParamPrimeFunctionCallParamPrime node) {
        // // TODO Auto-generated method stub
        // super.inAFunctionCallParamPrimeFunctionCallParamPrime(node);
        //! Vigtig, skal være her
        defaultIn(node);
    }

    @Override
    public void outAFunctionCallFunctionCall(AFunctionCallFunctionCall node) {
        // symbolTable = symbolTable.getOuterSymbolTable();
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
    private String typeCheckExpression() {
        // boolean res = false;
        String res = "";
        TypeSystem typeSystem = new TypeSystem();

        QueueList<String> SimplifiedExpressionTypeQueue = new QueueList<>();

        try {
            while (!operatorQueue.isEmpty()) {
                String operator = operatorQueue.remove();

                Boolean isBinaryInFixOp = typeSystem.isBinaryInfixOperator(operator);

                if (isBinaryInFixOp) {
                    String LhsType = SimplifiedExpressionTypeQueue.isEmpty() ? typeQueue.remove()
                            : SimplifiedExpressionTypeQueue.remove();
                    String RhsType = typeQueue.remove();

                    // if (typeSystem.isArithmeticOperator(operator)) {
                    // if (!typeSystem.isArithmeticType(LhsType) ||
                    // !typeSystem.isArithmeticType(RhsType)) {
                    // throw new InvalidExpressionException("Arithmetic operation " + operator
                    // + " cannot be applied to types " + LhsType + " and " + RhsType);
                    // }
                    // }

                    String resultingType = typeSystem.lookupResultingTypeNew(LhsType, RhsType, operator);
                    SimplifiedExpressionTypeQueue.add(resultingType);
                }
            }
            res = SimplifiedExpressionTypeQueue.remove();
        } catch (InvalidExpressionException | IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            res = "INVALID_TYPE";
        }

        return res;
    }

}
