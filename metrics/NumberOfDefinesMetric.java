package metrics;

import org.eclipse.xtext.resource.XtextResource;

public class NumberOfDefinesMetric extends AbstractMetricFileLevel implements Metric {
  
   
  public NumberOfDefinesMetric(XtextResource xtext) {
    super(xtext);
  }

  public Integer getValue() {
    return resource.getAPIMetric().gerNumberOfDefine();
  }
  
  public String getName() { 
    return "number Of Defines";
  }
}
