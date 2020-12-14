package tools;

import java.awt.Point;
import java.awt.Shape;
import java.awt.event.KeyEvent;
import java.awt.geom.Path2D;

/**
 * 
 * @author Kenneth Ahrens
 * @author Katlyn Malone
 * @version Fall 2020
 */

public class PencilTool extends AbstractPaintTool {
	
	private static final String NAME = "Pencil";
	
	private static final int MNEMONIC = KeyEvent.VK_P;
	
	private Point myNextPoint;
	
	private Path2D myPen;
	
	
	public PencilTool() {
		super(NAME, MNEMONIC);
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
