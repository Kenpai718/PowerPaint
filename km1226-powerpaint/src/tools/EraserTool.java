package tools;

<<<<<<< Updated upstream
import java.awt.Point;
import java.awt.Shape;
import java.awt.event.KeyEvent;
import java.awt.geom.Path2D;

/**
=======
import java.awt.event.KeyEvent;

/**
 * Eraser tool is like the pencil tool but draws a white path to erase.
>>>>>>> Stashed changes
 * 
 * @author Kenneth Ahrens
 * @author Katlyn Malone
 * @version Fall 2020
 */

<<<<<<< Updated upstream
public class EraserTool extends AbstractPaintTool {

	private static final String NAME = "Eraser";

	private static final int MNEMONIC = KeyEvent.VK_A;
	
	private Point myNextPoint;

	private Path2D.Double myEraser;

	// note to self: this probably extends pencil
	public EraserTool() {
		super(NAME, MNEMONIC);
		myNextPoint = NO_POINT;
		myEraser = new Path2D.Double();
	}

	@Override
	public Shape getShape() {
		return myEraser;
	}

	@Override
	public void setStartPoint(final Point thePoint) {
		super.setStartPoint(thePoint);
		myEraser.moveTo(thePoint.getX(),  thePoint.getY()); 
	}

	@Override
	public void setNextPoint(Point thePoint) {
		myEraser.lineTo(thePoint.getX(), thePoint.getY());
	}
		
	@Override
	public void reset() {
		super.reset();
		myEraser = new Path2D.Double();
		myNextPoint = NO_POINT;
=======
public class EraserTool extends PencilTool {

	/** Constant name for the tool */
	private static final String NAME = "Eraser";

	/** Constant mnemonic for the tool */
	private static final int MNEMONIC = KeyEvent.VK_A;

	/**
	 * Default constructor: defines eraser
	 * 
	 */
	public EraserTool() {
		super(NAME, MNEMONIC);
>>>>>>> Stashed changes
	}

}
