/* This file was generated by SableCC (http://www.sablecc.org/). */

package postfix.node;

import postfix.analysis.*;

@SuppressWarnings("nls")
public final class AGreaterThanInfixBinInfixOp extends PBinInfixOp
{
    private TBopGthan _bopGthan_;

    public AGreaterThanInfixBinInfixOp()
    {
        // Constructor
    }

    public AGreaterThanInfixBinInfixOp(
        @SuppressWarnings("hiding") TBopGthan _bopGthan_)
    {
        // Constructor
        setBopGthan(_bopGthan_);

    }

    @Override
    public Object clone()
    {
        return new AGreaterThanInfixBinInfixOp(
            cloneNode(this._bopGthan_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAGreaterThanInfixBinInfixOp(this);
    }

    public TBopGthan getBopGthan()
    {
        return this._bopGthan_;
    }

    public void setBopGthan(TBopGthan node)
    {
        if(this._bopGthan_ != null)
        {
            this._bopGthan_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._bopGthan_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._bopGthan_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._bopGthan_ == child)
        {
            this._bopGthan_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._bopGthan_ == oldChild)
        {
            setBopGthan((TBopGthan) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
