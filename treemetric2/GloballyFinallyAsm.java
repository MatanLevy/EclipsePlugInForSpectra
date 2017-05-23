package treemetric2;

public class GloballyFinallyAsm implements Metric {

  @Override
  public Integer getValue() {
    return ResourceHandler.getAPIMetric().getNumberOfGloballyFinallyLTLAsm();
  }

  @Override
  public String getName() {
    return "Globally Finally Assumption";
  }

}
