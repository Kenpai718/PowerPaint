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
import java.io.Serializable;
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

public class PowerPaintGUI {

	/** A drawing panel. */
	private PaintPanel myPanel;

	/** The window for this GUI. */
	private JFrame myFrame;
	
	/** The created top Menu Bar*/
	private PaintMenuBar myPaintMenuBar;
	
	/** The created bottom Tool Bar*/
	private PaintToolBar myPaintToolBar;

	/** The image icon to show in the window title and about window. */
	private ImageIcon myImageIcon = new ImageIcon("./images/w.gif");
	
	/**List of actions for the tools*/
	private ArrayList<Action> myToolActions;
	
	/**Default tool action */
	private LineAction myDefaultAction;
	

	/**
	 * Constructor of PowerPaintGUI
	 * 
	 */
	public PowerPaintGUI() {
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

		myPanel = new PaintPanel();
		//myPanel.addPropertyChangeListener(myPaintMenuBar);
		myFrame.add(myPanel);
		
		myDefaultAction = new LineAction(myPanel);
		myToolActions = new ArrayList<Action>();
		setupToolActions();
		
		myPaintMenuBar = new PaintMenuBar(myFrame, myPanel, myToolActions, myDefaultAction);
		myPaintToolBar = new PaintToolBar(myFrame, myPanel, myToolActions, myDefaultAction);
		

		// put bars on the panel
		myFrame.setJMenuBar(myPaintMenuBar.getMenuBar());
		myFrame.add(myPaintToolBar.getPaintToolBar(), BorderLayout.SOUTH);

		// finalize frame
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.pack();
		myFrame.setLocationRelativeTo(null);
		myFrame.setVisible(true);

	}
	
	public void setupToolActions () {
		myToolActions.add(new PencilAction(myPanel));
		myToolActions.add(myDefaultAction); //line tool 
		myToolActions.add(new RectangleAction(myPanel));
		myToolActions.add(new EllipseAction(myPanel));
		myToolActions.add(new EraserAction(myPanel));
	}
	
}
