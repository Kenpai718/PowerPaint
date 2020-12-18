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
<<<<<<< Updated upstream
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
=======
import java.awt.event.MouseEvent;
import java.io.Serializable;
>>>>>>> Stashed changes
import java.util.Stack;

import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;
<<<<<<< Updated upstream
import javax.swing.plaf.basic.BasicDesktopIconUI.MouseInputHandler;

import model.PaintShape;
import model.PaintPanelProperties;
import tools.AbstractPaintTool;
import tools.EraserTool;
import tools.LineTool;
import tools.PaintTool;
import tools.PencilTool;

/**
=======

import model.PaintShape;
import model.PaintPanelProperties;
import tools.EraserTool;
import tools.LineTool;
import tools.PaintTool;

/**
 * Used to create the actual panel we paint on in the program
 * and what the shapes are drawn into
>>>>>>> Stashed changes
 * 
 * @author Kenneth Ahrens
 * @author Katlyn Malone
 * @version Fall 2020
 */

<<<<<<< Updated upstream
public class PaintPanel extends JPanel implements PaintPanelProperties {

	// constants

=======
public class PaintPanel extends JPanel implements PaintPanelProperties, Serializable{

	// constants

	/**
	 * Java auto generated serial constant
	 */
	private static final long serialVersionUID = 9190391605769957067L;

>>>>>>> Stashed changes
	/** The default size of the drawing panel. */
	private static final Dimension PANEL_DEFAULT_SIZE = new Dimension(500, 300);

	/** The initial thickness size. */
	private static final int DEFAULT_THICKNESS = 10;

<<<<<<< Updated upstream
	/** The initial point of the tool. */
	private static final Point INITIAL_POINT = new Point(0, 0);

=======
>>>>>>> Stashed changes
	// fields

	/** Stack to keep track of all shapes drawn on the panel */
	private Stack<PaintShape> myShapesStack;

	/** Stack of shapes that were removed by undo */
	private Stack<PaintShape> myRedoStack;

	/** Current shape on panel */
	private Shape myCurrentShape;
<<<<<<< Updated upstream

=======
	
	/** The current color being used for drawing */
>>>>>>> Stashed changes
	private Color myCurrentColor;
	
	/** Current primary color */
	private Color myPrimaryColor;

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

<<<<<<< Updated upstream
	/** When true clear the panel */
	private boolean myClearStatus;

	/** Boolean to inform paintpanel if it can draw with the current shape */
	private boolean myDragStatus;

	/** Boolean to inform paintpanel if undo was pressed */
	private boolean myUndoStatus;

	/** Boolean to inform paintpanel if redo was pressed */
	private boolean myRedoStatus;

=======
	/** Boolean to inform paintpanel if it can draw with the current shape */
	private boolean myDragStatus;

>>>>>>> Stashed changes
	/**
	 * Paint panel constructor
	 */
	public PaintPanel() {
		super();

		// initialize some of the base fields
		myPrimaryColor = DEFAULT_PRIMARY;
		mySecondaryColor = DEFAULT_SECONDARY;
		myThickness = DEFAULT_THICKNESS;
<<<<<<< Updated upstream
		myClearStatus = false;
=======
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
	public void paintComponent(Graphics theGraphics) {
=======
	public void paintComponent(final Graphics theGraphics) {
>>>>>>> Stashed changes
		super.paintComponent(theGraphics);
		final Graphics2D g2d = (Graphics2D) theGraphics;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);

		// send a property change to PowerPaintGUI
		updateGUI();

<<<<<<< Updated upstream
		// draw a shape with the current tool only when the mouse is being
		// dragged. This is to provide visual feedback as the user draws the
		// shape.
		if (myDragStatus) {
			g2d.setStroke(new BasicStroke(myThickness));
			g2d.setPaint(myCurrentColor);
			g2d.draw(myCurrentTool.getShape());
		}

=======
>>>>>>> Stashed changes
		// draw all shapes currently on the list to the panel
		if (!myShapesStack.isEmpty()) {
			for (final PaintShape ps : myShapesStack) {
				g2d.setStroke(new BasicStroke(ps.getThickness()));
				g2d.setPaint(ps.getColor());
				g2d.draw(ps.getShape());
			}
		}
<<<<<<< Updated upstream
=======
		
		// draw a shape with the current tool only when the mouse is being
		// dragged. This is to provide visual feedback as the user draws the
		// shape.
		if (myDragStatus) {
			g2d.setStroke(new BasicStroke(myThickness));
			g2d.setPaint(myCurrentColor);
			g2d.draw(myCurrentTool.getShape());
		}
>>>>>>> Stashed changes

	}

	/**
	 * Sets primary color of the tool to use on panel
	 * 
	 * @param Color the color to change to
	 */
<<<<<<< Updated upstream
	public void setColor(Color theColor) {
=======
	public void setColor(final Color theColor) {
>>>>>>> Stashed changes
		myPrimaryColor = theColor;
	}

	/**
	 * Sets secondary color of the tool to use on panel
	 * 
	 * @param Color the color to change to
	 */
<<<<<<< Updated upstream
	public void setSecondaryColor(Color theColor) {
=======
	public void setSecondaryColor(final Color theColor) {
>>>>>>> Stashed changes
		mySecondaryColor = theColor;
	}

	/**
	 * Sets thickness of the tool for the panel
	 * 
	 * @param int of the thickness value
	 */
<<<<<<< Updated upstream
	public void setThickness(int theThickness) {
=======
	public void setThickness(final int theThickness) {
>>>>>>> Stashed changes
		myThickness = theThickness;
	}

	/**
	 * Sets what the current tool used on the panel is
	 * 
	 * @param PaintTool the type of tool used
	 */
<<<<<<< Updated upstream
	public void setCurrentTool(PaintTool theTool) {
=======
	public void setCurrentTool(final PaintTool theTool) {
>>>>>>> Stashed changes
		myCurrentTool = theTool;
	}

	/**
	 * Save shapes to a list to keep track of.
	 * 
	 * @param Shape shape to be saved
	 */
	public void saveShape(final Shape theShape) {
		PaintShape ps = new PaintShape(theShape, myCurrentColor, myThickness);
		myShapesStack.push(ps);
	}

	/**
	 * Clear the shapes list and draw an empty panel
	 */
	public void clearShapes() {
		
<<<<<<< Updated upstream
		//make a backup of current shapes in case of undo

=======
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
	 * Undos a shape that was drawn
=======
	 * Redos a shape that was undone
>>>>>>> Stashed changes
	 */
	public void redo() {
		if (!myRedoStack.isEmpty()) {
			PaintShape s = myRedoStack.pop();
			myShapesStack.push(s);
<<<<<<< Updated upstream

		}

		repaint();

	}
=======
			
			repaint();

		}

	}
	
	/**
	 * Returns all shapes currently drawn
	 * 
	 * @return Shape stack of all currently drawn shapes
	 */
	public Stack<PaintShape> getShapesList() {
		Stack<PaintShape> copy = (Stack<PaintShape>) myShapesStack.clone();
		return copy;
		
	}
	
	/**
	 * Clears panel and redraws shapes with a new stack of shapes
	 * 
	 * @param Shape shapes to be loaded to panel
	 */
	public void loadShapes(final Stack<PaintShape> theShapes) {
		clearShapes();
		myShapesStack.addAll(theShapes);
		
		//draw new shapes
		repaint();
		
	}
	
>>>>>>> Stashed changes

	/**
	 * When called this method fires property changes to the GUI class to update
	 * various buttons such as clear, undo and redo.
	 * 
	 */
	private void updateGUI() {

		// update gui on the status of the panel if it has shapes drawn to it
<<<<<<< Updated upstream
		firePropertyChange(PROPERTY_HAS_SHAPE, null,
				!myShapesStack.isEmpty());
=======
		firePropertyChange(PROPERTY_HAS_SHAPE, null,!myShapesStack.isEmpty());
>>>>>>> Stashed changes

		// update gui on the status of the redo stack
		firePropertyChange(PROPERTY_SHAPE_REDO, null, !myRedoStack.isEmpty());

	}

	// inner class to track mouse input
	class MouseHandler extends MouseInputAdapter {
		
		@Override
		// set start point at mouse click
		public void mousePressed(final MouseEvent theEvent) {
			
			if (myThickness > 0) {
				if(myCurrentTool instanceof EraserTool)
				{
					myCurrentColor = Color.white;
				}
				else
				{
					if (theEvent.getButton() == 1)
					{
						myCurrentColor = myPrimaryColor;
					}
					else
					{
						myCurrentColor = mySecondaryColor;
					}
				}
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
				myCurrentTool.reset();
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
