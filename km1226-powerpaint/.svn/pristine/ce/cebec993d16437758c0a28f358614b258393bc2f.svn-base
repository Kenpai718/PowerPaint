package tools;

import java.awt.Point;
import java.awt.Shape;
import java.awt.event.KeyEvent;
import java.awt.geom.Path2D;

/**
 * 
 * @author Kenneth Ahrens
 * @author Katlyn Malone
 * @version Fall 2020
 */

public class EraserTool extends AbstractPaintTool {

	private static final String NAME = "Line";

	private static final int MNEMONIC = KeyEvent.VK_A;
	private Point myNextPoint;

	private Path2D myEraser;

	// note to self: this probably extends pencil
	public EraserTool() {
		super(NAME, MNEMONIC);
		myNextPoint = NO_POINT;
		myEraser = new Path2D.Double();
	}

	@Override
	public Shape getShape() {
		// TODO
		// return the shape that it is hovering over but cover it in white bg
		return myEraser;
	}

	@Override
	public void setNextPoint(Point thePoint) {
		// TODO Auto-generated method stub

	}

}
