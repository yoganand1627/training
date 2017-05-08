//*  Validation Class  Name:     AdoptionInformationCustomValidation
//*  Created by:   Jacob Vaidyan
//*  Date Created: 02/18/2007
//*
//*  Description:Custom Validation Class for Adoption Information.
//*  Validation rules applied to date fields in Adoption Information section to prevent the entry of future dates
//*  if enetered.
//** Change History:
//**  Date       User              Description
//**  --------   ----------------  --------------------------------------------------
//**  10/7/2008	 Ronnie Phelps	   Changes for Adoptions Enhancements.
//**  06/06/2011 Hai Nguyen        MR-083 Updated recruitment activities date validation
//**  09/23/2011 Hai Nguyen        STGAP00017011: MR-092 Updated and added new validation for
//**                               sibling with open ADO in a different case section. Now requires
//**                               primary child to be in a group if a sibling is selected in either
//**                               lists of siblings.
//**  10/05/2011 Hai Nguyen        STGAP00017011: MR-092 Added missing validation.
//**  10/13/2011 Hai Nguyen        STGAP00017216: MR-092 Added missing validation for duplicate sibling.
//**  

package gov.georgia.dhr.dfcs.sacwis.web.subcare;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.LookupException;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.service.adoexchange.AdoExchange;
import gov.georgia.dhr.dfcs.sacwis.service.person.Person;
import gov.georgia.dhr.dfcs.sacwis.structs.input.StagePersonLinkRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.AdoptionInformationRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.AdoInfoCbxSentStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.RecruitmentActivitiesSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SiblingGroupInformationSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.StagePersonLinkDetail_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.StagePersonLinkSO;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

import javax.servlet.http.HttpServletRequest;

import org.grnds.structural.web.GrndsExchangeContext;

public class AdoptionInformationCustomValidation extends FormValidation {
  public static final String TRACE_TAG = "AdoptionInformationCustomValidation";

  protected boolean validateForm() {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".validationForm()");
    performanceTrace.enterScope();
    HttpServletRequest request = super.getRequest();
    BaseSessionStateManager state = super.getState();

    boolean isValid = true;

    org.exolab.castor.types.Date dtFostParNotAgTPR = ContextHelper.getCastorDateSafe(request, "dtFostParNotAgTPR");
    org.exolab.castor.types.Date dtPermStaffFostPar = ContextHelper.getCastorDateSafe(request, "dtPermStaffFostPar");
    org.exolab.castor.types.Date dtFostParNotAgDecAdpt = ContextHelper.getCastorDateSafe(request,
                                                                                         "dtFostParNotAgDecAdpt");
    org.exolab.castor.types.Date dtChildLifeHistPres = ContextHelper.getCastorDateSafe(request, "dtChildLifeHistPres");
    org.exolab.castor.types.Date dtStaffAdptFam = ContextHelper.getCastorDateSafe(request, "dtStaffAdptFam");
    org.exolab.castor.types.Date dtAdptPlacAgmtSigned = ContextHelper.getCastorDateSafe(request, "dtAdptPlacAgmtSigned");
    org.exolab.castor.types.Date dtDocSentAttor = ContextHelper.getCastorDateSafe(request, "dtDocSentAttor");
    org.exolab.castor.types.Date dtPermFileLetterComp = ContextHelper.getCastorDateSafe(request, "dtPermFileLetterComp");

    org.exolab.castor.types.Date dtDisruption = ContextHelper.getCastorDateSafe(request, "dtDisruption");

    org.exolab.castor.types.Date dtSelectionLetterSent = ContextHelper.getCastorDateSafe(request,
                                                                                         "dtSelectionLetterSent");

    String indHasSiblingExtCase = ContextHelper.getStringSafe(request, "rbHasSiblingExtCase");
    String indSiblingGrpExtCase = ContextHelper.getStringSafe(request, "rbSiblingGrpExtCase");

    String indAdoptOutcome = ContextHelper.getStringSafe(request, "indAdoptOutcome");

    AdoptionInformationRetrieveSO adoptioninformationret = (AdoptionInformationRetrieveSO) state.getAttribute("AdoptionInformationRetrieveSO",
                                                                                                              request);
    SiblingGroupInformationSO siblingGroupInformationSO = (SiblingGroupInformationSO) adoptioninformationret.getSiblingGroupInformation();

    if (dtFostParNotAgTPR != null && DateHelper.isAfterToday(dtFostParNotAgTPR)) {
      setErrorMessage("dtFostParNotAgTPR", Messages.SSM_DATE_BEFORE_SAME_CURR);
      isValid = false;
    }

    if (dtPermStaffFostPar != null && DateHelper.isAfterToday(dtPermStaffFostPar)) {
      setErrorMessage("dtPermStaffFostPar", Messages.SSM_DATE_BEFORE_SAME_CURR);
      isValid = false;
    }

    if (dtFostParNotAgDecAdpt != null && DateHelper.isAfterToday(dtFostParNotAgDecAdpt)) {
      setErrorMessage("dtFostParNotAgDecAdpt", Messages.SSM_DATE_BEFORE_SAME_CURR);
      isValid = false;
    }

    if (dtChildLifeHistPres != null && DateHelper.isAfterToday(dtChildLifeHistPres)) {
      setErrorMessage("dtChildLifeHistPres", Messages.SSM_DATE_BEFORE_SAME_CURR);
      isValid = false;
    }

    if (dtStaffAdptFam != null && DateHelper.isAfterToday(dtStaffAdptFam)) {
      setErrorMessage("dtStaffAdptFam", Messages.SSM_DATE_BEFORE_SAME_CURR);
      isValid = false;
    }

    if (dtAdptPlacAgmtSigned != null && DateHelper.isAfterToday(dtAdptPlacAgmtSigned)) {
      setErrorMessage("dtAdptPlacAgmtSigned", Messages.SSM_DATE_BEFORE_SAME_CURR);
      isValid = false;
    }

    if (dtDocSentAttor != null && DateHelper.isAfterToday(dtDocSentAttor)) {
      setErrorMessage("dtDocSentAttor", Messages.SSM_DATE_BEFORE_SAME_CURR);
      isValid = false;
    }
    if (dtPermFileLetterComp != null && DateHelper.isAfterToday(dtPermFileLetterComp)) {
      setErrorMessage("dtPermFileLetterComp", Messages.SSM_DATE_BEFORE_SAME_CURR);
      isValid = false;
    }

    if (dtDisruption != null && DateHelper.isAfterToday(dtDisruption)) {
      setErrorMessage("dtDisruption", Messages.SSM_DATE_BEFORE_SAME_CURR);
      isValid = false;
    }

    if (dtSelectionLetterSent != null && DateHelper.isAfterToday(dtSelectionLetterSent)) {
      setErrorMessage("dtSelectionLetterSent", Messages.SSM_DATE_BEFORE_SAME_CURR);
      isValid = false;
    }

    // a date has been entered for foster parent notified agency of decision to adopt and no
    // outcome was chosen
    if (dtFostParNotAgDecAdpt != null && (indAdoptOutcome == null || indAdoptOutcome.trim().length() == 0)) {
      setErrorMessage("indAdoptOutcome", Messages.MSG_IND_ADOPT_NO_OUTCOME);
      isValid = false;
    }

    if (siblingGroupInformationSO != null && siblingGroupInformationSO.getAllSiblingsRetrievedSOList() != null
        && siblingGroupInformationSO.getAllSiblingsRetrievedSOList().size() > 0) {
      /* get checked siblinggroup_sibling fields */
      String[] checked_existing_SiblingGroups_Siblings = CheckboxHelper.getCheckedValues(request, "cbx_sibling_");

      /* get checked new siblingroup_sibling fields */
      String[] checked_new_SiblingGroups_Siblings = CheckboxHelper.getCheckedValues(request, "cbx_New_PG_");

      Set<Integer> siblingsSelectedSet = new HashSet<Integer>();
      /* check children in existing groups for duplicates */
      for (int i = 0; i < checked_existing_SiblingGroups_Siblings.length; ++i) {
        StringTokenizer st = new StringTokenizer(checked_existing_SiblingGroups_Siblings[i], "_");

        // idSiblinggroup not used
        st.nextToken();
        Integer idPersonInteger = new Integer(st.nextToken());
        String childName = ContextHelper.getStringSafe(request, "sibName_" + idPersonInteger.intValue());

        if (siblingsSelectedSet.add(idPersonInteger) == false) {
          // duplicate exists
          isValid = false;
          String message = "";
          message = MessageLookup.getMessageByNumber(Messages.MSG_MULTIPLE_PLCMT_GRPS);
          message = MessageLookup.addMessageParameter(message, childName);
          setErrorMessage(message);
        }
      }

      /* build input groupings for new Siblings */
      for (int i = 0; i < checked_new_SiblingGroups_Siblings.length; ++i) {
        StringTokenizer st = new StringTokenizer(checked_new_SiblingGroups_Siblings[i], "_");

        // idSiblinggroup not used
        st.nextToken();
        Integer idPersonInteger = new Integer(st.nextToken());

        String childName = ContextHelper.getStringSafe(request, "sibName_" + idPersonInteger.intValue());

        if (siblingsSelectedSet.add(idPersonInteger) == false) {
          // duplicate exists
          isValid = false;
          String message = "";
          message = MessageLookup.getMessageByNumber(Messages.MSG_MULTIPLE_PLCMT_GRPS);
          message = MessageLookup.addMessageParameter(message, childName);
          setErrorMessage(message);
        }
      }

      boolean siblingExtLnkExists = false;

      if (siblingGroupInformationSO != null) {
        Map<Integer, Integer> prnChildrenUnder18WithAnotherAdoCase = adoptioninformationret.getPrnChildrenUnder18WithAnotherAdoCase();
        Set<Integer> prnKeySet = prnChildrenUnder18WithAnotherAdoCase.keySet();
        Iterator<Integer> prnIter = prnKeySet.iterator();
        boolean dupFound = false;

        while (prnIter.hasNext()) {
          Integer idPersonFromMap = prnIter.next();
          List<Integer> dupChkList = new ArrayList<Integer>();

          for (int i = 0; i < prnChildrenUnder18WithAnotherAdoCase.size(); i++) {
            int idPersonFromRequest = ContextHelper.getIntSafe(request, "selSiblingsExtCase_" + i);

            if (idPersonFromRequest > 0 && idPersonFromMap == idPersonFromRequest) {
              siblingExtLnkExists = true;
            }

            if (idPersonFromRequest > 0 && !dupFound) {
              if (dupChkList.contains(idPersonFromRequest)) {
                dupFound = true;

                setErrorMessage(Messages.MSG_SIBLING_DUPLICATED);
                isValid = false;
              } else {
                dupChkList.add(idPersonFromRequest);
              }
            }
          }
        }
      }

      if (checked_existing_SiblingGroups_Siblings.length == 0 && checked_new_SiblingGroups_Siblings.length == 0
          && siblingExtLnkExists) {

        setErrorMessage(Messages.MSG_UPDT_SIBLING_GRPS);
        isValid = false;
      }

      if (StringHelper.isEmptyOrNull(indHasSiblingExtCase)) {
        setErrorMessage(Messages.MSG_SIBLING_WITH_ADO_IN_ANOTHER_CASE_REQ);
        isValid = false;
      } else if ("Y".equals(indHasSiblingExtCase) && StringHelper.isEmptyOrNull(indSiblingGrpExtCase)) {
        setErrorMessage(Messages.MSG_IND_SIBLING_PLACED_TOGETHER_REQ);
        isValid = false;
      } else if ("Y".equals(indHasSiblingExtCase) && "Y".equals(indSiblingGrpExtCase) && !siblingExtLnkExists) {
        setErrorMessage(Messages.MSG_SIBLING_REQ);
        isValid = false;
      }

    }

    // MR-083 Recruitment Activities validations
    isValid = (isValid && validateRecruitmentActivities(request));

    return isValid;
  }

  @SuppressWarnings("unchecked")
  private Map<String, Date> getNewRecActivityDates(HttpServletRequest request, String cdCbxCodeType, String actCode) {
    // getting new recruitment Activities dates from request.
    Map<String, Date> newRecActivityDate = new HashMap<String, Date>();

    // get the date calendar field value if any
    Date newRecActDate = ContextHelper.getJavaDateSafe(request, "dtRecActCounty" + actCode);

    if (newRecActDate != null) {
      newRecActivityDate.put(actCode, newRecActDate);
    }
    return newRecActivityDate;
  } // end method

  @SuppressWarnings("unchecked")
  private Map<String, List<AdoInfoCbxSentStruct>> getModifiedRecActivityDates(HttpServletRequest request,
                                                                              String cdCbxCodeType, String actCode) {
    // getting modified recruitment Activities dates from request.
    Map<String, List<AdoInfoCbxSentStruct>> modifiedRecActivitiesDates = new HashMap<String, List<AdoInfoCbxSentStruct>>();

    // get the each of the recruitment activities 10 date fields for any updates or additions
    List<AdoInfoCbxSentStruct> dateList = new ArrayList<AdoInfoCbxSentStruct>();

    // loop through each set of 10 dates that ends with actCode
    for (int i = 0; i < 10; i++) {
      String attrNameId = "Date#_idAdoInfoCbxSent" + actCode;
      attrNameId = attrNameId.replace("#", String.valueOf(i));

      String attrName = "Date#_dtRecActCounty" + actCode;
      attrName = attrName.replace("#", String.valueOf(i));

      // retrieve each recruitment activity date from request and add to list in order
      Date dtRecAct = ContextHelper.getJavaDateSafe(request, attrName);
      int idRecAct = ContextHelper.getIntSafe(request, attrNameId);

      AdoInfoCbxSentStruct adoInfoCbxSentSO = null;

      // if no date entered AND field was not populated initially
      // then AdoInfoCbxSentSO should remain null
      if (!(dtRecAct == null && idRecAct == 0)) {
        adoInfoCbxSentSO = new AdoInfoCbxSentStruct();
        adoInfoCbxSentSO.setIdAdoInfoCbxSent(idRecAct);
        adoInfoCbxSentSO.setIdInfoChar(0); // this will be fetch later in save service
        adoInfoCbxSentSO.setIdEvent(GlobalData.getUlIdEvent(request));
        adoInfoCbxSentSO.setCdCbxCodeType(CodesTables.CADRACC);
        adoInfoCbxSentSO.setCdAdoInfoCbx(actCode);
        adoInfoCbxSentSO.setDtAdoInfoCbxSent(dtRecAct);
      }
      dateList.add(adoInfoCbxSentSO);
    } // end for loop
    modifiedRecActivitiesDates.put(actCode, dateList);

    return modifiedRecActivitiesDates;
  }

  @SuppressWarnings("unchecked")
  private Map<String, List<AdoInfoCbxSentStruct>> getSavedRecActivities(int idEvent, String cdCbxCodeType) {
    Map<String, List<AdoInfoCbxSentStruct>> savedRecActivitiesDates = new HashMap<String, List<AdoInfoCbxSentStruct>>();

    if (idEvent > 0) {
      AdoExchange adoExchange = this.getEjb(AdoExchange.class);

      RecruitmentActivitiesSO recruitmentActivitiesSO = adoExchange.retrieveRecruitmentActivities(idEvent,
                                                                                                  cdCbxCodeType);

      if (recruitmentActivitiesSO != null && recruitmentActivitiesSO.getRecruitmentActivityDates() != null
          && recruitmentActivitiesSO.getRecruitmentActivityDates().size() > 0) {
        Iterator it = recruitmentActivitiesSO.getRecruitmentActivityDates().iterator();
        while (it.hasNext()) {
          AdoInfoCbxSentStruct adoInfoCbxSentSO = (AdoInfoCbxSentStruct) it.next();
          // if code key does not exist in map yet then add otherwise retrieve existing
          // date list and add additional date.
          if (!savedRecActivitiesDates.containsKey(adoInfoCbxSentSO.getCdAdoInfoCbx())) {
            List<AdoInfoCbxSentStruct> AdoInfoCbxSentSOList = new ArrayList<AdoInfoCbxSentStruct>();
            AdoInfoCbxSentSOList.add(adoInfoCbxSentSO);
            savedRecActivitiesDates.put(adoInfoCbxSentSO.getCdAdoInfoCbx(), AdoInfoCbxSentSOList);
          } else {
            List<AdoInfoCbxSentStruct> adoInfoCbxSentSOList = savedRecActivitiesDates.get(adoInfoCbxSentSO.getCdAdoInfoCbx());
            adoInfoCbxSentSOList.add(adoInfoCbxSentSO);
          }
        }
      }
    }
    return savedRecActivitiesDates;
  }

  private boolean validateRecruitmentActivities(HttpServletRequest request) {
    boolean isValid = true;

    Collection<String> actList = new ArrayList<String>();
    // getting the recruitment Activities dates from request.
    Map<String, List<AdoInfoCbxSentStruct>> modifiedRecActivitiesDates = new HashMap<String, List<AdoInfoCbxSentStruct>>();
    Map<String, Date> newRecActivityDate = new HashMap<String, Date>();
    Map<String, List<AdoInfoCbxSentStruct>> savedRecActivitiesDates = new HashMap<String, List<AdoInfoCbxSentStruct>>();

    // get primary child DOB
    Person personEjb = getEjb(Person.class);
    StagePersonLinkRetrieveSI si = new StagePersonLinkRetrieveSI();
    si.setUlIdStage(GlobalData.getUlIdStage(request));
    si.setSzCdStagePersRole(CodesTables.CROLEALL_PC);

    StagePersonLinkSO so = personEjb.retrieveStagePersonLink(si);
    StagePersonLinkDetail_ARRAY splList = so.getStagePersonLinkDetail_ARRAY();

    Date dtChildDob = null;

    if (splList.getStagePersonLinkDetailCount() > 0) {
      // there should only be one PC, so pull first item on list
      dtChildDob = DateHelper.toJavaDate(splList.getStagePersonLinkDetail(0).getDtDtPersonBirth());
    }

    try {
      // get all possible recruitment activity codes
      actList = Lookup.getCategoryCodesCollection(CodesTables.CADRACC);
      savedRecActivitiesDates = getSavedRecActivities(GlobalData.getUlIdEvent(request), CodesTables.CADRACC);
      if (actList != null && !actList.isEmpty()) {
        Iterator<String> itAct = actList.iterator();

        // loop through each activity code
        while (itAct.hasNext()) {
          String actCode = itAct.next();
          boolean isBeforeDob = false;
          boolean isFutureDt = false;
          boolean isDuplicate = false;

          // getting the recruitment Activities dates from request.
          modifiedRecActivitiesDates = getModifiedRecActivityDates(request, CodesTables.CADRACC, actCode);
          newRecActivityDate = getNewRecActivityDates(request, CodesTables.CADRACC, actCode);

          List<AdoInfoCbxSentStruct> savedList = savedRecActivitiesDates.get(actCode);
          List<AdoInfoCbxSentStruct> modList = modifiedRecActivitiesDates.get(actCode);

          Iterator<AdoInfoCbxSentStruct> itMod = modList.iterator();

          Date newDate = newRecActivityDate.get(actCode);

          // loop through mod list
          while (itMod.hasNext()) {
            AdoInfoCbxSentStruct modAdoInfoSO = itMod.next();

            Date modDate = (modAdoInfoSO != null ? modAdoInfoSO.getDtAdoInfoCbxSent() : null);

            // check new and mod date for future date
            if ((modDate != null && DateHelper.isAfterToday(modDate))
                || (newDate != null && DateHelper.isAfterToday(newDate))) {
              isFutureDt = true;
            }
            // check new and mod date if it is before child DOB
            if (dtChildDob == null || (modDate != null && DateHelper.isBefore(modDate, dtChildDob))
                || (newDate != null && DateHelper.isBefore(newDate, dtChildDob))) {
              isBeforeDob = true;
            }

            if (savedList != null) {
              Iterator<AdoInfoCbxSentStruct> itSaved = savedList.iterator();

              while (itSaved.hasNext()) {
                AdoInfoCbxSentStruct savedAdoInfoSO = itSaved.next();

                Date savedDate = savedAdoInfoSO.getDtAdoInfoCbxSent();

                // check mod for duplicate in saved list if both are not the same record.
                if ((modAdoInfoSO != null && modAdoInfoSO.getIdAdoInfoCbxSent() != savedAdoInfoSO.getIdAdoInfoCbxSent()
                     && modAdoInfoSO.getIdAdoInfoCbxSent() > 0 && savedAdoInfoSO.getIdAdoInfoCbxSent() > 0
                     && modDate != null && savedDate != null && DateHelper.isEqual(modDate, savedDate))) {
                  // if modified two existing date with same date value
                  isDuplicate = true;
                  break;
                } else if ((modAdoInfoSO != null
                            && modAdoInfoSO.getIdAdoInfoCbxSent() == savedAdoInfoSO.getIdAdoInfoCbxSent()
                            && modAdoInfoSO.getIdAdoInfoCbxSent() > 0 && savedAdoInfoSO.getIdAdoInfoCbxSent() > 0
                            && savedDate != null && !DateHelper.isEqual(modDate, savedDate))) {
                  // if modified an existing date then update the saved date list for next round of validation.
                  savedAdoInfoSO.setDtAdoInfoCbxSent(modDate);

                  // only after the savedList update, we check if new date would create a duplicate
                  // after modified date is updated
                  if (newDate != null && DateHelper.isEqual(newDate, savedDate)) {
                    isDuplicate = true;
                    break;
                  }
                } else if ((modAdoInfoSO != null
                            && modAdoInfoSO.getIdAdoInfoCbxSent() == savedAdoInfoSO.getIdAdoInfoCbxSent()
                            && modAdoInfoSO.getIdAdoInfoCbxSent() == 0 && savedAdoInfoSO.getIdAdoInfoCbxSent() == 0 && DateHelper.isEqual(modDate,
                                                                                                                                          savedDate))) {
                  // if adding two new duplicate date
                  isDuplicate = true;
                  break;
                } else {
                  // otherwise check new date against existing saved date
                  if ((newDate != null && DateHelper.isEqual(newDate, savedDate))
                      || (modDate != null && modAdoInfoSO.getIdAdoInfoCbxSent() == 0 && DateHelper.isEqual(modDate,
                                                                                                           savedDate))) {
                    isDuplicate = true;
                    break;
                  }
                }
              }

              if (!isDuplicate && modAdoInfoSO != null && modAdoInfoSO.getIdAdoInfoCbxSent() == 0) {
                // reached end of saved list but no duplicate found so updated saved list
                // to include new date for next round of validation
                savedList.add(modAdoInfoSO);

                // only after the savedList update, we check if new date would create a duplicate
                if (newDate != null && DateHelper.isEqual(newDate, modDate)) {
                  isDuplicate = true;
                  break;
                }
              }

            } else {
              if (modAdoInfoSO != null) {
                // there is no existing recruitment activities dates
                savedList = new ArrayList<AdoInfoCbxSentStruct>();
                savedList.add(modAdoInfoSO);

                // only after the savedList update, we check if new dates would create a duplicate
                if (newDate != null && modDate != null && DateHelper.isEqual(newDate, modDate)) {
                  isDuplicate = true;
                  // no break here since we still want to check for future date and before DOB check
                }
              }
            }
          }

          // Check indicators to send only one message per type per activity
          if (isBeforeDob) {
            setErrorMessage("dtRecActCounty" + actCode, Messages.MSG_CMN_BEFORE_DOB);
            isValid = false;
          }
          if (isFutureDt) {
            setErrorMessage("dtRecActCounty" + actCode, Messages.SSM_DATE_BEFORE_SAME_CURR);
            isValid = false;
          }
          if (isDuplicate) {
            setErrorMessage("dtRecActCounty" + actCode, Messages.MSG_CMN_DUPLICATE_DATE);
            isValid = false;
          }
        }
      }
    } catch (LookupException le) {
      // this should never happen, but just in case we want to do a hard stop
      setErrorMessage(Messages.MSG_CODE_NOT_FOUND);
      isValid = false;
    }

    return isValid;
  }
}
