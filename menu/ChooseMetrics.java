package menu;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.jface.action.ContributionItem;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ListSelectionDialog;

import controller.Icontroller;
import controller.InstanceCreator;
import controller.MetricsFilter;
import model.Pair;
import treemetric.views.MetricView;

/**
 * adding menu item for choosing metrics from a list of all possible metrics. 
 *
 */
public class ChooseMetrics extends ContributionItem {

  public ChooseMetrics() {
  }

  public ChooseMetrics(String id) {
    super(id);
  }

  @Override
  public void fill(Menu menu, int index) {
    MenuItem menuItem = new MenuItem(menu, SWT.CHECK, index);
    menuItem.setText("Choose Metrics");
    menuItem.addSelectionListener(new SelectionAdapter() {
      public void widgetSelected(SelectionEvent e) {
        ListSelectionDialog dialog = new ListSelectionDialog(new Shell(),
            InstanceCreator.getListOfAllMetrics().stream().map(Pair::getRight).collect(Collectors.toList()),
            new ArrayContentProvider(), new LabelProvider(), "Set here");
        dialog.setTitle("Please Choose Metrics to present");
        dialog.open();
        Object[] result = dialog.getResult();
        List<String> resultString = Arrays.asList(Arrays.copyOf(result, result.length, String[].class));
        List<String> fileLevelClasses = InstanceCreator.getListOfFileLevel().stream()
            .filter(x -> resultString.contains(x.getRight())).map(x -> x.getLeft()).collect(Collectors.toList());
        List<String> asmgarLevelClasses = InstanceCreator.getListOfAsmGarLevel().stream()
            .filter(x -> resultString.contains(x.getRight())).map(x -> x.getLeft()).collect(Collectors.toList());
        Icontroller controller = MetricView.getController();
        controller.setFileLevelMetrics(fileLevelClasses);
        controller.setAsmGarLevelMetrics(asmgarLevelClasses);
        controller.SetChangbleData(true);
        IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
        try {
          activePage.showView(MetricView.ID);
        } catch (PartInitException e1) {
          e1.printStackTrace();
        }

      }
    });

  }

}
