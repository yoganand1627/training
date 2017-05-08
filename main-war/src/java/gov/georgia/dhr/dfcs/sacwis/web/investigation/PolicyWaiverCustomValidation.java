package gov.georgia.dhr.dfcs.sacwis.web.investigation;

// -- java classes --

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;


import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.CaseMgmt;
import gov.georgia.dhr.dfcs.sacwis.service.resource.Resource;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FadHomeRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;



/**
 * This class is used to validate parameters entered on the Policy Waiver page.
 * 
 * @author Carina Gerry Sept 15, 2006
 * 
 * 
 * <pre>
 *  Change History:
 *  Date        User      Description
 *  ----------  --------  --------------------------------------------------
 * 03/21/2011   hnguyen    SMS#97850: MR-075 Added new validation message.
 * 03/22/2011   hnguyen    SMS#97850: MR-075 Updated validation message text.
 * 03/25/2011   hnguyen    SMS#97850: MR-075 Consolidate validation for continue and submit.
 * 03/25/2011   hnguyen    SMS#97850: MR-075 Retrieve resource id from stage id in global, since
 *                         resource id in globaldata may not be populated.
 * </pre>
 */
public class PolicyWaiverCustomValidation extends FormValidation {
  /**
   * This method performs custom validation on the data submitted on the Medical Mental Assessment Page
   * 
   * @return <code>true</code> if the form data is valid; <code>false</code> otherwise.
   */
  protected boolean validateForm() {
    // Instantiate a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "validateForm()");
    // start the method trace
    performanceTrace.enterScope();

    HttpServletRequest request = super.getRequest();

    boolean isValid = true;

    String comments = ContextHelper.getStringSafe(request, "txtSzTxtWvrComments");
    String waiverType = ContextHelper.getStringSafe(request, "selCdWvrType");

    if(super.isButtonPressed("btnContinue") || super.isButtonPressed("btnSaveAndSubmit"))
    {
      if(CodesTables.CWVRTYP_WGP.equals(waiverType))
      {
        CaseMgmt caseMgmt = this.getEjb(CaseMgmt.class);

        FadHomeRetrieveSO fadHomeSO = caseMgmt.retrieveFadHomeByIdStage(GlobalData.getUlIdStage(request));
                
        List<String> wvrStatuses = new ArrayList<String>();
        wvrStatuses.add(CodesTables.CFAHMSTA_PUN);
        wvrStatuses.add(CodesTables.CFAHMSTA_AUN);

        if(!wvrStatuses.contains(fadHomeSO.getSzCdRsrcFaHomeStatus())){
          setErrorMessage(Messages.MSG_FAD_WVR_HOME_INVALID_STATUS);
          isValid = false;
        }else{
          Resource resource = this.getEjb(Resource.class);

          List<String> cdFaHomeStatuses = new ArrayList<String>();
          cdFaHomeStatuses.add(CodesTables.CFAHMSTA_PUN); // Pending Unapproved

          Date dtLastPendingUnapproved = resource.retrieveHomeStatusLastApproval(fadHomeSO.getUlIdResource(), cdFaHomeStatuses);
          
          if(dtLastPendingUnapproved == null || DateHelper.addToDate(dtLastPendingUnapproved, 0, 0, 60).before(new Date())){
            setErrorMessage(Messages.MSG_FAD_WVR_PERIOD_EXPIRED);
            isValid = false;
          }
        }
      }
    }
    
    if (super.isButtonPressed("btnSaveAndSubmit")) {
      // Make sure Reason "Other" is not entered without Findings
      if ("".equals(comments)) {
        setErrorMessage("txtSzTxtWvrComments", Messages.MSG_PWV_COMMENTS_REQ);
        isValid = false;
      }
      
      if(CodesTables.CWVRTYP_WPW.equals(waiverType))
      {
        String waiverReason = ContextHelper.getStringSafe(request, "selCdWvrReason");
        if(waiverReason.equals("P3C") || waiverReason.equals("PCS") || waiverReason.equals("PNB"))
        {
          String sleepingArrangement = ContextHelper.getStringSafe(request, "txtSlpArngmts");
          if(sleepingArrangement == null || sleepingArrangement.trim().equals(""))
          {
            setErrorMessage("txtSlpArngmts", Messages.MSG_INV_wvr_SLPARNGMNTS);
            isValid = false;
          }
        }
      }
      
      if(CodesTables.CWVRTYP_WLC.equals(waiverType))
      {
        String waiverReason = ContextHelper.getStringSafe(request, "selCdWvrReason");
        if(waiverReason.equals("IFI"))
        {
          String appPerDiem = ContextHelper.getStringSafe(request, "amtAppPrdm");
          if(appPerDiem == null || appPerDiem.trim().equals(""))
          {
            setErrorMessage("amtAppPrdm", Messages.MSG_INV_WVR_APPPERDM);
            isValid = false;
          }
        }
      }
    }
    
    if(super.isButtonPressed("btnSave"))
    {
      if(CodesTables.CWVRTYP_WCS.equals(waiverType))
      {
        String person = ContextHelper.getStringSafe(request, "personByIdWvrPrnUnableCnct");
        String other = ContextHelper.getStringSafe(request, "txtWvrOther");
        if(person == null || person.trim().equals(""))
        {
          if(other == null || other.trim().equals(""))
          {
            setErrorMessage("txtWvrOther", Messages.MSG_INV_WVR_PER_OTH);
            isValid = false;
          }
        }
      }
      if( CodesTables.CWVRTYP_WAS.equals(waiverType) )
      {
        String serviceDescription = ContextHelper.getStringSafe(request, "cdWvrSvcDesc");
        if(serviceDescription != null && !("".equals(serviceDescription)) )
        {
          String units = ContextHelper.getStringSafe(request, "nbrWvrUnit");
          if(units == null ||  "".equals(units) )
          {
            setErrorMessage("nbrWvrUnit", Messages.MSG_INV_WVR_SVCDESC);
            isValid = false;
          }
        }
      }
    }
      performanceTrace.getTotalTime();
    performanceTrace.exitScope("result is" + isValid);
    return isValid;
  }

  // static constants
  public static final String TRACE_TAG = "PolicyWaiverCustomValidation";

}
