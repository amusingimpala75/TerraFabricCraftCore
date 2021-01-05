package com.github.amusingimpala75.terrafabriccraftcore.util;

public class CollapseData
{
	public ByteCoord coords;
	public float collapseChance;
	public ExtendedDirection direction;

	public CollapseData(ByteCoord c, float chance, ExtendedDirection d)
	{
		coords = c;
		collapseChance = chance;
		direction = d;
	}

	@Override
	public boolean equals(Object o)
	{
		return o instanceof CollapseData && ((CollapseData) o).coords.equals(coords);
	}
}
