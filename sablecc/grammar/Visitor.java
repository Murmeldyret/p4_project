import postfix.analysis.DepthFirstAdapter;
import postfix.lexer.*;
import postfix.parser.*;
import postfix.node.*;

import java.io.*;

public class Visitor extends DepthFirstAdapter {

    int indent = 4;

    @Override
    public void inAValIntnumVal(AValIntnumVal node) {
        System.out.println(node.toString());
    }
}