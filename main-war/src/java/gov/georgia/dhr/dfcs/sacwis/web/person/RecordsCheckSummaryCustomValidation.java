package gov.georgia.dhr.dfcs.sacwis.web.person;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.LookupException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.codestables.Cchktype;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

/*Change History:
 *  Date        User      Description
 *  ----------  --------  --------------------------------------------------
 *  06/23/2011  schoi     SMS #112294 Updated the condition to validate an invalid date format so that it includes
 *                        'mm/dd/yy' as one of the invalid date format; only 'mm/dd/yyyy' is the valid format
 */

@SuppressWarnings("serial")
public class RecordsCheckSummaryCustomValidation extends FormValidation  {
  //static constants
  public static final String TRACE_TAG = "RecordsCheckSummaryCustomValidation";

  
  /**
   * This method validates the Records Check Summary page
   */
  protected boolean validateForm(){
    // add trace info
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".validationForm()");
    performanceTrace.enterScope();
    
    // get the current request
    HttpServletRequest request = this.getRequest();
    
    // get the string parameter to determine if we are adding or saving and from which page
    String addType = request.getParameter("hdnType");

    // create boolean for validation
    Boolean result = true;
    
    // determine which page we are coming from so validations can be run
    if(RecordsCheckSummaryConversation.ADD_BY_PERSON.equals(addType) || RecordsCheckSummaryConversation.ADD_BY_REQ_TYPE.equals(addType)){
      result = validateAdd(request);
    }else{
      result = validateSummary(request);
    }
    
    // log time and exit method scope
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    
    return result;
  }
  
  
  /**
   * This method performs validations for the add by person and add by type views
   * @param request - the current request
   * @return - returns whether the page is valid or not
   */
  private boolean validateAdd(HttpServletRequest request){
    // create boolean to return value
    boolean ret = true;
    // create object to format dates
    SimpleDateFormat dateFormatter = DateHelper.SLASH_FORMAT;
    
    // get the number of rows from the request
    int rowCount = StringHelper.toInteger(request.getParameter("hdnRowCount"));
    
    // loop thru rows to add them to Records Check list
    for(int i = 1; i <= rowCount; i++){
      // get the page parameters
      String reqDateStr = StringHelper.getSafeString(request.getParameter(RecordsCheckSummaryConversation.DT_REC_CHECK_REQ + i));
      String compDateStr = StringHelper.getSafeString(request.getParameter(RecordsCheckSummaryConversation.DT_REC_CHECK_COMP + i));
      Date reqDate = null;
      Date compDate = null;
      String history = StringHelper.getNonNullString(request.getParameter(RecordsCheckSummaryConversation.HISTORY + i)); 
      String comments = StringHelper.getNonNullString(request.getParameter(RecordsCheckSummaryConversation.COMMENTS + i)).trim();
      
      // get metadata
      String metaData = StringHelper.getSafeString(request.getParameter(RecordsCheckSummaryConversation.META_DATA + i));
      
      // break out of loop if there are no more rows
      if(metaData == null){
        continue;
      }
      
      // create variables to hold meta data information
      String type = "";
      int idPerson = 0;
      int idRequestor = 0;
      int idRecCheck = 0;
      String name = "";
      String beginMessage = "";
      String paramMessage = "";
      
      // delimit the meta data
      String[] nvp = metaData.split("&");
      
      // loop thru name-value pairs (nvp) to delimit nvp's and retrieve data
      for(String str : nvp){
        // delimit the nvp
        String[] delimtedPair = str.split("=");
        
        // add data to variables
        if("person".equals(delimtedPair[0])){
          // get the person id
          idPerson = StringHelper.toInteger(delimtedPair[1]);
        }else if("requestor".equals(delimtedPair[0])){
          // get the person id of the requestor
          idRequestor = StringHelper.toInteger(delimtedPair[1]);
        }else if("idRecCheck".equals(delimtedPair[0])){
          // get the primary key of the Records Check
          idRecCheck = StringHelper.toInteger(delimtedPair[1]);
        }else if("personName".equals(delimtedPair[0])){
          name = StringHelper.getSafeString(delimtedPair[1]);
        }else{
          // get the type of the Records Check
          type = StringHelper.getSafeString(delimtedPair[0]);
        }
      }
      
      
      // validate that dates are in the correct format
      try{
        // create beginning of message string
        beginMessage = "For " + name + "'s " + Lookup.simpleDecode(Cchktype.CCHKTYPE, type) + ", ";
        paramMessage = " " + name + "'s " + Lookup.simpleDecode(Cchktype.CCHKTYPE, type);
        
        // SMS #112294
        // Check both reqDateStr and compDateStr are in the correct Sting format as "mm/dd/yyyy"
        // This check takes care of any invalid alphanumeric format including "mm/dd/yy" 
        if (DateHelper.isValidDate(reqDateStr)) {
          reqDate = DateHelper.toJavaDateSafe(reqDateStr);
        }
        if (DateHelper.isValidDate(compDateStr)) {
          compDate = DateHelper.toJavaDateSafe(compDateStr);
        }
        // End SMS #112294

      }catch(LookupException l){
        ret = false;
      }
      
      // SMS #112294
      // Validate any invalid date format entered
      if ((!DateHelper.isValidDate(reqDateStr) && (reqDateStr != null)) || (!DateHelper.isValidDate(compDateStr) && (compDateStr != null))) {
        String error = MessageLookup.addMessageParameter(MessageLookup.getMessageByNumber(Messages.MSG_REC_CONSTR_DATE), paramMessage);
        setErrorMessage(error);
        ret = false;
      }
      // make sure date of request has been filled in
      // SMS #112294
      // Do not validate the following conditions inside else block if an invalid format is entered
      else {
        if (reqDate == null && (compDate != null || StringHelper.isValid(history) || StringHelper.isValid(comments))) {
          setErrorMessage(MessageLookup.getMessageByNumber(Messages.MSG_MUST_COMPLETE_TO_SAVE_REQ));
          ret = false;
        }

        // validate that date completed is not equal to or after date requested
        if (compDate != null && reqDate != null
            && (!DateHelper.isEqual(reqDate, compDate) && !DateHelper.isAfter(compDate, reqDate))) {
          setErrorMessage(beginMessage + MessageLookup.getMessageByNumber(Messages.SSM_CFC_COMPLETED_DATE));
          ret = false;
        }

        // validate that date completed and date requested are not future dates
        if ((reqDate != null && DateHelper.isAfterToday(reqDate))
            || (compDate != null && DateHelper.isAfterToday(compDate))) {
          setErrorMessage(beginMessage + MessageLookup.getMessageByNumber(Messages.SSM_DATE_BEFORE_SAME_CURR));
          ret = false;
        }
      }
      
      // validate that comments field is not empty when history checkbox has been checked
      if(ArchitectureConstants.Y.equals(history) && "".equals(comments)){
        setErrorMessage(beginMessage + "Since History checkbox is checked, a Comment Entry is required ");
         ret = false;
      }
    }
    
    
    return ret;
  }

  
  /**
   * This method performs validations for the summary view
   * @param request - the current request
   * @return - returns whether the page is valid or not
   */
  private boolean validateSummary(HttpServletRequest request){
    
    // get the parameters
    String addType = StringHelper.getSafeString(request.getParameter("add_type"));
    String selPerson = StringHelper.getSafeString(request.getParameter(RecordsCheckSummaryConversation.SELECTED_PERSON));
    
    // validate that a person has been chosen if type is add by person
    if(RecordsCheckSummaryConversation.ADD_BY_PERSON.equals(addType) && selPerson == null){
      setErrorMessage(Messages.MSG_REC_PERSON_REQ_ADD);
      return false;
    }
    
    return true;
  }
}
