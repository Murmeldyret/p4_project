package testng.src;

import org.testng.Assert;
import org.testng.annotations.*;

import postfix.node.*;
import postfix.semantics.*;
import postfix.semantics.visitors.TypeVisitor;

public class TypeVisitorTest {
    
    AExprPrime not = new AExprPrime();
    AValIntnumVal two = new AValIntnumVal(new TIntnum("2"));
    APlusInfixBinInfixOp plus = new APlusInfixBinInfixOp(new TOpPlus());
    AExprPrimeOperatorValPrimeExprPrime ExprSnd = new AExprPrimeOperatorValPrimeExprPrime(plus, two, null);
    
    AExprValPrimeExpr ExprAdd = new AExprValPrimeExpr(null, new AValIntnumVal(new TIntnum("2")), ExprSnd);
    
    @Test
    public void typeCheckExpression(){
        try{
            ExprAdd.apply(new TypeVisitor(new SymbolTable(),"int"));
        } catch (Exception e) {
            Assert.fail("",e);
        }
    }    
}
