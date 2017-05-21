package treemetric2;

import java.util.ArrayList;
import java.util.List;

public class MetricData {
  
  private Node<Metric> root;
  private List<Node<Metric>> iterateing;
  
  public MetricData() {
    root = new Node<Metric>(new ImplMetric());
    Node<Metric> child1 = new Node<Metric>(new ImplMetric2());
    Node<Metric> child2 = new Node<Metric>(new ImplMetric3());
    Node<Metric> child3 = new Node<Metric>(new ImplMetric());
    root.addChild(child1);
    root.addChild(child2);
    child2.addChild(child3);
    //iterateing = addAllElementsToList(root);
  }
  public Node<Metric> getListOfNodes() {
    return root;
  }
  
  private List<Node<Metric>> addAllElementsToList(Node<Metric> root1) {
    List<Node<Metric>> lst = new ArrayList<>();
    lst.add(root1);
    for (Node<Metric> child : root1.getChildren()) {
      lst.addAll(addAllElementsToList(child));
    }
    return lst;
    
  }

}
