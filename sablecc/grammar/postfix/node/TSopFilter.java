/* This file was generated by SableCC (http://www.sablecc.org/). */

package postfix.node;

import postfix.analysis.*;

@SuppressWarnings("nls")
public final class TSopFilter extends Token
{
    public TSopFilter()
    {
        super.setText("filter");
    }

    public TSopFilter(int line, int pos)
    {
        super.setText("filter");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TSopFilter(getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTSopFilter(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TSopFilter text.");
    }
}
