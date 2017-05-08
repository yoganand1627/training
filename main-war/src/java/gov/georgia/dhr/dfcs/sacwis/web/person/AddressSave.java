package gov.georgia.dhr.dfcs.sacwis.web.person;

import java.io.Serializable;

import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN42SO;
import gov.georgia.dhr.dfcs.sacwis.web.common.AddressBean;

/**
 * <p>Address Detail Submodule Data Bean</p>
 * <p>Description: This bean will encapsulate all the data that the Address Detail
 *    conversation needs to populate the CCMN44SI input object.</p>
 *
 * @author Jenn M. Casdorph
 * @version 1.0
 *
 *
 * Change History:
 * Date      User         Description
 * --------  -----------  ----------------------------------------------
 * 09/12/03  CASDORJM     SIR 19772 - Added in logic such that

 */

/** Encapsulates request to save a phoneDB */
public class AddressSave
        implements Serializable {

  protected AddressBean addressBean = null;
  protected CCMN42SO ccmn42so = null;
  protected String cReqFuncCd = null;
  protected int indexNum = 0;
  protected String indInvalid = null;
  protected String indPrimary = null;
  protected String addressType = null;
  protected String attention = null;
  protected String email = null;
  protected String dateEnd = null;
  protected String indRemovalHome = null;

  public void setAddressBean(AddressBean addressBean) {
    this.addressBean = addressBean;
  }

  public AddressBean getAddressBean() {
    return addressBean;
  }

  public void setCCMN42SO(CCMN42SO ccmn42so) {
    this.ccmn42so = ccmn42so;
  }

  public CCMN42SO getCCMN42SO() {
    return ccmn42so;
  }

  public void setCReqFuncCd(String cReqFuncCd) {
    this.cReqFuncCd = cReqFuncCd;
  }

  public String getCReqFuncCd() {
    return cReqFuncCd;
  }

  public void setIndexNum(int indexNum) {
    this.indexNum = indexNum;
  }

  public int getIndexNum() {
    return indexNum;
  }

  public void setIndInvalid(String indInvalid) {
    this.indInvalid = indInvalid;
  }

  public String getIndInvalid() {
    return indInvalid;
  }

  public void setIndPrimary(String indPrimary) {
    this.indPrimary = indPrimary;
  }

  public String getIndPrimary() {
    return indPrimary;
  }

  public void setAddressType(String addressType) {
    this.addressType = addressType;
  }

  public String getAddressType() {
    return addressType;
  }

  public void setDateEnd(String dateEnd) {
    this.dateEnd = dateEnd;
  }

  public String getDateEnd() {
    return dateEnd;
  }

  public void setAttention(String attention) {
    this.attention = attention;
  }

  public String getAttention() {
    return attention;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getEmail() {
    return email;
  }
  
  public void setIndRemovalHome(String indRemovalHome) {
    this.indRemovalHome = indRemovalHome;
  }

  public String getIndRemovalHome() {
    return indRemovalHome;
  }

}