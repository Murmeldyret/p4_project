package postfix.semantics;

import java.util.ArrayList;
import java.util.List;

import postfix.node.TId;
import postfix.node.TType;
import postfix.semantics.Exceptions.invalidFunctionCallException;

/**
 * Represents all necessary attributes, about an identifier, that a symbol table
 * monitors
 */
public class IdAttributes implements Cloneable {

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
    @Override
    protected Object clone() throws CloneNotSupportedException {
        IdAttributes clone = new IdAttributes(id,type,value,attributes);
        clone.setReturnType(getReturnType());
        //TODO giv fuld klon
        return super.clone();
    }

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
        this.parameterNames = new ArrayList<>();
        this.parameterTypes = new ArrayList<>();
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
    /**
     * Returns the list of parameter types in the order that they are declared
     * @return
     */
    public QueueList<String> getParameterTypeListAsQueueList() {
        return new QueueList<>(parameterTypes);
    }

}
