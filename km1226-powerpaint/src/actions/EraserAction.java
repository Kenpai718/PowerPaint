package actions;


import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.geom.Point2D;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;

<<<<<<< Updated upstream
=======
import tools.EraserTool;
import tools.PaintTool;
>>>>>>> Stashed changes
import view.PaintPanel;

public class EraserAction extends AbstractAction {
	
	//constants
	public static final String NAME = "Eraser";
    public static final ImageIcon ICON = new ImageIcon("./images/eraser_bw.gif");
    
	
    /** The JPanel to associate with this Action. */
    private final PaintPanel myPanel;
    
<<<<<<< Updated upstream
=======
    private PaintTool myTool;
    
>>>>>>> Stashed changes
	   /**
  * Construct an Action of the Line tool.
  * 
  * @param thePanel a JPanel to associate with this Action.
  */
 public EraserAction(final PaintPanel thePanel) {
     super(NAME, ICON);
     
<<<<<<< Updated upstream
     putValue(Action.MNEMONIC_KEY, KeyEvent.VK_D);
     putValue(Action.SELECTED_KEY, true);
     putValue(Action.SHORT_DESCRIPTION, "An eraser");
     
     myPanel = thePanel;
=======
     myPanel = thePanel;
     myTool = new EraserTool();
     
     putValue(Action.MNEMONIC_KEY, myTool.getMnemonic());
     putValue(Action.SELECTED_KEY, true);
     putValue(Action.SHORT_DESCRIPTION, "An eraser");
     
    
     
>>>>>>> Stashed changes
 }
 
 @Override
 public void actionPerformed(final ActionEvent theEvent) {
<<<<<<< Updated upstream
=======
	 myPanel.setCurrentTool(myTool);
>>>>>>> Stashed changes
     myPanel.repaint();
 }

}
