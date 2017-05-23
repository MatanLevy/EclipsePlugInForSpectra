package treemetric2;

import tau.smlab.syntech.spectraapi.ObjectInfo;

public class NumberOfLines extends ObjectInfoMetric {

  public NumberOfLines(ObjectInfo objectInfo) {
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
