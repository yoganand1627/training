/**
 * Name: UASProgramCodeMtntRetrieveSI
 * Description: This class contains user request information to display the page UAS program code maintenance 
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
 */
package gov.georgia.dhr.dfcs.sacwis.structs.input;

public class UASProgramCodeMtntRetrieveSI {

  private int rowIndex;

  private int idUasProgramCodeMtnt;

  private String cdReqFunc;

  public int getRowIndex() {
    return rowIndex;
  }

  public void setRowIndex(int rowIndex) {
    this.rowIndex = rowIndex;
  }

  public int getIdUasProgramCodeMtnt() {
    return idUasProgramCodeMtnt;
  }

  public void setIdUasProgramCodeMtnt(int idUasProgramCodeMtnt) {
    this.idUasProgramCodeMtnt = idUasProgramCodeMtnt;
  }

  public String getCdReqFunc() {
    return cdReqFunc;
  }

  public void setCdReqFunc(String cdReqFunc) {
    this.cdReqFunc = cdReqFunc;
  }
}
