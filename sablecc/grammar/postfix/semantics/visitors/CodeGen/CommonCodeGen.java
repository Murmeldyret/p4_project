package postfix.semantics.visitors.CodeGen;

import java.util.List;

import postfix.analysis.DepthFirstAdapter;
import postfix.node.AAssignStmt;
import postfix.node.AExprValPrimeExpr;
import postfix.node.APrintStatementStmt;
import postfix.node.AVariableDeclarationDcl;
import postfix.node.AVariableDeclarationInitializationDcl;
import postfix.semantics.SymbolTable;

public class CommonCodeGen extends DepthFirstAdapter {
    // Variables
    SymbolTable symbolTable;

    public String program;
    
    //Constructor
    public CommonCodeGen() {};

    public CommonCodeGen(SymbolTable symbolTable, String program) {
        this.symbolTable = symbolTable;
        this.program = program;
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
    public void inAExprValPrimeExpr(AExprValPrimeExpr node) {
        if (node.getBopNot() != null)
            program += node.getBopNot().getText().toString();

        program += node.getVal().toString();
    }

    @Override
    public void inAVariableDeclarationDcl(AVariableDeclarationDcl node) {
        if (symbolTable.isDeclared(node.getId().getText())) {
            System.out.println("variable" + node.getId().getText() + " is already declared");
        } else {
            switch (node.getType().getText().toString()) {
                case "int":
                    program += "int " + node.getId().getText() + ";";
                    break;
                case "float":
                    program += "float " + node.getId().getText() + ";";
                    break; 
                case "bool":
                    program += "bool " + node.getId().getText() + ";";
                    break; 
                case "string":
                    program += "string " + node.getId().getText() + ";";
                    break; 
                case "csv":
                    program += "csv " + node.getId().getText() + ";";
                    break; 
                case "char":
                    program += "char " + node.getId().getText() + ";";
                    break; 
                case "array":
                    program += "array " + node.getId().getText() + ";";
                    break; 
            }
        }
    }

}
