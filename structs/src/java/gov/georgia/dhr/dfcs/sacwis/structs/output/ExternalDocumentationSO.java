package gov.georgia.dhr.dfcs.sacwis.structs.output;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ExternalDocumentationSO implements Serializable{
  
  byte[] fileData;

  String isUCMFile;

  String fileName;

  String fileFormat;

  public byte[] getFileData() {
    return fileData;
  }

  public void setFileData(byte[] fileData) {
    this.fileData = fileData;
  }

  public String getIsUCMFile() {
	return isUCMFile;
  }

  public void setIsUCMFile(String isUCMFile) {
	this.isUCMFile = isUCMFile;
  }

  public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  public String getFileFormat() {
    return fileFormat;
  }

  public void setFileFormat(String fileFormat) {
    this.fileFormat = fileFormat;
  }
}
