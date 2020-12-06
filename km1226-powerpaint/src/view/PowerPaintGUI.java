package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSlider;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

import actions.PencilAction;
import actions.LineAction;
import actions.RectangleAction;
import actions.EllipseAction;
import actions.EraserAction;

public class PowerPaintGUI implements PropertyChangeListener {

	// constants

	/** Slider minimum value. */
	private static final int THICKNESS_MIN = 0;

	/** Slider maximum value. */
	private static final int THICKNESS_MAX = 20;

	/** Slider major spacing. */
	private static final int MAJOR_SPACING = 5;

	/** Slider minor spacing. */
	private static final int MINOR_SPACING = 1;

	/** Slider initial value position. */
	private static final int THICKNESS_INIT = 10;

	/** Default color for primary color */
	private final Color PURPLE = new Color(51, 0, 111);

	/** Default color for secondary color */
	private final Color GOLD = new Color(232, 211, 162);;

	// fields

	/** A drawing panel. */
	private PaintPanel myPanel;

	/** The window for this GUI. */
	private JFrame myFrame;

	/** The top menu for this GUI. */
	private JMenuBar myMenuBar;

	/** Top tools menu bar. */
	private JMenu myToolsMenu;

	/** Top file menu bar. */
	private JMenu myOptionsMenu;

	/** Top help menu bar. */
	private JMenu myHelpMenu;

	/** The image icon to show in the window title and about window. */
	private ImageIcon myImageIcon = new ImageIcon("./images/w.gif");
	
	private JSlider myThicknessSlider;
	
	/** A list of color actions. */
	private ButtonGroup myToolButtons;

	/** A list of tool actions from actions package. */
	private List<Action> myToolActions;

	/** Toolbar of tools attatched to jpanel */
	private JToolBar myToolBar;

	// fields below for color options

	/** Primary color menu button in options menu */
	private JMenuItem myPrimaryButton;

	/** Secondary color menu button in options menu */
	private JMenuItem mySecondaryButton;
	
	/** Primary color icon */
	private final ColorIcon myColorIcon;
	
	/** Secondary color icon */
	private final ColorIcon myColorIcon2;

	
    /**
     * Constructor of PowerPaintGUI
     * 
     */
	public PowerPaintGUI() {

		// default UW color setup
		myColorIcon = new ColorIcon(PURPLE);
		myColorIcon2 = new ColorIcon(GOLD);

		// initialize panels, menu, toolbar, etc
		setupGUI();

	}
	

    /**
     * Helper method to initialize all GUI components
     */
	public void setupGUI() {
		// initialize jframe
		myFrame = new JFrame("PowerPaint");
		//add a custom icon to the frame
		myFrame.setIconImage(myImageIcon.getImage());
		myFrame.setVisible(true);
		myFrame.setSize(500, 500);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// initialize fields like menus
		myPanel = new PaintPanel();
		myToolBar = new JToolBar();
		myToolActions = new ArrayList<Action>();
		myToolButtons = new ButtonGroup();

		// add buttons and menu options
		setupToolActions();
		setupTopMenu();
		myFrame.add(myPanel);

		// put toolbar on the panel
		myFrame.add(myToolBar, BorderLayout.SOUTH);

	}
	

    /**
     * Setups actions for the tool buttons on the toolbar
     */
	public void setupToolActions() {

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

    /**
     * Setups up all menu options/buttons at top of panel
     */
	public void setupTopMenu() {
		myMenuBar = new JMenuBar();
		myFrame.setJMenuBar(myMenuBar);

		// helper methods to condense code
		setupMenuOptions();
		setupMenuTools();
		setupMenuHelp();

	}

    /**
     * Setups the options menu
     * 
     */
	public void setupMenuOptions() {
		myOptionsMenu = new JMenu("Options");
		myOptionsMenu.setMnemonic(KeyEvent.VK_O);
		myMenuBar.add(myOptionsMenu);

		// thickness sub menu
		JMenu thickMenu = new JMenu("Thickness");
		thickMenu.setMnemonic(KeyEvent.VK_T);
		myOptionsMenu.add(thickMenu);
		setupThicknessSlider();
		thickMenu.add(myThicknessSlider);
		
		myOptionsMenu.addSeparator();

		// primary and secondary colors menu
		setupColorButtons();

		myOptionsMenu.addSeparator();

		// adds the clear function
		myOptionsMenu.add(new JMenuItem("Clear"));
		myOptionsMenu.addSeparator();

		// extra option in case user wants to exit
		JMenuItem exit = new JMenuItem("Exit");
		exit.addActionListener(new ExitAction());
		myOptionsMenu.add(exit);

	}
	
	public void setupThicknessSlider()
    {
        myThicknessSlider = new JSlider(THICKNESS_MIN, THICKNESS_MAX, THICKNESS_INIT);
        myThicknessSlider.setMajorTickSpacing(MAJOR_SPACING);
        myThicknessSlider.setMinorTickSpacing(MINOR_SPACING);
        myThicknessSlider.setPaintTicks(true);
        myThicknessSlider.setPaintLabels(true);
    }
	
    /**
     * Setups the color buttons under the menu options
     * 
     */
	public void setupColorButtons() {
		myPrimaryButton = new JMenuItem("Primary Color...",
				myColorIcon);
		myPrimaryButton.setMnemonic(KeyEvent.VK_P);
		myOptionsMenu.add(myPrimaryButton);

		mySecondaryButton = new JMenuItem("Secondary Color...",
				myColorIcon2);
		mySecondaryButton.setMnemonic(KeyEvent.VK_S);
		myOptionsMenu.add(mySecondaryButton);

		// listeners to open color swatch and assign new colors and icons
		myPrimaryButton.addActionListener(new ColorChoicePrimary());
		mySecondaryButton.addActionListener(new ColorChoiceSecondary());
	}


	// class to open color swatch for primary color. After user chooses color,
	// that color and icon is updated.
	class ColorChoicePrimary implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			//gets the color choice from user input
			final Color colorChoice = JColorChooser.showDialog(null,
					"Select a color", PURPLE);

			// update primary colors based on input
			myColorIcon.setColor(colorChoice);

			// set the color for the jpanel tool
			if (colorChoice != null) {
				myPanel.setColor(colorChoice);
			}
		}

	}

	// class to open color swatch for secondary color. After user chooses color,
	// that color and icon is updated.
	class ColorChoiceSecondary implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			final Color colorChoice = JColorChooser.showDialog(null,
					"Select a color", GOLD);
			

			// update secondary colors based on input
			myColorIcon2.setColor(colorChoice);

			if (colorChoice != null) {
				myPanel.setSecondaryColor(colorChoice);
			}
		}

	}

    /**
     * Setups the menu tools dropdown with radio buttons
     * 
     */
	public void setupMenuTools() {
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
		JRadioButtonMenuItem rectangleButton = new JRadioButtonMenuItem(
				"Rectangle");
		rectangleButton.setMnemonic(KeyEvent.VK_R);
		group.add(rectangleButton);
		myToolsMenu.add(rectangleButton);

		// add the ellipse option
		JRadioButtonMenuItem ellipseButton = new JRadioButtonMenuItem(
				"Ellipse");
		ellipseButton.setMnemonic(KeyEvent.VK_E);
		group.add(ellipseButton);
		myToolsMenu.add(ellipseButton);

		// add the eraser option
		JRadioButtonMenuItem eraserButton = new JRadioButtonMenuItem("Eraser");
		eraserButton.setMnemonic(KeyEvent.VK_A);
		group.add(eraserButton);
		myToolsMenu.add(eraserButton);
	}

    /**
     * Setups help menu 
     * 
     */
	public void setupMenuHelp() {
		myHelpMenu = new JMenu("Help");
		myHelpMenu.setMnemonic(KeyEvent.VK_H);
		myMenuBar.add(myHelpMenu);

		JMenuItem about = new JMenuItem("About...", KeyEvent.VK_A);
		myHelpMenu.add(about);
		about.addActionListener(new PopOutAction());
	}

	class PopOutAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// gets the image we want to use for our icon
			final ImageIcon icon = myImageIcon;
			// takes the image from the icon
			Image imgIcon = icon.getImage();
			// scales the image down
			Image newImgIcon = imgIcon.getScaledInstance(50, 35,
					java.awt.Image.SCALE_SMOOTH);
			// takes our scaled image and makes it into an icon
			final ImageIcon icon2 = new ImageIcon(newImgIcon);
			// creates the pop up window when "about" is clicked with our custom
			// title, message, and icon
			JOptionPane.showMessageDialog(null,
					"Katlyn and Kenneth \nAutumn 2020 \nTCSS 305 Assignment 4",
					"About", JOptionPane.INFORMATION_MESSAGE, icon2);
		}
	}

	//listener for when exit is chosen
	class ExitAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			myFrame.dispose();
			System.exit(0);

		}

	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub

	}
}