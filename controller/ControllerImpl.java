package controller;

import java.util.List;
/**
 * Implemention of controller interface based on MetricsFilter class
 * @author Emi
 *
 */
public class ControllerImpl implements Icontroller{

  private MetricsFilter filter = new MetricsFilter();
  
  public void setFileLevelMetrics(List<String> fileLevel) {
    filter.setListOfFileLevelMetrics(fileLevel);
  }
  @Override
  public List<String> getFileLevelMetrics() {
   return filter.getListOfFileLevelMetrics();
  }

  @Override
  public List<String> getAsmGarLevelMetrics() {
    return filter.getListOfAsmGarLevelMetrics();
  }
  @Override
  public void setAsmGarLevelMetrics(List<String> listOfAsmGarLevelMetrics) {
    filter.setListOfAsmGarLevelMetrics(listOfAsmGarLevelMetrics);
    
  }
  @Override
  public void SetChangbleData(boolean flag) {
    filter.setFiltered(flag);
    
  }
  @Override
  public boolean isChangableData() {
    return filter.getFiltered();
  }
  
}
