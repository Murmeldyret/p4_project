/* This file was generated by SableCC (http://www.sablecc.org/). */

package postfix.node;

import postfix.analysis.*;

@SuppressWarnings("nls")
public final class TSopSum extends Token
{
    public TSopSum()
    {
        super.setText("sum");
    }

    public TSopSum(int line, int pos)
    {
        super.setText("sum");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TSopSum(getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTSopSum(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TSopSum text.");
    }
}
