package postfix.semantics.visitors.CodeGen;

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

    protected String program;

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
        // Everything is inside the Main class. We don't need classes in our program.
        program = "public class Main {";
    }

    @Override
    public void outStart(Start node) {
        program += "}\n";
        codeCompiling();
    }

    private void codeCompiling() {
        File root;
        File sourceFile

        try {
            root = Files.createTempDirectory("java").toFile();
            // ! Please fix later
            sourceFile = new File(root, "test/Main.java");
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
