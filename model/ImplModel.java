package model;

import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
/**
 * this Implementation is used for our needs-always define activePage as our resource
 *
 */
public class ImplModel implements IModel {

  private ResourceHandler resource;

  /**
   * the default is setting the active page as our resource
   */
  public ImplModel() {
    setActivePageResource();
  }
  @Override
  public ResourceHandler getResource() {
    return resource;
  }

  /**
   * if resource == null the active page will be updated
   */
  @Override
  public void UpdateResource(ResourceHandler resource) {
    if (resource == null)
      setActivePageResource();
    else
      this.resource = resource;
  }
  /**
   * setting the active page at the current resource
   */
  private void setActivePageResource() {
    IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
    IEditorPart activeEditor = page.getActiveEditor();
    if (activeEditor instanceof XtextEditor) {
      XtextEditor xtextEditor = (XtextEditor) activeEditor;
      xtextEditor.getDocument().readOnly((XtextResource resource) -> {
        this.resource = new ResourceHandler(resource);
        return null;
      });
    }
  }

}
