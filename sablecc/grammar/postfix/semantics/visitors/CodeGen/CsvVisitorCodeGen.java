package postfix.semantics.visitors.CodeGen;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import postfix.analysis.DepthFirstAdapter;
import postfix.node.AAddToCsvCsvOp;
import postfix.node.ACountSpecialSyntax;
import postfix.node.ACsvOperationStmt;
import postfix.node.ACsvToArrayDclDcl;
import postfix.node.AExportStatementStmt;
import postfix.node.AExprSpecialExpr;
import postfix.node.AFilterSpecialSyntax;
import postfix.node.AFilterexprFilterexpr;
import postfix.node.AImportWithoutSeperatorStmt;
import postfix.node.AInsertFromCsvCsvOp;
import postfix.node.AMeanSpecialSyntax;
import postfix.node.ARemoveAtFromCsvCsvOp;
import postfix.node.ARemoveFromCsvCsvOp;
import postfix.node.ASortAscSpecialSyntax;
import postfix.node.ASortDescSpecialSyntax;
import postfix.node.ASortSpecialSyntax;
import postfix.node.ASumSpecialSyntax;
import postfix.node.AVariableDeclarationDcl;
import postfix.semantics.SymbolTable;

public class CsvVisitorCodeGen extends DepthFirstAdapter {
    String csvOperations = "";
    String csvId;
    SymbolTable symbolTable;

    public CsvVisitorCodeGen(SymbolTable symbolTable, String program) {
        this.symbolTable = symbolTable;
        this.csvOperations = program;
    }

    public CsvVisitorCodeGen() {
    }

    public CsvVisitorCodeGen(String id) {
        this.csvId = id;
    }

    @Override
    public void inAExprSpecialExpr(AExprSpecialExpr node) {
        csvOperations += node.getId().getText();
    }

    @Override
    public void inAImportWithoutSeperatorStmt(AImportWithoutSeperatorStmt node) {
        csvOperations += "Csvruntime " + node.getId().toString() + "= new Csvruntime("
                + node.getExpr().toString().strip() + ");";
    }

    @Override
    public void inAExportStatementStmt(AExportStatementStmt node) {
        csvOperations += node.getId().getText() + ".export(" + node.getExpr().toString().strip() +");";
    }

    @Override
    public void inAAddToCsvCsvOp(AAddToCsvCsvOp node) {
        String[] sArr = node.getArrayExpr().toString().split(",");
        String ori = node.getOrientation().toString().strip();
        String arrayExpr = "";
        int i = 0;

        for (String s : sArr) {
            if (i++ == sArr.length - 1) {
                arrayExpr += "\"" + s.strip() + "\"";
            } else {
                arrayExpr += "\"" + s.strip() + "\"" + ", ";
            }
        }

        System.out.println(arrayExpr);
        if (ori.equals("row")) {
            csvOperations += node.getId().getText() + ".addRow(" + arrayExpr + ")";

        } else if (ori.equals("column")) {
            csvOperations += node.getId().getText() + ".addColumn(" + node.getExpr().toString() + ", " + arrayExpr
                    + ")";
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
            if (i++ == sArr.length - 1) {
                arrayExpr += "\"" + s.strip() + "\"";
            } else {
                arrayExpr += "\"" + s.strip() + "\"" + ", ";
            }
        }

        if (ori.equals("row")) {
            csvOperations += node.getId().getText() + ".insertRow(" + node.getVal().toString() + ", new String[] {"
                    + arrayExpr + "})";

        } else if (ori.equals("column")) {
            csvOperations += node.getId().getText() + ".insertColumn(" + node.getVal().toString() + ", "
                    + node.getExpr().toString() + ", " + arrayExpr + ")";
        }
    }

    @Override
    public void inACsvToArrayDclDcl(ACsvToArrayDclDcl node) {

        if (isInteger(node.getExpr().toString().strip())) {
            csvOperations += "addAll(" + node.getCsvAndArrayHelp().toString().strip() + ".getRow("
                    + node.getExpr().toString().strip() + "))";
        } else {
            csvOperations += "addAll(" + node.getCsvAndArrayHelp().toString().strip() + ".getColumn("
                    + node.getExpr().toString().strip() + "))";
        }
    }

    @Override
    public void inASumSpecialSyntax(ASumSpecialSyntax node) {
        csvOperations += ".sum(" + node.getExpr().toString().strip() + ")";
    }

    @Override
    public void inAFilterSpecialSyntax(AFilterSpecialSyntax node) {
        String filterString = "";
        csvOperations += ".filter(" + node.getExpr().toString().strip() + ",";

        String type = typeSwitch(((AVariableDeclarationDcl) node.getDcl()).getType().getText());
        String id = ((AVariableDeclarationDcl) node.getDcl()).getId().getText();
        String filtExpr = ((AFilterexprFilterexpr) node.getFilterexpr()).getExpr().toString();

        filterString += "new Csvruntime.Filter<" + type + ">() {";
        filterString += "@Override\npublic Boolean compare(" + type + " " + id + ") {";
        filterString += "return ";

        if (type.equals("String")) {
            Pattern p = Pattern.compile("(\".*\")");
            Matcher m = p.matcher(filtExpr);
            filterString += id + ".equals(";
            if (m.find()) {
                filterString += m.group(0);
            }
            filterString += ");";
        } else {
            filterString += filtExpr + ";";
        }

        filterString += "}}";
        csvOperations += filterString + ")";
    }

    @Override
    public void inACountSpecialSyntax(ACountSpecialSyntax node) {
        csvOperations += ".count();";
    }

    @Override
    public void inAMeanSpecialSyntax(AMeanSpecialSyntax node) {
        csvOperations += ".mean(" + node.getExpr().toString().strip() + ")";
    }

    @Override
    public void inASortSpecialSyntax(ASortSpecialSyntax node) {
        csvOperations += ".sort(" + node.getExpr().toString().strip() + ", false)";
    }

    @Override
    public void inASortDescSpecialSyntax(ASortDescSpecialSyntax node) {
        csvOperations += ".sort(" + node.getExpr().toString().strip() + ", true)";
    }

    @Override
    public void inASortAscSpecialSyntax(ASortAscSpecialSyntax node) {
        csvOperations += ".sort(" + node.getExpr().toString().strip() + ", false)";
    }

    private boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private String typeSwitch(String type) {
        switch (type) {
            case "int":
                return "Integer";
            case "float":
                return "Double";
            case "bool":
                return "Boolean";
            case "string":
                return "String";
            case "char":
                return "Character";
        }
        return "";
    }
}
