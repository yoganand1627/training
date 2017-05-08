/**
 * Created by Kapil Aggarwal - SACWIS Atlanta
 */
package gov.georgia.dhr.dfcs.sacwis.service.ws.impl;

import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.ws.CrsInquiryWS;
import gov.georgia.dhr.dfcs.sacwis.service.ws.CrsInquiry;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CrsInquirySI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CrsInquirySO;

public class CrsInquiryImpl extends BaseServiceImpl implements CrsInquiry {

  private CrsInquiryWS crsInquiryWS = null;

  public void setCrsInquiryWS(CrsInquiryWS crsInquiryWS) {
    this.crsInquiryWS = crsInquiryWS;
  }


  public CrsInquirySO performCrsInquiry(CrsInquirySI crsInquirySI) {
    return crsInquiryWS.performCrsInquiry(crsInquirySI);
  }
}