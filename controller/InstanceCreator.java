package controller;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import metrics.GloballyAsm;
import metrics.GloballyFinallyAsm;
import metrics.GloballyFinallyGar;
import metrics.GloballyGar;
import metrics.InitialAsm;
import metrics.InitialGar;
import metrics.Metric;
import metrics.NumberOfAUXVariables;
import metrics.NumberOfDefinesMetric;
import metrics.NumberOfENVVariables;
import metrics.NumberOfSYSVariables;
import metrics.NumberOfSysVar;
import metrics.NumberOfVariables;
import metrics.ObjectDeepestNestingOfExpression;
import metrics.ObjectDeepestNestingOfPastLTL;
import metrics.ObjectNumberOfAuxVariables;
import metrics.ObjectNumberOfDefines;
import metrics.ObjectNumberOfEnvVariables;
import metrics.ObjectNumberOfLines;
import metrics.ObjectNumberOfLinesWithoutComment;
import metrics.ObjectNumberOfPatternsInstances;
import metrics.ObjectNumberOfPredicatesInstances;
import model.Pair;
/**
 * This class is used to manage metrics instances
 * here you can add new metric :
 * if you want to add a new File level metric,just add it to fileLevelclasses
 *
 */
public class InstanceCreator {
  

  public static List<Pair<String,String>> fileLevelMetricsclasses = 
      Arrays.asList(new Pair<String,String>(NumberOfDefinesMetric.class.getName(),"Number Of Defines"),
      new Pair<String,String>(NumberOfVariables.class.getName(),"Number Of Variables"),
      new Pair<String,String>(InitialAsm.class.getName(),"Initial Assumptions"), 
      new Pair<String,String>(GloballyAsm.class.getName(),"Globally Assumptions"), 
      new Pair<String,String>(GloballyFinallyAsm.class.getName(),"Globally Finally Assumptions"),
      new Pair<String,String>(GloballyGar.class.getName(),"Globally Guarantees"),
      new Pair<String,String>(GloballyFinallyGar.class.getName(),"Globally Finally Guarantees"),
      new Pair<String,String>(InitialGar.class.getName(),"Initial Guarantees"),
      new Pair<String,String>(NumberOfENVVariables.class.getName(),"Number of Env Variables"),
      new Pair<String,String>(NumberOfAUXVariables.class.getName(),"Number of Aux Variables"),
      new Pair<String,String>(NumberOfSYSVariables.class.getName(),"Number of Sys Variables"));

  public static List<Pair<String,String>> asmGarLevelMetricsClasses = 
      Arrays.asList(new Pair<String,String>(ObjectNumberOfLines.class.getName(),"Asm/Gar Number of Lines"),
      new Pair<String,String>(ObjectDeepestNestingOfExpression.class.getName(),"Asm/Gar Deepest Nesting of expression"), 
      new Pair<String,String>(ObjectDeepestNestingOfPastLTL.class.getName(),"Asm/Gar Deepest Nesting of PastLTL"),
      new Pair<String,String>(ObjectNumberOfAuxVariables.class.getName(),"Asm/Gar Number of aux Variables"), 
      new Pair<String,String>(ObjectNumberOfDefines.class.getName(),"Asm/Gar Number of Defines"),
      new Pair<String,String>(ObjectNumberOfPredicatesInstances.class.getName(),"Asm/Gar Number of Predicates Instances"), 
      new Pair<String,String>(ObjectNumberOfPatternsInstances.class.getName(),"Asm/Gar Number of Patterns Instances"),
      new Pair<String,String>(ObjectNumberOfLinesWithoutComment.class.getName(),"Asm/Gar Number of Lines without comments"),
      new Pair<String,String>(ObjectNumberOfEnvVariables.class.getName(),"Asm/Gar Number of env Variables"), 
      new Pair<String,String>(NumberOfSysVar.class.getName(),"Asm/Gar Number of sus Variables"));
  
  public static List<Pair<String,String>> getListOfAllMetrics() {
    List<Pair<String,String>> allMetrics = new ArrayList<>();
    allMetrics.addAll(fileLevelMetricsclasses);
    allMetrics.addAll(asmGarLevelMetricsClasses);
    return allMetrics;
  }
  public static List<Pair<String,String>> getListOfFileLevel() {
    return fileLevelMetricsclasses;
  }
  
  public static List<String> getClassesNamesFileLevel() {
    return fileLevelMetricsclasses.stream().map(Pair::getLeft).collect(Collectors.toList());
  }
  public static List<String> getClassesNamesAsmGarLevel() {
    return asmGarLevelMetricsClasses.stream().map(Pair::getLeft).collect(Collectors.toList());
  }

  public static List<Pair<String,String>> getListOfAsmGarLevel() {
    return asmGarLevelMetricsClasses;
  }
  /**
   * creating newInstance of Metric using Java reflection
   * @param name - the name of the class we want to create new Instance of
   * @param resource - the resource to be passed to the ctor of the new Instance
   * @param arguments - type of the arguments to the constructor of the new Instance
   * @return
   */
  public static Metric createNewInstance(String name, Object resource, Class<?>... arguments) {
    try {
      Object o = null;
      Class<?> cl = Class.forName(name);
      Constructor<?> ctor = cl.getConstructor(arguments);
      o = ctor.newInstance(resource);
      if (o instanceof Metric) {
        Metric metric = (Metric) o;
        return metric;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }
  /**
   * 
   * 
   * @param names - list of the metrics classes names 
   * @param resources - list of all resources  
   * @param arguments - names of the classes to be passed as argument to ctor.
   * @return list of Metrics - each metric for all element in the Cartesian product of <Metric,XtextResource> from the list
   * 
   */
  public static List<Metric> createMetricListfromMetricNames(List<String> names, List<?> resources,
      Class<?>... arguments) {
    List<Metric> lst = new ArrayList<Metric>();
    for (Object resource : resources) {
      for (String name : names) {
        Metric metric = createNewInstance(name, resource, arguments);
        if (metric != null) {
          lst.add(metric);
        }
      }
    }
    return lst;
  }

}
