package treemetric2;

public class GloballyAsm implements Metric{

  @Override
  public Integer getValue() {
   return ResourceHandler.getAPIMetric().getNumberOfGloballyLTLAsm();
  }

  @Override
  public String getName() {
    return "Globally Assumptions";
  }

}
