package postfix.semantics.visitors.CodeGen;

import postfix.analysis.DepthFirstAdapter;
import postfix.node.AProgramProgram;
import postfix.node.AStatementsStmts;
import postfix.node.AStmts;
import postfix.node.Start;
import postfix.semantics.QueueList;
import postfix.semantics.SymbolTable;
import postfix.semantics.visitors.CodeGen.*;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import javax.tools.*;


import org.apache.tools.ant.Project;
import org.apache.tools.ant.ProjectHelper;
import org.apache.tools.ant.util.FileUtils;


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
        program = "package src;\nimport java.util.*;\nimport src.compilerdeps.Csvruntime;\nimport src.compilerdeps.ObjectConverter;";
        // Everything is inside the Main class. We don't need classes in our program.
        program += "public class Main {";
    }

    @Override
    public void inAProgramProgram(AProgramProgram node) {
        MainMethodDclCodeGen mainVisitor = new MainMethodDclCodeGen(symbolTable, program);
        node.apply(mainVisitor);
        program = mainVisitor.program;
    }

    @Override
    public void outStart(Start node) {
        program += "}\n";
        codeCompiling();
    }

    private void codeCompiling() {
        System.out.println(program);

        File slib = new File("compilerdeps/lib.jar");
        File dlib;
        File sbuildxml = new File("compilerdeps/build.xml");
        File dbuildxml;

        File root;
        File sourceFile;
        File compiledSource;
        File compiledDestination = new File("build/program.jar");

        try {
            root = Files.createTempDirectory("java").toFile();

            // Copy the code and it's dependencies.
            sourceFile = new File(root, "src/Main.java");
            sourceFile.getParentFile().mkdirs();
            Files.write(sourceFile.toPath(), program.getBytes(StandardCharsets.UTF_8));

            // Create a destination for the code.

            dlib = new File(root, "lib/lib.jar");
            dlib.getParentFile().mkdirs();
            dbuildxml = new File(root, "build.xml");
            dbuildxml.getParentFile().mkdirs();

            // Copy the files used for the java compiler to work.
            Files.copy(slib.toPath(), dlib.toPath(), StandardCopyOption.COPY_ATTRIBUTES);
            Files.copy(sbuildxml.toPath(), dbuildxml.toPath(), StandardCopyOption.COPY_ATTRIBUTES);

            // Setup the ANT project.
            Project p = new Project();
            p.setUserProperty("ant.file", dbuildxml.getAbsolutePath());
            p.init();
            ProjectHelper helper = ProjectHelper.getProjectHelper();
            p.addReference(("ant.projectHelper"), helper);

            helper.parse(p, dbuildxml);
            p.executeTarget(p.getDefaultTarget());

            // Copy the compiled program back to a build folder, for the user to use.

            compiledSource = new File(root, "build/jar/Main.jar");

            compiledDestination.getParentFile().mkdirs();

            Files.copy(compiledSource.toPath(), compiledDestination.toPath(), StandardCopyOption.REPLACE_EXISTING);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
