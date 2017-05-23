package treemetric2;

public class InitialGar implements Metric {

  @Override
  public Integer getValue() {
    return ResourceHandler.getAPIMetric().getNumberOfInitialLTLGar();
  }

  @Override
  public String getName() {
    return "Initial Guarantees";
  }

}
