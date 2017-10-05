package metrics;

import org.eclipse.xtext.resource.XtextResource;

public class NumberOfSYSVariables extends AbstractMetricFileLevel implements Metric{

  public NumberOfSYSVariables(XtextResource xtext) {
    super(xtext);
  }

  @Override
  public Integer getValue() {
    return resource.getAPIMetric().getNumberOfSYSVar();
  }

  @Override
  public String getName() {
    return "Number Of SYS Variables";
  }
  

}
