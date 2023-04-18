package postfix.semantics.visitors;

import postfix.semantics.SymbolTable;

public class TypeVisitor extends TopDclVisitor {

    public TypeVisitor() {
    }

    public TypeVisitor(SymbolTable symbolTable) {
        super(symbolTable);
    }
}
