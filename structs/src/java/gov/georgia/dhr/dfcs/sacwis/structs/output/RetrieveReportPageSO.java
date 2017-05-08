/**
 * Created on Jan 8, 2007 at 4:12:25 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.structs.output;

import java.io.Serializable;

public class RetrieveReportPageSO implements Serializable {
  private String nmRptSqrName;

  private String nmRptSqrVer;

  private String dtLastUpdate;

  private int nbrRptRetainage;

  private String nmRptType;

  private String txtRptFullName;

  private String nmRptTemplateName;

  private String nmRptOrientation;

  private String txtRptEmailOptions;

  private String txtRptDesc;

  private String txtRptAreaType;

  private String indRptPage;

  private String indAccessAllowed; // Y or N - STGAP00010625 
  
  private String indShinesBatch;

public String getIndShinesBatch() {
	return indShinesBatch;
}

public void setIndShinesBatch(String indShinesBatch) {
	this.indShinesBatch = indShinesBatch;
}

public String getNmRptSqrName() {
    return this.nmRptSqrName;
  }

  public void setNmRptSqrName(String nmRptSqrName) {
    this.nmRptSqrName = nmRptSqrName;
  }

  public String getNmRptSqrVer() {
    return this.nmRptSqrVer;
  }

  public void setNmRptSqrVer(String nmRptSqrVer) {
    this.nmRptSqrVer = nmRptSqrVer;
  }

  public String getDtLastUpdate() {
    return this.dtLastUpdate;
  }

  public void setDtLastUpdate(String dtLastUpdate) {
    this.dtLastUpdate = dtLastUpdate;
  }

  public int getNbrRptRetainage() {
    return this.nbrRptRetainage;
  }

  public void setNbrRptRetainage(int nbrRptRetainage) {
    this.nbrRptRetainage = nbrRptRetainage;
  }

  public String getNmRptType() {
    return this.nmRptType;
  }

  public void setNmRptType(String nmRptType) {
    this.nmRptType = nmRptType;
  }

  public String getTxtRptFullName() {
    return this.txtRptFullName;
  }

  public void setTxtRptFullName(String txtRptFullName) {
    this.txtRptFullName = txtRptFullName;
  }

  public String getNmRptTemplateName() {
    return this.nmRptTemplateName;
  }

  public void setNmRptTemplateName(String nmRptTemplateName) {
    this.nmRptTemplateName = nmRptTemplateName;
  }

  public String getNmRptOrientation() {
    return this.nmRptOrientation;
  }

  public void setNmRptOrientation(String nmRptOrientation) {
    this.nmRptOrientation = nmRptOrientation;
  }

  public String getTxtRptEmailOptions() {
    return this.txtRptEmailOptions;
  }

  public void setTxtRptEmailOptions(String txtRptEmailOptions) {
    this.txtRptEmailOptions = txtRptEmailOptions;
  }

  public String getTxtRptDesc() {
    return this.txtRptDesc;
  }

  public void setTxtRptDesc(String txtRptDesc) {
    this.txtRptDesc = txtRptDesc;
  }

  public String getTxtRptAreaType() {
    return this.txtRptAreaType;
  }

  public void setTxtRptAreaType(String txtRptAreaType) {
    this.txtRptAreaType = txtRptAreaType;
  }

  public String getIndRptPage() {
    return this.indRptPage;
  }

  public void setIndRptPage(String indRptPage) {
    this.indRptPage = indRptPage;
  }

  public String getIndAccessAllowed() {
    return indAccessAllowed;
  }

  public void setIndAccessAllowed(String indAccessAllowed) {
    this.indAccessAllowed = indAccessAllowed;
  }



}
