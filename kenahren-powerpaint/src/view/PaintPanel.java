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
import java.util.Stack;

import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;
import javax.swing.plaf.basic.BasicDesktopIconUI.MouseInputHandler;

import model.PaintShape;
import model.PaintPanelProperties;
import tools.AbstractPaintTool;
import tools.LineTool;
import tools.PaintTool;
import tools.PencilTool;

/**
 * 
 * @author Kenneth Ahrens
 * @author Katlyn Malone
 * @version Fall 2020
 */

public class PaintPanel extends JPanel implements PaintPanelProperties {

	// constants

	/** The default size of the drawing panel. */
	private static final Dimension PANEL_DEFAULT_SIZE = new Dimension(500, 300);

	/** The initial thickness size. */
	private static final int DEFAULT_THICKNESS = 10;

	/** The initial point of the tool. */
	private static final Point INITIAL_POINT = new Point(0, 0);

	// fields

	/** Stack to keep track of all shapes drawn on the panel */
	private Stack<PaintShape> myShapesStack;

	/** Stack of shapes that were removed by undo */
	private Stack<PaintShape> myRedoStack;

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

	/** When true clear the panel */
	private boolean myClearStatus;

	/** Boolean to inform paintpanel if it can draw with the current shape */
	private boolean myDragStatus;

	/** Boolean to inform paintpanel if undo was pressed */
	private boolean myUndoStatus;

	/** Boolean to inform paintpanel if redo was pressed */
	private boolean myRedoStatus;

	/**
	 * Paint panel constructor
	 */
	public PaintPanel() {
		super();

		// initialize some of the base fields
		myColor = DEFAULT_PRIMARY;
		myThickness = DEFAULT_THICKNESS;
		myClearStatus = false;
		myDragStatus = false;
		myShapesStack = new Stack<PaintShape>();
		myRedoStack = new Stack<PaintShape>();

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

		// send a property change to PowerPaintGUI
		updateGUI();

		// draw a shape with the current tool only when the mouse is being
		// dragged. This is to provide visual feedback as the user draws the
		// shape.
		if (myDragStatus) {
			g2d.setStroke(new BasicStroke(myThickness));
			g2d.setPaint(myColor);
			g2d.draw(myCurrentTool.getShape());
		}

		// draw all shapes currently on the list to the panel
		if (!myShapesStack.isEmpty()) {
			for (final PaintShape ps : myShapesStack) {
				g2d.setStroke(new BasicStroke(ps.getThickness()));
				g2d.setPaint(ps.getColor());
				g2d.draw(ps.getShape());
			}
		}

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
		PaintShape ps = new PaintShape(theShape, myColor, myThickness);
		myShapesStack.push(ps);
	}

	/**
	 * Clear the shapes list and draw an empty panel
	 */
	public void clearShapes() {
		
		//make a backup of current shapes in case of undo

		myShapesStack.clear();
		myRedoStack.clear();

		repaint();
	}

	/**
	 * Undos a shape that was drawn
	 */
	public void undo() {
		if (!myShapesStack.isEmpty()) {
			myRedoStack.push(myShapesStack.pop());

			repaint();
		}
	}

	/**
	 * Undos a shape that was drawn
	 */
	public void redo() {
		if (!myRedoStack.isEmpty()) {
			PaintShape s = myRedoStack.pop();
			myShapesStack.push(s);

		}

		repaint();

	}

	/**
	 * When called this method fires property changes to the GUI class to update
	 * various buttons such as clear, undo and redo.
	 * 
	 */
	private void updateGUI() {

		// update gui on the status of the panel if it has shapes drawn to it
		firePropertyChange(PROPERTY_SHAPE_HAS_SHAPE, null,
				!myShapesStack.isEmpty());

		// update gui on the status of the redo stack
		firePropertyChange(PROPERTY_SHAPE_REDO, null, !myRedoStack.isEmpty());

	}

	// inner class to track mouse input
	class MouseHandler extends MouseInputAdapter {
		
		@Override
		// set start point at mouse click
		public void mousePressed(final MouseEvent theEvent) {
			
			if (myThickness > 0) {
				myStartPoint = theEvent.getPoint();
				myNextPoint = myStartPoint;

				// draws a dot when pressed and will extend when dragged
				myCurrentTool.setStartPoint(myStartPoint);
				myCurrentTool.setNextPoint(myNextPoint);
				myCurrentShape = myCurrentTool.getShape();

				repaint();
			}
		}

		@Override
		// set the ending point
		public void mouseDragged(final MouseEvent theEvent) {

			if (myThickness > 0) {
				myDragStatus = true;

				myNextPoint = theEvent.getPoint();
				myCurrentTool.setNextPoint(myNextPoint);
				myCurrentShape = myCurrentTool.getShape();

				// update panel with new line that follows the drag
				repaint();
			}
		}

		@Override
		// add this new shape to the list
		public void mouseReleased(final MouseEvent theEvent) {
			if (myThickness > 0) {
				myDragStatus = false;

				saveShape(myCurrentShape);
				repaint();
			}
		}

		@Override
		// custom cursor when mouse is on the paint panel
		public void mouseEntered(final MouseEvent theEvent) {

			setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
		}

	}
}