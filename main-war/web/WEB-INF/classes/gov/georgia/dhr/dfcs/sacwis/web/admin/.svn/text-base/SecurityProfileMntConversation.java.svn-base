package gov.georgia.dhr.dfcs.sacwis.web.admin;

// -- javax classes --

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodeAttributes;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.LookupException;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.service.security.Security;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CARC12SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CARC13SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCARC13SIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCARC13SIG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CARC12SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC12SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC12SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;

public class SecurityProfileMntConversation extends BaseHiddenFieldStateConversation {
  public static final String TRACE_TAG = "SecurityProfileMntConversation";

  public static final String TXT_SECURITY_CLASS_PROFIL = "TxtSecurityClassProfile";

  public static final String DELETE = "D";

  public static final String NEW_USING = "N";

  public static final String ADD = "A";

  public static final String UPDATE = "U";

  public static final String REGION_12 = "BC";

  public static final String REGION_13 = "BD";

  public static final String REGION_14 = "BE";

  private Security security;

  public void setAdmin(Security security) {
    this.security = security;
  }

  public void displaySecurityProfileMnt_xa(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".securityProfileMnt_xa()");
    performanceTrace.enterScope();
    // Allocate the structures
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    state.removeAllAttributes(request);
    request.removeAttribute("CARC12S_SecurityProfiles");

    UserProfile user = UserProfileHelper.getUserProfile(context);
    ArchInputStruct input = new ArchInputStruct();
    // Set the values for the ArchInputStruct
    input.setSzUserId(user.getUserLogonID());
    input.setUsPageNbr(1);
    input.setUlPageSizeNbr(200);

    // Get the profiles and store it to request and state
    CARC12SO carc12so = this.findSecurityProfiles(context);

    /*******************************************************************************************************************
     * get the TXT_SECURITY_CLASS_PROFIL. the length is needed for creating the string in Security Detail Window *
     ******************************************************************************************************************/
    if (carc12so != null) {
      if (carc12so.getROWCARC12SOG00_ARRAY() != null) {
        String sTxtSecurityClassProfile = carc12so.getROWCARC12SOG00_ARRAY().getROWCARC12SOG00(0)
                                                  .getSzTxtSecurityClassProfil();
        state.setAttribute(TXT_SECURITY_CLASS_PROFIL, sTxtSecurityClassProfile, request);
        request.setAttribute(TXT_SECURITY_CLASS_PROFIL, sTxtSecurityClassProfile);
      }
    }
    state.setAttribute("CARC12S_SecurityProfiles", carc12so, request);
    state.setAttribute(PageMode.PAGE_MODE_ATTRIBUTE_NAME, getPageMode(request), request);
    request.setAttribute(GRNDS_QNAME_ATTRIBUTE, null);
    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }

  public void securityProfileDetail_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace("SecurityProfileConversation", "securityProfileDetail_xa");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();

    BaseSessionStateManager state = getSessionStateManager(context);
    try {
      CARC12SO carc12so = (CARC12SO) state.getAttribute("CARC12S_SecurityProfiles", request);
      String cReqFuncCd = request.getParameter("cReqFuncCd");
      ROWCARC12SOG00_ARRAY rowcarc12sog00_array = carc12so.getROWCARC12SOG00_ARRAY();

      int idIndex = -1;
      if ("N".equals(cReqFuncCd) || "D".equals(cReqFuncCd)) {
        idIndex = Integer.parseInt(request.getParameter("rbSecurityProfileRadioIndex"));
      } else if ("U".equals(cReqFuncCd)) {
        idIndex = Integer.parseInt(request.getParameter("indexNum"));
      }

      state.removeAttribute("SecurityDetail_Attribute", request);
      request.setAttribute("checkedValues", new ArrayList());
      if (idIndex != -1) {
        ROWCARC12SOG00 securityRow = rowcarc12sog00_array.getROWCARC12SOG00(idIndex);
        state.setAttribute("SecurityDetail_Attribute", securityRow, request);
        List checkedValues = setCheckBoxValues(context, securityRow.getSzTxtSecurityClassProfil());
        request.setAttribute("checkedValues", checkedValues);
      }
      state.setAttribute(PageMode.PAGE_MODE_ATTRIBUTE_NAME, getPageMode(request), request);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, " Exception executing securityDetailProfile_xa.");
      processSevereException(context, e);
    }
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  /** this function will delete one row from security_class table */
  public void deleteProfile_xa(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".deleteProfile_xa()");
    performanceTrace.enterScope();
    // Allocate the structures
    HttpServletRequest request = context.getRequest();
    // ecd BaseSessionStateManager state = getSessionStateManager( context );

    // Get the profiles and store it to request and state
    this.saveSecurityProfile(context);
    request.removeAttribute(GRNDS_QNAME_ATTRIBUTE);

    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }

  /** this function will add one row from security_class table */
  public void saveProfile_xa(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".saveProfile_xa()");
    performanceTrace.enterScope();

    // Allocate the structures
    HttpServletRequest request = context.getRequest();

    // Get the profiles and store it to request and state
    this.saveSecurityProfile(context);
    request.removeAttribute(GRNDS_QNAME_ATTRIBUTE);

    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }

  /** this function will add one new row to security_class table */
  public void newUsingProfile_xa(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".saveProfile_xa()");
    performanceTrace.enterScope();
    // Allocate the structures
    // ecd HttpServletRequest request = context.getRequest();

    // Get the profiles and store it to request and state
    this.saveSecurityProfile(context);

    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }

  /** This method calls a Tuxedo service to save of security profile * */
  private void saveSecurityProfile(GrndsExchangeContext context) {
    CARC13SI carc13si = new CARC13SI();
    HttpServletRequest request = context.getRequest();
    String cReqFuncCd;
    String Add = ADD;
    String Delete = DELETE;
    String Update = UPDATE;
    String newUsing = NEW_USING;
    String szNmSecurityClass = "";
    String messageValue = "";
    UserProfile user = UserProfileHelper.getUserProfile(context);
    try {
      BaseSessionStateManager state = getSessionStateManager(context);

      CARC12SO carc12so = (CARC12SO) state.getAttribute("CARC12S_SecurityProfiles", request);

      cReqFuncCd = request.getParameter("cReqFuncCd");

      int iIndex = -1;

      if (cReqFuncCd.equals(Delete)) {
        iIndex = Integer.parseInt(request.getParameter("rbSecurityProfileRadioIndex"));
      }
      if (cReqFuncCd.equals(newUsing) || cReqFuncCd.equals(Update)) {
        iIndex = Integer.parseInt(request.getParameter("indexNum"));
      }

      // Set cReqFuncCd to Add if the user clicks on the New Using Push Button
      if (cReqFuncCd.equals(newUsing)) {
        cReqFuncCd = Add;
      }

      // Creates a new rowcarc13sig00_array
      ROWCARC13SIG00_ARRAY rowcarc13sig00_array = new ROWCARC13SIG00_ARRAY();
      int rows = 0;

      if (cReqFuncCd.equals(Delete)) {
        ROWCARC12SOG00 rowcarc12sog00 = carc12so.getROWCARC12SOG00_ARRAY().getROWCARC12SOG00(iIndex);
        messageValue = carc12so.getROWCARC12SOG00_ARRAY().getROWCARC12SOG00(iIndex).getSzNmSecurityClass();

        ROWCARC13SIG00 rowcarc13sig00 = rowcarc12soToRowcarc13si(rowcarc12sog00);
        rowcarc13sig00.setSzCdSysDataActionOutcome(ServiceConstants.REQ_FUNC_CD_DELETE);
        rowcarc13sig00_array.addROWCARC13SIG00(rowcarc13sig00);
        rows++;
      } else {
        // get the security class that is saved in the database
        String hdnSecurityClass = request.getParameter("hdntxtSzNmSecurityClass").toUpperCase();
        if (("".equals(hdnSecurityClass) == false)
            && (hdnSecurityClass.equals(request.getParameter("txtSzNmSecurityClass")) == false)) {
          cReqFuncCd = ServiceConstants.REQ_FUNC_CD_ADD;
          ROWCARC13SIG00 rowcarc13sig00 = deleteSecProfiles(context);
          rowcarc13sig00_array.addROWCARC13SIG00(rowcarc13sig00);
          rows++;
        }

        ROWCARC12SOG00 securityProfileRow = (ROWCARC12SOG00) state.getAttribute("SecurityDetail_Attribute", request);

        Date tsLastUpdate = null;
        if (securityProfileRow != null) {
          tsLastUpdate = securityProfileRow.getTsLastUpdate();
        }

        ROWCARC13SIG00 rowcarc13sig00 = createROWCARC13SIG00(
                                                             cReqFuncCd,
                                                             request.getParameter("txtSzNmSecurityClass"),
                                                             request.getParameter("txtSzTxtSecurityClassProfil"),
                                                             CheckboxHelper.getCheckboxValue(request, "cbCIndRestrict"),
                                                             tsLastUpdate, user.getUserID());

        rowcarc13sig00_array.addROWCARC13SIG00(rowcarc13sig00);
        rows++;
      }

      ArchInputStruct archinputstruct = new ArchInputStruct();
      archinputstruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
      archinputstruct.setUlPageSizeNbr(rows);
      carc13si.setArchInputStruct(archinputstruct);

      rowcarc13sig00_array.setUlRowQty(rows);

      carc13si.setROWCARC13SIG00_ARRAY(rowcarc13sig00_array);

      // WtcHelper.callService("CARC13S", carc13si);
      security.saveSecurityClass(carc13si);

      // SQL_DUPLICATE_KEY -1
      // MSG_DUPLICATE_RECORD 9029

      // SQL_CHILD_REF_INTEGRITY -2292
      // MSG_ARC_CLASS_IN_USE 9813

      // SQL_NOT_FOUND 1403
      // MSG_CMN_TMSTAMP_MISMATCH 2046
    } catch (ServiceException we) {
      String errorMessage;
      // switch the response based on the Service Returned Error Code
      switch (we.getErrorCode()) {
      case Messages.MSG_CMN_TMSTAMP_MISMATCH:
        errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_CMN_TMSTAMP_MISMATCH);
        errorMessage = MessageLookup.addMessageParameter(errorMessage, szNmSecurityClass);
        setErrorMessage(errorMessage, "/admin/SecurityProfileMnt/saveProfile", context.getRequest());
        break;

      case Messages.MSG_ARC_CLASS_IN_USE:
        // SIR 18770 -- Added the messageValue variable to insert security profile in to the message.
        StringBuffer errorMessage2 = new StringBuffer(MessageLookup.getMessageByNumber(Messages.MSG_ARC_CLASS_IN_USE));
        errorMessage2.insert(16, messageValue);
        errorMessage2.deleteCharAt(15);
        setErrorMessage(errorMessage2.toString(), "/admin/SecurityProfileMnt/deleteProfile", context.getRequest());
        break;

      case Messages.MSG_ARC_SECURITY_CLASS_EXISTS:
        this.setPresentationBranch("duplicateRecord", context);
        errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_ARC_SECURITY_CLASS_EXISTS);
        errorMessage = MessageLookup.addMessageParameter(errorMessage, szNmSecurityClass);
        setErrorMessage(errorMessage, "/admin/SecurityProfileMnt/saveProfile", context.getRequest());
        break;

      case Messages.MSG_DUPLICATE_RECORD:
        this.setPresentationBranch("duplicateRecord", context);
        // SIR 17826 -- Changed the message being throw from MSG_DUPLICATE_RECORD
        // to MSG_DUPLICATE_PROFILE
        errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_DUPLICATE_PROFILE);
        errorMessage = MessageLookup.addMessageParameter(errorMessage, szNmSecurityClass);
        setErrorMessage(errorMessage, "/admin/SecurityProfileMnt/saveProfile", context.getRequest());
        break;

      default:
        processSevereException(context, we);
        break;
      }
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure:" + e.getMessage());
      processSevereException(context, e);
    }
  }

  private ROWCARC13SIG00 deleteSecProfiles(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    ROWCARC12SOG00 securityProfileRow = (ROWCARC12SOG00) state.getAttribute("SecurityDetail_Attribute", request);

    ROWCARC13SIG00 rowcarc13sig00 = rowcarc12soToRowcarc13si(securityProfileRow);
    rowcarc13sig00.setSzCdSysDataActionOutcome(ServiceConstants.REQ_FUNC_CD_DELETE);
    return rowcarc13sig00;
  }

  protected ROWCARC13SIG00 rowcarc12soToRowcarc13si(ROWCARC12SOG00 rowcarc12sog00) {
    return createROWCARC13SIG00(ServiceConstants.REQ_FUNC_CD_UPDATE, rowcarc12sog00.getSzNmSecurityClass(),
                                rowcarc12sog00.getSzTxtSecurityClassProfil(), rowcarc12sog00.getCIndRestrict(),
                                rowcarc12sog00.getTsLastUpdate(), rowcarc12sog00.getUlIdPerson());
  }

  protected ROWCARC13SIG00 createROWCARC13SIG00(String action, String securityClass, String profile,
                                                String cIndRestrict, Date tsLastUpdate, Integer idUser) {
    securityClass = securityClass.toUpperCase();

    ROWCARC13SIG00 rowcarc13sig00 = new ROWCARC13SIG00();
    rowcarc13sig00.setSzCdSysDataActionOutcome(action);
    rowcarc13sig00.setSzNmSecurityClass(securityClass);
    rowcarc13sig00.setSzTxtSecurityClassProfil(profile);
    rowcarc13sig00.setUlIdEmployee(idUser);

    if (ArchitectureConstants.Y.equals(cIndRestrict) == false) {
      cIndRestrict = ArchitectureConstants.N;
    }
    rowcarc13sig00.setCIndRestrict(cIndRestrict);

    if (ServiceConstants.REQ_FUNC_CD_ADD.equals(action) == false) {
      rowcarc13sig00.setSzCdEmpSecurityClassNm(securityClass);
      rowcarc13sig00.setTsLastUpdate(tsLastUpdate);
    }
    return rowcarc13sig00;
  }

  /** This method calls a Tuxedo service to get the Security Profiles */
  private CARC12SO findSecurityProfiles(GrndsExchangeContext context) {
    CARC12SO carc12so = null;

    GrndsTrace.enterScope(TRACE_TAG + ".findSecurityProfile");
    try {
      CARC12SI carc12si = new CARC12SI();
      UserProfile user = UserProfileHelper.getUserProfile(context);
      ArchInputStruct input = new ArchInputStruct();
      // Set the values for the ArchInputStruct
      input.setSzUserId(user.getUserLogonID());
      input.setUsPageNbr(1);
      input.setUlPageSizeNbr(200);
      carc12si.setArchInputStruct(input);

      // Call WTC
      // carc12so = CARC12SO.unmarshal(new StringReader(WtcHelper.callService("CARC12S", carc12si)));
      carc12so = security.retrieveSecurityClass(carc12si);
    } catch (ServiceException we) {
      // switch the response based on the Service Returned Error Code
      switch (we.getErrorCode()) {
      case Messages.SSM_NO_ROWS_RETURNED:
        this.setPresentationBranch("NoRecordReturned", context);
        String errorMessage = MessageLookup.getMessageByName("SSM_NO_ROWS_RETURNED");
        setErrorMessage(errorMessage, "/admin/SecurityProfileMnt/SecurityProfileMnt", context.getRequest());
        break;

      default:
        GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
        processSevereException(context, we);
        break;
      }
    }

    catch (Exception ve) {
      GrndsTrace.msg(TRACE_TAG, 7, " Failure:" + ve.getMessage());
      processSevereException(context, ve);
    }
    // catch (MarshalException me) {
    // GrndsTrace.msg(TRACE_TAG, 7, "Marshalling Failure:" + me.getMessage());
    // processSevereException(context, me);
    // }

    GrndsTrace.exitScope( /* carc12so */);
    return carc12so;
  }

  /** This function accepts a string and creates a Vector that is used to populate a page of checkboxes. */
  private List setCheckBoxValues(GrndsExchangeContext context, String sTmp) {
    List<String> checkedValues = new ArrayList<String>();
    try {
      List securityAttr = buildSecurityAttr(context);
      for (int i = 0; i < sTmp.length(); i++) {
        if (sTmp.charAt(i) == '1') {
          checkedValues.add((String) securityAttr.get(i));
        }
      }
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "setCheckBoxValues fail: " + e.getMessage());
      processSevereException(context, e);
    }
    GrndsTrace.msg(TRACE_TAG, 10, "securityAttr_is = \n" + checkedValues.toString());
    return checkedValues;
  }

  /** This submodule finds page mode */
  private String getPageMode(HttpServletRequest request) {
    String pageMode;
    UserProfile userProfile = UserProfileHelper.getUserProfile(request);
    // ecd List regionAccess = new ArrayList();
    boolean userHasAllPrivelege = false;
    boolean userHasPartialPrivelege = false;
    if (userProfile != null) {
      // Check if user has SEC_RESTRICT_SEC rights.
      // IT Security attribute (SEC_RESTRICT_SEC) will be able to add, modify, and delete all profiles.
      userHasAllPrivelege = userProfile.hasRight(UserProfile.SEC_RESTRICT_SEC);

      // Maintain Security Profile attribute (SEC_MNTN_SEC_PROFILE) will be
      // able to add, modify, and delete all profiles that are not designated
      // as Restricted IT Security.
      userHasPartialPrivelege = userProfile.hasRight(UserProfile.SEC_MNTN_SEC_PROFILE);
    }
    if (userHasAllPrivelege || userHasPartialPrivelege) {
      pageMode = PageModeConstants.EDIT;
    } else {
      pageMode = PageModeConstants.VIEW;
    }
    return pageMode;
  }

  /** This submodule creates a string that is used to populate a page of checkboxes */
  private List<String> buildSecurityAttr(GrndsExchangeContext context) throws LookupException {
    HttpServletRequest request = context.getRequest();
    List<String> arrayListSecAttr = new ArrayList<String>();
    List<String> arryayExcludeRegion = new ArrayList<String>();
    String sExcludeRegion = "";
    // Get all securities from the security codestable.
    Collection securityCollection = Lookup.getCategoryCollection(CodesTables.CSECATTR);

    // Build the security String.
    Iterator securityIterator = securityCollection.iterator();
    while (securityIterator.hasNext()) {
      CodeAttributes security = (CodeAttributes) securityIterator.next();
      arrayListSecAttr.add(security.getCode());
      // Sir# 19653. Added if statement to find the positions of regions 12, 13, 14
      // in the txt_security_class_profile field in security_class table
      /*
      if (security.getCode().compareToIgnoreCase(REGION_12) == 0
          || security.getCode().compareToIgnoreCase(REGION_13) == 0
          || security.getCode().compareToIgnoreCase(REGION_14) == 0) {
        sExcludeRegion = sExcludeRegion.concat("1");
        arryayExcludeRegion.add(security.getCode());
      } else {
        sExcludeRegion = sExcludeRegion.concat("0");
      }
      */
    }
    /* Sir#19653. added sExcludeRegion & arryayExcludeRegion to the request */
    request.setAttribute("sExcludeRegion", sExcludeRegion);
    request.setAttribute("arryayExcludeRegion", arryayExcludeRegion);
    return arrayListSecAttr;
  }
}