package tools;

import java.awt.Point;
import java.awt.Shape;
import java.awt.event.KeyEvent;

public class EraserTool extends AbstractPaintTool {

	private static final String NAME = "Line";

	private static final int MNEMONIC = KeyEvent.VK_E;

	// private Point myNextPoint;

	public EraserTool() {
		super(NAME, MNEMONIC);
	}

	@Override
	public Shape getShape() {
		// TODO
		// return the shape that it is hovering over but cover it in white bg
		return null;
	}

	@Override
	public void setNextPoint(Point thePoint) {
		// TODO Auto-generated method stub

	}

}
