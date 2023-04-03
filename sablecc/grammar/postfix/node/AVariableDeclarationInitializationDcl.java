/* This file was generated by SableCC (http://www.sablecc.org/). */

package postfix.node;

import postfix.analysis.*;

@SuppressWarnings("nls")
public final class AVariableDeclarationInitializationDcl extends PDcl
{
    private TType _type_;
    private TId _id_;
    private TOpAssign _opAssign_;
    private PExpr _expr_;

    public AVariableDeclarationInitializationDcl()
    {
        // Constructor
    }

    public AVariableDeclarationInitializationDcl(
        @SuppressWarnings("hiding") TType _type_,
        @SuppressWarnings("hiding") TId _id_,
        @SuppressWarnings("hiding") TOpAssign _opAssign_,
        @SuppressWarnings("hiding") PExpr _expr_)
    {
        // Constructor
        setType(_type_);

        setId(_id_);

        setOpAssign(_opAssign_);

        setExpr(_expr_);

    }

    @Override
    public Object clone()
    {
        return new AVariableDeclarationInitializationDcl(
            cloneNode(this._type_),
            cloneNode(this._id_),
            cloneNode(this._opAssign_),
            cloneNode(this._expr_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAVariableDeclarationInitializationDcl(this);
    }

    public TType getType()
    {
        return this._type_;
    }

    public void setType(TType node)
    {
        if(this._type_ != null)
        {
            this._type_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._type_ = node;
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

    public TOpAssign getOpAssign()
    {
        return this._opAssign_;
    }

    public void setOpAssign(TOpAssign node)
    {
        if(this._opAssign_ != null)
        {
            this._opAssign_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._opAssign_ = node;
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
            + toString(this._type_)
            + toString(this._id_)
            + toString(this._opAssign_)
            + toString(this._expr_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._type_ == child)
        {
            this._type_ = null;
            return;
        }

        if(this._id_ == child)
        {
            this._id_ = null;
            return;
        }

        if(this._opAssign_ == child)
        {
            this._opAssign_ = null;
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
        if(this._type_ == oldChild)
        {
            setType((TType) newChild);
            return;
        }

        if(this._id_ == oldChild)
        {
            setId((TId) newChild);
            return;
        }

        if(this._opAssign_ == oldChild)
        {
            setOpAssign((TOpAssign) newChild);
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
