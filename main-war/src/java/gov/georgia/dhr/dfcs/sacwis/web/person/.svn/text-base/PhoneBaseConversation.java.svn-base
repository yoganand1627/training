package gov.georgia.dhr.dfcs.sacwis.web.person;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.common.PhoneDB;
import gov.georgia.dhr.dfcs.sacwis.service.common.Phone;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN46SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN46SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN46SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

/** Handles activities related to display the Address submodule. */
public abstract class PhoneBaseConversation extends BaseHiddenFieldStateConversation {

  public static final String TRACE_TAG = "PhoneConversation";

  public static final String PHONE_SUB_PERSON_ID = "phonePersonId";

  public static final String PHONE_SUB_PERSON_NAME = "phonePersonName";

  public static final String CONVERSATION_URL = "/person/PhoneConversation/";

  public static final String FORWARD_TO = CONVERSATION_URL + "ForwardTo";

  public static final String PHONE_DETAIL = CONVERSATION_URL + "PhoneDetail";

  public static final String PHONE_DETAIL_PHONE = "phoneDB";

  public static final String PHONE_PULLBACK = CONVERSATION_URL + "PhonePullback";

  public static final String PHONE_PULLBACK_PHONES = "phonesDB";

  public static final String PHONE_SAVE = CONVERSATION_URL + "PhoneSave";

  public static final String PHONE_SUB_HOLDER = CONVERSATION_URL + "PhoneSubHolder";

  public static final String RETURN_URL = "phoneSub_returnUrl";

  public static final String PAGE_MODE = "PHONE_SUBMODULE_PAGE_MODE_KEY";

  Phone phone;

  public void setPhone(Phone phone) {
    this.phone = phone;
  }

  /**
   * Retrieves PhoneDB for the PhoneDetail.jsp
   *
   * @param context The GrndsExchangeContext object.
   */
  public void phoneDetail_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, "phoneDetail_xa");

    HttpServletRequest request = context.getRequest();
    try {
      int personId = ContextHelper.getIntSafe(request, PHONE_SUB_PERSON_ID);
      if (personId != 0) {
        GlobalData.setUlIdPerson(personId, request);
      }

      String personName = ContextHelper.getStringSafe(request, PHONE_SUB_PERSON_NAME);
      if (!"".equals(personName)) {
        GlobalData.setSzNmPersonFull(personName, request);
      }

      // SIR 22456 - Get page mode out of request using PAGE_MODE constant
      // key name because that is the name that JSP's that include the phone
      // submodule are expecting to use. Also put page mode back into the
      // request using the same name.
      String pageMode = ContextHelper.getString(request, PAGE_MODE);
      if ((pageMode == null) || ("".equals(pageMode))) {
        pageMode = PageMode.getPageMode(request);
      }
      request.setAttribute(PAGE_MODE, pageMode);

      PhoneDB phoneDB = getPhoneDB(request);
      request.setAttribute(PHONE_DETAIL_PHONE, phoneDB);
    } catch (Exception e) {
      processSevereException(context, e);
    } finally {
      performanceTrace.exitScope();
    }
  }

  /**
   * Retrieves the vector of PhoneDBs for PhonePullback.jsp based on stageId and stageType. Sets SSM_NO_ROWS_RETURNED if
   * vector.size() == 0.
   *
   * @param context The GrndsExchangeContext object.
   */
  public void phonePullback_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, "phonePullback_xa");

    HttpServletRequest request = context.getRequest();

    try {
      int stageId = GlobalData.getUlIdStage(request);
      String stageCode = GlobalData.getSzCdStage(request);

      List vector = phone.getActivePhonesForStage(stageId, stageCode);
      request.setAttribute(PHONE_PULLBACK_PHONES, vector);

      if (vector.size() == 0) {
        String SSM_NO_ROWS_RETURNED = MessageLookup.getMessageByNumber(Messages.SSM_NO_ROWS_RETURNED);
        setErrorMessage(SSM_NO_ROWS_RETURNED, PHONE_PULLBACK, request);
      }
    } catch (Exception e) {
      processSevereException(context, e);
    } finally {
      performanceTrace.exitScope();
    }
  }

  /**
   * Save the Phone passed on the request to it. Executes PhoneSave Method object (command). If PhoneSave has an
   * errorMessage, control is returned to PhoneDetail to resolve. Otherwise, forwards request to returnUrl.
   *
   * @param context The GrndsExchangeContext object.
   */
  public abstract void phoneSave_xa(GrndsExchangeContext context);

  /** All ROWCCMN46SOG00 of ccmn46so are set in vector. */
  protected static void addRowsToVector(CCMN46SO ccmn46so, List<ROWCCMN46SOG00> vector) {
    ROWCCMN46SOG00[] outputArray = ccmn46so.getROWCCMN46SOG00_ARRAY().getROWCCMN46SOG00();
    List<ROWCCMN46SOG00> list = Arrays.asList(outputArray);
    vector.addAll(list);
  }

  /** Vector of ROWCCMN46SOG00 are set back on ccmn46so. */
  protected static void setRowsOnCCMN46SO(CCMN46SO ccmn46so, List<ROWCCMN46SOG00> list, boolean more) {
    ROWCCMN46SOG00[] outputArray = new ROWCCMN46SOG00[list.size()];
    list.toArray(outputArray);

    ROWCCMN46SOG00_ARRAY rowccmn46so_array = new ROWCCMN46SOG00_ARRAY();
    rowccmn46so_array.setROWCCMN46SOG00(outputArray);
    rowccmn46so_array.setUlRowQty(outputArray.length);

    ccmn46so.setROWCCMN46SOG00_ARRAY(rowccmn46so_array);

    // ArchOutputStruct archOutputStruct = ccmn46so.getArchOutputStruct();
    ArchOutputStruct archOutputStruct = new ArchOutputStruct();
    archOutputStruct.setUlRowQty(outputArray.length);
    archOutputStruct.setBMoreDataInd(ArchitectureConstants.N);
    if (more) {
      archOutputStruct.setBMoreDataInd(ArchitectureConstants.Y);
    }
  }

  /**
   * Either retrieves the PhoneDB from the request attribute, or creates a new one and fills it with the request
   * parameters.
   */
  protected static PhoneDB getPhoneDB(HttpServletRequest request) {
    PhoneDB phoneDB = (PhoneDB) request.getAttribute(PHONE_DETAIL_PHONE);
    if (phoneDB != null) {
      GrndsTrace.msg(TRACE_TAG, 7, "retrieving phoneDB from request attribute");
      request.removeAttribute(PHONE_DETAIL_PHONE);
      return phoneDB;
    }
    GrndsTrace.msg(TRACE_TAG, 7, "retrieving phoneDB from request parameters");

    phoneDB = new PhoneDB();
    phoneDB.setPersonId(GlobalData.getUlIdPerson(request));
    phoneDB.setPersonFullName(GlobalData.getSzNmPersonFull(request));
    phoneDB.setPhoneId(ContextHelper.getIntSafe(request, "phoneId"));
    phoneDB.setPhoneType(ContextHelper.getString(request, "phoneType"));
    phoneDB.setPrimary(ContextHelper.getBooleanSafe(request, "phonePrimary"));
    phoneDB.setInvalid(ContextHelper.getBooleanSafe(request, "phoneInvalid"));
    phoneDB.setNumber(ContextHelper.getPhoneSafe(request, "phoneNumber"));

    if (ContextHelper.getStringSafe(request, "phoneExtension") == null) {
      phoneDB.setExtension(StringHelper.EMPTY_STRING);
    } else {
      phoneDB.setExtension(ContextHelper.getStringSafe(request, "phoneExtension"));
    }

    if (ContextHelper.getStringSafe(request, "phoneComments") == null) {
      phoneDB.setComments(StringHelper.EMPTY_STRING);
    } else {
      phoneDB.setComments(ContextHelper.getStringSafe(request, "phoneComments"));
    }

    String startDateString = ContextHelper.getStringSafe(request, "phoneStartDate");
    Date startDate = DateHelper.toJavaDateFromInputWithDefault(startDateString, null);
    if (startDate == null) {
      startDate = new Date();
    }
    phoneDB.setStartDate(startDate);

    String endDateString = ContextHelper.getStringSafe(request, "phoneEndDate");
    Date endDate = DateHelper.toJavaDateFromInputWithDefault(endDateString, null);
    if ((endDate == null) && (phoneDB.getInvalid())) {
      endDate = new Date();
    }
    phoneDB.setEndDate(endDate);

    long lastUpdateTime = ContextHelper.getLongSafe(request, "phoneLastUpdate");
    Date lastUpdate = null;
    if (lastUpdateTime != 0) {
      lastUpdate = new Date(lastUpdateTime);
    }
    phoneDB.setLastUpdate(lastUpdate);

    return phoneDB;
  }

  /** Converts a ROWCCMN46SOG00 to a PhoneDB */
  protected static PhoneDB toPhoneDB(ROWCCMN46SOG00 row) {
    PhoneDB phoneDB = new PhoneDB();
    phoneDB.setComments(row.getSzTxtPhoneComments());
    phoneDB.setEndDate(DateHelper.toJavaDate(row.getDtDtPersonPhoneEnd()));
    phoneDB.setExtension(row.getLNbrPhoneExtension());
    phoneDB.setInvalid(row.getBIndPersonPhoneInvalid().equals(ArchitectureConstants.Y));
    phoneDB.setLastUpdate(row.getTsLastUpdate());
    phoneDB.setNumber(row.getLNbrPhone());
    phoneDB.setPhoneId(row.getUlIdPhone());
    phoneDB.setPhoneType(row.getSzCdPhoneType());
    phoneDB.setPrimary(row.getBIndPersonPhonePrimary().equals(ArchitectureConstants.Y));
    phoneDB.setStartDate(DateHelper.toJavaDate(row.getDtDtPersonPhoneStart()));
    return phoneDB;
  }

  /** Similar to StringHelper.isTrue, except it handles null and "1" */
  protected static boolean isTrue(String string) {
    return ((string != null) && ("Y".equals(string) || "1".equals(string)));
  }

  /** Similar to StringHelper.isFalse, except it handles null and "1" */
  protected static boolean isFalse(String string) {
    return (isTrue(string) == false);
  }

  /** @todo add javadoc */
  // !!! modify StringHelper?
  // used by PhoneSub.jsp
  public static int stringToInt(String string) {
    string = safeString(string);
    if ("".equals(string)) {
      return 0;
    }
    return Integer.parseInt(string);
  }

  /** Never returns null; returns "" instead. */
  public static String safeString(String string) {
    if (string == null) {
      return "";
    }
    string = string.trim();
    if ("null".equals(string)) {
      return "";
    }
    return string;
  }

}
