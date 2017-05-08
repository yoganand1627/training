/**
 * Created on Aug 4, 2006 at 10:39:08 AM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.core.ant;

import java.io.File;

import org.apache.tools.ant.taskdefs.JDBCTask;
import org.apache.tools.ant.BuildException;

public abstract class GenerateCodeTask extends JDBCTask {
  private File srcDir = null;
  private String simpleClassName = null;
  private String packageName = null;

  public void setClassname(String classname) {
    int lastDotIndex = classname.lastIndexOf(".");
    this.simpleClassName = classname.substring(lastDotIndex + 1);
    this.packageName = classname.substring(0, lastDotIndex);
  }

  public void setSrcDir(File srcDir) {
    if(!srcDir.isDirectory()) {
      throw new BuildException("The source directory specified in srcDir does not exist or is not a directory."); 
    }
    this.srcDir = srcDir;
  }

  public File getSrcDir() {
    return srcDir;
  }

  public String getSimpleClassName() {
    return simpleClassName;
  }

  public String getPackageName() {
    return packageName;
  }

  public File getPackageDir() {
    return new File(srcDir, packageName.replace('.', File.separatorChar));
  }

  public void execute() throws BuildException {
    generate();
  }

  protected abstract void generate();
}
