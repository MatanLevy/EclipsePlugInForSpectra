package metrics;

import org.eclipse.xtext.resource.XtextResource;

public class GloballyGar extends AbstractMetricFileLevel implements Metric {

  public GloballyGar(XtextResource xtext) {
    super(xtext);
  }

  @Override
  public Integer getValue() {
    return resource.getAPIMetric().getNumberOfGloballyLTLGar();
  }

  @Override
  public String getName() {
    return "Globally Guarantees";
  }

}
