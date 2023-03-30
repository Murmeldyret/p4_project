/* This file was generated by SableCC (http://www.sablecc.org/). */

package postfix.node;

import postfix.analysis.*;

@SuppressWarnings("nls")
public final class TSopCount extends Token
{
    public TSopCount()
    {
        super.setText("count");
    }

    public TSopCount(int line, int pos)
    {
        super.setText("count");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TSopCount(getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTSopCount(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TSopCount text.");
    }
}
