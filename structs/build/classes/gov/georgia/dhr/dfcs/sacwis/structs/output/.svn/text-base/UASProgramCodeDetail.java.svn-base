/**
 * Name: UASPrgCodeDetail
 * Description : This class contains UAS program code information retrieved from DB to display on UAS Program Code Maintenance 
 * for the Program Code Maintenance section.
 * <p/>
 * <p/>
 * 
 * <pre>
 *  Change History:
 *  Date      User      Description
 *  --------  --------  --------------------------------------------------
 *  09/02/11  htvo      STGAP00017019: ECEM 5.0: UAS Program Code Maintenance - new page development
 * 
 * </pre>
 * 
 */

package gov.georgia.dhr.dfcs.sacwis.structs.output;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UASProgramCodeDetail implements Serializable {

  // variables for direct data access
  private Date dtLastUpdatedBy;

  private Date dtProgramEffective;

  private int idUasPrgCode;

  private int idPersonLastUpdate;
  
  private String nmPersonLastUpdate;

  private String cdProgramCode;
  
  private String txtProgramDesc;
  
  // variables for indirect data access
  private String cdProgramType;

  private String indServiceAuth;

  private String indCCI;

  private String indCPA;

  private String indPSSF;

  private String indInvAddOn;
  
  // variables for page function
  private int recordIndex;

  private List<UASEntitlementCodeDetail> entCodeList;

  public Date getDtLastUpdatedBy() {
    return dtLastUpdatedBy;
  }

  public void setDtLastUpdatedBy(Date dtLastUpdatedBy) {
    this.dtLastUpdatedBy = dtLastUpdatedBy;
  }

  public Date getDtProgramEffective() {
    return dtProgramEffective;
  }

  public void setDtProgramEffective(Date dtProgramEffective) {
    this.dtProgramEffective = dtProgramEffective;
  }

  public int getIdUasPrgCode() {
    return idUasPrgCode;
  }

  public void setIdUasPrgCode(int idUasPrgCodeMtnt) {
    this.idUasPrgCode = idUasPrgCodeMtnt;
  }

  public int getIdPersonLastUpdate() {
    return idPersonLastUpdate;
  }

  public void setIdPersonLastUpdate(int idPersonLastUpdate) {
    this.idPersonLastUpdate = idPersonLastUpdate;
  }

  public String getCdProgramCode() {
    return cdProgramCode;
  }

  public void setCdProgramCode(String cdProgramCode) {
    this.cdProgramCode = cdProgramCode;
  }

  public String getCdProgramType() {
    return cdProgramType;
  }

  public void setCdProgramType(String cdProgramType) {
    this.cdProgramType = cdProgramType;
  }

  public String getIndServiceAuth() {
    return indServiceAuth;
  }

  public void setIndServiceAuth(String indServiceAuth) {
    this.indServiceAuth = indServiceAuth;
  }

  public String getIndCCI() {
    return indCCI;
  }

  public void setIndCCI(String indCCI) {
    this.indCCI = indCCI;
  }

  public String getIndCPA() {
    return indCPA;
  }

  public void setIndCPA(String indCPA) {
    this.indCPA = indCPA;
  }

  public String getIndPSSF() {
    return indPSSF;
  }

  public void setIndPSSF(String indPSSF) {
    this.indPSSF = indPSSF;
  }

  public String getTxtProgramDesc() {
    return txtProgramDesc;
  }

  public void setTxtProgramDesc(String txtProgramDesc) {
    this.txtProgramDesc = txtProgramDesc;
  }

  public List<UASEntitlementCodeDetail> getEntCodeList() {
    return entCodeList;
  }

  public void setEntCodeList(List<UASEntitlementCodeDetail> entCodeList) {
    this.entCodeList = entCodeList;
  }

  public int getRecordIndex() {
    return recordIndex;
  }

  public void setRecordIndex(int recordIndex) {
    this.recordIndex = recordIndex;
  }

  public String getNmPersonLastUpdate() {
    return nmPersonLastUpdate;
  }

  public void setNmPersonLastUpdate(String nmPersonLastUpdate) {
    this.nmPersonLastUpdate = nmPersonLastUpdate;
  }

  public void setIndInvAddOn(String indInvAddOn) {
    this.indInvAddOn = indInvAddOn;
  }

  public String getIndInvAddOn() {
    return indInvAddOn;
  }
  
  public UASProgramCodeDetail() {
    super();
  }
  public UASProgramCodeDetail(UASProgramCodeDetail programCodeDetail, String copyMode)
  {
    setDtLastUpdatedBy(programCodeDetail.getDtLastUpdatedBy());
    setDtProgramEffective(programCodeDetail.getDtProgramEffective());
    setIdUasPrgCode(programCodeDetail.getIdUasPrgCode());
    setIdPersonLastUpdate(programCodeDetail.getIdPersonLastUpdate());
    setCdProgramCode(programCodeDetail.getCdProgramCode());
    setCdProgramType(programCodeDetail.getCdProgramType());
    setIndServiceAuth(programCodeDetail.getIndServiceAuth());
    setIndCCI(programCodeDetail.getIndCCI());
    setIndCPA(programCodeDetail.getIndCPA());
    setIndPSSF(programCodeDetail.getIndPSSF());
    setTxtProgramDesc(programCodeDetail.getTxtProgramDesc());
    setRecordIndex(programCodeDetail.getRecordIndex());
    setNmPersonLastUpdate(programCodeDetail.getNmPersonLastUpdate());
    setIndInvAddOn(programCodeDetail.getIndInvAddOn());
    List<UASEntitlementCodeDetail> entCodeList = new ArrayList<UASEntitlementCodeDetail>();
    if ("FULL".equals(copyMode)) {
      List<UASEntitlementCodeDetail> aEntList = programCodeDetail.getEntCodeList();
      if (aEntList != null) {
        for (UASEntitlementCodeDetail aEnt : aEntList) {
          UASEntitlementCodeDetail theEnt = new UASEntitlementCodeDetail(aEnt);
          entCodeList.add(theEnt);
        }
      }
    }
    setEntCodeList(entCodeList);
  }
}
