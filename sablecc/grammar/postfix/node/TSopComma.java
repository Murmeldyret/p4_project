/* This file was generated by SableCC (http://www.sablecc.org/). */

package postfix.node;

import postfix.analysis.*;

@SuppressWarnings("nls")
public final class TSopComma extends Token
{
    public TSopComma()
    {
        super.setText(",");
    }

    public TSopComma(int line, int pos)
    {
        super.setText(",");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TSopComma(getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTSopComma(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TSopComma text.");
    }
}
