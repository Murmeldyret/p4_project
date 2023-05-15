package testng.src;

import org.testng.annotations.*;
import org.testng.Assert;

import postfix.node.TId;
import postfix.node.TType;
import postfix.semantics.*;
import postfix.semantics.IdAttributes.Attributes;
import postfix.semantics.SymbolTable.Scopekind;

public class SymbolTableTest {
    //Setup
    SymbolTable TestSymbolTable = new SymbolTable(null, Scopekind.block);
    
    public void eraseTable(){
        TestSymbolTable = new SymbolTable(null, Scopekind.block);
    }
    public void input(String key, String sameKey, String type, String value, Attributes options){
        TestSymbolTable.put(key, new IdAttributes(new TId(sameKey),new TType(type) , value, options));
    }

    /*        
        input("b", "b","int", "2", Attributes.variable);
        eraseTable(); 
    */

    //Actual Tests
    @Test //Nedpriotiter
    public void testGetFunctionMap(){
        eraseTable();
        input("func", "func", "int", null , Attributes.function);
        input("func1", "func1", "string", null , Attributes.function);
        input("func2", "func2", "boolean", null , Attributes.function);
        input("func3", "func3", "float", null , Attributes.function);
        
        TestSymbolTable.CreateNewScope("func", Scopekind.functionBlock, "String");
        TestSymbolTable.CreateNewScope("func1", Scopekind.functionBlock, "String");
        TestSymbolTable.CreateNewScope("func2", Scopekind.functionBlock, "String");
        TestSymbolTable.CreateNewScope("func3", Scopekind.functionBlock, "String");
        
        Assert.assertEquals(TestSymbolTable.getFunctionMap().size(), 4);
    }

    @Test
    public void testGetToOuterSymbolTable(){
        eraseTable();
       
        input("a", "a", "int", "10", Attributes.variable);
        input("b", "b", "int", "11", Attributes.variable);
        
        SymbolTable Test1LocalSymbolTable = new SymbolTable(TestSymbolTable, Scopekind.block);
        //Test1LocalSymbolTable.put("c", new IdAttributes(new TId("c"),new TType("float") , "10.5", Attributes.variable));
        
        SymbolTable Test2LocalSymbolTable = new SymbolTable(Test1LocalSymbolTable, Scopekind.block);
        //Test2LocalSymbolTable.put("d", new IdAttributes(new TId("d"),new TType("string") , "testlocal", Attributes.variable));
        
        Assert.assertEquals(Test1LocalSymbolTable, Test2LocalSymbolTable.getOuterSymbolTable());
        
        eraseTable();
    }

    @Test
    public void testDeclaredLocally(){
        eraseTable();
        SymbolTable TestLocalSymbolTable = new SymbolTable(TestSymbolTable, Scopekind.block);
        input("a", "a", "int", "10", Attributes.variable);
        TestLocalSymbolTable.put("b", new IdAttributes(new TId("b"),new TType("float") , "10.5", Attributes.variable));
        Assert.assertTrue(TestLocalSymbolTable.DeclaredLocally("b"));
    }

    @Test
    public void testNotDeclaredLocally(){
        eraseTable();
        SymbolTable TestLocalSymbolTable = new SymbolTable(TestSymbolTable, Scopekind.block);
        input("a", "a", "int", "10", Attributes.variable);
        TestLocalSymbolTable.put("b", new IdAttributes(new TId("b"),new TType("float") , "10.5", Attributes.variable));
        Assert.assertTrue(!TestLocalSymbolTable.DeclaredLocally("a"));
    }


    @Test
    public void testIsDeclared(){
        eraseTable();
        SymbolTable TestLocalSymbolTable = new SymbolTable(TestSymbolTable, Scopekind.block);
        input("a", "a", "int", "10", Attributes.variable);
        TestLocalSymbolTable.put("b", new IdAttributes(new TId("b"),new TType("float") , "10.5", Attributes.variable));
        Assert.assertTrue(TestLocalSymbolTable.isDeclared("a"));
    }

    @Test //Nedprioriter
    public void testGetReturnType(){
        eraseTable();
        
        input("func", "func", "int", null , Attributes.function);
        TestSymbolTable.addFunctionParameter("func", "int", "Calc");
        TestSymbolTable.CreateNewScope("func", Scopekind.functionBlock, "int");
        
        Assert.assertEquals(TestSymbolTable.getFunctionSymbolTable("func").getReturnType(), "int");
    }

    @Test
    public void testRetrieveSymbol(){
        eraseTable();
        input("b", "b","int", "2", Attributes.variable);
        IdAttributes confirmed = TestSymbolTable.RetrieveSymbol("b");
        IdAttributes expected = new IdAttributes(new TId("b"),new TType("int") , "2", Attributes.variable);
        Assert.assertEquals(confirmed,expected);
    }

    @Test //Arbejder kun i current scope, lav test som fejler i et andet scope
    public void testSize(){
        eraseTable();
        input("a", "a", "int", "10", Attributes.variable);
        input("c", "c", "string", "John Doe", Attributes.variable);
        input("d", "d", "int", "69", Attributes.variable);
        int size = TestSymbolTable.size();
        Assert.assertEquals(size, 3, null);
    }

    @Test
    public void testIsEmpty(){
        eraseTable();
        Assert.assertTrue(TestSymbolTable.isEmpty());
    }

    @Test
    public void testContainsKey(){
        eraseTable();
        input("a", "a", "int", "10", Attributes.variable);
        Boolean keyExists = TestSymbolTable.containsKey("a");
        Assert.assertTrue(keyExists);
    }

    @Test
    public void testContainsValue(){
        eraseTable();
        input("a", "a", "int", "10", Attributes.variable);
        Boolean valueExists = TestSymbolTable.containsValue(new IdAttributes(new TId("a"),new TType("int"),"10",Attributes.variable));
        
        Assert.assertTrue(valueExists);
    }

    @Test
    public void testGet(){
        eraseTable();
        IdAttributes testAttributes = new IdAttributes(new TId("b"), new TType("string"), null, Attributes.variable);
        TestSymbolTable.put("b", testAttributes);
        IdAttributes CopyTestAttributes = TestSymbolTable.get("b");
        
        Assert.assertTrue(CopyTestAttributes.equals(testAttributes));
    }

    @Test
    public void testPut(){
        eraseTable();
        input("a", "a", "int", "10", Attributes.variable);
        TestSymbolTable.put("b", new IdAttributes(new TId("b"),new TType("int") , "5", Attributes.variable));
        
        Assert.assertEquals(TestSymbolTable.size(), 2);
    }

    @Test
    public void testPutKeyCollision(){
        eraseTable();
        input("a", "a", "int", "10", Attributes.variable);
        input("a", "a", "int", "10", Attributes.variable);
        
        Assert.assertEquals(TestSymbolTable.size(), 1);
    }

    @Test ( expectedExceptions = {NullPointerException.class})
    public void testPutNullPointer(){
        eraseTable();
        input(null, null, "int", "10", Attributes.variable);
    }

    @Test
    public void testRemove(){
        eraseTable();
        input("a", "a", "int", "10", Attributes.variable);
        input("d", "d", "int", "15", Attributes.variable);
        TestSymbolTable.remove("d");
        
        Assert.assertEquals(TestSymbolTable.size(), 1);
    }

    @Test ( expectedExceptions = {IllegalArgumentException.class})
    public void testNullRemove(){
        eraseTable();
        input("bait", "bait", "int", "15" , Attributes.variable);
        SymbolTable TestLocalSymbolTable = new SymbolTable(TestSymbolTable, Scopekind.functionBlock);
        TestLocalSymbolTable.put("func", new IdAttributes(new TId("func"),new TType("float") , null, Attributes.function));
        TestLocalSymbolTable.addFunctionParameter("func", "int", "Calc");
        TestLocalSymbolTable.remove("bait");
    }

    @Test
    public void testCreateNewScope(){
        eraseTable();
        input("func", "func", "int", null , Attributes.function);
        TestSymbolTable.addFunctionParameter("func", "int", "Calc");
        TestSymbolTable.CreateNewScope("func", Scopekind.functionBlock, "string");
        
        Assert.assertTrue(TestSymbolTable.DeclaredLocally("func"));
    }

    @Test( expectedExceptions = {IllegalArgumentException.class})
    public void testDontCreateNewScope(){
        eraseTable();
        input("func", "func", "int", "100" , Attributes.variable);
        TestSymbolTable.addFunctionParameter("func", "int", "Sinus");
        TestSymbolTable.CreateNewScope("func", Scopekind.functionBlock, "string");
    }

    @Test
    public void testGetFunctionSymbolTable(){
        input("func", "func", "string", null , Attributes.function);
        TestSymbolTable.addFunctionParameter("func", "int", "Sinus");
        TestSymbolTable.CreateNewScope("func", Scopekind.functionBlock, "string");
        
        SymbolTable TestLocalSymbolTable = new SymbolTable(TestSymbolTable, Scopekind.functionBlock);
        TestLocalSymbolTable.put("func1", new IdAttributes(new TId("func1"),new TType("float"), null, Attributes.function));
        TestLocalSymbolTable.addFunctionParameter("func1", "int", "sinus");
        TestLocalSymbolTable.CreateNewScope("func1", Scopekind.functionBlock, "float");
        TestLocalSymbolTable.put("func2", new IdAttributes(new TId("func2"),new TType("float"), null, Attributes.function));

        Assert.assertTrue(TestLocalSymbolTable.getFunctionSymbolTable("func1").containsKey("sinus"));
    }
}