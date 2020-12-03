package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.geom.Point2D;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;

import view.PaintPanel;

public class RectangleAction extends AbstractAction{

    
	//constants
	public static final String NAME = "Rectangle";
    public static final ImageIcon ICON = new ImageIcon("./images/rectangle_bw.gif");
    
	
    /** The JPanel to associate with this Action. */
    private final PaintPanel myPanel;
    
    
   /**
     * Construct an Action of the rectangle tool.
     * 
     * @param thePanel a JPanel to associate with this Action.
     */
    public RectangleAction(final PaintPanel thePanel) {
        super(NAME, ICON);
        
        putValue(Action.MNEMONIC_KEY, KeyEvent.VK_R);
        putValue(Action.SELECTED_KEY, true);
        putValue(Action.SHORT_DESCRIPTION, "A rectangle");
        
        myPanel = thePanel;

    }
    
    @Override
    public void actionPerformed(final ActionEvent theEvent) {

        myPanel.repaint();
    }
    
}
