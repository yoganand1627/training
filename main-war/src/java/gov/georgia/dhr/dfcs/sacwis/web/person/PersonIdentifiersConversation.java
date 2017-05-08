/**
 * User: mkw
 * Date: Dec 9, 2002
 */

package gov.georgia.dhr.dfcs.sacwis.web.person;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean;
import gov.georgia.dhr.dfcs.sacwis.dao.person.RaceEthnicityBean;
import gov.georgia.dhr.dfcs.sacwis.service.person.Person;
import gov.georgia.dhr.dfcs.sacwis.service.person.RetrievePersonIdentifiers;
import gov.georgia.dhr.dfcs.sacwis.service.ws.WS;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN42SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT19SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT23SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV04SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV25SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CrsAuditSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CrsRegistrationSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CrsScreeningSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.PersonIdInStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN42SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT14WLB;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT14WLB_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT19SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SOG03;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SOG03_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SOG04;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SOG04_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV25SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CrsRegistrationSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CrsScreeningSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN42SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN42SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV25SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.web.core.base.ValueBeanHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.SortedSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

/**
 * PersonIdentifiers Conversation Class
 * <p>
 * This conversation is used to display person identifiers information; while it does not display a list directly, it
 * uses the entire list of person identifiers, so it contains the logic to call CINT19S that is also used by its
 * subclass to get display the full list of person identifiers.
 * </p>
 * <p>
 * Copyright: Copyright (c) 2002
 * </p>
 * <p>
 * Company: Accenture
 * </p>
 *
 * @author Michael Werle
 * @version 1.0
 *
 * <pre>
 *   Change History:
 *   Date      User          Description
 *   --------  ------------  --------------------------------------------------
 *   07/11/05  Merle A Demo  Added IndValidateByInterface for Sir23446, It shows when and SSN was 
 *                           validated by the interface.   
 *   10/31/08  alwilliams    STGAP00007484 - Updated method getUpdateCINT14WLB to exclude the end dated
 *                           CINT14WLB objects from the set of CINT14WLB objects that had the same type. If the 
 *                           resulting set is empty the method return a null object. If resulting set is not empty then
 *                           the method returns the object.. 
 *  3/25/09    cwells        STGAP00012545 - Leaving the SSN number as a string so the leading 0's are not 
 *                           lost by converting it to an Integer.                           
 *                           
 *                           
 * </pre>
 e.
 */

/**
 */
public class PersonIdentifiersConversation extends BaseHiddenFieldStateConversation {
  public static final String TRACE_TAG = "PersonIdentifiersConversation";

  public static final String PAGE_MODE_KEY = TRACE_TAG + ".PAGE_MODE_KEY";

  public static final String CINT14WLB_ARRAY_KEY = "cint14wlb_array";

  public static final String INTAKE_MODE_KEY = "INTAKE_MODE_KEY";

  public static final String INTAKE_MODE = "Y";

  public static final String NOT_INTAKE_MODE = "N";

  public static final int PAGE_NUMBER = 1;

  public static final int PAGE_SIZE_NUMBER = 65;

  // Sir23446
  public static final String VERIFIED_DHS = "VERIFIED_DHS";

  public static final String VERIFIED_DHS_COMMENT = "SSA verified via DHS RECEIVE Interface";
  
  public static final String ALLOW_MULT_CATEGORY="CNUMMULT";
  
  private Person person;

  private WS ws;

  public void setPerson(Person person) {
    this.person = person;
  }

  public void setWS(WS ws) {
    this.ws = ws;
  }

  /**
   * This method is used to display the detail of a person identifier. It uses preserveRequestData to do the bulk of its
   * work, which consists of calling CINT19S again to get the most current data for display (which should minimize
   * timestamp mismatch exceptions) and setting data from CINT19S into the request, as well as preserving the idpersonid
   * of the person identifier that we are interested in displaying.
   *
   * @param context
   */
  public void displayPersonIdDetail_xa(GrndsExchangeContext context) {
    // Turn on the performance tracing
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayPersonIdDetail_xa()");
    performanceTrace.enterScope();
    GrndsTrace.enterScope(TRACE_TAG + ".displayPersonIdDetail_xa()");
    HttpServletRequest request = context.getRequest();

    // Used to preserve the including page display command cint14wlb_array object,
    // the current ulIdPersonId, and the current cint14wlb object, as available
    preserveRequestData(context);

    GrndsTrace.exitScope();
    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  /**
   * This is used to preserve the including page display command, the cint14wlb_array object, the hdnUlIdPersonId value,
   * and the current cint14wlb object to which the hdnUlIdPersonId points. It calls CINT19S to ensure that it has the
   * most current copy of the relevant person identifiers data and minimize timestamp mismatch errors. <p/> Note that,
   * because of the service call, "preserve" is perhaps a misnomer -- it preserves the information needed to handle the
   * fact that it is a list-detail submodule, but the data being edited or added is based on a list that is refreshed
   * from the database on each request. The only part of the person identifers information that it truly "preserved" is
   * the idpersonid of the person identifier being edited. If this is 0, then we are adding a new person identifier.
   *
   * @param context the current <code>GrndsExchangeContext</code>
   */
  private void preserveRequestData(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();

    // preserve the including page display command
    BaseSessionStateManager state = getSessionStateManager(context);
    CINV04SI cinv04si = populateCINV04SI_Retrieve(context);
    CINV04SO cinv04so = person.retrievePersonDetail(cinv04si);
    state.setAttribute("CINV04SO", cinv04so, request);

    org.exolab.castor.types.Date dob = ContextHelper.getCastorDateSafe(context, "txtDtDtPersonBirth");
    if(dob!=null){
      request.setAttribute("txtDtDtPersonBirth", dob.toLong());
    }
    

    String addrCounty = ContextHelper.getStringSafe(context, "cboSzCdAddrCounty");
    request.setAttribute("cboSzCdAddrCounty", addrCounty);

    //String ssn = ContextHelper.getSSNSafe(context, "txtSzSysTxtGenericSSN");
    //request.setAttribute("txtSzSysTxtGenericSSN", ssn);

    String includingPageDisplayCommand = ContextHelper.getStringSafe(request, "hdnIncludingPageDisplayCommand");
    request.setAttribute("includingPageDisplayCommand", includingPageDisplayCommand);

    // callCINT14S to get cint14wlb_array for the most current data
    gov.georgia.dhr.dfcs.sacwis.structs.output.CINT14WLB_ARRAY cint14wlb_array = getCINT14WLB_ARRAY(context, person);

    // if hdnUlIdPersonId is greater than 0, we are editing an existing one,
    // which means that there's an array we can pull it out of
    int ulIdPersonId = ContextHelper.getIntSafe(request, "hdnUlIdPersonId");
    request.setAttribute("idPersonId", String.valueOf(ulIdPersonId));
    gov.georgia.dhr.dfcs.sacwis.structs.output.CINT14WLB currentCint14wlb = null;
    if (ulIdPersonId > 0) {
      // get the cint14wlb being edited and put it in the request
      currentCint14wlb = getCINT14WLBByUlIdPersonId(ulIdPersonId, cint14wlb_array);
    } else if (ulIdPersonId == 0) {
      // Added this code to test CRS
      currentCint14wlb = (CINT14WLB) state.getAttribute("cint14wlb", request);
    }

    state.setAttribute("cint14wlb", currentCint14wlb, request);

    // create the existingTypes attribute
    setExistingTypesAttribute(cint14wlb_array, currentCint14wlb, request);
  }

  /**
   * This method sets an attribute called "existingTypes" into the request that is used to create a javascript array on
   * the PersonIdentifiersDetail.jsp page. This array contains the types of all person id's without end dates and is
   * used by the javascript on the page to warn the user that the old identifier will be end-dated if the user has
   * entered a new identifier of the same type.
   *
   * @param cint14wlb_array
   * @param currentCint14wlb
   * @param request
   */
  private void setExistingTypesAttribute(gov.georgia.dhr.dfcs.sacwis.structs.output.CINT14WLB_ARRAY cint14wlb_array,
                                         gov.georgia.dhr.dfcs.sacwis.structs.output.CINT14WLB currentCint14wlb,
                                         HttpServletRequest request) {
    StringBuffer existingTypes = new StringBuffer();
    for (int i = 0; i < cint14wlb_array.getCINT14WLBCount(); i++) {
      gov.georgia.dhr.dfcs.sacwis.structs.output.CINT14WLB cint14wlb = cint14wlb_array.getCINT14WLB(i);
      if (cint14wlb.getDtPersonIDEnd() == null) {
        // do not add the type of the one that we are editing (null check in case we are adding instead of editing)
        // STGAP00006035: Some Id Types we DO now allow multiples of, so don't include those in this list
        if (allowMultiples(cint14wlb.getSzCdPersonIdType())==false && (currentCint14wlb == null
            || !(currentCint14wlb.getSzCdPersonIdType().equals(cint14wlb.getSzCdPersonIdType()) && comparePersonIds(
                currentCint14wlb
                        .getSzCdPersonIdType(),
                currentCint14wlb
                        .getSzNbrPersonIdNumber(),
                cint14wlb
                        .getSzNbrPersonIdNumber())))) {
          String type = cint14wlb.getSzCdPersonIdType();
          // need to escape all occurances of single-quote (ascii code 27)
          int quoteLoc = type.indexOf(0x27);
          while (quoteLoc >= 0) {
            type = type.substring(0, quoteLoc) + "\\" + type.substring(quoteLoc, type.length());
            quoteLoc = type.length() >= quoteLoc + 2 ? type.indexOf(0x27, quoteLoc + 2) : -1;
          }
          existingTypes.append("'").append(type).append("', ");
        }
      }
    }
    int existingTypesLength = existingTypes.length();
    request.setAttribute("existingTypes", existingTypesLength > 2 ? existingTypes.substring(0, existingTypesLength - 2)
                                          : "");
  }

  /**
   * This is the activity method that is called when a user clicks on add under the list of the submodule. It is part of
   * the main conversation even though the button appears in the submodule because it displays the detail page, which
   * has its own page.
   *
   * @param context
   */
  public void addPersonIdDetail_xa(GrndsExchangeContext context) {
    // Turn on the performance tracing
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".addPersonIdDetail_xa()");
    performanceTrace.enterScope();
    GrndsTrace.enterScope(TRACE_TAG + ".addPersonIdDetail_xa()");
    HttpServletRequest request = context.getRequest();
    GlobalData.setSzCdTask("A", request);

    // Used to preserve the including page display command cint14wlb_array object
    preserveRequestData(context);

    GrndsTrace.exitScope();
    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  /**
   * This method uses cint23s to save changes and additions to person identifiers. It must recall cint19s in order to
   * get the list of current person identifiers because we need to check to see if anyone has updated the list of
   * identifiers underneath us to ensure that there were no changes that would invalidate the changes that we are making
   * (e.g. if another person added an identifer of the same type just before, it is end-dated and the new one is
   * added).
   *
   * @param context The <code>GrndsExchangeContext</code> associated with the request.
   */
  public void savePersonIdDetail_xa(GrndsExchangeContext context) {
    // Turn on the performance tracing
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".savePersonIdDetail_xa()");
    performanceTrace.enterScope();
    GrndsTrace.enterScope(TRACE_TAG + ".savePersonIdDetail_xa()");
    HttpServletRequest request = context.getRequest();

    // get the object that is populated on the form in its current state // Identifier Displayed
    gov.georgia.dhr.dfcs.sacwis.structs.input.CINT14WLB inputCint14wlb = populateInputCINT14WLB_save(request);

    // get the array of current identifiers // All of Existing Idendifiers
    gov.georgia.dhr.dfcs.sacwis.structs.output.CINT14WLB_ARRAY outputCint14wlb_array = getCINT14WLB_ARRAY(context,
                                                                                                          person);

    // get the CINT14WLB object that needs to be updated, if it exists // Existing identifier not end dated
    gov.georgia.dhr.dfcs.sacwis.structs.input.CINT14WLB updateCint14wlb = getUpdateCINT14WLB(outputCint14wlb_array,
                                                                                             inputCint14wlb, request);

    // populate the CINT1WLB_ARRAY object; it contains the actual add/update data //
    gov.georgia.dhr.dfcs.sacwis.structs.input.CINT14WLB_ARRAY inputCint14wlb_array = populateCINT14WLB_ARRAY(
            updateCint14wlb,
            inputCint14wlb,
            request);

    UserProfile user = UserProfileHelper.getUserProfile(context);
    ArchInputStruct archInputStruct = new ArchInputStruct();
    archInputStruct.setSzUserId(user.getUserLogonID());

    // not sure why this is set, but it seems to need to be set to tell the service how many rows to update, maybe?
    archInputStruct.setUlPageSizeNbr(inputCint14wlb_array.getCINT14WLBCount());
    archInputStruct.setSzUserId(UserProfileHelper.getUserProfile(request).getUserLogonID());

    CINT23SI cint23si = new CINT23SI();
    cint23si.setArchInputStruct(archInputStruct);
    cint23si.setSzCdTask(GlobalData.getSzCdTask(request));
    cint23si.setUlIdStage(GlobalData.getUlIdStage(request));
    /* SIR #17412: adding an end-dated SSN, the previous SSN should be untouched. */
    if (inputCint14wlb_array.getCINT14WLB() != null) {
      boolean bDataAction = inputCint14wlb_array.getCINT14WLB(0).getSzCdScrDataAction().compareToIgnoreCase("A") == 0;
      boolean bIdTypeIsSSN = inputCint14wlb_array.getCINT14WLB(0).getSzCdPersonIdType().compareToIgnoreCase("SSN") == 0;
      int iCount = inputCint14wlb_array.getCINT14WLBCount();
      org.exolab.castor.types.Date endDate = inputCint14wlb_array.getCINT14WLB(0).getDtPersonIDEnd();
      if (bDataAction && iCount > 1) {
        if (endDate!= null &&  ((DateHelper.isToday(endDate)) && bIdTypeIsSSN)) {
          inputCint14wlb_array.getCINT14WLB(1).setDtPersonIDEnd(null);
        }
      }
    }
    // Adding Clientoutbound id_initiator to UlIdPersonId
    cint23si.setUlIdPersonId(user.getUserID());
    cint23si.setCINT14WLB_ARRAY(inputCint14wlb_array);
    if("A".equals(GlobalData.getSzCdTask(request))){
      cint23si.setSzCdTask("A");
    }else{
      cint23si.setSzCdTask("U");
    }
    String includingPageDisplayCommand = ContextHelper.getString(request, "hdnIncludingPageDisplayCommand");
    String forwardURL = null;
    try {
      // ServiceHelper.callService("CINT23S", cint23si);
      person.savePersonIdentifiers(cint23si);
      GlobalData.setSzCdTask("", request);
      forwardURL = includingPageDisplayCommand;
    } catch (ServiceException we) {
      switch (we.getErrorCode()) {
        case Messages.SQL_NOT_FOUND:
          // This happends when we try to update something that was updated while we were modifying it or when we try
          // to do a reload after save. We go to the previous URL, as it will always be display of the person
          // identifiers detail page.
          forwardURL = ContextHelper.getPreviousUrl(request);
          setInformationalMessage(MessageLookup.getMessageByNumber(Messages.MSG_CMN_TMSTAMP_MISMATCH), forwardURL,
                                  request);
          // preserve the request data, so we can redisplay
          preserveRequestData(context);
          break;
        default:
          processSevereException(context, we);
          break;
      }
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure:" + e.getMessage());
      processSevereException(context, e);
    }

    // always forward
    try {
      forward(forwardURL, request, context.getResponse());
    } catch (ServletException e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Failed to foward to ' " + forwardURL + "':" + e.getMessage());
      processSevereException(context, e);
    }

    GrndsTrace.exitScope();
    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  /**
   * This populates the input object to CINT14S, which is used to add and update person identifiers. It is passed two
   * objects in order to support adding an identier of an existing type; in that case, we need to end-date the old
   * identifier at the same time that we create the new one. There are three main cases in this method: <ol>
   * <li>updateCint14wlb is null, meaning that we only need do an add </li> <li>updateCint14wlb is not null and its id
   * matches the id of inputCint14wlb, meaning that we do a normal update</li> <li>updateCint14wlb is not null and its
   * id does not match the id of inputCint14wlb, meaning that we need to both update and end-date the old one</li>
   * </ol>
   *
   * @param updateCint14wlb
   * @param inputCint14wlb
   * @param request
   * @return
   */
  private gov.georgia.dhr.dfcs.sacwis.structs.input.CINT14WLB_ARRAY populateCINT14WLB_ARRAY(
          gov.georgia.dhr.dfcs.sacwis.structs.input.CINT14WLB updateCint14wlb,
          gov.georgia.dhr.dfcs.sacwis.structs.input.CINT14WLB inputCint14wlb,
          HttpServletRequest request) {
    gov.georgia.dhr.dfcs.sacwis.structs.input.CINT14WLB_ARRAY inputCint14wlb_array =
            new gov.georgia.dhr.dfcs.sacwis.structs.input.CINT14WLB_ARRAY();
    // if updateCint14wlb is null, we just need to add a new one
    if (updateCint14wlb == null) {
      // the id of the person being affected
      inputCint14wlb.setUlIdPerson(GlobalData.getUlIdPerson(request));
      inputCint14wlb.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_ADD);
      inputCint14wlb_array.addCINT14WLB(inputCint14wlb);
    }
    // else if updateCint14wlb is not null, and the number is the same, we just need to update
    else if (comparePersonIds(inputCint14wlb.getSzCdPersonIdType(), inputCint14wlb.getSzNbrPersonIdNumber(),
                              updateCint14wlb.getSzNbrPersonIdNumber())) {
      // we only need the 2 id fields from the update one
      // the id of the person being affected
      inputCint14wlb.setUlIdPerson(updateCint14wlb.getUlIdPerson());
      // the id of the person identifier itself
      inputCint14wlb.setUlIdPersonId(updateCint14wlb.getUlIdPersonId());
      
      inputCint14wlb.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_UPDATE);
      inputCint14wlb_array.addCINT14WLB(inputCint14wlb);
    }
    // else we need to end-date the old one (updateCint14wlb) AND add a new one
    else {
      // matching caps window code, the add should go before the update in the array
      // the id of the person being affected
      inputCint14wlb.setUlIdPerson(updateCint14wlb.getUlIdPerson());
      inputCint14wlb.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_ADD);
      inputCint14wlb_array.addCINT14WLB(inputCint14wlb);
      // end date the one being udpated
      // STGAP00006035: Do not end date the old one if multiples are allowed
      if (allowMultiples(updateCint14wlb.getSzCdPersonIdType())==false) {
        updateCint14wlb.setDtPersonIDEnd(DateHelper.getTodayCastorDate());
        updateCint14wlb.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_UPDATE);
        inputCint14wlb_array.addCINT14WLB(updateCint14wlb);
      }
    }
    return inputCint14wlb_array;
  }

  /**
   * This returns the cint14wlb object from a cint14wlb_array if it exists in the array using the idpersonid as an
   * index; if no cint14wlb object with the specificed idpersonid exists, it returns null.
   *
   * @param idPersonId
   * @param cint14wlb_array
   * @return
   */
  public static gov.georgia.dhr.dfcs.sacwis.structs.output.CINT14WLB getCINT14WLBByUlIdPersonId(
          int idPersonId,
          gov.georgia.dhr.dfcs.sacwis.structs.output.CINT14WLB_ARRAY cint14wlb_array) {
    Enumeration enumeration = cint14wlb_array.enumerateCINT14WLB();
    gov.georgia.dhr.dfcs.sacwis.structs.output.CINT14WLB returnCint14wlb = null;
    while (enumeration.hasMoreElements()) {
      gov.georgia.dhr.dfcs.sacwis.structs.output.CINT14WLB cint14wlb =
              (gov.georgia.dhr.dfcs.sacwis.structs.output.CINT14WLB) enumeration.nextElement();
      if (cint14wlb.getUlIdPersonId() == idPersonId) {
        returnCint14wlb = cint14wlb;
        break;
      }
    }
    return returnCint14wlb;
  }

  /**
   * This checks to see if there is a CINT14WLB object in the CINT14WLB_ARRAY that matches the type that was entered and
   * has no end date. If one is found that matches these conditions, it returns an input CINT14WLB object so that the
   * save method can end date the existing one; if no match is found, it returns null.
   *
   * @param outputCint14wlb_array
   * @param inputCint14wlb
   * @return
   */
  private gov.georgia.dhr.dfcs.sacwis.structs.input.CINT14WLB getUpdateCINT14WLB(
          gov.georgia.dhr.dfcs.sacwis.structs.output.CINT14WLB_ARRAY outputCint14wlb_array,
          gov.georgia.dhr.dfcs.sacwis.structs.input.CINT14WLB inputCint14wlb,
          HttpServletRequest request) {
    gov.georgia.dhr.dfcs.sacwis.structs.output.CINT14WLB outputCint14wlb;
    // if hdnIsNew is false, look for one in the array that has the same ulIdPersonId, as that is a unique identifier
    if (!ContextHelper.getBooleanSafe(request, "hdnIsNew")) {
      outputCint14wlb = getCINT14WLBByUlIdPersonId(inputCint14wlb.getUlIdPersonId(), outputCint14wlb_array);
    } else {
      // Create a sorted set that sorts CINT14WLB objects by End Date
      SortedSet<gov.georgia.dhr.dfcs.sacwis.structs.output.CINT14WLB> cint14wlbSet =
              new TreeSet<gov.georgia.dhr.dfcs.sacwis.structs.output.CINT14WLB>(
                      new Comparator<gov.georgia.dhr.dfcs.sacwis.structs.output.CINT14WLB>() {
                        public int compare(gov.georgia.dhr.dfcs.sacwis.structs.output.CINT14WLB cint14wlb1,
                                           gov.georgia.dhr.dfcs.sacwis.structs.output.CINT14WLB cint14wlb2) {
                          // compare the dates of the CINT14WLB objects; use the MAX_CASTOR_DATE date if the date is null
                          org.exolab.castor.types.Date date1 = cint14wlb1.getDtPersonIDEnd();
                          date1 = date1 != null ? date1 : DateHelper.MAX_CASTOR_DATE;
                          org.exolab.castor.types.Date date2 = cint14wlb2.getDtPersonIDEnd();
                          date2 = date2 != null ? date2 : DateHelper.MAX_CASTOR_DATE;
                          return date1.compareTo(date2);
                        }
                      });
      Enumeration enumeration = outputCint14wlb_array.enumerateCINT14WLB();
      while (enumeration.hasMoreElements()) {
        // Add the ones of the same type to a SortedSet so we can get the last one;
        outputCint14wlb = (gov.georgia.dhr.dfcs.sacwis.structs.output.CINT14WLB) enumeration.nextElement();
        if (outputCint14wlb.getSzCdPersonIdType().equals(inputCint14wlb.getSzCdPersonIdType())) {
          // STGAP00007484 - Add the active (not end dated) CINT14WLB object to the set
          if ((outputCint14wlb.getDtPersonIDEnd() == null) || 
              (outputCint14wlb.getDtPersonIDEnd() == DateHelper.MAX_CASTOR_DATE)) {
            cint14wlbSet.add(outputCint14wlb);
          }
        }
      }
      // this works because MAX_CASTOR_DATE is after all other dates
      //noinspection AssignmentToNull
      outputCint14wlb = cint14wlbSet.isEmpty() ? null : cint14wlbSet.last();
    }

    // if we got an existing object, using either method, we need to make an input value
    gov.georgia.dhr.dfcs.sacwis.structs.input.CINT14WLB updateCint14wlb = null;
    if (outputCint14wlb != null) {
      updateCint14wlb = new gov.georgia.dhr.dfcs.sacwis.structs.input.CINT14WLB();
      updateCint14wlb.setSzCdPersonIdType(outputCint14wlb.getSzCdPersonIdType());
      updateCint14wlb.setSzNbrPersonIdNumber(outputCint14wlb.getSzNbrPersonIdNumber());
      updateCint14wlb.setDtPersonIDEnd(outputCint14wlb.getDtPersonIDEnd());
      updateCint14wlb.setDtPersonIDStart(outputCint14wlb.getDtPersonIDStart());
      updateCint14wlb.setSzDescPersonID(outputCint14wlb.getSzDescPersonID());
      updateCint14wlb.setBIndPersonIDInvalid(outputCint14wlb.getBIndPersonIDInvalid());
      updateCint14wlb.setUlIdPerson(outputCint14wlb.getUlIdPerson());
      updateCint14wlb.setUlIdPersonId(outputCint14wlb.getUlIdPersonId());
      // need to set tsLastUpdate2 for updates to check for time stamp mis-matches
      updateCint14wlb.setTsSysTsLastUpdate2(outputCint14wlb.getTsSysTsLastUpdate2());
      // Sir23446 update record that been end dated.
      updateCint14wlb.setBIndValidateByInterface(outputCint14wlb.getBIndValidateByInterface());
    }
    return updateCint14wlb;
  }

  /**
   * This method is used to compare to person identifier strings; it includes special handling of Social Secuirty
   * Numbers to deal with the case in which one is formatted and the other not.
   *
   * @param type
   * @param number1
   * @param number2
   * @return
   */
  protected static boolean comparePersonIds(String type, String number1, String number2) {
    boolean isEqual = false;
    // if only one is null, return false
    if (number1 == null ^ number2 == null) {
      isEqual = false;
    } else if (number1 == null) {
      // The above works because if the ^ is false, one or both must be null.
      isEqual = true;
    } else if (number1.equals(number2)) {
      isEqual = true;
    } else if (type.equals(CodesTables.CNUMTYPE_SSN)) {
      // need to test for formatted SSN's
      String ssn1 = FormattingHelper.formatSSN(number1);
      String ssn2 = FormattingHelper.formatSSN(number2);
      if (ssn1.equals(ssn2)) {
        isEqual = true;
      }
    }
    return isEqual;
  }

  /**
   * This populates the input version of CINT14WLB from the fields in the request; note that it is NOT a full
   * population; in particular, the ulIdPerson and szCdScrDataAction fields are not populated, as they need to be
   * populated differently depending on conditions known only to the save method.
   *
   * @param request
   * @return
   */
  private gov.georgia.dhr.dfcs.sacwis.structs.input.CINT14WLB populateInputCINT14WLB_save(HttpServletRequest request) {

    // pull current values out of the request and put them in an input object
    gov.georgia.dhr.dfcs.sacwis.structs.input.CINT14WLB inputCint14wlb =
            new gov.georgia.dhr.dfcs.sacwis.structs.input.CINT14WLB();

    CrsRegistrationSO crsRegistrationSO = (CrsRegistrationSO) request.getAttribute("crsRegistrationSO");

    inputCint14wlb.setUlIdPersonId(ContextHelper.getIntSafe(request, "hdnUlIdPersonId"));
    boolean isInvalid = request.getParameter("cbxBIndPersonIDInvalid") != null ? true : false;
    // Sir23446 get the existing validate value, set isValidated to 'N' but save code for future need
    // String isValidated = ContextHelper.getStringSafe( request, "hdnIsValidated" );
    String isValidated = ServiceConstants.FND_NO;
    String endDateString = ContextHelper.getStringSafe(request, "dspDtPersonIDEnd");
    boolean noEndDate = "".equals(endDateString) ? true : false;
    String codeType = ContextHelper.getStringSafe(request, "selSzCdPersonIdType");

    inputCint14wlb.setSzCdPersonIdType(codeType);
    // do special formating for SSN's

    // Check for the existance of a newly registered CRS ID if it exist, set the values
    // for Person Identifier Detail into the input object.
    if (crsRegistrationSO != null) {
      inputCint14wlb.setSzNbrPersonIdNumber(FormattingHelper.formatLong(crsRegistrationSO.getLnIrnClientId()));
      inputCint14wlb.setSzCdPersonIdType(CodesTables.CNUMTYPE_CRS_IDNUMBER);
      inputCint14wlb.setDtPersonIDStart(DateHelper.getTodayCastorDate());
      inputCint14wlb.setBIndPersonIDInvalid(ServiceConstants.FND_NO);

    } else {

      if (codeType.equals(CodesTables.CNUMTYPE_SSN)) {
        inputCint14wlb.setSzNbrPersonIdNumber(ContextHelper.getSSNSafe(request, "txtSzNbrPersonIdNumber"));

      } else {
        inputCint14wlb.setSzNbrPersonIdNumber(ContextHelper.getStringSafe(request, "txtSzNbrPersonIdNumber"));
      }

      inputCint14wlb.setDtPersonIDStart(ContextHelper.getCastorDateSafe(request, "dspDtPersonIDStart"));
      // if the invalid flag it set, we need to end date it so long as it does not have one already
      inputCint14wlb.setDtPersonIDEnd(isInvalid && noEndDate ? DateHelper.getTodayCastorDate()
                                      : ContextHelper.getCastorDateSafe(request,
                                                                        "dspDtPersonIDEnd"));
      inputCint14wlb.setSzDescPersonID(ContextHelper.getStringSafe(request, "txtSzDescPersonID"));
      inputCint14wlb.setBIndPersonIDInvalid(isInvalid ? ServiceConstants.FND_YES : ServiceConstants.FND_NO);
      // Sir23446 update field in row that is going to be inserted
      inputCint14wlb.setBIndValidateByInterface(isValidated);
      // set the tsLastUpdate2 so updates will succeed
      inputCint14wlb.setTsSysTsLastUpdate2(ContextHelper.getJavaDateSafe(request, "hdnTsLastUpdate2"));
    }

    return inputCint14wlb;
  }

  /**
   * This method exists solely so that the service call will be made only once per request; to do so, it caches the
   * output CINT14WLB_ARRAY object in the request.
   *
   * @param context
   * @return
   * @author Merle A Demo Sir23446 for loop to set VERIFIED_DHS if any record in the array has been verified by DHS (is
   * used in .jsp to control drop down box).
   */
  /*
   * public static gov.georgia.dhr.dfcs.sacwis.structs.output.CINT14WLB_ARRAY getCINT14WLB_ARRAY( GrndsExchangeContext
   * context, Person person) {
   */
  public static gov.georgia.dhr.dfcs.sacwis.structs.output.CINT14WLB_ARRAY getCINT14WLB_ARRAY(
          GrndsExchangeContext context,
          RetrievePersonIdentifiers retrievePersonIdentifiers) {
    HttpServletRequest request = context.getRequest();
    gov.georgia.dhr.dfcs.sacwis.structs.output.CINT14WLB_ARRAY cint14WLB_array =
            (gov.georgia.dhr.dfcs.sacwis.structs.output.CINT14WLB_ARRAY) request
                    .getAttribute(CINT14WLB_ARRAY_KEY);
    if (cint14WLB_array == null) {
      cint14WLB_array = callCINT19S(context, retrievePersonIdentifiers);
      // cint14WLB_array = callCINT19S(context, person); // submodule wont show
      request.setAttribute(CINT14WLB_ARRAY_KEY, cint14WLB_array);

      // Sir23446 set true if the current SSN is Validated by the interface
      request.setAttribute(VERIFIED_DHS, "false");

      /*
       * Keep this code because the user may want it later, it disables updates one time for (int i = 0; i <
       * cint14WLB_array.getUlRowQty(); i++) {
       * if(cint14WLB_array.getCINT14WLB(i).getBIndValidateByInterface().equals("Y") &&
       * cint14WLB_array.getCINT14WLB(i).getBIndPersonIDInvalid().equals("N") &&
       * DateHelper.isNull(cint14WLB_array.getCINT14WLB(i).getDtPersonIDEnd()) ) { request.setAttribute(VERIFIED_DHS,
       * "true"); } }
       */

    }
    return cint14WLB_array;
  }

  /**
   * This method invokes CINT19S to get back a CINT14WLB_ARRAY representing the list of person identifiers for a
   * particular person. It needs only id_person unless it is being called from intake, in which case the request
   * attribute "INTAKE_MODE_KEY" (use the PersonIdentifiersCovnersation.INTAKE_MODE_KEY constant) must be set to "Y"
   * (use the PersonIdentifiersConversation.INTAKE_MODE constant). This flag is passed to CINT19S for unknown reasons.
   *
   * @param context
   * @return
   */
  private static gov.georgia.dhr.dfcs.sacwis.structs.output.CINT14WLB_ARRAY callCINT19S(
          GrndsExchangeContext context,
          RetrievePersonIdentifiers retrievePersonIdentifiers) {

    HttpServletRequest request = context.getRequest();
    int personId = GlobalData.getUlIdPerson(request);

    UserProfile user = UserProfileHelper.getUserProfile(context);
    ArchInputStruct archInputStruct = new ArchInputStruct();
    archInputStruct.setSzUserId(user.getUserLogonID());

    archInputStruct.setUsPageNbr(PAGE_NUMBER);
    archInputStruct.setUlPageSizeNbr(PAGE_SIZE_NUMBER);

    PersonIdInStruct personIdInStruct = new PersonIdInStruct();

    // get intake mode out of the request if it's there; this will tell cint19s to run in "intake" mode
    String intakeMode = (String) request.getAttribute(INTAKE_MODE_KEY);
    intakeMode = INTAKE_MODE.equals(intakeMode) ? INTAKE_MODE : NOT_INTAKE_MODE;
    personIdInStruct.setBSysIndIntake(intakeMode);
    personIdInStruct.setUlIdPerson(personId);

    CINT19SI cint19si = new CINT19SI();
    cint19si.setArchInputStruct(archInputStruct);
    cint19si.setPersonIdInStruct(personIdInStruct);

    CINT19SO cint19so = null;
    try {
      cint19so = retrievePersonIdentifiers.findPersonIdentifiers(cint19si);
    } catch (ServiceException we) {
      switch (we.getErrorCode()) {
        case Messages.MSG_NO_ROWS_RETURNED:
          // this happends when we view a person with no person identifiers, so do nothing
          break;
        default:
          processSevereException(context, we);
          break;
      }
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure:" + e.getMessage());
      processSevereException(context, e);
    }

    return cint19so != null ? cint19so.getCINT14WLB_ARRAY() : null;
  }

  public void displayCrsInquiryScreen_xa(GrndsExchangeContext context) {
    // Turn on the performance tracing
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayCrsInquiryScreen_xa()");
    performanceTrace.enterScope();

    try {
      BaseSessionStateManager state = getSessionStateManager(context);
      HttpServletRequest request = context.getRequest();
      state.setAttribute("crsScreeningResults", null, request);
      state.setAttribute("hdnScreened", null, request);

      // Used to preserve the including page display command cint14wlb_array object,
      // the current ulIdPersonId, and the current cint14wlb object, as available
      preserveRequestData(context);
      savePageMode(context);
      getRaceEthnicity(context, true);
      getSSN(context, person);
      getCounty(context);

      GrndsTrace.exitScope();
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Failure:" + e.getMessage());
      processSevereException(context, e);
    }
    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

  }

  // Herlper method to get the SSN
  private void getSSN(GrndsExchangeContext context, Person person) {

    HttpServletRequest request = context.getRequest();

    // The following code Retrieves the Current active SSN and set it in the request.
    gov.georgia.dhr.dfcs.sacwis.structs.output.CINT14WLB_ARRAY cint14WLB_array = getCINT14WLB_ARRAY(context, person);
    // Loop thru the person identification and check for Active SSN
    for (Enumeration idEnumeration = cint14WLB_array.enumerateCINT14WLB(); idEnumeration.hasMoreElements();) {
      CINT14WLB cint14wlb = (CINT14WLB) idEnumeration.nextElement();
      if (cint14wlb.getSzCdPersonIdType().equals(CodesTables.CNUMTYPE_SSN)
          && "N".equals(cint14wlb.getBIndPersonIDInvalid()) && DateHelper.isNull(cint14wlb.getDtPersonIDEnd())) {
        request.setAttribute("txtSzSysTxtGenericSSN", cint14wlb.getSzNbrPersonIdNumber());
        break;
      }
    }

  }

  // Helper method to get the county
  private void getCounty(GrndsExchangeContext context) {

    HttpServletRequest request = context.getRequest();
    UserProfile user = UserProfileHelper.getUserProfile(context);

    // Retrieve the county
    CCMN42SI ccmn42si = new CCMN42SI();
    ArchInputStruct input = new ArchInputStruct();
    input.setBPerfInd("Y");
    input.setBDataAcsInd("Y");
    input.setUsPageNbr(1);
    input.setUlPageSizeNbr(65);
    input.setSzUserId(user.getUserLogonID());
    ccmn42si.setUlIdPerson(GlobalData.getUlIdPerson(request));
    ccmn42si.setArchInputStruct(input);

    CCMN42SO ccmn42so = person.retrievePersonAddressList(ccmn42si);

    ROWCCMN42SOG00_ARRAY rowccmn42sog00_array = ccmn42so.getROWCCMN42SOG00_ARRAY();

    if (rowccmn42sog00_array != null) {
      // Loop thru the Addresses and retrieve the Active County for the person
      for (Enumeration addressEnum = rowccmn42sog00_array.enumerateROWCCMN42SOG00(); addressEnum.hasMoreElements();) {
        ROWCCMN42SOG00 rowccmn42sog00 = (ROWCCMN42SOG00) addressEnum.nextElement();
        if ("Y".equals(rowccmn42sog00.getBIndPersAddrLinkPrimary())
            && "N".equals(rowccmn42sog00.getBIndPersAddrLinkInvalid())
            && DateHelper.isNull(rowccmn42sog00.getDtDtPersAddrLinkEnd())) {
          request.setAttribute("cboSzCdAddrCounty", rowccmn42sog00.getSzCdAddrCounty());
          break;
        }
      }
    }
  }

  /**
   * Helper method to get the race and ethnicity of the person.
   *
   * @param context
   */
  private void getRaceEthnicity(GrndsExchangeContext context, boolean ignoreState) {
    try {
      HttpServletRequest request = context.getRequest();
      // Pull from the database when coming from anywhere but the Iquire button or when the information is not yet in state.
      RaceEthnicityBean reBean;
      if (ignoreState || !RaceEthnicityHelper.isInState(request)) {
        CINV04SI cinv04si = populateCINV04SI_Retrieve(context);
        CINV04SO cinv04so = person.retrievePersonDetail(cinv04si);
        reBean = new RaceEthnicityBean();
        XmlValueBean raceList = cinv04so.getCINV04SOG03_ARRAY();
        XmlValueBean ethnicityList = cinv04so.getCINV04SOG04_ARRAY();
        reBean.setEthnicity(ethnicityList);
        reBean.setRaces(raceList);
      } else {
        reBean = RaceEthnicityHelper.getFromState(request);
        RaceEthnicityBean requestReBean = RaceEthnicityHelper.createRaceEthnicityBean(request);
        RaceEthnicityBean.Races requestRaces = requestReBean.getRaces();
        RaceEthnicityBean.Races races = reBean.getRaces();
        while (requestRaces.hasNext()) {
          RaceEthnicityBean.Race race = requestRaces.next();
          if (CheckboxHelper.ADDED.equals(race.getActionCode())) {
            races.put(race.getValue(), race.getActionCode());
          } else if (CheckboxHelper.DELETED.equals(race.getActionCode())) {
            races.remove(race.getValue());
          }
        }
        reBean.setEthnicity(requestReBean.getEthnicity());
      }
      // Always put the bean in state for storage and in the request for processing.
      RaceEthnicityHelper.addToState(reBean, request);
      RaceEthnicityHelper.addToRequest(reBean, request);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Failure:" + e.getMessage());
      processSevereException(context, e);
    }
  }

  public void performCrsInquiry_xa(GrndsExchangeContext context) {
    // Turn on the performance tracing
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".performCrsInquiry_xa()");
    performanceTrace.enterScope();

    try {
      preserveRequestData(context);
      savePageMode(context);
      getCounty(context);
      getSSN(context, person);
      getRaceEthnicity(context, false);
      performCrsScreening(context);
      GrndsTrace.exitScope();
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Failure:" + e.getMessage());
      processSevereException(context, e);
    }
    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

  }

  @SuppressWarnings({"unchecked"})
  private void performCrsScreening(GrndsExchangeContext context) {
    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();

    try {
      // Capture the displayed person info
      // Populate the information into the Screening SI object that is required for the Web Service
      CrsScreeningSI crsScreeningSI = populate_CrsScreeningSI(context);
      try {
        // Check to see if the screening is called by the Inquiry/Screen button or the Next/Previous links
        // If Inquiry/Screen then call the Web Service or else use the cashed Screening results.
        String inquiryPressed = request.getParameter("hdnInqPressed");
        CrsScreeningSO result;
        if (null == inquiryPressed || "true".equalsIgnoreCase(inquiryPressed)
            || null == state.getAttribute("orgCrsScreeningResults", request)) {
          state.setAttribute("hdnWebServiceError", null, request);
          state.setAttribute("crsScreeningResults", null, request);
          result = ws.performCrsScreening(crsScreeningSI);
          state.setAttribute("orgCrsScreeningResults", result, request);
          if (result != null) {
            if(result.getReturnCode().intValue() == CrsScreeningSO.SUCCESSFULL_SCREENING) {
              state.setAttribute("hdnScreened", "true", request);
              setPaginatedListInRequest(context, result.getReturnItems());
            }
            else {
              String message = "No CRS message is define for this return code: " + result.getReturnCode();
              //CRS return codes we are tacking start at this value so if we get a smaller return code display generic messge
              if (result.getReturnCode().intValue() > 90036){
                String lookupMessage = MessageLookup.getMessageByNumber(result.getReturnCode().intValue());
                message = (lookupMessage.length() > 0) ? lookupMessage : message;
              }
              state.setAttribute("hdnWebServiceError",
                                   "CRS Service error when perform inquiry: " + message, request);
            }
          }
        } else {
          result = (CrsScreeningSO) state.getAttribute("orgCrsScreeningResults", request);
          setPaginatedListInRequest(context, result.getReturnItems());
        }
      } catch (Exception e) {
        // This error is captured by the calling JSP page and displayed to the user.
        state.setAttribute("hdnWebServiceError",
                           "CRS Sreening Service cannot be accessed! Please check logs for error details.", request);
        GrndsTrace.msg(TRACE_TAG, 7, "General Failure:" + e.getMessage());
      }
      GrndsTrace.exitScope();
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Failure:" + e.getMessage());
      processSevereException(context, e);
    }
  }

  /**
   * This is the method that processes the List for Pagination for Screening calls from CrsInquiry and the
   * CrsRegistration pages
   *
   * @param context
   * @param results
   */
  private void setPaginatedListInRequest(GrndsExchangeContext context, List<CrsScreeningSO.ReturnItem> results) {

    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();

    // Get the page and the results per page info
    CrsPaginationValueBean crsPagination = new CrsPaginationValueBean();
    ValueBeanHelper.populateDefaultValues(context, crsPagination);
    int requestedPageNo = crsPagination.getResultDetails().getRequestedPage();
    int resultsPerPage = crsPagination.getResultDetails().getResultsPerPage();

    // Reset the page number to last page if the user enters page number higher than available pages
    int rows = results.size();
    int lastPage = rows / resultsPerPage + (rows % resultsPerPage > 0 ? 1 : 0);
    if (requestedPageNo > lastPage) {
      requestedPageNo = lastPage;
      crsPagination.getResultDetails().setRequestedPage(requestedPageNo);
    }

    List<CrsScreeningSO.ReturnItem> subList = null;
    int toIndex = 0;
    if (results.size() > 0) {
      // Find the starting index and the to index and create the list to be displayed on the page and save it in state
      int fromIndex = (requestedPageNo - 1) * resultsPerPage;
      int remainingRows = rows-fromIndex;
      toIndex = fromIndex + (remainingRows>resultsPerPage? resultsPerPage:remainingRows);
      subList = results.subList(fromIndex, toIndex);
    } else {
      subList = results;
    }
    
    PaginatedHibernateList<CrsScreeningSO.ReturnItem> phl =
            new PaginatedHibernateList<CrsScreeningSO.ReturnItem>(subList, resultsPerPage, requestedPageNo);
    state.setAttribute("crsScreeningResults", phl, request);

    // Store the pagination information in the Pagination bean
    String hasMoreData = toIndex < results.size() ? ArchitectureConstants.Y : ArchitectureConstants.N;
    crsPagination.setPaginationInformation(hasMoreData, subList.size());
    storePaginationBeanToRequest(context, crsPagination);
  }

  private CrsScreeningSI populate_CrsScreeningSI(GrndsExchangeContext context) {

    CrsScreeningSI crsScreeningSI = new CrsScreeningSI();
    crsScreeningSI.setSzLName(ContextHelper.getStringSafe(context, "txtSzNmNameLast"));
    crsScreeningSI.setSzFName(ContextHelper.getStringSafe(context, "txtSzNmNameFirst"));
    crsScreeningSI.setSzMName(ContextHelper.getStringSafe(context, "txtSzNmNameMiddle"));
    crsScreeningSI.setSzSuffix(ContextHelper.getStringSafe(context, "cboCcdPersonSuffix"));
    crsScreeningSI.setSzSexCode(ContextHelper.getStringSafe(context, "cboCcdPersonSex"));
    crsScreeningSI.setSzShinesLogonShort(UserProfileHelper.getUserProfile(context.getRequest()).getUserLogonID());
    crsScreeningSI.setLnIdInitiator(String.valueOf(UserProfileHelper.getUserProfile(context.getRequest()).getUserID()));
    String ssn = decodeFormattedSSNString(ContextHelper.getStringSafe(context, "txtSzSysTxtGenericSSN"));
    if (StringHelper.isValid(ssn)) {
      crsScreeningSI.setUlSsn(ssn);
    }

    // Set date of birth
    org.exolab.castor.types.Date dob = ContextHelper.getCastorDateSafe(context, "txtDtDtPersonBirth");
    if(DateHelper.isNull(dob) == true) {
      crsScreeningSI.setUlDob(null);
    } else {
      crsScreeningSI.setUlDob(DateHelper.toString(dob, new SimpleDateFormat("yyyyMMdd")));
    }

    // Set Races Selected
    HttpServletRequest request = context.getRequest();
    RaceEthnicityBean reBean = RaceEthnicityHelper.getFromRequest(request);
    String ethnicity = reBean.getEthnicity();
    // The races list has 
    RaceEthnicityBean.Races races = reBean.getRaces();
    while (races.hasNext()) {
      RaceEthnicityBean.Race race = races.next();
      String val = race.getValue();
      if (RaceEthnicityHelper.RACE_AMERIND.equals(val)) {
        crsScreeningSI.setSzBlnNtvAmerican(ArchitectureConstants.Y);
      } else if (RaceEthnicityHelper.RACE_ASIAN.equals(val)) {
        crsScreeningSI.setSzBlnAsian(ArchitectureConstants.Y);
      } else if (RaceEthnicityHelper.RACE_BLACK.equals(val)) {
        crsScreeningSI.setSzBlnAfAmerican(ArchitectureConstants.Y);
      } else if (RaceEthnicityHelper.RACE_WHITE.equals(val)) {
        crsScreeningSI.setSzBlnWhite(ArchitectureConstants.Y);
      } else if (RaceEthnicityHelper.RACE_HAWAIIAN.equals(val)) {
        crsScreeningSI.setSzBlnPcfcislander(ArchitectureConstants.Y);
      }
    }
    // Set Ethnicity
    String ethicType = RaceEthnicityHelper.ETHNICITY_HISPANIC.equals(ethnicity) == true ? "L" : "N";
    crsScreeningSI.setSzEthnCode(ethicType);
    return crsScreeningSI;
  }

  // This method is called by a click on the Add To CRS button on CRS Registration page
  // A helper method is called to populate the SI object that will be passed to the service that will handle
  // the operation of registraring a CRS. The Service will return an object containing a new CRS ID
  public void performCrsRegistration_xa(GrndsExchangeContext context) {
    // Turn on the performance tracing
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".performCrsRegistration_xa()");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();
    try {
      preserveRequestData(context);
      savePageMode(context);
      getRaceEthnicity(context, true);
      performCrsRegistration(context);
      if (null != request.getAttribute("hdnCrsRegnSaveMsg")) {
        // Call the savePersonIdDetail method to save the registered CRS ID
        savePersonIdDetail_xa(context);
      } else {
        String includingPageDisplayCommand = ContextHelper.getString(request, "hdnIncludingPageDisplayCommand");
        forward(includingPageDisplayCommand, request, context.getResponse());
      }

      GrndsTrace.exitScope();
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Failure:" + e.getMessage());
      processSevereException(context, e);
    }
    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  private boolean performCrsRegistration(GrndsExchangeContext context) {
    BaseSessionStateManager state = getSessionStateManager(context);
    CINV04SI cinv04si = populateCINV04SI_Retrieve(context);
    CINV04SO cinv04so = person.retrievePersonDetail(cinv04si);

    CrsRegistrationSO crsRegistrationSO = new CrsRegistrationSO();
    // Populate registration input object
    CrsRegistrationSI crsRegistrationSI = populate_CrsRegistrationSI(context, cinv04so);
    HttpServletRequest request = context.getRequest();
    try {
      state.setAttribute("hdnWebServiceError", null, request);
      request.setAttribute("hdnWebServiceError", null);
      crsRegistrationSO = ws.performCrsRegistration(crsRegistrationSI);
      if (crsRegistrationSO != null) {
        //if id is zero than we have an error
        if(crsRegistrationSO.getLnIrnClientId() == 0) {
          String message = "No CRS message is define for this return code: " + Integer.toString(crsRegistrationSO.getLnCrsReturnValue());
          //CRS return codes we are tacking start at this value so if we get a smaller return code display generic messge
          if (crsRegistrationSO.getLnCrsReturnValue() > 90036){
            String lookupMessage = MessageLookup.getMessageByNumber(crsRegistrationSO.getLnCrsReturnValue());
            message = (lookupMessage.length() > 0) ? lookupMessage : message;
          }
          request.setAttribute("hdnWebServiceError",
          "CRS Registration Service could not create CRS ID: "  + message);
        } else {
          request.setAttribute("crsRegistrationSO", crsRegistrationSO);
          CrsAuditSI crsAuditSI = populate_CrsAuditSI(crsRegistrationSO, null, context);
          ws.saveCrsAuditRow(crsAuditSI);
          request.setAttribute("hdnCrsRegnSaveMsg",
                               "A new CRS ID has been created in the CRS system and has also been added as an Identifier for "
                               + cinv04so.getSzNmNameFirst() + " " + cinv04so.getSzNmNameLast());
          return true;
        }
      } else {
        request.setAttribute("hdnWebServiceError",
        "CRS Registration Service could not create CRS ID! Please check logs for errors.");
      }
    } catch (Exception e) {
      CrsAuditSI crsAuditSI = populate_CrsAuditSI(crsRegistrationSO, e, context);
      ws.saveCrsAuditRow(crsAuditSI);
      request.setAttribute("hdnWebServiceError",
                           "CRS Registration Service cannot be accessed! Please check logs for errors.");
      state.setAttribute("hdnWebServiceError",
                         "CRS Registration Service cannot be accessed! Please check logs for errors.", request);
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure:" + e.getMessage());
    }
    return false;
  }

  private CrsAuditSI populate_CrsAuditSI(CrsRegistrationSO crsRegistrationSO, Exception e,
                                         GrndsExchangeContext context) {

    HttpServletRequest request = context.getRequest();
    CrsAuditSI crsAuditSI = new CrsAuditSI();

    if (e != null) {
      crsAuditSI.setInterfaceStatus(CrsAuditSI.REGISTRATION_ERROR);
    } else {
      crsAuditSI.setInterfaceStatus(CrsAuditSI.REGISTRATION_SENT);
    }

    crsAuditSI.setDtProcess(new Date());
    int crsRetnValue = crsRegistrationSO.getLnCrsReturnValue();
    crsAuditSI.setCdError(crsRetnValue > 0 ? Integer.toString(crsRetnValue) : CrsAuditSI.CONNECTION_ERROR);
    crsAuditSI.setIdInitiator(GlobalData.getUlIdStaff(request));
    crsAuditSI.setShinesLogonShort(crsRegistrationSO.getSzRacfid());
    crsAuditSI.setDtCrsRequested(new Date());
    crsAuditSI.setCdCrsRequest(CrsAuditSI.CRS_REGISTER);
    crsAuditSI.setIdPerson(GlobalData.getUlIdPerson(request));
    crsAuditSI.setNbrCrsId(crsRegistrationSO.getLnIrnClientId());
    crsAuditSI.setNbrPersonIdNumber(StringHelper.getSafeString(crsRegistrationSO.getUlSsn() + StringHelper.EMPTY_STRING));
    crsAuditSI.setNmPersonLast(crsRegistrationSO.getSzLName());
    crsAuditSI.setNmPersonFirst(crsRegistrationSO.getSzFName());
    String sexCode = crsRegistrationSO.getSzSexCode();
    crsAuditSI.setCdPersonSex(StringHelper.isValid(sexCode) ? sexCode : "-");

    return crsAuditSI;

  }

  // This method populates the SI object that is passed as input for CRS Registration
  private CrsRegistrationSI populate_CrsRegistrationSI(GrndsExchangeContext context, CINV04SO cinv04so) {
    CrsRegistrationSI crsRegistrationSI = new CrsRegistrationSI();

    try {
      HttpServletRequest request = context.getRequest();
      CINV25SI cinv25si = new CINV25SI();
      cinv25si.setUlIdPerson(GlobalData.getUlIdPerson(request));
      CINV25SO cinv250so = person.retrievePersonNameInformation(cinv25si);

      getSSN(context, person);

      crsRegistrationSI.setSzLName(ContextHelper.getStringSafe(context, "txtSzNmNameLast"));
      crsRegistrationSI.setSzFName(ContextHelper.getStringSafe(context, "txtSzNmNameFirst"));
      crsRegistrationSI.setSzMName(ContextHelper.getStringSafe(context, "txtSzNmNameMiddle"));
      crsRegistrationSI.setSzSuffix(ContextHelper.getStringSafe(context, "cboCcdPersonSuffix"));
      crsRegistrationSI.setSzSexCode(ContextHelper.getStringSafe(context, "cboCcdPersonSex"));
      crsRegistrationSI.setSzSsnVrfcnCode(ContextHelper.getStringSafe(context, "txtSSNVer"));
      crsRegistrationSI.setSzDobVrfcnCode(ContextHelper.getStringSafe(context, "txtDOBVer"));
      
      //cboSzCdAddrCounty is a name at this point so lookup the code which is needed. 
      String szCountId = Lookup.simpleEncodeSafe(CodesTables.CCOUNT , (String) request.getAttribute("cboSzCdAddrCounty"));
      int countyId = 0;
      if(szCountId != null) {
        try {
          szCountId = szCountId.trim();
          countyId = Integer.parseInt(szCountId);
        }
        catch (Exception e) {
          countyId = 0;
        }
      }
      crsRegistrationSI.setUlCountyCode(countyId);
      crsRegistrationSI.setSzMaritalStatus(cinv04so.getSzCdPersonMaritalStatus());
      crsRegistrationSI.setSzPrimLanguage(cinv04so.getSzCdPersonLanguage());
      crsRegistrationSI.setSzBirthStateCd(cinv04so.getSzCdPersonBirthState());
      crsRegistrationSI.setSzBirthCityNm(cinv04so.getSzCdPersonBirthCity());
      crsRegistrationSI.setLnIdInitiator(String.valueOf(UserProfileHelper.getUserProfile(request).getUserID()));
      crsRegistrationSI.setShinesLogonShort(String.valueOf(UserProfileHelper.getUserProfile(request).getUserLogonID()));
      String ssn = decodeFormattedSSNString(ContextHelper.getSSN(context, "txtSzSysTxtGenericSSN"));

      if (ssn != null) {
        crsRegistrationSI.setSzSsn(ssn);
      }

      // Set DOB
      org.exolab.castor.types.Date dob = ContextHelper.getCastorDateSafe(context, "txtDtDtPersonBirth");
      String tmp = DateHelper.toString(dob, new SimpleDateFormat("yyyyMMdd"));
      crsRegistrationSI.setUlDob(tmp);

      // Set aliases
      ROWCINV25SOG00_ARRAY nameList = cinv250so.getROWCINV25SOG00_ARRAY();
      int nbrName = nameList.getROWCINV25SOG00Count();
      int nbnameAl = 0;

      if (nbrName > 1) {
        for (int i = 1; i < nbrName && nbnameAl <= 3; i++) {
          crsRegistrationSI.setSzAlias1FName(nameList.getROWCINV25SOG00(i).getSzNmNameFirst());
          crsRegistrationSI.setSzAlias1LName(nameList.getROWCINV25SOG00(i).getSzNmNameLast());
          crsRegistrationSI.setSzAlias1MName(nameList.getROWCINV25SOG00(i).getSzNmNameMiddle());
          crsRegistrationSI.setSzAlias1Suffix(nameList.getROWCINV25SOG00(i).getSzCdNameSuffix());
          nbnameAl++;
        }
      }

      // Set Race

      CINV04SOG03_ARRAY raceList = cinv04so.getCINV04SOG03_ARRAY();
      CINV04SOG03 cinv04sog03;
      // Loop thru the person and retrieve person ethnicity
      for (Enumeration raceEnumeration = raceList.enumerateCINV04SOG03(); raceEnumeration.hasMoreElements();) {
        cinv04sog03 = (CINV04SOG03) raceEnumeration.nextElement();
        if (RaceEthnicityHelper.RACE_AMERIND.equals(cinv04sog03.getSzCdPersonRace())) {
          crsRegistrationSI.setSzBlnNtvAmerican("Y");
        }
        if (RaceEthnicityHelper.RACE_ASIAN.equals(cinv04sog03.getSzCdPersonRace())) {
          crsRegistrationSI.setSzBlnAsian("Y");
        }
        if (RaceEthnicityHelper.RACE_BLACK.equals(cinv04sog03.getSzCdPersonRace())) {
          crsRegistrationSI.setSzBlnAfAmerican("Y");
        }
        if (RaceEthnicityHelper.RACE_WHITE.equals(cinv04sog03.getSzCdPersonRace())) {
          crsRegistrationSI.setSzBlnWhite("Y");
        }
        if (RaceEthnicityHelper.RACE_HAWAIIAN.equals(cinv04sog03.getSzCdPersonRace())) {
          crsRegistrationSI.setSzBlnPcfcislander("Y");
        }
      }

      // Set Ethnicity
      CINV04SOG04_ARRAY ethnicityList = cinv04so.getCINV04SOG04_ARRAY();
      for (Enumeration ethnicityEnumeration = ethnicityList.enumerateCINV04SOG04();
           ethnicityEnumeration.hasMoreElements();) {
        CINV04SOG04 cinv04sog04 = (CINV04SOG04) ethnicityEnumeration.nextElement();
        if (cinv04sog04 != null) {
          String ethic = RaceEthnicityHelper.ETHNICITY_HISPANIC.equals(cinv04sog04.getSzCdPersonEthnicity()) == true ? "L" : "N";
          crsRegistrationSI.setSzEthnCode(ethic);
        }
      }

      // Populate SSN Aliases
      CINT14WLB_ARRAY cint14WLB_array = getCINT14WLB_ARRAY(context, person);
      CINT14WLB_ARRAY ssAllias_array = new CINT14WLB_ARRAY();
      CINT14WLB ssnAlias = new CINT14WLB();
      int count = 0;
      // Loop thru the person identification and check for SSN
      for (Enumeration idEnumeration = cint14WLB_array.enumerateCINT14WLB(); idEnumeration.hasMoreElements();) {
        CINT14WLB cint14wlb = (CINT14WLB) idEnumeration.nextElement();
        if ((CodesTables.CNUMTYPE_SSN).equals(cint14wlb.getSzCdPersonIdType())
            && !DateHelper.isNull(cint14wlb.getDtPersonIDEnd())) {
          ssnAlias.setSzNbrPersonIdNumber(cint14wlb.getSzNbrPersonIdNumber());
          ssAllias_array.addCINT14WLB(ssnAlias);
          count++;
        }
      }
      // Set SSN aliases
      int nbSSN = 0;
      if (count != 0) {
        for (int j = 0; j < count && nbSSN <= 5; j++) {
          String ssn1 = decodeFormattedSSNString(ssAllias_array.getCINT14WLB(j).getSzNbrPersonIdNumber());
          crsRegistrationSI.setUlAlt1Ssn(StringHelper.toInteger(ssn1));
          nbSSN++;
        }
      }

    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Failure:" + e.getMessage());
      processSevereException(context, e);
    }

    return crsRegistrationSI;
  }

  public void displayCrsRegistration_xa(GrndsExchangeContext context) {

    // Turn on the performance tracing
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayCrsRegistration_xa()");
    performanceTrace.enterScope();

    try {
      HttpServletRequest request = context.getRequest();
      BaseSessionStateManager state = getSessionStateManager(context);
      CINV04SI cinv04si = populateCINV04SI_Retrieve(context);
      CINV04SO cinv04so = person.retrievePersonDetail(cinv04si);
      state.setAttribute("CINV04SO", cinv04so, request);
      state.setAttribute("crsScreeningResults", null, request);
      state.setAttribute("hdnScreened", null, request);

      // Used to preserve the including page display command cint14wlb_array object,
      // the current ulIdPersonId, and the current cint14wlb object, as available
      preserveRequestData(context);
      savePageMode(context);
      getRaceEthnicity(context, true);
      getCounty(context);
      getSSN(context, person);

      GrndsTrace.exitScope();
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Failure:" + e.getMessage());
      processSevereException(context, e);
    }

    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

  }

  public void performCrsScreening_xa(GrndsExchangeContext context) {
    // Turn on the performance tracing
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".performCrsScreening_xa()");
    performanceTrace.enterScope();
    try {
      preserveRequestData(context);
      savePageMode(context);
      getCounty(context);
      getSSN(context, person);

      getRaceEthnicity(context, true);
      performCrsScreening(context);

      GrndsTrace.exitScope();
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Failure:" + e.getMessage());
      processSevereException(context, e);
    }
    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  @SuppressWarnings({"unchecked"})
  public void selectCrsId_xa(GrndsExchangeContext context) {

    // Turn on the performance tracing
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".selectCrsId_xa()");
    performanceTrace.enterScope();
    BaseSessionStateManager state = getSessionStateManager(context);

    try {
      HttpServletRequest request = context.getRequest();
      preserveRequestData(context);
      savePageMode(context);

      if (ContextHelper.isParameterPresent(request, "hdnLoopCount")) {
        // An exception here is severe, so use the non-"Safe" version of getInt().
        int selectionIndex = ContextHelper.getInt(request, "hdnLoopCount");
        List<CrsScreeningSO.ReturnItem> results = (List<CrsScreeningSO.ReturnItem>) state.getAttribute("crsScreeningResults", request);
        if (results != null) {
          CINT14WLB crsObject = new CINT14WLB();
          CrsScreeningSO.ReturnItem selection = results.get(selectionIndex);
          crsObject.setSzNbrPersonIdNumber(String.valueOf(selection.getLnIrnClientId()));
          crsObject.setSzCdPersonIdType(CodesTables.CNUMTYPE_CRS_IDNUMBER);
          state.setAttribute("cint14wlb", crsObject, request);
        }
      }
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Failure:" + e.getMessage());
      processSevereException(context, e);
    }

    GrndsTrace.exitScope();
    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

  }

  private void savePageMode(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    String localPageMode = (String) state.getAttribute(PersonIdentifiersSubmoduleConversation.PAGE_MODE_KEY, request);
    if (localPageMode == null || "".equals(localPageMode)) {
      localPageMode = PageModeConstants.VIEW;
    }
    state.setAttribute(PAGE_MODE_KEY, localPageMode, request);
  }

  private CINV04SI populateCINV04SI_Retrieve(GrndsExchangeContext context) {
    CINV04SI cinv04si = new CINV04SI();
    HttpServletRequest request = context.getRequest();
    ArchInputStruct input = new ArchInputStruct();
    cinv04si.setArchInputStruct(input);
    cinv04si.setSzCdStageProgram(GlobalData.getSzCdStageProgram(request));
    cinv04si.setSzSysCdWinMode(PersonHelper.getPersonDetailPageMode(request));
    cinv04si.setUlIdStage(GlobalData.getUlIdStage(request));
    cinv04si.setUlIdPerson(GlobalData.getUlIdPerson(request));
    cinv04si.setUlIdCase(GlobalData.getUlIdCase(request));
    return cinv04si;
  }

  // This helper method decode a formated SSN
  public static String decodeFormattedSSNString(String formattedSsn) {
    if (formattedSsn == null) {
      return null;
    }
    StringBuffer buff = new StringBuffer();
    StringTokenizer strtok = new StringTokenizer(formattedSsn, "-");
    while (strtok.hasMoreTokens()) {
      buff.append(strtok.nextToken());
    }
    return buff.toString();
  }
  
  //Check to see if the Id Type allows duplicates
  private boolean allowMultiples(String idType) {
    boolean allowMult = false;
    String multFlag = Lookup.simpleDecodeSafe(ALLOW_MULT_CATEGORY, idType);
    if (StringHelper.isValid(multFlag) && ArchitectureConstants.Y.equals(multFlag)) {
      allowMult = true;
    }
    return allowMult;
  }
}
