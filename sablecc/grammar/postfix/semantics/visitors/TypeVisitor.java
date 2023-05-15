package postfix.semantics.visitors;

import postfix.node.AAndInfixBinInfixOp;
import postfix.node.ADivisionInfixBinInfixOp;
import postfix.node.AEqualityInfixBinInfixOp;
import postfix.node.AExprValPrimeExpr;
import postfix.node.AFunctionCallFunctionCall;
import postfix.node.AFunctionCallParamFunctionCallParam;
import postfix.node.AFunctionCallParamPrimeFunctionCallParamPrime;
import postfix.node.AGreaterThanEqualInfixBinInfixOp;
import postfix.node.AGreaterThanInfixBinInfixOp;
import postfix.node.ALessThanEqualInfixBinInfixOp;
import postfix.node.ALessThanInfixBinInfixOp;
import postfix.node.AMinusInfixBinInfixOp;
import postfix.node.AModuloInfixBinInfixOp;
import postfix.node.AMultiplicationInfixBinInfixOp;
import postfix.node.ANotEqualInfixBinInfixOp;
import postfix.node.AOrInfixBinInfixOp;
import postfix.node.APlusInfixBinInfixOp;
import postfix.node.AReturnStmt;
import postfix.node.AValBoolVal;
import postfix.node.AValFloatnumVal;
import postfix.node.AValIdVal;
import postfix.node.AValIntnumVal;
import postfix.node.AValStringVal;
import postfix.semantics.QueueList;
import postfix.semantics.SymbolTable;
import postfix.semantics.TypeSystem;
import postfix.semantics.Exceptions.InvalidExpressionException;
import postfix.semantics.Exceptions.invalidFunctionCallException;
import postfix.semantics.Exceptions.invalidReturnExpression;

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
        simplifiedTypeQueue = new QueueList<>();
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
    protected QueueList<String> simplifiedTypeQueue;
    /** The type that an expression or return statement must return */
    protected String expressionType;
    /** The type that an expression actually produces */
    protected String actualExpressionType;

    @Override
    public void inAReturnStmt(AReturnStmt node) {
        // TODO Auto-generated method stub
        super.inAReturnStmt(node);
    }

    @Override
    public void outAReturnStmt(AReturnStmt node) {
        if (!(expressionType.equals(actualExpressionType))) {
            throw new invalidReturnExpression("Cannot return a value of type " + actualExpressionType
                    + " on a function that has a return type of " + expressionType + " (Line: "
                    + node.getKwReturn().getLine() + ")");
        }
        // TODO skal lige testes
        // String expr = typeCheckExpression();
        // if (!expr.equals(expressionType)) {
        // throw new invalidReturnExpression(
        // "Cannot return a value of type " + expr + " on a function whose return type
        // is " + expressionType);
        // }
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
        actualExpressionType = typeCheckExpression(node);

        // Validate the resulting type and throw an exception if it's invalid
        if ("INVALID_TYPE".equals(actualExpressionType)) {
            throw new InvalidExpressionException("Invalid expression type detected", node);
        }
        if (!expressionType.equals(actualExpressionType)) {
            throw new InvalidExpressionException("Expression produces a value of type " + actualExpressionType + ", must be of type " + expressionType, node);
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
        // FIXME funktionenens parametertypeliste er tom?
        functionParameterTypeList = symbolTable.get(node.getId().getText()).getParameterTypeListAsQueueList();
        // symbolTable =
        // symbolTable.getFunctionSymbolTable(symbolTable.get(node.getId().getText()).getId().getText());
    }

    @Override
    public void inAFunctionCallParamFunctionCallParam(AFunctionCallParamFunctionCallParam node) {
        // // TODO Auto-generated method stub
        // super.inAFunctionCallParamFunctionCallParam(node);
        // ! Vigtig, skal være her
        defaultIn(node);
    }

    @Override
    public void caseAFunctionCallParamFunctionCallParam(AFunctionCallParamFunctionCallParam node) {
        inAFunctionCallParamFunctionCallParam(node);
        // TODO typecheck funktionsparameter
        if (node.getExpr() != null) {
            if (functionParameterTypeList.isEmpty()) {
                // TODO bedre fejlbesked
                throw new invalidFunctionCallException("Dette er en fejl");
            }
            node.getExpr().apply(new TypeVisitor(symbolTable, functionParameterTypeList.remove()));
        }
        if (node.getFunctionCallParamPrime() != null) {
            node.getFunctionCallParamPrime().apply(this);
        }
        outAFunctionCallParamFunctionCallParam(node);
    }

    @Override
    public void inAFunctionCallParamPrimeFunctionCallParamPrime(AFunctionCallParamPrimeFunctionCallParamPrime node) {
        // // TODO Auto-generated method stub
        // super.inAFunctionCallParamPrimeFunctionCallParamPrime(node);
        // ! Vigtig, skal være her
        defaultIn(node);
    }

    @Override
    public void caseAFunctionCallParamPrimeFunctionCallParamPrime(AFunctionCallParamPrimeFunctionCallParamPrime node) {
        inAFunctionCallParamPrimeFunctionCallParamPrime(node);
        if (node.getSopComma() != null) {
            node.getSopComma().apply(this);
        }
        if (node.getExpr() != null) {
            if (functionParameterTypeList.isEmpty()) {
                throw new invalidFunctionCallException("TODO lav fejlbesked");
            }
            node.getExpr().apply(new TypeVisitor(symbolTable, functionParameterTypeList.remove()));
        }
        if (node.getFunctionCallParamPrime() != null) {
            node.getFunctionCallParamPrime().apply(this);
        }
        outAFunctionCallParamPrimeFunctionCallParamPrime(node);
    }

    // @Override
    // public void outAFunctionCallFunctionCall(AFunctionCallFunctionCall node) {
    // // symbolTable = symbolTable.getOuterSymbolTable();
    // }

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
     * simplifies the expression by taking the appropriate operator and operand(s)
     * from their respective queues (from left to right)
     * 
     * @return true if the expression was simplified, false if it could not be
     *         simplified any further
     */
    private boolean SimplifyExpression() {
        boolean res = false;

        TypeSystem typesystem = new TypeSystem();
        String operator;

        // if the operator queue is empty, there are no operators present in this
        // expression, or the expression has been simplified to the point that all
        // operators have been consumed
        if (!operatorQueue.isEmpty()) {
            operator = operatorQueue.remove();
            if (typesystem.isBinaryInfixOperator(operator)) {
                String LhsType = simplifiedTypeQueue.isEmpty() ? typeQueue.remove()
                        : simplifiedTypeQueue.remove();
                String RhsType = typeQueue.remove();

                simplifiedTypeQueue.add(typesystem.lookupResultingTypeNew(LhsType, RhsType, operator));
                res = true;
            }
        } else {
            switch (typeQueue.size()) {
                case 0:
                    res = false;
                    break;
                case 1:
                    if (!simplifiedTypeQueue.isEmpty()) {
                        // throw new InvalidExpressionException("Expression cannot produce a valid
                        // value");
                    }
                    simplifiedTypeQueue.add(typeQueue.remove());
                    res = false;
                    break;
                default:
                    // cannot have more than 1 operand without any operator
                    // throw new InvalidExpressionException("Expression cannot produce a valid
                    // value");
            }
        }
        return res;
    }

    /**
     * Tests if an expression produces a valid value
     * 
     * @return true if the expression produces a valid value under the current type
     *         system.
     * @throws invalidExpressionException if the given expression does not produce a
     *                                    valid value
     */
    private String typeCheckExpression(AExprValPrimeExpr node) {
        String res = "";
        // TypeSystem typeSystem = new TypeSystem();

        // QueueList<String> SimplifiedExpressionTypeQueue = new QueueList<>();

        try {
            boolean canSimplify = true;
            do {
                canSimplify = SimplifyExpression();
                // evt debug statements hvis man er interesseret i sådan noget
            } while (canSimplify);
            if (simplifiedTypeQueue.isEmpty()) {
                // throw new IllegalArgumentException();
                res = "INVALID_TYPE";
            } else {
                res = simplifiedTypeQueue.remove();
            }
            // while (!operatorQueue.isEmpty()) {
            // String operator = operatorQueue.remove();

            // Boolean isBinaryInFixOp = typeSystem.isBinaryInfixOperator(operator);

            // if (isBinaryInFixOp) {
            // String LhsType = SimplifiedExpressionTypeQueue.isEmpty() ? typeQueue.remove()
            // : SimplifiedExpressionTypeQueue.remove();
            // String RhsType = typeQueue.remove();

            // // if (typeSystem.isArithmeticOperator(operator)) {
            // // if (!typeSystem.isArithmeticType(LhsType) ||
            // // !typeSystem.isArithmeticType(RhsType)) {
            // // throw new InvalidExpressionException("Arithmetic operation " + operator
            // // + " cannot be applied to types " + LhsType + " and " + RhsType);
            // // }
            // // }

            // String resultingType = typeSystem.lookupResultingTypeNew(LhsType, RhsType,
            // operator);
            // SimplifiedExpressionTypeQueue.add(resultingType);
            // }
            // }
            // res = SimplifiedExpressionTypeQueue.remove();
        } catch (InvalidExpressionException e) {
            // System.out.println("Error: " + e.getMessage());
            // res = "INVALID_TYPE";
            // e.printStackTrace();
            throw new InvalidExpressionException("Expression does not produce a valid value", node);
        }

        return res;
    }

}
