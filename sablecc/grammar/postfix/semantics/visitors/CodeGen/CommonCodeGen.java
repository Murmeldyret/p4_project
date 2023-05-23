package postfix.semantics.visitors.CodeGen;

import java.util.*;

import postfix.analysis.DepthFirstAdapter;
import postfix.node.*;
import postfix.semantics.IdAttributes;
import postfix.semantics.SymbolTable;
import postfix.semantics.IdAttributes.Attributes;
import postfix.semantics.SymbolTable.Scopekind;

public class CommonCodeGen extends DepthFirstAdapter {
    // Variables
    SymbolTable symbolTable;

    public String program;
    protected static final String bvm = "blockVariableMap";
    private int i = 0;
    // Constructor
    public CommonCodeGen() {
    };

    public CommonCodeGen(SymbolTable symbolTable, String program) {
        this.symbolTable = symbolTable;
        this.program = program;
    }

    @Override
    public void caseTSemi(TSemi node) {
        // TODO Auto-generated method stub
        super.caseTSemi(node);
        program += "\n";
    }

    @Override
    public void inAImportWithoutSeperatorStmt(AImportWithoutSeperatorStmt node) {
        CsvVisitorCodeGen csvVisitorCodeGen = new CsvVisitorCodeGen();
        node.apply(csvVisitorCodeGen);

        program += csvVisitorCodeGen.csvOperations;

    }

    @Override
    public void outADeclarationStmt(ADeclarationStmt node) {
        program += ";";
    }

    @Override
    public void inAAssignStmt(AAssignStmt node) {
        program += bvm +".put(\""+ node.getId().getText().toString()+"\",";

        node.getIndexing().apply(this);
        node.setIndexing(null);
        // program += " = ";
    }

    @Override
    public void outAAssignStmt(AAssignStmt node) {
        program += ");";
    }

    @Override
    public void outAFunctionCallStmt(AFunctionCallStmt node) {
        program += ";";
        // TODO ændr scope, NVM
    }

    @Override
    public void inAWhileLoopStmt(AWhileLoopStmt node) {
        int hashcode = node.getKwWhile().getLine() + node.getKwWhile().getPos();

        program += "Map<String,Object> old" +bvm+hashcode + " = new HashMap("+bvm+");\n";
        program += "while (";
        node.getExpr().apply(this);
        node.setExpr(null);
        program += ")";
        // TODO ændr scope, NVM InABlockStmtBlock gør det
    }
    @Override
    public void outAWhileLoopStmt(AWhileLoopStmt node) {
        int hashcode = node.getKwWhile().getLine() + node.getKwWhile().getPos();
        program += bvm + "= old" +bvm+hashcode+";\n";
    }

    @Override
    public void inAControlStatementStmt(AControlStatementStmt node) {
        int hashcode = node.getKwIf().getLine() + node.getKwIf().getPos();
        program += "Map<String,Object> old" +bvm+hashcode + " = new HashMap("+bvm+");\n";
        program += "if (";
        node.getExpr().apply(this);
        node.setExpr(null);
        program += ")\n";
    }
    @Override
    public void outAControlStatementStmt(AControlStatementStmt node) {
        int hashcode = node.getKwIf().getLine() + node.getKwIf().getPos();
        program += bvm + "= old" +bvm+hashcode+";\n";
    }

    @Override
    public void inAPrintStatementStmt(APrintStatementStmt node) {
        program += "System.out.println(";
    }

    @Override
    public void outAPrintStatementStmt(APrintStatementStmt node) {
        program += ");";
    }

    @Override
    public void inAFunctionDeclarationDcl(AFunctionDeclarationDcl node) {
        symbolTable.put(node.getId().getText(),
                new IdAttributes(node.getId(), node.getType(), null, Attributes.function));
    }

    @Override
    public void inAVariableDeclarationInitializationDcl(AVariableDeclarationInitializationDcl node) {
        if (!symbolTable.DeclaredLocally(node.getId().getText().toString())) {

            String type = typeSwitch(node.getType().getText().toString());

            // program += type + " " + node.getId().getText().toString() + " = ";
            // program += bvm + ".put(\"" + node.getId().getText()
            // +"\","+node.getExpr().toString().strip()+ ");";
            program += bvm + ".put(\"" + node.getId().getText() + "\",";
            symbolTable.put(node.getId().getText(),
                    new IdAttributes(node.getId(), node.getType(), null, Attributes.variable));
        }
    }

    @Override
    public void outAVariableDeclarationInitializationDcl(AVariableDeclarationInitializationDcl node) {
        program += ")";
    }

    private String convertIdToVal(String id) {
        // Class<String> bv = String.class;
        // Class<Boolean> ab = boolean.class;
        // Class<Char> ab = char.class;
        String type = typeSwitch(symbolTable.get(id).getType().getText()); // TODO medmindre det er array eller csv
        String typeWithFirstToUpper = type.substring(0, 1).toUpperCase(Locale.ROOT) + type.substring(1);
        return "ObjectConverter.convert(" + bvm + ".get(" + id + "," + type + ".class)";
    }

    @Override
    public void inAValIdVal(AValIdVal node) {
        // TODO objectconveter her
        if (node.parent() instanceof PExpr || node.parent() instanceof PExprPrime) { // TODO if Id is on rhs, convert
            // program += convertIdToVal(node.getId().getText());
            String type = typeSwitch(symbolTable.get(node.getId().getText()).getType().getText()); // TODO medmindre det
                                                                                                   // er array eller csv
            program += "(" + type + ")" + bvm + ".get(\"" + node.getId().getText() + "\")";
        }
    }

    @Override
    public void inAConstDeclarationInitializationDcl(AConstDeclarationInitializationDcl node) {
        String type = typeSwitch(node.getType().getText().toString());
        program += "final " + type + " " + node.getId().getText().strip() + " = " + node.getExpr().toString().strip()
                + ";";
        node.setExpr(null);
        symbolTable.put(node.getId().getText(),
                new IdAttributes(node.getId(), node.getType(), null, Attributes.constant));
    }

    @Override
    public void inABlockStmtBlock(ABlockStmtBlock node) {
        // ! LGTM :)))))))
        // program += "{ Map<String,Object> old" + bvm +i++ + " =" + bvm +";\n";
        // program += bvm + "= new HashMap<>("+bvm+");\n";
        program += "{\n";
        symbolTable = new SymbolTable(symbolTable, Scopekind.block);
    }

    @Override
    public void outABlockStmtBlock(ABlockStmtBlock node) {
        // program += bvm + " = old" +bvm+(--i)+";\n}";
        program +="}\n";
        symbolTable = symbolTable.getOuterSymbolTable();
    }

    @Override
    public void inAElifStatementInControlStmt(AElifStatementInControlStmt node) {
        program += "else if (";
        node.getExpr().apply(this);
        node.setExpr(null);
        program += ") ";
        // TODO ændr scope, NVM InABlockStmtBlock gør det
    }

    @Override
    public void inAElseBlockStatementElseStatement(AElseBlockStatementElseStatement node) {
        program += "else ";
        // TODO ændr scope, NVM InABlockStmtBlock gør det
    }

    @Override
    public void inAExprValPrimeExpr(AExprValPrimeExpr node) {
        if (node.getBopNot() != null) {
            program += "!";
        }
        if (!(node.getVal() instanceof AValIdVal)) {
            program += node.getVal().toString().strip();
        }
        // TODO måske skal det ikke udkommenteres
    }

    @Override
    public void inAVariableDeclarationDcl(AVariableDeclarationDcl node) {
        program += typeSwitch(node.getType().getText()) + " " + node.getId().getText();
        symbolTable.put(node.getId().getText(),
                new IdAttributes(node.getId(), node.getType(), null, Attributes.variable));
    }

    // Returns the appropriate types for code generation
    private String typeSwitch(String type) {
        switch (type) {
            case "int":
                return "int";
            case "float":
                return "double";
            case "bool":
                return "boolean";
            case "string":
                return "String";
            case "char":
                return "char";
        }
        return "";
    }

    @Override
    public void inAExprPrimeOperatorValPrimeExprPrime(AExprPrimeOperatorValPrimeExprPrime node) {
        String expr = "";

        expr += node.getBinInfixOp().toString();
        if (!(node.getVal() instanceof AValIdVal)) {
            expr += node.getVal().toString().strip();
        }
        program += expr;
    }

    @Override
    public void inAForLoopStmt(AForLoopStmt node) {
        program += "for ( " + symbolTable.get(node.getId().getText()).getType().getText() + " " + node.getId().getText()
                + " : ";

        node.getVal().apply(this);
        node.setVal(null);

        program += ") ";
        // TODO ændr scope, NVM InABlockStmtBlock gør det
    }

    @Override
    public void inAVariableDeclarationArrayDcl(AVariableDeclarationArrayDcl node) {
        if (typeSwitch(node.getType().getText()) == "int") {
            program += "ArrayList<Integer> " + node.getId().getText() + " = new ArrayList<Integer>()";
        } else if (typeSwitch(node.getType().getText()) == "double") {
            program += "ArrayList<Double> " + node.getId().getText() + " = new ArrayList<Double>()";
        } else {
            program += "ArrayList<" + typeSwitch(node.getType().getText()) + "> " + node.getId().getText()
                    + " = new ArrayList<" + typeSwitch(node.getType().getText()) + ">()";
        }
        symbolTable.put(node.getId().getText(), new IdAttributes(node.getId(), node.getType(), null, Attributes.array));
    }

    private boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isDouble(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public void inAAddToArrayArrayOp(AAddToArrayArrayOp node) {
        String[] sArr = node.getArrayExpr().toString().split(",");

        for (String s : sArr) {
            if (isInteger(s.strip())) {
                program += node.getId().getText() + ".add(" + s.strip() + ");";
            } else if (isDouble(s.strip())) {
                program += node.getId().getText() + ".add(" + s.strip() + ");";
            } else {
                program += node.getId().getText() + ".add(\"" + s.strip() + "\");";
            }
        }

    }

    @Override
    public void inARemoveFromArrayArrayOp(ARemoveFromArrayArrayOp node) {
        program += node.getId().getText() + ".remove(" + node.getId().getText() + ".size() - 1);";
    }

    @Override
    public void inARemoveAtFromArrayArrayOp(ARemoveAtFromArrayArrayOp node) {
        // System.out.println(node.getIndexing());
        program += node.getId().getText().strip() + ".remove(" + node.getIndexing().toString().strip() + ");";

        node.setIndexing(null);

    }

    @Override
    public void inAInsertToArrayArrayOp(AInsertToArrayArrayOp node) {
        // Insert val [0] in ArrayList
        Object o = node.getArrayExpr();

        if (o instanceof String) {
            program += node.getId().getText() + ".add(" + node.getArrayExpr().toString().strip() + ", \""
                    + node.getVal().toString().strip() + "\");";
        } else {
            program += node.getId().getText() + ".add(" + node.getArrayExpr().toString().strip() + ", "
                    + node.getVal().toString().strip() + ");";
        }
    }

}
