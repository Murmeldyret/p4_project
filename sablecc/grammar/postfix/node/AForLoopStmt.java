/* This file was generated by SableCC (http://www.sablecc.org/). */

package postfix.node;

import postfix.analysis.*;

@SuppressWarnings("nls")
public final class AForLoopStmt extends PStmt
{
    private TKwFor _kwFor_;
    private TId _id_;
    private TKwIn _kwIn_;
    private PVal _val_;
    private PBlock _block_;

    public AForLoopStmt()
    {
        // Constructor
    }

    public AForLoopStmt(
        @SuppressWarnings("hiding") TKwFor _kwFor_,
        @SuppressWarnings("hiding") TId _id_,
        @SuppressWarnings("hiding") TKwIn _kwIn_,
        @SuppressWarnings("hiding") PVal _val_,
        @SuppressWarnings("hiding") PBlock _block_)
    {
        // Constructor
        setKwFor(_kwFor_);

        setId(_id_);

        setKwIn(_kwIn_);

        setVal(_val_);

        setBlock(_block_);

    }

    @Override
    public Object clone()
    {
        return new AForLoopStmt(
            cloneNode(this._kwFor_),
            cloneNode(this._id_),
            cloneNode(this._kwIn_),
            cloneNode(this._val_),
            cloneNode(this._block_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAForLoopStmt(this);
    }

    public TKwFor getKwFor()
    {
        return this._kwFor_;
    }

    public void setKwFor(TKwFor node)
    {
        if(this._kwFor_ != null)
        {
            this._kwFor_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._kwFor_ = node;
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

    public PBlock getBlock()
    {
        return this._block_;
    }

    public void setBlock(PBlock node)
    {
        if(this._block_ != null)
        {
            this._block_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._block_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._kwFor_)
            + toString(this._id_)
            + toString(this._kwIn_)
            + toString(this._val_)
            + toString(this._block_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._kwFor_ == child)
        {
            this._kwFor_ = null;
            return;
        }

        if(this._id_ == child)
        {
            this._id_ = null;
            return;
        }

        if(this._kwIn_ == child)
        {
            this._kwIn_ = null;
            return;
        }

        if(this._val_ == child)
        {
            this._val_ = null;
            return;
        }

        if(this._block_ == child)
        {
            this._block_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._kwFor_ == oldChild)
        {
            setKwFor((TKwFor) newChild);
            return;
        }

        if(this._id_ == oldChild)
        {
            setId((TId) newChild);
            return;
        }

        if(this._kwIn_ == oldChild)
        {
            setKwIn((TKwIn) newChild);
            return;
        }

        if(this._val_ == oldChild)
        {
            setVal((PVal) newChild);
            return;
        }

        if(this._block_ == oldChild)
        {
            setBlock((PBlock) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
