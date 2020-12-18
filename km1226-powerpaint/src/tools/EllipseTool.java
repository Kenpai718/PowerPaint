package tools;

import java.awt.Point;
import java.awt.Shape;
import java.awt.event.KeyEvent;
import java.awt.geom.Ellipse2D;
<<<<<<< Updated upstream
import java.awt.geom.Line2D;

/**
 * 
=======

/**
 * 
 * Tool draws an ellipse shape
 * 
>>>>>>> Stashed changes
 * @author Kenneth Ahrens
 * @author Katlyn Malone
 * @version Fall 2020
 */

public class EllipseTool extends AbstractPaintTool {

<<<<<<< Updated upstream
	private static final String MY_NAME = "Ellipse";

	private static final int MY_MNEMONIC = KeyEvent.VK_E;

	private Point myNextPoint;

	public EllipseTool() {
		super(MY_NAME, MY_MNEMONIC);
		myNextPoint = NO_POINT;
	}

=======
	/** Constant name for the tool */
	private static final String NAME = "Ellipse";

	/** Constant mnemonic for the tool */
	private static final int MNEMONIC = KeyEvent.VK_E;

	/**Next point field */
	private Point myNextPoint;

	/**
	 * Default constructor: defines ellipse
	 * 
	 */
	public EllipseTool() {
		super(NAME, MNEMONIC);
		myNextPoint = NO_POINT;
	}
	
	/**
	 * Constructor for inheritance
	 * 
	 * @param theName     is the name of the tool
	 * @param theMnemonic is the keyboard shortcut value of the tool
	 */
	public EllipseTool(final String theName, final int theMnemonic) {
		super(theName, theMnemonic);
		myNextPoint = NO_POINT;
	}

	/**
	 * Get Shape of the tool
	 * 
	 * @return Shape of tool
	 */
>>>>>>> Stashed changes
	@Override
	public Shape getShape() {
		final Ellipse2D.Double el = new Ellipse2D.Double();
		el.setFrameFromDiagonal(getStartPoint(), myNextPoint);
		return el;
	}

<<<<<<< Updated upstream
	@Override
	public void setStartPoint(Point thePoint) {
=======
	/**
	 * Change starting point
	 * 
	 * @param thePoint is the new start point
	 */
	@Override
	public void setStartPoint(final Point thePoint) {
>>>>>>> Stashed changes
		super.setStartPoint(thePoint);
		myNextPoint = thePoint;
	}

<<<<<<< Updated upstream
	@Override
	public void setNextPoint(Point thePoint) {
		myNextPoint = thePoint;
	}

=======
	/**
	 * Change next point
	 * 
	 * @param thePoint is the new next point
	 */
	@Override
	public void setNextPoint(final Point thePoint) {
		myNextPoint = thePoint;
	}

	/**
	 * Reset tool to default
	 */
>>>>>>> Stashed changes
	@Override
	public void reset() {
		super.reset();
		myNextPoint = NO_POINT;
	}

}
