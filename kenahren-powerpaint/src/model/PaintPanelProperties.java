package model;

import java.awt.Color;

/**
 * Defines properties that a PropertyChangeListener will be notifying for. Also
 * provides constants such as the default primary and secondary color for all
 * classes.
 * 
 * @author Kenneth Ahrens
 * @author Katlyn Malone
 * @version Fall 2020
 *
 */

public interface PaintPanelProperties {

	/**
	 * Property for a change listener for when there is a shape on the panel.
	 * Tell GUI to reenable or disable the clear button.
	 */
	String PROPERTY_SHAPE_ADD = "Shape(s) on paint panel";

	// default colors for all classes to access

	/** Default color for primary color */
	Color DEFAULT_PRIMARY = new Color(51, 0, 111); //UW purple

	/** Default color for secondary color */
	Color DEFAULT_SECONDARY = new Color(232, 211, 162);; //UW gold

}
