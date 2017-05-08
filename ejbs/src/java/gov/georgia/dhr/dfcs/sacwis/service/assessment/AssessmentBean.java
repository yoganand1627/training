/**
 * Created on Jun 28, 2006 at 12:56:56 AM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.service.assessment;

import java.util.List;
import java.util.Map;

import javax.ejb.CreateException;

import gov.georgia.dhr.dfcs.sacwis.core.spring.BaseSpringStatelessSessionBean;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV02SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV36SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV51SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV54SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV55SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SafetyAssessmentDeleteSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SafetyAssessmentRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SafetyAssessmentSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SafetyResourceSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SafetyPlanRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SafetyPlanSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV02SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV36SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV51SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV54SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV55SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SafetyAssessmentRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SafetyResourceRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SafetyResourceRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SafetyPlanRetrieveSO;

/**
 * <pre>
 *          Change History:
 *           Date      User              Description
 *           --------  ----------------  --------------------------------------------------
 *           02/10/2010  wjcochran       SMS #44832 - Add new service to retrieve all
 *                                       principals without a value for "Member in Primary
 *                                       Caretaker's Household" -
 *                                       retrieveAllPrincipalsWithNullInPKHshld.
 * </pre>
 */                                       
public class AssessmentBean extends BaseSpringStatelessSessionBean implements Assessment {

  private DeleteSafetyAssessment deleteSafetyAssessment;

  private RetrieveIsDrugExposedNewborn retrieveIsDrugExposedNewborn;

  private RetrievePrincipalsForRiskAssessment retrievePrincipalsForRiskAssessment;

  private RetrievePrincipals retrievePrincipals;
  
  private RetrievePrincipals retrieveAllPrincipals;
  
  private RetrieveRiskFactors retrieveRiskFactors;

  private RetrieveSafetyAssessment retrieveSafetyAssessment;

  private RetrieveServicesReferralsChecklist retrieveServicesReferralsChecklist;

  private SaveSafetyAssessment saveSafetyAssessment;

  private SaveServicesAndReferrals saveServicesAndReferrals;

  private RetrieveSafetyPlan retrieveSafetyPlan;

  private SaveSafetyPlan saveSafetyPlan;
   
  public CINV36SO retrievePrincipalsForRiskAssessment(CINV36SI cinv36si) {
    return retrievePrincipalsForRiskAssessment.retrievePrincipalsForRiskAssessment(cinv36si);
  }

  public CINV36SO retrievePrincipals(CINV36SI cinv36si) {
    return retrievePrincipals.retrievePrincipals(cinv36si);
  }
  
  public List<Map> retrieveAllPrincipals(int idStage,String type) {
    return retrievePrincipals.retrieveAllPrincipals(idStage, type);
  }

  public CINV51SO retrieveRiskFactors(CINV51SI cinv51si) {
    return retrieveRiskFactors.retrieveRiskFactors(cinv51si);
  }

  public SafetyAssessmentRetrieveSO retrieveSafetyAssessment(SafetyAssessmentRetrieveSI safetyAssessmentRetrieveSI) {
    return retrieveSafetyAssessment.retrieveSafetyAssessment(safetyAssessmentRetrieveSI);
  }

  public int deleteSafetyAssessment(SafetyAssessmentDeleteSI deleteSI) {
    return deleteSafetyAssessment.deleteSafetyAssessment(deleteSI);
  }

  public CINV54SO retrieveServicesReferralsChecklist(CINV54SI cinv54si) {
    return retrieveServicesReferralsChecklist.retrieveServicesReferralsChecklist(cinv54si);
  }

  public int saveSafetyAssessment(SafetyAssessmentRetrieveSO safetyAssessmentRetrieveSO, SafetyAssessmentSaveSI safetyAssessmentSaveSI) {
    return saveSafetyAssessment.saveSafetyAssessment(safetyAssessmentRetrieveSO, safetyAssessmentSaveSI);
  }

  public CINV55SO saveServicesAndReferralsInformation(CINV55SI cinv55si) {
    return saveServicesAndReferrals.saveServicesAndReferralsInformation(cinv55si);
  }

  public boolean isDrugExposedNewborn(int idStage) {
    return retrieveIsDrugExposedNewborn.isDrugExposedNewborn(idStage);
  }

  public SafetyPlanRetrieveSO retrieveSafetyPlan(SafetyPlanRetrieveSI safetyPlaneRetrieveSI) {

    return retrieveSafetyPlan.retrieveSafetyPlan(safetyPlaneRetrieveSI);
  }

  public int saveSafetyPlan(SafetyPlanSaveSI safetyPlanSaveSI) {

    return saveSafetyPlan.saveSafetyPlan(safetyPlanSaveSI);
  }
  public int deleteSafetyPlan(SafetyPlanSaveSI safetyPlanSaveSI) {

    return saveSafetyPlan.deleteSafetyPlan(safetyPlanSaveSI);
  }
 
  public List<Map> retrieveAllPrincipalsWithNullInPKHshld(int idStage, String type) {
    return retrievePrincipals.retrieveAllPrincipalsWithNullInPKHshld(idStage, type);
  }

  protected void onEjbCreate() throws CreateException {
    deleteSafetyAssessment = getService(DeleteSafetyAssessment.class);
    retrievePrincipalsForRiskAssessment = getService(RetrievePrincipalsForRiskAssessment.class);
    retrievePrincipals = getService(RetrievePrincipals.class);
    retrieveAllPrincipals = getService(RetrievePrincipals.class);
    retrieveRiskFactors = getService(RetrieveRiskFactors.class);
    retrieveSafetyAssessment = getService(RetrieveSafetyAssessment.class);
    retrieveServicesReferralsChecklist = getService(RetrieveServicesReferralsChecklist.class);
    saveSafetyAssessment = getService(SaveSafetyAssessment.class);
    saveServicesAndReferrals = getService(SaveServicesAndReferrals.class);
    retrieveIsDrugExposedNewborn = getService(RetrieveIsDrugExposedNewborn.class);
    retrieveSafetyPlan = getService(RetrieveSafetyPlan.class);
    saveSafetyPlan = getService(SaveSafetyPlan.class);
    
  }

}