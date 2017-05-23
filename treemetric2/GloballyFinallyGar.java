package treemetric2;

public class GloballyFinallyGar implements Metric{

  @Override
  public Integer getValue() {
    return ResourceHandler.getAPIMetric().getNumberOfGloballyFinallyLTLGar();
  }

  @Override
  public String getName() {
    return "Globally Finally Guarantees";
  }
  

}
