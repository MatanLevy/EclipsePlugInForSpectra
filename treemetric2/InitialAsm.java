package treemetric2;

public class InitialAsm implements Metric {

  @Override
  public Integer getValue() {
    return ResourceHandler.getAPIMetric().getNumberOfInitialLTLAsm();
  }

  @Override
  public String getName() {
    return "Initial Assumptions";
  }

}
