package treemetric2;

import tau.smlab.syntech.spectraapi.ObjectInfo;

public class ObjectDeepestNestingOfExpression extends ObjectInfoMetric {

  public ObjectDeepestNestingOfExpression(ObjectInfo objectInfo) {
    super(objectInfo);
  }

  @Override
  public Integer getValue() {
    return getObjectInfo().getDeepestNestingOfExpressions();
  }

  @Override
  public String getName() {
    return "Deepest nesting of expression";
  }

}
