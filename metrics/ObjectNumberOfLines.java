package metrics;

import tau.smlab.syntech.spectraapi.ObjectInfo;

public class ObjectNumberOfLines extends ObjectInfoMetric {

  public ObjectNumberOfLines(ObjectInfo objectInfo) {
    super(objectInfo);
  }

  @Override
  public Integer getValue() {
    return getObjectInfo().getTotalNumberOfLines();
  }

  @Override
  public String getName() {
    return "Number Of Lines";
  }

}
