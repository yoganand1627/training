package gov.georgia.dhr.dfcs.sacwis.web.casemgmt;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.RuntimeWrappedException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateUtility;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.service.person.Person;
import gov.georgia.dhr.dfcs.sacwis.structs.input.StagePersonLinkRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PaymentOfCareRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.StagePersonLinkSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.StagePersonLinkDetail_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

/**
 * This class is used to perform the custom validation on Payment Of Care.
 *
 * Change History:
 *  Date           User        Description
 * -----------     -------     -------------------------------------------------------------------------------------------
 *  04/30/2009     arege       STGAP00013397 - Added changes for MR- 033 Relative Care Invoicing Changes.
 *  06/08/2009     arege       STGAP00014111 - Modified code to reflect design change of check box to radio button for 
 *                                             the waiver options of 80%, 100% and custom waiver.  
 *  07/01/2009     hjbaptiste  STGAP00014561 - Perform all validations if in approval mode and the approver has
 *                                             clicked the Save button to update the page prior to approving
 *  04/27/2010     mxpatel     SMS #37417: Modified code so that for an Emergency Payment of Care, only the date of Emergency 
 *                             Supervisor Approval and name of the Supervisor Approving is required to Save and Submit.                                           
 *  05/21/2011     hnguyen     SMS #109407: MR-087 Added validation for conditionally required Court Review Due By date if POC type is RCS
 *                             or ERCS.  This validation will be bypassed if Child turns 18 prior to next court review checkbox
 *                             is selected. Added validation that court review date cannot be a past date or greater than or
 *                             equal to child 18th birthday.
 *  06/10/2011     hnguyen     SMS#109407: MR-087 Corrected validation message to not validate court review due by for APRV events. 
 *  06/16/2011     hnguyen     SMS#112174: MR-087 Corrected validation message to occur only on Save and Submit or Save in Approval mode. 
 *  06/16/2011     hnguyen     SMS#112181: MR-087 Corrected validation message to trigger if court review is on or after child 18th birthday. 
 *                                             
**/

public class PaymentOfCareCustomValidation extends FormValidation {
  public static final String TRACE_TAG = "PaymentOfCareCustomValidation";

  /**
   * 
   * @return result - Returns false if the data fails validation. Returns true if the data passes validation.
   * @throws gov.georgia.dhr.dfcs.sacwis.core.exception.RuntimeWrappedException
   * 
   */
  protected boolean validateForm() throws RuntimeWrappedException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".validateForm()");
    performanceTrace.enterScope();

    HttpServletRequest request = super.getRequest();
    BaseSessionStateManager state = (BaseSessionStateManager) request.getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);
    
    // MR-087 Needed for Child turns 18 checkbox and court review validation
    Person personEjb = getEjb(Person.class);
    PaymentOfCareRetrieveSO paymentOfCareRetrieve = (PaymentOfCareRetrieveSO) state.getAttribute("pocRetrieve", request);
        
    boolean isValid = true;
    String errorMessage = "";
    Date startDate = ContextHelper.getJavaDateSafe(request, PaymentOfCareConversation.TXT_START_DATE);
    Date endDate = ContextHelper.getJavaDateSafe(request, PaymentOfCareConversation.TXT_END_DATE);
    Date terminateDate = ContextHelper.getJavaDateSafe(request, PaymentOfCareConversation.TXT_TERM_DATE);
    Date currentDate = new Date();
    String indConcurrent = CheckboxHelper.getCheckboxValue(request, PaymentOfCareConversation.CBX_CONC_PER_DIEM);
    String pocType = request.getParameter(PaymentOfCareConversation.POC_TYPE);
    double specialAddOn = ContextHelper.getDoubleSafe(request, PaymentOfCareConversation.TXT_SPECIAL_RATE);
    String waiverSelectd = ContextHelper.getStringSafe(request, "rbCWaiverOptions");

    // MR-087 Add new Child turns 18 checkbox and court review validation
    Date dtCourtReview = ContextHelper.getJavaDateSafe(request, PaymentOfCareConversation.DT_COURT_REVIEW);
    String indChildTurns18 = CheckboxHelper.getCheckboxValue(request, PaymentOfCareConversation.IND_18_BY_NEXT_CRT_RVW);
    String cdEventStatus = StringHelper.EMPTY_STRING;
    
    if(paymentOfCareRetrieve != null){
      cdEventStatus = paymentOfCareRetrieve.getCdEventStatus();
    }

    boolean approvalMode = false;
    if (GlobalData.isApprovalMode(request)) {
      approvalMode = true;
    }
    
    try {
      if ((approvalMode && super.isButtonPressed(PaymentOfCareConversation.SAVE_BUTTON_ON_POC)) ||
                      super.isButtonPressed(PaymentOfCareConversation.SAVE_BUTTON_ON_POC)
          || super.isButtonPressed(PaymentOfCareConversation.SAVE_SUBMIT_ON_POC)) {
        if ((CodesTables.CPOCTYPE_RCS.equals(pocType) || CodesTables.CPOCTYPE_ERS.equals(pocType)
             || CodesTables.CPOCTYPE_SUG.equals(pocType) || CodesTables.CPOCTYPE_ESG.equals(pocType)
             || CodesTables.CPOCTYPE_NSG.equals(pocType) || CodesTables.CPOCTYPE_NEG.equals(pocType))
            && "".equals(ContextHelper.getStringSafe(request, PaymentOfCareConversation.IND_RCS_TYPE))) {
          errorMessage = "Initial/Renewal - " + MessageLookup.getMessageByNumber(Messages.SSM_COMPLETE_REQUIRED);
          setErrorMessage(errorMessage);
          isValid = false;
        }
        if (!DateHelper.isNull(endDate) && !DateHelper.isNull(startDate) && DateHelper.isBefore(endDate,startDate)) {
          isValid = false;
          setErrorMessage(PaymentOfCareConversation.TXT_END_DATE, Messages.SSM_START_BEFORE_SAME_END);
        } else if (!DateHelper.isNull(startDate) && startDate.after(currentDate)) {
          setErrorMessage(PaymentOfCareConversation.TXT_START_DATE, Messages.SSM_DATE_BEFORE_SAME_CURR);
          isValid = false;
        }

        if (CodesTables.CPOCTYPE_RCS.equals(pocType) || CodesTables.CPOCTYPE_ERS.equals(pocType)
            || CodesTables.CPOCTYPE_SUG.equals(pocType) || CodesTables.CPOCTYPE_ESG.equals(pocType)
            || CodesTables.CPOCTYPE_NSG.equals(pocType) || CodesTables.CPOCTYPE_NEG.equals(pocType)) {
          Date suspTermDate = ContextHelper.getJavaDateSafe(request, PaymentOfCareConversation.TXT_TERM_DATE);
          // STGAP00006376 - only Enhanced Relative Care Subsidy, Non-Relative Enhanced Subsidized Guardianship
          // or enhanced subsidized guardianship require family's income to be less than $150,000
          if ((CodesTables.CPOCTYPE_ERS.equals(pocType) || CodesTables.CPOCTYPE_NEG.equals(pocType)|| CodesTables.CPOCTYPE_ESG.equals(pocType))
              && ArchitectureConstants.N
                                        .equals(CheckboxHelper
                                                              .getCheckboxValue(
                                                                                request,
                                                                                PaymentOfCareConversation.FAMILY_INCOME_LESS))) {
            isValid = false;
            setErrorMessage(PaymentOfCareConversation.FAMILY_INCOME_LESS, Messages.MSG_FAM_INC_LESS_150);
          } else if ((DateHelper.isNull(suspTermDate))
                     && (ArchitectureConstants.Y
                                                .equals(CheckboxHelper
                                                                      .getCheckboxValue(
                                                                                        request,
                                                                                        PaymentOfCareConversation.IND_SUSPEND)) || ArchitectureConstants.Y
                                                                                                                                                          .equals(CheckboxHelper
                                                                                                                                                                                .getCheckboxValue(
                                                                                                                                                                                                  request,
                                                                                                                                                                                                  PaymentOfCareConversation.IND_TERMINATE)))) {
            isValid = false;
            setErrorMessage(PaymentOfCareConversation.TXT_TERM_DATE, Messages.MSG_TERM_SUSP_DATE_REQ);
          } else if (!StringHelper.isValid(request.getParameter(PaymentOfCareConversation.REASON_SUSP_TERM))
                     && (ArchitectureConstants.Y
                                                .equals(CheckboxHelper
                                                                      .getCheckboxValue(
                                                                                        request,
                                                                                        PaymentOfCareConversation.IND_SUSPEND)) || ArchitectureConstants.Y
                                                                                                                                                          .equals(CheckboxHelper
                                                                                                                                                                                .getCheckboxValue(
                                                                                                                                                                                                  request,
                                                                                                                                                                                                  PaymentOfCareConversation.IND_TERMINATE)))) {
            isValid = false;
            errorMessage = "Reason for Suspension/Termination - "
                           + MessageLookup.getMessageByNumber(Messages.MSG_TERM_SUP_EXPL_REQ);
            setErrorMessage(errorMessage);
          }
        }

        if (ArchitectureConstants.Y.equals(indConcurrent)
            && (!StringHelper.isValid(request.getParameter(PaymentOfCareConversation.TXT_REASON_CONC_PER_DIEM)))) {
          isValid = false;
          setErrorMessage(PaymentOfCareConversation.TXT_REASON_CONC_PER_DIEM, Messages.MSG_CONCURR_EXPL_REQ);
        } else if (StringHelper.isValid(request.getParameter(PaymentOfCareConversation.TXT_SPECIAL_RATE))
                   && (!StringHelper.isValid(request.getParameter(PaymentOfCareConversation.TXT_REASON_SPEC_PER_DIEM)))
                   && (CodesTables.CPOCTYPE_RFD.equals(pocType) || CodesTables.CPOCTYPE_EFD.equals(pocType) || CodesTables.CPOCTYPE_LOC
                                                                                                                                       .equals(pocType))) {
          isValid = false;
          errorMessage = "Reason For Special Add-On Rate - "
                         + MessageLookup.getMessageByNumber(Messages.MSG_SPEC_PDIEM_EXPL_REQ);
          setErrorMessage(errorMessage);
        }
        if (!DateHelper.isNull(terminateDate) && !DateHelper.isNull(endDate)
            && DateHelper.isAfter(terminateDate, endDate)) {
          setErrorMessage(Messages.SSM_CON_TERM_AFTER_END);
          isValid = false;
        }
        
        // STGAP00009380 We need to throw this Error message even if Only Save button is pressed.
        if (!(request.getParameter(PaymentOfCareConversation.TXT_SPECIAL_RATE) == null)
                        && !"".equals(request.getParameter(PaymentOfCareConversation.TXT_SPECIAL_RATE))
                        && (specialAddOn < 0.50 || specialAddOn > 1.75)) {
               isValid = false;
               setErrorMessage(PaymentOfCareConversation.TXT_SPECIAL_RATE, Messages.MSG_ELEV_PDEM_LIMITS);
             }
      // Per MR- 033 STGAP00013397        
       if (CodesTables.CPERDIEM_W3.equals(waiverSelectd)
                        && (!StringHelper.isValid(request.getParameter(PaymentOfCareConversation.TXT_WAIVER_AMOUNT)))) {
                      isValid = false;
                      setErrorMessage(PaymentOfCareConversation.TXT_WAIVER_AMOUNT, Messages.MSG_POC_WVR_AMT_REQ);
                    }
        // End MR- 033 STGAP00013397
        
        if ((approvalMode && super.isButtonPressed(PaymentOfCareConversation.SAVE_BUTTON_ON_POC)) || 
                        super.isButtonPressed(PaymentOfCareConversation.SAVE_SUBMIT_ON_POC)) {
          if ((CodesTables.CPOCTYPE_SFD.equals(pocType) || CodesTables.CPOCTYPE_RWW.equals(pocType))
              && (!"E".equals(request.getParameter(PaymentOfCareConversation.IND_RBWO_TYPE)) && (DateHelper
                                                                                                           .isNull(endDate) || pocDuration(
                                                                                                                                           startDate,
                                                                                                                                           endDate) > 12))) {
            isValid = false;
            setErrorMessage(Messages.MSG_SPEC_FPDM_END_DATE_REQ);
          } else if (CodesTables.CPOCTYPE_EFD.equals(pocType)
                     && (DateHelper.isNull(endDate) || (pocDuration(startDate, endDate) > 12))) {
            isValid = false;
            setErrorMessage(Messages.MSG_SPEC_FPDM_END_DATE_REQ);
          } else if ((CodesTables.CPOCTYPE_SFD.equals(pocType) || CodesTables.CPOCTYPE_RWW.equals(pocType))
                     && ("E".equals(request.getParameter(PaymentOfCareConversation.IND_RBWO_TYPE)) && (DateHelper
                                                                                                                 .isNull(endDate) || check30Day(
                                                                                                                                                startDate,
                                                                                                                                                endDate)))) {
            isValid = false;
            setErrorMessage(Messages.MSG_EMG_LOC_END_DATE);
          } else if ((CodesTables.CPOCTYPE_SFD.equals(pocType) || CodesTables.CPOCTYPE_RWW.equals(pocType))
                     && "E".equals(request.getParameter(PaymentOfCareConversation.IND_RBWO_TYPE))) {
            if (request.getParameter(PaymentOfCareConversation.TXT_PACKET_EMERG_APPRV) == null
                || "".equals(request.getParameter(PaymentOfCareConversation.TXT_PACKET_EMERG_APPRV))) {
              isValid = false;
              setErrorMessage(PaymentOfCareConversation.TXT_PACKET_EMERG_APPRV, Messages.SSM_COMPLETE_REQUIRED_SAVE_SUBMIT);
            } else if (request.getParameter(PaymentOfCareConversation.TXT_SUPRVAPPRV) == null
                       || "".equals(request.getParameter(PaymentOfCareConversation.TXT_SUPRVAPPRV))) {
              isValid = false;
              setErrorMessage(PaymentOfCareConversation.TXT_SUPRVAPPRV, Messages.SSM_COMPLETE_REQUIRED_SAVE_SUBMIT);
            }
          } else if ((CodesTables.CPOCTYPE_SFD.equals(pocType) || CodesTables.CPOCTYPE_RWW.equals(pocType))
                     && "I".equals(request.getParameter(PaymentOfCareConversation.IND_RBWO_TYPE))) {
            if (request.getParameter(PaymentOfCareConversation.TXT_PACKET_COMP) == null
                || "".equals(request.getParameter(PaymentOfCareConversation.TXT_PACKET_COMP))) {
              isValid = false;
              setErrorMessage(PaymentOfCareConversation.TXT_PACKET_COMP, Messages.SSM_COMPLETE_REQUIRED_SAVE_SUBMIT);
            } else if (request.getParameter(PaymentOfCareConversation.NM_PERS_COMP) == null
                       || "".equals(request.getParameter(PaymentOfCareConversation.NM_PERS_COMP))) {
              isValid = false;
              setErrorMessage(PaymentOfCareConversation.NM_PERS_COMP, Messages.SSM_COMPLETE_REQUIRED_SAVE_SUBMIT);
            } else if (request.getParameter(PaymentOfCareConversation.TXT_PACKET_EMERG_APPRV) == null
                       || "".equals(request.getParameter(PaymentOfCareConversation.TXT_PACKET_EMERG_APPRV))) {
              isValid = false;
              setErrorMessage(PaymentOfCareConversation.TXT_PACKET_EMERG_APPRV,
                              Messages.SSM_COMPLETE_REQUIRED_SAVE_SUBMIT);
            } else if (request.getParameter(PaymentOfCareConversation.TXT_SUPRVAPPRV) == null
                       || "".equals(request.getParameter(PaymentOfCareConversation.TXT_SUPRVAPPRV))) {
              isValid = false;
              setErrorMessage(PaymentOfCareConversation.TXT_SUPRVAPPRV, Messages.SSM_COMPLETE_REQUIRED_SAVE_SUBMIT);
            } else if (request.getParameter(PaymentOfCareConversation.TXT_PACKET_SENT) == null
                       || "".equals(request.getParameter(PaymentOfCareConversation.TXT_PACKET_SENT))) {
              isValid = false;
              setErrorMessage(PaymentOfCareConversation.TXT_PACKET_SENT, Messages.SSM_COMPLETE_REQUIRED_SAVE_SUBMIT);
            } else if (request.getParameter(PaymentOfCareConversation.TXT_STAFF_COMP) == null
                       || "".equals(request.getParameter(PaymentOfCareConversation.TXT_STAFF_COMP))) {
              isValid = false;
              setErrorMessage(PaymentOfCareConversation.TXT_STAFF_COMP, Messages.SSM_COMPLETE_REQUIRED_SAVE_SUBMIT);
            } else if (request.getParameter(PaymentOfCareConversation.TXT_SO_RESPONSE) == null
                       || "".equals(request.getParameter(PaymentOfCareConversation.TXT_SO_RESPONSE))) {
              isValid = false;
              setErrorMessage(PaymentOfCareConversation.TXT_SO_RESPONSE, Messages.SSM_COMPLETE_REQUIRED_SAVE_SUBMIT);
            } else if (request.getParameter(PaymentOfCareConversation.TXT_SO_STAFF_APPRV) == null
                       || "".equals(request.getParameter(PaymentOfCareConversation.TXT_SO_STAFF_APPRV))) {
              isValid = false;
              setErrorMessage(PaymentOfCareConversation.TXT_SO_STAFF_APPRV, Messages.SSM_COMPLETE_REQUIRED_SAVE_SUBMIT);
            }
          } else if ((CodesTables.CPOCTYPE_SFD.equals(pocType) || CodesTables.CPOCTYPE_RWW.equals(pocType))
                     && "R".equals(request.getParameter(PaymentOfCareConversation.IND_RBWO_TYPE))) {
            if (request.getParameter(PaymentOfCareConversation.TXT_RBWO_REVIEW) == null
                || "".equals(request.getParameter(PaymentOfCareConversation.TXT_RBWO_REVIEW))) {
              isValid = false;
              setErrorMessage(PaymentOfCareConversation.TXT_RBWO_REVIEW, Messages.SSM_COMPLETE_REQUIRED_SAVE_SUBMIT);
            } else if (request.getParameter(PaymentOfCareConversation.TXT_RBWO_STAFF_APPRV) == null
                       || "".equals(request.getParameter(PaymentOfCareConversation.TXT_RBWO_STAFF_APPRV))) {
              isValid = false;
              setErrorMessage(PaymentOfCareConversation.TXT_RBWO_STAFF_APPRV,
                              Messages.SSM_COMPLETE_REQUIRED_SAVE_SUBMIT);
            }
          } else if (!(request.getParameter(PaymentOfCareConversation.TXT_SPECIAL_RATE) == null)
                     && !"".equals(request.getParameter(PaymentOfCareConversation.TXT_SPECIAL_RATE))
                     && (specialAddOn < 0.50 || specialAddOn > 1.75)) {
            isValid = false;
            setErrorMessage(PaymentOfCareConversation.TXT_SPECIAL_RATE, Messages.MSG_ELEV_PDEM_LIMITS);
          }
          // STGAP00004406
          // if payment type is RBWO or RBWO with Waiver then Program Type (CCI or CPA) is required in order to submit
          // for approval
          if ((CodesTables.CPOCTYPE_LOC.equals(pocType) || CodesTables.CPOCTYPE_RWW.equals(pocType))) {
            if (!StringHelper.isValid(request.getParameter(PaymentOfCareConversation.IND_PROGRAM_TYPE))) {
              isValid = false;
              setErrorMessage(PaymentOfCareConversation.PROGRAM_TYPE_LABEL, Messages.SSM_COMPLETE_REQUIRED_SAVE_SUBMIT);
            } else if (!StringHelper.isValid(request.getParameter(PaymentOfCareConversation.RBWO_PROGRAM_TYPE))) {
              isValid = false;
              setErrorMessage(PaymentOfCareConversation.RBWO_PROGRAM_TYPE, Messages.SSM_COMPLETE_REQUIRED_SAVE_SUBMIT);
            }
          }
          // end STGAP00004406
          
          // MR- 033 STGAP00013397 
         if ((CodesTables.CPERDIEM_W2.equals(waiverSelectd) || CodesTables.CPERDIEM_W3.equals(waiverSelectd))
                          && (!StringHelper.isValid(request.getParameter(PaymentOfCareConversation.TXT_WAIVER_REASON)))){
            isValid = false;
            setErrorMessage(PaymentOfCareConversation.TXT_WAIVER_REASON, Messages.MSG_POC_WVR_CMNT_REQ);                  
            }            

          if ( CodesTables.CPOCTYPE_SFD.equals(pocType) && (StringHelper.isEmptyOrNull(request.getParameter(PaymentOfCareConversation.TXT_SPECIAL_RATE)) || 
                          StringHelper.isEmptyOrNull(request.getParameter(PaymentOfCareConversation.TXT_FC_RBWO_WAIVER))) ) {
            isValid = false;
            setErrorMessage( Messages.MSG_POC_BOTH_AMT_REQ);
          }
          // end of MR- 033 STGAP00013397 
          
          // MR-087: RCS or ERCS Validations
          // Court review validation
          // do not validate if event is already Approved
          if ((CodesTables.CPOCTYPE_RCS.equals(pocType) || CodesTables.CPOCTYPE_ERS.equals(pocType))
                          && !CodesTables.CEVTSTAT_APRV.equals(cdEventStatus)){
            // Court Review is required if Child turns 18 checkbox is not selected
            if (DateHelper.isNull(dtCourtReview) 
                            && !ArchitectureConstants.Y.equals(indChildTurns18)){
              isValid = false;
              setErrorMessage(PaymentOfCareConversation.DT_COURT_REVIEW, Messages.SSM_COMPLETE_REQUIRED);
            }
            
            // if Court Review is required, Court review cannot be a past date
            if (!DateHelper.isNull(dtCourtReview)
                            && !ArchitectureConstants.Y.equals(indChildTurns18)
                            && DateHelper.isBeforeToday(dtCourtReview)){
              isValid = false;
              setErrorMessage(PaymentOfCareConversation.DT_COURT_REVIEW, Messages.MSG_RCS_CRT_RVW_PAST);
            }
            
            // if court review is required, Court review cannot be greater than or equal to child 18th birthdate
            StagePersonLinkRetrieveSI si = new StagePersonLinkRetrieveSI();
            si.setUlIdStage(GlobalData.getUlIdStage(request));
            si.setSzCdStagePersRole(CodesTables.CROLEALL_PC);
            
            StagePersonLinkSO so = personEjb.retrieveStagePersonLink(si);
            StagePersonLinkDetail_ARRAY splList = so.getStagePersonLinkDetail_ARRAY();
            
            Date childDOB = null;
            
            if(splList.getStagePersonLinkDetailCount() > 0){
              // there should only be one PC, so pull first item on list
              childDOB = DateHelper.toJavaDate(splList.getStagePersonLinkDetail(0).getDtDtPersonBirth());
            }
            
            // only validate if all required fields and criterias are valid
            if (!DateHelper.isNull(dtCourtReview)
                            && !ArchitectureConstants.Y.equals(indChildTurns18)
                            && !DateHelper.isNull(childDOB)
                            && DateHelper.isAfter(dtCourtReview, DateHelper.addToDate(childDOB, 18, 0, -1))){
              isValid = false;
              setErrorMessage(PaymentOfCareConversation.DT_COURT_REVIEW, Messages.MSG_RCS_18_PRIOR_TO_CRT_RVW);
            }
            // End MR-087
          }          
          
        } // end if Save and submit
        
      } // end if either Save or Save and Submit
    } catch (Exception e) {
      throw new RuntimeWrappedException(e);
    }

    performanceTrace.exitScope();
    return isValid;
  }

  private int pocDuration(Date dtStart, Date dtEnd) {
    return DateUtility.getAgeInMonths(dtStart, dtEnd);
  }

  private boolean check30Day(Date startDate, Date endDate) {
    return DateHelper.isAfter(endDate, DateHelper.addToDate(startDate, 0, 0, 30));
  }
}