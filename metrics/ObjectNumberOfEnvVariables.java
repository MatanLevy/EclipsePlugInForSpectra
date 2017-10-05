package metrics;

import tau.smlab.syntech.spectraapi.ObjectInfo;

public class ObjectNumberOfEnvVariables extends ObjectInfoMetric {

  public ObjectNumberOfEnvVariables(ObjectInfo objectInfo) {
    super(objectInfo);
  }

  @Override
  public Integer getValue() {
    return getObjectInfo().getNumberOfEnvVar();
  }

  @Override
  public String getName() {
    return "Number of ENV variables";
  }

}
