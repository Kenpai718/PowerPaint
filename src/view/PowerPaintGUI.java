package view;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;

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

// to set up the Options menu in the main menu bar
		myFileMenu = new JMenu("Options");
		myFileMenu.setMnemonic(KeyEvent.VK_O);
		myMenuBar.add(myFileMenu);
		
		// this adds the thickness submenu
		JMenu myMenu = new JMenu("Thickness");
		myMenu.setMnemonic(KeyEvent.VK_T);
		myFileMenu.add(myMenu);
		
		myFileMenu.addSeparator();
		
		// adds the primary and secondary colors
		JButton primary = new JButton("Primary Color...");
		primary.setMnemonic(KeyEvent.VK_P);
		myFileMenu.add(primary);
		JButton secondary = new JButton("Secondary Color...");
		secondary.setMnemonic(KeyEvent.VK_S);
		myFileMenu.add(secondary);
		
		myFileMenu.addSeparator();
		// adds the clear function
		myFileMenu.add(new JMenuItem("Clear"));
		myFileMenu.addSeparator();
		JMenuItem exit = new JMenuItem("Exit");
		exit.addActionListener(new ExitAction());
		myFileMenu.add(exit);
		
// to set up the Tool menu in the main menu bar
		myToolsMenu = new JMenu("Tools");
		myToolsMenu.setMnemonic(KeyEvent.VK_T);
		myMenuBar.add(myToolsMenu);
		
		// create the radio list for our tools
		ButtonGroup group = new ButtonGroup();
		
		// add the pencil option
		JRadioButtonMenuItem pencilButton = new JRadioButtonMenuItem("Pencil");
		pencilButton.setMnemonic(KeyEvent.VK_P);
		group.add(pencilButton);
		myToolsMenu.add(pencilButton);
		
		// add the line option
		JRadioButtonMenuItem lineButton = new JRadioButtonMenuItem("Line");
		lineButton.setMnemonic(KeyEvent.VK_L);
		group.add(lineButton);
		myToolsMenu.add(lineButton);
		
		// add the rectangle option
		JRadioButtonMenuItem rectangleButton = new JRadioButtonMenuItem("Rectangle");
		rectangleButton.setMnemonic(KeyEvent.VK_R);
		group.add(rectangleButton);
		myToolsMenu.add(rectangleButton);
		
		// add the ellipse option
		JRadioButtonMenuItem ellipseButton = new JRadioButtonMenuItem("Ellipse");
		ellipseButton.setMnemonic(KeyEvent.VK_E);
		group.add(ellipseButton);
		myToolsMenu.add(ellipseButton);
		
		// add the eraser option
		JRadioButtonMenuItem eraserButton = new JRadioButtonMenuItem("Eraser");
		eraserButton.setMnemonic(KeyEvent.VK_A);
		group.add(eraserButton);
		myToolsMenu.add(eraserButton);

// to set up the Help menu in the main menu bar
		myHelpMenu = new JMenu("Help");
		myHelpMenu.setMnemonic(KeyEvent.VK_H);
		myMenuBar.add(myHelpMenu);
		
		JMenuItem about = new JMenuItem("About...", KeyEvent.VK_A);
		myHelpMenu.add(about);
		about.addActionListener(new PopOutAction());
		
		

	}

	class PopOutAction implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			// gets the image we want to use for our icon
			final ImageIcon icon = myImageIcon;
			// takes the image from the icon
			Image imgIcon = icon.getImage();
			// scales the image down
			Image newImgIcon = imgIcon.getScaledInstance(50, 35, java.awt.Image.SCALE_SMOOTH);
			// takes our scaled image and makes it into an icon
			final ImageIcon icon2 = new ImageIcon(newImgIcon);
			// creates the pop up window when "about" is clicked with our custom title, message, and icon
			JOptionPane.showMessageDialog(null, "Katlyn and Kenneth \nAutumn 2020 \nTCSS 305 Assignment 4", 
					                     "About", JOptionPane.INFORMATION_MESSAGE, icon2);
		}
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
