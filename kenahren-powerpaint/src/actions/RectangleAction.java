package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.geom.Point2D;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;

import tools.PaintTool;
import tools.RectangleTool;
import view.PaintPanel;

/**
 * Sets up the rectangle action for a button
 * 
 * @author Kenneth Ahrens
 * @author Katlyn Malone
 * @version Fall 2020
 */

public class RectangleAction extends AbstractAction{

    
	//constants
	/** Name for the button*/
	public static final String NAME = "Rectangle";
	/** Name for the button*/
    public static final ImageIcon ICON = new ImageIcon("./images/rectangle_bw.gif");
    
	
    /** The JPanel to associate with this Action. */
    private final PaintPanel myPanel;
    
    /** The tool that represents the Rectangle. */
    private final PaintTool myTool;
    
   /**
     * Construct an Action of the rectangle tool.
     * 
     * @param thePanel a JPanel to associate with this Action.
     */
    public RectangleAction(final PaintPanel thePanel) {
        super(NAME, ICON);
        
        
        myPanel = thePanel;
        myTool = new RectangleTool();
        
        putValue(Action.MNEMONIC_KEY, myTool.getMnemonic());
        putValue(Action.SELECTED_KEY, true);
        putValue(Action.SHORT_DESCRIPTION, "A Rectangle");
        

    }
    
    /**
     * When clicking the button change to specified tool
     * 
     * @param ActionEvent clicking the button
     */
    @Override
    public void actionPerformed(final ActionEvent theEvent) {
    	myPanel.setCurrentTool(myTool);
        myPanel.repaint();
    }
    
    /**
     * Get tool for this action
     * 
     * @return the tool used for this action
     */
    public PaintTool getTool() {
    	return myTool;
    }
    

    @Override
    public String toString() {
    	return NAME;
    }
}
