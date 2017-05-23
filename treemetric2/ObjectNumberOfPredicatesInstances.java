package treemetric2;

import tau.smlab.syntech.spectraapi.ObjectInfo;

public class ObjectNumberOfPredicatesInstances extends ObjectInfoMetric {

  public ObjectNumberOfPredicatesInstances(ObjectInfo objectInfo) {
    super(objectInfo);
  }

  @Override
  public Integer getValue() {
    return getObjectInfo().getNumberOfPredicateInstances();
  }

  @Override
  public String getName() {
    return "Number of predicates Instances";
  }

}
