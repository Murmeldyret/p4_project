/* This file was generated by SableCC (http://www.sablecc.org/). */

package postfix.node;

import postfix.analysis.*;

@SuppressWarnings("nls")
public final class AMeanOpSpecialSyntax extends PSpecialSyntax
{
    private TSopMean _sopMean_;

    public AMeanOpSpecialSyntax()
    {
        // Constructor
    }

    public AMeanOpSpecialSyntax(
        @SuppressWarnings("hiding") TSopMean _sopMean_)
    {
        // Constructor
        setSopMean(_sopMean_);

    }

    @Override
    public Object clone()
    {
        return new AMeanOpSpecialSyntax(
            cloneNode(this._sopMean_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAMeanOpSpecialSyntax(this);
    }

    public TSopMean getSopMean()
    {
        return this._sopMean_;
    }

    public void setSopMean(TSopMean node)
    {
        if(this._sopMean_ != null)
        {
            this._sopMean_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._sopMean_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._sopMean_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._sopMean_ == child)
        {
            this._sopMean_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._sopMean_ == oldChild)
        {
            setSopMean((TSopMean) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
