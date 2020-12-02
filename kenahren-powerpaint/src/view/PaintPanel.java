package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;

import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;


public class PaintPanel extends JPanel {
	
	//constants
	
	/** The default size of the drawing panel. */
    private static final Dimension PANEL_DEFAULT_SIZE = new Dimension(400, 200);
    
    //fields
    
    private Color myColor;
	
	public PaintPanel() {
        super();
        
        setBackground(Color.WHITE);
        
        setPreferredSize(PANEL_DEFAULT_SIZE);
        
        setupListeners();
	}
	
	public void paintComponent(Graphics theGraphics) {
		super.paintComponent(theGraphics);
		final Graphics2D g2d = (Graphics2D) theGraphics;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                             RenderingHints.VALUE_ANTIALIAS_ON);
		
	}
	
	//to set color of drawing tool
	public void setColor(Color theColor) {
		myColor = theColor;
	}

	public void setupListeners() {
		//mouse listener
		//draagging listener
		//add a cursor
	}
}
