package testng.src;

import org.testng.annotations.*;
import org.testng.Assert;

import postfix.node.TId;
import postfix.node.TType;
import postfix.semantics.IdAttributes;
import postfix.semantics.SymbolTable;
import postfix.semantics.IdAttributes.Attributes;
import postfix.semantics.SymbolTable.Scopekind;

public class SymbolTableTest {
    //Setup
    SymbolTable TestSymbolTable = new SymbolTable(null, Scopekind.block);
    
    public void eraseTable(){
        SymbolTable TestSymbolTable = new SymbolTable(null, Scopekind.block);
    }
    public void input(String key, String sameKey, String type, String value, Attributes options){
        TestSymbolTable.put(key, new IdAttributes(new TId(sameKey),new TType(type) , value, options));
    }

    /*        
        input("b", "b","int", "2", Attributes.variable);
        eraseTable(); 
    */

    //Actual Tests
    //getKind og getHashMap???
    @Test //Nedpriotiter
    public void testGetFunctionMap(){
        TestSymbolTable.getFunctionMap();

    }

    @Test //Nedprioriter
    public void testGetOuterSymbolTable(){
        TestSymbolTable.getOuterSymbolTable();
    }

    @Test
    public void testDeclaredLocally(){
        TestSymbolTable.DeclaredLocally(null);
    }

    @Test
    public void testIsDeclared(){
        TestSymbolTable.isDeclared(null);
    }

    @Test //Nedprioriter
    public void testGetReturnType(){
        TestSymbolTable.getReturnType();
    }

    @Test //Anders get returnere ikke en value men noget der nærmere ligner en adresse
    public void testRetrieveSymbol(){
        /*input("b", "b","int", "2", Attributes.variable);
        IdAttributes confirmed = TestSymbolTable.RetrieveSymbol("b");
        IdAttributes expected = new IdAttributes(new TId("b"),new TType("int") , "2", Attributes.variable);
        System.out.println(confirmed);
        Assert.assertEquals(confirmed,expected);
        eraseTable(); */
    }

    @Test //Arbejder kun i current scope, lav test som fejler i et andet scope
    public void testSize(){
        input("a", "a", "int", "10", Attributes.variable);
        input("c", "c", "string", "John Doe", Attributes.variable);
        input("d", "d", "int", "69", Attributes.variable);
        int size = TestSymbolTable.size();
        Assert.assertEquals(size, 3, null);
        eraseTable();
    }

    @Test
    public void testIsEmpty(){
        Assert.assertTrue(TestSymbolTable.isEmpty());
    }

    @Test
    public void testContainsKey(){
        input("a", "a", "int", "10", Attributes.variable);
        Boolean keyExists = TestSymbolTable.containsKey("a");
        Assert.assertTrue(keyExists);
        eraseTable();
    }

    @Test //Anders har fucked op igen.
    public void testContainsValue(){
        input("a", "a", "int", "10", Attributes.variable);
        Boolean valueExists = TestSymbolTable.containsValue(new IdAttributes(new TId("a"),new TType("int"),"10",Attributes.variable));
        Assert.assertTrue(valueExists);
        eraseTable();
    }

    @Test //Anders, hvordan asserter man attributes.
    public void testGet(){
        input("c", "c", "string", "John Doe", Attributes.variable);
        IdAttributes copySymbolTable = TestSymbolTable.get("c");
        Assert.assertTrue(TestSymbolTable.equals(copySymbolTable));
        eraseTable();
    }

    @Test //Virker ikke fordi put skal bruge en værdi af IdAttributes
    public void testPut(){
        input("a", "a", "int", "10", Attributes.variable);
        TestSymbolTable.put("b", new IdAttributes(new TId("b"),new TType("int") , "5", Attributes.variable));
        Assert.assertEquals(TestSymbolTable.size(), 2);
        //Assert.assertEquals(TestSymbolTable.containsValue(TestSymbolTable), 12);
        eraseTable();
    }

    @Test //String går ikke til IdAttributes. Anders?
    public void testRemove(){
        input("a", "a", "int", "10", Attributes.variable);
        input("d", "d", "int", "15", Attributes.variable);
        TestSymbolTable.remove("d");
        Assert.assertEquals(TestSymbolTable.size(), 1);
        eraseTable();
    }

    @Test //Anders, der mangler en implementering på keySet()
    public void testPutAll(){
        SymbolTable TestCopySymbolTable = new SymbolTable(null, Scopekind.block);
        TestCopySymbolTable.put("1", new IdAttributes(new TId("1"),new TType("int") , "5", Attributes.variable));
        TestCopySymbolTable.put("2", new IdAttributes(new TId("2"),new TType("int") , "6", Attributes.variable));
        TestCopySymbolTable.put("3", new IdAttributes(new TId("3"),new TType("int") , "7", Attributes.variable));
        TestCopySymbolTable.put("4", new IdAttributes(new TId("4"),new TType("int") , "8", Attributes.variable));
        TestSymbolTable.putAll(TestCopySymbolTable);
        Assert.assertEquals(TestSymbolTable.size(), 4);
        eraseTable();
    }

    @Test //Anders, når du instantiere en funktion, så vil den ikke anerkende at det er en funktion
    public void testAddFunctionReturnType(){
        /*input("b", "b","int", "2", Attributes.function); 
        IdAttributes testReturnT = TestSymbolTable.addFunctionReturnType("b", "int");
        Assert.assertEquals(testReturnT, TestSymbolTable.getReturnType());
        eraseTable(); */
    }

    @Test
    public void testCreateNewScope(){
        TestSymbolTable.CreateNewScope(null, null, null);
    }

    @Test
    public void testGetFunctionSymbolTable(){
        TestSymbolTable.getFunctionSymbolTable(null);
    }
}