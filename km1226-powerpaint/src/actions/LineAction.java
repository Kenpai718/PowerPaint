package actions;

import view.PaintPanel;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.geom.Point2D;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;

import tools.LineTool;
import tools.PaintTool;

<<<<<<< Updated upstream
=======
/**
 * 
 * @author Kenneth Ahrens
 * @author Katlyn Malone
 * @version Fall 2020
 */

>>>>>>> Stashed changes
public class LineAction extends AbstractAction {
	
	//constants
	public static final String NAME = "Line";
    public static final ImageIcon ICON = new ImageIcon("./images/line_bw.gif");
    
    /** The JPanel to associate with this Action. */
    private final PaintPanel myPanel;
    
    /** The tool that represents the Line. */
    private final PaintTool myTool;
<<<<<<< Updated upstream
<<<<<<< Updated upstream
    
=======
  
>>>>>>> Stashed changes
=======
  
>>>>>>> Stashed changes
    
    
   /**
     * Construct an Action of the Line tool.
     * 
     * @param thePanel a JPanel to associate with this Action.
     */
    public LineAction(final PaintPanel thePanel) {
        super(NAME, ICON);
        
<<<<<<< Updated upstream
<<<<<<< Updated upstream
        putValue(Action.MNEMONIC_KEY, KeyEvent.VK_L);
        putValue(Action.SELECTED_KEY, true);
        putValue(Action.SHORT_DESCRIPTION, "A Line");
        
        myPanel = thePanel;
        myTool = new LineTool();
=======
=======
>>>>>>> Stashed changes
        myPanel = thePanel;
        myTool = new LineTool();
        
        putValue(Action.MNEMONIC_KEY, myTool.getMnemonic());
        putValue(Action.SELECTED_KEY, true);
        putValue(Action.SHORT_DESCRIPTION, "A Line");
        
<<<<<<< Updated upstream
>>>>>>> Stashed changes
=======
>>>>>>> Stashed changes

    }
    
    @Override
    public void actionPerformed(final ActionEvent theEvent) {
    	myPanel.setCurrentTool(myTool);
        myPanel.repaint();
    }
    
    public PaintTool getTool() {
    	return myTool;
    }
    
<<<<<<< Updated upstream
=======
    @Override
    public String toString() {
    	return NAME;
    }
>>>>>>> Stashed changes
}