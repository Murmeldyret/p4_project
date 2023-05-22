package testng.src;

import org.testng.annotations.*;
import org.testng.Assert;
import postfix.semantics.TypeSystem;
import postfix.semantics.Exceptions.InvalidExpressionException;

import java.util.Set;

public class TypeSystemTest {
    TypeSystem typeSystem = new TypeSystem();
    Set<String> operators = Set.of("+", "-", "*", "/", "%", "<", "<=", ">", ">=", "==", "!=", "and", "or");
    Set<String> unaryoperators = Set.of("!");

    @Test
    public void isBinOpTrue(){
        for (String string : operators) {
            Boolean confirmed = typeSystem.isBinaryInfixOperator(string);
        Assert.assertTrue(confirmed);
        }
    }
    
    @Test
    public void isBinOpFalse(){
        String fakeSymbol = "&";
        Boolean confirmed = typeSystem.isBinaryInfixOperator(fakeSymbol);
        Assert.assertFalse(confirmed);
        
    }

    @Test
    public void isUnOpTrue(){
        for (String string : unaryoperators) {
            Boolean confirmed = typeSystem.isUnaryOperator(string);
        Assert.assertTrue(confirmed);
        }
    }

    @Test
    public void isUnOpFalse(){
        String fakeUnary = ")";
        Boolean confirmed = typeSystem.isUnaryOperator(fakeUnary);
        Assert.assertFalse(confirmed);
    }

    @Test( expectedExceptions = {IllegalArgumentException.class})
    public void checkUnaryTypeFailArg(){
        String unaryBool = ")";
        typeSystem.lookupUnaryType("bool", unaryBool);
    }

//Test fejler pga. en node der fejler (! er ikke opdateret til not i TypeSystem.java)
    @Test( expectedExceptions = {InvalidExpressionException.class})
    public void checkUnaryTypeFailExpr(){
        String unaryBool = "not";
        typeSystem.lookupUnaryType("string", unaryBool);
    }

    @Test
    public void checkUnaryTypeSucc(){
        String unaryBool = "not";
        String confirmed = typeSystem.lookupUnaryType("bool", unaryBool);
        Assert.assertEquals("bool", confirmed);
    }

    @Test( expectedExceptions = {IllegalArgumentException.class})
    public void checkResTypeNewFailArg(){
        String LType = "int";
        String RType = "int";
        String operator = "&";
        typeSystem.lookupResultingTypeNew(LType, RType, operator);
    }

    @Test( expectedExceptions = {InvalidExpressionException.class})
    public void checkResTypeNewFailExpr(){
        String LType = "int";
        String RType = "string";
        String operator = "+";
        typeSystem.lookupResultingTypeNew(LType, RType, operator);
    }

    @Test
    public void checkResTypeNewSucc(){
        String LType = "int";
        String RType = "int";
        String operator = "+";
        String confirmed = typeSystem.lookupResultingTypeNew(LType, RType, operator);
        Assert.assertEquals("int", confirmed);
    }
}
