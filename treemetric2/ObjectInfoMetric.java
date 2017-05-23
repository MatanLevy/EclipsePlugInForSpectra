package treemetric2;

import tau.smlab.syntech.spectraapi.ObjectInfo;

public abstract class ObjectInfoMetric implements Metric {
  ObjectInfo objectinfo;
  
  public ObjectInfoMetric(ObjectInfo objectInfo) {
    this.objectinfo = objectInfo;
  }
  public ObjectInfo getObjectInfo() {
    return objectinfo;
  }
}
