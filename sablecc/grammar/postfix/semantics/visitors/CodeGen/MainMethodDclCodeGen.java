package postfix.semantics.visitors.CodeGen;

import java.lang.reflect.Method;
import java.util.List;

import postfix.analysis.DepthFirstAdapter;
import postfix.node.AFunctionDeclarationDcl;
import postfix.node.AProgramProgram;
import postfix.node.AStmts;
import postfix.node.Start;
import postfix.semantics.SymbolTable;

public class MainMethodDclCodeGen extends CommonCodeGen {
    // Variables
    private static String mainMethod = "public static void main(String[] args) {";

    String program;

    private List<String> methodArray;

    public MainMethodDclCodeGen(SymbolTable symbolTable, String program) {
        super(symbolTable, mainMethod);
        this.program = program;
    }

    @Override
    public void outAProgramProgram(AProgramProgram node) {
        mainMethod = super.program;
        mainMethod += "}";

        functionConcatanation();
    }

    // Concatinate all functions
    private void functionConcatanation() {

        program += mainMethod;

        if (methodArray != null) {
            for (String function : methodArray) {
                program += function;
            }
        }
    }
}
