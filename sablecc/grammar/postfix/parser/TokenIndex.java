/* This file was generated by SableCC (http://www.sablecc.org/). */

package postfix.parser;

import postfix.node.*;
import postfix.analysis.*;

class TokenIndex extends AnalysisAdapter
{
    int index;

    @Override
    public void caseTNewline(@SuppressWarnings("unused") TNewline node)
    {
        this.index = 0;
    }

    @Override
    public void caseTLPar(@SuppressWarnings("unused") TLPar node)
    {
        this.index = 1;
    }

    @Override
    public void caseTRPar(@SuppressWarnings("unused") TRPar node)
    {
        this.index = 2;
    }

    @Override
    public void caseTLCbrack(@SuppressWarnings("unused") TLCbrack node)
    {
        this.index = 3;
    }

    @Override
    public void caseTRCbrack(@SuppressWarnings("unused") TRCbrack node)
    {
        this.index = 4;
    }

    @Override
    public void caseTLBrack(@SuppressWarnings("unused") TLBrack node)
    {
        this.index = 5;
    }

    @Override
    public void caseTRBrack(@SuppressWarnings("unused") TRBrack node)
    {
        this.index = 6;
    }

    @Override
    public void caseTString(@SuppressWarnings("unused") TString node)
    {
        this.index = 7;
    }

    @Override
    public void caseTIntnum(@SuppressWarnings("unused") TIntnum node)
    {
        this.index = 8;
    }

    @Override
    public void caseTFloatnum(@SuppressWarnings("unused") TFloatnum node)
    {
        this.index = 9;
    }

    @Override
    public void caseTBool(@SuppressWarnings("unused") TBool node)
    {
        this.index = 10;
    }

    @Override
    public void caseTType(@SuppressWarnings("unused") TType node)
    {
        this.index = 11;
    }

    @Override
    public void caseTChar(@SuppressWarnings("unused") TChar node)
    {
        this.index = 12;
    }

    @Override
    public void caseTId(@SuppressWarnings("unused") TId node)
    {
        this.index = 13;
    }

    @Override
    public void caseTOpAssign(@SuppressWarnings("unused") TOpAssign node)
    {
        this.index = 14;
    }

    @Override
    public void caseTOpPlus(@SuppressWarnings("unused") TOpPlus node)
    {
        this.index = 15;
    }

    @Override
    public void caseTOpMinus(@SuppressWarnings("unused") TOpMinus node)
    {
        this.index = 16;
    }

    @Override
    public void caseTOpMult(@SuppressWarnings("unused") TOpMult node)
    {
        this.index = 17;
    }

    @Override
    public void caseTOpDiv(@SuppressWarnings("unused") TOpDiv node)
    {
        this.index = 18;
    }

    @Override
    public void caseTOpMod(@SuppressWarnings("unused") TOpMod node)
    {
        this.index = 19;
    }

    @Override
    public void caseTBopLthan(@SuppressWarnings("unused") TBopLthan node)
    {
        this.index = 20;
    }

    @Override
    public void caseTBopLethan(@SuppressWarnings("unused") TBopLethan node)
    {
        this.index = 21;
    }

    @Override
    public void caseTBopGthan(@SuppressWarnings("unused") TBopGthan node)
    {
        this.index = 22;
    }

    @Override
    public void caseTBopGethan(@SuppressWarnings("unused") TBopGethan node)
    {
        this.index = 23;
    }

    @Override
    public void caseTBopEq(@SuppressWarnings("unused") TBopEq node)
    {
        this.index = 24;
    }

    @Override
    public void caseTBopNeq(@SuppressWarnings("unused") TBopNeq node)
    {
        this.index = 25;
    }

    @Override
    public void caseTBopAnd(@SuppressWarnings("unused") TBopAnd node)
    {
        this.index = 26;
    }

    @Override
    public void caseTBopOr(@SuppressWarnings("unused") TBopOr node)
    {
        this.index = 27;
    }

    @Override
    public void caseTBopNot(@SuppressWarnings("unused") TBopNot node)
    {
        this.index = 28;
    }

    @Override
    public void caseTSopDot(@SuppressWarnings("unused") TSopDot node)
    {
        this.index = 29;
    }

    @Override
    public void caseTSopComma(@SuppressWarnings("unused") TSopComma node)
    {
        this.index = 30;
    }

    @Override
    public void caseTSopSum(@SuppressWarnings("unused") TSopSum node)
    {
        this.index = 31;
    }

    @Override
    public void caseTSopFilter(@SuppressWarnings("unused") TSopFilter node)
    {
        this.index = 32;
    }

    @Override
    public void caseTSopGroupby(@SuppressWarnings("unused") TSopGroupby node)
    {
        this.index = 33;
    }

    @Override
    public void caseTSopMean(@SuppressWarnings("unused") TSopMean node)
    {
        this.index = 34;
    }

    @Override
    public void caseTSopSort(@SuppressWarnings("unused") TSopSort node)
    {
        this.index = 35;
    }

    @Override
    public void caseTSopCount(@SuppressWarnings("unused") TSopCount node)
    {
        this.index = 36;
    }

    @Override
    public void caseTKwAs(@SuppressWarnings("unused") TKwAs node)
    {
        this.index = 37;
    }

    @Override
    public void caseTKwImport(@SuppressWarnings("unused") TKwImport node)
    {
        this.index = 38;
    }

    @Override
    public void caseTKwExport(@SuppressWarnings("unused") TKwExport node)
    {
        this.index = 39;
    }

    @Override
    public void caseTKwPrint(@SuppressWarnings("unused") TKwPrint node)
    {
        this.index = 40;
    }

    @Override
    public void caseTKwSeparatedBy(@SuppressWarnings("unused") TKwSeparatedBy node)
    {
        this.index = 41;
    }

    @Override
    public void caseTKwFor(@SuppressWarnings("unused") TKwFor node)
    {
        this.index = 42;
    }

    @Override
    public void caseTKwWhile(@SuppressWarnings("unused") TKwWhile node)
    {
        this.index = 43;
    }

    @Override
    public void caseTKwIn(@SuppressWarnings("unused") TKwIn node)
    {
        this.index = 44;
    }

    @Override
    public void caseTKwIf(@SuppressWarnings("unused") TKwIf node)
    {
        this.index = 45;
    }

    @Override
    public void caseTKwElse(@SuppressWarnings("unused") TKwElse node)
    {
        this.index = 46;
    }

    @Override
    public void caseTKwSortOrderAsc(@SuppressWarnings("unused") TKwSortOrderAsc node)
    {
        this.index = 47;
    }

    @Override
    public void caseTKwSortOrderDsc(@SuppressWarnings("unused") TKwSortOrderDsc node)
    {
        this.index = 48;
    }

    @Override
    public void caseTKwTo(@SuppressWarnings("unused") TKwTo node)
    {
        this.index = 49;
    }

    @Override
    public void caseTKwConst(@SuppressWarnings("unused") TKwConst node)
    {
        this.index = 50;
    }

    @Override
    public void caseTKwFunction(@SuppressWarnings("unused") TKwFunction node)
    {
        this.index = 51;
    }

    @Override
    public void caseTKwReturn(@SuppressWarnings("unused") TKwReturn node)
    {
        this.index = 52;
    }

    @Override
    public void caseTKwBreak(@SuppressWarnings("unused") TKwBreak node)
    {
        this.index = 53;
    }

    @Override
    public void caseTKwAdd(@SuppressWarnings("unused") TKwAdd node)
    {
        this.index = 54;
    }

    @Override
    public void caseTKwRemove(@SuppressWarnings("unused") TKwRemove node)
    {
        this.index = 55;
    }

    @Override
    public void caseTKwRemoveAt(@SuppressWarnings("unused") TKwRemoveAt node)
    {
        this.index = 56;
    }

    @Override
    public void caseTKwInsert(@SuppressWarnings("unused") TKwInsert node)
    {
        this.index = 57;
    }

    @Override
    public void caseTKwColumn(@SuppressWarnings("unused") TKwColumn node)
    {
        this.index = 58;
    }

    @Override
    public void caseTKwRow(@SuppressWarnings("unused") TKwRow node)
    {
        this.index = 59;
    }

    @Override
    public void caseEOF(@SuppressWarnings("unused") EOF node)
    {
        this.index = 60;
    }
}
