package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

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

	/** A button group for radio buttons. */
	//private final ButtonGroup myTopGroup;

	/** Top tools menu bar. */
	private JMenu myToolsMenu;

	/** Top file menu bar. */
	private JMenu myFileMenu;

	/** Top file menu bar. */
	private JMenu myHelpMenu;

	/** The image icon to show in the window title and about window. */
	private ImageIcon myImageIcon = new ImageIcon("./images/w.gif");

	public PowerPaintGUI() {
		setupGUI();
		setupTopMenu();

	}

	public void setupGUI() {
		myFrame = new JFrame("PowerPaint");
		myFrame.setVisible(true);
		myFrame.setSize(500, 500);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setupTopMenu();

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

		myHelpMenu = new JMenu("About");
		myMenuBar.add(myHelpMenu);
		
		

	}


	
	class ExitAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
			
		}
		
	}



	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub
		
	}
}
