package gov.georgia.dhr.dfcs.sacwis.service.document.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.AdoptionSubsidyDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsResourceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ExchangeChildDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.FccpChildDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.LegalStatusDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.NonIncidentAFCARSInfoDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonIdDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonPhoneDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonRaceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PlacementDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ResourceAddressDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.IncomeAndResourcesDAO;
import gov.georgia.dhr.dfcs.sacwis.db.AdoptionSubsidy;
import gov.georgia.dhr.dfcs.sacwis.db.CapsResource;
import gov.georgia.dhr.dfcs.sacwis.db.ExchangeChild;
import gov.georgia.dhr.dfcs.sacwis.db.LegalStatus;
import gov.georgia.dhr.dfcs.sacwis.db.NonIncidentAfcarsInfo;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.PersonPhone;
import gov.georgia.dhr.dfcs.sacwis.db.PersonRace;
import gov.georgia.dhr.dfcs.sacwis.db.Placement;
import gov.georgia.dhr.dfcs.sacwis.db.ResourceAddress;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.db.StagePersonLink;
import gov.georgia.dhr.dfcs.sacwis.db.IncomeAndResources;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FormDataGroup;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PreFillData;
import gov.georgia.dhr.dfcs.sacwis.service.document.AdoptAssistMem;
import gov.georgia.dhr.dfcs.sacwis.structs.input.AdoptAssistMemSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.AdoptAssistMemSO;

/**
 * Child Life History Checklist service Implementation 
 * <pre>
 * Change History:
 *  Date      User      Description
 *  --------  --------  --------------------------------------------------
 *  07/24/2008  ssubram STGAP00009509: Child life History check list has been added
 *  2/2/2009    cwells  STGAP00012295: Pulling childs name from Exchange Child table. 
 *  05/31/2011  schoi   SMS #109403: MR-082 Added retrieveSSIIncomeAndResources
 *  
 * </pre>
 *
 */
public class AdoptAssistMemImpl extends BaseDocumentServiceImpl implements AdoptAssistMem {
  
  AdoptionSubsidyDAO adoptionSubsidyDAO;
  
  CapsResourceDAO capsResourceDAO;
  
  ExchangeChildDAO exchangeChildDAO;
  
  FccpChildDAO fccpChildDAO;
  
  LegalStatusDAO legalStatusDAO;
  
  NonIncidentAFCARSInfoDAO nonIncidentAFCARSInfoDAO;
  
  PersonDAO personDAO;
  
  PersonIdDAO personIdDAO;

  PersonPhoneDAO personPhoneDAO;
  
  PersonRaceDAO personRaceDAO;
  
  PlacementDAO placementDAO;
  
  ResourceAddressDAO resourceAddressDAO;
  
  StageDAO stageDAO;
  
  StageLinkDAO stageLinkDAO;
  
  StagePersonLinkDAO stagePersonLinkDAO;
  
  // SMS #109403: MR-082
  IncomeAndResourcesDAO incomeAndResourcesDAO;
  
  public void setAdoptionSubsidyDAO(AdoptionSubsidyDAO adoptionSubsidyDAO) {
    this.adoptionSubsidyDAO = adoptionSubsidyDAO;
  }
  
  public void setCapsResourceDAO(CapsResourceDAO capsResourceDAO) {
    this.capsResourceDAO = capsResourceDAO;
  }  
  
  public void setExchangeChildDAO(ExchangeChildDAO exchangeChildDAO) {
    this.exchangeChildDAO = exchangeChildDAO;
  }

  public void setFccpChildDAO(FccpChildDAO fccpChildDAO) {
    this.fccpChildDAO = fccpChildDAO;
  }

  public void setLegalStatusDAO(LegalStatusDAO legalStatusDAO) {
    this.legalStatusDAO = legalStatusDAO;
  }

  public void setNonIncidentAFCARSInfoDAO(NonIncidentAFCARSInfoDAO nonIncidentAFCARSInfoDAO) {
    this.nonIncidentAFCARSInfoDAO = nonIncidentAFCARSInfoDAO;
  }

  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }
  
  public void setPersonIdDAO(PersonIdDAO personIdDAO) {
    this.personIdDAO = personIdDAO;
  }
  
  public void setPersonPhoneDAO(PersonPhoneDAO personPhoneDAO) {
    this.personPhoneDAO = personPhoneDAO;
  }
  
  public void setPersonRaceDAO(PersonRaceDAO personRaceDAO) {
    this.personRaceDAO = personRaceDAO;
  }
  
  public void setPlacementDAO(PlacementDAO placementDAO) {
    this.placementDAO = placementDAO;
  }
  
  public void setResourceAddressDAO(ResourceAddressDAO resourceAddressDAO) {
    this.resourceAddressDAO = resourceAddressDAO;
  }
  
  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }
  
  public void setStageLinkDAO(StageLinkDAO stageLinkDAO) {
    this.stageLinkDAO = stageLinkDAO;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }
  
  // SMS #109403: MR-082
  public void setIncomeAndResourcesDAO(IncomeAndResourcesDAO incomeAndResourcesDAO) {
    this.incomeAndResourcesDAO = incomeAndResourcesDAO;
  }  
  
   public AdoptAssistMemSO retrieveAdoptAssistMem(AdoptAssistMemSI adoptAssistMemSI) {
    AdoptAssistMemSO adoptAssistMemSO = new AdoptAssistMemSO();
    PreFillData preFillData = new PreFillData();
    int idStage = adoptAssistMemSI.getUlIdStage();
    int idAdptSub = adoptAssistMemSI.getUlIdAdptSub();
    String nmChildPrimary ="";
    int idPerson = 0;
    // Generate pre-fill data
    // Find the Primary Child for the given Stage ID 
    String cdStagePersRelInt = CodesTables.CROLES_PC;
    StagePersonLink stagePersonLink = stagePersonLinkDAO
                                                        .findStagePersonLinkByIdStageByCdStagePersRole(idStage,
                                                                                                       cdStagePersRelInt);
    
    if (stagePersonLink != null) {
      Person childPrimary = stagePersonLink.getPerson();
      if (childPrimary != null) {
        nmChildPrimary = childPrimary.getNmPersonFull();
        idPerson = childPrimary.getIdPerson();
      }
    }    
    // Get the DOB, Full Name, Sex and County Code
    Person person = personDAO.findPersonByIdPerson(idPerson);
    
    //Get the Stage
    Stage stage = stageDAO.findStageByIdStage(idStage);
    
    //Get FC Medicaid #, SSN, New Medicaid # and New SSN(from PAD stage if applicable)
    retrievePersonalInfo(idPerson, stage, preFillData);
    
    // SMS #109403: MR-082
    // Get the SSI Incomes and Resources entry and the most recent SSI Incomes and Resources record
    retrieveSSIIncomeAndResources(idPerson, preFillData);
    
    //Get the Primary Case worker and Phone number
    Person caseWorker = getCaseManagerInfo(idStage);
    String caseWorkerName = getFullName(caseWorker);
    String phoneNum = getPersonOfficePhone(caseWorker.getIdPerson());
    Date endDate = null;
    //Get the Father, Mother and Address
    retrieveResourceInfo(preFillData, idPerson);

    //Get Adoption Subsidy Start and End date
    AdoptionSubsidy adoptionSubsidy = adoptionSubsidyDAO.findAdptSubByIdAdptSub(idAdptSub);

    if (person == null) {
      throw new ServiceException(Messages.MSG_NO_ROWS_RETURNED);
    }else {
      preFillData.addBookmark(createBookmark(AdoptAssistMem.CASE_WORKER, FormattingHelper.formatString(caseWorkerName)));
      preFillData.addBookmark(createBookmark(AdoptAssistMem.TEL_NUMBER, FormattingHelper.formatPhone(phoneNum)));
      preFillData.addBookmark(createBookmark(AdoptAssistMem.DOB, FormattingHelper.formatDate(person.getDtPersonBirth())));
      preFillData.addBookmark(createBookmark(AdoptAssistMem.SEX, FormattingHelper.formatString(person.getCdPersonSex())));
      preFillData.addBookmark(createBookmark(AdoptAssistMem.RACE, FormattingHelper.formatString(getPersonRace(idPerson))));
      preFillData.addBookmark(createBookmarkWithCodesTable(AdoptAssistMem.COUNTY, FormattingHelper.formatString(stage.getCdStageCnty()),
                                                           CodesTables.CCOUNT));
      preFillData.addBookmark(createBookmark(AdoptAssistMem.DATE_BEGIN, 
                                             FormattingHelper.formatDate(adoptionSubsidy.getDtAdptSubEffective())));
      //the Date the adoption assistance should discontinue based on the end date or termination date 
      //(whichever is non-null and comes first) of the Adoption Assistance Agreement.
      if (adoptionSubsidy.getDtAdptSubEnd() != null){
        endDate = adoptionSubsidy.getDtAdptSubEnd();
        if (adoptionSubsidy.getDtAdptSubTerminated() != null){
          if(DateHelper.isAfter(endDate,adoptionSubsidy.getDtAdptSubTerminated())){ 
            endDate = adoptionSubsidy.getDtAdptSubTerminated();
          }
        }
      }else if(adoptionSubsidy.getDtAdptSubTerminated() != null){
        endDate = adoptionSubsidy.getDtAdptSubTerminated();
      }
      preFillData.addBookmark(createBookmark(AdoptAssistMem.DATE_END, 
                                             FormattingHelper.formatDate(endDate)));
      if (adoptionSubsidy.getIndSchoolVer()!= null && ArchitectureConstants.Y.equals(adoptionSubsidy.getIndSchoolVer())){
        preFillData.addBookmark(createBookmark(AdoptAssistMem.BENFT_BEYND_18_YES,"CHECKED"));
      }else{
        preFillData.addBookmark(createBookmark(AdoptAssistMem.BENFT_BEYND_18_NO,"CHECKED"));
      }
      //Set Child Eligibility
      setChildEligibility(preFillData, adoptionSubsidy);    
      
    }
    adoptAssistMemSO.setPreFillData(preFillData);
    return adoptAssistMemSO;
  }

   // get the case manager for the ADO stage
   private Person getCaseManagerInfo(int idStage) {
     // Checking for current case manager as well as historical case manager
     StagePersonLink stagePersonLink = stagePersonLinkDAO.findStagePersonLinkByIdStageCdStagePersRoleAll(idStage);
     Person caseMngr = stagePersonLink.getPerson();
     return caseMngr;
   } // end getCaseManagerInfo()

   // if a person has a primary active & valid business office phone, select it, otherwise get the next active & valid
   // business phone available
   private String getPersonOfficePhone(int idPerson) {
     List<String> phoneTypes = new ArrayList<String>();
     phoneTypes.add(CodesTables.CPHNTYP_BC); // Business Cell
     phoneTypes.add(CodesTables.CPHNTYP_BP); // Business Pager
     phoneTypes.add(CodesTables.CPHNTYP_BS); // Business

     return getPersonOfficePhoneNbr(idPerson, phoneTypes);
   }

   private String getPersonOfficePhoneNbr(int idPerson, List<String> phoneTypes) {
     StringBuffer primPersonPhone = new StringBuffer();
     String indPersonPhoneInValid = "N";
     String indPersonPhonePrimary = "Y";

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
         if (indPersonPhonePrimary.equals(personPhone.getIndPersonPhonePrimary())) {
           if (personPhone.getNbrPersonPhone() != null) {
             primPersonPhone.append(FormattingHelper.formatPhone(personPhone.getNbrPersonPhone()));
             if (personPhone.getNbrPersonPhoneExtension() != null) {
               primPersonPhone
                              .append("   Ext " + FormattingHelper.formatPhone(personPhone.getNbrPersonPhoneExtension()));
             }
             break;
           }
         } else {
           if (personPhone.getNbrPersonPhone() != null) {
             primPersonPhone.append(FormattingHelper.formatPhone(personPhone.getNbrPersonPhone()));
             if (personPhone.getNbrPersonPhoneExtension() != null) {
               primPersonPhone
                              .append("   Ext " + FormattingHelper.formatPhone(personPhone.getNbrPersonPhoneExtension()));
             }
             break;
           } // inner else
         } // end outer if indPersonPhonePrimary
       } // end if personPhone
     } // end for loop
     return primPersonPhone.toString();

   }

   private String getFullName(Person person) {
     StringBuffer fullName = new StringBuffer();
     if (person != null) {
       fullName.append(person.getNmPersonLast());
       if (person.getNmPersonFirst() != null) {
         fullName.append(", " + person.getNmPersonFirst());
       }
       if (person.getNmPersonMiddle() != null) {
         fullName.append(" " + person.getNmPersonMiddle());
       }
       if (person.getCdPersonSuffix() != null) {
         fullName.append(" " + person.getCdPersonSuffix());
       }
     }
     return fullName.toString();
   }
   
   private void setChildEligibility(PreFillData preFillData, AdoptionSubsidy adoptionSubsidy) {
     String adptSubDetermCd = adoptionSubsidy.getCdAdptSubDeterm();
     double amtAdoAsst = adoptionSubsidy.getAmtAdptSub();
     Date agrmtStartDt = adoptionSubsidy.getDtAdptSubEffective();
     if (null != adptSubDetermCd){
       //State Funded Adoption Assistance
       if (CodesTables.CSUBTYPE_07.equalsIgnoreCase(adptSubDetermCd) ||
                       CodesTables.CSUBTYPE_09.equalsIgnoreCase(adptSubDetermCd) ||
                       CodesTables.CSUBTYPE_11.equalsIgnoreCase(adptSubDetermCd) ||
                       CodesTables.CSUBTYPE_12.equalsIgnoreCase(adptSubDetermCd) ||
                       CodesTables.CSUBTYPE_13.equalsIgnoreCase(adptSubDetermCd)) {
         preFillData.addBookmark(createBookmark(AdoptAssistMem.STATE_FUNDED_ADOPT_ASST, 
                                                FormattingHelper.formatMoney(amtAdoAsst)));
         preFillData.addBookmark(createBookmark(AdoptAssistMem.CBX_STATE_FUNDED_ADOPT_ASST, 
                                                FormattingHelper.formatString(AdoptAssistMem.CBX_X)));
       }
       //Title IV_E Adoption Assistance
       if (CodesTables.CSUBTYPE_01.equalsIgnoreCase(adptSubDetermCd) ||
                       CodesTables.CSUBTYPE_03.equalsIgnoreCase(adptSubDetermCd) ||
                       CodesTables.CSUBTYPE_05.equalsIgnoreCase(adptSubDetermCd) ||
                       CodesTables.CSUBTYPE_06.equalsIgnoreCase(adptSubDetermCd)) {
         preFillData.addBookmark(createBookmark(AdoptAssistMem.TITLE_IVE, 
                                                FormattingHelper.formatMoney(amtAdoAsst)));
         preFillData.addBookmark(createBookmark(AdoptAssistMem.CBX_TITLE_IVE, 
                                                AdoptAssistMem.CBX_X));         
       }
       //Non-Recurring Adoption Assistance
       if (CodesTables.CSUBTYPE_22.equalsIgnoreCase(adptSubDetermCd) ||
                       CodesTables.CSUBTYPE_23.equalsIgnoreCase(adptSubDetermCd) ||
                       CodesTables.CSUBTYPE_24.equalsIgnoreCase(adptSubDetermCd) ||
                       CodesTables.CSUBTYPE_25.equalsIgnoreCase(adptSubDetermCd) ||
                       CodesTables.CSUBTYPE_26.equalsIgnoreCase(adptSubDetermCd)) {
         preFillData.addBookmark(createBookmark(AdoptAssistMem.NON_RECURRING, 
                                                FormattingHelper.formatMoney(amtAdoAsst)));
         preFillData.addBookmark(createBookmark(AdoptAssistMem.CBX_NON_RECURRING, 
                                                AdoptAssistMem.CBX_X));   
         //DateHelper uses Calendar.MONTH, which returns zero-based values (i.e. 0=January, 1=February, etc.)
         preFillData.addBookmark(createBookmark(AdoptAssistMem.MONTH_PAID,
                                                (DateHelper.getMonth(agrmtStartDt) + 1) +"/"+
                                                DateHelper.getYear(agrmtStartDt)));
       }
     }
   }
   @SuppressWarnings( { "unchecked" })
   private void retrieveResourceInfo(PreFillData preFillData, int idChildPrimary) {
     Placement adoPlcmt = null;
     int idFadStage = 0;
     String address = "";
     String nameFather = "";
     String nameMother = "";
     adoPlcmt = getCurrentPlacement(idChildPrimary);
     if (adoPlcmt != null) {
       int idResource = adoPlcmt.getCapsResourceByIdRsrcFacil() == null ? 0 : adoPlcmt.getCapsResourceByIdRsrcFacil()
                                                                                      .getIdResource();
       if (idResource > 0) {
         ResourceAddress rsrcAddress = resourceAddressDAO.findRsrcAddressByAddressTypeOnly(idResource);
         if (rsrcAddress != null) {
           StringBuffer addr = new StringBuffer();
           formatAddress(rsrcAddress.getAddrRsrcAddrStLn1(), rsrcAddress.getAddrRsrcAddrStLn2(),
                         rsrcAddress.getAddrRsrcAddrCity(), rsrcAddress.getCdRsrcAddrState(),
                         rsrcAddress.getAddrRsrcAddrZip(), addr);
           address = addr.toString();
         }
         CapsResource resource = capsResourceDAO.findCapsResourceByIdResc(idResource);
         if (resource != null) {
           idFadStage = resource.getStage() == null ? 0 : resource.getStage().getIdStage();
           if (idFadStage > 0) {
             Collection cdStagePersTypes = new ArrayList<String>();
             cdStagePersTypes.add(CodesTables.CRELVICT_AF);
             cdStagePersTypes.add(CodesTables.CRELVICT_FA);
             cdStagePersTypes.add(CodesTables.CRELVICT_FP);
             cdStagePersTypes.add(CodesTables.CRELVICT_PT);
             List<StagePersonLink> personList = stagePersonLinkDAO
                                                                  .findStagePersonLinkByIdStageByCdStagePersRelInts(
                                                                                                                    idFadStage,
                                                                                                                    cdStagePersTypes);
             if (personList != null) {
               Iterator it = personList.iterator();
               while (it.hasNext()) {
                 StagePersonLink stgPerson = (StagePersonLink) it.next();
                 Person person = stgPerson.getPerson();
                 if (person != null) {
                   String cdSex = person.getCdPersonSex();
                   if (cdSex.equalsIgnoreCase(CodesTables.CRSRCSEX_M)){
                     nameFather = person.getNmPersonFull();
                     preFillData.addBookmark(createBookmark(AdoptAssistMem.FATHER, FormattingHelper.formatString(nameFather)));
                   }else if (cdSex.equalsIgnoreCase(CodesTables.CRSRCSEX_F)){
                     nameMother = person.getNmPersonFull();
                     preFillData.addBookmark(createBookmark(AdoptAssistMem.MOTHER, FormattingHelper.formatString(nameMother)));
                   }                   
                 }
               }
             }
           }
         }
       }
     }
     preFillData.addBookmark(createBookmark(AdoptAssistMem.ADDRESS, FormattingHelper.formatString(address)));
   }   

   private void formatAddress(String stLn1, String stLn2, String city, String state, String zip, StringBuffer addr) {
     if (stLn1 != null) {
       addr = addr.append(stLn1);
     }
     if (stLn2 != null) {
       addr = addr.append(", " + stLn2);
     }
     if (city != null) {
       addr = addr.append(", " + city);
     }
     if (state != null) {
       addr = addr.append(", " + state);
     }
     if (zip != null) {
       addr = addr.append(", " + zip);
     }
   }
   
   // Start Current Placement
   private Placement getCurrentPlacement(int idPrimaryChild) {
     return placementDAO.findPlacementLatestApprovedByIdPerson(idPrimaryChild, DateHelper.MAX_JAVA_DATE);
   }
   
   // If the current stage is ADO then use the idPerson to find the SSN and Medicaid # and fill
   // blank for new SSN and new Medicaid #.
   // If the current stage is PAD, then find the previous stage (usually ADO if PAD is an incident 
   // child) and get the previous Person Id to find the SSN and Medicaid #. Now use the existing
   // person id to find the new SSN and new Medicaid #. For non incident child the SSN, Medicaid #
   // will be set to blank. (Non incident child is nothing but the child got to the PAD stage
   // straight from the INT).
   private void retrievePersonalInfo(int idPerson, Stage stage, PreFillData preFillData) {
     String cdStage = stage.getCdStage();
     int idStage = stage.getIdStage();
     Integer idPrevStage = null;
     Integer idPrevPerson = null;
     String ssn = "";
     String medicaidNum = "";
     String newSsn = "";
     String newMedicaidNum = "";
     String newName = "";
     String birthName = "";
     Date dtFinalization = null;
     if (CodesTables.CSTAGES_ADO.equals(cdStage)) {
       birthName = personDAO.findNmFullByIdPerson(idPerson);
       ssn = personIdDAO.findNonEndDatePersonSSN(idPerson);
       medicaidNum = personIdDAO.findNonEndDatePersonMedicaid(idPerson);        
       //Get Adoption Finalization Date by passing status code "Not In DFCS Custody - Adoption Finalized"
       LegalStatus legalStatus = legalStatusDAO.findMostRecentLegalStatusbyIdPersonAndLegalStatStatus(idPerson, CodesTables.CLEGSTAT_NAF);
       if (legalStatus != null){
         dtFinalization = legalStatus.getDtLegalStatStatusDt();
       } 
       if(CodesTables.CCLOSADO_ADF.equals(stage.getCdStageReasonClosed())) {
         Integer idPADStage = stageLinkDAO.findNewIdPADStageByIdPriorStage(idStage);
         if(idPADStage != null && idPADStage > 0){
           StagePersonLink stagePersonLink = stagePersonLinkDAO
                                                               .findStagePersonLinkByIdStageByCdStagePersRole(idPADStage,
                                                                                                              CodesTables.CROLES_PC);
           
           if (stagePersonLink != null) {
             Person childPrimary = stagePersonLink.getPerson();
             if (childPrimary != null) {
               newName = childPrimary.getNmPersonFull();
             }
           }    
         }
       }
       
       FormDataGroup birthNameGroup = createFormDataGroup(TMPLAT_BIRTH_NAME, ADOASSMEM);
       birthNameGroup.addBookmark(createBookmark(AdoptAssistMem.CHILD_BIRTH_NAME, FormattingHelper.formatString(birthName)));
       preFillData.addFormDataGroup(birthNameGroup);
       
       FormDataGroup birthIDSGroup = createFormDataGroup(TMPLAT_BIRTH_IDS, ADOASSMEM);
       birthIDSGroup.addBookmark(createBookmark(AdoptAssistMem.SSN, FormattingHelper.formatSSN(ssn)));
       birthIDSGroup.addBookmark(createBookmark(AdoptAssistMem.FC_MEDICAID, FormattingHelper.formatString(medicaidNum)));
       preFillData.addFormDataGroup(birthIDSGroup);
       
     } else if (CodesTables.CSTAGES_PAD.equals(cdStage)) {
       //Return Previous Stage ID only if the previous stage is ADO
       idPrevStage = stageLinkDAO.findPreviousIdStageByIdStageByCdStage(idStage);
       if (idPrevStage != null){
         //This makes the child as incident child.
         idPrevPerson = stagePersonLinkDAO.findIdPersonForChildByIdStage(idPrevStage);
         if (idPrevPerson != null){
           newSsn = personIdDAO.findNonEndDatePersonSSN(idPerson);
           newMedicaidNum = personIdDAO.findNonEndDatePersonMedicaid(idPerson);
           Person person = personDAO.findPersonByIdPerson(idPerson);
           newName = person.getNmPersonFull();
           //Get Adoption Finalization Date by passing status code "Not In DFCS Custody - Adoption Finalized"
           LegalStatus legalStatus = legalStatusDAO.findMostRecentLegalStatusbyIdPersonAndLegalStatStatus(idPrevPerson, CodesTables.CLEGSTAT_NAF);
           if (legalStatus != null){
             dtFinalization = legalStatus.getDtLegalStatStatusDt();
           }
         }
       }else{
         //Non Incident Child
         newSsn = personIdDAO.findNonEndDatePersonSSN(idPerson);
         newMedicaidNum = personIdDAO.findNonEndDatePersonMedicaid(idPerson);
         Person person = personDAO.findPersonByIdPerson(idPerson);
         newName = person.getNmPersonFull();
       } 
     }
     preFillData.addBookmark(createBookmark(AdoptAssistMem.NEW_SSN, FormattingHelper.formatSSN(newSsn)));
     preFillData.addBookmark(createBookmark(AdoptAssistMem.NEW_MA_NUMBER, FormattingHelper.formatString(newMedicaidNum)));
     preFillData.addBookmark(createBookmark(AdoptAssistMem.MA_CARD_NAME, FormattingHelper.formatString(newName)));
     preFillData.addBookmark(createBookmark(AdoptAssistMem.DATE_FINALIZATION, 
                                            FormattingHelper.formatDate(dtFinalization)));
   }

   // SMS #109403: MR-082
   private void retrieveSSIIncomeAndResources(int idPerson, PreFillData preFillData) {
    String cdIncRsrcType = "SSI";
    
    // Get today's date
    Date todayDate = DateHelper.toJavaDate(DateHelper.getTodayCastorDate());

    // Get the most recent income and resource records as of current date for the given person by cdIncRsrcType
    IncomeAndResources incomeAndResources = incomeAndResourcesDAO
                                                                 .findMostRecentIncomeAsOfTodayByIdPersonByCdIncRsrcType(
                                                                                                                 idPerson,
                                                                                                                 cdIncRsrcType,
                                                                                                                 todayDate);
    if (incomeAndResources != null) {
      double amtIncRerc = incomeAndResources.getAmtIncRsrc();
      if (amtIncRerc > 0) {
        preFillData.addBookmark(createBookmark(AdoptAssistMem.RECEIVE_SSI_YES, "CHECKED"));
        preFillData.addBookmark(createBookmark(AdoptAssistMem.AMOUNT_OF_SSI, FormattingHelper.formatMoney(amtIncRerc)));
      }
    } else {
      preFillData.addBookmark(createBookmark(AdoptAssistMem.RECEIVE_SSI_NO, "CHECKED"));
    }
  }
   
   private String getFullName(NonIncidentAfcarsInfo nonIncidentAfcarsInfo) {
     StringBuffer fullName = new StringBuffer();
     if (nonIncidentAfcarsInfo != null) {
       if (nonIncidentAfcarsInfo.getNmBnLast() != null) {
         fullName.append(nonIncidentAfcarsInfo.getNmBnLast());
       }
       if (nonIncidentAfcarsInfo.getNmBnFirst() != null) {
         fullName.append(", " + nonIncidentAfcarsInfo.getNmBnFirst());
       }
       if (nonIncidentAfcarsInfo.getNmBnMiddle() != null) {
         fullName.append(" " + nonIncidentAfcarsInfo.getNmBnMiddle());
       }
     }
     return fullName.toString();
   }
   
   private String getPersonRace(Integer idPerson){
     StringBuffer strPersonRace = new StringBuffer();
     //Get the Person Race
     List<PersonRace> personRaceList = personRaceDAO.findPersonRaceByIdPerson(idPerson);
     for(int i = 0; i < personRaceList.size(); i++){
       PersonRace personRace = personRaceList.get(i);
       if (personRace.getCdRace() != null){
         if (i+1 < personRaceList.size()){
           strPersonRace.append(Lookup.simpleDecodeSafe(CodesTables.CRACE, personRace.getCdRace())+", ");
         }else if (i+1 == personRaceList.size()){
           strPersonRace.append(Lookup.simpleDecodeSafe(CodesTables.CRACE, personRace.getCdRace()));
         }
       }
     }    
     return strPersonRace.toString();
   }
}
