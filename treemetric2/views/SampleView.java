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

import treemetric2.ImplMetric;
import treemetric2.Metric;
import treemetric2.MetricData;
import treemetric2.Node;

public class SampleView extends ViewPart {

  public static final String ID = "treemetric2.views.SampleView";
  private TableViewer viewer;
  private Action action1;
  private Action action2;
  private Action doubleClickAction;

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
  public SampleView() {
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
  
  
  
  public void createPartControl(Composite parent) {
    TreeViewer viewer = new TreeViewer(parent);
//    viewer.setContentProvider(new TreeContentProvider());
    viewer.setContentProvider(new TreeContentProvider() { 
      @Override 
      public boolean hasChildren(Object element) {
        Node<Metric> elem = (Node<Metric>)element;
        return  !elem.isLeaf();
      }
      @Override
      public Object getParent(Object element) {
        Node<Metric> elem = (Node<Metric>)element;
        if (elem.isRoot()) {
          return null;
        }
        return elem.getParent(); 
      }
      @Override
      public Object[] getChildren(Object parentElement) {
        System.out.println("**************** + " + parentElement.getClass().getName() + " *********");
        Node<Metric> elem = ((Node<Metric>)parentElement);
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
    viewerColumn.getColumn().setText("Names");
    viewerColumn.setLabelProvider(new ColumnLabelProvider() {
      public String getText(Object element) {
        Node<Metric> m  = (Node<Metric>)element;
        return m.getData().getName();
      }
    });
    viewerColumn = new TreeViewerColumn(viewer, SWT.NONE, 1);
    viewerColumn.getColumn().setWidth(300);
    viewerColumn.getColumn().setText("Value");
    viewerColumn.setLabelProvider(new ColumnLabelProvider() {
      public String getText(Object element) {
        System.out.println("**************** + " + element.getClass().getName() + " *********");
        Node<Metric> m = (Node<Metric>)element;
        return m.getData().getValue().toString();
      }
    });
    viewer.setInput(new MetricData().getListOfNodes());

    GridLayoutFactory.fillDefaults().generateLayout(parent);
  }

  private void hookContextMenu() {
    MenuManager menuMgr = new MenuManager("#PopupMenu");
    menuMgr.setRemoveAllWhenShown(true);
    menuMgr.addMenuListener(new IMenuListener() {
      public void menuAboutToShow(IMenuManager manager) {
        SampleView.this.fillContextMenu(manager);
      }
    });
    Menu menu = menuMgr.createContextMenu(viewer.getControl());
    viewer.getControl().setMenu(menu);
    getSite().registerContextMenu(menuMgr, viewer);
  }

  private void contributeToActionBars() {
    IActionBars bars = getViewSite().getActionBars();
    fillLocalPullDown(bars.getMenuManager());
    fillLocalToolBar(bars.getToolBarManager());
  }

  private void fillLocalPullDown(IMenuManager manager) {
    manager.add(action1);
    manager.add(new Separator());
    manager.add(action2);
  }

  private void fillContextMenu(IMenuManager manager) {
    manager.add(action1);
    manager.add(action2);
    // Other plug-ins can contribute there actions here
    manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
  }

  private void fillLocalToolBar(IToolBarManager manager) {
    manager.add(action1);
    manager.add(action2);
  }

  private void makeActions() {
    action1 = new Action() {
      public void run() {
        showMessage("Action 1 executed");
      }
    };
    action1.setText("Action 1");
    action1.setToolTipText("Action 1 tooltip");
    action1.setImageDescriptor(
        PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));

    action2 = new Action() {
      public void run() {
        showMessage("Action 2 executed");
      }
    };
    action2.setText("Action 2");
    action2.setToolTipText("Action 2 tooltip");
    action2.setImageDescriptor(
        PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));
    doubleClickAction = new Action() {
      public void run() {
        ISelection selection = viewer.getSelection();
        Object obj = ((IStructuredSelection) selection).getFirstElement();
        showMessage("Double-click detected on " + obj.toString());
      }
    };
  }

  private void hookDoubleClickAction() {
    viewer.addDoubleClickListener(new IDoubleClickListener() {
      public void doubleClick(DoubleClickEvent event) {
        doubleClickAction.run();
      }
    });
  }

  private void showMessage(String message) {
    MessageDialog.openInformation(viewer.getControl().getShell(), "Sample View", message);
  }

  /**
   * Passing the focus request to the viewer's control.
   */
  public void setFocus() {
    viewer.getControl().setFocus();
  }
}
