package gov.georgia.dhr.dfcs.sacwis.web.person;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.service.common.Common;
import gov.georgia.dhr.dfcs.sacwis.service.person.Person;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.input.FAPersonDetailRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FAPersonDetailRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.FAPersonDetailSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FAPersonDetailSaveSO;

/**
 * This is a Conversation class to maintain the information specific to household members in a Foster home,
 * Foster/Adoptive home. This information is a supplement to the person data captured on the Person Detail page.
 * 
 * @author lata.p.lokhande
 * 
 * <pre>
 *      &lt;p/&gt;
 *       Change History:
 *        Date      User          Description
 *       --------  --------       --------------------------------------------------
 *       01/26/2007 Lata Lokhande Coded a new Page for Release 2.
 *       02/24/2011 hnguyen       SMS#97850: MR-075 Page date fields are sync and display only.
 *                                Also remove date fields that are calculated and read-only, no
 *                                longer need to save these fields.
 *                           
 * </pre>
 */

public class FAPersonDetailConversation extends BaseHiddenFieldStateConversation {

  private Common common;
  
  private Person person;

  public void setCommon(Common common) {
    this.common = common;
  }

  public void setPerson(Person person) {
    this.person = person;
  }

  public void displayFAPersonDetail_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayFAPersonDetail_xa()");
    performanceTrace.enterScope();

    // define state and request
    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();

    // clear state at the beginning of the conversation
    state.removeAllAttributes(request);

    String pageMode = PersonHelper.getPersonDetailPageMode(request);
    state.setAttribute("PageMode", pageMode, request);

    // -- populate input retrieve object.
    FAPersonDetailRetrieveSI faPersonDetailRetrieveSI = populateFAPersonDetailRetrieveSI(context);
    FAPersonDetailRetrieveSO faPersonDetailRetrieveSO = null;
    try {
      // SMS#97850: MR-075 Sync FA Person Detail date fields before displaying.
      common.syncFaPersonDetailRecordsCheck(faPersonDetailRetrieveSI.getIdPerson());
      common.syncFaPersonDetailHealthDetail(faPersonDetailRetrieveSI.getIdPerson());

      faPersonDetailRetrieveSO = person.retrieveFAPersonDetail(faPersonDetailRetrieveSI);
    } catch (ServiceException se) {
      GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + se.getMessage());
    }
    if (faPersonDetailRetrieveSO != null) {
      // put the output object in state to retriev it on the jsp page.
      state.setAttribute("FAPersonDetailRetrieveSO", faPersonDetailRetrieveSO, request);
    }
    performanceTrace.exitScope();

  }

  public void saveFAPersonDetail_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".saveFAPersonDetail_xa()");
    performanceTrace.enterScope();

    // define state and request
    HttpServletRequest request = context.getRequest();

    FAPersonDetailSaveSI faPersonDetailSaveSI = populateFAPersonDetailSaveSI(context);

    try {
      FAPersonDetailSaveSO faPersonDetailSaveSO = person.saveFAPersonDetail(faPersonDetailSaveSI);
      setInformationalMessage(Messages.MSG_DATABASE_SAVE_SUCCESS, request);

    } catch (ServiceException se) {
      GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + se.getMessage());
    }

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

    displayFAPersonDetail_xa(context);

  }

  private FAPersonDetailRetrieveSI populateFAPersonDetailRetrieveSI(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".populateFAPErsonDetailRetrieveSI");
    performanceTrace.enterScope();
    // Get request and state
    HttpServletRequest request = context.getRequest();

    // get the person id from GlobalData
    int idPerson = GlobalData.getUlIdPerson(request);

    FAPersonDetailRetrieveSI faPersonDetailRetrieveSI = new FAPersonDetailRetrieveSI();

    ArchInputStruct input = new ArchInputStruct();
    // Populate the input object sub-structures from the request,
    input.setBPerfInd(ArchitectureConstants.Y);
    input.setBDataAcsInd(ArchitectureConstants.Y);

    UserProfile user = UserProfileHelper.getUserProfile(request);
    String userId = user.getUserLogonID();
    // int idUser = (new Integer(user.getUserLogonID())).intValue();
    input.setSzUserId(userId);

    faPersonDetailRetrieveSI.setArchInputStruct(input);
    faPersonDetailRetrieveSI.setIdPerson(idPerson);

    return faPersonDetailRetrieveSI;
  }

  private FAPersonDetailSaveSI populateFAPersonDetailSaveSI(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".populateFAPersonDetailSaveSI");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    ArchInputStruct input = new ArchInputStruct();
    // Populate the input object sub-structures from the request,
    input.setBPerfInd(ArchitectureConstants.Y);
    input.setBDataAcsInd(ArchitectureConstants.Y);

    UserProfile user = UserProfileHelper.getUserProfile(context);
    input.setSzUserId(user.getUserLogonID());

    FAPersonDetailSaveSI faPersonDetailSaveSI = new FAPersonDetailSaveSI();

    FAPersonDetailRetrieveSO faPersonDetailRetrieveSO = (FAPersonDetailRetrieveSO) state
                                                                                        .getAttribute(
                                                                                                      "FAPersonDetailRetrieveSO",
                                                                                                      request);

    // get the form input values
    String cbxMedFormReq = CheckboxHelper.getCheckboxValue(request, "cbxMedFormReq");
    Date dtLastUpdate = faPersonDetailRetrieveSO.getDtLastUpdate();

    // populate the save input object
    faPersonDetailSaveSI.setAnnualMedFormRequired(cbxMedFormReq);
    int idPerson = faPersonDetailRetrieveSO.getIdPerson();
    faPersonDetailSaveSI.setIdPerson(idPerson);
    faPersonDetailSaveSI.setArchInputStruct(input);
    faPersonDetailSaveSI.setDtLastUpdate(dtLastUpdate);

    return faPersonDetailSaveSI;

  }

}