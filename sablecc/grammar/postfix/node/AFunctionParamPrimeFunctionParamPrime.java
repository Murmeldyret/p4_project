/* This file was generated by SableCC (http://www.sablecc.org/). */

package postfix.node;

import postfix.analysis.*;

@SuppressWarnings("nls")
public final class AFunctionParamPrimeFunctionParamPrime extends PFunctionParamPrime
{
    private TSopComma _sopComma_;
    private PDcl _dcl_;
    private PFunctionParamPrime _functionParamPrime_;

    public AFunctionParamPrimeFunctionParamPrime()
    {
        // Constructor
    }

    public AFunctionParamPrimeFunctionParamPrime(
        @SuppressWarnings("hiding") TSopComma _sopComma_,
        @SuppressWarnings("hiding") PDcl _dcl_,
        @SuppressWarnings("hiding") PFunctionParamPrime _functionParamPrime_)
    {
        // Constructor
        setSopComma(_sopComma_);

        setDcl(_dcl_);

        setFunctionParamPrime(_functionParamPrime_);

    }

    @Override
    public Object clone()
    {
        return new AFunctionParamPrimeFunctionParamPrime(
            cloneNode(this._sopComma_),
            cloneNode(this._dcl_),
            cloneNode(this._functionParamPrime_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAFunctionParamPrimeFunctionParamPrime(this);
    }

    public TSopComma getSopComma()
    {
        return this._sopComma_;
    }

    public void setSopComma(TSopComma node)
    {
        if(this._sopComma_ != null)
        {
            this._sopComma_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._sopComma_ = node;
    }

    public PDcl getDcl()
    {
        return this._dcl_;
    }

    public void setDcl(PDcl node)
    {
        if(this._dcl_ != null)
        {
            this._dcl_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._dcl_ = node;
    }

    public PFunctionParamPrime getFunctionParamPrime()
    {
        return this._functionParamPrime_;
    }

    public void setFunctionParamPrime(PFunctionParamPrime node)
    {
        if(this._functionParamPrime_ != null)
        {
            this._functionParamPrime_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._functionParamPrime_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._sopComma_)
            + toString(this._dcl_)
            + toString(this._functionParamPrime_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._sopComma_ == child)
        {
            this._sopComma_ = null;
            return;
        }

        if(this._dcl_ == child)
        {
            this._dcl_ = null;
            return;
        }

        if(this._functionParamPrime_ == child)
        {
            this._functionParamPrime_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._sopComma_ == oldChild)
        {
            setSopComma((TSopComma) newChild);
            return;
        }

        if(this._dcl_ == oldChild)
        {
            setDcl((PDcl) newChild);
            return;
        }

        if(this._functionParamPrime_ == oldChild)
        {
            setFunctionParamPrime((PFunctionParamPrime) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
