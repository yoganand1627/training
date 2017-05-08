/** Change History:
 **  Date        User              Description
 **  --------    ----------------  --------------------------------------------------
 *   03/21/11    Hai Nguyen        SMS#97850: MR-075 Included idResource, resource status,
 *                                 and Fa Home status.                                
 *                                 
 **/

package gov.georgia.dhr.dfcs.sacwis.structs.output;

import java.io.Serializable;

@SuppressWarnings("serial")
public class FadHomeRetrieveSO implements Serializable {

  private int ulIdCase;
  private int ulIdStage;
  private int ulIdResource;
  private String szCdRsrcFaHomeStatus;
  private String szCdRsrcStatus;

  public int getUlIdCase() {
    return ulIdCase;
  }

  public void setUlIdCase(int ulIdCase) {
    this.ulIdCase = ulIdCase;
  }

  public int getUlIdStage() {
    return ulIdStage;
  }

  public void setUlIdStage(int ulIdStage) {
    this.ulIdStage = ulIdStage;
  }

  public int getUlIdResource() {
    return ulIdResource;
  }

  public void setUlIdResource(int ulIdResource) {
    this.ulIdResource = ulIdResource;
  }

  public String getSzCdRsrcFaHomeStatus() {
    return szCdRsrcFaHomeStatus;
  }

  public void setSzCdRsrcFaHomeStatus(String szCdRsrcFaHomeStatus) {
    this.szCdRsrcFaHomeStatus = szCdRsrcFaHomeStatus;
  }

  public String getSzCdRsrcStatus() {
    return szCdRsrcStatus;
  }

  public void setSzCdRsrcStatus(String szCdRsrcStatus) {
    this.szCdRsrcStatus = szCdRsrcStatus;
  }
 
}
