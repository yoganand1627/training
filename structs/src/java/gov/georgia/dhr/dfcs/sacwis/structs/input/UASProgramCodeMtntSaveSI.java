/**
 * This class contains information and data to save a UAS Program Code Maintenance entry.
 */
package gov.georgia.dhr.dfcs.sacwis.structs.input;

import gov.georgia.dhr.dfcs.sacwis.structs.output.UASProgramCodeDetail;
import gov.georgia.dhr.dfcs.sacwis.structs.output.UASProgramCodeListRow;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class UASProgramCodeMtntSaveSI implements Serializable {

  private String cdReqFunc;
  
  private String pageState;
  
  private String indHeaderReuse;
  
  private UASProgramCodeDetail prgCodeDetail;
  
  private UASProgramCodeDetail prevPrgCodeDetail;

  public String getCdReqFunc() {
    return cdReqFunc;
  }

  public void setCdReqFunc(String cdReqFunc) {
    this.cdReqFunc = cdReqFunc;
  }

  public UASProgramCodeDetail getPrgCodeDetail() {
    return prgCodeDetail;
  }

  public void setPrgCodeDetail(UASProgramCodeDetail prgCodeDetail) {
    this.prgCodeDetail = prgCodeDetail;
  }

  public UASProgramCodeDetail getPrevPrgCodeDetail() {
    return prevPrgCodeDetail;
  }

  public void setPrevPrgCodeDetail(UASProgramCodeDetail prevPrgCodeDetail) {
    this.prevPrgCodeDetail = prevPrgCodeDetail;
  }

  public String getPageState() {
    return pageState;
  }

  public void setPageState(String pageState) {
    this.pageState = pageState;
  }

  public String getIndHeaderReuse() {
    return indHeaderReuse;
  }

  public void setIndHeaderReuse(String indHeaderReuse) {
    this.indHeaderReuse = indHeaderReuse;
  }

}
