package postfix.semantics;

import postfix.node.TId;
import postfix.node.TType;

/**
 * Represents all necessary attributes, about an identifier, that a symbol table
 * monitors
 */
public class IdAttributes {

    private TId id;
    private TType type;
    private String value;
    private boolean isFunction;
    private boolean isConst;
    // TODO variabel der indeholder værdi

    @Deprecated
    public IdAttributes(TId id, TType type, boolean isFunction, boolean isConst) {
    }

    public IdAttributes(TId id, TType type, String value, boolean isFunction, boolean isConst) {
    
    }


}
