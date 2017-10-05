package metrics;

import org.eclipse.xtext.resource.XtextResource;

public class InitialGar extends AbstractMetricFileLevel implements Metric {

  public InitialGar(XtextResource xtext) {
    super(xtext);
  }

  @Override
  public Integer getValue() {
    return resource.getAPIMetric().getNumberOfInitialLTLGar();
  }

  @Override
  public String getName() {
    return "Initial Guarantees";
  }

}
