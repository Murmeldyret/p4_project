package postfix;
import postfix.analysis.*;
import postfix.node.*;

class Translation extends DepthFirstAdapter
{
public void outAAddToArrayArrayAdd(AAddToArrayArrayAdd node)
{// out of alternative {plus} in Expr, we print the plus.
    System.out.print(node.getKwAdd());
    System.out.print(node.getLPar());
    System.out.print(node.getArrayExpr());
    System.out.print(node.getRPar());
}

public void outAAddToCsvCsvOp(AAddToCsvCsvOp node)
{
    System.out.print(node.getKwAdd());
    System.out.print(node.getOrientation());
    System.out.print(node.getArrayExpr());
    System.out.print(node.getKwIn());
    System.out.print(node.getId());
}

public void outAAndInfixBinInfixOp(AAndInfixBinInfixOp node)
{
    System.out.print(node.getBopAnd());
}

public void outAArrayExprPrime(AArrayExprPrime node)
{
    //has no get method
}

public void outAArrayExprPrimeExtraArrayExprPrime(AArrayExprPrimeExtraArrayExprPrime node)
{
    System.out.print(node.getSopComma());
    System.out.print(node.getVal());
    System.out.print(node.getArrayExprPrime());
}

public void outAArrayExprValPrimeArrayExpr(AArrayExprValPrimeArrayExpr node)
{
    System.out.print(node.getVal());
    System.out.print(node.getArrayExprPrime());
}

public void outAArrayOperationsStmt(AArrayOperationsStmt node)
{
    System.out.print(node.getArrayOp());
}

public void outAAssignStmt(AAssignStmt node)
{
    System.out.print(node.getId());
    System.out.print(node.getIndexing());
    System.out.print(node.getOpAssign());
    System.out.print(node.getExpr());
}

public void outABlockStmtBlock(ABlockStmtBlock node)
{
    System.out.print(node.getStmts());
}

public void outABreakStatementStmt(ABreakStatementStmt node)
{
    System.out.print(node.getKwBreak());
}

public void outAConstDeclarationInitializationDcl(AConstDeclarationInitializationDcl node)
{
    System.out.print(node.getKwConst());
    System.out.print(node.getType());
    System.out.print(node.getId());
    System.out.print(node.getOpAssign());
    System.out.print(node.getExpr());
}

public void outAControlStatementStmt(AControlStatementStmt node)
{
    System.out.print(node.getKwIf());
    System.out.print(node.getExpr());
    System.out.print(node.getBlock());
    System.out.print(node.getInControlStmt());
}

public void outACountSpecialSyntax(ACountSpecialSyntax node)
{
    System.out.print(node.getSopCount());
    System.out.print(node.getId());
}

public void outACsvOperationStmt(ACsvOperationStmt node)
{
    System.out.print(node.getCsvOp());
}

public void outACsvOrientationColumnOrientation(ACsvOrientationColumnOrientation node)
{
    System.out.print(node.getKwColumn());
}

public void outACsvOrientationRowOrientation(ACsvOrientationRowOrientation node)
{
    System.out.print(node.getKwRow());
}

public void outADeclarationStmt(ADeclarationStmt node)
{
    System.out.print(node.getDcl());
}

public void outADivisionInfixBinInfixOp(ADivisionInfixBinInfixOp node)
{
    System.out.print(node.getOpDiv());
}

public void outAElifStatementInControlStmt(AElifStatementInControlStmt node)
{
    System.out.print(node.getKwElse());
    System.out.print(node.getKwIf());
    System.out.print(node.getExpr());
    System.out.print(node.getBlock());
    System.out.print(node.getInControlStmt());
}

public void outAElseBlockStatementElseStatement(AElseBlockStatementElseStatement node)
{
    System.out.print(node.getKwElse());
    System.out.print(node.getBlock());
}

public void outAElseStatementInControlStmt(AElseStatementInControlStmt node)
{
    System.out.print(node.getElseStatement());
}

public void outAEqualityInfixBinInfixOp(AEqualityInfixBinInfixOp node)
{
    System.out.print(node.getBopEq());
}

public void outAExportStatementStmt(AExportStatementStmt node)
{
    System.out.print(node.getKwExport());
    System.out.print(node.getId());
    System.out.print(node.getKwTo());
    System.out.print(node.getExpr());
}

public void outAExprArrayExpr(AExprArrayExpr node)
{
    System.out.print(node.getArrayExpr());
}

public void outAExprPrimeOperatorValPrimeExprPrime(AExprPrimeOperatorValPrimeExprPrime node)
{
    System.out.print(node.getBinInfixOp());
    System.out.print(node.getVal());
    System.out.print(node.getExprPrime());
}

public void outAExprSpecialExpr(AExprSpecialExpr node)
{
    System.out.print(node.getSpecialExpr());
    System.out.print(node.getId());
}

public void outAExprValPrimeExpr(AExprValPrimeExpr node)
{//
    System.out.print(node.getBopNot());
    System.out.print(node.getVal());
    System.out.print(node.getExprPrime());
}

public void outAFilterSpecialSyntax(AFilterSpecialSyntax node)
{
    System.out.print(node.getSopFilter());
    System.out.print(node.getId());
}

public void outAForLoopStmt(AForLoopStmt node)
{
    System.out.print(node.getKwFor());
    System.out.print(node.getId());
    System.out.print(node.getKwIn());
    System.out.print(node.getVal());
    System.out.print(node.getBlock());
}

public void outAFunctionCallParamFunctionCallParam(AFunctionCallParamFunctionCallParam node)
{
    System.out.print(node.getExpr());
    System.out.print(node.getFunctionCallParamPrime());
}

public void outAFunctionCallParamPrimeFunctionCallParamPrime(AFunctionCallParamPrimeFunctionCallParamPrime node)
{
    System.out.print(node.getSopComma());
    System.out.print(node.getExpr());
    System.out.print(node.getFunctionCallParamPrime());
}

public void outAFunctionCallVal(AFunctionCallVal node)
{
    System.out.print(node.getId());
    System.out.print(node.getFunctionCallParam());
}

public void outAFunctionDeclarationDcl(AFunctionDeclarationDcl node)
{
    System.out.print(node.getType());
    System.out.print(node.getKwFunction());
    System.out.print(node.getId());
    System.out.print(node.getFunctionParam());
    System.out.print(node.getStmts());
}

public void outAFunctionParamFunctionParam(AFunctionParamFunctionParam node)
{
    System.out.print(node.getDcl());
    System.out.print(node.getFunctionParamPrime());
}

public void outAFunctionParamPrimeFunctionParamPrime(AFunctionParamPrimeFunctionParamPrime node)
{
    System.out.print(node.getSopComma());
    System.out.print(node.getDcl());
    System.out.print(node.getFunctionParamPrime());
}

public void outAGreaterThanEqualInfixBinInfixOp(AGreaterThanEqualInfixBinInfixOp node)
{
    System.out.print(node.getBopGethan());
}

public void outAGreaterThanInfixBinInfixOp(AGreaterThanInfixBinInfixOp node)
{
    System.out.print(node.getBopGthan());
}

public void outAGroupbySpecialSyntax(AGroupbySpecialSyntax node)
{
    System.out.print(node.getSopGroupby());
    System.out.print(node.getId());
}

public void outAImportWithoutSeperatorStmt(AImportWithoutSeperatorStmt node)
{
    System.out.print(node.getKwImport());
    System.out.print(node.getString());
    System.out.print(node.getKwAs());
    System.out.print(node.getId());
}

public void outAImportWithSeperatorStmt(AImportWithSeperatorStmt node)
{
    System.out.print(node.getKwImport());
    System.out.print(node.getString());
    System.out.print(node.getKwSeparatedBy());
    System.out.print(node.getChar());
    System.out.print(node.getKwAs());
    System.out.print(node.getId());
}

public void outAIndexingIndexing(AIndexingIndexing node)
{
    System.out.print(node.getExpr());
    System.out.print(node.getIndexing());
}

public void outAInsertFromCsvCsvOp(AInsertFromCsvCsvOp node)
{
    System.out.print(node.getKwInsert());
    System.out.print(node.getOrientation());
    System.out.print(node.getVal());
    System.out.print(node.getArrayExpr());
    System.out.print(node.getKwIn());
    System.out.print(node.getId());
}

public void outAInsertToArrayArrayOp(AInsertToArrayArrayOp node)
{
    System.out.print(node.getKwInsert());
    System.out.print(node.getVal());
    System.out.print(node.getArrayExpr());
    System.out.print(node.getKwIn());
    System.out.print(node.getId());
}

public void outALessThanEqualInfixBinInfixOp(ALessThanEqualInfixBinInfixOp node)
{
    System.out.print(node.getBopLethan());
}

public void outALessThanInfixBinInfixOp(ALessThanInfixBinInfixOp node)
{
    System.out.print(node.getBopLthan());
}

public void outAMeanSpecialSyntax(AMeanSpecialSyntax node)
{
    System.out.print(node.getSopMean());
    System.out.print(node.getId());
}

public void outAMinusInfixBinInfixOp(AMinusInfixBinInfixOp node)
{//
    System.out.print(node.getOpMinus());
}

public void outAMultiplicationInfixBinInfixOp(AMultiplicationInfixBinInfixOp node)
{//
    System.out.print(node.getOpMult());
}

public void outAModuloInfixBinInfixOp(AModuloInfixBinInfixOp node)
{//
    System.out.print(node.getOpMod());
}

public void outANotEqualInfixBinInfixOp(ANotEqualInfixBinInfixOp node)
{
    System.out.print(node.getBopNeq());
}

public void outAOrInfixBinInfixOp(AOrInfixBinInfixOp node)
{
    System.out.print(node.getBopOr());
}

public void outAPlusInfixBinInfixOp(APlusInfixBinInfixOp node)
{//
System.out.print(node.getOpPlus());
}

public void outAPrintStatementStmt(APrintStatementStmt node)
{
    System.out.print(node.getKwPrint());
    System.out.print(node.getExpr());
}

public void outAProgramProgram(AProgramProgram node)
{
    System.out.print(node.getStmts());
}

public void outARemoveAtFromArrayArrayOp(ARemoveAtFromArrayArrayOp node)
{
    System.out.print(node.getKwRemoveAt());
    System.out.print(node.getIndexing());
    System.out.print(node.getKwIn());
    System.out.print(node.getId());
}

public void outARemoveAtFromCsvCsvOp(ARemoveAtFromCsvCsvOp node)
{
    System.out.print(node.getKwRemoveAt());
    System.out.print(node.getOrientation());
    System.out.print(node.getVal());
    System.out.print(node.getKwIn());
    System.out.print(node.getId());
}

public void outARemoveFromArrayArrayOp(ARemoveFromArrayArrayOp node)
{
    System.out.print(node.getKwRemove());
    System.out.print(node.getKwIn());
    System.out.print(node.getId());
}

public void outARemoveFromCsvCsvOp(ARemoveAtFromCsvCsvOp node)
{
    System.out.print(node.getKwRemove());
    System.out.print(node.getOrientation());
    System.out.print(node.getKwIn());
    System.out.print(node.getId());
}

public void outAReturnStmt(AReturnStmt node)
{
    System.out.print(node.getKwReturn());
    System.out.print(node.getExpr());
}

public void outASortAscSpecialSyntax(ASortAscSpecialSyntax node)
{
    System.out.print(node.getSopSort());
    System.out.print(node.getId());
    System.out.print(node.getSopComma());
    System.out.print(node.getKwSortOrderAsc());
}

public void outASortDescSpecialSyntax(ASortDescSpecialSyntax node)
{
    System.out.print(node.getSopSort());
    System.out.print(node.getId());
    System.out.print(node.getSopComma());
    System.out.print(node.getKwSortOrderDsc());
}

public void outASortSpecialSyntax(ASortSpecialSyntax node)
{
    System.out.print(node.getSopSort());
    System.out.print(node.getId());
}

public void outASpecialExprPrimeSpecialExprPrime(ASpecialExprPrimeSpecialExprPrime node)
{
    System.out.print(node.getSpecialSyntax());
    System.out.print(node.getSpecialExprPrime());
}

public void outASpeicalExpressionSpecialExpr(ASpeicalExpressionSpecialExpr node)
{
    System.out.print(node.getSpecialSyntax());
    System.out.print(node.getSpecialExprPrime());
}

public void outAStatementStmts(AStatementsStmts node)
{
    System.out.print(node.getStmt());
    System.out.print(node.getNewline());
    System.out.print(node.getStmts());
}

public void outASumSpecialSyntax(ASumSpecialSyntax node)
{
    System.out.print(node.getSopSum());
    System.out.print(node.getId());
}

public void outAValBoolVal(AValBoolVal node)
{
    System.out.print(node.getBool());
}

public void outAValFloatnumVal(AValFloatnumVal node)
{
    System.out.print(node.getFloatnum());
}

public void outAValIdVal(AValIdVal node)
{
    System.out.print(node.getId());
}

public void outAValIntnumVal(AValIntnumVal node)
{
    System.out.print(node.getIntnum());
}

public void outAValStringVal(AValStringVal node)
{
    System.out.print(node.getString());
}

public void outAVariableDeclarationDcl(AVariableDeclarationDcl node)
{
    System.out.print(getType());
    System.out.print(getId());
}

public void outAVariableDeclarationInitializationDcl(AVariableDeclarationInitializationDcl node)
{
    System.out.print(node.getType());
    System.out.print(node.getId());
    System.out.print(node.getOpAssign());
    System.out.print(node.getExpr());
}

public void outAWhileLoopStmt(AWhileLoopStmt node)
{
    System.out.print(node.getKwWhile());
    System.out.print(node.getExpr());
    System.out.print(node.getBlock());
}


public void outTRPar(TRPar node)
{//
System.out.print(node.getText());
}

public void outTLPar(TLPar node)
{//
System.out.print(node.getText());
}

public void outEOF(EOF node)
{//
System.out.print(node.getText());
}

}