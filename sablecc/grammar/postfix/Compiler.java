package postfix;

import postfix.semantics.SymbolTable;
import postfix.semantics.Exceptions.InvalidExpressionException;
import postfix.parser.*;
import postfix.semantics.visitors.SemanticVisitor;
import postfix.semantics.visitors.CodeGen.CodeGen;
import postfix.lexer.*;
import postfix.node.*;
import java.io.*;

public class Compiler {

    public static void main(String[] arguments) {
        Compiler compiler = new Compiler();
        compiler.compile(arguments);
    }

    public void compile(String[] arguments) {
        try {
            // Create a Parser instance.
            Parser parser = new Parser(new Lexer(new PushbackReader(new FileReader(arguments[0]), 1024)));

            // Parse the input.
            Start tree = parser.parse();

            tree.apply(new SemanticVisitor());
            tree.apply(new CodeGen());
            // Apply the translation.
            // tree.apply(new Translation());
        } catch (ParserException | LexerException e) {
            handleException(e, "Parser error");
        } catch (InvalidExpressionException e) {
            handleException(e, "InvalidExpressionException");
        } catch (FileNotFoundException e) {
            handleException(e, "Input file not found");
        } catch (IOException e) {
            handleException(e, "IO error");
        }
    }

    private void handleException(Exception e, String message) {
        System.out.println(e.getMessage() + " " + message);
        e.printStackTrace();
    }
}
