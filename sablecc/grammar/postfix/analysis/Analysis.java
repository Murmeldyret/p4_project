/* This file was generated by SableCC (http://www.sablecc.org/). */

package postfix.analysis;

import postfix.node.*;

public interface Analysis extends Switch
{
    Object getIn(Node node);
    void setIn(Node node, Object o);
    Object getOut(Node node);
    void setOut(Node node, Object o);

    void caseStart(Start node);
    void caseAProgramProgram(AProgramProgram node);
    void caseAStatementsStmts(AStatementsStmts node);
    void caseAStmts(AStmts node);
    void caseAImportStmtStmt(AImportStmtStmt node);
    void caseADeclarationStmt(ADeclarationStmt node);
    void caseAAssignmentStatementStmt(AAssignmentStatementStmt node);
    void caseAArrayOperationsStmt(AArrayOperationsStmt node);
    void caseAForLoopStmt(AForLoopStmt node);
    void caseAWhileLoopStmt(AWhileLoopStmt node);
    void caseAControlStatementStmt(AControlStatementStmt node);
    void caseAPrintStatementStmt(APrintStatementStmt node);
    void caseACsvOperationStmt(ACsvOperationStmt node);
    void caseAExportStatementStmt(AExportStatementStmt node);
    void caseABlockStmtBlock(ABlockStmtBlock node);
    void caseAElifStatementInControlStmt(AElifStatementInControlStmt node);
    void caseAElseStatementInControlStmt(AElseStatementInControlStmt node);
    void caseAElseBlockStatementElseStatement(AElseBlockStatementElseStatement node);
    void caseAElseStatement(AElseStatement node);
    void caseAAssignAssignment(AAssignAssignment node);
    void caseAExprValPrimeExpr(AExprValPrimeExpr node);
    void caseAExprSpecialExpr(AExprSpecialExpr node);
    void caseAExprPrimeOperatorValPrimeExprPrime(AExprPrimeOperatorValPrimeExprPrime node);
    void caseAExprPrime(AExprPrime node);
    void caseACsvOperationAddCsvOp(ACsvOperationAddCsvOp node);
    void caseACsvOperationRemoveCsvOp(ACsvOperationRemoveCsvOp node);
    void caseACsvOperationRemoveAtCsvOp(ACsvOperationRemoveAtCsvOp node);
    void caseACsvOperationInsertCsvOp(ACsvOperationInsertCsvOp node);
    void caseAAddToCsvCsvAdd(AAddToCsvCsvAdd node);
    void caseARemoveFromCsvCsvRemove(ARemoveFromCsvCsvRemove node);
    void caseARemoveAtFromCsvCsvRemoveAt(ARemoveAtFromCsvCsvRemoveAt node);
    void caseAInsertFromCsvCsvInsert(AInsertFromCsvCsvInsert node);
    void caseACsvOrientationRowOrientation(ACsvOrientationRowOrientation node);
    void caseACsvOrientationColumnOrientation(ACsvOrientationColumnOrientation node);
    void caseAIndexingIndexing(AIndexingIndexing node);
    void caseAIndexing(AIndexing node);
    void caseAArrayExprValPrimeArrayExpr(AArrayExprValPrimeArrayExpr node);
    void caseAArrayExprPrimeExtraArrayExprPrime(AArrayExprPrimeExtraArrayExprPrime node);
    void caseAArrayExprPrime(AArrayExprPrime node);
    void caseAArrayOperationAddArrayOp(AArrayOperationAddArrayOp node);
    void caseAArrayOperationRemoveArrayOp(AArrayOperationRemoveArrayOp node);
    void caseAArrayOperationRemoveAtArrayOp(AArrayOperationRemoveAtArrayOp node);
    void caseAArrayOperationInsertArrayOp(AArrayOperationInsertArrayOp node);
    void caseAAddToArrayArrayAdd(AAddToArrayArrayAdd node);
    void caseARemoveFromArrayArrayRemove(ARemoveFromArrayArrayRemove node);
    void caseARemoveAtFromArrayArrayRemoveAt(ARemoveAtFromArrayArrayRemoveAt node);
    void caseAInsertToArrayArrayInsert(AInsertToArrayArrayInsert node);
    void caseAValIdVal(AValIdVal node);
    void caseAValFloatnumVal(AValFloatnumVal node);
    void caseAValIntnumVal(AValIntnumVal node);
    void caseAValStringVal(AValStringVal node);
    void caseAValBoolVal(AValBoolVal node);
    void caseAPlusInfixBinInfixOp(APlusInfixBinInfixOp node);
    void caseAMinusInfixBinInfixOp(AMinusInfixBinInfixOp node);
    void caseAMultiplicationInfixBinInfixOp(AMultiplicationInfixBinInfixOp node);
    void caseADivisionInfixBinInfixOp(ADivisionInfixBinInfixOp node);
    void caseAModuloInfixBinInfixOp(AModuloInfixBinInfixOp node);
    void caseAAndInfixBinInfixOp(AAndInfixBinInfixOp node);
    void caseAOrInfixBinInfixOp(AOrInfixBinInfixOp node);
    void caseAEqualityInfixBinInfixOp(AEqualityInfixBinInfixOp node);
    void caseAGreaterThanInfixBinInfixOp(AGreaterThanInfixBinInfixOp node);
    void caseAGreaterThanEqualInfixBinInfixOp(AGreaterThanEqualInfixBinInfixOp node);
    void caseALessThanInfixBinInfixOp(ALessThanInfixBinInfixOp node);
    void caseALessThanEqualInfixBinInfixOp(ALessThanEqualInfixBinInfixOp node);
    void caseASpeicalExpressionSpecialExpr(ASpeicalExpressionSpecialExpr node);
    void caseASpecialExprPrimeSpecialExprPrime(ASpecialExprPrimeSpecialExprPrime node);
    void caseASpecialExprPrime(ASpecialExprPrime node);
    void caseASumOpSpecialSyntax(ASumOpSpecialSyntax node);
    void caseAFilterOpSpecialSyntax(AFilterOpSpecialSyntax node);
    void caseAGroupbyOpSpecialSyntax(AGroupbyOpSpecialSyntax node);
    void caseAMeanOpSpecialSyntax(AMeanOpSpecialSyntax node);
    void caseACountOpSpecialSyntax(ACountOpSpecialSyntax node);
    void caseASortOpSpecialSyntax(ASortOpSpecialSyntax node);
    void caseASumSum(ASumSum node);
    void caseAFilterFilter(AFilterFilter node);
    void caseAGroupbyGroupby(AGroupbyGroupby node);
    void caseAMeanMean(AMeanMean node);
    void caseACountCount(ACountCount node);
    void caseASortAscSort(ASortAscSort node);
    void caseASortDescSort(ASortDescSort node);
    void caseASortSort(ASortSort node);
    void caseAImportWithoutSeperatorImport(AImportWithoutSeperatorImport node);
    void caseAImportWithSeperatorImport(AImportWithSeperatorImport node);

    void caseTNewline(TNewline node);
    void caseTComment(TComment node);
    void caseTLPar(TLPar node);
    void caseTRPar(TRPar node);
    void caseTLCbrack(TLCbrack node);
    void caseTRCbrack(TRCbrack node);
    void caseTLBrack(TLBrack node);
    void caseTRBrack(TRBrack node);
    void caseTString(TString node);
    void caseTIntnum(TIntnum node);
    void caseTFloatnum(TFloatnum node);
    void caseTBool(TBool node);
    void caseTType(TType node);
    void caseTChar(TChar node);
    void caseTId(TId node);
    void caseTBlank(TBlank node);
    void caseTOpAssign(TOpAssign node);
    void caseTOpPlus(TOpPlus node);
    void caseTOpMinus(TOpMinus node);
    void caseTOpMult(TOpMult node);
    void caseTOpDiv(TOpDiv node);
    void caseTOpMod(TOpMod node);
    void caseTBopLthan(TBopLthan node);
    void caseTBopLethan(TBopLethan node);
    void caseTBopGthan(TBopGthan node);
    void caseTBopGethan(TBopGethan node);
    void caseTBopEq(TBopEq node);
    void caseTBopAnd(TBopAnd node);
    void caseTBopOr(TBopOr node);
    void caseTBopNot(TBopNot node);
    void caseTSopDot(TSopDot node);
    void caseTSopComma(TSopComma node);
    void caseTSopSum(TSopSum node);
    void caseTSopFilter(TSopFilter node);
    void caseTSopGroupby(TSopGroupby node);
    void caseTSopMean(TSopMean node);
    void caseTSopSort(TSopSort node);
    void caseTSopCount(TSopCount node);
    void caseTKwAs(TKwAs node);
    void caseTKwImport(TKwImport node);
    void caseTKwExport(TKwExport node);
    void caseTKwPrint(TKwPrint node);
    void caseTKwSeparatedBy(TKwSeparatedBy node);
    void caseTKwFor(TKwFor node);
    void caseTKwWhile(TKwWhile node);
    void caseTKwIn(TKwIn node);
    void caseTKwIf(TKwIf node);
    void caseTKwElse(TKwElse node);
    void caseTKwSortOrderAsc(TKwSortOrderAsc node);
    void caseTKwSortOrderDsc(TKwSortOrderDsc node);
    void caseTKwTo(TKwTo node);
    void caseTKwAdd(TKwAdd node);
    void caseTKwRemove(TKwRemove node);
    void caseTKwRemoveAt(TKwRemoveAt node);
    void caseTKwInsert(TKwInsert node);
    void caseTKwColumn(TKwColumn node);
    void caseTKwRow(TKwRow node);
    void caseEOF(EOF node);
    void caseInvalidToken(InvalidToken node);
}
