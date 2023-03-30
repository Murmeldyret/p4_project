/* This file was generated by SableCC (http://www.sablecc.org/). */

package postfix.node;

import postfix.analysis.*;

@SuppressWarnings("nls")
public final class TUnaryPrefixOp extends Token
{
    public TUnaryPrefixOp(String text)
    {
        setText(text);
    }

    public TUnaryPrefixOp(String text, int line, int pos)
    {
        setText(text);
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TUnaryPrefixOp(getText(), getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTUnaryPrefixOp(this);
    }
}
