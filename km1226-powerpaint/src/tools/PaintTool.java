package tools;

import java.awt.Point;
import java.awt.Shape;

/**
<<<<<<< Updated upstream
=======
 * Defines what makes a tool
>>>>>>> Stashed changes
 * 
 * @author Kenneth Ahrens
 * @author Katlyn Malone
 * @version Fall 2020
 */

public interface PaintTool {
	
<<<<<<< Updated upstream
	String getName();
	int getMnemonic();
	Shape getShape();
	void setStartPoint(Point thePoint);
	void setNextPoint(Point thePoint);
	Point getStartPoint();
=======
	/**
	 * Get the name of the tool
	 * 
	 * @return String the name of the tool
	 */
	String getName();
	
	/**
	 * Get the mnemonic of the tool
	 * 
	 * @return int the mnemonic value
	 */
	int getMnemonic();
	
	/**
	 * Get Shape of the tool
	 * 
	 * @return Shape of tool
	 */
	Shape getShape();
	
	/**
	 * Change starting point
	 * 
	 * @param thePoint is the new start point
	 */
	void setStartPoint(final Point thePoint);
	
	/**
	 * Change next point
	 * 
	 * @param thePoint is the new next point
	 */
	void setNextPoint(final Point thePoint);
	
	/**
	 * Get starting point
	 * 
	 * @return Point the start point
	 */
	Point getStartPoint();
	
	/**
	 * Reset tool to default
	 */
>>>>>>> Stashed changes
	void reset();

}
