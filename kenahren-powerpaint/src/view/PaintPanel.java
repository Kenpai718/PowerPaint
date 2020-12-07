package view;

import java.awt.BasicStroke;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;
import javax.swing.plaf.basic.BasicDesktopIconUI.MouseInputHandler;

import model.PaintShape;
import model.PaintPanelProperties;
import tools.AbstractPaintTool;
import tools.LineTool;
import tools.PaintTool;
import tools.PencilTool;

public class PaintPanel extends JPanel implements PaintPanelProperties {

	// constants

	/** The default size of the drawing panel. */
	private static final Dimension PANEL_DEFAULT_SIZE = new Dimension(500, 300);

	/** The initial thickness size. */
	private static final int DEFAULT_THICKNESS = 10;

	/** The initial point of the tool. */
	private static final Point INITIAL_POINT = new Point(0, 0);

	/** The default UW Purple drawing color. */
	private static final Color DEFAULT_COLOR = new Color(51, 0, 111);

	// fields

	/** List to keep track of all shapes drawn on the panel */
	private ArrayList<PaintShape> myShapesList;

	/** Current shape on panel */
	private Shape myCurrentShape;

	/** Current primary color */
	private Color myColor;

	/** Current secondary color */
	private Color mySecondaryColor;

	/** Thickness of the stroke */
	private int myThickness;

	/** Current tool used on the panel */
	private PaintTool myCurrentTool;

	/** Start position */
	private Point myStartPoint;

	/** Next/End position */
	private Point myNextPoint;

	/** Next/End position */
	private boolean myClear;

	/**
	 * Paint panel constructor
	 */
	public PaintPanel() {
		super();

		// initialize some of the base fields

		myShapesList = new ArrayList<PaintShape>();
		myColor = DEFAULT_COLOR;
		myThickness = DEFAULT_THICKNESS;
		myClear = false;

		// set default tool
		// NOTE: should be pencil as default, but for now its line tool
		// until pencil tool is implemented
		myCurrentTool = new LineTool();

		// setup the painting panel
		setupPanel();
		setupListeners();

	}

	/**
	 * Sets up the panel to draw on
	 */
	public void setupPanel() {

		setBackground(Color.WHITE);
		setPreferredSize(PANEL_DEFAULT_SIZE);
	}

	/**
	 * Places mouse listeners to the panel
	 */
	public void setupListeners() {
		// mouse listener
		// dragging listener
		// add a cursor
		final MouseHandler MIH = new MouseHandler();
		addMouseListener(MIH);
		addMouseMotionListener(MIH);
	}

	/**
	 * Paints the panel with shapes
	 * 
	 * @param theGraphics graphics
	 */
	public void paintComponent(Graphics theGraphics) {
		super.paintComponent(theGraphics);
		final Graphics2D g2d = (Graphics2D) theGraphics;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);

		// draw something when the panel has not queried to be cleared
		if (!myClear) {
			g2d.setStroke(new BasicStroke(myThickness));
			g2d.setPaint(myColor);
			g2d.draw(myCurrentTool.getShape());

			// draw previous shapes
			for (final PaintShape p : myShapesList) {
				g2d.setStroke(new BasicStroke(p.getThickness()));
				g2d.setPaint(p.getColor());
				g2d.draw(p.getShape());
			}
		}

		// send a property change to PowerPaintGUI that a change was made
		// firePropertyChange(string name, boolean oldValue, boolean newValue)
		firePropertyChange(PROPERTY_SHAPE_ADD, false, !myShapesList.isEmpty());

	}

	/**
	 * Sets primary color of the tool to use on panel
	 * 
	 * @param Color the color to change to
	 */
	public void setColor(Color theColor) {
		myColor = theColor;
	}

	/**
	 * Sets secondary color of the tool to use on panel
	 * 
	 * @param Color the color to change to
	 */
	public void setSecondaryColor(Color theColor) {
		mySecondaryColor = theColor;
	}

	/**
	 * Sets thickness of the tool for the panel
	 * 
	 * @param int of the thickness value
	 */
	public void setThickness(int theThickness) {
		myThickness = theThickness;
	}

	/**
	 * Sets what the current tool used on the panel is
	 * 
	 * @param PaintTool the type of tool used
	 */
	public void setCurrentTool(PaintTool theTool) {
		myCurrentTool = theTool;
	}

	/**
	 * Save shapes to a list to keep track of.
	 * 
	 * @param Shape shape to be saved
	 */
	public void saveShape(final Shape theShape) {
		PaintShape PS = new PaintShape(theShape, myColor, myThickness);
		myShapesList.add(PS);
	}

	/**
	 * Clear the shapes list and draw an empty panel
	 */
	public void clearShapes() {
		myShapesList.clear();
		myClear = true;
		repaint();
	}

	// inner class to track mouse input
	class MouseHandler extends MouseInputAdapter {
		@Override
		// set start point at mouse click
		public void mousePressed(final MouseEvent theEvent) {
			myStartPoint = theEvent.getPoint();
			myNextPoint = myStartPoint;

			// draws a dot when pressed and will extend when dragged
			myCurrentTool.setStartPoint(myStartPoint);
			myCurrentTool.setNextPoint(myNextPoint);
			myCurrentShape = myCurrentTool.getShape();

			repaint();
		}

		@Override
		// set the ending point
		public void mouseDragged(final MouseEvent theEvent) {

			myNextPoint = theEvent.getPoint();
			myCurrentTool.setNextPoint(myNextPoint);
			myCurrentShape = myCurrentTool.getShape();

			// update panel with new line that follows the drag
			repaint();
		}

		@Override
		// add this new shape to the list
		public void mouseReleased(final MouseEvent theEvent) {
			// TODO
			// Temp myClear until better solution. 
			myClear = false;

			saveShape(myCurrentShape);
			repaint();
		}

		@Override
		// custom cursor when mouse is on the paint panel
		public void mouseEntered(final MouseEvent theEvent) {

			setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
		}

	}
}
