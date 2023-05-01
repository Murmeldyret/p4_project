package postfix.semantics;

import java.util.Collection;
import java.util.HashMap;
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
            res = res && outerSymbolTable.isEmpty();
        }

        return res;
    }

    @Override
    public boolean containsKey(Object key) {
        if (key == null) {
            throw new NullPointerException("Key cannot be null");
        }

        // Check if the key exists in the current scope (hashMap)
        return hashMap.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        if (value == null) {
            throw new NullPointerException("Value cannot be null");
        }

        // Check if the value exists in the current scope (hashMap)
        boolean res = hashMap.containsValue(value);

        // If there is an outer scope and the value is not in the current scope,
        // check if the value exists in the outer scope
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

        // Check if the key exists in the current scope (hashMap) and return its value
        IdAttributes value = hashMap.get(key);
        if (value != null) {
            return value;
        }

        // If there is an outer scope, recursively search for the key in the outer scope
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

        // Add the key-value pair to the current scope (hashMap)
        return hashMap.put(key, value);
    }

    @Override
    public IdAttributes remove(Object key) {
        // TODO Auto-generated method stub

        IdAttributes res = null;

        // Check if both hashMap and outerSymbolTable are null, and if so, throw a
        // NullPointerException
        if (hashMap == null && outerSymbolTable == null) {
            throw new NullPointerException("Symbol table does not exists");
        }

        // Check if the key is declared locally (in the current scope)
        if (this.DeclaredLocally((IdAttributes) key)) {
            res = hashMap.remove(key);
        }

        // If the key is not found locally, check if the outerSymbolTable is not null
        // and if the key is present in the outer scope
        else if (outerSymbolTable != null && outerSymbolTable.containsKey(key)) {
            if (kind != Scopekind.functionBlock) {
                res = outerSymbolTable.remove(key);
            } else
                throw new IllegalArgumentException("Function block scope cannot remove identifers outside local scope");
        }

        // Return the removed IdAttributes (if any), otherwise null
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

}
