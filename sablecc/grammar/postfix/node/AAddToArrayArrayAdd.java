/* This file was generated by SableCC (http://www.sablecc.org/). */

package postfix.node;

import postfix.analysis.*;

@SuppressWarnings("nls")
public final class AAddToArrayArrayAdd extends PArrayAdd
{
    private TKwAdd _kwAdd_;
    private TLPar _lPar_;
    private PArrayExpr _arrayExpr_;
    private TRPar _rPar_;

    public AAddToArrayArrayAdd()
    {
        // Constructor
    }

    public AAddToArrayArrayAdd(
        @SuppressWarnings("hiding") TKwAdd _kwAdd_,
        @SuppressWarnings("hiding") TLPar _lPar_,
        @SuppressWarnings("hiding") PArrayExpr _arrayExpr_,
        @SuppressWarnings("hiding") TRPar _rPar_)
    {
        // Constructor
        setKwAdd(_kwAdd_);

        setLPar(_lPar_);

        setArrayExpr(_arrayExpr_);

        setRPar(_rPar_);

    }

    @Override
    public Object clone()
    {
        return new AAddToArrayArrayAdd(
            cloneNode(this._kwAdd_),
            cloneNode(this._lPar_),
            cloneNode(this._arrayExpr_),
            cloneNode(this._rPar_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAAddToArrayArrayAdd(this);
    }

    public TKwAdd getKwAdd()
    {
        return this._kwAdd_;
    }

    public void setKwAdd(TKwAdd node)
    {
        if(this._kwAdd_ != null)
        {
            this._kwAdd_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._kwAdd_ = node;
    }

    public TLPar getLPar()
    {
        return this._lPar_;
    }

    public void setLPar(TLPar node)
    {
        if(this._lPar_ != null)
        {
            this._lPar_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._lPar_ = node;
    }

    public PArrayExpr getArrayExpr()
    {
        return this._arrayExpr_;
    }

    public void setArrayExpr(PArrayExpr node)
    {
        if(this._arrayExpr_ != null)
        {
            this._arrayExpr_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._arrayExpr_ = node;
    }

    public TRPar getRPar()
    {
        return this._rPar_;
    }

    public void setRPar(TRPar node)
    {
        if(this._rPar_ != null)
        {
            this._rPar_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._rPar_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._kwAdd_)
            + toString(this._lPar_)
            + toString(this._arrayExpr_)
            + toString(this._rPar_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._kwAdd_ == child)
        {
            this._kwAdd_ = null;
            return;
        }

        if(this._lPar_ == child)
        {
            this._lPar_ = null;
            return;
        }

        if(this._arrayExpr_ == child)
        {
            this._arrayExpr_ = null;
            return;
        }

        if(this._rPar_ == child)
        {
            this._rPar_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._kwAdd_ == oldChild)
        {
            setKwAdd((TKwAdd) newChild);
            return;
        }

        if(this._lPar_ == oldChild)
        {
            setLPar((TLPar) newChild);
            return;
        }

        if(this._arrayExpr_ == oldChild)
        {
            setArrayExpr((PArrayExpr) newChild);
            return;
        }

        if(this._rPar_ == oldChild)
        {
            setRPar((TRPar) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}