/* This file was generated by SableCC (http://www.sablecc.org/). */

package postfix.node;

import postfix.analysis.*;

@SuppressWarnings("nls")
public final class AAddToArrayArrayOp extends PArrayOp
{
    private TKwAdd _kwAdd_;
    private PArrayExpr _arrayExpr_;
    private TKwTo _kwTo_;
    private TId _id_;

    public AAddToArrayArrayOp()
    {
        // Constructor
    }

    public AAddToArrayArrayOp(
        @SuppressWarnings("hiding") TKwAdd _kwAdd_,
        @SuppressWarnings("hiding") PArrayExpr _arrayExpr_,
        @SuppressWarnings("hiding") TKwTo _kwTo_,
        @SuppressWarnings("hiding") TId _id_)
    {
        // Constructor
        setKwAdd(_kwAdd_);

        setArrayExpr(_arrayExpr_);

        setKwTo(_kwTo_);

        setId(_id_);

    }

    @Override
    public Object clone()
    {
        return new AAddToArrayArrayOp(
            cloneNode(this._kwAdd_),
            cloneNode(this._arrayExpr_),
            cloneNode(this._kwTo_),
            cloneNode(this._id_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAAddToArrayArrayOp(this);
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

    public TKwTo getKwTo()
    {
        return this._kwTo_;
    }

    public void setKwTo(TKwTo node)
    {
        if(this._kwTo_ != null)
        {
            this._kwTo_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._kwTo_ = node;
    }

    public TId getId()
    {
        return this._id_;
    }

    public void setId(TId node)
    {
        if(this._id_ != null)
        {
            this._id_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._id_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._kwAdd_)
            + toString(this._arrayExpr_)
            + toString(this._kwTo_)
            + toString(this._id_);
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

        if(this._arrayExpr_ == child)
        {
            this._arrayExpr_ = null;
            return;
        }

        if(this._kwTo_ == child)
        {
            this._kwTo_ = null;
            return;
        }

        if(this._id_ == child)
        {
            this._id_ = null;
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

        if(this._arrayExpr_ == oldChild)
        {
            setArrayExpr((PArrayExpr) newChild);
            return;
        }

        if(this._kwTo_ == oldChild)
        {
            setKwTo((TKwTo) newChild);
            return;
        }

        if(this._id_ == oldChild)
        {
            setId((TId) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
