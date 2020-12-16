package view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

import actions.EllipseAction;
import actions.EraserAction;
import actions.LineAction;
import actions.PencilAction;
import actions.RectangleAction;

public class PaintToolBar extends JToolBar
{
	private final PaintPanel myPaintPanel;
	
	/** A button group for tool actions in toolbar */
	private ButtonGroup myToolBarButtons;

	/** A list of tool actions from actions package. */
	private List<Action> myToolActions;

	/** Toolbar of tools attached to jpanel */
	private JToolBar myToolBar;

	/** Sets default tool action */
	private Action myDefaultAction;
	
	public PaintToolBar(JFrame theFrame, PaintPanel thePanel)
	{
		super();
		myPaintPanel = thePanel;
		myToolBar = new JToolBar();
		myToolBarButtons = new ButtonGroup();

		// initialize tool actions for buttons
		myDefaultAction = new LineAction(myPaintPanel);
		myToolActions = new ArrayList<Action>();
		myToolActions.add(new PencilAction(myPaintPanel));
		myToolActions.add(myDefaultAction); // line tool
		myToolActions.add(new RectangleAction(myPaintPanel));
		myToolActions.add(new EllipseAction(myPaintPanel));
		myToolActions.add(new EraserAction(myPaintPanel));
	}
	
	public void setupToolBarActions() {

		// associate tool buttons with actions and add to toolbar
		for (final Action act : myToolActions) {
			final JToggleButton tb = new JToggleButton(act);
			myToolBarButtons.add(tb);
			myToolBar.add(tb);

			// selects the line tool at the start as default
			if (tb.getAction() == myDefaultAction) {
				tb.setSelected(true);
			}

		}

	}
}
