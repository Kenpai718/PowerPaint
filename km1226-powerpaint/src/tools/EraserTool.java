package tools;

import java.awt.Point;
import java.awt.Shape;
import java.awt.event.KeyEvent;
<<<<<<< Updated upstream

public class EraserTool extends AbstractPaintTool {

	private static final String NAME = "Line";

	private static final int MNEMONIC = KeyEvent.VK_A;

	// private Point myNextPoint;

	public EraserTool() {
		super(NAME, MNEMONIC);
=======
import java.awt.geom.Path2D;

/**
 * 
 * @author Kenneth Ahrens
 * @author Katlyn Malone
 * @version Fall 2020
 */

public class EraserTool extends AbstractPaintTool {

	private static final String NAME = "Eraser";

	private static final int MNEMONIC = KeyEvent.VK_A;
	
	private Point myNextPoint;

	private Path2D.Double myEraser;

	// note to self: this probably extends pencil
	public EraserTool() {
		super(NAME, MNEMONIC);
		myNextPoint = NO_POINT;
		myEraser = new Path2D.Double();
>>>>>>> Stashed changes
	}

	@Override
	public Shape getShape() {
<<<<<<< Updated upstream
		// TODO
		// return the shape that it is hovering over but cover it in white bg
		return null;
	}

	@Override
	public void setNextPoint(Point thePoint) {
		// TODO Auto-generated method stub

=======
		return myEraser;
	}

	@Override
	public void setStartPoint(final Point thePoint) {
		super.setStartPoint(thePoint);
		myEraser.moveTo(thePoint.getX(),  thePoint.getY()); 
	}

	@Override
	public void setNextPoint(Point thePoint) {
		myEraser.lineTo(thePoint.getX(), thePoint.getY());
	}
		
	@Override
	public void reset() {
		super.reset();
		myEraser = new Path2D.Double();
		myNextPoint = NO_POINT;
>>>>>>> Stashed changes
	}

}
