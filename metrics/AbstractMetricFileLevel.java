package metrics;

import org.eclipse.xtext.resource.XtextResource;

import model.ResourceHandler;

/**
 * 
 * Abstract class for all metrics each metric should has a ResourceHandler
 * inside to get data about XtextResource and use APIMetric to get data from
 *
 */
public abstract class AbstractMetricFileLevel implements Metric {

  protected ResourceHandler resource;

  public AbstractMetricFileLevel(XtextResource xtext) {
    resource = new ResourceHandler(xtext);
  }
}
