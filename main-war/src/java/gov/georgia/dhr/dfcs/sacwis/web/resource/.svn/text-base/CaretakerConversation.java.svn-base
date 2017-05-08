package gov.georgia.dhr.dfcs.sacwis.web.resource;

import java.io.StringReader;
import javax.servlet.http.HttpServletRequest;
import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelper;
import gov.georgia.dhr.dfcs.sacwis.service.resource.Resource;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES18SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES18SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES55DO;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.ValidationException;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;

/**
 * File Name: CaretakerConversation.java Created by: Narasimha Rao 
 * 
 * Date Created: 09/19/2002 
 * <p/> Description: This class is used to perform custom validation on the Caretaker Detail page 
 * 
 * <p/> Change History: 
 *   Date      User              Description
 *   --------  ----------------  ----------------------------------------------- 
 *   02/18/04  Linda Reed        SIR 22625- added txtChildResourceId to pass Home ResourceId. 
 *   09/01/05  Linda Reed        SIR 23777 - split Race out of Ethnicity. Added Save 
 *   04/05/07  Lata Lokhande     Added Retrieve and Save Services for displayCaretakerInformation_xa 
 *                               and & retrieve services saveCaretakerDetail_xa method by replacing 
 *                               CaretakerImpl class and added related helper populate methods. Removed 
 *                               race field and added End Date field.
 *   12/23/08  Abraham Williams  STGAP00010681: Added method findSubcontractor. This method is
 *                               made available such that the CaretakerConversation can pass the
 *                               list of subcontractors to the CaretakerInformation.jsp 
 *   01/02/09 Abraham Williams   STGAP00010681: Removed the changes made above for this defect.
 *                               The change is not needed because the solution design is based 
 *                               on Resource Facility Type (CPA) instead of Service (1202) provided by 
 *                               the Resource (Service/Site Subcontractors).                             
 */

public class CaretakerConversation extends BaseHiddenFieldStateConversation {

  private static final int PAGE_NUMBER = ServiceConstants.INITIAL_PAGE;

  private static final int PAGE_SIZE_NUMBER = 2;

  private static final String SAVE_FUNCTION = ServiceConstants.REQ_FUNC_CD_SAVE;

  public static final String CRES18SO_ATTR_NAME = "CRES18SO";

  private static final String TRACE_TAG = "CaretakerConversation";

  private Resource resource;

  public void setResource(Resource resource) {
    this.resource = resource;
  }

  /**
   * This method retrieves the Caretaker Information based on a resource ID that is passed in the http request that is
   * part of the GrndsExchangeContext
   * 
   * @param GrndsExchangeContext
   *          The context of this page including the http request and other GRNDS information
   * 
   */
  public void displayCaretakerInformation_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayCaretakerInformation_xa()");
    performanceTrace.enterScope();

    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();

    CRES18SO cres18SO = null;

    // populate RetrieveSI object.
    CRES18SI cres18si = populate_CRES18SI_RetrieveSI(context);
    int ulIdResource = GlobalData.getUlIdResource(request);

    try {
      cres18SO = resource.retrieveCaretakerInformation(cres18si);

    } catch (ServiceException we) {
      GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
      if (we.getErrorCode() == Messages.MSG_NO_ROWS_RETURNED) {
        // create an SO object with the known data
        cres18SO = new CRES18SO();
        cres18SO.setSzCpaName(GlobalData.getSzNmResource(request));

        cres18SO.setUlHmResourceId(ulIdResource);
        cres18SO.setUlIdResource(ulIdResource);
      } else {
        GrndsTrace.msg(TRACE_TAG, 7, "Exception in Caretaker Conversation.  About to process severe exception!!");
        processSevereException(context, we);
        return;

      }

    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception in conversation" + e.getMessage());
      processSevereException(context, e);
      return;
    }

    state.setAttribute(CRES18SO_ATTR_NAME, cres18SO, request);
    PageMode.setPageMode(GlobalData.getAppMode(request), request);

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

  }

  /**
   * Helper method to populate RetrieveSI Object (CRES18SI), to pass it to Retrieve Service.
   * 
   * @param context
   * @return CRES18SI
   * 
   */
  private CRES18SI populate_CRES18SI_RetrieveSI(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".populate_CRES18SI_RetrieveSI");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    UserProfile user = UserProfileHelper.getUserProfile(request);

    CRES18SI cres18si = new CRES18SI();

    ArchInputStruct input = new ArchInputStruct();
    input.setSzUserId(user.getUserLogonID());
    input.setCReqFuncCd(SAVE_FUNCTION);
    input.setUsPageNbr(PAGE_NUMBER);
    input.setUlPageSizeNbr(PAGE_SIZE_NUMBER);

    cres18si.setArchInputStruct(input);
    cres18si.setUlIdResource(GlobalData.getUlIdResource(request));

    return cres18si;
  }

  /**
   * This method retrieves the Caretaker Detail based on the array of Caretakers and the index into that array. It then
   * sets the caretaker detail onto the request as an attribute for use by the presentation (jsp).
   * 
   * @param GrndsExchangeContext
   *          The context of this page including the http request and other GRNDS information
   */
  public void displayCaretakerDetail_xa(GrndsExchangeContext context) {
    GrndsTrace.enterScope(TRACE_TAG + ".detailCaretaker_xa");
    HttpServletRequest request = context.getRequest();
    int index = 0;

    String caretakerIndex = request.getParameter("caretakerIndex");
    if (!(StringHelper.EMPTY_STRING.equals(caretakerIndex)) || caretakerIndex != null) {
      index = Integer.parseInt(caretakerIndex);

    }

    ROWCRES55DO caretakerDetail = getCaretakerDetail(context, index);

    request.setAttribute("ROWCRES55DO", caretakerDetail);

    PageMode.setPageMode(GlobalData.getAppMode(request), request);

    GrndsTrace.exitScope();
  }

  /**
   * This method retrieves the Caretaker Detail based on the array of Caretakers and the index into that array.
   * 
   * @param GrndsExchangeContext
   *          The context of this page including the http request and other GRNDS information
   */
  private ROWCRES55DO getCaretakerDetail(GrndsExchangeContext context, int index) {
    GrndsTrace.enterScope(TRACE_TAG + ".getCaretakerDetail");
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    CRES18SO cres18so = (CRES18SO) state.getAttribute(CRES18SO_ATTR_NAME, request);
    ROWCRES55DO caretakerDetail = cres18so.getROWCRES55DO_ARRAY().getROWCRES55DO(index);
    GrndsTrace.exitScope();
    return caretakerDetail;
  }

  /**
   * This save method is saves the Caretaker Detail information by calling saveCaretakerDetail service.
   * 
   * @param GrndsExchangeContext
   */
  public void saveCaretakerDetail_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".saveCaretakerDetail_xa()");
    performanceTrace.enterScope();

    CRES18SO cres18so = null;

    // populate SaveSI object.
    CRES18SI cres18si = populate_CRES18SI_SaveSI(context);

    try {
      cres18so = resource.saveCaretakerDetail(cres18si);
    } catch (ServiceException se) {
      GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + se.getMessage());
    }
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

  }

  /**
   * Helper method for Save method, to populate the SaveSI object, to pass it to saveCaretakerDetail service.
   * 
   * @param context
   * @return CRES18SI
   */
  private CRES18SI populate_CRES18SI_SaveSI(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".populateCRES18SI_SaveSI");
    performanceTrace.enterScope();

    CRES18SI cres18si = new CRES18SI();

    HttpServletRequest request = context.getRequest();
    UserProfile user = UserProfileHelper.getUserProfile(request);

    ArchInputStruct input = new ArchInputStruct();

    input.setSzUserId(user.getUserLogonID());
    input.setCReqFuncCd(request.getParameter("cReqFuncCd"));
    GrndsTrace.msg(TRACE_TAG, 7, request.getParameter("cReqFuncCd"));
    input.setUsPageNbr(PAGE_NUMBER);
    input.setUlPageSizeNbr(PAGE_NUMBER);

    cres18si.setArchInputStruct(input);

    cres18si.setUlIdResource(GlobalData.getUlIdResource(request));

    cres18si.setCdCaretkrEthnic(request.getParameter("selEthnicity"));
    cres18si.setCdCaretkrSex(request.getParameter("selGender"));
    cres18si.setCd_Home_Marital_Status(request.getParameter("selHomeMarital"));
    cres18si.setDtCaretkrBirth(DateHelper.toCastorDateSafe(request.getParameter("txtDateBirth")));

    if (request.getParameter("idCaretaker") != null && !"".equals(request.getParameter("idCaretaker"))) {
      cres18si.setIdCaretaker(Integer.parseInt(request.getParameter("idCaretaker")));
    }
    cres18si.setDtEnd(DateHelper.toCastorDateSafe(request.getParameter("txtDateEnd")));
    cres18si.setSzNmCaretkrFname(FormattingHelper.initCapsName(request.getParameter("txtFirstName")));
    cres18si.setSzNmCaretkrLname(FormattingHelper.initCapsName(request.getParameter("txtLastName")));
    cres18si.setSzNmCaretkrMname(FormattingHelper.initCapsName(request.getParameter("txtMiddleName")));

    return cres18si;

  }

  /**
   * This method removes the Caretaker Information from the http request that is passed on to the presentation (JSP)
   * 
   * @param GrndsExchangeContext
   *          The context of this page including the http request and other GRNDS information
   */
  public void addCaretakerDetail_xa(GrndsExchangeContext context) {
    GrndsTrace.enterScope(TRACE_TAG + ".addCaretaker_xa");
    // request.removeAttribute(GRNDS_QNAME_ATTRIBUTE);
    GrndsTrace.exitScope();
  }

  /**
   * This method deletes the Caretaker Detail based on the selected row and the array of caretakers. It then calls the
   * displayCaretaker_xa to retrieve the updated caretaker information
   * 
   * @param GrndsExchangeContext
   *          The context of this page including the http request and other GRNDS information
   */
  public void deleteCaretaker_xa(GrndsExchangeContext context) {
    GrndsTrace.enterScope(TRACE_TAG + ".deleteCaretaker_xa");
    CRES18SI cres18si = new CRES18SI();
    HttpServletRequest request = context.getRequest();
    ROWCRES55DO row = null;// SR-
    String caretakerIndex = request.getParameter("rbSelectedCaretaker");
    int index = Integer.parseInt(caretakerIndex);
    row = getCaretakerDetail(context, index);
    cres18si.setIdCaretaker(row.getIdCaretaker());
    ArchInputStruct archinputstruct = new ArchInputStruct();
    UserProfile user = UserProfileHelper.getUserProfile(context);
    archinputstruct.setSzUserId(user.getUserLogonID());
    archinputstruct.setCReqFuncCd("D");

    archinputstruct.setUsPageNbr(1);
    archinputstruct.setUlPageSizeNbr(2);
    cres18si.setArchInputStruct(archinputstruct);

    CRES18SO cres18so = null;// SR-
    try {
      // replacing the old call with service.
      // cres18so = CRES18SO.unmarshal(new StringReader(WtcHelper.callService("CRES18S", cres18si)));
      cres18so = resource.caretaker(cres18si);
    }

    catch (ServiceException we) {
      switch (we.getErrorCode()) {
      case Messages.MSG_CMN_TMSTAMP_MISMATCH:
        setErrorMessage(MessageLookup.getMessageByNumber(Messages.MSG_CMN_TMSTAMP_MISMATCH), "/resource/Caretaker/",
                        request);
        break;

      case Messages.MSG_CMN_UPDATE_FAILED:
        setErrorMessage(we.getErrorMessage(), "/resource/Caretaker/", request);
        break;

      default:
        GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
        processSevereException(context, we);
        break;
      }
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception in conversation" + e.getMessage());
      processSevereException(context, e);
    }
    request.removeAttribute(GRNDS_QNAME_ATTRIBUTE);// SR-
    GrndsTrace.exitScope();
  }

  /**
   * This method deletes the Caretaker Detail based on the id of the individual caretaker being displayed. It then calls
   * the displayCaretaker_xa to retrieve the updated caretaker information
   * 
   * @param GrndsExchangeContext
   *          The context of this page including the http request and other GRNDS information
   */
  public void deleteCaretakerDetail_xa(GrndsExchangeContext context) {
    GrndsTrace.enterScope(TRACE_TAG + ".deleteCaretakerdetail_xa");
    CRES18SI cres18si = new CRES18SI();
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    ROWCRES55DO row = null; // SR-

    String caretakerIndex = request.getParameter("caretakerIndex");
    int index = Integer.parseInt(caretakerIndex);
    row = getCaretakerDetail(context, index);

    cres18si.setIdCaretaker(row.getIdCaretaker());
    ArchInputStruct archinputstruct = new ArchInputStruct();
    UserProfile user = UserProfileHelper.getUserProfile(context);
    archinputstruct.setSzUserId(user.getUserLogonID());
    archinputstruct.setCReqFuncCd("D");

    archinputstruct.setUsPageNbr(1);
    archinputstruct.setUlPageSizeNbr(2);
    cres18si.setArchInputStruct(archinputstruct);
    // call cres18s
    CRES18SO cres18so = (CRES18SO) state.getAttribute(CRES18SO_ATTR_NAME, request);
    try {
      cres18so = CRES18SO.unmarshal(new StringReader(WtcHelper.callService("CRES18S", cres18si)));
    } catch (ValidationException ve) {
      GrndsTrace.msg(TRACE_TAG, 7, "Validation Exception " + ve.getMessage());
      processSevereException(context, ve);
    } catch (MarshalException me) {
      GrndsTrace.msg(TRACE_TAG, 7, "Marshal Exception " + me.getMessage());
      processSevereException(context, me);
    } catch (ServiceException we) {
      GrndsTrace.msg(TRACE_TAG, 7, "WTC Exception in conversation" + we.getMessage());
      processSevereException(context, we);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception in conversation" + e.getMessage());
      processSevereException(context, e);
    }

    request.removeAttribute(GRNDS_QNAME_ATTRIBUTE);
    GrndsTrace.exitScope();
  }

}
