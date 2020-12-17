package tools;

import java.awt.Point;
import java.awt.Shape;
import java.awt.event.KeyEvent;
import java.awt.geom.Path2D;

/**
 * 
 * Pencil tool draws a path following user input
 * 
 * @author Kenneth Ahrens
 * @author Katlyn Malone
 * @version Fall 2020
 */

public class PencilTool extends AbstractPaintTool {

	/** Constant name for the tool */
	private static final String NAME = "Pencil";

	/** Constant mnemonic for the tool */
	private static final int MNEMONIC = KeyEvent.VK_P;

	/** Next point on path */
	private Point myNextPoint;

	/** Path2D to represent the pencil */
	private Path2D.Double myPencil;

	/**
	 * Default constructor: defines pencil
	 * 
	 */
	public PencilTool() {
		super(NAME, MNEMONIC);
		myNextPoint = NO_POINT;
		myPencil = new Path2D.Double();
	}

	/**
	 * Constructor for inheritance
	 * 
	 * @param theName     is the name of the tool
	 * @param theMnemonic is the keyboard shortcut value of the tool
	 */
	public PencilTool(String theName, int theMnemonic) {
		super(theName, theMnemonic);
		myNextPoint = NO_POINT;
		myPencil = new Path2D.Double();
	}

	/**
	 * Get Shape of the tool
	 * 
	 * @return Shape of tool
	 */
	@Override
	public Shape getShape() {
		return myPencil;
	}

	/**
	 * Change starting point
	 * 
	 * @param thePoint is the new start point
	 */
	@Override
	public void setStartPoint(final Point thePoint) {
		super.setStartPoint(thePoint);
		myPencil.moveTo(thePoint.getX(), thePoint.getY());
	}

	/**
	 * Change next point
	 * 
	 * @param thePoint is the new next point
	 */
	@Override
	public void setNextPoint(Point thePoint) {
		myPencil.lineTo(thePoint.getX(), thePoint.getY());
	}

	/**
	 * Reset tool to default
	 */
	@Override
	public void reset() {
		super.reset();
		myPencil = new Path2D.Double();
		myNextPoint = NO_POINT;
	}

}
