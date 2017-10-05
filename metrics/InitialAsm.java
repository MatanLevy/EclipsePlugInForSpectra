package metrics;

import org.eclipse.xtext.resource.XtextResource;

public class InitialAsm extends AbstractMetricFileLevel implements Metric {

  public InitialAsm(XtextResource xtext) {
    super(xtext);
  }

  @Override
  public Integer getValue() {
    return resource.getAPIMetric().getNumberOfInitialLTLAsm();
  }

  @Override
  public String getName() {
    return "Initial Assumptions";
  }

}
