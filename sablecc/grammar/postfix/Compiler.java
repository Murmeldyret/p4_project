package postfix;

import postfix.parser.*;
import postfix.semantics.Exceptions.InvalidExpressionException;
import postfix.semantics.Exceptions.VariableAlreadyDeclaredException;
import postfix.semantics.visitors.SemanticVisitor;
import postfix.lexer.*;
import postfix.node.*;
import java.io.*;

public class Compiler {
    public static void main(String[] arguments) {
        try {
            System.out.println("Code Something:");

            // Create a Parser instance.
            Parser p = new Parser(
                    new Lexer(
                            new PushbackReader(
                                    new FileReader(arguments[0]), 1024)));

            // Parse the input.
            Start tree = p.parse();

            //
            tree.apply(new SemanticVisitor());
            // Apply the translation.
            // tree.apply(new Translation());
        } catch (ParserException e) {
            System.out.println(e.getMessage() + " Vores error");
            System.out.println(e.getMessage());
        } catch (InvalidExpressionException e) {
            System.out.println(e.getMessage() + "InvalidExpressionException");
        } catch (VariableAlreadyDeclaredException e) {
            System.out.println(e.getMessage() + "VariableAlreadyDeclaredException");
        } catch (Exception e) {

        }


    }
}
