/**
 * Created on May 14, 2007 at 4:14:49 PM by Kapil Aggarwal - SACWIS Atlanta
 */
package gov.georgia.dhr.dfcs.sacwis.structs.output;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CSupRefOutboundSI;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 */
@SuppressWarnings("serial")
public class RetrieveCsupOutboundNcpsSO extends CSupRefOutboundSI implements Serializable {

  private StringBuffer errors;
  private static final String MSG_DELIM = "|";
  private boolean hasErrors;
  private String exceptionMsg;
  private List<CSupRefOutboundSI> listCSupRefOutboundSI = new ArrayList<CSupRefOutboundSI>();
  
  /**
   * @return the hasErrors
   */
  public boolean hasErrors() {
    return hasErrors;
  }

  /**
   * set the hasErrors
   */
  public void setHasErrors() {
    this.hasErrors = true;
  }

  /**
   * @return the errors
   */
  public StringBuffer getErrors() {
    return errors;
  }

  /**
   * @param errors the errors to set
   */
  public void setError(String error) {
    if(errors == null) {
      errors = new StringBuffer();
    }
    this.errors.append(MSG_DELIM + error);
    setHasErrors();
  }
  
  /**
   * @param RetrieveCsupOutboundNcpsSO the retrieveCsupOutboundNcpsSO to set
   */
  @SuppressWarnings("unused")
  public void addToListCSupRefOutboundSI(RetrieveCsupOutboundNcpsSO retrieveCsupOutboundNcpsSO) {
    this.listCSupRefOutboundSI.add(retrieveCsupOutboundNcpsSO);
  }

  /**
   * @return
   */
  public List<CSupRefOutboundSI> getNcpsList() {
    return listCSupRefOutboundSI;
  }
  
  public static String getErrorMsgsDelimeter() {
    return MSG_DELIM;
  }
  
  /**
   * @return the exceptionMsg
   */
  public String getExceptionMsgs() {
    return exceptionMsg;
  }

  /**
   * @param exceptionMsg the exceptionMsg to set
   */
  public void addExceptionMsg(String exceptionMsg) {
    this.exceptionMsg = exceptionMsg;
  }
  
  public void setListCSupRefOutboundSI(List<CSupRefOutboundSI> listCSupRefOutboundSI) {
    this.listCSupRefOutboundSI = listCSupRefOutboundSI;
  }
  
}
