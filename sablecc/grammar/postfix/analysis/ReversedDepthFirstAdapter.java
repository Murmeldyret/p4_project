/* This file was generated by SableCC (http://www.sablecc.org/). */

package postfix.analysis;

import java.util.*;
import postfix.node.*;

public class ReversedDepthFirstAdapter extends AnalysisAdapter
{
    public void inStart(Start node)
    {
        defaultIn(node);
    }

    public void outStart(Start node)
    {
        defaultOut(node);
    }

    public void defaultIn(@SuppressWarnings("unused") Node node)
    {
        // Do nothing
    }

    public void defaultOut(@SuppressWarnings("unused") Node node)
    {
        // Do nothing
    }

    @Override
    public void caseStart(Start node)
    {
        inStart(node);
        node.getEOF().apply(this);
        node.getPProgram().apply(this);
        outStart(node);
    }

    public void inAProgramProgram(AProgramProgram node)
    {
        defaultIn(node);
    }

    public void outAProgramProgram(AProgramProgram node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAProgramProgram(AProgramProgram node)
    {
        inAProgramProgram(node);
        if(node.getStmts() != null)
        {
            node.getStmts().apply(this);
        }
        outAProgramProgram(node);
    }

    public void inAStatementsStmts(AStatementsStmts node)
    {
        defaultIn(node);
    }

    public void outAStatementsStmts(AStatementsStmts node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAStatementsStmts(AStatementsStmts node)
    {
        inAStatementsStmts(node);
        if(node.getStmts() != null)
        {
            node.getStmts().apply(this);
        }
        if(node.getNewline() != null)
        {
            node.getNewline().apply(this);
        }
        if(node.getStmt() != null)
        {
            node.getStmt().apply(this);
        }
        outAStatementsStmts(node);
    }

    public void inAStmts(AStmts node)
    {
        defaultIn(node);
    }

    public void outAStmts(AStmts node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAStmts(AStmts node)
    {
        inAStmts(node);
        outAStmts(node);
    }

    public void inAImportStmtStmt(AImportStmtStmt node)
    {
        defaultIn(node);
    }

    public void outAImportStmtStmt(AImportStmtStmt node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAImportStmtStmt(AImportStmtStmt node)
    {
        inAImportStmtStmt(node);
        if(node.getImportT() != null)
        {
            node.getImportT().apply(this);
        }
        outAImportStmtStmt(node);
    }

    public void inADeclarationStmt(ADeclarationStmt node)
    {
        defaultIn(node);
    }

    public void outADeclarationStmt(ADeclarationStmt node)
    {
        defaultOut(node);
    }

    @Override
    public void caseADeclarationStmt(ADeclarationStmt node)
    {
        inADeclarationStmt(node);
        if(node.getExpr() != null)
        {
            node.getExpr().apply(this);
        }
        if(node.getOpAssign() != null)
        {
            node.getOpAssign().apply(this);
        }
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        if(node.getType() != null)
        {
            node.getType().apply(this);
        }
        outADeclarationStmt(node);
    }

    public void inAAssignmentStatementStmt(AAssignmentStatementStmt node)
    {
        defaultIn(node);
    }

    public void outAAssignmentStatementStmt(AAssignmentStatementStmt node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAAssignmentStatementStmt(AAssignmentStatementStmt node)
    {
        inAAssignmentStatementStmt(node);
        if(node.getAssignment() != null)
        {
            node.getAssignment().apply(this);
        }
        outAAssignmentStatementStmt(node);
    }

    public void inAForLoopStmt(AForLoopStmt node)
    {
        defaultIn(node);
    }

    public void outAForLoopStmt(AForLoopStmt node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAForLoopStmt(AForLoopStmt node)
    {
        inAForLoopStmt(node);
        if(node.getBlock() != null)
        {
            node.getBlock().apply(this);
        }
        if(node.getVal() != null)
        {
            node.getVal().apply(this);
        }
        if(node.getKwIn() != null)
        {
            node.getKwIn().apply(this);
        }
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        if(node.getKwFor() != null)
        {
            node.getKwFor().apply(this);
        }
        outAForLoopStmt(node);
    }

    public void inAWhileLoopStmt(AWhileLoopStmt node)
    {
        defaultIn(node);
    }

    public void outAWhileLoopStmt(AWhileLoopStmt node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAWhileLoopStmt(AWhileLoopStmt node)
    {
        inAWhileLoopStmt(node);
        if(node.getBlock() != null)
        {
            node.getBlock().apply(this);
        }
        if(node.getExpr() != null)
        {
            node.getExpr().apply(this);
        }
        if(node.getKwWhile() != null)
        {
            node.getKwWhile().apply(this);
        }
        outAWhileLoopStmt(node);
    }

    public void inAControlStatementStmt(AControlStatementStmt node)
    {
        defaultIn(node);
    }

    public void outAControlStatementStmt(AControlStatementStmt node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAControlStatementStmt(AControlStatementStmt node)
    {
        inAControlStatementStmt(node);
        if(node.getInControlStmt() != null)
        {
            node.getInControlStmt().apply(this);
        }
        if(node.getBlock() != null)
        {
            node.getBlock().apply(this);
        }
        if(node.getExpr() != null)
        {
            node.getExpr().apply(this);
        }
        if(node.getKwIf() != null)
        {
            node.getKwIf().apply(this);
        }
        outAControlStatementStmt(node);
    }

    public void inABlockStmtBlock(ABlockStmtBlock node)
    {
        defaultIn(node);
    }

    public void outABlockStmtBlock(ABlockStmtBlock node)
    {
        defaultOut(node);
    }

    @Override
    public void caseABlockStmtBlock(ABlockStmtBlock node)
    {
        inABlockStmtBlock(node);
        if(node.getRCbrack() != null)
        {
            node.getRCbrack().apply(this);
        }
        if(node.getStmts() != null)
        {
            node.getStmts().apply(this);
        }
        if(node.getLCbrack() != null)
        {
            node.getLCbrack().apply(this);
        }
        outABlockStmtBlock(node);
    }

    public void inAElifStatementInControlStmt(AElifStatementInControlStmt node)
    {
        defaultIn(node);
    }

    public void outAElifStatementInControlStmt(AElifStatementInControlStmt node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAElifStatementInControlStmt(AElifStatementInControlStmt node)
    {
        inAElifStatementInControlStmt(node);
        if(node.getBlock() != null)
        {
            node.getBlock().apply(this);
        }
        if(node.getExpr() != null)
        {
            node.getExpr().apply(this);
        }
        if(node.getKwIf() != null)
        {
            node.getKwIf().apply(this);
        }
        if(node.getKwElse() != null)
        {
            node.getKwElse().apply(this);
        }
        outAElifStatementInControlStmt(node);
    }

    public void inAElseStatementInControlStmt(AElseStatementInControlStmt node)
    {
        defaultIn(node);
    }

    public void outAElseStatementInControlStmt(AElseStatementInControlStmt node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAElseStatementInControlStmt(AElseStatementInControlStmt node)
    {
        inAElseStatementInControlStmt(node);
        if(node.getElseStatement() != null)
        {
            node.getElseStatement().apply(this);
        }
        outAElseStatementInControlStmt(node);
    }

    public void inAElseBlockStatementElseStatement(AElseBlockStatementElseStatement node)
    {
        defaultIn(node);
    }

    public void outAElseBlockStatementElseStatement(AElseBlockStatementElseStatement node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAElseBlockStatementElseStatement(AElseBlockStatementElseStatement node)
    {
        inAElseBlockStatementElseStatement(node);
        if(node.getBlock() != null)
        {
            node.getBlock().apply(this);
        }
        if(node.getKwElse() != null)
        {
            node.getKwElse().apply(this);
        }
        outAElseBlockStatementElseStatement(node);
    }

    public void inAElseStatement(AElseStatement node)
    {
        defaultIn(node);
    }

    public void outAElseStatement(AElseStatement node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAElseStatement(AElseStatement node)
    {
        inAElseStatement(node);
        outAElseStatement(node);
    }

    public void inAAssignAssignment(AAssignAssignment node)
    {
        defaultIn(node);
    }

    public void outAAssignAssignment(AAssignAssignment node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAAssignAssignment(AAssignAssignment node)
    {
        inAAssignAssignment(node);
        if(node.getExpr() != null)
        {
            node.getExpr().apply(this);
        }
        if(node.getOpAssign() != null)
        {
            node.getOpAssign().apply(this);
        }
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        outAAssignAssignment(node);
    }

    public void inAExprValPrimeExpr(AExprValPrimeExpr node)
    {
        defaultIn(node);
    }

    public void outAExprValPrimeExpr(AExprValPrimeExpr node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAExprValPrimeExpr(AExprValPrimeExpr node)
    {
        inAExprValPrimeExpr(node);
        if(node.getExprPrime() != null)
        {
            node.getExprPrime().apply(this);
        }
        if(node.getVal() != null)
        {
            node.getVal().apply(this);
        }
        if(node.getBopNot() != null)
        {
            node.getBopNot().apply(this);
        }
        outAExprValPrimeExpr(node);
    }

    public void inAExprSpecialExpr(AExprSpecialExpr node)
    {
        defaultIn(node);
    }

    public void outAExprSpecialExpr(AExprSpecialExpr node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAExprSpecialExpr(AExprSpecialExpr node)
    {
        inAExprSpecialExpr(node);
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        if(node.getSpecialExpr() != null)
        {
            node.getSpecialExpr().apply(this);
        }
        outAExprSpecialExpr(node);
    }

    public void inAExprPrimeOperatorValPrimeExprPrime(AExprPrimeOperatorValPrimeExprPrime node)
    {
        defaultIn(node);
    }

    public void outAExprPrimeOperatorValPrimeExprPrime(AExprPrimeOperatorValPrimeExprPrime node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAExprPrimeOperatorValPrimeExprPrime(AExprPrimeOperatorValPrimeExprPrime node)
    {
        inAExprPrimeOperatorValPrimeExprPrime(node);
        if(node.getExprPrime() != null)
        {
            node.getExprPrime().apply(this);
        }
        if(node.getVal() != null)
        {
            node.getVal().apply(this);
        }
        if(node.getBinInfixOp() != null)
        {
            node.getBinInfixOp().apply(this);
        }
        outAExprPrimeOperatorValPrimeExprPrime(node);
    }

    public void inAExprPrime(AExprPrime node)
    {
        defaultIn(node);
    }

    public void outAExprPrime(AExprPrime node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAExprPrime(AExprPrime node)
    {
        inAExprPrime(node);
        outAExprPrime(node);
    }

    public void inAValIdVal(AValIdVal node)
    {
        defaultIn(node);
    }

    public void outAValIdVal(AValIdVal node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAValIdVal(AValIdVal node)
    {
        inAValIdVal(node);
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        outAValIdVal(node);
    }

    public void inAValFloatnumVal(AValFloatnumVal node)
    {
        defaultIn(node);
    }

    public void outAValFloatnumVal(AValFloatnumVal node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAValFloatnumVal(AValFloatnumVal node)
    {
        inAValFloatnumVal(node);
        if(node.getFloatnum() != null)
        {
            node.getFloatnum().apply(this);
        }
        outAValFloatnumVal(node);
    }

    public void inAValIntnumVal(AValIntnumVal node)
    {
        defaultIn(node);
    }

    public void outAValIntnumVal(AValIntnumVal node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAValIntnumVal(AValIntnumVal node)
    {
        inAValIntnumVal(node);
        if(node.getIntnum() != null)
        {
            node.getIntnum().apply(this);
        }
        outAValIntnumVal(node);
    }

    public void inAValStringVal(AValStringVal node)
    {
        defaultIn(node);
    }

    public void outAValStringVal(AValStringVal node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAValStringVal(AValStringVal node)
    {
        inAValStringVal(node);
        if(node.getString() != null)
        {
            node.getString().apply(this);
        }
        outAValStringVal(node);
    }

    public void inAValBoolVal(AValBoolVal node)
    {
        defaultIn(node);
    }

    public void outAValBoolVal(AValBoolVal node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAValBoolVal(AValBoolVal node)
    {
        inAValBoolVal(node);
        if(node.getBool() != null)
        {
            node.getBool().apply(this);
        }
        outAValBoolVal(node);
    }

    public void inAPlusInfixBinInfixOp(APlusInfixBinInfixOp node)
    {
        defaultIn(node);
    }

    public void outAPlusInfixBinInfixOp(APlusInfixBinInfixOp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAPlusInfixBinInfixOp(APlusInfixBinInfixOp node)
    {
        inAPlusInfixBinInfixOp(node);
        if(node.getOpPlus() != null)
        {
            node.getOpPlus().apply(this);
        }
        outAPlusInfixBinInfixOp(node);
    }

    public void inAMinusInfixBinInfixOp(AMinusInfixBinInfixOp node)
    {
        defaultIn(node);
    }

    public void outAMinusInfixBinInfixOp(AMinusInfixBinInfixOp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAMinusInfixBinInfixOp(AMinusInfixBinInfixOp node)
    {
        inAMinusInfixBinInfixOp(node);
        if(node.getOpMinus() != null)
        {
            node.getOpMinus().apply(this);
        }
        outAMinusInfixBinInfixOp(node);
    }

    public void inAMultiplicationInfixBinInfixOp(AMultiplicationInfixBinInfixOp node)
    {
        defaultIn(node);
    }

    public void outAMultiplicationInfixBinInfixOp(AMultiplicationInfixBinInfixOp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAMultiplicationInfixBinInfixOp(AMultiplicationInfixBinInfixOp node)
    {
        inAMultiplicationInfixBinInfixOp(node);
        if(node.getOpMult() != null)
        {
            node.getOpMult().apply(this);
        }
        outAMultiplicationInfixBinInfixOp(node);
    }

    public void inADivisionInfixBinInfixOp(ADivisionInfixBinInfixOp node)
    {
        defaultIn(node);
    }

    public void outADivisionInfixBinInfixOp(ADivisionInfixBinInfixOp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseADivisionInfixBinInfixOp(ADivisionInfixBinInfixOp node)
    {
        inADivisionInfixBinInfixOp(node);
        if(node.getOpDiv() != null)
        {
            node.getOpDiv().apply(this);
        }
        outADivisionInfixBinInfixOp(node);
    }

    public void inAModuloInfixBinInfixOp(AModuloInfixBinInfixOp node)
    {
        defaultIn(node);
    }

    public void outAModuloInfixBinInfixOp(AModuloInfixBinInfixOp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAModuloInfixBinInfixOp(AModuloInfixBinInfixOp node)
    {
        inAModuloInfixBinInfixOp(node);
        if(node.getOpMod() != null)
        {
            node.getOpMod().apply(this);
        }
        outAModuloInfixBinInfixOp(node);
    }

    public void inAAndInfixBinInfixOp(AAndInfixBinInfixOp node)
    {
        defaultIn(node);
    }

    public void outAAndInfixBinInfixOp(AAndInfixBinInfixOp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAAndInfixBinInfixOp(AAndInfixBinInfixOp node)
    {
        inAAndInfixBinInfixOp(node);
        if(node.getBopAnd() != null)
        {
            node.getBopAnd().apply(this);
        }
        outAAndInfixBinInfixOp(node);
    }

    public void inAOrInfixBinInfixOp(AOrInfixBinInfixOp node)
    {
        defaultIn(node);
    }

    public void outAOrInfixBinInfixOp(AOrInfixBinInfixOp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAOrInfixBinInfixOp(AOrInfixBinInfixOp node)
    {
        inAOrInfixBinInfixOp(node);
        if(node.getBopOr() != null)
        {
            node.getBopOr().apply(this);
        }
        outAOrInfixBinInfixOp(node);
    }

    public void inAEqualityInfixBinInfixOp(AEqualityInfixBinInfixOp node)
    {
        defaultIn(node);
    }

    public void outAEqualityInfixBinInfixOp(AEqualityInfixBinInfixOp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAEqualityInfixBinInfixOp(AEqualityInfixBinInfixOp node)
    {
        inAEqualityInfixBinInfixOp(node);
        if(node.getBopEq() != null)
        {
            node.getBopEq().apply(this);
        }
        outAEqualityInfixBinInfixOp(node);
    }

    public void inAGreaterThanInfixBinInfixOp(AGreaterThanInfixBinInfixOp node)
    {
        defaultIn(node);
    }

    public void outAGreaterThanInfixBinInfixOp(AGreaterThanInfixBinInfixOp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAGreaterThanInfixBinInfixOp(AGreaterThanInfixBinInfixOp node)
    {
        inAGreaterThanInfixBinInfixOp(node);
        if(node.getBopGthan() != null)
        {
            node.getBopGthan().apply(this);
        }
        outAGreaterThanInfixBinInfixOp(node);
    }

    public void inAGreaterThanEqualInfixBinInfixOp(AGreaterThanEqualInfixBinInfixOp node)
    {
        defaultIn(node);
    }

    public void outAGreaterThanEqualInfixBinInfixOp(AGreaterThanEqualInfixBinInfixOp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAGreaterThanEqualInfixBinInfixOp(AGreaterThanEqualInfixBinInfixOp node)
    {
        inAGreaterThanEqualInfixBinInfixOp(node);
        if(node.getBopGethan() != null)
        {
            node.getBopGethan().apply(this);
        }
        outAGreaterThanEqualInfixBinInfixOp(node);
    }

    public void inALessThanInfixBinInfixOp(ALessThanInfixBinInfixOp node)
    {
        defaultIn(node);
    }

    public void outALessThanInfixBinInfixOp(ALessThanInfixBinInfixOp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseALessThanInfixBinInfixOp(ALessThanInfixBinInfixOp node)
    {
        inALessThanInfixBinInfixOp(node);
        if(node.getBopLthan() != null)
        {
            node.getBopLthan().apply(this);
        }
        outALessThanInfixBinInfixOp(node);
    }

    public void inALessThanEqualInfixBinInfixOp(ALessThanEqualInfixBinInfixOp node)
    {
        defaultIn(node);
    }

    public void outALessThanEqualInfixBinInfixOp(ALessThanEqualInfixBinInfixOp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseALessThanEqualInfixBinInfixOp(ALessThanEqualInfixBinInfixOp node)
    {
        inALessThanEqualInfixBinInfixOp(node);
        if(node.getBopLethan() != null)
        {
            node.getBopLethan().apply(this);
        }
        outALessThanEqualInfixBinInfixOp(node);
    }

    public void inASpeicalExpressionSpecialExpr(ASpeicalExpressionSpecialExpr node)
    {
        defaultIn(node);
    }

    public void outASpeicalExpressionSpecialExpr(ASpeicalExpressionSpecialExpr node)
    {
        defaultOut(node);
    }

    @Override
    public void caseASpeicalExpressionSpecialExpr(ASpeicalExpressionSpecialExpr node)
    {
        inASpeicalExpressionSpecialExpr(node);
        if(node.getSpecialExprPrime() != null)
        {
            node.getSpecialExprPrime().apply(this);
        }
        if(node.getSpecialSyntax() != null)
        {
            node.getSpecialSyntax().apply(this);
        }
        outASpeicalExpressionSpecialExpr(node);
    }

    public void inASpecialExprPrimeSpecialExprPrime(ASpecialExprPrimeSpecialExprPrime node)
    {
        defaultIn(node);
    }

    public void outASpecialExprPrimeSpecialExprPrime(ASpecialExprPrimeSpecialExprPrime node)
    {
        defaultOut(node);
    }

    @Override
    public void caseASpecialExprPrimeSpecialExprPrime(ASpecialExprPrimeSpecialExprPrime node)
    {
        inASpecialExprPrimeSpecialExprPrime(node);
        if(node.getSpecialExprPrime() != null)
        {
            node.getSpecialExprPrime().apply(this);
        }
        if(node.getSpecialSyntax() != null)
        {
            node.getSpecialSyntax().apply(this);
        }
        outASpecialExprPrimeSpecialExprPrime(node);
    }

    public void inASpecialExprPrime(ASpecialExprPrime node)
    {
        defaultIn(node);
    }

    public void outASpecialExprPrime(ASpecialExprPrime node)
    {
        defaultOut(node);
    }

    @Override
    public void caseASpecialExprPrime(ASpecialExprPrime node)
    {
        inASpecialExprPrime(node);
        outASpecialExprPrime(node);
    }

    public void inASumOpSpecialSyntax(ASumOpSpecialSyntax node)
    {
        defaultIn(node);
    }

    public void outASumOpSpecialSyntax(ASumOpSpecialSyntax node)
    {
        defaultOut(node);
    }

    @Override
    public void caseASumOpSpecialSyntax(ASumOpSpecialSyntax node)
    {
        inASumOpSpecialSyntax(node);
        if(node.getSopSum() != null)
        {
            node.getSopSum().apply(this);
        }
        outASumOpSpecialSyntax(node);
    }

    public void inAFilterOpSpecialSyntax(AFilterOpSpecialSyntax node)
    {
        defaultIn(node);
    }

    public void outAFilterOpSpecialSyntax(AFilterOpSpecialSyntax node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAFilterOpSpecialSyntax(AFilterOpSpecialSyntax node)
    {
        inAFilterOpSpecialSyntax(node);
        if(node.getSopFilter() != null)
        {
            node.getSopFilter().apply(this);
        }
        outAFilterOpSpecialSyntax(node);
    }

    public void inAGroupbyOpSpecialSyntax(AGroupbyOpSpecialSyntax node)
    {
        defaultIn(node);
    }

    public void outAGroupbyOpSpecialSyntax(AGroupbyOpSpecialSyntax node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAGroupbyOpSpecialSyntax(AGroupbyOpSpecialSyntax node)
    {
        inAGroupbyOpSpecialSyntax(node);
        if(node.getSopGroupby() != null)
        {
            node.getSopGroupby().apply(this);
        }
        outAGroupbyOpSpecialSyntax(node);
    }

    public void inAMeanOpSpecialSyntax(AMeanOpSpecialSyntax node)
    {
        defaultIn(node);
    }

    public void outAMeanOpSpecialSyntax(AMeanOpSpecialSyntax node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAMeanOpSpecialSyntax(AMeanOpSpecialSyntax node)
    {
        inAMeanOpSpecialSyntax(node);
        if(node.getSopMean() != null)
        {
            node.getSopMean().apply(this);
        }
        outAMeanOpSpecialSyntax(node);
    }

    public void inACountOpSpecialSyntax(ACountOpSpecialSyntax node)
    {
        defaultIn(node);
    }

    public void outACountOpSpecialSyntax(ACountOpSpecialSyntax node)
    {
        defaultOut(node);
    }

    @Override
    public void caseACountOpSpecialSyntax(ACountOpSpecialSyntax node)
    {
        inACountOpSpecialSyntax(node);
        if(node.getSopCount() != null)
        {
            node.getSopCount().apply(this);
        }
        outACountOpSpecialSyntax(node);
    }

    public void inASortOpSpecialSyntax(ASortOpSpecialSyntax node)
    {
        defaultIn(node);
    }

    public void outASortOpSpecialSyntax(ASortOpSpecialSyntax node)
    {
        defaultOut(node);
    }

    @Override
    public void caseASortOpSpecialSyntax(ASortOpSpecialSyntax node)
    {
        inASortOpSpecialSyntax(node);
        if(node.getSopSort() != null)
        {
            node.getSopSort().apply(this);
        }
        outASortOpSpecialSyntax(node);
    }

    public void inASumSum(ASumSum node)
    {
        defaultIn(node);
    }

    public void outASumSum(ASumSum node)
    {
        defaultOut(node);
    }

    @Override
    public void caseASumSum(ASumSum node)
    {
        inASumSum(node);
        if(node.getSopSum() != null)
        {
            node.getSopSum().apply(this);
        }
        outASumSum(node);
    }

    public void inAFilterFilter(AFilterFilter node)
    {
        defaultIn(node);
    }

    public void outAFilterFilter(AFilterFilter node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAFilterFilter(AFilterFilter node)
    {
        inAFilterFilter(node);
        if(node.getRPar() != null)
        {
            node.getRPar().apply(this);
        }
        if(node.getExpr() != null)
        {
            node.getExpr().apply(this);
        }
        if(node.getLPar() != null)
        {
            node.getLPar().apply(this);
        }
        if(node.getSopFilter() != null)
        {
            node.getSopFilter().apply(this);
        }
        outAFilterFilter(node);
    }

    public void inAGroupbyGroupby(AGroupbyGroupby node)
    {
        defaultIn(node);
    }

    public void outAGroupbyGroupby(AGroupbyGroupby node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAGroupbyGroupby(AGroupbyGroupby node)
    {
        inAGroupbyGroupby(node);
        if(node.getRPar() != null)
        {
            node.getRPar().apply(this);
        }
        if(node.getExpr() != null)
        {
            node.getExpr().apply(this);
        }
        if(node.getLPar() != null)
        {
            node.getLPar().apply(this);
        }
        if(node.getSopGroupby() != null)
        {
            node.getSopGroupby().apply(this);
        }
        outAGroupbyGroupby(node);
    }

    public void inAMeanMean(AMeanMean node)
    {
        defaultIn(node);
    }

    public void outAMeanMean(AMeanMean node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAMeanMean(AMeanMean node)
    {
        inAMeanMean(node);
        if(node.getRPar() != null)
        {
            node.getRPar().apply(this);
        }
        if(node.getExpr() != null)
        {
            node.getExpr().apply(this);
        }
        if(node.getLPar() != null)
        {
            node.getLPar().apply(this);
        }
        if(node.getSopMean() != null)
        {
            node.getSopMean().apply(this);
        }
        outAMeanMean(node);
    }

    public void inACountCount(ACountCount node)
    {
        defaultIn(node);
    }

    public void outACountCount(ACountCount node)
    {
        defaultOut(node);
    }

    @Override
    public void caseACountCount(ACountCount node)
    {
        inACountCount(node);
        if(node.getRPar() != null)
        {
            node.getRPar().apply(this);
        }
        if(node.getExpr() != null)
        {
            node.getExpr().apply(this);
        }
        if(node.getLPar() != null)
        {
            node.getLPar().apply(this);
        }
        if(node.getSopCount() != null)
        {
            node.getSopCount().apply(this);
        }
        outACountCount(node);
    }

    public void inASortAscSort(ASortAscSort node)
    {
        defaultIn(node);
    }

    public void outASortAscSort(ASortAscSort node)
    {
        defaultOut(node);
    }

    @Override
    public void caseASortAscSort(ASortAscSort node)
    {
        inASortAscSort(node);
        if(node.getKwSortOrderAsc() != null)
        {
            node.getKwSortOrderAsc().apply(this);
        }
        if(node.getSopSort() != null)
        {
            node.getSopSort().apply(this);
        }
        outASortAscSort(node);
    }

    public void inASortDescSort(ASortDescSort node)
    {
        defaultIn(node);
    }

    public void outASortDescSort(ASortDescSort node)
    {
        defaultOut(node);
    }

    @Override
    public void caseASortDescSort(ASortDescSort node)
    {
        inASortDescSort(node);
        if(node.getKwSortOrderDsc() != null)
        {
            node.getKwSortOrderDsc().apply(this);
        }
        if(node.getSopSort() != null)
        {
            node.getSopSort().apply(this);
        }
        outASortDescSort(node);
    }

    public void inASortSort(ASortSort node)
    {
        defaultIn(node);
    }

    public void outASortSort(ASortSort node)
    {
        defaultOut(node);
    }

    @Override
    public void caseASortSort(ASortSort node)
    {
        inASortSort(node);
        if(node.getSopSort() != null)
        {
            node.getSopSort().apply(this);
        }
        outASortSort(node);
    }

    public void inAImportWithoutSeperatorImportT(AImportWithoutSeperatorImportT node)
    {
        defaultIn(node);
    }

    public void outAImportWithoutSeperatorImportT(AImportWithoutSeperatorImportT node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAImportWithoutSeperatorImportT(AImportWithoutSeperatorImportT node)
    {
        inAImportWithoutSeperatorImportT(node);
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        if(node.getKwAs() != null)
        {
            node.getKwAs().apply(this);
        }
        if(node.getString() != null)
        {
            node.getString().apply(this);
        }
        if(node.getKwImport() != null)
        {
            node.getKwImport().apply(this);
        }
        outAImportWithoutSeperatorImportT(node);
    }

    public void inAImportWithSeperatorImportT(AImportWithSeperatorImportT node)
    {
        defaultIn(node);
    }

    public void outAImportWithSeperatorImportT(AImportWithSeperatorImportT node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAImportWithSeperatorImportT(AImportWithSeperatorImportT node)
    {
        inAImportWithSeperatorImportT(node);
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        if(node.getKwAs() != null)
        {
            node.getKwAs().apply(this);
        }
        if(node.getChar() != null)
        {
            node.getChar().apply(this);
        }
        if(node.getKwSeparatedBy() != null)
        {
            node.getKwSeparatedBy().apply(this);
        }
        if(node.getString() != null)
        {
            node.getString().apply(this);
        }
        if(node.getKwImport() != null)
        {
            node.getKwImport().apply(this);
        }
        outAImportWithSeperatorImportT(node);
    }
}
