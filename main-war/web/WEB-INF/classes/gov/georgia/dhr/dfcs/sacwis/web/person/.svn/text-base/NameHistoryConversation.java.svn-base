package gov.georgia.dhr.dfcs.sacwis.web.person;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.service.person.Person;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV26SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV26SIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV26SIG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SzNmPersonFull_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV25SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV26SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV25SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV25SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.web.core.decorator.IncludeTag;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

/**
 * **************************************************************************** This is the Conversation class used to
 * add or modify a person's name or alias ('a.k.a.') names
 *
 * @author J Heather Dean, December 11, 2002
 *         <p/>
 *         <pre>
 *                 Change History:
 *                  Date      User      Description
 *                  --------  --------  --------------------------------------------------
 *                  07/10/03  GRIMSHAN  SIR 18777 The code was trying to end date old primary
 *                                      row even if  there was not another row, or if there was
 *                                      another row but it was not marked as primare.
 *         <p/>
 *                  09/19/2003 Matthew McClain, SIR 19781, if you make a non-primary row, primary
 *                                      you end-date the old row, and create a new row
 *                                      Refactored, to make it clearer where data is coming from
 *         <p/>
 *                 07/01/05 PINKSTBA      SIR 23727 MPS Phase II.  Replaced WtcException/WtxHelper
 *                                        references with ServiceException/ServiceHelper references.
 *                 ****************************************************************************
 */
public class NameHistoryConversation extends BaseHiddenFieldStateConversation {
  /*****************************************************************************
   * This method is called by the GRNDS controller when a user opens the Name
   * History submodule
   *
   * Code to include this submodule: <impact:include
   * page="/submodule/NameHistorySubmoduleConversation/displayNameHistory"
   * callingPage="/test/NameHistorySubmodTest/display" tabindex="1"
   * includingForm="frmNameHistSub"> <impact:attribute name="intakeIndicator"
   * value=" <%= bIntakeIndicator %>" /> </impact:include>
   *
   * where bIntakeIndicator has been set to a value of 'N' or 'Y'
   *
   * Note: If the intakeIndicator attribute is not included, an error will be
   * displayed.
   *
   * @param context
   *          The GrndsExchangeContext object.
   ****************************************************************************/

  /**
   * ************************************************************************** This method is called by the GRNDS
   * controller when a user opens the Name History submodule
   *
   * @param context The GrndsExchangeContext object. **************************************************************************
   */
  private Person person;

  public void setPerson(Person person) {
    this.person = person;
  }

  public void saveNameHistory_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "saveNameHistory_xa");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    try {
      CINV26SI cinv26si = populateCINV26SI_AU(context);
      //ServiceHelper.callService("CINV26S", cinv26si);
      CINV26SO cinv26so = person.updateNameInformation(cinv26si);
      request.setAttribute("CINV26SO", cinv26so);

      String forwardURI = (String) state.getAttribute(IncludeTag.INCLUDING_PAGE_DISPLAY_COMMAND_KEY, request);

      //Forwards page back to the including page after save
      forward(forwardURI, request, context.getResponse());
    }
    catch (Exception e) {
      handleException(e, context, "saveNameHistory_xa");
    }

    performanceTrace.exitScope();
  }

  /**
   * ************************************************************************** This helper method is called by the
   * saveNameHistory_xa to populate the input object for the cinv26s save service.
   *
   * @param context The GrndeExchangeContext
   * @return CINV26SI **************************************************************************
   */
  private CINV26SI populateCINV26SI_AU(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "populateCINV26SI_AU");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    NameDB nameDB = new NameDB();
    nameDB.setPrimary("on".equals(ContextHelper.getStringSafe(context, "cbxPrimary")));
    nameDB.setInvalid("on".equals(ContextHelper.getStringSafe(context, "cbxInvalid")));
    nameDB.setEndDate(ContextHelper.getCastorDateSafe(request, "dspEndDate"));
    nameDB.setStartDate(ContextHelper.getCastorDateSafe(request, "dspStartDate"));

    //put in a separate block because I don't want these variables
    {
      String newLastName = ContextHelper.getStringSafe(request, "txtNameHistLast");
      nameDB.setLastName(FormattingHelper.changeCase(newLastName));

      String newFirstName = ContextHelper.getStringSafe(request, "txtNameHistFirst");
      nameDB.setFirstName(FormattingHelper.changeCase(newFirstName));

      String newMiddleName = ContextHelper.getStringSafe(request, "txtNameHistMiddle");
      nameDB.setMiddleName(FormattingHelper.changeCase(newMiddleName));

      nameDB.setNameSuffix(ContextHelper.getStringSafe(request, "selNameHistSuffix"));
    }

    ArchInputStruct input = new ArchInputStruct();

    CINV26SI cinv26si = new CINV26SI();
    ROWCINV26SIG00 inputRow = new ROWCINV26SIG00();
    ROWCINV26SIG00_ARRAY inputArray = new ROWCINV26SIG00_ARRAY();

    //THIS ASSUMES YOU CAN'T UPDATE THE PRIMARY NAME AFTER IT'S CREATED
    //Here, if the name is marked primary and not invalid with no end date,
    // then
    //the primary name has changed and the full name will be changed
    boolean primaryHasChanged = false;
    if ((nameDB.getPrimary()) && (nameDB.getInvalid() == false) && (isDateNull(nameDB.getEndDate()))) {
      primaryHasChanged = true;
    }

    String funcCode = ServiceConstants.REQ_FUNC_CD_ADD;
    if (!"true".equals(request.getParameter("isAdd"))) {
      CINV25SO cinv25so = (CINV25SO) state.getAttribute("CINV25SO", request);
      ROWCINV25SOG00_ARRAY rowArray = cinv25so.getROWCINV25SOG00_ARRAY();

      int arrayIndex = ContextHelper.getIntSafe(request, "arrayIndex");
      ROWCINV25SOG00 oldRow = rowArray.getROWCINV25SOG00(arrayIndex);

      //SIR 19781, end date oldRow, create newRow as primary
      if (primaryHasChanged) {
        nameDB.setStartDate(DateHelper.toCastorDate(new Date()));

        ROWCINV26SIG00 inputRow1 = getROWCINV26SIG00(oldRow);
        inputRow1.setDtDtNameEndDate(DateHelper.toCastorDate(new Date()));
        inputRow1.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_UPDATE);
        inputArray.addROWCINV26SIG00(inputRow1);
      } else {
        //only set timestamp, nameId if we aren't creating a new row as primary
        nameDB.setTimestamp(oldRow.getTsLastUpdate());
        nameDB.setNameId(oldRow.getUlIdName());
        funcCode = ServiceConstants.REQ_FUNC_CD_UPDATE;
      }
    }

    //If primary name has changed, the old primary name is end dated and the
    // full name is changed
    if (primaryHasChanged) {
      SzNmPersonFull_ARRAY fullNameArray = new SzNmPersonFull_ARRAY();
      //Add original full name at position zero
      fullNameArray.addSzNmPersonFull(0, GlobalData.getSzNmPersonFull(request));

      String newFullName = FormattingHelper.formatFullName(nameDB.getFirstName(), nameDB.getMiddleName(), nameDB
              .getLastName());

      //Add new full name at position one
      fullNameArray.addSzNmPersonFull(1, newFullName);
      cinv26si.setSzNmPersonFull_ARRAY(fullNameArray);

      CINV25SO cinv25so = (CINV25SO) state.getAttribute("CINV25SO", request);
      if (cinv25so != null) {
        ROWCINV25SOG00_ARRAY rowArray = cinv25so.getROWCINV25SOG00_ARRAY();
        // SIR 18846 Only end date the old primary row, if pne or more rows
        // was in the old array.
        if (rowArray.getROWCINV25SOG00Count() >= 1) {
          // THIS ASSUMES THE FIRST ROW IS THE PRIMARY
          // ROWCINV25SOG00 oldPrimaryRow = rowArray.getROWCINV25SOG00(0);
          for (int i = rowArray.getROWCINV25SOG00Count() - 1; i >= 0; i--) {
            ROWCINV25SOG00 oldPrimaryRow = rowArray.getROWCINV25SOG00(i);
            if (Y.equals(oldPrimaryRow.getBIndNamePrimary())) {
              ROWCINV26SIG00 inputRow1 = getROWCINV26SIG00(oldPrimaryRow);
              inputRow1.setDtDtNameEndDate(DateHelper.toCastorDate(new Date()));
              inputRow1.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_UPDATE);
              inputRow1.setBIndNamePrimary(N);
              inputArray.addROWCINV26SIG00(inputRow1);
            }
          }
        }
      }
    }

    UserProfile userProfile = UserProfileHelper.getUserProfile(request);

    input.setUsPageNbr(1);
    input.setSzUserId(userProfile.getUserLogonID());

    cinv26si.setBSysIndGeneric(N);
    if (userProfile.hasRight(userProfile.SEC_MNTN_PERSON)) {
      cinv26si.setBSysIndGeneric(Y);
    }

    cinv26si.setBSysIndUpdateFullName(primaryHasChanged ? Y : N);
    cinv26si.setSzCdTask(GlobalData.getSzCdTask(request));
    cinv26si.setUlIdStage(GlobalData.getUlIdStage(request));
    //Added for ClientOutbound Interface
    cinv26si.setUlIdEvent(GlobalData.getUlIdEvent(request));
    cinv26si.setUlIdPersonId(userProfile.getUserID());
    
    inputRow.setSzCdNameSuffix(nameDB.getNameSuffix());
    //!!! is this reseting end-dates on invalid names?
    if (nameDB.getInvalid()) {
      inputRow.setDtDtNameEndDate(DateHelper.toCastorDate(new Date()));
    } else {
      inputRow.setDtDtNameEndDate(nameDB.getEndDate());
    }

    inputRow.setUlIdPerson(GlobalData.getUlIdPerson(request));

    inputRow.setUlIdName(nameDB.getNameId());
    inputRow.setDtDtNameStartDate(nameDB.getStartDate());
    inputRow.setBIndNameInvalid(nameDB.getInvalid() ? Y : N);
    inputRow.setBIndNamePrimary(nameDB.getPrimary() ? Y : N);
    inputRow.setSzNmNameFirst(nameDB.getFirstName());
    inputRow.setSzNmNameLast(nameDB.getLastName());
    inputRow.setSzNmNameMiddle(nameDB.getMiddleName());
    inputRow.setTsLastUpdate(nameDB.getTimestamp());

    inputRow.setSzCdScrDataAction(funcCode);

    inputArray.addROWCINV26SIG00(inputRow);
    input.setUlPageSizeNbr(inputArray.getROWCINV26SIG00Count());

    cinv26si.setROWCINV26SIG00_ARRAY(inputArray);
    cinv26si.setArchInputStruct(input);

    performanceTrace.exitScope();
    return cinv26si;
  }

  protected static ROWCINV26SIG00 getROWCINV26SIG00(ROWCINV25SOG00 outputRow) {
    ROWCINV26SIG00 inputRow = new ROWCINV26SIG00();
    inputRow.setBIndNameInvalid(outputRow.getBIndNameInvalid());
    inputRow.setBIndNamePrimary(outputRow.getBIndNamePrimary());
    inputRow.setDtDtNameEndDate(outputRow.getDtDtNameEndDate());
    inputRow.setDtDtNameStartDate(outputRow.getDtDtNameStartDate());
    inputRow.setSzCdNameSuffix(outputRow.getSzCdNameSuffix());
    inputRow.setSzNmNameFirst(outputRow.getSzNmNameFirst());
    inputRow.setSzNmNameLast(outputRow.getSzNmNameLast());
    inputRow.setSzNmNameMiddle(outputRow.getSzNmNameMiddle());
    inputRow.setTsLastUpdate(outputRow.getTsLastUpdate());
    inputRow.setUlIdName(outputRow.getUlIdName());
    inputRow.setUlIdPerson(outputRow.getUlIdPerson());
    inputRow.setSzCdScrDataAction(null);
    return inputRow;
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

          setErrorMessage(Messages.MSG_CMN_NO_PRIMARY_ROW, "/person/NameHistory/displayNameHistoryDetail", context
                  .getRequest());
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
    return date == null || DateHelper.MAX_CASTOR_DATE.equals(date);
  }

  public static final String Y = ArchitectureConstants.Y;
  public static final String N = ArchitectureConstants.N;
  public static final String TRACE_TAG = "NameHistoryConversation";
  public static final String NO_INTAKE_IND_ERROR = "Required attribute missing from Include tag: intakeIndicator";
}
