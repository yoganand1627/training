package gov.georgia.dhr.dfcs.sacwis.service.admin.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.AaFundingDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.AaFundingReasonEligDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.AdoNewNameDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.AdoptionSubsidyDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.AdptSubEventLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ApprovalDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ApprovalEventLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ApproversDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsCaseDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsResourceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CharacteristicsDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ClientOutboundDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.DynamicEventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EligibilityDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventPersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ExchangeChildDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.IncomeAndResourcesDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.LegalStatusDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.MedicationDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.NameDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonCitizenshipDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDtlDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonEthnicityDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonRaceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PlacementDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ServiceAuthorizationDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SituationDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SpecialNeedsDeterminationDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SvcAuthDetailDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SvcAuthEventLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.TodoDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.UnitEmpLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.AaFunding;
import gov.georgia.dhr.dfcs.sacwis.db.AaFundingReasonElig;
import gov.georgia.dhr.dfcs.sacwis.db.AdoptionSubsidy;
import gov.georgia.dhr.dfcs.sacwis.db.AdptSubEventLink;
import gov.georgia.dhr.dfcs.sacwis.db.Approval;
import gov.georgia.dhr.dfcs.sacwis.db.Approvers;
import gov.georgia.dhr.dfcs.sacwis.db.CapsCase;
import gov.georgia.dhr.dfcs.sacwis.db.CapsResource;
import gov.georgia.dhr.dfcs.sacwis.db.Characteristics;
import gov.georgia.dhr.dfcs.sacwis.db.ClientOutbound;
import gov.georgia.dhr.dfcs.sacwis.db.Contract;
import gov.georgia.dhr.dfcs.sacwis.db.Eligibility;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.EventPersonLink;
import gov.georgia.dhr.dfcs.sacwis.db.ExchangeChild;
import gov.georgia.dhr.dfcs.sacwis.db.IncomeAndResources;
import gov.georgia.dhr.dfcs.sacwis.db.LegalStatus;
import gov.georgia.dhr.dfcs.sacwis.db.Medication;
import gov.georgia.dhr.dfcs.sacwis.db.Name;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.PersonCitizenship;
import gov.georgia.dhr.dfcs.sacwis.db.PersonDtl;
import gov.georgia.dhr.dfcs.sacwis.db.PersonEthnicity;
import gov.georgia.dhr.dfcs.sacwis.db.PersonRace;
import gov.georgia.dhr.dfcs.sacwis.db.Placement;
import gov.georgia.dhr.dfcs.sacwis.db.ServiceAuthorization;
import gov.georgia.dhr.dfcs.sacwis.db.Situation;
import gov.georgia.dhr.dfcs.sacwis.db.SpecialNeedsDetermination;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.db.StageLink;
import gov.georgia.dhr.dfcs.sacwis.db.StagePersonLink;
import gov.georgia.dhr.dfcs.sacwis.db.SvcAuthDetail;
import gov.georgia.dhr.dfcs.sacwis.db.SvcAuthEventLink;
import gov.georgia.dhr.dfcs.sacwis.db.Todo;
import gov.georgia.dhr.dfcs.sacwis.db.Unit;
import gov.georgia.dhr.dfcs.sacwis.db.UnitEmpLink;
import gov.georgia.dhr.dfcs.sacwis.service.admin.CloseStageCase;
import gov.georgia.dhr.dfcs.sacwis.service.admin.SaveAdoFinalized;
import gov.georgia.dhr.dfcs.sacwis.service.common.CheckIfUserHasRight;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN02UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN02UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB68SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB68SO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * This is the Service that creates a new PAD Case to the Database. <p/> <p/>
 * 
 * <pre>
 *   Change History:
 *   Date      User           Description
 *   --------  --------       --------------------------------------------------
 *   11/03/08  vdevarak       STGAP00010749 - When an approval of the closure event for an Adoption stage with reason
 *                                            Adoption Finalized, is being saved, this service called to:  
 *                                            1. Create new person record for the child with new name and corresponding 
 *                                               Race, Ethnicity, Characteristics,Income and Resources, and Medication records
 *                                            2. Mark the ADO stage and the corresponding FCC stage as sealed. 
 *                                            3. Mark any other open stages in the case as sensitive.
 *                                            4. Create a new case and a PAD stage in it for the child and mark the case as sensitive.
 *                                            5. Copy the current Placement, Adoption Assistance and Adoption Assistance Agreement 
 *                                            records to the new PAD stage with the new person Id. 
 *                                            6. End date or close all the current Placement, Adoption Assistance and Adoption 
 *                                               Assistance Agreement records in the ADO stage. 
 *                                            7. Copy the Eligibility Summary records from the FCC stage to PAD stage. 
 *                                            8. Close all the active Eligibility Summary records in the FCC stage. 
 *                                            9. The FAD stage of the Adoptive Resource is marked SAU Sealed.
 *   12/11/08  wjcochran      STGAP00011529 - Modified to use the new person ID in registerWithSMILE method 
 *   01/12/09  mchillman      STGAP00011820 - Code was coping the correct adoption agreement over
 *   01/30/09  wjcochran      STGAP00012065 - Set the indStagePersEmpNew flag when creating a new StagePersonLink
 *   02/10/09  hjbaptiste     STGAP00012390 - Modified markAdoAndFccStagesSealed() to mark Adoptive child's entire pre-Adoptive case Sensitive.
 *   02/26/09  hjbaptiste     STGAP00012521 - Modified copyAdoptionAssistanceAgreementRecord(), copyAdoptionAssistanceRecordFromAdoStage()to copy 
 *                                            any open (non-expired, ended or terminated) Adoption Assistance Agreements, along with their associated
 *                                            Adoption Assistance Application records to the PAD stage and all other open Adoption Assistance 
 *                                            Application records that do not have an associated Agreement
 *   03/02/09  hjbaptiste     STGAP00012681 - Modified updateExchangeChild() to check to see if the ExchangeChildDetail Event object returned by the 
 *                                            exchangeChildDAO call is null. Rearranged the code. 
 *   03/05/09  arege          STGAP00012658 - Modified copyAdoptionAssistanceAgreementRecord method to display correct Event Description on 
 *                                            Adoption Assistance Agreement List page in PAD stage.
 *   03/09/09  hjbaptiste     STGAP00011821 - Modified copyAdoptionAssistanceRecordFromAdoStage() to call endDateAdoAsstApplication() to comment and
 *                                            set the expiration date of the ADO Adoption Assistance Application to today's date
 *   03/18/09  hjbaptiste     STGAP00012681 - Modified updateExchangeChild() to throw SQL_NOT_FOUND since check for Exchange Child registration
 *                                            has been moved to StageClosureEditChecksImpl.  
 *   04/22/09  cwells         STGAP00009847 - Removing references to AFCAR widgets in the newPlcmtRecord object.  Since those sections
 *                                            Are being removed from the page.
 *   06/01/09  hjbaptiste     STGAP00012521 - Since Agreements are no longer being approved and are only set to COMP status, modified the call to the 
 *                                            adptSubEventLinkDAO to call on the modified name of the method call to find the completed agreements.
 *                                            Modified populate_newAdoption_Assistance() by adding missing fields to copy from old application to new application                                           
 *   06/03/09  hjbaptiste     STGAP00013089 - Copy the old Adoption Subsidy event description to the Adoptions Assistance Agreement list page of the new PAD stage.
 *   06/10/09  hjbaptiste     STGAP00012521 - Change the new Agreement event status to COMP since Agreements are no longer being approved and are only set to COMP status
 *   06/10/09  bgehlot        STGAP00014187:  Removed end date from the event description. Also Removed the copy of reason to the new Eligibility as it's not end dated                                                                                                                                                                   
 *   06/16/09  bgehlot        STGAP00014279: Insert the citizenship status , citizenship and age verification records for the new person record that is inserted
 *   06/17/09  bgehlot        STGAP00014345: Start Date in the PAD stage should continue to display the Start Date from the FCC stage
 *   07/20/09  eudofiah       STGAP00014523 - Modified saveAdoFinalized() to truncate the newFullName field into 25 characters.
 *   07/31/09  bgehlot        STGAP00014952: Copy over the new fields added to the adoption application to the PAD stage 
 *   08/01/09  bgehlot        STGAP00014279 :Copy other fields from citizenship identity page
 *   1/29/10   cwells         SMS44140:      Adding newly created person name to the Carried over 512 Services 
 *   02/03/2010 arege         SMS#44138: Modified method copyAdoptionAssistanceRecordFromAdoStage to copy over event descr for approved Ado Assist Application
 *   02/04/10  bgehlot        SMS#44783: MR-60 Changes, Pre Post radio buttons added.
 *   02/12/2010 arege         SMS#45290  Event description for AdoAssitApp copied to PAD should display the idPerson of new person
 *   02/15/2010  mxpatel      SMS #45289: Modified the code to update the event description with the new Person name (not pre-adoptive name).
 *   02/15/2010 mxpatel       SMS #45427: Modified the code to make sure new idSpecialNeedsDeter is copied over to the service auth details when progressing to 
 *                            PAD stage.
 *   02/15/2010  mxpatel      SMS #45427: Modified the code to make sure that event description for AdoAssitAgreement copied to PAD should display the idPerson of new person
 *   03/18/2010  cwells       SMS #45415 Coping most recently created & approved eligibility regardless of stage closure status
 *   05/03/2010  arege        SMS#49588 stage region did not align with stage county as the stage county for PAD stages 
 *                             
 * database
 *   05/11/2010  mxpatel      SMS #52233: Modified the code to populate the sealed date of FAD stage with the most recent Legal Status od Adoption Finalized 
 *                            Effective Date value of any child placed in the home at the time their ADO stage was closed with a reason of adoption finalized.
 *  08/05/2010   bgehlot      SMS #65398 MR-041: SHINES Person Id of the existing, pre-adoptive child need to be saved in CLIENT_OUTBOUND table.
 *  10/06/2011   hgnuyen      STGAP00017011: MR-092 Added new logic to copy over latest approved AA Funding Summary for adoption finalization stage progression.
 *  11/09/2011   hnguyen      STGAP00017622: MR-092 Updated call to AAFundingDAO.findLatestValidatedAAFundingByIdChildByIdStage query 
 * </pre>
 */

public class SaveAdoFinalizedImpl extends BaseServiceImpl implements SaveAdoFinalized {
  public static final String TARGET_SYSTEM_SMILE = "SML";

  public static final String NEW = "NEW";

  public static final String NEW_SMILE_CLIENT = "Y";

  public static final String CD_SMILE_CLIENT = "REG";

  public static final String SUB_ADO_FSU_EVENT_TYPE = CodesTables.CEVNTTYP_CCL;
  
  public static final String SPC_SER_SVC_PROG_CAT = CodesTables.CPRGCOD1_512;
  
  public static final String SPC_SER_SVC_PROG_CAT_SQL = SPC_SER_SVC_PROG_CAT + "%";
  
  public static final String FSU_EVENT_DESC = "Foster Care Family stage has been closed";

  public static final String SUB_EVENT_DESC = "Foster Care Child stage has been closed";

  public static final String ADO_EVENT_DESC = "Adoption stage has been closed";
  
  public static final String SVC_AUTH_DTL_COMMENT = "Adoption Finalized- Automatic System Closure.";

  public static final String CLOSE_SUBCARE_STAGE = "3270"; // SUB

  public static final String CLOSE_ADOPTION_STAGE = "8770"; // ADO

  public static final String CLOSE_FAMILY_SUBCARE_STAGE = "4110"; // FSU

  public static final String FSU_SVC_AUTH = "4190";
  

  public static final String STAGE_FSU = CodesTables.CSTAGES_FSU;

  public static final String STAGE_SUB = CodesTables.CSTAGES_SUB;

  public static final String STAGE_ADO = CodesTables.CSTAGES_ADO;

  public static final String STAGE_PAD = CodesTables.CSTAGES_PAD;

  public static final String CD_CASE_PROGRAM = CodesTables.CPGRMS_CPS;

  public static final String EVENT_STATUS = CodesTables.CEVTSTAT_APRV;
  
  public static final String AGREEMENT_EVENT_STATUS = CodesTables.CEVTSTAT_COMP;

  public static final String APP_EVENT_TYPE = CodesTables.CEVNTTYP_APP;

  public static final String APP_EVENT_STATUS = CodesTables.CEVTSTAT_COMP;

  public static final String PAD_PLCMT_TASK = "9080"; // PAD

  public static final String ADO_ASST_APPLICATION_TASK = "9100"; // PAD
  
  public static final String ADO_SVC_AUTH_TASK = "9020"; // PAD
  
  public static final String ADO_ASST_AGREEMENT_TASK = "9105"; // PAD

  public static final String ADO_ASST_APPLICATION_APP_TASK = "8352"; // PAD

  public static final String ADO_ASST_AGREEMENT_APP_TASK = "9106"; // PAD = "9106"

  public static final String PAD_PLCMT_APP_TASK = "9090"; // PAD

  public static final String ELIGIBILITY_TASK = "9110"; // PAD

  public static final String OPEN_PAD_TASK = "9999"; // PAD

  public static final String NON_CRSR = "01";

  public static final String PAD_AA_FUNDING_TASK = "9103"; // -- PAD, AA Funding Summary

  private static final String SEC_REG_FAM_INDP_STF = "76";

  private static final String SEC_REG_FAM_INDP_MGMNT_STF = "77";
  
  private PersonDAO personDAO = null;

  private StagePersonLinkDAO stagePersonLinkDAO = null;

  private PersonDtlDAO personDtlDAO = null;

  private PersonEthnicityDAO personEthnicityDAO = null;

  private PersonRaceDAO personRaceDAO = null;

  private IncomeAndResourcesDAO incomeAndResourcesDAO = null;

  private CharacteristicsDAO characteristicsDAO = null;

  private MedicationDAO medicationDAO = null;

  private ClientOutboundDAO clientOutboundDAO = null;

  private StageDAO stageDAO = null;

  private PlacementDAO placementDAO = null;

  private AdoNewNameDAO adoNewNameDAO = null;

  private CapsCaseDAO capsCaseDAO = null;

  private EventDAO eventDAO = null;

  private EventPersonLinkDAO eventPersonLinkDAO = null;

  private ApprovalEventLinkDAO approvalEventLinkDAO = null;

  private ApprovalDAO approvalDAO = null;

  private ApproversDAO approversDAO = null;

  private StageLinkDAO stageLinkDAO = null;

  private UnitEmpLinkDAO unitEmpLinkDAO = null;

  private SituationDAO situationDAO = null;

  private SpecialNeedsDeterminationDAO specialNeedsDeterminationDAO = null;

  private AdoptionSubsidyDAO adoptionSubsidyDAO = null;

  private EligibilityDAO eligibilityDAO = null;

  private AdptSubEventLinkDAO adptSubEventLinkDAO = null;

  private NameDAO nameDAO = null;

  private DynamicEventDAO dynamicEventDAO = null;

  private ServiceAuthorizationDAO serviceAuthorizationDAO = null;

  private SvcAuthDetailDAO svcAuthDetailDAO = null;

  private SvcAuthEventLinkDAO svcAuthEventLinkDAO = null;

  private CloseStageCase closeStageCase = null;

  private CapsResourceDAO capsResourceDAO = null;

  private LegalStatusDAO legalStatusDAO = null;

  private ExchangeChildDAO exchangeChildDAO = null;
  
  private PersonCitizenshipDAO personCitizenshipDAO = null;

  private AaFundingDAO aaFundingDAO = null;
  
  private AaFundingReasonEligDAO aaFundingReasonEligDAO = null;
  
  private CheckIfUserHasRight checkIfUserHasRight = null;
  
  private TodoDAO todoDAO = null;

  public void setCloseStageCase(CloseStageCase closeStageCase) {
    this.closeStageCase = closeStageCase;
  }

  public void setSvcAuthEventLinkDAO(SvcAuthEventLinkDAO svcAuthEventLinkDAO) {
    this.svcAuthEventLinkDAO = svcAuthEventLinkDAO;
  }

  public void setServiceAuthorizationDAO(ServiceAuthorizationDAO serviceAuthorizationDAO) {
    this.serviceAuthorizationDAO = serviceAuthorizationDAO;
  }

  public void setSvcAuthDetailDAO(SvcAuthDetailDAO svcAuthDetailDAO) {
    this.svcAuthDetailDAO = svcAuthDetailDAO;
  }

  public void setDynamicEventDAO(DynamicEventDAO dynamicEventDAO) {
    this.dynamicEventDAO = dynamicEventDAO;
  }

  public void setNameDAO(NameDAO nameDAO) {
    this.nameDAO = nameDAO;
  }

  public void setAdptSubEventLinkDAO(AdptSubEventLinkDAO adptSubEventLinkDAO) {
    this.adptSubEventLinkDAO = adptSubEventLinkDAO;
  }

  public void setEligibilityDAO(EligibilityDAO eligibilityDAO) {
    this.eligibilityDAO = eligibilityDAO;
  }

  public void setSituationDAO(SituationDAO situationDAO) {
    this.situationDAO = situationDAO;
  }

  public void setAdoNewNameDAO(AdoNewNameDAO adoNewNameDAO) {
    this.adoNewNameDAO = adoNewNameDAO;
  }

  public void setPlacementDAO(PlacementDAO placementDAO) {
    this.placementDAO = placementDAO;
  }

  public StageDAO getStageDAO() {
    return stageDAO;
  }

  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }

  public CharacteristicsDAO getCharacteristicsDAO() {
    return characteristicsDAO;
  }

  public void setCharacteristicsDAO(CharacteristicsDAO characteristicsDAO) {
    this.characteristicsDAO = characteristicsDAO;
  }

  public PersonRaceDAO getPersonRaceDAO() {
    return personRaceDAO;
  }

  public void setPersonRaceDAO(PersonRaceDAO personRaceDAO) {
    this.personRaceDAO = personRaceDAO;
  }

  public IncomeAndResourcesDAO getIncomeAndResourcesDAO() {
    return incomeAndResourcesDAO;
  }

  public void setIncomeAndResourcesDAO(IncomeAndResourcesDAO incomeAndResourcesDAO) {
    this.incomeAndResourcesDAO = incomeAndResourcesDAO;
  }

  public PersonDAO getPersonDAO() {
    return personDAO;
  }

  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }
  
  public void setPersonCitizenshipDAO(PersonCitizenshipDAO personCitizenshipDAO) {
    this.personCitizenshipDAO = personCitizenshipDAO;
  }

  public void setAaFundingDAO(AaFundingDAO aaFundingDAO) {
    this.aaFundingDAO = aaFundingDAO;
  }

  public void setAaFundingReasonEligDAO(AaFundingReasonEligDAO aaFundingReasonEligDAO) {
    this.aaFundingReasonEligDAO = aaFundingReasonEligDAO;
  }

  public void setCheckIfUserHasRight(CheckIfUserHasRight checkIfUserHasRight) {
    this.checkIfUserHasRight = checkIfUserHasRight;
  }

  public void setTodoDAO(TodoDAO todoDAO) {
    this.todoDAO = todoDAO;
  }

  @SuppressWarnings( { "unchecked" })
  public CSUB68SO saveAdoFinalized(CSUB68SI csub68si) {
    CSUB68SO csub68so = new CSUB68SO();
    int idStage = csub68si.getROWCSUB68SIG01().getUlIdStage();
    int idCase = csub68si.getROWCSUB68SIG01().getUlIdCase();
    Integer oldPersonId = stagePersonLinkDAO.findIdPersonForChildByIdStage(idStage);
    Integer idPrimaryCaseWorker = stagePersonLinkDAO.findIdPersonByIdStageAndCdStagePersRole(idStage,
                                                                                             CodesTables.CROLEALL_PR);
    Person primaryCaseWorker = (Person) getPersistentObject(Person.class, idPrimaryCaseWorker);
    if (oldPersonId != null) {
      // Update the old person record by setting the indAdopted indicator to 'Y'.
      int nbrRowsUpdated = personDAO.updatePersonIndAdopted(oldPersonId);
      if (nbrRowsUpdated == 0) {
        throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
      }
      // Get new name entered for the child
      Map newNameMap = adoNewNameDAO.findNameByStage(idStage);
      String newFirstName = (String) newNameMap.get("nmPersonFirst");
      String newLastName = (String) newNameMap.get("nmPersonLast");
      String newMiddleName = (String) newNameMap.get("nmPersonMiddle");
      newFirstName = FormattingHelper.formatString(newFirstName);
      newLastName = FormattingHelper.formatString(newLastName);
      newMiddleName = FormattingHelper.formatString(newMiddleName);
      String newFullName = "";
      /*if (newLastName != null) {
        newFullName = newLastName;
      }
      if (newFirstName != null) {
         {
          newFullName = newFullName + "," + newFirstName;
        } else {
          newFullName = newFirstName;
        }
      }
      if (newMiddleName != null) {
        newFullName = newFullName + " " + newMiddleName;
        } else {
          newFullName = newMiddleName;
        }
      }*/
      //STGAP00014523
      newFullName = FormattingHelper.formatFullName(newFirstName, newMiddleName, newLastName);
      
     // Get the Adoption Finalized legal status record.
      LegalStatus legalStatus = legalStatusDAO
                                              .findMostRecentLegalStatusbyIdPersonAndLegalStatStatus(
                                                                                                     oldPersonId,
                                                                                                     CodesTables.CLEGSTAT_NAF);
      // Insert a new person record for the adopted child with the new name and get the new person Id
      int newPersonId = saveNewPerson(oldPersonId, newFirstName, newLastName, newMiddleName, newFullName);
      if (newPersonId != 0) {
        Person newPersCreated = (Person) getPersistentObject(Person.class, newPersonId);
        // Insert new name record
        saveNewName(newPersCreated, newFirstName, newLastName, newMiddleName);
        // Insert a corresponding person detail record for the new person record that is inserted
        saveNewpersonDtl(newPersonId, oldPersonId, newPersCreated);
        
        //STGAP00014279: Insert the citizenship and age verification records for the new person record that is inserted
        saveNewpersonCitizenShipMethodVerif(newPersonId, oldPersonId);
        // Insert race list of the child with the child's new person Id
        saveRaces(oldPersonId, newPersonId);
        // Insert child's ethnicity with the new person Id
        saveEthnicity(oldPersonId, newPersonId);
        // Insert Child Characteristics with new Person Id
        saveCharacteristics(oldPersonId, newPersonId);
        // Insert child's Medication records with the new person Id
        saveMedications(oldPersonId, newPersonId);
        // Insert child's Income and Resources records with new person Id
        saveIncomeAndResources(oldPersonId, newPersonId);
        // Register the new person id with the SMILE
        registerWithSmile(oldPersonId, newPersonId, legalStatus);
        // Mark the ADO and FCC stages SAU sealed.Mark the remaining open stages in the case, sensitive.
        markAdoAndFccStagesSealed(idStage, idCase, oldPersonId);
        // Retrieve the current placement for the child in ADO stage
        Placement placement = placementDAO.findCurrentAdoPlcmtByIdPersonByIdStage(oldPersonId, idStage);
        if (placement != null) {
          String plcmtType = placement.getCdPlcmtType();
          // Create New case
        /*  if (newFullName.length() > 25) {
            // Since the case name and stage name are limited to 25 characters in the database we are
            // truncating it to 25
            newFullName = StringHelper.truncate(newFullName, 25);
          }*/
          CapsResource plcmtResource = placement.getCapsResourceByIdRsrcFacil();
          String nmResource = plcmtResource.getNmResource();
          int idPlcmtResource = plcmtResource.getIdResource();
          // Update Exchange Child table and Exchange Home tables
          updateExchangeChild(plcmtResource, legalStatus, oldPersonId);
          markFadStageSealed(idPlcmtResource);
          int idNewCase = createNewCase(newFullName, plcmtResource);
          // If the new case is successfully created, create PAD stage for the new case
          int idNewStage = 0;
          if (idNewCase > 0) {
            // Insert a row in Situation table for the new PAD stage
            Integer idSituation = insertSituationRow(idNewCase);
            // Get Case Manager Unit
            int idUnit = getCaseManagerIdUnit(idPrimaryCaseWorker);
            idNewStage = createPadStage(idNewCase, newFullName, plcmtResource, idSituation, idUnit);
            if (idNewStage > 0) {
              // Once the PAD stage is successfully created insert a stage person link record with the child as the
              // primary child
              insertStagePersonLink(idNewStage, newPersonId, idNewCase, CodesTables.CRELVICT_SL, CodesTables.CROLES_PC,
                                    CodesTables.CPRSNTYP_PRN);
              // Once the PAD stage is successfully created insert a copy of the final adoptive placement recorded in
              // the ADO stage into the PAD stage with the new person Id.
              String eventDesc = generateEventDescr(plcmtType, nmResource);
              int idNewPlcmtEvent = copyPlcmtRecordFromAdoStage(placement, idNewCase, idNewStage, newPersonId,
                                                                eventDesc, primaryCaseWorker);
              // End date Placement record in ADO stage
              endDatePlcmtRecordInAdoStage(placement);

              // Check if there are any open (non-expired, ended or terminated) adoption agreements , and if there are
              // copy them along with their associated Adoption Assistance Application to the new PAD stage with the new 
              // Person Id
              // It will check if there are any orphaned non-expired Adoption application assistance records
              // and if there are any than insert a copy of them into the PAD stage with new person id
              eventDesc = "Adoption Assistance Application created for " + newFullName;
              
              copyAdoptionAssistanceAgreementRecord(idCase, idNewCase, idStage, idNewStage, oldPersonId, newPersonId, eventDesc,
                                                    primaryCaseWorker, idNewPlcmtEvent);

              // MR-092 copying over latest AA Funding if any, if not copy latest eligibility
              copyLatestAAFundingSummaryFromAdoStage(oldPersonId, idStage, idNewCase, idNewStage, newPersonId, primaryCaseWorker);
              
              // Insert the stage link record which will be the only link between the PAD stage in the new case and the
              // ADO stage in the old case
              insertStageLink(idStage, idNewCase, idNewStage);
              // If FCF is the only open stage in the case close the stage and the case
              List<Stage> openStageList = stageDAO.findOpenStagesByIdCaseByIdStage(idCase, idStage);
              if (openStageList != null && openStageList.size() == 1
                  && CodesTables.CSTAGES_FSU.equals(openStageList.get(0).getCdStage())) {
                closeStageCloseCase(openStageList.get(0).getIdStage(), idCase, idPrimaryCaseWorker);
              }
              // Assign New PAD stage to the Primary case worker of the ADO stage
              assignPadStage(idNewCase, idNewStage, primaryCaseWorker.getIdPerson());

              // MR-092 assign ADO assigned MES to PAD
              List<Integer> mesWorkerOrPaList = getSecondaryAssignedMesWorkers(idStage);
              if(!mesWorkerOrPaList.isEmpty()){
                  Integer idMesPaPerson = mesWorkerOrPaList.get(0);
                  // Assign New PAD stage to a secondary MES worker of the ADO stage
                  assignSecondaryPadStage(idNewCase, idNewStage, idMesPaPerson);
              }

              // Insert an Open PAD stage event
              CapsCase newCapsCase = (CapsCase) getPersistentObject(CapsCase.class, idNewCase);
              eventDesc = "Post Adoptive Stage Opened";
              insertEvent(newCapsCase, idNewStage, newPersonId, primaryCaseWorker, eventDesc, CodesTables.CEVNTTYP_STG,
                          OPEN_PAD_TASK, CodesTables.CEVTSTAT_COMP);
            } else {
              throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
            }
          } else {
            throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
          }
        } else {
          throw new ServiceException(Messages.SQL_NOT_FOUND);
        }
      } else {
        throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
      }
    } else {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    return csub68so;
  }

  private int saveNewPerson(int oldPersonId, String newFirstName, String newLastName, String newMiddleName,
                            String newFullName) {
    Person person = personDAO.findPersonByIdPerson(oldPersonId);
    int nbrPersonAge = DateHelper.getAge(person.getDtPersonBirth());
    Person newPerson = new Person();
    newPerson.setCdPersonSex(person.getCdPersonSex());
    newPerson.setDtPersonBirth(person.getDtPersonBirth());
    newPerson.setNmPersonFirst(newFirstName);
    newPerson.setNmPersonLast(newLastName);
    newPerson.setNmPersonMiddle(newMiddleName);
    newPerson.setNmPersonFull(newFullName);
    newPerson.setCdPersonChar(person.getCdPersonChar());
    newPerson.setNbrPersonAge(nbrPersonAge);
    newPerson.setTxtCharCmnts(person.getTxtCharCmnts());
    newPerson.setCdPersNotYetDiag(person.getCdPersNotYetDiag());
    newPerson.setCdSmileClient(CD_SMILE_CLIENT);
    newPerson.setIdPerson(null);
    newPerson.setDtLastUpdate(null);
    int newPersonId = personDAO.saveNewPerson(newPerson);
    return newPersonId;
  }

  private void saveNewName(Person newPersCreated, String newFirstName,String newLastName, String newMiddleName) {
    Name newName = new Name();
    newName.setDtLastUpdate(null);
    newName.setDtNameEndDate(DateHelper.MAX_JAVA_DATE);
    newName.setDtNameStartDate(new Date());
    newName.setIdName(0);
    newName.setIndNameEmp(ArchitectureConstants.N);
    newName.setIndNameInvalid(ArchitectureConstants.N);
    newName.setIndNamePrimary(ArchitectureConstants.Y);
    newName.setNmNameFirst(newFirstName);
    newName.setNmNameLast(newLastName);
    newName.setNmNameMiddle(newMiddleName);
    newName.setPerson(newPersCreated);
    nameDAO.saveOrUpdateName(newName);
  }

  private void saveNewpersonDtl(int newPersonId, int oldPersonId, Person newPersCreated) {
    PersonDtl oldPersonDtl = personDtlDAO.findServiceAuthByIdPerson(oldPersonId);
    if (oldPersonDtl != null) {
      PersonDtl newPersonDtl = new PersonDtl();
      newPersonDtl.setCdPersonEyeColor(oldPersonDtl.getCdPersonEyeColor());
      newPersonDtl.setCdPersonHairColor(oldPersonDtl.getCdPersonHairColor());
      newPersonDtl.setDtLastMed(oldPersonDtl.getDtLastMed());
      newPersonDtl.setDtMedDue(oldPersonDtl.getDtMedDue());
      newPersonDtl.setQtyPersonHeightFeet(oldPersonDtl.getQtyPersonHeightFeet());
      newPersonDtl.setQtyPersonHeightInches(oldPersonDtl.getQtyPersonHeightInches());
      newPersonDtl.setQtyPersonWeight(oldPersonDtl.getQtyPersonWeight());
      newPersonDtl.setPerson(newPersCreated);
      newPersonDtl.setIdPerson(newPersonId);
      newPersonDtl.setDtLastUpdate(null);
      //STGAP00014279: Copy citizenship status
      newPersonDtl.setCdPersonCitizenship(oldPersonDtl.getCdPersonCitizenship());
      //STGAP00014279: Copy Mother Married at Child's Birth 
      newPersonDtl.setCdPersonMarriedAtBirth(oldPersonDtl.getCdPersonMarriedAtBirth());
      //STGAP00014279 :Copy other fields from citizenship identity page
      newPersonDtl.setCdPersonBirthState(oldPersonDtl.getCdPersonBirthState());
      newPersonDtl.setCdPersonBirthCounty(oldPersonDtl.getCdPersonBirthCounty());
      newPersonDtl.setCdPersonBirthCity(oldPersonDtl.getCdPersonBirthCity());
      newPersonDtl.setCdPersonBirthCountry(oldPersonDtl.getCdPersonBirthCountry());
      newPersonDtl.setDtEntryUs(oldPersonDtl.getDtEntryUs());
      newPersonDtl.setIndPersonNoUsBrn(oldPersonDtl.getIndPersonNoUsBrn());
      personDtlDAO.savePersonDtl(newPersonDtl);
    }
  }
  
  
  //STGAP00014279: Insert the citizenship and age verification records for the new person record that is inserted
  private void saveNewpersonCitizenShipMethodVerif(int newPersonId, int oldPersonId) {
    List<PersonCitizenship>  personCitizenshipList = personCitizenshipDAO.findCheckboxByIdPerson(oldPersonId);
    if (personCitizenshipList != null && personCitizenshipList.size() > 0) {
      Iterator<PersonCitizenship> it = personCitizenshipList.iterator();
      while (it.hasNext()) {
        PersonCitizenship personCitizenship = (PersonCitizenship) it.next();
        PersonCitizenship newPersonCitizenship = new PersonCitizenship();
        newPersonCitizenship.setCdCbx(personCitizenship.getCdCbx());
        newPersonCitizenship.setCdCbxCodeType(personCitizenship.getCdCbxCodeType());
        newPersonCitizenship.setDtLastUpdate(null);
        newPersonCitizenship.setIdPersonCitizenship(0);
        newPersonCitizenship.setPerson((Person) getPersistentObject(Person.class, newPersonId));
        personCitizenshipDAO.savePersonCitizenship(newPersonCitizenship);
      }
    }
  }

  @SuppressWarnings( { "unchecked" })
  private void saveRaces(int oldPersonId, int idNewPerson) {
    List<PersonRace> personRaceList = personRaceDAO.findPersonRaceByIdPerson(oldPersonId);
    if (personRaceList != null && personRaceList.size() > 0) {
      Iterator it = personRaceList.iterator();
      while (it.hasNext()) {
        PersonRace personRace = new PersonRace();
        personRace = (PersonRace) it.next();
        PersonRace newPersonRace = new PersonRace();
        newPersonRace.setCdRace(personRace.getCdRace());
        newPersonRace.setDtLastUpdate(null);
        newPersonRace.setIdPersonRace(0);
        newPersonRace.setPerson((Person) getPersistentObject(Person.class, idNewPerson));
        personRaceDAO.savePersonRace(newPersonRace);
      }
    }
  }

  private void saveEthnicity(int oldPersonId, int idNewPerson) {
    PersonEthnicity personEthnicity = personEthnicityDAO.findLatestPersonEthnicityByIdPerson(oldPersonId);
    if (personEthnicity != null) {
      PersonEthnicity newPersonEthnicity = new PersonEthnicity();
      newPersonEthnicity.setCdEthnicity(personEthnicity.getCdEthnicity());
      newPersonEthnicity.setDtLastUpdate(null);
      newPersonEthnicity.setIdPersonEthnicity(0);
      newPersonEthnicity.setPerson((Person) getPersistentObject(Person.class, idNewPerson));
      personEthnicityDAO.savePersonEthnicity(newPersonEthnicity);
    }
  }

  @SuppressWarnings( { "unchecked" })
  private void saveCharacteristics(int oldPersonId, int idNewPerson) {
    List<Characteristics> characteristicsLst = characteristicsDAO.findCharsByIdPerson(oldPersonId);
    if (characteristicsLst != null && characteristicsLst.size() > 0) {
      Iterator charItr = characteristicsLst.iterator();
      while (charItr.hasNext()) {
        Characteristics characteristics = new Characteristics();
        characteristics = (Characteristics) charItr.next();
        Characteristics newCharacteristics = new Characteristics();
        newCharacteristics.setCdCharacteristic(characteristics.getCdCharacteristic());
        newCharacteristics.setCdCharCategory(characteristics.getCdCharCategory());
        newCharacteristics.setDtCharEnd(characteristics.getDtCharEnd());
        newCharacteristics.setDtCharStart(characteristics.getDtCharStart());
        newCharacteristics.setDtLastUpdate(null);
        newCharacteristics.setIdCharacteristics(0);
        newCharacteristics.setPerson((Person) getPersistentObject(Person.class, idNewPerson));
        characteristicsDAO.saveCharacteristics(newCharacteristics);
      }
    }
  }

  @SuppressWarnings( { "unchecked" })
  private void saveMedications(int oldPersonId, int idNewPerson) {
    List<Medication> medicationLst = medicationDAO.findMedicationByIdPerson(oldPersonId);
    if (medicationLst != null && medicationLst.size() > 0) {
      Iterator medItr = medicationLst.iterator();
      while (medItr.hasNext()) {
        Medication medication = (Medication) medItr.next();
        Medication newMedication = new Medication();
        populate_newMedication(medication, newMedication, idNewPerson);
        medicationDAO.saveMedication(newMedication);
      }
    }
  }

  @SuppressWarnings( { "unchecked" })
  private void saveIncomeAndResources(int oldPersonId, int idNewPerson) {
    List<IncomeAndResources> incomeAndResourcesLst = incomeAndResourcesDAO.findByIdPerson(oldPersonId);
    if (incomeAndResourcesLst != null && incomeAndResourcesLst.size() > 0) {
      Iterator incomeAndResItr = incomeAndResourcesLst.iterator();
      while (incomeAndResItr.hasNext()) {
        IncomeAndResources incomeAndResources = (IncomeAndResources) incomeAndResItr.next();
        IncomeAndResources newIncomeAndResources = new IncomeAndResources();
        populate_newIncomeResource(incomeAndResources, newIncomeAndResources, idNewPerson);
        incomeAndResourcesDAO.saveIncomeAndResources(newIncomeAndResources);
      }
    }
  }

  private void registerWithSmile(int oldPersonId, int newPersonId, LegalStatus legalStatus) {
    String cdPerCounty = "";
    if (legalStatus != null
        && (!("".equals(legalStatus.getCdLegalStatCnty())) || legalStatus.getCdLegalStatCnty() != null)) {
      cdPerCounty = legalStatus.getCdLegalStatCnty();
    } else {
      cdPerCounty = stageDAO.findStageCountyForPerson(oldPersonId);
    }

    int idCaseWorker = 0;
    Person person = personDAO.findPersonByIdPerson(newPersonId);
    ClientOutbound clientOutbound = new ClientOutbound();
    clientOutbound.setCdPerCounty(cdPerCounty);
    clientOutbound.setCdPersonSex(person.getCdPersonSex());
    clientOutbound.setDtPersonBirth(person.getDtPersonBirth());
    clientOutbound.setNmPersonFirst(person.getNmPersonFirst());
    clientOutbound.setNmPersonLast(person.getNmPersonLast());
    clientOutbound.setNmPersonMiddle(person.getNmPersonMiddle());
    clientOutbound.setIdClient(newPersonId);
    clientOutbound.setIndNewClient(NEW_SMILE_CLIENT);
    clientOutbound.setIdClientOutbound(0);
    clientOutbound.setIdInitiator(idCaseWorker);
    clientOutbound.setCdTargetSystem(TARGET_SYSTEM_SMILE);
    clientOutbound.setInterfaceStatus(NEW);
    clientOutbound.setDtLastUpdate(null);
    
    //MR-041 Set the Old Person ID SHINES Person Id of the existing, pre-adoptive child need to be saved in CLIENT_OUTBOUND table.
    clientOutbound.setIdClientPrev(oldPersonId);
    
    clientOutboundDAO.sendClientOutbound(clientOutbound);
  }

  private void markAdoAndFccStagesSealed(int idStage, int idCase, int idPerson) {
    // Get the list of all open stages in the case and the Fcc stage for the child
    // and mark the ADO and FCC stages as SAU Sealed. Mark all the other open stages
    // as sensitive.
    Integer idSubStage = stageDAO.findStageFCCByIdCaseIdPerson(idCase, idPerson, CodesTables.CSTAGES_SUB);
    List<Integer> lstStagesToBeSealed = new ArrayList<Integer>();
    lstStagesToBeSealed.add(idStage);
    if (idSubStage != null) {
      lstStagesToBeSealed.add(idSubStage);
    }
    int nbrSealedRows = stageDAO.updateStageMarkStageSealed(lstStagesToBeSealed);
    if (nbrSealedRows == 0) {
      throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
    }
    List<Integer> lstStagesToBeMarkedSensitive = stageDAO.findIdStagesOfOpenStagesByIdCase(idCase);
    int nbrSensitiveRows = 0;
    if (lstStagesToBeMarkedSensitive != null && lstStagesToBeMarkedSensitive.size() > 0) {
      nbrSensitiveRows = stageDAO.updateStageMarkStageSensitive(lstStagesToBeMarkedSensitive);
      if (nbrSensitiveRows == 0) {
        throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
      }
    }
    // Mark the pre-adoptive case as sensitive
    int nbrRowsUpdated = capsCaseDAO.updateCapsCaseIndCaseSensitive(idCase, ArchitectureConstants.Y);
    if (nbrRowsUpdated < 1) {
      throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
    }
  }

  private int createNewCase(String newFullName, CapsResource plcmtResource) {
    // CREATE A CASE
    CapsCase capsCase = new CapsCase();
    capsCase.setIdCase(0);
    capsCase.setCdCaseProgram(CD_CASE_PROGRAM);
    capsCase.setNmCase(newFullName);
    capsCase.setCdCaseCounty(plcmtResource.getCdRsrcCnty());
    capsCase.setCdCaseRegion(plcmtResource.getCdRsrcRegion());
    capsCase.setDtCaseOpened(new Date());
    capsCase.setDtCaseClosed(null);
    capsCase.setDtLastUpdate(null);
    capsCase.setIndCaseSensitive(ArchitectureConstants.Y);
    int idNewCase = capsCaseDAO.saveOrUpdateCapsCase(capsCase);
    return idNewCase;
  }

  private int createPadStage(int idNewCase, String newFullName, CapsResource plcmtResource, int idSituation, int idUnit) {
    Stage stage = new Stage();
    stage.setIdStage(0);
    stage.setCapsCase((CapsCase) getPersistentObject(CapsCase.class, idNewCase));
    stage.setNmStage(newFullName);
    stage.setSituation((Situation) getPersistentObject(Situation.class, idSituation));
    stage.setUnit((Unit) getPersistentObject(Unit.class, idUnit));
    stage.setCdStage(STAGE_PAD);
    stage.setCdStageProgram(CD_CASE_PROGRAM);
    stage.setCdStageType(CD_CASE_PROGRAM);
    stage.setDtStageStart(new Date());
    stage.setCdStageCnty(plcmtResource.getCdRsrcCnty());
    //SMS#49588 stage region did not align with stage county as the stage county for PAD stages 
    // was populated from resource county and some resource records had null in their cd_region field in the
    // database
    String cdStageRegion = null;
    if(plcmtResource.getCdRsrcCnty() != null){
    cdStageRegion = Lookup.simpleDecodeSafe(CodesTables.CCNTYREG, plcmtResource.getCdRsrcCnty());
    }
    stage.setCdStageRegion(cdStageRegion);
    stage.setCdStageClassification(CD_CASE_PROGRAM);
    stage.setDtLastUpdate(null);
    int idPadStage = stageDAO.saveOrUpdateStage(stage);
    return idPadStage;
  }

  private void closeStageCloseCase(int idStage, int idCase, int idCaseWorker) {
    String[] cdEventTypes = { CodesTables.CEVNTTYP_AUT };
    Date dtSystemDate = new Date();
    List<Object[]> events = dynamicEventDAO.findEvents(false, 0, idStage, 0, 0, 0, cdEventTypes, null, FSU_SVC_AUTH,
                                                       null, null, null);
    Iterator<Object[]> it = events.iterator();
    while (it.hasNext()) {
      Object[] event = it.next();
      // Test for CdEventStatus and ignored NEW or PROC status. There should be no open Svc Auths
      // above PROC status when closing the case
      if (CodesTables.CEVNTTYP_AUT.equals(event[1]) && !CodesTables.CEVTSTAT_NEW.equals(event[0])
          && !CodesTables.CEVTSTAT_PROC.equals(event[0])) {
        // cses24d
        SvcAuthEventLink svcAuthEventLink = svcAuthEventLinkDAO.findSvcAuthEventLinkByEventId((Integer) event[6]);
        if (svcAuthEventLink != null) {
          // cses23d
          ServiceAuthorization serviceAuth = serviceAuthorizationDAO
                                                                    .findServiceAuth(svcAuthEventLink
                                                                                                     .getServiceAuthorization()
                                                                                                     .getIdSvcAuth());
          if (serviceAuth != null) {
            // clss24d
            List<SvcAuthDetail> authDetails = svcAuthDetailDAO
                                                              .findServiceAuthDetailPersonByIdSvcAuth(svcAuthEventLink
                                                                                                                      .getServiceAuthorization()
                                                                                                                      .getIdSvcAuth());
            if (authDetails == null || authDetails.isEmpty()) {
              throw new ServiceException(Messages.SQL_NOT_FOUND);
            }
            Iterator<SvcAuthDetail> auth_iterator = authDetails.iterator();
            while (auth_iterator.hasNext()) {
              SvcAuthDetail svcAuthDetail = auth_iterator.next();
              // The Term date should not be greater than or = today's date and the
              // Service Code should not be 40m. Allow for open service auths if
              // they are any type of DAYCARE.
              if ((dtSystemDate.compareTo(svcAuthDetail.getDtSvcAuthDtlTerm()) < 0)) {
                throw new ServiceException(Messages.MSG_SVA_OPN_AUTHS);
              }
            }
          } else {
            throw new ServiceException(Messages.ARC_ERR_SQL_ERROR);
          }
        } else {
          throw new ServiceException(Messages.ARC_ERR_SQL_ERROR);
        }
      }
    }
    CCMN02UI ccmn02ui = new CCMN02UI();
    CCMN02UIG00 ccmn02UiG00 = new CCMN02UIG00();
    ccmn02UiG00.setBIndSkipStageProg(ArchitectureConstants.Y);
    ccmn02UiG00.setSzCdStage(STAGE_FSU);
    ccmn02UiG00.setSzCdStageProgram("CPS");
    ccmn02UiG00.setSzCdStageReasonClosed(CodesTables.CCLOSFCF_ACA);
    ccmn02UiG00.setSzTxtEventDescr("All Children Adopted - automatic system closure");
    ccmn02UiG00.setUlIdPerson(idCaseWorker);
    ccmn02UiG00.setUlIdStage(idStage);
    ccmn02ui.setCCMN02UIG00(ccmn02UiG00);
    closeStageCase.closeStageCase(ccmn02ui);
  }

  private int copyPlcmtRecordFromAdoStage(Placement placement, int idNewCase, int idNewStage, int newPersonId,
                                          String eventDesc, Person primaryCaseWorker) {
    CapsCase newCapsCase = (CapsCase) getPersistentObject(CapsCase.class, idNewCase);
    Person newPerson = (Person) getPersistentObject(Person.class, newPersonId);
    Event newPlcmtEvent = insertEvent(newCapsCase, idNewStage, newPersonId, primaryCaseWorker, eventDesc,
                                      CodesTables.CEVNTTYP_PLA, PAD_PLCMT_TASK, EVENT_STATUS);
    int idNewPlcmtEvent = newPlcmtEvent.getIdEvent();
    if (idNewPlcmtEvent > 0) {
      // Insert Event Person Link record
      insertEventPersonLink(newPerson, newPlcmtEvent, newCapsCase);
      // Insert Placement Record
      insertPlcmtRecord(placement, newPerson, idNewPlcmtEvent, newCapsCase);
      // Insert Approval Event, Approval and Approvers records
      String cdTxtApprovalTopic = "Approve Placement";
      insertApprovalEventRecords(primaryCaseWorker, idNewStage, newCapsCase, idNewPlcmtEvent,
                                 placement.getIdPlcmtEvent(), cdTxtApprovalTopic, CodesTables.CEVNTTYP_PLA,
                                 PAD_PLCMT_APP_TASK);

    }
    return idNewPlcmtEvent;
  }

  private Event insertEvent(CapsCase newCapsCase, int idNewStage, int idNewPerson, Person primaryCaseWorker,
                            String eventDesc, String eventType, String cdTask, String eventStatus) {
    Event newPlcmtEvent = new Event();
    newPlcmtEvent.setIdEvent(0);
    newPlcmtEvent.setDtLastUpdate(null);
    newPlcmtEvent.setDtEventOccurred(new Date());
    newPlcmtEvent.setCapsCase(newCapsCase);
    newPlcmtEvent.setCdEventStatus(eventStatus);
    newPlcmtEvent.setCdEventType(eventType);
    newPlcmtEvent.setCdTask(cdTask);
    newPlcmtEvent.setStage((Stage) getPersistentObject(Stage.class, idNewStage));
    newPlcmtEvent.setPerson(primaryCaseWorker);
    newPlcmtEvent.setTxtEventDescr(eventDesc);
    // Insert Event record in the Event table.
    int idNewPlcmtEvent = eventDAO.saveEventReturnsEventId(newPlcmtEvent);
    newPlcmtEvent.setIdEvent(idNewPlcmtEvent);
    return newPlcmtEvent;
  }

  private int copyAdoptionAssistanceRecordFromAdoStage(int idCase, int oldPersonId, int idNewCase, int idNewStage,
                                                       int newPersonId, String eventDesc, Person primaryCaseWorker,
                                                       int idOldSpclNeedsEvent, int idStage) {

    SpecialNeedsDetermination spclNeedsDet = null;
    Event spclNeedsEvent = null;
    int idNewSpclNeedsEvent = 0;
    if (idOldSpclNeedsEvent > 0) {
      spclNeedsDet = specialNeedsDeterminationDAO.findSpecialNeedsDeterminationByIdEvent(idOldSpclNeedsEvent);
      spclNeedsEvent = eventDAO.findEventByIdEvent(idOldSpclNeedsEvent);
    }

    if (spclNeedsDet != null) {
      CapsCase newCapsCase = (CapsCase) getPersistentObject(CapsCase.class, idNewCase);
      Person newPerson = (Person) getPersistentObject(Person.class, newPersonId);
      //SMS#44138 Get the event description from old snd event and copy to new event
      String eventDescFromOld = StringHelper.EMPTY_STRING;
      if (spclNeedsEvent != null) {
        eventDescFromOld = spclNeedsEvent.getTxtEventDescr();
        //SMS#45290 Event description should display the idPerson of new person
        int lastSpace = eventDescFromOld.lastIndexOf(" ");
        eventDescFromOld = eventDescFromOld.substring(0, lastSpace);
        eventDescFromOld = eventDescFromOld + " " + newPerson.getIdPerson();
        if (eventDescFromOld.length() > 100) {
          eventDescFromOld = eventDescFromOld.substring(0, 99);
        }
      }
      Event newSpclNeedsDetEvent = insertEvent(newCapsCase, idNewStage, newPersonId, primaryCaseWorker, eventDescFromOld,
                                               CodesTables.CEVNTTYP_SND, ADO_ASST_APPLICATION_TASK, EVENT_STATUS);
      idNewSpclNeedsEvent = newSpclNeedsDetEvent.getIdEvent();
      if (idNewSpclNeedsEvent > 0) {
        // Insert Event Person Link record
        insertEventPersonLink(newPerson, newSpclNeedsDetEvent, newCapsCase);
        // Insert new Adoption Assistance Application Record
        insertAdoAsstAppRecord(spclNeedsDet, newPerson, idNewSpclNeedsEvent, newCapsCase);
        // Insert Approval Event, Approval and Approvers records
        String cdTxtApprovalTopic = "Approve Adoption Assistance Application";
        insertApprovalEventRecords(primaryCaseWorker, idNewStage, newCapsCase, idNewSpclNeedsEvent,
                                   spclNeedsDet.getIdEvent(), cdTxtApprovalTopic, CodesTables.CEVNTTYP_SND,
                                   ADO_ASST_APPLICATION_APP_TASK);
        
        copySpecialServicesServicAuthRecords(idStage, idNewCase, newPersonId, idNewStage, primaryCaseWorker, idNewSpclNeedsEvent, idOldSpclNeedsEvent);
        
       
      }
      // Comment and set the expiration date of the ADO Adoption Assistance Application to today's date
      endDateAdoAsstApplication(spclNeedsDet);
    }
    return idNewSpclNeedsEvent;
  }

  
  @SuppressWarnings("unchecked")
  private void copySpecialServicesServicAuthRecords(int idStage, int idNewCase, int newPersonId, int idNewStage,
                                                    Person primaryCaseWorker, int idNewSpclNeedsEvent, int idOldSpclNeedsEvent) {
    List<Map> specialSvcSvcAuth = svcAuthEventLinkDAO.findLinkedServAuthByIdStagecdProgType(idStage, CodesTables.CPRGCOD1_512, idOldSpclNeedsEvent );
    // MR-52 Checking to see if the Stage has an approved Adoption Assistance Applications before carrying
    // any service Authorizations to the PAD stage.
    if (specialSvcSvcAuth != null && !specialSvcSvcAuth.isEmpty()) {
      for (Iterator<Map> it = specialSvcSvcAuth.iterator(); it.hasNext();) {
        Map oldSvcAuth = it.next();
        int idSvcAuth = (Integer) oldSvcAuth.get("idSvcAuth");
        Date todayDate = new Date();
        // MR-52 Checking to see if the Service Auth header has any active Details that are tied to a 
        // Special Needs Determination(Ado Assistance Application). 
        List <SvcAuthDetail> svcAuthDetails = svcAuthDetailDAO.getLinkedOpenSvcAuthDetailByIdSvcAuth(idSvcAuth, todayDate);
        if (svcAuthDetails != null && !svcAuthDetails.isEmpty()) {
          CapsCase newCapsCase = (CapsCase) getPersistentObject(CapsCase.class, idNewCase);
          Person newPerson = (Person) getPersistentObject(Person.class, newPersonId);
          String eventDesc = (String) oldSvcAuth.get("txtEventDescr");

          SpecialNeedsDetermination specNeedsDeter = specialNeedsDeterminationDAO.findSpecialNeedsDeterminationByIdEvent(idNewSpclNeedsEvent);
          String uasCode = (String) oldSvcAuth.get ("cdSvcAuthCategory");
          String entCode =  (String) oldSvcAuth.get ("cdSvcAuthService");
          int idResource = (Integer) oldSvcAuth.get ("idResource");
          String resourceName = capsResourceDAO.findNmByIdResourceOnly(idResource);
          String nmPrimaryClient = personDAO.findNmFullByIdPerson(newPersonId);
          
          eventDesc =  (uasCode != null ? uasCode : "");
          eventDesc += (entCode != null ? " " + Lookup.simpleDecodeSafe("CENTCODE", entCode) : "");
          eventDesc += "; Resource: " + resourceName;
          if(!StringHelper.EMPTY_STRING.equals(nmPrimaryClient)){
            eventDesc += "; for " + nmPrimaryClient;
          }
          int eventDecLn =  eventDesc.length();
          eventDesc = eventDesc.substring(0, eventDecLn > 100 ? 100 : eventDecLn);
         
          // Adding New Service Authorization event
          Event newSvcAuthEvent = insertEvent(newCapsCase, idNewStage, newPersonId, primaryCaseWorker, eventDesc,
                                              CodesTables.CEVNTTYP_AUT, ADO_SVC_AUTH_TASK, EVENT_STATUS);

          int newIdEvent = newSvcAuthEvent.getIdEvent();
          if (newIdEvent > 0) {
            // Adding New Event Person Link Record
            insertEventPersonLink(newPerson, newSvcAuthEvent, newCapsCase);
            
            

            // // Adding New Service Authorization Record
            ServiceAuthorization newServiceAuthorization =  insertServiceAuthorizationRecord(oldSvcAuth, newPerson);
            int idNewSvcAuth = newServiceAuthorization.getIdSvcAuth();
            // MR-52 Adding new Service Auth Event Link Record
            saveSvcAuthEventLink(newServiceAuthorization, newIdEvent, newSvcAuthEvent);
            addSvcAuthDetails(svcAuthDetails,newServiceAuthorization,specNeedsDeter );

            
          }

        }
      }
    }

  }

  

  private void copyAdoptionAssistanceAgreementRecord(int idCase, int idNewCase, int idStage, int idNewStage, int oldPersonId,
                                                     int newPersonId, String eventDesc, Person primaryCaseWorker,
                                                     int idNewPlcmtEvent) {

    int idAdpAsstAppEvent = 0;
    boolean isAgreementActive = false;
    // Copy any open (non-expired, ended or terminated) Adoption Assistance Agreements, 
    // along with their associated Adoption Assistance Application records to the PAD stage
    // and all other open Adoption Assistance Application records that do not have an associated Agreement
    List<Integer> spclNeedsDeterms = specialNeedsDeterminationDAO.findSpclDeterminationsByIdCaseIdStageIdPerson(idCase, idStage, oldPersonId);
    // Agreements are no longer being set to APRV but instead to COMP
    List<Integer> idAgreements = adptSubEventLinkDAO.findCompletedAdoptionSubsidiesByIdCaseIdStageIdPerson(idCase, idStage, oldPersonId);
    if (idAgreements != null && idAgreements.size() != 0) {
      Iterator<Integer> idAgreements_it = idAgreements.iterator();
      while (idAgreements_it.hasNext()) {
        Integer idAgreement = idAgreements_it.next();
        if (idAgreement != null && idAgreement.intValue() > 0) {
          AdoptionSubsidy adoSubsidy = adoptionSubsidyDAO.findAdptSubByIdAdptSub(idAgreement);
          if (adoSubsidy != null) {
            Date endDate = adoSubsidy.getDtAdptSubEnd();
            Date termDate = adoSubsidy.getDtAdptSubTerminated();
            // If the Agreement Terminated date exists, see if it's set to a date that's before the
            // Agreement End date. If so, determine if the Agreement is active by using the Agreement Terminated date
            if (termDate != null) {
              if (DateHelper.isBefore(endDate, termDate)) {
                if (DateHelper.isAfterToday(termDate)) {
                  isAgreementActive = true;
                  SpecialNeedsDetermination specialNeeds = adoSubsidy.getSpecialNeedsDetermination();
                  idAdpAsstAppEvent = (specialNeeds != null) ? specialNeeds.getIdEvent() : 0;
                  // create the new application if one exist for the agreement
                  if (idAdpAsstAppEvent > 0 && spclNeedsDeterms.contains(idAdpAsstAppEvent)) {
                    // Remove this Application from the list of All of the approved Applications for this child in this case
                    spclNeedsDeterms.remove((Integer)idAdpAsstAppEvent); 
                    idAdpAsstAppEvent = copyAdoptionAssistanceRecordFromAdoStage(idCase, oldPersonId, idNewCase,
                                                                                 idNewStage, newPersonId, eventDesc,
                                                                                 primaryCaseWorker, idAdpAsstAppEvent, idStage);
                  }
                }
              } 
              // determine if the Agreement is active by using the Agreement End date
              else {
                if (DateHelper.isAfterToday(endDate)) {
                  isAgreementActive = true;
                  SpecialNeedsDetermination specialNeeds = adoSubsidy.getSpecialNeedsDetermination();
                  idAdpAsstAppEvent = (specialNeeds != null) ? specialNeeds.getIdEvent() : 0;
                  // create the new application if one exist for the agreement
                  if (idAdpAsstAppEvent > 0 && spclNeedsDeterms.contains(idAdpAsstAppEvent)) {
                    
                    // Remove this Application from the list of All of the approved Applications for this child in this case
                    spclNeedsDeterms.remove((Integer)idAdpAsstAppEvent); 
                    idAdpAsstAppEvent = copyAdoptionAssistanceRecordFromAdoStage(idCase, oldPersonId, idNewCase,
                                                                                 idNewStage, newPersonId, eventDesc,
                                                                                 primaryCaseWorker, idAdpAsstAppEvent, idStage);
                  }
                }
              }
            } 
            // The Agreement Terminated date doesn't exist. Determine if the Agreement is active by using the Agreement End date
            else {
              if (DateHelper.isAfterToday(endDate)) {
                isAgreementActive = true;
                SpecialNeedsDetermination specialNeeds = adoSubsidy.getSpecialNeedsDetermination();
                idAdpAsstAppEvent = (specialNeeds != null) ? specialNeeds.getIdEvent() : 0;
                // create the new application if one exist for the agreement
                if (idAdpAsstAppEvent > 0 && spclNeedsDeterms.contains(idAdpAsstAppEvent)) {
                  // Remove this Application from the list of All of the approved Applications for this child in this case
                  spclNeedsDeterms.remove((Integer)idAdpAsstAppEvent); 
                  idAdpAsstAppEvent = copyAdoptionAssistanceRecordFromAdoStage(idCase, oldPersonId, idNewCase,
                                                                               idNewStage, newPersonId, eventDesc,
                                                                               primaryCaseWorker, idAdpAsstAppEvent, idStage);
                }
              }
            }
          }
        }
        if (isAgreementActive) {
          if (idAgreement != null && idAgreement.intValue() > 0) {
            String agreementEventDesc = null; 
            AdoptionSubsidy adoSubsidy = adoptionSubsidyDAO.findAdptSubByIdAdptSub(idAgreement);
            if (adoSubsidy != null) {
              Integer idOldAdoSubEvent = adptSubEventLinkDAO.findIdEventByIdAdoSub(adoSubsidy.getIdAdptSub());
              if (idOldAdoSubEvent == null) {
                idOldAdoSubEvent = 0;
                // STGAP00012658: Fixed the event description on Adoption Assistance Agreement list page in PAD stage. 
                int length = "Adoption Assistance Application created for ".length();
                String newFullName = eventDesc.substring(length, eventDesc.length());
                agreementEventDesc = "Adoption Assistance Agreement created for " + newFullName;
              } else {
                // STGAP00013089: Copy the old Adoption Subsidy event description to the new PAD stage
                Event oldAdoSubEvent = eventDAO.findEventByIdEvent(idOldAdoSubEvent);
                String tmpSzCdEventStatus = oldAdoSubEvent.getCdEventStatus();
                String tmpSzCdAdptSubDeterm = adoSubsidy.getCdAdptSubDeterm();
                String tmpDtDtAdptSubEffective = DateHelper.toString(adoSubsidy.getDtAdptSubEffective(), DateHelper.SLASH_FORMAT);
                String tmpDtDtAdptSubEnd = DateHelper.toString(adoSubsidy.getDtAdptSubEnd(), DateHelper.SLASH_FORMAT);
                if ((tmpSzCdEventStatus != null) && tmpSzCdEventStatus.equals(CodesTables.CEVTSTAT_COMP)) {
                  agreementEventDesc = Lookup.simpleDecodeSafe(CodesTables.CSUBTYPE, tmpSzCdAdptSubDeterm)
                                       + " Assistance Start " + tmpDtDtAdptSubEffective + " End " + tmpDtDtAdptSubEnd
                                       + " for child " + newPersonId + " is Complete.";
                }
              }
              if (agreementEventDesc != null) {
                if (agreementEventDesc.length() > 100) {
                  agreementEventDesc = agreementEventDesc.substring(0, 100);
                }
              }
              CapsCase newCapsCase = (CapsCase) getPersistentObject(CapsCase.class, idNewCase);
              Person newPerson = (Person) getPersistentObject(Person.class, newPersonId);
              Event newAdoAsstAgrEvent = insertEvent(newCapsCase, idNewStage, newPersonId, primaryCaseWorker,
                                                     agreementEventDesc, CodesTables.CEVNTTYP_ADP, ADO_ASST_AGREEMENT_TASK,
                                                     AGREEMENT_EVENT_STATUS);
              int idNewAdoAsstAgrEvent = newAdoAsstAgrEvent.getIdEvent();
              if (idNewAdoAsstAgrEvent > 0) {
                // Insert Event Person Link record
                insertEventPersonLink(newPerson, newAdoAsstAgrEvent, newCapsCase);
                // Insert Placement Record
                int idNewAdoSub = insertAdoAsstAgreementRecord(adoSubsidy, newPerson, newCapsCase, idAdpAsstAppEvent,
                                                               idNewPlcmtEvent);
                insertAdtptSubEventLink(idNewAdoAsstAgrEvent, idNewAdoSub, newCapsCase);
                // Insert Approval Event, Approval and Approvers records
                String cdTxtApprovalTopic = "Approve Adoption Assistance Agreement";
                insertApprovalEventRecords(primaryCaseWorker, idNewStage, newCapsCase, idNewAdoAsstAgrEvent,
                                           idOldAdoSubEvent, cdTxtApprovalTopic, CodesTables.CEVNTTYP_ADP,
                                           ADO_ASST_AGREEMENT_APP_TASK);
              }
              endDateAdoAsstAgreement(adoSubsidy);
            }
          }
        }
      }
    }
    // We have finished copying over all of the active, approved Agreements and their corresponding Applications.
    // We now need to copy over any orphaned, non-expired and approved Applications to the PAD stage
    if (spclNeedsDeterms != null && spclNeedsDeterms.size() != 0) {
      Iterator<Integer> spclNeedsDeterms_it = spclNeedsDeterms.iterator();
      while (spclNeedsDeterms_it.hasNext()) {
        copyAdoptionAssistanceRecordFromAdoStage(idCase, oldPersonId, idNewCase, idNewStage, newPersonId, eventDesc,
                                                 primaryCaseWorker, spclNeedsDeterms_it.next(), idStage);
      }
    }
  }

  
  
  private void saveSvcAuthEventLink(ServiceAuthorization serviceAuthorization, int idSvcAuthEvent, Event event) {
    SvcAuthEventLink svcAuthEventLink = new SvcAuthEventLink();
    svcAuthEventLink.setIdSvcAuthEvent(idSvcAuthEvent);
    svcAuthEventLink.setServiceAuthorization(serviceAuthorization);
    svcAuthEventLink.setEvent(event);
    svcAuthEventLinkDAO.saveSvcAuthEventLink(svcAuthEventLink);
  }
  
  
  private void copyLatestEligibilityRecordFromAdoStage(int idOldPerson, int idNewCase, int idNewStage, int newPersonId,
                                                       Person primaryCaseWorker) {
    // 45415 Coping most recently created & approved eligibility regardless of stage closure status. 
    Eligibility eligibility = eligibilityDAO.findLatestApprovedEligibilityinFCC(idOldPerson);
    if (eligibility != null) {
      CapsCase newCapsCase = (CapsCase) getPersistentObject(CapsCase.class, idNewCase);
      Person newPerson = (Person) getPersistentObject(Person.class, newPersonId);
      String eventDesc = "";
      Person mesWorker = new Person();
      Event oldEvent = eventDAO.findEventByIdEvent(eligibility.getIdEligEvent());
      if (oldEvent != null) {
        // 45415 displaying the MES worker for Eligibility since the case manager doesn't fill out the 
        // eligibility. 
         mesWorker = oldEvent.getPerson();
        eventDesc = oldEvent.getTxtEventDescr();
        //STGAP00014187: Remove end date from the description
        if(eventDesc != null && !"".equals(eventDesc)){
          int index = eventDesc.indexOf("End");  
          eventDesc = eventDesc.substring(0, index);
        }
      } else {
        eventDesc = Lookup.simpleDecodeSafe(CodesTables.CELIGIBI, eligibility.getCdEligSelected()) + " Start "
                    + FormattingHelper.formatDate(new Date());
      }

      Event newEligbilityEvent = insertEvent(newCapsCase, idNewStage, newPersonId, mesWorker, eventDesc,
                                             CodesTables.CEVNTTYP_FCD, ELIGIBILITY_TASK, EVENT_STATUS);
      int idNewEligEvent = newEligbilityEvent.getIdEvent();
      if (idNewEligEvent > 0) {
        // Insert Event Person Link record
        insertEventPersonLink(newPerson, newEligbilityEvent, newCapsCase);
        // Insert Placement Record
        insertElligibilityRecord(eligibility, newPerson, idNewEligEvent, newCapsCase, primaryCaseWorker);
      }
      // STGAP00011416: Since there is a validation while closing the FCC stage to end date the eligibility in that
      // stage,
      // modified code to get the most recent eligibility for the child in the FCC stage instead of current eligibility
      // and
      // copy it over to the PAD stage.Now there is no need to end date the eligibility.
      // endDateEligibility(eligibility);
    }
  }

  private void copyLatestAAFundingSummaryFromAdoStage(int idOldPerson, int idOldStage,
                                                      int idNewCase, int idNewStage, int newPersonId, Person primaryCaseWorker) {
    
    AaFunding adoAaFunding = aaFundingDAO.findLatestValidatedAAFundingByIdChildByIdStage(idOldPerson, idOldStage);
    
    if (adoAaFunding != null) {
      CapsCase newCapsCase = getPersistentObject(CapsCase.class, idNewCase);
      Person newPerson = getPersistentObject(Person.class, newPersonId);
      Event oldAaFundingEvent = eventDAO.findEventByIdEvent(adoAaFunding.getIdAaFundingEvent());
      
      // create new AA Funding Event record
      Event newAaFundingEvent = insertEvent(newCapsCase, idNewStage, newPersonId, 
                                            oldAaFundingEvent.getPerson(), oldAaFundingEvent.getTxtEventDescr(),
                                            CodesTables.CEVNTTYP_AFS, PAD_AA_FUNDING_TASK, EVENT_STATUS);
      
      int idNewAaFundingEvent = newAaFundingEvent.getIdEvent();
      if (idNewAaFundingEvent > 0) {
        // Insert Event Person Link record
        insertEventPersonLink(newPerson, newAaFundingEvent, newCapsCase);
        
        // Insert AA Funding Record
        insertAaFundingRecord(adoAaFunding, newPerson, idNewAaFundingEvent, primaryCaseWorker);
      }
    }else{
      // MR-092 If latest validated AA Funding does not exists, then copy eligibility since
      // AA Application is based on that eligibility funding type.
      // This is purely to support old cases prior to AA Funding enhancement, going forward
      // funding type will be retrieve from AA Funding Summary
      // Copy Eligibility record
      copyLatestEligibilityRecordFromAdoStage(idOldPerson, idNewCase, idNewStage, newPersonId,
                                              primaryCaseWorker);

    }
  }

  private static String generateEventDescr(String plcmtType, String nmResource) {
    StringBuffer eventDescr = new StringBuffer(0);
    // Start Date<placement start date> 15 spaces <Placement name> <Placement Type>
    eventDescr.append("Start Date").append(FormattingHelper.formatDate(DateHelper.toCastorDate(new Date())));
    eventDescr.append("               ");
    nmResource = StringHelper.truncate(nmResource, 14);
    eventDescr.append(nmResource).append(" ");
    eventDescr.append(plcmtType);
    return eventDescr.toString();
  }

  private void insertEventPersonLink(Person newPerson, Event newEvent, CapsCase newCapsCase) {
    EventPersonLink eventPersonLink = new EventPersonLink();
    eventPersonLink.setCapsCase(newCapsCase);
    eventPersonLink.setEvent(newEvent);
    eventPersonLink.setPerson(newPerson);
    eventPersonLink.setIdEventPersLink(0);
    eventPersonLink.setDtLastUpdate(null);
    eventPersonLinkDAO.saveEventPersonLink(eventPersonLink);
  }

  private void insertPlcmtRecord(Placement placement, Person newPerson, int idNewPlcmtEvent, CapsCase newCapsCase) {
    Placement newPlcmtRecord = new Placement();
    newPlcmtRecord.setIdPlcmtEvent(idNewPlcmtEvent);
    newPlcmtRecord.setCapsCase(newCapsCase);
    newPlcmtRecord.setDtLastUpdate(null);
    newPlcmtRecord.setEvent((Event) getPersistentObject(Event.class, idNewPlcmtEvent));
    newPlcmtRecord.setPersonByIdPlcmtChild(newPerson);
    populateNewPlacement(newPlcmtRecord, placement, newPerson);
    placementDAO.savePlacement(newPlcmtRecord);
  }

  private int insertAdoAsstAppRecord(SpecialNeedsDetermination spclNeedsDet, Person newPerson,
                                      int idNewAdoAssAppEvent, CapsCase newCapsCase) {
    SpecialNeedsDetermination newSpclNeedsDet = new SpecialNeedsDetermination();
    newSpclNeedsDet.setIdEvent(idNewAdoAssAppEvent);
    newSpclNeedsDet.setDtLastUpdate(null);
    newSpclNeedsDet.setEvent((Event) getPersistentObject(Event.class, idNewAdoAssAppEvent));
    populate_newAdoption_Assistance(spclNeedsDet, newSpclNeedsDet);
   int idNewSpecNeedsDet = specialNeedsDeterminationDAO.saveSpecialNeedsDetermination(newSpclNeedsDet);
   
   return idNewSpecNeedsDet;
  }
  
  private ServiceAuthorization insertServiceAuthorizationRecord(Map oldServiceAuth, Person newPerson) {
    ServiceAuthorization newSvcAuth = populate_New_ServiceAuth(oldServiceAuth, newPerson);
    serviceAuthorizationDAO.saveServiceAuthorization(newSvcAuth);
    return newSvcAuth;
  }
  



  private void addSvcAuthDetails(List<SvcAuthDetail> svcAuthDetails, ServiceAuthorization newServiceAuthorization, SpecialNeedsDetermination specNeedsDeter) {
 
    Iterator<SvcAuthDetail> it = svcAuthDetails.iterator();
    while (it.hasNext()) {
      SvcAuthDetail svcAuthDetail = (SvcAuthDetail) it.next(); 
      SvcAuthDetail newDetail = new SvcAuthDetail();
      int idSvcAuthDtl = commonDAO.getNextval("SEQ_SVC_AUTH_DETAIL");
      newDetail.setIdSvcAuthDtl(idSvcAuthDtl);
      newDetail.setServiceAuthorization(newServiceAuthorization);
      newDetail.setPerson(newServiceAuthorization.getPersonByIdPerson());
      newDetail.setCdSvcAuthDtlAuthType(svcAuthDetail.getCdSvcAuthDtlAuthType());
      newDetail.setCdSvcAuthDtlUnitType(svcAuthDetail.getCdSvcAuthDtlUnitType());
      newDetail.setCdSvcAuthDtlPeriod(svcAuthDetail.getCdSvcAuthDtlPeriod());
      newDetail.setCdSvcAuthDtlSvc(svcAuthDetail.getCdSvcAuthDtlSvc());    
      newDetail.setDtSvcAuthDtl(svcAuthDetail.getDtSvcAuthDtl());
      newDetail.setDtSvcAuthDtlBegin(svcAuthDetail.getDtSvcAuthDtlBegin());
      newDetail.setDtSvcAuthDtlEnd(svcAuthDetail.getDtSvcAuthDtlEnd());
      newDetail.setDtSvcAuthDtlTerm(svcAuthDetail.getDtSvcAuthDtlTerm());
      newDetail.setDtSvcAuthDtlShow(svcAuthDetail.getDtSvcAuthDtlShow());
      newDetail.setAmtSvcAuthDtlAmtReq(svcAuthDetail.getAmtSvcAuthDtlAmtReq());
      newDetail.setAmtSvcAuthDtlAmtUsed(svcAuthDetail.getAmtSvcAuthDtlAmtUsed());
      newDetail.setNbrSvcAuthDtlFreq(svcAuthDetail.getNbrSvcAuthDtlFreq());
      newDetail.setNbrSvcAuthDtlLineItm(svcAuthDetail.getNbrSvcAuthDtlLineItm());
      newDetail.setNbrSvcAuthDtlSugUnit(svcAuthDetail.getNbrSvcAuthDtlSugUnit());
      newDetail.setNbrSvcAuthDtlUnitRate(svcAuthDetail.getNbrSvcAuthDtlUnitRate());
      newDetail.setNbrSvcAuthDtlUnitsReq(svcAuthDetail.getNbrSvcAuthDtlUnitsReq());
      newDetail.setNbrSvcAuthDtlUnitUsed(svcAuthDetail.getNbrSvcAuthDtlUnitUsed());
      newDetail.setIndServAcpt(svcAuthDetail.getIndServAcpt());
      newDetail.setIndCasePlnSvc(svcAuthDetail.getIndCasePlnSvc());
      newDetail.setCdSvcQlty(svcAuthDetail.getCdSvcQlty());
      newDetail.setTxtCmmts(svcAuthDetail.getTxtCmmts());
      newDetail.setSpecialNeedsDetermination(specNeedsDeter);
      svcAuthDetailDAO.saveSvcAuthDetail(newDetail);
      endDateOldSvcAuthDetail(svcAuthDetail);

    }

  }

  private int insertAdoAsstAgreementRecord(AdoptionSubsidy adoSubsidy, Person newPerson, CapsCase newCapsCase,
                                           int idAdpAsstAppEvent, int idNewPlcmtEvent) {
    AdoptionSubsidy newAdoSubsidy = new AdoptionSubsidy();
    newAdoSubsidy.setIdAdptSub(0);
    newAdoSubsidy.setDtLastUpdate(null);
    newAdoSubsidy.setPlacement((Placement) getPersistentObject(Placement.class, idNewPlcmtEvent));
    newAdoSubsidy.setPerson(newPerson);
    if (idAdpAsstAppEvent > 0) {
      newAdoSubsidy
                   .setSpecialNeedsDetermination((SpecialNeedsDetermination) getPersistentObject(
                                                                                                 SpecialNeedsDetermination.class,
                                                                                                 idAdpAsstAppEvent));
    }
    populate_newAdoAsstAgreement(adoSubsidy, newAdoSubsidy);
    int idAdoSub = adoptionSubsidyDAO.saveAdoptionSubsidy(newAdoSubsidy);
    return idAdoSub;
  }

  private void insertElligibilityRecord(Eligibility eligibility, Person newPerson, int idNewEligEvent,
                                        CapsCase newCapsCase, Person primaryCaseWorker) {
    Eligibility newEligibility = new Eligibility();
    newEligibility.setIdEligEvent(idNewEligEvent);
    newEligibility.setDtLastUpdate(null);
    newEligibility.setEvent((Event) getPersistentObject(Event.class, idNewEligEvent));
    newEligibility.setCapsCase(newCapsCase);
    newEligibility.setPersonByIdPerson(newPerson);
    newEligibility.setPersonByIdPersonUpdate(primaryCaseWorker);
    populate_newEligibility(eligibility, newEligibility);
    eligibilityDAO.saveEligibility(newEligibility);
  }

  private void insertAaFundingRecord(AaFunding adoAaFunding, Person newPerson, int idNewAaFundingEvent,
                                     Person primaryCaseWorker) {
    
    Event padAaFundingEvent = eventDAO.findEventByIdEvent(idNewAaFundingEvent);

    AaFunding padAaFunding = new AaFunding();
    padAaFunding.setEvent(padAaFundingEvent); // replace with new pad Event
    padAaFunding.setIdAaFundingEvent(idNewAaFundingEvent); // replace with new pad event id
    padAaFunding.setChild(newPerson); // replace with new PAD child

    populate_newAAFundingSummary(adoAaFunding, padAaFunding);
    
    aaFundingDAO.saveAaFunding(padAaFunding);

    // refresh object from db after save
    padAaFunding = aaFundingDAO.findAAfundingByIdEvent(idNewAaFundingEvent);

    // Loop through any AAFundingReasonElig for ADO stage and copy over for new PAD stage AA Funding event.
    Collection<AaFundingReasonElig> adoAaFundingReasonEligs = adoAaFunding.getAaFundingReasonEligs();
    if(adoAaFundingReasonEligs != null){
      Iterator<AaFundingReasonElig> iter = adoAaFundingReasonEligs.iterator();

      while (iter.hasNext()) {
        AaFundingReasonElig adoAaFundingReasonElig = iter.next();
        // update to new event
        AaFundingReasonElig padAaFundingReasonElig = new AaFundingReasonElig();
        padAaFundingReasonElig.setIdAaFundingReasonElig(0); // new reason elig record for new PAD event
        padAaFundingReasonElig.setDtLastUpdate(new Date()); // last update as of stage progression
        padAaFundingReasonElig.setAaFunding(padAaFunding);
        padAaFundingReasonElig.setCdAaFundingRsn(adoAaFundingReasonElig.getCdAaFundingRsn());

        aaFundingReasonEligDAO.saveAaFundingReasonElig(padAaFundingReasonElig);
      }
    }
  }

  private void insertApprovalEventRecords(Person primaryCaseWorker, int idNewStage, CapsCase newCapsCase,
                                          int idNewPlcmtEvent, int idOldPlcmtEvent, String cdTxtApprovalTopic,
                                          String eventType, String cdAppTask) {

    Event approvalEvent = new Event();
    approvalEvent.setIdEvent(0);
    approvalEvent.setDtLastUpdate(null);
    approvalEvent.setDtEventOccurred(new Date());
    approvalEvent.setCapsCase(newCapsCase);
    approvalEvent.setCdEventStatus(APP_EVENT_STATUS);
    approvalEvent.setCdEventType(eventType);
    approvalEvent.setCdTask(cdAppTask);
    approvalEvent.setStage((Stage) getPersistentObject(Stage.class, idNewStage));
    approvalEvent.setPerson(primaryCaseWorker);
    approvalEvent.setTxtEventDescr(cdTxtApprovalTopic);
    int idAppEvent = eventDAO.saveEventReturnsEventId(approvalEvent);
    // Insert approval event. Since we are just copying the existing placement from ADO stage
    // to PAD stage only the latest approval event will be copied.
    if (idAppEvent > 0) {
      // Insert Approval record
      Approval approval = new Approval();
      approval.setDtLastUpdate(null);
      approval.setIdApproval(idAppEvent);
      approval.setPerson(primaryCaseWorker);
      approvalDAO.insertApproval(idAppEvent, primaryCaseWorker.getIdPerson(), cdTxtApprovalTopic);
      int nbrRows = insertApprovalEventLink(idAppEvent, idNewPlcmtEvent, newCapsCase.getIdCase());
      if (nbrRows > 0) {
        // Retrieve the latest approvers record for the placement event in ADO stage
        // This is necessary to get the approvers id.
        Approvers approver = approversDAO.findApproverByIdEvent(idOldPlcmtEvent);
        if (approver != null) {
          approversDAO.insertApprovers(EVENT_STATUS, new Date(), new Date(), idAppEvent,
                                       primaryCaseWorker.getIdPerson(), 0, ArchitectureConstants.N, "");
        }
      }
    }
  }

  private int insertApprovalEventLink(int idApproval, int idNewPlcmtEvent, int idCase) {
    int idAppEventLink = approvalEventLinkDAO.insertNewApprovalEventLink(idNewPlcmtEvent, idApproval, idCase);
    return idAppEventLink;
  }

  private void insertStageLink(int idStage, int idNewCase, int idNewStage) {
    StageLink stageLink = new StageLink();
    CapsCase newCapscase = (CapsCase) getPersistentObject(CapsCase.class, idNewCase);
    stageLink.setCapsCase(newCapscase);
    stageLink.setDtLastUpdate(null);
    stageLink.setIdStageLink(0);
    stageLink.setStageByIdPriorStage((Stage) getPersistentObject(Stage.class, idStage));
    stageLink.setStageByIdStage((Stage) getPersistentObject(Stage.class, idNewStage));
    stageLinkDAO.saveStageLink(stageLink);
  }

  private void insertStagePersonLink(int idNewStage, int newPersonId, int idNewCase, String relInt, String persRole,
                                     String persType) {
    StagePersonLink stagePersonLink = new StagePersonLink();
    stagePersonLink.setCapsCase((CapsCase) getPersistentObject(CapsCase.class, idNewCase));
    stagePersonLink.setCdStagePersRelInt(relInt);
    stagePersonLink.setCdStagePersRole(persRole);
    stagePersonLink.setCdStagePersType(persType);
    stagePersonLink.setDtLastUpdate(null);
    stagePersonLink.setDtStagePersLink(new Date());
    stagePersonLink.setIdStagePersonLink(0);
    stagePersonLink.setIndStagePersEmpNew("1");
    stagePersonLink.setPerson((Person) getPersistentObject(Person.class, newPersonId));
    stagePersonLink.setStage((Stage) getPersistentObject(Stage.class, idNewStage));
    stagePersonLinkDAO.saveStagePersonLink(stagePersonLink);
  }

  private int getCaseManagerIdUnit(int idCaseManager) {
    UnitEmpLink unitEmpLink = unitEmpLinkDAO
                                            .findUnitFromUnitAndUnitEmpLinkByIdPersonCDUnitMemberInOut(
                                                                                                       idCaseManager,
                                                                                                       CodesTables.CUMINOUT_IN);
    int idUnit = 0;
    if (unitEmpLink != null && unitEmpLink.getUnit() != null && unitEmpLink.getUnit().getIdUnit() != null) {
      idUnit = unitEmpLink.getUnit().getIdUnit();
    }
    return idUnit;
  }

  private int insertSituationRow(int idNewCase) {
    Situation situation = new Situation();
    situation.setCapsCase((CapsCase) getPersistentObject(CapsCase.class, idNewCase));
    situation.setDtLastUpdate(null);
    situation.setDtSituationOpened(new Date());
    situation.setIdSituation(0);
    Integer idSituation = situationDAO.saveNewSituation(situation);
    return idSituation;
  }

  private void insertAdtptSubEventLink(int idNewAdoAsstAgrEvent, int idNewAdoSub, CapsCase newCapsCase) {
    AdptSubEventLink adptSubEventLink = new AdptSubEventLink();
    adptSubEventLink.setAdoptionSubsidy((AdoptionSubsidy) getPersistentObject(AdoptionSubsidy.class, idNewAdoSub));
    adptSubEventLink.setCapsCase(newCapsCase);
    adptSubEventLink.setEvent((Event) getPersistentObject(Event.class, idNewAdoAsstAgrEvent));
    adptSubEventLink.setDtLastUpdate(null);
    adptSubEventLink.setIdAdptSubEventLink(0);
    adptSubEventLinkDAO.saveAdptSubEventLink(adptSubEventLink);
  }

  private void assignPadStage(int idNewCase, int idNewStage, int idPerson) {
    String persRole = CodesTables.CSTFROLS_PR;
    String persType = CodesTables.CPRSNALL_STF;
    stagePersonLinkDAO.insertNewStagePersonLink(idNewStage, idPerson, idNewCase, persRole, persType, new Date());

    Person pers = (Person) getPersistentObject(Person.class, idPerson);
    CapsCase capsCase = (CapsCase) getPersistentObject(CapsCase.class, idNewCase);
    Stage stage = (Stage) getPersistentObject(Stage.class, idNewStage);

    Todo todo = new Todo();
    todo.setCdTodoTask("");
    todo.setCdTodoType(CodesTables.CTODOTYP_A);
    todo.setDtTodoTaskDue(null);
    todo.setDtTodoCreated(new Date());
    todo.setDtTodoCompleted(new Date());
    todo.setDtTodoDue(new Date());
    todo.setTxtTodoLongDesc(null);
    todo.setPersonByIdTodoPersCreator(pers);
    todo.setCapsCase(capsCase);
    todo.setIdTodo(0);
    todo.setStage(stage);
    todo.setTxtTodoDesc("New Primary Assignment");
    todo.setPersonByIdTodoPersWorker(pers);
    todo.setPersonByIdTodoPersAssigned(pers);
    todoDAO.saveTodo(todo);
  }

  private void assignSecondaryPadStage(int idNewCase, int idNewStage, int idPerson) {
    String persRole = CodesTables.CSTFROLS_SE;
    String persType = CodesTables.CPRSNALL_STF;
    stagePersonLinkDAO.insertNewStagePersonLink(idNewStage, idPerson, idNewCase, persRole, persType, new Date());

    Person pers = (Person) getPersistentObject(Person.class, idPerson);
    CapsCase capsCase = (CapsCase) getPersistentObject(CapsCase.class, idNewCase);
    Stage stage = (Stage) getPersistentObject(Stage.class, idNewStage);

    Todo todo = new Todo();
    todo.setCdTodoTask("");
    todo.setCdTodoType(CodesTables.CTODOTYP_A);
    todo.setDtTodoTaskDue(null);
    todo.setDtTodoCreated(new Date());
    todo.setDtTodoCompleted(new Date());
    todo.setDtTodoDue(new Date());
    todo.setTxtTodoLongDesc(null);
    todo.setPersonByIdTodoPersCreator(pers);
    todo.setCapsCase(capsCase);
    todo.setIdTodo(0);
    todo.setStage(stage);
    todo.setTxtTodoDesc(pers.getNmPersonFull() + " assigned as a secondary to PAD stage for " + stage.getNmStage());
    todo.setPersonByIdTodoPersWorker(pers);
    todo.setPersonByIdTodoPersAssigned(pers);
    todoDAO.saveTodo(todo);
  }

  private void endDatePlcmtRecordInAdoStage(Placement placement) {
    placement.setDtPlcmtEnd(new Date());
    placement.setCdPlcmtRemovalRsn(CodesTables.CRMRSNAC_ADF);
    placementDAO.savePlacement(placement);
    Event event = getPersistentObject(Event.class, placement.getIdPlcmtEvent());
    String evntDesc = generateEventDescr(DateHelper.toCastorDate(placement.getDtPlcmtStart()),
                                         DateHelper.toCastorDate(new Date()), placement.getNmPlcmtFacil());
    event.setTxtEventDescr(evntDesc);
    eventDAO.saveEvent(event);
  }

  private void endDateAdoAsstAgreement(AdoptionSubsidy adoptionSubsidy) {
    adoptionSubsidy.setDtAdptSubTerminated(new Date());
    adoptionSubsidy.setCdAdptSubCloseRsn(CodesTables.CSUBCLOS_AF);
    adoptionSubsidy.setTxtAdptSubRsn("Adoption Finalized - automatic system closure");
    adoptionSubsidyDAO.saveAdoptionSubsidy(adoptionSubsidy);
  }
  
  private void endDateOldSvcAuthDetail(SvcAuthDetail svcAuthDetail) {
    Date today = new Date();
    svcAuthDetail.setDtSvcAuthDtlTerm(today);
    svcAuthDetail.setDtSvcAuthDtlEnd(today);
    svcAuthDetail.setCdSvcAuthDtlAuthType(CodesTables.CSVATYPE_TRM);
    svcAuthDetail.setTxtCmmts(SVC_AUTH_DTL_COMMENT); 
    svcAuthDetailDAO.saveSvcAuthDetail(svcAuthDetail);
  }
  

  private void endDateAdoAsstApplication(SpecialNeedsDetermination spclNeedsDet) {
    if (ArchitectureConstants.Y.equals(spclNeedsDet.getIndSpclReqApproved())) {
      Date dtExpiration = spclNeedsDet.getDtExpirationDate();
      Date today = new Date();
      if (dtExpiration == null || today.before(dtExpiration)) {
        spclNeedsDet.setDtExpirationDate(today);
      }
      spclNeedsDet.setTxtComments("Adoption Finalized - automatic system closure");
      specialNeedsDeterminationDAO.saveSpecialNeedsDetermination(spclNeedsDet);
    }
  }

  private void endDateEligibility(Eligibility eligibility) {
    eligibility.setDtEligEnd(new Date());
    eligibility.setCdFceEligReason(CodesTables.CELIGCHG_OTH);
    eligibility.setTxtEligComment("Adoption Finalized - automatic system closure");
    eligibilityDAO.saveEligibility(eligibility);
  }

  private void populateNewPlacement(Placement newPlcmtRecord, Placement placement, Person newPerson) {
    newPlcmtRecord.setAddrPlcmtCity(placement.getAddrPlcmtCity());
    newPlcmtRecord.setAddrPlcmtCnty(placement.getAddrPlcmtCnty());
    newPlcmtRecord.setAddrPlcmtLn1(placement.getAddrPlcmtLn1());
    newPlcmtRecord.setAddrPlcmtLn2(placement.getAddrPlcmtLn2());
    newPlcmtRecord.setAddrPlcmtSt(placement.getAddrPlcmtSt());
    newPlcmtRecord.setAddrPlcmtZip(placement.getAddrPlcmtZip());
    newPlcmtRecord.setCapsResourceByIdRsrcAgency(placement.getCapsResourceByIdRsrcAgency());
    newPlcmtRecord.setCapsResourceByIdRsrcFacil(placement.getCapsResourceByIdRsrcFacil());
    newPlcmtRecord.setCdAdoType(placement.getCdAdoType());
    newPlcmtRecord.setCdBoardingCnty(placement.getCdBoardingCnty());
    newPlcmtRecord.setCdContactMethod(placement.getCdContactMethod());
    newPlcmtRecord.setCdPlcmtActPlanned(placement.getCdPlcmtActPlanned());
    newPlcmtRecord.setCdPlcmtAdptBy(placement.getCdPlcmtAdptBy());
    newPlcmtRecord.setCdPlcmtCcfa(placement.getCdPlcmtCcfa());
    newPlcmtRecord.setCdPlcmtInfo1(placement.getCdPlcmtInfo1());
    newPlcmtRecord.setCdPlcmtInfo10(placement.getCdPlcmtInfo10());
    newPlcmtRecord.setCdPlcmtInfo11(placement.getCdPlcmtInfo11());
    newPlcmtRecord.setCdPlcmtInfo12(placement.getCdPlcmtInfo12());
    newPlcmtRecord.setCdPlcmtInfo13(placement.getCdPlcmtInfo13());
    newPlcmtRecord.setCdPlcmtInfo14(placement.getCdPlcmtInfo14());
    newPlcmtRecord.setCdPlcmtInfo15(placement.getCdPlcmtInfo15());
    newPlcmtRecord.setCdPlcmtInfo16(placement.getCdPlcmtInfo16());
    newPlcmtRecord.setCdPlcmtInfo17(placement.getCdPlcmtInfo17());
    newPlcmtRecord.setCdPlcmtInfo2(placement.getCdPlcmtInfo2());
    newPlcmtRecord.setCdPlcmtInfo3(placement.getCdPlcmtInfo3());
    newPlcmtRecord.setCdPlcmtInfo4(placement.getCdPlcmtInfo4());
    newPlcmtRecord.setCdPlcmtInfo5(placement.getCdPlcmtInfo5());
    newPlcmtRecord.setCdPlcmtInfo6(placement.getCdPlcmtInfo6());
    newPlcmtRecord.setCdPlcmtInfo7(placement.getCdPlcmtInfo7());
    newPlcmtRecord.setCdPlcmtInfo8(placement.getCdPlcmtInfo8());
    newPlcmtRecord.setCdPlcmtInfo9(placement.getCdPlcmtInfo9());
    newPlcmtRecord.setCdPlcmtLivArr(placement.getCdPlcmtLivArr());
    newPlcmtRecord.setCdPlcmtService(placement.getCdPlcmtService());
    newPlcmtRecord.setCdPlcmtSibling(placement.getCdPlcmtSibling());
    newPlcmtRecord.setCdPlcmtType(placement.getCdPlcmtType());
    newPlcmtRecord.setCdTempType(placement.getCdTempType());
    newPlcmtRecord.setCdWaiverType(placement.getCdWaiverType());
    newPlcmtRecord.setContract(placement.getContract());
    newPlcmtRecord.setDtPlcmtLastPrebill(placement.getDtPlcmtLastPrebill());
    newPlcmtRecord.setDtMedCp(placement.getDtMedCp());
    newPlcmtRecord.setDtPlcmtCaregvrDiscuss(placement.getDtPlcmtCaregvrDiscuss());
    newPlcmtRecord.setDtPlcmtChildDiscuss(placement.getDtPlcmtChildDiscuss());
    newPlcmtRecord.setDtPlcmtChildPlan(placement.getDtPlcmtChildPlan());
    newPlcmtRecord.setDtPlcmtEducLog(placement.getDtPlcmtEducLog());
    newPlcmtRecord.setDtPlcmtLastPrebill(placement.getDtPlcmtLastPrebill());
    newPlcmtRecord.setDtPlcmtMeddevHistory(placement.getDtPlcmtMeddevHistory());
    newPlcmtRecord.setDtPlcmtParentsNotif(placement.getDtPlcmtParentsNotif());
    newPlcmtRecord.setDtPlcmtPermEff(placement.getDtPlcmtPermEff());
    newPlcmtRecord.setDtPlcmtPreplaceVisit(placement.getDtPlcmtPreplaceVisit());
    newPlcmtRecord.setDtPlcmtSchoolRecords(placement.getDtPlcmtSchoolRecords());
    newPlcmtRecord.setDtPlcmtStart(new Date());
    newPlcmtRecord.setDtPsyCp(placement.getDtPsyCp());
    newPlcmtRecord.setDtPsyInfo(placement.getDtPsyInfo());
    newPlcmtRecord.setDtTrialCoEnd(placement.getDtTrialCoEnd());
    newPlcmtRecord.setDtTrialCoStart(placement.getDtTrialCoStart());
    newPlcmtRecord.setIndPlcmtAppr(placement.getIndPlcmtAppr());
    newPlcmtRecord.setIndPlcmtCasePlan(placement.getIndPlcmtCasePlan());
    newPlcmtRecord.setIndPlcmtCcfa(placement.getIndPlcmtCcfa());
    newPlcmtRecord.setIndPlcmtContCntct(placement.getIndPlcmtContCntct());
    newPlcmtRecord.setIndPlcmtEducLog(placement.getIndPlcmtEducLog());
    newPlcmtRecord.setIndPlcmtEmerg(placement.getIndPlcmtEmerg());
    newPlcmtRecord.setIndPlcmtFam(placement.getIndPlcmtFam());
    newPlcmtRecord.setIndPlcmtProx(placement.getIndPlcmtProx());
    newPlcmtRecord.setIndPlcmtRestr(placement.getIndPlcmtRestr());
    newPlcmtRecord.setIndPlcmtSafe(placement.getIndPlcmtSafe());
    newPlcmtRecord.setIndPlcmtSchDist(placement.getIndPlcmtSchDist());
    newPlcmtRecord.setIndPlcmtSchoolDoc(placement.getIndPlcmtSchoolDoc());
    newPlcmtRecord.setIndPlcmtSibling(placement.getIndPlcmtSibling());
    newPlcmtRecord.setIndPlcmtTrauma(placement.getIndPlcmtTrauma());
    newPlcmtRecord.setIndSpvsn(placement.getIndSpvsn());
    newPlcmtRecord.setIndTrialHome(placement.getIndTrialHome());
    newPlcmtRecord.setIndWaiverReqd(placement.getIndWaiverReqd());
    newPlcmtRecord.setNbrPlcmtPhoneExt(placement.getNbrPlcmtPhoneExt());
    newPlcmtRecord.setNbrPlcmtSibCare(placement.getNbrPlcmtSibCare());
    newPlcmtRecord.setNbrPlcmtSibChild(placement.getNbrPlcmtSibChild());
    newPlcmtRecord.setNbrPlcmtTelephone(placement.getNbrPlcmtTelephone());
    newPlcmtRecord.setNmPlcmtAgency(placement.getNmPlcmtAgency());
    newPlcmtRecord.setNmPlcmtContact(placement.getNmPlcmtContact());
    newPlcmtRecord.setNmPlcmtFacil(placement.getNmPlcmtFacil());
    newPlcmtRecord.setNmPlcmtPersonFull(placement.getNmPlcmtPersonFull());
    newPlcmtRecord.setPersonByIdContactWrkr(placement.getPersonByIdContactWrkr());
    newPlcmtRecord.setPersonByIdPlcmtAdult(placement.getPersonByIdPlcmtAdult());
    newPlcmtRecord.setPersonByIdPlcmtChild(newPerson);
    newPlcmtRecord.setPolicyWaiver(placement.getPolicyWaiver());
    newPlcmtRecord.setTxtAdoCmnts(placement.getTxtAdoCmnts());
    newPlcmtRecord.setTxtDocCmnts(placement.getTxtDocCmnts());
    newPlcmtRecord.setTxtEduCpContact(placement.getTxtEduCpContact());
    newPlcmtRecord.setTxtEduInfoContact(placement.getTxtEduInfoContact());
    newPlcmtRecord.setTxtMatch(placement.getTxtMatch());
    newPlcmtRecord.setTxtMedCpContact(placement.getTxtMedCpContact());
    newPlcmtRecord.setTxtMedInfoContact(placement.getTxtMedInfoContact());
    newPlcmtRecord.setTxtPlcmtAddrComment(placement.getTxtPlcmtAddrComment());
    newPlcmtRecord.setTxtPlcmtCcfa(placement.getTxtPlcmtCcfa());
    newPlcmtRecord.setTxtPlcmtChecklist(placement.getTxtPlcmtChecklist());
    newPlcmtRecord.setTxtPlcmtDiscussion(placement.getTxtPlcmtDiscussion());
    newPlcmtRecord.setTxtPlcmtDocuments(placement.getTxtPlcmtDocuments());
    newPlcmtRecord.setTxtPlcmtSibling(placement.getTxtPlcmtSibling());
    newPlcmtRecord.setTxtPlcmtTrauma(placement.getTxtPlcmtTrauma());
    newPlcmtRecord.setTxtPsyCpContact(placement.getTxtPsyCpContact());
    newPlcmtRecord.setTxtPsyInfoContact(placement.getTxtPsyInfoContact());
    newPlcmtRecord.setTxtSpvsn(placement.getTxtSpvsn());
    newPlcmtRecord.setTxtTempCmnts(placement.getTxtTempCmnts());
    newPlcmtRecord.setDtPlcmtEnd(DateHelper.MAX_JAVA_DATE);
  }

  private void populate_newMedication(Medication medication, Medication newMedication, int idNewPerson) {
    newMedication.setAddrPharmCity(medication.getAddrPharmCity());
    newMedication.setAddrPharmStLn1(medication.getAddrPharmStLn1());
    newMedication.setAddrPharmStLn2(medication.getAddrPharmStLn2());
    newMedication.setAddrPharmZip(medication.getAddrPharmZip());
    newMedication.setCdAddrPharmState(medication.getCdAddrPharmState());
    newMedication.setCdMedctnDose(medication.getCdMedctnDose());
    newMedication.setDtLastUpdate(null);
    newMedication.setDtMedctnEndDate(medication.getDtMedctnEndDate());
    newMedication.setDtMedctnPresc(medication.getDtMedctnPresc());
    newMedication.setIdMedication(0);
    newMedication.setIndMedctnAllergies(medication.getIndMedctnAllergies());
    newMedication.setNbrPharmPhone(medication.getNbrPharmPhone());
    newMedication.setNmMedctn(medication.getNmMedctn());
    newMedication.setNmPharmacy(medication.getNmPharmacy());
    newMedication.setPerson((Person) getPersistentObject(Person.class, idNewPerson));
    newMedication.setTxtMedctnAdminPerson(medication.getTxtMedctnAdminPerson());
    newMedication.setTxtMedctnCmnts(medication.getTxtMedctnCmnts());
    newMedication.setTxtMedctnDescrip(medication.getTxtMedctnDescrip());
    newMedication.setTxtMedctnPrescPerson(medication.getTxtMedctnPrescPerson());
    newMedication.setTxtMedctnReason(medication.getTxtMedctnReason());
  }

  private void populate_newIncomeResource(IncomeAndResources incomeAndResources,
                                          IncomeAndResources newIncomeAndResources, int idNewPerson) {
    newIncomeAndResources.setAmtIncRsrc(incomeAndResources.getAmtIncRsrc());
    newIncomeAndResources.setAuNumber(incomeAndResources.getAuNumber());
    newIncomeAndResources.setAuStatus(incomeAndResources.getAuStatus());
    newIncomeAndResources.setCaseLoadNumber(incomeAndResources.getCaseLoadNumber());
    newIncomeAndResources.setCdIncRsrcFreqType(incomeAndResources.getCdIncRsrcFreqType());
    newIncomeAndResources.setCdIncRsrcIncome(incomeAndResources.getCdIncRsrcIncome());
    newIncomeAndResources.setCdIncRsrcSrcAddrCounty(incomeAndResources.getCdIncRsrcSrcAddrCounty());
    newIncomeAndResources.setCdIncRsrcType(incomeAndResources.getCdIncRsrcType());
    newIncomeAndResources.setCdProgramType(incomeAndResources.getCdProgramType());
    newIncomeAndResources.setDtIncRsrcFrom(incomeAndResources.getDtIncRsrcFrom());
    newIncomeAndResources.setDtIncRsrcModified(incomeAndResources.getDtIncRsrcModified());
    newIncomeAndResources.setDtIncRsrcTo(incomeAndResources.getDtIncRsrcTo());
    newIncomeAndResources.setDtLastUpdate(null);
    newIncomeAndResources.setIdIncRsrc(null);
    newIncomeAndResources.setPersonByIdIncRsrcWorker(incomeAndResources.getPersonByIdIncRsrcWorker());
    newIncomeAndResources.setPersonByIdPerson((Person) getPersistentObject(Person.class, idNewPerson));
    newIncomeAndResources.setSdsIncRsrcSource(incomeAndResources.getSdsIncRsrcSource());
    newIncomeAndResources.setIndIncRsrcNotAccess(incomeAndResources.getIndIncRsrcNotAccess());
    newIncomeAndResources.setSdsIncRsrcVerfMethod(incomeAndResources.getSdsIncRsrcVerfMethod());
    newIncomeAndResources.setTxtIncRsrcDesc(incomeAndResources.getTxtIncRsrcDesc());
    newIncomeAndResources.setTxtIncRsrcSrcAddrCity(incomeAndResources.getTxtIncRsrcSrcAddrCity());
    newIncomeAndResources.setTxtIncRsrcSrcAddrCmnts(incomeAndResources.getTxtIncRsrcSrcAddrCmnts());
    newIncomeAndResources.setTxtIncRsrcSrcAddrState(incomeAndResources.getTxtIncRsrcSrcAddrState());
    newIncomeAndResources.setTxtIncRsrcSrcAddrStLn1(incomeAndResources.getTxtIncRsrcSrcAddrStLn1());
    newIncomeAndResources.setTxtIncRsrcSrcAddrStLn2(newIncomeAndResources.getTxtIncRsrcSrcAddrStLn2());
    newIncomeAndResources.setTxtIncRsrcSrcAddrZip(newIncomeAndResources.getTxtIncRsrcSrcAddrZip());
    newIncomeAndResources.setTxtIncRsrcSrcPhoneExt(newIncomeAndResources.getTxtIncRsrcSrcPhoneExt());
    newIncomeAndResources.setTxtIncRsrcSrcPhoneNum(newIncomeAndResources.getTxtIncRsrcSrcPhoneNum());
  }

  private void populate_newAdoption_Assistance(SpecialNeedsDetermination spclNeedsDet,
                                               SpecialNeedsDetermination newSpclNeedsDet) {
    newSpclNeedsDet.setCdApprvSpclTypeFunding(spclNeedsDet.getCdApprvSpclTypeFunding());
    newSpclNeedsDet.setCdFundingType(spclNeedsDet.getCdFundingType());
    newSpclNeedsDet.setCdPaymentMthd(spclNeedsDet.getCdPaymentMthd());
    newSpclNeedsDet.setCdSpclSerType(spclNeedsDet.getCdSpclSerType());
    newSpclNeedsDet.setDtApprvDate(spclNeedsDet.getDtApprvDate());
    newSpclNeedsDet.setDtExpirationDate(spclNeedsDet.getDtExpirationDate());
    newSpclNeedsDet.setIndAllSpecialDocAttached(spclNeedsDet.getIndAllSpecialDocAttached());
    newSpclNeedsDet.setIndApprvEmotionalDist(spclNeedsDet.getIndApprvEmotionalDist());
    newSpclNeedsDet.setIndApprvHearingImpaired(spclNeedsDet.getIndApprvHearingImpaired());
    newSpclNeedsDet.setIndApprvMntRetarded(spclNeedsDet.getIndApprvMntRetarded());
    newSpclNeedsDet.setIndApprvOther(spclNeedsDet.getIndApprvOther());
    newSpclNeedsDet.setIndApprvPhysicallyDisabled(spclNeedsDet.getIndApprvPhysicallyDisabled());
    newSpclNeedsDet.setIndAprType(spclNeedsDet.getIndAprType());
    newSpclNeedsDet.setIndBasicRateReqChild(spclNeedsDet.getIndBasicRateReqChild());
    newSpclNeedsDet.setIndChildEmotionallyDisabled(spclNeedsDet.getIndChildEmotionallyDisabled());
    newSpclNeedsDet.setIndChildMntRetarded(spclNeedsDet.getIndChildMntRetarded());
    newSpclNeedsDet.setIndChildOtherMedical(spclNeedsDet.getIndChildOtherMedical());
    newSpclNeedsDet.setIndChildPhysicallyDisabled(spclNeedsDet.getIndChildPhysicallyDisabled());
    newSpclNeedsDet.setIndChildVisHearingImpaired(spclNeedsDet.getIndChildVisHearingImpaired());
    newSpclNeedsDet.setIndDocDevelopmentalAssmt(spclNeedsDet.getIndDocDevelopmentalAssmt());
    newSpclNeedsDet.setIndDocMentalAssmt(spclNeedsDet.getIndDocMentalAssmt());
    newSpclNeedsDet.setIndDocPsychological(spclNeedsDet.getIndDocPsychological());
    newSpclNeedsDet.setIndDocSSI(spclNeedsDet.getIndDocSSI());
    newSpclNeedsDet.setIndDocTrtmntPrvdr(spclNeedsDet.getIndDocTrtmntPrvdr());
    newSpclNeedsDet.setIndReasonSpecialRequest(spclNeedsDet.getIndDocTrtmntPrvdr());
    newSpclNeedsDet.setIndReasonSpecialRequest(spclNeedsDet.getIndReasonSpecialRequest());
    newSpclNeedsDet.setIndSfcRbwoRcvd(spclNeedsDet.getIndSfcRbwoRcvd());
    newSpclNeedsDet.setIndSpcNeedsApproved(spclNeedsDet.getIndSpcNeedsApproved());
    newSpclNeedsDet.setIndSpclRateAdoAppr(spclNeedsDet.getIndSpclRateAdoAppr());
    newSpclNeedsDet.setIndSpclRateReqChild(spclNeedsDet.getIndSpclRateReqChild());
    newSpclNeedsDet.setIndSpclSerReqChild(spclNeedsDet.getIndSpclSerReqChild());
    newSpclNeedsDet.setIndSpclReqApproved(spclNeedsDet.getIndSpclReqApproved());
    newSpclNeedsDet.setIndNonRecOnly(spclNeedsDet.getIndNonRecOnly());
    newSpclNeedsDet.setNbrApprvAmt(spclNeedsDet.getNbrApprvAmt());
    newSpclNeedsDet.setNbrIvbAmt(spclNeedsDet.getNbrIvbAmt());
    newSpclNeedsDet.setNbrIveAmt(spclNeedsDet.getNbrIveAmt());
    newSpclNeedsDet.setNbrReqAmt(spclNeedsDet.getNbrReqAmt());
    newSpclNeedsDet.setNbrTotalIveIvbAmt(spclNeedsDet.getNbrTotalIveIvbAmt());
    newSpclNeedsDet.setIndNonRecApproved(spclNeedsDet.getIndNonRecApproved());
    newSpclNeedsDet.setNbrNonRecAprvAmt(spclNeedsDet.getNbrNonRecAprvAmt());
    newSpclNeedsDet.setIndNonRecRequested(spclNeedsDet.getIndNonRecRequested());
    newSpclNeedsDet.setNbrNonRecAmt(spclNeedsDet.getNbrNonRecAmt());
    newSpclNeedsDet.setNbrSpNeedsChildrenRequest(spclNeedsDet.getNbrSpNeedsChildrenRequest());
    newSpclNeedsDet.setTxtApprvOtherCmt(spclNeedsDet.getTxtApprvOtherCmt());
    newSpclNeedsDet.setTxtCmntsEmotionallyDisabled(spclNeedsDet.getTxtCmntsEmotionallyDisabled());
    newSpclNeedsDet.setTxtCmntsMntRetarded(spclNeedsDet.getTxtCmntsMntRetarded());
    newSpclNeedsDet.setTxtCmntsOtherMedical(spclNeedsDet.getTxtCmntsOtherMedical());
    newSpclNeedsDet.setTxtCmntsPhysicallyDisabled(spclNeedsDet.getTxtCmntsPhysicallyDisabled());
    newSpclNeedsDet.setTxtCmntsVisHearingImpaired(spclNeedsDet.getTxtCmntsVisHearingImpaired());
    newSpclNeedsDet.setTxtCmntsSpecialRequest(spclNeedsDet.getTxtCmntsVisHearingImpaired());
    newSpclNeedsDet.setTxtComments(spclNeedsDet.getTxtComments());
    newSpclNeedsDet.setTxtPleaseSpecify(spclNeedsDet.getTxtPleaseSpecify());
    //STGAP00014952: Copy over the new fields added to the application to the PAD stage
    newSpclNeedsDet.setCdBasicRateType(spclNeedsDet.getCdBasicRateType());
    newSpclNeedsDet.setNbrCountyAddonAmt(spclNeedsDet.getNbrCountyAddonAmt());
    newSpclNeedsDet.setNbrBasicRateAmt(spclNeedsDet.getNbrBasicRateAmt());
    newSpclNeedsDet.setDtSpclNeedsApprvd(spclNeedsDet.getDtSpclNeedsApprvd());
    newSpclNeedsDet.setTxtAdditionalComments(spclNeedsDet.getTxtAdditionalComments());
    
    //MR-60 changes
    newSpclNeedsDet.setCdSpcNdsPrePosReq(spclNeedsDet.getCdSpcNdsPrePosReq());
    newSpclNeedsDet.setCdSpcNdsPrePosApr(spclNeedsDet.getCdSpcNdsPrePosApr());
  }
  
 private ServiceAuthorization populate_New_ServiceAuth(Map copiedServiceAuth, Person newPerson) {   
    ServiceAuthorization newSvcAuth = new ServiceAuthorization();
    int idSvcAuth = commonDAO.getNextval("SEQ_SERVICE_AUTHORIZATION");
    newSvcAuth.setIdSvcAuth(idSvcAuth);
    newSvcAuth.setDtLastUpdate(null);
    newSvcAuth.setCdSvcAuthCounty((String) copiedServiceAuth.get("cdSvcAuthCounty"));
    Integer idResource = (Integer) copiedServiceAuth.get("idResource");
    if(idResource != null){
    CapsResource resource = getPersistentObject(CapsResource.class, idResource);
    newSvcAuth.setCapsResource(resource);
    }
    Integer idContract = (Integer) copiedServiceAuth.get("idContract");
    if(idContract != null){
    Contract contract = getPersistentObject(Contract.class, idContract);
    newSvcAuth.setContract(contract);
    }
    Integer idPrimaryClient = (Integer) copiedServiceAuth.get("idPrimaryClient");
    if(idPrimaryClient != null){
    Person primaryClient = getPersistentObject(Person.class, idPrimaryClient);
    newSvcAuth.setPersonByIdPrimaryClient(primaryClient);
    }
    newSvcAuth.setPersonByIdPerson(newPerson);
    newSvcAuth.setCdSvcAuthAbilToRespond((String) copiedServiceAuth.get("cdSvcAuthAbilToRespond"));
    newSvcAuth.setCdSvcAuthCategory(SPC_SER_SVC_PROG_CAT);
    newSvcAuth.setCdSvcAuthRegion((String) copiedServiceAuth.get("cdSvcAuthRegion"));
    newSvcAuth.setCdSvcAuthService((String) copiedServiceAuth.get("cdSvcAuthService"));
    newSvcAuth.setDtSvcAuthVerbalReferl((Date) copiedServiceAuth.get("dtSvcAuthVerbalReferl"));
    newSvcAuth.setCdSvcAuthCounty((String) copiedServiceAuth.get("cdSvcAuthCounty"));
    newSvcAuth.setDtSvcAuthEff((Date) copiedServiceAuth.get("dtSvcAuthEff"));
    newSvcAuth.setIndSvcAuthComplete((String) copiedServiceAuth.get("indSvcAuthComplete"));
    newSvcAuth.setTxtSvcAuthComments((String) copiedServiceAuth.get("txtSvcAuthComments"));
    newSvcAuth.setTxtSvcAuthDirToHome((String) copiedServiceAuth.get("txtSvcAuthDirToHome"));
    newSvcAuth.setTxtSvcAuthHomeEnviron((String) copiedServiceAuth.get("txtSvcAuthHomeEnviron"));
    newSvcAuth.setTxtSvcAuthMedCond((String) copiedServiceAuth.get("txtSvcAuthMedCond"));
    newSvcAuth.setTxtSvcAuthSecProvdr((String) copiedServiceAuth.get("txtSvcAuthSecProvdr"));
    newSvcAuth.setIndDontdComntySvc((String) copiedServiceAuth.get("indDontdComntySvc"));
    newSvcAuth.setAmtEstValue((Double) copiedServiceAuth.get("amtEstValue"));
    newSvcAuth.setCdPayCnty((String) copiedServiceAuth.get("cdPayCnty"));
    newSvcAuth.setIndWaiverReqd((String) copiedServiceAuth.get("indWaiverReqd"));
    newSvcAuth.setIdWaiver((Integer) copiedServiceAuth.get("idWaiver"));
    newSvcAuth.setDtRefSent((Date) copiedServiceAuth.get("dtRefSent"));
    newSvcAuth.setCdErlyCaseTyp((String) copiedServiceAuth.get("cdErlyCaseTyp"));
    newSvcAuth.setCdPupTyp((String) copiedServiceAuth.get("cdPupTyp"));
    newSvcAuth.setCdPupOtcme((String) copiedServiceAuth.get("cdPupOtcme"));    
    return newSvcAuth; 
  }


  
  private void populate_newAdoAsstAgreement(AdoptionSubsidy adoSubsidy, AdoptionSubsidy newAdoSubsidy) {
    newAdoSubsidy.setAmtAdptSub(adoSubsidy.getAmtAdptSub());
    newAdoSubsidy.setAmtSpclAsstReq(adoSubsidy.getAmtSpclAsstReq());
    newAdoSubsidy.setCapsResource(adoSubsidy.getCapsResource());
    newAdoSubsidy.setCdAdptSubCloseRsn(adoSubsidy.getCdAdptSubCloseRsn());
    newAdoSubsidy.setCdAdptSubDeterm(adoSubsidy.getCdAdptSubDeterm());
    newAdoSubsidy.setCdPaymentMthd(adoSubsidy.getCdPaymentMthd());
    newAdoSubsidy.setCdSpclAsstType(adoSubsidy.getCdSpclAsstType());
    newAdoSubsidy.setDtAdptSubAgreeRetn(adoSubsidy.getDtAdptSubAgreeRetn());
    newAdoSubsidy.setDtAdptSubAgreeSent(adoSubsidy.getDtAdptSubAgreeSent());
    newAdoSubsidy.setDtAdptSubAppReturned(adoSubsidy.getDtAdptSubAppReturned());
    newAdoSubsidy.setDtAdptSubApprvd(adoSubsidy.getDtAdptSubAppReturned());
    newAdoSubsidy.setDtAdptSubApprvd(adoSubsidy.getDtAdptSubApprvd());
    newAdoSubsidy.setDtAdptSubAppSent(adoSubsidy.getDtAdptSubAppSent());
    newAdoSubsidy.setDtAdptSubEnd(adoSubsidy.getDtAdptSubEnd());
    newAdoSubsidy.setDtAdptSubEffective(adoSubsidy.getDtAdptSubEffective());
    newAdoSubsidy.setDtAdptSubLastInvc(adoSubsidy.getDtAdptSubLastInvc());
    newAdoSubsidy.setDtAdptSubTerminated(adoSubsidy.getDtAdptSubTerminated());
    newAdoSubsidy.setDtRenwlEffBegin(adoSubsidy.getDtRenwlEffBegin());
    newAdoSubsidy.setDtRenwlEffEnd(adoSubsidy.getDtRenwlEffEnd());
    newAdoSubsidy.setIndAdptSubProcess(adoSubsidy.getIndAdptSubProcess());
    newAdoSubsidy.setIndAdptSubThirdParty(adoSubsidy.getIndAdptSubThirdParty());
    newAdoSubsidy.setIndDocSsi(adoSubsidy.getIndDocSsi());
    newAdoSubsidy.setIndNonIncSSA(adoSubsidy.getIndNonIncSSA());
    newAdoSubsidy.setIndSauConf(adoSubsidy.getIndSauConf());
    newAdoSubsidy.setIndSchoolVer(adoSubsidy.getIndSchoolVer());
    newAdoSubsidy.setIndSpclAsstApprvl(adoSubsidy.getIndSpclAsstApprvl());
    newAdoSubsidy.setTxtAdptSubRsn(adoSubsidy.getTxtAdptSubRsn());
    newAdoSubsidy.setTxtIcamaComments(adoSubsidy.getTxtIcamaComments());
    newAdoSubsidy.setTxtSpclAsstCmnts(adoSubsidy.getTxtSpclAsstCmnts());
    newAdoSubsidy.setTxtSpclAsstSpecify(adoSubsidy.getTxtSpclAsstSpecify());
    //STGAP00014952: Copy over the new columns added to the agreement table to the PAD stage
    newAdoSubsidy.setCdBasicRateType(adoSubsidy.getCdBasicRateType());
    newAdoSubsidy.setNbrCountyAddonAmt(adoSubsidy.getNbrCountyAddonAmt());
  }

  private void populate_newEligibility(Eligibility eligibility, Eligibility newEligibility) {
    //STGAP00014187: Removed the copy of reason to the new Eligibility as it's not end dated
    newEligibility.setCdEligActual(eligibility.getCdEligActual());
    newEligibility.setCdEligCsupQuest1(eligibility.getCdEligCsupQuest1());
    newEligibility.setCdEligCsupQuest2(eligibility.getCdEligCsupQuest2());
    newEligibility.setCdEligCsupQuest3(eligibility.getCdEligCsupQuest3());
    newEligibility.setCdEligCsupQuest4(eligibility.getCdEligCsupQuest4());
    newEligibility.setCdEligCsupQuest5(eligibility.getCdEligCsupQuest5());
    newEligibility.setCdEligCsupQuest6(eligibility.getCdEligCsupQuest6());
    newEligibility.setCdEligCsupQuest7(eligibility.getCdEligCsupQuest7());
    newEligibility.setCdEligMedEligGroup(eligibility.getCdEligMedEligGroup());
    newEligibility.setCdEligSelected(eligibility.getCdEligSelected());
    newEligibility.setDtEligCsupReferral(eligibility.getDtEligCsupReferral());
    newEligibility.setDtEligEnd(DateHelper.MAX_JAVA_DATE);
    newEligibility.setDtEligReview(eligibility.getDtEligReview());
    //STGAP00014345: Start Date in the PAD stage should continue to display the Start Date from the FCC stage
    newEligibility.setDtEligStart(eligibility.getDtEligStart());
    newEligibility.setIndEligCsupSend(eligibility.getIndEligCsupSend());
    newEligibility.setIndEligWriteHistory(eligibility.getIndEligWriteHistory());
  }

  private void populate_newAAFundingSummary(AaFunding adoAaFunding, AaFunding padAaFunding) {
    padAaFunding.setEligibility(adoAaFunding.getEligibility());
    padAaFunding.setEmployee(adoAaFunding.getEmployee());
    padAaFunding.setDtLastUpdate(new Date());
    padAaFunding.setCdAaFundingType(adoAaFunding.getCdAaFundingType());
    padAaFunding.setDtAaFundingValidated(adoAaFunding.getDtAaFundingValidated());
    padAaFunding.setDtAcSiblingDob(adoAaFunding.getDtAcSiblingDob());
    padAaFunding.setDtChildDob(adoAaFunding.getDtChildDob());
    padAaFunding.setDtCreated(adoAaFunding.getDtCreated());
    padAaFunding.setIndAcAgeMet(adoAaFunding.getIndAcAgeMet());
    padAaFunding.setIndAcChildOfMinorMet(adoAaFunding.getIndAcChildOfMinorMet());
    padAaFunding.setIndAcIvePriorAdoptMet(adoAaFunding.getIndAcIvePriorAdoptMet());
    padAaFunding.setIndAcSiblingMet(adoAaFunding.getIndAcSiblingMet());
    padAaFunding.setIndAcSsiEligMet(adoAaFunding.getIndAcSsiEligMet());
    padAaFunding.setIndAcTimeInFosterMet(adoAaFunding.getIndAcTimeInFosterMet());
    padAaFunding.setIndAcTprCtwVsMet(adoAaFunding.getIndAcTprCtwVsMet());
    padAaFunding.setIndNacAfdcMet(adoAaFunding.getIndNacAfdcMet());
    padAaFunding.setIndNacChildOfMinorMet(adoAaFunding.getIndNacChildOfMinorMet());
    padAaFunding.setIndNacIvePriorAdoptMet(adoAaFunding.getIndNacIvePriorAdoptMet());
    padAaFunding.setIndNacSsiEligMet(adoAaFunding.getIndNacSsiEligMet());
    padAaFunding.setIndNonRecurringReq(adoAaFunding.getIndNonRecurringReq());
    padAaFunding.setNbrAcSiblingAge(adoAaFunding.getNbrAcSiblingAge());
    padAaFunding.setNbrAcSiblingMthsInFoster(adoAaFunding.getNbrAcSiblingMthsInFoster());
    padAaFunding.setNbrChildAge(adoAaFunding.getNbrChildAge());
    padAaFunding.setNbrChildMthsInFoster(adoAaFunding.getNbrChildMthsInFoster());
    padAaFunding.setNbrFfy(adoAaFunding.getNbrFfy());
    padAaFunding.setNmAcSiblingFullName(adoAaFunding.getNmAcSiblingFullName());
    padAaFunding.setSibling(adoAaFunding.getSibling());
    padAaFunding.setTxtComments(adoAaFunding.getTxtComments());
  }

  private void markFadStageSealed(int idPlcmtResource) {
    //52233: find the latest legal status Adoption Finalized Effective Date of any child placed in the resource.
    Date dateAdoFinalized = legalStatusDAO.findMostRecentAdoFinalizedDate(idPlcmtResource);
    Integer idFadStage = capsResourceDAO.findIdFadStageByIdResource(idPlcmtResource);
    if (idFadStage != null && idFadStage > 0) {
      Stage fadStage = getPersistentObject(Stage.class, idFadStage);
      if (fadStage != null) {
        fadStage.setIndStageSealed(ArchitectureConstants.Y);
        fadStage.setDtStageSealed(dateAdoFinalized);
        stageDAO.saveOrUpdateStage(fadStage);
      }
    }
  }

  /**
   * This method will generate the Event Description
   * 
   * @param request
   *                The request object to get data from jsps.
   * @return eventDescr StringBuffer.toString()
   */
  private static String generateEventDescr(org.exolab.castor.types.Date dtStart, org.exolab.castor.types.Date dtEnd,
                                           String nmResource) {
    StringBuffer eventDescr = new StringBuffer(0);
    String type = CodesTables.CPLMNTYP_ADH;
    // Start Date<placement start date> End Date <placement end date>
    // <Person name OR Placement name> <Placement Type>
    eventDescr.append("Start Date").append(FormattingHelper.formatDate(dtStart));

    eventDescr.append(" End Date ").append(FormattingHelper.formatDate(dtEnd)).append(" ");
    nmResource = StringHelper.truncate(nmResource, 14);
    eventDescr.append(nmResource).append(" ");
    eventDescr.append(type);
    return eventDescr.toString();
  }

  private void updateExchangeChild(CapsResource plcmtResource, LegalStatus legalStatus, int idChild) {
    if (plcmtResource != null && legalStatus != null) {
      String cdRsrcCategory = plcmtResource.getCdRsrcCategory();
      int idResource = plcmtResource.getIdResource();
      Date dtFinal = legalStatus.getDtLegalStatStatusDt();
      Date dtFinalEntered = legalStatus.getEvent().getDtEventOccurred();
      ExchangeChild exchangeChild = exchangeChildDAO.findMostRecentExchangeChildRecordByIdPerson(idChild);
      if (exchangeChild != null) {
        Event exchangeChildEvent = getPersistentObject(Event.class, exchangeChild.getIdEvent());
        if (cdRsrcCategory != null) {
          if (CodesTables.CFACATEG_A.equals(cdRsrcCategory)) {
            exchangeChild.setCdNonAvailStatus(CodesTables.CANONAV_09);
          }
          if (CodesTables.CFACATEG_F.equals(cdRsrcCategory)) {
            exchangeChild.setCdNonAvailStatus(CodesTables.CANONAV_10);
          }
          if (CodesTables.CFACATEG_L.equals(cdRsrcCategory)) {
            exchangeChild.setCdNonAvailStatus(CodesTables.CANONAV_12);
          }
          if (CodesTables.CFACATEG_I.equals(cdRsrcCategory)) {
            exchangeChild.setCdNonAvailStatus(CodesTables.CANONAV_10);
          }
          if (CodesTables.CFACATEG_J.equals(cdRsrcCategory)) {
            exchangeChild.setCdNonAvailStatus(CodesTables.CANONAV_09);
          }
          if (CodesTables.CFACATEG_D.equals(cdRsrcCategory)) {
            exchangeChild.setCdNonAvailStatus(CodesTables.CANONAV_15);
          }
          if (CodesTables.CFACATEG_O.equals(cdRsrcCategory)) {
            exchangeChild.setCdNonAvailStatus(CodesTables.CANONAV_16);
          }
        }
        exchangeChild.setDtFinal(dtFinal);
        exchangeChild.setDtFinalEntered(dtFinalEntered);
        exchangeChildDAO.saveExchangeChild(exchangeChild);
        if (exchangeChildEvent != null) {
          exchangeChildEvent.setCdEventStatus(CodesTables.CEVTSTAT_COMP);
          eventDAO.saveEvent(exchangeChildEvent);
        } else {
          throw new ServiceException(Messages.SQL_NOT_FOUND);
        }
      } else {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }
    }
  }
  
  /**
   * check if a secondary MES Worker already exists for the stage. If secondary MES Worker already exists, Get all MES
   * Workers currently assigned as a secondary to the given stage.
   * 
   * @param idStage
   * @return List<Integer> List of assigned secondary MES Workers 
   */
  private List<Integer> getSecondaryAssignedMesWorkers(int idStage) {
    String[] secAttributesMESWorker = { SEC_REG_FAM_INDP_STF, SEC_REG_FAM_INDP_MGMNT_STF };
    List<Integer> mesWorkerAssignedAsSEList = new ArrayList<Integer>();

    // retrieve list of all secondary workers for the stage
    List<Integer> idSecondaryWorkers = stagePersonLinkDAO.findIdPersonByIdStageAndCdStagePersRoleAsSE(idStage);
    if (idSecondaryWorkers != null && idSecondaryWorkers.size() > 0) {
      // loop thru the list of secondary workers, retrieve their security profile
      // and see if they have the MES Worker attribute
      for (Iterator<Integer> it_idSecondaryWorkers = idSecondaryWorkers.iterator(); it_idSecondaryWorkers.hasNext();) {
        int idSecondaryWorker = it_idSecondaryWorkers.next();
        if ((checkIfUserHasRight.determineIfUserHasRight(idSecondaryWorker, secAttributesMESWorker[0]))
            || (checkIfUserHasRight.determineIfUserHasRight(idSecondaryWorker, secAttributesMESWorker[1]))) {
          mesWorkerAssignedAsSEList.add(idSecondaryWorker);
        }
      }
    }
    return mesWorkerAssignedAsSEList;
  }

  public StagePersonLinkDAO getStagePersonLinkDAO() {
    return stagePersonLinkDAO;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public PersonDtlDAO getPersonDtlDAO() {
    return personDtlDAO;
  }

  public void setPersonDtlDAO(PersonDtlDAO personDtlDAO) {
    this.personDtlDAO = personDtlDAO;
  }

  public PersonEthnicityDAO getPersonEthnicityDAO() {
    return personEthnicityDAO;
  }

  public void setPersonEthnicityDAO(PersonEthnicityDAO personEthnicityDAO) {
    this.personEthnicityDAO = personEthnicityDAO;
  }

  public MedicationDAO getMedicationDAO() {
    return medicationDAO;
  }

  public void setMedicationDAO(MedicationDAO medicationDAO) {
    this.medicationDAO = medicationDAO;
  }

  public ClientOutboundDAO getClientOutboundDAO() {
    return clientOutboundDAO;
  }

  public void setClientOutboundDAO(ClientOutboundDAO clientOutboundDAO) {
    this.clientOutboundDAO = clientOutboundDAO;
  }

  public void setCapsCaseDAO(CapsCaseDAO capsCaseDAO) {
    this.capsCaseDAO = capsCaseDAO;
  }

  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }

  public void setEventPersonLinkDAO(EventPersonLinkDAO eventPersonLinkDAO) {
    this.eventPersonLinkDAO = eventPersonLinkDAO;
  }

  public void setApprovalEventLinkDAO(ApprovalEventLinkDAO approvalEventLinkDAO) {
    this.approvalEventLinkDAO = approvalEventLinkDAO;
  }

  public void setApproversDAO(ApproversDAO approversDAO) {
    this.approversDAO = approversDAO;
  }

  public void setApprovalDAO(ApprovalDAO approvalDAO) {
    this.approvalDAO = approvalDAO;
  }

  public void setStageLinkDAO(StageLinkDAO stageLinkDAO) {
    this.stageLinkDAO = stageLinkDAO;
  }

  public void setUnitEmpLinkDAO(UnitEmpLinkDAO unitEmpLinkDAO) {
    this.unitEmpLinkDAO = unitEmpLinkDAO;
  }

  public void setSpecialNeedsDeterminationDAO(SpecialNeedsDeterminationDAO specialNeedsDeterminationDAO) {
    this.specialNeedsDeterminationDAO = specialNeedsDeterminationDAO;
  }

  public void setAdoptionSubsidyDAO(AdoptionSubsidyDAO adoptionSubsidyDAO) {
    this.adoptionSubsidyDAO = adoptionSubsidyDAO;
  }

  public void setCapsResourceDAO(CapsResourceDAO capsResourceDAO) {
    this.capsResourceDAO = capsResourceDAO;
  }

  public void setLegalStatusDAO(LegalStatusDAO legalStatusDAO) {
    this.legalStatusDAO = legalStatusDAO;
  }

  public void setExchangeChildDAO(ExchangeChildDAO exchangeChildDAO) {
    this.exchangeChildDAO = exchangeChildDAO;
  }
}