package gov.georgia.dhr.dfcs.sacwis.structs.output;

import java.io.Serializable;

/**
 * This is a generic response object for Web Services.  
 * <br>
 * The response codes are: <br>
 * <li>0 : Update OK
 * <li>-1: Error while saving the WebService
 * 
 * @author kapil.aggarwal
 */
public class ResponseSO implements Serializable {
  
  public static final int RESPONSE_OK = 0;

  private int code;
  
  public ResponseSO(int code){
    this.code = code;
  }

  public int getResponseCode() {
    return code;
  }

  public void setResponseCode(int code) {
    this.code = code;
  }
}