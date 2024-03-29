/* This file was generated by SableCC (http://www.sablecc.org/). */

package postfix.node;

import postfix.analysis.*;

@SuppressWarnings("nls")
public final class AArrayOperationRemoveAtArrayOp extends PArrayOp
{
    private PArrayRemoveAt _arrayRemoveAt_;

    public AArrayOperationRemoveAtArrayOp()
    {
        // Constructor
    }

    public AArrayOperationRemoveAtArrayOp(
        @SuppressWarnings("hiding") PArrayRemoveAt _arrayRemoveAt_)
    {
        // Constructor
        setArrayRemoveAt(_arrayRemoveAt_);

    }

    @Override
    public Object clone()
    {
        return new AArrayOperationRemoveAtArrayOp(
            cloneNode(this._arrayRemoveAt_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAArrayOperationRemoveAtArrayOp(this);
    }

    public PArrayRemoveAt getArrayRemoveAt()
    {
        return this._arrayRemoveAt_;
    }

    public void setArrayRemoveAt(PArrayRemoveAt node)
    {
        if(this._arrayRemoveAt_ != null)
        {
            this._arrayRemoveAt_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._arrayRemoveAt_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._arrayRemoveAt_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._arrayRemoveAt_ == child)
        {
            this._arrayRemoveAt_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._arrayRemoveAt_ == oldChild)
        {
            setArrayRemoveAt((PArrayRemoveAt) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
