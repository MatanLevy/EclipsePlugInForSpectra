package metrics;

import org.eclipse.xtext.resource.XtextResource;

public class NumberOfVariables extends AbstractMetricFileLevel implements Metric {
  public NumberOfVariables(XtextResource xtext) {
    super(xtext);
  }

  public Integer getValue() {
    return resource.getAPIMetric().getNumberOfAUXVar() + resource.getAPIMetric()
    .getNumberOfENVVar() + resource.getAPIMetric().getNumberOfSYSVar();
  }
  
  public String getName() { 
    return "Total Number Of Variables";
  }
}