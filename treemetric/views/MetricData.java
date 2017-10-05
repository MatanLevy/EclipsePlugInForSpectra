package treemetric.views;

import java.util.Arrays;
import java.util.List;

import org.eclipse.xtext.resource.XtextResource;

import controller.InstanceCreator;
import metrics.Metric;
import metrics.NumberOfDefinesMetric;
import metrics.ObjectName;
import model.Node;
import model.ResourceHandler;
import tau.smlab.syntech.spectraapi.ObjectInfo;
/**
 * this class is used for view of the metric plug in. I used a treeViewer view,which is a 
 * Hierarchical table. so MetricData represent the tree - with two levels : 
 * File level - all the metric in file level
 * Asm/Gar level - all the Asm/Gar metrics.
 * 
 * the hierarchy would be : 
 * 
 *  root -> (file_metrics_1, ... filelevel_metric_n,asm/gar_1,...asm/gar_n)
 *  when : 
 *        file_metric_i is a leaf(key-value metric)
 *        asm/gar_i is a Node with root metric(key= name of the metric) and list of 
 *        childrens ,which are metrics of asm/gar level.
 *        
 *
 */
public class MetricData {

  private Node<Metric> root; //dummy root

  public MetricData(ResourceHandler resource,List<String> classNamesFileLevel,
      List<String> classesNamesAsmGarLevel) {
    XtextResource xtext = resource.getResource();
    root = new Node<Metric>(new NumberOfDefinesMetric(xtext)); //root is dummy
    for (Metric metric : InstanceCreator.createMetricListfromMetricNames(classNamesFileLevel, 
        Arrays.asList(xtext), org.eclipse.xtext.resource.XtextResource.class)) {
      root.addChild(metric); //adding file level metrics
    }
    List<ObjectInfo> lst = resource.getAPIMetric().getObjectInfoList();
    for (ObjectInfo element : lst) {
      Node<Metric> namechild = new Node<Metric>(new ObjectName(element));
      root.addChild(namechild);
      for (Metric metric : InstanceCreator.createMetricListfromMetricNames(classesNamesAsmGarLevel,
          Arrays.asList(element),tau.smlab.syntech.spectraapi.ObjectInfo.class)) {
        namechild.addChild(metric); //asm/gar level metrics
      }
    }
  }
  public Node<Metric> getListOfNodes() {
    return root;
  }
}
