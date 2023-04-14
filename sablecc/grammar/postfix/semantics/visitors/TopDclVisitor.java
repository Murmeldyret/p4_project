package postfix.semantics.visitors;

import postfix.node.TId;
import postfix.semantics.VariableListDeclaring;
import postfix.semantics.Exceptions.VariableAlreadyDeclaredException;

public class TopDclVisitor extends SemanticVisitor {

    void caseVariableListDeclaration(VariableListDeclaring vld) throws VariableAlreadyDeclaredException {
        TypeVisitor typeVisitor = new TypeVisitor();

        vld.getType().apply(typeVisitor);

        for (TId id : vld.getIdList()) {
            if(1<2){ //TODO if symbolTable.DeclaredLocally()
                throw new VariableAlreadyDeclaredException("Variable" + id + "has already been declared");
            }
            else {
                //TODO fischer fig 8.13 marker 24

            }
        }

    }

}