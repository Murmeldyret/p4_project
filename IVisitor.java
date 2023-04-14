interface IVisitor
{
    public void accept(Visitor visitor);   
}

public class Visitor
{
    void visit(AbstractNode n){
        n.accept(this);
    }
}