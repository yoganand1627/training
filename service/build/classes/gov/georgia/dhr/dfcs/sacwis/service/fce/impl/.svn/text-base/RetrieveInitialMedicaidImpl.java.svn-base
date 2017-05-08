package gov.georgia.dhr.dfcs.sacwis.service.fce.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.CnsrvtrshpRemovalDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.IncomeAndResourcesDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.InitialMedicaidAppDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.LegalStatusDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Characteristics;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.LegalStatus;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.service.fce.RetrieveInitialMedicaid;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.IncomeResourceMedicaidSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.MedicaidApplicationRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.PrincipalsList;
import gov.georgia.dhr.dfcs.sacwis.structs.output.MedicaidApplicationRetrieveSO;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Change History:
 * 
 *  Date      User              Description
 * --------  ----------------  --------------------------------------------------
 * 10/15/2008   wjcochran      Added new fields required for Adoptions updates
 *                             (STGAP00010435)
 * 10/23/2008   arege          STGAP00006284 Used new method to retrieve dtRemoval for displaying
 *                             correct date on the Initial Medicaid application.  
 * 12/31/2008   arege          STGAP00006284 Modified Code to resolve Null Pointer Exception    
 * 08/05/2009   arege          STGAP00014774 dtRemoval should not change with changes in placements.                                           
 */ 
public class RetrieveInitialMedicaidImpl extends BaseServiceImpl implements RetrieveInitialMedicaid {

  private static final String EVENT_TYPE = "IMA";
  
  private CnsrvtrshpRemovalDAO cnsrvtrshpRemovalDAO = null;
  
  private PersonDAO personDAO = null;

  private EventDAO eventDAO = null;

  private IncomeAndResourcesDAO incomeAndResourcesDAO = null;

  private InitialMedicaidAppDAO initialMedicaidAppDAO = null;

  private StageDAO stageDAO = null;
  
  private StageLinkDAO stageLinkDAO = null;

  private LegalStatusDAO legalStatusDAO = null;

  public void setCnsrvtrshpRemovalDAO(CnsrvtrshpRemovalDAO cnsrvtrshpRemovalDAO) {
    this.cnsrvtrshpRemovalDAO = cnsrvtrshpRemovalDAO;
  }
  public void setInitialMedicaidAppDAO(InitialMedicaidAppDAO initialMedicaidAppDAO) {
    this.initialMedicaidAppDAO = initialMedicaidAppDAO;
  }

  public void setIncomeAndResourcesDAO(IncomeAndResourcesDAO incomeAndResourcesDAO) {
    this.incomeAndResourcesDAO = incomeAndResourcesDAO;
  }

  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }

  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }

  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }
  
  public void setStageLinkDAO(StageLinkDAO stageLinkDAO) {
    this.stageLinkDAO = stageLinkDAO;
  }

  public void setLegalStatusDAO(LegalStatusDAO legalStatusDAO) {
    this.legalStatusDAO = legalStatusDAO;
  }

  /**
   * This method retrives required value from proper DAO
   * 
   * @param MedicaidApplicationRetrieveSI
   * @return MedicaidApplicationRetrieveSO
   */
  public MedicaidApplicationRetrieveSO retrieveInitialMedicaid(
                                                               MedicaidApplicationRetrieveSI medicaidApplicationRetrieveSI)
                                                                                                                           throws ServiceException {
    MedicaidApplicationRetrieveSO medicaidApplicationRetrieveSO = new MedicaidApplicationRetrieveSO();

    Event event = eventDAO.findEventByStageAndType(medicaidApplicationRetrieveSI.getUlIdStage(), EVENT_TYPE);
    int idEvent = 0;

    if (event != null) {
      idEvent = event.getIdEvent();
    }

    if (idEvent != 0) {
      Map initialMedicaid = initialMedicaidAppDAO.findInitialMedicaid(idEvent);
      if (initialMedicaid == null) {
        throw new ServiceException(Messages.MSG_NO_ROWS_RETURNED);
      }
      medicaidApplicationRetrieveSO.setEventId(idEvent);
      medicaidApplicationRetrieveSO
                                   .setIndChildCoverage(initialMedicaid.get("indChildCoverage") != null ? (String) initialMedicaid
                                                                                                                                  .get("indChildCoverage")
                                                                                                       : "");
      medicaidApplicationRetrieveSO
                                   .setIndChildPregnancy(initialMedicaid.get("indChildPregnancy") != null ? (String) initialMedicaid
                                                                                                                                    .get("indChildPregnancy")
                                                                                                         : "");
      medicaidApplicationRetrieveSO
                                   .setIndHealthInsuranceCard(initialMedicaid.get("indHealthInsuranceCard") != null ? (String) initialMedicaid
                                                                                                                                              .get("indHealthInsuranceCard")
                                                                                                                   : "");
      medicaidApplicationRetrieveSO
                                   .setIndCaseManagerApply(ArchitectureConstants.Y
                                                                                  .equals((String) initialMedicaid
                                                                                                                  .get("indCaseManagerApply")) ? true
                                                                                                                                              : false);
      medicaidApplicationRetrieveSO
                                   .setIndMedicalAsstChild(initialMedicaid.get("indMedicalAsstChild") != null ? (String) initialMedicaid
                                                                                                                                        .get("indMedicalAsstChild")
                                                                                                             : "");
      medicaidApplicationRetrieveSO
                                   .setIndChildSupportOrder(initialMedicaid.get("indChildSupportOrder") != null ? (String) initialMedicaid
                                                                                                                                          .get("indChildSupportOrder")
                                                                                                               : "");
      medicaidApplicationRetrieveSO
                                   .setTxtComments(initialMedicaid.get("txtComments") != null ? ((String) initialMedicaid
                                                                                                                         .get("txtComments"))
                                                                                             : "");
      medicaidApplicationRetrieveSO.setDtProcessed((Date) initialMedicaid.get("dtProcessed"));
      medicaidApplicationRetrieveSO.setDtEstDeliveryDate((Date) initialMedicaid.get("dtEstDeliveryDate"));
      medicaidApplicationRetrieveSO
                                   .setCdType(initialMedicaid.get("cdType") != null ? (String) initialMedicaid
                                                                                                              .get("cdType")
                                                                                   : "");
      medicaidApplicationRetrieveSO
                                   .setNmCompany(initialMedicaid.get("nmCompany") != null ? ((String) initialMedicaid
                                                                                                                     .get("nmCompany"))
                                                                                         : "");
      medicaidApplicationRetrieveSO
                                   .setNbrPolicy(initialMedicaid.get("nbrPolicy") != null ? ((String) initialMedicaid
                                                                                                                     .get("nbrPolicy"))
                                                                                         : "");
      medicaidApplicationRetrieveSO
                                   .setNbrGroup(initialMedicaid.get("nbrGroup") != null ? ((String) initialMedicaid
                                                                                                                   .get("nbrGroup"))
                                                                                       : "");
      medicaidApplicationRetrieveSO
                                   .setAddrStreetLn1(initialMedicaid.get("addrStreetLn1") != null ? ((String) initialMedicaid
                                                                                                                             .get("addrStreetLn1"))
                                                                                                 : "");
      medicaidApplicationRetrieveSO
                                   .setAddrStreetLn2(initialMedicaid.get("addrStreetLn2") != null ? ((String) initialMedicaid
                                                                                                                             .get("addrStreetLn2"))
                                                                                                 : "");
      medicaidApplicationRetrieveSO
                                   .setAddrCity(initialMedicaid.get("addrCity") != null ? ((String) initialMedicaid
                                                                                                                   .get("addrCity"))
                                                                                       : "");
      medicaidApplicationRetrieveSO
                                   .setAddrState(initialMedicaid.get("addrState") != null ? ((String) initialMedicaid
                                                                                                                     .get("addrState"))
                                                                                         : "");
      medicaidApplicationRetrieveSO
                                   .setAddrZip(initialMedicaid.get("addrZip") != null ? ((String) initialMedicaid
                                                                                                                 .get("addrZip"))
                                                                                     : "");
      medicaidApplicationRetrieveSO
                                   .setNbrPhone(initialMedicaid.get("nbrPhone") != null ? ((String) initialMedicaid
                                                                                                                   .get("nbrPhone"))
                                                                                       : "");
      medicaidApplicationRetrieveSO
                                   .setNmPolicyHolder(initialMedicaid.get("nmPolicyHolder") != null ? ((String) initialMedicaid
                                                                                                                               .get("nmPolicyHolder"))
                                                                                                   : "");
      medicaidApplicationRetrieveSO.setDtBegin((Date) initialMedicaid.get("dtBegin"));
      medicaidApplicationRetrieveSO.setDtEnd((Date) initialMedicaid.get("dtEnd"));
      medicaidApplicationRetrieveSO
                                   .setNmEmployer(initialMedicaid.get("nmEmployer") != null ? ((String) initialMedicaid
                                                                                                                       .get("nmEmployer"))
                                                                                           : "");
      medicaidApplicationRetrieveSO
                                   .setNmEmployeeName(initialMedicaid.get("nmEmployeeName") != null ? ((String) initialMedicaid
                                                                                                                               .get("nmEmployeeName"))
                                                                                                   : "");
      medicaidApplicationRetrieveSO
                                   .setTxtMonths(initialMedicaid.get("txtMonths") != null ? ((String) initialMedicaid
                                                                                                                     .get("txtMonths"))
                                                                                         : "");
      medicaidApplicationRetrieveSO
                                   .setIndParent(ArchitectureConstants.Y
                                                                        .equals((String) initialMedicaid
                                                                                                        .get("indParent")) ? true
                                                                                                                          : false);
      medicaidApplicationRetrieveSO.setCdEventStatus(event.getCdEventStatus() != null ? event.getCdEventStatus() : "");
      medicaidApplicationRetrieveSO.setCdTask(event.getCdTask() != null ? event.getCdTask() : "");
      medicaidApplicationRetrieveSO.setDtEventOccurred(event.getDtEventOccurred());
      medicaidApplicationRetrieveSO.setDtSigned((Date) initialMedicaid.get("dtCmSigned"));
      int idCaseManager = 0;
      if (initialMedicaid.get("idCaseManager") != null) {
        idCaseManager = Integer.parseInt(initialMedicaid.get("idCaseManager").toString());
      }
      
      medicaidApplicationRetrieveSO.setIndIcamaIcpc(initialMedicaid.get("indIcamaIcpc") != null ? ((String) initialMedicaid
                                                                                                                           .get("indIcamaIcpc"))
                                                                                               : " ");
      medicaidApplicationRetrieveSO.setCdIcamaAsstType(initialMedicaid.get("cdIcamaAsstType") != null ? ((String) initialMedicaid
                                                                                                                                 .get("cdIcamaAsstType"))
                                                                                               : " ");
      medicaidApplicationRetrieveSO.setCdIcamaState(initialMedicaid.get("cdIcamaState") != null ? ((String) initialMedicaid
                                                                                                                           .get("cdIcamaState")) 
                                                                                               : " ");
      medicaidApplicationRetrieveSO.setCdAdoptionType(initialMedicaid.get("cdAdoptionType") != null ? ((String) initialMedicaid
                                                                                                                               .get("cdAdoptionType")) 
                                                                                               : " ");
      medicaidApplicationRetrieveSO.setTxtIcamaComments(initialMedicaid.get("txtIcamaComments") != null ? ((String) initialMedicaid
                                                                                                                                   .get("txtIcamaComments")) 
                                                                                               : " ");
      
      String nmCaseManager = personDAO.findNmFullByIdPerson(idCaseManager);
      medicaidApplicationRetrieveSO.setNmCaseManager(nmCaseManager);
    }

    int idPerson = 0;
    if (medicaidApplicationRetrieveSI.getUlIdStage() != 0 && medicaidApplicationRetrieveSI.getUlIdCase() != 0) {
      List<Map> personList = personDAO
                                      .findPersonPersonDtlByStagePersonLink(
                                                                            medicaidApplicationRetrieveSI
                                                                                                         .getUlIdStage(),
                                                                            medicaidApplicationRetrieveSI.getUlIdCase());

      if (!personList.isEmpty() || personList != null) {
        for (Iterator<Map> mapIt = personList.iterator(); mapIt.hasNext();) {
          Map mapPerson = mapIt.next();
          medicaidApplicationRetrieveSO
                                       .setChildName((String) mapPerson.get("nmPersonFull") != null ? (String) mapPerson
                                                                                                                        .get("nmPersonFull")
                                                                                                   : " ");
          medicaidApplicationRetrieveSO
                                       .setGender((String) mapPerson.get("cdPErsonSex") != null ? (String) mapPerson
                                                                                                                    .get("cdPErsonSex")
                                                                                               : " ");
          medicaidApplicationRetrieveSO.setDob((Date) mapPerson.get("dtPersonBirth"));
          medicaidApplicationRetrieveSO
                                       .setSsn((String) mapPerson.get("nbrPersonIdNumber") != null ? (String) mapPerson
                                                                                                                       .get("nbrPersonIdNumber")
                                                                                                  : " ");
          idPerson = (Integer) mapPerson.get("idPerson");
          medicaidApplicationRetrieveSO
                                       .setIdPerson((Integer) mapPerson.get("idPerson") != null ? (Integer) mapPerson
                                                                                                                     .get("idPerson")
                                                                                               : 0);

          int idPersonTemp = Integer.parseInt(((Integer) mapPerson.get("idPerson")).toString());
          String cdRace = personDAO.findcdRaceByIdPerson(idPersonTemp);

          Map cdPersonCitizenshipMap = personDAO.findCdPersonCitizenshipCdPersonBirthCountyByIdPerson(idPersonTemp);
          
          // STGAP00006284 : Commented out the following line and added code to reflect correct dt_removal on the
          // Initial Medicaid Page.
          // It retrieves most recent removal that contributed to the opening of the FCC stage.
          // Date dtRemoval = personDAO.findDtRemovalByIdPerson(idPersonTemp);
          int idCase = medicaidApplicationRetrieveSI.getUlIdCase();
          int idStage = medicaidApplicationRetrieveSI.getUlIdStage();
          //Per STGAP00006284 Modified to resolve Null Pointer Exception
          Integer idPrevStage = stageLinkDAO.findPreviousIdStagebyIdStage(idStage);
          if (idPrevStage == null) {
            idPrevStage = 0;
          }
          Stage stage = getPersistentObject(Stage.class, idStage);
          String cdStage = stage.getCdStage();
          Date dtRemoval = cnsrvtrshpRemovalDAO.findDtRemovalByIdPersonByIdCase(idPersonTemp, idCase, idPrevStage);

          // If we are retrieving the Intial Medicaid application in the ADO stage
          if (CodesTables.CSTAGES_ADO.equals(cdStage)) {
            Integer idPrevPrevStage = stageLinkDAO.findPreviousIdStagebyIdStage(idPrevStage);
            if (idPrevPrevStage == null) {
              idPrevPrevStage = 0;
            }
            dtRemoval = cnsrvtrshpRemovalDAO.findDtRemovalByIdPersonByIdCase(idPersonTemp, idCase, idPrevPrevStage);
          }
          
          if (dtRemoval == null) {
            //STGAP00014774 Get the ealiest approved placement start date for the person in this case. 
            dtRemoval = personDAO.findEarliestAprvDtPlcmntByIdPerson(idPersonTemp, idCase);
          }

          if (cdPersonCitizenshipMap != null) {
            medicaidApplicationRetrieveSO
                                         .setCitizenship((String) cdPersonCitizenshipMap.get("cdPersonCitizenship") != null ? (String) cdPersonCitizenshipMap
                                                                                                                                                             .get("cdPersonCitizenship")
                                                                                                                           : " ");
          } else {
            medicaidApplicationRetrieveSO.setCitizenship("");
          }
          medicaidApplicationRetrieveSO.setRace(cdRace != null ? cdRace : " ");
          
          medicaidApplicationRetrieveSO.setRemvDate(dtRemoval);

          List<Characteristics> characteristicList = personDAO.findCdCharacteristicByIdPerson(idPersonTemp);
          if (!characteristicList.isEmpty() && characteristicList != null) {
            for (Iterator<Characteristics> itChar = characteristicList.iterator(); itChar.hasNext();) {
              Characteristics characteristic = itChar.next();
              String cdCharacteristic = characteristic.getCdCharacteristic();
              Date dtCharEnd = characteristic.getDtCharEnd();
              if (cdCharacteristic != null) {
                if ((cdCharacteristic.equals(CodesTables.CPM_62)) && DateHelper.MAX_JAVA_DATE.equals(dtCharEnd)) {
                  medicaidApplicationRetrieveSO.setChildPregnancy("Yes");
                  break;
                } else {
                  medicaidApplicationRetrieveSO.setChildPregnancy("No");
                }
              } else {
                medicaidApplicationRetrieveSO.setChildPregnancy("No");
              }
            }
          } else {
            medicaidApplicationRetrieveSO.setChildPregnancy("No");
          }
          // Get the Home County of the child from the Legal status table
          LegalStatus legalStatus = legalStatusDAO.findMostRecentLegalStatusByIdPerson(idPerson);
          if (legalStatus != null) {
            medicaidApplicationRetrieveSO.setCounty(legalStatus.getCdLegalStatCnty());
          }
        }
      }
    }
    if (idPerson != 0) {
      java.util.GregorianCalendar tempCal = new java.util.GregorianCalendar();
      tempCal.setTime(new Date());
      int firstDayOfMonth = tempCal.getActualMinimum(java.util.GregorianCalendar.DATE);
      tempCal.set(java.util.GregorianCalendar.DATE, firstDayOfMonth);
      Date currentMonthStartDate = tempCal.getTime();
      Date currentMonthEndDate = DateHelper.addToDate(DateHelper.getLastDayOfTheMonth(new Date()), 0, 0, 1);
      List<Map> incomeList = incomeAndResourcesDAO.findIncomeAndResourcesByIdPerson(idPerson, currentMonthStartDate, currentMonthEndDate);
      List<IncomeResourceMedicaidSI> incomeResourceList = new ArrayList<IncomeResourceMedicaidSI>();
      if (!incomeList.isEmpty() || incomeList != null) {
        for (Iterator<Map> mapIt = incomeList.iterator(); mapIt.hasNext();) {
          Map mapIncome = mapIt.next();
          IncomeResourceMedicaidSI incomeResource = new IncomeResourceMedicaidSI();
          incomeResource
                        .setCdIncRsrcIncome((String) mapIncome.get("cdIncRsrcIncome") != null ? (String) mapIncome
                                                                                                                  .get("cdIncRsrcIncome")
                                                                                             : " ");
          incomeResource
                        .setCdIncRsrcType((String) mapIncome.get("cdIncRsrcType") != null ? (String) mapIncome
                                                                                                              .get("cdIncRsrcType")
                                                                                         : " ");
          incomeResource.setAmtIncRsrc((Double) mapIncome.get("amtIncRsrc") != 0 ? (Double) mapIncome.get("amtIncRsrc")
                                                                                : 0.0);
          incomeResource
                        .setSdsIncRsrcSource((String) mapIncome.get("sdsIncRsrcSourc") != null ? (String) mapIncome
                                                                                                                   .get("sdsIncRsrcSourc")
                                                                                              : " ");
          incomeResource
                        .setIndIncRsrcNotAccess((String) mapIncome.get("indIncRsrcNotAccessc") != null ? (String) mapIncome
                                                                                                                           .get("indIncRsrcNotAccessc")
                                                                                                      : " ");
          incomeResource
                        .setSdsIncRsrcVerfMethod((String) mapIncome.get("sdsIncRsrcVerfMethod") != null ? (String) mapIncome
                                                                                                                            .get("sdsIncRsrcVerfMethod")
                                                                                                       : " ");
          incomeResourceList.add(incomeResource);
        }
        medicaidApplicationRetrieveSO.setIncomeResourceList(incomeResourceList);
      }
    }
    if (medicaidApplicationRetrieveSI.getUlIdStage() != 0 && medicaidApplicationRetrieveSI.getUlIdCase() != 0) {

      List<Map> principleList = personDAO.findPrinciples(medicaidApplicationRetrieveSI.getUlIdStage(),
                                                         medicaidApplicationRetrieveSI.getUlIdCase());
      List<PrincipalsList> principalsList = new ArrayList<PrincipalsList>();
      List<PrincipalsList> allPrincipalsList = new ArrayList<PrincipalsList>();

      List<Map> indParentList = new ArrayList<Map>();
      indParentList = initialMedicaidAppDAO.findIndParent(medicaidApplicationRetrieveSI.getUlIdStage(),
                                                          medicaidApplicationRetrieveSI.getUlIdCase(), idEvent);

      if (!principleList.isEmpty() || principleList != null) {
        for (Iterator<Map> mapIt = principleList.iterator(); mapIt.hasNext();) {
          Map mapPerson = mapIt.next();
          PrincipalsList principal = new PrincipalsList();

          principal
                   .setNmPrincipals((String) mapPerson.get("nmPersonFull") != null ? (String) mapPerson
                                                                                                       .get("nmPersonFull")
                                                                                  : " ");
          principal
                   .setCdStagePersRelInt((String) mapPerson.get("cdStagePersRelInt") != null ? (String) mapPerson
                                                                                                                 .get("cdStagePersRelInt")
                                                                                            : " ");
          principal.setDob((Date) mapPerson.get("dtPersonBirth"));
          principal
                   .setAddrPersonStLn1((String) mapPerson.get("addrPersonStLn1") != null ? (String) mapPerson
                                                                                                             .get("addrPersonStLn1")
                                                                                        : " ");
          principal
                   .setAddrPersonCity((String) mapPerson.get("addrPersonCity") != null ? (String) mapPerson
                                                                                                           .get("addrPersonCity")
                                                                                      : " ");
          principal
                   .setAddrPersonZip((String) mapPerson.get("addrPersonZip") != null ? (String) mapPerson
                                                                                                         .get("addrPersonZip")
                                                                                    : " ");
          principal
                   .setCdPersonState((String) mapPerson.get("cdPersonState") != null ? (String) mapPerson
                                                                                                         .get("cdPersonState")
                                                                                    : " ");
          principal
                   .setCdPersonMaritalStatus((String) mapPerson.get("cdPersonMaritalStatus") != null ? (String) mapPerson
                                                                                                                         .get("cdPersonMaritalStatus")
                                                                                                    : " ");

          int idPersonTemp = Integer.parseInt(((Integer) mapPerson.get("idPerson")).toString());
          principal.setIdPerson(idPersonTemp);
          String cdRace = personDAO.findcdRaceByIdPerson(idPersonTemp);
          String nbrPersonIdNumber = personDAO.findNbrPersonByIdPerson(idPersonTemp);
          String indPersonPaternityEst = personDAO.findIndPersonPaternityEstByIdPerson(idPersonTemp);
          principal.setRace(cdRace != null ? cdRace : " ");
          principal.setNbrPersonIdNumber(nbrPersonIdNumber != null ? nbrPersonIdNumber : " ");
          principal.setIndPersonPaternityEst(indPersonPaternityEst != null ? indPersonPaternityEst : "");
          if (!indParentList.isEmpty() || indParentList != null) {
            for (Iterator<Map> mapParentIt = indParentList.iterator(); mapParentIt.hasNext();) {
              Map mapParent = mapParentIt.next();
              int idPersonParent = Integer.parseInt(((Integer) mapParent.get("idPerson")).toString());
              if (idPersonTemp == idPersonParent) {
                principal.setIndParent((String) mapParent.get("indParent"));
              }
            }
          } else {
            principal.setIndParent("");
          }

          if ("PRN".equals((String) mapPerson.get("cdStagePersType"))
              && !("SL".equals((String) mapPerson.get("cdStagePersRelInt")))) {
            principalsList.add(principal);
          }
          if ("PRN".equals((String) mapPerson.get("cdStagePersType"))) {
            allPrincipalsList.add(principal);
          }
        }
      }
      
      // hjbaptiste - This is for closed converted cases where an event wasn't created. The elements on the page need to be disabled
      // if the case was closed when converted and it was never opened in SHINES.
      Stage stage = stageDAO.findStageByIdStage( medicaidApplicationRetrieveSI.getUlIdStage());
      medicaidApplicationRetrieveSO.setStageIsClosed(stage.getDtStageClose() == null ? false : true);
      medicaidApplicationRetrieveSO.setPrincipalsBeanList(principalsList);
      medicaidApplicationRetrieveSO.setAllPrincipalsBeanList(allPrincipalsList);
    }
    // STGAP00006202: Name of the case Manager signed is being reset to the name of the case manger logged in.
    // This is being commented out.
    // String caseManager = personDAO.findNmFullByIdPerson(medicaidApplicationRetrieveSI.getUlIdPerson());
    // medicaidApplicationRetrieveSO.setNmCaseManager(caseManager);
    return medicaidApplicationRetrieveSO;
  }

  public String retrieveStageCountyByStageId(int idStage) {
    Stage stage = stageDAO.findStageByIdStage(idStage);
    return stage.getCdStageCnty();
  }

  public int retrieveIdEventFromEvent(int idStage) {
    Integer idEventObject = eventDAO.retrieveIdEventFromEvent(idStage);
    int idEvent = 0;
    if (idEventObject != null) {
      idEvent = Integer.parseInt(idEventObject.toString());
    }

    return idEvent;
  }

  @SuppressWarnings( { "unchecked" })
  public List retrieveEventByIdEvent(int idEvent) {
    Event event = eventDAO.findEventByIdEvent(idEvent);
    List eventList = new ArrayList();
    eventList.add(event.getCdEventStatus());
    eventList.add(event.getCdTask());
    eventList.add(event.getDtLastUpdate());
    eventList.add(event.getDtEventOccurred());
    return eventList;
  }
}
