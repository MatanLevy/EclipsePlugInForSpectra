package treemetric2;

import tau.smlab.syntech.spectraapi.ObjectInfo;

public class ObjectDeepestNestingOfPastLTL extends ObjectInfoMetric {

  public ObjectDeepestNestingOfPastLTL(ObjectInfo objectInfo) {
    super(objectInfo);
  }

  @Override
  public Integer getValue() {
    return getObjectInfo().getDeepestNestingOfPastLTLOperators();
  }

  @Override
  public String getName() {
    return "Deepest Nesting of past LTL";
  }

}
