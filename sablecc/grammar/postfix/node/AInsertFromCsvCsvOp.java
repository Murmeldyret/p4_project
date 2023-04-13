/* This file was generated by SableCC (http://www.sablecc.org/). */

package postfix.node;

import postfix.analysis.*;

@SuppressWarnings("nls")
public final class AInsertFromCsvCsvOp extends PCsvOp
{
    private TKwInsert _kwInsert_;
    private POrientation _orientation_;
    private PVal _val_;
    private PArrayExpr _arrayExpr_;
    private TKwIn _kwIn_;
    private TId _id_;

    public AInsertFromCsvCsvOp()
    {
        // Constructor
    }

    public AInsertFromCsvCsvOp(
        @SuppressWarnings("hiding") TKwInsert _kwInsert_,
        @SuppressWarnings("hiding") POrientation _orientation_,
        @SuppressWarnings("hiding") PVal _val_,
        @SuppressWarnings("hiding") PArrayExpr _arrayExpr_,
        @SuppressWarnings("hiding") TKwIn _kwIn_,
        @SuppressWarnings("hiding") TId _id_)
    {
        // Constructor
        setKwInsert(_kwInsert_);

        setOrientation(_orientation_);

        setVal(_val_);

        setArrayExpr(_arrayExpr_);

        setKwIn(_kwIn_);

        setId(_id_);

    }

    @Override
    public Object clone()
    {
        return new AInsertFromCsvCsvOp(
            cloneNode(this._kwInsert_),
            cloneNode(this._orientation_),
            cloneNode(this._val_),
            cloneNode(this._arrayExpr_),
            cloneNode(this._kwIn_),
            cloneNode(this._id_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAInsertFromCsvCsvOp(this);
    }

    public TKwInsert getKwInsert()
    {
        return this._kwInsert_;
    }

    public void setKwInsert(TKwInsert node)
    {
        if(this._kwInsert_ != null)
        {
            this._kwInsert_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._kwInsert_ = node;
    }

    public POrientation getOrientation()
    {
        return this._orientation_;
    }

    public void setOrientation(POrientation node)
    {
        if(this._orientation_ != null)
        {
            this._orientation_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._orientation_ = node;
    }

    public PVal getVal()
    {
        return this._val_;
    }

    public void setVal(PVal node)
    {
        if(this._val_ != null)
        {
            this._val_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._val_ = node;
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

    public TKwIn getKwIn()
    {
        return this._kwIn_;
    }

    public void setKwIn(TKwIn node)
    {
        if(this._kwIn_ != null)
        {
            this._kwIn_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._kwIn_ = node;
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
            + toString(this._kwInsert_)
            + toString(this._orientation_)
            + toString(this._val_)
            + toString(this._arrayExpr_)
            + toString(this._kwIn_)
            + toString(this._id_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._kwInsert_ == child)
        {
            this._kwInsert_ = null;
            return;
        }

        if(this._orientation_ == child)
        {
            this._orientation_ = null;
            return;
        }

        if(this._val_ == child)
        {
            this._val_ = null;
            return;
        }

        if(this._arrayExpr_ == child)
        {
            this._arrayExpr_ = null;
            return;
        }

        if(this._kwIn_ == child)
        {
            this._kwIn_ = null;
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
        if(this._kwInsert_ == oldChild)
        {
            setKwInsert((TKwInsert) newChild);
            return;
        }

        if(this._orientation_ == oldChild)
        {
            setOrientation((POrientation) newChild);
            return;
        }

        if(this._val_ == oldChild)
        {
            setVal((PVal) newChild);
            return;
        }

        if(this._arrayExpr_ == oldChild)
        {
            setArrayExpr((PArrayExpr) newChild);
            return;
        }

        if(this._kwIn_ == oldChild)
        {
            setKwIn((TKwIn) newChild);
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
