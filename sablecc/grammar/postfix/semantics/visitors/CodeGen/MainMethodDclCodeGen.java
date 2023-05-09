package postfix.semantics.visitors.CodeGen;

import java.lang.reflect.Method;
import java.util.List;

import postfix.analysis.DepthFirstAdapter;
import postfix.node.AFunctionDeclarationDcl;
import postfix.node.Start;
import postfix.semantics.SymbolTable;

public class MainMethodDclCodeGen extends CommonCodeGen {
    // Variables
    private String mainMethod = "public static void main(String[] args) {";

    private List<String> methodArray;

    SymbolTable symbolTable;

    String program;

    @Override
    public void outStart(Start node) {
        mainMethod += "}";

        functionConcatanation();
    }

    // Concatinate all functions
    private void functionConcatanation() {
        program += mainMethod;

        for (String function : methodArray) {
            program += function;
        }
    }
}
