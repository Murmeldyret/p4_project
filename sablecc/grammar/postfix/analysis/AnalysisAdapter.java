/* This file was generated by SableCC (http://www.sablecc.org/). */

package postfix.analysis;

import java.util.*;
import postfix.node.*;

public class AnalysisAdapter implements Analysis
{
    private Hashtable<Node,Object> in;
    private Hashtable<Node,Object> out;

    @Override
    public Object getIn(Node node)
    {
        if(this.in == null)
        {
            return null;
        }

        return this.in.get(node);
    }

    @Override
    public void setIn(Node node, Object o)
    {
        if(this.in == null)
        {
            this.in = new Hashtable<Node,Object>(1);
        }

        if(o != null)
        {
            this.in.put(node, o);
        }
        else
        {
            this.in.remove(node);
        }
    }

    @Override
    public Object getOut(Node node)
    {
        if(this.out == null)
        {
            return null;
        }

        return this.out.get(node);
    }

    @Override
    public void setOut(Node node, Object o)
    {
        if(this.out == null)
        {
            this.out = new Hashtable<Node,Object>(1);
        }

        if(o != null)
        {
            this.out.put(node, o);
        }
        else
        {
            this.out.remove(node);
        }
    }

    @Override
    public void caseStart(Start node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAProgramProgram(AProgramProgram node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAStatementsStmts(AStatementsStmts node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAStmts(AStmts node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAImportStmtStmt(AImportStmtStmt node)
    {
        defaultCase(node);
    }

    @Override
    public void caseADeclarationStmt(ADeclarationStmt node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAAssignmentStatementStmt(AAssignmentStatementStmt node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAArrayOperationsStmt(AArrayOperationsStmt node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAForLoopStmt(AForLoopStmt node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAWhileLoopStmt(AWhileLoopStmt node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAControlStatementStmt(AControlStatementStmt node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAPrintStatementStmt(APrintStatementStmt node)
    {
        defaultCase(node);
    }

    @Override
    public void caseACsvOperationStmt(ACsvOperationStmt node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAExportStatementStmt(AExportStatementStmt node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAReturnStatementStmt(AReturnStatementStmt node)
    {
        defaultCase(node);
    }

    @Override
    public void caseABreakStatementStmt(ABreakStatementStmt node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAVariableDeclarationInitializationDcl(AVariableDeclarationInitializationDcl node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAVariableDeclarationDcl(AVariableDeclarationDcl node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAConstDeclarationInitializationDcl(AConstDeclarationInitializationDcl node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAFunctionDeclarationDcl(AFunctionDeclarationDcl node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAFunctionParamFunctionParam(AFunctionParamFunctionParam node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAFunctionParam(AFunctionParam node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAFunctionParamPrimeFunctionParamPrime(AFunctionParamPrimeFunctionParamPrime node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAFunctionParamPrime(AFunctionParamPrime node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAFunctionBodyFunctionBody(AFunctionBodyFunctionBody node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAReturnReturn(AReturnReturn node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAFunctionCallParamFunctionCallParam(AFunctionCallParamFunctionCallParam node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAFunctionCallParam(AFunctionCallParam node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAFunctionCallParamPrimeFunctionCallParamPrime(AFunctionCallParamPrimeFunctionCallParamPrime node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAFunctionCallParamPrime(AFunctionCallParamPrime node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAFunctionCallFunctionCall(AFunctionCallFunctionCall node)
    {
        defaultCase(node);
    }

    @Override
    public void caseABlockStmtBlock(ABlockStmtBlock node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAElifStatementInControlStmt(AElifStatementInControlStmt node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAElseStatementInControlStmt(AElseStatementInControlStmt node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAElseBlockStatementElseStatement(AElseBlockStatementElseStatement node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAElseStatement(AElseStatement node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAAssignAssignment(AAssignAssignment node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAExprValPrimeExpr(AExprValPrimeExpr node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAExprSpecialExpr(AExprSpecialExpr node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAExprArrayExpr(AExprArrayExpr node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAExprPrimeOperatorValPrimeExprPrime(AExprPrimeOperatorValPrimeExprPrime node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAExprPrime(AExprPrime node)
    {
        defaultCase(node);
    }

    @Override
    public void caseACsvOperationAddCsvOp(ACsvOperationAddCsvOp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseACsvOperationRemoveCsvOp(ACsvOperationRemoveCsvOp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseACsvOperationRemoveAtCsvOp(ACsvOperationRemoveAtCsvOp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseACsvOperationInsertCsvOp(ACsvOperationInsertCsvOp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAAddToCsvCsvAdd(AAddToCsvCsvAdd node)
    {
        defaultCase(node);
    }

    @Override
    public void caseARemoveFromCsvCsvRemove(ARemoveFromCsvCsvRemove node)
    {
        defaultCase(node);
    }

    @Override
    public void caseARemoveAtFromCsvCsvRemoveAt(ARemoveAtFromCsvCsvRemoveAt node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAInsertFromCsvCsvInsert(AInsertFromCsvCsvInsert node)
    {
        defaultCase(node);
    }

    @Override
    public void caseACsvOrientationRowOrientation(ACsvOrientationRowOrientation node)
    {
        defaultCase(node);
    }

    @Override
    public void caseACsvOrientationColumnOrientation(ACsvOrientationColumnOrientation node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAIndexingIndexing(AIndexingIndexing node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAIndexing(AIndexing node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAArrayExprValPrimeArrayExpr(AArrayExprValPrimeArrayExpr node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAArrayExprPrimeExtraArrayExprPrime(AArrayExprPrimeExtraArrayExprPrime node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAArrayExprPrime(AArrayExprPrime node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAArrayOperationAddArrayOp(AArrayOperationAddArrayOp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAArrayOperationRemoveArrayOp(AArrayOperationRemoveArrayOp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAArrayOperationRemoveAtArrayOp(AArrayOperationRemoveAtArrayOp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAArrayOperationInsertArrayOp(AArrayOperationInsertArrayOp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAAddToArrayArrayAdd(AAddToArrayArrayAdd node)
    {
        defaultCase(node);
    }

    @Override
    public void caseARemoveFromArrayArrayRemove(ARemoveFromArrayArrayRemove node)
    {
        defaultCase(node);
    }

    @Override
    public void caseARemoveAtFromArrayArrayRemoveAt(ARemoveAtFromArrayArrayRemoveAt node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAInsertToArrayArrayInsert(AInsertToArrayArrayInsert node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAValIdVal(AValIdVal node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAFunctionCallValueVal(AFunctionCallValueVal node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAValFloatnumVal(AValFloatnumVal node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAValIntnumVal(AValIntnumVal node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAValStringVal(AValStringVal node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAValBoolVal(AValBoolVal node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAPlusInfixBinInfixOp(APlusInfixBinInfixOp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAMinusInfixBinInfixOp(AMinusInfixBinInfixOp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAMultiplicationInfixBinInfixOp(AMultiplicationInfixBinInfixOp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseADivisionInfixBinInfixOp(ADivisionInfixBinInfixOp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAModuloInfixBinInfixOp(AModuloInfixBinInfixOp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAAndInfixBinInfixOp(AAndInfixBinInfixOp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAOrInfixBinInfixOp(AOrInfixBinInfixOp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAEqualityInfixBinInfixOp(AEqualityInfixBinInfixOp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAGreaterThanInfixBinInfixOp(AGreaterThanInfixBinInfixOp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAGreaterThanEqualInfixBinInfixOp(AGreaterThanEqualInfixBinInfixOp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseALessThanInfixBinInfixOp(ALessThanInfixBinInfixOp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseALessThanEqualInfixBinInfixOp(ALessThanEqualInfixBinInfixOp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseANotEqualInfixBinInfixOp(ANotEqualInfixBinInfixOp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseASpeicalExpressionSpecialExpr(ASpeicalExpressionSpecialExpr node)
    {
        defaultCase(node);
    }

    @Override
    public void caseASpecialExprPrimeSpecialExprPrime(ASpecialExprPrimeSpecialExprPrime node)
    {
        defaultCase(node);
    }

    @Override
    public void caseASpecialExprPrime(ASpecialExprPrime node)
    {
        defaultCase(node);
    }

    @Override
    public void caseASumOpSpecialSyntax(ASumOpSpecialSyntax node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAFilterOpSpecialSyntax(AFilterOpSpecialSyntax node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAGroupbyOpSpecialSyntax(AGroupbyOpSpecialSyntax node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAMeanOpSpecialSyntax(AMeanOpSpecialSyntax node)
    {
        defaultCase(node);
    }

    @Override
    public void caseACountOpSpecialSyntax(ACountOpSpecialSyntax node)
    {
        defaultCase(node);
    }

    @Override
    public void caseASortOpSpecialSyntax(ASortOpSpecialSyntax node)
    {
        defaultCase(node);
    }

    @Override
    public void caseASumSum(ASumSum node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAFilterFilter(AFilterFilter node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAGroupbyGroupby(AGroupbyGroupby node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAMeanMean(AMeanMean node)
    {
        defaultCase(node);
    }

    @Override
    public void caseACountCount(ACountCount node)
    {
        defaultCase(node);
    }

    @Override
    public void caseASortAscSort(ASortAscSort node)
    {
        defaultCase(node);
    }

    @Override
    public void caseASortDescSort(ASortDescSort node)
    {
        defaultCase(node);
    }

    @Override
    public void caseASortSort(ASortSort node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAImportWithoutSeperatorImport(AImportWithoutSeperatorImport node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAImportWithSeperatorImport(AImportWithSeperatorImport node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTNewline(TNewline node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTComment(TComment node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTLPar(TLPar node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTRPar(TRPar node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTLCbrack(TLCbrack node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTRCbrack(TRCbrack node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTLBrack(TLBrack node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTRBrack(TRBrack node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTString(TString node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTIntnum(TIntnum node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTFloatnum(TFloatnum node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTBool(TBool node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTType(TType node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTChar(TChar node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTId(TId node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTBlank(TBlank node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTOpAssign(TOpAssign node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTOpPlus(TOpPlus node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTOpMinus(TOpMinus node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTOpMult(TOpMult node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTOpDiv(TOpDiv node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTOpMod(TOpMod node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTBopLthan(TBopLthan node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTBopLethan(TBopLethan node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTBopGthan(TBopGthan node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTBopGethan(TBopGethan node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTBopEq(TBopEq node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTBopNeq(TBopNeq node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTBopAnd(TBopAnd node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTBopOr(TBopOr node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTBopNot(TBopNot node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTSopDot(TSopDot node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTSopComma(TSopComma node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTSopSum(TSopSum node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTSopFilter(TSopFilter node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTSopGroupby(TSopGroupby node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTSopMean(TSopMean node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTSopSort(TSopSort node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTSopCount(TSopCount node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTKwAs(TKwAs node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTKwImport(TKwImport node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTKwExport(TKwExport node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTKwPrint(TKwPrint node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTKwSeparatedBy(TKwSeparatedBy node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTKwFor(TKwFor node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTKwWhile(TKwWhile node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTKwIn(TKwIn node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTKwIf(TKwIf node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTKwElse(TKwElse node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTKwSortOrderAsc(TKwSortOrderAsc node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTKwSortOrderDsc(TKwSortOrderDsc node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTKwTo(TKwTo node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTKwConst(TKwConst node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTKwFunction(TKwFunction node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTKwReturn(TKwReturn node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTKwBreak(TKwBreak node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTKwAdd(TKwAdd node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTKwRemove(TKwRemove node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTKwRemoveAt(TKwRemoveAt node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTKwInsert(TKwInsert node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTKwColumn(TKwColumn node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTKwRow(TKwRow node)
    {
        defaultCase(node);
    }

    @Override
    public void caseEOF(EOF node)
    {
        defaultCase(node);
    }

    @Override
    public void caseInvalidToken(InvalidToken node)
    {
        defaultCase(node);
    }

    public void defaultCase(@SuppressWarnings("unused") Node node)
    {
        // do nothing
    }
}
