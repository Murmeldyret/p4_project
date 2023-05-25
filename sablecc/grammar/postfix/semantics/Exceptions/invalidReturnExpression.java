package postfix.semantics.Exceptions;

import postfix.node.AReturnStmt;

public class invalidReturnExpression extends InvalidExpressionException {
    private AReturnStmt returnStmt;

    public invalidReturnExpression(String message) {
        super(message);
    }
    public invalidReturnExpression(String message, AReturnStmt node) {
        this(message + "\n" + node);
        returnStmt = node;
    }

}
