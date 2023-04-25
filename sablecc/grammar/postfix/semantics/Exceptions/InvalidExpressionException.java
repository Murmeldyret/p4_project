package postfix.semantics.Exceptions;

import postfix.node.AExprValPrimeExpr;

/**
 * An Exception that occurs when an expression does not produce a valid value
 */
public class InvalidExpressionException extends TypeError{

    public InvalidExpressionException(String mesString) {
        super(mesString);
        //TODO Auto-generated constructor stub
    }
    public InvalidExpressionException(String mesString, AExprValPrimeExpr node) {
        super(mesString);
    }
    
}
