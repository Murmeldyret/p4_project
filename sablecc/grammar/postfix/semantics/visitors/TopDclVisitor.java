package postfix.semantics.visitors;

import postfix.node.TId;
import postfix.semantics.SymbolTable;
import postfix.semantics.VariableListDeclaring;
import postfix.semantics.Exceptions.VariableAlreadyDeclaredException;

public class TopDclVisitor extends SemanticVisitor {

    public TopDclVisitor() {
    }

    public TopDclVisitor(SymbolTable symbolTable) {
        super(symbolTable);
    }

    void caseVariableListDeclaration(VariableListDeclaring vld) throws VariableAlreadyDeclaredException {
        TypeVisitor typeVisitor = new TypeVisitor(this.symbolTable);


        vld.getType().apply(typeVisitor);

        for (TId id : vld.getIdList()) {
            if (symbolTable.DeclaredLocally(id.getText())) { // TODO if symbolTable.DeclaredLocally(id)
                throw new VariableAlreadyDeclaredException("Variable" + id + "has already been declared");
            } else {
                //fischer fig 8.13 marker 24
                //TODO måske skal der være satelitdata til dette, idk
                symbolTable.put(id.getText(), id);

            }
        }

    }

}