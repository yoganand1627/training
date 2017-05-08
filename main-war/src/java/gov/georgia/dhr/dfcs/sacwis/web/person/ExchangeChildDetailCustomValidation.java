//** Change History:
//**  Date       User              Description
//**  --------   ----------------  --------------------------------------------------
//**  06/06/2011 Hai Nguyen        MR-083 Updated recruitment activities date validation
//**  

package gov.georgia.dhr.dfcs.sacwis.web.person;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.LookupException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.service.adoexchange.AdoExchange;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ExcChildAdoInfoCbxStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.RecruitmentActivitiesSO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class ExchangeChildDetailCustomValidation extends FormValidation {

  protected boolean validateForm() {
    boolean isValid = true;
    boolean indSeverity = true;
    HttpServletRequest request = super.getRequest();
    Date dtReRegistered = ContextHelper.getJavaDateSafe(request, "txtDtReRegistered");
    Date dtRegistered = ContextHelper.getJavaDateSafe(request, "txtDtRegistered");
    Date dtApproved = ContextHelper.getJavaDateSafe(request, "dspDtApproved");
    if (ArchitectureConstants.Y.equals(ContextHelper.getStringSafe(request, "cbxMntlRetard"))
        && "".equals(ContextHelper.getStringSafe(request, "szCdMntRetSevLevel"))) {
      indSeverity = false;
    }
    if (ArchitectureConstants.Y.equals(ContextHelper.getStringSafe(request, "cbxVislHearImp"))
        && "".equals(ContextHelper.getStringSafe(request, "szCdVisHearSevLevel"))) {
      indSeverity = false;
    }
    if (ArchitectureConstants.Y.equals(ContextHelper.getStringSafe(request, "cbxPhyDisabled"))
        && "".equals(ContextHelper.getStringSafe(request, "szCdPhyDisSevLevel"))) {
      indSeverity = false;
    }
    if (ArchitectureConstants.Y.equals(ContextHelper.getStringSafe(request, "cbxEmtDisturbed"))
        && "".equals(ContextHelper.getStringSafe(request, "szCdEmtDistSevLevel"))) {
      indSeverity = false;
    }
    if (ArchitectureConstants.Y.equals(ContextHelper.getStringSafe(request, "cbxOthMedDiag"))
        && "".equals(ContextHelper.getStringSafe(request, "szCdOthMedDiagSevLevel"))) {
      indSeverity = false;
    }
    if (!indSeverity) {
      setErrorMessage(Messages.MSG_NO_SEVERITY);
      isValid = false;
    }
    if(dtReRegistered!=null){
    if (dtRegistered == null || (DateHelper.isBefore(dtReRegistered, dtRegistered))) {
      setErrorMessage(Messages.MSG_REREG_DT_BEFORE_REG);
      isValid = false;
    }
    }
    if(dtRegistered != null) {
     if (dtApproved == null || DateHelper.isBefore(dtRegistered, dtApproved)) {
        setErrorMessage(Messages.MSG_REG_DT_BEFORE_APPROVED);
        isValid = false;
      }
    }
    
    // MR-083 Recruitment Activities validations
    isValid = validateRecruitmentActivities(request);

    return isValid;
  }
  
  @SuppressWarnings("unchecked")
  private Map<String, Date> getNewRecActivityDates(HttpServletRequest request, String cdCbxCodeType, String actCode){
    // getting new recruitment Activities dates from request.
    Map<String, Date> newRecActivityDate = new HashMap<String, Date>();
    
    // get the date calendar field value if any
    Date newRecActDate = ContextHelper.getJavaDateSafe(request, "dtRecActState" + actCode);
    
    if(newRecActDate != null){
      newRecActivityDate.put(actCode, newRecActDate);
    }
    return newRecActivityDate;
  } // end method
  
  @SuppressWarnings("unchecked")
  private Map<String, List<ExcChildAdoInfoCbxStruct>> getModifiedRecActivityDates(HttpServletRequest request, String cdCbxCodeType, String actCode){
    // getting modified recruitment Activities dates from request.
    Map<String, List<ExcChildAdoInfoCbxStruct>> modifiedRecActivitiesDates = new HashMap<String, List<ExcChildAdoInfoCbxStruct>>();
    
    // get the each of the recruitment activities 10 date fields for any updates or additions
    List<ExcChildAdoInfoCbxStruct> dateList = new ArrayList<ExcChildAdoInfoCbxStruct>();

    // loop through each set of 10 dates that ends with actCode
    for(int i = 0; i < 10; i++){
      String attrNameId = "Date#_idInfoChar" + actCode;
      attrNameId = attrNameId.replace("#", String.valueOf(i));

      String attrName = "Date#_dtRecActState" + actCode;
      attrName = attrName.replace("#", String.valueOf(i));
      
      // retrieve each recruitment activity date from request and add to list in order
      Date dtRecAct = ContextHelper.getJavaDateSafe(request, attrName);
      int idRecAct = ContextHelper.getIntSafe(request, attrNameId);
      
      ExcChildAdoInfoCbxStruct excChildAdoInfoCbxSO = null;
      
      // if no date entered AND field was not populated initially
      // then excChildAdoInfoCbxSO should remain null
      if( !(dtRecAct == null && idRecAct == 0)){
        excChildAdoInfoCbxSO = new ExcChildAdoInfoCbxStruct();
        excChildAdoInfoCbxSO.setIdInfoChar(idRecAct);
        excChildAdoInfoCbxSO.setIdEvent(GlobalData.getUlIdEvent(request));
        excChildAdoInfoCbxSO.setCdCbxCodeType(CodesTables.CADRACS);
        excChildAdoInfoCbxSO.setCdAdoInfoCbx(actCode);
        excChildAdoInfoCbxSO.setDtPerformed(dtRecAct);
      }
      dateList.add(excChildAdoInfoCbxSO);
    } // end for loop
    modifiedRecActivitiesDates.put(actCode, dateList);

    return modifiedRecActivitiesDates;
  }
  
  @SuppressWarnings("unchecked")
  private Map<String, List<ExcChildAdoInfoCbxStruct>> getSavedRecActivities(int idEvent, String cdCbxCodeType){
    Map<String, List<ExcChildAdoInfoCbxStruct>> savedRecActivitiesDates = new HashMap<String, List<ExcChildAdoInfoCbxStruct>>();
    
    if(idEvent > 0 ){
      AdoExchange adoExchange = this.getEjb(AdoExchange.class);
      
      RecruitmentActivitiesSO recruitmentActivitiesSO = adoExchange.retrieveRecruitmentActivities(idEvent , cdCbxCodeType);
      
      if (recruitmentActivitiesSO != null 
                      && recruitmentActivitiesSO.getRecruitmentActivityDates() != null 
                      && recruitmentActivitiesSO.getRecruitmentActivityDates().size() > 0) {
        Iterator it = recruitmentActivitiesSO.getRecruitmentActivityDates().iterator();
        while (it.hasNext()) {
          ExcChildAdoInfoCbxStruct excChildAdoInfoCbxSO = (ExcChildAdoInfoCbxStruct) it.next();
          // if code key does not exist in map yet then add otherwise retrieve existing
          // date list and add additional date.
          if( !savedRecActivitiesDates.containsKey(excChildAdoInfoCbxSO.getCdAdoInfoCbx())){
            List<ExcChildAdoInfoCbxStruct> excChildAdoInfoCbxSOList = new ArrayList<ExcChildAdoInfoCbxStruct>();
            excChildAdoInfoCbxSOList.add(excChildAdoInfoCbxSO);
            savedRecActivitiesDates.put(excChildAdoInfoCbxSO.getCdAdoInfoCbx(), excChildAdoInfoCbxSOList);
          }else{
            List<ExcChildAdoInfoCbxStruct> excChildAdoInfoCbxSOList = savedRecActivitiesDates.get(excChildAdoInfoCbxSO.getCdAdoInfoCbx());
            excChildAdoInfoCbxSOList.add(excChildAdoInfoCbxSO);
          }
        }
      }
    }
    return savedRecActivitiesDates;
  }
  
  private boolean validateRecruitmentActivities(HttpServletRequest request){
    boolean isValid = true;
    Date dtChildDob = ContextHelper.getJavaDateSafe(request, "dspDtBirth");

    Collection<String> actList = new ArrayList<String>();
    // getting the recruitment Activities dates from request.
    Map<String, List<ExcChildAdoInfoCbxStruct>> modifiedRecActivitiesDates = new HashMap<String, List<ExcChildAdoInfoCbxStruct>>();
    Map<String, Date> newRecActivityDate =  new HashMap<String, Date>();
    Map<String, List<ExcChildAdoInfoCbxStruct>> savedRecActivitiesDates =  new HashMap<String, List<ExcChildAdoInfoCbxStruct>>();

    try{
      // get all possible recruitment activity codes
      actList = Lookup.getCategoryCodesCollection(CodesTables.CADRACS);
      savedRecActivitiesDates = getSavedRecActivities(GlobalData.getUlIdEvent(request), CodesTables.CADRACS);
      if(actList != null && !actList.isEmpty()){
        Iterator<String> itAct = actList.iterator();
        
        // loop through each activity code
        while(itAct.hasNext()){
          String actCode = itAct.next();
          boolean isBeforeDob = false;
          boolean isFutureDt = false;
          boolean isDuplicate = false;
          
          // getting the recruitment Activities dates from request.
          modifiedRecActivitiesDates = getModifiedRecActivityDates(request, CodesTables.CADRACS, actCode);
          newRecActivityDate = getNewRecActivityDates(request, CodesTables.CADRACS, actCode);
          
          List<ExcChildAdoInfoCbxStruct> savedList = savedRecActivitiesDates.get(actCode);
          List<ExcChildAdoInfoCbxStruct> modList = modifiedRecActivitiesDates.get(actCode);

          Iterator<ExcChildAdoInfoCbxStruct> itMod = modList.iterator();

          Date newDate = newRecActivityDate.get(actCode);

          // loop through mod list
          while(itMod.hasNext()){
            ExcChildAdoInfoCbxStruct modAdoInfoSO = itMod.next();
            
            Date modDate = (modAdoInfoSO != null ? modAdoInfoSO.getDtPerformed() : null);

            // check new and mod date for future date
            if((modDate != null && DateHelper.isAfterToday(modDate)) 
                            || (newDate != null && DateHelper.isAfterToday(newDate))){
              isFutureDt = true;
            }
            // check new and mod date if it is before child DOB
            if(dtChildDob == null 
                            || (modDate != null && DateHelper.isBefore(modDate, dtChildDob)) 
                            || (newDate != null && DateHelper.isBefore(newDate, dtChildDob))){
              isBeforeDob = true;
            }

            if( savedList != null ){
              Iterator<ExcChildAdoInfoCbxStruct> itSaved = savedList.iterator();

              while(itSaved.hasNext()){
                ExcChildAdoInfoCbxStruct savedAdoInfoSO = itSaved.next();
                
                Date savedDate = savedAdoInfoSO.getDtPerformed();
                
                // check mod for duplicate in saved list if both are not the same record.
                if((modAdoInfoSO != null 
                                && modAdoInfoSO.getIdInfoChar() != savedAdoInfoSO.getIdInfoChar()
                                && modAdoInfoSO.getIdInfoChar() > 0 
                                && savedAdoInfoSO.getIdInfoChar() > 0
                                && modDate != null
                                && savedDate != null
                                && DateHelper.isEqual(modDate, savedDate))){
                  // if modified two existing date with same date value
                  isDuplicate = true;
                  break;
                }else if((modAdoInfoSO != null 
                                && modAdoInfoSO.getIdInfoChar() == savedAdoInfoSO.getIdInfoChar() 
                                && modAdoInfoSO.getIdInfoChar() > 0 
                                && savedAdoInfoSO.getIdInfoChar() > 0
                                && savedDate != null
                                && !DateHelper.isEqual(modDate, savedDate))){
                  // if modified an existing date then update the saved date list for next round of validation.
                  savedAdoInfoSO.setDtPerformed(modDate);

                  // only after the savedList update, we check if new date would create a duplicate
                  // after modified date is updated
                  if(newDate != null && DateHelper.isEqual(newDate, savedDate)){
                    isDuplicate = true;
                    break;
                  }
                }else if((modAdoInfoSO != null 
                                && modAdoInfoSO.getIdInfoChar() == savedAdoInfoSO.getIdInfoChar() 
                                && modAdoInfoSO.getIdInfoChar() == 0
                                && savedAdoInfoSO.getIdInfoChar() == 0
                                && DateHelper.isEqual(modDate, savedDate))){
                  // if adding two new duplicate date
                  isDuplicate = true;
                  break;
                }else{
                  // otherwise check new date against existing saved date
                  if((newDate != null && DateHelper.isEqual(newDate, savedDate))
                                  || (modDate != null 
                                                  && modAdoInfoSO.getIdInfoChar() == 0 
                                                  && DateHelper.isEqual(modDate, savedDate))){
                    isDuplicate = true;
                    break;
                  }
                }
              }
              
              if (!isDuplicate
                              && modAdoInfoSO != null
                              && modAdoInfoSO.getIdInfoChar() == 0){
                // reached end of saved list but no duplicate found so updated saved list
                // to include new date for next round of validation
                savedList.add(modAdoInfoSO);

                // only after the savedList update, we check if new date would create a duplicate
                if(newDate != null && DateHelper.isEqual(newDate, modDate)){
                  isDuplicate = true;
                  break;
                }
              }

            }else{
              if( modAdoInfoSO != null){
                // there is no existing recruitment activities dates
                savedList = new ArrayList<ExcChildAdoInfoCbxStruct>();
                savedList.add(modAdoInfoSO);
                
                // only after the savedList update, we check if new dates would create a duplicate
                if(newDate != null 
                                && modDate != null 
                                && DateHelper.isEqual(newDate, modDate)){
                  isDuplicate = true;
                  // no break here since we still want to check for future date and before DOB check
                }
              }
            }
          }
          
          //Check indicators to send only one message per type per activity
          if(isBeforeDob){
            setErrorMessage("dtRecActState" + actCode, Messages.MSG_CMN_BEFORE_DOB);
            isValid = false;
          }
          if(isFutureDt){
            setErrorMessage("dtRecActState" + actCode, Messages.SSM_DATE_BEFORE_SAME_CURR);
            isValid = false;
          }
          if(isDuplicate){
            setErrorMessage("dtRecActState" + actCode, Messages.MSG_CMN_DUPLICATE_DATE);
            isValid = false;
          }
        }
      }
    } catch (LookupException le){
      // this should never happen, but just in case we want to do a hard stop
      setErrorMessage(Messages.MSG_CODE_NOT_FOUND);
      isValid = false;
    }

    return isValid;
  }
}