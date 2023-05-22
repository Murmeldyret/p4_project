package postfix.semantics.visitors.CodeGen;

import postfix.analysis.DepthFirstAdapter;
import postfix.node.AAddToCsvCsvOp;
import postfix.node.ACsvOperationStmt;
import postfix.node.AImportWithoutSeperatorStmt;
import postfix.node.AInsertFromCsvCsvOp;
import postfix.node.ARemoveAtFromCsvCsvOp;
import postfix.node.ARemoveFromCsvCsvOp;

public class CsvVisitorCodeGen extends DepthFirstAdapter{
    String csvOperations;

    @Override
    public void inAImportWithoutSeperatorStmt(AImportWithoutSeperatorStmt node) {
        csvOperations = "Csvruntime " + node.getId().toString() + "= new Csvruntime(" + node.getExpr().toString() + ");";
    }

    @Override
    public void inAAddToCsvCsvOp(AAddToCsvCsvOp node) {
        if (node.getOrientation().toString() == "row") {
            csvOperations = node.getId().getText() + "." + "addRow(" + node.getArrayExpr().toString() + ")";

        } else if (node.getOrientation().toString() == "column") {
            csvOperations = node.getId().getText() + "." + "addColumn(" + node.getExpr().toString() + ", " + node.getArrayExpr().toString() + ")";
        }
    }

    @Override
    public void inARemoveFromCsvCsvOp(ARemoveFromCsvCsvOp node) {
        if (node.getOrientation().toString() == "row") {
            csvOperations = node.getId().getText() + "." + "removeRow()";

        } else if (node.getOrientation().toString() == "column") {
            csvOperations = node.getId().getText() + "." + "removeColumn()";
        }
    }

    @Override
    public void inARemoveAtFromCsvCsvOp(ARemoveAtFromCsvCsvOp node) {
        if (node.getOrientation().toString() == "row") {
            csvOperations = node.getId().getText() + "." + "removeRow(" + node.getVal().toString() + ")";

        } else if (node.getOrientation().toString() == "column") {
            csvOperations = node.getId().getText() + "." + "removeColumn(" + node.getVal().toString() + ")";
        }
    }

    @Override
    public void inAInsertFromCsvCsvOp(AInsertFromCsvCsvOp node) {
        if (node.getOrientation().toString() == "row") {
            csvOperations = node.getId().getText() + "." + "insertRow(" + node.getVal().toString() + ", " + node.getArrayExpr().toString() + ")";

        } else if (node.getOrientation().toString() == "column") {
            csvOperations = node.getId().getText() + "." + "insertColumn(" + node.getVal().toString() + ", " + node.getExpr().toString() + ", " + node.getArrayExpr().toString() + ")";
        }
    }
}
