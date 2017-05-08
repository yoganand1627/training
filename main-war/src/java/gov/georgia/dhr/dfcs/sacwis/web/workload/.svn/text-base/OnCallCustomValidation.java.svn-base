package gov.georgia.dhr.dfcs.sacwis.web.workload;

import java.text.ParseException;
//import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
//import java.util.HashMap;
//import java.util.Iterator;
import java.util.List;
//import java.util.Map;

import javax.servlet.http.HttpServletRequest;

//import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
//import gov.georgia.dhr.dfcs.sacwis.core.exception.RuntimeWrappedException;
//import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
//import gov.georgia.dhr.dfcs.sacwis.core.utility.DateUtility;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN10SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN22DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN06SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN16DO;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

/**
 * Used to perform the custom validation on On-Call Search when the user searches for matching on-call schedules.
 *
 * @author Jason Rios 12/19/2002 <p/> Change History:
 *  Date        User         Description 
 *  10/14/2003  CORLEYAN SIR 19857 -- ContextHelper.get... replaces
 *         getInputValue(), removed InputValidation.UNSPECIFIED_INPUT_FIELD removed message lookup.
 *  12/09/2008  arege        STGAP00010274 MSG_CMN_NOT_FULL error should not be thrown when Saving an On-Call Detail 
 *                           Page after deleting an employee from the On-Call Detail. 
 *         
 */
public class OnCallCustomValidation extends FormValidation {

  /**
   * <p/>
   * This method contains custom validation that is checked when the user searches for on-call schedules. </p>
   *
   * @return result - Returns false if the data fails validation. Returns true if the data passes validation.
   */
  protected boolean validateForm() {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".validateForm()");
    performanceTrace.enterScope();

    HttpServletRequest request = super.getRequest();
    boolean isValidOverall = true;
    boolean isValidForDelete = true;
    boolean isValidForSearch = true;
    boolean isValidForSave = true;

    // Perform the following validation if the user clicked 'Delete' to delete
    // an On-Call Schedule.
    if (super.isButtonPressed("btnDeleteOnSearchPage")) {
      isValidForDelete = validateFormForDelete();
      return isValidForDelete;
    }

    // Perform the following validation for 'Search' and 'Save'.
    if (super.isButtonPressed("btnSearch")) {
      isValidForSearch = validateDates(request, true);
      
      // Confirm that at least one county has been selected. If 'Statewide' is
      // the selected region, then all the counties will be selected by default.
      // Therefore, only check the counties if 'Statewide' is not the selected
      // region.
      // String selectedRegion = ContextHelper.getStringSafe(request, "selSzCdRegion");
      // if (!selectedRegion.equals(CodesTables.CREGIONS_98)) {
      // String checkboxGroupName = "cbxSelectedCountiesRegion" + selectedRegion;
      // String[] selectedCountiesFromRequest = null;
      // selectedCountiesFromRequest = CheckboxHelper.getCheckedValues(request, checkboxGroupName);
      // if (selectedCountiesFromRequest.length < 1) {
      // isValidForSearch = false;
      // setErrorMessage(Messages.MSG_ONCALL_CNTY_REQ);
      // }
      // }
      
      /* This is checking if the start time is entered but no the date if so it gives an error - jd
      if (!"".equals(startTime) && DateHelper.isNull(startDate)) { 
        this.setErrorMessage(TXT_DT_ONCALL_START, "Must specify a Start Date if a Start Time is specified.");
        return false;
        }
      if (!"".equals(endTime) && DateHelper.isNull(endDate)) { 
        this.setErrorMessage(TXT_DT_ONCALL_END, "Must specify an End Date if an End Time is specified.");
        return false;
        }
      // - jd
      */
      /*
      String county = ContextHelper.getStringSafe(request, "selSzCdCounty");
      if (county == null || "".equals(county)) {
        isValidForSearch = false;
        setErrorMessage(Messages.SSM_COMPLETE_REQUIRED);
      }
      */

      /* 'Start Date' must be before 'End Date' if they both are present.
      if (!DateHelper.NULL_CASTOR_DATE.equals(startDate) && !DateHelper.NULL_CASTOR_DATE.equals(endDate)) {
        Date startDateAsJavaUtilDate = null;
        Date endDateAsJavaUtilDate = null;
        try {
          // Get 'Start Date' and 'End Date' as a java.util.Date
          SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
          String startDateAsString = startDate.toString();
          String endDateAsString = endDate.toString();
          if (!"".equals(startTime) && !"".equals(endTime)) {
            formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm a");
            startDateAsString = startDate.toString() + " " + startTime;
            endDateAsString = endDate.toString() + " " + endTime;
          }
           
          startDateAsJavaUtilDate = formatter.parse(startDateAsString);
          endDateAsJavaUtilDate = formatter.parse(endDateAsString);
        } catch (Exception e) {
          throw new RuntimeWrappedException(e);
        }
       
        // The 'Start Date' must be before the 'End Date'
        if (endDateAsJavaUtilDate.before(startDateAsJavaUtilDate)
            || endDateAsJavaUtilDate.equals(startDateAsJavaUtilDate)) {
          isValidForSearch = false;
          setErrorMessage(TXT_DT_ONCALL_START, Messages.SSM_START_BEFORE_END);
        }
      } // end ( !DateHelper.NULL_CASTOR_DATE.equals(startDate) && !DateHelper.NULL_CASTOR_DATE.equals(endDate) )
      */
    } // end if ( super.isButtonPressed( btnSearch ) || super.isButtonPressed( btnSave ) )

    // Perform the following validation if the user clicked 'Save'.
    if (super.isButtonPressed("btnSave")) {
      isValidForSave = validateFormForSave();
    }

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

    isValidOverall = isValidForSearch && isValidForSave;
    return isValidOverall;
  }

  /**
   * <p/>
   * This method contains custom validation that is checked when the user attempts to delete an on-call schedule. </p>
   *
   * @return result - Returns false if the data fails validation. Returns true if the data passes validation.
   */
  private boolean validateFormForDelete() {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".validateFormForDelete()");
    performanceTrace.enterScope();

    HttpServletRequest request = super.getRequest();
    BaseSessionStateManager state = super.getState();
    boolean isValid = true;
    org.exolab.castor.types.Date endDate = null;

    int ulIdOnCall = ContextHelper.getIntSafe(request, "rbUlIdOnCall");

    // Iterate through the on-call schedules that were displayed in the
    // list, find the selected schedule, and get its date fields.
    CCMN06SO ccmn06so_list = (CCMN06SO) state.getAttribute("CCMN06SO_LIST", request);
    Enumeration enumeration = ccmn06so_list.getROWCCMN16DO_ARRAY().enumerateROWCCMN16DO();
    ROWCCMN16DO schedule = null;
    while (enumeration.hasMoreElements()) {
      schedule = (ROWCCMN16DO) enumeration.nextElement();
      if (schedule.getUlIdOnCall() == ulIdOnCall) {
        endDate = schedule.getDtDtOnCallEnd();
      }
    }

    // The user cannot delete the schedule if the End Date is today.
    if (DateHelper.isToday(endDate)) {
      isValid = false;
      setErrorMessage(Messages.MSG_ONCALL_DELETE_SHFT_BLK);
    }

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return isValid;
  }

  /**
   * <p/>
   * This method contains custom validation that is checked when the user saves a new on-call schedule. </p>
   *
   * @return result - Returns false if the data fails validation. Returns true if the data passes validation.
   */
  private boolean validateFormForSave() {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".validateFormForSave()");
    performanceTrace.enterScope();

    HttpServletRequest request = super.getRequest();
    BaseSessionStateManager state = super.getState();
    
    //-- check validity of start date and time and end date and time
    boolean datesAreValid = validateDates(request, false);
    
    //-- check validity of employees (at least one assigned and no duplicate call orders)
    CCMN10SI ccmn10si = (CCMN10SI) state.getAttribute("CCMN10SI", request);
    //boolean hasEmployees = checkForEmployee(ccmn10si);
    boolean employeeListIsValid = checkEmployeeList(ccmn10si);

    /* 'Type' field is conditionally required to save.
    if ("".equals(ContextHelper.getStringSafe(request, "selSzCdOnCallType"))) {
      isValid = false;
      setErrorMessage("selSzCdOnCallType", Messages.SSM_COMPLETE_REQUIRED);
    }
    */

    /* 'Start Date' is conditionally required to save.
    if (DateHelper.NULL_CASTOR_DATE.equals(startDate)) {
      isValid = false;
      setErrorMessage(TXT_DT_ONCALL_START, Messages.SSM_COMPLETE_REQUIRED);
    } else {
      // 'Start Date' cannot be before today's date
      if (DateHelper.isBeforeToday(startDate)) {
        isValid = false;
        setErrorMessage(TXT_DT_ONCALL_START, Messages.MSG_CMN_CANNOT_ADD);
      }
    }
    */    

    /* 'End Date' is conditionally required to save.
    if (DateHelper.NULL_CASTOR_DATE.equals(endDate)) {
      isValid = false;
      setErrorMessage(TXT_DT_ONCALL_END, Messages.SSM_COMPLETE_REQUIRED);
    }
    */

    /* 'Start Time' is conditionally required to save.
    if ("".equals(startTime)) {
      isValid = false;
      setErrorMessage(TXT_TM_ONCALL_START, Messages.SSM_COMPLETE_REQUIRED);
    }
    */

    /* 'End Time' is conditionally required to save.
    if ("".equals(endTime)) {
      isValid = false;
      setErrorMessage(TXT_TM_ONCALL_END, Messages.SSM_COMPLETE_REQUIRED);
    }
    */

    /* 'Start Date' must be before 'End Date'.
    if (!DateHelper.NULL_CASTOR_DATE.equals(startDate) && !DateHelper.NULL_CASTOR_DATE.equals(endDate)
        && !"".equals(startTime) && !"".equals(endTime)) {
      Date startDateAsJavaUtilDate = null;
      Date endDateAsJavaUtilDate = null;
      try {
        // Get 'Start Date' and 'End Date' as a java.util.Date
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm a");
        String startDateAsString = startDate.toString() + " " + startTime;
        String endDateAsString = endDate.toString() + " " + endTime;
        startDateAsJavaUtilDate = formatter.parse(startDateAsString);
        endDateAsJavaUtilDate = formatter.parse(endDateAsString);
      } catch (Exception e) {
        throw new RuntimeWrappedException(e);
      }

      // The 'Start Date' must be before the 'End Date'
      if (endDateAsJavaUtilDate.before(startDateAsJavaUtilDate)
          || endDateAsJavaUtilDate.equals(startDateAsJavaUtilDate)) {
        isValid = false;
        setErrorMessage(TXT_DT_ONCALL_START, Messages.SSM_START_BEFORE_END);
      }
    }
    */
    
    //-- only check number 1 from below is still a valid requirement
    //-- check at least one employee assigned and no duplicate contact orders

    /*
     * * The following checks need to be made to insure that the proper number of * employees have been entered. * * 1.
     * Check contact order for duplicates. No duplicates are allowed. * 2. Check for no more than two entries with the
     * same IdPerson. At most, * two entries with the same IdPerson are allowed. If two entries with * the same IdPerson
     * are found, one of the designations for the IdPerson * must be 'RC'. * 3. Check that the on-call shift/block
     * contains the required minimum * workers. * 4. If the PageMode is NEW_USING and all required employees exist,
     * perform * CriticalPeriodCheck. (THIS CHECK WAS REMOVED FROM CCMN21W WINDOW CODE * IN CAPS PER SIR 5168, SO IT IS
     * NO LONGER NEEDED HERE EITHER.) * * If the PageMode is MODIFY, only ccmn22d (AUD) will need to be called from *
     * the save service (ccmn10s). * * If the PageMode is NEW_USING, all three dams: ccmn16d (query), ccmn20d * (add),
     * and ccmn22d (add) will need to be called from the save service * (ccmn10s).
     */
    
    /*
    Map contactOrderHashtable = new HashMap();
    ROWCCMN22DI employee = null;
    Map employeeMap = new HashMap();
    List entriesAndRCVector = null;
    Integer numOfEntriesInVector = null;
    Boolean isDesignatedRCInVector = null;
    Integer totalNumOfEntries = null;
    Boolean isDesignatedRC = null;
    employee = null;
    if (ccmn10si != null) {
    */
      /*
       * * 1. Check contact order for duplicates. No duplicates are allowed. * * Build a hashtable of the contact orders
       * where the 'key' is the contact * order and the 'value' is the number of times the contact order appears * in
       * the employee list. If a contact order appears more than once, then * give the user an error message immediately
       * and end the validation.
       */
    /*
      Enumeration enumeration = ccmn10si.getROWCCMN22DI_ARRAY().enumerateROWCCMN22DI();
      while (enumeration.hasMoreElements()) {
        employee = (ROWCCMN22DI) enumeration.nextElement();

        // Check the contact order only if the employee is not marked for deletion.
        if (employee.getSzCdScrDataAction() == null || "".equals(employee.getSzCdScrDataAction())
            || !employee.getSzCdScrDataAction().equals(ServiceConstants.REQ_FUNC_CD_DELETE)) {
          // If the contact order is already in the hashtable, then give the user
          // an error message, and end the validation; otherwise, put the contact
          // order in the hashtable.
          if (contactOrderHashtable.containsKey(employee.getUsNbrEmpOnCallCntctOrd())) {
            isValid = false;
            setErrorMessage(Messages.MSG_CMN_DUP_CONTACT_ORDER);
            break;
          }
          contactOrderHashtable.put(employee.getUsNbrEmpOnCallCntctOrd(), 1);
        } // end if( employee.getSzCdScrDataAction() == null ||
      } // end while( enumeration.hasMoreElements() )
      */
      /*
       * * 2. Check for no more than two entries with the same IdPerson. At most, * two entries with the same IdPerson
       * are allowed. If two entries with * the same IdPerson are found, one of the designations for the IdPerson * must
       * be Router (RC). * * Build a hashtable of the employees where the 'key' is the IdPerson of the * employee and
       * the 'value' is a two-element vector. The first element of * the vector is the number of times the employee is
       * listed for this schedule. * The second element of the vector is a boolean indicator that indicates * whether or
       * not the employee is designated as 'RC' in one of the entries.
       */
    /*
      enumeration = ccmn10si.getROWCCMN22DI_ARRAY().enumerateROWCCMN22DI();
      while (enumeration.hasMoreElements()) {
        employee = (ROWCCMN22DI) enumeration.nextElement();

        // Check the employee's designations only if the employee is not marked
        // for deletion.
        if (employee.getSzCdScrDataAction() == null
            || !employee.getSzCdScrDataAction().equals(ServiceConstants.REQ_FUNC_CD_DELETE)) {
          // Check whether or not the employee is designated as Router (RC).
          isDesignatedRC = Boolean.FALSE;
          // if (employee.getSzCdEmpOnCallDesig().equals(CodesTables.COCDESGN_RC)) {
          // isDesignatedRC = Boolean.TRUE;
          // }

          // If the employee is already in the hashtable, increment their counter
          // and reset their 'RC' designation, if necessary. If the employee is not
          // yet in the hashtable, add them to it.
          if (employeeMap.containsKey(employee.getUlIdPerson())) {
            entriesAndRCVector = (List) employeeMap.get(employee.getUlIdPerson());
            numOfEntriesInVector = (Integer) entriesAndRCVector.get(0);
            isDesignatedRCInVector = (Boolean) entriesAndRCVector.get(1);
            totalNumOfEntries = numOfEntriesInVector.intValue() + 1;
            entriesAndRCVector = new ArrayList();
            entriesAndRCVector.add(0, totalNumOfEntries);
            if (isDesignatedRC) {
              entriesAndRCVector.add(1, isDesignatedRC);
            } else {
              entriesAndRCVector.add(1, isDesignatedRCInVector);
            }
          } else {
            entriesAndRCVector = new ArrayList();
            entriesAndRCVector.add(0, 1);
            entriesAndRCVector.add(1, isDesignatedRC);
          }
          employeeMap.put(employee.getUlIdPerson(), entriesAndRCVector);
        } // end if( employee.getSzCdScrDataAction() == null ||
      } // end while( enumeration.hasMoreElements() )

      // Check the number of entries for each employee. If there are more than
      // two entries for any employee, throw an error (MSG_CMN_THREE_TIMES). If
      // there are two entries for an employee, and the employee is not designated
      // 'RC' in either entry, throw an error (MSG_CMN_TWICE_NO_RC).
      Integer employeeId;
      Iterator it = employeeMap.keySet().iterator();
      while (it.hasNext()) {
        employeeId = (Integer) it.next();
        entriesAndRCVector = (List) employeeMap.get(employeeId);
        numOfEntriesInVector = (Integer) entriesAndRCVector.get(0);
        isDesignatedRCInVector = (Boolean) entriesAndRCVector.get(1);
        if (numOfEntriesInVector == 3) {
          isValid = false;
          setErrorMessage(Messages.MSG_CMN_THREE_TIMES);
        } else if (numOfEntriesInVector == 2 && !isDesignatedRCInVector) {
          isValid = false;
          setErrorMessage(Messages.MSG_CMN_TWICE_NO_RC);
        }
      } // end while( it.hasNext() )
    } // end if ( ccmn10si != null )
    */

    /*
     * * 3. Check that the on-call shift/block contains the required minimum * workers. * * If any of the requirements
     * are not met, the checkForMinimumWorkers() * method will put an appropriate error message into the request.
     */
    // OnCallEmployeeDeatil Page does not store designation
    /*
     * boolean hasMinimumWorkers = checkForMinimumWorkers(request, state); if (!hasMinimumWorkers) { isValid = false; }
     */

    // There should be atleast one employee associated with Schedule
    //boolean hasAtleastOnEmployee = checkEmployee(request, state);
    //if (!hasAtleastOnEmployee) {
    //  isValid = false;
    //}

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return datesAreValid && employeeListIsValid;
  }
  
  private boolean validateDates(HttpServletRequest request, boolean isSearchButton){
    boolean isValid = true;
    
    //-- get inputs from form (request parameters)
    Date startDate = ContextHelper.getJavaDateSafe(request, TXT_DT_ONCALL_START);
    Date endDate = ContextHelper.getJavaDateSafe(request, TXT_DT_ONCALL_END);
    String startTime = ContextHelper.getTimeSafe(request, TXT_TM_ONCALL_START);
    String endTime = ContextHelper.getTimeSafe(request, TXT_TM_ONCALL_END);
    
    //-- combine dates and times
    
    Date startDateAndTime = null;
    Date endDateAndTime = null;
    if(!DateHelper.isNull(startDate) && !DateHelper.isNull(endDate)){
    startDateAndTime = DateHelper.toJavaDateSafe(startDate, startTime);
    endDateAndTime = DateHelper.toJavaDateSafe(endDate, endTime);
    }
    
    //-- if called from the search button, check date is given if time is given
    if(isSearchButton){
      if(!"".equals(startTime) && DateHelper.isNull(startDate)){
        setErrorMessage(TXT_DT_ONCALL_START, "Must specify a Start Date if a Start Time is specified.");
        isValid = false;
      }
      if(!"".equals(endTime) && DateHelper.isNull(endDate)){
        setErrorMessage(TXT_DT_ONCALL_END, "Must specify an End Date if an End Time is specified.");
        isValid = false;
      }
    } else{
      //-- if saving, check Start Date and Start Time are not before the current date and time
      Date now = new Date();
      if(!DateHelper.isNull(startDateAndTime) && startDateAndTime.compareTo(now) < 0){
        isValid = false;
        setErrorMessage(TXT_DT_ONCALL_START, Messages.MSG_CMN_CANNOT_ADD);
      }
    }
    
    //-- check Start Date and Start Time is before End Date and End Time
    if(!DateHelper.isNull(startDateAndTime) && !DateHelper.isNull(endDateAndTime)){
      if(endDateAndTime.compareTo(startDateAndTime) < 0){
        isValid = false;
        setErrorMessage(TXT_DT_ONCALL_START, Messages.SSM_START_BEFORE_END);
      }
    }
    
    return isValid;
  }

  /** This method checks to see if the On Call Schedule has atleast one employee */
  private boolean checkForEmployee(CCMN10SI ccmn10si) {
    /*
    boolean result = false;
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".checkEmployee()");
    performanceTrace.enterScope();
    */
    
    boolean isValid;
    if(ccmn10si == null || ccmn10si.getROWCCMN22DI_ARRAY() == null){
      isValid = false;
    } else{
      isValid = ccmn10si.getROWCCMN22DI_ARRAY().getROWCCMN22DI().length > 0;
    }
    
    if(!isValid){
      setErrorMessage(Messages.MSG_CMN_NOT_FULL);
    }
    return isValid;

    //CCMN10SI ccmn10si = (CCMN10SI) state.getAttribute("CCMN10SI", request);
    /*
    int numEmployees = 0;
    if (ccmn10si != null) {
      Enumeration enumeration = ccmn10si.getROWCCMN22DI_ARRAY().enumerateROWCCMN22DI();
      while (enumeration.hasMoreElements()) {
        numEmployees++;
        break;
      }
    }
    if (numEmployees > 0) {
      result = true;
    } else {
      setErrorMessage(Messages.MSG_CMN_NOT_FULL);
    }
    */
    
    /*
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

    return result;
    */
  }
  
  private boolean checkEmployeeList(CCMN10SI ccmn10si) {
    boolean hasEmployee = true;
    boolean duplicateOrders = false;
    boolean duplicateIDs = false;
    
    int empCounter = 0;
    String dataAction = StringHelper.EMPTY_STRING;
      
    if(ccmn10si != null && ccmn10si.getROWCCMN22DI_ARRAY() != null){
      List<Integer> orders = new ArrayList<Integer>();
      List<Integer> ids = new ArrayList<Integer>();
      Enumeration e = ccmn10si.getROWCCMN22DI_ARRAY().enumerateROWCCMN22DI();
      while(e.hasMoreElements()){
        ROWCCMN22DI emp = (ROWCCMN22DI) e.nextElement();
        
        dataAction = emp.getSzCdScrDataAction();
        if(!ServiceConstants.REQ_FUNC_CD_DELETE.equals(dataAction)){
          empCounter++;
        
          Integer order = new Integer(emp.getUsNbrEmpOnCallCntctOrd());
          if(orders.contains(order)){
            duplicateOrders = true;
          }
          orders.add(order);
          
          Integer idPerson = new Integer(emp.getUlIdPerson());
          if(ids.contains(idPerson)){
            duplicateIDs = true;
          }
          ids.add(idPerson);
        }
      }
    }
    //STGAP00010274 Added condition to check if the dataAction was not delete.
    if(empCounter == 0 && !ServiceConstants.REQ_FUNC_CD_DELETE.equals(dataAction)){
      hasEmployee = false;
      setErrorMessage(Messages.MSG_CMN_NOT_FULL);
    }
    
    if(duplicateOrders){
      setErrorMessage(Messages.MSG_CMN_DUP_CONTACT_ORDER);
    }
    if(duplicateIDs){
      setErrorMessage("You cannot associate the same employee to a Shift/Block more than once.");
    }
    return hasEmployee && !duplicateOrders && !duplicateIDs;
  }

  /**
   * <p/>
   * This method is used to determine whether an on-call shift or block contains business hours, non-business hours, or
   * both. </p>
   * <p/>
   * <p/>
   * business hours (8am - 5pm, M - F) </p>
   * <p/>
   * non-business hours (5pm - 8am, M - F; and 5pm Friday thru 8am Monday) </p>
   *
   * @return result - Returns BUSINESS_HOURS (int) if the on-call shift or block contains only business hours. Returns
   *         NON_BUSINESS_HOURS (int) if the on-call shift or block contains only non-business hours. Returns
   *         BOTH_BUSINESS_AND_NON_BUSINESS_HOURS (int) if the on-call shift or block contains both business hours and
   *         non-business hours.
   */
  /*
  private int determineTypeOfHours(HttpServletRequest request) throws RuntimeWrappedException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".determineTypeOfHours()");
    performanceTrace.enterScope();

    int result = 0;
    boolean spansBusinessHours = false;
    boolean spansNonBusinessHours = false;

    String typeOfSchedule = ContextHelper.getStringSafe(request, "selSzCdOnCallType");

    // Get 'Start Date', 'Start Time', 'End Date' and 'End Time'
    org.exolab.castor.types.Date startDate = ContextHelper.getCastorDateSafe(request, TXT_DT_ONCALL_START);
    org.exolab.castor.types.Date endDate = ContextHelper.getCastorDateSafe(request, TXT_DT_ONCALL_END);
    String startTime = ContextHelper.getTimeSafe(request, TXT_TM_ONCALL_START);
    String endTime = ContextHelper.getTimeSafe(request, TXT_TM_ONCALL_END);

    // Get the number of days between (and including) 'Start Date' and 'End Date'
    gov.georgia.dhr.dfcs.sacwis.core.utility.Date startDateAsImpactUtilDate =
            new gov.georgia.dhr.dfcs.sacwis.core.utility.Date(
                    startDate
                            .getDay(),
                    startDate
                            .getMonth(),
                    startDate
                            .getCentury()
                    * 100
                    + startDate
                            .getYear());
    gov.georgia.dhr.dfcs.sacwis.core.utility.Date endDateAsImpactUtilDate =
            new gov.georgia.dhr.dfcs.sacwis.core.utility.Date(
                    endDate
                            .getDay(),
                    endDate
                            .getMonth(),
                    endDate
                            .getCentury()
                    * 100
                    + endDate
                            .getYear());
    int numOfDaysInRange = DateUtility.getDatesInRange(startDateAsImpactUtilDate, endDateAsImpactUtilDate,
                                                       DateUtility.DAY, 1).size();

    // Get 'Start Date' and 'End Date' elements
    Date startDateAsJavaUtilDate = null;
    Date endDateAsJavaUtilDate = null;
    int startDay;
    int endDay;
    int startTimeHour24;
    int endTimeHour24;
    int endTimeMinutes;
    try {
      // Get 'Start Date' and 'End Date' as a java.util.Date
      SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm a");
      String startDateAsString = startDate.toString() + " " + startTime;
      String endDateAsString = endDate.toString() + " " + endTime;
      startDateAsJavaUtilDate = formatter.parse(startDateAsString);
      endDateAsJavaUtilDate = formatter.parse(endDateAsString);

      // Determine the day of the week of the 'Start Date' and 'End Date'
      startDay = DateHelper.getDayOfWeekAsInt(startDate);
      endDay = DateHelper.getDayOfWeekAsInt(endDate);

      // Get the hour portion of the 'Start Time' and 'End Time' in Universal
      // Military Time (24-hour time)
      formatter = new SimpleDateFormat("H");
      startTimeHour24 = Integer.parseInt(formatter.format(startDateAsJavaUtilDate));
      endTimeHour24 = Integer.parseInt(formatter.format(endDateAsJavaUtilDate));

      // Get the minutes portion of the 'Start Time' and 'End Time'
      formatter = new SimpleDateFormat("m");
      endTimeMinutes = Integer.parseInt(formatter.format(endDateAsJavaUtilDate));
    } catch (Exception e) {
      throw new RuntimeWrappedException(e);
    }

    /*
     * * 1. First, consider whether the on-call schedule is of type shift (SH) * or block (BL). * 2. Then consider each
     * of the following cases for the shift or the block: * a. Start Day = business day, End Day = business day * b.
     * Start Day = business day, End Day = non-business day * c. Start Day = non-business day, End Day = business day *
     * d. Start Day = non-business day, End Day = non-business day * * Use the following matrix to determine whether or
     * not the shift/block is * going to span a weekend, thereby guaranteeing that it will include at * least
     * non-business hours. * * Start End Relation Conclusion *
     * ------------------------------------------------------------------------ * 1 wkday wkday start == end same day OR
     * spans weekend * 2 wkday wkday start < end same week OR spans weekend * 3 wkday wkday start > end spans weekend *
     * 4 wkday wkend (sat) start < end spans weekend * 5 wkday wkend (sun) start > end spans weekend * 6 wkend (sun)
     * wkday start < end spans weekend * 7 wkend (sat) wkday start > end spans weekend * 8 wkend wkend any spans weekend
     */

    /* -------------------------------
    // --- TYPE OF SCHEDULE: SHIFT ---
    // -------------------------------
    if (typeOfSchedule.equals(CodesTables.CONCLTYP_SH)) {
      // start day == business day
      if ((startDay != DateHelper.SUNDAY) && (startDay != DateHelper.SATURDAY)) {
        // end day == business day
        // cases 1 thru 3 in the matrix above
        if ((endDay != DateHelper.SUNDAY) && (endDay != DateHelper.SATURDAY)) {
          // case 1: shift starts and ends on the same weekday
          if (startDay == endDay) {
            // The shift starts and ends on the same day of the week, but it is
            // not the same date, so it spans a weekend.
            if (!startDate.equals(endDate)) {
              spansNonBusinessHours = true;
            }
          }
          // case 2: start day < end day
          else if (startDay < endDay) {
            // If the start date and end date are more than 5 days apart, then
            // the shift spans a weekend.
            if (numOfDaysInRange > 5) {
              spansNonBusinessHours = true;
            }
          }
          // case 3: start day > end day
          // spans a weekend
          else {
            spansNonBusinessHours = true;
          }

          /*
           * * Any shifts that have non-business hours due to their spanning * weekends have been taken care of by the
           * above if statements. Now * we need to determine whether the hours themselves are business, * non-business,
           * or both. * * Since we know that both days are weekdays, the checks that are * necessary are: * 1) If either
           * start time or end time is within business hours, * set the business hours flag. * 2) If either start time
           * or end time is outside business hours, * set the non-business hours flag. * 3) If the start and end times
           * are outside business hours, set * the business hours flag if the time encompassed by the shift * contains
           * any business hours.
           */

          /* start time is no earlier than 8am and is earlier than 5pm.
          // end time is no earlier than 8am and is earlier than or exactly 5pm.
          if (((startTimeHour24 >= 8) && (startTimeHour24 < 17)) || ((endTimeHour24 > 8) && (endTimeHour24 < 17))
              || ((endTimeHour24 == 8) && (endTimeMinutes > 0)) || ((endTimeHour24 == 17) && (endTimeMinutes == 0))) {
            spansBusinessHours = true;
          }

          // start time is after 5pm or before 8am or end time is before
          // or exactly 8am or after 5pm.
          if ((startTimeHour24 >= 17) || (startTimeHour24 < 8) || (endTimeHour24 < 8) || (endTimeHour24 > 17)
              || ((endTimeHour24 == 8) && (endTimeMinutes == 0)) || ((endTimeHour24 == 17) && (endTimeMinutes > 0))) {
            spansNonBusinessHours = true;
          }

          // start time is before 8am and end time is after 5pm, or
          // start and end time are before 8am and end time is before start time
          // start and end time are after 5pm and end time is before start time
          // start time & end time are both non-business hours, but the shift
          // spans business hours
          // ex. Start Time: 06:00 AM End Time: 06:00 PM
          if (((startTimeHour24 < 8) && (endTimeHour24 > 17))
              || ((startTimeHour24 < 8) && (endTimeHour24 < 8) && (endTimeHour24 < startTimeHour24))
              || ((startTimeHour24 > 17) && (endTimeHour24 > 17) && (endTimeHour24 < startTimeHour24))) {
            spansBusinessHours = true;
          }
        }
        // start day == business day, end day == non-business day
        // cases 4 & 5 in the matrix above
        // since end day is on the weekend, it will span non-business hours
        else {
          spansNonBusinessHours = true;

          /*
           * * Now we must determine whether or not the hours to be worked on the * weekday are during business hours.
           * (The one special case that needs * to be checked is when the start day is Friday and the end day is *
           * either the Saturday or Sunday immediately following. In this * instance, the only time the business hours
           * flag should be set is if * the start time is within business hours.)
           //
          if ((startDay != DateHelper.FRIDAY) || (numOfDaysInRange > 3)) {
            // start day is either not Friday, or it is Friday but this shift
            // does not end during the immediately following weekend, so check
            // whether the shift contains any business hours.
            //
            // start time is no earlier than 8am and is earlier than 5pm. end
            // time is no earlier than 8am and is earlier than 5pm or is exactly
            // 5pm
            if (((startTimeHour24 >= 8) && (startTimeHour24 < 17)) || ((endTimeHour24 > 8) && (endTimeHour24 < 17))
                || ((endTimeHour24 == 8) && (endTimeMinutes > 0)) || ((endTimeHour24 == 17) && (endTimeMinutes == 0))) {
              spansBusinessHours = true;
            }

            // start time is before 8am and end time is after 5pm, or start and
            // end time are before 8am and end time is before start time. or
            // start and end time are after 5pm and end time is before start time.
            // start time & end time are both non-business hours, but the shift
            // spans business hours
            // ex. Start Time: 06:00 AM End Time: 06:00 PM
            if (((startTimeHour24 < 8) && (endTimeHour24 > 17))
                || ((startTimeHour24 < 8) && (endTimeHour24 < 8) && (endTimeHour24 < startTimeHour24))
                || ((startTimeHour24 > 17) && (endTimeHour24 > 17) && (endTimeHour24 < startTimeHour24))) {
              spansBusinessHours = true;
            }
          }
          // start day is Friday and the shift ends on the Saturday or Sunday
          // immediately following. check if the hours on Friday are business
          // hours
          else {
            // start time is before 5pm, end time is later than 8am
            if ((startTimeHour24 < 17) && ((endTimeHour24 > 8) || ((endTimeHour24 == 8) && (endTimeMinutes > 0)))) {
              spansBusinessHours = true;
            }
          }
        }
      } // end if ( start day == business day )
      // start day == non-business day
      // cases 6 - 8 in the matrix above
      // since start day is on the weekend, it will span non-business hours
      else {
        spansNonBusinessHours = true;

        // case 8: end day is on the weekend
        // if the start and end days are consecutive (i.e., they occur during
        // the same weekend), then there is no need to check for business hours.
        // if they are not consecutive, then two (or more) weekends are involved
        // and it is necessary to determine if the shift occurs during any
        // business hours for the weekdays
        if ((endDay == DateHelper.SUNDAY) || (endDay == DateHelper.SATURDAY)) {
          // the start and end days are not consecutive, so check for
          // business hours
          if ((numOfDaysInRange != 2) && (numOfDaysInRange > 1)) {
            // start time is no earlier than 8am and is earlier than 5pm, or
            // end time is no earlier than 8am and is earlier than 5pm or is
            // exactly 5pm
            if (((startTimeHour24 >= 8) && (startTimeHour24 < 17)) || ((endTimeHour24 > 8) && (endTimeHour24 < 17))
                || ((endTimeHour24 == 8) && (endTimeMinutes > 0)) || ((endTimeHour24 == 17) && (endTimeMinutes == 0))) {
              spansBusinessHours = true;
            }

            // start time is before 8am and end time is after 5pm, or
            // start and end time are before 8am and end time is before start
            // time, or start and end time are after 5pm and end time is before
            // start time. start time & end time are both non-business hours,
            // but the shift spans business hours.
            // ex. Start Time: 06:00 AM End Time: 06:00 PM
            if (((startTimeHour24 < 8) && (endTimeHour24 > 17))
                || ((startTimeHour24 < 8) && (endTimeHour24 < 8) && (endTimeHour24 < startTimeHour24))
                || ((startTimeHour24 > 17) && (endTimeHour24 > 17) && (endTimeHour24 < startTimeHour24))) {
              spansBusinessHours = true;
            }
          }
        }
        // start day is on weekend, end day is on weekday
        // cases 6 & 7 from the matrix above
        // check for business hours
        else {
          // start time is no earlier than 8am and is earlier than 5pm, or
          // end time is no earlier than 8am and is earlier than 5pm or is
          // exactly 5pm
          if (((startTimeHour24 >= 8) && (startTimeHour24 < 17)) || ((endTimeHour24 > 8) && (endTimeHour24 < 17))
              || ((endTimeHour24 == 8) && (endTimeMinutes > 0)) || ((endTimeHour24 == 17) && (endTimeMinutes == 0))) {
            spansBusinessHours = true;
          }

          // start time is before 8am and end time is after 5pm, or start
          // and end time are before 8am and end time is before start time, or
          // start and end time are after 5pm and end time is before start time.
          // start time & end time are both non-business hours, but the shift
          // spans business hours.
          // ex. Start Time: 06:00 AM End Time: 06:00 PM
          if (((startTimeHour24 < 8) && (endTimeHour24 > 17))
              || ((startTimeHour24 < 8) && (endTimeHour24 < 8) && (endTimeHour24 < startTimeHour24))
              || ((startTimeHour24 > 17) && (endTimeHour24 > 17) && (endTimeHour24 < startTimeHour24))) {
            spansBusinessHours = true;
          }
        } // end else (end day == weekday)
      } // end else (start day == weekend)
    } // end if (type == shift)
    // -------------------------------
    // --- TYPE OF SCHEDULE: SHIFT ---
    // -------------------------------
    /*
     * * The following possibilities exists for blocks: * 1) start day == business, end day == business * a) both are
     * the same day * b) the two days are consecutive * c) the days are non-consecutive * 2) start day == business, end
     * day == non-business * a) start day == Friday, end day == following Sat or Sun * b) the days are non-consecutive *
     * 3) start day == non-business, end day == business * a) start day == Sat or Sun, end day == following Monday * b)
     * the days are non-consecutive * 4) start day == non-business, end day == non-business * a) start day == Saturday,
     * end day == following Sunday * b) the days are non-consecutive * * The only block which will contain only business
     * hours is case 1a. * All other blocks will contain (at least) non-business hours.
     //
    else if (typeOfSchedule.equals(CodesTables.CONCLTYP_BL)) {
      // start day == business day
      if ((startDay != DateHelper.SUNDAY) && (startDay != DateHelper.SATURDAY)) {
        // end day == business day
        // case 1
        if ((endDay != DateHelper.SUNDAY) && (endDay != DateHelper.SATURDAY)) {
          // case 1(a)
          if (startDay == endDay) {
            // start day and end day are exactly the same day. this is the only
            // case where it is possible for a block to contain only business
            // hours -- and this only occurs if the block starts and ends during
            // business hours. first check for non-business hours. then check
            // for business hours.
            if (numOfDaysInRange == 1) {
              // start time is after 5pm or before 8am, or end time is before
              // 8am or after 5:00pm (an end time of 5:00pm is a valid business
              // hours time)
              if ((startTimeHour24 >= 17) || (startTimeHour24 < 8) || (endTimeHour24 <= 8)
                  || ((endTimeHour24 >= 17) && (endTimeMinutes > 0))) {
                spansNonBusinessHours = true;
              }

              // start time is no earlier than 8am and is earlier than 5pm, or
              // end time is no earlier than 8am and is earlier than 5pm or is
              // exactly 5pm
              if (((startTimeHour24 >= 8) && (startTimeHour24 < 17)) || ((endTimeHour24 > 8) && (endTimeHour24 < 17))
                  || ((endTimeHour24 == 8) && (endTimeMinutes > 0)) || ((endTimeHour24 == 17) && (endTimeMinutes == 0))) {
                spansBusinessHours = true;
              }
            }
            // same weekday, but different weeks, so set both flags
            else {
              spansBusinessHours = true;
              spansNonBusinessHours = true;
            }
          }
          // cases 1(b) & 1(c)
          // set the non-business hours flag, then check if the block crosses
          // business hours
          else {
            spansNonBusinessHours = true;

            // the days are not consecutive or the start time is before 5pm or
            // the end time is after 8am. consecutive means that numOfDaysInRange
            // is 2. Monday is consective to Friday if numOfDaysInRange is 4.
            // since we know both days are business days, if they are not
            // consecutive, then there is at least one day worth of business
            // hours in the block. if they are consecutive, then it is the start
            // and end times that indicate whether the block spans business hours.
            if (((numOfDaysInRange > 2) && (startDay != DateHelper.FRIDAY))
                || ((numOfDaysInRange > 4) && (startDay == DateHelper.FRIDAY)) || (startTimeHour24 < 17)
                || (endTimeHour24 > 8) || ((endTimeHour24 == 8) && (endTimeMinutes > 0))) {
              spansBusinessHours = true;
            }
          }
        }

        // end day == non-business day
        // case 2
        // set the non-business hours flag and check if the block spans
        // business hours
        else {
          spansNonBusinessHours = true;

          // a block could start after 5pm on a Friday and end during the
          // weekend immediately following. when this happens, there are no
          // business hours included in the block. however, if it starts on
          // any other day of the week or it starts before 5pm on that Friday
          // or it ends during some other weekend, there are business hours
          // included in the block
          //
          // start time is earlier than 5pm, or start day is earlier in the
          // week than Friday, or start day is Friday and the end day is not
          // during the weekend immediately following
          if ((startTimeHour24 < 17) || (startDay < DateHelper.FRIDAY) || (numOfDaysInRange > 3)) {
            spansBusinessHours = true;
          }
        } // end else (end day == non-business day)
      } // end if (start day == business day)
      // start day == non-business day
      else {
        // end day == business day
        // case 3
        if ((endDay != DateHelper.SUNDAY) && (endDay != DateHelper.SATURDAY)) {
          spansNonBusinessHours = true;

          // a block could start during a weekend and end before 8am the
          // Monday immediately following. when this happens, there are no
          // business hours included in the block. however, if it ends on
          // any other day of the week or it ends after 8am on that Monday
          // or it ends on some other Monday, there are business hours
          // included in the block
          //
          // end time is later than 8am, or end day is later in the week
          // than Monday, or end day is Monday and the start day is not
          // during the weekend immediately preceeding
          if ((endTimeHour24 > 8) || ((endTimeHour24 == 8) && (endTimeMinutes > 0)) || (endDay > DateHelper.MONDAY)
              || (numOfDaysInRange > 3)) {
            spansBusinessHours = true;
          }
        }
        // end day == non-business day
        // case 4
        else {
          spansNonBusinessHours = true;

          // a block could start on a Saturday and end on that Saturday or
          // the following day (Sunday), so no business hours are included
          // in the block. if there are any other days included in the block,
          // the business hours flag should be set.
          //
          // there is more than one day separating the start and end days
          if (numOfDaysInRange > 2) {
            spansBusinessHours = true;
          }
        } /* end else (end day == non-business day) //
      } /* end else (start day == non-business day) //
    } /* end else if (type == block) //

    // Set the result based on the values of the flags
    if (spansBusinessHours) {
      result = BUSINESS_HOURS;
    }

    if (spansNonBusinessHours) {
      result = NON_BUSINESS_HOURS;
    }

    if (spansBusinessHours && spansNonBusinessHours) {
      result = BOTH_BUSINESS_AND_NON_BUSINESS_HOURS;
    }
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return result;
  }
  */

  /**
   * <p/>
   * This method is used to determine whether or not an on-call shift or block contains the required minimum workers. If
   * the shift/block contains business hours, then it must have one employee designated as a Router (RC). If the
   * shift/block contains any non-business hours, then it must have one employee designated as the Primary Worker (PW),
   * another employee designated as the Supervisor (SP), and a third employee designated as any of the following:
   * Primary Worker (PW), Backup (BW), Router (RC), or Supervisor (SP). </p>
   */
  /*
  private boolean checkForMinimumWorkers(HttpServletRequest request, BaseSessionStateManager state) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".checkForMinimumWorkers()");
    performanceTrace.enterScope();

    boolean hasMinimumWorkers = true;
    int typeOfHours = determineTypeOfHours(request);

    boolean spansBusinessHours = false;
    boolean spansNonBusinessHours = false;
    if (typeOfHours == BUSINESS_HOURS) {
      spansBusinessHours = true;
    } else if (typeOfHours == NON_BUSINESS_HOURS) {
      spansNonBusinessHours = true;
    } else if (typeOfHours == BOTH_BUSINESS_AND_NON_BUSINESS_HOURS) {
      spansBusinessHours = true;
      spansNonBusinessHours = true;
    }

    CCMN10SI ccmn10si = (CCMN10SI) state.getAttribute("CCMN10SI", request);

    int numOfEmployeesDesignatedBW = 0;
    int numOfEmployeesDesignatedPW = 0;
    int numOfEmployeesDesignatedRC = 0;
    int numOfEmployeesDesignatedSP = 0;

    // If the shift/block spans any business hours, the schedule must have one
    // employee designated as Router (RC). Iterate through the employee list
    // and check their designations.
    if (spansBusinessHours == true) {
      ROWCCMN22DI employee = null;
      if (ccmn10si != null) {
        Enumeration enumeration = ccmn10si.getROWCCMN22DI_ARRAY().enumerateROWCCMN22DI();
        while (enumeration.hasMoreElements()) {
          employee = (ROWCCMN22DI) enumeration.nextElement();

          // Check the employee's designation only if the employee is not marked
          // for deletion.
          if (employee.getSzCdScrDataAction() == null
              || !employee.getSzCdScrDataAction().equals(ServiceConstants.REQ_FUNC_CD_DELETE)) {
            // Check whether or not the employee is designated as Router (RC).
            if (employee.getSzCdEmpOnCallDesig().equals(CodesTables.COCDESGN_RC)) {
              numOfEmployeesDesignatedRC = numOfEmployeesDesignatedRC + 1;
            }
          }
        }
      }
      // If there are no employees designated as Router (RC), give the user an
      // error message.
      if (numOfEmployeesDesignatedRC == 0) {
        hasMinimumWorkers = false;
        setErrorMessage(Messages.MSG_CMN_NO_RC);
      }
    }

    // Reset the Router counter.
    numOfEmployeesDesignatedRC = 0;

    // If the shift/block spans any non-business hours, the schedule must have
    // one employee designated as Primary Worker (PW), one employee designated
    // as Supervisor (SP), and a third employee designated as any of the
    // following: Primary Worker (PW), Backup (BW), Router (RC), or Supervisor
    // (SP). Iterate through the employee list and check their designations.
    if (spansNonBusinessHours == true) {
      ROWCCMN22DI employee = null;
      int numOfEmployees = 0;
      if (ccmn10si != null) {
        Enumeration enumeration = ccmn10si.getROWCCMN22DI_ARRAY().enumerateROWCCMN22DI();
        while (enumeration.hasMoreElements()) {
          employee = (ROWCCMN22DI) enumeration.nextElement();

          // Check the contact order only if the employee is not marked for deletion.
          if (employee.getSzCdScrDataAction() == null
              || !employee.getSzCdScrDataAction().equals(ServiceConstants.REQ_FUNC_CD_DELETE)) {
            numOfEmployees = numOfEmployees + 1;

            // Check the employee's designation, and set the corresponding counter.
            if (employee.getSzCdEmpOnCallDesig().equals(CodesTables.COCDESGN_BW)) {
              numOfEmployeesDesignatedBW = numOfEmployeesDesignatedBW + 1;
            } else if (employee.getSzCdEmpOnCallDesig().equals(CodesTables.COCDESGN_PW)) {
              numOfEmployeesDesignatedPW = numOfEmployeesDesignatedPW + 1;
            } else if (employee.getSzCdEmpOnCallDesig().equals(CodesTables.COCDESGN_RC)) {
              numOfEmployeesDesignatedRC = numOfEmployeesDesignatedRC + 1;
            } else if (employee.getSzCdEmpOnCallDesig().equals(CodesTables.COCDESGN_SP)) {
              numOfEmployeesDesignatedSP = numOfEmployeesDesignatedSP + 1;
            }
          }
        }
      }
      // If there are no employees designated as Primary Worker (PW), give the
      // user an error message.
      if (numOfEmployeesDesignatedPW == 0) {
        hasMinimumWorkers = false;
        setErrorMessage(Messages.MSG_CMN_NO_PRIMARY);
      }

      // If there are no employees designated as Supervisor (SP), give the
      // user an error message.
      if (numOfEmployeesDesignatedSP == 0) {
        hasMinimumWorkers = false;
        setErrorMessage(Messages.MSG_CMN_NO_SUPERVISOR);
      }

      if (numOfEmployees < 3) {
        hasMinimumWorkers = false;
        setErrorMessage(Messages.MSG_CMN_NOT_FULL);
      }
    } // end if ( spansNonBusinessHours == true )

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return hasMinimumWorkers;
  }
  */

  // static constants
  public static final int BUSINESS_HOURS = 1111;

  public static final int NON_BUSINESS_HOURS = 2222;

  public static final int BOTH_BUSINESS_AND_NON_BUSINESS_HOURS = 3333;

  public static final String DELETE_BUTTON_ON_SEARCH_PAGE = "btnDeleteOnSearchPage";

  public static final String SEARCH_BUTTON = "btnSearch";

  public static final String SAVE_BUTTON = "btnSave";

  public static final String TRACE_TAG = "OnCallCustomValidation";

  private static final String TXT_DT_ONCALL_START = "txtDtDtOnCallStart";

  private static final String TXT_TM_ONCALL_START = "txtTmOnCallStart";

  private static final String TXT_DT_ONCALL_END = "txtDtDtOnCallEnd";

  private static final String TXT_TM_ONCALL_END = "txtTmOnCallEnd";
}
