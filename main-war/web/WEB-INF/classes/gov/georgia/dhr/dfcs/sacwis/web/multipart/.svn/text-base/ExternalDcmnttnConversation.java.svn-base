package gov.georgia.dhr.dfcs.sacwis.web.multipart;

import gov.georgia.dhr.dfcs.sacwis.core.base.BaseValueBean;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PlatformConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.DatabaseResultDetails;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.UCMDataObject;
import gov.georgia.dhr.dfcs.sacwis.dao.document.CompressionHelper;
import gov.georgia.dhr.dfcs.sacwis.service.common.Common;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV22SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV23SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ExternalDocumentationSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV22SIG;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV22SIG1;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV22SIG1_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV22SIG_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV23SI00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV23SI00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV23SI01;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV23SI01_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEEXTDOCPERSONCHECK;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELEXTDOCPERCHECK_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV23SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ExternalDocumentationSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV23SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV23SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV23SOG01_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV23SOG02;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV23SOG02_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.web.core.base.ValueBeanHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelperException;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag;
import gov.georgia.dhr.dfcs.sacwis.web.core.pagination.TuxedoPaginationValueBean;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.grnds.structural.web.GrndsExchangeContext;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

/**
 * This conversation calls is used to display the External Documentation List and Detail pages. It will also Add,
 * Update, and Delete External Documentation Entries.
 * 
 * <pre>
 * Change History:
 * Date      User              Description
 * --------  ----------------  --------------------------------------------------
 * 04/16/03  Todd Reser        Changed local A, U, D to WtcHelper Constants.
 *                             Added a few comments to the code.  Switched
 *                             dateObtained to getCastorDateSafe.
 * 06/16/03  Merle A Demo      Replaced old pageMode with newer GlobalData.getPageMode
 * 10/03/03  CORLEYAN          SIR 19951 Removed pagemode logic, these pages should
 *                             always be in modify mode.
 * 12/08/04  Hadjimh           SIR#22839. Currently, the worker clicks the add button,
 *                             selects one item and saves. this action takes user to
 *                             Ext Doc List page and the actions are repeated
 *                             for each item that is being documented. SaveAndStay
 *                             button will be added to make this task smoother. I also have
 *                             bundled some existing lines of code into displayExtDocList
 *                             function for clarity.
 * 09/02/05  cooganpj          SIR 23953 - Changed call to CINV22S from Wtc service to EJB
 * 09/23/05  PISHARRK          SIR 23953 - Changed call to CINV23S from Wtc service to EJB
 * 09/26/05  cooganpj          SIR 23966 - Added page mode code for MPS and IMPACT lockdown.
 * 12/08/08  charden		   STGAP00010041 - wrote code so that pageMode of the external 
 *                             documentation list and the detail page will be view only if 
 *                             the case is closed
 * 8/13/09 Ekemini Udofiah     STGAP00015065 - Added method to save and delete persons from 
 *                             an external document.
 * 9/10/09   ssubram           STGAP00015066 - Added code for Search operation and other
 *                             validation as per the design document  
 * 11/05/09  pcoogan           SMS 39107: Added sort key for document class    
 * 11/22/09  pcoogan           SMS 40847: Removed code that removed first digit of external doc index,
 *                             index is no longer added ahead of unique external doc ID for rb.      
 * 5/20/10   cwells            SMS 41277 If the external document is added the same day the stage is closed then display informational message and 
 *                             set the page to view.                                             
 * 12/07/11  vcollooru		   STGAP00017712: Modified for integrating Imaging into SHINES.
 * 12/22/11  vcollooru		   STGAP00017712: Imaging integration into SHINES - Modified to comment out code for compressing/decompressing file content.
 * 01/30/12	 vcollooru		   STGAP00017827 MR-085 Modified to add new parameter to mark or filter for ICPC Documents
 * &lt;p/&gt;
 * </pre>
 * 
 * @author Rodrigo DeJuana, December 9, 2002
 */
public class ExternalDcmnttnConversation extends BaseHiddenFieldStateConversation {
  public static final String ERROR_DISPLAY = "/multipart/ExternalDcmnttn/displayExtDocDetail";

  public static final String TRACE_TAG = "ExternalDcmnttnConversation";

  public static final String EXT_DOC_LIST_URL = "/multipart/ExternalDcmnttn/displayExtDocList";

  public static final int RETRIEVE_PAGESIZE = 50;

  public static final int SAVE_PAGESIZE = 75;

  public static final String PDF_TYPE = "application/pdf";

  public static final String JPEG_TYPE = "image/jpeg";

  public static final String PJPEG_TYPE = "image/pjpeg";

  public static final String JPG_TYPE = "image/jpg";

  public static final String PDF_DIS_TYPE = "PDF";

  public static final String JPEG_PJPEG_DIS_TYPE = "JPEG";

  private static final String NO_FILE_TO_DISPLAY = "The file can not be displayed";

  // Sorting constants for External Documentation
  public static final String SORT_BY_DOC_TYPE = "1";

  public static final String SORT_BY_DATE_OBTAINED = "2";
  
  public static final String SORT_BY_DOC_CLASS = "3";

  private Common common;

  /**
   * Setter Method for Common
   * 
   * @param common
   */
  public void setCommon(Common common) {
    this.common = common;
  }

  /**
   * This method is added consequent to the implementation of SIR 23953. This makes the second level tab, 'Case
   * Management', to point to the External Documentation List page URL so that the pagination work correctly. Without
   * this re-routing, when the External Documentation List page is reached from the second level tab, 'Case Management',
   * the 'Next' hyperlink does not work as desired.
   * 
   * @param context
   *                Contains the session, state, and request objects to get data from jsps
   */
  public void forwardToDisplayExtDocList_xa(GrndsExchangeContext context) {
    try {
      forwardSafe(EXT_DOC_LIST_URL, context.getRequest(), context.getResponse());
    } catch (ServletException se) {
      processSevereException(context, se);
    }
  }

  /**
   * This method will clear the state, set the page mode, and then call the cinv23s service to display the External
   * Documentation List. All the data for the Detail page is contained within the cinv23so object.
   * 
   * @param context
   *                Contains the session, state, and request objects to get data from jsps
   */
  public void displayExtDocList_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayExtDocList_xa()");
    performanceTrace.enterScope();
    // SIR# 22839. Some lines of previously written code is bundled in the
    // following new function for clarity.
    displayExtDocList(context);
    performanceTrace.exitScope();
  }

  /**
   * This method will clear the state, set the page mode, and then call the cinv23s service to display the External
   * Documentation List. All the data for the Detail page is contained within the cinv23so object.
   * 
   * @param context
   *                Contains the session, state, and request objects to get data from jsps
   */

  public void displayExtDocList(GrndsExchangeContext context) {
    displayExtDocList(context, null, null);
  }
  /**
   * This method will clear the state, set the page mode, and then call the cinv23s service to display the External
   * Documentation List. All the data for the Detail page is contained within the cinv23so object.
   * 
   * @param context
   *                Contains the session, state, and request objects to get data from jsps
   */

  public void displayExtDocList(GrndsExchangeContext context, String orderBy, String orderByDirection) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayExtDocList_xa()");
    performanceTrace.enterScope();

    TuxedoPaginationValueBean tuxPagination = new TuxedoPaginationValueBean();
    ValueBeanHelper.populateDefaultValues(context, tuxPagination);
    //To preserve the sort after the deletion of an external document
    if (orderBy != null && orderByDirection != null){
      DatabaseResultDetails details = tuxPagination.getResultDetails();
      details.setOrderBy(orderBy);
      details.setOrderByDirection(orderByDirection);
    }
    tuxPagination.getResultDetails().setResultsPerPage(RETRIEVE_PAGESIZE);

    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();
    try {
      CINV23SI cinv23si = populateCINV23SI_Retrieve(context, tuxPagination);

      try {
        CINV23SO cinv23so = common.retrieveExternalDocumentation(cinv23si);
        state.setAttribute("CINV23SO", cinv23so, request);
        //In order to keep the Search parameters so that if the sort request comes next time,
        //the sort parameters can be reused.
        state.setAttribute("CINV23SI", cinv23si, request);
        tuxPagination.setPaginationInformation(cinv23so.getArchOutputStruct(), cinv23so.getROWCINV23SOG00_ARRAY()
                                                                                       .getROWCINV23SOG00Count());
        request.setAttribute(BaseValueBean.REQUEST_ATTRIBUTE_NAME, tuxPagination);
        state.setAttribute("TUXPAGINATION", tuxPagination, request);
      } catch (ServiceException re) {

      }
      
      // SIR 23966 - Set page mode for MPS
      String pageMode = PageModeConstants.EDIT;
      // STGAP00010041 - pageMode should be view only if the case is closed
      int ulIdCase = GlobalData.getUlIdCase(request);
      List<CaseUtility.Stage> checkCaseStatusList = new ArrayList<CaseUtility.Stage>();
      checkCaseStatusList = CaseUtility.getOpenStages(ulIdCase);
      boolean pendApproval = CaseUtility.getAFCPendingStatus(ulIdCase);

      UserProfile user = UserProfileHelper.getUserProfile(request);
      int ulIdStage = GlobalData.getUlIdStage(request);
      int ulIDCase = GlobalData.getUlIdCase(request);
      
      //STGAP00015066 -- Starts here ---
      /*In Modify mode, available only to assigned workers, the Add button will display.  
      The Add button will continue to display for users with the ability to add and modify 
      information for a closed case up to 7 days, but users will not be able to delete any 
      documentation added prior to case closure.*/
      boolean hasBeenAssigned = common.determineIfUserWasEverAssigned(ulIDCase, ulIdStage, user.getUserID());
      boolean hasStageAccess = CaseUtility.hasStageAccess(user.getUserID(), ulIdStage);      
      boolean userAllowedToEdit = (hasBeenAssigned || hasStageAccess);
      CaseUtility.Stage stage = CaseUtility.getStage("" + ulIdStage);
      boolean stageClosed = false;
      //boolean editsAndAddAllowed = true;
      //Get Stage close date
      Date stageClosureDate = DateHelper.toJavaDateSafe(stage.getDtClose(), "12:00 am");  
      if(stage.getDtClose() != null){
        stageClosed = true;
        stageClosureDate = DateHelper.addToDate(stageClosureDate, 0, 0, 1);
      }
      //Get today
      Date dtToday = new Date();
      
      //Edits allowed 7 days after stage closed
      /*if (stageClosureDate != null) {
        Date weekAfterStageClosed = DateHelper.addToDate(stageClosureDate, 0, 0, 7);
        editsAndAddAllowed = DateHelper.isBefore(dtToday, weekAfterStageClosed);
      }*/
      //Set the attributes to the state
      state.setAttribute("userAllowedToEdit",userAllowedToEdit, request);
      //state.setAttribute("editsAndAddAllowed",editsAndAddAllowed, request);
      state.setAttribute("stageClosed",stageClosed, request);
      state.setAttribute("stageClosureDate",stageClosureDate, request);
      //If the user is not a historic primary or their supervisor
      if (!userAllowedToEdit) {
        pageMode = PageModeConstants.VIEW;
      }
      //Edits and add allowed only for 7 days after the stage closed
      /*if (!editsAndAddAllowed) {
        pageMode = PageModeConstants.VIEW;
      }
      //STGAP00015066 -- Ends here ---
      if (!(CaseUtility.hasStageAccess(user.getUserID(), ulIdStage))) {
        pageMode = PageModeConstants.VIEW;
      }*/
      /*if ((checkCaseStatusList == null || checkCaseStatusList.isEmpty()) && !editsAndAddAllowed) {
        pageMode = PageModeConstants.VIEW;
      }*/

      if ("AFC".equals(GlobalData.getSzCdStageProgram(request)) && PlatformConstants.SERVER_IMPACT
          && CaseUtility.getCaseCheckoutStatus(GlobalData.getUlIdStage(request)) && !pendApproval) {
        pageMode = PageModeConstants.VIEW;
        setInformationalMessage(Messages.MSG_CASE_CHECKEDOUT, request);
      } else if (PlatformConstants.MOBILE_IMPACT
                 && (CodesTables.CMOBSTAT_ER.equals(CaseUtility.getCdMobileStatus(GlobalData.getUlIdCase(request))) || pendApproval)) {
        pageMode = PageModeConstants.VIEW;
      }

      PageMode.setPageMode(pageMode, request);

    } catch (ServiceException se) {
      // The service exception is thrown when a severe error is generated at the dao
      processSevereException(context, se);
    }

    performanceTrace.exitScope();
  }
  /**
   * This method will display the External Document Detail page. If a new item is being created an empty Ext Doc Detail
   * object will be created. Three value will be set: Date Obtained, Location, and Details. If the is displaying an
   * existing Detail, the method will take the index passed to it and populate an External Document Detail object
   * (ROWCINV23SOG00) and place it in the request.
   * 
   * @param context
   *                Contains the session, state, and request objects to get data from jsps
   */
  public void displayExtDocDetail_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayExtDocDetail_xa()");
    performanceTrace.enterScope();

    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();

    if (ContextHelper.getString(request, "btnView.x") != null) {
      state.setAttribute("btnSave", ContextHelper.getString(request, "btnView.x"), request);
    }

    boolean bSaved = state.getAttribute("btnSave", request) != null;

    if (!bSaved) {
      state.setAttribute("btnAdd", ContextHelper.getString(request, "btnAdd.x"), request);
    }
    boolean bAdd = state.getAttribute("btnAdd", request) != null;
    /* SIR#22839: set the boolean value to check if SaveAndStay button is pressed. */
    String sSaveAndStay = (String) state.getAttribute("btnSaveAndStay", request);
    boolean bSaveAndStay = sSaveAndStay != null;

    String idExtDoc = ContextHelper.getString(request, "rbExtDoc");

    ROWCINV23SOG00 extDocDetail = new ROWCINV23SOG00();
    // If Add button has been click launch Detail page in new mode.
    // SIR#22839: SaveAndStay works like Save on Ext Document Detail page except on Save
    // user is taken back to Ext Document List page rather than to stay on the same page
    // (Ext Document Detail page) for more addition of Document type.

    if (bAdd || bSaveAndStay) {
      extDocDetail.setDtDtExtDocObtained(DateHelper.toCastorDate(new java.util.Date()));
      extDocDetail.setSzTxtExtDocDetails("");
      extDocDetail.setDtExtDocUploaded(DateHelper.toCastorDate(new java.util.Date()));
      extDocDetail.setDtDtExtDocAdded(DateHelper.toCastorDate(new java.util.Date()));
      extDocDetail.setSzTxtFileName("");
      extDocDetail.setSzTxtFormatType("");
      request.setAttribute("hdnAUMode", ServiceConstants.REQ_FUNC_CD_ADD);
      if (bSaved) {
        extDocDetail.setDtDtExtDocObtained(ContextHelper.getCastorDateSafe(request, "txtDtDtExtDocObtained"));
        extDocDetail.setSzCdExtDocSort(ContextHelper.getString(request, "txtSzCdExtDocSort"));
        extDocDetail.setSzCdExtDocType(ContextHelper.getString(request, "selSzCdExtDocType"));
        extDocDetail.setSzCdDocClass(ContextHelper.getString(request, "selSzcdDocClass"));
        extDocDetail.setDtExtDocUploaded(ContextHelper.getCastorDateSafe(request, "txtDtDtExtDocUploaded"));
        extDocDetail.setDtDtExtDocAdded(DateHelper.toCastorDate(new java.util.Date()));
        extDocDetail.setSzTxtExtDocLocation(ContextHelper.getString(request, "txttSzTxtExtDocLocation"));
        extDocDetail.setBIndExtDocSigned(CheckboxHelper.getCheckboxValue(request, "selIndSigned"));
        extDocDetail.setBIndNaChecked(CheckboxHelper.getCheckboxValue(request, "selIndNaChecked"));
        extDocDetail.setSzTxtExtDocDetails(ContextHelper.getString(request, "txtaSzTxtExtDocDetails"));
        extDocDetail.setBIndICPCDoc(CheckboxHelper.getCheckboxValue(request, "selIndICPCDoc"));
      }
      state.setAttribute("txtFileName", null, request);
      state.setAttribute("FileName", null, request);
      state.setAttribute("FileType", null, request);

      if (bSaveAndStay) {
        extDocDetail.setSzCdExtDocSort(null);
        extDocDetail.setSzCdExtDocType(null);
        extDocDetail.setSzCdDocClass(null);
        extDocDetail.setBIndExtDocSigned(null);
        extDocDetail.setBIndNaChecked(null);
        extDocDetail.setSzTxtExtDocDetails(null);
        extDocDetail.setBIndICPCDoc(null);
      }

    } else if (bSaved) {
      if (bAdd || bSaveAndStay) {
        request.setAttribute("hdnAUMode", ServiceConstants.REQ_FUNC_CD_ADD);
      } else {
        request.setAttribute("hdnAUMode", ServiceConstants.REQ_FUNC_CD_UPDATE);
        extDocDetail.setUlIdExtSitInfo(ContextHelper.getIntSafe(request, "hdnUlIdExtSitInfo"));
        if (ContextHelper.getStringSafe(request, "hdnSzTxtFileName") != null) {
          state.setAttribute("txtFileName", ContextHelper.getStringSafe(request, "hdnSzTxtFileName"), request);
        }
      }
      extDocDetail.setDtDtExtDocObtained(ContextHelper.getCastorDateSafe(request, "txtDtDtExtDocObtained"));
      extDocDetail.setSzCdExtDocSort(ContextHelper.getString(request, "txtSzCdExtDocSort"));
      extDocDetail.setSzCdExtDocType(ContextHelper.getString(request, "selSzCdExtDocType"));
      extDocDetail.setSzCdDocClass(ContextHelper.getString(request, "selSzcdDocClass"));
      extDocDetail.setDtExtDocUploaded(ContextHelper.getCastorDateSafe(request, "txtDtDtExtDocUploaded"));
      extDocDetail.setDtDtExtDocAdded(ContextHelper.getCastorDateSafe(request, "hdnDtDtExtDocAdded"));
      extDocDetail.setSzTxtExtDocLocation(ContextHelper.getString(request, "txttSzTxtExtDocLocation"));
      extDocDetail.setBIndExtDocSigned(CheckboxHelper.getCheckboxValue(request, "selIndSigned"));
      extDocDetail.setBIndNaChecked(CheckboxHelper.getCheckboxValue(request, "selIndNaChecked"));
      extDocDetail.setSzTxtExtDocDetails(ContextHelper.getString(request, "txtaSzTxtExtDocDetails"));
      extDocDetail.setSzTxtFileName(ContextHelper.getString(request, "txtDtDtExtDocFileName"));
      extDocDetail.setSzTxtFormatType(ContextHelper.getString(request, "txtDtDtExtDocFileType"));
      extDocDetail.setBIndICPCDoc(CheckboxHelper.getCheckboxValue(request, "selIndICPCDoc"));
      String[] extDocPersonChecks = CheckboxHelper.getCheckedValues(request, "cbxUlIdPerson");
      
      //Get the SO Object back from the state and set the person list when the view button
      //is clicked
      CINV23SO extDocList = (CINV23SO) state.getAttribute("CINV23SO", request);
      ROWCINV23SOG02_ARRAY rowPerCheckArray = new ROWCINV23SOG02_ARRAY();
      if (extDocList != null) {
        ROWCINV23SOG01_ARRAY personList = extDocList.getROWCINV23SOG01_ARRAY();
        for (String ulIdPerson : extDocPersonChecks) {
          Integer index = 0;
          try{
            index = Integer.parseInt(ulIdPerson);
            Integer idPerson = personList.getROWCINV23SOG01()[index].getUlIdPerson();
            ROWCINV23SOG02 rowPerCheck = new ROWCINV23SOG02();
            if (idPerson != null){
              rowPerCheck.setUlIdPerson(idPerson);
            }
            rowPerCheckArray.addROWCINV23SOG02(rowPerCheck);            
          }catch (NumberFormatException nfe){
            //Checking for N/A value and setting it back
            if (ulIdPerson.equalsIgnoreCase("N")){
              extDocDetail.setBIndNaChecked("Y");
            }
          }
        }
      }
      extDocDetail.setROWCINV23SOG02_ARRAY(rowPerCheckArray);
    }
    // Else Add has been clicked along with a radio button, or hyper link was clicked
    else {
      CINV23SO extDocList = (CINV23SO) state.getAttribute("CINV23SO", request);
      if (extDocList != null) {

        int index = ContextHelper.getIntSafe(request, "hdnUlIdExtDoc");
        if (idExtDoc != null && index > 0) {
          index = Integer.parseInt(idExtDoc.substring(0, 1));
        }
        extDocDetail = extDocList.getROWCINV23SOG00_ARRAY().getROWCINV23SOG00(index);

        String mode = ServiceConstants.REQ_FUNC_CD_UPDATE;
        // SIR#22839: there is not going to be any new mode added. Add is the same as
        // SaveAndStay which means add a document type and stay on the page
        // possibly for more addition.
        if (bAdd || bSaveAndStay) {
          mode = ServiceConstants.REQ_FUNC_CD_ADD;
        } else if (extDocDetail != null) {
          String fileType = extDocDetail.getSzTxtFormatType();
          if (PDF_TYPE.equals(fileType)) {
            fileType = PDF_DIS_TYPE;
          } else if (JPEG_TYPE.equals(fileType) || PJPEG_TYPE.equals(fileType)) {
            fileType = JPEG_PJPEG_DIS_TYPE;
          }
          state.setAttribute("txtFileType", fileType, request);
        }
        request.setAttribute("hdnAUMode", mode);
      }
    }

    request.setAttribute("ExtDocDetail", extDocDetail);

    // SIR 23966 - Set page mode for MPS

    String pageMode = PageModeConstants.EDIT;
    // STGAP00010041 - pageMode should be view only if the case is closed
    int ulIdCase = GlobalData.getUlIdCase(request);
    List<CaseUtility.Stage> checkCaseStatusList = new ArrayList<CaseUtility.Stage>();
    checkCaseStatusList = CaseUtility.getOpenStages(ulIdCase);
    boolean pendApproval = CaseUtility.getAFCPendingStatus(GlobalData.getUlIdCase(request));

    UserProfile user = UserProfileHelper.getUserProfile(request);
    int ulIdStage = GlobalData.getUlIdStage(request);
    //STGAP00015066 -- Starts here ---
    /*In Modify mode, available only to assigned workers, the Add button will display.  
    The Add button will continue to display for users with the ability to add and modify 
    information for a closed case up to 7 days, but users will not be able to delete any 
    documentation added prior to case closure.*/
    boolean hasBeenAssigned = common.determineIfUserWasEverAssigned(ulIdCase, ulIdStage, user.getUserID());
    boolean hasStageAccess = CaseUtility.hasStageAccess(user.getUserID(), ulIdStage);      
    boolean userAllowedToEdit = (hasBeenAssigned || hasStageAccess);
    CaseUtility.Stage stage = CaseUtility.getStage("" + ulIdStage);
    boolean stageClosed = false;
    //boolean editsAndAddAllowed = true;
    //Get Stage close date
    Date stageClosureDate = DateHelper.toJavaDateSafe(stage.getDtClose(), "12:00 am");  
    if(stage.getDtClose() != null){
      stageClosed = true;
   //   stageClosureDate = DateHelper.addToDate(stageClosureDate, 0, 0, 1);
      Date dateDocAdded = extDocDetail.getDtDtExtDocAdded().toDate();
      if(dateDocAdded.before(stageClosureDate))
      {
        pageMode = PageModeConstants.VIEW;
      }else if(dateDocAdded.equals(stageClosureDate)){
        // 41277 If the external document is added the same day the stage is closed then display informational message and 
        // set the page to view. 
        setInformationalMessage(Messages.MSG_EXT_DOC_CLOSURE, request);
        pageMode = PageModeConstants.VIEW;
      }
    }
    //Get today
    //Date dtToday = new Date();
    
    //Edits allowed 7 days after stage closed
    /*if (stageClosureDate != null) {
      Date weekAfterStageClosed = DateHelper.addToDate(stageClosureDate, 0, 0, 7);
      editsAndAddAllowed = DateHelper.isBefore(dtToday, weekAfterStageClosed);
    }*/
    //Set the attributes to the state
    state.setAttribute("userAllowedToEdit",userAllowedToEdit, request);
    //state.setAttribute("editsAndAddAllowed",editsAndAddAllowed, request);
    state.setAttribute("stageClosed",stageClosed, request);
    state.setAttribute("stageClosureDate",stageClosureDate, request);
    //If the user is not a historic primary or their supervisor
    if (!userAllowedToEdit) {
      pageMode = PageModeConstants.VIEW;
    }
    //Edits and add allowed only for 7 days after the stage closed
    /*if (!editsAndAddAllowed) {
      pageMode = PageModeConstants.VIEW;
    }      
    if (!(CaseUtility.hasStageAccess(user.getUserID(), ulIdStage))) {
      pageMode = PageModeConstants.VIEW;
    }*/
    //STGAP00015066 -- Ends here ---
    /*if ((checkCaseStatusList == null || checkCaseStatusList.isEmpty()) && !editsAndAddAllowed) {
      pageMode = PageModeConstants.VIEW;
    }*/
    
    if ("AFC".equals(GlobalData.getSzCdStageProgram(request)) && PlatformConstants.SERVER_IMPACT
        && CaseUtility.getCaseCheckoutStatus(GlobalData.getUlIdStage(request)) && !pendApproval) {
      pageMode = PageModeConstants.VIEW;
      setInformationalMessage(Messages.MSG_CASE_CHECKEDOUT, request);
    }
    PageMode.setPageMode(pageMode, request);

    performanceTrace.exitScope();
  }

  /**
   * This method will call the cinv22s service. This service is in charge of AUD.
   * 
   * @param context
   *                Contains the session, state, and request objects to get data from jsps
   */
  public void saveExtDocDetail_xa(GrndsExchangeContext context) {

    String ucmDId = getFileUploadId(context);
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".saveExtDocDetail_xa()");
    performanceTrace.enterScope();
    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();

    try {
      // Using the data we got from cinv23so, populate cinv22si.
      CINV22SI cinv22si = populateCINV22SI_AUD(context);
      // Now modify the new cinv22si with the date on the page.
      cinv22si = audExtDocDetail(context, cinv22si, ucmDId);

      ExternalDocumentationSI extDocSI = new ExternalDocumentationSI();
      // This code is only hit when updating an existing record. The
      // blob must be selected out and re-saved since the DAO updates
      // the entire record.
      int idExtDoc = ContextHelper.getIntSafe(request, "hdnUlIdExtSitInfo");
      if (idExtDoc > 0 && !StringHelper.isValid(ucmDId)) {
        ExternalDocumentationSO edso = common.displayExtDoc(idExtDoc);
        if (edso != null) {
          extDocSI.setFileData(edso.getFileData());
        }
      }
      // This returns a boolean, but ServiceException is ALWAYS thrown if it would return false.
      // If we get a ServiceException here, we can't go on; just throw it.
      common.saveExternalDocumentation(cinv22si, state.getAttribute("btnSave", request) != null, extDocSI);
      // SIR#22839: check to see if SaveAndStay button is clicked
      if (null != ContextHelper.getString(request, "btnSaveAndStay.x")) {
        state.setAttribute("btnSaveAndStay", ContextHelper.getString(request, "btnSaveAndStay.x"), request);
        this.setPresentationBranch("stay", context);
      } else {
        String orderBy = null;
        String orderByDirection = null;
        // Get the Pagination Information from the state
        TuxedoPaginationValueBean tuxPagination = (TuxedoPaginationValueBean) state.getAttribute("TUXPAGINATION",
                                                                                                 request);
        // Pass the Sort and Direction information to preserve the sort after the save.
        if (tuxPagination != null) {
          DatabaseResultDetails details = tuxPagination.getResultDetails();
          if (details != null) {
            orderBy = details.getOrderBy();
            orderByDirection = details.getOrderByDirection();
          }
        }
        displayExtDocList(context, orderBy, orderByDirection);

      }
    } catch (Exception e) {
      processSevereException(context, e);
    }

    performanceTrace.exitScope();
  }

  /**
   * <p>
   * This method returns the ID of the file uploaded to UCM Server.
   * </p>
   * 
   * @param context
   *          The <code>GrndeExchangeContext<code> object.
   * @return
   */
  private String getFileUploadId(GrndsExchangeContext context) {
    InputStream fileInputStream = null;
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".getFileUploadId()");
    performanceTrace.enterScope();
    String ucmDId = null;

    BaseSessionStateManager state = getSessionStateManager(context);
    Object tmp = context.getRequest();
    if (tmp instanceof DefaultMultipartHttpServletRequest) {
      DefaultMultipartHttpServletRequest request = (DefaultMultipartHttpServletRequest) context.getRequest();
      MultipartFile multipartFile = request.getFile("txttSzTxtExtFile");

      // get the file name
      String fileName = multipartFile.getOriginalFilename();
      state.setAttribute("viewFileName", fileName, request);

      if (!multipartFile.isEmpty()) {
        // We will leave the existing functionality triggered by the
        // click of the Upload button
        // Even though we have now removed the Upload button from the
        // screen
        String bSaved = "Clicked";
        state.setAttribute("btnSave", bSaved, request);

        // get the file type
        String fileType = multipartFile.getContentType();

        Boolean validFileType = false;
        String displayFileType = null;
        if (JPEG_TYPE.equalsIgnoreCase(fileType) || PJPEG_TYPE.equalsIgnoreCase(fileType)
            || JPG_TYPE.equalsIgnoreCase(fileType)) {
          validFileType = true;
          displayFileType = "image";
        } else if (PDF_TYPE.equalsIgnoreCase(fileType)) {
          validFileType = true;
          displayFileType = "pdf";
        }

        if (validFileType == true) {
          state.setAttribute("FileName", fileName, request);
          state.setAttribute("FileType", fileType, request);
          state.setAttribute("displayFileType", displayFileType, request);
        } else {
          // TODO error message that file is not a valid type
        }
        performanceTrace.exitScope();
        try {
          fileInputStream = multipartFile.getInputStream();
          byte[] fileContent = multipartFile.getBytes();
          if (fileContent != null && fileContent.length > 0 && fileInputStream != null) {
            UCMDataObject dataObject = new UCMDataObject();
            dataObject.setDocTitle(fileName);
            dataObject.setDocType("Document");
            dataObject.setSecurityGroup("ChildWelfare");
            dataObject.setAccount("ChildWelfare");
            dataObject.setPrimaryFile(fileInputStream);
            dataObject.setFileName(fileName);
            dataObject.setContentLength(fileContent.length);
            ucmDId = common.uploadDocumentToUCM(dataObject);
          }
        } catch (Exception e) {
          // The IO exception should never happen because we do not
          // cache the files on disk.
          processSevereException(context, e);
          // Throw an exception to kill the request.
          throw new RuntimeException("Failure to get file contents", e);
        } finally {
          if (fileInputStream != null) {
            try {
              fileInputStream.close();
            } catch (Exception e) {
              // Ignore the Exception
            }
          }
        }
      }
    }
    return ucmDId;
  }

  /**
   * <p>
   * This method is called when the user clicks on the View button. It opens the uploaded document in the program
   * depending on the type of the document
   * </p>
   * 
   * @param context
   *                The <code>GrndeExchangeContext<code> object.
   */
  public void viewExtDoc_xa(GrndsExchangeContext context) {

    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".viewExtDoc_xa()");
    performanceTrace.enterScope();

    try {
      HttpServletRequest request = context.getRequest();
      int idExtDoc = ContextHelper.getIntSafe(request, "UlIdExtDoc");

      BaseSessionStateManager state = getSessionStateManager(context);
      state.setAttribute("hdnUlIdExtDoc", idExtDoc, request);

      ExternalDocumentationSO edso = common.displayExtDoc(idExtDoc);
      String formatType = edso.getFileFormat();
      String fileName = edso.getFileName();

      HttpServletResponse response = context.getResponse();
      response.addHeader("Content-Disposition", "inline; filename=\"" + fileName + "\"");
      response.setContentType(formatType);

      OutputStream outStream = response.getOutputStream();
      // flush before writing to it.
      outStream.flush();

      byte[] fileData = edso.getFileData();
      if (fileData != null && fileData.length > 0) {
        if (StringUtils.equalsIgnoreCase("N", StringUtils.trimToEmpty(edso.getIsUCMFile()))) {
          ByteArrayOutputStream bos = CompressionHelper.decompressData(fileData);
          fileData = bos.toByteArray();
        }
      } else {
        fileData = NO_FILE_TO_DISPLAY.getBytes();
        response.setContentType("text/plain");
      }
      outStream.write(fileData, 0, fileData.length);
      response.setContentLength(fileData.length);
      outStream.flush();
      outStream.close();
      response.flushBuffer();

    } catch (Exception e) {
      processSevereException(context, e);
    }
  }

  /**
   * This method will populate the cinv22si object by coping all the data from the cinv23so object into the
   * corresponding fields. Any changes that are taking place will be addressed in teh audExtDocDetail method.
   * 
   * @param context
   *                Contains the session, state, and request objects to get data from jsps
   * @return cinv22si Populated CINV22SI object.
   */
  private CINV22SI populateCINV22SI_AUD(GrndsExchangeContext context) throws CheckboxHelperException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".populateCinv22_aud()");
    performanceTrace.enterScope();

    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();

    ArchInputStruct input = new ArchInputStruct();
    CINV22SI cinv22si = new CINV22SI();
    ROWCINV22SIG_ARRAY outExtDocArray = new ROWCINV22SIG_ARRAY();

    int i = 0;

    CINV23SO cinv23so = (CINV23SO) state.getAttribute("CINV23SO", request);
    if (cinv23so != null) {
      ROWCINV23SOG00_ARRAY inExtDocArray = cinv23so.getROWCINV23SOG00_ARRAY();
      Enumeration<ROWCINV23SOG00> inExtDocEnum = inExtDocArray.enumerateROWCINV23SOG00();

      input.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
      input.setUsPageNbr(1);
      input.setUlPageSizeNbr(SAVE_PAGESIZE);
      input.setSzUserId(UserProfileHelper.getUserProfile(request).getUserLogonID());

      while (inExtDocEnum.hasMoreElements()) {
        ROWCINV23SOG00 inExtDocDetail = (ROWCINV23SOG00) inExtDocEnum.nextElement();
        ROWCINV22SIG outExtDocDetail = new ROWCINV22SIG();

        outExtDocDetail.setDtDtExtDocObtained(inExtDocDetail.getDtDtExtDocObtained());
        outExtDocDetail.setSzCdExtDocSort(inExtDocDetail.getSzCdExtDocSort());
        outExtDocDetail.setSzCdExtDocType(inExtDocDetail.getSzCdExtDocType());
        outExtDocDetail.setSzCdDocClass(inExtDocDetail.getSzCdDocClass());
        outExtDocDetail.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_NO_ACTION);
        outExtDocDetail.setSzTxtExtDocDetails(inExtDocDetail.getSzTxtExtDocDetails());
        outExtDocDetail.setSzTxtExtDocLocation(inExtDocDetail.getSzTxtExtDocLocation());
        outExtDocDetail.setTsLastUpdate(inExtDocDetail.getTsLastUpdate());
        outExtDocDetail.setUlIdCase(GlobalData.getUlIdCase(request));
        outExtDocDetail.setUlIdExtSitInfo(inExtDocDetail.getUlIdExtSitInfo());
        outExtDocDetail.setDtExtDocUploaded(inExtDocDetail.getDtExtDocUploaded());
        outExtDocDetail.setDtExtDocAdded(inExtDocDetail.getDtDtExtDocAdded());
        outExtDocDetail
                       .setBIndExtDocSigned(inExtDocDetail.getBIndExtDocSigned() == null ? "N"
                                                                                        : inExtDocDetail
                                                                                                        .getBIndExtDocSigned());
        outExtDocDetail.setBIndNaChecked(inExtDocDetail.getBIndNaChecked() == null ? "N"
                                                                                  : inExtDocDetail.getBIndNaChecked());
        outExtDocDetail.setSzTxtExtDoc(inExtDocDetail.getSzTxtExtDoc());
        outExtDocDetail.setSzTxtFileName(inExtDocDetail.getSzTxtFileName());
        outExtDocDetail.setSzTxtFormatType(inExtDocDetail.getSzTxtFormatType());
        outExtDocDetail
        .setBIndICPCDoc(inExtDocDetail.getBIndICPCDoc() == null ? "N"
                                                                         : inExtDocDetail
                                                                                         .getBIndICPCDoc());

        outExtDocDetail.setSzTxtUcmDId(inExtDocDetail.getSzTxtUcmDId());
        outExtDocArray.addROWCINV22SIG(outExtDocDetail);
        i++;
      }
      // start of save person checked
      ROWCINV23SOG01_ARRAY personList = cinv23so.getROWCINV23SOG01_ARRAY();
      String[] ExtDocPersonChecks = CheckboxHelper.getCheckedValues(request, "cbxUlIdPerson");
      ROWCINV22SIG1_ARRAY personchecked_array = new ROWCINV22SIG1_ARRAY();
      ROWDELEXTDOCPERCHECK_ARRAY perCheckedDelete_array = new ROWDELEXTDOCPERCHECK_ARRAY();

      for (int j = 0; j < ExtDocPersonChecks.length; j++) {
        Integer idPerson = (Integer) (personList.getROWCINV23SOG01()[Integer.parseInt(ExtDocPersonChecks[j])]
                                                                                                             .getUlIdPerson());
        ROWCINV22SIG1 rowPerchecked = new ROWCINV22SIG1();
        ROWDELETEEXTDOCPERSONCHECK rowPerchkDel = new ROWDELETEEXTDOCPERSONCHECK();
        rowPerchkDel.setUlIdPerson(idPerson);
        rowPerchecked.setUlIdPerson(idPerson);
        personchecked_array.addROWCINV22SIG1(rowPerchecked);
        perCheckedDelete_array.addROWDELETEEXTDOCPERSONCHECK(rowPerchkDel);
        personchecked_array.setUlRowQty(personchecked_array.getROWCINV22SIG1Count());
        perCheckedDelete_array.setUlRowQty(perCheckedDelete_array.getROWDELETEEXTDOCPERSONCHECKCount());
      }

      // remove after forming add and delete lists,
      state.removeAttribute("savedExtDocPerson", request);
      cinv22si.setROWCINV22SIG1_ARRAY(personchecked_array);
      cinv22si.setROWDELEXTDOCPERCHECK_ARRAY(perCheckedDelete_array);
    }

    cinv22si.setUsSysNbrNumberOfRows(i);
    cinv22si.setSzCdTask(GlobalData.getSzCdTask(request));

    CaseUtility.Stage stage = CaseUtility.getStage(GlobalData.getUlIdStage(request));
    String indStageClose = "";
    if (stage != null) {
      indStageClose = stage.getIndStageClose();
    }
    if ("N".equals(indStageClose)) {
      cinv22si.setUlIdStage(GlobalData.getUlIdStage(request));
    }

    cinv22si.setArchInputStruct(input);
    cinv22si.setROWCINV22SIG_ARRAY(outExtDocArray);

    performanceTrace.exitScope();
    return cinv22si;
  }

  /**
   * This method will determine what changes specific detail has been add, updated, or deleted.
   * 
   * @param context
   *                Contains the session, state, and request objects to get data from jsps
   * @param cinv22si
   *                CINV22SI that will be modifed
   * @param ucmDId
   * 				ID of the document uploaded onto UCM Server.
   * @return cinv22si Modifed CINV22SI object.
   */
  private CINV22SI audExtDocDetail(GrndsExchangeContext context, CINV22SI cinv22si, String ucmDId) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".AddUpdateExtDocDetail()");
    performanceTrace.enterScope();

    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();

    String fileName = (String) state.getAttribute("FileName", request);
    String formatType = (String) state.getAttribute("FileType", request);

    ROWCINV22SIG_ARRAY extDocArray = cinv22si.getROWCINV22SIG_ARRAY();
    if (extDocArray == null) {
      extDocArray = new ROWCINV22SIG_ARRAY();
    }
    Enumeration<ROWCINV22SIG> extDocEnum = extDocArray.enumerateROWCINV22SIG();

    // SIR#22839: rearranged the if statement to include SaveAndStay button
    boolean bDelete = false;
    boolean bSaved;
    int idExtDoc = ContextHelper.getIntSafe(request, "hdnUlIdExtSitInfo");
    if (null != ContextHelper.getString(request, "btnSaveAndStay.x")) {
      bSaved = state.getAttribute("btnSave", request) != null;
      this.setPresentationBranch("stay", context);
    } else {
      bSaved = state.getAttribute("btnSave", request) != null;
      bDelete = ContextHelper.getString(request, "btnDelete.x") != null;
      String rbIdExtDoc = ContextHelper.getString(request, "rbExtDoc");
      if (rbIdExtDoc != null) {
        idExtDoc = Integer.parseInt(rbIdExtDoc);
      }
    }
    org.exolab.castor.types.Date dateObtained = ContextHelper.getCastorDateSafe(request, "txtDtDtExtDocObtained");
    String sortOrder = ContextHelper.getStringSafe(request, "txtSzCdExtDocSort");
    String type = ContextHelper.getStringSafe(request, "selSzCdExtDocType");
    String docType = ContextHelper.getStringSafe(request, "selSzcdDocClass");
    String location = ContextHelper.getStringSafe(request, "txttSzTxtExtDocLocation");
    String details = ContextHelper.getStringSafe(request, "txtaSzTxtExtDocDetails");
    org.exolab.castor.types.Date dateUploaded = ContextHelper.getCastorDateSafe(request, "txtDtDtExtDocUploaded");
    org.exolab.castor.types.Date dateDocAdded = DateHelper.toCastorDate(new java.util.Date());
    String signed = CheckboxHelper.getCheckboxValue(request, "selIndSigned");
    signed = (!StringHelper.isValid(signed) ? "N" : signed);
    String CheckedNa = CheckboxHelper.getCheckboxValue(request, "selIndNaChecked");
    CheckedNa = (!StringHelper.isValid(CheckedNa) ? "N" : CheckedNa);
    String ICPCDoc = CheckboxHelper.getCheckboxValue(request, "selIndICPCDoc");
    ICPCDoc = (!StringHelper.isValid(ICPCDoc) ? "N" : ICPCDoc);

    String adMode = ContextHelper.getStringSafe(request, "hdnAUMode");

    if (adMode.equals(ServiceConstants.REQ_FUNC_CD_ADD)) {
      ROWCINV22SIG extDocDetail = new ROWCINV22SIG();
      extDocDetail.setUlIdCase(GlobalData.getUlIdCase(request));
      extDocDetail.setDtDtExtDocObtained(dateObtained);
      extDocDetail.setSzCdExtDocSort(sortOrder);
      extDocDetail.setSzCdExtDocType(type);
      extDocDetail.setSzCdDocClass(docType);
      extDocDetail.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_ADD);
      extDocDetail.setSzTxtExtDocDetails(details);
      extDocDetail.setSzTxtExtDocLocation(location);
      extDocDetail.setDtExtDocUploaded(dateUploaded);
      extDocDetail.setDtExtDocAdded(dateDocAdded);
      extDocDetail.setBIndExtDocSigned(signed);
      extDocDetail.setBIndNaChecked(CheckedNa);
      extDocDetail.setBIndICPCDoc(ICPCDoc);
      if(StringUtils.isNotBlank(ucmDId)) {
    	  extDocDetail.setSzTxtUcmDId(ucmDId);
      }
      if (fileName != null) {
        extDocDetail.setSzTxtFileName(fileName);
      }
      if (formatType != null) {
        extDocDetail.setSzTxtFormatType(formatType);
      }

      extDocArray.addROWCINV22SIG(extDocDetail);
      cinv22si.setUsSysNbrNumberOfRows(cinv22si.getUsSysNbrNumberOfRows() + 1);
    } else {
      while (extDocEnum.hasMoreElements()) {
        ROWCINV22SIG extDocDetail = (ROWCINV22SIG) extDocEnum.nextElement();
        if (idExtDoc == extDocDetail.getUlIdExtSitInfo()) {
          if (bDelete) {
            extDocDetail.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_DELETE);
            // If we're deleting we don't want to change any of the data.
            // so we break out of the while loop, so we won't populate anything
            // else in the extDocDetail object.
            break;
          }
          extDocDetail.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_UPDATE);
          extDocDetail.setDtDtExtDocObtained(dateObtained);
          extDocDetail.setSzCdExtDocSort(sortOrder);
          extDocDetail.setSzCdExtDocType(type);
          extDocDetail.setSzCdDocClass(docType);
          extDocDetail.setSzTxtExtDocDetails(details);
          extDocDetail.setSzTxtExtDocLocation(location);
          extDocDetail.setDtExtDocUploaded(dateUploaded);
          extDocDetail.setBIndExtDocSigned(signed);
          extDocDetail.setBIndNaChecked(CheckedNa);
          extDocDetail.setBIndICPCDoc(ICPCDoc);
          if (bSaved) {
            if(StringUtils.isNotBlank(ucmDId)) {
              extDocDetail.setSzTxtUcmDId(ucmDId);
            }
            if (fileName != null) {
              extDocDetail.setSzTxtFileName(fileName);
            }
            if (formatType != null) {
              extDocDetail.setSzTxtFormatType(formatType);
            }
          }
        }
      }
    }
    performanceTrace.exitScope();
    return cinv22si;
  }

  /**
   * This method will populate the civn23si object.
   * 
   * @param context
   *                Contains the session, state, and request objects to get data from jsps
   * @return cinv23si Populated CINV23SI object.
   */
  private CINV23SI populateCINV23SI_Retrieve(GrndsExchangeContext context, TuxedoPaginationValueBean tuxPagination) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".populateCINV23SI_Retrieve()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();

    ArchInputStruct input = new ArchInputStruct();

    input.setCReqFuncCd(tuxPagination.getResultDetails().getOrderBy());
    input.setUlPageSizeNbr(tuxPagination.getResultDetails().getResultsPerPage());
    input.setUsPageNbr(tuxPagination.getResultDetails().getRequestedPage());
    input.setSzUserId(UserProfileHelper.getUserProfile(request).getUserLogonID());
    
    String sortColumn = request.getParameter(SortableColumnTag.ORDER_BY_NAME);
    String requestedPage = request.getParameter(ResultsPaginationHelper.REQUESTED_PAGE_KEY);
    CINV23SI cinv23si = new CINV23SI();
    BaseSessionStateManager state = getSessionStateManager(context);
    //check if coming from sort or pagination
    if(StringHelper.isValid(sortColumn) || StringHelper.isValid(requestedPage)){
      cinv23si = (CINV23SI)state.getAttribute("CINV23SI",request);
      cinv23si.setArchInputStruct(input);
      cinv23si.setBIndSort(ArchitectureConstants.Y);
    }else{
      state.removeAllAttributes(request);
      cinv23si.setUlIdCase(GlobalData.getUlIdCase(request));
      cinv23si.setBIndSealed(getSealedAttribute(request));
      cinv23si.setArchInputStruct(input);
      // Adding the Search Parameter
      cinv23si.setDtScrSearchDateFrom(ContextHelper.getCastorDateSafe(request, "dtScrSearchDateFrom"));
      cinv23si.setDtScrSearchDateTo(ContextHelper.getCastorDateSafe(request, "dtScrSearchDateTo"));
      cinv23si.setSzTxtExtDocLocation(ContextHelper.getStringSafe(request, "txtSzTxtExtDocLocation"));
      cinv23si.setSzCdExtDocSort(ContextHelper.getStringSafe(request, "txtSzCdExtDocSortInList"));
      cinv23si.setBIndICPCDoc(CheckboxHelper.getCheckboxValue( request, "cbxICPCDocument" ));
      String[] adoInfoChecks = CheckboxHelper.getCheckedValues(request, "cbxAdoInfo");
      String[] caseDataChecks = CheckboxHelper.getCheckedValues(request, "cbxCaseData");
      String[] crtLegalChecks = CheckboxHelper.getCheckedValues(request, "cbxCrtLegalInfo");
      String[] fstAdoHmChecks = CheckboxHelper.getCheckedValues(request, "cbxFstAdoHmInfo");
      String[] hlthInfoChecks = CheckboxHelper.getCheckedValues(request, "cbxHlthInfo");
      String[] prsnInfoChecks = CheckboxHelper.getCheckedValues(request, "cbxPrsnInfo");
      String[] othChecks = CheckboxHelper.getCheckedValues(request, "cbxOth");
      String[] idPersonChecks = CheckboxHelper.getCheckedValues(request, "cbxUlIdPersons");
      //STGAP00015066 -- Starts here ---
      ROWCINV23SI01_ARRAY rowCinv23si01Array = new ROWCINV23SI01_ARRAY();
      int docTypeCount = 0;
      for (String docType : adoInfoChecks) {
        docTypeCount++;
        ROWCINV23SI01 rowCinv23si01 = new ROWCINV23SI01();
        rowCinv23si01.setSzCdExtDocType(docType);
        rowCinv23si01.setSzCdDocClass(CodesTables.CEXDOCLA_AI);
        rowCinv23si01Array.addROWCINV23SI01(rowCinv23si01);
      }
      for (String docType : caseDataChecks) {
        docTypeCount++;
        ROWCINV23SI01 rowCinv23si01 = new ROWCINV23SI01();
        rowCinv23si01.setSzCdExtDocType(docType);
        rowCinv23si01.setSzCdDocClass(CodesTables.CEXDOCLA_CD);
        rowCinv23si01Array.addROWCINV23SI01(rowCinv23si01);
      }
      for (String docType : crtLegalChecks) {
        docTypeCount++;
        ROWCINV23SI01 rowCinv23si01 = new ROWCINV23SI01();
        rowCinv23si01.setSzCdExtDocType(docType);
        rowCinv23si01.setSzCdDocClass(CodesTables.CEXDOCLA_CI);
        rowCinv23si01Array.addROWCINV23SI01(rowCinv23si01);
      }
      for (String docType : fstAdoHmChecks) {
        docTypeCount++;
        ROWCINV23SI01 rowCinv23si01 = new ROWCINV23SI01();
        rowCinv23si01.setSzCdExtDocType(docType);
        rowCinv23si01.setSzCdDocClass(CodesTables.CEXDOCLA_FA);
        rowCinv23si01Array.addROWCINV23SI01(rowCinv23si01);
      }
      for (String docType : hlthInfoChecks) {
        docTypeCount++;
        ROWCINV23SI01 rowCinv23si01 = new ROWCINV23SI01();
        rowCinv23si01.setSzCdExtDocType(docType);
        rowCinv23si01.setSzCdDocClass(CodesTables.CEXDOCLA_HI);
        rowCinv23si01Array.addROWCINV23SI01(rowCinv23si01);
      }
      for (String docType : prsnInfoChecks) {
        docTypeCount++;
        ROWCINV23SI01 rowCinv23si01 = new ROWCINV23SI01();
        rowCinv23si01.setSzCdExtDocType(docType);
        rowCinv23si01.setSzCdDocClass(CodesTables.CEXDOCLA_PI);
        rowCinv23si01Array.addROWCINV23SI01(rowCinv23si01);
      }
      for (String docType : othChecks) {
        docTypeCount++;
        ROWCINV23SI01 rowCinv23si01 = new ROWCINV23SI01();
        rowCinv23si01.setSzCdExtDocType(docType);
        rowCinv23si01.setSzCdDocClass(CodesTables.CEXDOCLA_XX);
        rowCinv23si01Array.addROWCINV23SI01(rowCinv23si01);
      }
      // Set the total row count
      rowCinv23si01Array.setUlRowQty(docTypeCount);
      cinv23si.setROWCINV23SI01_ARRAY(rowCinv23si01Array);
  
      // Add Persons
      ROWCINV23SI00_ARRAY rowCinv23si00Array = new ROWCINV23SI00_ARRAY();
      int personCount = 0;
      for (String idPerson : idPersonChecks) {
        personCount++;
        ROWCINV23SI00 rowCinv23si00 = new ROWCINV23SI00();
        rowCinv23si00.setUlIdPerson(Integer.parseInt(idPerson));
        rowCinv23si00Array.addROWCINV23SI00(rowCinv23si00);
      }
      // Set the total row count
      rowCinv23si00Array.setUlRowQty(personCount);
      cinv23si.setROWCINV23SI00_ARRAY(rowCinv23si00Array);
  
      //STGAP00015066 -- Ends here ---
      performanceTrace.exitScope();
    }
    return cinv23si;
  }

  /**
   * This method is called by the other methods to get whether the user has Rights to access ADO and FCC Stages after
   * the Adoption is Finalized.
   * STGAP00015066
   * @param request
   *                HTTP Servlet Request object.
   * @return String Return either N or Y.
   */
  private String getSealedAttribute(HttpServletRequest request) {
    String retValue = ArchitectureConstants.N;
    UserProfile userProfile = UserProfileHelper.getUserProfile(request);
    if (userProfile != null) {
      retValue = userProfile.hasRight(UserProfile.SEC_SAU_SEALED) == true ? ArchitectureConstants.Y
                                                                         : ArchitectureConstants.N;
    }
    return retValue;
  }
}
