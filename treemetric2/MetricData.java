package treemetric2;

import java.util.List;

import tau.smlab.syntech.spectraapi.ObjectInfo;

public class MetricData {
  
  private Node<Metric> root;
  
  public MetricData() {
    root = new Node<Metric>(new NumberOfDefinesMetric());
    Node<Metric> child1 = new Node<Metric>(new NumberOfDefinesMetric());
    Node<Metric> child2 = new Node<Metric>(new NumberOfVariables());
    Node<Metric> child3 = new Node<Metric>(new InitialAsm());
    Node<Metric> child4 = new Node<Metric>(new GloballyAsm());
    Node<Metric> child5 = new Node<Metric>(new GloballyFinallyAsm());
    Node<Metric> child6 = new Node<Metric>(new InitialGar());
    Node<Metric> child7 = new Node<Metric>(new GloballyGar());
    Node<Metric> child8 = new Node<Metric>(new GloballyFinallyGar());
    Node<Metric> child21 = new Node<Metric>(new NumberOfAUXVariables());
    Node<Metric> child22 = new Node<Metric>(new NumberOfSYSVariables());
    Node<Metric> child23 = new Node<Metric>(new NumberOfENVVariables());
    root.addChild(child1);
    root.addChild(child2);
    root.addChild(child3);
    root.addChild(child4);
    root.addChild(child5);
    root.addChild(child6);
    root.addChild(child7);
    root.addChild(child8);
    child2.addChild(child21);
    child2.addChild(child22);
    child2.addChild(child23);
    List<ObjectInfo> lst = ResourceHandler.getAPIMetric().getObjectInfoList();
    for (ObjectInfo element : lst) {
      Node<Metric> namechild = new Node<Metric>(new ObjectName(element));
      root.addChild(namechild);
      namechild.addChild(new ObjectDeepestNestingOfExpression(element));
      namechild.addChild(new ObjectDeepestNestingOfPastLTL(element));
      namechild.addChild(new ObjectNumberOfAuxVariables(element));
      namechild.addChild(new ObjectNumberOfEnvVariables(element));
      namechild.addChild(new NumberOfSysVar(element));
      namechild.addChild(new ObjectNumberOfPatternsInstances(element));
      namechild.addChild(new ObjectNumberOfPredicatesInstances(element));
      namechild.addChild(new ObjectNumberOfLinesWithoutComment(element));
      namechild.addChild(new NumberOfLines(element));
    }
    
  }
  public Node<Metric> getListOfNodes() {
    return root;
  }
}
