package actions;



import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.geom.Point2D;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;

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

public class PencilAction extends AbstractAction{
	
	//constants
	public static final String NAME = "Pencil";
    public static final ImageIcon ICON = new ImageIcon("./images/pencil_bw.gif");
    
	
    /** The JPanel to associate with this Action. */
    private final PaintPanel myPanel;
    
    private final PaintTool myTool;
    
	
	
	
	   /**
     * Construct an Action of the pencil tool.
     * 
     * @param thePanel a JPanel to associate with this Action.
     */
    public PencilAction(final PaintPanel thePanel) {
        super(NAME, ICON);
        
        myPanel = thePanel;
        myTool = new PencilTool();
        
        putValue(Action.MNEMONIC_KEY, myTool.getMnemonic());
        putValue(Action.SELECTED_KEY, true);
        putValue(Action.SHORT_DESCRIPTION, "A Pencil");
       

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
    public String getActionName() {
    	return NAME;
    }
 
}
