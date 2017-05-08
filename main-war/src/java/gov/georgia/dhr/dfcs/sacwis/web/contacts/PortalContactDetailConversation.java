package gov.georgia.dhr.dfcs.sacwis.web.contacts;

import gov.georgia.dhr.dfcs.sacwis.core.base.BaseValueBean;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PlatformConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodeAttributes;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.LookupException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.document.NewUsingDocumentValueBean;
import gov.georgia.dhr.dfcs.sacwis.service.common.Common;
import gov.georgia.dhr.dfcs.sacwis.service.document.DocumentSave;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSYS03SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSYS04SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSYS07SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSYS08SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ContactCbxRecord;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ContactCbxRecord_Array;
import gov.georgia.dhr.dfcs.sacwis.structs.input.DiscussedPersonsSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.DiscussedPersonsSI_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCLSC97DIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCLSC97DIG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSVC02SIG03;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSVC02SIG03_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSYS04SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSYS04SI_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSYS07SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSYS07SI_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEDISCUSSED;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEDISCUSSED_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEPRIVCONVER;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEPRIVCONVER_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDISCUSSED;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDISCUSSED_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWPRIVCONVER;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWPRIVCONVER_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ValidateContactDateSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSYS03SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSYS04SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSYS07SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSYS08SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ContactCbxDisplay;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ContactCbxDisplay_Array;
import gov.georgia.dhr.dfcs.sacwis.structs.output.EventIdStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.EventIdStruct_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN45DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN50DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN50DO_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS04SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS04SO_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS08SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS08SO_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWDISCUSSEDSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWDISCUSSEDSO_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWPRIVCONVERSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWPRIVCONVERSO_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.TCMClaimValidateSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.TmScrTmCntct_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.web.core.base.ValueBeanHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelperException;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.pagination.TuxedoPaginationValueBean;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.web.document.DocumentRecordHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

/**
 * <p>Title: PortalContactDetailConversation</p> 
 * <p>Description: This is the Conversation class used to display contacts for
 * the SHINES Vendor Portal.
 * <p/>
 * <pre>
 * Change History:
 * Date      User              Description
 * --------  ----------------  ----------------------------------------------
 * 11/08/09  Patrick Coogan    Created new class as copy of main-war Contact
 *                             SearchListConversation for use in SHINES vendor
 *                             portal.
 * 05/26/11  schoi             SMS #109398: MR-086 Added a new field 'Discussed/In Reference To'   
 * 06/02/11  schoi             SMS #109398: MR-086 Per code peer review finding, added comment 
 *                             regarding previous code update made on 05/26/11 
 *                          
 * </pre>
 *
 * @author Patrick Coogan, October 26, 2009
 */
@SuppressWarnings("serial")
public class PortalContactDetailConversation extends BaseHiddenFieldStateConversation {

  public static final String DETAIL_CONTACT = "DETAIL_CONTACT";
  public static final String SUMMARY_CONTACT = "SUMMARY_CONTACT";
  public static final String INITIAL_CONTACT = "INITIAL_CONTACT";

  public static final String TRACE_TAG = "PortalContactDetailConversation";
  public static final String DISPLAY_LIST_PAGE = "/contacts/ContactSearchListDetail/displayContactSearchList";
  public static final String DISPLAY_DETAIL_PAGE = "/contacts/ContactSearchListDetail/displayContact";
  public static final String VISITATION_NARRATIVE_TABLE_NAME = "CONTACT_VISITATION_NARRATIVE"; //Used to save narrative of type PCV
  public static final String SAFETY_RSRC_ASMNT_NARR_TABLE_NAME = "SAFETY_RSRC_ASMNT_NARR";
  public static final String NARRATIVE_TABLE_NAME = "CONTACT_NARRATIVE"; //Used to save narratives of type Blank and SPW
  public static final String CSYS08S = "CSYS08S";
  public static final String ROWCSYS04SO_STRING = "rowcsys04so";
  public static final String GENERALFAILURE = "General Failure:";
  public static final String SZCDCONTACTMETHOD = "szCdContactMethod";
  public static final String SZCDCONTACTPURPOSE = "szCdContactPurpose";
  public static final String CONTACTTYPE = "contactType";
  public static final String BINDCONTACTATTEMPTED = "bIndContactAttempted";
  public static final String DTDTCONTACTOCCURRED = "dtDtContactOccurred";
  public static final String CBXBINDCONTACTATTEMPTED = "cbxBIndContactAttempted";
  public static final String CBXBINDEXTCOMMENT = "cbxBIndExtComment";
  public static final String SELSZCDCONTACTMETHOD = "selSzCdContactMethod";
  public static final String SELSZCDCONTACTPURPOSE = "selSzCdContactPurpose";
  public static final String SELSZCDCONTACTTYPE = "selSzCdContactType";
  public static final String SELSZCDCONTACTLOCATION = "selSzCdContactLocation";
  public static final String SELSZCDCONTACTOTHERS = "selSzCdContactOthers";
  public static final String TXTDTDTMONTHLYSUMMBEGIN = "txtDtDtMonthlySummBegin";
  public static final String TXTDTDTMONTHLYSUMMEND = "txtDtDtMonthlySummEnd";
  public static final String TXTDTDTCONTACTOCCURRED = "txtDtDtContactOccurred";
  public static final String TXTTMSCRCNTCT = "txtTmScrTmCntct";
  public static final String DOCEXISTS = "docExists";
  public static final String GENERIC_CONTACT = "CONNARR";
  public static final String HDNULROWSELECTED = "hdnUlRowSelected";
  public static final String HDNENTEREDON = "hdnEnteredOn";  //MR-024
  public static final String ULROWSELECTED = "ulRowSelected";
  public static final String DISABLE_TCM_GUARANTOR_PC_NAME = "disable_selGuarantorPC";

  public static final String CONTACT_TYPE_REGULAR = "REG";
  
  public static final String CONTACTS_ADO = "8520";
  public static final String CONTACTS_SUB = "3010";

  public static final String STAGE_CODE_CPS_SVC = "FPR";
  public static final String STAGE_CODE_FMR = "FRE";
  public static final String STAGE_CODE_FSC = "FSU";
  public static final String STAGE_CODE_FAD = "FAD";
  public static final String STAGE_CODE_SUB = "SUB";
  public static final String STAGE_CODE_APS_SVC = "SVC";
  public static final String STAGE_CODE_INV = "INV";
  public static final String STAGE_CODE_ADO = "ADO";

    
  private static final Set<String> CONTACTS_TASK_CODES = new HashSet<String>() {
    {
      add(CONTACTS_ADO);
      add(CONTACTS_SUB);
    }
  };
  
  private static final String MSG_CMN_NO_PC = "No Primary Child was found for this stage.";

  private Common common;
  private DocumentSave documentSave;

  public void setCommon(Common common) {
    this.common = common;
  }

  public void setDocumentSave(DocumentSave documentSave) {
    this.documentSave = documentSave;
  }
  
  /**
   * This helper method populates the input object for the csys03s retrieve service.
   *
   * @param context The GrndsExchangeContext object.
   * @return csys03si
   */
  private CSYS03SI populateCSYS03SI_Retrieve(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".populateCSYS03SI_Retrieve()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();

    CSYS03SI csys03si = new CSYS03SI();
    UserProfile user = UserProfileHelper.getUserProfile(context);
    ArchInputStruct input = new ArchInputStruct();

    input.setUsPageNbr(1);
    input.setUlPageSizeNbr(50);
    input.setSzUserId(user.getUserLogonID());
    csys03si.setArchInputStruct(input);
    csys03si.setUlIdStage(GlobalData.getUlIdStage(request));

    performanceTrace.exitScope();
    return csys03si;
  }

  /**
   * This helper method populates the input object for the csys04s retrieve service.
   *
   * @param context    The GrndsExchangeContext object
   * @param pagination TuxedoPaginationValueBean.
   * @return csys04si
   */
  private CSYS04SI populateCSYS04SI_Retrieve(GrndsExchangeContext context, TuxedoPaginationValueBean pagination) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".populateCSYS04SI_Retrieve()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();

    CSYS04SI csys04si = new CSYS04SI();
    UserProfile user = UserProfileHelper.getUserProfile(context);
    ArchInputStruct input = new ArchInputStruct();

    input.setUsPageNbr(pagination.getResultDetails().getRequestedPage());
    input.setUlPageSizeNbr(pagination.getResultDetails().getResultsPerPage());
    input.setSzUserId(user.getUserLogonID());
    csys04si.setArchInputStruct(input);
    csys04si.setUlIdStage(GlobalData.getUlIdStage(request));
    csys04si.setUlIdCase(GlobalData.getUlIdCase(request));
    //set the values for the Principals/Collaterals if any were checked
    ROWCSYS04SI_ARRAY csys04siArray = new ROWCSYS04SI_ARRAY();
    
    //see if the stage is a FSD stage and is sealed if so set the sealed date 
    CaseUtility.Stage stage = CaseUtility.getStage(GlobalData.getUlIdStage(request));
    csys04si.setDtDtStageSealed((ArchitectureConstants.Y.equals(stage.getIndSealed()) && CodesTables.CSTAGES_FAD.equals(stage.getCdStage()))? stage.getDtSealed() : null);

    //if deletedDetail != null then we don't populate anything else for CSYS04SI
    if (request.getAttribute("deletedDetail") == null) {
      String[] collateralsPrincipalsArray = CheckboxHelper.getCheckedValues(request, "cbxUlIdPerson");
      for (int i = 0; i < collateralsPrincipalsArray.length; i++) {
        ROWCSYS04SI csys04siRow = new ROWCSYS04SI();
        csys04siRow.setUlIdPerson(Integer.parseInt(collateralsPrincipalsArray[i]));
        csys04siArray.addROWCSYS04SI(csys04siRow);
      }

      //set the array into the si object after all of the rows are added
      csys04si.setROWCSYS04SI_ARRAY(csys04siArray);

      // Todo: Shouldn't this line be here???
      csys04si.setUlRowQty(csys04siArray.getUlRowQty());

      // if the Contacts for Case Checkbox is checked then set UlIdCase to
      // GlobalData.UlCaseId, otherwise set it to 0 so the service will do a
      // search including all stages.
      // MR-024
      csys04si.setUlIdCase(GlobalData.getUlIdCase(request));
      if (StringHelper.isValid(ContextHelper.getStringSafe(request, "btnSearch.x"))) {
        if ("on".equals(ContextHelper.getStringSafe(request, "cbxUlIsCase"))) {
          csys04si.setUlIdCase(GlobalData.getUlIdCase(request));          
        } else {
          csys04si.setUlIdCase(0);
        }
        request.setAttribute("SEARCHBTN", "true");
      } else {
        request.setAttribute("SEARCH_ENTIRE_CASE", "true");
      }
  
      csys04si.setDtScrSearchDateFrom(ContextHelper.getCastorDateSafe(request, "dtScrSearchDateFrom"));
      csys04si.setDtScrSearchDateTo(ContextHelper.getCastorDateSafe(request, "dtScrSearchDateTo"));
      csys04si.setSzCdContactType(ContextHelper.getStringSafe(request, SELSZCDCONTACTTYPE));
      csys04si.setSzCdContactPurpose(ContextHelper.getStringSafe(request, SELSZCDCONTACTPURPOSE));
      csys04si.setSzCdContactMethod(ContextHelper.getStringSafe(request, SELSZCDCONTACTMETHOD));
      csys04si.setSzCdContactLocation(ContextHelper.getStringSafe(request, SELSZCDCONTACTLOCATION));
      csys04si.setSzCdContactOthers(ContextHelper.getStringSafe(request, SELSZCDCONTACTOTHERS));
      //STGAP00014326 MR -024 set Purpose options
      String[] purposeChecks = CheckboxHelper.getCheckedValues(request, "cbxContactPurpose");      
      ContactCbxRecord_Array cbxArray = new ContactCbxRecord_Array();      
      for(String contactPurpose : purposeChecks) {
          ContactCbxRecord cbx = new ContactCbxRecord();
          cbx.setSzCdCbxCodeType(CodesTables.CCNTPURP);
          cbx.setSzCdContactCbx(contactPurpose);
          cbxArray.addContactCbxRecord(cbx);
          }
      csys04si.setContactCbxRecord_Array(cbxArray);     
      
      // SMS #109398: MR-086 
      // Set the values for the Discussed/In Reference To if any were checked
      DiscussedPersonsSI_ARRAY discussedPersonsSI_ARRAY = new DiscussedPersonsSI_ARRAY();
      String[] discussedInReferenceToArray = CheckboxHelper.getCheckedValues(request, "cbxDiscussed");
      for (int i = 0; i < discussedInReferenceToArray.length; i++) {
        DiscussedPersonsSI discussedPersonsSI = new DiscussedPersonsSI();
        discussedPersonsSI.setUlIdPerson(Integer.parseInt(discussedInReferenceToArray[i]));
        discussedPersonsSI_ARRAY.addDiscussedPersonsSI(discussedPersonsSI);
      }

      // set the array into the si object after all of the rows are added
      csys04si.setDiscussedPersonsSI_ARRAY(discussedPersonsSI_ARRAY);
      // End SMS #109398: MR-086
    }

    performanceTrace.exitScope();
    return csys04si;
  }

  
  /**
   * This helper method populates the input object for the csys07s AUD service.
   *
   * @param context The GrndsExchangeContext object
   * @return csys07si
   * @throws CheckboxHelperException
   */
  private CSYS07SI populateCSYS07SI_AUD(GrndsExchangeContext context)
          throws CheckboxHelperException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".populateCSYS07SI_AU()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();

    CSYS07SI csys07si = new CSYS07SI();
    ArchInputStruct input = new ArchInputStruct();
    UserProfile user = UserProfileHelper.getUserProfile(context);
    ROWCCMN01UIG00 rowccmn01uig00 = new ROWCCMN01UIG00();
    ROWCSVC02SIG03_ARRAY rowcsvc02sig03_array = new ROWCSVC02SIG03_ARRAY();
    ROWCLSC97DIG00_ARRAY rowclsc97dig00_array = new ROWCLSC97DIG00_ARRAY();
    ROWCSYS07SI_ARRAY rowcsys07si_array = new ROWCSYS07SI_ARRAY();

    CSYS08SO csys08so = getCSYS08SO(request);
    if (csys08so == null) {
      csys08so = new CSYS08SO();
    }

    ROWCCMN45DO rowccmn45do = csys08so.getROWCCMN45DO();
    if (rowccmn45do == null) {
      rowccmn45do = new ROWCCMN45DO();
    }

    // If this is a NEW record the csys08so contact type will
    // not be filled so we grab the value from the hidden field on the contact detail page.
    String szCdContactType = ContextHelper.getStringSafe(request, "selSzCdContactType");
    if (szCdContactType == null) {
      szCdContactType = csys08so.getSzCdContactType();
    }
    if (szCdContactType.length() <= 3) {
      throw new IllegalStateException("szCdContactType(2) length is <= 3: '" + szCdContactType + "'");
    }
    String szScrTxtNarrStatus = csys08so.getSzScrTxtNarrStatus();

    // Get AUD Codes from checkboxes into SI objects
    ROWCSYS08SO_ARRAY contactList = csys08so.getROWCSYS08SO_ARRAY();
    int ulRowSelected = 0;

    BaseSessionStateManager state = getSessionStateManager(context);
     
    Collection contactChecks = CheckboxHelper.getChangedValues(request, "cbxUlIdPerson", contactList,
                                                                 ROWCSYS08SO.class, "ulIdPerson");

    Iterator i = contactChecks.iterator();
    while (i.hasNext()) {
        CheckboxHelper.ObjectActionCodePair pair = (CheckboxHelper.ObjectActionCodePair) i.next();
        String actionCode = pair.getActionCode();
        ROWCSYS08SO contact = (ROWCSYS08SO) pair.getObject();
        ROWCSVC02SIG03 rowcsvc02sig03 = new ROWCSVC02SIG03();
        rowcsvc02sig03.setUlIdPerson(contact.getUlIdPerson());
        rowcsvc02sig03.setSzCdScrDataAction(actionCode);
        rowcsvc02sig03.setTsLastUpdate(contact.getTsLastUpdate());
        rowcsvc02sig03_array.addROWCSVC02SIG03(rowcsvc02sig03);

        ROWCSYS07SI rowcsys07si = new ROWCSYS07SI();
        rowcsys07si.setUlIdPerson(contact.getUlIdPerson());
        rowcsys07si.setSzCdScrDataAction(actionCode);
        rowcsys07si.setTsLastUpdate(contact.getTsLastUpdate());
        rowcsys07si_array.addROWCSYS07SI(rowcsys07si);

        ROWCLSC97DIG00 rowclsc97dig00 = new ROWCLSC97DIG00();
        rowclsc97dig00.setUlIdPerson(contact.getUlIdPerson());
        rowclsc97dig00_array.addROWCLSC97DIG00(rowclsc97dig00);
        ulRowSelected++;
    
      rowcsvc02sig03_array.setUlRowQty(rowcsvc02sig03_array.getROWCSVC02SIG03Count());
      rowcsys07si_array.setUlRowQty(rowcsys07si_array.getROWCSYS07SICount());
      rowclsc97dig00_array.setUlRowQty(rowclsc97dig00_array.getROWCLSC97DIG00Count());
    }
      
      // STGAP00014326 MR-024
      String[] privConversationChecks = CheckboxHelper.getCheckedValues(request, "cbxPrivConver");
      ROWPRIVCONVER_ARRAY privConversation_array = new ROWPRIVCONVER_ARRAY();
      ROWDELETEPRIVCONVER_ARRAY privDeleteConversation_array = new ROWDELETEPRIVCONVER_ARRAY();
      ROWPRIVCONVERSO_ARRAY rowPrivConverSOARRAY = (ROWPRIVCONVERSO_ARRAY) state
                                                                                .getAttribute(
                                                                                              "savedPrivConversationArray",
                                                                                              request);
     

      if (rowPrivConverSOARRAY != null) {
        Enumeration<ROWPRIVCONVERSO> privConverEnumeration = rowPrivConverSOARRAY.enumerateROWPRIVCONVERSO();
        while (privConverEnumeration.hasMoreElements()) {
          ROWPRIVCONVERSO rowPrivConverso = (ROWPRIVCONVERSO) privConverEnumeration.nextElement();
          Integer idPersonToDelete = rowPrivConverso.getUlIdPerson();
          ROWDELETEPRIVCONVER rowDeletePrivConversation = new ROWDELETEPRIVCONVER();
          rowDeletePrivConversation.setUlIdPerson(idPersonToDelete);
          privDeleteConversation_array.addROWDELETEPRIVCONVER(rowDeletePrivConversation);
        }
      }
      privDeleteConversation_array.setUlRowQty(privDeleteConversation_array.getROWDELETEPRIVCONVERCount());

      for (int j = 0; j < privConversationChecks.length; j++) {
        Integer idPerson = (Integer) (contactList.getROWCSYS08SO()[Integer.parseInt(privConversationChecks[j])]
                                                                                                               .getUlIdPerson());
        ROWPRIVCONVER rowPrivConversation = new ROWPRIVCONVER();
        rowPrivConversation.setUlIdPerson(idPerson);
        privConversation_array.addROWPRIVCONVER(rowPrivConversation);
        privConversation_array.setUlRowQty(privConversation_array.getROWPRIVCONVERCount());
      }

      // SMS #109398: MR-086
      // This is a production defect; because of removeAttribute call below, ROWDELETEPRIVCONVER_ARRAY 
      // has been always empty, so the record(s) in the CONTACT_PRIV_CONVER_CBX is not deleted.
      // Therefore, removed the call removeAttribute
      
      //remove after forming add and delete lists, 
      // state.removeAttribute("savedPrivConversationArray", request);
      // End SMS #109398: MR-086
      csys07si.setROWPRIVCONVER_ARRAY(privConversation_array);
      csys07si.setROWDELETEPRIVCONVER_ARRAY(privDeleteConversation_array);
    
    
    //End STGAP00014326 MR-024 
    
    // SMS #109398: MR-086
    // Add code per new field 'Discussed/In Reference To'
    // discussed_array will hold checkbox update and deleteDiscussed_array will hold 
    // the checkbox(es) stored in the database  
    String[] discussedPersonsChecks = CheckboxHelper.getCheckedValues(request, "cbxDiscussed");
    ROWDISCUSSED_ARRAY discussed_array = new ROWDISCUSSED_ARRAY();
    ROWDELETEDISCUSSED_ARRAY deleteDiscussed_array = new ROWDELETEDISCUSSED_ARRAY();
    ROWDISCUSSEDSO_ARRAY rowDiscussedSOARRAY = (ROWDISCUSSEDSO_ARRAY) state
                                                                           .getAttribute("savedDiscussedArray", request);

    if (rowDiscussedSOARRAY != null) {
      Enumeration<ROWDISCUSSEDSO> discussedEnumeration = rowDiscussedSOARRAY.enumerateROWDISCUSSEDSO();
      while (discussedEnumeration.hasMoreElements()) {
        ROWDISCUSSEDSO rowDiscussedso = (ROWDISCUSSEDSO) discussedEnumeration.nextElement();
        Integer idPersonToDelete = rowDiscussedso.getUlIdPerson();
        ROWDELETEDISCUSSED rowDeleteDiscussed = new ROWDELETEDISCUSSED();
        rowDeleteDiscussed.setUlIdPerson(idPersonToDelete);
        deleteDiscussed_array.addROWDELETEDISCUSSED(rowDeleteDiscussed);
      }
    }
    deleteDiscussed_array.setUlRowQty(deleteDiscussed_array.getROWDELETEDISCUSSEDCount());

    for (int j = 0; j < discussedPersonsChecks.length; j++) {
      Integer idPerson = (Integer) (contactList.getROWCSYS08SO()[Integer.parseInt(discussedPersonsChecks[j])]
                                                                                                             .getUlIdPerson());
      ROWDISCUSSED rowDiscussed = new ROWDISCUSSED();
      rowDiscussed.setUlIdPerson(idPerson);
      discussed_array.addROWDISCUSSED(rowDiscussed);
      discussed_array.setUlRowQty(discussed_array.getROWDISCUSSEDCount());
    }

    csys07si.setROWDISCUSSED_ARRAY(discussed_array);
    csys07si.setROWDELETEDISCUSSED_ARRAY(deleteDiscussed_array);

    // End SMS #109398: MR-086
      
    input.setSzUserId(user.getUserLogonID());
    int ulIdEvent = GlobalData.getUlIdEvent(request);

    String cReqFuncCd;
    if (StringHelper.isValid(ContextHelper.getStringSafe(request, "btnDelete.x"))) {
      cReqFuncCd = ServiceConstants.REQ_FUNC_CD_DELETE;
    } else if (ulIdEvent != 0) {
      cReqFuncCd = ServiceConstants.REQ_FUNC_CD_UPDATE;
    } else {
      cReqFuncCd = ServiceConstants.REQ_FUNC_CD_ADD;
    }
    input.setCReqFuncCd(cReqFuncCd);

    //If contact type is null and eventStatus is new then the Page Size = 1
    // NOTE:  We want to use the contact type we retrieved from csys08so, not the
    // szCdContactType string we initialize at the beginning of this method because
    // that will not be null even if this is a new record.
    if (CodesTables.CEVTSTAT_NEW.equals(rowccmn45do.getSzCdEventStatus()) &&
        (csys08so.getSzCdContactType() == null || "".equals(csys08so.getSzCdContactType()))) {
      input.setUlPageSizeNbr(1);
    } else {
      input.setUlPageSizeNbr(0);
    }
      input.setUsPageNbr(1);
    
    // We use the ulSysNbrReserved1 to tell the service we are in approval mode.  If we are
    // in approval mode, the service will not invalidate the pending approval.
    input.setUlSysNbrReserved1(GlobalData.getApprovalFlag(request));
    rowccmn01uig00.setSzCdTask(GlobalData.getSzCdTask(request));

    //We only need to set this Timestamp for Delete & Update
    if (cReqFuncCd.equals(ServiceConstants.REQ_FUNC_CD_DELETE) ||
        cReqFuncCd.equals(ServiceConstants.REQ_FUNC_CD_UPDATE)) {
      rowccmn01uig00.setTsLastUpdate(rowccmn45do.getTsLastUpdate());
    }

    String szCdEventStatus = rowccmn45do.getSzCdEventStatus();
    if (szCdEventStatus == null) {
      szCdEventStatus = "";
    }

    // Always pass in the event from csys08so so we invalidate the approval when we need to do so
    csys07si.setUlIdEvent(csys08so.getUlIdEvent());

    // If we are in APPROVAL mode, we don't want to modify the event status.
    if (!ArchitectureConstants.Y.equals(GlobalData.getApprovalFlag(request))) {
      //If Status is not PENDing set it to COMPlete or PROCess
      if (!szCdEventStatus.equals(CodesTables.CEVTSTAT_PEND) ||
          PageMode.getPageMode(request).equals(PageModeConstants.NEW_USING)) {
        // Upgrade event to completed if meets requirements
        // (Save enabled, Narrative stored or exists)
        if ("24H".equals(szCdContactType) ||
            "REG".equals(szCdContactType) ||
            "CCA".equals(szCdContactType) ||
            "MST".equals(szCdContactType) ||
            "MTG".equals(szCdContactType) ||
            "PHS".equals(szCdContactType) ||
            "CMP".equals(szCdContactType) ||
            "ATP".equals(szCdContactType) ||
            "DVP".equals(szCdContactType) ||
            "MAS".equals(szCdContactType) ||
            "QUV".equals(szCdContactType) ||
            "REA".equals(szCdContactType) ||
            "SEI".equals(szCdContactType) ||
            "VAR".equals(szCdContactType) ||
            "VIO".equals(szCdContactType) ||
            "REV".equals(szCdContactType)) {
          szCdEventStatus = "COMP";
        } else if ("MTH".equals(szCdContactType) && csys08so.getDtDtMonthlySummBegin().getDay() > (short) 0 &&
                   !"".equals(csys08so.getBScrIndStructNarrExists()) || !"".equals(szScrTxtNarrStatus)) {
          szCdEventStatus = "COMP";
        } else if (!"MTH".equals(szCdContactType) && !"".equals(csys08so.getBScrIndStructNarrExists()) ||
                   !"".equals(szScrTxtNarrStatus)) {
          szCdEventStatus = "COMP";
        } else {
          szCdEventStatus = "PROC";
        }
      }
    }
    rowccmn01uig00.setSzCdEventStatus(szCdEventStatus);
    
    String stageType = CaseUtility.getStage(GlobalData.getUlIdStage(request)).getCdStage();
    String taskCode = "";
    if (STAGE_CODE_SUB.equals(stageType)){
      taskCode = CONTACTS_SUB;
    } else if (STAGE_CODE_ADO.equals(stageType)){
      taskCode = CONTACTS_ADO;
    }
    rowccmn01uig00.setSzCdTask(taskCode);
    
    rowccmn01uig00.setSzCdEventType("CON");

    if (cReqFuncCd.equals(ServiceConstants.REQ_FUNC_CD_ADD)) {
      rowccmn01uig00.setUlIdEvent(0);
    //SIR 15161 - Need the Event date to be the system date of data entry
      rowccmn01uig00.setDtDtEventOccurred(DateHelper.getTodayCastorDate());
    } else {
      rowccmn01uig00.setUlIdEvent(GlobalData.getUlIdEvent(request));    
      //Added this line so that the dtEntered field in Event table is not changed when you update a contact.
      rowccmn01uig00.setDtDtEventOccurred(csys08so.getDtDTContactEntered());
    }
    rowccmn01uig00.setUlIdStage(GlobalData.getUlIdStage(request));
    rowccmn01uig00.setUlIdPerson(GlobalData.getUlIdPerson(request));

    rowcsvc02sig03_array.setUlRowQty(rowcsvc02sig03_array.getROWCSVC02SIG03Count());

    csys07si.setUlIdCase(GlobalData.getUlIdCase(request));
    csys07si.setSzCdStage(GlobalData.getSzCdStage(request));
    csys07si.setSzCdStageType(GlobalData.getSzCdStageType(request)); //SIR 15280 added

    csys07si.setSzCdStageClassification(csys08so.getSzCdStageClassification());
    if (csys08so.getUlNbrReviewContact() > 0) {
      csys07si.setBIndReview(ArchitectureConstants.Y);
    } else {
      csys07si.setBIndReview(ArchitectureConstants.N);
    }
    csys07si.setTsSysTsLastUpdate2(csys08so.getTsSysTsLastUpdate2());
    csys07si.setBIndVictimSelected(ContextHelper.getStringSafe(request, "hdnBVictimSelected"));
    //csys07si.setSzNmPersonFull(ContextHelper.getStringSafe(request, "szNmPersonFull"));
    //csys07si.setUlIdPerson(ContextHelper.getIntSafe(request, "hdnUlIdPerson"));
    csys07si.setSzNmAgencyName(ContextHelper.getStringSafe(request, "szNmAgencyName"));
    csys07si.setSzCdContactLocation(ContextHelper.getStringSafe(request, SELSZCDCONTACTLOCATION));
    csys07si.setSzCdContactMethod(ContextHelper.getStringSafe(request, SELSZCDCONTACTMETHOD));
    csys07si.setSzCdContactOthers(ContextHelper.getStringSafe(request, SELSZCDCONTACTOTHERS));
    String contactType = ContextHelper.getStringSafe(request, SELSZCDCONTACTTYPE);
    csys07si.setSzCdContactType(contactType);
    csys07si.setUlIdPortalUser(csys08so.getUlIdPortalUser());
    csys07si.setSzNmPortalUserFull(ContextHelper.getStringSafe(request, "szNmPersonFull"));
   
    //STGAP00014326 MR-024 Changes  //TODO 
    Date dtToday = new Date();
    csys07si.setSzCdContactedBy(ContextHelper.getStringSafe(request, "rbContactedBy"));
    
    if (ContextHelper.getBooleanSafe(request, "hidDeleteDocument")) {
      csys07si.setTsSysTsLastUpdate3(csys08so.getTsLastUpdate());
    }
    //STGAP00015281 : Check if the hdnDocExits is false, if it is false set the BIndDeleteDoc to Y ,
    // Save service will delete the narrative from the Contact_Narrative table if BIndDeleteDoc is Y.
    if(ContextHelper.getBooleanSafe(request, "hidDeleteDocument") && ArchitectureConstants.FALSE.equals(ContextHelper.getStringSafe(request,"hdnDocExists"))){
      csys07si.setBIndDeleteDoc(ArchitectureConstants.Y);
    }
    if (CodesTables.CCCONTBY_DFC.equals(csys07si.getSzCdContactedBy())){
    csys07si.setSzNmContactedBy(ContextHelper.getStringSafe(request, "szNmContactedByStaff"));  
    }else if(CodesTables.CCCONTBY_CCA.equals(csys07si.getSzCdContactedBy()))  {
    csys07si.setSzNmContactedBy(ContextHelper.getStringSafe(request, "szNmContactedByCCA"));
    }else {
    csys07si.setSzNmContactedBy(ContextHelper.getStringSafe(request, "szNmContactedByXXX"));
    }
    csys07si.setSzCdContactNarrative(ContextHelper.getStringSafe(request, "rbNarrType"));
    //Set EnteredOn date only once during initial save
    //Check if we already have a date on the page, as the field is disabled, you will not get it from request 
    // so use a hidden field.
    org.exolab.castor.types.Date enteredOn = ContextHelper.getCastorDateSafe(request, HDNENTEREDON);
        
    
    //STGAP00015282: When copying a contact the dtContactEntered should be the day on which the copy event was created.
    if(PageModeConstants.NEW_USING.equals(PageMode.getPageMode(request))){
    csys07si.setDtDTContactEntered(DateHelper.toCastorDate(dtToday)); 
    }else if(StringHelper.isNotEmptyOrNull(enteredOn)){    
    csys07si.setDtDTContactEntered(enteredOn); 
    }else{
    csys07si.setDtDTContactEntered(DateHelper.toCastorDate(dtToday));
    }
    
    List<String> newContactPurpose= Arrays.asList(CheckboxHelper.getCheckedValues(request, "cbxContactPurpose"));
    List<String> oldContactPurpose = new ArrayList<String>();
    ContactCbxDisplay_Array oldContactPurposeArray = csys08so.getContactCbxDisplay_Array();
    if ((oldContactPurposeArray != null) && (!(cReqFuncCd.equals(ServiceConstants.REQ_FUNC_CD_ADD)))) {
      Enumeration oldContactPurposeArrayEnumeration = oldContactPurposeArray.enumerateContactCbxDisplay();
      while (oldContactPurposeArrayEnumeration.hasMoreElements()) {
        // Get all the Saved Purpose options and add it to the oldContactPurpose array list.
        ContactCbxDisplay oldContactCbx = (ContactCbxDisplay) oldContactPurposeArrayEnumeration.nextElement();
        String cdCbxCodeType = oldContactCbx.getSzCdCbxCodeType();
        String cdPurpose = oldContactCbx.getSzCdContactCbx();
        if (CodesTables.CCNTPURP.equals(cdCbxCodeType)) {
          oldContactPurpose.add(cdPurpose);
        }
      }
    }    
    Collection<String> allContactPurpose = null;
    try {
      allContactPurpose = Lookup.getCategoryCodesCollection(CodesTables.CCNTPURP);
    } catch(LookupException le) {
      throw new IllegalStateException("Lookup data has not been initialized. Contact tech support for assistance.");
    }
    ContactCbxRecord_Array cbxArray = new ContactCbxRecord_Array();
   
    //STGAP00015191 and STGAP00015282
    if (PageModeConstants.NEW_USING.equals(PageMode.getPageMode(request))) {
      for (String contactPurpose : allContactPurpose) {
        if (newContactPurpose.contains(contactPurpose)) {
          ContactCbxRecord cbx = new ContactCbxRecord();
          cbx.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_ADD);
          cbx.setSzCdCbxCodeType(CodesTables.CCNTPURP);
          cbx.setSzCdContactCbx(contactPurpose);
          cbxArray.addContactCbxRecord(cbx);
        }
      }
    } else {
      for (String contactPurpose : allContactPurpose) {
        if (newContactPurpose.contains(contactPurpose) && !oldContactPurpose.contains(contactPurpose)) {
          ContactCbxRecord cbx = new ContactCbxRecord();
          cbx.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_ADD);
          cbx.setSzCdCbxCodeType(CodesTables.CCNTPURP);
          cbx.setSzCdContactCbx(contactPurpose);
          cbxArray.addContactCbxRecord(cbx);
        }

        if (!newContactPurpose.contains(contactPurpose) && oldContactPurpose.contains(contactPurpose)) {
          ContactCbxRecord cbx = new ContactCbxRecord();
          cbx.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_DELETE);
          cbx.setSzCdCbxCodeType(CodesTables.CCNTPURP);
          cbx.setSzCdContactCbx(contactPurpose);
          cbxArray.addContactCbxRecord(cbx);
        }
      }
    }
    
    //End STGAP00014326 MR-024 Changes
    
    csys07si.setContactCbxRecord_Array(cbxArray);
    
    // STGAP00015320: Cycle through the list of purposes selected in the request and add each purpose to
    // Event description untill length of eventdescription is less than 97 characters.
    // SIR 14291 - don't add the '-' and purpose for the three month review type
    // because there is no purpose code to add for that type. Later on in csys07,
    // the szTxtEventDescr is looked at, and having the extra '-' causes problems
    // with not moving contacts & events to the SVC stage.
    String szTxtEventDescr = StringHelper.EMPTY_STRING;
    int descrLength = 0;
    szTxtEventDescr = Lookup.simpleDecodeSafe("CCNTCTYP", ContextHelper.getStringSafe(request, SELSZCDCONTACTTYPE));
    if (newContactPurpose != null && !newContactPurpose.isEmpty()) {
      String cdPurpose = null;
      String decodePurpose = null;
      List<String> decodePurposeList = new ArrayList<String>();
      Iterator<String> newContactPurposeIt = newContactPurpose.iterator();
      while (newContactPurposeIt.hasNext()) {
        cdPurpose = newContactPurposeIt.next();
        decodePurpose = Lookup.simpleDecodeSafe("CCNTPURP", cdPurpose);
        decodePurposeList.add(decodePurpose);
      }
      Collections.sort(decodePurposeList);
      Iterator<String> decodePurposeListIt = decodePurposeList.iterator();

      szTxtEventDescr += " - ";
      while (decodePurposeListIt.hasNext()) {
        decodePurpose = decodePurposeListIt.next();
        szTxtEventDescr += decodePurpose;
        if (decodePurposeListIt.hasNext()) {
          szTxtEventDescr += ", ";
        }
        descrLength = szTxtEventDescr.length();
        if (descrLength >= 100) {
          szTxtEventDescr = szTxtEventDescr.substring(0, 96);
          szTxtEventDescr += "...";
          break;
        }
      }

    }
       
    rowccmn01uig00.setSzTxtEventDescr(szTxtEventDescr);
    
    //-- Add TCM-specific fields *******************************************************
    if(contactType.endsWith("TCM")) {
      csys07si.setUlIdTCMClient(ContextHelper.getIntSafe(request, "selGuarantorPC"));
      csys07si.setSzCdTCMEligible(ContextHelper.getStringSafe(request, "selEligible"));
      csys07si.setSzCdTCMMedSvcs(ContextHelper.getStringSafe(request, "selMedSvcs"));
      
      List<String> newEligProgs = Arrays.asList(CheckboxHelper.getCheckedValues(request, "cbxEligProgs_"));
      List<String> newMedSvcs = Arrays.asList(CheckboxHelper.getCheckedValues(request, "cbxSvcsProvided_"));
      List<String> oldEligProgs = new ArrayList<String>();
      List<String> oldMedSvcs = new ArrayList<String>();
      //-- get oldEligProgs and oldMedSvcs
      //MR-024 As the contact is now modifiable, get the saved checkboxes which are used later
      //to compare with the current checkboxes on the page.
      ContactCbxDisplay_Array oldEligProgsArray = csys08so.getContactCbxDisplay_Array();
      if (oldEligProgsArray != null) {
        Enumeration oldEligProgsArrayEnumeration = oldEligProgsArray.enumerateContactCbxDisplay();
        while (oldEligProgsArrayEnumeration.hasMoreElements()) {
          // Get all the Saved EligProgs options and add it to the oldEligProgsArray array list.
          ContactCbxDisplay oldContactCbx = (ContactCbxDisplay) oldEligProgsArrayEnumeration.nextElement();
          String cdCbxCodeType = oldContactCbx.getSzCdCbxCodeType();
          String eligProg = oldContactCbx.getSzCdContactCbx();
          if (CodesTables.CTCMPROG.equals(cdCbxCodeType)) {
            oldEligProgs.add(eligProg);
          }
        }
      }
      
      ContactCbxDisplay_Array oldMedSvcsArray = csys08so.getContactCbxDisplay_Array();
      if (oldMedSvcsArray != null) {
        Enumeration oldMedSvcsArrayEnumeration = oldMedSvcsArray.enumerateContactCbxDisplay();
        while (oldMedSvcsArrayEnumeration.hasMoreElements()) {
          // Get all the Saved EligProgs options and add it to the oldEligProgsArray array list.
          ContactCbxDisplay oldContactCbx = (ContactCbxDisplay) oldMedSvcsArrayEnumeration.nextElement();
          String cdCbxCodeType = oldContactCbx.getSzCdCbxCodeType();
          String medSvcs = oldContactCbx.getSzCdContactCbx();
          if (CodesTables.CTCMSVCS.equals(cdCbxCodeType)) {
            oldMedSvcs.add(medSvcs);
          }
        }
      }
      
      Collection<String> allEligProgs = null;
      Collection<String> allMedSvcs = null;
      try {
        allEligProgs = Lookup.getCategoryCodesCollection(CodesTables.CTCMPROG);
        allMedSvcs = Lookup.getCategoryCodesCollection(CodesTables.CTCMSVCS);
      } catch(LookupException le) {
        throw new IllegalStateException("Lookup data has not been initialized. Contact tech support for assistance.");
      }
      
      for(String eligProg : allEligProgs) {
        if(newEligProgs.contains(eligProg) && !oldEligProgs.contains(eligProg)) {
          ContactCbxRecord cbx = new ContactCbxRecord();
          cbx.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_ADD);
          cbx.setSzCdCbxCodeType(CodesTables.CTCMPROG);
          cbx.setSzCdContactCbx(eligProg);
          cbxArray.addContactCbxRecord(cbx);
        }
        
        if(!newEligProgs.contains(eligProg) && oldEligProgs.contains(eligProg)) {
          ContactCbxRecord cbx = new ContactCbxRecord();
          cbx.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_DELETE);
          cbx.setSzCdCbxCodeType(CodesTables.CTCMPROG);
          cbx.setSzCdContactCbx(eligProg);
          cbxArray.addContactCbxRecord(cbx);
        }
      }
      
      for(String medSvc : allMedSvcs) {
        if(newMedSvcs.contains(medSvc) && !oldMedSvcs.contains(medSvc)) {
          ContactCbxRecord cbx = new ContactCbxRecord();
          cbx.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_ADD);
          cbx.setSzCdCbxCodeType(CodesTables.CTCMSVCS);
          cbx.setSzCdContactCbx(medSvc);
          cbxArray.addContactCbxRecord(cbx);
        }
        
        if(!newMedSvcs.contains(medSvc) && oldMedSvcs.contains(medSvc)) {
          ContactCbxRecord cbx = new ContactCbxRecord();
          cbx.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_DELETE);
          cbx.setSzCdCbxCodeType(CodesTables.CTCMSVCS);
          cbx.setSzCdContactCbx(medSvc);
          cbxArray.addContactCbxRecord(cbx);
        }
      }
      
      csys07si.setContactCbxRecord_Array(cbxArray);
    }
    //-- *******************************************************************************
    String bIndContactAttempted = CheckboxHelper.getCheckboxValue(request, CBXBINDCONTACTATTEMPTED);
    if (!bIndContactAttempted.equals(ArchitectureConstants.Y)) {
      bIndContactAttempted = ArchitectureConstants.N;
    }
    csys07si.setBIndContactAttempted(bIndContactAttempted);
    
    String bIndExtComment = CheckboxHelper.getCheckboxValue(request, CBXBINDEXTCOMMENT);
    if (!bIndExtComment.equals(ArchitectureConstants.Y)) {
      bIndExtComment = ArchitectureConstants.N;
    }
    csys07si.setIndExtDocAccepted(bIndExtComment);
    
    String bIndCrossCountyLines = ArchitectureConstants.N;
    if("on".equals(ContextHelper.getStringSafe(request, "chkCrossCountyLines"))) {
      bIndCrossCountyLines = ArchitectureConstants.Y;
    }
    csys07si.setBIndCrossCountyLines(bIndCrossCountyLines);

    // SIR 18274 - This section sets the Date and Time to the current date and
    // time if the contact Type is and EEXR and the UlidEvent == 0
    if (CodesTables.CCNTCTYP_EEXR.equals(szCdContactType) &&
        GlobalData.getUlIdEvent(request) == 0) {
      csys07si.setDtDTContactOccurred(DateHelper.getTodayCastorDate());
      csys07si.setTmScrTmCntct(ContextHelper.getTimeSafe(request, "txtTmScrTmCntct"));
    } else {
      csys07si.setDtDTContactOccurred(ContextHelper.getCastorDateSafe(request, TXTDTDTCONTACTOCCURRED));
      csys07si.setTmScrTmCntct(ContextHelper.getTimeSafe(request, TXTTMSCRCNTCT));
    }

    csys07si.setDtDtMonthlySummEnd(ContextHelper.getCastorDateSafe(request, TXTDTDTMONTHLYSUMMEND));
    csys07si.setDtDtMonthlySummBegin(ContextHelper.getCastorDateSafe(request, TXTDTDTMONTHLYSUMMBEGIN));
    csys07si.setUlRowSelected(ulRowSelected);

    csys07si.setROWCCMN01UIG00(rowccmn01uig00);
    csys07si.setArchInputStruct(input);
    csys07si.setROWCSVC02SIG03_ARRAY(rowcsvc02sig03_array);
    csys07si.setROWCSYS07SI_ARRAY(rowcsys07si_array);
    csys07si.setROWCLSC97DIG00_ARRAY(rowclsc97dig00_array);

    performanceTrace.exitScope();
    return csys07si;
  }

  /**
   * This helper method populates the input object for the csys08s retrieve service.
   *
   * @param context    The GrndsExchangeContext object
   * @param pagination TuxedoPaginationValueBean
   * @param ulIdEvent  int
   * @return csys08si
   */
  private CSYS08SI populateCSYS08SI_Retrieve(GrndsExchangeContext context,
                                             TuxedoPaginationValueBean pagination,
                                             int ulIdEvent) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".populateCSYS08SI_Retrieve()");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();

    CSYS08SI csys08si = new CSYS08SI();
    UserProfile user = UserProfileHelper.getUserProfile(context);
    ArchInputStruct input = new ArchInputStruct();

    input.setUsPageNbr(pagination.getResultDetails().getRequestedPage());
    input.setUlPageSizeNbr(pagination.getResultDetails().getResultsPerPage());
    input.setSzUserId(user.getUserLogonID());
    
    csys08si.setArchInputStruct(input);
    csys08si.setUlIdCase(GlobalData.getUlIdCase(request));

    csys08si.setUlIdEvent(ulIdEvent);

    csys08si.setUlIdStage(GlobalData.getUlIdStage(request));
    
    String contactType = "REG";

    String narrType = ContextHelper.getStringSafe(request, "rbNarrType");
    if (contactType != null){
      csys08si.setSzSysTxtTablename(NARRATIVE_TABLE_NAME);
    }
    performanceTrace.exitScope();
    return csys08si;
  }
  
  /**
   * This method is the main call for Adding.  This method has been changed for 
   * portal by wrapping the retrieve method within an "add portal contact" service
   * which performs the necessary overrides for setting the portal view of the page.
   *
   * @param context The GrndsExchangeContext object.
   */
  public void addContact_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".addContact_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    PageMode.setPageMode(PageModeConstants.NEW, request);

    try {
      
      TuxedoPaginationValueBean pagination = new TuxedoPaginationValueBean();
      ValueBeanHelper.populateDefaultValues(context, pagination);
      pagination.getResultDetails().setResultsPerPage(50);

      GlobalData.setUlIdEvent(0, request);
      
      UserProfile user = UserProfileHelper.getUserProfile(context);
      Integer portalUser = user.getUserID();
      Integer idRsrcFacil;
      Integer idRsrcAgency;
      Integer idResource;
      
      idRsrcFacil = ContextHelper.getIntSafe(context, "hdnUlIdPlcmtFacil");
      idRsrcAgency = ContextHelper.getIntSafe(context, "hdnUlIdPlcmtAgency");
      
      if (idRsrcAgency > 0){
        idResource = idRsrcAgency;
      } else {
        idResource = idRsrcFacil;
      }
      
      CSYS08SI csys08si = populateCSYS08SI_Retrieve(context, pagination, GlobalData.getUlIdEvent(request));
      
      CSYS08SO csys08so = common.addPortalContactDetail(csys08si, portalUser, idResource);
      
      csys08so.setSzCdContactType(getTypeKey(request)+CONTACT_TYPE_REGULAR);
      
      ArchOutputStruct archOutputStruct = new ArchOutputStruct();
      archOutputStruct.setBMoreDataInd("N");
      csys08so.setArchOutputStruct(archOutputStruct);
      
      state.setAttribute("CSYS08SO", csys08so, request);
      state.setAttribute("hdnUlIdPlcmtFacil", idRsrcFacil, request);
      state.setAttribute("hdnUlIdPlcmtAgency", idRsrcAgency, request);
      
      pagination.setPaginationInformation(csys08so.getArchOutputStruct(),0);

      request.setAttribute(BaseValueBean.REQUEST_ATTRIBUTE_NAME, pagination);
    }
    catch (ServiceException we) {
      handleContactDetailDisplayError(we, context);
    }
    catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, GENERALFAILURE + e.getMessage());
      processSevereException(context, e);
    }

    performanceTrace.exitScope();
  }

  
  /**
   * This method calls the populate csys08si_Retireve and handleContactDisplayError methods.
   *
   * @param context The GrndsExchangeContext object.
   */
  public void displayContact_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayContact_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    String allowModifyOfFormOnClosed = ArchitectureConstants.N;
    //Portal: We will allow add on closed during time period up to when the child disappears from portal (30 days)
    String allowAddOnClosedStage = ArchitectureConstants.Y;
    
    int ulIdEvent = ContextHelper.getIntSafe(request,"hdnUlIdEvent");
    Integer idRsrcFacil;
    Integer idRsrcAgency;
    Integer idPlcmtResource;
    
    idRsrcFacil = ContextHelper.getIntSafe(context, "hdnUlIdPlcmtFacil");
    idRsrcAgency = ContextHelper.getIntSafe(context, "hdnUlIdPlcmtAgency");
    
    if (idRsrcAgency > 0){
      idPlcmtResource = idRsrcAgency;
    } else {
      idPlcmtResource = idRsrcFacil;
    }
    
    
    if (ulIdEvent == 0) {
    
      ulIdEvent = GlobalData.getUlIdEvent(request);
    }
    
    GlobalData.setUlIdEvent(ulIdEvent, request);

    if (ulIdEvent == 0) {
      setPresentationBranch("ADD_CONTACT", context);
      return;
    }
    
    PageMode.setPageMode("EDIT", request);

    try {
      TuxedoPaginationValueBean pagination = new TuxedoPaginationValueBean();
      ValueBeanHelper.populateDefaultValues(context, pagination);
      pagination.getResultDetails().setResultsPerPage(50);

      CSYS08SI csys08si = populateCSYS08SI_Retrieve(context, pagination, ulIdEvent);
      CSYS08SO csys08so = common.contactDetailRetrieve(csys08si);

      if (StringHelper.isValid(csys08so.getSzCdContactType()) == false) {
        setPresentationBranch("ADD_CONTACT", context);
        PageMode.setPageMode(PageModeConstants.NEW, request);
        return;
      }

      ROWCCMN45DO rowccmn45do = csys08so.getROWCCMN45DO();
      if (rowccmn45do == null) {
        rowccmn45do = new ROWCCMN45DO();
      }


      // SIR 18353 - Added to if statement to make sure that the NewUsing button
      // had not been pressed, otherwise we'd erroneously keep NewUsed Approved
      // contacts from being able to be saved.
      else if (CodesTables.CEVTSTAT_APRV.equals(rowccmn45do.getSzCdEventStatus()) &&
               !StringHelper.isValid(ContextHelper.getStringSafe(request, "btnNewUsing.x"))) {
        //!!! I think EventSearchConversation should handle this fine
        PageMode.setPageMode(PageModeConstants.VIEW, request);
      }

      // SIR 18885; !!! this allows anyone to edit approved events in AFC/INV stages
      ROWCCMN45DO eventDetail = csys08so.getROWCCMN45DO();
      if (eventDetail == null) {
        eventDetail = new ROWCCMN45DO();
      }

      String pageMode = PageModeConstants.VIEW;
      
      if ((eventDetail.getUlIdStage() != GlobalData.getUlIdStage(request)) &&
          (!pageMode.equals(PageModeConstants.NEW)) &&
          (!pageMode.equals(PageModeConstants.NEW_USING))) {
        // FIXME: This does nothing because the assignment is never used!
          pageMode = PageModeConstants.VIEW;
      }

      CaseUtility.Stage stage = CaseUtility.getStage("" + csys08si.getUlIdStage());
      boolean stageClosed = false;
      if(stage.getDtClose() != null){
        stageClosed = true;
      }
      
      if (stageClosed && ArchitectureConstants.Y.equals(allowAddOnClosedStage)) {  
        Date stageClosureDate = DateHelper.toJavaDateSafe(stage.getDtClose(), "12:00 am");  
         
        stageClosureDate = DateHelper.addToDate(stageClosureDate, 0, 0, 1);  
        Date dtContactLsUpdate = csys08so.getTsSysTsLastUpdate2();  
         
  
        if (DateHelper.isNull(dtContactLsUpdate) == false && DateHelper.isNull(stageClosureDate) == false) {  
          if (stageClosureDate.before(dtContactLsUpdate)) {  
            allowModifyOfFormOnClosed = ArchitectureConstants.Y;  
          }  
        }  
        
      }
        
      // STGAP00014326 MR-024
      // Check to see if the sysdate - Entered On date is greater than 7days.
      // then page mode should be view only PageMode.setPageMode(PageModeConstants.VIEW, request);
      // Also Check if the status of the TCM claim corresponding to the Contact is Not Billed.
      Date dtToday = new Date();
      boolean editAllowedForSevenDays = false;
      boolean editAllowed = false;
      boolean isContactAuthor = false;
      boolean isAdmin = false;
      boolean isLockedByDFCS = false;
      boolean isTCMNotBilled = false;
      boolean isDateBeforeStageClose = true;
      int caseId = GlobalData.getUlIdCase(request);
      int stageId = GlobalData.getUlIdStage(request);
      UserProfile userProfile = getUserProfile(request);
      int userId = userProfile.getUserID();

      if (csys08so.getDtDTContactEntered() != null) {
        Date weekAfterEnteredOn = DateHelper.addToDate(csys08so.getDtDTContactEntered(), 0, 0, 7).toDate();
        editAllowedForSevenDays = DateHelper.isBefore(dtToday, weekAfterEnteredOn);
      }
      
      //We are not giving portal users ongoing comment access
 
      boolean hasFormCommentsAccess = false;
      String sHasFormCommentsAccess = String.valueOf(hasFormCommentsAccess);   
      state.setAttribute("FORMCOMMENTSACCESS", sHasFormCommentsAccess, request);
      boolean contactStageClosed = false; //Stage in which the contact was done
      
      CaseUtility.Stage contactStage = CaseUtility.getStage("" + csys08so.getROWCCMN45DO().getUlIdStage());
      if(contactStage.getDtClose() != null){
        contactStageClosed = true;
      }
      
      if (contactStageClosed) {
        // Check if the contact was before stageClosed or after Stageclosed
        // Check if the stageClosureDate is less than sysdate and that the contact was done before stageclosure, if yes
        // contact is not modifiable
        Date stageClosureDate = DateHelper.toJavaDateSafe(contactStage.getDtClose(), "12:00 am");
        Date dtContactEntered = DateHelper.toJavaDateSafe(csys08so.getDtDTContactEntered(), "12:00 am");
        if (csys08so.getDtDTContactEntered() != null) {
          boolean isContactBeforeStageClosure = (DateHelper.isBefore(dtContactEntered, stageClosureDate));
          if (isContactBeforeStageClosure) {
            isDateBeforeStageClose = true; // now the contact is not modifiable i.e the contact was entered before
            // stage closure, 7 day
            // scenario will be taken care of by the editAllowed variable.
          } else {
            isDateBeforeStageClose = false; // Contact was entered after the stage was closed.
          }
        }
      } else {
        isDateBeforeStageClose = false; // that means the stage is still open
      }
      
      //Check if the logged in user is the original Contact Author.     
      if (userId == csys08so.getUlIdPortalUser()) {
        isContactAuthor = true;
      }
      
      //Check if the logged in user is an administrator
      Map<Integer, String> rsrcMap = new HashMap<Integer, String>();
      rsrcMap = userProfile.getRsrcMap();
      
      List<Integer> vendorStaffList = new ArrayList<Integer>();
      List<Integer> adminList = new ArrayList<Integer>();
      
      vendorStaffList.addAll(rsrcMap.keySet());
      for(Iterator<Integer> it = vendorStaffList.iterator();it.hasNext();){
        
        Integer resourceId = it.next();
        String userType = rsrcMap.get(resourceId);
      
        if (CodesTables.CUSRTYP_PAD.equals(userType)){
          adminList.add(resourceId); 
        }
      }
      if (idRsrcAgency>0){
        
        isAdmin = adminList.contains(idRsrcAgency);
        
      } else if (idRsrcFacil > 0) {
        
        isAdmin = adminList.contains(idRsrcFacil);
        
      }
      
      
      //Verify that contacts have not been accepted
      
      if (ArchitectureConstants.Y.equals(csys08so.getIndExtDocAccepted()!=null ? csys08so.getIndExtDocAccepted():"N")){
        isLockedByDFCS = true;
      }
      
      // This is checked in the retrieve service
      String contactType = ContextHelper.getStringSafe(request, "selSzCdContactType");
      if (!contactType.endsWith("TCM")) {
        isTCMNotBilled = true;
      } else {
        isTCMNotBilled = csys08so.getBIndTcmNBLStatus();
      }
      
      editAllowed = editAllowedForSevenDays && (isContactAuthor||isAdmin) && isTCMNotBilled && !(isLockedByDFCS);
      boolean sausealedhomeandworker = false;
      
      if (editAllowed ||(sausealedhomeandworker && editAllowedForSevenDays && (isContactAuthor||isAdmin))) {
        PageMode.setPageMode(PageModeConstants.EDIT, request);
      }
      
      String editAllowed1 = String.valueOf(editAllowed);
      
      state.setAttribute("EDITALLOWEDFORSEVENDAYS", String.valueOf(editAllowedForSevenDays), request);
      state.setAttribute("SAUSEALEDHOMEANDWORKER", String.valueOf(sausealedhomeandworker), request);
      state.setAttribute("EDITALLOWED", editAllowed1, request);
      state.setAttribute("ISDATEBEFORESTAGECLOSE", String.valueOf(isDateBeforeStageClose), request);
      state.setAttribute("CSYS08SO", csys08so, request);
      state.setAttribute("allowFormModifyOnClosedStage", allowModifyOfFormOnClosed, request);
      state.setAttribute("hdnUlIdPlcmtFacil",idRsrcFacil,request);
      state.setAttribute("hdnUlIdPlcmtAgency",idRsrcAgency,request);
      
      ArchOutputStruct archOutputStruct = new ArchOutputStruct();
      archOutputStruct.setBMoreDataInd("N");
      csys08so.setArchOutputStruct(archOutputStruct);

      pagination.setPaginationInformation(csys08so.getArchOutputStruct(),
                                          csys08so.getROWCSYS08SO_ARRAY().getROWCSYS08SOCount());

      request.setAttribute(BaseValueBean.REQUEST_ATTRIBUTE_NAME, pagination);

      if (csys08so.getTsLastUpdate() != null) {
        request.setAttribute(DOCEXISTS, ArchitectureConstants.TRUE);
      } else {
        request.setAttribute(DOCEXISTS, ArchitectureConstants.FALSE);
      }

    }
    catch (ServiceException we) {
      handleContactDetailDisplayError(we, context);
    }
    catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, GENERALFAILURE + e.getMessage());
      processSevereException(context, e);
    }

    performanceTrace.exitScope();
  }


  /**
   * This method is the main call for saving.
   *
   * @param context The GrndsExchangeContext object.
   */
  public void saveContact_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".saveContact_xa()");
    performanceTrace.enterScope();

    try {
      //We do this validation first in portal only to ensure not before date worker started
      boolean afterStart = validateSave(context);
      if (afterStart) { 
      saveDetail(context);
      } else {
        setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
        setErrorMessage("You cannot enter a contact prior to your start date with the agency or facility with which the child is placed.", context.getRequest());
      }
    }
    catch (ServiceException we) {
      handleContactDetailAUDError(we, context);
    }
    catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }

    performanceTrace.exitScope();
  }

  
  public static CSYS08SO getCSYS08SO(HttpServletRequest request) {
    BaseSessionStateManager state = getSessionStateManager(request);
    return (CSYS08SO) state.getAttribute("CSYS08SO", request);
  }
  
  public static List<CodeAttributes> getTypeOptions(HttpServletRequest request) {
    List<CodeAttributes> typeOptions = new ArrayList<CodeAttributes>();
    List<CodeAttributes> codesTable = null;
    try {
      codesTable = Lookup.getCategoryCollectionSortedByDecode(CodesTables.CCNTCTYP);
    } catch(LookupException le) {
      throw new IllegalStateException("Lookup data has not been initialized. Contact tech support for assistance.");
    }
    
    if(codesTable != null) {
      String typeKey = getTypeKey(request);
      for(CodeAttributes codeAttr : codesTable) {
        if(codeAttr.getCode().startsWith(typeKey)) {
          typeOptions.add(codeAttr);
        }
      }
    }
    
    return typeOptions;
  }
  //For the first release of portal, we will only allow announced and unannounced face to face contacts
  public static List<CodeAttributes> getMethodOptions(HttpServletRequest request, boolean filter) {
    List<CodeAttributes> methodOptions = new ArrayList<CodeAttributes>();
    List<CodeAttributes> codesTable = null;
    try {
      codesTable = Lookup.getCategoryCollectionSortedByDecode(CodesTables.CCNTMETH);
    } catch(LookupException le) {
      throw new IllegalStateException("Lookup data has not been initialized. Contact tech support for assistance.");
    }
    
    if(codesTable != null) {
      
      for(CodeAttributes codeAttr : codesTable) {
        if (CodesTables.CCNTMETH_ATF.equals(codeAttr.getCode())||CodesTables.CCNTMETH_UTF.equals(codeAttr.getCode())){
          methodOptions.add(codeAttr);
        }  
      }
    }
    
    return methodOptions;
  }

  /**
   * This helper method is called by deleteContact and saveContact to handle any ServiceExceptions by setting the
   * branch, looking up the error message and setting it.
   *
   * @param we      The ServiceException object.
   * @param context The GrndsExchangeContext object.
   */
  private void handleContactDetailAUDError(ServiceException we, GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();

    int errorCode = we.getErrorCode();
    switch (errorCode) {
      
      case Messages.TOO_MANY_CONTACTS_IN_MONTHLY:
      case Messages.MSG_CMN_TMSTAMP_MISMATCH:
      case Messages.MSG_SVC_DELETE_CONTACT:
      case Messages.MSG_SVC_NO_SUMMARY_DATES:
      case Messages.MSG_SVC_STRUCTURED_NARR:
      case Messages.MSG_SYS_EVENT_STS_MSMTCH:
      case Messages.MSG_SYS_MULT_INST:
      case Messages.MSG_SYS_STAGE_CLOSED:
      case Messages.MSG_VICTIM_NOT_SELECTED:
      case Messages.MSG_SVC_TCM_EXISTS:
      case Messages.MSG_SVC_TCM_DOB:
      case Messages.MSG_SVC_TCM_ID:
        setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
        setErrorMessage(errorCode, request);
        break;
      default:
        processSevereException(context, we);
        break;
    }
  }
  
  /**
   * This helper method is called by the Save and Save and Submit activity methods. It will save the contact detail
   * utilizing the CSYS07S AUD service.
   *
   * @param context GrndsExchangeContext
   * @return CSYS07SO (used for save and submits)
   * @throws ServiceException
   * @throws CheckboxHelperException
   */
  private CSYS07SO saveDetail(GrndsExchangeContext context)
          throws ServiceException, CheckboxHelperException {
    HttpServletRequest request = context.getRequest();
    CSYS07SI csys07si = populateCSYS07SI_AUD(context);
    
    String contactType = csys07si.getSzCdContactType();
    
    CSYS07SO csys07so = common.contactDetailSave(csys07si);
      
    CSYS08SO csys08so = getCSYS08SO(request);
    if(csys08so != null) {
      csys08so.setUlIdEvent(0);
    }

    GlobalData.setUlIdEvent(csys07so.getUlIdEvent(), request);
    request.setAttribute("sEvent", String.valueOf(GlobalData.getUlIdEvent(request)));
    request.setAttribute("sCase", String.valueOf(GlobalData.getUlIdCase(request)));

    PageMode.setPageMode(PageModeConstants.EDIT, request);
    
    return csys07so;
  }

  /**
   * This helper method is called by the Save activity method to verify 
   * that the contact is not being entered for a date prior to the user
   * joining the agency or facility
   *
   * @param context GrndsExchangeContext
   * @return result
   * @throws ServiceException
   * @throws CheckboxHelperException
   */
  private boolean validateSave(GrndsExchangeContext context)
          throws ServiceException, CheckboxHelperException {
    
    CSYS07SI csys07si = populateCSYS07SI_AUD(context);
    int idRsrcFacil = ContextHelper.getIntSafe(context, "hdnUlIdPlcmtFacil");
    int idRsrcAgency = ContextHelper.getIntSafe(context, "hdnUlIdPlcmtAgency");
    UserProfile user = UserProfileHelper.getUserProfile(context);
    boolean result = true;
   
    
    // Storing both Agency resource id and Facility resource id into the SI.  
    ValidateContactDateSI validateContactDateSI = new ValidateContactDateSI();
    validateContactDateSI.setDtContactDate((csys07si.getDtDTContactOccurred()).toDate());
    validateContactDateSI.setUlIdFacilResource(idRsrcFacil);
    validateContactDateSI.setUlIdAgcyResource(idRsrcAgency);
    validateContactDateSI.setUlIdUser(user.getUserID());
     
    result = common.validateContactDate(validateContactDateSI);
      
    return result;
  }

  
  /**
   * This helper method is called by the displayContactDetal method to handle and ServiceException by setting the
   * branch, looking up the error message and setting it.
   *
   * @param we      The ServiceException object.
   * @param context The GrndsExchangeContext object.
   */
  private void handleContactDetailDisplayError(ServiceException we, GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();

    int errorCode = we.getErrorCode();
    switch (errorCode) {
      case Messages.MSG_CMN_TMSTAMP_MISMATCH:
      case Messages.MSG_CONFIRM_ON_EXIT:
      case Messages.MSG_FAD_SUBMIT_SUM:
      case Messages.MSG_SVC_CONTACT_DOESNT_EXIST:
      case Messages.MSG_SVC_DELETE_CONTACT:
      case Messages.MSG_SVC_NO_SUMMARY_DATES:
      case Messages.MSG_SVC_STRUCTURED_NARR:
        setErrorMessage(errorCode, request);
        break;

      default:
        processSevereException(context, we);
        break;
    }
  }

  /**
   * This helper method will determine the task code we need to pass to the To Do Detail page.
   *
   * @param context  GrndsExchangeContext
   * @param csys07so CSYS07SO
   * @return toDoDetailDB
   */
  
  /**
   * <p>This submethod is called by the displayContact_xa() method.  It will determine where the user is coming from and
   * obtain a ulIdEvent based on this.  We are handling 5 different ways for the user to access the page.</p>
   * <p>Cases:</p>
   * <p/>
   * <blockquote> <ol> <li>The user selected a hyperlink from the Search List page.</li> <li>The user is performing a
   * New Using from the Search List page.</li> <li>The user is Adding a Contact/Summary from the Search List page.</li>
   * <li>The user is accessing the detail page from a Navigable To Do.</li> <li>The user is paginating on the page or
   * the page is reloading from a Save or Save and Submit.</li></ol> </blockquote>
   *
   * @param context GrndsExchangeContext
   * @return ulIdEvent
   */
  private int getUlIdEvent(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    ROWCSYS04SO_ARRAY rowcsys04soArray = (ROWCSYS04SO_ARRAY)
            state.getAttribute("rowcsys04soArray", request);

    if (rowcsys04soArray == null) {
      rowcsys04soArray = new ROWCSYS04SO_ARRAY();
    }

    ROWCSYS04SO rowcsys04so = new ROWCSYS04SO();

    // CASE 1:  User selected a HYPERLINK
    // Check to see if HDNULROWSELECTED is valid.  If it is valid, this means the user
    // selected a hyperlink and the value was set in the javascript function.
    if (StringHelper.isValid(ContextHelper.getStringSafe(request, HDNULROWSELECTED))) {
      int ulRowSelected = ContextHelper.getIntSafe(request, HDNULROWSELECTED);
      if (ulRowSelected < rowcsys04soArray.getROWCSYS04SOCount()) {
        rowcsys04so = rowcsys04soArray.getROWCSYS04SO(ulRowSelected);
      }
      return rowcsys04so.getUlIdEvent();
    }
    // CASE 2:  User selected a row and clicked NEW USING
    else if (StringHelper.isValid(ContextHelper.getStringSafe(request, "btnNewUsing.x"))) {
      int ulRowSelected = ContextHelper.getIntSafe(request, ULROWSELECTED);
      if (ulRowSelected < rowcsys04soArray.getROWCSYS04SOCount()) {
        rowcsys04so = rowcsys04soArray.getROWCSYS04SO(ulRowSelected);
      }
      return rowcsys04so.getUlIdEvent();
    }
    // CASE 3:  User clicked the ADD button on the Contact Search List page.
    // CASE 4:  User is navigating the Contact Detail directly from Case To Do, Staff To Do,
    // or the Event List - all these conversations will put the ulIdEvent into Global Data.
    // CASE 5:  The user is attempting to paginate the page or the display
    // is being called after the save (display is presentation url for save).
    return GlobalData.getUlIdEvent(request);
  }

   /**
   * This helper method is called by the display method to handle and ServiceExceptions by setting the
   * branch, looking up the error message and setting it.
   *
   * @param we      The ServiceException object.
   * @param context The GrndsExchangeContext object.
   */
  private void handleContactSearchListDisplayError(ServiceException we, GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();

    int errorCode = we.getErrorCode();
    switch (errorCode) {
      case Messages.MSG_ARC_DATA_CHANGED:
      case Messages.MSG_ERR_ON_RETURN:
      case Messages.MSG_REPORT_LAUNCH_FAILED:
      case Messages.MSG_REPORT_LAUNCHED:
      case Messages.MSG_SVC_MAX_CONTACT_FORM:
      case Messages.MSG_SVC_NO_CONTACTS_FOUND:
      case Messages.MSG_SVC_STRUCTURED_NARR:
      case Messages.MSG_SYS_NO_CNCT_NARR:
      case Messages.MSG_CONTACT_TYPE_SEARCH:
      case Messages.SSM_COMPLETE_REQUIRED:
      case Messages.SSM_ARC_NO_REPORTS_FOUND:
        setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
        setErrorMessage(errorCode, request);
        break;

      default:
        processSevereException(context, we);
        break;
    }
  }

  public static String getPurposeKey(HttpServletRequest request) {
    String stage = GlobalData.getSzCdStage(request);
    String program = GlobalData.getSzCdStageProgram(request);

    if (((CodesTables.CSTAGES_INV.equals(stage)) &&
         ((CodesTables.CPGRMS_APS.equals(program)) ||
          (CodesTables.CPGRMS_AFC.equals(program)))) ||
                                                     (CodesTables.CSTAGES_SVC.equals(stage)) ||
                                                     (CodesTables.CSTAGES_AOC.equals(stage)) ||
                                                     (CodesTables.CSTAGES_FPR.equals(stage))) {
      return "A";
    }
    // If Investigation - Licensing or CPS
    if ((CodesTables.CSTAGES_INV.equals(stage)) &&
        ((CodesTables.CPGRMSFM_CCL.equals(program)) ||
         (CodesTables.CPGRMSFM_RCL.equals(program)) ||
         (CodesTables.CPGRMSFM_CPS.equals(program)))) {
      return "B";
    }
    // If PAL or Foster Adoptive Home
    if ((CodesTables.CSTAGES_PAL.equals(stage)) ||
        (CodesTables.CSTAGES_FAD.equals(stage))) {
      return "I";
    }
    // If Intake
    if (CodesTables.CSTAGES_INT.equals(stage)) {
      return "D";
    }
    // If Adoption
    else if ((CodesTables.CSTAGES_ADO.equals(stage)) ||
             (CodesTables.CSTAGES_PAD.equals(stage))) {
      return "H";
    }
    // If Substitute Care
    else if ((CodesTables.CSTAGES_SUB.equals(stage)) ||
             (CodesTables.CSTAGES_FRE.equals(stage)) ||
             (CodesTables.CSTAGES_FSU.equals(stage))) {
      return "G";
    }
    // Admin Review
    else if ((CodesTables.CSTAGES_ARI.equals(stage)) ||
             (CodesTables.CSTAGES_ARF.equals(stage))) {
      return "K";
    }

    throw new IllegalStateException("Error occurred while returning data.  Contact Tech Support for assistance.");
  }

  public static String getOthersKey(HttpServletRequest request) {
    String stage = GlobalData.getSzCdStage(request);
    String program = GlobalData.getSzCdStageProgram(request);

    // If Service Delivery or Investigation and APS
    if ((CodesTables.CPGRMSFM_APS.equals(program)) &&
        ((CodesTables.CSTAGES_INV.equals(stage)) ||
         (CodesTables.CSTAGES_SVC.equals(stage)) ||
         (CodesTables.CSTAGES_AOC.equals(stage)))) {
      return "A";
    }
    // If Service Delivery, Investigation, CPS or Licensing
    else if (((CodesTables.CSTAGES_INV.equals(stage)) || (CodesTables.CSTAGES_FPR.equals(stage))) &&
             ((CodesTables.CPGRMS_CPS.equals(program)) ||
              (CodesTables.CPGRMS_RCL.equals(program)) ||
              (CodesTables.CPGRMS_CCL.equals(program)))) {
      return "B";
    }
    // If Investigation and Facilities
    else if ((CodesTables.CSTAGES_INV.equals(stage)) && (CodesTables.CPGRMS_AFC.equals(program))) {
      return "C";
    }
    // If Intake
    else if (CodesTables.CSTAGES_INT.equals(stage)) {
      return "D";
    }
    // If PAL
    else if (CodesTables.CSTAGES_PAL.equals(stage)) {
      return "H";
    }
    // If Foster Adoptive Home, Adoption, or Substitute Care
    else if ((CodesTables.CSTAGES_ADO.equals(stage)) ||
             (CodesTables.CSTAGES_SUB.equals(stage)) ||
             (CodesTables.CSTAGES_FAD.equals(stage)) ||
             (CodesTables.CSTAGES_PAD.equals(stage)) ||
             (CodesTables.CSTAGES_FRE.equals(stage)) ||
             (CodesTables.CSTAGES_FSU.equals(stage))) {
      return "G";
    }
    // Admin Review
    if ((CodesTables.CSTAGES_ARI.equals(stage)) ||
        (CodesTables.CSTAGES_ARF.equals(stage))) {
      return "K";
    }

    throw new IllegalStateException("Error occurred while returning data.  Contact Tech Support for assistance.");
  }

  public static String getTypeKey(HttpServletRequest request) {
    CSYS08SO csys08so = getCSYS08SO(request);
    if (csys08so == null) {
      csys08so = new CSYS08SO();
    }

    String stage = CaseUtility.getStage(GlobalData.getUlIdStage(request)).getCdStage();
    
         if (CodesTables.CSTAGES_INV.equals(stage)) { 
      return "A";
    }
    
    
    // If Intake
    else if (CodesTables.CSTAGES_INT.equals(stage)) {
      return "D";
    }
   
    // If Adoption
    else if ((CodesTables.CSTAGES_ADO.equals(stage))) {
      return "H";
    }
    
    // If Foster Adoptive Home
    else if (CodesTables.CSTAGES_FAD.equals(stage)) {
      return "I";
    }
    
    // Admin Review
    else if ((CodesTables.CSTAGES_ARI.equals(stage)) || (CodesTables.CSTAGES_ARF.equals(stage))) {
      return "K";
    }
    
    //-- Ongoing (FPR, ONG)
    else if (CodesTables.CSTAGES_FPR.equals(stage) || CodesTables.CSTAGES_ONG.equals(stage)) {
      return "L";
    }
    
    //-- Foster Care Child (SUB, FCC)
    else if (CodesTables.CSTAGES_SUB.equals(stage) || CodesTables.CSTAGES_FCC.equals(stage)) {
      return "M";
    }
    
    //-- Diversion
    else if (CodesTables.CSTAGES_DIV.equals(stage)) {
      return "N";
    }
    
    //-- Foster Care Family (FSU, FCF)
    else if (CodesTables.CSTAGES_FSU.equals(stage) || CodesTables.CSTAGES_FCF.equals(stage)) {
      return "O";
    }
    
    //-- Post Foster Care
    else if (CodesTables.CSTAGES_PFC.equals(stage)) {
      return "P";
    }
    
    //-- Post Adoption Care
    else if (CodesTables.CSTAGES_PAD.equals(stage)) {
      return "Q";
    }

    throw new IllegalStateException("Error occurred while returning data.  Contact Tech Support for assistance.");
  }
  
  /**
   * This helper method is called by continueType, displayContact, and newUsing to determine which presentation branch
   * the page should be in.
   *
   * @param request HttpServletRequest
   * @return presentationMode
   */
  public static String getPresentationMode(HttpServletRequest request) {
    String contactType = getSelSzCdContactType(request);

    if (contactType.length() <= 3) {
      throw new IllegalStateException("contactType length is <= 3: '" + contactType + "'");
    }
    //!!! dup'd
    String stageTypeCode = contactType.substring(1, 4);

    //String stageTypeCode = contactType.substring(0, 3);

    // SIR 22657 - Added CSQ to detailArray
    // SIR 19163 - Had to add 24N and FTF to detailArray so the page would allow
    // data to be entered instead of eternally staying in Initial PresenationMode.
    // SIR 23410 - Added LES and LEV to detailArray
    // SIR 23298 Added AGR to the detail Array
    String[] detailArray = {"24H", "24N", "ATP", "DVP", "CCA", "CSQ", "FTF",
                            "IFF", "MAS", "MST", "MTG", "NOT", "PHS", "QUV",
                            "SRA", "REA", "REG", "REV", "SEI", "VAR", "VIO",
                            "LES", "LEV", "AGR", "TCM", "INQ", "PTC", "PVC"};
    String[] summaryArray = {"3MT", "ACS", "ATZ", "CCS", "CLS", "CMP", "DOC",
                             "DVZ", "ENV", "EXR", "FAC", "FAZ", "FCL", "INC",
                             "LIC", "MAZ", "MTH", "PAR", "PHY", "PHZ", "PPS",
                             "PRO", "QUZ", "REE", "REZ", "SCS", "SEZ", "SPV",
                             "STR", "STS", "TRN", "VAZ", "VIZ"};
    
    if(Arrays.asList(detailArray).contains(stageTypeCode)) {
      return DETAIL_CONTACT;
    } else if(Arrays.asList(summaryArray).contains(stageTypeCode)) {
      return SUMMARY_CONTACT;
    }
    
    
    throw new IllegalStateException("Unhandled contactType(1,4): '" + stageTypeCode + "'");
  }
  
//!!! I don't like this, but it's currently everywhere
  //I think it'd be better to assure a cys08so object and fill in all this temporary state
  public static String getSelSzCdContactType(HttpServletRequest request) {
    // If we are adding a new contact, the user must select Contact/Summary Type after clicking
    // the add button on the Contact/Summaries List Page.  In this instance, the Contact Type
    // is passed to the ContactDetail.jsp through the request.  If we are viewing the detail
    // page for an existing contact/summary or a new using, the contact type should be
    // in the csys08so object.
    String selSzCdContactType = ContextHelper.getStringSafe(request, SELSZCDCONTACTTYPE);
    if (!"".equals(selSzCdContactType)) {
      return selSzCdContactType;
    }
    
    CSYS08SO csys08so = getCSYS08SO(request);
    if (csys08so == null) {
      //return null;
      return "";
    }
    return FormattingHelper.formatString(csys08so.getSzCdContactType());
  }
  
}
