package postfix.semantics.visitors;

import postfix.analysis.DepthFirstAdapter;
import postfix.node.Start;
import postfix.semantics.QueueList;
import postfix.semantics.SymbolTable;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import javax.tools.*;

public class CodeGen extends DepthFirstAdapter {

    // Variable declarations
    protected SymbolTable symbolTable;
    protected QueueList<String> functionParameterTypeList;

    private String program;

    // Constructors
    public CodeGen() {
        this.symbolTable = new SymbolTable(null, SymbolTable.Scopekind.block);
    }

    public CodeGen(SymbolTable symbolTable) {
        this.symbolTable = symbolTable;
    }

    // This method should initiate some sort of start code for the jvm. Constructing
    // a main class and so on.
    @Override
    public void inStart(Start node) {
        program = "public class Main {\n    public static void main(String[] args) {\n        System.out.println(\"Hello\");\n    }\n}";
    }

    @Override
    public void outStart(Start node) {
        File root;

        try {
            root = Files.createTempDirectory("java").toFile();
            // ! Please fix later
            File sourceFile = new File(root, "test/Main.java");
            sourceFile.getParentFile().mkdirs();
            Files.write(sourceFile.toPath(), program.getBytes(StandardCharsets.UTF_8));

            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            compiler.run(null, null, null, sourceFile.getPath());

            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
