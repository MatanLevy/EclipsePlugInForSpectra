package treemetric2;

import tau.smlab.syntech.spectraapi.ObjectInfo;

public class ObjectNumberOfAuxVariables extends ObjectInfoMetric {

  public ObjectNumberOfAuxVariables(ObjectInfo objectInfo) {
    super(objectInfo);
  }

  @Override
  public Integer getValue() {
    return getObjectInfo().getNumberOfAuxVar();
  }

  @Override
  public String getName() {
    return "Number of AUX Variables";
  }

}
