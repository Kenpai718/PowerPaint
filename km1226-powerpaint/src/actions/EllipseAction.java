package actions;

<<<<<<< Updated upstream
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.geom.Point2D;
=======
/**
 * Sets up the Ellipse action for a button.
 * 
 * @author Kenneth Ahrens
 * @author Katlyn Malone
 * @version Fall 2020
 *
 */

import java.awt.event.ActionEvent;
>>>>>>> Stashed changes

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;

import tools.EllipseTool;
import tools.PaintTool;
import view.PaintPanel;

/**
 * 
 * @author Kenneth Ahrens
 * @author Katlyn Malone
 * @version Fall 2020
 */

public class EllipseAction extends AbstractAction {
	
	//constants
<<<<<<< Updated upstream
	public static final String NAME = "Ellipse";
=======
	/** Name for the button*/
	public static final String NAME = "Ellipse";
	/** Icon for the button*/
>>>>>>> Stashed changes
    public static final ImageIcon ICON = new ImageIcon("./images/ellipse_bw.gif");
    
	
    /** The JPanel to associate with this Action. */
    private final PaintPanel myPanel;
    
<<<<<<< Updated upstream
=======
    /**The tool that represents the ellipse.*/
>>>>>>> Stashed changes
    private PaintTool myTool;
    
   /**
     * Construct an Action of the Ellipse tool.
     * 
     * @param thePanel a JPanel to associate with this Action.
     */
    public EllipseAction(final PaintPanel thePanel) {
        super(NAME, ICON);
        
        
        myPanel = thePanel;
        myTool = new EllipseTool();
        
        putValue(Action.MNEMONIC_KEY, myTool.getMnemonic());
        putValue(Action.SELECTED_KEY, true);
        putValue(Action.SHORT_DESCRIPTION, "An Eclipse");

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
