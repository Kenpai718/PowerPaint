package actions;

import java.awt.event.ActionEvent;
<<<<<<< Updated upstream
import java.awt.event.KeyEvent;
import java.awt.geom.Point2D;
=======
>>>>>>> Stashed changes

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;

import tools.EraserTool;
import tools.PaintTool;
import view.PaintPanel;

/**
<<<<<<< Updated upstream
=======
 * Sets up the Eraser action for a button
>>>>>>> Stashed changes
 * 
 * @author Kenneth Ahrens
 * @author Katlyn Malone
 * @version Fall 2020
 */

public class EraserAction extends AbstractAction {

	// constants
<<<<<<< Updated upstream
	public static final String NAME = "Eraser";
=======
	/** Name for the button*/
	public static final String NAME = "Eraser";
	/** Icon for the button*/
>>>>>>> Stashed changes
	public static final ImageIcon ICON = new ImageIcon("./images/eraser_bw.gif");

	/** The JPanel to associate with this Action. */
	private final PaintPanel myPanel;

<<<<<<< Updated upstream
=======
	/**The tool associated with this action*/
>>>>>>> Stashed changes
	private final PaintTool myTool;

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

<<<<<<< Updated upstream
=======
    /**
     * When clicking the button change to specified tool
     * 
     * @param ActionEvent clicking the button
     */
>>>>>>> Stashed changes
	@Override
	public void actionPerformed(final ActionEvent theEvent) {
		myPanel.setCurrentTool(myTool);
		myPanel.repaint();
	}
	
<<<<<<< Updated upstream
=======
    /**
     * Get tool for this action
     * 
     * @return the tool used for this action
     */
    public PaintTool getTool() {
    	return myTool;
    }
	
>>>>>>> Stashed changes
    @Override
    public String toString() {
    	return NAME;
    }

}
