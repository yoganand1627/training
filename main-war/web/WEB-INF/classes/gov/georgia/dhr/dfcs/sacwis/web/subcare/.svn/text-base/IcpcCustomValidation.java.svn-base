package gov.georgia.dhr.dfcs.sacwis.web.subcare;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.output.IcpcDetailRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

/**
 * IcpcDetail.jsp Custom validation class
 * 
 * @author Herve Jean-Baptiste January 27, 2012
 * @version 1.0
 * 
 * <pre>
 * Change History:
 * Date           User                Description
 * ----------     ---------------     --------------------------------------------------------------------
 * 02/06/2012     arege               STGAP00017827: MR-085 Added generic message with name of the required fields for 
 *                                    ICWA Eligible and Initial Report Requested fields on 100A
 * 02/06/2012     arege               STGAP00017827: Fixed the condition for which the IV-E Determination check box is required
 * 02/10/2012     arege               STGAP00017827: Type Of Care is a required field for Form 100B
 * 02/13/2012     arege               STGAP00017827: Modified code so that 'Approved AA Funding Determination is required prior to .... error message
 *                                    is displayed correctly.
 * 02/21/2012     arege               STGAP00017827: After confirming with Pat, made all the 'required' fields to be validated on click of Save also.
 * 02/28/2012     arege               STGAP00017959: Fixed validation message "Approved AA Funding Determination is required....
 * 04/19/2012     arege               STGAP00017951: Added new error messages for Street, City , State , Zip and Phone fields.
 * </pre>
 */

public class IcpcCustomValidation extends FormValidation {

  public static final String TRACE_TAG = "IcpcCustomValidation";

  public static final String PENDING = "Pending";

  public static final String PLACEMENT_STATUS_INITIAL = "I";

  public static final String PLACEMENT_STATUS_CHANGE = "C";

  // The Primary Person is derived from the Person List of child's FCC Stage and is displayed in the
  // 'Caregiver/Parental Relationship Information for Child' Section on the Person Detail page. These are
  // the 'Parent' type relationships - the valid CodesTable codes are grouped here
  private static final Set<String> OTHER_RELATIONSHIP_CODES = new HashSet<String>() {
    {
      add(CodesTables.CRELVICT_SC); // -- SECONDARY CAREGIVER
      add(CodesTables.CRELVICT_PF); // -- PUTATIVE FATHER
      add(CodesTables.CRELVICT_LF); // -- LEGAL FATHER
      add(CodesTables.CRELVICT_BF); // -- BIOLOGICAL FATHER
      add(CodesTables.CRELVICT_LM); // -- LEGAL MOTHER
      add(CodesTables.CRELVICT_BM); // -- BIOLOGICAL MOTHER
    }
  };

  protected boolean validateForm() {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "validationForm");
    performanceTrace.enterScope();

    HttpServletRequest request = getRequest();
    BaseSessionStateManager state = getState();
    boolean result = true;

    IcpcDetailRetrieveSO icpcDetailRet = (IcpcDetailRetrieveSO) state.getAttribute("ICPCDETAILRETSO", request);
    String cdFormType = icpcDetailRet.getCdFormType();

    if (super.isButtonPressed("btnComplete") || super.isButtonPressed("btnSave")) {
      String errorMessage = StringHelper.EMPTY_STRING;
      int idPrimrayPerson = ContextHelper.getIntSafe(request, "selPrimaryPerson");
      String cdRelPrimaryPerson = icpcDetailRet.getCdRelPrimaryPerson();
      String indICWAEligible = ContextHelper.getStringSafe(request, "rbICWAEligible");
      String cdInitReportReq = ContextHelper.getStringSafe(request, "rbCdInitialReportReq");
      String dspIVEDeterm = ContextHelper.getStringSafe(request, "dspIVEDeterm");
      String street  = ContextHelper.getStringSafe(request, "dspStreet");
      String city  = ContextHelper.getStringSafe(request, "dspCity");
      String dspState  = ContextHelper.getStringSafe(request, "dspState");
      String zip  = ContextHelper.getStringSafe(request, "dspZip");
      String phone  = ContextHelper.getStringSafe(request, "dspPhone");




      if (CodesTables.CICPCTYP_100A.equals(cdFormType)) {
        // ICWA Eligible radio button field is required
        if (StringHelper.isEmptyOrNull(indICWAEligible)) {
          errorMessage = "ICWA Eligible - " + MessageLookup.getMessageByNumber(Messages.SSM_COMPLETE_REQUIRED);
          setErrorMessage(errorMessage);
          result = false;
        }
        // Initial Report Requested field is required
        if (StringHelper.isEmptyOrNull(cdInitReportReq)) {
          errorMessage = "Initial Report Requested - "
                         + MessageLookup.getMessageByNumber(Messages.SSM_COMPLETE_REQUIRED);
          setErrorMessage(errorMessage);
          result = false;
        }

        // User fails to select all required documents under 'Documents Enclosed'.
        String[] reqCheckedValues = CheckboxHelper.getCheckedValues(request, "cbxReqDoc");
        if (reqCheckedValues == null || reqCheckedValues.length < 7) {
          setErrorMessage(Messages.MSG_ICPC_100A_DOCS_REQ);
          result = false;
        }

        if (super.isButtonPressed("btnComplete")) { // if Complete button pressed
          //STGAP00017951: User selects a Primary Person and the person does not have either Street, State, Zip 
          //'Street, City, State and Zip are required for primary person.'          
          if(StringHelper.isEmptyOrNull(street)||StringHelper.isEmptyOrNull(dspState)
          ||  StringHelper.isEmptyOrNull(city) || StringHelper.isEmptyOrNull(zip)){
            setErrorMessage(Messages.MSG_ADDR_FIELDS_REQD);
            result = false;
          }
          //STGAP00017951: User selects a Primary Person and the person does not phone
          // 'Phone is required for primary person'
          if (StringHelper.isEmptyOrNull(phone)) {
            setErrorMessage(Messages.MSG_PHONE_REQD);
            result = false;
          }        
          
          
          // User selects "Relative Home Study, Adoptive Home Study" or "Foster Home Study" as
          // Initial Report Requested but the relationship of the Primary Person selected is of "Parent"
          if ((CodesTables.CINRPTRQ_IRB.equals(cdInitReportReq) || CodesTables.CINRPTRQ_IRC.equals(cdInitReportReq) || CodesTables.CINRPTRQ_IRD
                                                                                                                                               .equals(cdInitReportReq))
              && OTHER_RELATIONSHIP_CODES.contains(cdRelPrimaryPerson)) {
            setErrorMessage(Messages.MSG_ICPC_PARENT_STUDY);
            result = false;
          }

          // User selects the same person for Spouse and Primary Person
          if (idPrimrayPerson == ContextHelper.getIntSafe(request, "selSpouse")) {
            setErrorMessage(Messages.MSG_ICPC_SPOUSE_NOT_PRIMARY);
            result = false;
          }

          // User selects "Adoptive Home Study" and there is no IV-E Determination on AA Funding Summary page
          if (CodesTables.CINRPTRQ_IRC.equals(cdInitReportReq)
              && !StringHelper.isValid(icpcDetailRet.getAaFundingDeterm())) {
            setErrorMessage(Messages.MSG_ICPC_IVE_ADO_FUND_REQ);
            result = false; //STGAP00017959
          }

          // User fails to select the IV-E Documentation, as an enclosed document and
          // the Title IV-E Determination is not Pending
          if (!PENDING.equals(dspIVEDeterm)) {
            String[] applcblCheckedValues = CheckboxHelper.getCheckedValues(request, "cbxAplDoc");
            if (applcblCheckedValues == null) {
              setErrorMessage(Messages.MSG_ICPC_100A_DOCS_REQ);
              result = false;
            } else {
              boolean isIVEDocChecked = false;
              for (int i = 0; i < applcblCheckedValues.length; i++) {
                if (CodesTables.CDAPLCBX_APC.equals(applcblCheckedValues[i])) {
                  isIVEDocChecked = true;
                  break;
                }
              }
              if (!isIVEDocChecked) {
                setErrorMessage(Messages.MSG_ICPC_IVE_REQD);
                result = false;
              }
            }
          }
        }

      } else if (CodesTables.CICPCTYP_100B.equals(cdFormType)) {
        String cdTypeOfCare = ContextHelper.getStringSafe(request, "rbTypeOfCare");
        // Type Of Care field is required
        if (StringHelper.isEmptyOrNull(cdTypeOfCare)) {
          errorMessage = "Type Of Care - " + MessageLookup.getMessageByNumber(Messages.SSM_COMPLETE_REQUIRED);
          setErrorMessage(errorMessage);
          result = false;
        }
        if (super.isButtonPressed("btnComplete")) { // if Complete button pressed
          //STGAP00017951: User selects a Primary Person and the person does not have either Street, State, Zip 
          //'Street, City, State and Zip are required for primary person.'          
          if(StringHelper.isEmptyOrNull(street)||StringHelper.isEmptyOrNull(dspState)
          ||  StringHelper.isEmptyOrNull(city) || StringHelper.isEmptyOrNull(zip)){
            setErrorMessage(Messages.MSG_ADDR_FIELDS_REQD);
            result = false;
          }         
          
          // User selects "Relative Care or Foster Family Home Care" as the Type of Care but
          // the relationship of the Resource selected is of "Parent"
          if ((CodesTables.CTYPCARE_FFH.equals(cdTypeOfCare) || CodesTables.CTYPCARE_REL.equals(cdTypeOfCare))
              && OTHER_RELATIONSHIP_CODES.contains(cdRelPrimaryPerson)) {
            setErrorMessage(Messages.MSG_ICPC_PARENT_CARE);
            result = false;
          }

          // Placement Status is Initial Placement of Child in Receiving State but
          // did not enter a 'Date Child Placed in Receiving State'
          org.exolab.castor.types.Date dtPlacedRecState = ContextHelper.getCastorDateSafe(request, "dtPlacedRecState");
          if (PLACEMENT_STATUS_INITIAL.equals(ContextHelper.getStringSafe(request, "rbIndPlacementStatus"))
              && dtPlacedRecState == null) {
            setErrorMessage(Messages.MSG_ICPC_DT_PLACED_REQ);
            result = false;
          }

          // Placement Status is Placement Change but did not enter an 'Effective Date of Change'
          org.exolab.castor.types.Date dtEffectDtChange = ContextHelper.getCastorDateSafe(request, "dtEffectDtChange");
          if (PLACEMENT_STATUS_CHANGE.equals(ContextHelper.getStringSafe(request, "rbIndPlacementStatus"))
              && dtEffectDtChange == null) {
            setErrorMessage(Messages.MSG_ICPC_DT_CHANGE_REQ);
            result = false;
          }

          // User selects the Adoption Finalized radio button, doesn't indicate if it's In Sending State or Receiving
          // State
          if (CodesTables.CTERMRSN_TRA.equals(ContextHelper.getStringSafe(request, "rbCdPlacementTermReason"))
              && !StringHelper.isValid(ContextHelper.getStringSafe(request, "rbIndFinalizedIn"))) {
            setErrorMessage(Messages.MSG_ICPC_SEND_RECV_STATE_REQ);
            result = false;
          }

          // User selects 'Other (Specify)' in the Compact Placement Termination section but doesn't enter data in the
          // text field to specify
          if (CodesTables.CTERMRSN_TRL.equals(ContextHelper.getStringSafe(request, "rbCdPlacementTermReason"))
              && !StringHelper.isValid(ContextHelper.getStringSafe(request, "txtOtherTermRsn"))) {
            setErrorMessage(Messages.MSG_ICPC_OTHER_NOT_SPECIFY);
            result = false;
          }

          // User selects a value in the Compact Placement Termination section but doesn't enter a Date of Termination.
          org.exolab.castor.types.Date dtDateTermination = ContextHelper
                                                                        .getCastorDateSafe(request, "dtDateTermination");
          if (StringHelper.isValid(ContextHelper.getStringSafe(request, "rbCdPlacementTermReason"))
              && dtDateTermination == null) {
            setErrorMessage(Messages.MSG_ICPC_DT_TERM_REQD);
            result = false;
          }
        } //end of complete

      }
    }
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return result;
  }
}
