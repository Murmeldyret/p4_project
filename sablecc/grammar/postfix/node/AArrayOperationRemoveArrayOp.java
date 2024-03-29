/* This file was generated by SableCC (http://www.sablecc.org/). */

package postfix.node;

import postfix.analysis.*;

@SuppressWarnings("nls")
public final class AArrayOperationRemoveArrayOp extends PArrayOp
{
    private PArrayRemove _arrayRemove_;

    public AArrayOperationRemoveArrayOp()
    {
        // Constructor
    }

    public AArrayOperationRemoveArrayOp(
        @SuppressWarnings("hiding") PArrayRemove _arrayRemove_)
    {
        // Constructor
        setArrayRemove(_arrayRemove_);

    }

    @Override
    public Object clone()
    {
        return new AArrayOperationRemoveArrayOp(
            cloneNode(this._arrayRemove_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAArrayOperationRemoveArrayOp(this);
    }

    public PArrayRemove getArrayRemove()
    {
        return this._arrayRemove_;
    }

    public void setArrayRemove(PArrayRemove node)
    {
        if(this._arrayRemove_ != null)
        {
            this._arrayRemove_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._arrayRemove_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._arrayRemove_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._arrayRemove_ == child)
        {
            this._arrayRemove_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._arrayRemove_ == oldChild)
        {
            setArrayRemove((PArrayRemove) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
