package metrics;

import tau.smlab.syntech.spectraapi.ObjectInfo;

public class ObjectNumberOfLinesWithoutComment extends ObjectInfoMetric {

  public ObjectNumberOfLinesWithoutComment(ObjectInfo objectInfo) {
    super(objectInfo);
  }

  @Override
  public Integer getValue() {
    return getObjectInfo().getTotalNumberOfLinesWithoutComments();
  }

  @Override
  public String getName() {
    return "Number of lines without comment";
  }

}
