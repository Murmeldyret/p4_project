/* This file was generated by SableCC (http://www.sablecc.org/). */

package postfix.node;

import postfix.analysis.*;

@SuppressWarnings("nls")
public final class AFunctionDeclarationDcl extends PDcl
{
    private TType _type_;
    private TKwFunction _kwFunction_;
    private TId _id_;
    private PFunctionParam _functionParam_;
    private PBlock _block_;

    public AFunctionDeclarationDcl()
    {
        // Constructor
    }

    public AFunctionDeclarationDcl(
        @SuppressWarnings("hiding") TType _type_,
        @SuppressWarnings("hiding") TKwFunction _kwFunction_,
        @SuppressWarnings("hiding") TId _id_,
        @SuppressWarnings("hiding") PFunctionParam _functionParam_,
        @SuppressWarnings("hiding") PBlock _block_)
    {
        // Constructor
        setType(_type_);

        setKwFunction(_kwFunction_);

        setId(_id_);

        setFunctionParam(_functionParam_);

        setBlock(_block_);

    }

    @Override
    public Object clone()
    {
        return new AFunctionDeclarationDcl(
            cloneNode(this._type_),
            cloneNode(this._kwFunction_),
            cloneNode(this._id_),
            cloneNode(this._functionParam_),
            cloneNode(this._block_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAFunctionDeclarationDcl(this);
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

    public TKwFunction getKwFunction()
    {
        return this._kwFunction_;
    }

    public void setKwFunction(TKwFunction node)
    {
        if(this._kwFunction_ != null)
        {
            this._kwFunction_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._kwFunction_ = node;
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

    public PFunctionParam getFunctionParam()
    {
        return this._functionParam_;
    }

    public void setFunctionParam(PFunctionParam node)
    {
        if(this._functionParam_ != null)
        {
            this._functionParam_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._functionParam_ = node;
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
            + toString(this._type_)
            + toString(this._kwFunction_)
            + toString(this._id_)
            + toString(this._functionParam_)
            + toString(this._block_);
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

        if(this._kwFunction_ == child)
        {
            this._kwFunction_ = null;
            return;
        }

        if(this._id_ == child)
        {
            this._id_ = null;
            return;
        }

        if(this._functionParam_ == child)
        {
            this._functionParam_ = null;
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
        if(this._type_ == oldChild)
        {
            setType((TType) newChild);
            return;
        }

        if(this._kwFunction_ == oldChild)
        {
            setKwFunction((TKwFunction) newChild);
            return;
        }

        if(this._id_ == oldChild)
        {
            setId((TId) newChild);
            return;
        }

        if(this._functionParam_ == oldChild)
        {
            setFunctionParam((PFunctionParam) newChild);
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
