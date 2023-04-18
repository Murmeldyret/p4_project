package postfix.semantics.visitors;

import postfix.analysis.DepthFirstAdapter;
import postfix.semantics.SymbolTable;

public class SemanticVisitor extends DepthFirstAdapter {

    // TODO Kapitel 8.8 i fischer bogen
    @Deprecated
    public SemanticVisitor() {

    }

    public SemanticVisitor(SymbolTable symbolTable) {
        this.symbolTable = symbolTable;

    }

    protected SymbolTable symbolTable;

}
