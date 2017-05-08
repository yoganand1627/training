package gov.georgia.dhr.dfcs.sacwis.structs.input;

import java.io.Serializable;
import java.util.Date;

/** @todo add javadocs for methods */

/**
 * ProtectiveServiceAlertDB value bean that contains the details of a Protective Service Alert.
 *
 * @author Lokhande, Lata, Sept 11, 2006
 */
public class ProtectiveServiceAlertDB implements Serializable {
  protected String ArchInputStruct = null;
  protected String szIdEmployeeLogon = null;

  protected String ulNmPersonFirst = null;
  protected String ulNmPersonLast = null;
  protected String ulIndPersonDOBApprox = null;
  protected String ulNbrPersonIdNumber = null; //SSN
  protected String ulCdPersonEthnicGroup = null;
  protected String ulCdPersonSex = null;

  protected String ulStage = null;
  protected Date dtTime = null;
  protected Date dtDtPSADate = null;
  protected String ulPSACaseManager = null;
  protected Date dtDtPSAAbsconded = null;
  protected String idCdPSAResonAlert = null;

  protected String idTxtPSAComment = null;

  public String getNmPersonFirst() {
    return ulNmPersonFirst;
  }

  public void setulNmPersonFirst(String ulNmPersonFirst) {
    this.ulNmPersonFirst = ulNmPersonFirst;
  }

  public String getulNmPersonLast() {
    return ulNmPersonLast;
  }

  public void setulNmPersonLast(String ulNmPersonLast) {
    this.ulNmPersonLast = ulNmPersonLast;
  }

  public String ulIndPersonDOBApprox() {
    return ulIndPersonDOBApprox;
  }

  public void setulIndPersonDOBApprox(String ulIndPersonDOBApprox) {
    this.ulIndPersonDOBApprox = ulIndPersonDOBApprox;
  }

  public String getulNbrPersonIdNumber() {
    return ulNbrPersonIdNumber;
  }

  public void setulNbrPersonIdNumber(String ulNbrPersonIdNumber) {
    this.ulNbrPersonIdNumber = ulNbrPersonIdNumber;
  }

  public String getulCdPersonEthnicGroup() {
    return ulCdPersonEthnicGroup;
  }

  public void setulCdPersonEthnicGroup(String ulCdPersonEthnicGroup) {
    this.ulCdPersonEthnicGroup = ulCdPersonEthnicGroup;
  }

  public String getulCdPersonSex() {
    return ulCdPersonSex;
  }

  public void setulCdPersonSex(String ulCdPersonSex) {
    this.ulCdPersonSex = ulCdPersonSex;
  }

  public String getulStage() {
    return ulStage;
  }

  public void setulStage(String ulStage) {
    this.ulStage = ulStage;
  }

  public Date getdtTime() {
    return dtTime;
  }

  public void setdtTime(Date dtTime) {
    this.dtTime = dtTime;
  }

  public Date getdtDtPSADate() {
    return dtDtPSADate;
  }

  public void setdtDtPSADate(Date dtDtPSADate) {
    this.dtDtPSADate = dtDtPSADate;
  }

  public String getulPSACaseManager() {
    return ulPSACaseManager;
  }

  public void setulPSACaseManager(String ulPSACaseManager) {
    this.ulPSACaseManager = ulPSACaseManager;
  }

  public Date getdtDtPSAAbsconded() {
    return dtDtPSAAbsconded;
  }

  public void setdtDtPSAAbsconded(Date dtDtPSAAbsconded) {
    this.dtDtPSAAbsconded = dtDtPSAAbsconded;
  }

  public String getidCdPSAResonAlert() {
    return idCdPSAResonAlert;
  }

  public void setidCdPSAResonAlert(String idCdPSAResonAlert) {
    this.idCdPSAResonAlert = idCdPSAResonAlert;
  }

  public String getidTxtPSAComment() {
    return idTxtPSAComment;
  }

  public void setidTxtPSAComment(String idTxtPSAComment) {
    this.idTxtPSAComment = idTxtPSAComment;
  }

}