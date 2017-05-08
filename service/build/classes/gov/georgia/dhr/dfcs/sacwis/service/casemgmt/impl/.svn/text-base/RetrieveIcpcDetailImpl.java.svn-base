
  /**
   * This Service retrieves data for the Icpc Detail page
   *
   * @param IcpcDetailSI object
   * @return IcpcDetailRetrieveSO object  
   *  @author ashwini.rege
   */

package gov.georgia.dhr.dfcs.sacwis.service.casemgmt.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.AaFundingDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EligibilityDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.FceEligibilityDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.IcpcDetailDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.IcpcEnclosedDocCbxDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonIdDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonPhoneDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.RelationshipDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.UnitEmpLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.AaFunding;
import gov.georgia.dhr.dfcs.sacwis.db.AddressPersonLink;
import gov.georgia.dhr.dfcs.sacwis.db.Eligibility;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.IcpcDetail;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.PersonAddress;
import gov.georgia.dhr.dfcs.sacwis.db.PersonEthnicity;
import gov.georgia.dhr.dfcs.sacwis.db.PersonPhone;
import gov.georgia.dhr.dfcs.sacwis.db.PersonRace;
import gov.georgia.dhr.dfcs.sacwis.db.StagePersonLink;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.RetrieveIcpcDetail;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.IcpcDetailRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.IcpcDetailRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN45DO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * This class provides a service that retrieves the Icpc Detail data.
 *
 * 
 * Change History:
 *  Date          User              Description
 *  --------     ----------------  ----------------------------------------------------------------
 *   01/23/2012   arege            STGAP00017827: MR-085  
 *   01/27/2012   arege            STGAP00017827: MR-085 Changes
 *   02/02/2012   arege            STGAP00017827: MR-085 Added code to populate ive determination, aafunding and 
 *                                 pagemode of edit for ICPC unit members in COMP status  
 *   02/06/2012   arege            STGAP00017827: MR-085 Added comments and cleaned up the code
 *   02/09/2012   arege            STGAP00017827: MR-085 ICPC unit member should be calculated only if the event is in COMP status
 *   02/14/2012   arege            STGAP00017895: MR-085 Modified code so that the ssn for child, primary person and spouse is pulled from personId Table instead
 *                                 of the person object
 *   02/28/2012   arege            STGAP00017967: Get idStage from SPL if the cdstagepersrole is 'PC'so that the Adoption Subsidy displays correctly.
 *   02/29/2012   arege            STGAP00017956 and STGAP00017948: Icpc page should not be saved on change of primary person dropdown
 *   03/05/2012   arege            STGAP00017956: Clear all address fields if the person address is end dated and 
 *                                 Retrieve phone info from the personPhone table instead of getting it from the person object
 *   03/08/2012   arege            STGAP00017972: Used most recent non end-dated eligibility summary to find value for IVE determination
 *   03/12/2012   arege            STGAP00018020: Find latest AAFundingSummary of type IVE or PST 
 *
 */
 


public class RetrieveIcpcDetailImpl extends BaseServiceImpl implements RetrieveIcpcDetail {

  private final String ICPC_NBR_UNIT = "I1";

  private AaFundingDAO aaFundingDAO = null;

  private EventDAO eventDAO = null;

  private EligibilityDAO eligibilityDAO = null;

  private FceEligibilityDAO fceEligibilityDAO = null;

  private IcpcDetailDAO icpcDetailDAO = null;

  private IcpcEnclosedDocCbxDAO icpcEnclosedDocCbxDAO = null;
  
  private PersonIdDAO personIdDAO = null;
  
  private PersonPhoneDAO personPhoneDAO = null;

  private RelationshipDAO relationshipDAO = null;

  private StagePersonLinkDAO stagePersonLinkDAO = null;

  private UnitEmpLinkDAO unitEmpLinkDAO = null;

  public void setAaFundingDAO(AaFundingDAO aaFundingDAO) {
    this.aaFundingDAO = aaFundingDAO;
  }

  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }

  public void setEligibilityDAO(EligibilityDAO eligibilityDAO) {
    this.eligibilityDAO = eligibilityDAO;
  }

  public void setFceEligibilityDAO(FceEligibilityDAO fceEligibilityDAO) {
    this.fceEligibilityDAO = fceEligibilityDAO;
  }

  public void setIcpcDetailDAO(IcpcDetailDAO icpcDetailDAO) {
    this.icpcDetailDAO = icpcDetailDAO;
  }

  public void setIcpcEnclosedDocCbxDAO(IcpcEnclosedDocCbxDAO icpcEnclosedDocCbxDAO) {
    this.icpcEnclosedDocCbxDAO = icpcEnclosedDocCbxDAO;
  }

  public void setPersonIdDAO(PersonIdDAO personIdDAO) {
    this.personIdDAO = personIdDAO;
  }

  
  public void setPersonPhoneDAO(PersonPhoneDAO personPhoneDAO) {
    this.personPhoneDAO = personPhoneDAO;
  }

  public void setRelationshipDAO(RelationshipDAO relationshipDAO) {
    this.relationshipDAO = relationshipDAO;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public void setUnitEmpLinkDAO(UnitEmpLinkDAO unitEmpLinkDAO) {
    this.unitEmpLinkDAO = unitEmpLinkDAO;
  }

  public IcpcDetailRetrieveSO retrieveIcpcDetail(IcpcDetailRetrieveSI icpcDetailRetrieveSI) throws ServiceException {
    IcpcDetailRetrieveSO icpcDetailRetrieveSO = new IcpcDetailRetrieveSO();
    int idEvent = icpcDetailRetrieveSI.getUlIdEvent();
    int idStage = icpcDetailRetrieveSI.getUlIdStage();
    int idChild = icpcDetailRetrieveSI.getUlIdChild();
    int idLoggedInUser = icpcDetailRetrieveSI.getIdLoggedInUser();

    // Find list of all principal persons over 18 years of age that belong to the stage
    List<Map> principalsOver18List = stagePersonLinkDAO
                                                       .findPRNIdPersonAndNmPersonFullOver18FromStagePersonLinkAndPerson(idStage);
    icpcDetailRetrieveSO.setPrincipalsOver18List(principalsOver18List);

    Person child = null;
    // Retrieve for a new event i.e. when ADD button is clicked on ICPC List page
    if (idEvent == 0) {
      StagePersonLink spl = stagePersonLinkDAO.findStagePersonLinkByIdStageByCdStagePersRole(idStage, "PC");
      child = (Person) spl.getPerson();
      idChild = child.getIdPerson();
      // Retrieve Title IV-E Determination
      // Retrieve most recent initial or amended Fce application
      String cdIVEDetermination = "";
      int idEligibilityEvent = 0;
      Eligibility eligibility = null;
      Object[] idMap = null;
      // We need to find the latest Initial/Amended FCE Application and the Eligibility Summary page tied to it.
      // If one does not exist, It could be a converted Case. In that case, look for the most recent Eligibility
      // Summary in the FCC(SUB) stage and find the 'Actual' eligibility   findLatestIdEligibilityForLatestInitialAmendedApplication
      
      //STGAP00017972: Above logic needs to be changed as there could be cases where the actual eligibility was changed from IV-E to IV-B or vice a versa but
      //an Amended Application was not entered in addition to an existing application as it was not available in SHINES at that point of time. 
      //e.g case id 8501682       

        eligibility = eligibilityDAO.findEligibilityLatestApprovedByIdStageByIdPerson(idStage, idChild);
        idEligibilityEvent = eligibility != null ? eligibility.getIdEligEvent() : 0;
      if (eligibility != null) {
        cdIVEDetermination = eligibility.getCdEligActual();
      }
      icpcDetailRetrieveSO.setCdIVEDetermination(cdIVEDetermination);

      // Retrieve the  field of Adoption for 100A form
      int idADOOrPADStage = 0;
      String aAFundingDeterm = StringHelper.EMPTY_STRING;
      Collection<StagePersonLink> stagePersonLinks = child.getStagePersonLinks();
      java.util.Iterator<StagePersonLink> it = stagePersonLinks.iterator();
      while (it.hasNext()) {
        StagePersonLink splItem = it.next();
        String cdStage = splItem.getStage().getCdStage();
                   //STGAP00017967:Get idStage from SPL if the cdstagepersrole is 'PC'
        if ((CodesTables.CSTAGES_ADO.equals(cdStage) || CodesTables.CSTAGES_PAD.equals(cdStage)) 
                        && CodesTables.CROLES_PC.equals(splItem.getCdStagePersRole())) {
          idADOOrPADStage = splItem.getStage().getIdStage();
          break;
        }
      }
      
      AaFunding aaFunding = aaFundingDAO.findLatestValidatedIVEOrPSTAAFundingByIdChildByIdStage(idChild, idADOOrPADStage);
      if (aaFunding != null) {
        aAFundingDeterm = aaFunding.getCdAaFundingType();
      }
      icpcDetailRetrieveSO.setAaFundingDeterm(aAFundingDeterm);

    } else {// If the event Already exists i.e idEvent >0
      Event event = eventDAO.findEventByIdEvent(idEvent);
      if (event == null) {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }
      ROWCCMN45DO rowccmn45do = new ROWCCMN45DO();
      rowccmn45do.setSzCdEventType(event.getCdEventType());
      rowccmn45do.setDtDtEventOccurred(DateHelper.toCastorDate(event.getDtEventOccurred()));
      rowccmn45do.setUlIdEvent(event.getIdEvent() != null ? event.getIdEvent() : 0);
      rowccmn45do.setUlIdStage(event.getStage() != null ? event.getStage().getIdStage() : 0);
      rowccmn45do.setUlIdPerson(event.getPerson() != null ? event.getPerson().getIdPerson() : 0);
      rowccmn45do.setSzTxtEventDescr(event.getTxtEventDescr());
      rowccmn45do.setSzCdTask(event.getCdTask());
      rowccmn45do.setSzCdEventStatus(event.getCdEventStatus());
      rowccmn45do.setTsLastUpdate(event.getDtLastUpdate());
      icpcDetailRetrieveSO.setRowccmn45do(rowccmn45do);
      
      // Get ICPC detail from the database for the idEvent
      IcpcDetail icpcDetailRec = icpcDetailDAO.findIcpcDetailByIdEvent(idEvent);
      icpcDetailRetrieveSO.setCdFormType(icpcDetailRec.getCdIcpcFormType());
      icpcDetailRetrieveSO.setIndICWAEligible(icpcDetailRec.getIndIcwaElig());

      child = icpcDetailRec.getChild();
      idChild = child.getIdPerson();
      Person primaryPerson = (Person) icpcDetailRec.getPrimaryPerson();
      if (primaryPerson != null) {
        icpcDetailRetrieveSO.setIdPrimaryPerson(primaryPerson.getIdPerson());
        String ssnPrimaryPerson = personIdDAO.findNonEndDatePersonSSN(primaryPerson.getIdPerson());
        icpcDetailRetrieveSO.setSsnPrimaryPerson(ssnPrimaryPerson);
        PersonAddress primaryPersonAddress = getPrimaryPersonAddress(primaryPerson);
        if (primaryPersonAddress != null) {
          icpcDetailRetrieveSO.setAddrStreetLn1(primaryPersonAddress.getAddrPersAddrStLn1());
          icpcDetailRetrieveSO.setAddrStreetLn2(primaryPersonAddress.getAddrPersAddrStLn2());
          icpcDetailRetrieveSO.setAddrCity(primaryPersonAddress.getAddrPersonAddrCity());
          icpcDetailRetrieveSO.setAddrState(primaryPersonAddress.getCdPersonAddrState());
          icpcDetailRetrieveSO.setAddrZip(primaryPersonAddress.getAddrPersonAddrZip());
        }else{
        // STGAP00017956 clear all address fields if the person address is end dated
          icpcDetailRetrieveSO.setAddrStreetLn1(StringHelper.EMPTY_STRING);
          icpcDetailRetrieveSO.setAddrStreetLn2(StringHelper.EMPTY_STRING);
          icpcDetailRetrieveSO.setAddrCity(StringHelper.EMPTY_STRING);
          icpcDetailRetrieveSO.setAddrState(StringHelper.EMPTY_STRING);
          icpcDetailRetrieveSO.setAddrZip(StringHelper.EMPTY_STRING);          
        }
        //STGAP00017956: Retrieve phone info from the personPhone table instead of getting it from the person object
        String priPerPhone = StringHelper.EMPTY_STRING;
        priPerPhone = retrievePrimaryPersonPhoneData(primaryPerson.getIdPerson());
        icpcDetailRetrieveSO.setNbrPhone(priPerPhone);
        StagePersonLink spl = stagePersonLinkDAO.findStagePersonLinkByIdPersonAndIdStage(primaryPerson.getIdPerson(),
                                                                                         idStage);
        icpcDetailRetrieveSO.setCdRelPrimaryPerson(spl.getCdStagePersRelInt());
        icpcDetailRetrieveSO.setCdSideOfFam(spl.getCdPersonSideOfFamily());
      }

      Person spouse = (Person) icpcDetailRec.getSpouse();
      if (spouse != null) {
        icpcDetailRetrieveSO.setIdSpouse(spouse.getIdPerson());
        String ssnSpouse = personIdDAO.findNonEndDatePersonSSN(spouse.getIdPerson());
        icpcDetailRetrieveSO.setSsnSpouse(ssnSpouse);
      }

      icpcDetailRetrieveSO.setCdInitReportReq(icpcDetailRec.getCdInitReportReq());
      icpcDetailRetrieveSO.setAaFundingDeterm(icpcDetailRec.getAaFundingDeterm());
      icpcDetailRetrieveSO.setCdIVEDetermination(icpcDetailRec.getIveDeterm());

      List<String> savedReqCbx = new ArrayList<String>();
      savedReqCbx = icpcEnclosedDocCbxDAO.findSavedCbxByIdIcpcDetailAndCdCbxCodeType(CodesTables.CDREQCBX,
                                                                                     icpcDetailRec.getIdIcpcDetail());
      icpcDetailRetrieveSO.setSavedReqCbx(savedReqCbx);

      List<String> savedAplCbx = new ArrayList<String>();
      savedAplCbx = icpcEnclosedDocCbxDAO.findSavedCbxByIdIcpcDetailAndCdCbxCodeType(CodesTables.CDAPLCBX,
                                                                                     icpcDetailRec.getIdIcpcDetail());
      icpcDetailRetrieveSO.setSavedAplCbx(savedAplCbx);

      icpcDetailRetrieveSO.setIndPlcmtStatus(icpcDetailRec.getIndPlcmtStatus());
      icpcDetailRetrieveSO.setDtChildPlaced(icpcDetailRec.getDtChildPlaced());
      icpcDetailRetrieveSO.setCdTypeCare(icpcDetailRec.getCdTypeCare());
      icpcDetailRetrieveSO.setCdPlcmtTermRsn(icpcDetailRec.getCdPlcmtTermRsn());
      icpcDetailRetrieveSO.setTxtOtherSpecify(icpcDetailRec.getTxtOtherSpecify());
      icpcDetailRetrieveSO.setIndFinalizedIn(icpcDetailRec.getIndFinalizedIn());
      icpcDetailRetrieveSO.setIndCrtOrderAf(icpcDetailRec.getIndCrtOrderAf());
      icpcDetailRetrieveSO.setIndCrtOrderLcgr(icpcDetailRec.getIndCrtOrderLcgr());
      icpcDetailRetrieveSO.setIndCrtOrderLcrp(icpcDetailRec.getIndCrtOrderLcrp());
      icpcDetailRetrieveSO.setDtTermination(icpcDetailRec.getDtTermination());
      icpcDetailRetrieveSO.setIdCaseWorker(icpcDetailRec.getEmployee().getIdPerson());
      icpcDetailRetrieveSO.setNmCaseManager(icpcDetailRec.getEmployee().getPerson().getNmPersonFull());
      icpcDetailRetrieveSO.setDtComplete(icpcDetailRec.getDtCompleted());
      icpcDetailRetrieveSO.setCdIVEDetermination(icpcDetailRec.getIveDeterm());
      
      //If event status is not COMP calculate iveDeterm and adoption values , if the status is COMP display the value stored in the database.
      if(!CodesTables.CEVTSTAT_COMP.equals(event.getCdEventStatus())){
        // Retrieve Title IV-E Determination
        // Retrieve most recent initial or amended Fce application
        String cdIVEDetermination = "";
        int idEligibilityEvent = 0;
        Eligibility eligibility = null;
        Object[] idMap = null;
        // We need to find the latest Initial/Amended FCE Application and the Eligibility Summary page tied to it.
        // If one does not exist, It could be a converted Case. In that case, look for the most recent Eligibility
        // Summary in the FCC(SUB) stage and find the 'Actual' eligibility
        //STGAP00017972: Above logic needs to be changed as there could be cases where the actual eligibility was changed from IV-E to IV-B or vice a versa but
        //an Amended Application was not entered in addition to an existing application as it was not available in SHINES at that point of time. 
        //e.g case id 8501682 
        //As per current requirement,  find the most recent approved non-enddated eligibility summary for that child and stage. 
      
         eligibility = eligibilityDAO.findEligibilityLatestApprovedByIdStageByIdPerson(idStage, idChild);
         idEligibilityEvent = eligibility != null ? eligibility.getIdEligEvent() : 0;   

        if (eligibility != null) {
          cdIVEDetermination = eligibility.getCdEligActual();
        }
        icpcDetailRetrieveSO.setCdIVEDetermination(cdIVEDetermination);

        // Retrieve the  field of Adoption for 100A form
        int idADOOrPADStage = 0;
        String aAFundingDeterm = StringHelper.EMPTY_STRING;
        Collection<StagePersonLink> stagePersonLinks = child.getStagePersonLinks();
        java.util.Iterator<StagePersonLink> it = stagePersonLinks.iterator();
        while (it.hasNext()) {
          StagePersonLink splItem = it.next();
          String cdStage = splItem.getStage().getCdStage();
           //STGAP00017967:Get idStage from SPL if the cdstagepersrole is 'PC'
          if ((CodesTables.CSTAGES_ADO.equals(cdStage) || CodesTables.CSTAGES_PAD.equals(cdStage))
            && CodesTables.CROLES_PC.equals(splItem.getCdStagePersRole())) {
            idADOOrPADStage = splItem.getStage().getIdStage();
            break;
          }
        }
        
        AaFunding aaFunding = aaFundingDAO.findLatestValidatedIVEOrPSTAAFundingByIdChildByIdStage(idChild, idADOOrPADStage);
        if (aaFunding != null) {
          aAFundingDeterm = aaFunding.getCdAaFundingType();
        }
        icpcDetailRetrieveSO.setAaFundingDeterm(aAFundingDeterm); 
      }
      
      
      
      // Find all employee ids for the ICPC Unit nbr I1 , county = none and region = 99
      // indIcpcUnitMember should be calculated only if the event is in COMP status
      if(CodesTables.CEVTSTAT_COMP.equals(event.getCdEventStatus())){

      String indIcpcUnitMember = ArchitectureConstants.FALSE;
      List<Integer> membersInUnit = unitEmpLinkDAO
                                                  .findUnitMembersInAndOutByNbrUnitAndCdRegionAndCdCounty(
                                                                                                          ICPC_NBR_UNIT,
                                                                                                          CodesTables.CREGDIV_099,
                                                                                                          CodesTables.CCOUNT_XXX);
      if (membersInUnit != null && !membersInUnit.isEmpty()) {
        if (membersInUnit.contains(idLoggedInUser)) {
          indIcpcUnitMember = ArchitectureConstants.TRUE;
        }
      }
      icpcDetailRetrieveSO.setIndIcpcUnitMember(indIcpcUnitMember);
    }
    }
    
    // Retrieve all the display only fields that are dependent on the child
    // idChild, Firstname, Middle, Last, DOB, Gender, SSN, race, ethnicity, name of the father , name of mother.
    idChild = child.getIdPerson();
    String nmFirst = child.getNmPersonFirst();
    String nmLast = child.getNmPersonLast();
    String nmMiddle = child.getNmPersonMiddle();
    Date DOB = child.getDtPersonBirth();
    String cdGender = child.getCdPersonSex();
    
    //Find the latest SSN from personid table instead of getting it from the person object
    String ssn = personIdDAO.findNonEndDatePersonSSN(idChild);


    icpcDetailRetrieveSO.setIdChild(idChild);
    icpcDetailRetrieveSO.setNmFirst(nmFirst);
    icpcDetailRetrieveSO.setNmMiddle(nmMiddle);
    icpcDetailRetrieveSO.setNmLast(nmLast);
    icpcDetailRetrieveSO.setDtPersonBirth(DOB);
    icpcDetailRetrieveSO.setCdGender(cdGender);    
    icpcDetailRetrieveSO.setSsn(ssn);

    Collection<PersonRace> personRaces = child.getPersonRaces();
    String cdRace = "";
    List<String> raceList = new ArrayList<String>();
    if (personRaces != null && !personRaces.isEmpty()) {
      for (Iterator<PersonRace> it = personRaces.iterator(); it.hasNext();) {
        PersonRace personRaceInfo = it.next();
        String race = Lookup.simpleDecodeSafe(CodesTables.CRACE, personRaceInfo.getCdRace());
        raceList.add(race);
      }
    }
    int i = 0;
    if (!raceList.isEmpty()) {
      if (raceList.size() > 1) { // Concatenate all races checked on the Person Detail page
        for (i = 0; i < raceList.size(); i++) {
          if (i == 0) {
            cdRace = (String) raceList.get(i);
          } else
            cdRace = cdRace + ", " + raceList.get(i);
        }
      } else { // If there is only one race checkbox checked on the Person Detail page
        cdRace = (String) raceList.get(i);
      }
    }
    icpcDetailRetrieveSO.setCdRace(cdRace);

    String cdEthnicity = "";
    Collection<PersonEthnicity> personEthnicities = child.getPersonEthnicities();
    if (personEthnicities != null && !personEthnicities.isEmpty()) {
      Iterator<PersonEthnicity> it = personEthnicities.iterator();
      PersonEthnicity personEthnicityInfo = it.next();
      cdEthnicity = Lookup.simpleDecodeSafe(CodesTables.CINDETHN, personEthnicityInfo.getCdEthnicity());
    }
    icpcDetailRetrieveSO.setCdEthnicity(cdEthnicity);

    // Retrieve Mother and Father's full name
    String nmMotherFull = "";
    String nmFatherFull = "";
    // First find Legal Mother, if legal mother does not exist find Biological mother else display blank
    // First find Legal Father, if legal father does not exist find Biological father else find Putative father, if none
    // of these 3 exist display blank
    Integer idMother = relationshipDAO.findRelationshipIdRelatedPersonByIdPerson(idChild, CodesTables.CRELVICT_LM);
    if (idMother == null) {
      idMother = relationshipDAO.findRelationshipIdRelatedPersonByIdPerson(idChild, CodesTables.CRELVICT_BM);
    }
    if (idMother != null && idMother > 0) {
      Person mother = (Person) getPersistentObject(Person.class, idMother);
      nmMotherFull = mother.getNmPersonFull();
    }

    Integer idFather = relationshipDAO.findRelationshipIdRelatedPersonByIdPerson(idChild, CodesTables.CRELVICT_LF);
    if (idFather == null) {
      idFather = relationshipDAO.findRelationshipIdRelatedPersonByIdPerson(idChild, CodesTables.CRELVICT_BF);
    }
    if (idFather == null) {
      idFather = relationshipDAO.findRelationshipIdRelatedPersonByIdPerson(idChild, CodesTables.CRELVICT_PF);
    }

    if (idFather != null && idFather > 0) {
      Person father = (Person) getPersistentObject(Person.class, idFather);
      nmFatherFull = father.getNmPersonFull();
    }
    icpcDetailRetrieveSO.setNmMotherFull(nmMotherFull);
    icpcDetailRetrieveSO.setNmFatherFull(nmFatherFull);
    
    //STGAP00017956 and STGAP00017948:
    //Retrieve person address and phone and side of family fields and redisplay the page
      int idPrimaryPerson =  icpcDetailRetrieveSI.getIdPrimaryPerson();
      if (idPrimaryPerson > 0) {
        Person primaryPerson = (Person) getPersistentObject(Person.class, idPrimaryPerson);
        icpcDetailRetrieveSO.setIdPrimaryPerson(idPrimaryPerson);
        String ssnPrimaryPerson = personIdDAO.findNonEndDatePersonSSN(idPrimaryPerson);
        icpcDetailRetrieveSO.setSsnPrimaryPerson(ssnPrimaryPerson);
        PersonAddress primaryPersonAddress = getPrimaryPersonAddress(primaryPerson);
        if (primaryPersonAddress != null) {
          icpcDetailRetrieveSO.setAddrStreetLn1(primaryPersonAddress.getAddrPersAddrStLn1());
          icpcDetailRetrieveSO.setAddrStreetLn2(primaryPersonAddress.getAddrPersAddrStLn2());
          icpcDetailRetrieveSO.setAddrCity(primaryPersonAddress.getAddrPersonAddrCity());
          icpcDetailRetrieveSO.setAddrState(primaryPersonAddress.getCdPersonAddrState());
          icpcDetailRetrieveSO.setAddrZip(primaryPersonAddress.getAddrPersonAddrZip());
        }else{
         // STGAP00017956 clear all address fields if the person address is end dated
          icpcDetailRetrieveSO.setAddrStreetLn1(StringHelper.EMPTY_STRING);
          icpcDetailRetrieveSO.setAddrStreetLn2(StringHelper.EMPTY_STRING);
          icpcDetailRetrieveSO.setAddrCity(StringHelper.EMPTY_STRING);
          icpcDetailRetrieveSO.setAddrState(StringHelper.EMPTY_STRING);
          icpcDetailRetrieveSO.setAddrZip(StringHelper.EMPTY_STRING);          
        }
        //STGAP00017956: Retrieve phone info from the personPhone table instead of getting it from the person object
        String priPerPhone = StringHelper.EMPTY_STRING;
        priPerPhone = retrievePrimaryPersonPhoneData(primaryPerson.getIdPerson());
        icpcDetailRetrieveSO.setNbrPhone(priPerPhone);
        StagePersonLink spl = stagePersonLinkDAO.findStagePersonLinkByIdPersonAndIdStage(primaryPerson.getIdPerson(),
                                                                                         idStage);
        icpcDetailRetrieveSO.setCdRelPrimaryPerson(spl.getCdStagePersRelInt());
        icpcDetailRetrieveSO.setCdSideOfFam(spl.getCdPersonSideOfFamily());
      }      
      int idSpouse =  icpcDetailRetrieveSI.getIdSpouse();
      if (idSpouse > 0) {
        icpcDetailRetrieveSO.setIdSpouse(idSpouse);
        String ssnSpouse = personIdDAO.findNonEndDatePersonSSN(idSpouse);
        icpcDetailRetrieveSO.setSsnSpouse(ssnSpouse);
      }
    

    return icpcDetailRetrieveSO;
  }

  private PersonAddress getPrimaryPersonAddress(Person person) {
    PersonAddress personAddress = null;
    if (person != null) {
      Collection<AddressPersonLink> personAddresses = person.getAddressPersonLinks();
      if (personAddresses != null && !personAddresses.isEmpty()) {
        for (Iterator<AddressPersonLink> it = personAddresses.iterator(); it.hasNext();) {
          AddressPersonLink addressPersonLink = it.next();
          if (addressPersonLink.getIndPersAddrLinkPrimary().equals("Y")
              && DateHelper.isNull(addressPersonLink.getDtPersAddrLinkEnd())) {
            personAddress = addressPersonLink.getPersonAddress();
            break;
          }
        } // end for loop
      } // end personAddress
    } // end person
    return personAddress;
  }
  
  private String retrievePrimaryPersonPhoneData(int idPerson) {
    String phoneNbr = null;
    Date maxDate = DateHelper.toJavaDate(DateHelper.MAX_CASTOR_DATE);
    PersonPhone personPhone = null;
    if (idPerson != 0) {
      personPhone = personPhoneDAO.findPersonPhoneByIdPersonAndMaxDate(idPerson, maxDate);
    }

    if (personPhone != null) {
      if (personPhone.getNbrPersonPhoneExtension() != null) {
        // Display extension after the phone number if it exists
        phoneNbr = FormattingHelper.formatPhone(personPhone.getNbrPersonPhone()) + " Ext. "
                   + personPhone.getNbrPersonPhoneExtension();
      } else {
        phoneNbr = FormattingHelper.formatPhone(personPhone.getNbrPersonPhone());
      }
    }
    return phoneNbr;
  }
}
