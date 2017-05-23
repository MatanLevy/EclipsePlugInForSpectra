package treemetric2;

public class NumberOfENVVariables  implements Metric{

  @Override
  public Integer getValue() {
    return ResourceHandler.getAPIMetric().getNumberOfENVVar();
  }

  @Override
  public String getName() {
    return "Number Of ENV Variables";
  }
  

}
