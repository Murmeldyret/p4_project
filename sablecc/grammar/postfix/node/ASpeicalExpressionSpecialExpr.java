/* This file was generated by SableCC (http://www.sablecc.org/). */

package postfix.node;

import postfix.analysis.*;

@SuppressWarnings("nls")
public final class ASpeicalExpressionSpecialExpr extends PSpecialExpr
{
    private PSpecialSyntax _specialSyntax_;
    private PSpecialExprPrime _specialExprPrime_;

    public ASpeicalExpressionSpecialExpr()
    {
        // Constructor
    }

    public ASpeicalExpressionSpecialExpr(
        @SuppressWarnings("hiding") PSpecialSyntax _specialSyntax_,
        @SuppressWarnings("hiding") PSpecialExprPrime _specialExprPrime_)
    {
        // Constructor
        setSpecialSyntax(_specialSyntax_);

        setSpecialExprPrime(_specialExprPrime_);

    }

    @Override
    public Object clone()
    {
        return new ASpeicalExpressionSpecialExpr(
            cloneNode(this._specialSyntax_),
            cloneNode(this._specialExprPrime_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseASpeicalExpressionSpecialExpr(this);
    }

    public PSpecialSyntax getSpecialSyntax()
    {
        return this._specialSyntax_;
    }

    public void setSpecialSyntax(PSpecialSyntax node)
    {
        if(this._specialSyntax_ != null)
        {
            this._specialSyntax_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._specialSyntax_ = node;
    }

    public PSpecialExprPrime getSpecialExprPrime()
    {
        return this._specialExprPrime_;
    }

    public void setSpecialExprPrime(PSpecialExprPrime node)
    {
        if(this._specialExprPrime_ != null)
        {
            this._specialExprPrime_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._specialExprPrime_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._specialSyntax_)
            + toString(this._specialExprPrime_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._specialSyntax_ == child)
        {
            this._specialSyntax_ = null;
            return;
        }

        if(this._specialExprPrime_ == child)
        {
            this._specialExprPrime_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._specialSyntax_ == oldChild)
        {
            setSpecialSyntax((PSpecialSyntax) newChild);
            return;
        }

        if(this._specialExprPrime_ == oldChild)
        {
            setSpecialExprPrime((PSpecialExprPrime) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
