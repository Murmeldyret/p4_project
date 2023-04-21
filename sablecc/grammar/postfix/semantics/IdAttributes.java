package postfix.semantics;

import java.util.function.Function;

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

    private Attributes attributes;

    /** Represents information about what modifiers the identifer has */
    public enum Attributes {
        /** An identifier whose value cannot be changed */
        constant,
        /** An identifier, that is a function */
        function,
        // TODO csv skal måske ikke være her
        /** A special csv type */
        csv,

    }
    // TODO variabel der indeholder værdi

    @Deprecated
    public IdAttributes(TId id, TType type, boolean isFunction, boolean isConst) {
    }

    @Deprecated
    public IdAttributes(TId id, TType type, String value, boolean isFunction, boolean isConst) {
    }

    public IdAttributes(TId id, TType type, String value, Attributes attributes) {
        this.id = id;
        this.type = type;
        this.value = value;
        this.attributes = attributes;
    }

    public Attributes getAttributes() {
        return attributes;
    }

    public TId getId() {
        return id;
    }

    public TType getType() {
        return type;
    }

    public String getValue() {
        return value;
    }

    public boolean isFunction() {
        return isFunction;
    }

    public boolean isConst() {
        return isConst;
    }

}
