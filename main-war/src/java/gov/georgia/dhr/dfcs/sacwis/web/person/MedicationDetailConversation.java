package gov.georgia.dhr.dfcs.sacwis.web.person;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.service.person.Person;
import gov.georgia.dhr.dfcs.sacwis.structs.input.MedicationSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.PersonMedicationList;
import gov.georgia.dhr.dfcs.sacwis.structs.output.MedicationRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.web.core.decorator.IncludeTag;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;


/**
 * *************************************************************************** This is the Conversation class used to
 * display add or modify a person's Medication info
 *
 * @author Vishala Devarakonda, September 13, 2006
 *         <p/>
 *         Change History: Date User Description --------------------------------------------------
 *         <p/>
 *         ****************************************************************************
 */
@SuppressWarnings("serial")
public class MedicationDetailConversation extends BaseHiddenFieldStateConversation {

  /**
   * ************************************************************************** This method is called by the GRNDS
   * controller when a user clicks on the Save Button on the Medication Detail page
   *
   * @param context The GrndsExchangeContext object. **************************************************************************
   */
  private Person person;

  private static final String TRUE = "true";

  public static final String TRACE_TAG = "MedicationDetailConversation";

  public static final String NO_INTAKE_IND_ERROR = "Required attribute missing from Include tag: intakeIndicator";

  public void setPerson(Person person) {
    this.person = person;
  }

  @SuppressWarnings("unchecked")
  public void displayMedicationDetail_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "displayMedicationDetail_xa");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    List<PersonMedicationList> rowArray = null;
    PersonMedicationList selectedMedication = new PersonMedicationList();
    String isAdd = "";
    int arrayIndex = ContextHelper.getIntSafe(request, "medicationIndex");

    try {
      MedicationRetrieveSO medicationRetrieveSO = (MedicationRetrieveSO) state.getAttribute("MedicationRetrieveSO",
                                                                                            request);
      if (medicationRetrieveSO != null) {
        rowArray = (List) medicationRetrieveSO.getPmBeanList();
        if (request.getParameter("isAddMedication") != null) {
          isAdd = (String) request.getParameter("isAddMedication");
          if (!(TRUE.equals(isAdd))) {
            selectedMedication = rowArray.get(arrayIndex);
          }
        }

        state.setAttribute("PersonMedicationList", selectedMedication, request);
      }
    } catch (Exception e) {
      handleException(e, context, "displayMedicationDetail_xa");
    }

    performanceTrace.exitScope();
  }

  public void saveMedicationDetail_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "saveMedicationDetail_xa");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    try {
      MedicationSaveSI medicationSaveSI = populateMedicationSaveSI_AU(context);
      Date endDate =DateHelper.toJavaDate(ContextHelper.getStringSafe(request, "hdnMedEndDate"));
      medicationSaveSI.setEndDate(endDate);
      person.updateMedicationInformation(medicationSaveSI);
      request.setAttribute("MedicationSaveSI", medicationSaveSI);

      String forwardURI = (String) state.getAttribute(IncludeTag.INCLUDING_PAGE_DISPLAY_COMMAND_KEY, request);

      // Forwards page back to the including page after save
      forward(forwardURI, request, context.getResponse());
    } catch (Exception e) {
      handleException(e, context, "saveMedicationDetail_xa");
    }

    performanceTrace.exitScope();
  }

  /**
   * This helper method is called by the saveMedicationDetail_xa to populate the input object for the MedicationSaveS
   * save service.
   *
   * @param context GrndeExchangeContext
   * @return CINV26SI
   * @throws ParseException
   * @throws ParseException
   */
  private MedicationSaveSI populateMedicationSaveSI_AU(GrndsExchangeContext context)
          throws ServiceException, ParseException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "populateMedicationSaveSI_AU");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    PersonMedicationList pmBean = new PersonMedicationList();
    String endDate = ContextHelper.getStringSafe(request, "szDtMedctnEndDate");

    pmBean.setLdNmMedctn(ContextHelper.getStringSafe(request, "szNmMedctn"));
    pmBean.setLdCdMedctnDose(ContextHelper.getStringSafe(request, "szCdMedctnDose"));
    pmBean.setLdTxtMedctnReason(ContextHelper.getStringSafe(request, "szTxtMedctnReason"));
    pmBean.setLdTxtMedctnAdminPerson(ContextHelper.getStringSafe(request, "szTxtMedctnAdminPerson"));
    pmBean.setSzTxtPrescribingPerson(ContextHelper.getStringSafe(request, "szTxtPrescribingPerson"));
    pmBean.setLdDtMedctnPresc(DateHelper.toJavaDate(ContextHelper.getStringSafe(request, "szDtMedctnPresc")));
    if(!(endDate.equals(null)|| endDate.equals("")))
    {
      pmBean.setLdDtMedctnEndDate(DateHelper.toJavaDate(ContextHelper.getStringSafe(request, "szDtMedctnEndDate")));
    }
    pmBean.setLdIndMedctnAllergies(ContextHelper.getStringSafe(context, "szIndMedctnAllergies"));
    pmBean.setLdTxtMedctnDescrip(ContextHelper.getStringSafe(request, "szTxtMedctnDescrip"));
    pmBean.setLdTxtMedctnCmnts(ContextHelper.getStringSafe(request, "szTxtMedctnCmnts"));

    int arrayIndex = ContextHelper.getIntSafe(request, "medicationIndex");
    MedicationRetrieveSO medicationRetrieveSO = (MedicationRetrieveSO) state.getAttribute("MedicationRetrieveSO",
                                                                                          request);
    int idMedication = 0;

    if (!TRUE.equals(request.getParameter("isAddMedication"))) {
      PersonMedicationList pmBean1 = (PersonMedicationList) medicationRetrieveSO.getPmBeanList().get(arrayIndex);
      idMedication = pmBean1.getIdMedication();
    }

    MedicationSaveSI medicationSaveSI = new MedicationSaveSI();
    String funcCode = ServiceConstants.REQ_FUNC_CD_ADD;

    if (!TRUE.equals(request.getParameter("isAddMedication"))) {
      funcCode = ServiceConstants.REQ_FUNC_CD_UPDATE;
    }

    pmBean.setLdAddLine1(ContextHelper.getStringSafe(request, "szAddLine1"));
    pmBean.setLdAddLine2(ContextHelper.getStringSafe(request, "szAddLine2"));
    pmBean.setLdCity(ContextHelper.getStringSafe(request, "szCity"));
    
    String phoneNumber = ContextHelper.getStringSafe(request, "szPhoneNumber");
    
    if(!"".equals(phoneNumber) && phoneNumber != null){      
      pmBean.setLdPhoneNumber(FormattingHelper.decodeFormattedPhoneString(phoneNumber));      
    }
        
    pmBean.setLdState1(ContextHelper.getStringSafe(request, "szState"));
    String zip5 = ContextHelper.getStringSafe(request, "txtZip5");
    String zip4 = ContextHelper.getStringSafe(request, "txtZip4");
    pmBean.setLdZip(zip5+zip4);
    pmBean.setLdPharmacy(ContextHelper.getStringSafe(request, "szNmPharamacy"));
    
    medicationSaveSI.setUlIdPerson(GlobalData.getUlIdPerson(request));
    pmBean.setIdMedication(idMedication);
    pmBean.setCdScrDataAction(funcCode);
    medicationSaveSI.setPmList(pmBean);
    performanceTrace.exitScope();
    return medicationSaveSI;
  }

  /**
   * ************************************************************************** This method is called by the other
   * methods when an exception is caught.
   *
   * @param context    The GrndsExchangeContext object.
   * @param e          The Exception
   * @param methodName A String containing the method which threw the exception **************************************************************************
   */
  protected void handleException(Exception e, GrndsExchangeContext context, String methodName) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "handleError");
    performanceTrace.enterScope();

    if (e instanceof ServiceException) {
      ServiceException we = (ServiceException) e;

      switch (we.getErrorCode()) {
        case Messages.MSG_CMN_TMSTAMP_MISMATCH:
        case Messages.MSG_SYS_EVENT_STS_MSMTCH:
        case Messages.MSG_SYS_STAGE_CLOSED:
        case Messages.MSG_CMN_NO_PRIMARY_ROW:
          this.setPresentationBranch("error", context);
          setErrorMessage(Messages.MSG_CMN_NO_PRIMARY_ROW, "/person/Medication/displayMedicationDetail",
                          context.getRequest());
          break;

        default:
          GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
          processSevereException(context, we);
          break;
      }
    } else {
      processSevereException(context, e);
    }

    performanceTrace.exitScope();
  }

  protected static boolean isDateNull(org.exolab.castor.types.Date date) {
    return date == null;
  }
}
