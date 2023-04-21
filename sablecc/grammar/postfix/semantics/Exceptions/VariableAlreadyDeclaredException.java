package postfix.semantics.Exceptions;

public class VariableAlreadyDeclaredException extends RuntimeException {
 
    public VariableAlreadyDeclaredException(String mesString) {
        super(mesString);
    }
}
