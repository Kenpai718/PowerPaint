package tools;

import java.awt.Point;
import java.awt.Shape;

/**
 * 
 * @author Kenneth Ahrens
 * @author Katlyn Malone
 * @version Fall 2020
 */

public abstract class AbstractPaintTool implements PaintTool {
	
	public static final Point NO_POINT = new Point(-50, -50);
	private final String myName;
	private final int myMnemonic;
	private Point myStartPoint;
	
	
	public AbstractPaintTool (final String theName, final int theMnemonic) {
		myName = theName;
		myMnemonic = theMnemonic;
		myStartPoint = NO_POINT;
	}
	

	@Override
	public String getName() {
		return myName;
	}

	@Override
	public int getMnemonic() {
		return myMnemonic;
	}

	@Override
	public void setStartPoint(final Point thePoint) {
		myStartPoint = thePoint;

	}

	@Override
	public Point getStartPoint() {
		return myStartPoint;
	}


	@Override
	public void reset() {
		myStartPoint = NO_POINT;

	}
	
	@Override
	public abstract Shape getShape();
	
	@Override
	public abstract void setNextPoint(Point thePoint);
	
}
