package metrics;

import tau.smlab.syntech.spectraapi.ObjectInfo;

public class ObjectNumberOfPatternsInstances extends ObjectInfoMetric {

  public ObjectNumberOfPatternsInstances(ObjectInfo objectInfo) {
    super(objectInfo);
  }

  @Override
  public Integer getValue() {
    return getObjectInfo().getNumberOfPatternsInstances();
  }

  @Override
  public String getName() {
    return "Number of patterns instances";
  }

}
