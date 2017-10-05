package metrics;

import tau.smlab.syntech.spectraapi.ObjectInfo;

public class ObjectNumberOfDefines extends ObjectInfoMetric {

  public ObjectNumberOfDefines(ObjectInfo objectInfo) {
    super(objectInfo);
  }

  @Override
  public Integer getValue() {
    return getObjectInfo().getNumberOfDefines();
  }

  @Override
  public String getName() {
    return "Number of defines";
  }

}
