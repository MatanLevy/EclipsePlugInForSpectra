package treemetric2.views;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;

import treemetric2.NumberOfDefinesMetric;
import treemetric2.ProjectManager;
import treemetric2.ResourceHandler;
import treemetric2.Metric;
import treemetric2.MetricData;
import treemetric2.Node;

public class MetricView extends ViewPart {

  public static final String ID = "treemetric2.views.SampleView";
  private TableViewer viewer;
  private ResourceHandler resource = new ResourceHandler();
  private ProjectManager projectManager = new ProjectManager();

  class ViewLabelProvider extends LabelProvider implements ITableLabelProvider {
    public String getColumnText(Object obj, int index) {
      return getText(obj);
    }

    public Image getColumnImage(Object obj, int index) {
      return getImage(obj);
    }

    public Image getImage(Object obj) {
      return PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_ELEMENT);
    }
  }

  /**
   * The constructor.
   */
  public MetricView() {
  }

  public class TreeContentProvider implements ITreeContentProvider {
    @Override
    public boolean hasChildren(Object element) {
      return false;
    }

    @Override
    public Object getParent(Object element) {
      return null;
    }

    @Override
    public Object[] getElements(Object inputElement) {
      return ArrayContentProvider.getInstance().getElements(inputElement);
    }

    @Override
    public Object[] getChildren(Object parentElement) {
      return null;
    }
  }

  private void init() {
    ResourceHandler.init();
  }

  public void createPartControl(Composite parent) {
    
    

    Action action = new Action("Refresh Table", Action.AS_PUSH_BUTTON) {
      @Override
      public void run() {
        init();
        //viewer.refresh();
      }

    };
    IActionBars actionBars = getViewSite().getActionBars();
    IMenuManager dropDownMenu = actionBars.getMenuManager();
    IToolBarManager toolBar = actionBars.getToolBarManager();
    dropDownMenu.add(action);
    toolBar.add(action);

    TreeViewer viewer = new TreeViewer(parent);
    // viewer.setContentProvider(new TreeContentProvider());
    viewer.setContentProvider(new TreeContentProvider() {
      @Override
      public boolean hasChildren(Object element) {
        Node<Metric> elem = (Node<Metric>) element;
        return !elem.isLeaf();
      }

      @Override
      public Object getParent(Object element) {
        Node<Metric> elem = (Node<Metric>) element;
        if (elem.isRoot()) {
          return null;
        }
        return elem.getParent();
      }

      @Override
      public Object[] getChildren(Object parentElement) {
        Node<Metric> elem = ((Node<Metric>) parentElement);
        return elem.getChildren().toArray();
      }

      public Object[] getElements(Object inputElements) {
        return getChildren(inputElements);
      }
    });
    viewer.getTree().setHeaderVisible(true);
    viewer.getTree().setLinesVisible(true);
    TreeViewerColumn viewerColumn = new TreeViewerColumn(viewer, SWT.NONE);
    viewerColumn.getColumn().setWidth(300);
    viewerColumn.getColumn().setText("Metric Name");
    viewerColumn.setLabelProvider(new ColumnLabelProvider() {
      public String getText(Object element) {
        Node<Metric> m = (Node<Metric>) element;
        return m.getData().getName();
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
    viewer.setInput(new MetricData().getListOfNodes());

    GridLayoutFactory.fillDefaults().generateLayout(parent);
  }
  public void setFocus() {
  }
}
