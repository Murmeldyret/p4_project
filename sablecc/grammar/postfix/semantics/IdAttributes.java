package postfix.semantics;

import postfix.node.TId;
import postfix.node.TType;


/**
 * Represents all necessary attributes, about an identifier, that a symbol table monitors
 */
public class IdAttributes {
    
    
    
    private TId id;
    private TType type;
    private boolean isFunction;
    private boolean isConst;

    public IdAttributes(TId id, TType type, boolean isFunction, boolean isConst) {


        
    }


}
