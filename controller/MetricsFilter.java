package controller;

import java.util.List;
/**
 * this class is used to help us manage when to change our view and which metrics to present
 * according to user choice 
 *
 */
public class MetricsFilter {

  private boolean filtered = false;

  public boolean getFiltered() {
    return filtered;
  }

  public void setFiltered(boolean filtered) {
    this.filtered = filtered;
  }

  public List<String> getListOfFileLevelMetrics() {
    return listOfFileLevelMetrics;
  }

  public void setListOfFileLevelMetrics(List<String> listOfFileLevelMetrics) {
    this.listOfFileLevelMetrics = listOfFileLevelMetrics;
  }

  public List<String> getListOfAsmGarLevelMetrics() {
    return listOfAsmGarLevelMetrics;
  }

  public void setListOfAsmGarLevelMetrics(List<String> listOfAsmGarLevelMetrics) {
    this.listOfAsmGarLevelMetrics = listOfAsmGarLevelMetrics;
  }

  private List<String> listOfFileLevelMetrics = InstanceCreator.getClassesNamesFileLevel();

  private List<String> listOfAsmGarLevelMetrics = InstanceCreator.getClassesNamesAsmGarLevel();

}
