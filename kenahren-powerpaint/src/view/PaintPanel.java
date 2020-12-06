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
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;
import javax.swing.plaf.basic.BasicDesktopIconUI.MouseInputHandler;

import tools.AbstractPaintTool;
import tools.LineTool;
import tools.PaintShape;
import tools.PaintTool;

public class PaintPanel extends JPanel {

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
	private final ArrayList<PaintShape> myPreviousShapes;

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

	/**
	 * Paint panel constructor
	 */
	public PaintPanel() {
		super();

		// initialize some of the base fields

		myPreviousShapes = new ArrayList<PaintShape>();
		myColor = DEFAULT_COLOR;
		myThickness = 1;

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

		// draw something
		g2d.setStroke(new BasicStroke(myThickness));
		g2d.setPaint(myColor);
		g2d.draw(myCurrentTool.getShape());

		// draw previous shapes
		for (final PaintShape p : myPreviousShapes) {
			g2d.setStroke(new BasicStroke(p.getThickness()));
			g2d.setPaint(p.getColor());
			g2d.draw(p.getShape());
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
		PaintShape PS = new PaintShape(theShape, myColor, myThickness);
		myPreviousShapes.add(PS);
	}

	// inner class to track mouse input
	class MouseHandler extends MouseInputAdapter {
		@Override
		// set start point at mouse click
		public void mousePressed(final MouseEvent theEvent) {

			myCurrentTool.setStartPoint(theEvent.getPoint());
			myCurrentShape = myCurrentTool.getShape();
		}

		@Override
		// set the ending point
		public void mouseDragged(final MouseEvent theEvent) {

			myCurrentTool.setNextPoint(theEvent.getPoint());
			myCurrentShape = myCurrentTool.getShape();

			// update panel with new line that follows the drag
			repaint();
		}

		@Override
		// add this new shape to the list
		public void mouseReleased(final MouseEvent theEvent) {

			saveShape(myCurrentShape);
		}

		@Override
		// custom cursor when mouse is on the paint panel
		public void mouseEntered(final MouseEvent theEvent) {

			setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
		}

	}
}
