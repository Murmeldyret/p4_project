package postfix.semantics;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class SymbolTable implements Map<String, IdAttributes> {

    public SymbolTable() {

    }

    /**
     * Constructs a symbol table with a reference to an outer symbol table
     * @param outerSymbolTable The outer symbol table
     */
    public SymbolTable(SymbolTable outerSymbolTable) {
        this.outerSymbolTable = outerSymbolTable;
    }

    private SymbolTable outerSymbolTable;

    private SymbolTable outerScope() {
        throw new UnsupportedOperationException("Unimplemented method 'outerScope'");
    }

    /**
     * Tests whether an identifier exists within this symbol table or an outer one
     * @param idName the identifier to test
     * @return true if identifier exists within the current block, false otherwise
     */
    public boolean DeclaredLocally(String idName) {
        throw new UnsupportedOperationException("Unimplemented method 'DeclaredLocally'");

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