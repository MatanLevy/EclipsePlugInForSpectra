package metrics;

import org.eclipse.xtext.resource.XtextResource;

public class Monitors extends AbstractMetricFileLevel implements Metric {

  public Monitors(XtextResource xtext) {
    super(xtext);
  }

  @Override
  public Integer getValue() {
    return resource.getAPIMetric().getNumberOfMonitor();
  }

  @Override
  public String getName() {
    return "Monitors";
  }

}
