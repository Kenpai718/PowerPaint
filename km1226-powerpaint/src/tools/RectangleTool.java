package tools;

import java.awt.Point;
import java.awt.Shape;
import java.awt.event.KeyEvent;
<<<<<<< Updated upstream
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

/**
=======
import java.awt.geom.Rectangle2D;

/**
 * Tool draws a rectangle shape
>>>>>>> Stashed changes
 * 
 * @author Kenneth Ahrens
 * @author Katlyn Malone
 * @version Fall 2020
 */

public class RectangleTool extends AbstractPaintTool {

<<<<<<< Updated upstream
	private static final String MY_NAME = "Rectangle";

	private static final int MY_MNEMONIC = KeyEvent.VK_R;

	private Point myNextPoint;

=======
	/** Constant name for the tool */
	private static final String MY_NAME = "Rectangle";

	/** Constant mnemonic for the tool */
	private static final int MY_MNEMONIC = KeyEvent.VK_R;

	/**Next point field */
	private Point myNextPoint;

	/**
	 * Default constructor: defines rectangle
	 * 
	 */
>>>>>>> Stashed changes
	public RectangleTool() {
		super(MY_NAME, MY_MNEMONIC);
		myNextPoint = NO_POINT;
	}
<<<<<<< Updated upstream

=======
	
	/**
	 * Constructor for inheritance
	 * 
	 * @param theName     is the name of the tool
	 * @param theMnemonic is the keyboard shortcut value of the tool
	 */
	public RectangleTool(final String theName, final int theMnemonic) {
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
		final Rectangle2D.Double rect = new Rectangle2D.Double();
		rect.setFrameFromDiagonal(getStartPoint(), myNextPoint);
		return rect;
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
