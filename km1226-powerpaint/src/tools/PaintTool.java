package tools;

import java.awt.Point;
import java.awt.Shape;

<<<<<<< Updated upstream
=======
/**
 * 
 * @author Kenneth Ahrens
 * @author Katlyn Malone
 * @version Fall 2020
 */

>>>>>>> Stashed changes
public interface PaintTool {
	
	String getName();
	int getMnemonic();
	Shape getShape();
	void setStartPoint(Point thePoint);
	void setNextPoint(Point thePoint);
	Point getStartPoint();
	void reset();

}
