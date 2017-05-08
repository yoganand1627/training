package gov.georgia.dhr.dfcs.sacwis.dao.document.cfp;

import java.io.Serializable;

/** Value Object for defining how reports/forms are generated for a given outputCode */
public class DocumentGenerationMetaDataDB implements Serializable {
  public static final String FOR_EACH_STAGE = "foreach stage";
  public static final String FOR_EACH_STAGE_EVENT = "foreach stage, event";
  public static final String FOR_EACH_EVENT = "foreach event";
  public static final String FOR_EACH_PERSON = "foreach person";
  public static final String FOR_EACH_CRIMINAL_HISTORY = "foreach criminalHistory";
  protected String outputCode = null;
  protected String outputName = null;
  protected String docType = null;
  protected String generateMethod = null;
  protected String forEach = null;

  public String getOutputCode() {
    return outputCode;
  }

  public void setOutputCode(String outputCode) {
    this.outputCode = outputCode;
  }

  public String getOutputName() {
    return outputName;
  }

  public void setOutputName(String outputName) {
    this.outputName = outputName;
  }

  public String getDocType() {
    return docType;
  }

  public void setDocType(String docType) {
    this.docType = docType;
  }

  public String getGenerateMethod() {
    return generateMethod;
  }

  public void setGenerateMethod(String generateMethod) {
    this.generateMethod = generateMethod;
  }

  public String getForEach() {
    return forEach;
  }

  public void setForEach(String forEach) {
    this.forEach = forEach;
  }

  public boolean isForEachNull() {
    return (forEach == null);
  }

  public boolean isForEachStage() {
    return (forEach != null && forEach.equals(FOR_EACH_STAGE));
  }

  public boolean isForEachStageEvent() {
    return (forEach != null && forEach.equals(FOR_EACH_STAGE_EVENT));
  }

  public boolean isForEachEvent() {
    return (forEach != null && forEach.equals(FOR_EACH_EVENT));
  }

  public boolean isForEachPerson() {
    return (forEach != null && forEach.equals(FOR_EACH_PERSON));
  }

  public boolean isForEachCriminalHistory() {
    return (forEach != null && forEach.equals(FOR_EACH_CRIMINAL_HISTORY));
  }
}


