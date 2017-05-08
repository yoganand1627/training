/**
 * This class contains an Entitlement code's information for a program code to display on UAS Program Code Maintenance 
 * for the Entitlement Codes section.
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
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class UASEntitlementCodeDetail implements Serializable {
  private String cdReqFunc;

  private Date dtEntEff;

  private Date dtLastUpdate;

  private double amtCBL; // Case Budget Limit

  private double amtLIL; // Line Item Limit

  private double amtRate;

  private int idEntRow;
  
  private int idEquiv;

  private String cdEntCode;

  private String cdPymtType;

  private String cdSvcCode;

  private String cdUnitType;

  private String indMileage;

  private String indHeader;

  private String txtEntDesc;

  private String txtEntAlpha;
  
  private Map<String, String> cdFuncProgs;

  public String getCdReqFunc() {
    return cdReqFunc;
  }

  public void setCdReqFunc(String cdReqFunc) {
    this.cdReqFunc = cdReqFunc;
  }

  public Date getDtEntEff() {
    return dtEntEff;
  }

  public void setDtEntEff(Date dtEntEff) {
    this.dtEntEff = dtEntEff;
  }

  public Date getDtLastUpdate() {
    return dtLastUpdate;
  }

  public void setDtLastUpdate(Date dtLastUpdate) {
    this.dtLastUpdate = dtLastUpdate;
  }

  public double getAmtCBL() {
    return amtCBL;
  }

  public void setAmtCBL(double amtCBL) {
    this.amtCBL = amtCBL;
  }

  public double getAmtLIL() {
    return amtLIL;
  }

  public void setAmtLIL(double amtLIL) {
    this.amtLIL = amtLIL;
  }

  public double getAmtRate() {
    return amtRate;
  }

  public void setAmtRate(double amtRate) {
    this.amtRate = amtRate;
  }

  public int getIdEntRow() {
    return idEntRow;
  }

  public void setIdEntRow(int idEntRow) {
    this.idEntRow = idEntRow;
  }

  public int getIdEquiv() {
    return idEquiv;
  }

  public void setIdEquiv(int idEquiv) {
    this.idEquiv = idEquiv;
  }

  public String getTxtEntAlpha() {
    return txtEntAlpha;
  }

  public void setTxtEntAlpha(String txtEntAlpha) {
    this.txtEntAlpha = txtEntAlpha;
  }

  public String getCdEntCode() {
    return cdEntCode;
  }

  public void setCdEntCode(String cdEntCode) {
    this.cdEntCode = cdEntCode;
  }

  public String getCdPymtType() {
    return cdPymtType;
  }

  public void setCdPymtType(String cdPymtType) {
    this.cdPymtType = cdPymtType;
  }

  public String getCdSvcCode() {
    return cdSvcCode;
  }

  public void setCdSvcCode(String cdSvcCode) {
    this.cdSvcCode = cdSvcCode;
  }

  public String getCdUnitType() {
    return cdUnitType;
  }

  public void setCdUnitType(String cdUnitType) {
    this.cdUnitType = cdUnitType;
  }

  public String getIndMileage() {
    return indMileage;
  }

  public void setIndMileage(String indMileage) {
    this.indMileage = indMileage;
  }

  public String getIndHeader() {
    return indHeader;
  }

  public void setIndHeader(String indHeader) {
    this.indHeader = indHeader;
  }

  public String getTxtEntDesc() {
    return txtEntDesc;
  }

  public void setTxtEntDesc(String txtEntDesc) {
    this.txtEntDesc = txtEntDesc;
  }

  public Map<String, String> getCdFuncProgs() {
    return cdFuncProgs;
  }

  public void setCdFuncProgs(Map<String, String> cdFuncProgs) {
    this.cdFuncProgs = cdFuncProgs;
  }
  
  public UASEntitlementCodeDetail() {
    super();
  }
  
  public UASEntitlementCodeDetail(UASEntitlementCodeDetail aEntCodeDetail) {
    this.setAmtCBL(aEntCodeDetail.getAmtCBL());
    this.setAmtLIL(aEntCodeDetail.getAmtLIL());
    this.setAmtRate(aEntCodeDetail.getAmtRate());
    this.setCdEntCode(aEntCodeDetail.getCdEntCode());
    this.setCdPymtType(aEntCodeDetail.getCdPymtType());
    this.setCdReqFunc(aEntCodeDetail.getCdReqFunc());
    this.setCdSvcCode(aEntCodeDetail.getCdSvcCode());
    this.setCdUnitType(aEntCodeDetail.getCdUnitType());
    this.setDtEntEff(aEntCodeDetail.getDtEntEff());
    this.setDtLastUpdate(aEntCodeDetail.getDtLastUpdate());
    this.setIdEntRow(aEntCodeDetail.getIdEntRow());
    this.setIdEquiv(aEntCodeDetail.getIdEquiv());
    this.setIndHeader(aEntCodeDetail.getIndHeader());
    this.setIndMileage(aEntCodeDetail.getIndMileage());
    this.setTxtEntAlpha(aEntCodeDetail.getTxtEntAlpha());
    this.setTxtEntDesc(aEntCodeDetail.getTxtEntDesc());
    Map<String, String> aCdFuncProgs = aEntCodeDetail.getCdFuncProgs();
    // this creates a shallow copy but its ok for this page
    Map<String, String> cdFuncProgs = new HashMap<String, String>(aCdFuncProgs);
    
    this.setCdFuncProgs(cdFuncProgs);
  }
  
  public UASEntitlementCodeDetail(UASEntitlementCodeDetail aEntCodeDetail, Map<String, String> cdFuncProgs) {
    this.setAmtCBL(aEntCodeDetail.getAmtCBL());
    this.setAmtLIL(aEntCodeDetail.getAmtLIL());
    this.setAmtRate(aEntCodeDetail.getAmtRate());
    this.setCdEntCode(aEntCodeDetail.getCdEntCode());
    this.setCdPymtType(aEntCodeDetail.getCdPymtType());
    this.setCdReqFunc(aEntCodeDetail.getCdReqFunc());
    this.setCdSvcCode(aEntCodeDetail.getCdSvcCode());
    this.setCdUnitType(aEntCodeDetail.getCdUnitType());
    this.setDtEntEff(aEntCodeDetail.getDtEntEff());
    this.setDtLastUpdate(aEntCodeDetail.getDtLastUpdate());
    this.setIdEntRow(aEntCodeDetail.getIdEntRow());
    this.setIdEquiv(aEntCodeDetail.getIdEquiv());
    this.setIndHeader(aEntCodeDetail.getIndHeader());
    this.setIndMileage(aEntCodeDetail.getIndMileage());
    this.setTxtEntAlpha(aEntCodeDetail.getTxtEntAlpha());
    this.setTxtEntDesc(aEntCodeDetail.getTxtEntDesc());
    Map<String, String> aCdFuncProgs = aEntCodeDetail.getCdFuncProgs();
    // empty map
    this.setCdFuncProgs(cdFuncProgs);
  }

}
