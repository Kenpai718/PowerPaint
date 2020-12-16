package view;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class PaintMenuBar extends JMenuBar implements PropertyChangeListener {
	
	//all the menu fields here 
    private final JMenuItem myClear;
    
    private final PaintPanel myPaintPanel;
    
    private final JFrame myFrame;

	public PaintMenuBar(JFrame theFrame, PaintPanel thePanel) {
		super();
		myPaintPanel = thePanel;
		myFrame = theFrame;
		
		myClear = new JMenuItem("clear");
		//now instantiate all the menu buttons fields like slider, drawing colors, etc
		
		//for communicating with paintpanel
		addPropertyChangeListener(this);
		
		//like we did in the GUI class start filling out the menubar
		setupMenu();
	}
	
	public void setupMenu() {
		
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub
		
	}


}
