/* This file was generated by SableCC (http://www.sablecc.org/). */

package postfix.node;

import postfix.analysis.*;

@SuppressWarnings("nls")
public final class AMinusInfixBinInfixOp extends PBinInfixOp
{
    private TOpMinus _opMinus_;

    public AMinusInfixBinInfixOp()
    {
        // Constructor
    }

    public AMinusInfixBinInfixOp(
        @SuppressWarnings("hiding") TOpMinus _opMinus_)
    {
        // Constructor
        setOpMinus(_opMinus_);

    }

    @Override
    public Object clone()
    {
        return new AMinusInfixBinInfixOp(
            cloneNode(this._opMinus_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAMinusInfixBinInfixOp(this);
    }

    public TOpMinus getOpMinus()
    {
        return this._opMinus_;
    }

    public void setOpMinus(TOpMinus node)
    {
        if(this._opMinus_ != null)
        {
            this._opMinus_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._opMinus_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._opMinus_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._opMinus_ == child)
        {
            this._opMinus_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._opMinus_ == oldChild)
        {
            setOpMinus((TOpMinus) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
