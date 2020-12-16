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
import tools.EllipseTool;
import tools.PaintTool;
>>>>>>> Stashed changes
import view.PaintPanel;

=======
import tools.EllipseTool;
import tools.PaintTool;
import view.PaintPanel;

/**
 * 
 * @author Kenneth Ahrens
 * @author Katlyn Malone
 * @version Fall 2020
 */

>>>>>>> Stashed changes
public class EllipseAction extends AbstractAction {
	
	//constants
	public static final String NAME = "Ellipse";
    public static final ImageIcon ICON = new ImageIcon("./images/ellipse_bw.gif");
    
	
    /** The JPanel to associate with this Action. */
    private final PaintPanel myPanel;
    
<<<<<<< Updated upstream
<<<<<<< Updated upstream
=======
    private PaintTool myTool;
>>>>>>> Stashed changes
=======
    private PaintTool myTool;
>>>>>>> Stashed changes
    
   /**
     * Construct an Action of the Ellipse tool.
     * 
     * @param thePanel a JPanel to associate with this Action.
     */
    public EllipseAction(final PaintPanel thePanel) {
        super(NAME, ICON);
        
<<<<<<< Updated upstream
<<<<<<< Updated upstream
        putValue(Action.MNEMONIC_KEY, KeyEvent.VK_E);
        putValue(Action.SELECTED_KEY, true);
        putValue(Action.SHORT_DESCRIPTION, "A Eclipse");
        
        myPanel = thePanel;
=======
=======
>>>>>>> Stashed changes
        
        myPanel = thePanel;
        myTool = new EllipseTool();
        
        putValue(Action.MNEMONIC_KEY, myTool.getMnemonic());
        putValue(Action.SELECTED_KEY, true);
<<<<<<< Updated upstream
        putValue(Action.SHORT_DESCRIPTION, "A Eclipse");
>>>>>>> Stashed changes
=======
        putValue(Action.SHORT_DESCRIPTION, "An Eclipse");
>>>>>>> Stashed changes

    }
    
    @Override
    public void actionPerformed(final ActionEvent theEvent) {
<<<<<<< Updated upstream
<<<<<<< Updated upstream
=======
    	myPanel.setCurrentTool(myTool);
>>>>>>> Stashed changes
        myPanel.repaint();
    }
    
=======
    	myPanel.setCurrentTool(myTool);
        myPanel.repaint();
    }
    
    @Override
    public String toString() {
    	return NAME;
    }
    
>>>>>>> Stashed changes
}
