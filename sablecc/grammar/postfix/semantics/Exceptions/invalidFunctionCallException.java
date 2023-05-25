
package postfix.semantics.Exceptions;

import postfix.node.Node;

/**
 * invalidFunctionCallException
 */
public class invalidFunctionCallException extends RuntimeException {

    private Node node;

    public invalidFunctionCallException(String message) {
        super();
    }

    public invalidFunctionCallException(String message, Node node) {
        this(message + "\n" + node);
        this.node = node;
    }

}