package treemetric2;

public class NumberOfVariables implements Metric {
  public Integer getValue() {
    return ResourceHandler.getAPIMetric().getNumberOfAUXVar() + ResourceHandler.getAPIMetric()
    .getNumberOfENVVar() + ResourceHandler.getAPIMetric().getNumberOfSYSVar();
  }
  
  public String getName() { 
    return "Total Number Of Variables";
  }
}