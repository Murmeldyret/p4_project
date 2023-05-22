package postfix.semantics.Exceptions;

import postfix.node.ABreakStatementStmt;

public class InvalidBreakStatement extends TypeException{

    private ABreakStatementStmt node;
    
    public InvalidBreakStatement(String message) {
        super(message);
        //TODO Auto-generated constructor stub
    }
    public InvalidBreakStatement(String message, ABreakStatementStmt node) {
        super(message);
    }

    
}
