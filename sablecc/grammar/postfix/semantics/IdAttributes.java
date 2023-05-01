package postfix.semantics;

import java.util.List;

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
    private List<String> parameterTypes;
    private List<String> parameterNames;
    private String returnType;

    private Attributes attributes;

    /** Represents information about what modifiers the identifer has */
    public enum Attributes {
        variable,
        /** An identifier whose value cannot be changed */
        constant,
        /** An identifier, that is a function */
        function,
        /** An identifier, that is an array */
        array,
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

    public List<String> getParameterTypes() {
        return parameterTypes;
    }

    public List<String> getParameterNames() {
        return parameterNames;
    }

    public void addParameter(String type, String name) {
        parameterTypes.add(type);
        parameterNames.add(name);
    }

    public String getReturnType() {
        return returnType;
    }

    public void setReturnType(String type) {
        returnType = type;
    }

}
