package metrics;

import org.eclipse.xtext.resource.XtextResource;

public class GloballyFinallyGar extends AbstractMetricFileLevel implements Metric{

  public GloballyFinallyGar(XtextResource xtext) {
    super(xtext);
  }

  @Override
  public Integer getValue() {
    return resource.getAPIMetric().getNumberOfGloballyFinallyLTLGar();
  }

  @Override
  public String getName() {
    return "Globally Finally Guarantees";
  }
  

}
