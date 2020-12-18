package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

import javax.swing.Icon;

/**
<<<<<<< Updated upstream
=======
 * Used to create the custom color icons used in the Options menu
>>>>>>> Stashed changes
 * 
 * @author Kenneth Ahrens
 * @author Katlyn Malone
 * @version Fall 2020
 */

<<<<<<< Updated upstream
public class ColorIcon implements Icon {
=======
public class ColorIcon implements Icon{
>>>>>>> Stashed changes
	
    /** The color of the icon. */
    private Color myColor;
    
    /** The height of the icon. */
    private static final int HEIGHT = 14;
    
    /** The width of the icon. */
    private static final int WIDTH = 14;
   
    
    /**
     * Constructs a new icon with the given color.
     * 
     * @param theColor color of the icon.
     */
    public ColorIcon(final Color theColor) {
        myColor = theColor;
    }
    
    @Override
<<<<<<< Updated upstream
=======
    // creates the custom icon with the color input
>>>>>>> Stashed changes
    public void paintIcon(final Component theComponent, 
                          final Graphics theGraphics, final int theX, final int theY) {
        
    	//the fill color
        theGraphics.setColor(myColor);
        theGraphics.fillRect(theX, theY, WIDTH, HEIGHT);
        
        //the border
        theGraphics.setColor(Color.BLACK);
        theGraphics.drawRect(theX, theY, WIDTH, HEIGHT);
        
    }
    
    /** 
     * This sets the color of the icon.
     * 
     * @param theColor the color if the icon.
     */
    public void setColor(final Color theColor) {
        myColor = theColor;
    }
    
    /** 
     * Getter for myColor
     * 
     * @return current color of icon
     */
    public Color getColor() {
        return myColor;
    }
    
    @Override
    public int getIconWidth() {
        return WIDTH;
    }

    @Override
    public int getIconHeight() {
        return HEIGHT;
    }

}
