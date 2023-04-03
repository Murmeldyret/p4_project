/* This file was generated by SableCC (http://www.sablecc.org/). */

package postfix.node;

import postfix.analysis.*;

@SuppressWarnings("nls")
public final class ACsvOperationAddCsvOp extends PCsvOp
{
    private PCsvAdd _csvAdd_;

    public ACsvOperationAddCsvOp()
    {
        // Constructor
    }

    public ACsvOperationAddCsvOp(
        @SuppressWarnings("hiding") PCsvAdd _csvAdd_)
    {
        // Constructor
        setCsvAdd(_csvAdd_);

    }

    @Override
    public Object clone()
    {
        return new ACsvOperationAddCsvOp(
            cloneNode(this._csvAdd_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseACsvOperationAddCsvOp(this);
    }

    public PCsvAdd getCsvAdd()
    {
        return this._csvAdd_;
    }

    public void setCsvAdd(PCsvAdd node)
    {
        if(this._csvAdd_ != null)
        {
            this._csvAdd_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._csvAdd_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._csvAdd_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._csvAdd_ == child)
        {
            this._csvAdd_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._csvAdd_ == oldChild)
        {
            setCsvAdd((PCsvAdd) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
