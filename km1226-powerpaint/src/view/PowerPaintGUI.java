package view;

import java.awt.BorderLayout;
<<<<<<< Updated upstream
import java.awt.Color;
=======


import java.awt.Color;
import java.awt.Dimension;
>>>>>>> Stashed changes
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
<<<<<<< Updated upstream
=======
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
<<<<<<< Updated upstream
=======
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
>>>>>>> Stashed changes
=======
import javax.swing.KeyStroke;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.MouseInputAdapter;
>>>>>>> Stashed changes

import actions.PencilAction;
import actions.LineAction;
import actions.RectangleAction;
<<<<<<< Updated upstream
<<<<<<< Updated upstream
=======
import tools.EllipseTool;
import tools.EraserTool;
import tools.LineTool;
import tools.PencilTool;
import tools.RectangleTool;
>>>>>>> Stashed changes
import actions.EllipseAction;
import actions.EraserAction;

public class PowerPaintGUI implements PropertyChangeListener {
=======
import model.PaintPanelProperties;
import actions.EllipseAction;
import actions.EraserAction;

/**
 * 
 * @author Kenneth Ahrens
 * @author Katlyn Malone
 * @version Fall 2020
 */

public class PowerPaintGUI
		implements PropertyChangeListener, PaintPanelProperties {
>>>>>>> Stashed changes

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
<<<<<<< Updated upstream
	private static final int THICKNESS_INIT = 10;

	/** Default color for primary color */
	private final Color PURPLE = new Color(51, 0, 111);

	/** Default color for secondary color */
	private final Color GOLD = new Color(232, 211, 162);;

	// fields
=======
	private static final int THICKNESS_INITIAL = 10;

	// fields below
>>>>>>> Stashed changes

	/** A drawing panel. */
	private PaintPanel myPanel;

	/** The window for this GUI. */
	private JFrame myFrame;

<<<<<<< Updated upstream
=======
	// menu fields

>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
	
	private JSlider myThicknessSlider;
	
	/** A list of color actions. */
	private ButtonGroup myToolButtons;

<<<<<<< Updated upstream
	/** A list of tool actions from actions package. */
	private List<Action> myToolActions;

=======
	private JRadioButtonMenuItem myPencilButton;
	private JRadioButtonMenuItem myLineButton;
	private JRadioButtonMenuItem myRectangleButton;
	private JRadioButtonMenuItem myEllipseButton;
	private JRadioButtonMenuItem myEraserButton;
	
	private JToggleButton myPencilToolButton;
	private JToggleButton myLineToolButton;
	private JToggleButton myRectangleToolButton;
	private JToggleButton myEraserToolButton;
	private JToggleButton myEllipseToolButton;
	
	/** A tool for drawing lines. */
    private final LineTool myLineTool;
    
    /** A tool for drawing rectangles. */
    private final RectangleTool myRectangleTool;
    
    /** A tool for drawing ellipses. */
    private final EllipseTool myEllipseTool;
    
    /** A tool for erasing. */
    private final EraserTool myEraserTool;
    
    /** A tool for free drawing. */
    private final PencilTool myPencilTool;
	
	/** A list of tool actions from actions package. */
	private List<Action> myToolActions;
	
>>>>>>> Stashed changes
	/** Toolbar of tools attached to jpanel */
	private JToolBar myToolBar;

	// fields below for color options
=======

	/** Thickness slider */
	private JSlider myThicknessSlider;

	/** Clear button in options. */
	private JMenuItem myClearButton;

	/** Clear button in options. */
	private JMenuItem myUndoButton;

	/** Clear button in options. */
	private JMenuItem myRedoButton;

	// toolbar fields

	/** A button group for tool actions in toolbar */
	private ButtonGroup myToolBarButtons;

	/** A button group for tool actions in tool menu */
	private ButtonGroup myToolMenuButtons;

	/** A list of tool actions from actions package. */
	private List<Action> myToolActions;

	/** Toolbar of tools attached to jpanel */
	private JToolBar myToolBar;

	// fields for color options
>>>>>>> Stashed changes

	/** Primary color menu button in options menu */
	private JMenuItem myPrimaryButton;

	/** Secondary color menu button in options menu */
	private JMenuItem mySecondaryButton;
<<<<<<< Updated upstream
	
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
<<<<<<< Updated upstream

=======
		
		myLineTool = new LineTool();
		myRectangleTool = new RectangleTool();
		myEllipseTool = new EllipseTool();
		myPencilTool = new PencilTool();
		myEraserTool = new EraserTool();
		
>>>>>>> Stashed changes
=======

	/** Primary color icon */
	private final ColorIcon myColorIcon;

	/** Secondary color icon */
	private final ColorIcon myColorIcon2;

	/** Sets default tool action */
	private Action myDefaultAction;

	/**
	 * Constructor of PowerPaintGUI
	 * 
	 */
	public PowerPaintGUI() {

		// default UW color setup
		myColorIcon = new ColorIcon(DEFAULT_PRIMARY);
		myColorIcon2 = new ColorIcon(DEFAULT_SECONDARY);

>>>>>>> Stashed changes
		// initialize panels, menu, toolbar, etc
		setupGUI();

	}
<<<<<<< Updated upstream
	

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
=======

	/**
	 * Helper method to initialize all GUI components
	 */
	public void setupGUI() {
		// initialize jframe
		myFrame = new JFrame("PowerPaint");
		// add a custom icon to the frame
		myFrame.setIconImage(myImageIcon.getImage());
>>>>>>> Stashed changes

		// initialize fields like menus
		myPanel = new PaintPanel();
		myToolBar = new JToolBar();
<<<<<<< Updated upstream
		myToolActions = new ArrayList<Action>();
		myToolButtons = new ButtonGroup();
<<<<<<< Updated upstream
=======
        
>>>>>>> Stashed changes

		// add buttons and menu options
		setupToolActions();
=======
		myToolBarButtons = new ButtonGroup();
		myToolMenuButtons = new ButtonGroup();

		// initialize tool actions for buttons
		myDefaultAction = new LineAction(myPanel);
		myToolActions = new ArrayList<Action>();
		myToolActions.add(new PencilAction(myPanel));
		myToolActions.add(myDefaultAction); // line tool
		myToolActions.add(new RectangleAction(myPanel));
		myToolActions.add(new EllipseAction(myPanel));
		myToolActions.add(new EraserAction(myPanel));

		// add buttons and menu options
		setupToolBarActions();
>>>>>>> Stashed changes
		setupTopMenu();
		myFrame.add(myPanel);

		// put toolbar on the panel
		myFrame.add(myToolBar, BorderLayout.SOUTH);
<<<<<<< Updated upstream
<<<<<<< Updated upstream
=======
		
		//listen for changes that happen in this panel
		myPanel.addPropertyChangeListener(this);
>>>>>>> Stashed changes

	}
	

    /**
     * Setups actions for the tool buttons on the toolbar
     */
	public void setupToolActions() {

<<<<<<< Updated upstream
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
=======
		myPencilToolButton = new JToggleButton(new PencilAction(myPanel));
		myPencilToolButton.addActionListener(new PickPencilTool());
		myToolButtons.add(myPencilToolButton);
		myToolBar.add(myPencilToolButton);
		
		myLineToolButton = new JToggleButton(new LineAction(myPanel));
		myLineToolButton.addActionListener(new PickLineTool());
		myToolButtons.add(myLineToolButton);
		myToolBar.add(myLineToolButton);
		myLineToolButton.setSelected(true);
		
        myRectangleToolButton = new JToggleButton(new RectangleAction(myPanel));
        myRectangleToolButton.addActionListener(new PickRectangleTool());
        myToolButtons.add(myRectangleToolButton);
		myToolBar.add(myRectangleToolButton);
		
        myEllipseToolButton = new JToggleButton(new EllipseAction(myPanel));
        myEllipseToolButton.addActionListener(new PickEllipseTool());
        myToolButtons.add(myEllipseToolButton);
		myToolBar.add(myEllipseToolButton);
		
        myEraserToolButton = new JToggleButton(new EraserAction(myPanel));
        myEraserToolButton.addActionListener(new PickEraserTool());
        myToolButtons.add(myEraserToolButton);
		myToolBar.add(myEraserToolButton);
	}
	
	
>>>>>>> Stashed changes

    /**
     * Setups up all menu options/buttons at top of panel
     */
=======

		// finalize frame
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.pack();
		myFrame.setLocationRelativeTo(null);
		myFrame.setVisible(true);

		//listeners
		// listen for changes that happen in this paintpanel
		myPanel.addPropertyChangeListener(this);

	}

	/**
	 * Setups actions for the tool buttons on the toolbar
	 */
	public void setupToolBarActions() {

		// associate tool buttons with actions and add to toolbar
		for (final Action act : myToolActions) {
			final JToggleButton tb = new JToggleButton(act);
			myToolBarButtons.add(tb);
			myToolBar.add(tb);

			// selects the line tool at the start as default
			if (tb.getAction() == myDefaultAction) {
				tb.setSelected(true);
			}

		}

	}

	/**
	 * Setups up all menu options/buttons at top of panel
	 */
>>>>>>> Stashed changes
	public void setupTopMenu() {
		myMenuBar = new JMenuBar();
		myFrame.setJMenuBar(myMenuBar);

		// helper methods to condense code
		setupMenuOptions();
		setupMenuTools();
		setupMenuHelp();

	}

<<<<<<< Updated upstream
    /**
     * Setups the options menu
     * 
     */
=======
	/**
	 * Setups the options menu
	 * 
	 */
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
<<<<<<< Updated upstream
=======
		myThicknessSlider.addChangeListener(new SliderAdjuster());
>>>>>>> Stashed changes
		
=======
		myThicknessSlider.addChangeListener(new SliderAdjuster());

>>>>>>> Stashed changes
		myOptionsMenu.addSeparator();

		// primary and secondary colors menu
		setupColorButtons();

		myOptionsMenu.addSeparator();

<<<<<<< Updated upstream
		// adds the clear function
		myOptionsMenu.add(new JMenuItem("Clear", KeyEvent.VK_C));
=======
		// clear button is disabled until a shape is drawn
		myClearButton = new JMenuItem("Clear", KeyEvent.VK_C);
		myClearButton.setEnabled(false);
		myClearButton.addActionListener(new ClearHandler());

		// adds the clear function
		myOptionsMenu.add(myClearButton);
		myOptionsMenu.addSeparator();

		// undo option: Shorcut ctrl + z
		myUndoButton = new JMenuItem("Undo", KeyEvent.VK_Y);
		myUndoButton.setAccelerator(KeyStroke.getKeyStroke(
                   KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
		myUndoButton.setEnabled(false);
		myUndoButton.addActionListener(new UndoAction());
		myOptionsMenu.add(myUndoButton);

		// redo option: Shortcut ctrl + y
		myRedoButton = new JMenuItem("Redo", KeyEvent.VK_Y);
        myRedoButton.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_Y, ActionEvent.CTRL_MASK));
		myRedoButton.setEnabled(false);
		myRedoButton.addActionListener(new RedoAction());
		myOptionsMenu.add(myRedoButton);

>>>>>>> Stashed changes
		myOptionsMenu.addSeparator();

		// extra option in case user wants to exit
		JMenuItem exit = new JMenuItem("Exit", KeyEvent.VK_E);
		exit.addActionListener(new ExitAction());
		myOptionsMenu.add(exit);

	}
<<<<<<< Updated upstream
	
	public void setupThicknessSlider()
    {
        myThicknessSlider = new JSlider(THICKNESS_MIN, THICKNESS_MAX, THICKNESS_INIT);
        myThicknessSlider.setMajorTickSpacing(MAJOR_SPACING);
        myThicknessSlider.setMinorTickSpacing(MINOR_SPACING);
        myThicknessSlider.setPaintTicks(true);
        myThicknessSlider.setPaintLabels(true);
    }
	
<<<<<<< Updated upstream
=======
	private class SliderAdjuster implements ChangeListener
    {
    	@Override
    	public void stateChanged(ChangeEvent e)
    	{
    		JSlider source = (JSlider)e.getSource();
    		if(!source.getValueIsAdjusting())
    		{
    			int changeValue = (int)source.getValue();
    			myPanel.setThickness(changeValue);
    		}
    	}
    }
	
>>>>>>> Stashed changes
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
=======

	public void setupThicknessSlider() {
		myThicknessSlider = new JSlider(THICKNESS_MIN, THICKNESS_MAX,
				THICKNESS_INITIAL);
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
		myPrimaryButton = new JMenuItem("Primary Color...", myColorIcon);
		myPrimaryButton.setMnemonic(KeyEvent.VK_P);
		myOptionsMenu.add(myPrimaryButton);

		mySecondaryButton = new JMenuItem("Secondary Color...", myColorIcon2);
>>>>>>> Stashed changes
		mySecondaryButton.setMnemonic(KeyEvent.VK_S);
		myOptionsMenu.add(mySecondaryButton);

		// listeners to open color swatch and assign new colors and icons
		myPrimaryButton.addActionListener(new ColorChoicePrimary());
		mySecondaryButton.addActionListener(new ColorChoiceSecondary());
	}

<<<<<<< Updated upstream

=======
>>>>>>> Stashed changes
	// class to open color swatch for primary color. After user chooses color,
	// that color and icon is updated.
	class ColorChoicePrimary implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

<<<<<<< Updated upstream
			//gets the color choice from user input
			final Color colorChoice = JColorChooser.showDialog(null,
					"Select a color", PURPLE);
=======
			// gets the color choice from user input
			final Color colorChoice = JColorChooser.showDialog(null,
					"Select a color", DEFAULT_PRIMARY);
>>>>>>> Stashed changes

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
<<<<<<< Updated upstream
					"Select a color", GOLD);
			
=======
					"Select a color", DEFAULT_SECONDARY);
>>>>>>> Stashed changes

			// update secondary colors based on input
			myColorIcon2.setColor(colorChoice);

			if (colorChoice != null) {
				myPanel.setSecondaryColor(colorChoice);
			}
		}

	}

<<<<<<< Updated upstream
    /**
     * Setups the menu tools dropdown with radio buttons
     * 
     */
=======
	/**
	 * Setups the menu tools dropdown with radio buttons
	 * 
	 */
>>>>>>> Stashed changes
	public void setupMenuTools() {
		myToolsMenu = new JMenu("Tools");
		myToolsMenu.setMnemonic(KeyEvent.VK_T);
		myMenuBar.add(myToolsMenu);

<<<<<<< Updated upstream
		// create the radio list for our tools
		ButtonGroup group = new ButtonGroup();

		// add the pencil option
<<<<<<< Updated upstream
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
=======
		myPencilButton = new JRadioButtonMenuItem("Pencil", false);
		myPencilButton.setMnemonic(KeyEvent.VK_P);
		group.add(myPencilButton);
		myToolsMenu.add(myPencilButton);
		myPencilButton.addActionListener(new PickPencilTool());

		// add the line option
		myLineButton = new JRadioButtonMenuItem("Line", true);
		myLineButton.setMnemonic(KeyEvent.VK_L);
		group.add(myLineButton);
		myToolsMenu.add(myLineButton);
		myLineButton.addActionListener(new PickLineTool());

		// add the rectangle option
		myRectangleButton = new JRadioButtonMenuItem("Rectangle", false);
		myRectangleButton.setMnemonic(KeyEvent.VK_R);
		group.add(myRectangleButton);
		myToolsMenu.add(myRectangleButton);
		myRectangleButton.addActionListener(new PickRectangleTool());

		// add the ellipse option
		myEllipseButton = new JRadioButtonMenuItem("Ellipse", false);
		myEllipseButton.setMnemonic(KeyEvent.VK_E);
		group.add(myEllipseButton);
		myToolsMenu.add(myEllipseButton);
		myEllipseButton.addActionListener(new PickEllipseTool());

		// add the eraser option
		myEraserButton = new JRadioButtonMenuItem("Eraser", false);
		myEraserButton.setMnemonic(KeyEvent.VK_A);
		group.add(myEraserButton);
		myToolsMenu.add(myEraserButton);
		myEraserButton.addActionListener(new PickEraserTool());
	}

	private class PickPencilTool implements ActionListener
    {	
    	@Override
    	public void actionPerformed(ActionEvent e)
    	{
    		myPanel.setCurrentTool(myPencilTool);
    		myPencilButton.setSelected(true);
    		myPencilToolButton.setSelected(true);
    	}
    }
	
	private class PickLineTool implements ActionListener
    {	
    	@Override
    	public void actionPerformed(ActionEvent e)
    	{
    		myPanel.setCurrentTool(myLineTool);
    		myLineButton.setSelected(true);
    		myLineToolButton.setSelected(true);
    	}
    }
	
	private class PickRectangleTool implements ActionListener
    {	
    	@Override
    	public void actionPerformed(ActionEvent e)
    	{
    		myPanel.setCurrentTool(myRectangleTool);
    		myRectangleButton.setSelected(true);
    		myRectangleToolButton.setSelected(true);
    	}
    }
	
	private class PickEllipseTool implements ActionListener
    {	
    	@Override
    	public void actionPerformed(ActionEvent e)
    	{
    		myPanel.setCurrentTool(myEllipseTool);
    		myEllipseButton.setSelected(true);
    		myEllipseToolButton.setSelected(true);
    	}
    }
	
	private class PickEraserTool implements ActionListener
    {	
    	@Override
    	public void actionPerformed(ActionEvent e)
    	{
    		myPanel.setCurrentTool(myEraserTool);
    		myEraserButton.setSelected(true);
    		myEraserToolButton.setSelected(true);
    	}
    }
	
	/**
>>>>>>> Stashed changes
     * Setups help menu 
     * 
     */
=======
		// associate tool buttons with actions and add to toolbar
		for (final Action act : myToolActions) {
			JRadioButtonMenuItem rb = new JRadioButtonMenuItem(act);

			myToolMenuButtons.add(rb);
			myToolsMenu.add(rb);

			// selects the line tool at the start as default
			if (rb.getAction() == myDefaultAction) {
				rb.setSelected(true);
			}

		}

	}

	/**
	 * Setups help menu
	 * 
	 */
>>>>>>> Stashed changes
	public void setupMenuHelp() {
		myHelpMenu = new JMenu("Help");
		myHelpMenu.setMnemonic(KeyEvent.VK_H);
		myMenuBar.add(myHelpMenu);

		JMenuItem about = new JMenuItem("About...", KeyEvent.VK_A);
		myHelpMenu.add(about);
		about.addActionListener(new PopOutAction());
	}

<<<<<<< Updated upstream
=======
	class ClearHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (myClearButton.isEnabled()) {

				myPanel.clearShapes(); // clear stored info on panel

				myClearButton.setEnabled(false);

			}

		}

	}

	class UndoAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (myUndoButton.isEnabled()) {

				myPanel.undo(); 

			}

		}

	}

	class RedoAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (myRedoButton.isEnabled()) {

				myPanel.redo(); 

			}

		}

	}
	


	private class SliderAdjuster implements ChangeListener {
		@Override
		public void stateChanged(ChangeEvent e) {
			JSlider source = (JSlider) e.getSource();
			if (!source.getValueIsAdjusting()) {
				int changeValue = (int) source.getValue();
				myPanel.setThickness(changeValue);
			}
		}
	}

>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
					"Katlyn and Kenneth \nAutumn 2020 \nTCSS 305 Assignment 4",
=======
					"Katlyn Malone and Kenneth Ahrens\nAutumn 2020 \nTCSS 305 Assignment 4",
>>>>>>> Stashed changes
					"About", JOptionPane.INFORMATION_MESSAGE, icon2);
		}
	}

<<<<<<< Updated upstream
	//listener for when exit is chosen
=======
	// listener for when exit is chosen
>>>>>>> Stashed changes
	class ExitAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			myFrame.dispose();
			System.exit(0);

		}

	}

	@Override
<<<<<<< Updated upstream
	public void propertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub
=======
	public void propertyChange(PropertyChangeEvent theEvent) {
		final boolean status = (Boolean) theEvent.getNewValue();
		
		if (PROPERTY_SHAPE_HAS_SHAPE.equals(theEvent.getPropertyName())) {
			myClearButton.setEnabled(status);
			myUndoButton.setEnabled(status);
		}
		
		if (PROPERTY_SHAPE_REDO.equals(theEvent.getPropertyName())) {
			myRedoButton.setEnabled(status);
		} 
>>>>>>> Stashed changes

	}
}
