package treemetric2;

public class NumberOfDefinesMetric extends AbstractMetric implements Metric {
  
   
  public Integer getValue() {
    return ResourceHandler.getAPIMetric().gerNumberOfDefine();
  }
  
  public String getName() { 
    return "number Of Defines";
  }
}
