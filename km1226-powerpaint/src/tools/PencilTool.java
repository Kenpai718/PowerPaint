package tools;

import java.awt.Point;
import java.awt.Shape;
import java.awt.event.KeyEvent;
import java.awt.geom.Path2D;

<<<<<<< Updated upstream
public class PencilTool extends AbstractPaintTool {
	
	private static final String MY_NAME = "Pencil";
	
	private static final int MY_MNEMONIC = KeyEvent.VK_P;
	
	private Point myNextPoint;
	
	private Path2D myPen;
	
	
	public PencilTool() {
		super(MY_NAME, MY_MNEMONIC);
		myNextPoint = NO_POINT;
		myPen = new Path2D.Double();
=======
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
>>>>>>> Stashed changes
	}

	@Override
	public Shape getShape() {
<<<<<<< Updated upstream
		
		return myPen;
		
=======
		return myPencil;
	}
	
	 @Override
	public void setStartPoint(final Point thePoint) {
	    super.setStartPoint(thePoint);
	    myPencil.moveTo(thePoint.getX(),  thePoint.getY()); 
>>>>>>> Stashed changes
	}

	@Override
	public void setNextPoint(Point thePoint) {
<<<<<<< Updated upstream
		// TODO Auto-generated method stub

=======
		 myPencil.lineTo(thePoint.getX(), thePoint.getY());
>>>>>>> Stashed changes
	}
	
	@Override
	public void reset() {
		super.reset();
<<<<<<< Updated upstream
=======
		myPencil = new Path2D.Double();
>>>>>>> Stashed changes
		myNextPoint = NO_POINT;
	}

}
