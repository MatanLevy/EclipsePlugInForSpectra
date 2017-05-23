package treemetric2;

public class NumberOfSYSVariables  implements Metric{

  @Override
  public Integer getValue() {
    return ResourceHandler.getAPIMetric().getNumberOfSYSVar();
  }

  @Override
  public String getName() {
    return "Number Of SYS Variables";
  }
  

}
