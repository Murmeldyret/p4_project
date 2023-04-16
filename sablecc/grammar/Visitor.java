import postfix.analysis.DepthFirstAdapter;
import postfix.lexer.*;
import postfix.parser.*;
import postfix.node.*;

import java.io.*;

public class Visitor extends DepthFirstAdapter {

    static final int indent = 4;
    int indent_count = 0;
    String prettyprint = "";

    @Override
    public void outStart(Start node) {
        System.out.print(prettyprint);
    }

    @Override
    public void inAStatementsStmts(AStatementsStmts node) {
        print_indent();
        node.getStmt().apply(this);
        node.setStmt(null);
        prettyprint += node.getSemi().toString() + "\n";
    }

    @Override
    public void inAImportWithoutSeperatorStmt(AImportWithoutSeperatorStmt node) {
        space_print_check();
        prettyprint += node.getKwImport().toString() + node.getString().toString() + node.getKwAs().toString()
                + node.getId().getText().toString();
    }

    @Override
    public void inAImportWithSeperatorStmt(AImportWithSeperatorStmt node) {
        // TODO Auto-generated method stub
        super.inAImportWithSeperatorStmt(node);
    }

    @Override
    public void inAAssignStmt(AAssignStmt node) {
        space_print_check();
        prettyprint += node.getId().getText().toString();
        node.getIndexing().apply(this);
        node.setIndexing(null);
        space_print_check();
        prettyprint += node.getOpAssign().getText().toString();
    }

    @Override
    public void inAForLoopStmt(AForLoopStmt node) {
        prettyprint += node.getKwFor().toString() + node.getId().toString() + node.getKwIn().toString()
                + node.getVal().toString();
    }

    @Override
    public void inAWhileLoopStmt(AWhileLoopStmt node) {
        prettyprint += node.getKwWhile().getText().toString();
    }

    @Override
    public void inAControlStatementStmt(AControlStatementStmt node) {
        space_print_check();
        prettyprint += node.getKwIf().toString();
    }

    @Override
    public void inAPrintStatementStmt(APrintStatementStmt node) {
        prettyprint += node.getKwPrint().toString();
    }

    @Override
    public void inAExportStatementStmt(AExportStatementStmt node) {
        space_print_check();
        prettyprint += node.getKwExport().toString() + node.getId().toString() + node.getKwTo().toString();
    }

    @Override
    public void inAReturnStmt(AReturnStmt node) {
        space_print_check();
        prettyprint += node.getKwReturn().toString();
    }

    @Override
    public void inABreakStatementStmt(ABreakStatementStmt node) {
        space_print_check();
        prettyprint += node.getKwBreak().getText().toString();
    }

    @Override
    public void inAVariableDeclarationInitializationDcl(AVariableDeclarationInitializationDcl node) {
        space_print_check();
        prettyprint += node.getType().toString() + node.getId().toString() + node.getOpAssign().toString();
    }

    @Override
    public void inAVariableDeclarationDcl(AVariableDeclarationDcl node) {
        space_print_check();
        prettyprint += node.getType().toString() + node.getId().getText().toString();
    }

    @Override
    public void inAConstDeclarationInitializationDcl(AConstDeclarationInitializationDcl node) {
        space_print_check();
        prettyprint += node.getKwConst().toString() + node.getType().toString() + node.getId().toString()
                + node.getOpAssign().toString();
    }

    @Override
    public void inAFunctionDeclarationDcl(AFunctionDeclarationDcl node) {
        space_print_check();
        prettyprint += node.getType().toString() + node.getKwFunction().toString() + node.getId().getText().toString();

        prettyprint += "(";

        node.getFunctionParam().apply(this);
        node.setFunctionParam(null);
        prettyprint += ")";

        prettyprint += "{\n";
        indent_count += indent;

        node.getStmts().apply(this);
        node.setStmts(null);

        indent_count -= indent;
        print_indent();
        prettyprint += "}";
    }

    @Override
    public void inAFunctionParamPrimeFunctionParamPrime(AFunctionParamPrimeFunctionParamPrime node) {
        prettyprint += node.getSopComma().toString();
    }

    @Override
    public void inAFunctionCallParamFunctionCallParam(AFunctionCallParamFunctionCallParam node) {
        prettyprint += "(";
    }

    @Override
    public void outAFunctionCallParamFunctionCallParam(AFunctionCallParamFunctionCallParam node) {
        prettyprint += ")";
    }

    @Override
    public void inAFunctionCallParamPrimeFunctionCallParamPrime(AFunctionCallParamPrimeFunctionCallParamPrime node) {
        prettyprint += ",";
    }

    @Override
    public void inABlockStmtBlock(ABlockStmtBlock node) {
        space_print_check();
        prettyprint += "{\n";
        indent_count += indent;
    }

    @Override
    public void outABlockStmtBlock(ABlockStmtBlock node) {
        indent_count -= indent;
        print_indent();
        prettyprint += "}";
    }

    @Override
    public void inAElifStatementInControlStmt(AElifStatementInControlStmt node) {
        space_print_check();
        prettyprint += node.getKwElse().toString() + node.getKwIf().toString();
    }

    @Override
    public void inAElseBlockStatementElseStatement(AElseBlockStatementElseStatement node) {
        space_print_check();
        prettyprint += node.getKwElse().toString();
    }

    @Override
    public void inAExprValPrimeExpr(AExprValPrimeExpr node) {
        if (node.getBopNot() != null) {
            prettyprint += "!";
        }
    }

    @Override
    public void outAExprSpecialExpr(AExprSpecialExpr node) {
        space_print_check();
        prettyprint += node.getId().getText().toString();
    }

    @Override
    public void inAExprPrimeOperatorValPrimeExprPrime(AExprPrimeOperatorValPrimeExprPrime node) {
        space_print_check();
        prettyprint += node.getBinInfixOp();
    }

    @Override
    public void inAAddToCsvCsvOp(AAddToCsvCsvOp node) {
        space_print_check();
        prettyprint += node.getKwAdd().toString() + node.getOrientation().toString();

        node.getArrayExpr().apply(this);
        node.setArrayExpr(null);

        space_print_check();
        prettyprint += node.getKwIn().toString() + node.getId().getText().toString();
    }

    @Override
    public void inARemoveFromCsvCsvOp(ARemoveFromCsvCsvOp node) {
        space_print_check();
        prettyprint += node.getKwRemove().toString() + node.getOrientation().toString() + node.getKwIn().toString()
                + node.getId().getText().toString();
    }

    @Override
    public void inARemoveAtFromCsvCsvOp(ARemoveAtFromCsvCsvOp node) {
        space_print_check();
        prettyprint += node.getKwRemoveAt().toString() + node.getOrientation().toString();
    }

    @Override
    public void outARemoveAtFromCsvCsvOp(ARemoveAtFromCsvCsvOp node) {
        space_print_check();
        prettyprint += node.getKwIn().toString() + node.getId().getText().toString();
    }

    @Override
    public void inAInsertFromCsvCsvOp(AInsertFromCsvCsvOp node) {
        space_print_check();
        prettyprint += node.getKwInsert().toString() + node.getOrientation();
    }

    @Override
    public void outAInsertFromCsvCsvOp(AInsertFromCsvCsvOp node) {
        space_print_check();
        prettyprint += node.getKwIn().toString() + node.getId().getText().toString();
    }

    @Override
    public void inAIndexingIndexing(AIndexingIndexing node) {
        prettyprint += "[";
        node.getExpr().apply(this);
        node.setExpr(null);
        prettyprint += "]";
    }

    @Override
    public void inAArrayExprValPrimeArrayExpr(AArrayExprValPrimeArrayExpr node) {
        space_print_check();
        prettyprint += "[";
    }

    @Override
    public void outAArrayExprValPrimeArrayExpr(AArrayExprValPrimeArrayExpr node) {
        prettyprint += "]";
    }

    @Override
    public void inAArrayExprPrimeExtraArrayExprPrime(AArrayExprPrimeExtraArrayExprPrime node) {
        prettyprint += ",";
    }

    @Override
    public void inAAddToArrayArrayOp(AAddToArrayArrayOp node) {
        // TODO Auto-generated method stub
        super.inAAddToArrayArrayOp(node);
    }

    @Override
    public void inARemoveFromArrayArrayOp(ARemoveFromArrayArrayOp node) {
        space_print_check();
        prettyprint += node.getKwRemove().toString() + node.getKwIn().toString() + node.getId().getText().toString();
    }

    @Override
    public void inARemoveAtFromArrayArrayOp(ARemoveAtFromArrayArrayOp node) {
        space_print_check();
        prettyprint += node.getKwRemoveAt().toString();
    }

    @Override
    public void outARemoveAtFromArrayArrayOp(ARemoveAtFromArrayArrayOp node) {
        space_print_check();
        prettyprint += node.getKwIn().toString() + node.getId().getText().toString();
    }

    @Override
    public void inAInsertToArrayArrayOp(AInsertToArrayArrayOp node) {
        space_print_check();
        prettyprint += node.getKwInsert().toString();
    }

    @Override
    public void outAInsertToArrayArrayOp(AInsertToArrayArrayOp node) {
        space_print_check();
        prettyprint += node.getKwIn().toString() + node.getId().getText().toString();
    }

    @Override
    public void inAValIdVal(AValIdVal node) {
        space_print_check();
        prettyprint += node.getId().getText().toString();
    }

    @Override
    public void inAFunctionCallVal(AFunctionCallVal node) {
        space_print_check();
        prettyprint += node.getId().getText().toString();
    }

    @Override
    public void inAValFloatnumVal(AValFloatnumVal node) {
        space_print_check();
        prettyprint += node.getFloatnum().getText().toString();
    }

    @Override
    public void inAValIntnumVal(AValIntnumVal node) {
        space_print_check();
        prettyprint += node.getIntnum().getText().toString();
    }

    @Override
    public void inAValStringVal(AValStringVal node) {
        space_print_check();
        prettyprint += node.getString().getText().toString();
    }

    @Override
    public void inAValBoolVal(AValBoolVal node) {
        space_print_check();
        prettyprint += node.getBool().getText().toString();
    }

    

    private void print_indent() {
        for (int i = 0; i < indent_count; i++) {
            prettyprint += " ";
        }
    }

    private void space_print_check() {
        String x = prettyprint.substring(prettyprint.length() - 1);

        // TODO: Change this to be a switch instead of this. It'll probably become very
        // long at some point.
        if (!x.equals(" ") && !x.equals("[") && !x.equals("\n") && !x.equals("(")) {
            prettyprint += " ";
        }
    }
}