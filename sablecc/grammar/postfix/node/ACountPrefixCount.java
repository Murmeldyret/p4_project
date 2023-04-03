/* This file was generated by SableCC (http://www.sablecc.org/). */

package postfix.node;

import postfix.analysis.*;

@SuppressWarnings("nls")
public final class ACountPrefixCount extends PCount
{
    private TSopCount _sopCount_;
    private PExpr _expr_;

    public ACountPrefixCount()
    {
        // Constructor
    }

    public ACountPrefixCount(
        @SuppressWarnings("hiding") TSopCount _sopCount_,
        @SuppressWarnings("hiding") PExpr _expr_)
    {
        // Constructor
        setSopCount(_sopCount_);

        setExpr(_expr_);

    }

    @Override
    public Object clone()
    {
        return new ACountPrefixCount(
            cloneNode(this._sopCount_),
            cloneNode(this._expr_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseACountPrefixCount(this);
    }

    public TSopCount getSopCount()
    {
        return this._sopCount_;
    }

    public void setSopCount(TSopCount node)
    {
        if(this._sopCount_ != null)
        {
            this._sopCount_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._sopCount_ = node;
    }

    public PExpr getExpr()
    {
        return this._expr_;
    }

    public void setExpr(PExpr node)
    {
        if(this._expr_ != null)
        {
            this._expr_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._expr_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._sopCount_)
            + toString(this._expr_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._sopCount_ == child)
        {
            this._sopCount_ = null;
            return;
        }

        if(this._expr_ == child)
        {
            this._expr_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._sopCount_ == oldChild)
        {
            setSopCount((TSopCount) newChild);
            return;
        }

        if(this._expr_ == oldChild)
        {
            setExpr((PExpr) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}