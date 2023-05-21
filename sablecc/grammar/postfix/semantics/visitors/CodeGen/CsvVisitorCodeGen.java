package postfix.semantics.visitors.CodeGen;

import postfix.analysis.DepthFirstAdapter;
import postfix.node.AAddToCsvCsvOp;
import postfix.node.AImportWithoutSeperatorStmt;

public class CsvVisitorCodeGen extends DepthFirstAdapter{
    String csvOperations;

    @Override
    public void inAImportWithoutSeperatorStmt(AImportWithoutSeperatorStmt node) {
        csvOperations = "Csvruntime " + node.getId().toString() + "= new Csvruntime(" + node.getString().getText().toString() + ");";
    }
}
