package postfix.semantics;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SymbolTable implements Map<String, IdAttributes> {

    public SymbolTable() {

    }

    /**
     * Constructs a symbol table with a reference to an outer symbol table
     * 
     * @param outerSymbolTable The outer symbol table
     * @param kind             Determines what this symbol can access
     */
    public SymbolTable(SymbolTable outerSymbolTable, Scopekind kind) {

        this.outerSymbolTable = outerSymbolTable;
        this.kind = kind;
        hashMap = new HashMap<String, IdAttributes>();
    }

    /**
     * Represents the scope type that this symbol table manages
     */
    public enum Scopekind {
        /** A normal block */
        block,
        /** Like a normal block, just for if statements */
        ifBlock,
        /** Like a normal block, just for loops */
        loopBlock,
        /** A block where all outer variables are read only */
        functionBlock,
    }

    private Scopekind kind;
    // holds the actual symbols
    private HashMap<String, IdAttributes> hashMap;

    /** Represents the outer scope, is null if no such scope exists */
    private SymbolTable outerSymbolTable;

    private SymbolTable outerScope() {
        return outerSymbolTable;
    }

    private boolean DeclaredExternally(IdAttributes id) {
        boolean res = false;

        if (outerSymbolTable != null) {

        }

        return res;
    }

    private boolean DeclaredLocally(IdAttributes id) {
        return DeclaredLocally(id.getId().getText());
    }

    /**
     * Tests whether an identifier exists within this symbol table or an outer one
     * 
     * @param idName the identifier to test
     * @return true if identifier exists within the current block, false otherwise
     */
    public boolean DeclaredLocally(String idName) {
        // TODO først implementer når scoperegler er aftalt
        throw new UnsupportedOperationException("Unimplemented method 'DeclaredLocally'");

    }

    /**
     * Retrieves the current declaratation with this name
     * 
     * @param idName the name of the declaration to retrieve
     * @return the current declaration if it exists, null otherwise
     */
    public IdAttributes RetrieveSymbol(String idName) {
        return get(idName);
    }

    @Override
    public int size() {
        return hashMap.size();
    }

    @Override
    public boolean isEmpty() {
        boolean res = hashMap.isEmpty();
        if (outerSymbolTable != null) {
            res = res || outerSymbolTable.isEmpty();
        }
        return res;
    }

    @Override
    public boolean containsKey(Object key) {
        if (key == null) {
            throw new NullPointerException("Key cannot be null");
        }
        return hashMap.containsKey(key);

    }

    @Override
    public boolean containsValue(Object value) {
        if (value == null) {
            throw new NullPointerException("Value cannot be null");
        }
        boolean res = false;

        res = hashMap.containsValue(value);

        if (outerSymbolTable != null && !res) {
            res = outerSymbolTable.containsValue(value);
        }
        return res;

    }

    @Override
    public IdAttributes get(Object key) {
        if (key == null) {
            throw new NullPointerException("Key cannot be null");
        }
        if (hashMap.containsKey(key)) {
            return hashMap.get(key);
        }
        if (outerSymbolTable != null) {
            return outerSymbolTable.get(key);
        }
        throw new IllegalArgumentException("Key does not exist in symbol table");
    }

    @Override
    public IdAttributes put(String key, IdAttributes value) {
        if (key == null) {
            throw new NullPointerException("Key cannot be null");
        }
        return hashMap.put(key, value);
    }

    @Override
    public IdAttributes remove(Object key) {
        // TODO Auto-generated method stub
        // findes hashmap, hvis nej så fejl
        // findes værdi ude for lokal scope og er i funktionsscope, så smid fejl
        // findes værdi, hvis nej så return null

        IdAttributes res = null;

        if (hashMap == null && outerSymbolTable == null) {
            throw new NullPointerException("Symbol table does not exists");
        }
        if (this.DeclaredLocally((IdAttributes) key)) {
            res = hashMap.remove(key);
        }
        // findes, men i outer scope
        else if (containsValue(key)) {
            if (kind != Scopekind.functionBlock) {
                res = outerSymbolTable.remove(key);
            } else
                throw new IllegalArgumentException("Function block scope cannot remove identifers outside local scope");
        }
        return res;
    }

    @Override
    public void putAll(Map<? extends String, ? extends IdAttributes> m) {
        // TODO Auto-generated method stub
        // put loop

        for (String keyString : m.keySet()) {
            put(keyString, m.get(keyString));
        }
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'clear'");
    }

    @Override
    public Set<String> keySet() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keySet'");
    }

    @Deprecated
    @Override
    public Collection<IdAttributes> values() {
        Collection<IdAttributes> attributes = hashMap.values();
        if (outerSymbolTable != null) {
            // TODO outer scope kan have identiske keys hvilket skaber problemer, så denne
            // metode kan ikke virke
            attributes.addAll(outerSymbolTable.values());
        }

        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'values'");
    }

    @Override
    public Set<Entry<String, IdAttributes>> entrySet() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'entrySet'");
    }

    /**
     * Adds parameters to a function
     * 
     * @param functionName the name of the function to add parameters to
     * @param parameterTypes the types of the parameters to add
     * @param parameterNames the names of the parameters to add
     * @return the attributes of the function
     * @throws NullPointerException if the function does not exist
     * @throws IllegalArgumentException if the function already has parameters or the number of types and names are different
     */
    public IdAttributes addFunctionParameters(String functionName, List<String> parameterTypes, List<String> parameterNames) {
        IdAttributes attributes = get(functionName);
        if (attributes == null) {
            throw new NullPointerException("Function " + functionName + " does not exist");
        }
        if (!attributes.getParameterTypes().isEmpty() || !attributes.getParameterNames().isEmpty()) {
            throw new IllegalArgumentException("Function " + functionName + " already has parameters");
        }
        if (parameterTypes.size() != parameterNames.size()) {
            throw new IllegalArgumentException("Function " + functionName + " has different number of parameters");
        }
        for (int i = 0; i < parameterTypes.size(); i++) {
            attributes.addParameter(parameterTypes.get(i), parameterNames.get(i));
        }

        // return hashMap.put(functionName, attributes);
        // return attributes;
    }

    /**
     * Adds a return type to a function
     * 
     * @param functionName the name of the function to add a return type to
     * @param returnType the return type to add to the function
     * @return the attributes of the function
     * @throws NullPointerException if the function does not exist
     * @throws IllegalArgumentException if the function already has a return type
     */
    public IdAttributes addFunctionReturnType(String functionName, String returnType) {
        IdAttributes attributes = get(functionName);
        if (attributes == null) {
            throw new NullPointerException("Function " + functionName + " does not exist");
        }
        if (attributes.getReturnType() != null) {
            throw new IllegalArgumentException("Function " + functionName + " already has a return type");
        }
        attributes.setReturnType(returnType);
        
        // return hashMap.put(functionName, attributes);
        // return attributes;
    }


}
