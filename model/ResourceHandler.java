package model;

import org.eclipse.xtext.resource.XtextResource;

import tau.smlab.syntech.spectraapi.APIMetrics;
/**
 * this class represent our resource for metrics plugin.
 * it has XtextResource necessary for build new metrics.and the APIMetrics to calculate
 * the value of each metric 
 *
 */
public class ResourceHandler {
  private  XtextResource resource;
  private   APIMetrics apimetric;
  
  public  XtextResource getResource() {
    return this.resource;
  }  
  public APIMetrics getAPIMetric() {
    return apimetric;
  }
  public ResourceHandler(XtextResource resource) {
    init(resource);
  }
  
  public  void setResource(XtextResource resource)
  {   
         this.resource = resource;

  }
  
  private  void setMetric() {
    apimetric = new APIMetrics(resource);
  }
  
  public  void init(XtextResource resource) {
    setResource(resource);
    setMetric();
  }

}
