/* This file was generated by SableCC (http://www.sablecc.org/). */

package postfix.node;

import postfix.analysis.*;

@SuppressWarnings("nls")
public final class AOrInfixBinInfixOp extends PBinInfixOp
{
    private TBopOr _bopOr_;

    public AOrInfixBinInfixOp()
    {
        // Constructor
    }

    public AOrInfixBinInfixOp(
        @SuppressWarnings("hiding") TBopOr _bopOr_)
    {
        // Constructor
        setBopOr(_bopOr_);

    }

    @Override
    public Object clone()
    {
        return new AOrInfixBinInfixOp(
            cloneNode(this._bopOr_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAOrInfixBinInfixOp(this);
    }

    public TBopOr getBopOr()
    {
        return this._bopOr_;
    }

    public void setBopOr(TBopOr node)
    {
        if(this._bopOr_ != null)
        {
            this._bopOr_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._bopOr_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._bopOr_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._bopOr_ == child)
        {
            this._bopOr_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._bopOr_ == oldChild)
        {
            setBopOr((TBopOr) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
