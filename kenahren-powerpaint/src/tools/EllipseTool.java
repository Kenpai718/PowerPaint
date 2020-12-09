package tools;

import java.awt.Point;
import java.awt.Shape;
import java.awt.event.KeyEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

/**
 * 
 * @author Kenneth Ahrens
 * @author Katlyn Malone
 * @version Fall 2020
 */

public class EllipseTool extends AbstractPaintTool {

	private static final String MY_NAME = "Ellipse";

	private static final int MY_MNEMONIC = KeyEvent.VK_E;

	private Point myNextPoint;

	public EllipseTool() {
		super(MY_NAME, MY_MNEMONIC);
		myNextPoint = NO_POINT;
	}

	@Override
	public Shape getShape() {
		final Ellipse2D.Double el = new Ellipse2D.Double();
		el.setFrameFromDiagonal(getStartPoint(), myNextPoint);
		return el;
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
