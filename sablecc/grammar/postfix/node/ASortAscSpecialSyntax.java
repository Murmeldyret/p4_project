/* This file was generated by SableCC (http://www.sablecc.org/). */

package postfix.node;

import postfix.analysis.*;

@SuppressWarnings("nls")
public final class ASortAscSpecialSyntax extends PSpecialSyntax
{
    private TSopSort _sopSort_;
    private PExpr _expr_;
    private TSopComma _sopComma_;
    private TKwSortOrderAsc _kwSortOrderAsc_;

    public ASortAscSpecialSyntax()
    {
        // Constructor
    }

    public ASortAscSpecialSyntax(
        @SuppressWarnings("hiding") TSopSort _sopSort_,
        @SuppressWarnings("hiding") PExpr _expr_,
        @SuppressWarnings("hiding") TSopComma _sopComma_,
        @SuppressWarnings("hiding") TKwSortOrderAsc _kwSortOrderAsc_)
    {
        // Constructor
        setSopSort(_sopSort_);

        setExpr(_expr_);

        setSopComma(_sopComma_);

        setKwSortOrderAsc(_kwSortOrderAsc_);

    }

    @Override
    public Object clone()
    {
        return new ASortAscSpecialSyntax(
            cloneNode(this._sopSort_),
            cloneNode(this._expr_),
            cloneNode(this._sopComma_),
            cloneNode(this._kwSortOrderAsc_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseASortAscSpecialSyntax(this);
    }

    public TSopSort getSopSort()
    {
        return this._sopSort_;
    }

    public void setSopSort(TSopSort node)
    {
        if(this._sopSort_ != null)
        {
            this._sopSort_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._sopSort_ = node;
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

    public TSopComma getSopComma()
    {
        return this._sopComma_;
    }

    public void setSopComma(TSopComma node)
    {
        if(this._sopComma_ != null)
        {
            this._sopComma_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._sopComma_ = node;
    }

    public TKwSortOrderAsc getKwSortOrderAsc()
    {
        return this._kwSortOrderAsc_;
    }

    public void setKwSortOrderAsc(TKwSortOrderAsc node)
    {
        if(this._kwSortOrderAsc_ != null)
        {
            this._kwSortOrderAsc_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._kwSortOrderAsc_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._sopSort_)
            + toString(this._expr_)
            + toString(this._sopComma_)
            + toString(this._kwSortOrderAsc_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._sopSort_ == child)
        {
            this._sopSort_ = null;
            return;
        }

        if(this._expr_ == child)
        {
            this._expr_ = null;
            return;
        }

        if(this._sopComma_ == child)
        {
            this._sopComma_ = null;
            return;
        }

        if(this._kwSortOrderAsc_ == child)
        {
            this._kwSortOrderAsc_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._sopSort_ == oldChild)
        {
            setSopSort((TSopSort) newChild);
            return;
        }

        if(this._expr_ == oldChild)
        {
            setExpr((PExpr) newChild);
            return;
        }

        if(this._sopComma_ == oldChild)
        {
            setSopComma((TSopComma) newChild);
            return;
        }

        if(this._kwSortOrderAsc_ == oldChild)
        {
            setKwSortOrderAsc((TKwSortOrderAsc) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
