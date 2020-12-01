package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

import actions.PencilAction;
import actions.LineAction;
import actions.RectangleAction;
import actions.EllipseAction;
import actions.EraserAction;


public class PowerPaintGUI implements PropertyChangeListener {

	/** Slider minimum value. */
	private static final int THICKNESS_MIN = 0;

	/** Slider maximum value. */
	private static final int THICKNESS_MAX = 20;

	/** Slider major spacing. */
	private static final int MAJOR_SPACING = 5;

	/** Slider minor spacing. */
	private static final int MINOR_SPACING = 1;

	/** Slider initial value position. */
	private static final int THICKNESS_INIT = 1;

	/** A drawing panel. */
	private PaintPanel myPanel;

	/** The window for this GUI. */
	private JFrame myFrame;

	/** The top menu for this GUI. */
	private JMenuBar myMenuBar;

	/** Top tools menu bar. */
	private JMenu myToolsMenu;

	/** Top file menu bar. */
	private JMenu myFileMenu;

	/** Top help menu bar. */
	private JMenu myHelpMenu;

	/** The image icon to show in the window title and about window. */
	private ImageIcon myImageIcon = new ImageIcon("./images/w.gif");
	
    /** A list of color actions. */
    private ButtonGroup myToolButtons;
	
    /** A list of tool actions from actions package. */
    private List<Action> myToolActions;
    
    private JToolBar myToolBar;

	public PowerPaintGUI() {
		
		
		setupGUI();
		setupTopMenu();
		

	}

	public void setupGUI() {
		//initialize jframe
		myFrame = new JFrame("PowerPaint");
		myFrame.setVisible(true);
		myFrame.setSize(500, 500);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//initialize fields like menus 
		myPanel = new PaintPanel();
		myToolBar = new JToolBar();
		myToolActions = new ArrayList<Action>();
		myToolButtons = new ButtonGroup();

		//add buttons and menu options
		setupAction();
		setupTopMenu();
		
		
		myFrame.add(myToolBar, BorderLayout.SOUTH);

	}
	
	public void setupAction() {
		
        myToolActions.add(new PencilAction(myPanel));
        myToolActions.add(new LineAction(myPanel));
        myToolActions.add(new RectangleAction(myPanel));
        myToolActions.add(new EllipseAction(myPanel));
        myToolActions.add(new EraserAction(myPanel));
        
        // associate tool buttons with actions
        for (final Action act : myToolActions) {
        	final JToggleButton tb = new JToggleButton(act);
            myToolButtons.add(tb);
            myToolBar.add(tb);
        }
	}

	public void setupTopMenu() {
		myMenuBar = new JMenuBar();
		myFrame.setJMenuBar(myMenuBar);

		myFileMenu = new JMenu("File");
		myMenuBar.add(myFileMenu);
		JMenuItem exit = new JMenuItem("Exit");
		exit.addActionListener(new ExitAction());
		
	
		myFileMenu.add(exit);
		
		myToolsMenu = new JMenu("Tools");
		myMenuBar.add(myToolsMenu);

		myHelpMenu = new JMenu("Help");
		myMenuBar.add(myHelpMenu);
		
		

	}

	
	class ExitAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			//dispose(); idk how this works but tom has it
			System.exit(0);
			
		}
		
	}



	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub
		
	}
}
