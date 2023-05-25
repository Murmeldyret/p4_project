package postfix.semantics.Exceptions;

import postfix.node.PDcl;

public class InvalidDeclarationException extends TypeException {

    private PDcl node;
    public InvalidDeclarationException(String message) {
        super(message);
    }
    public InvalidDeclarationException(String message, PDcl node) {
        super(message + "\n" + node);
        this.node = node;
    }
}
