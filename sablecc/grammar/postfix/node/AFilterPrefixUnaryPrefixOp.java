/* This file was generated by SableCC (http://www.sablecc.org/). */

package postfix.node;

import postfix.analysis.*;

@SuppressWarnings("nls")
public final class AFilterPrefixUnaryPrefixOp extends PUnaryPrefixOp
{
    private TSopFilter _sopFilter_;

    public AFilterPrefixUnaryPrefixOp()
    {
        // Constructor
    }

    public AFilterPrefixUnaryPrefixOp(
        @SuppressWarnings("hiding") TSopFilter _sopFilter_)
    {
        // Constructor
        setSopFilter(_sopFilter_);

    }

    @Override
    public Object clone()
    {
        return new AFilterPrefixUnaryPrefixOp(
            cloneNode(this._sopFilter_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAFilterPrefixUnaryPrefixOp(this);
    }

    public TSopFilter getSopFilter()
    {
        return this._sopFilter_;
    }

    public void setSopFilter(TSopFilter node)
    {
        if(this._sopFilter_ != null)
        {
            this._sopFilter_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._sopFilter_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._sopFilter_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._sopFilter_ == child)
        {
            this._sopFilter_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._sopFilter_ == oldChild)
        {
            setSopFilter((TSopFilter) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
