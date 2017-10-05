package model;
/**
 * IMode repersent the data for the metrics.
 * each class should Implement two basic functions :
 * getResource -> to return the current resource
 * UpdateResource -> to update the current resource
 *
 */
public interface IModel {
  
  ResourceHandler getResource();
  
  
  /**
   * if resource == null -> active page will be updated
   * @param resource
   */
  public void UpdateResource(ResourceHandler resource);
}
