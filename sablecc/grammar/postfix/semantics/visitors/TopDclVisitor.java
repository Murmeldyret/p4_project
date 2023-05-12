package postfix.semantics.visitors;

import postfix.node.*;
import postfix.semantics.*;
import postfix.semantics.Exceptions.VariableAlreadyDeclaredException;
import postfix.semantics.IdAttributes.Attributes;
import postfix.semantics.SymbolTable.Scopekind;

/**
 * Class for managing declarations, also responsible for calling TypeVisitor for
 * the right hand side (or statements in case of functions)
 * 
 * @see {@link postfix.semantics.visitors.TypeVisitor}
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
        if (symbolTable.DeclaredLocally(node.getId().getText())) {
            throw new VariableAlreadyDeclaredException(
                    "Variable" + node.getId().toString() + "has already been declared");
        } else {
            symbolTable.put(node.getId().toString(),
                    new IdAttributes(node.getId(), node.getType(), node.getExpr().toString().strip(), Attributes.variable));
        }
    }

    @Override
    public void inAVariableDeclarationDcl(AVariableDeclarationDcl node) {
        // TypeVisitor typeVisitor = new TypeVisitor(symbolTable);

        // node.apply(typeVisitor);

        if (symbolTable.DeclaredLocally(node.getId().getText())) {
            throw new VariableAlreadyDeclaredException(
                    "Variable " + node.getId().getText() + " has already been declared");
        } else {
            symbolTable.put(node.getId().toString(),
                    new IdAttributes(node.getId(), node.getType(), null, Attributes.variable));
            // seems legit
            if (node.parent() instanceof AFunctionParamFunctionParam
                    || node.parent() instanceof AFunctionParamPrimeFunctionParamPrime) {
                Node functionDCL = node.parent();

                while (!(functionDCL instanceof AFunctionDeclarationDcl)) {
                    // find the parent function declaration
                    functionDCL = functionDCL.parent();
                }
                AFunctionDeclarationDcl funcDCL = (AFunctionDeclarationDcl) functionDCL;
                // symbolTable.get(funcDCL.getId().getText()).addParameter(node.getType().getText(),
                // node.getId().getText());
                symbolTable.addFunctionParameter(funcDCL.getId().getText(), node.getType().getText(),
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
            // symbolTable = symbolTable.getFunctionSymbolTable(node.getId().getText());
            // symbolTable = symbolTable.CreateNewScope(node.getId().getText(),
            // Scopekind.functionBlock);
        }
    }

    // @Override
    // public void caseAFunctionDeclarationDcl(AFunctionDeclarationDcl node) {

    //     inAFunctionDeclarationDcl(node);
    //     if (node.getType() != null) {
    //         node.getType().apply(this);
    //     }
    //     if (node.getKwFunction() != null) {
    //         node.getKwFunction().apply(this);
    //     }
    //     if (node.getId() != null) {
    //         node.getId().apply(this);
    //     }
    //     symbolTable = symbolTable.getFunctionSymbolTable(node.getId().getText());
    //     if (node.getFunctionParam() != null) {
    //         node.getFunctionParam().apply(this);
    //     }
    //     if (node.getStmts() != null) {
    //         node.getStmts().apply(this);
    //     }
    //     outAFunctionDeclarationDcl(node);
    // }

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
}