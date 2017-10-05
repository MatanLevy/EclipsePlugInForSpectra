package metrics;

import org.eclipse.xtext.resource.XtextResource;

public class GloballyFinallyAsm extends AbstractMetricFileLevel implements Metric {

  public GloballyFinallyAsm(XtextResource xtext) {
    super(xtext);
  }

  @Override
  public Integer getValue() {
    return resource.getAPIMetric().getNumberOfGloballyFinallyLTLAsm();
  }

  @Override
  public String getName() {
    return "Globally Finally Assumption";
  }

}
