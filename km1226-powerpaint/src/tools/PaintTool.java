package tools;

import java.awt.Point;
import java.awt.Shape;

public interface PaintTool {
	
	String getName();
	int getMnemonic();
	Shape getShape();
	void setStartPoint(Point thePoint);
	void setNextPoint(Point thePoint);
	Point getStartPoint();
	void reset();

}
