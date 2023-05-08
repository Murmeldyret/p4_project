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
        SymbolTable symbolTable;
        System.out.println("Running parser...");
        try {

            // Create a Parser instance.
            Parser p = new Parser(
                    new Lexer(
                            new PushbackReader(
                                    new FileReader(arguments[0]), 1024)));

            // Parse the input.
            Start tree = p.parse();

            tree.apply(new SemanticVisitor());
            tree.apply(new CodeGen());
            // Apply the translation.
            // tree.apply(new Translation());
        } catch (ParserException e) {
            System.out.println(e.getMessage() + " Parser error");
        } catch (InvalidExpressionException e) {
            // System.out.println(e.getMessage() + " InvalidExpressionException");
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            System.out.println("Input file not found");
        } catch (LexerException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
