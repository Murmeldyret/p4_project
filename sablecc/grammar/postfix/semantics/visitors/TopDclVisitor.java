package postfix.semantics.visitors;

import postfix.node.TId;
import postfix.semantics.VariableListDeclaring;
import postfix.semantics.Exceptions.VariableAlreadyDeclaredException;

public class TopDclVisitor extends SemanticVisitor {

    void caseVariableListDeclaration(VariableListDeclaring vld) throws VariableAlreadyDeclaredException {
        TypeVisitor typeVisitor = new TypeVisitor();

        vld.getType().apply(typeVisitor);

        for (TId id : vld.getIdList()) {
            
        }

    }

}