package gov.georgia.dhr.dfcs.sacwis.service.person.impl;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.dao.CsupParentOutboundDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EligibilityDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EmployeeDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.IncomeAndResourcesDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.NameDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonAddressDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonIdDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonPhoneDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonRaceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CsupParentOutbound;
import gov.georgia.dhr.dfcs.sacwis.db.Eligibility;
import gov.georgia.dhr.dfcs.sacwis.db.Employee;
import gov.georgia.dhr.dfcs.sacwis.db.IncomeAndResources;
import gov.georgia.dhr.dfcs.sacwis.db.Name;
import gov.georgia.dhr.dfcs.sacwis.db.PersonAddress;
import gov.georgia.dhr.dfcs.sacwis.db.PersonPhone;
import gov.georgia.dhr.dfcs.sacwis.db.PersonRace;
import gov.georgia.dhr.dfcs.sacwis.service.common.InterfaceServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.person.CalculatePerDiem;
import gov.georgia.dhr.dfcs.sacwis.service.person.SaveCsupParentDemographicInfo;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SaveCsupParentDemographicInfoSI;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * SaveCsupParentDemographicInfoImpl
 * 
 * @author Kalpana Thirumurthy
 * @version 1.0
 * 
 * <pre>
 *              Change History:
 *              Date      User              Description
 *              --------  ----------------  --------------------------------------------------
 * </pre>
 */

public class SaveCsupParentDemographicInfoImpl extends BaseServiceImpl implements SaveCsupParentDemographicInfo {

  // Create local references to DAO's used for the CSUPParent
  private CalculatePerDiem calculatePerDiem = null;

  private CsupParentOutboundDAO csupParentDAO = null;

  private EligibilityDAO eligibilityDAO = null;

  private EmployeeDAO employeeDAO = null;

  private IncomeAndResourcesDAO incomeAndResourcesDAO = null;

  private NameDAO nameDAO = null;

  private PersonDAO personDAO = null;

  private PersonAddressDAO personAddressDAO = null;

  private PersonIdDAO personIdDAO = null;

  private PersonPhoneDAO personPhoneDAO = null;

  private PersonRaceDAO personRaceDAO = null;

  private StageDAO stageDAO = null;

  private StagePersonLinkDAO stagePersonLinkDAO = null;

  // Create setters to set the current DAO instance to the local reference/s
  public void setCalculatePerDiem(CalculatePerDiem calculatePerDiem) {
    this.calculatePerDiem = calculatePerDiem;
  }

  public void setCsupParentOutboundDAO(CsupParentOutboundDAO csupParentDAO) {
    this.csupParentDAO = csupParentDAO;
  }

  public void setEligibilityDAO(EligibilityDAO eligibilityDAO) {
    this.eligibilityDAO = eligibilityDAO;
  }

  public void setEmployeeDAO(EmployeeDAO employeeDAO) {
    this.employeeDAO = employeeDAO;
  }

  public void setIncomeAndResourcesDAO(IncomeAndResourcesDAO incomeAndResourcesDAO) {
    this.incomeAndResourcesDAO = incomeAndResourcesDAO;
  }

  public void setNameDAO(NameDAO nameDAO) {
    this.nameDAO = nameDAO;
  }

  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }

  public void setPersonAddressDAO(PersonAddressDAO personAddressDAO) {
    this.personAddressDAO = personAddressDAO;
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

  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  /**
   * Method used to save data for the Outbound web Service for Stars parent demographic update This method is called by
   * all others services when an update takes place to the Demographic information of the parent. Services that call
   * this service are (is not inclusive): SaveIncomeAndResourcesImpl, SaveNameImpl, SaveAddressListDetailImpl,
   * SavePhoneListDetailImpl, SavePersonDetailImpl, SavePersonIdentifiersImpl This method in turn calls helpers methods
   * for each of the DAO calls and also to persorm the required business logic before it sets the csupParentUpdate
   * object, which finally calls the CSUPParentOutboundDAO to make the final insert in the csup_parent_outbound table
   * 
   * @param context
   *                Accepts the SI object as the input Returns the number of rows inserted returns 0 rows if the insert
   *                failed. If failed to insert then throw a service exception in the same service that calls the
   *                current service and that triggers a rollback
   */

  public int saveCsupParentDemographicInfo(SaveCsupParentDemographicInfoSI saveCsupParentDemographicInfoSI,
                                           String service, String szCdScrDataAction) {

    CsupParentOutbound csupParentUpdate = new CsupParentOutbound();
    IncomeAndResources incRsrcObj = (InterfaceServiceConstants.SAVE_PERSON_INCOME_AND_RESOURCES_DETAIL.equals(service) ? null
                                                                                                                      : retrievePersonIncomeAndResourceDetails(saveCsupParentDemographicInfoSI));
    Name nameObj = (InterfaceServiceConstants.SAVE_PERSON_NAME_DETAIL.equals(service) ? null
                                                                                     : retrievePersonNameDetails(saveCsupParentDemographicInfoSI));
    PersonAddress personAddrObj = (InterfaceServiceConstants.SAVE_PERSON_ADDRESS_DETAIL.equals(service) ? null
                                                                                                       : retrievePersonAddressDetails(saveCsupParentDemographicInfoSI));
    Object[] personIdParentCrsIdObj = (InterfaceServiceConstants.SAVE_PERSON_IDENTIFIERS_DETAIL.equals(service) ? null
                                                                                                               : retrievePersonIdParentCrsIdDetails(saveCsupParentDemographicInfoSI));
    Object[] personIdParentSsnObj = (InterfaceServiceConstants.SAVE_PERSON_IDENTIFIERS_DETAIL.equals(service) ? null
                                                                                                             : retrievePersonIdParentSsnDetails(saveCsupParentDemographicInfoSI));
    PersonPhone personPhoneObj = (InterfaceServiceConstants.SAVE_PERSON_PHONE_DETAIL.equals(service) ? null
                                                                                                    : retrievePersonPhoneDetails(saveCsupParentDemographicInfoSI));
    PersonRace personRaceObj = (InterfaceServiceConstants.SAVE_PERSON_RACE_DETAIL.equals(service) ? null
                                                                                                 : retrievePersonRaceDetails(saveCsupParentDemographicInfoSI));
    Date personDobObj = null;
    if (null != saveCsupParentDemographicInfoSI) {
      if (null == saveCsupParentDemographicInfoSI.getDtNoncustDob()) {
        personDobObj = retrievePersonDobDetails(saveCsupParentDemographicInfoSI);
      }
      if (null == saveCsupParentDemographicInfoSI.getCdCrsNoncustRace()) {
        personRaceObj = retrievePersonRaceDetails(saveCsupParentDemographicInfoSI);
      }
    } else {
      personDobObj = retrievePersonDobDetails(saveCsupParentDemographicInfoSI);
      personRaceObj = retrievePersonRaceDetails(saveCsupParentDemographicInfoSI);
    }
    Object[] stagePersonLinkObj = retrieveStagePersonLinkDetails(saveCsupParentDemographicInfoSI);
    Employee employeeObj = retrieveEmployeeDetails(stagePersonLinkObj);
    Object[] caseObj = null;
    String childMedClassOfAss = null;
    HashMap callCalculatePerDiemMonth = null;
    Eligibility eligCsupSend = null;
    int rowInserted = 0;

    // get the id_person of the children for the parent
    List<Integer> stageForIdPerson = retrieveStageDetailsForPerson(saveCsupParentDemographicInfoSI);
    if (null != stageForIdPerson) {
      if (stageForIdPerson.size() > 1) {
        String childrenCount = Integer.toString(stageForIdPerson.size());
      }
      for (int i = 0; i <= stageForIdPerson.size() - 1; i++) {
        int childStageId = stageForIdPerson.get(i);
        String idPersonForChild = retrieveIdPersonForChildDetails(childStageId);

        if (null != idPersonForChild) {
          eligCsupSend = eligibilityDAO
                                       .findDistinctEligibilityByIdPersonAndIndCsupSend(Integer
                                                                                               .valueOf(
                                                                                                        idPersonForChild)
                                                                                               .intValue());
        }
        if (null != eligCsupSend) {
          if (InterfaceServiceConstants.CSUP_FLAG_Y.equals(eligCsupSend.getIndEligCsupSend())) {
            caseObj = retrieveCaseDetails(idPersonForChild);
            childMedClassOfAss = retrieveChildCOADetails(idPersonForChild);
            callCalculatePerDiemMonth = retrieveCalculatePerDiem(idPersonForChild);
            Object[] personIdChildCrsIdObj = (InterfaceServiceConstants.SAVE_PERSON_IDENTIFIERS_DETAIL.equals(service)
                                              && saveCsupParentDemographicInfoSI.getNbrChildCrsId() != 0 ? null
                                                                                                        : retrievePersonIdChildCrsIdDetails(idPersonForChild));
            csupParentUpdate = setObjectValue(incRsrcObj, nameObj, personAddrObj, personIdParentCrsIdObj,
                                              personIdParentSsnObj, personIdChildCrsIdObj, personPhoneObj,
                                              personRaceObj, personDobObj, stagePersonLinkObj, employeeObj, caseObj,
                                              childMedClassOfAss, callCalculatePerDiemMonth,
                                              saveCsupParentDemographicInfoSI, service,
                                              eligCsupSend.getCdEligSelected(), szCdScrDataAction);

            rowInserted = insertParentUpdateInfo(csupParentUpdate);
            if (0 == rowInserted) {
              throw new ServiceException(Messages.MSG_NO_ROWS_RETURNED);
            }
          }
        }
      }
    }
    return rowInserted;
  }

  // Helper methods that makes calls to the appropriate DAO's to get the data that is required to
  // insert into the csup_parent_outbound table
  private IncomeAndResources retrievePersonIncomeAndResourceDetails(
                                                                    SaveCsupParentDemographicInfoSI saveCsupParentDemographicInfoSI) {
    IncomeAndResources incRsrc = null;
    if (null != saveCsupParentDemographicInfoSI) {
      if (null != (Integer.toString(saveCsupParentDemographicInfoSI.getIdPersonId())))
        incRsrc = incomeAndResourcesDAO
                                       .findDistinctIncomeAndResourcesInfo(saveCsupParentDemographicInfoSI
                                                                                                          .getIdPersonId());
    }
    return incRsrc;
  }

  private Name retrievePersonNameDetails(SaveCsupParentDemographicInfoSI saveCsupParentDemographicInfoSI) {
    Name nameDet = null;
    if (null != saveCsupParentDemographicInfoSI) {
      if (null != (Integer.toString(saveCsupParentDemographicInfoSI.getIdPersonId())))
        nameDet = (Name) nameDAO.findDistinctNameByIdPerson(saveCsupParentDemographicInfoSI.getIdPersonId());
    }
    return nameDet;
  }

  private PersonAddress retrievePersonAddressDetails(SaveCsupParentDemographicInfoSI saveCsupParentDemographicInfoSI) {
    PersonAddress pAddr = null;
    if (null != saveCsupParentDemographicInfoSI) {
      if (null != (Integer.toString(saveCsupParentDemographicInfoSI.getIdPersonId())))
        pAddr = personAddressDAO.findPrimaryPersonAddressByIdPerson(saveCsupParentDemographicInfoSI.getIdPersonId());
    }
    return pAddr;
  }

  private Object[] retrievePersonIdParentCrsIdDetails(SaveCsupParentDemographicInfoSI saveCsupParentDemographicInfoSI) {
    Object[] personIdParentCrsIdObj = null;
    if (null != saveCsupParentDemographicInfoSI) {
      if (null != (Integer.toString(saveCsupParentDemographicInfoSI.getIdPersonId())))
        personIdParentCrsIdObj = personIdDAO
                                            .findDistinctParentNbrPersonIdCrsIdByIdPerson(saveCsupParentDemographicInfoSI
                                                                                                                         .getIdPersonId());
    }
    return personIdParentCrsIdObj;
  }

  private Object[] retrievePersonIdParentSsnDetails(SaveCsupParentDemographicInfoSI saveCsupParentDemographicInfoSI) {
    Object[] personIdSsnObj = null;
    if (null != saveCsupParentDemographicInfoSI) {
      if (null != (Integer.toString(saveCsupParentDemographicInfoSI.getIdPersonId())))
        personIdSsnObj = personIdDAO
                                    .findDistinctParentNbrPersonIdSsnByIdPerson(saveCsupParentDemographicInfoSI
                                                                                                               .getIdPersonId());
    }
    return personIdSsnObj;
  }

  private Object[] retrievePersonIdChildCrsIdDetails(String idPersonForChild) {
    Object[] personIdChildCrsIdObj = null;
    if (null != idPersonForChild) {
      personIdChildCrsIdObj = personIdDAO
                                         .findDistinctChildNbrPersonIdCrsIdByIdPerson((Integer
                                                                                              .valueOf(idPersonForChild))
                                                                                                                         .intValue());
    }
    return personIdChildCrsIdObj;
  }

  private PersonPhone retrievePersonPhoneDetails(SaveCsupParentDemographicInfoSI saveCsupParentDemographicInfoSI) {
    PersonPhone pPhone = null;
    if (null != saveCsupParentDemographicInfoSI) {
      if (null != (Integer.toString(saveCsupParentDemographicInfoSI.getIdPersonId())))
        pPhone = personPhoneDAO.findDistinctPersonPhoneByIdPerson(saveCsupParentDemographicInfoSI.getIdPersonId());
    }
    return pPhone;
  }

  private PersonRace retrievePersonRaceDetails(SaveCsupParentDemographicInfoSI saveCsupParentDemographicInfoSI) {
    PersonRace pRace = null;
    if (null != saveCsupParentDemographicInfoSI) {
      if (null != (Integer.toString(saveCsupParentDemographicInfoSI.getIdPersonId())))
        pRace = personRaceDAO.findDistinctPersonRaceByIdPerson(saveCsupParentDemographicInfoSI.getIdPersonId());
    }
    return pRace;
  }

  private Date retrievePersonDobDetails(SaveCsupParentDemographicInfoSI saveCsupParentDemographicInfoSI) {
    Date pDob = null;
    if (null != saveCsupParentDemographicInfoSI) {
      if (null != (Integer.toString(saveCsupParentDemographicInfoSI.getIdPersonId())))
        pDob = personDAO.findDateOfBirthByIdPerson(saveCsupParentDemographicInfoSI.getIdPersonId());
    }
    return pDob;
  }

  private Object[] retrieveStagePersonLinkDetails(SaveCsupParentDemographicInfoSI saveCsupParentDemographicInfoSI) {
    Object[] pLink = null;
    if (null != saveCsupParentDemographicInfoSI) {
      if (null != (Integer.toString(saveCsupParentDemographicInfoSI.getIdPersonId())))
        pLink = stagePersonLinkDAO.findIdPersonByIdStagePersRole(saveCsupParentDemographicInfoSI.getIdPersonId());
    }
    return pLink;
  }

  private Employee retrieveEmployeeDetails(Object[] stagePersonLinkObj) {
    Employee emp = null;
    if (null != stagePersonLinkObj) {
      if (null != stagePersonLinkObj[0])
        emp = employeeDAO.findEmployeeByIdPerson(Integer.valueOf(stagePersonLinkObj[0].toString()).intValue());
    }
    return emp;
  }

  private String retrieveChildCOADetails(String idPersonForChild) {
    String childCOA = null;
    if (null != idPersonForChild) {
      childCOA = eligibilityDAO.findDistinctChildCOAByIdPerson(Integer.valueOf(idPersonForChild).intValue());
    }
    return childCOA;
  }

  private List<Integer> retrieveStageDetailsForPerson(SaveCsupParentDemographicInfoSI saveCsupParentDemographicInfoSI) {
    List<Integer> stageDet = null;
    if (null != saveCsupParentDemographicInfoSI) {
      if (null != (Integer.toString(saveCsupParentDemographicInfoSI.getIdPersonId())))
        stageDet = stagePersonLinkDAO
                                     .findIdStageByIdPersonParentForPerDiem(saveCsupParentDemographicInfoSI
                                                                                                           .getIdPersonId());
    }
    return stageDet;
  }

  private Object[] retrieveCaseDetails(String idPersonForChild) {
    Object[] caseIdForChild = null;
    if (null != idPersonForChild) {
      caseIdForChild = stagePersonLinkDAO.findCaseIdByChildIdPerson((Integer.valueOf(idPersonForChild)).intValue());
    }
    return caseIdForChild;
  }

  private String retrieveIdPersonForChildDetails(int childStageId) {
    String childIdPersonDet = null;
    if (null != String.valueOf(childStageId)) {
      int tempChildIdPersonDet = stagePersonLinkDAO.findIdPersonForChildByIdStage(childStageId);
      childIdPersonDet = Integer.toString(tempChildIdPersonDet);
    }
    return childIdPersonDet;
  }

  private HashMap retrieveCalculatePerDiem(String idPersonForChild) {
    HashMap perDiemInfo = null;
    if (null != idPersonForChild) {
      calculatePerDiem.callCalculatePerDiem(idPersonForChild);
    }
    return perDiemInfo;
  }

  private int insertParentUpdateInfo(CsupParentOutbound csupParentUpdate) {
    // call the csupDAO to do the insert
    return csupParentDAO.saveCsupParentOutboundTable(csupParentUpdate);
  }

  private CsupParentOutbound setObjectValue(IncomeAndResources incRsrcObj, Name nameObj, PersonAddress personAddrObj,
                                            Object[] personIdParentCrsIdObj, Object[] personIdParentSsnObj,
                                            Object[] personIdChildCrsIdObj, PersonPhone personPhoneObj,
                                            PersonRace personRaceObj, Date personDobObj, Object[] stagePersonLinkObj,
                                            Employee employeeObj, Object[] caseObj, String childMedClassOfAss,
                                            HashMap callCalculatePerDiemMonth,
                                            SaveCsupParentDemographicInfoSI saveCsupParentDemographicInfoSI,
                                            String service, String eligibilityType, String szCdScrDataAction) {

    CsupParentOutbound csupParentUpdate = new CsupParentOutbound();

    if (null != incRsrcObj) {
      if (InterfaceServiceConstants.INC_RSRC_TYPE_SSI.equals(incRsrcObj.getCdIncRsrcType())) {
        csupParentUpdate.setIndSsiNoncust(InterfaceServiceConstants.SSI_NON_CUST_FLAG_Y);
      } else {
        csupParentUpdate.setIndSsiNoncust(InterfaceServiceConstants.SSI_NON_CUST_FLAG_N);
      }
      if (null != incRsrcObj.getCdIncRsrcType()
          && InterfaceServiceConstants.INC_RSRC_DESC_GRS.equals(incRsrcObj.getCdIncRsrcType())) {
        csupParentUpdate
                        .setTxtIncRsrcDesc(null != incRsrcObj.getTxtIncRsrcDesc() ? incRsrcObj.getTxtIncRsrcDesc() : "");
        csupParentUpdate.setTxtIncRsrcSrcAddrStLn1(buildMax25LengthString(incRsrcObj.getTxtIncRsrcSrcAddrStLn1()));
        csupParentUpdate.setTxtIncRsrcSrcAddrStLn2(buildMax25LengthString(incRsrcObj.getTxtIncRsrcSrcAddrStLn2()));
        csupParentUpdate
                        .setTxtIncRsrcSrcAddrState(null != incRsrcObj.getTxtIncRsrcSrcAddrState() ? incRsrcObj
                                                                                                              .getTxtIncRsrcSrcAddrState()
                                                                                                 : "");
        csupParentUpdate
                        .setTxtIncRsrcSrcAddrCity(null != incRsrcObj.getTxtIncRsrcSrcAddrCity() ? incRsrcObj
                                                                                                            .getTxtIncRsrcSrcAddrCity()
                                                                                               : "");
        csupParentUpdate
                        .setTxtIncRsrcSrcAddrZip(null != incRsrcObj.getTxtIncRsrcSrcAddrZip() ? incRsrcObj
                                                                                                          .getTxtIncRsrcSrcAddrZip()
                                                                                             : "");
      }
    } else {
      if (null != saveCsupParentDemographicInfoSI) {
        if (InterfaceServiceConstants.SAVE_PERSON_INCOME_AND_RESOURCES_DETAIL.equals(service)
            && null != saveCsupParentDemographicInfoSI.getDtCsupparRequested()) {
          csupParentUpdate.setDtCsupparRequested(saveCsupParentDemographicInfoSI.getDtCsupparRequested());
        }
        if (InterfaceServiceConstants.INC_RSRC_TYPE_SSI.equals((saveCsupParentDemographicInfoSI.getIndIncRsrcType()))
            && (InterfaceServiceConstants.END_DATE_CHECK
                                                        .equals((saveCsupParentDemographicInfoSI.getDtRsrcTo()
                                                                                                              .toString())) || null == saveCsupParentDemographicInfoSI
                                                                                                                                                                      .getDtRsrcTo())) {
          csupParentUpdate.setIndSsiNoncust(InterfaceServiceConstants.SSI_NON_CUST_FLAG_Y);
        } else {
          csupParentUpdate.setIndSsiNoncust(InterfaceServiceConstants.SSI_NON_CUST_FLAG_N);
        }
        if (null != saveCsupParentDemographicInfoSI.getIndIncRsrcType()
            && InterfaceServiceConstants.INC_RSRC_DESC_GRS
                                                          .equals((saveCsupParentDemographicInfoSI.getIndIncRsrcType()))) {
          csupParentUpdate
                          .setTxtIncRsrcDesc(null != saveCsupParentDemographicInfoSI.getTxtIncRsrcDesc() ? saveCsupParentDemographicInfoSI
                                                                                                                                          .getTxtIncRsrcDesc()
                                                                                                        : "");
          csupParentUpdate
                          .setTxtIncRsrcSrcAddrStLn1(buildMax25LengthString(saveCsupParentDemographicInfoSI
                                                                                                           .getTxtIncRsrcSrcAddrStLn1()));
          csupParentUpdate
                          .setTxtIncRsrcSrcAddrStLn2(buildMax25LengthString(saveCsupParentDemographicInfoSI
                                                                                                           .getTxtIncRsrcSrcAddrStLn2()));
          csupParentUpdate
                          .setTxtIncRsrcSrcAddrState(null != saveCsupParentDemographicInfoSI
                                                                                            .getTxtIncRsrcSrcAddrState() ? saveCsupParentDemographicInfoSI
                                                                                                                                                          .getTxtIncRsrcSrcAddrState()
                                                                                                                        : "");
          csupParentUpdate
                          .setTxtIncRsrcSrcAddrCity(null != saveCsupParentDemographicInfoSI.getTxtIncRsrcSrcAddrCity() ? saveCsupParentDemographicInfoSI
                                                                                                                                                        .getTxtIncRsrcSrcAddrCity()
                                                                                                                      : "");
          csupParentUpdate
                          .setTxtIncRsrcSrcAddrZip(null != saveCsupParentDemographicInfoSI.getTxtIncRsrcSrcAddrZip() ? saveCsupParentDemographicInfoSI
                                                                                                                                                      .getTxtIncRsrcSrcAddrZip()
                                                                                                                    : "");
        }
      }
    }
    if (null != nameObj) {
      csupParentUpdate.setNmNoncustFirst(null != nameObj.getNmNameFirst() ? nameObj.getNmNameFirst() : "");
      csupParentUpdate.setNmNoncustLast(null != nameObj.getNmNameLast() ? nameObj.getNmNameLast() : "");
      csupParentUpdate.setNmNoncustMiddle(null != nameObj.getNmNameMiddle() ? nameObj.getNmNameMiddle() : "");
    } else {
      if (null != saveCsupParentDemographicInfoSI) {
        if (InterfaceServiceConstants.SAVE_PERSON_NAME_DETAIL.equals(service)
            && null != saveCsupParentDemographicInfoSI.getDtCsupparRequested()) {
          csupParentUpdate.setDtCsupparRequested(saveCsupParentDemographicInfoSI.getDtCsupparRequested());
        }
        csupParentUpdate
                        .setNmNoncustFirst(null != saveCsupParentDemographicInfoSI.getNmNoncustFirst() ? saveCsupParentDemographicInfoSI
                                                                                                                                        .getNmNoncustFirst()
                                                                                                      : "");
        csupParentUpdate
                        .setNmNoncustLast(null != saveCsupParentDemographicInfoSI.getNmNoncustLast() ? saveCsupParentDemographicInfoSI
                                                                                                                                      .getNmNoncustLast()
                                                                                                    : "");
        csupParentUpdate
                        .setNmNoncustMiddle(null != saveCsupParentDemographicInfoSI.getNmNoncustMiddle() ? saveCsupParentDemographicInfoSI
                                                                                                                                          .getNmNoncustMiddle()
                                                                                                        : "");
      }
    }
    if (null != personAddrObj) {
      csupParentUpdate.setAddrNoncustAddrStLn1(buildMax25LengthString(personAddrObj.getAddrPersAddrStLn1()));
      csupParentUpdate.setAddrNoncustAddrStLn2(buildMax25LengthString(personAddrObj.getAddrPersAddrStLn2()));
      csupParentUpdate
                      .setAddrNoncustAddrCity(null != personAddrObj.getAddrPersonAddrCity() ? personAddrObj
                                                                                                           .getAddrPersonAddrCity()
                                                                                           : "");
      csupParentUpdate
                      .setCdNoncustAddrState(null != personAddrObj.getCdPersonAddrState() ? personAddrObj
                                                                                                         .getCdPersonAddrState()
                                                                                         : "");
      csupParentUpdate
                      .setAddrNoncustAddrZip(null != personAddrObj.getAddrPersonAddrZip() ? personAddrObj
                                                                                                         .getAddrPersonAddrZip()
                                                                                         : "");
    } else {
      if (null != saveCsupParentDemographicInfoSI) {
        if (InterfaceServiceConstants.SAVE_PERSON_ADDRESS_DETAIL.equals(service)
            && null != saveCsupParentDemographicInfoSI.getDtCsupparRequested()) {
          csupParentUpdate.setDtCsupparRequested(saveCsupParentDemographicInfoSI.getDtCsupparRequested());
        }
        csupParentUpdate
                        .setAddrNoncustAddrStLn1(buildMax25LengthString(saveCsupParentDemographicInfoSI
                                                                                                       .getAddrNoncustAddrStLn1()));
        csupParentUpdate
                        .setAddrNoncustAddrStLn2(buildMax25LengthString(saveCsupParentDemographicInfoSI
                                                                                                       .getAddrNoncustAddrStLn2()));
        csupParentUpdate
                        .setAddrNoncustAddrCity(null != saveCsupParentDemographicInfoSI.getAddrNoncustAddrCity() ? saveCsupParentDemographicInfoSI
                                                                                                                                                  .getAddrNoncustAddrCity()
                                                                                                                : "");
        csupParentUpdate
                        .setCdNoncustAddrState(null != saveCsupParentDemographicInfoSI.getCdNoncustAddrState() ? saveCsupParentDemographicInfoSI
                                                                                                                                                .getCdNoncustAddrState()
                                                                                                              : "");
        csupParentUpdate
                        .setAddrNoncustAddrZip(null != saveCsupParentDemographicInfoSI.getAddrNoncustAddrZip() ? saveCsupParentDemographicInfoSI
                                                                                                                                                .getAddrNoncustAddrZip()
                                                                                                              : "");
      }
    }
    if (null != personIdParentCrsIdObj) {
      if (Integer.valueOf((String) personIdParentCrsIdObj[1]) != null)
        csupParentUpdate.setNbrNoncustCrsId(Integer.valueOf((String) personIdParentCrsIdObj[1]).intValue());
    } else {
      if (null != saveCsupParentDemographicInfoSI) {
        if (Integer.valueOf(saveCsupParentDemographicInfoSI.getNbrNoncustCrsId()) != null)
          csupParentUpdate.setNbrNoncustCrsId(Integer.valueOf(saveCsupParentDemographicInfoSI.getNbrNoncustCrsId())
                                                     .intValue());
        if (InterfaceServiceConstants.SAVE_PERSON_IDENTIFIERS_DETAIL.equals(service)
            && null != saveCsupParentDemographicInfoSI.getDtCsupparRequested()
            && null == csupParentUpdate.getDtCsupparRequested()) {
          csupParentUpdate.setDtCsupparRequested(saveCsupParentDemographicInfoSI.getDtCsupparRequested());
        }
      }
    }
    if (null != personIdParentSsnObj) {
      if ((String) personIdParentSsnObj[1] != null)
        csupParentUpdate.setNbrNoncustNumber((String) personIdParentSsnObj[1]);
    } else {
      if (null != saveCsupParentDemographicInfoSI) {
        if (null != saveCsupParentDemographicInfoSI.getNbrNoncustNumber())
          csupParentUpdate.setNbrNoncustNumber(saveCsupParentDemographicInfoSI.getNbrNoncustNumber());
        if (InterfaceServiceConstants.SAVE_PERSON_IDENTIFIERS_DETAIL.equals(service)
            && null != saveCsupParentDemographicInfoSI.getDtCsupparRequested()
            && null == csupParentUpdate.getDtCsupparRequested()) {
          csupParentUpdate.setDtCsupparRequested(saveCsupParentDemographicInfoSI.getDtCsupparRequested());
        }
      }
    }
    if (null != personIdChildCrsIdObj) {
      if (Integer.valueOf((String) personIdChildCrsIdObj[1]) != null)
        csupParentUpdate.setNbrChildCrsId(Integer.valueOf((String) personIdChildCrsIdObj[1]).intValue());
    } else {
      if (null != saveCsupParentDemographicInfoSI) {
        if (Integer.valueOf(saveCsupParentDemographicInfoSI.getNbrChildCrsId()) != null)
          csupParentUpdate.setNbrChildCrsId(Integer.valueOf(saveCsupParentDemographicInfoSI.getNbrChildCrsId())
                                                   .intValue());
        if (InterfaceServiceConstants.SAVE_PERSON_IDENTIFIERS_DETAIL.equals(service)
            && null != saveCsupParentDemographicInfoSI.getDtCsupparRequested()
            && null == csupParentUpdate.getDtCsupparRequested()) {
          csupParentUpdate.setDtCsupparRequested(saveCsupParentDemographicInfoSI.getDtCsupparRequested());
        }
      }
    }
    if (null != personPhoneObj) {
      csupParentUpdate
                      .setNbrNoncustPhone(null != personPhoneObj.getNbrPersonPhone() ? personPhoneObj
                                                                                                     .getNbrPersonPhone()
                                                                                    : "");
    } else {
      if (null != saveCsupParentDemographicInfoSI) {
        csupParentUpdate
                        .setNbrNoncustPhone(saveCsupParentDemographicInfoSI.getNbrNoncustPhone() != null ? saveCsupParentDemographicInfoSI
                                                                                                                                          .getNbrNoncustPhone()
                                                                                                        : "");
        if (InterfaceServiceConstants.SAVE_PERSON_PHONE_DETAIL.equals(service)
            && null != saveCsupParentDemographicInfoSI.getDtCsupparRequested()) {
          csupParentUpdate.setDtCsupparRequested(saveCsupParentDemographicInfoSI.getDtCsupparRequested());
        }
      }
    }
    if (null != personRaceObj) {
      csupParentUpdate.setCdCrsNoncustRace(null != personRaceObj.getCdRace() ? personRaceObj.getCdRace()
                                                                                            .substring(0, 1) : "");
    } else {
      if (null != saveCsupParentDemographicInfoSI) {
        csupParentUpdate
                        .setCdCrsNoncustRace(null != saveCsupParentDemographicInfoSI.getCdCrsNoncustRace() ? saveCsupParentDemographicInfoSI
                                                                                                                                            .getCdCrsNoncustRace()
                                                                                                                                            .substring(
                                                                                                                                                       0,
                                                                                                                                                       1)
                                                                                                          : "");
        if (InterfaceServiceConstants.SAVE_PERSON_RACE_DETAIL.equals(service)
            && null != saveCsupParentDemographicInfoSI.getDtCsupparRequested()) {
          csupParentUpdate.setDtCsupparRequested(saveCsupParentDemographicInfoSI.getDtCsupparRequested());
        }
      }
    }
    if (null != personDobObj) {
      if (null != personDobObj)
        csupParentUpdate.setDtNoncustDob(personDobObj);
    } else {
      if (null != saveCsupParentDemographicInfoSI) {
        if (null != saveCsupParentDemographicInfoSI.getDtNoncustDob()) {
          csupParentUpdate.setDtNoncustDob(saveCsupParentDemographicInfoSI.getDtNoncustDob());
        }
        if (null != saveCsupParentDemographicInfoSI.getCdCrsNoncustRace()) {
          if (saveCsupParentDemographicInfoSI.getCdCrsNoncustRace().length() > 1) {
            String tmpRace = saveCsupParentDemographicInfoSI.getCdCrsNoncustRace();
            csupParentUpdate
                            .setCdCrsNoncustRace(tmpRace
                                                        .substring((saveCsupParentDemographicInfoSI
                                                                                                   .getCdCrsNoncustRace()
                                                                                                                         .length()) - 1));
          } else {
            csupParentUpdate.setCdCrsNoncustRace(saveCsupParentDemographicInfoSI.getCdCrsNoncustRace());
          }
        }
        if (InterfaceServiceConstants.SAVE_PERSON_BIRTH_DETAIL.equals(service)
            && null != saveCsupParentDemographicInfoSI.getDtCsupparRequested()) {
          csupParentUpdate.setDtCsupparRequested(saveCsupParentDemographicInfoSI.getDtCsupparRequested());
        }
      }
    }
    if (null != stagePersonLinkObj) {
      if (null != stagePersonLinkObj[0])
        csupParentUpdate.setIdInitiator(Integer.valueOf((String) stagePersonLinkObj[0].toString()));
    }
    if (null != callCalculatePerDiemMonth) {
      if (null != callCalculatePerDiemMonth.get(InterfaceServiceConstants.PER_DIEM))
        csupParentUpdate.setNbrPerDiem((Double) callCalculatePerDiemMonth.get(InterfaceServiceConstants.PER_DIEM));
      if (null != callCalculatePerDiemMonth.get(InterfaceServiceConstants.DT_EFF_PER_DIEM))
        csupParentUpdate
                        .setDtEffPerDiem((Date) callCalculatePerDiemMonth
                                                                         .get(InterfaceServiceConstants.DT_EFF_PER_DIEM));
      if (null != callCalculatePerDiemMonth.get(InterfaceServiceConstants.PER_MONTH))
        csupParentUpdate.setNbrPerMonth((Double) callCalculatePerDiemMonth.get(InterfaceServiceConstants.PER_MONTH));
    }
    if (null != employeeObj) {
      csupParentUpdate.setNmCasemanFirst(null != employeeObj.getNmEmployeeFirst() ? employeeObj.getNmEmployeeFirst()
                                                                                 : "");
      csupParentUpdate.setNmCasemanLast(null != employeeObj.getNmEmployeeLast() ? employeeObj.getNmEmployeeLast() : "");
      csupParentUpdate.setNmCasemanMiddle(null != employeeObj.getNmEmployeeMiddle() ? employeeObj.getNmEmployeeMiddle()
                                                                                   : "");
      csupParentUpdate
                      .setAddrCasemanAddrStLn1(buildMax25LengthString(employeeObj.getMailCode().getAddrMailCodeStLn1()));
      csupParentUpdate
                      .setAddrCasemanAddrStLn2(buildMax25LengthString(employeeObj.getMailCode().getAddrMailCodeStLn2()));
      csupParentUpdate
                      .setAddrCasemanAddrCity(null != employeeObj.getMailCode().getAddrMailCodeCity() ? employeeObj
                                                                                                                   .getMailCode()
                                                                                                                   .getAddrMailCodeCity()
                                                                                                     : "");
      //csupParentUpdate.setCdCasemanAddrState(employeeObj.getMailCode());
      csupParentUpdate
                      .setAddrCasemanAddrZip(null != employeeObj.getMailCode().getAddrMailCodeZip() ? employeeObj
                                                                                                                 .getMailCode()
                                                                                                                 .getAddrMailCodeZip()
                                                                                                   : "");
      //csupParentUpdate.setNbrCasemanFax(employeeObj.getMailCode());
      csupParentUpdate
                      .setNbrCasemanPhone(null != employeeObj.getMailCode().getNbrMailCodePhone() ? employeeObj
                                                                                                               .getMailCode()
                                                                                                               .getNbrMailCodePhone()
                                                                                                 : "");
    }
    if (null != childMedClassOfAss) {
      csupParentUpdate.setCdMedClassAsst(null != childMedClassOfAss ? childMedClassOfAss : "");
    }
    if (null != caseObj) {
      csupParentUpdate.setIdCase(Integer.valueOf((String) caseObj[0].toString()));
    } else {
      if (null != Integer.valueOf(saveCsupParentDemographicInfoSI.getIdCase()).toString()) {
        csupParentUpdate.setIdCase(Integer.valueOf(saveCsupParentDemographicInfoSI.getIdCase()));
      }
    }
    csupParentUpdate.setCdEligibilityType(eligibilityType);
    csupParentUpdate.setInterfaceStatus(InterfaceServiceConstants.INTERFACE_STATUS_INITIAL);

    return csupParentUpdate;
  }

  String buildMax25LengthString(String str) {
    return buildNLengthString(buildNonNullString(str), 25);
  }

  String buildNLengthString(String str, int len) {
    String rtString = str;
    if (str.length() > len) {
      rtString = str.substring(0, len);
    }
    return rtString;
  }

  String buildNonNullString(String str) {
    return (str != null ? str.trim() : "");
  }
}