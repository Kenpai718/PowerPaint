package actions;



import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.geom.Point2D;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;

import view.PaintPanel;

public class PencilAction extends AbstractAction{
	
	//constants
	public static final String NAME = "Pencil";
    public static final ImageIcon ICON = new ImageIcon("./images/pencil_bw.gif");
    
	
    /** The JPanel to associate with this Action. */
    private final PaintPanel myPanel;
    
	
	
	
	   /**
     * Construct an Action of the pencil tool.
     * 
     * @param thePanel a JPanel to associate with this Action.
     */
    public PencilAction(final PaintPanel thePanel) {
        super(NAME, ICON);
        
        putValue(Action.MNEMONIC_KEY, KeyEvent.VK_P);
        putValue(Action.SELECTED_KEY, true);
        putValue(Action.SHORT_DESCRIPTION, "A Pencil");
        
        myPanel = thePanel;

    }
    
    @Override
    public void actionPerformed(final ActionEvent theEvent) {

        myPanel.repaint();
    }
}
