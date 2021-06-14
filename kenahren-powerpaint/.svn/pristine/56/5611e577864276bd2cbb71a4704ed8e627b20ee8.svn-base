package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.geom.Point2D;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;

import tools.EraserTool;
import tools.PaintTool;
import view.PaintPanel;

/**
 * 
 * @author Kenneth Ahrens
 * @author Katlyn Malone
 * @version Fall 2020
 */

public class EraserAction extends AbstractAction {

	// constants
	public static final String NAME = "Eraser";
	public static final ImageIcon ICON = new ImageIcon(
			"./images/eraser_bw.gif");

	/** The JPanel to associate with this Action. */
	private final PaintPanel myPanel;

	private PaintTool myTool;

	/**
	 * Construct an Action of the Line tool.
	 * 
	 * @param thePanel a JPanel to associate with this Action.
	 */
	public EraserAction(final PaintPanel thePanel) {
		super(NAME, ICON);

		myPanel = thePanel;
		myTool = new EraserTool();

		putValue(Action.MNEMONIC_KEY, myTool.getMnemonic());
		putValue(Action.SELECTED_KEY, true);
		putValue(Action.SHORT_DESCRIPTION, "An Eraser");

	}

	@Override
	public void actionPerformed(final ActionEvent theEvent) {
		myPanel.setCurrentTool(myTool);
		myPanel.repaint();
	}
	
    @Override
    public String toString() {
    	return NAME;
    }

}
