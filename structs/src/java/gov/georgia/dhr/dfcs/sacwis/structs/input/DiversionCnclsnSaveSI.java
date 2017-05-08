package gov.georgia.dhr.dfcs.sacwis.structs.input;

import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN45DO;

import java.io.Serializable;
import java.util.Date;

public class DiversionCnclsnSaveSI implements Serializable {

  /**
   * <p>fields used in the save process</p>
   */
  private int idDiversionCnclsn;
  private Date dtLastUpdate; 
  private int idStage;
  private int idCase;
  private Date dtResponse;
  private Date dtDiversionTaskCompleted;
  private String szCdDisposition;
  private ArchInputStruct archInputStruct;
  private ROWCCMN45DO rowccmn45do;
  
  public ROWCCMN45DO getROWCCMN45DO() {
    return rowccmn45do;
  }
  public void setROWCCMN45DO(ROWCCMN45DO rowccmn45do) {
    this.rowccmn45do = rowccmn45do;
  }
  public ArchInputStruct getArchInputStruct() {
    return archInputStruct;
  }
  public void setArchInputStruct(ArchInputStruct archInputStruct) {
    this.archInputStruct = archInputStruct;
  }
  public Date getDtResponse() {
    return dtResponse;
  }
  public void setDtResponse(Date dtResponse) {
    this.dtResponse = dtResponse;
  }
  public Date getDtDiversionTaskCompleted() {
    return dtDiversionTaskCompleted;
  }
  public void setDtDiversionTaskCompleted(Date dtDiversionTaksCompleted) {
    this.dtDiversionTaskCompleted = dtDiversionTaksCompleted;
  }
  public Date getDtLastUpdate() {
    return dtLastUpdate;
  }
  public void setDtLastUpdate(Date dtLastUpdate) {
    this.dtLastUpdate = dtLastUpdate;
  }
  public int getIdDiversionCnclsn() {
    return idDiversionCnclsn;
  }
  public void setIdDiversionCnclsn(int idDiversionCnclsn) {
    this.idDiversionCnclsn = idDiversionCnclsn;
  }
  public int getIdStage() {
    return idStage;
  }
  public void setIdStage(int idStage) {
    this.idStage = idStage;
  }
  public int getIdCase() {
    return idCase;
  }
  public void setIdCase(int idCase) {
    this.idCase = idCase;
  }
  public String getSzCdDisposition() {
    return szCdDisposition;
  }
  public void setSzCdDisposition(String szCdDisposition) {
    this.szCdDisposition = szCdDisposition;
  }

}
