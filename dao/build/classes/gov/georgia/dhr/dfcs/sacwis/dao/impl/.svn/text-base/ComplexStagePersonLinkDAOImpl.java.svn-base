package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.AddressPersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexStagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventPersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.IncomingDetailDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.NameDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonAddressDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonCategoryDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonIdDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonPhoneDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.RelationshipDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.AddressPersonLink;
import gov.georgia.dhr.dfcs.sacwis.db.Name;
import gov.georgia.dhr.dfcs.sacwis.db.PersonId;
import gov.georgia.dhr.dfcs.sacwis.db.PersonPhone;
import gov.georgia.dhr.dfcs.sacwis.db.StagePersonLink;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**Change History:
*    Date        User              Description
*    --------    ----------------  --------------------------------------------------
*   05/25/2010   mxpatel           SMS#50561: added code to delete from Relationship table when a person is deleted                           
*/

public class ComplexStagePersonLinkDAOImpl extends BaseDAOImpl implements ComplexStagePersonLinkDAO {
  private AddressPersonLinkDAO addressPersonLinkDAO = null;

  private NameDAO nameDAO = null;

  private EventPersonLinkDAO eventPersonLinkDAO = null;

  private PersonAddressDAO personAddressDAO = null;

  private PersonCategoryDAO personCategoryDAO = null;

  private PersonDAO personDAO = null;

  private PersonIdDAO personIdDAO = null;

  private PersonPhoneDAO personPhoneDAO = null;

  private StageDAO stageDAO = null;

  private StagePersonLinkDAO stagePersonLinkDAO = null;

  private IncomingDetailDAO incomingDetailDAO = null;
  
  private RelationshipDAO relationshipDAO = null;
  
  public void setRelationshipDAO(RelationshipDAO relationshipDAO) {
    this.relationshipDAO = relationshipDAO;
  } 

  public void setAddressPersonLinkDAO(AddressPersonLinkDAO addressPersonLinkDAO) {
    this.addressPersonLinkDAO = addressPersonLinkDAO;
  }

  public void setNameDAO(NameDAO nameDAO) {
    this.nameDAO = nameDAO;
  }

  public void setPersonAddressDAO(PersonAddressDAO personAddressDAO) {
    this.personAddressDAO = personAddressDAO;
  }

  public void setPersonCategoryDAO(PersonCategoryDAO personCategoryDAO) {
    this.personCategoryDAO = personCategoryDAO;
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

  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public void setIncomingDetailDAO(IncomingDetailDAO incomingDetailDAO) {
    this.incomingDetailDAO = incomingDetailDAO;
  }

  public long countOpenStagesForIdPerson(String openFlag, int idPerson, String cdStagePersRole, String cdStage) {
    if ("O".equals(openFlag)) {
      return stagePersonLinkDAO.countOpenStagesByIdPersonAndIdStage(idPerson, cdStagePersRole, cdStage);
    } else {
      return stagePersonLinkDAO.countStagesByIdPersonAndIdStage(idPerson, cdStagePersRole, cdStage);
    }
  }

  public List<Map> findCallPersonList(String cdIncmgStatus, int idStage, Date dtSysTsQuery) {
    List<Object[]> splInfoList;
    if (CodesTables.CINCMGST_OPN.equals(cdIncmgStatus)) {
      splInfoList = stagePersonLinkDAO.findSPLPersonPersonIDIncmgStatus(idStage, dtSysTsQuery);
    } else {
      dtSysTsQuery = DateHelper.MAX_JAVA_DATE;
      splInfoList = stagePersonLinkDAO.findSPLPersonPersonID(idStage, dtSysTsQuery);      
    }
    if (splInfoList == null || splInfoList.isEmpty()) {
      return null;
    }
    List<Map> results = new ArrayList<Map>(splInfoList.size());
    // Map<String, Object> resultRow = new HashMap<String, Object>();
    for (Iterator<Object[]> it = splInfoList.iterator(); it.hasNext();) {
      Map<String, Object> resultRow = new HashMap<String, Object>();
      Object[] splInfo = it.next();
      resultRow.put("cdStagePersType", splInfo[0]);
      resultRow.put("cdStagePersRole", splInfo[1]);
      // resultRow.put("nmPersHistFull", splInfo[2]);
      resultRow.put("nmPersonFull", splInfo[2]);
      resultRow.put("dtPersHistBirth", splInfo[3]);
      resultRow.put("nbrPersHistAge", splInfo[4]);
      resultRow.put("cdPersHistSex", splInfo[5]);
      resultRow.put("cdStagePersRelInt", splInfo[6]);
      resultRow.put("indStagePersReporter", splInfo[7]);
      resultRow.put("cdStagePersSearchInd", splInfo[8]);
      resultRow.put("dtPersHistDeath", splInfo[9]);
      resultRow.put("cdPersHistDeath", splInfo[10]);
      resultRow.put("cdPersHistMaritalStat", splInfo[11]);
      resultRow.put("cdPersHistLanguage", splInfo[12]);
      resultRow.put("cdDisasterRlf", splInfo[13]);
      resultRow.put("cdPersHistEthnic", splInfo[14]);
      resultRow.put("txtStagePersNotes", splInfo[15]);
      resultRow.put("idStage", splInfo[16]);
      int idPerson = (Integer) splInfo[17]; // assume that this is non-null
      resultRow.put("idPerson", idPerson);
      resultRow.put("nbrPersonIdNumber", splInfo[18]);
      resultRow.put("idPersonId", splInfo[19]);
      resultRow.put("indPersonIdInvalid", splInfo[20]);
      resultRow.put("dtPersonIdStart", splInfo[21]);
      resultRow.put("dtPersonIdEnd", splInfo[22]);
      resultRow.put("descPersonId", splInfo[23]);
      resultRow.put("indPersHistDobApprox", splInfo[24]);
      resultRow.put("indStagePersInLaw", splInfo[25]);
      resultRow.put("cdStagePersLstSort", splInfo[26]);

      resultRow.put("cdNameSuffix", splInfo[27]);
      resultRow.put("cdPersonTitle", splInfo[28]);
      resultRow.put("indPersonUsCitizen", splInfo[29]);
      resultRow.put("cdPersonImmigrationStatus", splInfo[30]);
      resultRow.put("cdPersonCountryOrigin", splInfo[31]);
      resultRow.put("cdPersonProofCitizenship", splInfo[32]);
      resultRow.put("cdMatchType", splInfo[33]);
      resultRow.put("txtOtherRelationships", splInfo[34]);
      resultRow.put("cdPkHshdMember", splInfo[35]);
      resultRow
               .put("addressPersonLink", addressPersonLinkDAO.findAddressPersonLinkByIdPersonDtSysTsQuery(idPerson,
                                                                                                          dtSysTsQuery));
      resultRow.put("name", nameDAO.findNameByIdPersonDtSysTsQuery(idPerson, dtSysTsQuery));
      resultRow.put("personPhone", personPhoneDAO.findPersonPhoneByIdPersonDtSysTsQuery(idPerson, dtSysTsQuery));
      resultRow.put("lScrNbrOfAddrs",
                    addressPersonLinkDAO.countAddressPersonLinkIdPersonAddr(idPerson, dtSysTsQuery) > 1 ? MORE : null);
      resultRow.put("lScrNbrPhoneNbrs", personPhoneDAO.countPersonPhoneIdPersonPhone(idPerson, dtSysTsQuery) > 1 ? MORE
                                                                                                                : null);
      resultRow.put("bScrIndAlias", nameDAO.countNameIdName(idPerson, dtSysTsQuery) > 1 ? ArchitectureConstants.Y
                                                                                       : ArchitectureConstants.N);
      resultRow.put("bScrIndPersIdentifiers",
                    personIdDAO.countPersonIdIdPersonId(idPerson, dtSysTsQuery) > 1 ? ArchitectureConstants.Y
                                                                                   : ArchitectureConstants.N);
      resultRow.put("personSSN", personIdDAO.findNonEndDatePersonSSN(idPerson));
        
         results.add(resultRow);
    }
    return results;
  }

  @SuppressWarnings( { "unchecked" })
  public Map findCallPerson(int idStage, int idPerson) {
    StagePersonLink stagePersonLink = stagePersonLinkDAO
                                                        .findStagePersonLinkByIdStageIdPersonAndMaxDate(
                                                                                                        idStage,
                                                                                                        idPerson,
                                                                                                        DateHelper.MAX_JAVA_DATE);
    if (stagePersonLink == null) {
      // We return null here if we get no results from the first query, as it is then impossible to continue
      // in a meaningful way.
      // noinspection ReturnOfNull
      return null;
    }
    AddressPersonLink addressPersonLink = addressPersonLinkDAO
                                                              .findAddressPersonLinkByIdPersonAndMaxDate(
                                                                                                         idPerson,
                                                                                                         DateHelper.MAX_JAVA_DATE);
    Name personName = nameDAO.findNameByIdPersonAndMaxDate(idPerson, DateHelper.MAX_JAVA_DATE);
    PersonPhone personPhone = personPhoneDAO.findPersonPhoneByIdPersonAndMaxDate(idPerson, DateHelper.MAX_JAVA_DATE);
    PersonId personId = personIdDAO.findIdPersonIdByIdPersonAndMaxDate(idPerson, DateHelper.MAX_JAVA_DATE);
    long addressCount = addressPersonLinkDAO.countAddressPersonLinkByIdPersonAndMaxDate(idPerson,
                                                                                        DateHelper.MAX_JAVA_DATE);
    long phoneCount = personPhoneDAO.countIdPersonPhoneByIdPersonAndMaxDate(idPerson, DateHelper.MAX_JAVA_DATE);
    long nameCount = nameDAO.countIdNameByIdPersonAndMaxDate(idPerson, DateHelper.MAX_JAVA_DATE);
    long personIdCount = personIdDAO.countIdPersonIdByIdPersonAndMaxDate(idPerson, DateHelper.MAX_JAVA_DATE);

    Map callPersonInfo = new HashMap();
    callPersonInfo.put("stagePerson", stagePersonLink);
    callPersonInfo.put("addressPerson", addressPersonLink);
    callPersonInfo.put("name", personName);
    callPersonInfo.put("phone", personPhone);
    callPersonInfo.put("personId", personId);

    callPersonInfo.put("nbrOfAddress", addressCount > 1 ? MORE : null);
    callPersonInfo.put("nbrOfPhoneNbrs", phoneCount > 1 ? MORE : null);
    callPersonInfo.put("indAlias", nameCount > 1 ? ArchitectureConstants.Y : ArchitectureConstants.N);
    callPersonInfo.put("indPersIdentifiers", personIdCount > 1 ? ArchitectureConstants.Y : ArchitectureConstants.N);

    return callPersonInfo;
  }

  public void updateIntakeRelateUnrelate(int idPerson, int idRelatedPerson, int idStage, String cdStagePersSearchInd,
                                         boolean bDeleteUnrelated) {
    stagePersonLinkDAO.updateStagePersonLinkIdPersonCdStagePersSearchInd(idRelatedPerson, cdStagePersSearchInd,
                                                                         idPerson, idStage);
    if (bDeleteUnrelated) {
      long count = stagePersonLinkDAO.countStagePersonLinksNonStfCdStagePersTypeNonZeroIdStageByIdPerson(idPerson);
      if (count == 0) {
        personCategoryDAO.deletePersonCategory(idPerson, CodesTables.CPSNDTCT_CAS);
      }
    }
  }

  public void updateStagePersonLink(String indStagePersInLaw, int idPerson, int idStage, String cdPersonEthnicGroup,
                                    String indPersCancelHist, String cdPersonLanguage, String cdStagePersRelInt,
                                    String cdStagePersRole, String cdStagePersType, String nmNameLast, int idName,
                                    String nmPersonFull, String cdPersAddrLinkType, int idAddress,
                                    int idAddrPersonLink, String addrPersAddrStLn1, String addrPersAddrStLn2,
                                    String addrCity, String addrZip, String cdAddrCounty, String cdAddrState,
                                    String cdPhoneType, String nbrPhone, String nbrPhoneExtension, int idPhone, String cdPKHouseholdMember) {
    stagePersonLinkDAO.updateStagePersonLinkIndStagePersInLaw(indStagePersInLaw, idPerson, idStage);
    if (StringHelper.isValid(cdPersonEthnicGroup)) {
      personDAO.updatePerson(cdPersonEthnicGroup, indPersCancelHist, idPerson);
    }

    if (StringHelper.isValid(cdPersonLanguage)) {
      personDAO.updatePersonByPerLangAndPerCancelHist(cdPersonLanguage, indPersCancelHist, idPerson);
    }
    if (StringHelper.isValid(cdStagePersRelInt)) {
      stagePersonLinkDAO.updateStagePersonLinkCdStagePersRelInt(cdStagePersRelInt, idPerson, idStage);
    }
    if (StringHelper.isValid(cdStagePersRole)) {
      stagePersonLinkDAO.updateStagePersonLinkCdStagePersRole(cdStagePersRole, idPerson, idStage);
    }
    if (StringHelper.isValid(cdStagePersType)) {
      stagePersonLinkDAO.updateStagePersonLinkcdStagePersType(cdStagePersType, idPerson, idStage);
    }
    //STGAP0015485: Added cdPKHouseholdMember
    if (StringHelper.isValid(cdPKHouseholdMember)) {
      stagePersonLinkDAO.updateStagePersonLinkCdPKHouseholdMember(cdPKHouseholdMember, idPerson, idStage);
    }

    // Process Name
    if (StringHelper.isValid(nmNameLast)) {
      if (idName != 0) {
        nameDAO.updateNameNmNameLast(nmNameLast, idName, idPerson);
      } else {
        nameDAO.insertName(nmNameLast, idPerson);
      }

      personDAO.updatePersonNmPersonFull(nmPersonFull, indPersCancelHist, idPerson);
    }

    // Process Address
    if (StringHelper.isValid(cdPersAddrLinkType)) {
      if (idAddrPersonLink != 0 && idAddress != 0) {
        if (StringHelper.isValid(addrPersAddrStLn1)) {
          personAddressDAO.updatePersonAddress(addrPersAddrStLn1, idAddress);
        }
        if (StringHelper.isValid(addrPersAddrStLn2)) {
          personAddressDAO.updatePersonAddressAddrPersAddrStLn2(addrPersAddrStLn2, idAddress);
        }
        if (StringHelper.isValid(addrCity)) {
          personAddressDAO.updatePersonAddressAddrCity(addrCity, idAddress);
        }
        if (StringHelper.isValid(addrZip)) {
          personAddressDAO.updatePersonAddressAddrZip(addrZip, idAddress);
        }
        if (StringHelper.isValid(cdAddrCounty)) {
          personAddressDAO.updatePersonAddressCdAddrCounty(cdAddrCounty, idAddress);
        }
        if (StringHelper.isValid(cdAddrState)) {
          personAddressDAO.updatePersonAddressCdAddrState(cdAddrState, idAddress);
        }
        addressPersonLinkDAO.updateAddressPersonLink(cdPersAddrLinkType, idAddrPersonLink);
      } else {
        idAddress = personAddressDAO.insertPersonAddress(addrPersAddrStLn1, addrPersAddrStLn2, addrCity, addrZip,
                                                         cdAddrCounty, cdAddrState);

        addressPersonLinkDAO.insertAddressPersonLink(cdPersAddrLinkType, idPerson, idAddress);
      }

    }

    // Process Phone
    if (StringHelper.isValid(cdPhoneType) && StringHelper.isValid(nbrPhone) && StringHelper.isValid(nbrPhoneExtension)) {
      if (idPhone != 0) // Update
      {
        if (StringHelper.isValid(cdPhoneType)) {
          personPhoneDAO.updatePersonPhoneCdPhoneType(cdPhoneType, idPhone);
        }
        if (StringHelper.isValid(nbrPhone)) {
          personPhoneDAO.updatePersonPhoneNbrPhone(nbrPhone, idPhone);
        }
        if (StringHelper.isValid(nbrPhoneExtension)) {
          personPhoneDAO.updatePersonPhoneNbrPhoneExtension(nbrPhoneExtension, idPhone);
        }
      } else {
        // insert
        personPhoneDAO.insertPersonPhone(idPerson, cdPhoneType, nbrPhone, nbrPhoneExtension);
      }
    }
  }

  public Date addStageToWorker(int idStage, int idPerson, String cdStagePersRole, String cdStagePersType,
                               String cdStagePersSearchInd, String txtStagePersNotes, Date dtStagePersLink,
                               String cdStagePersRelInt, String indStagePersReporter, String indStagePersInLaw,
                               String indStagePersEmpNew, String cdPKHouseholdMember) {
    stagePersonLinkDAO.insertStagePersonLinkWihoutIndNmStage(idStage, idPerson, cdStagePersRole, cdStagePersType,
                                                             cdStagePersSearchInd, txtStagePersNotes, dtStagePersLink,
                                                             cdStagePersRelInt, indStagePersReporter,
                                                             indStagePersInLaw, indStagePersEmpNew, cdPKHouseholdMember,null);
    return stageDAO.findStageDtLastUpdate(idStage);
  }

  public void deleteStagePersonLink(int idStage, int idPerson) {
    int rows = stagePersonLinkDAO.deleteStagePersonLink(idStage, idPerson);
    if (rows == 0) {
      return;
    }
    long count = stagePersonLinkDAO.countStagePersonLinksNonZeroIdStageByIdPerson(idPerson);

    if (count == 0) {
      count = eventPersonLinkDAO.countEventPersonLinksNonZeroIdEventByIdPerson(idPerson);
    }
    if (count == 0) {
      relationshipDAO.deleteRelationshipByIdPerson(idPerson);
      personDAO.deleteIntakePerson(idPerson);
    }
  }

  public void setEventPersonLinkDAO(EventPersonLinkDAO eventPersonLinkDAO) {
    this.eventPersonLinkDAO = eventPersonLinkDAO;
  }

  public List<Integer> findIdStageByIdPersonStagePersType(Collection<Integer> idPersons, String cdStagePersType) {

    List<Integer> idStageList = new ArrayList<Integer>();

    if (StringHelper.EMPTY_STRING.equals(cdStagePersType) || cdStagePersType == null) {
      idStageList = stagePersonLinkDAO.findIdStageByIdPerson(idPersons);
    } else if (CodesTables.CPRSNTYP_PRN.equals(cdStagePersType) || CodesTables.CPRSNTYP_COL.equals(cdStagePersType)) {
      idStageList = stagePersonLinkDAO.findIdStageByIdPersonStagePersType(idPersons, cdStagePersType);
    } else if (CodesTables.CCALLLOG_AVC.equals(cdStagePersType)) {
      idStageList = stagePersonLinkDAO.findIdStageByIdPersonStagePersRole(idPersons, CodesTables.CROLEALL_VC);
    } else if (CodesTables.CCALLLOG_AMR.equals(cdStagePersType)) {
      idStageList = stagePersonLinkDAO.findIdStageByIdPersonStagePersRole(idPersons, CodesTables.CROLEALL_AP);
    } else if (CodesTables.CCALLLOG_REP.equals(cdStagePersType)) {
      idStageList = incomingDetailDAO.findIncomingDetailStageByIdPerson(idPersons);
    } else if (CodesTables.CCALLLOG_DHR.equals(cdStagePersType)) {
      idStageList = stagePersonLinkDAO.findIdStageByIdPersonByEmployee(idPersons);
    }

    return idStageList;
  }
}