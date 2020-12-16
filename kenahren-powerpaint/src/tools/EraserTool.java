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

public class EraserTool extends PencilTool {

	private static final String NAME = "Eraser";

	private static final int MNEMONIC = KeyEvent.VK_A;

	
	public EraserTool() {
		super(NAME, MNEMONIC);
	}

}
