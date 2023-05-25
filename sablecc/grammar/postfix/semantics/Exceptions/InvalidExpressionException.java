package postfix.semantics.Exceptions;

import postfix.node.AExprValPrimeExpr;

/**
 * An Exception that occurs when an expression does not produce a valid value
 */
public class InvalidExpressionException extends TypeException {

    private AExprValPrimeExpr node;
    // TODO: Auto-generated constructor stub
    public InvalidExpressionException(String message) {
        super(message);
    }

    public InvalidExpressionException(String message, AExprValPrimeExpr node) {
        super(message + "\n" + node);
        this.node = node;
    }

    public AExprValPrimeExpr getNode() {
        return node;
    }
}
