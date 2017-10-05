package metrics;

import tau.smlab.syntech.spectraapi.ObjectInfo;

public class ObjectName extends ObjectInfoMetric {

  public ObjectName(ObjectInfo objectInfo) {
    super(objectInfo);
  }

  @Override
  public Integer getValue() {
    return (getObjectInfo().getType().equals("Asm")) ? -1 : -2;
  }

  @Override
  public String getName() {
    return getObjectInfo().getName();
  }

}
