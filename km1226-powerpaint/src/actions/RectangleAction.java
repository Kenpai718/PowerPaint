package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.geom.Point2D;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;

<<<<<<< Updated upstream
<<<<<<< Updated upstream
=======
import tools.PaintTool;
import tools.RectangleTool;
>>>>>>> Stashed changes
import view.PaintPanel;

=======
import tools.PaintTool;
import tools.RectangleTool;
import view.PaintPanel;

/**
 * 
 * @author Kenneth Ahrens
 * @author Katlyn Malone
 * @version Fall 2020
 */

>>>>>>> Stashed changes
public class RectangleAction extends AbstractAction{

    
	//constants
	public static final String NAME = "Rectangle";
    public static final ImageIcon ICON = new ImageIcon("./images/rectangle_bw.gif");
    
	
    /** The JPanel to associate with this Action. */
    private final PaintPanel myPanel;
    
<<<<<<< Updated upstream
<<<<<<< Updated upstream
=======
    /** The tool that represents the Rectangle. */
    private final PaintTool myTool;
>>>>>>> Stashed changes
=======
    /** The tool that represents the Rectangle. */
    private final PaintTool myTool;
>>>>>>> Stashed changes
    
   /**
     * Construct an Action of the rectangle tool.
     * 
     * @param thePanel a JPanel to associate with this Action.
     */
    public RectangleAction(final PaintPanel thePanel) {
        super(NAME, ICON);
        
<<<<<<< Updated upstream
<<<<<<< Updated upstream
        putValue(Action.MNEMONIC_KEY, KeyEvent.VK_R);
        putValue(Action.SELECTED_KEY, true);
        putValue(Action.SHORT_DESCRIPTION, "A rectangle");
        
        myPanel = thePanel;
=======
=======
>>>>>>> Stashed changes
        
        myPanel = thePanel;
        myTool = new RectangleTool();
        
        putValue(Action.MNEMONIC_KEY, myTool.getMnemonic());
        putValue(Action.SELECTED_KEY, true);
<<<<<<< Updated upstream
        putValue(Action.SHORT_DESCRIPTION, "A rectangle");
        
>>>>>>> Stashed changes
=======
        putValue(Action.SHORT_DESCRIPTION, "A Rectangle");
        
>>>>>>> Stashed changes

    }
    
    @Override
    public void actionPerformed(final ActionEvent theEvent) {
<<<<<<< Updated upstream
<<<<<<< Updated upstream

        myPanel.repaint();
    }
    
=======
=======
>>>>>>> Stashed changes
    	myPanel.setCurrentTool(myTool);
        myPanel.repaint();
    }
    
    public PaintTool getTool() {
    	return myTool;
    }
    
<<<<<<< Updated upstream
>>>>>>> Stashed changes
=======

    @Override
    public String toString() {
    	return NAME;
    }
>>>>>>> Stashed changes
}
