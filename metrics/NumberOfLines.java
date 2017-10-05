package metrics;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.eclipse.xtext.resource.XtextResource;

public class NumberOfLines extends AbstractMetricFileLevel {

  public NumberOfLines(XtextResource xtext) {
    super(xtext);
  }

  @Override
  public Integer getValue() {
    Integer lineCount = -1;
    String path1 = resource.getResource().getURI().path();
    path1 = path1.substring("/resource".length() + 1);
    File file = new File(path1);
    String fullpath = file.getAbsolutePath();
    Path path = Paths.get(fullpath);
//    try {
//      lineCount = (int) Files.lines(path).count();
//    } catch (IOException e) {
//      e.printStackTrace();
//    }
    return lineCount;
  }

  @Override
  public String getName() {
    return "Number of lines";
  }

}
