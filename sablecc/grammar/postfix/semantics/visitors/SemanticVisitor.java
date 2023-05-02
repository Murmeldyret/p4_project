package postfix.semantics.visitors;

import postfix.analysis.DepthFirstAdapter;
import postfix.node.*;
import postfix.semantics.SymbolTable;

public class SemanticVisitor extends DepthFirstAdapter {

    // TODO Kapitel 8.8 i fischer bogen
    public SemanticVisitor() {

    }

    public SemanticVisitor(SymbolTable symbolTable) {
        this.symbolTable = symbolTable;
    }

    protected SymbolTable symbolTable;

    @Override
    public void inStart(Start node) {
        this.symbolTable = new SymbolTable(null, SymbolTable.Scopekind.block);
    }

    @Override
    public void inAImportWithoutSeperatorStmt(AImportWithoutSeperatorStmt node) {
        // add to symbol table
    }

    @Override
    public void inAImportWithSeperatorStmt(AImportWithSeperatorStmt node) {
        // add to symbol table
    }

    @Override
    public void inADeclarationStmt(ADeclarationStmt node) {
        TopDclVisitor dclVisitor = new TopDclVisitor(symbolTable);
        node.apply(dclVisitor);

    }

    @Override
    public void inAAssignStmt(AAssignStmt node) {
        // type visitor
    }

    @Override
    public void inAForLoopStmt(AForLoopStmt node) {
        //Type Visitor
    }




}
