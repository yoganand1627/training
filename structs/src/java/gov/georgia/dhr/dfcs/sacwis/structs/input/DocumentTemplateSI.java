package gov.georgia.dhr.dfcs.sacwis.structs.input;

import java.io.Serializable;

public class DocumentTemplateSI implements Serializable {
  
private String document = null;
  
  private int major;
  
  private int minor;
  
  private int revision;

  public String getDocument() {
    return document;
  }

  public void setDocument(String document) {
    this.document = document;
  }

  public int getMajor() {
    return major;
  }

  public void setMajor(int major) {
    this.major = major;
  }

  public int getMinor() {
    return minor;
  }

  public void setMinor(int minor) {
    this.minor = minor;
  }

  public int getRevision() {
    return revision;
  }

  public void setRevision(int revision) {
    this.revision = revision;
  }
}
