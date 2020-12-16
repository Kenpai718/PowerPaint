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
	
	private Path2D.Double myPencil;
	
	
	public PencilTool() {
		super(NAME, MNEMONIC);
		myNextPoint = NO_POINT;
		myPencil = new Path2D.Double();
	}

	@Override
	public Shape getShape() {
		return myPencil;
	}
	
	 @Override
	public void setStartPoint(final Point thePoint) {
	    super.setStartPoint(thePoint);
	    myPencil.moveTo(thePoint.getX(),  thePoint.getY()); 
	}

	@Override
	public void setNextPoint(Point thePoint) {
		 myPencil.lineTo(thePoint.getX(), thePoint.getY());
	}
	
	@Override
	public void reset() {
		super.reset();
		myPencil = new Path2D.Double();
		myNextPoint = NO_POINT;
	}

}
