/* This file was generated by SableCC (http://www.sablecc.org/). */

package postfix.node;

import postfix.analysis.*;

@SuppressWarnings("nls")
public final class ACsvOperationStmt extends PStmt
{
    private PCsvOp _csvOp_;

    public ACsvOperationStmt()
    {
        // Constructor
    }

    public ACsvOperationStmt(
        @SuppressWarnings("hiding") PCsvOp _csvOp_)
    {
        // Constructor
        setCsvOp(_csvOp_);

    }

    @Override
    public Object clone()
    {
        return new ACsvOperationStmt(
            cloneNode(this._csvOp_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseACsvOperationStmt(this);
    }

    public PCsvOp getCsvOp()
    {
        return this._csvOp_;
    }

    public void setCsvOp(PCsvOp node)
    {
        if(this._csvOp_ != null)
        {
            this._csvOp_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._csvOp_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._csvOp_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._csvOp_ == child)
        {
            this._csvOp_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._csvOp_ == oldChild)
        {
            setCsvOp((PCsvOp) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
