package gov.georgia.dhr.dfcs.sacwis.service.adoexchange.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.LookupException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsResourceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CharacteristicsDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.NonIncidentAFCARSInfoDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDtlDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonPhoneDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PlacementDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SpecialNeedsDeterminationDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.NonIncidentAfcarsInfo;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.PersonDtl;
import gov.georgia.dhr.dfcs.sacwis.db.PersonPhone;
import gov.georgia.dhr.dfcs.sacwis.db.Placement;
import gov.georgia.dhr.dfcs.sacwis.db.SpecialNeedsDetermination;
import gov.georgia.dhr.dfcs.sacwis.db.StagePersonLink;
import gov.georgia.dhr.dfcs.sacwis.service.adoexchange.RetrieveNonIncidentAFCARSInformation;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.intake.RetrieveRaceAndEthnicity;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN95SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.NonIncidentAFCARSInformationSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN95SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.NonIncidentAFCARSInformationSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN95SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN95SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN95SOG01;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN95SOG01_ARRAY;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * The RetrieveNonIncidentAFCARSInformationImpl class is the service for retrieving data for the 
 * Non-Incident AFCARS Information page.
 * 
 * @see gov.georgia.dhr.dfcs.sacwis.service.adoexchange.RetrieveNonIncidentAFCARSInformation
 * 
 * @author Stephen Roberts, October 1, 2008
 * 
 * <PRE>
 * 
 * Date        Updated by                Description
 * ---------   ------------              -------------------------------------
 * 02/04/09    wjcochran                 STGAP00012148: Added Mother Married at Birth information
 * 05/30/09    mchillman                 STGAP00012616: Changed code so that it pulls special need info from adoption application a
 * 02/03/10    hjbaptiste  		         SMS#44783: MR-60 Changes, Primary Special Needs drop down, new types added. Map with new
 *                                       Special Need Types added the Adoption Assistance Application Page. populateChildCharacteristics()
 *                                       modified
 * 02/17/2010  bgehlot                   SMS#45716 Corrected the mapping from Adoption Application Special Needs Type to Primary Special
 *                                       Needs
 * 
 * </PRE>
 */

public class RetrieveNonIncidentAFCARSInformationImpl extends BaseServiceImpl implements
                                                                             RetrieveNonIncidentAFCARSInformation {

  private final static String MALE = "M";

  private final static String FEMALE = "F";

  // Constants for 'Child Placed From'
  private final static String PUBLIC_AGENCY = "Public Agency";

  private final static String PRIVATE_AGENCY = "Private Agency";

  private final static String TRIBAL_AGENCY = "Tribal Agency";

  private final static String INDEPENDENT_PERSON = "Independent Person";

  private final static String BIRTH_PARENT = "Birth Parent";

  // Constants for 'Child Placed By'
  private final static String WITHIN_STATE = "Within State";

  private final static String OUT_OF_STATE = "Out Of State";

  private final static String ANOTHER_COUNTRY = "Another Country";

  private final static String ONE = "1";

  private final static String TWO = "2";

  private final static String THREE = "3";

  private final static String FOUR = "4";

  private final static String FIVE = "5";

  private NonIncidentAFCARSInfoDAO nonIncidentAFCARSInfoDAO;

  private PersonPhoneDAO personPhoneDAO;
  
  private PlacementDAO placementDAO;

  private CapsResourceDAO capsResourceDAO;

  private StagePersonLinkDAO stagePersonLinkDAO;

  private CharacteristicsDAO characteristicsDAO;

  private RetrieveRaceAndEthnicity retrieveRaceAndEthnicity;

  private PersonDtlDAO personDtlDAO;
  
  private SpecialNeedsDeterminationDAO specialNeedsDeterminationDAO;
  
  public void setNonIncidentAFCARSInfoDAO(NonIncidentAFCARSInfoDAO nonIncidentAFCARSInfoDAO) {
    this.nonIncidentAFCARSInfoDAO = nonIncidentAFCARSInfoDAO;
  }

  public void setPersonPhoneDAO(PersonPhoneDAO personPhoneDAO) {
    this.personPhoneDAO = personPhoneDAO;
  }

  public void setPlacementDAO(PlacementDAO placementDAO) {
    this.placementDAO = placementDAO;
  }

  public void setCapsResourceDAO(CapsResourceDAO capsResourceDAO) {
    this.capsResourceDAO = capsResourceDAO;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public void setCharacteristicsDAO(CharacteristicsDAO characteristicsDAO) {
    this.characteristicsDAO = characteristicsDAO;
  }

  public void setRetrieveRaceAndEthnicity(RetrieveRaceAndEthnicity retrieveRaceAndEthnicity) {
    this.retrieveRaceAndEthnicity = retrieveRaceAndEthnicity;
  }

  public void setPersonDtlDAO(PersonDtlDAO personDtlDAO) {
    this.personDtlDAO = personDtlDAO;
  }

  public NonIncidentAFCARSInformationSO retrieveNonIncidentAFCARSInformation(
                                                                             NonIncidentAFCARSInformationSI nonIncidentAFCARSInformationSI) {

    NonIncidentAFCARSInformationSO nonIncidentAFCARSInformationSO = new NonIncidentAFCARSInformationSO();
    NonIncidentAfcarsInfo nonIncidentAfcarsInfo = nonIncidentAFCARSInfoDAO
                                                                          .findNonIncidentAFCARSInfoByPersonID(nonIncidentAFCARSInformationSI
                                                                                                                                             .getIdPerson());
    if (nonIncidentAfcarsInfo != null) {
      populateBirthParentAndChildInformation(nonIncidentAFCARSInformationSI, nonIncidentAFCARSInformationSO,
                                             nonIncidentAfcarsInfo);
    } 
    //Populate the adoption characteristics based on Person Detail characteristics and Adoption Assistance application
    populateChildCharacteristics(nonIncidentAFCARSInformationSI, nonIncidentAFCARSInformationSO);
    populateMotherMarriedAtBirth(nonIncidentAFCARSInformationSI, nonIncidentAFCARSInformationSO);
    populateCaseWorkerInformation(nonIncidentAFCARSInformationSI, nonIncidentAFCARSInformationSO);
    populatePlacementInformation(nonIncidentAFCARSInformationSI, nonIncidentAFCARSInformationSO);
    populateAdoptiveParentsInformation(nonIncidentAFCARSInformationSI, nonIncidentAFCARSInformationSO);

    // @TODO Deal with ethnicity for mother and father
    return nonIncidentAFCARSInformationSO;
  }

  /**
   * Populates the Birth Parent and Child Information into the output object.
   * 
   * @param nonIncidentAFCARSInformationSI
   * @param nonIncidentAFCARSInformationSO
   * @param nonIncidentAfcarsInfo
   * @return void
   */
  private void populateBirthParentAndChildInformation(NonIncidentAFCARSInformationSI nonIncidentAFCARSInformationSI,
                                                      NonIncidentAFCARSInformationSO nonIncidentAFCARSInformationSO,
                                                      NonIncidentAfcarsInfo nonIncidentAfcarsInfo) {

    //Special Needs Characteristics
    SpecialNeedsDetermination spNeedsDeter = specialNeedsDeterminationDAO.findSpclDeterminationByIdStageByIdPerson(nonIncidentAFCARSInformationSI.getIdStage(), 
                                                                                                                   nonIncidentAFCARSInformationSI.getIdPerson(), 
                                                                                                                   nonIncidentAFCARSInformationSI.getIdCase());
                                                  
    if(spNeedsDeter != null) {
      if ("Y".equals(spNeedsDeter.getIndApprvEmotionalDist())) {
        nonIncidentAFCARSInformationSO.setIndEmtDisturbed(ArchitectureConstants.Y);
      }
      if ("Y".equals(spNeedsDeter.getIndApprvOther())) {
        nonIncidentAFCARSInformationSO.setIndOthMedDiag(ArchitectureConstants.Y);
      }
      if ("Y".equals(spNeedsDeter.getIndApprvMntRetarded())) {
        nonIncidentAFCARSInformationSO.setIndMentRetard(ArchitectureConstants.Y);
      }
      if ("Y".equals(spNeedsDeter.getIndApprvHearingImpaired())) {
        nonIncidentAFCARSInformationSO.setIndVisHearImp(ArchitectureConstants.Y);
      }
      if ("Y".equals(spNeedsDeter.getIndApprvPhysicallyDisabled())) {
        nonIncidentAFCARSInformationSO.setIndPhyDisabled(ArchitectureConstants.Y);
      }
      
      String indSpNdsAppr = spNeedsDeter.getIndAprType();
      String primarySPN = null;
      
      if("R".equals(indSpNdsAppr)){
        primarySPN = CodesTables.CPRSPCLN_02;
      } else if("A".equals(indSpNdsAppr)) {
        primarySPN = CodesTables.CPRSPCLN_03;
      } else if("S".equals(indSpNdsAppr)) {
        primarySPN = CodesTables.CPRSPCLN_04;
      } else if("T".equals(indSpNdsAppr)) {
        primarySPN = CodesTables.CPRSPCLN_05;
      } else if("M".equals(indSpNdsAppr)) {
        primarySPN = CodesTables.CPRSPCLN_06;
      } else if("N".equals(indSpNdsAppr)) {
        primarySPN = CodesTables.CPRSPCLN_01;
      } 
      nonIncidentAFCARSInformationSO.setCdPrimSpecNeed(primarySPN);
          
      nonIncidentAFCARSInformationSO.setDtApplicationSent(spNeedsDeter.getEvent().getDtLastUpdate());
    }

    nonIncidentAFCARSInformationSO.setCdSevMentRetard(nonIncidentAfcarsInfo.getCdSevMentalRetardation());
    nonIncidentAFCARSInformationSO.setCdSevVisHearImp(nonIncidentAfcarsInfo.getCdSevVisualHearingImp());
    nonIncidentAFCARSInformationSO.setCdSevPhyDisabled(nonIncidentAfcarsInfo.getCdSevPhysicallyDisabled());
    nonIncidentAFCARSInformationSO.setCdSevEmtDisturbed(nonIncidentAfcarsInfo.getCdSevEmotionallyDist());
    nonIncidentAFCARSInformationSO.setCdSevOthMedDiag(nonIncidentAfcarsInfo.getCdSevOtherMed());
    
    nonIncidentAFCARSInformationSO.setCdPrimSpecNeed(nonIncidentAfcarsInfo.getCdPrimaryNeed());

    // Child Name
    nonIncidentAFCARSInformationSO.setNmBirthNameFirst(nonIncidentAfcarsInfo.getNmBnFirst());
    nonIncidentAFCARSInformationSO.setNmBirthNameMiddle(nonIncidentAfcarsInfo.getNmBnMiddle());
    nonIncidentAFCARSInformationSO.setNmBirthNameLast(nonIncidentAfcarsInfo.getNmBnLast());

    // Birth Mother
    nonIncidentAFCARSInformationSO.setDtBirthMotherDOB(nonIncidentAfcarsInfo.getDtBmDob());
    nonIncidentAFCARSInformationSO.setCdBirthMotherTermType(nonIncidentAfcarsInfo.getCdBmTerminationType());
    nonIncidentAFCARSInformationSO.setDtBirthMotherRightsTerm(nonIncidentAfcarsInfo.getDtBmRightTerminated());

    nonIncidentAFCARSInformationSO.setIndBMRaceAA(nonIncidentAfcarsInfo.getIndBmRaceAa());
    nonIncidentAFCARSInformationSO.setIndBMRaceAN(nonIncidentAfcarsInfo.getIndBmRaceAn());
    nonIncidentAFCARSInformationSO.setIndBMRaceBK(nonIncidentAfcarsInfo.getIndBmRaceBk());
    nonIncidentAFCARSInformationSO.setIndBMRaceHP(nonIncidentAfcarsInfo.getIndBmRaceHp());
    nonIncidentAFCARSInformationSO.setIndBMRaceUD(nonIncidentAfcarsInfo.getIndBmRaceUd());
    nonIncidentAFCARSInformationSO.setIndBMRaceWT(nonIncidentAfcarsInfo.getIndBmRaceWt());

    nonIncidentAFCARSInformationSO.setCdBMEthnicity(nonIncidentAfcarsInfo.getCdBmEthnicity());

    // Birth Father
    nonIncidentAFCARSInformationSO.setDtBirthFatherDOB(nonIncidentAfcarsInfo.getDtBfDob());
    nonIncidentAFCARSInformationSO.setCdBirthFatherTermType(nonIncidentAfcarsInfo.getCdBfTerminationType());
    nonIncidentAFCARSInformationSO.setDtBirthFatherRightsTerm(nonIncidentAfcarsInfo.getDtBfRightTerminated());

    nonIncidentAFCARSInformationSO.setIndBFRaceAA(nonIncidentAfcarsInfo.getIndBfRaceAa());
    nonIncidentAFCARSInformationSO.setIndBFRaceAN(nonIncidentAfcarsInfo.getIndBfRaceAn());
    nonIncidentAFCARSInformationSO.setIndBFRaceBK(nonIncidentAfcarsInfo.getIndBfRaceBk());
    nonIncidentAFCARSInformationSO.setIndBFRaceHP(nonIncidentAfcarsInfo.getIndBfRaceHp());
    nonIncidentAFCARSInformationSO.setIndBFRaceUD(nonIncidentAfcarsInfo.getIndBfRaceUd());
    nonIncidentAFCARSInformationSO.setIndBFRaceWT(nonIncidentAfcarsInfo.getIndBfRaceWt());

    nonIncidentAFCARSInformationSO.setCdBFEthnicity(nonIncidentAfcarsInfo.getCdBfEthnicity());

    // Setup the birth mother race list in an array. This makes it easier for the custom tags
    // with the JSP to consume the values.

    ArrayList<String> bmRaceList = new ArrayList<String>();

    if (ArchitectureConstants.Y.equals(nonIncidentAfcarsInfo.getIndBmRaceAa()))
      bmRaceList.add(CodesTables.CRACE_AA);

    if (ArchitectureConstants.Y.equals(nonIncidentAfcarsInfo.getIndBmRaceAn()))
      bmRaceList.add(CodesTables.CRACE_AN);

    if (ArchitectureConstants.Y.equals(nonIncidentAfcarsInfo.getIndBmRaceBk()))
      bmRaceList.add(CodesTables.CRACE_BK);

    if (ArchitectureConstants.Y.equals(nonIncidentAfcarsInfo.getIndBmRaceHp()))
      bmRaceList.add(CodesTables.CRACE_HP);

    if (ArchitectureConstants.Y.equals(nonIncidentAfcarsInfo.getIndBmRaceUd()))
      bmRaceList.add(CodesTables.CRACE_UD);

    if (ArchitectureConstants.Y.equals(nonIncidentAfcarsInfo.getIndBmRaceWt()))
      bmRaceList.add(CodesTables.CRACE_WT);

    nonIncidentAFCARSInformationSO.setBMRaceList(bmRaceList);

    // Setup the birth father race list in an array. This makes it easier for the custom tags
    // with the JSP to consume the values.
    ArrayList<String> bfRaceList = new ArrayList<String>();

    if (ArchitectureConstants.Y.equals(nonIncidentAfcarsInfo.getIndBfRaceAa()))
      bfRaceList.add(CodesTables.CRACE_AA);

    if (ArchitectureConstants.Y.equals(nonIncidentAfcarsInfo.getIndBfRaceAn()))
      bfRaceList.add(CodesTables.CRACE_AN);

    if (ArchitectureConstants.Y.equals(nonIncidentAfcarsInfo.getIndBfRaceBk()))
      bfRaceList.add(CodesTables.CRACE_BK);

    if (ArchitectureConstants.Y.equals(nonIncidentAfcarsInfo.getIndBfRaceHp()))
      bfRaceList.add(CodesTables.CRACE_HP);

    if (ArchitectureConstants.Y.equals(nonIncidentAfcarsInfo.getIndBfRaceUd()))
      bfRaceList.add(CodesTables.CRACE_UD);

    if (ArchitectureConstants.Y.equals(nonIncidentAfcarsInfo.getIndBfRaceWt()))
      bfRaceList.add(CodesTables.CRACE_WT);

    nonIncidentAFCARSInformationSO.setBFRaceList(bfRaceList);

    nonIncidentAFCARSInformationSO.setDtLastUpdate(nonIncidentAfcarsInfo.getDtLastUpdate());
  }

  /**
   * Populates the Case Worker Information into the output object. Makes a call to the database to find the primary
   * worker assigned to the stage.
   * 
   * @param nonIncidentAFCARSInformationSI
   * @param nonIncidentAFCARSInformationSO
   * @return void
   */
  private void populateCaseWorkerInformation(NonIncidentAFCARSInformationSI nonIncidentAFCARSInformationSI,
                                             NonIncidentAFCARSInformationSO nonIncidentAFCARSInformationSO) {

    StagePersonLink stgPersLink = stagePersonLinkDAO
                                                    .findStagePersonLinkByIdStageCdStagePersRoleAll(nonIncidentAFCARSInformationSI
                                                                                                                                  .getIdStage());
    if (stgPersLink != null) {
      Person caseWorker = stgPersLink.getPerson();
      if (caseWorker != null) {
        String nmCaseWorker = caseWorker.getNmPersonFull();
        String nbrCsWorkerPhone = getPersonOfficePhone(caseWorker.getIdPerson());
        
        if (nmCaseWorker != null) {
          nonIncidentAFCARSInformationSO.setNmEmployee(nmCaseWorker);
        }
        if (nbrCsWorkerPhone != null) {
          nonIncidentAFCARSInformationSO.setEmployeePhone(nbrCsWorkerPhone);
        }
      }
    }

  }
  
  /**
   * Sets up the valid phone types for the case manager display
   * 
   * @param idPerson - PersonID
   * @return Business number for the person
   */  
  private String getPersonOfficePhone(int idPerson) {
    List<String> phoneTypes = new ArrayList<String>();
    phoneTypes.add(CodesTables.CPHNTYP_BC); // Business Cell
    phoneTypes.add(CodesTables.CPHNTYP_BP); // Business Pager
    phoneTypes.add(CodesTables.CPHNTYP_BS); // Business

    return getPersonOfficePhoneNbr(idPerson, phoneTypes);
  }

  
  /**
   * Makes call to the database to get the case manager's business phone.
   * 
   * @param idPerson - PersonID
   * @param phoneTypes - List of valid phone types
   * @return Business number for the person
   */    
  private String getPersonOfficePhoneNbr(int idPerson, List<String> phoneTypes) {
    StringBuffer primPersonPhone = new StringBuffer();
    String indPersonPhoneInValid = "N";

    Date maxDate = DateHelper.toJavaDate(DateHelper.MAX_CASTOR_DATE);
    List<PersonPhone> personPhones = personPhoneDAO
                                                   .findPersonPhoneByIdPersonDtPersonPhoneCdPersonPhoneTypes(
                                                                                                             idPerson,
                                                                                                             maxDate,
                                                                                                             indPersonPhoneInValid,
                                                                                                             phoneTypes);

    for (Iterator<PersonPhone> it = personPhones.iterator(); it.hasNext();) {
      PersonPhone personPhone = it.next();
      if (personPhone != null) {
        if (personPhone.getNbrPersonPhone() != null) {
          primPersonPhone.append(FormattingHelper.formatPhone(personPhone.getNbrPersonPhone()));
          if (personPhone.getNbrPersonPhoneExtension() != null) {
            primPersonPhone.append("   Ext " + personPhone.getNbrPersonPhoneExtension());
          }
          break;
        }
      } // end if personPhone
    } // end for loop
    
    return primPersonPhone.toString();

  }
  
  
  
  
  
  
  /**
   * Populates the Placement Information into the output object. Makes a call to the database to find the most recent
   * approved placement.
   * 
   * @param nonIncidentAFCARSInformationSI
   * @param nonIncidentAFCARSInformationSO
   * @return void
   */
  private void populatePlacementInformation(NonIncidentAFCARSInformationSI nonIncidentAFCARSInformationSI,
                                            NonIncidentAFCARSInformationSO nonIncidentAFCARSInformationSO) {

    Placement placement = placementDAO
                                      .findPlacementLatestApprovedByIdPerson(
                                                                             nonIncidentAFCARSInformationSI
                                                                                                           .getIdPerson(),
                                                                             DateHelper.MAX_JAVA_DATE);

    if (placement != null) {
      nonIncidentAFCARSInformationSO.setCdPlacmentCounty(placement.getAddrPlcmtCnty());
      nonIncidentAFCARSInformationSO.setIndAPNonRelative(placement.getCdPlcmtInfo9());
      nonIncidentAFCARSInformationSO.setIndAPPriorFP(placement.getCdPlcmtInfo10());
      nonIncidentAFCARSInformationSO.setIndAPStepParent(placement.getCdPlcmtInfo12());
      nonIncidentAFCARSInformationSO.setIndAPOtherRelative(placement.getCdPlcmtInfo11());

      // This mapping in code was necessary b/c a codes table was never appropriately setup
      // for this data element. Similar code exists in PlcmtInformation.jsp.
      // @TODO Move mapping into codes table after data conversion
      if (ONE.equals(placement.getCdPlcmtAdptBy()))
        nonIncidentAFCARSInformationSO.setCdPlcmtBy(PUBLIC_AGENCY);
      if (TWO.equals(placement.getCdPlcmtAdptBy()))
        nonIncidentAFCARSInformationSO.setCdPlcmtBy(PRIVATE_AGENCY);
      if (THREE.equals(placement.getCdPlcmtAdptBy()))
        nonIncidentAFCARSInformationSO.setCdPlcmtBy(TRIBAL_AGENCY);
      if (FOUR.equals(placement.getCdPlcmtAdptBy()))
        nonIncidentAFCARSInformationSO.setCdPlcmtBy(INDEPENDENT_PERSON);
      if (FIVE.equals(placement.getCdPlcmtAdptBy()))
        nonIncidentAFCARSInformationSO.setCdPlcmtBy(BIRTH_PARENT);

      // This mapping in code was necessary b/c a codes table was never appropriately setup
      // for this data element. Similar code exists in PlcmtInformation.jsp.
      // @TODO Move mapping into codes table after data conversion
      if (ONE.equals(placement.getCdAdoType()))
        nonIncidentAFCARSInformationSO.setCdPlacementFrom(WITHIN_STATE);
      if (TWO.equals(placement.getCdAdoType()))
        nonIncidentAFCARSInformationSO.setCdPlacementFrom(OUT_OF_STATE);
      if (THREE.equals(placement.getCdAdoType()))
        nonIncidentAFCARSInformationSO.setCdPlacementFrom(ANOTHER_COUNTRY);

      Integer idStage = nonIncidentAFCARSInformationSI.getIdStage();
      if(idStage != null && idStage.intValue() > 0) {
        List<String> mslist = stagePersonLinkDAO.listMaritalStatusByCdStagePersRelInt(idStage.intValue(), CodesTables.CRELVICT_PT);
        if(mslist != null && mslist.size() > 0) {
          if(mslist.size() >= 2){
            nonIncidentAFCARSInformationSO.setCdMaritalStatus(CodesTables.CMARSTAT_MA);
          } else if(mslist.size() == 1) {
            nonIncidentAFCARSInformationSO.setCdMaritalStatus(mslist.get(0));
          }
        }
      }
    }
  }

  /**
   * Populates the Adoptive Parent Information into the output object. Makes a call to the database to find the Adoptive Parent 
   * information.
   * 
   * @param nonIncidentAFCARSInformationSI
   * @param nonIncidentAFCARSInformationSO
   * @return void
   */
  private void populateAdoptiveParentsInformation(NonIncidentAFCARSInformationSI nonIncidentAFCARSInformationSI,
                                                  NonIncidentAFCARSInformationSO nonIncidentAFCARSInformationSO) {

    // Find the Adoptive Mother and Father by querying the PAD stage for Primary Caretaker and
    // Foster/Adoptive Parent Relationship codes.
    ArrayList<String> cdRelIntList = new ArrayList<String>();
    cdRelIntList.add(CodesTables.CRELVICT_PT);

    List<StagePersonLink> adoptiveParentList = stagePersonLinkDAO
                                                                 .findStagePersonLinkByIdStageByCdStagePersRelInts(
                                                                                                                   nonIncidentAFCARSInformationSI
                                                                                                                                                 .getIdStage(),
                                                                                                                   cdRelIntList);

    // Loop through the results finding the race/ethnicity for each person
    for (int x = 0; x < adoptiveParentList.size(); x++) {
      StagePersonLink stagePersonLink = adoptiveParentList.get(x);
      CCMN95SI ccmn95si = new CCMN95SI();
      ArchInputStruct input = new ArchInputStruct();
      input.setUsPageNbr(1);
      input.setUlPageSizeNbr(10);
      ccmn95si.setArchInputStruct(input);
      ccmn95si.setUlIdPerson(stagePersonLink.getPerson().getIdPerson());
      CCMN95SO ccmn95so = retrieveRaceAndEthnicity.findPersonRaceAndPersonEthnicity(ccmn95si);

      // Copy the Race structure into a normal Array List
      ArrayList<String> raceArrayList = new ArrayList<String>();
      ROWCCMN95SOG00_ARRAY raceArray = ccmn95so.getROWCCMN95SOG00_ARRAY();
      for (int i = 0; i < raceArray.getUlRowQty(); i++) {
        ROWCCMN95SOG00 race = raceArray.getROWCCMN95SOG00(i);
        raceArrayList.add(race.getSzCdPersonRace());
      }

      // Get the ethnicity into a single variable. While the service returns an array,
      // the application enforce a single ethnicity so this should be okay.
      String cdEthnicity = null;
      ROWCCMN95SOG01_ARRAY ethnicityArray = ccmn95so.getROWCCMN95SOG01_ARRAY();
      for (int i = 0; i < ethnicityArray.getUlRowQty(); i++) {
        ROWCCMN95SOG01 ethnicity = ethnicityArray.getROWCCMN95SOG01(i);
        cdEthnicity = ethnicity.getSzCdPersonEthnicity();
      }

      // Set the race list and ethnicity according to the sex of the person
      if (MALE.equals(stagePersonLink.getPerson().getCdPersonSex())) {
        nonIncidentAFCARSInformationSO.setAfRaceList(raceArrayList);
        nonIncidentAFCARSInformationSO.setCdAFEthnicity(cdEthnicity);
        nonIncidentAFCARSInformationSO.setDtAdoptiveFatherDOB(stagePersonLink.getPerson().getDtPersonBirth());
      } else if (FEMALE.equals(stagePersonLink.getPerson().getCdPersonSex())) {
        nonIncidentAFCARSInformationSO.setAmRaceList(raceArrayList);
        nonIncidentAFCARSInformationSO.setCdAMEthnicity(cdEthnicity);
        nonIncidentAFCARSInformationSO.setDtAdoptiveMotherDOB(stagePersonLink.getPerson().getDtPersonBirth());
      }
    } // End for loop for Adoptive Parent List
  }

  /**
   * Populates the default characteristics into the output object. It maps the special needs found on the adoption assistance application
   * 
   * @param nonIncidentAFCARSInformationSI
   * @param nonIncidentAFCARSInformationSO
   * @return void
   */
  private void populateChildCharacteristics(NonIncidentAFCARSInformationSI nonIncidentAFCARSInformationSI,
                                                   NonIncidentAFCARSInformationSO nonIncidentAFCARSInformationSO) {
    SpecialNeedsDetermination spNeedsDeter = specialNeedsDeterminationDAO.findSpclDeterminationByIdStageByIdPerson(nonIncidentAFCARSInformationSI.getIdStage(), 
                                                                     nonIncidentAFCARSInformationSI.getIdPerson(), 
                                                                     nonIncidentAFCARSInformationSI.getIdCase());
    
    if(spNeedsDeter != null) {
      if ("Y".equals(spNeedsDeter.getIndApprvEmotionalDist())) {
        nonIncidentAFCARSInformationSO.setIndEmtDisturbed(ArchitectureConstants.Y);
      }
      if ("Y".equals(spNeedsDeter.getIndApprvOther())) {
        nonIncidentAFCARSInformationSO.setIndOthMedDiag(ArchitectureConstants.Y);
      }
      if ("Y".equals(spNeedsDeter.getIndApprvMntRetarded())) {
        nonIncidentAFCARSInformationSO.setIndMentRetard(ArchitectureConstants.Y);
      }
      if ("Y".equals(spNeedsDeter.getIndApprvHearingImpaired())) {
        nonIncidentAFCARSInformationSO.setIndVisHearImp(ArchitectureConstants.Y);
      }
      if ("Y".equals(spNeedsDeter.getIndApprvPhysicallyDisabled())) {
        nonIncidentAFCARSInformationSO.setIndPhyDisabled(ArchitectureConstants.Y);
      }
      
      String indSpNdsAppr = spNeedsDeter.getIndAprType();
      String primarySPN = null;
      
      if(CodesTables.CSPCLTYP_R.equals(indSpNdsAppr)){
        primarySPN = CodesTables.CPRSPCLN_02;
      } else if(CodesTables.CSPCLTYP_A.equals(indSpNdsAppr)) {
        primarySPN = CodesTables.CPRSPCLN_03;
      } else if(CodesTables.CSPCLTYP_S.equals(indSpNdsAppr)) {
        primarySPN = CodesTables.CPRSPCLN_04;
      } else if(CodesTables.CSPCLTYP_T.equals(indSpNdsAppr)) {
        primarySPN = CodesTables.CPRSPCLN_05;
      } else if(CodesTables.CSPCLTYP_M.equals(indSpNdsAppr)) {
        primarySPN = CodesTables.CPRSPCLN_06;
      } else if(CodesTables.CSPCLTYP_N.equals(indSpNdsAppr)) {
        primarySPN = CodesTables.CPRSPCLN_01;
      }else if(CodesTables.CSPCLTYP_C.equals(indSpNdsAppr)) {
        primarySPN = CodesTables.CPRSPCLN_08;
      } else if(CodesTables.CSPCLTYP_U.equals(indSpNdsAppr)) {// SMS#45716 Changed from T to U
        primarySPN = CodesTables.CPRSPCLN_09;
      } else if(CodesTables.CSPCLTYP_V.equals(indSpNdsAppr)) {
        primarySPN = CodesTables.CPRSPCLN_10;
      }  
      nonIncidentAFCARSInformationSO.setCdPrimSpecNeed(primarySPN);
          
      nonIncidentAFCARSInformationSO.setDtApplicationSent(spNeedsDeter.getEvent().getDtLastUpdate());
    }
  }
  
  /**
   * Reads the PersonDtl table to retrieve "mother married at birth"
   * information.
   * 
   * @param nonIncidentAFCARSInformationSI
   * @param nonIncidentAFCARSInformationSO
   */
  private void populateMotherMarriedAtBirth(NonIncidentAFCARSInformationSI nonIncidentAFCARSInformationSI,
                                            NonIncidentAFCARSInformationSO nonIncidentAFCARSInformationSO) {
    //STGAP00012148: Retrieve Married at Child Birth information
    PersonDtl personDtl = personDtlDAO.findServiceAuthByIdPerson(nonIncidentAFCARSInformationSI.getIdPerson());
    String indBMMarriedAtChildBrth = "";
    if (personDtl != null) {
      indBMMarriedAtChildBrth = personDtl.getCdPersonMarriedAtBirth();
    }
    nonIncidentAFCARSInformationSO.setIndBMMarriedAtChildBrth(indBMMarriedAtChildBrth);
    
    
  }

  public void setSpecialNeedsDeterminationDAO(SpecialNeedsDeterminationDAO specialNeedsDeterminationDAO) {
    this.specialNeedsDeterminationDAO = specialNeedsDeterminationDAO;
  }
}
