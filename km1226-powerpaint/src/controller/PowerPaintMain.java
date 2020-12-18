package controller;

<<<<<<< Updated upstream
import javax.swing.JFrame;
import java.awt.EventQueue;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import view.PaintPanel;
=======
import java.awt.EventQueue;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

>>>>>>> Stashed changes
import view.PowerPaintGUI;


/**
<<<<<<< Updated upstream
=======
 * Main program that runs the powerpaint program
>>>>>>> Stashed changes
 * 
 * @author Kenneth Ahrens
 * @author Katlyn Malone
 * @version Fall 2020
 */

public class PowerPaintMain {

    /**
<<<<<<< Updated upstream
     * Private constructor to prevent external instantiation.
=======
     * Private constructor to prevent instantiation.
>>>>>>> Stashed changes
     */
    private PowerPaintMain() {
        throw new IllegalStateException();
    }

    /**
<<<<<<< Updated upstream
     * Creates and makes visible a ToolBarFrame.
=======
     * Runs the program and sets look and feel
>>>>>>> Stashed changes
     * 
     * @param theArgs Command line arguments, ignored.
     */
    public static void main(final String... theArgs) {
        /* Use an appropriate Look and Feel */
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (final UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (final IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (final InstantiationException ex) {
            ex.printStackTrace();
        } catch (final ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        /* Turn off metal's use of bold fonts */
        UIManager.put("swing.boldMetal", Boolean.FALSE);
        
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PowerPaintGUI();
            }
        });
    }
}
