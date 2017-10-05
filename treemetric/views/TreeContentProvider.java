package treemetric.views;

import org.eclipse.jface.viewers.ITreeContentProvider;

import metrics.Metric;
import model.Node;
/**
 *implemention of treeContentProvider that should be passed as argument to TreeViewer
 *in order to define the structre of the tree in the table 
 *
 */
public class TreeContentProvider implements ITreeContentProvider {

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

}
