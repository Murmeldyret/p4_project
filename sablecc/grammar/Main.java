import postfix.lexer.*;
import postfix.parser.*;
import postfix.node.*;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            Reader reader = new FileReader("input.txt");
            Lexer lexer = new Lexer(new PushbackReader(reader));
            Parser parser = new Parser(lexer);
            Start startNode = parser.parse();

            PrettyPrinter visitor = new PrettyPrinter();
            startNode.apply(visitor);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.err.println("Working Directory = " + System.getProperty("user.dir"));
        }
    }
}