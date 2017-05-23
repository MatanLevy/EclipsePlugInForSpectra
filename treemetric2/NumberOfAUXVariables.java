package treemetric2;

public class NumberOfAUXVariables  implements Metric{

  @Override
  public Integer getValue() {
    return ResourceHandler.getAPIMetric().getNumberOfAUXVar();
  }

  @Override
  public String getName() {
    return "Number Of AUX Variables";
  }
  

}