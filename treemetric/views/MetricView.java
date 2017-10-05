package treemetric.views;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.part.ViewPart;

import controller.ControllerImpl;
import controller.Icontroller;
import metrics.Metric;
import model.IModel;
import model.ImplModel;
import model.Node;
/**
 * this is the viewPart of the table of metrics.
 * 
 * this is a view with refresh button that always present metrics of current file we are
 * in our open eclipse editor.
 * 
 *
 */
public class MetricView extends ViewPart {

  public static final String ID = "treemetric2.views.SampleView";

  private TreeViewer viewer;
  
  private static IModel model= new ImplModel();
  
  private static Icontroller controller = new ControllerImpl();
  
  public static Icontroller getController() {
    return controller;
  }


  private Composite parent;


  public MetricView() {
  }
  public void createPartControl(Composite parent) {
    this.parent = parent;
    addRefreshButton();
    model.UpdateResource(null);
    buildNewView();
  }
  
  public void addRefreshButton() {
    Action action = new Action("Refresh Table", Action.AS_PUSH_BUTTON) {
      @Override
      public void run() {
        model.UpdateResource(null);
        viewer.setInput(new MetricData(model.getResource(), controller.getFileLevelMetrics(),
            controller.getAsmGarLevelMetrics()).getListOfNodes());
      }

    };
    IActionBars actionBars = getViewSite().getActionBars();
    IMenuManager dropDownMenu = actionBars.getMenuManager();
    IToolBarManager toolBar = actionBars.getToolBarManager();
    dropDownMenu.add(action);
    toolBar.add(action);
  }

  public void buildNewView() {
    viewer = new TreeViewer(parent);
    viewer.setContentProvider(new TreeContentProvider());
    viewer.getTree().setHeaderVisible(true);
    viewer.getTree().setLinesVisible(true);
    createColumns();
    viewer.setInput(
        new MetricData(model.getResource(), controller.getFileLevelMetrics(), controller.getAsmGarLevelMetrics())
            .getListOfNodes());
    GridLayoutFactory.fillDefaults().generateLayout(parent);

  }

  public void createColumns() {
    TreeViewerColumn viewerColumn = new TreeViewerColumn(viewer, SWT.NONE);
    viewerColumn.getColumn().setWidth(300);
    viewerColumn.getColumn().setText("Metric Name");
    viewerColumn.setLabelProvider(new ColumnLabelProvider() {
      public String getText(Object element) {
        Node<Metric> m = (Node<Metric>) element;
        String name = m.getData().getName();
        return (name == null || name.length() == 0) ? "Annonymos" : m.getData().getName();
      }
    });
    viewerColumn = new TreeViewerColumn(viewer, SWT.NONE, 1);
    viewerColumn.getColumn().setWidth(300);
    viewerColumn.getColumn().setText("Value");
    viewerColumn.setLabelProvider(new ColumnLabelProvider() {
      public String getText(Object element) {
        Node<Metric> m = (Node<Metric>) element;
        if (m.getData().getValue() < -0) {
          return (m.getData().getValue() == -1 ? "Assumption" : "Guarantee");
        }
        return m.getData().getValue().toString();
      }
    });
  }

  public void setFocus() {
    if (controller.isChangableData()) {
      model.UpdateResource(null);
      viewer.setInput(new MetricData(model.getResource(), controller.getFileLevelMetrics(),
          controller.getAsmGarLevelMetrics()).getListOfNodes());
    }
    controller.SetChangbleData(false);
  }
}
