package tools;

import java.awt.Point;
import java.awt.Shape;
import java.awt.event.KeyEvent;
import java.awt.geom.Path2D;

/**
 * 
<<<<<<< Updated upstream
=======
 * Pencil tool draws a path following user input
 * 
>>>>>>> Stashed changes
 * @author Kenneth Ahrens
 * @author Katlyn Malone
 * @version Fall 2020
 */

public class PencilTool extends AbstractPaintTool {
<<<<<<< Updated upstream
	
	private static final String NAME = "Pencil";
	
	private static final int MNEMONIC = KeyEvent.VK_P;
	
	private Point myNextPoint;
	
	private Path2D.Double myPencil;
	
	
	public PencilTool() {
		super(NAME, MNEMONIC);
		myNextPoint = NO_POINT;
		myPencil = new Path2D.Double();
	}

=======

	/** Constant name for the tool */
	private static final String NAME = "Pencil";

	/** Constant mnemonic for the tool */
	private static final int MNEMONIC = KeyEvent.VK_P;


	/** Path2D to represent the pencil */
	private Path2D.Double myPencil;

	/**
	 * Default constructor: defines pencil
	 * 
	 */
	public PencilTool() {
		super(NAME, MNEMONIC);
		myPencil = new Path2D.Double();
	}

	/**
	 * Constructor for inheritance
	 * 
	 * @param theName     is the name of the tool
	 * @param theMnemonic is the keyboard shortcut value of the tool
	 */
	public PencilTool(final String theName, final int theMnemonic) {
		super(theName, theMnemonic);
		myPencil = new Path2D.Double();
	}

	/**
	 * Get Shape of the tool
	 * 
	 * @return Shape of tool
	 */
>>>>>>> Stashed changes
	@Override
	public Shape getShape() {
		return myPencil;
	}
<<<<<<< Updated upstream
	
	 @Override
	public void setStartPoint(final Point thePoint) {
	    super.setStartPoint(thePoint);
	    myPencil.moveTo(thePoint.getX(),  thePoint.getY()); 
	}

	@Override
	public void setNextPoint(Point thePoint) {
		 myPencil.lineTo(thePoint.getX(), thePoint.getY());
	}
	
=======

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
	public void setNextPoint(final Point thePoint) {
		myPencil.lineTo(thePoint.getX(), thePoint.getY());
	}

	/**
	 * Reset tool to default
	 */
>>>>>>> Stashed changes
	@Override
	public void reset() {
		super.reset();
		myPencil = new Path2D.Double();
<<<<<<< Updated upstream
		myNextPoint = NO_POINT;
=======
>>>>>>> Stashed changes
	}

}
