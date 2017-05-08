package gov.georgia.dhr.dfcs.sacwis.service.fce.impl;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexFceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.FceApplicationDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.FceEligibilityDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.FceExpendituresDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.FceIncomeDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.FcePersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.FceReviewDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.FceThirdPartyInsuranceDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.FceApplication;
import gov.georgia.dhr.dfcs.sacwis.db.FceEligibility;
import gov.georgia.dhr.dfcs.sacwis.db.FceExpenditures;
import gov.georgia.dhr.dfcs.sacwis.db.FceIncome;
import gov.georgia.dhr.dfcs.sacwis.db.FcePerson;
import gov.georgia.dhr.dfcs.sacwis.db.FceReview;
import gov.georgia.dhr.dfcs.sacwis.db.FceThirdPartyInsurance;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.service.fce.PerformFceDataPrefill;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.FceDataPrefillSI;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 
 * <pre>
 *  Change History:
 *  Date        User      Description
 *  ----------  --------  --------------------------------------------------
 *  12/03/10    hnguyen   SMS#81144: MR-053 Moved Case Manager Information section from
 *                        Income and Expenditures to Application and Background. Added 
 *                        logic for prefilling most recent removal date and amended application 
 *                        indicator. Corrected logic with deprivation validation and determination. 
 *                        Also corrected some javascript display issues on deprivation. Update 
 *                        page title for Reimbursability Determination. Updated EventHelper to 
 *                        change event description text based on application type. 
 *  12/08/10    hnguyen   SMS#81144: MR-053 Peer review updates to App and Background and Deprivation.
 *  12/13/10    hnguyen   SMS#81144: MR-053 Updated Foster Care Reimbursability Determination page. 
 *                        Updated related jsp, service, DBs, schema, xconf, context, etc to 
 *                        implement new design to remove ES confirmation process and have 
 *                        system automatically determine reimbursability information change. 
 *  12/14/10    hnguyen   SMS#81144: MR-053 Corrected logic for Reimbursability page display 
 *                        and IV-E Budget calculation and data persistent issues. 
 *  01/05/11    hnguyen   SMS#89483: Updated logic to copy over Foster Care Eligibility 
 *                        Checklist results for NOC, which otherwise is not calculated.
 *  01/07/11    hnguyen   SMS#81144: MR-053 Updated FCEA to prefill on change of application 
 *                        type of Amended and NOC. Also forces user to select application type 
 *                        for NEW application and perform appropriate data prefill based on 
 *                        type selected. Updated prefill logic to also prefill allocation/deeming 
 *                        section for Amended Application.
 *  01/19/11    hnguyen   SMS#91847: MR-053 Fixed issue with deprivation principal 
 *                        earner displaying incorrect name due to retrieving person object with 
 *                        the fcePerson ID. Added Change History.
 *  02/02/11    hnguyen   SMS#94617: Update FCEA Deprivation page to store ID_PERSON instead of ID_FCE_PERSON
 *                        for specified relative and principal earner.
 *  02/12/11    hnguyen   SMS#95590: Updated reimbursability prefill to not prefill indicator
 *                        for Reimbursability Determination is no longer appropriate.
 * </pre>
 */

public class PerformFceDataPrefillImpl extends BaseServiceImpl implements PerformFceDataPrefill {
  
  private final static String CD_NOTICE_OF_CHANGE = CodesTables.CFCEAPRE_R;
  private final static String CD_INITIAL_APP = CodesTables.CFCEAPRE_A;
  private final static String FOSTER_CARE_EVENT = CodesTables.CEVNTTYP_FCA;
  private final static String FOSTER_CARE_REDETERMINATION_EVENT = CodesTables.CEVNTTYP_FCR;
  private final static String APPROVE = CodesTables.CEVTSTAT_APRV;
  
  EventDAO eventDAO = null;
  FceApplicationDAO fceApplicationDAO = null;
  FceEligibilityDAO fceEligibilityDAO = null;
  FceIncomeDAO fceIncomeDAO = null;
  ComplexFceDAO complexFceDAO = null;
  FceExpendituresDAO fceExpendituresDAO = null;
  FcePersonDAO fcePersonDAO = null;
  FceThirdPartyInsuranceDAO fceThirdPartyInsuranceDAO = null;
  FceReviewDAO fceReviewDAO = null;
  
  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }

  public void setFceApplicationDAO(FceApplicationDAO fceApplicationDAO) {
    this.fceApplicationDAO = fceApplicationDAO;
  }

  public void setFceEligibilityDAO(FceEligibilityDAO fceEligibilityDAO) {
    this.fceEligibilityDAO = fceEligibilityDAO;
  }

  public void setComplexFceDAO(ComplexFceDAO complexFceDAO) {
    this.complexFceDAO = complexFceDAO;
  }

  public void setFceExpendituresDAO(FceExpendituresDAO fceExpendituresDAO) {
    this.fceExpendituresDAO = fceExpendituresDAO;
  }

  public void setFcePersonDAO(FcePersonDAO fcePersonDAO) {
    this.fcePersonDAO = fcePersonDAO;
  }

  public void setFceIncomeDAO(FceIncomeDAO fceIncomeDAO) {
    this.fceIncomeDAO = fceIncomeDAO;
  }


  public void setFceThirdPartyInsuranceDAO(FceThirdPartyInsuranceDAO fceThirdPartyInsuranceDAO) {
    this.fceThirdPartyInsuranceDAO = fceThirdPartyInsuranceDAO;
  }

  
  public void setFceReviewDAO(FceReviewDAO fceReviewDAO) {
    this.fceReviewDAO = fceReviewDAO;
  }

  @SuppressWarnings({"unchecked"})
  public void doFceDataPrefill(FceDataPrefillSI fceDataPrefillSI) {
    long idStage = fceDataPrefillSI.getUlIdStage();
    long idEvent = fceDataPrefillSI.getUlIdEvent();
    String cdEventType = "";
    FceApplication currentFceApp = null;
    FceReview currentFceRedetermination = null;
    FceApplication latestFceApp = null;
    FceReview latestFceReview = null;
    FceApplication latestFceAppBeforeReview = null;
    FceEligibility currentFceElig = null;
    List<FcePerson> currentPrincipals = null;
    FceThirdPartyInsurance currentThirdPartyHealthInsurance = null;
    Map<String, List<FceIncome>> currentIncomeAndResources = null;
    List<FceExpenditures> currentFceExpenditures = null;
    Event event = eventDAO.findEventByIdEvent((int) idEvent);
    if(event != null){
      cdEventType = event.getCdEventType();
      if("FCA".equals(cdEventType)){
        // Find the current FCE Application
        currentFceApp = fceApplicationDAO.findFceApplicationByIdApplicationEvent(idEvent);
        if (currentFceApp == null) {
          throw new ServiceException(Messages.SQL_NOT_FOUND);
        }
        // set application type from SI (Initial or Amended or NOC)
        currentFceApp.setCdApplication(fceDataPrefillSI.getSzCdApplication());
        
      } else if("FCR".equals(cdEventType)){
        // Find the current FCE Redetermination
        currentFceRedetermination = fceReviewDAO.findFceReviewByIdReviewEvent(idEvent);
        if (currentFceRedetermination == null) {
          throw new ServiceException(Messages.SQL_NOT_FOUND);
        }
      } 
    } 

    // To find the latest FCE Appp or Latest Foster Care Redetermination we first need to find all of the approved FCA and FCR events for the stage
    List<Event> applicationEvents = eventDAO.findAllEventsByStageTypeAndStatus((int)idStage, FOSTER_CARE_EVENT, FOSTER_CARE_REDETERMINATION_EVENT, APPROVE);
    if (applicationEvents != null && applicationEvents.size() > 0) {
      // Create a list of Integers containing the Ids of the Events to find the latest FCE Application
      List<Integer> idAppEvents = new ArrayList<Integer>();
      for (int i = 0; i < applicationEvents.size(); i++){
        Event appEvent = applicationEvents.get(i);
        idAppEvents.add(appEvent.getIdEvent());
      }
      if(FOSTER_CARE_EVENT.equals(applicationEvents.get(0).getCdEventType())){
        // Find the latest FCE Application that has the most recent Complete Date
        if(CD_NOTICE_OF_CHANGE.equals(fceDataPrefillSI.getSzCdApplication()) ){
          latestFceApp = fceApplicationDAO.findFceApplicationByEventList(idAppEvents);
        }else{
          //Amended prefill only prefill from previous initial or amended apps only, no NOC
          latestFceApp = fceApplicationDAO.findLatestFceApplicationInitialAmendedByEventList(idAppEvents);
        }
      }else if(FOSTER_CARE_REDETERMINATION_EVENT.equals(applicationEvents.get(0).getCdEventType())){
        // Find the latest FCR Redetermination that has the most recent Complete Date
        latestFceReview = fceReviewDAO.findFceReviewByIdEventAndDtReviewComplete(applicationEvents.get(0).getIdEvent());
        // Find the latest FCE Application that has the most recent Complete Date
        latestFceAppBeforeReview = fceApplicationDAO.findFceApplicationByEventList(idAppEvents);
      }
    }
    // If a previously approved FCE  Application or Redetermination doesn't exist, there's no need to do a Prefill of
    // of the data for the current application. Indicate that the current app is an Initial Application 
    // and just return
    if (latestFceApp == null && latestFceReview == null) {
      if("FCA".equals(cdEventType)){
        fceApplicationDAO.updateFceApplicationCdApplication(currentFceApp.getIdFceApplication(), fceDataPrefillSI.getSzCdApplication());
      }
      return;
    }
    
    // If the FC Application is the latest one fill out all the Application pages with that
    if(latestFceApp != null){
      long latestIdFceElig = latestFceApp.getFceEligibility().getIdFceEligibility();
      FceEligibility latestFceElig = fceEligibilityDAO.findFceEligibilityByIdFceEligibility(latestIdFceElig);
      
      // Retrieve the principals of the latest FCE Application
      List<FcePerson> latestAppPrincipals = fcePersonDAO.findPrincipals(latestIdFceElig);
      
      // Retrieve the Third Party Health Insurance for the latest approved FCE Application
      FceThirdPartyInsurance latestThirdPartyHealthInsurance = fceThirdPartyInsuranceDAO.
      findFceThirdPartyHealthInsuranceByIdFceApplication(latestFceApp.getIdFceApplication());
      if (latestThirdPartyHealthInsurance == null){
        latestThirdPartyHealthInsurance = new FceThirdPartyInsurance();
      }
      
      // Retrieve all Income and Resources for the Primary Child and the Family members of the SUB/FCC Stage
      List<FceIncome> latestIncomeForChild = complexFceDAO.findFceIncomeResources(latestIdFceElig, true, true);
      List<FceIncome> latestResourceForChild = complexFceDAO.findFceIncomeResources(latestIdFceElig, false, true);
      List<FceIncome> latestIncomeForFamily = complexFceDAO.findFceIncomeResources(latestIdFceElig, true, false);
      List<FceIncome> latestResourceForFamily = complexFceDAO.findFceIncomeResources(latestIdFceElig, false, false);
      
      Map<String, List<FceIncome>> latestIncomeAndResources = new HashMap<String, List<FceIncome>>();
      latestIncomeAndResources.put("latestIncomeForChild", latestIncomeForChild);
      latestIncomeAndResources.put("latestResourceForChild", latestResourceForChild);
      latestIncomeAndResources.put("latestIncomeForFamily", latestIncomeForFamily);
      latestIncomeAndResources.put("latestResourceForFamily", latestResourceForFamily);
      
      // Retrieve all Expenditures that the Principals of the current FCE Application are responsible for
      List<FceExpenditures> latestFceExpenditures = fceExpendituresDAO.findAllFceExpenditures(latestIdFceElig);
      
      if("FCA".equals(cdEventType)){
        // Find the current FCE_ELIGIBILITY record
        long currentIdFceElig = currentFceApp.getFceEligibility().getIdFceEligibility();
        currentFceElig = fceEligibilityDAO.findFceEligibilityByIdFceEligibility(currentIdFceElig);
        if (currentFceElig == null) {
          throw new ServiceException(Messages.SQL_NOT_FOUND);
        }
        
        // Retrieve the principals for the current FCE Application
        currentPrincipals = fcePersonDAO.findPrincipals(currentIdFceElig);
        
        // Retrieve the Third Party Health Insurance for the current FCE Application
        currentThirdPartyHealthInsurance = fceThirdPartyInsuranceDAO.findFceThirdPartyHealthInsuranceByIdFceApplication(currentFceApp.getIdFceApplication());
        if (currentThirdPartyHealthInsurance == null){
          currentThirdPartyHealthInsurance = new FceThirdPartyInsurance();
        }
        
        // Retrieve all Income and Resources for the Primary Child and the Family members of the SUB/FCC Stage
        List<FceIncome> currentIncomeForChild = complexFceDAO.findFceIncomeResources(currentIdFceElig, true, true);
        List<FceIncome> currentResourceForChild = complexFceDAO.findFceIncomeResources(currentIdFceElig, false, true);
        List<FceIncome> currentIncomeForFamily = complexFceDAO.findFceIncomeResources(currentIdFceElig, true, false);
        List<FceIncome> currentResourceForFamily = complexFceDAO.findFceIncomeResources(currentIdFceElig, false, false);
        
        currentIncomeAndResources = new HashMap<String, List<FceIncome>>();
        currentIncomeAndResources.put("currentIncomeForChild", currentIncomeForChild);
        currentIncomeAndResources.put("currentResourceForChild", currentResourceForChild);
        currentIncomeAndResources.put("currentIncomeForFamily", currentIncomeForFamily);
        currentIncomeAndResources.put("currentResourceForFamily", currentResourceForFamily);
        
        // Retrieve all Expenditures that the Principals of the current FCE Application are responsible for
        currentFceExpenditures = fceExpendituresDAO.findAllFceExpenditures(currentIdFceElig);
        // Do Prefill
        prefillAppBg(currentFceApp, latestFceApp, currentPrincipals, latestAppPrincipals);
        prefillAgeCitizenship(currentFceApp, latestFceApp, currentFceElig, latestFceElig, cdEventType);
        prefillRemovalHousehold(currentFceApp, latestFceApp, currentFceElig, latestFceElig, null, null, cdEventType);
        prefillIncomeExpenditures(currentFceApp, latestFceApp, currentFceElig, latestFceElig, null, 
                                  currentIncomeAndResources, latestIncomeAndResources,
                                  currentFceExpenditures, latestFceExpenditures);
        // If this is an Initial App or Amended, prefill the Household(including the child) equity/resource question
        if(CD_INITIAL_APP.equals(currentFceApp.getCdApplication())) {
          currentFceElig.setIndEquity(latestFceElig.getIndEquity());
        } 
        // Else it's a NOC and therefore prefill the Child(only) equity/resource question
        else {
          currentFceElig.setIndChildEquity(latestFceElig.getIndChildEquity());
        }
        prefillWorksheetJudicialSection(currentFceElig, latestFceElig);
        
        // Save Prefill
        fceEligibilityDAO.saveFceEligibility(currentFceElig);
        currentFceApp.setFceEligibility(currentFceElig);
        fceApplicationDAO.saveFceApplication(currentFceApp);
        currentThirdPartyHealthInsurance.setIdFceApplication(currentFceApp.getIdFceApplication());
        currentThirdPartyHealthInsurance.setFceApplication(currentFceApp);
        prefillHealthInsurance(currentThirdPartyHealthInsurance, latestThirdPartyHealthInsurance);
      } else if("FCR".equals(cdEventType)) {
        // Find the current FCE_ELIGIBILITY record
        long currentIdFceElig = currentFceRedetermination.getFceEligibility().getIdFceEligibility();
        currentFceElig = fceEligibilityDAO.findFceEligibilityByIdFceEligibility(currentIdFceElig);
        if (currentFceElig == null) {
          throw new ServiceException(Messages.SQL_NOT_FOUND);
        }
        
        // Retrieve all Income and Resources for the Primary Child of the SUB/FCC Stage
        List<FceIncome> currentIncomeForChild = complexFceDAO.findFceIncomeResources(currentFceElig.getIdFceEligibility(), true, true);
        List<FceIncome> currentResourceForChild = complexFceDAO.findFceIncomeResources(currentFceElig.getIdFceEligibility(), false, true);
        currentIncomeAndResources = new HashMap<String, List<FceIncome>>();
        currentIncomeAndResources.put("currentIncomeForChild", currentIncomeForChild);
        currentIncomeAndResources.put("currentResourceForChild", currentResourceForChild);
        // Do Prefill
        //MR-053 No longer need to prefill these since they are removed from page.
//        prefillRemovalHousehold(null, latestFceApp, currentFceElig, latestFceElig, currentFceRedetermination, null, cdEventType);
//        prefillAgeCitizenship(null, latestFceApp, currentFceElig, latestFceElig, cdEventType);
        
        // If the latest Application was a NOC, use the Child(only) equity/resource question to prefill the
        // Redetermination's Child(only) equity/resource question
        if(CD_NOTICE_OF_CHANGE.equals(latestFceApp.getCdApplication())) {
          currentFceElig.setIndChildEquity(latestFceElig.getIndChildEquity());
        }
        // Save Prefill
        fceEligibilityDAO.saveFceEligibility(currentFceElig);
        
        prefillIncomeAndResourcesForChild(currentIncomeAndResources, latestIncomeAndResources);
        
        //currentFceRedetermination.setFceEligibility(currentFceElig);
        fceReviewDAO.saveFceReview(currentFceRedetermination);
      }
    }
    // If the Redetermination is the latest one, fill out all the Application pages with that and the latest Application
    else if(latestFceReview != null){  
      long latestIdFceElig = latestFceReview.getFceEligibility().getIdFceEligibility();
      FceEligibility latestFceEligReview = fceEligibilityDAO.findFceEligibilityByIdFceEligibility(latestIdFceElig);
      
      long idFceEligOfLatestFceApp = latestFceAppBeforeReview.getFceEligibility().getIdFceEligibility();
      FceEligibility latestFceEligOfLatestFceApp = fceEligibilityDAO.findFceEligibilityByIdFceEligibility(idFceEligOfLatestFceApp);
      
      // Retrieve the principals of the latest FCE Application
      List<FcePerson> latestAppPrincipals = fcePersonDAO.findPrincipals(idFceEligOfLatestFceApp);
      
      // Retrieve the Third Party Health Insurance for the latest approved FCE Application
      FceThirdPartyInsurance latestThirdPartyHealthInsurance = fceThirdPartyInsuranceDAO.
      findFceThirdPartyHealthInsuranceByIdFceApplication(latestFceAppBeforeReview.getIdFceApplication());
      if (latestThirdPartyHealthInsurance == null){
        latestThirdPartyHealthInsurance = new FceThirdPartyInsurance();
      }
      
      // Retrieve all Income and Resources for the Primary Child using the Eligibility of the latest Redetermination 
      // and all Income and Resources for the Family members using the Eligibility of the latest Application of the SUB/FCC Stage
      List<FceIncome> latestIncomeForChild = complexFceDAO.findFceIncomeResources(latestIdFceElig, true, true);
      List<FceIncome> latestResourceForChild = complexFceDAO.findFceIncomeResources(latestIdFceElig, false, true);
      List<FceIncome> latestIncomeForFamily = complexFceDAO.findFceIncomeResources(idFceEligOfLatestFceApp, true, false);
      List<FceIncome> latestResourceForFamily = complexFceDAO.findFceIncomeResources(idFceEligOfLatestFceApp, false, false);
      
      Map<String, List<FceIncome>> latestIncomeAndResources = new HashMap<String, List<FceIncome>>();
      latestIncomeAndResources.put("latestIncomeForChild", latestIncomeForChild);
      latestIncomeAndResources.put("latestResourceForChild", latestResourceForChild);
      latestIncomeAndResources.put("latestIncomeForFamily", latestIncomeForFamily);
      latestIncomeAndResources.put("latestResourceForFamily", latestResourceForFamily);
      
      // Retrieve all Expenditures that the Principals of the current FCE Application are responsible for
      List<FceExpenditures> latestFceExpenditures = fceExpendituresDAO.findAllFceExpenditures(idFceEligOfLatestFceApp);
      
      if("FCA".equals(cdEventType)){
        // Find the current FCE_ELIGIBILITY record
        long currentIdFceElig = currentFceApp.getFceEligibility().getIdFceEligibility();
        currentFceElig = fceEligibilityDAO.findFceEligibilityByIdFceEligibility(currentIdFceElig);
        if (currentFceElig == null) {
          throw new ServiceException(Messages.SQL_NOT_FOUND);
        }
        
        // Retrieve the principals for the current FCE Application
        currentPrincipals = fcePersonDAO.findPrincipals(currentIdFceElig);
        
        // Retrieve the Third Party Health Insurance for the current FCE Application
        currentThirdPartyHealthInsurance = fceThirdPartyInsuranceDAO.findFceThirdPartyHealthInsuranceByIdFceApplication(currentFceApp.getIdFceApplication());
        if (currentThirdPartyHealthInsurance == null){
          currentThirdPartyHealthInsurance = new FceThirdPartyInsurance();
        }
        
        // Retrieve all Income and Resources for the Primary Child and the Family members of the SUB/FCC Stage
        List<FceIncome> currentIncomeForChild = complexFceDAO.findFceIncomeResources(currentIdFceElig, true, true);
        List<FceIncome> currentResourceForChild = complexFceDAO.findFceIncomeResources(currentIdFceElig, false, true);
        List<FceIncome> currentIncomeForFamily = complexFceDAO.findFceIncomeResources(currentIdFceElig, true, false);
        List<FceIncome> currentResourceForFamily = complexFceDAO.findFceIncomeResources(currentIdFceElig, false, false);
        
        currentIncomeAndResources = new HashMap<String, List<FceIncome>>();
        currentIncomeAndResources.put("currentIncomeForChild", currentIncomeForChild);
        currentIncomeAndResources.put("currentResourceForChild", currentResourceForChild);
        currentIncomeAndResources.put("currentIncomeForFamily", currentIncomeForFamily);
        currentIncomeAndResources.put("currentResourceForFamily", currentResourceForFamily);
        
        // Retrieve all Expenditures that the Principals of the current FCE Application are responsible for
        currentFceExpenditures = fceExpendituresDAO.findAllFceExpenditures(currentIdFceElig);
        // Do Prefill
        prefillAppBg(currentFceApp, latestFceAppBeforeReview, currentPrincipals, latestAppPrincipals);
        prefillAgeCitizenship(currentFceApp, latestFceAppBeforeReview, currentFceElig, latestFceEligReview, cdEventType);
        prefillRemovalHousehold(currentFceApp, latestFceAppBeforeReview, currentFceElig, latestFceEligReview, null, latestFceReview, cdEventType);
        prefillIncomeExpenditures(currentFceApp, latestFceAppBeforeReview, currentFceElig, latestFceEligReview, latestFceEligOfLatestFceApp,
                                  currentIncomeAndResources, latestIncomeAndResources,
                                  currentFceExpenditures, latestFceExpenditures);
        
        // If the current Application is a NOC(which it should be if we already have a latest Redetermination), 
        // use the Child(only) equity/resource question from the latest Redetermination to prefill the current NOC
        // Child(only) equity/resource question
        if(CD_NOTICE_OF_CHANGE.equals(currentFceApp.getCdApplication())) {
          currentFceElig.setIndChildEquity(latestFceEligReview.getIndChildEquity());
        }
        int latestIdFceEligibility = latestFceAppBeforeReview.getFceEligibility().getIdFceEligibility();
        FceEligibility latestFceEligBeforeReview = fceEligibilityDAO.findFceEligibilityByIdFceEligibility(latestIdFceEligibility);
        prefillWorksheetJudicialSection(currentFceElig, latestFceEligBeforeReview);
        // Save Prefill
        fceEligibilityDAO.saveFceEligibility(currentFceElig);
        currentFceApp.setFceEligibility(currentFceElig);
        fceApplicationDAO.saveFceApplication(currentFceApp);
        currentThirdPartyHealthInsurance.setIdFceApplication(currentFceApp.getIdFceApplication());
        currentThirdPartyHealthInsurance.setFceApplication(currentFceApp);
        prefillHealthInsurance(currentThirdPartyHealthInsurance, latestThirdPartyHealthInsurance);
      } else if("FCR".equals(cdEventType)) {
        // Find the current FCE_ELIGIBILITY record
        long currentIdFceElig = currentFceRedetermination.getFceEligibility().getIdFceEligibility();
        currentFceElig = fceEligibilityDAO.findFceEligibilityByIdFceEligibility(currentIdFceElig);
        if (currentFceElig == null) {
          throw new ServiceException(Messages.SQL_NOT_FOUND);
        }
        
        // Retrieve all Income and Resources for the Primary Child of the SUB/FCC Stage
        List<FceIncome> currentIncomeForChild = complexFceDAO.findFceIncomeResources(currentFceElig.getIdFceEligibility(), true, true);
        List<FceIncome> currentResourceForChild = complexFceDAO.findFceIncomeResources(currentFceElig.getIdFceEligibility(), false, true);
        currentIncomeAndResources = new HashMap<String, List<FceIncome>>();
        currentIncomeAndResources.put("currentIncomeForChild", currentIncomeForChild);
        currentIncomeAndResources.put("currentResourceForChild", currentResourceForChild);
        // Do Prefill
        // MR-053 No longer prefilling these data since sections are no longer there
//        prefillRemovalHousehold(null, latestFceAppBeforeReview, currentFceElig, latestFceEligReview, currentFceRedetermination, latestFceReview, cdEventType);
//        prefillAgeCitizenship(null, latestFceAppBeforeReview, currentFceElig, latestFceEligReview, cdEventType);
        
        // use the Child(only) equity/resource question from the latest Redetermination to prefill the current
        // Redetermination's Child(only) equity/resource question
        currentFceElig.setIndChildEquity(latestFceEligReview.getIndChildEquity());
        // Save Prefill
        fceEligibilityDAO.saveFceEligibility(currentFceElig);
        
        prefillIncomeAndResourcesForChild(currentIncomeAndResources, latestIncomeAndResources);
        
        prefillFceRedetermination(currentFceRedetermination, latestFceReview);
        currentFceRedetermination.setIndExtnsionProvided12Mnths(latestFceReview.getIndExtnsionProvided12Mnths());
        currentFceRedetermination.setIndSavingsAcct(latestFceReview.getIndSavingsAcct());
        
        fceReviewDAO.saveFceReview(currentFceRedetermination);
      }
    }
  }
  
  private void prefillAppBg(FceApplication currentFceApplication, FceApplication latestFceApplication, 
                            List<FcePerson> currentPrincipals, List<FcePerson> latestAppPrincipals){
    // Prefill App And BG page
    currentFceApplication.setAddrRemovalStLn1(latestFceApplication.getAddrRemovalStLn1());
    currentFceApplication.setAddrRemovalStLn2(latestFceApplication.getAddrRemovalStLn2());
    currentFceApplication.setAddrRemovalCity(latestFceApplication.getAddrRemovalCity());
    currentFceApplication.setCdRemovalAddrState(latestFceApplication.getCdRemovalAddrState());
    currentFceApplication.setCdRemovalAddrCounty(latestFceApplication.getCdRemovalAddrCounty());
    currentFceApplication.setAddrRemovalAddrZip(latestFceApplication.getAddrRemovalAddrZip());
    currentFceApplication.setIndMinorParent(latestFceApplication.getIndMinorParent());
    currentFceApplication.setIndHospital(latestFceApplication.getIndHospital());
    currentFceApplication.setDtHospitalAdmission(latestFceApplication.getDtHospitalAdmission());
    currentFceApplication.setDtHospitalDischarge(latestFceApplication.getDtHospitalDischarge());
    currentFceApplication.setIndManagingCvs(latestFceApplication.getIndManagingCvs());
    currentFceApplication.setTxtPriorRemovalMonths(latestFceApplication.getTxtPriorRemovalMonths());
    currentFceApplication.setTxtEmployeeComments(latestFceApplication.getTxtEmployeeComments());
    
    
    // Prefill the List of Principals section
    if (currentPrincipals != null && currentPrincipals.size() > 0) {
      for (int i = 0; i < currentPrincipals.size(); i++) {
        FcePerson principal = (FcePerson) currentPrincipals.get(i);
        if (latestAppPrincipals != null && latestAppPrincipals.size() > 0){
          FcePerson latestPrincipal = new FcePerson();
          boolean foundPrincipal = false;
          for (int x = 0; x < latestAppPrincipals.size(); x++) {
            latestPrincipal = (FcePerson) latestAppPrincipals.get(x);
            if (principal.getPerson().getIdPerson() == latestPrincipal.getPerson().getIdPerson()){
              foundPrincipal = true;
              break;
            }
          }
          if (foundPrincipal){
            principal.setIndPersonHmRemoval(latestPrincipal.getIndPersonHmRemoval());
            principal.setIndLegalCustodian(latestPrincipal.getIndLegalCustodian());
            // Do not indicate whether this principal is a member of the AU because if any one of them
            // are receiving SSI, the case manger will get the message to remove them from the AU. The problem 
            // is that the case manager does not have access to the checkbox to uncheck it.
                   //principal.setIndCertifiedGroup(latestPrincipal.getIndCertifiedGroup());
            // This is set for the Third Party Health Insurance
            principal.setIndThirdPartyInsurance(latestPrincipal.getIndThirdPartyInsurance());
            fcePersonDAO.saveFcePerson(principal);
          }
        }
      }
    }
  }
  
  private void prefillAgeCitizenship (FceApplication currentFceApplication, FceApplication latestFceApplication,
                                      FceEligibility currentFceElig, FceEligibility latestFceElig, String cdEventType){
    if("FCA".equals(cdEventType)){
      currentFceApplication.setIndAgeVrfdSuccessSystem(latestFceApplication.getIndAgeVrfdSuccessSystem());
      currentFceApplication.setIndAgeVrfdSaveSystem(latestFceApplication.getIndAgeVrfdSaveSystem());   
      currentFceApplication.setNmHospital(latestFceApplication.getNmHospital());
      currentFceApplication.setNmMotherMaiden(latestFceApplication.getNmMotherMaiden());
      currentFceApplication.setNmHospitalCity(latestFceApplication.getNmHospitalCity());
      currentFceApplication.setCdState(latestFceApplication.getCdState());
      currentFceApplication.setCdCountyHospital(latestFceApplication.getCdCountyHospital());
    }
    currentFceElig.setIndChildQualifiedCitizen(latestFceElig.getIndChildQualifiedCitizen());
    currentFceElig.setIndChildUnder18(latestFceElig.getIndChildUnder18());
    
    // Prefill the Citizenship Verified by Eligibility Specialist section
    currentFceElig.setIndCtznshpSuccessSystem(latestFceElig.getIndCtznshpSuccessSystem());
    currentFceElig.setIndCtznshpSaveSystem(latestFceElig.getIndCtznshpSaveSystem());
  }
  
  private void prefillRemovalHousehold (FceApplication currentFceApplication, FceApplication latestFceApplication,
                                        FceEligibility currentFceElig, FceEligibility latestFceElig, 
                                        FceReview currentFceRedeterm,  FceReview latestFceRedeterm, String cdEventType){
    
    // Prefill DomicileDeprivation page
    if("FCA".equals(cdEventType)){
      currentFceApplication.setNbrCourtMonth(latestFceApplication.getNbrCourtMonth());
      currentFceApplication.setNbrCourtYear(latestFceApplication.getNbrCourtYear());
      currentFceApplication.setDtRemovalDate(latestFceApplication.getDtRemovalDate());
      //If the latest Application approved is the Redetermination then set the CdLivingMonthRemoval with the one on Redetermination page
      if(latestFceRedeterm != null){
        currentFceApplication.setCdLivingMonthRemoval(latestFceApplication.getCdLivingMonthRemoval());
        //prefill the MES Worker Comments from latest redetermination
        currentFceApplication.setTxtMeetsDdOrNotComments(latestFceElig.getTxtDeterminationComments());
      }else{ // Else set the CdLivingMonthRemoval with the one on Deprivation page of the Application
        currentFceApplication.setCdLivingMonthRemoval(latestFceApplication.getCdLivingMonthRemoval());
        // prefill the MES Worker Comments from latest application
        currentFceApplication.setTxtMeetsDdOrNotComments(latestFceApplication.getTxtMeetsDdOrNotComments());
      }
      currentFceElig.setIdOtherRelativePerson(latestFceElig.getIdOtherRelativePerson());
      currentFceApplication.setCdNotaMostRecent(latestFceApplication.getCdNotaMostRecent());
    }  else if("FCR".equals(cdEventType)) {
      //    If the latest Application approved is the Redetermination then set the CdLivingMonthRemoval with the one on Redetermination page
      if(latestFceRedeterm != null){
        currentFceRedeterm.setCdLivingConditionCurrent(latestFceApplication.getCdLivingMonthRemoval());
        //      prefill the MES Worker Comments from latest redetermination
        currentFceElig.setTxtDeterminationComments(latestFceElig.getTxtDeterminationComments());
      }else{ // Else set the CdLivingMonthRemoval with the one on Deprivation page of the Application
        currentFceRedeterm.setCdLivingConditionCurrent(latestFceApplication.getCdLivingMonthRemoval());
        //      prefill the MES Worker Comments from latest application
        currentFceElig.setTxtDeterminationComments(latestFceApplication.getTxtMeetsDdOrNotComments());
      }
    }
    currentFceElig.setIndMeetsDpOrNotSystem(latestFceElig.getIndMeetsDpOrNotSystem());
    currentFceElig.setIndParentalDeprivation(latestFceElig.getIndParentalDeprivation());
    currentFceElig.setIndChildLivingPrnt6Mnths(latestFceElig.getIndChildLivingPrnt6Mnths());
    currentFceElig.setTxtMonthsLivingRelCust(latestFceElig.getTxtMonthsLivingRelCust());
    currentFceElig.setDtDeprivationChanged(latestFceElig.getDtDeprivationChanged());

    // Prefill DeprivationBothSub page
    currentFceElig.setIndParentDisabled(latestFceElig.getIndParentDisabled());
    currentFceElig.setPersonByIdPrnEarner(latestFceElig.getPersonByIdPrnEarner());
    currentFceElig.setIndSsiVerification(latestFceElig.getIndSsiVerification());
    currentFceElig.setIndRsdiVerification(latestFceElig.getIndRsdiVerification());
    currentFceElig.setIndOtherVerification(latestFceElig.getIndOtherVerification());
    currentFceElig.setIndMotherPwe(latestFceElig.getIndMotherPwe());
    currentFceElig.setIndFatherPwe(latestFceElig.getIndFatherPwe());
    currentFceElig.setCdPweSteadyUnder100(latestFceElig.getCdPweSteadyUnder100());
    currentFceElig.setCdVerifDocType(latestFceElig.getCdVerifDocType());
    currentFceElig.setCdVerifMethod(latestFceElig.getCdVerifMethod());
    currentFceElig.setIndPeNotAcptEmpTrn(latestFceElig.getIndPeNotAcptEmpTrn());
    currentFceElig.setIndPeRecvUnemp(latestFceElig.getIndPeRecvUnemp());
    currentFceElig.setIndPeWrkEngEduTrn(latestFceElig.getIndPeWrkEngEduTrn());
    currentFceElig.setIndRecv100PctVa(latestFceElig.getIndRecv100PctVa());
    currentFceElig.setIndRecvRrRsdi(latestFceElig.getIndRecvRrRsdi());
    currentFceElig.setTxtMonthsDepUnemp(latestFceElig.getTxtMonthsDepUnemp());
    currentFceElig.setTxtMonthsDepDisabled(latestFceElig.getTxtMonthsDepDisabled());
    currentFceElig.setCdPweIrregularUnder100(latestFceElig.getCdPweIrregularUnder100());
    currentFceElig.setTxtMonthsDepUnderEmpl(latestFceElig.getTxtMonthsDepUnderEmpl());
    currentFceElig.setAmtPweIncome(latestFceElig.getAmtPweIncome());
    
    // Prefill DeprivationOneSub page
    currentFceElig.setIndAbsentFather(latestFceElig.getIndAbsentFather());
    currentFceElig.setIndAbsentMother(latestFceElig.getIndAbsentMother());
    currentFceElig.setIndAbsentMilitaryWork(latestFceElig.getIndAbsentMilitaryWork());
    currentFceElig.setIndAbsentMilitaryWork(latestFceElig.getIndAbsentMilitaryWork());
    currentFceElig.setIndAbsentDied(latestFceElig.getIndAbsentDied());
    currentFceElig.setIndAbsentDeported(latestFceElig.getIndAbsentDeported());
    currentFceElig.setIndAbsentDeserted(latestFceElig.getIndAbsentDeserted());
    currentFceElig.setIndAbsentDivorced(latestFceElig.getIndAbsentDivorced());
    currentFceElig.setIndAbsentHospitalized(latestFceElig.getIndAbsentHospitalized());
    currentFceElig.setIndAbsentIncarcerated(latestFceElig.getIndAbsentIncarcerated());
    currentFceElig.setIndAbsentNeverCohabitated(latestFceElig.getIndAbsentNeverCohabitated());
    currentFceElig.setIndAbsentAltrntCustody(latestFceElig.getIndAbsentAltrntCustody());
    currentFceElig.setIndAbsentSeparated(latestFceElig.getIndAbsentSeparated());
    currentFceElig.setIndAbsentTprVolRelinq(latestFceElig.getIndAbsentTprVolRelinq());
    currentFceElig.setIndAbsentWorkRelated(latestFceElig.getIndAbsentWorkRelated());
    
    // Prefill DeprivationOtherSub page
    currentFceApplication.setPersonByIdOtherRelativePerson(latestFceApplication.getPersonByIdOtherRelativePerson());
    currentFceApplication.setPersonByIdMngngCvsPerson(latestFceApplication.getPersonByIdMngngCvsPerson());
    currentFceApplication.setIndSpecifiedRelative(latestFceApplication.getIndSpecifiedRelative());
    
    //prefill MES Worker confirmation section
    currentFceElig.setIndMeetsDpOrNotEs(latestFceElig.getIndMeetsDpOrNotEs());
  }
  
  private void prefillHealthInsurance(FceThirdPartyInsurance currentHealthInsurance, FceThirdPartyInsurance latestHealthInsurance){
    // Prefill Third Party Health Insurance
    if (currentHealthInsurance == null){
      currentHealthInsurance = new FceThirdPartyInsurance();
    }
    currentHealthInsurance.setAddrZip(latestHealthInsurance.getAddrZip());
    currentHealthInsurance.setNbrPhone(latestHealthInsurance.getNbrPhone());
    currentHealthInsurance.setIndChildCoverage(latestHealthInsurance.getIndChildCoverage());
    currentHealthInsurance.setCdType(latestHealthInsurance.getCdType());
    currentHealthInsurance.setNmCompany(latestHealthInsurance.getNmCompany());
    currentHealthInsurance.setNbrPolicy(latestHealthInsurance.getNbrPolicy());
    currentHealthInsurance.setNbrGroup(latestHealthInsurance.getNbrGroup());
    currentHealthInsurance.setAddrStreetLn1(latestHealthInsurance.getAddrStreetLn1());
    currentHealthInsurance.setAddrStreetLn2(latestHealthInsurance.getAddrStreetLn2());
    currentHealthInsurance.setAddrCity(latestHealthInsurance.getAddrCity());
    currentHealthInsurance.setAddrState(latestHealthInsurance.getAddrState());
    currentHealthInsurance.setNmPolicyHolder(latestHealthInsurance.getNmPolicyHolder());
    currentHealthInsurance.setDtBegin(latestHealthInsurance.getDtBegin());
    currentHealthInsurance.setDtEnd(latestHealthInsurance.getDtEnd());
    currentHealthInsurance.setNmEmployer(latestHealthInsurance.getNmEmployer());
    currentHealthInsurance.setNmEmployeeName(latestHealthInsurance.getNmEmployeeName());
    currentHealthInsurance.setIndAuthRelease(latestHealthInsurance.getIndAuthRelease());
    currentHealthInsurance.setDtAuthRelease(latestHealthInsurance.getDtAuthRelease());
    currentHealthInsurance.setIndAuthAssign(latestHealthInsurance.getIndAuthAssign());
    currentHealthInsurance.setDtAuthAssign(latestHealthInsurance.getDtAuthAssign());
    currentHealthInsurance.setIndChangeCancel(latestHealthInsurance.getIndChangeCancel());
    currentHealthInsurance.setDtChangeCancel(latestHealthInsurance.getDtChangeCancel());
    currentHealthInsurance.setNbrPhone(latestHealthInsurance.getNbrPhone());
    fceThirdPartyInsuranceDAO.saveFceThirdPartyInsurance(currentHealthInsurance);
  }
  
  private void prefillIncomeExpenditures(FceApplication currentFceApplication, FceApplication latestFceApplication,
                                        FceEligibility currentFceElig, FceEligibility latestFceElig,
                                        FceEligibility latestFceEligOfLatestFceApp, 
                                        Map<String, List<FceIncome>> currentIncomeAndResources,
                                        Map<String, List<FceIncome>> latestIncomeAndResources,
                                        List<FceExpenditures> currentFceExpenditures,
                                        List<FceExpenditures> latestFceExpenditures){
    // Prefill Income Expenditures page
    currentFceApplication.setIndIncomeAssistance(latestFceApplication.getIndIncomeAssistance());
    currentFceApplication.setIndNotifiedDhsWorker(latestFceApplication.getIndNotifiedDhsWorker());
    currentFceApplication.setNmNotifiedDhsWrkrFirst(latestFceApplication.getNmNotifiedDhsWrkrFirst());
    currentFceApplication.setNmNotifiedDhsWrkrMiddle(latestFceApplication.getNmNotifiedDhsWrkrMiddle());
    currentFceApplication.setNmNotifiedDhsWrkrLast(latestFceApplication.getNmNotifiedDhsWrkrLast());
    currentFceApplication.setNbrNotifiedDhsWrkrPhn(latestFceApplication.getNbrNotifiedDhsWrkrPhn());
    currentFceApplication.setDtNotifiedWorker(latestFceApplication.getDtNotifiedWorker());
    currentFceApplication.setTxtNoIncomeExplanation(latestFceApplication.getTxtNoIncomeExplanation());
    currentFceApplication.setTxtIncomeDtrmntnComments(latestFceApplication.getTxtIncomeDtrmntnComments());
    currentFceApplication.setNbrLivingAtHome(latestFceApplication.getNbrLivingAtHome());
   
    //  If the latest Application approved is the Redetermination then set the below values using the eligibilty 
    // of the latest application and eligibility for the redetermination.
    if(latestFceEligOfLatestFceApp != null){
      currentFceElig.setNbrCertifiedGroup(latestFceEligOfLatestFceApp.getNbrCertifiedGroup());
      currentFceElig.setIndChildCare(latestFceEligOfLatestFceApp.getIndChildCare());
      currentFceElig.setIndOutHomeCare(latestFceEligOfLatestFceApp.getIndOutHomeCare());
      currentFceElig.setIndEmancipation(latestFceEligOfLatestFceApp.getIndEmancipation());
      currentFceElig.setIndAdoption(latestFceEligOfLatestFceApp.getIndAdoption());
      currentFceElig.setIndPayForCare(latestFceEligOfLatestFceApp.getIndPayForCare());
      currentFceElig.setNbrStepparentChildren(latestFceEligOfLatestFceApp.getNbrStepparentChildren());
      currentFceElig.setAmtStepparentAlimony(latestFceEligOfLatestFceApp.getAmtStepparentAlimony());
      currentFceElig.setAmtStepparentOutsidePmnt(latestFceEligOfLatestFceApp.getAmtStepparentOutsidePmnt());
      
      // For amended app prefill allocation/deeming, otherwise clear
      if( CD_INITIAL_APP.equals(currentFceApplication.getCdApplication())){
        currentFceElig.setCdAllocType(latestFceEligOfLatestFceApp.getCdAllocType());
        currentFceElig.setPersonAllocSngl1(latestFceEligOfLatestFceApp.getPersonAllocSngl1());
        currentFceElig.setNbrIneligSpouseAllocSngl1(latestFceEligOfLatestFceApp.getNbrIneligSpouseAllocSngl1());
        currentFceElig.setNbrIneligChildAllocSngl1(latestFceEligOfLatestFceApp.getNbrIneligChildAllocSngl1());
        
        currentFceElig.setPersonAllocSngl2(latestFceEligOfLatestFceApp.getPersonAllocSngl2());
        currentFceElig.setNbrIneligSpouseAllocSngl2(latestFceEligOfLatestFceApp.getNbrIneligSpouseAllocSngl2());
        currentFceElig.setNbrIneligChildAllocSngl2(latestFceEligOfLatestFceApp.getNbrIneligChildAllocSngl2());

        currentFceElig.setPersonAllocMutual1(latestFceEligOfLatestFceApp.getPersonAllocMutual1());
        currentFceElig.setPersonAllocMutual2(latestFceEligOfLatestFceApp.getPersonAllocMutual2());
        currentFceElig.setNbrIneligSpouseAllocMutual(latestFceEligOfLatestFceApp.getNbrIneligSpouseAllocMutual());
        currentFceElig.setNbrIneligChildAllocMutual(latestFceEligOfLatestFceApp.getNbrIneligChildAllocMutual());
        
        currentFceElig.setCdDeemRespType(latestFceEligOfLatestFceApp.getCdDeemRespType());
        currentFceElig.setPersonDeemIndiv1(latestFceEligOfLatestFceApp.getPersonDeemIndiv1());
        currentFceElig.setCdDeemIndivRel1(latestFceEligOfLatestFceApp.getCdDeemIndivRel1());
        currentFceElig.setPersonDeemIndiv2(latestFceEligOfLatestFceApp.getPersonDeemIndiv2());
        currentFceElig.setCdDeemIndivRel2(latestFceEligOfLatestFceApp.getCdDeemIndivRel2());
        currentFceElig.setNbrDeemChildNotInAU(latestFceEligOfLatestFceApp.getNbrDeemChildNotInAU());
        currentFceElig.setNbrDeemTaxDependNotInAU(latestFceEligOfLatestFceApp.getNbrDeemTaxDependNotInAU());
        currentFceElig.setNbrDeemResponseIndiv(latestFceEligOfLatestFceApp.getNbrDeemResponseIndiv());
        currentFceElig.setAmtDeemAlimonyOutsideHh(latestFceEligOfLatestFceApp.getAmtDeemAlimonyOutsideHh());
        currentFceElig.setAmtDeemTaxDependOutHh(latestFceEligOfLatestFceApp.getAmtDeemTaxDependOutHh());
      }else{
        currentFceElig.setCdAllocType(null);
        currentFceElig.setPersonAllocSngl1(null);
        currentFceElig.setNbrIneligSpouseAllocSngl1(null);
        currentFceElig.setNbrIneligChildAllocSngl1(null);
        
        currentFceElig.setPersonAllocSngl2(null);
        currentFceElig.setNbrIneligSpouseAllocSngl2(null);
        currentFceElig.setNbrIneligChildAllocSngl2(null);

        currentFceElig.setPersonAllocMutual1(null);
        currentFceElig.setPersonAllocMutual2(null);
        currentFceElig.setNbrIneligSpouseAllocMutual(null);
        currentFceElig.setNbrIneligChildAllocMutual(null);
        
        currentFceElig.setCdDeemRespType(null);
        currentFceElig.setPersonDeemIndiv1(null);
        currentFceElig.setCdDeemIndivRel1(null);
        currentFceElig.setPersonDeemIndiv2(null);
        currentFceElig.setCdDeemIndivRel2(null);
        currentFceElig.setNbrDeemChildNotInAU(null);
        currentFceElig.setNbrDeemTaxDependNotInAU(null);
        currentFceElig.setNbrDeemResponseIndiv(null);
        currentFceElig.setAmtDeemAlimonyOutsideHh(null);
        currentFceElig.setAmtDeemTaxDependOutHh(null);
      }
    }else{ // Else set the below values using the eligibilty of the latest application
      currentFceElig.setNbrCertifiedGroup(latestFceElig.getNbrCertifiedGroup());
      currentFceElig.setIndChildCare(latestFceElig.getIndChildCare());
      currentFceElig.setIndOutHomeCare(latestFceElig.getIndOutHomeCare());
      currentFceElig.setIndEmancipation(latestFceElig.getIndEmancipation());
      currentFceElig.setIndAdoption(latestFceElig.getIndAdoption());
      currentFceElig.setIndPayForCare(latestFceElig.getIndPayForCare());
      currentFceElig.setNbrStepparentChildren(latestFceElig.getNbrStepparentChildren());
      currentFceElig.setAmtStepparentAlimony(latestFceElig.getAmtStepparentAlimony());
      currentFceElig.setAmtStepparentOutsidePmnt(latestFceElig.getAmtStepparentOutsidePmnt());
      
      // For amended app prefill allocation/deeming, otherwise clear
      if( CD_INITIAL_APP.equals(currentFceApplication.getCdApplication())){
        currentFceElig.setCdAllocType(latestFceElig.getCdAllocType());
        currentFceElig.setPersonAllocSngl1(latestFceElig.getPersonAllocSngl1());
        currentFceElig.setNbrIneligSpouseAllocSngl1(latestFceElig.getNbrIneligSpouseAllocSngl1());
        currentFceElig.setNbrIneligChildAllocSngl1(latestFceElig.getNbrIneligChildAllocSngl1());
        
        currentFceElig.setPersonAllocSngl2(latestFceElig.getPersonAllocSngl2());
        currentFceElig.setNbrIneligSpouseAllocSngl2(latestFceElig.getNbrIneligSpouseAllocSngl2());
        currentFceElig.setNbrIneligChildAllocSngl2(latestFceElig.getNbrIneligChildAllocSngl2());

        currentFceElig.setPersonAllocMutual1(latestFceElig.getPersonAllocMutual1());
        currentFceElig.setPersonAllocMutual2(latestFceElig.getPersonAllocMutual2());
        currentFceElig.setNbrIneligSpouseAllocMutual(latestFceElig.getNbrIneligSpouseAllocMutual());
        currentFceElig.setNbrIneligChildAllocMutual(latestFceElig.getNbrIneligChildAllocMutual());
        
        currentFceElig.setCdDeemRespType(latestFceElig.getCdDeemRespType());
        currentFceElig.setPersonDeemIndiv1(latestFceElig.getPersonDeemIndiv1());
        currentFceElig.setCdDeemIndivRel1(latestFceElig.getCdDeemIndivRel1());
        currentFceElig.setPersonDeemIndiv2(latestFceElig.getPersonDeemIndiv2());
        currentFceElig.setCdDeemIndivRel2(latestFceElig.getCdDeemIndivRel2());
        currentFceElig.setNbrDeemChildNotInAU(latestFceElig.getNbrDeemChildNotInAU());
        currentFceElig.setNbrDeemTaxDependNotInAU(latestFceElig.getNbrDeemTaxDependNotInAU());
        currentFceElig.setNbrDeemResponseIndiv(latestFceElig.getNbrDeemResponseIndiv());
        currentFceElig.setAmtDeemAlimonyOutsideHh(latestFceElig.getAmtDeemAlimonyOutsideHh());
        currentFceElig.setAmtDeemTaxDependOutHh(latestFceElig.getAmtDeemTaxDependOutHh());
      }else{
        currentFceElig.setCdAllocType(null);
        currentFceElig.setPersonAllocSngl1(null);
        currentFceElig.setNbrIneligSpouseAllocSngl1(null);
        currentFceElig.setNbrIneligChildAllocSngl1(null);
        
        currentFceElig.setPersonAllocSngl2(null);
        currentFceElig.setNbrIneligSpouseAllocSngl2(null);
        currentFceElig.setNbrIneligChildAllocSngl2(null);

        currentFceElig.setPersonAllocMutual1(null);
        currentFceElig.setPersonAllocMutual2(null);
        currentFceElig.setNbrIneligSpouseAllocMutual(null);
        currentFceElig.setNbrIneligChildAllocMutual(null);
        
        currentFceElig.setCdDeemRespType(null);
        currentFceElig.setPersonDeemIndiv1(null);
        currentFceElig.setCdDeemIndivRel1(null);
        currentFceElig.setPersonDeemIndiv2(null);
        currentFceElig.setCdDeemIndivRel2(null);
        currentFceElig.setNbrDeemChildNotInAU(null);
        currentFceElig.setNbrDeemTaxDependNotInAU(null);
        currentFceElig.setNbrDeemResponseIndiv(null);
        currentFceElig.setAmtDeemAlimonyOutsideHh(null);
        currentFceElig.setAmtDeemTaxDependOutHh(null);
      }
    }
    currentFceApplication.setIndProofAgeSentEs(latestFceApplication.getIndProofAgeSentEs());
    currentFceApplication.setDtProofAgeSentEs(latestFceApplication.getDtProofAgeSentEs());
    currentFceApplication.setTxtProofAgeSentEs(latestFceApplication.getTxtProofAgeSentEs());
    currentFceApplication.setIndProofCitizenshipSentEs(latestFceApplication.getIndProofCitizenshipSentEs());
    currentFceApplication.setDtProofCitizenshipSentEs(latestFceApplication.getDtProofCitizenshipSentEs());
    currentFceApplication.setTxtProofCitizenshipSentEs(latestFceApplication.getTxtProofCitizenshipSentEs());
    currentFceApplication.setIndProofChildIdSentEs(latestFceApplication.getIndProofChildIdSentEs());
    currentFceApplication.setDtProofChildIdSentEs(latestFceApplication.getDtProofChildIdSentEs());
    currentFceApplication.setTxtProofChildIdSentEs(latestFceApplication.getTxtProofChildIdSentEs());
    currentFceApplication.setIndLegalDocsSentEs(latestFceApplication.getIndLegalDocsSentEs());
    currentFceApplication.setTxtLegalDocsSentEs(latestFceApplication.getTxtLegalDocsSentEs());
    currentFceApplication.setDtLegalDocsSentEs(latestFceApplication.getDtLegalDocsSentEs());
    currentFceApplication.setIndProofPregnancySentEs(latestFceApplication.getIndProofPregnancySentEs());
    currentFceApplication.setDtProofPregnancySentEs(latestFceApplication.getDtProofPregnancySentEs());
    currentFceApplication.setTxtProofPregnancySentEs(latestFceApplication.getTxtProofPregnancySentEs());
    currentFceApplication.setIndChildSupportOrder(latestFceApplication.getIndChildSupportOrder());
    
    // Prefill Income/Resource for Child section
    prefillIncomeAndResourcesForChild(currentIncomeAndResources, latestIncomeAndResources);
    
    // Prefill Income for Family section
    List<FceIncome> currentIncomeForFamily= currentIncomeAndResources.get("currentIncomeForFamily");
    if (currentIncomeForFamily != null && currentIncomeForFamily.size() > 0){
      for (int i = 0; i < currentIncomeForFamily.size(); i++) {
        FceIncome currentIncome = currentIncomeForFamily.get(i);
        List<FceIncome> latestIncomeForFamily = latestIncomeAndResources.get("latestIncomeForFamily");
        if (latestIncomeForFamily != null && latestIncomeForFamily.size() > 0){
          FceIncome latestIncome = new FceIncome();
          boolean foundIncome = false;
          for (int x = 0; x < latestIncomeForFamily.size(); x++) {
            latestIncome = latestIncomeForFamily.get(x);
            if (currentIncome.getIndIncomeSource().equals(latestIncome.getIndIncomeSource()) && 
                currentIncome.getPerson().getIdPerson() == latestIncome.getPerson().getIdPerson() &&
                currentIncome.getIdIncRsrc().equals(latestIncome.getIdIncRsrc())){
              foundIncome = true;
              break;
            }
          }
          if (foundIncome){
            currentIncome.setIndNone(latestIncome.getIndNone());
            currentIncome.setIndEarned(latestIncome.getIndEarned());
            currentIncome.setIndCountable(latestIncome.getIndCountable());
            fceIncomeDAO.saveFceIncome(currentIncome);
          }
        }
      }
    }
    
    // Prefill Resources For Family section
    List<FceIncome> currentResourceForFamily = currentIncomeAndResources.get("currentResourceForFamily");
    if (currentResourceForFamily != null && currentResourceForFamily.size() > 0){
      for (int i = 0; i < currentResourceForFamily.size(); i++) {
        FceIncome currentResource = currentResourceForFamily.get(i);
        List<FceIncome> latestResourceForFamily = latestIncomeAndResources.get("latestResourceForFamily");
        if (latestResourceForFamily != null && latestResourceForFamily.size() > 0){
          FceIncome latestResource = new FceIncome();
          boolean foundResource = false;
          for (int x = 0; x < latestResourceForFamily.size(); x++) {
            latestResource = latestResourceForFamily.get(x);
            if (currentResource.getIndIncomeSource().equals(latestResource.getIndIncomeSource()) && 
                currentResource.getPerson().getIdPerson() == latestResource.getPerson().getIdPerson() &&
                currentResource.getIdIncRsrc().equals(latestResource.getIdIncRsrc())){
              foundResource = true;
              break;
            }
          }
          if (foundResource){
            currentResource.setIndNotAccessible(latestResource.getIndNotAccessible());
            currentResource.setIndCountable(latestResource.getIndCountable());
            fceIncomeDAO.saveFceIncome(currentResource);
          }
        }
      }
    }
    
    // Prefill expenditures section
    if ((latestFceExpenditures != null && latestFceExpenditures.size() > 0) && (currentFceExpenditures == null || currentFceExpenditures.size() == 0)){
      FceExpenditures latestFceExpenditure = new FceExpenditures();
      for (int x = 0; x < latestFceExpenditures.size(); x++) {
        latestFceExpenditure = latestFceExpenditures.get(x);
        FceExpenditures currentFceExpenditure = new FceExpenditures();
        currentFceExpenditure.setFceEligibility(currentFceElig);
        FcePerson fcePerson = (FcePerson) getPersistentObject(FcePerson.class, latestFceExpenditure.getFcePerson().getIdFcePerson());
        currentFceExpenditure.setFcePerson(fcePerson);
        Person person = (Person) getPersistentObject(Person.class, latestFceExpenditure.getPerson().getIdPerson());
        currentFceExpenditure.setPerson(person);
        Person careReceiver = (Person) getPersistentObject(Person.class, latestFceExpenditure.getPersonCareReceive().getIdPerson());
        currentFceExpenditure.setPersonCareReceive(careReceiver);
        currentFceExpenditure.setNmServiceProvider(latestFceExpenditure.getNmServiceProvider());
        currentFceExpenditure.setAmtPdMonthly(latestFceExpenditure.getAmtPdMonthly());
        fceExpendituresDAO.saveFceExpenditures(currentFceExpenditure);
      }
    }
  }
  
  private void prefillIncomeAndResourcesForChild(Map<String, List<FceIncome>> currentIncomeAndResources,
                                     Map<String, List<FceIncome>> latestIncomeAndResources){
    // Prefill Income for Child section
    List<FceIncome> currentIncomeForChild = currentIncomeAndResources.get("currentIncomeForChild");
    if (currentIncomeForChild != null && currentIncomeForChild.size() > 0){
      for (int i = 0; i < currentIncomeForChild.size(); i++) {
        FceIncome currentIncome = currentIncomeForChild.get(i);
        List<FceIncome> latestIncomeForChild = latestIncomeAndResources.get("latestIncomeForChild");
        if (latestIncomeForChild != null && latestIncomeForChild.size() > 0){
          FceIncome latestIncome = new FceIncome();
          boolean foundIncome = false;
          for (int x = 0; x < latestIncomeForChild.size(); x++) {
            latestIncome = latestIncomeForChild.get(x);
            if (currentIncome.getIndIncomeSource().equals(latestIncome.getIndIncomeSource()) && 
                currentIncome.getPerson().getIdPerson() == latestIncome.getPerson().getIdPerson() &&
                currentIncome.getIdIncRsrc().equals(latestIncome.getIdIncRsrc())){
              foundIncome = true;
              break;
            }
          }
          if (foundIncome){
            currentIncome.setIndNone(latestIncome.getIndNone());
            currentIncome.setIndEarned(latestIncome.getIndEarned());
            currentIncome.setIndCountable(latestIncome.getIndCountable());
            fceIncomeDAO.saveFceIncome(currentIncome);
          }
        }
      }
    }
    
    // Prefill Resources For Child section
    List<FceIncome> currentResourceForChild = currentIncomeAndResources.get("currentResourceForChild");
    if (currentResourceForChild != null && currentResourceForChild.size() > 0){
      for (int i = 0; i < currentResourceForChild.size(); i++) {
        FceIncome currentResource = currentResourceForChild.get(i);
        List<FceIncome> latestResourceForChild = latestIncomeAndResources.get("latestResourceForChild");
        if (latestResourceForChild != null && latestResourceForChild.size() > 0){
          FceIncome latestResource = new FceIncome();
          boolean foundResource = false;
          for (int x = 0; x < latestResourceForChild.size(); x++) {
            latestResource = latestResourceForChild.get(x);
            if (currentResource.getIndIncomeSource().equals(latestResource.getIndIncomeSource()) && 
                currentResource.getPerson().getIdPerson() == latestResource.getPerson().getIdPerson() &&
                currentResource.getIdIncRsrc().equals(latestResource.getIdIncRsrc())){
              foundResource = true;
              break;
            }
          }
          if (foundResource){
            currentResource.setIndNotAccessible(latestResource.getIndNotAccessible());
            currentResource.setIndCountable(latestResource.getIndCountable());
            fceIncomeDAO.saveFceIncome(currentResource);
          }
        }
      }
    }
  }
  
  private void prefillFceRedetermination(FceReview currentFceReview, FceReview latestFceReview){
   //  Prefill Foster Care Redetermination page
// Should not prefill these two following fields to new event
//    currentFceReview.setIndReviewInappropriate(latestFceReview.getIndReviewInappropriate());
//    currentFceReview.setTxtInappropriateComments(latestFceReview.getTxtInappropriateComments());
    currentFceReview.setIndSavingsAcct(latestFceReview.getIndSavingsAcct());
    currentFceReview.setCdChangeCtznStatus(latestFceReview.getCdChangeCtznStatus());  
    currentFceReview.setIndChildCareCourtOrder(latestFceReview.getIndChildCareCourtOrder());
    currentFceReview.setIndPermanencyHearings(latestFceReview.getIndPermanencyHearings());
    currentFceReview.setIndPrmncyHearingsDue(latestFceReview.getIndPrmncyHearingsDue());
    currentFceReview.setIndPrmncyHrngs12Month(latestFceReview.getIndPrmncyHrngs12Month());
    currentFceReview.setIndBestInterestLang(latestFceReview.getIndBestInterestLang());
    currentFceReview.setIndResnablEfrtPrvntRmval(latestFceReview.getIndResnablEfrtPrvntRmval());
    currentFceReview.setIndResnablEfrtReunify(latestFceReview.getIndResnablEfrtReunify());
    currentFceReview.setDtCourtOrder(latestFceReview.getDtCourtOrder());
    currentFceReview.setDtPrmncyHrngs12Month(latestFceReview.getDtPrmncyHrngs12Month());
    currentFceReview.setDtBestInterestLang(latestFceReview.getDtBestInterestLang());
    currentFceReview.setDtResnablEfrtPrvntRmval(latestFceReview.getDtResnablEfrtPrvntRmval());
    currentFceReview.setDtResnablEfrtRenuify(latestFceReview.getDtResnablEfrtRenuify());
    currentFceReview.setIndExtnsionProvided12Mnths(latestFceReview.getIndExtnsionProvided12Mnths());
    currentFceReview.setDtExtnsionProvided12Mnths(latestFceReview.getDtExtnsionProvided12Mnths());
  }
  
  private void prefillWorksheetJudicialSection (FceEligibility currentFceElig, FceEligibility latestFceElig){
    currentFceElig.setIndRemovalChildOrdered(latestFceElig.getIndRemovalChildOrdered());
    currentFceElig.setDtRemovalChildOrdered(latestFceElig.getDtRemovalChildOrdered());
    currentFceElig.setIndRsnblEffortPrvtRemoval(latestFceElig.getIndRsnblEffortPrvtRemoval());
    currentFceElig.setDtRsnblEffortPreventRem(latestFceElig.getDtRsnblEffortPreventRem());
    currentFceElig.setIndPrsManagingCvs(latestFceElig.getIndPrsManagingCvs());
  }
 }