package controller;

import java.util.List;
/**
 * 
 * this Interface is used to control the number of metrics to be shown in each level and 
 * to decided when we can change the data to present.
 *
 */
public interface Icontroller {
  
  List<String> getFileLevelMetrics();
  
  List<String> getAsmGarLevelMetrics();
  
  void setFileLevelMetrics(List<String> fileLevel);
  
  void setAsmGarLevelMetrics(List<String> asmgarLevel);
  
  boolean isChangableData();
  
  void SetChangbleData(boolean flag);
}
