/* This file was generated by SableCC (http://www.sablecc.org/). */

package postfix.node;

import postfix.analysis.*;

@SuppressWarnings("nls")
public final class ASumSum extends PSum
{
    private TSopSum _sopSum_;

    public ASumSum()
    {
        // Constructor
    }

    public ASumSum(
        @SuppressWarnings("hiding") TSopSum _sopSum_)
    {
        // Constructor
        setSopSum(_sopSum_);

    }

    @Override
    public Object clone()
    {
        return new ASumSum(
            cloneNode(this._sopSum_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseASumSum(this);
    }

    public TSopSum getSopSum()
    {
        return this._sopSum_;
    }

    public void setSopSum(TSopSum node)
    {
        if(this._sopSum_ != null)
        {
            this._sopSum_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._sopSum_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._sopSum_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._sopSum_ == child)
        {
            this._sopSum_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._sopSum_ == oldChild)
        {
            setSopSum((TSopSum) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}