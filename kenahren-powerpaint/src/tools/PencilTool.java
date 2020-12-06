package tools;

import java.awt.Point;
import java.awt.Shape;
import java.awt.event.KeyEvent;
import java.awt.geom.Path2D;

public class PencilTool extends AbstractPaintTool {
	
	private static final String MY_NAME = "Pencil";
	
	private static final int MY_MNEMONIC = KeyEvent.VK_P;
	
	private Point myNextPoint;
	
	private Path2D myPen;
	
	
	public PencilTool() {
		super(MY_NAME, MY_MNEMONIC);
		myNextPoint = NO_POINT;
		myPen = new Path2D.Double();
	}

	@Override
	public Shape getShape() {
		
		return myPen;
		
	}

	@Override
	public void setNextPoint(Point thePoint) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void reset() {
		super.reset();
		myNextPoint = NO_POINT;
	}

}
