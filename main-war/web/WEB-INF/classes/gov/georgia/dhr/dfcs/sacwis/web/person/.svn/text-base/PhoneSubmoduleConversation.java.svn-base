package gov.georgia.dhr.dfcs.sacwis.web.person;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.grnds.structural.web.GrndsExchangeContext;

import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.common.PhoneDB;
import gov.georgia.dhr.dfcs.sacwis.service.person.Person;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN46SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN46SOG00;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BasePrsConversation;

/** @todo add parameters, etc. to javadocs */

/**
 * Defines phoneSub(module)
 *
 * @author Matthew McClain, March 1, 2003
 */
public class PhoneSubmoduleConversation extends PhoneConversation {
  public static final String CONVERSATION_URL = "/submodule/PhoneSubmoduleConversation/";
  public static final String PHONE_EXPANDABLE_SECTION_LABEL = "phoneExpandableSectionLabel";
  public static final String PHONE_SUB = CONVERSATION_URL + "PhoneSub";
  public static final String PHONE_SUB_NAME = "PhoneSub.Name";
  public static final String PHONE_SUB_CREATED_FORM_FIELDS = "PhoneSub.CreatedFormFields";
  //!!! do I need more than 1?
  public static final String PHONE_SUB_PHONES = "phonesDB";

  private Person person;

  public void setPerson(Person person) {
    this.person = person;
  }

  /** Calls CCMN46S Creates a vector of PhoneDBs from the array of ROWCCMN46SOG00 */
  public void phoneSub_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, "phoneSub_xa");

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    try {
      // Get page mode for this submodule from the request instead of from the
      // PageMode object. Including JSP's will pass page mode to this submodule
      // using impact:attribute because some including JSP's will want the
      // submodule's page mode to be different from the value in PageMode. If
      // page mode is not passed to the submodule, use PageMode by default.
      String pageMode = (String) request.getAttribute(PAGE_MODE);
      if ((pageMode == null) || ("".equals(pageMode))) {
        pageMode = PageMode.getPageMode(request);
      }
      request.setAttribute(PAGE_MODE, pageMode);

      int personId = GlobalData.getUlIdPerson(request);
      String personName = GlobalData.getSzNmPersonFull(request);

      //If PHONE_SUB_PERSON_ID is specified as an impact:attribute, it overrides
      //the value in GlobalData
      String personIdString = (String) request.getAttribute(PHONE_SUB_PERSON_ID);
      if (StringHelper.isValid(personIdString)) {
        personId = Integer.parseInt(personIdString);
        personName = (String) request.getAttribute(PHONE_SUB_PERSON_NAME);
      }

      request.setAttribute(PHONE_SUB_PERSON_ID, "" + personId);
      request.setAttribute(PHONE_SUB_PERSON_NAME, personName);

      CCMN46SO ccmn46so = callCCMN46S(personId, person);

      ROWCCMN46SOG00[] array = ccmn46so.getROWCCMN46SOG00_ARRAY().getROWCCMN46SOG00();

      List vector = new ArrayList();
      for (int i = 0; i < array.length; i++) {
        PhoneDB phoneDB = toPhoneDB(array[i]);
        vector.add(phoneDB);
      }
      request.setAttribute(PHONE_SUB_PHONES, vector);
    }
    catch (Throwable e) {
      e.printStackTrace();
      processSevereException(context, e);
    }
    finally {
      performanceTrace.exitScope();
    }
  }

  /** Creates a url given the pageName and a hashtable of parameters */
  public static String getUrl(String pageName,
                              Map parameters) {
    String baseUrl = CONVERSATION_URL + pageName;
    return BasePrsConversation.getUrl(baseUrl, parameters);
  }
}
