package actions;

<<<<<<< Updated upstream


=======
>>>>>>> Stashed changes
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.geom.Point2D;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;

<<<<<<< Updated upstream
<<<<<<< Updated upstream
=======
import tools.LineTool;
import tools.PaintTool;
import tools.PencilTool;
>>>>>>> Stashed changes
import view.PaintPanel;

=======
import tools.LineTool;
import tools.PaintTool;
import tools.PencilTool;
import view.PaintPanel;

/**
 * 
 * @author Kenneth Ahrens
 * @author Katlyn Malone
 * @version Fall 2020
 */

>>>>>>> Stashed changes
public class PencilAction extends AbstractAction{
	
	//constants
	public static final String NAME = "Pencil";
    public static final ImageIcon ICON = new ImageIcon("./images/pencil_bw.gif");
    
<<<<<<< Updated upstream
	
    /** The JPanel to associate with this Action. */
    private final PaintPanel myPanel;
    
<<<<<<< Updated upstream
=======
    private final PaintTool myTool;
    
>>>>>>> Stashed changes
	
	
	
	   /**
=======
    /** The JPanel to associate with this Action. */
    private final PaintPanel myPanel;
    
    private final PaintTool myTool;
	
	 /**
>>>>>>> Stashed changes
     * Construct an Action of the pencil tool.
     * 
     * @param thePanel a JPanel to associate with this Action.
     */
    public PencilAction(final PaintPanel thePanel) {
        super(NAME, ICON);
        
<<<<<<< Updated upstream
<<<<<<< Updated upstream
        putValue(Action.MNEMONIC_KEY, KeyEvent.VK_P);
        putValue(Action.SELECTED_KEY, true);
        putValue(Action.SHORT_DESCRIPTION, "A Pencil");
        
        myPanel = thePanel;
=======
        myPanel = thePanel;
        myTool = new LineTool();
=======
        myPanel = thePanel;
        myTool = new PencilTool();
>>>>>>> Stashed changes
        
        putValue(Action.MNEMONIC_KEY, myTool.getMnemonic());
        putValue(Action.SELECTED_KEY, true);
        putValue(Action.SHORT_DESCRIPTION, "A Pencil");
       
<<<<<<< Updated upstream
>>>>>>> Stashed changes

=======
>>>>>>> Stashed changes
    }
    
    @Override
    public void actionPerformed(final ActionEvent theEvent) {
<<<<<<< Updated upstream
<<<<<<< Updated upstream

        myPanel.repaint();
    }
=======
    	myPanel.setCurrentTool(myTool);
        myPanel.repaint();
    }
 
>>>>>>> Stashed changes
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
