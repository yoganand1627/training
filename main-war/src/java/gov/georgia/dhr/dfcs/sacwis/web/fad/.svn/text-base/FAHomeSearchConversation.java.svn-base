package gov.georgia.dhr.dfcs.sacwis.web.fad;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.TooManyRowsReturnedException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodeAttributes;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.LookupException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginationResultBean;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.Option;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.fad.FAChildSearchBean;
import gov.georgia.dhr.dfcs.sacwis.dao.fad.FAHomeValueBean;
import gov.georgia.dhr.dfcs.sacwis.service.resource.FAHomeList;
import gov.georgia.dhr.dfcs.sacwis.web.core.base.ValueBeanHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import oracle.sql.DATE;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

/**
 * This is the Conversation class used to search fad home and refine a search, conduct a new search, and display
 * selected list.STGAP00017313: retrieve char code by decode sort order tto match with page order.
 * <pre>
 * Change History:
 *   Date        User              Description
 *   --------   ----------------   --------------------------------------------------
 *   10/25/11   htvo               STGAP00017313: retrieve char code by decode sort order to match with page ordering.
 *   10/25/2011 htvo               STGAP00017310: defined constant for childLookup url to be included in jsp in the pool of 
 *                                 all possible prev url.
 *   11/01/2011 htvo               STGAP00017437: lookup chars sorted by decode to match with page display   
 *   11/06/2011 htvo               STGAP00017311: fixed age = 0 when there is no DOB
 *                                 STGAP00017459 retrieve person first, last name and suffix instead of full name for child search
 *                                 and format name as first last, suffix per design                           
 * </pre>  
 */
public class FAHomeSearchConversation extends BaseHiddenFieldStateConversation {
  public static final String TRACE_TAG = "FAHomeSearchConversation";

  public static final int FAD_MAX_AGE_YR = 19;

  public static final int FAD_MIN_AGE_YR = 1;

  public static final int FAD_MAX_AGE_MO = 11;

  public static final int FAD_MIN_AGE_MO = 1;

  public static final String FAD = "FAD";

  public static final String CPS = "CPS";

  public static final String FA_HOME_LIST = "FAHomeList";

  public static final String SEARCH_PAGE = "/fad/FAHomeSearch/faHomeSearch";

  public static final String DISPLAY_SEARCH_PAGE = "/fad/FAHomeSearch/displayHomeSearch";
  
  public static final String CHILD_SEARCH_PAGE = "/fad/FAHomeSearch/childLookup";

  public static final String FA_HOME_CONVERSATION_URL = "/fad/FAHomeSearch/";

  public static final String FA_HOME_STATUS_CLOSED = CodesTables.CFAHMSTA_CSD;
  
  FAHomeList faHomeList;

  public void setFaHomeList(FAHomeList faHomeList) {
    this.faHomeList = faHomeList;
  }

  /**
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void displayHomeSearch_xa(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayHomeSearch_xa()");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    state.removeAllAttributes(request);
    setInformationalMessage(Messages.MSG_MATCH_CRITERIA_INF, request);
    SortedMap<Integer, Option> years = new TreeMap<Integer, Option>();
    SortedMap<Integer, Option> months = new TreeMap<Integer, Option>();
    int yearCount = FAD_MIN_AGE_YR;
    int monthCount = FAD_MIN_AGE_MO;
    Option anOption;

    while (yearCount <= FAD_MAX_AGE_YR) {
      anOption = new Option(String.valueOf(yearCount), String.valueOf(yearCount));
      years.put(yearCount++, anOption);
    }

    state.setAttribute("years", years, request);

    while (monthCount <= FAD_MAX_AGE_MO) {
      anOption = new Option(String.valueOf(monthCount), String.valueOf(monthCount));
      months.put(monthCount++, anOption);
    }
    state.setAttribute("months", months, request);
    state.setAttribute(PageMode.PAGE_MODE_ATTRIBUTE_NAME, getPageMode(request, null), request);
    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  /**
   * This method displays new home info page *
   * 
   * @param context
   *          GrndsExchangeContext input object.
   */
  public void displayNewHomeInformation_xa(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "start_of.displayNewHomeInformation_xa()");
    performanceTrace.enterScope();
    // Allocate the structures
    HttpServletRequest request = context.getRequest();

    String pageMode = PageModeConstants.EDIT;
    GlobalData.setAppMode(pageMode, request);
    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

  }

  /**
   * This method displays new home info page *
   * 
   * @param context
   *          GrndsExchangeContext input object.
   */
  public void displayHomeInformationDetail_xa(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayHomeInformationDetail_xa()");
    performanceTrace.enterScope();
    // Allocate the structures
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    List faHomeList;
    FAHomeValueBean homeRow = null;
    String recordNumber = StringHelper.getSafeString(request.getParameter("indexNum"));
    int iRecordNumber = 0;
    if (recordNumber != null) {
      iRecordNumber = Integer.parseInt(recordNumber);
    }

    faHomeList = (List) state.getAttribute(FA_HOME_LIST, request);
    if (faHomeList != null) {
      homeRow = (FAHomeValueBean) faHomeList.get(iRecordNumber);
    }
    getPageMode(request, homeRow.getFaHomeStatus());
    state.setAttribute(PageMode.PAGE_MODE_ATTRIBUTE_NAME, getPageMode(request, null), request);
    GlobalData.setUlIdStage(homeRow.getHomeStageId(), request);
    CaseUtility.Stage myStage = CaseUtility.getStage(homeRow.getHomeStageId());
    String caseName = myStage.getNmCase();
    GlobalData.setSzNmCase(caseName, request);
    GlobalData.setUlIdCase(CaseUtility.getStage(homeRow.getHomeStageId()).getIdCase(), request);
    GlobalData.setSzCdStage(FAD, request);
    GlobalData.setSzNmStage(myStage.getNmStage(), request);
    GlobalData.setSzCdStageProgram(CPS, request);

    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }
  
 // ECEM 5.0 Action method used for child search functionality. 
  public void childLookup_xa(GrndsExchangeContext context) {
	  PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".faHomeSearch_xa()");
	    performanceTrace.enterScope();
	    
	    populateFAChildSearch(context);
	  
	// Log the performance trace info
	    performanceTrace.getTotalTime();
	    performanceTrace.exitScope();
  }
  
  
  

  public void faHomeSearch_xa(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".faHomeSearch_xa()");
    performanceTrace.enterScope();

    populateFAHomeList(context);
    HttpServletRequest request = context.getRequest();
    setInformationalMessage(Messages.MSG_MATCH_CRITERIA_INF, request);
    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  /**
   * This method returns page mode *
   * 
   * @param request
   *          HttpServletRequest input object. *
   * @param sHomeStatus
   *          String input object. *
   * @return pageMode String Output object **
   */
  protected static String getPageMode(HttpServletRequest request, String sHomeStatus) {
    String pageMode;
    UserProfile userProfile = UserProfileHelper.getUserProfile(request);
    String cReqFuncCd = request.getParameter("cReqFuncCd");
    boolean userHasMntnPrivelege = false;
    boolean userHasInquirePrivelege = false;
    GlobalData.setStageAccess(false, request);
    /*
     * The F/A Home Search is only accessible to those with the * Maintain Home Access security attribute
     * (SEC_MTN_HOME). * Users with this attribute generally include F/A Home Workers * and other staff in the F/A home
     * unit SEC_EMERG_PLCMT
     */

    if (userProfile != null) {
      userHasMntnPrivelege = userProfile.hasRight(UserProfile.SEC_MTN_HOME);
      userHasInquirePrivelege = userProfile.hasRight(UserProfile.SEC_EMERG_PLCMT);
    }

    /* for searching home, user only need to have SEC_MTN_HOME security */
    if (sHomeStatus == null && userHasMntnPrivelege) {
      pageMode = PageModeConstants.MODIFY;
      return pageMode;
    }

    if (cReqFuncCd != null) {
      if (userHasMntnPrivelege) {
        GlobalData.setStageAccess(true, request);
        if (cReqFuncCd.compareToIgnoreCase("M") == 0) {
          if (sHomeStatus.compareToIgnoreCase(FA_HOME_STATUS_CLOSED) == 0) {
            pageMode = PageModeConstants.MODIFY;
          } else {
            pageMode = PageModeConstants.VIEW;
          }
        } else if (cReqFuncCd.compareToIgnoreCase("A") == 0) {
          pageMode = PageModeConstants.NEW;
        } else {
          pageMode = PageModeConstants.VIEW;
        }
      } /* end if (userHasMntnPrivelege ) */else if (userHasInquirePrivelege) {
        pageMode = PageModeConstants.INQUIRE;
      } else {
        pageMode = PageModeConstants.VIEW;
      }
    } else {
      pageMode = PageModeConstants.VIEW;
    }
    if (pageMode.equals(PageModeConstants.EDIT)) {
      GlobalData.setAppMode(PageModeConstants.EDIT, request);
    } else {
      GlobalData.setAppMode(PageModeConstants.VIEW, request);
    }
    return pageMode;
  }

  /*
   * Constructor that builds the bean from an HttpServletRequest
   * 
   * @param request HttpServletRequest object @throws Exception
   */
  public FAHomeValueBean createFAHomeValueBean(HttpServletRequest request) throws LookupException {
    GrndsTrace.enterScope(TRACE_TAG + " constructor");
    FAHomeValueBean faHomeValueBean = new FAHomeValueBean();
    String sNmResource = StringHelper.getSafeString(request.getParameter("txtSzNmResource"));

    if (sNmResource != null) {
      // SIR 19040: JEH added function call to format names like "O'Brien".
      // FormattingHelper.changeCase does everything getResourceName does except
      // String trim, which is now done before the call. Also handles capatilization
      // after special characters like apostrophe, space, etc.

      sNmResource = FormattingHelper.changeCase(sNmResource.trim());
      faHomeValueBean.setResourceName(sNmResource);
    }
    if (StringHelper.getSafeString(request.getParameter("selSzCdRsrcFaHomeStatus")) != null) {
      faHomeValueBean.setFaHomeStatus(request.getParameter("selSzCdRsrcFaHomeStatus"));
    }
    if (StringHelper.getSafeString(request.getParameter("selSzCdRsrcRegion")) != null) {
      faHomeValueBean.setRegion(request.getParameter("selSzCdRsrcRegion"));
    }
    if (StringHelper.getSafeString(request.getParameter("selSzCdRsrcCnty")) != null) {
      faHomeValueBean.setResourceCounty(request.getParameter("selSzCdRsrcCnty"));
    }
    boolean bIncludeHmTypeInSearch = true;
    if (StringHelper.getSafeString(request.getParameter("selSzCdRsrcCategory")) != null) {
      faHomeValueBean.setResourceCategory(request.getParameter("selSzCdRsrcCategory"));
      bIncludeHmTypeInSearch = !(faHomeValueBean.getResourceCategory().equals(FAHomeValueBean.Adoptive));
    }

    String sCity = StringHelper.getSafeString(request.getParameter("txtSzAddrRsrcAddrCity"));

    if (sCity != null && !StringHelper.EMPTY_STRING.equals(sCity)) {
      sCity = sCity.trim();
      sCity = sCity.toUpperCase();
      faHomeValueBean.setCity(sCity);
    }

    // If the user selects "Adoptive" from the Category drop down menu,
    // and selects a value from the Type drop down menu, the Home type
    // will not be included as a parameter for the database search.
    // (Adoptive homes do not have home "types") FAHomeSearchConversation.
    if (bIncludeHmTypeInSearch && StringHelper.getSafeString(request.getParameter("selCCdRsrcFaHomeType1")) != null) {
      faHomeValueBean.setRsrcFaHomeType1(request.getParameter("selCCdRsrcFaHomeType1"));
    }

    if (StringHelper.getSafeString(request.getParameter("selSzCdRsrcLanguage")) != null) {
      faHomeValueBean.setLanguage(request.getParameter("selSzCdRsrcLanguage"));
    }

    String sGender = StringHelper.getSafeString(request.getParameter("selCCdPersonSex"));
    faHomeValueBean.setGender(sGender);
    if (sGender != null) {
      if (request.getParameter("minAge") != null) {
        faHomeValueBean.setMinAge(Integer.parseInt(request.getParameter("minAge")));
      }
      if (request.getParameter("maxAge") != null) {
        faHomeValueBean.setMaxAge(Integer.parseInt(request.getParameter("maxAge")));
      }
    }

    String sSchoolDistrict = StringHelper.getSafeString(request.getParameter("selSzCdSchoolDistrict"));

    if (sSchoolDistrict != null && !StringHelper.EMPTY_STRING.equals(sSchoolDistrict)) {
      sSchoolDistrict = sSchoolDistrict.trim();
      sSchoolDistrict = sSchoolDistrict.toUpperCase();
      faHomeValueBean.setSchoolDistrict(sSchoolDistrict);
    }

    String sMaritalStatus = StringHelper.getSafeString(request.getParameter("selSzCdMaritalStatus"));

    if (sMaritalStatus != null && !StringHelper.EMPTY_STRING.equals(sMaritalStatus)) {
      sMaritalStatus = sMaritalStatus.trim();
      sMaritalStatus = sMaritalStatus.toUpperCase();
      faHomeValueBean.setMaritalStatus(sMaritalStatus);
    }

    String sReligion = StringHelper.getSafeString(request.getParameter("selCdReligion"));
    if (sReligion != null && !StringHelper.EMPTY_STRING.equals(sReligion)) {
      sReligion = sReligion.trim();
      sReligion = sReligion.toUpperCase();
      faHomeValueBean.setReligion(sReligion);
    }
    
    String[] raceCheckedBoxes = CheckboxHelper.getCheckedValues(request, "cbxRace");
    if (raceCheckedBoxes != null && raceCheckedBoxes.length > 0) {
      faHomeValueBean.setRaceCriteria(Arrays.asList(raceCheckedBoxes));
    }
    
    String[] ethnicityCheckedBoxes = CheckboxHelper.getCheckedValues(request, "cbxEth"); 
    if(ethnicityCheckedBoxes != null && ethnicityCheckedBoxes.length > 0) {
      faHomeValueBean.setEthnicityCriteria(Arrays.asList(ethnicityCheckedBoxes));
    }
    
    String sEthnicity = StringHelper.getSafeString(request.getParameter("selEthnicity"));
    if (sEthnicity != null && !StringHelper.EMPTY_STRING.equals(sEthnicity)) {
      sEthnicity = sEthnicity.trim();
      sEthnicity = sEthnicity.toUpperCase();
      faHomeValueBean.setEthnicity(sEthnicity);
    }

    String sCapacity = StringHelper.getSafeString(request.getParameter("txtNbrRsrcFacilCapacity"));
    if (sCapacity != null && sCapacity.trim().length() > 0) {
      faHomeValueBean.setIntCapacity(Integer.parseInt(sCapacity));
    }

    String sOpenSlots = StringHelper.getSafeString(request.getParameter("txtNbrRsrcFacilOpenSlots"));
    if (sOpenSlots != null && sOpenSlots.trim().length() > 0) {
      faHomeValueBean.setOpenSlot(Integer.parseInt(sOpenSlots));
    }

    String sCurrPlcmnt = StringHelper.getSafeString(request.getParameter("txtNbrRsrcFacilCurrPlcmnt"));
    if (sCurrPlcmnt != null && sCurrPlcmnt.trim().length() > 0) {
      faHomeValueBean.setICurrPlcmnts(Integer.parseInt(sCurrPlcmnt));
    }

  //  String sAdoptExch = StringHelper.getSafeString(request.getParameter("rbIndRegAdptnExchge"));
  //  if (sAdoptExch != null && sAdoptExch.trim().length() > 0) {
  //    faHomeValueBean.setIndRegAdptnExchge(sAdoptExch);
  //  }

    List<String> checkedCharacteristicValues = new ArrayList<String>();
    // since number of characteristics in code table CPL might change, it's
    // best to retreive the number of characteristics from the code table instead of
    // assigning a fixed value
    // get the number of characteristics

    // ECEM 5.0 Iterating through Loop of Characteristics Categories 
    Collection<CodeAttributes> categoryCollection = Lookup.getCategoryCollection(CodesTables.CCHRTCA2);
    Iterator catIterator = categoryCollection.iterator();
    while(catIterator.hasNext()){
      CodeAttributes charCatCodeAtt = (CodeAttributes)catIterator.next();
      String catCode = charCatCodeAtt.getCode();
      // STGAP00017437: sorted by decode to match with page display
      Collection<CodeAttributes> codeCharas = Lookup.getCategoryCollectionSortedByDecode(catCode);	
      Iterator codeCharaIterator = codeCharas.iterator();	
      int i = 1;
      // ECEM Looping through list of Checkboxes for each category. 
      while (codeCharaIterator.hasNext()) {
  	  String sChkBox = "CharCbx" + catCode;
  	  CodeAttributes charBoxCodeAtt =   (CodeAttributes) codeCharaIterator.next();
  	  String code = charBoxCodeAtt.getCode();   	    
          sChkBox = sChkBox.concat(Integer.toString(i));
          if (request.getParameter(sChkBox) != null) {
            checkedCharacteristicValues.add(code);
          }
          i++;
      } 	
    }
    if (!checkedCharacteristicValues.isEmpty()) {
      faHomeValueBean.setResourceCharacteristics(checkedCharacteristicValues);
    }

    GrndsTrace.exitScope();
    return faHomeValueBean;
  }

    /**
   * This will pre populate the Fa Home Search page with the given persons id *
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void populateFAChildSearch(GrndsExchangeContext context) {
	
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "populateFAChildList");
    performanceTrace.enterScope();

    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();

    try {
      Boolean childSearchBtnPressed = true;
      state.setAttribute("childSearchBtnPressed", childSearchBtnPressed, request);
      String childIdString = StringHelper.getSafeString(request.getParameter("txtNbrChildPersonId"));
      if (childIdString != null) {
        // STGAP00017305: Removing any blank spaces from entered child ID
        childIdString = childIdString.replaceAll(" ", "");
        Integer idChild = new Integer(childIdString);
        if (idChild > 0) {
          int age = 0;
          FAChildSearchBean faChildSearchBean = faHomeList.getChildInformation(idChild);
          if (faChildSearchBean != null) {
            // STGAP00017311: only set actual age in state
            if (faChildSearchBean.getDob() != null) {
              age = DateHelper.getAge(faChildSearchBean.getDob());
              state.setAttribute("txtSzNmChildAge", Integer.toString(age), request);
            } else { // need to set "" so if there is age from previous search, it would be clear
              state.setAttribute("txtSzNmChildAge", StringHelper.EMPTY_STRING, request);
            }
            // STGAP00017459: retrieve person suffix and decode using the codes tables used on the Person page
            // format name as first last, suffix per design
            String cdChildSuffix = Lookup.simpleDecodeSafe("CSUFFIX2", faChildSearchBean.getCdPersonSuffix());
            String nmChild = faChildSearchBean.getNmPersonFirst() + " " + faChildSearchBean.getNmPersonLast();
            if (StringHelper.isValid(cdChildSuffix)) {
              nmChild = nmChild + ", " + cdChildSuffix;
            }
            state.setAttribute("txtSzNmChildName", nmChild, request);
            state.setAttribute("txtSzNmChildDob", FormattingHelper.formatDate(faChildSearchBean.getDob()), request);
            state.setAttribute("listRaces", faChildSearchBean.getRaces(), request);
            state.setAttribute("txtSzEthnicity", faChildSearchBean.getEthnicity(), request);
            state.setAttribute("checkedValues", faChildSearchBean.getResourceCharacteristics(), request);
            state.setAttribute("selCCdPersonSex", faChildSearchBean.getGender(), request);
          }
        }
      }
    } catch (TooManyRowsReturnedException tme) {
      this.setPresentationBranch("TooManyRowsReturned", context);
      String errorMessage = MessageLookup.getMessageByName("MSG_TOO_MANY_ROWS_RETURNED");
      setErrorMessage(errorMessage, "/fad/FAHomeSearch/faHomeSearch", request);
    } catch (ServiceException se) {
      int errorCode = se.getErrorCode();
      switch (errorCode) {
      case Messages.MSG_NO_CHILD_FOUND:
        GrndsTrace.msg(TRACE_TAG, 7, "Search:" + se.getMessage());
        setPresentationBranch("error", context);
        setErrorMessage(errorCode, context.getRequest());
        break;
      default:
        GrndsTrace.msg(TRACE_TAG, 7, "save:" + se.getMessage());
        processSevereException(context, se);
        break;
      }
    } catch (Exception e) {
      processSevereException(context, e);
    }
  }	    		    
  
  /**
   * This will populate the bean home list *
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void populateFAHomeList(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "populateFAHomeList");
    performanceTrace.enterScope();

    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();
    try {
      String sCreqFuncCd = request.getParameter("cReqFuncCd");

      String sTmp = StringHelper.getSafeString(request.getParameter("txtUlIdResource"));
      PaginationResultBean pPaginationResultBean;
      FAHomeValueBean searchBean = null;
      if (sCreqFuncCd == null) {
        searchBean = (FAHomeValueBean) state.getAttribute("searchBean", request);
      }

      if (searchBean == null) {
        if (sTmp != null && !StringHelper.EMPTY_STRING.equals(sTmp)) {
          sTmp = sTmp.trim();
          int resourceId = Integer.parseInt(sTmp);
          searchBean = new FAHomeValueBean(resourceId);
        } else {
          /* Save the checked values to state for redisplay if necessary */
          List<String> checkedCharacteristicValues = new ArrayList<String>();
         // ECEM 5.0 Modifing looping logic to consider the newly created expandable sections 
          Collection<CodeAttributes> categoryCollection = Lookup.getCategoryCollection(CodesTables.CCHRTCA2);          
          Iterator catIterator = categoryCollection.iterator();
          while(catIterator.hasNext()){
            CodeAttributes charCatCodeAtt = (CodeAttributes)catIterator.next();
            String catCode = charCatCodeAtt.getCode(); 
            // STGAP00017313: retrieve char code by decode sort order to match with page ordering.
      	    Collection<CodeAttributes> codeCharas = Lookup.getCategoryCollectionSortedByDecode(catCode);	

            Iterator codeCharaIterator = codeCharas.iterator();	
            int i = 1;
                while (codeCharaIterator.hasNext()) {
              	  
              	  String sChkBox = "CharCbx" + catCode;
              	  CodeAttributes charBoxCodeAtt =   (CodeAttributes) codeCharaIterator.next();
              	    String code = charBoxCodeAtt.getCode();   	    
                    sChkBox = sChkBox.concat(Integer.toString(i));
                    if (request.getParameter(sChkBox) != null) {
                      checkedCharacteristicValues.add(code);
                    }
                    i++;
                  } 	
          }
          if (!checkedCharacteristicValues.isEmpty() && checkedCharacteristicValues!= null ) {   
              state.setAttribute("checkedValues", checkedCharacteristicValues, request);
              GrndsTrace.msg(TRACE_TAG, 10, "checkedValues_is_: ?" + checkedCharacteristicValues.toString() + "?");
          }
          searchBean = createFAHomeValueBean(request);
        }
      }

      ValueBeanHelper.populateDefaultValues(context, searchBean);
      state.setAttribute("searchBean", searchBean, request);
      // Get result details
      searchBean.getResultDetails();

      // Get a reference to the FAHomeList EJB
      pPaginationResultBean = faHomeList.getFAHomeList(searchBean);
      if (pPaginationResultBean != null) {
        List vTmp = pPaginationResultBean.getResults();
        state.setAttribute(FA_HOME_LIST, vTmp, request);
        request.setAttribute(FA_HOME_LIST, vTmp);
        pPaginationResultBean.getResults();
        pPaginationResultBean.getResultDetails().setResultsPerPage(FAHomeValueBean.SEARCH_RESULTS_PER_PAGE);
        storePaginationBeanToRequest(context, pPaginationResultBean);
      }
    } catch (TooManyRowsReturnedException tme) {
      this.setPresentationBranch("TooManyRowsReturned", context);
      String errorMessage = MessageLookup.getMessageByName("MSG_TOO_MANY_ROWS_RETURNED");
      setErrorMessage(errorMessage, "/fad/FAHomeSearch/faHomeSearch", request);
    } catch (Exception e) {
      processSevereException(context, e);
    }
  }
}