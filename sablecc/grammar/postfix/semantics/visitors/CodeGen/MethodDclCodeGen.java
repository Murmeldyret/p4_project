package postfix.semantics.visitors.CodeGen;

import java.util.List;

import postfix.node.AFunctionDeclarationDcl;
import postfix.semantics.SymbolTable;

public class MethodDclCodeGen extends CommonCodeGen {
    // Variables

    private List<String> methodArray;

    // Constructor
    public MethodDclCodeGen() {}

    public MethodDclCodeGen(SymbolTable symbolTable, String program) {
        super(symbolTable, program);
    }

    @Override
    public void inAFunctionDeclarationDcl(AFunctionDeclarationDcl node) {
        
    }
}
