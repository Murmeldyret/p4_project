/* This file was generated by SableCC (http://www.sablecc.org/). */

package postfix.node;

import postfix.analysis.*;

@SuppressWarnings("nls")
public final class TSopSort extends Token
{
    public TSopSort()
    {
        super.setText("sort");
    }

    public TSopSort(int line, int pos)
    {
        super.setText("sort");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TSopSort(getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTSopSort(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TSopSort text.");
    }
}
