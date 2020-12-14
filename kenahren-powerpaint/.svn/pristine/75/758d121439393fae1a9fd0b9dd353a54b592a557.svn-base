package tools;

import java.awt.Point;
import java.awt.Shape;
import java.awt.event.KeyEvent;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

/**
 * 
 * @author Kenneth Ahrens
 * @author Katlyn Malone
 * @version Fall 2020
 */

public class RectangleTool extends AbstractPaintTool {

	private static final String MY_NAME = "Rectangle";

	private static final int MY_MNEMONIC = KeyEvent.VK_R;

	private Point myNextPoint;

	public RectangleTool() {
		super(MY_NAME, MY_MNEMONIC);
		myNextPoint = NO_POINT;
	}

	@Override
	public Shape getShape() {
		final Rectangle2D.Double rect = new Rectangle2D.Double();
		rect.setFrameFromDiagonal(getStartPoint(), myNextPoint);
		return rect;
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

}
