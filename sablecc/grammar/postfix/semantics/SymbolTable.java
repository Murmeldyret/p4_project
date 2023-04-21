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
     * @param kind Determines what this symbol can access
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
        /**A normal block*/block,
        /**Like a normal block, just for if statements*/ifBlock,
        /**Like a normal block, just for loops*/loopBlock,
        /**A block where all outer variables are read only*/functionBlock,
    }

    private Scopekind kind;
    // holds the actual symbols
    private HashMap<String, IdAttributes> hashMap;

    private SymbolTable outerSymbolTable;

    private SymbolTable outerScope() {
        return outerSymbolTable;
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
        throw new UnsupportedOperationException("Unimplemented method 'RetrieveSymbol'");
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'size'");
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isEmpty'");
    }

    @Override
    public boolean containsKey(Object key) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'containsKey'");
    }

    @Override
    public boolean containsValue(Object value) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'containsValue'");
    }

    @Override
    public IdAttributes get(Object key) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public IdAttributes put(String key, IdAttributes value) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'put'");
    }

    @Override
    public IdAttributes remove(Object key) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public void putAll(Map<? extends String, ? extends IdAttributes> m) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'putAll'");
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

    @Override
    public Collection<IdAttributes> values() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'values'");
    }

    @Override
    public Set<Entry<String, IdAttributes>> entrySet() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'entrySet'");
    }

}
