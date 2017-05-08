package gov.georgia.dhr.dfcs.sacwis.structs.output;

import java.io.Serializable;

import java.util.Date;

public class RetrieveReportParametersSO implements Serializable {

  private int idRptParameter;

  private Date dtLastUpdate;

  private int nbrRptParmSeq;

  private Integer nbrRptParmLength;

  private String nmRptParmName;
  
  private String txtRptParmType;
  
  private String indRequired;
  
  private String nmRptParmLabel;

  public int getIdRptParameter() {
    return idRptParameter;
  }

  public void setIdRptParameter(int idRptParameter) {
    this.idRptParameter = idRptParameter;
  }

  public Date getDtLastUpdate() {
    return this.dtLastUpdate;
  }

  public void setDtLastUpdate(Date dt) {
    this.dtLastUpdate = dt;
  }

  public int getNbrRptParmSeq() {
    return this.nbrRptParmSeq;
  }

  public void setNbrRptParmSeq(int nbrRptParmSeq) {
    this.nbrRptParmSeq = nbrRptParmSeq;
  }
  
  public Integer getNbrRptParmLength() {
    return this.nbrRptParmLength;
  }

  public void setNbrRptParmLength(Integer nbrRptParmLength) {
    this.nbrRptParmLength = nbrRptParmLength;
  }

  public String getNmRptParmName() {
    return this.nmRptParmName;
  }

  public void setNmRptParmName(String nmRptParmName) {
    this.nmRptParmName = nmRptParmName;
  }
 
  public String getTxtRptParmType() {
    return this.txtRptParmType;
  }  

  public void setTxtRptParmType(String txtRptParmType) {
    this.txtRptParmType = txtRptParmType;
  }
  
  public String getIndRequired() {
    return this.indRequired;
  }  

  public void setIndRequired(String indRequired) {
    this.indRequired = indRequired;
  }
  
  public String getNmRptParmLabel() {
      return this.nmRptParmLabel;
  }  

  public void setNmRptParmLabel(String nmRptParmLabel) {
	 this.nmRptParmLabel = nmRptParmLabel;
  }
}
