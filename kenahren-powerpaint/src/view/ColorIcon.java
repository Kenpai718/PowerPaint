package view;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

public class ColorIcon{

	//default square sizes
    public static final int WIDTH = 10;
    public static final int HEIGHT = 10;



    private Color myColor;
    private ImageIcon myColorIcon;

    public ColorIcon(Color theColor) {
        myColor = theColor;
        myColorIcon = createColorIcon(theColor);
    }

    public ImageIcon createColorIcon(Color theColor) {
        BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image.createGraphics();
        graphics.setPaint(theColor);
        graphics.fillRect (0, 0, WIDTH, HEIGHT);
        return new ImageIcon(image);
    }

    public void setColor(Color theColor) {
        myColor = theColor;
        myColorIcon = createColorIcon(theColor);
    }

    public ImageIcon getIcon() {
        return myColorIcon;
    }

}