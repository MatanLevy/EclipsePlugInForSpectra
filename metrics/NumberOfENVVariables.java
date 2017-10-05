package metrics;

import org.eclipse.xtext.resource.XtextResource;

public class NumberOfENVVariables extends AbstractMetricFileLevel implements Metric{

  public NumberOfENVVariables(XtextResource xtext) {
    super(xtext);
  }

  @Override
  public Integer getValue() {
    return resource.getAPIMetric().getNumberOfENVVar();
  }

  @Override
  public String getName() {
    return "Number Of ENV Variables";
  }
  

}
