package treemetric2;

public class Monitors implements Metric {

  @Override
  public Integer getValue() {
    return ResourceHandler.getAPIMetric().getNumberOfMonitor();
  }

  @Override
  public String getName() {
    return "Monitors";
  }

}
