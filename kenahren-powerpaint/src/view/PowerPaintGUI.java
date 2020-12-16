package view;

import java.awt.BorderLayout;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
import javax.swing.KeyStroke;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.MouseInputAdapter;

import actions.PencilAction;
import actions.LineAction;
import actions.RectangleAction;
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
	private static final int THICKNESS_INITIAL = 10;

	// fields below

	/** A drawing panel. */
	private PaintPanel myPanel;

	/** The window for this GUI. */
	private JFrame myFrame;

	// menu fields

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

	/** Primary color menu button in options menu */
	private JMenuItem myPrimaryButton;

	/** Secondary color menu button in options menu */
	private JMenuItem mySecondaryButton;

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

		// initialize panels, menu, toolbar, etc
		setupGUI();

	}

	/**
	 * Helper method to initialize all GUI components
	 */
	public void setupGUI() {
		// initialize jframe
		myFrame = new JFrame("PowerPaint");
		// add a custom icon to the frame
		myFrame.setIconImage(myImageIcon.getImage());

		// initialize fields like menus
		myPanel = new PaintPanel();
		myToolBar = new JToolBar();
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
		setupTopMenu();
		myFrame.add(myPanel);

		// put toolbar on the panel
		myFrame.add(myToolBar, BorderLayout.SOUTH);

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
		myThicknessSlider.addChangeListener(new SliderAdjuster());

		myOptionsMenu.addSeparator();

		// primary and secondary colors menu
		setupColorButtons();

		myOptionsMenu.addSeparator();

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

		myOptionsMenu.addSeparator();

		// extra option in case user wants to exit
		JMenuItem exit = new JMenuItem("Exit", KeyEvent.VK_E);
		exit.addActionListener(new ExitAction());
		myOptionsMenu.add(exit);

	}

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

			// gets the color choice from user input
			final Color colorChoice = JColorChooser.showDialog(null,
					"Select a color", DEFAULT_PRIMARY);

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
					"Select a color", DEFAULT_SECONDARY);

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
	public void setupMenuHelp() {
		myHelpMenu = new JMenu("Help");
		myHelpMenu.setMnemonic(KeyEvent.VK_H);
		myMenuBar.add(myHelpMenu);

		JMenuItem about = new JMenuItem("About...", KeyEvent.VK_A);
		myHelpMenu.add(about);
		about.addActionListener(new PopOutAction());
	}

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
					"Katlyn Malone and Kenneth Ahrens\nAutumn 2020 \nTCSS 305 Assignment 4",
					"About", JOptionPane.INFORMATION_MESSAGE, icon2);
		}
	}

	// listener for when exit is chosen
	class ExitAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			myFrame.dispose();
			System.exit(0);

		}

	}

	@Override
	public void propertyChange(PropertyChangeEvent theEvent) {
		final boolean status = (Boolean) theEvent.getNewValue();
		
		if (PROPERTY_HAS_SHAPE.equals(theEvent.getPropertyName())) {
			myClearButton.setEnabled(status);
			myUndoButton.setEnabled(status);
		}
		
		if (PROPERTY_SHAPE_REDO.equals(theEvent.getPropertyName())) {
			myRedoButton.setEnabled(status);
		} 

	}
}
