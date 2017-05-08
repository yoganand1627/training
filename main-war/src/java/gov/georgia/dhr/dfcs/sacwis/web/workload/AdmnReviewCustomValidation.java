package gov.georgia.dhr.dfcs.sacwis.web.workload;

import javax.servlet.http.HttpServletRequest;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

/**
 * This class is used to perform the custom validation on External Docuemtation Detail page.
 *
 * @author Rodrigo DeJuana 12/9/2002
 *         <p/>
 *         * Change History: Date      User         Description --------  -----------
 *         ---------------------------------------------- 
 *         10/14/03  dickmaec     SIR 19857 -- ContextHelper.get...replaces getInputValue();
 *         
 *         10/14/03  dickmaec     As part of SIR 19857, all messages where shorted from
 *                                MessageLookup.getMessageByNumber( Messages.SSM_FAD_MIN_LESS_MAX) 
 *                                to Messages.SSM_FAD_MIN_LESS_MAX.
 *         03/16/2010 hnguyen     Update validation to check against Denied(050)/Closed(060) status
 *                                rather than Approved(040) status that end-dated
 *         <p/>
 */
public class AdmnReviewCustomValidation extends FormValidation {
  public static final String TRACE_TAG = "AdmnReviewCustomValidation";

  /**
   * Custom validation method called for Admin Review page.  Fails validation under the following conditions: 1. Status
   * is either CARVSTAT_030 OR CARVSTAT_040 && resultField is empty
   * <p/>
   * 2. Status is either CARVSTAT_030 OR CARVSTAT_040 && type is NOT CARVTYPE_040 && reqRecDate OR reviewDate OR
   * notifDate is null && the stage type is not ARF.
   * <p/>
   * 3. reqRecDate is null && reviewDate is NOT null
   * <p/>
   * 4. reqRecDate is null && conductByDate is NOT null
   * <p/>
   * 5. SaveAndSubmit button is pressed && status is NOT CARVTYPE_040
   * <p/>
   * 6. Save button is pressed && status IS CARVTYPE_040
   *
   * @return false if validation fails.
   */
  protected boolean validateForm() {
    HttpServletRequest request = super.getRequest();

    boolean result = true;

    String type = ContextHelper.getStringSafe(request, "selSzCdAdminRvAppealType");
    String status = ContextHelper.getStringSafe(request, "selSzCdAdminRvStatus");


    //REG074 -- The Review Date must be after Requested Rec. Date. Added DateHelper to vertify this
    //condition and then throw the message, MSG_REVIEW_AFTER_REQUEST_DATE.
    if (CodesTables.CARVTYPE_020.equals(type) == false) {
      
      String resultField = ContextHelper.getStringSafe(request, "txtSzAdminRvAppealResult");
      String RsnApprDenial = ContextHelper.getStringSafe(request, "txtSzTxtRsnApprvDeny").trim();
      String lglRep = ContextHelper.getStringSafe(request, "rbIndLglRepresentation");
      String SAAGNtfctn = ContextHelper.getStringSafe(request, "rbIndSAAGNotification");
      org.exolab.castor.types.Date reqRecDate = ContextHelper.getCastorDateSafe(request, "txtDtDtAdminRvReqAppeal");
      org.exolab.castor.types.Date reviewDate = ContextHelper.getCastorDateSafe(request, "txtDtDtAdminRvAppealReview");
      org.exolab.castor.types.Date conductByDate = ContextHelper.getCastorDateSafe(request, "txtDtDtAdminRvDue");
      org.exolab.castor.types.Date notifDate = ContextHelper.getCastorDateSafe(request, "txtDtDtAdminRvAppealNotif");
      
      if (status.equals(CodesTables.CARVSTAT_050) || status.equals(CodesTables.CARVSTAT_060)) {

        if (!type.equals(CodesTables.CARVTYPE_050) || !type.equals(CodesTables.CARVTYPE_060)) {
          if (reqRecDate == null) {
            setErrorMessage("txtDtDtAdminRvReqAppeal", Messages.MSG_RQST_RCVD_DT_REQ);
            result = false;
          }
        }
      }
      
      if ((DateHelper.isBefore(reviewDate, reqRecDate))) {
        setErrorMessage("txtDtDtAdminRvAppealReview", Messages.MSG_REVIEW_AFTER_REQUEST_DATE);
        result = false;
      }

      if (reqRecDate == null && reviewDate != null) {
        setErrorMessage("txtDtDtAdminRvAppealReview", Messages.MSG_RQST_RCVD_DT_REQ_RVW);
        result = false;
      }
      if (reqRecDate == null && conductByDate != null) {
        setErrorMessage("txtDtDtAdminRvDue", Messages.MSG_RQST_RCVD_DT_REQ_CONDUCT);
        result = false;
      }

      if (isButtonPressed("btnSaveAndClose") && (!status.equals(CodesTables.CARVSTAT_050) && !status.equals(CodesTables.CARVSTAT_060))) {
        setErrorMessage("selSzCdAdminRvStatus", Messages.MSG_APRV_REQ_BEFORE_SAVE_CLOSE);
        result = false;
      }

      if (isButtonPressed("btnSaveAndClose") && RsnApprDenial.length() == 0) {
        setErrorMessage("txtSzTxtRsnApprvDeny", Messages.MSG_PRSN_NTFD_REQ_NOT_RLSE);
        result = false;
      }

      if (isButtonPressed("btnSaveAndClose") && lglRep.length() == 0) {
        setErrorMessage("rbIndLglRepresentation", Messages.MSG_ARI_LEGAL_REP_REQ);
        result = false;
      }

      if (isButtonPressed("btnSaveAndClose") && "Y".equals(lglRep) && (SAAGNtfctn == null || "N".equals(SAAGNtfctn))) {
        setErrorMessage("rbIndSAAGNotification", Messages.MSG_ARI_LEGAL_NOT_SAAG);
        result = false;
      }

      if (isButtonPressed("btnSaveAndClose") && reviewDate == null) {
        setErrorMessage("txtDtDtAdminRvAppealReview", Messages.MSG_RVW_DT_REQ_NOT_RLSE);
        result = false;
      }
      if (isButtonPressed("btnSaveAndClose") && notifDate == null) {
        setErrorMessage("txtDtDtAdminRvAppealNotif", Messages.MSG_ARI_REASON_REQ);
        result = false;
      }

      if (isButtonPressed("btnSaveAndClose") && resultField.length() == 0) {
        setErrorMessage("txtSzAdminRvAppealResult", Messages.MSG_ADMIN_RVW_RESULT_REQ);
        result = false;
      }

      if (isButtonPressed("btnSave") && (status.equals(CodesTables.CARVSTAT_050) || status.equals(CodesTables.CARVSTAT_060))) {
        setErrorMessage("selSzCdAdminRvStatus", Messages.MSG_AR_SAVE_CLOSE);
        result = false;
      }
    }

    
    
    //capta enhancements
    boolean intOnly = ContextHelper.getBooleanSafe(request, "hdnIntOnly");
    if(CodesTables.CARVTYPE_020.equals(type) == true && intOnly == false) {
      String indAdminLevel = ContextHelper.getStringSafe(request, "rbIndAdminLevel");
      if(("1".equals(indAdminLevel) || "2".equals(indAdminLevel)) == false) {
        setErrorMessage(Messages.MSG_ARI_LEVEL_REQ);
        result = false;
      }
      
      //1st level validations
      if("1".equals(indAdminLevel) == true) {
        
        String resultField = ContextHelper.getStringSafe(request, "txtSz1lvlAdminRvAppealResult").trim();
        String RsnApprDenial = ContextHelper.getStringSafe(request, "szTxt1lvlAdminRevResAppDen").trim();
        String lglRep = ContextHelper.getStringSafe(request, "rbInd1lvlLglRepresentation");
        String SAAGNtfctn = ContextHelper.getStringSafe(request, "rbInd1lvlSAAGNotification");
        org.exolab.castor.types.Date reqRecDate = ContextHelper.getCastorDateSafe(request, "txtDtDt1lvlAdminRvReqAppeal");
        org.exolab.castor.types.Date reviewDate = ContextHelper.getCastorDateSafe(request, "txtDtDt1lvlAdminRvAppealReview");
        org.exolab.castor.types.Date conductByDate = ContextHelper.getCastorDateSafe(request, "txtDtDt1lvlAdminRvDue");
        org.exolab.castor.types.Date notifDate = ContextHelper.getCastorDateSafe(request, "txtDtDt1lvlAdminRvPersonNoti");
        String disp = ContextHelper.getStringSafe(request, "rbInd1lvlDisp");
        String rsnForDis = ContextHelper.getStringSafe(request, "selSzCd1lvlRsDisg");
        
        
        if ((DateHelper.isBefore(reviewDate, reqRecDate))) {
          setErrorMessage("txtDtDt1lvlAdminRvAppealReview", Messages.MSG_REVIEW_AFTER_REQUEST_DATE);
          result = false;
        }

        if (reqRecDate == null && reviewDate != null) {
          setErrorMessage("txtDtDt1lvlAdminRvAppealReview", Messages.MSG_RQST_RCVD_DT_REQ_RVW);
          result = false;
        }
        if (reqRecDate == null && conductByDate != null) {
          setErrorMessage("txtDtDt1lvlAdminRvDue", Messages.MSG_RQST_RCVD_DT_REQ_CONDUCT);
          result = false;
        }  
        
        
        if(isButtonPressed("btnSaveAndClose") == true) {
          if (notifDate == null) {
            setErrorMessage("txtDtDt1lvlAdminRvPersonNoti", Messages.MSG_PRSN_NTFD_REQ_NOT_RLSE);
            result = false; 
          }
          
          if (lglRep.length() == 0) {
            setErrorMessage(Messages.MSG_ARI_LEGAL_REP_REQ);
            result = false;
          }

          if ("Y".equals(lglRep) && (SAAGNtfctn == null || "N".equals(SAAGNtfctn))) {
            setErrorMessage(Messages.MSG_ARI_LEGAL_NOT_SAAG);
            result = false;
          }
          
          if (reviewDate == null) {
            setErrorMessage("txtDtDt1lvlAdminRvAppealReview", Messages.MSG_RVW_DT_REQ_NOT_RLSE);
            result = false;
          }
          
          if (RsnApprDenial.length() == 0) {
            setErrorMessage("szTxt1lvlAdminRevResAppDen", Messages.MSG_ARI_REASON_REQ);
            result = false;
          }

          if (resultField.length() == 0) {
            setErrorMessage("txtSz1lvlAdminRvAppealResult", Messages.MSG_ARI_RESULT_REQ);
            result = false;
          }
          
          if (disp.length() == 0) {
            setErrorMessage(Messages.MSG_ARI_DISPOSITION);
            result = false;
          } 
          
          if("N".equals(disp) && rsnForDis.length() == 0) {
            setErrorMessage("selSzCd1lvlRsDisg", Messages.MSG_ARI_RSN_DISAGREEMENT);
            result = false;
          }   
          
          if(rsnForDis.length() > 0 && ("N".equals(disp) == false)) {
            setErrorMessage("selSzCd1lvlRsDisg", Messages.MSG_ARI_RSN_DISAG_AGREE);
            result = false;
          }
        }
      }   
      
      //2st level validations
      if("2".equals(indAdminLevel) == true) {
       
        String lglRep = ContextHelper.getStringSafe(request, "rbInd2lvlLglRepresentation");
        String SAAGNtfctn = ContextHelper.getStringSafe(request, "rbInd2lvlSAAGNotification");
        org.exolab.castor.types.Date reqRecDate = ContextHelper.getCastorDateSafe(request, "txtDtDt2lvlAdminRvReqAppeal");
        org.exolab.castor.types.Date reviewDate = ContextHelper.getCastorDateSafe(request, "txtDtDt2lvlAdminRvAppealReview");       
        org.exolab.castor.types.Date conductByDate = ContextHelper.getCastorDateSafe(request, "txtDtDt2lvlAdminRvDue");
        String cb1lvlAdmRv21lvlStage = CheckboxHelper.getCheckboxValue(request, "cb1lvlAdmRv21lvlStage");
        String sel1lvlARIStage = ContextHelper.getStringSafe(request, "sel1lvlARIStage");
        org.exolab.castor.types.Date dec21LetterDate = ContextHelper.getCastorDateSafe(request, "txtDtDt2lvlDecisionLtr");
     
        if ((DateHelper.isBefore(reviewDate, reqRecDate))) {
          setErrorMessage("txtDtDt2lvlAdminRvAppealReview", Messages.MSG_REVIEW_AFTER_REQUEST_DATE);
          result = false;
        }

        if (reqRecDate == null && reviewDate != null) {
          setErrorMessage("txtDtDt2lvlAdminRvAppealReview", Messages.MSG_RQST_RCVD_DT_REQ_RVW);
          result = false;
        }
        if (reqRecDate == null && conductByDate != null) {
          setErrorMessage("txtDtDt2lvlAdminRvDue", Messages.MSG_RQST_RCVD_DT_REQ_CONDUCT);
          result = false;
        }  
        
        boolean firstStageTest = false;
        if (("Y".equals(cb1lvlAdmRv21lvlStage) == true) && (sel1lvlARIStage != null && sel1lvlARIStage.length() > 0)) {
          setErrorMessage("sel1lvlARIStage", Messages.MSG_ARI_FIRST_LEVEL_DES);
          result = false;
          firstStageTest = true;
        }
        
        if(firstStageTest == false && reviewDate != null) {
          if ((cb1lvlAdmRv21lvlStage == null || "N".equals(cb1lvlAdmRv21lvlStage)) && (sel1lvlARIStage == null || sel1lvlARIStage.length() == 0)) {
            setErrorMessage("sel1lvlARIStage", Messages.MSG_ARI_FIRST_LEVEL_REQ);
            result = false;
          }
        }
        
        if ((firstStageTest == false) && (sel1lvlARIStage != null && sel1lvlARIStage.length() > 0)) {
          if(dec21LetterDate == null) {
            setErrorMessage("txtDtDt2lvlDecisionLtr", "Field is required. Please enter a value");
            result = false;
          }
        }
        
        String cb2lvlAdmRv2ndStageComp = CheckboxHelper.getCheckboxValue(request, "cb2lvlAdmRv2ndStageComp");
        if("Y".equals(cb2lvlAdmRv2ndStageComp) == true) {
          
          org.exolab.castor.types.Date notifDate = ContextHelper.getCastorDateSafe(request, "txtDtDt2lvlAdminRvPersonNoti");
          String disp = ContextHelper.getStringSafe(request, "rbInd2lvlDisp");
          String rsnForDis = ContextHelper.getStringSafe(request, "selSzCd2lvlRsDisg");
          String resultField = ContextHelper.getStringSafe(request, "txtSz2lvlAdminRvAppealResult").trim();
          String RsnApprDenial = ContextHelper.getStringSafe(request, "szTxt2lvlAdminRevResAppDen").trim();
          String reviewType = request.getParameter("rbInd2lvlRevType");
          
          
          if(("F".equals(reviewType) || "D".equals(reviewType)) == false) {
            setErrorMessage(Messages.MSG_ARI_SECOND_REV_TYPE);
            result = false; 
          }
          
          if (notifDate == null) {
            setErrorMessage("txtDtDt2lvlAdminRvPersonNoti", Messages.MSG_PRSN_NTFD_REQ_NOT_RLSE);
            result = false; 
          }
          
          if (lglRep.length() == 0) {
            setErrorMessage(Messages.MSG_ARI_LEGAL_REP_REQ);
            result = false;
          }

          if ("Y".equals(lglRep) && (SAAGNtfctn == null || "N".equals(SAAGNtfctn))) {
            setErrorMessage(Messages.MSG_ARI_LEGAL_NOT_SAAG);
            result = false;
          }
          
          if (reviewDate == null) {
            setErrorMessage("txtDtDt2lvlAdminRvAppealReview", Messages.MSG_RVW_DT_REQ_NOT_RLSE);
            result = false;
          }
          
          if (RsnApprDenial.length() == 0) {
            setErrorMessage("szTxt2lvlAdminRevResAppDen", Messages.MSG_ARI_REASON_REQ);
            result = false;
          }

          if (resultField.length() == 0) {
            setErrorMessage("txtSz2lvlAdminRvAppealResult", Messages.MSG_ARI_RESULT_REQ);
            result = false;
          }
          
          if (disp.length() == 0) {
            setErrorMessage(Messages.MSG_ARI_DISPOSITION);
            result = false;
          } 
          
          if("N".equals(disp) && rsnForDis.length() == 0) {
            setErrorMessage("selSzCd2lvlRsDisg", Messages.MSG_ARI_RSN_DISAGREEMENT);
            result = false;
          }   
          
          if(rsnForDis.length() > 0 && ("N".equals(disp) == false)) {
            setErrorMessage("selSzCd2lvlRsDisg", Messages.MSG_ARI_RSN_DISAG_AGREE);
            result = false;
          }
          
          if(isButtonPressed("btnSaveAndClose") == true) {
            org.exolab.castor.types.Date notifDate3 = ContextHelper.getCastorDateSafe(request, "txtDtDt3lvlAdminRvPersonNoti");
            String disp3 = ContextHelper.getStringSafe(request, "rbInd3lvlDisp");
            String rsnForDis3 = ContextHelper.getStringSafe(request, "selSzCd3lvlRsDisg");
            String resultField3 = ContextHelper.getStringSafe(request, "txtSz3lvlAdminRvAppealResult").trim();
            String RsnApprDenial3 = ContextHelper.getStringSafe(request, "szTxt3lvlAdminRevResAppDen").trim();
            org.exolab.castor.types.Date reviewDate3 = ContextHelper.getCastorDateSafe(request, "txtDtDt3lvlAdminRvAppealReview");       
            String fnDes3 = ContextHelper.getStringSafe(request, "rbInd3lvlFinDec");
                                                
            if (notifDate3 == null) {
              setErrorMessage("txtDtDt3lvlAdminRvPersonNoti", Messages.MSG_PRSN_NTFD_REQ_NOT_RLSE);
              result = false; 
            }
            
            if (reviewDate3 == null) {
              setErrorMessage("txtDtDt3lvlAdminRvAppealReview", Messages.MSG_RVW_DT_REQ_NOT_RLSE);
              result = false;
            }
            
            if (RsnApprDenial3.length() == 0) {
              setErrorMessage("szTxt3lvlAdminRevResAppDen", Messages.MSG_ARI_REASON_REQ);
              result = false;
            }

            if (resultField3.length() == 0) {
              setErrorMessage("txtSz3lvlAdminRvAppealResult", Messages.MSG_ARI_RESULT_REQ);
              result = false;
            }
            
            if (disp3.length() == 0) {
              setErrorMessage(Messages.MSG_ARI_DISPOSITION);
              result = false;
            } 
            
            if("N".equals(disp3) && rsnForDis3.length() == 0) {
              setErrorMessage("selSzCd3lvlRsDisg", Messages.MSG_ARI_RSN_DISAGREEMENT);
              result = false;
            }   
            
            if(rsnForDis3.length() > 0 && ("N".equals(disp3) == false)) {
              setErrorMessage("selSzCd3lvlRsDisg", Messages.MSG_ARI_RSN_DISAG_AGREE);
              result = false;
            }
            
            if (fnDes3.length() == 0) {
              setErrorMessage("Final Decision is required to complete the review.");
              result = false;
            } 
            
            if(("N".equals(disp3) && "Y".equals(fnDes3)) || ("Y".equals(disp3) && "N".equals(fnDes3))) {
              setErrorMessage(Messages.MSG_ARI_THIRD_INTEGRITY);
              result = false;
            }   
          }
        }
      }      
    }
      
    return result;
  }
}
