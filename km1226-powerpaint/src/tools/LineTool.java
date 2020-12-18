package tools;

import java.awt.Point;
import java.awt.Shape;
import java.awt.event.KeyEvent;
import java.awt.geom.Line2D;

/**
<<<<<<< Updated upstream
=======
 * This tool draws a line
>>>>>>> Stashed changes
 * 
 * @author Kenneth Ahrens
 * @author Katlyn Malone
 * @version Fall 2020
 */

public class LineTool extends AbstractPaintTool {

<<<<<<< Updated upstream
	private static final String NAME = "Line";

	private static final int MNEMONIC = KeyEvent.VK_L;

	private Point myNextPoint;

=======
	/** Constant name for the tool */
	private static final String NAME = "Line";

	/** Constant mnemonic for the tool */
	private static final int MNEMONIC = KeyEvent.VK_L;

	/**Next point field */
	private Point myNextPoint;

	/**
	 * Default constructor: defines line
	 * 
	 */
>>>>>>> Stashed changes
	public LineTool() {
		super(NAME, MNEMONIC);
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
	public LineTool(final String theName, final int theMnemonic) {
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
		return new Line2D.Double(getStartPoint().x, getStartPoint().y,
				myNextPoint.x, myNextPoint.y);
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
	
<<<<<<< Updated upstream
=======
	/**
	 * Getter for name of tool
	 * 
	 * @return String name of tool
	 */
>>>>>>> Stashed changes
	public String getName() {
		return NAME;
	}

}
