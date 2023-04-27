package postfix.semantics.Exceptions;

public class TypeError extends RuntimeException {
    
    public TypeError(String mesString) {
        super(mesString);
    }
}
