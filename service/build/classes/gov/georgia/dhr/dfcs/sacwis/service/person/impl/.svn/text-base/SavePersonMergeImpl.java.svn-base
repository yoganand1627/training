package gov.georgia.dhr.dfcs.sacwis.service.person.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.NullHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.AllegationDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CharacteristicsDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ChildPlanParticipDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ClientOutboundDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CnsrvtrshpRemovalDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexAddressPersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexCharacteristicsDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexFceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexMedicationDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexPersonMergeDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexPersonPhoneDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexSafetyResourceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ContactDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ContactDiscussedCbxDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ContactForDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ContactRuleDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EducationalHistoryDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventPersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ExtDocPersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.FamilyAssmtFactorsDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.IncomeAndResourcesDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.LegalActionDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.LegalStatusDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.MedicationDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.NameDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonAddressDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonCategoryDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonEligibilityDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonEligibilityDetailDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonHomeRemovalDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonIdDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonMergeDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonPhoneDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PlacementDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PlanParticipantDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PptParticipantDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.RecordsCheckDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.RelationshipDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.RiskFactorsDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ServiceAuthorizationDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SpclInvHmeWaiverChildHistDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonAddHistoryDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SvcAuthDetailDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.TCMClaimDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.TribalDAO;
import gov.georgia.dhr.dfcs.sacwis.db.AddressPersonLink;
import gov.georgia.dhr.dfcs.sacwis.db.Allegation;
import gov.georgia.dhr.dfcs.sacwis.db.CapsResource;
import gov.georgia.dhr.dfcs.sacwis.db.Characteristics;
import gov.georgia.dhr.dfcs.sacwis.db.ClientOutbound;
import gov.georgia.dhr.dfcs.sacwis.db.Contact;
import gov.georgia.dhr.dfcs.sacwis.db.ContactDiscussedCbx;
import gov.georgia.dhr.dfcs.sacwis.db.EducationalHistory;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.EventPersonLink;
import gov.georgia.dhr.dfcs.sacwis.db.Medication;
import gov.georgia.dhr.dfcs.sacwis.db.Name;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.PersonAddress;
import gov.georgia.dhr.dfcs.sacwis.db.PersonCategory;
import gov.georgia.dhr.dfcs.sacwis.db.PersonEligibility;
import gov.georgia.dhr.dfcs.sacwis.db.PersonEligibilityDetail;
import gov.georgia.dhr.dfcs.sacwis.db.PersonId;
import gov.georgia.dhr.dfcs.sacwis.db.PersonMerge;
import gov.georgia.dhr.dfcs.sacwis.db.PersonPhone;
import gov.georgia.dhr.dfcs.sacwis.db.Placement;
import gov.georgia.dhr.dfcs.sacwis.db.RecordsCheck;
import gov.georgia.dhr.dfcs.sacwis.db.Relationship;
import gov.georgia.dhr.dfcs.sacwis.db.ServiceAuthorization;
import gov.georgia.dhr.dfcs.sacwis.db.SpclInvHmeWaiverChildHist;
import gov.georgia.dhr.dfcs.sacwis.db.StagePersonLink;
import gov.georgia.dhr.dfcs.sacwis.db.Tribal;
import gov.georgia.dhr.dfcs.sacwis.service.admin.TodoCommonFunction;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.person.SavePersonMerge;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC14SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB40UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB40UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCFC14SIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC14SO;

import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

  /*Change History:
     Date        User          Description
     ----------  --------      --------------------------------------------------
                               
     08/04/03   mxpatel        STGAP00009781: calling a method from TCMClaimDAO (saveTCMClaimPersonMerge(idPersonForward,idPersonClosed))to update the TcmClaim Table after merging two people.                               
                               Also added following lines of code:
                               private TCMClaimDAO tcmClaimDAO = null;
                               public void setTcmClaimDAO(TCMClaimDAO tcmClaimDAO) {
                                 this.tcmClaimDAO = tcmClaimDAO;
                               }
                            
     09/23/2008  mxpatel       STGAP00010044: wrote an IF statement to update the allegation table after person merge. 
     
     10/10/2008  mxpatel       STGAP00010188: Wrote IF statement to create a link between the new person forward and each of the
                               old person closed in case of multiple merge.
                            
     09/23/2008  mxpatel       STGAP00010312: Wrote a method call to find any contacts that would need to be updated
                               as the result of person merge and wrote an IF statement to update the Contact table after person merge.
     06/12/2009  arege         STGAP00012399 : Person Merge should update Service Authorization records with Forward person id.
     06/12/2009  arege         STGAP00013099 : Person Merge should update Placement records with Forward person id.  
     06/15/2009  arege         STGAP00012399 : Added new method updateSvcAuthDetailWithIdForward to update svcAuthDetail
                               table with idForward during person merge.
     09/02/2009  ssubram       STGAP00015066 : Person Merge should udpate External Documentation Person link with Forward person id.
     03/05/2010  swroberts     MR-062:  Updated the merge process to update person ids related to Contact Standards.
     05/04/2010  wjcochran     SMS #37256: Updated to check if the forward person & closed person were part of the same event. If so,
                               then the event person link to the closed person is deleted. Otherwise, the closed event is updated with
                               the forward person ID.
     06/15/2010  wjcochran     SMS #37256: After discussing with Vishala Devarakonda, we decided it would be better to not delete anything
                               from the event person link table. So, if the forward person and closed person were part of the same event,
                               nothing happens and the save continues as normal.  
     09/01/2010  bgehlot       SMS 66380: MR-072 Person Merge for Contact Discussed/In Reference To
     07/07/2011  hjbaptiste    SMS109631: CAPTA 4.3: Special Investigation - Person Merge should update the waiver children
     09/12/2011  arege         STGAP00017062 : Person Merge should update the Removal events 
     09/26/2011  arege         SMS#62831: Checks to see if the personClosed is a SMILE Client. If so,then the SMILE data is updated with the forward person information.
     10/10/2011  schoi         STGAP00017013: MR-095 Added logic to delete the idPersonClosed from STAGE_PERSON_ADD_HISTORY table 
                               to avoid having duplicated entry when the idPersonClosed is being related to the open stage(s)
                               after the Person Merge then Person Split
     10/19/2011  arege         SMS#62831: Checks to see if the personClosed is a SMILE Client. If so,then the SMILE data is updated with the forward person information.
     11/30/2011  arege         SMS#62831/ITSM37804: Commenting out the call to callUpdateSmile and callUpdateSmileForSplit as not enough testing was done around this. 



*/
                       
public class SavePersonMergeImpl extends BaseServiceImpl implements SavePersonMerge {

  public static final String IND_VALID_NAME = "2";

  public static final int LOOP_TWICE = 2;

  public static final String TITLE_19 = "001004005006010011013014";

  public static final String NON_TITLE_19 = "002003007008009012015";

  public static final String SPLIT_SHORT_DESC = " Split From ";

  public static final String MERGE_SHORT_DESC = " Merged Into ";

  public static final String SPLIT_LONG_DESC = "has been split from";

  public static final String MERGED_LONG_DESC = "has been merged into";

  public static final String BY_STRING = "by";

  public static final String SPLIT_TODO_CD = "CFC018";

  public static final String MERGE_TODO_CD = "CFC017";

  public static final String SSA_VERIFIED = "SSA verified via DHS RECEIVE Interface";

  public static final char CD_PPT = 'P';

  public static final char CD_LEGAL_STAT = 'S';

  public static final char CD_CHILD_PLAN = 'C';

  public static final int ADO_RISK_ASSMT = 8750;

  public static final int INV_RISK_ASSMT = 2290;

  public static final int SUB_RISK_ASSMT = 3250;

  public static final int PAD_RISK_ASSMT = 9240;

  public static final int SVC_RISK_ASSMT = 7185;

  public static final int INV_HOME_REMOVAL = 2350;

  public static final int FSU_REMOVAL = 4330;

  public static final int SVC_REMOVAL = 7190;

  public static final int FRE_REMOVAL = 5830;

  public static final int SUB_PPT = 3180;

  public static final int PAD_PPT = 9170;

  public static final int ADO_PPT = 8680;

  public static final int SUB_CP = 3160;

  public static final int SUB_LEGAL_ACT = 3030;

  public static final int ADO_LEGAL_ACT = 8540;

  public static final int PAD_LEGAL_ACT = 9030;

  public static final int INV_LEGAL_ACT_1 = 2145;

  public static final int AGO_LEGAL_ACT = 5050;

  public static final int FSU_LEGAL_ACT = 4350;

  public static final int FRE_LEGAL_ACT = 5850;

  public static final int INV_LEGAL_ACT_2 = 2355;

  public static final int SVC_LEGAL_ACT = 6130;

  public static final int SVC_LEGAL_ACT_2 = 7210;

  public static final int SUB_LEGAL_STAT = 3050;

  public static final int ADO_LEGAL_STAT = 8560;

  public static final int PAD_LEGAL_STAT = 9050;

  public static final int INV_LEGAL_STAT = 2375;

  public static final int FSU_LEGAL_STAT = 4370;

  public static final int SVC_LEGAL_STAT = 7230;

  public static final int FRE_LEGAL_STAT = 5870;

  public static final int SVC_FAD_ASSMT = 7060;

  public static final int FRE_FAD_ASSMT = 5590;

  public static final int FSU_FAD_ASSMT = 4140;

  public static final int SUB_PLAC = 3080;

  public static final int ADO_PLAC = 8590;

  public static final int PAD_PLAC = 9080;

  public static final int FCE_APP = 3430;

  public static final int FCE_ELIG = 3120;

  public static final int FRE_FAMILY_PLAN = 5600;

  public static final int FPR_FAMILY_PLAN = 7080;

  public static final int FSU_FAMILY_PLAN = 4150;

  public static final int FRE_PLAN = 5605;

  public static final int FSU_PLAN = 4155;

  public static final int FPR_PLAN = 7075;

  public static final int FCE_REVIEW = 3440;

  public static final int SVC_GUARD = 6120;

  public static final int INV_GUARD = 2140;

  public static final int INV_SAFE_RSRC = 2277;

  public static final int FPR_SAFE_RSRC = 7331;
  
  public static final int FPR_CS = 7025;
  
  public static final int FSU_CS = 6540;
  
  public static final String NEW = "NEW";

  private AllegationDAO allegationDAO = null;

  private CharacteristicsDAO characteristicsDAO = null;

  private ChildPlanParticipDAO childPlanParticipDAO = null;

  private ComplexAddressPersonLinkDAO complexAddressPersonLinkDAO = null;

  private ComplexCharacteristicsDAO complexCharacteristicsDAO = null;

  private ComplexFceDAO complexFceDAO = null;

  private ComplexPersonPhoneDAO complexPersonPhoneDAO = null;

  private ComplexPersonMergeDAO complexPersonMergeDAO = null;

  private ComplexMedicationDAO complexMedicationDAO = null;  
  
  private CnsrvtrshpRemovalDAO cnsrvtrshpRemovalDAO = null;
  
  private ContactDAO contactDAO = null;//mxpatel added this for defect #10312
  
  private ContactRuleDAO contactRuleDAO = null;
  
  private ContactForDAO contactForDAO = null;

  private EducationalHistoryDAO educationalHistoryDAO = null;

  private EventPersonLinkDAO eventPersonLinkDAO = null;
  
  private ExtDocPersonLinkDAO extDocPersonLinkDAO = null;
  
  private FamilyAssmtFactorsDAO familyAssmtFactorsDAO = null;

  private IncomeAndResourcesDAO incomeAndResourcesDAO = null;

  private LegalActionDAO legalActionDAO = null;

  private LegalStatusDAO legalStatusDAO = null;

  private NameDAO nameDAO = null;

  private MedicationDAO medicationDAO = null;

  private PersonAddressDAO personAddressDAO = null;

  private PersonCategoryDAO personCategoryDAO = null;

  private PersonPhoneDAO personPhoneDAO = null;

  private PersonMergeDAO personMergeDAO = null;

  private TCMClaimDAO tcmClaimDAO = null; // mxpatel
  
  private PersonDAO personDAO = null;

  private PersonEligibilityDAO personEligibilityDAO = null;

  private PersonEligibilityDetailDAO personEligibilityDetailDAO = null;

  private PersonHomeRemovalDAO personHomeRemovalDAO = null;

  private PersonIdDAO personIdDAO = null;

  private PlacementDAO placementDAO = null;

  private PptParticipantDAO pptParticipantDAO = null;

  private PlanParticipantDAO planParticipantDAO = null;

  private RecordsCheckDAO recordsCheckDAO = null;

  private RelationshipDAO relationshipDAO = null;

  private RiskFactorsDAO riskFactorsDAO = null;
  
  private ServiceAuthorizationDAO serviceAuthorizationDAO = null;
  
  private SvcAuthDetailDAO svcAuthDetailDAO = null;

  private StagePersonLinkDAO stagePersonLinkDAO = null;
  
  private StagePersonAddHistoryDAO stagePersonAddHistoryDAO = null;

  private StageDAO stageDAO = null;
  
  private SpclInvHmeWaiverChildHistDAO spclInvHmeWaiverChildHistDAO = null;

  private TodoCommonFunction todoCommonFunction = null;

  private TribalDAO tribalDAO = null;
  
  private ClientOutboundDAO clientOutboundDAO = null;
  
  private ComplexSafetyResourceDAO complexSafetyResourceDAO = null;
  
  private ContactDiscussedCbxDAO contactDiscussedCbxDAO = null;
  
  //mxpatel
  public void setTcmClaimDAO(TCMClaimDAO tcmClaimDAO) {
    this.tcmClaimDAO = tcmClaimDAO;
  }

  public void setAllegationDAO(AllegationDAO allegationDAO) {
    this.allegationDAO = allegationDAO;
  }

  public void setCharacteristicsDAO(CharacteristicsDAO characteristicsDAO) {
    this.characteristicsDAO = characteristicsDAO;
  }

  public void setChildPlanParticipDAO(ChildPlanParticipDAO childPlanParticipDAO) {
    this.childPlanParticipDAO = childPlanParticipDAO;
  }

  public void setComplexAddressPersonLinkDAO(ComplexAddressPersonLinkDAO complexAddressPersonLinkDAO) {
    this.complexAddressPersonLinkDAO = complexAddressPersonLinkDAO;
  }

  public void setComplexCharacteristicsDAO(ComplexCharacteristicsDAO complexCharacteristicsDAO) {
    this.complexCharacteristicsDAO = complexCharacteristicsDAO;
  }

  public void setComplexFceDAO(ComplexFceDAO complexFceDAO) {
    this.complexFceDAO = complexFceDAO;
  }

  public void setComplexPersonPhoneDAO(ComplexPersonPhoneDAO complexPersonPhoneDAO) {
    this.complexPersonPhoneDAO = complexPersonPhoneDAO;
  }

  public void setComplexPersonMergeDAO(ComplexPersonMergeDAO complexPersonMergeDAO) {
    this.complexPersonMergeDAO = complexPersonMergeDAO;
  }

  public void setComplexMedicationDAO(ComplexMedicationDAO complexMedicationDAO) {
    this.complexMedicationDAO = complexMedicationDAO;
  }
  
  public void setCnsrvtrshpRemovalDAO(CnsrvtrshpRemovalDAO cnsrvtrshpRemovalDAO) {
    this.cnsrvtrshpRemovalDAO = cnsrvtrshpRemovalDAO;
}

  public void setEducationalHistoryDAO(EducationalHistoryDAO educationalHistoryDAO) {
    this.educationalHistoryDAO = educationalHistoryDAO;
  }

  public void setEventPersonLinkDAO(EventPersonLinkDAO eventPersonLinkDAO) {
    this.eventPersonLinkDAO = eventPersonLinkDAO;
  }
 
  public void setExtDocPersonLinkDAO(ExtDocPersonLinkDAO extDocPersonLinkDAO) {
	this.extDocPersonLinkDAO = extDocPersonLinkDAO;
  }

  public void setFamilyAssmtFactorsDAO(FamilyAssmtFactorsDAO familyAssmtFactorsDAO) {
    this.familyAssmtFactorsDAO = familyAssmtFactorsDAO;
  }

  public void setIncomeAndResourcesDAO(IncomeAndResourcesDAO incomeAndResourcesDAO) {
    this.incomeAndResourcesDAO = incomeAndResourcesDAO;
  }

  public void setLegalActionDAO(LegalActionDAO legalActionDAO) {
    this.legalActionDAO = legalActionDAO;
  }

  public void setLegalStatusDAO(LegalStatusDAO legalStatusDAO) {
    this.legalStatusDAO = legalStatusDAO;
  }

  public void setNameDAO(NameDAO nameDAO) {
    this.nameDAO = nameDAO;
  }

  public void setMedicationDAO(MedicationDAO medicationDAO) {
    this.medicationDAO = medicationDAO;
  }

  public void setPersonAddressDAO(PersonAddressDAO personAddressDAO) {
    this.personAddressDAO = personAddressDAO;
  }

  public void setPersonCategoryDAO(PersonCategoryDAO personCategoryDAO) {
    this.personCategoryDAO = personCategoryDAO;
  }

  public void setPersonPhoneDAO(PersonPhoneDAO personPhoneDAO) {
    this.personPhoneDAO = personPhoneDAO;
  }

  public void setPersonMergeDAO(PersonMergeDAO personMergeDAO) {
    this.personMergeDAO = personMergeDAO;
  }

  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }

  public void setPersonEligibilityDAO(PersonEligibilityDAO personEligibilityDAO) {
    this.personEligibilityDAO = personEligibilityDAO;
  }

  public void setPersonEligibilityDetailDAO(PersonEligibilityDetailDAO personEligibilityDetailDAO) {
    this.personEligibilityDetailDAO = personEligibilityDetailDAO;
  }

  public void setPersonHomeRemovalDAO(PersonHomeRemovalDAO personHomeRemovalDAO) {
    this.personHomeRemovalDAO = personHomeRemovalDAO;
  }

  public void setPersonIdDAO(PersonIdDAO personIdDAO) {
    this.personIdDAO = personIdDAO;
  }

  public void setPlacementDAO(PlacementDAO placementDAO) {
    this.placementDAO = placementDAO;
  }

  public void setPptParticipantDAO(PptParticipantDAO pptParticipantDAO) {
    this.pptParticipantDAO = pptParticipantDAO;
  }

  public void setPlanParticipantDAO(PlanParticipantDAO planParticipantDAO) {
    this.planParticipantDAO = planParticipantDAO;
  }

  public void setRecordsCheckDAO(RecordsCheckDAO recordsCheckDAO) {
    this.recordsCheckDAO = recordsCheckDAO;
  }

  public void setRelationshipDAO(RelationshipDAO relationshipDAO) {
    this.relationshipDAO = relationshipDAO;
  }

  public void setRiskFactorsDAO(RiskFactorsDAO riskFactorsDAO) {
    this.riskFactorsDAO = riskFactorsDAO;
  }

  public void setServiceAuthorizationDAO(ServiceAuthorizationDAO serviceAuthorizationDAO) {
    this.serviceAuthorizationDAO = serviceAuthorizationDAO;
  }

  public void setSvcAuthDetailDAO(SvcAuthDetailDAO svcAuthDetailDAO) {
    this.svcAuthDetailDAO = svcAuthDetailDAO;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public void setStagePersonAddHistoryDAO(StagePersonAddHistoryDAO stagePersonAddHistoryDAO) {
    this.stagePersonAddHistoryDAO = stagePersonAddHistoryDAO;
  }
  
  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }
  
  public void setSpclInvHmeWaiverChildHistDAO(SpclInvHmeWaiverChildHistDAO spclInvHmeWaiverChildHistDAO) {
    this.spclInvHmeWaiverChildHistDAO = spclInvHmeWaiverChildHistDAO;
  }

  public void setTodoCommonFunction(TodoCommonFunction todoCommonFunction) {
    this.todoCommonFunction = todoCommonFunction;
  }

  public void setTribalDAO(TribalDAO tribalDAO) {
    this.tribalDAO = tribalDAO;
  }

  public void setComplexSafetyResourceDAO(ComplexSafetyResourceDAO complexSafetyResourceDAO) {
    this.complexSafetyResourceDAO = complexSafetyResourceDAO;
  }

  //mxpatel added this for defect #10312
  public void setContactDAO(ContactDAO contactDAO){
    this.contactDAO = contactDAO;
  }

  public void setContactRuleDAO(ContactRuleDAO contactRuleDAO){
    this.contactRuleDAO = contactRuleDAO;
  }  

  public void setContactForDAO(ContactForDAO contactForDAO){
    this.contactForDAO = contactForDAO;
  } 
  
  public void setContactDiscussedCbxDAO(ContactDiscussedCbxDAO contactDiscussedCbxDAO) {
    this.contactDiscussedCbxDAO = contactDiscussedCbxDAO;
  }
    
  public void setClientOutboundDAO(ClientOutboundDAO clientOutboundDAO) {
    this.clientOutboundDAO = clientOutboundDAO;
  }
  
  public CCFC14SO savePersonMerge(CCFC14SI ccfc14si) throws ServiceException {
    CCFC14SO ccfc14so = new CCFC14SO();
    boolean bIndPersForwardActive = false;
    boolean bIndPersCloseActive = false;
    String cReqFuncCd = ccfc14si.getArchInputStruct().getCReqFuncCd();
    ROWCCFC14SIG00 rowccfc14sig00 = ccfc14si.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(0);
    int idPersonForward = rowccfc14sig00.getUlIdPersMergeForward();
    int idPersonClosed = rowccfc14sig00.getUlIdPersMergeClosed();
    if (!ServiceConstants.REQ_FUNC_CD_UPDATE.equals(cReqFuncCd)) {
      callCompareAddress(idPersonForward, idPersonClosed);

      callComparePhone(idPersonForward, idPersonClosed);

      callCompareEducation(idPersonForward, idPersonClosed);
      callCompareChar(idPersonForward, idPersonClosed);
      callCompareName(idPersonForward, idPersonClosed);
      callCompareIncome(idPersonForward, idPersonClosed);
      callCompareRecChk(idPersonClosed);
      callCompareRelationship(idPersonForward, idPersonClosed);
      callCompareTribal(idPersonForward, idPersonForward);
      callCompareMedication(idPersonForward, idPersonForward);

    }
    // If the required function is update, then the user performed a split on the
    // person merge/split window.
    if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(ccfc14si.getArchInputStruct().getCReqFuncCd())) {

      for (Enumeration<ROWCCFC14SIG00> rowccfc14sgooEnum = ccfc14si.getROWCCFC14SIG00_ARRAY().enumerateROWCCFC14SIG00(); rowccfc14sgooEnum
                                                                                                                          .hasMoreElements();) {
        ROWCCFC14SIG00 row = rowccfc14sgooEnum.nextElement();
        Date dtLastUpate = row.getTsLastUpdate();
        Date dtPersMergeSplit = DateHelper.toJavaDate(row.getDtDtPersMergeSplit());
        int idPersMergeForward = row.getUlIdPersMergeForward();
        int idPersMergeWrkr = row.getUlIdPersMergeWrkr();
        int idPersMergeClosed = row.getUlIdPersMergeClosed();
        int idPersMergeSplitWrkr = row.getUlIdPersMergeSplitWrkr();
        int idPersonMerge = row.getUlIdPersonMerge();
        String indPersMergeInvalid = row.getCIndPersMergeInvalid();
        // Calling caud63d
        int rows = personMergeDAO.updatePersonMerge(idPersonMerge, idPersMergeForward, idPersMergeClosed,
                                                    idPersMergeWrkr, idPersMergeSplitWrkr, indPersMergeInvalid,
                                                    dtPersMergeSplit, dtLastUpate);

        if (rows == 0) {
          throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
        }
  
        String cdPersonStatus = CodesTables.CPERSTAT_I;
        // Update Merge Closed Person Status to CD_INACTIVE for person merged closed
        // CallCAUD74D
        updatePersonStatus(idPersMergeClosed, cdPersonStatus);
        // SMS#62831:Send SMILE information about split
        // Removed code as not enough testing was done
       // callUpdateSmileForSplit( idPersonForward,  idPersonClosed,  idPersMergeWrkr);
      }
    } else {

      // Else the window passed in REQ_FUNC_CD_ADD as the required function, this
      // means that the user performed a merge on the person merge/split window.
      Person person = retrievePerson(idPersonForward);
      String cdPersonStatusClosed = processPersonAndPersonCategory(idPersonForward, idPersonClosed, person);
      String cdPersonStatus = person.getCdPersonStatus();
      // Set the Both Acitve flag to true if both the person forward and the person closed is active.
      if (CodesTables.CPERSTAT_A.equals(cdPersonStatus) || !StringHelper.isValid(cdPersonStatus)) {
        bIndPersForwardActive = true;
      }
      if (CodesTables.CPERSTAT_A.equals(cdPersonStatusClosed) || !StringHelper.isValid(cdPersonStatus)) {
        bIndPersCloseActive = true;
      }
      processStagePersonAndEvent(idPersonForward, idPersonClosed);
      // CALL CSEC83D
      findAndDeleteAllegation(idPersonForward);
      int idPersMergeWrkr = rowccfc14sig00.getUlIdPersMergeWrkr();
      Date dtPersMerge = DateHelper.toJavaDate(rowccfc14sig00.getDtDtPersMerge());
      Date dtPersMergeSplit = DateHelper.toJavaDate(rowccfc14sig00.getDtDtPersMergeSplit());
      // CLSS49D
      processPersonMerge(idPersonForward, idPersonClosed, idPersMergeWrkr, dtPersMerge, dtPersMergeSplit);
      // Check if Person Closed has records on the Merge Table as a Person Forward.
      // If so, this is a multiple Merge situation. Update the old Rows to be
      // Invalid and add new rows to make the old person closed's merge into the
      // new person forward.
      processPersonMergeList(idPersonForward, idPersonClosed, idPersMergeWrkr, dtPersMerge, dtPersMergeSplit);
      // Add the person merge that was requested on the window.
      addPersonMerge(idPersonForward, idPersonClosed, idPersMergeWrkr, dtPersMerge, dtPersMergeSplit);
      // Update Person Closed Person Status to Merge on the Person table
      StringBuffer cdPersonStatusBuffer = new StringBuffer();
      cdPersonStatusBuffer.append(CodesTables.CPERSTAT_M);
      cdPersonStatus = cdPersonStatusBuffer.toString();
      // Update Person Closed Person Status to Merge on the Person table
      // caud74d
      updatePersonStatus(idPersonClosed, cdPersonStatus);
      cdPersonStatusBuffer.setLength(0);
      if (bIndPersForwardActive || bIndPersCloseActive) {
        cdPersonStatusBuffer.append(CodesTables.CPERSTAT_A);
      } else {
        cdPersonStatusBuffer.append(CodesTables.CPERSTAT_I);
      }
      cdPersonStatus = cdPersonStatusBuffer.toString();
      // Update Person Forward Person Status. we need to update PERSON table with status
      // for person forward, otherwise PERSON_HISTORY table is not written into and
      // therefore we won't have any record of person_forward prior to merge
      // caud74d
      updatePersonStatus(idPersonForward, cdPersonStatus);
      // Call the Duplicate Stage Person Link Retrieval Dao - CLSC83D
      callStageDAO(idPersonForward, idPersonClosed);
      // Call the Stage Person Link AUD Dam - CAUD73D
      // This DAO updates all the rows in the STAGE_PERSON_LINK table
      // for open stages, replacing IdMergeClosed with IdMergeForward.
      stagePersonLinkDAO.updateStagePersonLinkIdPerson(idPersonForward, idPersonClosed);
      
      // STGAP00017013: MR-095
      // Delete the idPersonClosed from STAGE_PERSON_ADD_HISTORY table 
      // only if the stage is open to avoid having duplicated entry 
      // when the idPersonClosed is being related to the open stage(s)
      // after the Person Merge then Person Split
      stagePersonAddHistoryDAO.deleteStagePersonAddHistoryByIdPerson(idPersonClosed);
      // End STGAP00017013: MR-095      
      
      // Search for open EA eligibilities for the Person Closed
      // CallCSECA4D
      processPersonEligibility(idPersonForward, idPersonClosed);
      // Search for open DHS eligibilities for the Person Closed
      insertPersonEligibilityAndPersonEligibilityDetail(idPersonForward, idPersonClosed);
     
      // mxpatel
       int rows = tcmClaimDAO.saveTCMClaimPersonMerge(idPersonForward, idPersonClosed);

     List<Allegation> allegationsToUpdate  = allegationDAO.findAllegationByIdPersonClosedAsVictim(idPersonClosed);
     
     //mxpatel added this IF for defect #10044
     if (allegationsToUpdate != null && !allegationsToUpdate.isEmpty()){
       for (Iterator<Allegation> it = allegationsToUpdate.iterator(); it.hasNext();) {
        Allegation allegation = it.next();
        rows = allegationDAO.updateAllegationIdVictim(idPersonForward, idPersonClosed);
      }
     }
     
     //mxpatel added this for defect #10312
     List<Contact> contactsToUpdate = contactDAO.findContatcByIdPersonClosedAsTCMClient(idPersonClosed);
     
     if(contactsToUpdate != null && !contactsToUpdate.isEmpty()){
       for(Iterator<Contact> it = contactsToUpdate.iterator(); it.hasNext();){
         Contact contact = it.next();
         rows = contactDAO.updateContactByIdPersonClosedAsTcmClient(idPersonForward, idPersonClosed);
       }
     }
     
     //SMS 66380: Person Merge for Contact Discussed/In Reference To:
     List<ContactDiscussedCbx> updateDiscussedCbx = contactDiscussedCbxDAO.findDiscussedPersonByIdPersonClosed(idPersonClosed);
     
     if(updateDiscussedCbx != null && !updateDiscussedCbx.isEmpty()){
       for(Iterator<ContactDiscussedCbx> it = updateDiscussedCbx.iterator(); it.hasNext();){
         it.next();
         rows = contactDiscussedCbxDAO.updateDiscussedCbxByIdPersonClosed(idPersonForward, idPersonClosed);
       }
     }
     
     // CAPTA 4.3: Special Investigation - Person Merge should update the waiver children
     List<SpclInvHmeWaiverChildHist> homeWaiverChildren = spclInvHmeWaiverChildHistDAO.findSpclInvHmeWaiverChildHist(idPersonClosed);
     if (homeWaiverChildren != null && !homeWaiverChildren.isEmpty()) {
       spclInvHmeWaiverChildHistDAO.updateSpclInvHmeWaiverChildHistWithPersonForward(idPersonForward, idPersonClosed);
     }
     
     // STGAP00013099: Person merge should update the Placement records for idPrimaryClild
      // with Forward person id.
      List<Placement> placementsToUpdate = placementDAO.findPlacementByIdPlcmtChild(idPersonClosed);
      if (placementsToUpdate != null && !placementsToUpdate.isEmpty()) {
        for (Iterator<Placement> it = placementsToUpdate.iterator(); it.hasNext();) {
          it.next();
          rows = placementDAO.updatePlacementWithForwardPerson(idPersonForward, idPersonClosed);
        }
      }

      // STGAP00012399 ,STGAP00012838: Person merge should update the ServiceAuthorization record for idPrimaryClient
      // with Forward person id.
      List<ServiceAuthorization> servAuthToUpdate = serviceAuthorizationDAO
                                                                           .findServAuthByIdPrimaryClient(idPersonClosed);
      if (servAuthToUpdate != null && !servAuthToUpdate.isEmpty()) {
        for (Iterator<ServiceAuthorization> it = servAuthToUpdate.iterator(); it.hasNext();) {
          it.next();
          serviceAuthorizationDAO.updateServiceAuthorizationWithForwardPerson(idPersonForward, idPersonClosed);
        }
      }
      
      svcAuthDetailDAO.updateSvcAuthDetailWithIdForward(idPersonForward, idPersonClosed);
     
      //STGAP00015066 : Person Merge should udpate External Documentation Person link with Forward person id.
      extDocPersonLinkDAO.updateExtDocPersonLinkForPersonMerge(idPersonForward, idPersonClosed);      
      
      //STGAP00017062 : Person Merge should update the Removal events 
      cnsrvtrshpRemovalDAO.updateCnrvtrshpRemovalWithForwardPerson(idPersonForward, idPersonClosed);
      
      //SMS#62831 - Update SMILE Data
      //Removed call to callUpdateSmile as not enough testing was done
      //callUpdateSmile(idPersonForward, idPersonClosed, idPersMergeWrkr);
    }
    // Retrieve the Stage/Add categories based on Stage for a given person
    findStagePersonLink(idPersonForward);
    // This sends info to employee on merge or split
    callToDo(ccfc14si);
    return ccfc14so;

  }

  private void updatePersonStatus(int idPerson, String cdPersonStatus) {
    personDAO.updatePersonCdPersonStatus(idPerson, cdPersonStatus);
  }

  private void callToDo(CCFC14SI ccfc14si) throws ServiceException {
    StringBuffer TxtToDoDesc = new StringBuffer();
    StringBuffer TxtToDoLongDesc = new StringBuffer();
    CSUB40UI pCSUB40UInputRec = new CSUB40UI();
    // Loop through all of the rows in case there is a multiple split involved.
    for (Enumeration<ROWCCFC14SIG00> rowCCFC14SIG00Enum = ccfc14si.getROWCCFC14SIG00_ARRAY().enumerateROWCCFC14SIG00(); rowCCFC14SIG00Enum
                                                                                                                          .hasMoreElements();) {
      // Create a Todo for all of the primary and secondary workers that are affected
      // except for the person making the merge/split. This exception will be handled
      // by the clsc48d dao (stagePersonLinkDAO).
      ROWCCFC14SIG00 rowccfc14si = rowCCFC14SIG00Enum.nextElement();
      int idPersMergeForward = rowccfc14si.getUlIdPersMergeForward();
      int idPersMergeClosed = rowccfc14si.getUlIdPersMergeClosed();
      int idPerson = ccfc14si.getUlIdPersonRequestor();
      // This DAO will select the Primary and secondary workers where in the stages where
      // the Id Person is not equal to the IdWorker in the stages where either the
      // PersMerge Forward or the Person MergeClosed are on the Stage Person Link
      // clsc48d
      List<Map> stagePersonLinkList = stagePersonLinkDAO.findIdPersonIdStageFromStagePersonLink(idPersMergeForward,
                                                                                                idPersMergeClosed,
                                                                                                idPerson);
      if (stagePersonLinkList != null && !stagePersonLinkList.isEmpty()) {
        TxtToDoDesc.append(rowccfc14si.getSzScrNmPersMergeClosed());
        if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(ccfc14si.getArchInputStruct().getCReqFuncCd())) {
          TxtToDoDesc.append(SPLIT_SHORT_DESC);
          TxtToDoLongDesc.append(rowccfc14si.getSzScrNmPersMergeClosed()).append(" ")
                         .append(rowccfc14si.getUlIdPersMergeClosed()).append(" " + SPLIT_LONG_DESC + " ")
                         .append(rowccfc14si.getSzScrNmPersMergeForward()).append(" ")
                         .append(rowccfc14si.getUlIdPersMergeForward()).append(" " + BY_STRING + " ")
                         .append(rowccfc14si.getSzScrNmPersMrgSpltWrkr()).append(" ")
                         .append(rowccfc14si.getUlIdPersMergeSplitWrkr());
        } else {
          TxtToDoDesc.append(MERGE_SHORT_DESC);
          TxtToDoLongDesc.append(rowccfc14si.getSzScrNmPersMergeClosed()).append(" ")
                         .append(rowccfc14si.getUlIdPersMergeClosed()).append(" " + MERGED_LONG_DESC + " ")
                         .append(rowccfc14si.getSzScrNmPersMergeForward()).append(" ")
                         .append(rowccfc14si.getUlIdPersMergeForward()).append(" " + BY_STRING + " ")
                         .append(rowccfc14si.getSzScrNmPersMergeWrkr()).append(" ")
                         .append(rowccfc14si.getUlIdPersMergeWrkr());
        }
        TxtToDoDesc.append(rowccfc14si.getSzScrNmPersMergeForward());

        // Loop through all of the workers that were returned form the clsc48d dam
        // and send each one an alert about the merge.
        for (Iterator<Map> it = stagePersonLinkList.iterator(); it.hasNext();) {
          Map map = it.next();
          CSUB40UIG00 csub40uig00 = new CSUB40UIG00();
          ArchInputStruct archInputStruct = new ArchInputStruct();
          archInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_ADD);
          pCSUB40UInputRec.setArchInputStruct(archInputStruct);
          csub40uig00.setSzSysTxtTodoCfDesc(TxtToDoDesc.toString());
          csub40uig00.setSzSysTxtTodoCfLongDesc(TxtToDoLongDesc.toString());
          csub40uig00.setUlSysIdTodoCfEvent(0);
          csub40uig00.setUlSysIdTodoCfStage((Integer) map.get("idStage") != null ? (Integer) map.get("idStage") : 0);
          csub40uig00.setUlSysIdTodoCfPersAssgn((Integer) map.get("idPerson") != null ? (Integer) map.get("idPerson")
                                                                                     : 0);
          if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(ccfc14si.getArchInputStruct().getCReqFuncCd())) {
            csub40uig00.setDtSysDtTodoCfDueFrom(rowccfc14si.getDtDtPersMergeSplit());
            csub40uig00.setUlSysIdTodoCfPersCrea(rowccfc14si.getUlIdPersMergeSplitWrkr());
            csub40uig00.setSzSysCdTodoCf(SPLIT_TODO_CD);
          } else {
            csub40uig00.setDtSysDtTodoCfDueFrom(rowccfc14si.getDtDtPersMerge());
            csub40uig00.setUlSysIdTodoCfPersCrea(rowccfc14si.getUlIdPersMergeWrkr());
            csub40uig00.setSzSysCdTodoCf(MERGE_TODO_CD);
          }
          pCSUB40UInputRec.setCSUB40UIG00(csub40uig00);
          todoCommonFunction.audTodo(pCSUB40UInputRec);
        }
        break;
      }
    }
  }

  private void findStagePersonLink(int idPerson) {
    // CMSC23D
    // Call the Stage Person Link Retrieval Dam - CMSC23D
    // Description - This DAM a list of Stages where the Id Person (and all
    // persons merged with them) are on the Stage Person Link.
    List<StagePersonLink> stagePersonLinkList = stagePersonLinkDAO.findStagePersonLinkByIdPersonPersonMerge(idPerson);
    if (stagePersonLinkList != null && !stagePersonLinkList.isEmpty()) {
      // Initialize the FA home and Ind Case flags to false.
      boolean bIndFAHome = false;
      boolean bIndCase = false;
      // Determine if the FAHome is a category or if the person forward
      // is a principal or collateral.
      for (Iterator<StagePersonLink> it = stagePersonLinkList.iterator(); it.hasNext();) {
        StagePersonLink stagePersonLink = it.next();
        String cdStagePersType = stagePersonLink.getCdStagePersType();
        if ((CodesTables.CSTAGES_FAD.equals(stagePersonLink.getStage().getCdStage()) && ((CodesTables.CPRSNTYP_PRN
                                                                                                                  .equals(cdStagePersType)) || (CodesTables.CPRSNTYP_COL
                                                                                                                                                                        .equals(cdStagePersType))))) {
          bIndFAHome = true;
        }
        // If the dam call is successful and the stageperstype is either
        // a principal or a collateral, they must be part of the case.
        if ((CodesTables.CPRSNTYP_PRN.equals(cdStagePersType)) || (CodesTables.CPRSNTYP_COL.equals(cdStagePersType))) {
          bIndCase = true;
        }
      }
      // do not delete person category if there is not any insert
      if (bIndCase || bIndFAHome) {
        // Delete the current categories except FEM or EMP
        // Call the Category AUD Dam - CAUD66D
        // Description - Deletes the CATEGORY table using the criteria from
        // PERSON_MERGE. Note this is done for both person
        // merge and split.
        // DELETE PERSON_CATEGORY WHERE ID_PERSON = :hI_ulIdPerson:hI_ulIdPerson_i
        // AND CD_PERSON_CATEGORY <> 'FEM'
        // AND CD_PERSON_CATEGORY <> 'EMP';
        // caud66d
        personCategoryDAO.deletePersonCategory(idPerson);

      }
      // Write the Case Categories
      if (bIndCase) {
        // Call the Person Category AUD Dam - CCMNC2D
        // Description - This DAM performs ADD/UPDATE/DELETE functionality on the
        // PERSON CATEGORY table.
        // ADD - Full row add minus column DT LAST UPDATE
        // UPDATE - Update CD PERSON CATEGORY given a search
        // key of ID PERSON and a CD PERSON CATEGORY.
        // The timestamp is not used.
        // DELETE - Delete not performed
        String cdCategoryCategory = CodesTables.CPSNDTCT_CAS;
        PersonCategory personCategory = new PersonCategory();
        personCategory.setCdPersonCategory(cdCategoryCategory);
        Person person = (Person) getPersistentObject(Person.class, idPerson);
        personCategory.setPerson(person);
        // ccmnc2d
        personCategoryDAO.savePersonCategory(personCategory);
      }

      if (bIndFAHome) {
        // Call the Person Category AUD Dam - CCMNC2D
        // Description - This DAM performs ADD/UPDATE/DELETE functionality on the
        // PERSON CATEGORY table.
        // ADD - Full row add minus column DT LAST UPDATE
        // UPDATE - Update CD PERSON CATEGORY given a search
        // key of ID PERSON and a CD PERSON CATEGORY.
        // The timestamp is not used.
        // DELETE - Delete not performed
        String cdCategoryCategory = CodesTables.CPSNDTCT_FAH;
        PersonCategory personCategory = new PersonCategory();
        personCategory.setCdPersonCategory(cdCategoryCategory);
        Person person = (Person) getPersistentObject(Person.class, idPerson);
        personCategory.setPerson(person);
        // ccmnc2d
        personCategoryDAO.savePersonCategory(personCategory);
      }
    }
  }

  private void insertPersonEligibilityAndPersonEligibilityDetail(int idPersMergeForward, int idPersMergeClosed) {

    int idPersEligPerson = idPersMergeClosed;
    // Calling clsc86d
    List<PersonEligibility> personEligibilityList = personEligibilityDAO
                                                                        .findPersonEligibilityForPersonClosed(idPersEligPerson);
    if (personEligibilityList != null && !personEligibilityList.isEmpty()) {

      for (Iterator<PersonEligibility> it = personEligibilityList.iterator(); it.hasNext();) {
        PersonEligibility personEligibility = it.next();
        idPersEligPerson = idPersMergeForward;
        String cdPersEligType = personEligibility.getCdPersEligEligType();
        Date dtPersEligStart = personEligibility.getDtPersEligStart();
        Date dtPersEligEnd = personEligibility.getDtPersEligEnd();
        // If the EA END or DENY date is 12/31/4712, Foundation will return the value of null.
        // Since you cannot insert null into a NOT NULL column, set EA END and DENY dates to
        // the DateHelper.MAX_JAVA_DATE.
        if (DateHelper.isNull(personEligibility.getDtPersEligEnd())) {
          dtPersEligEnd = DateHelper.MAX_JAVA_DATE;
        }
        Date dtPersEligEaDeny = personEligibility.getDtPersEligEaDeny();
        if (DateHelper.isNull(personEligibility.getDtPersEligEaDeny())) {
          dtPersEligEaDeny = DateHelper.MAX_JAVA_DATE;
        }

        String cdPersEligPrgOpen = personEligibility.getCdPersEligPrgOpen();
        boolean bRowDifferent = false;
        // cseca6d
        bRowDifferent = processEligibilityDAOCountPersonEligibility(idPersEligPerson, dtPersEligStart, dtPersEligEnd,
                                                                    cdPersEligType);
        if (bRowDifferent) {
          idPersEligPerson = idPersMergeForward;
          cdPersEligType = personEligibility.getCdPersEligEligType();
          dtPersEligStart = personEligibility.getDtPersEligStart();
          dtPersEligEnd = personEligibility.getDtPersEligEnd();
          if (DateHelper.isNull(personEligibility.getDtPersEligEnd())) {
            dtPersEligEnd = DateHelper.MAX_JAVA_DATE;
          }
          dtPersEligEaDeny = personEligibility.getDtPersEligEaDeny();
          if (DateHelper.isNull(personEligibility.getDtPersEligEaDeny())) {
            dtPersEligEaDeny = DateHelper.MAX_JAVA_DATE;
          }
          String cPersEligPrgStart = personEligibility.getCdPersEligPrgStart();
          cdPersEligPrgOpen = personEligibility.getCdPersEligPrgOpen();
          // Calling caudd2d
          personEligibilityDAO.insertPersonEligibility(idPersEligPerson, cdPersEligType, dtPersEligStart,
                                                       dtPersEligEnd, dtPersEligEaDeny, cPersEligPrgStart,
                                                       cdPersEligPrgOpen);
          int idPersElig = personEligibility.getIdPersElig();
          int idPersEligDtlPerson = idPersMergeClosed;
          // Search for DHS eligibility in the PERSON_ELIGIBILITY_DETAIL table for the Person Closed
          // Calling clsc87d
          List<PersonEligibilityDetail> personEligibilityDetailList = personEligibilityDetailDAO
                                                                                                .findPersonEligibilityDtlForPersonClosed(
                                                                                                                                         idPersElig,
                                                                                                                                         idPersEligDtlPerson);

          for (Iterator<PersonEligibilityDetail> iterator = personEligibilityDetailList.iterator(); iterator.hasNext();) {
            PersonEligibilityDetail personEligibilityDetail = iterator.next();
            idPersElig = personEligibilityDetail.getPersonEligibility().getIdPersElig();
            idPersEligDtlPerson = idPersMergeForward;
            int moPersEligDtlMonth = personEligibilityDetail.getMoPersEligDtlMonth();
            int yrPersEligDtlYear = personEligibilityDetail.getYrPersEligDtlYear();
            String cdPersEligDtlEligCode = personEligibilityDetail.getCdPersEligDtlEligCode();
            String cdPersEligDtlTypeCase = personEligibilityDetail.getCdPersEligDtlTypeCase();
            String cdPersEligDtlMedCov = personEligibilityDetail.getCdPersEligDtlMedCov();
            String cdPersEligDtlStatInGrp = personEligibilityDetail.getCdPersEligDtlStatInGrp();
            String cdPersEligDtlCaseStatus = personEligibilityDetail.getCdPersEligDtlCaseStatus();
            String cdPersEligDtlProgType = personEligibilityDetail.getCdPersEligDtlProgType();
            String cdPersEligDtlCaseCateg = personEligibilityDetail.getCdPersEligDtlCaseCateg();
            Date dtPersEligDtlCaseCert = personEligibilityDetail.getDtPersEligDtlCaseCert();
            Integer nbrPersEligDtlCaseNbr = personEligibilityDetail.getNbrPersEligDtlCaseNbr();
            // caudd3d
            personEligibilityDetailDAO.insertPersonEligibilityDetail(idPersElig, idPersEligDtlPerson,
                                                                     moPersEligDtlMonth, yrPersEligDtlYear,
                                                                     cdPersEligDtlEligCode, cdPersEligDtlTypeCase,
                                                                     cdPersEligDtlMedCov, cdPersEligDtlStatInGrp,
                                                                     cdPersEligDtlCaseStatus, cdPersEligDtlProgType,
                                                                     cdPersEligDtlCaseCateg, dtPersEligDtlCaseCert,
                                                                     nbrPersEligDtlCaseNbr);
          }
        }

      }
    }
  }

  private boolean processEligibilityDAOCountPersonEligibility(int idPersEligPerson, Date dtPersEligStart,
                                                              Date dtPersEligEnd, String cdPersEligType) {
    boolean pbRowDifferent = false;
    int i = 0;
    StringBuffer szTemp = new StringBuffer();// this is to hold elig type
    boolean bTitle19 = false;// this group is title 19
    // boolean bNonTitle19 = false;// this group is non-title 19
    boolean bTitle19Exists = false;// title 19 exists
    boolean bNonTitle19Exists = false;// non-title 19 exists

    // When merging two persons, * if person_forward in any specific period has elig_type of title 19, * then DO NOT do
    // anything. * else if person_forward in any specific period does not have elig_type of * title 19 or has no
    // elig_type, then if person_closed has any, bring it over
    //

    // group one is XIX which means CD_PERS_ELIG_ELIG_TYPE is
    // one or more of these types ('001','004','005','006','010','011','013','014')
    // group two is non-XIX which means CD_PERS_ELIG_ELIG_TYPE is
    // one or more of these types ('002','003','007','008','009','012','015')
    // i+3 because szCdPersEligType has 3 char. we want to get the next * szCdPersEligType when we increment i. 21:
    // because there are 7 EligType * and each has 3 characters. this loop determines if szCdPersEligType is * of type
    // XIX or non-XIX
    String inputCdPersEligType = null;
    for (i = 0; i < TITLE_19.length(); i += 3) {
      inputCdPersEligType = szTemp.append(TITLE_19.charAt(i)).toString();
      bTitle19 = (inputCdPersEligType.equals(cdPersEligType));
      if (bTitle19) {
        // bNonTitle19 = false;
        break;
      }
    }
    inputCdPersEligType = null;
    // Regardless of szCdPersEligType being title 19, we have to check to see if * person_forward has any title19 in
    // that specific period and that's what * this first loop does.
    szTemp.setLength(0);
    for (i = 0; i < TITLE_19.length(); i += 3) {
      inputCdPersEligType = szTemp.append(TITLE_19.charAt(i)).toString();
      long count = personEligibilityDAO.countPersonEligibilityByIdAndType(idPersEligPerson, inputCdPersEligType,
                                                                          dtPersEligStart, dtPersEligEnd);
      if (count >= 1) {
        bTitle19Exists = true;
      }
      if (bTitle19Exists) {

        break;
      }
    }

    // we check to see if person_forward has any of non_title19 in that * specific period and that's what this loop
    // does.
    szTemp.setLength(0);
    for (i = 0; i < NON_TITLE_19.length() && !(bTitle19Exists); i += 3) {
      inputCdPersEligType = szTemp.append(NON_TITLE_19.charAt(i)).toString();
      // cseca6d
      long countNonTitle = personEligibilityDAO.countPersonEligibilityByIdAndType(idPersEligPerson,
                                                                                  inputCdPersEligType, dtPersEligStart,
                                                                                  dtPersEligEnd);

      if (countNonTitle >= 1) {
        bNonTitle19Exists = true;
      }
      if (bNonTitle19Exists) {

        break;
      }
    }
    if (bTitle19Exists) {
      pbRowDifferent = false;
    } else if (!(bTitle19Exists) && bTitle19) {
      pbRowDifferent = true;
    } else if (!(bTitle19Exists) && bNonTitle19Exists && !(bTitle19)) {
      pbRowDifferent = false;
    } else if (!(bTitle19Exists) && !bNonTitle19Exists) {
      pbRowDifferent = true;
    }
    return pbRowDifferent;
  }

  private void processPersonEligibility(int idPersMergeForward, int idPersMergeClosed) {
    // CallCSECA4D
    int idPersEligPerson = idPersMergeClosed;
    // This dao searches for any open EA eligibilities for the Person Merge Closed
    // on the PERSON_ELIGIBILITY table.
    // cseca4d
    PersonEligibility personEligibility = personEligibilityDAO.findPersonEligibilityOpenStages(idPersEligPerson);
    if (personEligibility != null) {
      String cdPersEligType = personEligibility.getCdPersEligEligType();
      Date dtPersEligStart = personEligibility.getDtPersEligStart();
      Date dtPersEligEnd = personEligibility.getDtPersEligEnd();
      // If the EA END or DENY date is 12/31/4712, Foundation will return the value of null.
      // Since you cannot insert null into a NOT NULL column, set EA END and DENY dates to
      // the DateHelper.MAX_JAVA_DATE.
      if (DateHelper.isNull(dtPersEligEnd)) {
        dtPersEligEnd = DateHelper.MAX_JAVA_DATE;
      }
      Date dtPersEligEaDeny = personEligibility.getDtPersEligEaDeny();
      if (DateHelper.isNull(dtPersEligEaDeny)) {
        dtPersEligEaDeny = DateHelper.MAX_JAVA_DATE;
      }
      String cdPersEligPrgStart = personEligibility.getCdPersEligPrgStart();
      String cdPersEligPrgOpen = personEligibility.getCdPersEligPrgOpen();
      Date ClosedStartDate = personEligibility.getDtPersEligStart();
      idPersEligPerson = idPersMergeForward;
      // cseca4d
      PersonEligibility personEligibilityForward = personEligibilityDAO
                                                                       .findPersonEligibilityOpenStages(idPersEligPerson);
      if (personEligibilityForward != null) {
        // Both Closed and Forward Person has EA eligibility
        Date ForwardStartDate = personEligibilityForward.getDtPersEligStart();
        if (DateHelper.isBefore(ClosedStartDate, ForwardStartDate)) {
          int idPersElig = personEligibilityForward.getIdPersElig();
          idPersEligPerson = idPersMergeForward;
          // caudd1d
          personEligibilityDAO.updateCdPersEligTypeAndEligDatesByIdPersElig(idPersElig, cdPersEligType,
                                                                            dtPersEligStart, dtPersEligEnd,
                                                                            dtPersEligEaDeny, cdPersEligPrgStart,
                                                                            cdPersEligPrgOpen);
        }
      } else {
        // Only Closed Person has EA eligibility
        idPersEligPerson = idPersMergeForward;
        // caudd1d
        personEligibilityDAO.insertPersonEligibility(dtPersEligStart, dtPersEligEnd, dtPersEligEaDeny,
                                                     cdPersEligPrgStart, cdPersEligPrgOpen, idPersEligPerson);
      }
    }
  }

  private void callStageDAO(int idPersMergeForward, int idPersMergeClosed) throws ServiceException {
    boolean bPrincipal = false;
    // CLSC83D
    // Call the Duplicate Stage Person Link Retrieval Dam - CLSC83D
    // Description - This DAM will retrieve the id_stage for all rows
    // in the stage_person_link table with duplicate spl id's.
    int x = 0;
    int iRowToUpdate = 0;
    // clsc83d
    List<Integer> stageList = stageDAO.findStageIdSategeForAllDupliactes(idPersMergeClosed, idPersMergeForward);
    if (stageList != null && !stageList.isEmpty()) {
      // for loop to go through all the rows retrieved by clsc83d
      for (Iterator<Integer> it = stageList.iterator(); it.hasNext();) {
        // Call the Select Duplicate Stage Person Link Retrieval Dam - CLSS74D
        int idStage = (Integer) it.next();
        // int idStage = stage.getIdStage();
        // clss74d
        List<StagePersonLink> stagePersonLinkList = stagePersonLinkDAO
                                                                      .findStagePersonLinkByIdStageOrderByCdStagePersrole(idStage);
        if (stagePersonLinkList == null || stagePersonLinkList.isEmpty()) {
          throw new ServiceException(Messages.MSG_DATABASE_SAVE_FAIL);
        }
        x = 0;
        int j = 0;
        // for loop to go through all the rows retrieved by clss74d
        for (Iterator<StagePersonLink> itStagePersonLink = stagePersonLinkList.iterator(); itStagePersonLink.hasNext();) {
          StagePersonLink stagePersonLink = itStagePersonLink.next();
          if ((stagePersonLink.getPerson().getIdPerson() == idPersMergeForward)
              || (stagePersonLink.getPerson().getIdPerson() == idPersMergeClosed)) {
            if (CodesTables.CPRSNTYP_PRN.equals(stagePersonLink.getCdStagePersType())) {
              bPrincipal = true;
            }
            // Store the row to be PersMergeForward in iRowToUpdate in order to update it later.
            // Delete the rest of the rows retrieved, which will be PersMergeClosed. Could not
            // update at this point because the database thinks a duplicate row is being created.
            if (x == 0) {
              iRowToUpdate = j;
            } else {
              int idStagePerson = stagePersonLink.getIdStagePersonLink();
              StagePersonLink stagePersonLinkToDelete = (StagePersonLink) getPersistentObject(StagePersonLink.class,
                                                                                              idStagePerson);
              // CAUDC5D
              stagePersonLinkDAO.deleteStagePersonLink(stagePersonLinkToDelete);
            }
            x++;
          }
          j++;
        }
        int idStagePerson = stagePersonLinkList.get(iRowToUpdate).getIdStagePersonLink();
        Date dtLastUpdate = stagePersonLinkList.get(iRowToUpdate).getDtLastUpdate();
        String cdStagePersType = null;
        if (bPrincipal) {
          cdStagePersType = CodesTables.CPRSNTYP_PRN;
        } else {
          cdStagePersType = CodesTables.CPRSNTYP_COL;
        }
        // caudc5d
        int rowsUpdated = stagePersonLinkDAO.updateIdPersonCdStagePersTypeByIdStagePersonLink(idPersMergeForward,
                                                                                              idStagePerson,
                                                                                              cdStagePersType,
                                                                                              dtLastUpdate);
        if (rowsUpdated == 0) {
          throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
        }
      }
    }
  }

  private void addPersonMerge(int idPersMergeForward, int idPersMergeClosed, int idPersMergeWrkr, Date dtPersMerge,
                              Date dtPersMergeSplit) {
    // CAUD63D
    String indPersMergeInvalid = ArchitectureConstants.N;
    PersonMerge personMergeToSave = new PersonMerge();
    personMergeToSave.setIndPersMergeInvalid(indPersMergeInvalid);
    Person personForward = (Person) getPersistentObject(Person.class, idPersMergeForward);
    personMergeToSave.setPersonByIdPersMergeForward(personForward);
    Person personClosed = (Person) getPersistentObject(Person.class, idPersMergeClosed);
    personMergeToSave.setPersonByIdPersMergeClosed(personClosed);
    Person personWrkr = (Person) getPersistentObject(Person.class, idPersMergeWrkr);
    personMergeToSave.setPersonByIdPersMergeWrkr(personWrkr);
    personMergeToSave.setDtPersMerge(dtPersMerge);
    personMergeToSave.setDtPersMergeSplit(dtPersMergeSplit);
    // Calling caud63d
    // This dao will update rows on the Person Merge table.
    personMergeDAO.savePersonMerge(personMergeToSave);

  }

  private void processPersonMergeList(int idPersMergeForward_row, int idPersMergeClosed_row, int idPersMergeWrkr_row,
                                      Date dtPersMerge, Date dtPersMergeSplit) {
    // Call the Person Merge List Retrieval Dao - CLSS49D
    // Description - This Dam will return the valid rows on the person merge
    // table where the host id is the Merge Closed.
    String indPersMergeInvalid = ArchitectureConstants.N;
    // Calling clss49d
    List<PersonMerge> personMergeList = personMergeDAO
                                                      .findPersonMergeFromMergeInvalidAndMergeForward(
                                                                                                      indPersMergeInvalid,
                                                                                                      idPersMergeClosed_row);
    if (personMergeList != null && !personMergeList.isEmpty()) {
      // Call caud63d the first time to update the person merge table
      // where the person closed id is found in the person forward column
      // and set the row to invalid. Then if a row was updated call caud63d
      // a second time to create a new row so that the person closed
      // in the newly invalidated row is now merged into the new person
      // merge sent from the window. This situation is called a multiple
      // merge.
      // If the row that the person closed id was found in has the two
      // id fields equal (i.e. the person was previously a person forward)
      // then do not create the new row after the invalidation since
      // this would end up duplicating the merge requested on the window so
      // let the third call to caud63 do this.
      for (Iterator<PersonMerge> it = personMergeList.iterator(); it.hasNext();) {
        PersonMerge personMerge = it.next();
        Date dtLastUpdate = personMerge.getDtLastUpdate();
        int idPersMergeForward = personMerge.getPersonByIdPersMergeForward().getIdPerson();
        int idPersMergeClosed = personMerge.getPersonByIdPersMergeClosed().getIdPerson();
        int idPersMergeWrkr = personMerge.getPersonByIdPersMergeWrkr().getIdPerson();
        int idPersonMerge = personMerge.getIdPersonMerge();
        indPersMergeInvalid = ArchitectureConstants.Y;

        int idPersMergeSplitWrkr = 0;
        if (personMerge.getPersonByIdPersMergeSplitWrkr() != null) {
          idPersMergeSplitWrkr = personMerge.getPersonByIdPersMergeSplitWrkr().getIdPerson();
        }

        // Calling caud63d
        int rows = complexPersonMergeDAO.updatePersonMerge(idPersonMerge, idPersMergeForward, idPersMergeClosed,
                                                           idPersMergeWrkr, idPersMergeSplitWrkr, indPersMergeInvalid,
                                                           dtPersMergeSplit, dtLastUpdate);
        // Now add a new row to the person merge table using the person closed that
        // was just invalidated and merge them into the new person merge. But only
        // if the previous dam call was successful and the row just invalidated
        // wasn't a previous person forward equal person forward row. (See comment above)
        if ((rows != 0) && (idPersMergeForward != idPersMergeClosed_row)) {
          indPersMergeInvalid = ArchitectureConstants.N;
          PersonMerge personMergeToSave = new PersonMerge();
          personMergeToSave.setIndPersMergeInvalid(indPersMergeInvalid);
          Person personForward = (Person) getPersistentObject(Person.class, idPersMergeForward_row);
          personMergeToSave.setPersonByIdPersMergeForward(personForward);
          Person personClosed = (Person) getPersistentObject(Person.class, idPersMergeClosed_row);
          personMergeToSave.setPersonByIdPersMergeClosed(personClosed);
          Person personWrkr = (Person) getPersistentObject(Person.class, idPersMergeWrkr_row);
          personMergeToSave.setPersonByIdPersMergeWrkr(personWrkr);
          personMergeToSave.setDtPersMerge(dtPersMerge);
          personMergeToSave.setDtPersMergeSplit(dtPersMergeSplit);
          // Calling caud63d
          personMergeDAO.savePersonMerge(personMergeToSave);
        }
        //mxpatel added this IF for defect #10188
        //In case of multiple merge, Check if the Old person merge and Old person close are not the same.
        //And create a link between the new person forward and each of the old person closed.
        if((rows != 0) && (idPersMergeForward != idPersMergeClosed)){
          indPersMergeInvalid = ArchitectureConstants.N;
          PersonMerge personMergeToSave = new PersonMerge();
          personMergeToSave.setIndPersMergeInvalid(indPersMergeInvalid);
          Person personForward = (Person) getPersistentObject(Person.class, idPersMergeForward_row);
          personMergeToSave.setPersonByIdPersMergeForward(personForward);
          Person personClosed = (Person) getPersistentObject(Person.class, idPersMergeClosed);
          personMergeToSave.setPersonByIdPersMergeClosed(personClosed);
          Person personWrkr = (Person) getPersistentObject(Person.class, idPersMergeWrkr_row);
          personMergeToSave.setPersonByIdPersMergeWrkr(personWrkr);
          personMergeToSave.setDtPersMerge(dtPersMerge);
          personMergeToSave.setDtPersMergeSplit(dtPersMergeSplit);
          // Calling caud63d
          personMergeDAO.savePersonMerge(personMergeToSave);
        }
      }
    }
  }

  private void processPersonMerge(int idPersMergeForward, int idPersMergeClosed, int idPersMergeWrkr, Date dtPersMerge,
                                  Date dtPersMergeSplit) {
    // Call the Person Merge List Retrieval Dao - CLSS49D
    // Description - This DAO will return the valid rows on the person merge
    // table where the host id is the Merge Forward.
    // Calling clss49d
    List<PersonMerge> personMergeList = personMergeDAO
                                                      .findPersonMergeFromMergeInvalidAndMergeForward(
                                                                                                      ArchitectureConstants.N,
                                                                                                      idPersMergeForward);
    if (personMergeList == null || personMergeList.isEmpty()) {

      String indPersMergeInvalid = ArchitectureConstants.N;
      PersonMerge personMerge = new PersonMerge();
      personMerge.setIndPersMergeInvalid(indPersMergeInvalid);
      Person personForward = (Person) getPersistentObject(Person.class, idPersMergeForward);
      personMerge.setPersonByIdPersMergeForward(personForward);
      Person personClosed = (Person) getPersistentObject(Person.class, idPersMergeForward);
      personMerge.setPersonByIdPersMergeClosed(personClosed);
      Person personWrkr = (Person) getPersistentObject(Person.class, idPersMergeWrkr);
      personMerge.setPersonByIdPersMergeWrkr(personWrkr);
      personMerge.setDtPersMerge(dtPersMerge);
      personMerge.setDtPersMergeSplit(dtPersMergeSplit);
      // Call daO to Add the first duplicate row. The first duplicate row will
      // have id person forward in both the forward column and in the closed
      // column of the person merge table. (i.e. idpersonclosed = idpersonforward)
      // Calling caud63d
      personMergeDAO.savePersonMerge(personMerge);
    }
  }

  private Person retrievePerson(int idPerson) throws ServiceException {
    Person person = personDAO.findPersonByIdPerson(idPerson);
    if (person == null) {
      throw new ServiceException(Messages.MSG_DATABASE_SAVE_FAIL);
    }
    return person;
  }

  private String processPersonAndPersonCategory(int idPersonForward, int idPersonClosed, Person person)
                                                                                                       throws ServiceException {
    // Set the active flags for later processing based upon the person
    // status retrieved from the person table. The first call is for the
    // id person forward.
    // 
    // Call the Person Retrieval Dao - CCMN44D
    // Description - This DAM will return one row from the person
    // table based upon the id_person passed into it.
    Person personClosed = personDAO.findPersonByIdPerson(idPersonClosed);
    if (personClosed == null) {
      throw new ServiceException(Messages.MSG_DATABASE_SAVE_FAIL);
    }
    if ((!StringHelper.isValid(person.getCdPersonDeath())) && StringHelper.isValid(personClosed.getCdPersonDeath())
        || DateHelper.isNull(person.getDtPersonDeath()) && !DateHelper.isNull(personClosed.getDtPersonDeath())) {
      // If the date of death is empty for person forward but not for person closed,
      // update date of death with the value from person closed
      String cdPersonDeath;
      if (!StringHelper.isValid(person.getCdPersonDeath()) && StringHelper.isValid(personClosed.getCdPersonDeath())) {
        cdPersonDeath = personClosed.getCdPersonDeath();
      } else {
        cdPersonDeath = person.getCdPersonDeath();
      }

      Date dtPersonDeath;
      if ((DateHelper.isNull(person.getDtPersonDeath())) && (!DateHelper.isNull(personClosed.getDtPersonDeath()))) {
        dtPersonDeath = personClosed.getDtPersonDeath();
      } else {
        dtPersonDeath = person.getDtPersonDeath();
      }
      // cinv41d -- ignores SQL_NOT_FOUND
      personDAO.updatePerson(person.getNbrPersonAge(), dtPersonDeath, person.getDtPersonBirth(),
                             person.getCdPersonStatus(), cdPersonDeath, person.getCdPersonMaritalStatus(),
                             person.getCdPersonLanguage(), person.getCdPersonSex(), person.getNmPersonFull(),
                             person.getCdPersonEthnicGroup(), person.getTxtPersonOccupation(),
                             person.getCdPersonLivArr(), person.getIndPersonDobApprox(), person.getCdPersonChar(),
                             person.getCdPersNotYetDiag(), person.getTxtCharCmnts(), person.getCdPersonReligion(),
                             person.getCdDisasterRlf(), idPersonForward, person.getDtLastUpdate(),
                             person.getTxtPersonAddlCmnts());
    }
    updatePersonIdEndDate(idPersonForward, idPersonClosed);
    return personClosed.getCdPersonStatus();

  }

  private void processStagePersonAndEvent(int idPersonForward, int idPersonClosed) {
    // clsc47d
    List<Object[]> stagePersonLinkClosedList = stagePersonLinkDAO.findOpenStagesAndEventsPerPerson(idPersonClosed);

    // Analyze return code
    if (stagePersonLinkClosedList != null && !stagePersonLinkClosedList.isEmpty()) {
      // Loop through all the rows returned from clsc47d and update the allegation
      // event and functional tables for each row.
      StagePersonLink previous = null;
      for (Iterator<Object[]> itClosed = stagePersonLinkClosedList.iterator(); itClosed.hasNext();) {
        Object[] currentArray = itClosed.next();
        StagePersonLink current = (StagePersonLink) currentArray[0];
        if ((previous == null) || current.getStage().getIdStage() != previous.getStage().getIdStage()) {
          int idStage = current.getStage().getIdStage();
          int idPersMergeClosed = idPersonClosed;
          int idPersMergeForward = idPersonForward;

          // cdyn14d
          allegationDAO.updateAllegationIdAllegedPerpetrator(idPersMergeForward, idPersMergeClosed, idStage);
          // }
        }
        Event eventClosed = (Event) currentArray[1];
        // For all rows that have an id event, try to first replace
        // the event person link.
        if (0 != eventClosed.getIdEvent()) {
          int idPersMergeClosed = idPersonClosed;
          int idPersMergeForward = idPersonForward;
          int idEvent = eventClosed.getIdEvent();
          // caud67d
          /* SMS #37256 - Check to see if the forward person and the closed person were part of the same event
           * If yes, then delete the link for the closed person. If not, then simply update the event person
           * link of the closed person with the id of the forward person.
           */
          EventPersonLink eventPersonForwardLink = eventPersonLinkDAO.findEventPersonLinkByIdEventAndIdPerson(idEvent, idPersMergeForward);
          EventPersonLink eventPersonClosedLink = eventPersonLinkDAO.findEventPersonLinkByIdEventAndIdPerson(idEvent, idPersMergeClosed);
          if (!NullHelper.isEmptyOrNull(eventPersonForwardLink) && 
                          !NullHelper.isEmptyOrNull(eventPersonClosedLink)) {
            // Do nothing - originally the link of the closed person was deleted,
            // but we do not want to delete data in the case that the merged persons
            // are ever split
          } else {
            eventPersonLinkDAO.updateEventPersonLink(idPersMergeForward, idPersMergeClosed, idEvent);
          }
        }
        if (eventClosed.getCdTask() != null) {
          // First you need to convert the cd task to a numeric value so
          // that the switch statement will work.
          int NumCdTask = Integer.parseInt(eventClosed.getCdTask());
          switch (NumCdTask) {
          case ADO_RISK_ASSMT:
          case INV_RISK_ASSMT:
          case SUB_RISK_ASSMT:
          case PAD_RISK_ASSMT:
          case SVC_RISK_ASSMT:
            int idPersMergeClosed = idPersonClosed;
            int idPersMergeForward = idPersonForward;
            int idStage = current.getStage().getIdStage();
            // cau68d
            riskFactorsDAO.updateRiskFactors(idPersMergeForward, idPersMergeClosed, idStage);
            break;
          case INV_HOME_REMOVAL:
          case FSU_REMOVAL:
          case SVC_REMOVAL:
          case FRE_REMOVAL:
            idPersMergeClosed = idPersonClosed;
            idPersMergeForward = idPersonForward;
            int idEvent = eventClosed.getIdEvent();
            // caud69d
            personHomeRemovalDAO.updatePersonHomeRemoval(idPersMergeForward, idPersMergeClosed, idEvent);
            break;
          case SUB_PPT:
          case PAD_PPT:
          case ADO_PPT:
            idPersMergeClosed = idPersonClosed;
            idPersMergeForward = idPersonForward;
            idEvent = eventClosed.getIdEvent();
            // cdyn16d
            pptParticipantDAO.updatePptParticipant(idEvent, idPersMergeForward, idPersMergeClosed);
            break;
          case SUB_CP:
            idPersMergeClosed = idPersonClosed;
            idPersMergeForward = idPersonForward;
            idEvent = eventClosed.getIdEvent();
            // cdyn16d
            childPlanParticipDAO.updateChildPlanParticipIdPerson(idPersMergeForward, idPersMergeClosed, idEvent);
            break;
          case FRE_PLAN:
          case FPR_PLAN:
          case FSU_PLAN:
            idPersMergeClosed = idPersonClosed;
            idPersMergeForward = idPersonForward;
            idEvent = eventClosed.getIdEvent();
            planParticipantDAO.updatePlanParticipant(idEvent, idPersMergeForward, idPersMergeClosed);
            break;
          case SUB_LEGAL_ACT:
          case ADO_LEGAL_ACT:
          case PAD_LEGAL_ACT:
          case INV_LEGAL_ACT_1:
          case AGO_LEGAL_ACT:
          case FSU_LEGAL_ACT:
          case INV_LEGAL_ACT_2:
          case SVC_LEGAL_ACT:
          case SVC_LEGAL_ACT_2:
            idPersMergeClosed = idPersonClosed;
            idPersMergeForward = idPersonForward;
            idEvent = eventClosed.getIdEvent();
            // cdyn16d
            legalActionDAO.updateLegalActionIdPerson(idPersMergeForward, idPersMergeClosed, idEvent);
            break;
          case SUB_LEGAL_STAT:
          case ADO_LEGAL_STAT:
          case PAD_LEGAL_STAT:
          case INV_LEGAL_STAT:
          case FSU_LEGAL_STAT:
          case SVC_LEGAL_STAT:
          case FRE_LEGAL_STAT:
            idPersMergeClosed = idPersonClosed;
            idPersMergeForward = idPersonForward;
            idEvent = eventClosed.getIdEvent();
            // cdyn16d
            legalStatusDAO.updateLegalStatus(idPersMergeClosed, idPersMergeForward, idEvent);
            break;
          case SVC_FAD_ASSMT:
          case FRE_FAD_ASSMT:
          case FSU_FAD_ASSMT:
            idPersMergeClosed = idPersonClosed;
            idPersMergeForward = idPersonForward;
            idEvent = eventClosed.getIdEvent();
            // Calling caud71d
            familyAssmtFactorsDAO.updateFamilyAssmtFactorsIdFamAssmntPrinciple(idPersMergeForward, idPersMergeClosed,
                                                                               idEvent);
            break;
          case SUB_PLAC:
          case ADO_PLAC:
          case PAD_PLAC:
            idPersMergeClosed = idPersonClosed;
            idPersMergeForward = idPersonForward;
            idEvent = eventClosed.getIdEvent();
            // caud83d
            placementDAO.updatePlacementByIdPlcmtEvent(idPersMergeForward, idPersMergeClosed, idEvent);
            break;
          case FCE_APP:
          case FCE_ELIG:
          case FCE_REVIEW:
            idPersMergeClosed = idPersonClosed;
            idPersMergeForward = idPersonForward;
            idStage = current.getStage().getIdStage();
            // cmsc58d
            complexFceDAO.updateFceIncome(idPersMergeForward, idPersMergeClosed, idStage);
            break;
          case INV_SAFE_RSRC:
          case FPR_SAFE_RSRC:
            // Check safety resource tables
            idPersMergeClosed = idPersonClosed;
            idPersMergeForward = idPersonForward;
            idEvent = eventClosed.getIdEvent();
            complexSafetyResourceDAO.updateSafetyResource(idPersMergeForward, idPersMergeClosed, idEvent);
            break;
          case FPR_CS:
          case FSU_CS:
            // Update the contact rule table
            idPersMergeClosed = idPersonClosed;
            idPersMergeForward = idPersonForward;
            idEvent = eventClosed.getIdEvent();
            contactRuleDAO.updateContactRule(idPersMergeForward, idPersMergeClosed, idEvent); 
            contactForDAO.updateContactFor(idPersMergeForward, idPersMergeClosed, idEvent);
          }
        }
        previous = current;
      }
    }
  }

  private void findAndDeleteAllegation(int idPersMergeForward) {
    // csec83d
    List<Object[]> allegationArrayList = allegationDAO.findAllegationDuplicatesByIdPerson(idPersMergeForward);
    if (allegationArrayList != null && !allegationArrayList.isEmpty()) {
      // into CINV07D
      for (Iterator<Object[]> it = allegationArrayList.iterator(); it.hasNext();) {
        // Populate Input Rec with IdAllegation and DtLastUpdate that needs to be deleted.
        // Use Data from CSEC83D. The following code determines which IdAllegation to pass
        Object[] obj = it.next();
        Allegation allegation = (Allegation) obj[0];
        Allegation allegation2 = (Allegation) obj[1];
        if ((CodesTables.CSTAGES_INT.equals(allegation.getCdAllegIncidentStage()))
            && (CodesTables.CSTAGES_INV.equals(allegation2.getCdAllegIncidentStage()))) {
          // Set IdAllegation to the id allegation of the INV stage In this case IdAllegation2
          int idAllegation = allegation2.getIdAllegation();
          Date dtLastUpdate = allegation2.getDtLastUpdate();
          Allegation allegationToDelete = new Allegation();
          allegationToDelete.setIdAllegation(idAllegation);
          allegationToDelete.setDtLastUpdate(dtLastUpdate);
          // cinv07d
          allegationDAO.deleteAllegation(allegationToDelete);
          // Reset the deleted IdAllegation to 0. This allows the CAUDC4D to know which Allegations
          // have been deleted. CAUDC4D will not process any rows with IdAllegation = 0.
          allegation2.setIdAllegation(0);
        } else if ((CodesTables.CSTAGES_INT.equals(allegation2.getCdAllegIncidentStage()))
                   && (CodesTables.CSTAGES_INV.equals(allegation.getCdAllegIncidentStage()))) {
          int idAllegation = allegation.getIdAllegation();
          Date dtLastUpdate = allegation.getDtLastUpdate();
          Allegation allegationToDelete = new Allegation();
          allegationToDelete.setIdAllegation(idAllegation);
          allegationToDelete.setDtLastUpdate(dtLastUpdate);
          // This dao will decide which allegations are duplicates and delete them.
          // If the cd_stage are the same then it will delete the newest allegation.
          // If the cd_stages are different, then it will delete the INV allegation.
          // If CSEC83D returns SQL_NOT_FOUND, then no duplicates exist. Only delete
          // duplicates if CSEC83D is not null or empty.
          // cinv07d
          allegationDAO.deleteAllegation(allegationToDelete);
          // Reset the deleted IdAllegation to 0. This allows the CAUDC4D to know which Allegations
          // have been deleted. CAUDC4D will not process any rows with IdAllegation = 0.
          allegation.setIdAllegation(0);
        } else {
          // Since the CdStages are the same, delete the newest allegation This is always the
          // 2nd Allegation since CSEC83D always places the newest allegation in IdAllegation2
          int idAllegation = allegation2.getIdAllegation();
          Date dtLastUpdate = allegation2.getDtLastUpdate();
          Allegation allegationToDelete = new Allegation();
          allegationToDelete.setIdAllegation(idAllegation);
          allegationToDelete.setDtLastUpdate(dtLastUpdate);
          // Calling cinv07d
          allegationDAO.deleteAllegation(allegationToDelete);
          // Reset the deleted IdAllegation to 0. This allows the CAUDC4D to know which Allegations
          // have been deleted. CAUDC4D will not process any rows with IdAllegation = 0.
          allegation2.setIdAllegation(0);
        }
      }
    }
    // Loop through CSEC83DOutputRec again. This time update based
    // on IdAllegation
    for (Iterator<Object[]> it = allegationArrayList.iterator(); it.hasNext();) {
      Object[] obj = it.next();
      Allegation allegation = (Allegation) obj[0];
      if (0 != allegation.getIdAllegation()) {
        int idAllegation = allegation.getIdAllegation();
        Date dtLastUpdate = allegation.getDtLastUpdate();
        // Calling caudc4d
        allegationDAO.updateCdAllegDispositionByIdAllegationAndDtLastUpdate(idAllegation, dtLastUpdate);
      }
    }

    // Loop through CSEC83DOutputRec again. This time update based
    // on IdAllegation2
    for (Iterator<Object[]> it = allegationArrayList.iterator(); it.hasNext();) {
      Object[] obj = it.next();
      Allegation allegation2 = (Allegation) obj[1];
      if (0 != allegation2.getIdAllegation()) {
        int idAllegation = allegation2.getIdAllegation();
        Date dtLastUpdate = allegation2.getDtLastUpdate();
        // caudc4d
        allegationDAO.updateCdAllegDispositionByIdAllegationAndDtLastUpdate(idAllegation, dtLastUpdate);
      }
    }
  }

  private void callCompareAddress(int idPersMergeForward, int idPersMergeClosed) {
    String szTemp = null;
    int ulIdAddress = 0;
    boolean bInsertAddress = false;
    boolean bPrimaryAddressExist = false;
    // string to hold the concatenated address for comparison
    StringBuffer szForward = new StringBuffer();
    StringBuffer szClosed = new StringBuffer();
    // CallCCMN96D
    List<AddressPersonLink> addressPersonLinkListForward = findIntakeOrInvest(idPersMergeForward);
    // CallCCMN96D
    List<AddressPersonLink> addressPersonLinkListClosed = findIntakeOrInvest(idPersMergeClosed);
    // check to see if person_forward has primary address
    for (Iterator<AddressPersonLink> itForward = addressPersonLinkListForward.iterator(); itForward.hasNext();) {
      AddressPersonLink addressPersonLink = itForward.next();
      if (ArchitectureConstants.N.equals(addressPersonLink.getIndPersAddrLinkInvalid())) {
        if (ArchitectureConstants.Y.equals(addressPersonLink.getIndPersAddrLinkPrimary())) {
          bPrimaryAddressExist = true;
        }
      }
    }
    for (Iterator<AddressPersonLink> itClosed = addressPersonLinkListClosed.iterator(); itClosed.hasNext();) {
      AddressPersonLink addressPersonLinkClosed = itClosed.next();
      if (ArchitectureConstants.N.equals(addressPersonLinkClosed.getIndPersAddrLinkInvalid())) {
        szClosed.setLength(0);
        PersonAddress personAddress = addressPersonLinkClosed.getPersonAddress();
        szTemp = personAddress.getAddrPersonAddrZip();
        szClosed.append(szTemp);
        szClosed.append(",");
        szTemp = personAddress.getCdPersonAddrState();
        szClosed.append(szTemp);
        szClosed.append(",");
        szTemp = personAddress.getAddrPersonAddrCity();
        szClosed.append(szTemp);
        szClosed.append(",");
        szTemp = personAddress.getAddrPersAddrStLn1();
        szClosed.append(szTemp);
        szClosed.append(",");
        szTemp = personAddress.getAddrPersAddrStLn2();
        szClosed.append(szTemp);
        szForward.setLength(0);
        // select one record and compare it with all the existing names in
        // person forward. insert if no match found
        for (Iterator<AddressPersonLink> itForward = addressPersonLinkListForward.iterator(); itForward.hasNext();) {
          AddressPersonLink addressPersonLink = itForward.next();
          personAddress = addressPersonLink.getPersonAddress();
          szTemp = personAddress.getAddrPersonAddrZip();
          szForward.append(szTemp);
          szForward.append(",");
          szTemp = personAddress.getCdPersonAddrState();
          szForward.append(szTemp);
          szForward.append(",");
          szTemp = personAddress.getAddrPersonAddrCity();
          szForward.append(szTemp);
          szForward.append(",");
          szTemp = personAddress.getAddrPersAddrStLn1();
          szForward.append(szTemp);
          szForward.append(",");
          szTemp = personAddress.getAddrPersAddrStLn2();
          szForward.append(szTemp);
          if (szForward.equals(szClosed)) {
            bInsertAddress = false;
            break;
          } else {
            bInsertAddress = true;
          }
          szForward.setLength(0);
        }
        if (addressPersonLinkListForward.size() == 0) {
          bInsertAddress = true;
        }
        if (bInsertAddress) {
          // CallCCMNA8D
          ulIdAddress = insertPersonAddress(addressPersonLinkClosed);
          // CallCCMNA9D
          insertAddressPersonLink(idPersMergeForward, addressPersonLinkClosed, ulIdAddress, bPrimaryAddressExist);
        }
      }
    }
  }

  private List<AddressPersonLink> findIntakeOrInvest(int idPerson) {
    // TODO: This used to use NULL_JAVA_DATE; the actual HQL indicates that the current date was more likely desired.
    return complexAddressPersonLinkDAO.findIntakeOrInvest(true, idPerson, new Date());
  }

  private int insertPersonAddress(AddressPersonLink addressPersonLink) {
    // CallCCMNA8D
    PersonAddress personAddress = addressPersonLink.getPersonAddress();
    String addrPersAddrStLn1 = personAddress.getAddrPersAddrStLn1();
    String addrPersAddrStLn2 = personAddress.getAddrPersAddrStLn2();
    String addrCity = personAddress.getAddrPersonAddrCity();
    String addrZip = personAddress.getAddrPersonAddrZip();
    String addrCounty = personAddress.getCdPersonAddrCounty();
    String addrPersAddrAttn = personAddress.getAddrPersonAddrAttn();
    String txtPersonEmail = personAddress.getTxtPersonEmail();
    String addrState = personAddress.getCdPersonAddrState();
    // ccmna8d
    return personAddressDAO.insertPersonAddressWithSeqPersonAddress(addrPersAddrStLn1, addrPersAddrStLn2, addrCity,
                                                                    addrZip, addrPersAddrAttn, txtPersonEmail,
                                                                    addrCounty, addrState);
  }

  private void insertAddressPersonLink(int idPerson, AddressPersonLink addressPersonLink, int ulIdAddress,
                                       boolean bPrimaryExist) {
    // CallCCMNA9D
    String cdPersAddrLinkType = addressPersonLink.getCdPersAddrLinkType();
    Date dtDtPersAddrLinkEnd = addressPersonLink.getDtPersAddrLinkEnd();
    String indPersAddrLinkInvalid = addressPersonLink.getIndPersAddrLinkInvalid();
    String indPersAddrLinkPrimary = null;
    if (bPrimaryExist) {
      indPersAddrLinkPrimary = ArchitectureConstants.N;
    } else {
      indPersAddrLinkPrimary = addressPersonLink.getIndPersAddrLinkPrimary();
    }
    String indRemovalHome = addressPersonLink.getIndRemovalHome();
    String txtPersAddrCmnts = addressPersonLink.getTxtPersAddrCmnts();
    // ccmna9d
    complexAddressPersonLinkDAO.insertAddressPersonLink(dtDtPersAddrLinkEnd, idPerson, ulIdAddress,
                                                        indPersAddrLinkInvalid, indPersAddrLinkPrimary,
                                                        txtPersAddrCmnts, cdPersAddrLinkType, indRemovalHome);
  }

  private void callComparePhone(int idPersMergeForward, int idPersMergeClosed) {
    String szTemp = new String();
    boolean bInsertPhone = false;
    boolean bPrimaryPhoneExist = false;
    // string to hold the concatenated phone for comparison
    StringBuffer szForward = new StringBuffer();
    StringBuffer szClosed = new StringBuffer();
    List<PersonPhone> personPhoneForwardList = processPersonPhoneDAOFindPersonPhone(idPersMergeForward);
    List<PersonPhone> personPhoneClosedList = processPersonPhoneDAOFindPersonPhone(idPersMergeClosed);

    // check to see if person_forward has primary phone
    for (Iterator<PersonPhone> itForward = personPhoneForwardList.iterator(); itForward.hasNext();) {
      PersonPhone personPhone = itForward.next();
      if (ArchitectureConstants.N.equals(personPhone.getIndPersonPhoneInvalid())) {
        if (ArchitectureConstants.Y.equals(personPhone.getIndPersonPhonePrimary())) {
          bPrimaryPhoneExist = true;
        }
      }
    }
    for (Iterator<PersonPhone> itClosed = personPhoneClosedList.iterator(); itClosed.hasNext();) {
      PersonPhone personPhoneClosed = itClosed.next();
      if (ArchitectureConstants.N.equals(personPhoneClosed.getIndPersonPhoneInvalid())) {
        szClosed.setLength(0);
        szTemp = personPhoneClosed.getNbrPersonPhone();
        szClosed.append(szTemp);
        szClosed.append(",");
        szTemp = personPhoneClosed.getNbrPersonPhoneExtension();

        szClosed.append(szTemp);
        szClosed.append(",");
        szTemp = personPhoneClosed.getCdPersonPhoneType();
        szClosed.append(szTemp);
        szForward.setLength(0);
        // select one record and compare it with all the existing phones in
        // person forward. insert if no match found
        for (Iterator<PersonPhone> itForward = personPhoneForwardList.iterator(); itForward.hasNext();) {
          PersonPhone personPhoneForward = itForward.next();
          if (ArchitectureConstants.N.equals(personPhoneForward.getIndPersonPhoneInvalid())) {
            szTemp = personPhoneForward.getNbrPersonPhone();
            szForward.append(szTemp);
            szForward.append(",");
            szTemp = personPhoneForward.getNbrPersonPhoneExtension();
            szForward.append(szTemp);
            szForward.append(",");
            szTemp = personPhoneForward.getCdPersonPhoneType();
            szForward.append(szTemp);

            if (szForward.equals(szClosed)) {
              bInsertPhone = false;
              break;
            } else {
              bInsertPhone = true;
            }
            szForward.setLength(0);
          }
        }

        if (personPhoneForwardList.size() == 0) {
          bInsertPhone = true;
        }

        if (bInsertPhone) {
          insertPersonPhone(idPersMergeForward, personPhoneClosed, bPrimaryPhoneExist);
        }
      }
    }
  }

  private List<PersonPhone> processPersonPhoneDAOFindPersonPhone(int idPerson) {
    return personPhoneDAO.findPersonPhoneByIdPersonDtPersonPhone(idPerson, new Date());
  }

  private void insertPersonPhone(int idPerson, PersonPhone personPhone, boolean bPrimaryExist) {
    String cdPhoneType = personPhone.getCdPersonPhoneType();
    String cdNbrPhone = personPhone.getNbrPersonPhone();
    String cdNbrPhoneExtension = personPhone.getNbrPersonPhoneExtension();

    String indPersonPhonePrimary = null;

    if (bPrimaryExist) {

      indPersonPhonePrimary = ArchitectureConstants.N;
    } else {

      indPersonPhonePrimary = personPhone.getIndPersonPhonePrimary();
    }
    String indPersonPhoneInvalid = personPhone.getIndPersonPhoneInvalid();
    String cdTxtPhoneComments = personPhone.getTxtPersonPhoneComments();
    complexPersonPhoneDAO.insertPersonPhone(null, idPerson, cdPhoneType, cdNbrPhone, cdNbrPhoneExtension,
                                            indPersonPhonePrimary, indPersonPhoneInvalid, cdTxtPhoneComments, 0,
                                            DateHelper.MAX_JAVA_DATE);
  }

  private void callCompareEducation(int idPersMergeForward, int idPersMergeClosed) {
    // CallCAUD78D
    String szTemp = new String();
    int lRC1 = 0;

    boolean bInsertEducation = false;

    // string to hold the concatenated Education for comparison
    StringBuffer szForward = new StringBuffer();
    StringBuffer szClosed = new StringBuffer();
    List<EducationalHistory> educationHistoryForwardList = educationalHistoryDAO
                                                                                .findEducationalHistoryByIdPerson(idPersMergeForward);

    List<EducationalHistory> educationHistoryClosedList = educationalHistoryDAO
                                                                               .findEducationalHistoryByIdPerson(idPersMergeClosed);

    for (Iterator<EducationalHistory> itClosed = educationHistoryClosedList.iterator(); itClosed.hasNext();) {
      EducationalHistory educationHistoryClosed = itClosed.next();
      szClosed.setLength(0);
      szTemp = educationHistoryClosed.getNmEdhistSchool();
      szClosed.append(szTemp);
      szClosed.append(",");
      szTemp = educationHistoryClosed.getCdEdhistEnrollGrade();
      szClosed.append(szTemp);
      szForward.setLength(0);
      // select one record and compare it with all the existing names in
      // person forward. insert if no match found
      for (Iterator<EducationalHistory> itForward = educationHistoryForwardList.iterator(); itForward.hasNext();) {
        EducationalHistory educationHistoryForward = itForward.next();
        szTemp = educationHistoryForward.getNmEdhistSchool();
        szForward.append(szTemp);
        szForward.append(",");
        szTemp = educationHistoryForward.getCdEdhistEnrollGrade();
        szForward.append(szTemp);

        // STGAP00007360: if one or both dates are null treat the dates as not equal
        Date forwardEnrollDate = educationHistoryForward.getDtEdhistEnrollDate();
        Date closedEnrollDate = educationHistoryClosed.getDtEdhistEnrollDate();
        if (forwardEnrollDate != null && closedEnrollDate != null) {
          lRC1 = (int) DateHelper.minutesDifference(forwardEnrollDate, forwardEnrollDate);
        } else {
          lRC1 = 1;
        }

        // STGAP00007360: If the school infos are not equal and the enrollment dates are not equal, then
        // transfer the records from the 'closed' person to the 'forward' person
        if ((szForward.equals(szClosed) == false) && lRC1 != 0) {
          bInsertEducation = true;
        } else {
          bInsertEducation = false;

          break;
        }
        szForward.setLength(0);
      }

      if (educationHistoryForwardList.size() == 0) {
        bInsertEducation = true;
      }
      if (bInsertEducation) {
        // CallCAUD78D
        saveEducationalHistory(idPersMergeForward, educationHistoryClosed);
      }
    }
  }

  private void saveEducationalHistory(int idPerson, EducationalHistory educationHistoryClosed) {
    // CallCAUD78D
    Date dtLastUpdate = educationHistoryClosed.getDtLastUpdate();
    Date DtEdhistEnrollDate = educationHistoryClosed.getDtEdhistEnrollDate();
    Date DtEdhistWithdrawnDate = educationHistoryClosed.getDtEdhistWithdrawnDate();
    String IndEdhistTeaSchool = educationHistoryClosed.getIndEdhistTeaSchool();
    String AddrEdhistCity = educationHistoryClosed.getAddrEdhistCity();
    String AddrEdhistCnty = educationHistoryClosed.getAddrEdhistCnty();
    String AddrEdhistState = educationHistoryClosed.getAddrEdhistState();
    String AddrEdhistStreetLn1 = educationHistoryClosed.getAddrEdhistStreetLn1();
    String AddrEdhistStreetLn2 = educationHistoryClosed.getAddrEdhistStreetLn2();
    String AddrEdhistZip = educationHistoryClosed.getAddrEdhistZip();
    String NbrEdhistPhone = educationHistoryClosed.getNbrEdhistPhone();
    String NbrEdhistPhoneExt = educationHistoryClosed.getNbrEdhistPhoneExt();
    String TxtEdhistAddrCmnt = educationHistoryClosed.getTxtEdhistAddrCmnt();
    String CdEdhistEnrollGrade = educationHistoryClosed.getCdEdhistEnrollGrade();
    String CdEdhistWithdrawnGrade = educationHistoryClosed.getCdEdhistWithdrawnGrade();
    String CdEdhistNeeds1 = educationHistoryClosed.getCdEdhistNeeds1();
    String CdEdhistNeeds2 = educationHistoryClosed.getCdEdhistNeeds2();
    String CdEdhistNeeds3 = educationHistoryClosed.getCdEdhistNeeds3();
    String CdEdhistNeeds4 = educationHistoryClosed.getCdEdhistNeeds4();
    String CdEdhistNeeds5 = educationHistoryClosed.getCdEdhistNeeds5();
    String CdEdhistNeeds6 = educationHistoryClosed.getCdEdhistNeeds6();
    String CdEdhistNeeds7 = educationHistoryClosed.getCdEdhistNeeds7();
    String CdEdhistNeeds8 = educationHistoryClosed.getCdEdhistNeeds8();
    String NmEdhistSchool = educationHistoryClosed.getNmEdhistSchool();
    String NmEdhistSchDist = educationHistoryClosed.getNmEdhistSchDist();

    // STGAP00007891: added missing values
    String CdEdhistType = educationHistoryClosed.getCdEdhistType();
    String CdAttendance = educationHistoryClosed.getCdAttendance();
    String CdCurrGrade = educationHistoryClosed.getCdCurrGrade();
    String CdEdhistNeeds9 = educationHistoryClosed.getCdEdhistNeeds9();
    String CdEdhistNeeds10 = educationHistoryClosed.getCdEdhistNeeds10();
    Date DtEduPlan = educationHistoryClosed.getDtEduPlan();
    Date DtSstRef = educationHistoryClosed.getDtSstRef();
    String IndCurrGradeLevel = educationHistoryClosed.getIndCurrGradeLevel();
    String IndEdhistLicense = educationHistoryClosed.getIndEdhistLicense();
    String IndEis = educationHistoryClosed.getIndEis();
    String IndFstrPrnt = educationHistoryClosed.getIndFstrPrnt();
    String IndLegalPrnt = educationHistoryClosed.getIndLegalPrnt();
    String IndPrevEduNeed = educationHistoryClosed.getIndPrevEduNeed();
    String IndPrevEis = educationHistoryClosed.getIndPrevEis();
    String IndRecBoard = educationHistoryClosed.getIndRecBoard();
    String IndSchChg = educationHistoryClosed.getIndSchChg();
    String IndSchRec = educationHistoryClosed.getIndSchRec();
    String IndSpcEduNeed = educationHistoryClosed.getIndSpcEduNeed();
    String NmSurrPrnt = educationHistoryClosed.getNmSurrPrnt();
    String TxtDscplComm = educationHistoryClosed.getTxtDscplComm();
    String TxtEdhistCmnts = educationHistoryClosed.getTxtEdhistCmnts();
    String TxtEis = educationHistoryClosed.getTxtEis();
    String TxtSpcEdu = educationHistoryClosed.getTxtSpcEdu();
    String TxtSst = educationHistoryClosed.getTxtSst();

    int idResource = 0;
    if (educationHistoryClosed.getCapsResource() != null && educationHistoryClosed.getCapsResource().equals(null)) {
      idResource = educationHistoryClosed.getCapsResource().getIdResource();
    }
    EducationalHistory educationalHistory = new EducationalHistory();
    educationalHistory.setDtLastUpdate(dtLastUpdate);
    educationalHistory.setDtEdhistEnrollDate(DtEdhistEnrollDate);
    educationalHistory.setDtEdhistWithdrawnDate(DtEdhistWithdrawnDate);
    educationalHistory.setIndEdhistTeaSchool(IndEdhistTeaSchool);
    educationalHistory.setAddrEdhistCity(AddrEdhistCity);
    educationalHistory.setAddrEdhistCnty(AddrEdhistCnty);
    educationalHistory.setAddrEdhistState(AddrEdhistState);
    educationalHistory.setAddrEdhistStreetLn1(AddrEdhistStreetLn1);
    educationalHistory.setAddrEdhistStreetLn2(AddrEdhistStreetLn2);
    educationalHistory.setAddrEdhistZip(AddrEdhistZip);
    educationalHistory.setNbrEdhistPhone(NbrEdhistPhone);
    educationalHistory.setNbrEdhistPhoneExt(NbrEdhistPhoneExt);
    educationalHistory.setTxtEdhistAddrCmnt(TxtEdhistAddrCmnt);
    educationalHistory.setCdEdhistEnrollGrade(CdEdhistEnrollGrade);
    educationalHistory.setCdEdhistWithdrawnGrade(CdEdhistWithdrawnGrade);
    educationalHistory.setNmEdhistSchool(NmEdhistSchool);
    educationalHistory.setNmEdhistSchDist(NmEdhistSchDist);
    educationalHistory.setCdEdhistNeeds1(CdEdhistNeeds1);
    educationalHistory.setCdEdhistNeeds2(CdEdhistNeeds2);
    educationalHistory.setCdEdhistNeeds3(CdEdhistNeeds3);
    educationalHistory.setCdEdhistNeeds4(CdEdhistNeeds4);
    educationalHistory.setCdEdhistNeeds5(CdEdhistNeeds5);
    educationalHistory.setCdEdhistNeeds6(CdEdhistNeeds6);
    educationalHistory.setCdEdhistNeeds7(CdEdhistNeeds7);
    educationalHistory.setCdEdhistNeeds8(CdEdhistNeeds8);

    // STGAP00007891: added missing values
    educationalHistory.setCdEdhistType(CdEdhistType);
    educationalHistory.setCdAttendance(CdAttendance);
    educationalHistory.setCdCurrGrade(CdCurrGrade);
    educationalHistory.setCdEdhistNeeds9(CdEdhistNeeds9);
    educationalHistory.setCdEdhistNeeds10(CdEdhistNeeds10);
    educationalHistory.setDtEduPlan(DtEduPlan);
    educationalHistory.setDtSstRef(DtSstRef);
    educationalHistory.setIndCurrGradeLevel(IndCurrGradeLevel);
    educationalHistory.setIndEdhistLicense(IndEdhistLicense);
    educationalHistory.setIndEis(IndEis);
    educationalHistory.setIndFstrPrnt(IndFstrPrnt);
    educationalHistory.setIndLegalPrnt(IndLegalPrnt);
    educationalHistory.setIndPrevEduNeed(IndPrevEduNeed);
    educationalHistory.setIndPrevEis(IndPrevEis);
    educationalHistory.setIndRecBoard(IndRecBoard);
    educationalHistory.setIndSchChg(IndSchChg);
    educationalHistory.setIndSchRec(IndSchRec);
    educationalHistory.setNmSurrPrnt(NmSurrPrnt);
    educationalHistory.setIndSpcEduNeed(IndSpcEduNeed);
    educationalHistory.setTxtDscplComm(TxtDscplComm);
    educationalHistory.setTxtEdhistCmnts(TxtEdhistCmnts);
    educationalHistory.setTxtEis(TxtEis);
    educationalHistory.setTxtSpcEdu(TxtSpcEdu);
    educationalHistory.setTxtSst(TxtSst);

    if (idResource != 0) {
      CapsResource capsResource = (CapsResource) getPersistentObject(CapsResource.class, idResource);
      educationalHistory.setCapsResource(capsResource);
    }

    Person person = (Person) getPersistentObject(Person.class, idPerson);
    educationalHistory.setPerson(person);
    // caud78d
    educationalHistoryDAO.saveEducationalHistory(educationalHistory);
  }

  private void callCompareChar(int idPersMergeForward, int idPersMergeClosed) {
    boolean bInsertChar = false;

    // string to hold the concatenated Characteristic and Category for comparison
    StringBuffer szCharCategoryForward = new StringBuffer();
    StringBuffer szCharCategoryClosed = new StringBuffer();

    Date dtSysdate = new Date();
    // CallCLSS60D
    List<Characteristics> charForwardList = characteristicsDAO.findCharacteristicsByIdPerson(idPersMergeForward,
                                                                                             dtSysdate);
    // CallCLSS60D
    List<Characteristics> charClosedList = characteristicsDAO.findCharacteristicsByIdPerson(idPersMergeClosed,
                                                                                            dtSysdate);

    for (Iterator<Characteristics> itClosed = charClosedList.iterator(); itClosed.hasNext();) {
      Characteristics charClosed = itClosed.next();
      szCharCategoryClosed.append(charClosed.getCdCharCategory());
      szCharCategoryClosed.append(",");
      szCharCategoryClosed.append(charClosed.getCdCharacteristic());
      szCharCategoryForward.setLength(0);
      // select one record and compare it with all the existing chars in
      // person forward. insert if no match found
      for (Iterator<Characteristics> itForward = charForwardList.iterator(); itForward.hasNext();) {
        Characteristics charForward = itForward.next();
        szCharCategoryForward.append(charForward.getCdCharCategory());
        szCharCategoryForward.append(",");
        szCharCategoryForward.append(charForward.getCdCharacteristic());
        if (szCharCategoryForward.equals(szCharCategoryClosed)) {
          bInsertChar = false;
          break;
        } else {
          bInsertChar = true;
        }
        szCharCategoryForward.setLength(0);
      }
      if (charForwardList.size() == 0) {
        bInsertChar = true;
      }
      // check if MergeFrom & MergeTo cases match previous record
      if (bInsertChar) {
        // cinv48d
        if (0 == complexCharacteristicsDAO.insertCharacteristicsForPersonMerge(idPersMergeForward,
                                                                               charClosed.getCdCharCategory(),
                                                                               charClosed.getCdCharacteristic(),
                                                                               charClosed.getDtCharStart(),
                                                                               charClosed.getDtCharEnd())) {
          throw new ServiceException(Messages.SQL_NOT_FOUND);
        }
      }
    }
  }

  private void callCompareMedication(int idPersonForward, int idPersonClosed) {
    boolean bInsertMedication = false;
    StringBuffer szMedicationForward = new StringBuffer();
    StringBuffer szMedicationClosed = new StringBuffer();

    Date dtSysdate = new Date();
    List<Medication> medicationForwardList = medicationDAO.findRelationshipByIdPerson(idPersonForward, dtSysdate);

    List<Medication> medicationClosedList = medicationDAO.findRelationshipByIdPerson(idPersonClosed, dtSysdate);

    for (Iterator<Medication> itClosed = medicationClosedList.iterator(); itClosed.hasNext();) {
      Medication medicationClosed = itClosed.next();
      szMedicationClosed.append(medicationClosed.getNmMedctn());
      szMedicationClosed.append(",");
      szMedicationClosed.append(medicationClosed.getCdMedctnDose());
      szMedicationClosed.append(",");
      szMedicationClosed.append(medicationClosed.getTxtMedctnReason());
      szMedicationClosed.append(",");
      szMedicationClosed.append(medicationClosed.getTxtMedctnAdminPerson());
      szMedicationClosed.append(",");
      szMedicationClosed.append(medicationClosed.getIndMedctnAllergies());
      szMedicationClosed.append(",");
      szMedicationClosed.append(medicationClosed.getTxtMedctnDescrip());
      szMedicationClosed.append(",");
      szMedicationClosed.append(medicationClosed.getTxtMedctnCmnts());
      szMedicationForward.setLength(0);
      // select one record and compare it with all the existing medication in
      // person forward. insert if no match found
      for (Iterator<Medication> itForward = medicationForwardList.iterator(); itForward.hasNext();) {
        Medication medicationForward = itForward.next();
        szMedicationForward.append(medicationForward.getNmMedctn());
        szMedicationForward.append(",");
        szMedicationForward.append(medicationForward.getCdMedctnDose());
        szMedicationForward.append(",");
        szMedicationForward.append(medicationForward.getTxtMedctnReason());
        szMedicationForward.append(",");
        szMedicationForward.append(medicationForward.getTxtMedctnAdminPerson());
        szMedicationForward.append(",");
        szMedicationForward.append(medicationForward.getIndMedctnAllergies());
        szMedicationForward.append(",");
        szMedicationForward.append(medicationForward.getTxtMedctnDescrip());
        szMedicationForward.append(",");
        szMedicationForward.append(medicationForward.getTxtMedctnCmnts());
        if (szMedicationForward.equals(szMedicationClosed)) {
          bInsertMedication = false;
          break;
        } else {
          bInsertMedication = true;
        }
        szMedicationForward.setLength(0);
      }
      if (medicationForwardList.size() == 0) {
        bInsertMedication = true;
      }
      // check if MergeFrom & MergeTo cases match previous record
      if (bInsertMedication) {

        if (0 == complexMedicationDAO.saveMedication(0, idPersonForward, medicationClosed.getNmMedctn(),
                                                     medicationClosed.getCdMedctnDose(),
                                                     medicationClosed.getTxtMedctnReason(),
                                                     medicationClosed.getDtMedctnPresc(),
                                                     medicationClosed.getDtMedctnEndDate(),
                                                     medicationClosed.getTxtMedctnAdminPerson(),
                                                     medicationClosed.getIndMedctnAllergies(),
                                                     medicationClosed.getTxtMedctnDescrip(),
                                                     medicationClosed.getTxtMedctnCmnts())) {
          throw new ServiceException(Messages.SQL_NOT_FOUND);
        }
      }
    }
  }

  private void callCompareRelationship(int idPersonForward, int idPersonClosed) {
    boolean bInsertRelationship = false;

    // string to hold the cd person relationship for comparison
    StringBuffer szRelationshipForward = new StringBuffer();
    StringBuffer szRelationshipClosed = new StringBuffer();

    Date dtSysdate = new Date();

    List<Relationship> relationshipForwardList = relationshipDAO.findRelationshipByIdPerson(idPersonForward, dtSysdate);

    List<Relationship> relationshipClosedList = relationshipDAO.findRelationshipByIdPerson(idPersonClosed, dtSysdate);

    for (Iterator<Relationship> itClosed = relationshipClosedList.iterator(); itClosed.hasNext();) {
      Relationship relationshipClosed = itClosed.next();
      szRelationshipClosed.append(relationshipClosed.getCdPersonRelationship());
      szRelationshipForward.setLength(0);
      // select one record and compare it with all the existing cd person relationships in
      // person forward. insert if no match found
      for (Iterator<Relationship> itForward = relationshipForwardList.iterator(); itForward.hasNext();) {
        Relationship relationshipForward = itForward.next();
        szRelationshipClosed.append(relationshipForward.getCdPersonRelationship());
        if (szRelationshipForward.equals(szRelationshipClosed)) {
          bInsertRelationship = false;
          break;
        } else {
          bInsertRelationship = true;
        }
        szRelationshipForward.setLength(0);
      }
      if (relationshipForwardList.size() == 0) {
        bInsertRelationship = true;
      }
      // check if MergeFrom & MergeTo cases match previous record
      if (bInsertRelationship) {
        relationshipDAO.saveRelationship(relationshipClosed.getIdRelationship(), idPersonForward,
                                         relationshipClosed.getPersonByIdRelatedPerson().getIdPerson(),
                                         relationshipClosed.getCdPersonRelationship());
      }
    }
    // Update all the Related by records where the closed person was related to someone
    // else.  Fixed with MR-062.
    relationshipDAO.updateRelatedPersonforPersonMerge(idPersonForward, idPersonClosed);
    
  }

  private void callCompareTribal(int idPersonForward, int idPersonClosed) {
    boolean bInsertTribal = false;
    String szTemp = new String();
    // string to hold the Tribal for comparison
    StringBuffer szTribalForward = new StringBuffer();
    StringBuffer szTribalClosed = new StringBuffer();
    Tribal tribalForward = tribalDAO.findTribalByIdPerson(idPersonForward);
    Tribal tribalClosed = tribalDAO.findTribalByIdPerson(idPersonClosed);

    if (tribalClosed != null) {
      szTribalClosed.setLength(0);
      szTemp = String.valueOf(tribalClosed.getNbrTrblPercentHeritage());
      szTribalClosed.append(szTemp);
      szTribalClosed.append(",");
      szTemp = tribalClosed.getTxtTribalName();
      szTribalClosed.append(szTemp);
      szTribalClosed.append(",");
      szTemp = tribalClosed.getNbrTribalRegistry();
      szTribalClosed.append(szTemp);
      szTribalClosed.append(",");
      szTemp = tribalClosed.getIndTrblMember();
      szTribalClosed.append(szTemp);
      szTribalForward.setLength(0);
    }

    if (tribalForward != null) {
      // select one record and compare it with the existing Tribal in
      // person forward. insert if no match found
      szTemp = String.valueOf(tribalForward.getNbrTrblPercentHeritage());
      szTribalForward.append(szTemp);
      szTribalForward.append(",");
      szTemp = tribalForward.getTxtTribalName();
      szTribalForward.append(szTemp);
      szTribalForward.append(",");
      szTemp = tribalForward.getNbrTribalRegistry();
      szTribalForward.append(szTemp);
      szTribalForward.append(",");
      szTemp = tribalForward.getIndTrblMember();
      szTribalForward.append(szTemp);

      if (szTribalForward.equals(szTribalClosed)) {
        bInsertTribal = false;
      } else {
        bInsertTribal = true;
      }
      szTribalForward.setLength(0);

    }

    if (tribalForward == null) {
      bInsertTribal = true;
    }
    // check if MergeFrom & MergeTo cases match previous record
    if (bInsertTribal) {
      String indTrblRegistered = StringHelper.EMPTY_STRING;
      String indTrblMember = StringHelper.EMPTY_STRING;
      String nbrTrblPercentHeritage = StringHelper.EMPTY_STRING;
      String txtTribalName = StringHelper.EMPTY_STRING;
      String nbrTribalRegistry = StringHelper.EMPTY_STRING;

      if (tribalClosed != null) {
        indTrblRegistered = tribalClosed.getIndTrblRegistered();
        indTrblMember = tribalClosed.getIndTrblMember();
        nbrTrblPercentHeritage = String.valueOf(tribalClosed.getNbrTrblPercentHeritage());
        txtTribalName = tribalClosed.getTxtTribalName();
        nbrTribalRegistry = tribalClosed.getNbrTribalRegistry();
      } else {

      }

      insertTribal(idPersonForward, indTrblRegistered, indTrblMember, nbrTrblPercentHeritage, txtTribalName,
                   nbrTribalRegistry);
    }
  }

  private void insertTribal(int idPerson, String indRegisteredWithTribe, String indTribalMember,
                            String szTxtPercentHeritage, String szTxtTribalName, String szTxtTribalRegistryNumber) {
    Tribal tribal = new Tribal();

    Person person = getPersistentObject(Person.class, idPerson);
    tribal.setPerson(person);
    tribal.setIndTrblRegistered(indRegisteredWithTribe);
    tribal.setIndTrblMember(indTribalMember);

    if (!"".equals(szTxtPercentHeritage) && !"null".equals(szTxtPercentHeritage)) {
      int percentHeritage = 0;
      try {
        percentHeritage = Integer.parseInt(szTxtPercentHeritage);
      } catch (NumberFormatException nfe) {
      }
      tribal.setNbrTrblPercentHeritage(percentHeritage);
    }

    if (StringHelper.isValid(szTxtTribalRegistryNumber)) {
      tribal.setNbrTribalRegistry(szTxtTribalRegistryNumber);
    }

    tribal.setTxtTribalName(szTxtTribalName);
    tribalDAO.saveTribal(tribal);
  }

  private void callCompareName(int idPersMergeForward, int idPersMergeClosed) throws ServiceException {
    String szTemp = new String();
    boolean bInsertName = false;
    boolean bPrimaryNameExist = false;

    // string to hold the concatenated name for comparison
    StringBuffer szForward = new StringBuffer();
    StringBuffer szClosed = new StringBuffer();
    // get the names from NAME table
    // CallCINV31D
    List<Name> nameForwardList = nameDAO.findNameByIdPerson(idPersMergeForward);
    // CallCINV31D
    List<Name> nameClosedList = nameDAO.findNameByIdPerson(idPersMergeClosed);

    // check to see if person_forward has primary name
    for (Iterator<Name> itForward = nameForwardList.iterator(); itForward.hasNext();) {
      Name name = itForward.next();
      if (ArchitectureConstants.Y.equals(name.getIndNamePrimary())
          && ArchitectureConstants.N.equals(name.getIndNameInvalid())) {
        bPrimaryNameExist = true;
      }
    }

    for (Iterator<Name> itClosed = nameClosedList.iterator(); itClosed.hasNext();) {
      Name nameClosed = itClosed.next();
      if (ArchitectureConstants.N.equals(nameClosed.getIndNameInvalid())) {
        szClosed.setLength(0);
        szTemp = nameClosed.getNmNameFirst();
        szClosed.append(szTemp);
        szClosed.append(",");
        szTemp = nameClosed.getNmNameLast();
        szClosed.append(szTemp);
        szClosed.append(",");
        szTemp = nameClosed.getNmNameMiddle();
        szClosed.append(szTemp);
        szClosed.append(",");
        szTemp = nameClosed.getCdNameSuffix();
        szClosed.append(szTemp);
        szForward.setLength(0);
        // select one record and compare it with all the existing names in
        // person forward. insert if no match found
        for (Iterator<Name> itForward = nameForwardList.iterator(); itForward.hasNext();) {
          Name nameForward = itForward.next();
          szTemp = nameForward.getNmNameFirst();
          szForward.append(szTemp);
          szForward.append(",");
          szTemp = nameForward.getNmNameLast();
          szForward.append(szTemp);
          szForward.append(",");
          szTemp = nameForward.getNmNameMiddle();
          szForward.append(szTemp);
          szForward.append(",");
          szTemp = nameForward.getCdNameSuffix();
          szForward.append(szTemp);
          if (szForward.equals(szClosed)) {
            bInsertName = false;

            break;
          } else {
            bInsertName = true;
          }
          szForward.setLength(0);
        }
        if (nameForwardList.size() == 0) {
          bInsertName = true;
        }
        if (bInsertName) {
          // if no rows found for person_forward, it means there is no name for person_forward
          // therefore we want to insert the name
          // CallCCMNA0D
          insertName(idPersMergeForward, nameClosed, bPrimaryNameExist);
        }
      }
    }

  }

  private void insertName(int idPerson, Name nameClosed, boolean bPrimaryExist) {
    // CallCCMNA0D
    Date dtNameStartDate = new Date();
    Date dtNameEndDate = null;
    String IndNameInvalid = nameClosed.getIndNameInvalid();

    String IndNamePrimary = null;
    if (bPrimaryExist) {
      IndNamePrimary = ArchitectureConstants.N;
    } else {
      IndNamePrimary = nameClosed.getIndNamePrimary();
    }
    String NmNameFirst = nameClosed.getNmNameFirst();
    String NmNameLast = nameClosed.getNmNameLast();
    String NmNameMiddle = nameClosed.getNmNameMiddle();
    String CdNameSuffix = nameClosed.getCdNameSuffix();
    // ccmna0d
    nameDAO.insertName(idPerson, NmNameFirst, NmNameMiddle, NmNameLast, CdNameSuffix, IndNamePrimary, IndNameInvalid,
                       dtNameStartDate, dtNameEndDate);
  }

  private void callCompareIncome(int idPersMergeForward, int idPersMergeClosed) {
    String szTemp = new String();

    int lRCFrom = 0;
    int lRCSys = 0;
    // string to hold the concatenated Education for comparison
    StringBuffer szForward = new StringBuffer();
    StringBuffer szClosed = new StringBuffer();

    boolean bInsertIncome = false;

    Date dtSysdate = new Date();
    List<Map> closedMapList = incomeAndResourcesDAO.findIncomeAndResourcesAndNmFull(idPersMergeClosed);
    List<Map> forwardMapList = incomeAndResourcesDAO.findIncomeAndResourcesAndNmFull(idPersMergeForward);

    for (Iterator<Map> itClosed = closedMapList.iterator(); itClosed.hasNext();) {
      Map closedMap = itClosed.next();

      szClosed.setLength(0);
      szTemp = (String) closedMap.get("cdIncRsrcIncome");
      szClosed.append(szTemp);
      szClosed.append(",");
      szTemp = (String) closedMap.get("cdIncRsrcType");

      szClosed.append(szTemp);

      // if dtDtIncRsrcTo is not max date, check to see if it's after today
      lRCSys = 1;
      if ((!DateHelper.isNull((Date) closedMap.get("dtIncRsrcTo")))) {
        lRCSys = (int) DateHelper.minutesDifference((Date) closedMap.get("dtIncRsrcTo"), dtSysdate);
      }
      szForward.setLength(0);
      // select one record and compare it with all the existing incomes in
      // person forward. insert if no match found
      for (Iterator<Map> itForward = forwardMapList.iterator(); itForward.hasNext() && lRCSys > 0;) {
        Map forwardMap = itForward.next();

        szTemp = (String) forwardMap.get("cdIncRsrcIncome");
        szForward.append(szTemp);
        szForward.append(",");
        szTemp = (String) forwardMap.get("cdIncRsrcType");
        szForward.append(szTemp);
        lRCFrom = 0;
        if ((!DateHelper.isNull((Date) forwardMap.get("dtIncRsrcTo")))) {
          lRCSys = (int) DateHelper.minutesDifference((Date) closedMap.get("dtIncRsrcFrom"),
                                                      (Date) forwardMap.get("dtIncRsrcTo"));
        }
        if (szForward.equals(szClosed)) {
          bInsertIncome = true;
        } else {
          // if they are the same type but one starts on or after the other ends,
          // it's still ok to insert. it's not overlapping
          if (lRCFrom > 0) {
            bInsertIncome = true;
          } else {
            bInsertIncome = false;
            break;
          }
        }
        szForward.setLength(0);
      }
      if (forwardMapList.size() == 0) {
        bInsertIncome = true;
      }
      if (bInsertIncome) {

        // CallCAUD88D
        insertIncomeAndResources(closedMap);
      }
    }
  }

  private void insertIncomeAndResources(Map closedMap) {

    double amtIncRsrc = (Double) closedMap.get("amtIncRsrc");
    String cdIncRsrcIncome = (String) closedMap.get("cdIncRsrcIncome");
    String cdIncRsrcType = (String) closedMap.get("cdIncRsrcType");
    Date dtIncRsrcFrom = (Date) closedMap.get("dtIncRsrcFrom");
    Date dtIncRsrcTo = (Date) closedMap.get("dtIncRsrcTo");
    int idPerson = (Integer) closedMap.get("idPerson");
    int idIncRsrcWorker = (Integer) closedMap.get("idIncRsrcWorker");

    String indIncRsrcNotAccess = (String) closedMap.get("indIncRsrcNotAccess");

    String sdsIncRrcsSource = (String) closedMap.get("sdsIncRsrcSource");

    String sdsIncRsrcVerfMethod = (String) closedMap.get("sdsIncRsrcVerfMethod");

    Date dtLastUpdate = (Date) closedMap.get("dtLastUpdate");
    String txtIncRsrcDesc = (String) closedMap.get("txtIncRsrcDesc");

    incomeAndResourcesDAO.insertIncomeAndResources(idPerson, idIncRsrcWorker, dtLastUpdate, amtIncRsrc, cdIncRsrcType,
                                                   cdIncRsrcIncome, dtIncRsrcFrom, dtIncRsrcTo, indIncRsrcNotAccess,
                                                   sdsIncRrcsSource, sdsIncRsrcVerfMethod, txtIncRsrcDesc);
  }

  private void callCompareRecChk(int idPersMergeClosed) {
    // CallCLSC53D
    List<Object[]> closedObjectList = recordsCheckDAO.findRecordsCheck(idPersMergeClosed, 0, 0);

    for (Iterator<Object[]> closedIt = closedObjectList.iterator(); closedIt.hasNext();) {
      Object[] closedObjectArray = closedIt.next();
      RecordsCheck recordsCheck = (RecordsCheck) closedObjectArray[0];
      String checkType = recordsCheck.getCdRecCheckEmpType();
      if (CodesTables.CCHKTYPE_10.equals(checkType) || CodesTables.CCHKTYPE_15.equals(checkType)
          || CodesTables.CCHKTYPE_20.equals(checkType) || CodesTables.CCHKTYPE_25.equals(checkType)
          || CodesTables.CCHKTYPE_85.equals(checkType)) {
        // caud87d
        recordsCheckDAO.saveRecordsCheck(recordsCheck);
      }
    }
  }

  private void updatePersonIdEndDate(int idPersonForward, int idPersonClosed) {
    // CallCINT17D
    boolean bMatch = false;
    Date tempDate = null;
    boolean bstoreforwardrow = false;
    PersonId personIdForward = null;
    // Check to see if any person identifiers from the person closed need to be
    // copied over to the person forward and, if so, do it.//
    // Calling cint17d
    List<PersonId> personIdClosedList = personIdDAO
                                                   .findPersonIdByIdPersonAndSysTsQueryInInvestigationStage(idPersonClosed);
    if (personIdClosedList != null && !personIdClosedList.isEmpty()) {
      // save the # of rows
      List<PersonId> personIdForwardList = personIdDAO
                                                      .findPersonIdByIdPersonAndSysTsQueryInInvestigationStage(idPersonForward);
      if (personIdForwardList == null || personIdForwardList.isEmpty() || personIdForwardList.size() == 0) {
        // change person_id to the person forward.
        for (Iterator<PersonId> it = personIdClosedList.iterator(); it.hasNext();) {
          PersonId personIdClosed = it.next();
          Person person = (Person) getPersistentObject(Person.class, idPersonForward);
          personIdClosed.setPerson(person);
        }
      } else {
        for (Iterator<PersonId> idClosed_it = personIdClosedList.iterator(); idClosed_it.hasNext();) {
          PersonId personIdClosed = idClosed_it.next();
          if (DateHelper.isNull(personIdClosed.getDtPersonIdEnd())) {
            // Second question: Does the person forward also have a valid id of this
            // type that is not end_dated? We need to loop through all of the person_forward rows
            // to see if any are of this type. If one is, break out and save what row # you were on.
            bMatch = false;
            for (Iterator<PersonId> idForward_it = personIdForwardList.iterator(); idForward_it.hasNext();) {
              personIdForward = idForward_it.next();
              if (((personIdClosed.getCdPersonIdType().equals(personIdForward.getCdPersonIdType()))
                   && (ArchitectureConstants.N.equals(personIdForward.getIndPersonIdInvalid())) && (DateHelper
                                                                                                              .isNull(personIdForward
                                                                                                                                     .getDtPersonIdEnd())))) {
                bMatch = true;
                break;
              }
            }
            if (bMatch) {
              if ((CodesTables.CNUMTYPE_SSN.equals(personIdClosed.getCdPersonIdType()))) {
                if ((SSA_VERIFIED.equals(personIdClosed.getDescPersonId()))
                    && (SSA_VERIFIED.equals(personIdForward.getDescPersonId()))) {
                  Person person = (Person) getPersistentObject(Person.class, idPersonForward);
                  personIdClosed.setPerson(person);
                  bstoreforwardrow = true;
                  personIdForward.setDtPersonIdEnd(new Date());

                } else {
                  // This means neither or both or only the person forward has SSN from
                  // the DHS interface. So just change the ID and enddate the row.
                  tempDate = new Date();
                  personIdClosed.setDtPersonIdEnd(tempDate);
                  // 
                  Person person = (Person) getPersistentObject(Person.class, idPersonForward);
                  personIdClosed.setPerson(person);
                }
              } else {
                // If there is a match in id type and the type is not SSN,
                // end_date the id.
                Person person = (Person) getPersistentObject(Person.class, idPersonForward);
                personIdClosed.setPerson(person);
                tempDate = new Date();
                personIdClosed.setDtPersonIdEnd(tempDate);
              }

            } else {
              // there is no row in the person forward table with the same id type,
              // so just change the id to the person forward
              Person person = (Person) getPersistentObject(Person.class, idPersonForward);
              personIdClosed.setPerson(person);
              personIdClosed.getPerson().setIdPerson(idPersonForward);
            }
          }
          // else the row is marked invalid so just change the id to the person forward
          else {
            Person person = (Person) getPersistentObject(Person.class, idPersonForward);
            personIdClosed.setPerson(person);
          }
        }
      }

      for (Iterator<PersonId> idClosed_it = personIdClosedList.iterator(); idClosed_it.hasNext();) {
        PersonId personIdClosed = idClosed_it.next();
        String cdPersonIdType = personIdClosed.getCdPersonIdType();
        String indPersonIDInvalid = personIdClosed.getIndPersonIdInvalid();
        String descPersonID = personIdClosed.getDescPersonId();
        Date dtPersonIDEnd = personIdClosed.getDtPersonIdEnd();
        String nbrPersonIdNumber = personIdClosed.getNbrPersonIdNumber();
        int idPersonCurrent = personIdClosed.getPerson().getIdPerson();
        int idPersonId = personIdClosed.getIdPersonId();
        Date tsSysTsLastUpdate2 = personIdClosed.getDtLastUpdate();
        String indValidateByInterface = personIdClosed.getIndValidateByInterface();
        // cint18d
        personIdDAO
                   .updatePersonIdEndDate(idPersonCurrent, idPersonId, nbrPersonIdNumber, cdPersonIdType, descPersonID,
                                          indPersonIDInvalid, dtPersonIDEnd, indValidateByInterface, tsSysTsLastUpdate2);
      }
      // If there was a break from the person forward iteration, that row is the current SSN
      // for the person forward and needs to be end_dated.
      if (bstoreforwardrow) {
        String cdPersonIdTypeForward = personIdForward.getCdPersonIdType();
        String indPersonIDInvalidForward = personIdForward.getIndPersonIdInvalid();
        String descPersonIDForward = personIdForward.getDescPersonId();
        Date dtPersonIDEndForward = personIdForward.getDtPersonIdEnd();
        String nbrPersonIdNumberForward = personIdForward.getNbrPersonIdNumber();
        int idPersonCurrentForward = personIdForward.getPerson().getIdPerson();
        int idPersonIdForward = personIdForward.getIdPersonId();
        Date tsSysTsLastUpdate2Forward = personIdForward.getDtLastUpdate();
        String indValidateByInterfaceForward = personIdForward.getIndValidateByInterface();
        // cint18d
        personIdDAO.updatePersonIdEndDate(idPersonCurrentForward, idPersonIdForward, nbrPersonIdNumberForward,
                                          cdPersonIdTypeForward, descPersonIDForward, indPersonIDInvalidForward,
                                          dtPersonIDEndForward, indValidateByInterfaceForward,
                                          tsSysTsLastUpdate2Forward);
      }
    }
  }

  /* Added for SMS#62831. Checks to see if the personClosed is a SMILE Client. If so,
   * then the SMILE data is updated with the forward person information.
   * 
   */
  private void callUpdateSmile(int idPersonForward, int idPersonClosed, int idPersMergeWrkr) {
    Person personClosed = personDAO.findPersonByIdPerson(idPersonClosed);
    String cdSmileClient = personClosed.getCdSmileClient();
    // If the closed person is a SMILE Client,  we will need to update this info with the forward person data
      
    if (StringHelper.isNotEmptyOrNull(cdSmileClient)) {
      List<ClientOutbound> listClientOutbound = clientOutboundDAO.findClientOutboundByIdClient(idPersonClosed);
      Person personForward = personDAO.findPersonByIdPerson(idPersonForward);
      Date dtPersonBirth = personForward.getDtPersonBirth();
      String cdPersonSex = personForward.getCdPersonSex();
      String cdNameSuffix = personForward.getCdPersonSuffix();
      String nmPersonFirst = personForward.getNmPersonFirst();
      String nmPersonLast = personForward.getNmPersonLast();
      String nmPersonMiddle = personForward.getNmPersonMiddle();
      String cdPerCounty = personForward.getCdPersonCounty();

      // Update each entry returned with the forward info
      for (ClientOutbound c : listClientOutbound) {
        c.setDtPersonBirth(dtPersonBirth);
        c.setCdPersonSex(cdPersonSex);
        c.setCdPersonSuffix(cdNameSuffix);
        c.setNmPersonFirst(nmPersonFirst);
        c.setNmPersonLast(nmPersonLast);
        c.setNmPersonMiddle(nmPersonMiddle);
        c.setIdClient(idPersonForward);
        c.setIdPersonClosed(idPersonClosed);
        c.setCdPerCounty(cdPerCounty);
        c.setIndNewClient("N");
        c.setInterfaceStatus(NEW);
        
        clientOutboundDAO.updateClientOutbound(c);
      }
      if(listClientOutbound.isEmpty()){
        ClientOutbound c = new ClientOutbound();
        c.setIdInitiator(idPersMergeWrkr);
        c.setCdTargetSystem("SML");
        c.setDtPersonBirth(dtPersonBirth);
        c.setCdPersonSex(cdPersonSex);
        c.setCdPersonSuffix(cdNameSuffix);
        c.setNmPersonFirst(nmPersonFirst);
        c.setNmPersonLast(nmPersonLast);
        c.setNmPersonMiddle(nmPersonMiddle);
        c.setIdClient(idPersonForward);
        c.setIdPersonClosed(idPersonClosed);
        c.setCdPerCounty(cdPerCounty);
        c.setIndNewClient("N");
        c.setInterfaceStatus(NEW);
        clientOutboundDAO.sendClientOutbound(c);
      }
    }
  }
  
  private void callUpdateSmileForSplit(int idPersonForward, int idPersonClosed, int idPersMergeWrkr) {
    Person personClosed = personDAO.findPersonByIdPerson(idPersonClosed);
    String cdSmileClient = personClosed.getCdSmileClient();
    // If the closed person is a SMILE Client,  we will need to send this info to the SMILE so that they can create a 
    //record for this closedPerson
      
    if (StringHelper.isNotEmptyOrNull(cdSmileClient)) {
      Date dtPersonBirth = personClosed.getDtPersonBirth();
      String cdPersonSex = personClosed.getCdPersonSex();
      String cdNameSuffix = personClosed.getCdPersonSuffix();
      String nmPersonFirst = personClosed.getNmPersonFirst();
      String nmPersonLast = personClosed.getNmPersonLast();
      String nmPersonMiddle = personClosed.getNmPersonMiddle();
      String cdPerCounty = personClosed.getCdPersonCounty();

      // Send data with the closed person info
        ClientOutbound c = new ClientOutbound();
        c.setIdInitiator(idPersMergeWrkr);
        c.setCdTargetSystem("SML");
        c.setDtPersonBirth(dtPersonBirth);
        c.setCdPersonSex(cdPersonSex);
        c.setCdPersonSuffix(cdNameSuffix);
        c.setNmPersonFirst(nmPersonFirst);
        c.setNmPersonLast(nmPersonLast);
        c.setNmPersonMiddle(nmPersonMiddle);
        c.setIdClient(idPersonForward);
        c.setIdPersonClosed(idPersonClosed);
        c.setCdPerCounty(cdPerCounty);
        c.setIndNewClient("Y");
        c.setInterfaceStatus(NEW);
        clientOutboundDAO.sendClientOutbound(c);      
    }
  }
}
