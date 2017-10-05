package model;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;

/**
 * helper functions for our resource management
 *
 */
public class ResourceHelper {

//  public static void getSpectraFiles(File dir, List<XtextResource> resources) {
//    if (dir == null) {
//      return;
//    }
//    if (dir.isDirectory()) {
//      File[] files = dir.listFiles();
//      for (File file : files) {
//        getSpectraFiles(file, resources);
//      }
//    } else {
//      String filename = dir.getName();
//      String extension = filename.substring(filename.lastIndexOf(".") + 1, filename.length());
//      if ("spectra".equals(extension)) {
//        System.out.format(" filename : %s \n", filename);
//        resources.add(convertFileToXtextResource(dir));
//      }
//    }
//
//  }

  /**
   * convert file to XtextResource
   * 
   * @param file
   */
  public static XtextResource convertFileToXtextResource(File file) {
    if (file == null) {
      return null;
    }
    IFile ifile = convertFiletoIfile(file);
    if (ifile == null) {
      return null;
    }
    return convertIFileToXtextResource(ifile);
  }

  /**
   * convert file to IFile
   * 
   * @param file
   */
  public static IFile convertFiletoIfile(File file) {
    IWorkspace workspace = ResourcesPlugin.getWorkspace();
    IPath location = Path.fromOSString(file.getAbsolutePath());
    IFile ifile = workspace.getRoot().getFileForLocation(location);
    return ifile;
  }
  /**
   * 
   * convert spectra file to XtextResource
   * @param file
   */
  public static XtextResource convertIFileToXtextResource(IFile file) {
    if ("spectra".equals(file.getFileExtension())) {
      IProject project = file.getProject();
      URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
      ResourceSet rs = IResourceServiceProvider.Registry.INSTANCE.getResourceServiceProvider(uri)
          .get(IResourceSetProvider.class).get(project);
      Resource r = rs.getResource(uri, true);
      try {
        r.load(null);
      } catch (IOException e) {
        e.printStackTrace();
      }
      if (r instanceof XtextResource) {
        return (XtextResource) r;
      }
    }
    return null;
  }

}
