package postfix.semantics.visitors;

import postfix.node.*;
import postfix.semantics.*;
import postfix.semantics.Exceptions.VariableAlreadyDeclaredException;
import postfix.semantics.IdAttributes.Attributes;
import postfix.semantics.SymbolTable.Scopekind;

//TODO skal stemme overens med de noder der faktisk eksisterer i AST
/**
 * Class for managing declarations, also responsible for calling TypeVisitor for
 * the right hand side (or statements in case of functions)
 */
public class TopDclVisitor extends SemanticVisitor {

    @Deprecated
    public TopDclVisitor() {
    }

    public TopDclVisitor(SymbolTable symbolTable) {
        super(symbolTable);
    }

    @Override
    public void inADeclarationStmt(ADeclarationStmt node) {
        defaultIn(node);
    }

    @Override
    public void inAAssignStmt(AAssignStmt node) {
        defaultIn(node);
    }

    @Override
    public void inAVariableDeclarationInitializationDcl(AVariableDeclarationInitializationDcl node) {
        TypeVisitor typeVisitor = new TypeVisitor(symbolTable, node.getType().getText());

        node.apply(typeVisitor);

        // TODO get expr value
        String value = "";
        if (symbolTable.DeclaredLocally(node.getId().getText())) {
            throw new VariableAlreadyDeclaredException(
                    "Variable" + node.getId().toString() + "has already been declared");
        } else {
            symbolTable.put(node.getId().toString(),
                    new IdAttributes(node.getId(), node.getType(), value, Attributes.variable));
        }
    }

    @Override
    public void inAVariableDeclarationDcl(AVariableDeclarationDcl node) {
        // TypeVisitor typeVisitor = new TypeVisitor(symbolTable);

        // node.apply(typeVisitor);

        if (symbolTable.DeclaredLocally(node.getId().getText())) {
            throw new VariableAlreadyDeclaredException(
                    "Variable " + node.getId().toString() + " has already been declared");
        } else {
            symbolTable.put(node.getId().toString(),
                    new IdAttributes(node.getId(), node.getType(), null, Attributes.variable));
            // seems legit
            if (node.parent() instanceof AFunctionParamFunctionParam
                    || node.parent() instanceof AFunctionParamPrimeFunctionParamPrime) {
                Node functionDCL = node.parent();

                while (!(functionDCL instanceof AFunctionDeclarationDcl)) {
                    //find the parent function declaration
                    functionDCL = functionDCL.parent();
                }
                AFunctionDeclarationDcl funcDCL = (AFunctionDeclarationDcl) functionDCL;
                symbolTable.get(funcDCL.getId().getText()).addParameter(node.getType().getText(),
                        node.getId().getText());

            }
        }
    }

    @Override
    public void inAConstDeclarationInitializationDcl(AConstDeclarationInitializationDcl node) {

        TypeVisitor typeVisitor = new TypeVisitor(symbolTable, node.getType().getText());

        node.apply(typeVisitor);

        // TODO get expr value
        String value = "";
        if (symbolTable.DeclaredLocally(node.getId().getText())) {
            throw new VariableAlreadyDeclaredException(
                    "Variable" + node.getId().toString() + "has already been declared");
        } else {
            symbolTable.put(node.getId().toString(),
                    new IdAttributes(node.getId(), node.getType(), value, Attributes.constant));
        }

    }

    @Override
    public void inAFunctionDeclarationDcl(AFunctionDeclarationDcl node) {
        // TopDclVisitor topDclVisitor = new TopDclVisitor(symbolTable);
        // node.getFunctionParam().apply(topDclVisitor);

        if (symbolTable.DeclaredLocally(node.getId().getText())) {
            throw new VariableAlreadyDeclaredException("null");
        } else {
            symbolTable.put(node.getId().getText(),
                    new IdAttributes(node.getId(), node.getType(), null, Attributes.function));
            symbolTable.CreateNewScope(node.getId().getText(), Scopekind.functionBlock, node.getType().getText());
            symbolTable = symbolTable.getFunctionSymbolTable(node.getId().getText());
            // symbolTable = symbolTable.CreateNewScope(node.getId().getText(),
            // Scopekind.functionBlock);
        }
    }

    @Override
    public void outAReturnStmt(AReturnStmt node) {
        // skal først besøges efter funktionsdeklaration er færdig
        node.apply(new TypeVisitor(symbolTable, symbolTable.getReturnType()));
        // træd ud af scope?
    }

    @Override
    public void outAFunctionDeclarationDcl(AFunctionDeclarationDcl node) {
        TypeVisitor typeVisitor = new TypeVisitor(symbolTable, node.getType().getText());

        node.apply(typeVisitor);
        if (symbolTable.getOuterSymbolTable() == null) {
            throw new NullPointerException("cannot go to outer scope: already in global scope");
        }
        symbolTable = symbolTable.getOuterSymbolTable();
    }

    @Override
    public void inAVariableDeclarationArrayDcl(AVariableDeclarationArrayDcl node) {
        TypeVisitor typeVisitor = new TypeVisitor(symbolTable, node.getType().getText());

        node.apply(typeVisitor);

        if (symbolTable.DeclaredLocally(node.getId().getText())) {
            throw new VariableAlreadyDeclaredException(
                    "Variable" + node.getId().toString() + "has already been declared");
        } else {
            symbolTable.put(node.getId().toString(),
                    new IdAttributes(node.getId(), node.getType(), null, Attributes.array));
        }
    }

    /*
     * @Override
     * public void inAFunctionDeclarationDcl(AFunctionDeclarationDcl node) {
     * TypeVisitor typeVisitor = new TypeVisitor(this.symbolTable);
     * 
     * node.getType().apply(typeVisitor);
     * 
     * if (symbolTable.DeclaredLocally(node.getId().getText())) {
     * throw new VariableAlreadyDeclaredException("null");
     * } else {
     * symbolTable.put(node.getId().getText(),
     * new IdAttributes(node.getId(), node.getType(), null, true, false));
     * }
     * 
     * }
     */

    /**
     * prcoesses a variable declaration and adds it to the nearest symbol table
     * 
     * @param vld
     * @throws VariableAlreadyDeclaredException
     */
    /*
     * void caseVariableListDeclaration(VariableListDeclaring vld) throws
     * VariableAlreadyDeclaredException {
     * TypeVisitor typeVisitor = new TypeVisitor(this.symbolTable);
     * 
     * vld.getType().apply(typeVisitor);
     * 
     * for (TId id : vld.getIdList()) {
     * if (symbolTable.DeclaredLocally(id.getText())) { // TODO if
     * symbolTable.DeclaredLocally(id)
     * throw new VariableAlreadyDeclaredException("Variable" + id +
     * "has already been declared");
     * } else {
     * // fischer fig 8.13 marker 24
     * // TODO måske skal der være satelitdata til dette, idk
     * symbolTable.put(id.getText(), new IdAttributes(id, vld.getType(), false,
     * false));
     * 
     * }
     * }
     * }
     */

    // lidt copy paste kode har aldrig gjort nogen noget
    /*
     * void caseConstListDeclaration(VariableListDeclaring cld) throws
     * VariableAlreadyDeclaredException {
     * TypeVisitor typeVisitor = new TypeVisitor(this.symbolTable);
     * 
     * cld.getType().apply(typeVisitor);
     * 
     * for (TId id : cld.getIdList()) {
     * if (symbolTable.DeclaredLocally(id.getText())) { // TODO if
     * symbolTable.DeclaredLocally(id)
     * throw new VariableAlreadyDeclaredException("Variable" + id +
     * "has already been declared");
     * } else {
     * // fischer fig 8.13 marker 24
     * // TODO måske skal der være satelitdata til dette, idk
     * symbolTable.put(id.getText(), new IdAttributes(id, cld.getType(), false,
     * true));
     * }
     * }
     * }
     */

}