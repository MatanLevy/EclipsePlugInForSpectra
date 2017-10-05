package menu;

import org.eclipse.jface.action.ContributionItem;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import treemetric.views.MetricView;
/**
 * adding menu item for showing the metric view for the current active page
 *
 */
public class MetricAction extends ContributionItem {
  public MetricAction() {
  }

  public MetricAction(String id) {
    super(id);
  }

  @Override
  public void fill(Menu menu, int index) {
    MenuItem menuItem = new MenuItem(menu, SWT.CHECK, index);
    menuItem.setText("Show view");
    menuItem.addSelectionListener(new SelectionAdapter() {
      public void widgetSelected(SelectionEvent e) {
        IWorkbenchPage activePage  = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
        try {
          activePage.showView(MetricView.ID);
        } catch (PartInitException e1) {
          e1.printStackTrace();
        }
      }
    });
    
  }


}