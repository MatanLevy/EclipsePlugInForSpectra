package treemetric2;

import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;

import tau.smlab.syntech.spectraapi.APIMetrics;

public class ResourceHandler {
  
  private static XtextResource resource;
  private static APIMetrics apimetric;
  
  public static XtextResource getResource() {
    return resource;
  }
  
  public static APIMetrics getAPIMetric() {
    return apimetric;
  }
  public ResourceHandler() {
    init();
  }
  
  private static void setResource()
  {
    IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
    IEditorPart activeEditor = page.getActiveEditor();
    if (activeEditor instanceof XtextEditor) {
        XtextEditor xtextEditor = (XtextEditor) activeEditor;
        xtextEditor.getDocument().readOnly((XtextResource resource) -> {    
         ResourceHandler.resource = resource;
         return null;
          });
      }
  }
  
  private static void setMetric() {
    apimetric = new APIMetrics(resource);
  }
  
  public static void init() {
    setResource();
//    apimetric.setResource(resource);
    setMetric();
  }

}
