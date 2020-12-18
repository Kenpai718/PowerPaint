package tools;

import java.awt.Point;
import java.awt.Shape;

/**
 * 
<<<<<<< Updated upstream
=======
 * Sets up most of the methods that define a tool.
 * 
>>>>>>> Stashed changes
 * @author Kenneth Ahrens
 * @author Katlyn Malone
 * @version Fall 2020
 */

public abstract class AbstractPaintTool implements PaintTool {
<<<<<<< Updated upstream
	
	public static final Point NO_POINT = new Point(-50, -50);
	private final String myName;
	private final int myMnemonic;
	private Point myStartPoint;
	
	
	public AbstractPaintTool (final String theName, final int theMnemonic) {
=======

	/** Constant for a point off the panel */
	public static final Point NO_POINT = new Point(-50, -50);
	/** Name for the tool */
	private final String myName;
	/** Mnemonic value for the tool */
	private final int myMnemonic;
	/** Starting point of the tool */
	private Point myStartPoint;

	/**
	 * Constructor
	 * 
	 * @param theName     is the name of the tool
	 * @param theMnemonic is the keyboard shortcut value of the tool
	 */
	public AbstractPaintTool(final String theName, final int theMnemonic) {
>>>>>>> Stashed changes
		myName = theName;
		myMnemonic = theMnemonic;
		myStartPoint = NO_POINT;
	}
<<<<<<< Updated upstream
	

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return myName;
	}

	@Override
	public int getMnemonic() {
		// TODO Auto-generated method stub
		return myMnemonic;
	}

=======

	/**
	 * Get the name of the tool
	 * 
	 * @return String the name of the tool
	 */
	@Override
	public String getName() {
		return myName;
	}

	/**
	 * Get the mnemonic of the tool
	 * 
	 * @return int the mnemonic value
	 */
	@Override
	public int getMnemonic() {
		return myMnemonic;
	}

	/**
	 * Set start point of the tool
	 * 
	 */
>>>>>>> Stashed changes
	@Override
	public void setStartPoint(final Point thePoint) {
		myStartPoint = thePoint;

	}

<<<<<<< Updated upstream
=======
	/**
	 * Get startpoint
	 * 
	 * @return Point startpoint
	 */
>>>>>>> Stashed changes
	@Override
	public Point getStartPoint() {
		return myStartPoint;
	}

<<<<<<< Updated upstream

=======
	/**
	 * Reset tools to default
	 */
>>>>>>> Stashed changes
	@Override
	public void reset() {
		myStartPoint = NO_POINT;

	}
<<<<<<< Updated upstream
	
	@Override
	public abstract Shape getShape();
	
	@Override
	public abstract void setNextPoint(Point thePoint);
	
=======

	/**
	 * Get Shape of the tool
	 * 
	 * @return Shape of tool
	 */
	@Override
	public abstract Shape getShape();

	/**
	 * Setter for next point
	 * 
	 */
	@Override
	public abstract void setNextPoint(final Point thePoint);

>>>>>>> Stashed changes
}
