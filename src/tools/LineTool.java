package tools;

import java.awt.Point;
import java.awt.Shape;
import java.awt.event.KeyEvent;
import java.awt.geom.Line2D;

public class LineTool extends AbstractPaintTool {

	private static final String MY_NAME = "Line";
	
	private static final int MY_MNEMONIC = KeyEvent.VK_L;
	
	private Point myNextPoint;
	
	public LineTool() {
		super(MY_NAME, MY_MNEMONIC);
		myNextPoint = NO_POINT;
	}
	
	@Override
	public Shape getShape() {
		return new Line2D.Double(getStartPoint().x, getStartPoint().y, myNextPoint.x, myNextPoint.y);
	}
	
	@Override
	public void setStartPoint(Point thePoint) {
		super.setStartPoint(thePoint);
		myNextPoint = thePoint;
	}
	
	@Override
	public void setNextPoint(Point thePoint) {
		myNextPoint = thePoint;
	}

	@Override
	public void reset() {
		super.reset();
		myNextPoint = NO_POINT;
	}
	
	
	
	
}
