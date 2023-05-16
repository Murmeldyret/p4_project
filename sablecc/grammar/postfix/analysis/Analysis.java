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
    void caseAImportWithoutSeperatorStmt(AImportWithoutSeperatorStmt node);
    void caseAImportWithSeperatorStmt(AImportWithSeperatorStmt node);
    void caseADeclarationStmt(ADeclarationStmt node);
    void caseAAssignStmt(AAssignStmt node);
    void caseAFunctionCallStmt(AFunctionCallStmt node);
    void caseAArrayOperationsStmt(AArrayOperationsStmt node);
    void caseAForLoopStmt(AForLoopStmt node);
    void caseAWhileLoopStmt(AWhileLoopStmt node);
    void caseAControlStatementStmt(AControlStatementStmt node);
    void caseACsvOperationStmt(ACsvOperationStmt node);
    void caseAPrintStatementStmt(APrintStatementStmt node);
    void caseAExportStatementStmt(AExportStatementStmt node);
    void caseAReturnStmt(AReturnStmt node);
    void caseABreakStatementStmt(ABreakStatementStmt node);
    void caseAVariableDeclarationInitializationDcl(AVariableDeclarationInitializationDcl node);
    void caseAVariableDeclarationArrayDcl(AVariableDeclarationArrayDcl node);
    void caseAVariableDeclarationDcl(AVariableDeclarationDcl node);
    void caseAVariableDeclarationArrayInitDcl(AVariableDeclarationArrayInitDcl node);
    void caseAConstDeclarationInitializationDcl(AConstDeclarationInitializationDcl node);
    void caseAFunctionDeclarationDcl(AFunctionDeclarationDcl node);
    void caseAFunctionParamFunctionParam(AFunctionParamFunctionParam node);
    void caseAFunctionParam(AFunctionParam node);
    void caseAFunctionParamPrimeFunctionParamPrime(AFunctionParamPrimeFunctionParamPrime node);
    void caseAFunctionParamPrime(AFunctionParamPrime node);
    void caseAFunctionCallParamFunctionCallParam(AFunctionCallParamFunctionCallParam node);
    void caseAFunctionCallParam(AFunctionCallParam node);
    void caseAFunctionCallParamPrimeFunctionCallParamPrime(AFunctionCallParamPrimeFunctionCallParamPrime node);
    void caseAFunctionCallParamPrime(AFunctionCallParamPrime node);
    void caseAFunctionCallFunctionCall(AFunctionCallFunctionCall node);
    void caseABlockStmtBlock(ABlockStmtBlock node);
    void caseAElifStatementInControlStmt(AElifStatementInControlStmt node);
    void caseAElseStatementInControlStmt(AElseStatementInControlStmt node);
    void caseAElseBlockStatementElseStatement(AElseBlockStatementElseStatement node);
    void caseAElseStatement(AElseStatement node);
    void caseAExprValPrimeExpr(AExprValPrimeExpr node);
    void caseAExprSpecialExpr(AExprSpecialExpr node);
    void caseAExprArrayExpr(AExprArrayExpr node);
    void caseAExprPrimeOperatorValPrimeExprPrime(AExprPrimeOperatorValPrimeExprPrime node);
    void caseAExprPrime(AExprPrime node);
    void caseAAddToCsvCsvOp(AAddToCsvCsvOp node);
    void caseARemoveFromCsvCsvOp(ARemoveFromCsvCsvOp node);
    void caseARemoveAtFromCsvCsvOp(ARemoveAtFromCsvCsvOp node);
    void caseAInsertFromCsvCsvOp(AInsertFromCsvCsvOp node);
    void caseACsvOrientationRowOrientation(ACsvOrientationRowOrientation node);
    void caseACsvOrientationColumnOrientation(ACsvOrientationColumnOrientation node);
    void caseAIndexingIndexing(AIndexingIndexing node);
    void caseAIndexing(AIndexing node);
    void caseAArrayExprValPrimeArrayExpr(AArrayExprValPrimeArrayExpr node);
    void caseAArrayExprPrimeExtraArrayExprPrime(AArrayExprPrimeExtraArrayExprPrime node);
    void caseAArrayExprPrime(AArrayExprPrime node);
    void caseAAddToArrayArrayOp(AAddToArrayArrayOp node);
    void caseARemoveFromArrayArrayOp(ARemoveFromArrayArrayOp node);
    void caseARemoveAtFromArrayArrayOp(ARemoveAtFromArrayArrayOp node);
    void caseAInsertToArrayArrayOp(AInsertToArrayArrayOp node);
    void caseAValIdVal(AValIdVal node);
    void caseAValFunctionCallVal(AValFunctionCallVal node);
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
    void caseANotEqualInfixBinInfixOp(ANotEqualInfixBinInfixOp node);
    void caseASpeicalExpressionSpecialExpr(ASpeicalExpressionSpecialExpr node);
    void caseASpecialExprPrimeSpecialExprPrime(ASpecialExprPrimeSpecialExprPrime node);
    void caseASpecialExprPrime(ASpecialExprPrime node);
    void caseASumSpecialSyntax(ASumSpecialSyntax node);
    void caseAFilterSpecialSyntax(AFilterSpecialSyntax node);
    void caseAGroupbySpecialSyntax(AGroupbySpecialSyntax node);
    void caseAMeanSpecialSyntax(AMeanSpecialSyntax node);
    void caseACountSpecialSyntax(ACountSpecialSyntax node);
    void caseASortAscSpecialSyntax(ASortAscSpecialSyntax node);
    void caseASortDescSpecialSyntax(ASortDescSpecialSyntax node);
    void caseASortSpecialSyntax(ASortSpecialSyntax node);

    void caseTNewline(TNewline node);
    void caseTSemi(TSemi node);
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
    void caseTKwConst(TKwConst node);
    void caseTKwFunction(TKwFunction node);
    void caseTKwReturn(TKwReturn node);
    void caseTKwBreak(TKwBreak node);
    void caseTKwArray(TKwArray node);
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
    void caseTBopNeq(TBopNeq node);
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
    void caseTKwAdd(TKwAdd node);
    void caseTKwRemoveLast(TKwRemoveLast node);
    void caseTKwRemoveAt(TKwRemoveAt node);
    void caseTKwInsert(TKwInsert node);
    void caseTKwColumn(TKwColumn node);
    void caseTKwRow(TKwRow node);
    void caseTId(TId node);
    void caseEOF(EOF node);
    void caseInvalidToken(InvalidToken node);
}
