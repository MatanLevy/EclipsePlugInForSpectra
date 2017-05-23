package treemetric2;

public class GloballyGar implements Metric {

  @Override
  public Integer getValue() {
    return ResourceHandler.getAPIMetric().getNumberOfGloballyLTLGar();
  }

  @Override
  public String getName() {
    return "Globally Guarantees";
  }

}
