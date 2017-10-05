package metrics;

import org.eclipse.xtext.resource.XtextResource;

public class NumberOfAUXVariables extends AbstractMetricFileLevel implements Metric{

  public NumberOfAUXVariables(XtextResource xtext) {
    super(xtext);
  }

  @Override
  public Integer getValue() {
    return resource.getAPIMetric().getNumberOfAUXVar();
  }

  @Override
  public String getName() {
    return "Number Of AUX Variables";
  }
  

}