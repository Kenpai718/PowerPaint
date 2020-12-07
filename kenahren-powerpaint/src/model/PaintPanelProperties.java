package model;

/**
 * Defines properties that a PropertyChangeListener will be notifying for.
 * 
 * @author Kenneth Ahrens, Katlyn Malone
 * @version Fall 2020
 *
 */

public interface PaintPanelProperties {

	/**
	 * Property for a change listener for when there is a shape on the panel.
	 * Tell GUI to reenable or disable the clear button.
	 */
	String PROPERTY_SHAPE_ADD = "Shape(s) on paint panel";

}
