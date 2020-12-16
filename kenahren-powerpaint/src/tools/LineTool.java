package tools;

import java.awt.Point;
import java.awt.Shape;
import java.awt.event.KeyEvent;
import java.awt.geom.Line2D;

/**
 * 
 * @author Kenneth Ahrens
 * @author Katlyn Malone
 * @version Fall 2020
 */

public class LineTool extends AbstractPaintTool {

	private static final String NAME = "Line";

	private static final int MNEMONIC = KeyEvent.VK_L;

	private Point myNextPoint;

	public LineTool() {
		super(NAME, MNEMONIC);
		myNextPoint = NO_POINT;
	}
	
	public LineTool(String theName, int theMnemonic) {
		super(theName, theMnemonic);
		myNextPoint = NO_POINT;
	}

	@Override
	public Shape getShape() {
		return new Line2D.Double(getStartPoint().x, getStartPoint().y,
				myNextPoint.x, myNextPoint.y);
	}

	@Override
	public void setStartPoint(Point thePoint) {
		super.setStartPoint(thePoint);
		myNextPoint = thePoint;
	}

	@Override
	public void setNextPoint(Point thePoint) {
		myNextPoint = thePoint;
	}

	@Override
	public void reset() {
		super.reset();
		myNextPoint = NO_POINT;
	}
	
	public String getName() {
		return NAME;
	}

}
