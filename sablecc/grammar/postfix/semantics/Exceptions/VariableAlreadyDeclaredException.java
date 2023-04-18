package postfix.semantics.Exceptions;

public class VariableAlreadyDeclaredException extends Exception {
 
    public VariableAlreadyDeclaredException(String mesString) {
        super(mesString);
    }
}
