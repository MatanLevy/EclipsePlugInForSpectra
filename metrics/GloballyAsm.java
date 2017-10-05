package metrics;

import org.eclipse.xtext.resource.XtextResource;

public class GloballyAsm extends AbstractMetricFileLevel implements Metric{

  public GloballyAsm(XtextResource xtext) {
    super(xtext);
  }

  @Override
  public Integer getValue() {
   return resource.getAPIMetric().getNumberOfGloballyLTLAsm();
  }

  @Override
  public String getName() {
    return "Globally Assumptions";
  }

}
