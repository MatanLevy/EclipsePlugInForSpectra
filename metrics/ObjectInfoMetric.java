package metrics;

import tau.smlab.syntech.spectraapi.ObjectInfo;
/**
 * 
 * each metric that use gar/asm level should extends this abstract class
 * in order to get data from ObjectInfo class
 *
 */
public abstract class ObjectInfoMetric implements Metric {
  ObjectInfo objectinfo;
  
  public ObjectInfoMetric(ObjectInfo objectInfo) {
    this.objectinfo = objectInfo;
  }
  public ObjectInfo getObjectInfo() {
    return objectinfo;
  }
}
