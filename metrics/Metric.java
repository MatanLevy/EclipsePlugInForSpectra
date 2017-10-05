package metrics;
/**
 * the basic Interface. each Metric should implement this interface
 *
 */
public interface Metric {
  /**
   * 
   * @return value of the metric
   */
  public Integer getValue();
  /**
   * 
   * @return name of the mertic
   */
  public String getName();
}
