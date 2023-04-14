package postfix.semantics;

import java.util.List;
import postfix.node.*;

// tyvstjålet fra fischer ch. 8.6.4
public class VariableListDeclaring {
    private List<TId> idList;
    private TType type;

    public TType getType() {
        return type;
    };

    public List<TId> getIdList() {
        return idList;
    }
}