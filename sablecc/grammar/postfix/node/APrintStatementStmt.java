/* This file was generated by SableCC (http://www.sablecc.org/). */

package postfix.node;

import postfix.analysis.*;

@SuppressWarnings("nls")
public final class APrintStatementStmt extends PStmt
{
    private TKwPrint _kwPrint_;
    private TId _id_;
    private PExpr _expr_;

    public APrintStatementStmt()
    {
        // Constructor
    }

    public APrintStatementStmt(
        @SuppressWarnings("hiding") TKwPrint _kwPrint_,
        @SuppressWarnings("hiding") TId _id_,
        @SuppressWarnings("hiding") PExpr _expr_)
    {
        // Constructor
        setKwPrint(_kwPrint_);

        setId(_id_);

        setExpr(_expr_);

    }

    @Override
    public Object clone()
    {
        return new APrintStatementStmt(
            cloneNode(this._kwPrint_),
            cloneNode(this._id_),
            cloneNode(this._expr_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAPrintStatementStmt(this);
    }

    public TKwPrint getKwPrint()
    {
        return this._kwPrint_;
    }

    public void setKwPrint(TKwPrint node)
    {
        if(this._kwPrint_ != null)
        {
            this._kwPrint_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._kwPrint_ = node;
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
            + toString(this._kwPrint_)
            + toString(this._id_)
            + toString(this._expr_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._kwPrint_ == child)
        {
            this._kwPrint_ = null;
            return;
        }

        if(this._id_ == child)
        {
            this._id_ = null;
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
        if(this._kwPrint_ == oldChild)
        {
            setKwPrint((TKwPrint) newChild);
            return;
        }

        if(this._id_ == oldChild)
        {
            setId((TId) newChild);
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
