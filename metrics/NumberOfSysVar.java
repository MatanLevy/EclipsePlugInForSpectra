package metrics;

import tau.smlab.syntech.spectraapi.ObjectInfo;

public class NumberOfSysVar extends ObjectInfoMetric {

  public NumberOfSysVar(ObjectInfo objectInfo) {
    super(objectInfo);
  }

  @Override
  public Integer getValue() {
    return getObjectInfo().getNumberOfSysVar();
  }

  @Override
  public String getName() {
    return "Number of SYS Variables";
  }

}
