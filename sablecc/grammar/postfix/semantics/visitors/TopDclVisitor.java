package postfix.semantics.visitors;

import postfix.node.AFunctionDeclarationDcl;
import postfix.node.TId;
import postfix.semantics.IdAttributes;
import postfix.semantics.SymbolTable;
import postfix.semantics.VariableListDeclaring;
import postfix.semantics.Exceptions.VariableAlreadyDeclaredException;

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

    /**
     * prcoesses a variable declaration and adds it to the nearest symbol table
     * @param vld
     * @throws VariableAlreadyDeclaredException
     */
    void caseVariableListDeclaration(VariableListDeclaring vld) throws VariableAlreadyDeclaredException {
        TypeVisitor typeVisitor = new TypeVisitor(this.symbolTable);

        vld.getType().apply(typeVisitor);

        for (TId id : vld.getIdList()) {
            if (symbolTable.DeclaredLocally(id.getText())) { // TODO if symbolTable.DeclaredLocally(id)
                throw new VariableAlreadyDeclaredException("Variable" + id + "has already been declared");
            } else {
                // fischer fig 8.13 marker 24
                // TODO måske skal der være satelitdata til dette, idk
                symbolTable.put(id.getText(), new IdAttributes(id, vld.getType(), false, false));

            }
        }
    }

    // lidt copy paste kode har aldrig gjort nogen noget
    void caseConstListDeclaration(VariableListDeclaring cld) throws VariableAlreadyDeclaredException {
        TypeVisitor typeVisitor = new TypeVisitor(this.symbolTable);

        cld.getType().apply(typeVisitor);

        for (TId id : cld.getIdList()) {
            if (symbolTable.DeclaredLocally(id.getText())) { // TODO if symbolTable.DeclaredLocally(id)
                throw new VariableAlreadyDeclaredException("Variable" + id + "has already been declared");
            } else {
                // fischer fig 8.13 marker 24
                // TODO måske skal der være satelitdata til dette, idk
                symbolTable.put(id.getText(), new IdAttributes(id, cld.getType(), false, true));
            }
        }
    }

    void caseFunctionDeclaration(AFunctionDeclarationDcl funcDCL) throws VariableAlreadyDeclaredException {
        TypeVisitor typeVisitor = new TypeVisitor(this.symbolTable);

        funcDCL.getType().apply(typeVisitor);

        if (symbolTable.DeclaredLocally(funcDCL.getId().getText())) {
            throw new VariableAlreadyDeclaredException(
                    "Function" + funcDCL.getId().getText() + "has already been declared");
        } else {
            symbolTable.put(funcDCL.getId().getText(),
                    new IdAttributes(funcDCL.getId(), funcDCL.getType(), true, false));
        }

    }

}