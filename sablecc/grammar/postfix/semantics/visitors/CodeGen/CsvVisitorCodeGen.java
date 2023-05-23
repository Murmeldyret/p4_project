package postfix.semantics.visitors.CodeGen;

import postfix.analysis.DepthFirstAdapter;
import postfix.node.AAddToCsvCsvOp;
import postfix.node.ACountSpecialSyntax;
import postfix.node.ACsvOperationStmt;
import postfix.node.AFilterSpecialSyntax;
import postfix.node.AImportWithoutSeperatorStmt;
import postfix.node.AInsertFromCsvCsvOp;
import postfix.node.AMeanSpecialSyntax;
import postfix.node.ARemoveAtFromCsvCsvOp;
import postfix.node.ARemoveFromCsvCsvOp;
import postfix.node.ASortAscSpecialSyntax;
import postfix.node.ASortDescSpecialSyntax;
import postfix.node.ASortSpecialSyntax;
import postfix.node.ASumSpecialSyntax;
import postfix.semantics.SymbolTable;

public class CsvVisitorCodeGen extends DepthFirstAdapter{
    String csvOperations;
    SymbolTable symbolTable;

    public CsvVisitorCodeGen(SymbolTable symbolTable, String program) {
        this.symbolTable = symbolTable;
        this.csvOperations = program;
    }

    public CsvVisitorCodeGen() {

    }

    @Override
    public void inAImportWithoutSeperatorStmt(AImportWithoutSeperatorStmt node) {
        csvOperations += "Csvruntime " + node.getId().toString() + "= new Csvruntime(" + node.getExpr().toString().strip() + ");";
    }

    @Override
    public void inAAddToCsvCsvOp(AAddToCsvCsvOp node) {
        String[] sArr = node.getArrayExpr().toString().split(",");
        String ori = node.getOrientation().toString().strip();
        String arrayExpr = "";
        int i = 0;

        for (String s : sArr) {
            if (i++ == sArr.length -1) {
                arrayExpr += "\"" + s.strip() + "\"";
            } else {
                arrayExpr +=  "\"" + s.strip() + "\"" + ", ";
            }
        }
        
        System.out.println(arrayExpr);
        if (ori.equals("row")) {
            csvOperations += node.getId().getText() + ".addRow(" + arrayExpr + ")";

        } else if (ori.equals("column")) {
            csvOperations += node.getId().getText() + ".addColumn(" + node.getExpr().toString() + ", " + arrayExpr + ")";
        }
    }

    @Override
    public void inARemoveFromCsvCsvOp(ARemoveFromCsvCsvOp node) {
        String ori = node.getOrientation().toString().strip();

        if (ori.equals("row")) {
            csvOperations += node.getId().getText() + ".removeRow()";

        } else if (ori.equals("column")) {
            csvOperations += node.getId().getText() + ".removeColumn()";
        }
    }

    @Override
    public void inARemoveAtFromCsvCsvOp(ARemoveAtFromCsvCsvOp node) {
        String ori = node.getOrientation().toString().strip();

        if (ori.equals("row")) {
            csvOperations += node.getId().getText() + ".removeRow(" + node.getVal().toString() + ")";

        } else if (ori.equals("column")) {
            csvOperations += node.getId().getText() + ".removeColumn(" + node.getVal().toString() + ")";
        }
    }

    @Override
    public void inAInsertFromCsvCsvOp(AInsertFromCsvCsvOp node) {
        String[] sArr = node.getArrayExpr().toString().split(",");
        String ori = node.getOrientation().toString().strip();
        String arrayExpr = "";
        int i = 0;

        for (String s : sArr) {
            if (i++ == sArr.length -1) {
                arrayExpr += "\"" + s.strip() + "\"";
            } else {
                arrayExpr +=  "\"" + s.strip() + "\"" + ", ";
            }
        }
        
        System.out.println(arrayExpr);
        if (ori.equals("row")) {
            csvOperations += node.getId().getText() + ".insertRow(" + node.getVal().toString() + ", new String[] {" + arrayExpr + "})";

        } else if (ori.equals("column")) {
            csvOperations += node.getId().getText() + ".insertColumn(" + node.getVal().toString() + ", " + node.getExpr().toString() + ", " + arrayExpr + ")";
        }
    }

    @Override
    public void inASumSpecialSyntax(ASumSpecialSyntax node) {
        csvOperations += ".sum(" + node.getExpr().toString() + ")";
    }

    @Override
    public void inAFilterSpecialSyntax(AFilterSpecialSyntax node) {
        csvOperations += ".filter(" + node.getExpr().toString() + "," + node.getFilterexpr().toString() + ")";
    }

    @Override
    public void inACountSpecialSyntax(ACountSpecialSyntax node) {
        csvOperations += ".count()";
    }

    @Override
    public void inAMeanSpecialSyntax(AMeanSpecialSyntax node) {
        csvOperations += ".mean(" + node.getExpr().toString() + ")";
    }

    @Override
    public void inASortSpecialSyntax(ASortSpecialSyntax node) {
        csvOperations += ".sort(" + node.getExpr().toString() + ", false)";
    }

    @Override
    public void inASortDescSpecialSyntax(ASortDescSpecialSyntax node) {
        csvOperations += ".sort(" + node.getExpr().toString() + ", true)";
    }

    @Override
    public void inASortAscSpecialSyntax(ASortAscSpecialSyntax node) {
        csvOperations += ".sort(" + node.getExpr().toString() + ", false)";
    }
}
