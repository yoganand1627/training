package gov.georgia.dhr.dfcs.sacwis.service.intake.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexIntakeAllegationDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexPersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexStagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EmployeeDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.IncomingAddressDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.IncomingEthnicityDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.IncomingNameDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.IncomingPersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.IncomingPersonIdDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.IncomingPhoneDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.IncomingRaceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.NameDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonIdDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonPhoneDAO;
import gov.georgia.dhr.dfcs.sacwis.db.AddressPersonLink;
import gov.georgia.dhr.dfcs.sacwis.db.Employee;
import gov.georgia.dhr.dfcs.sacwis.db.Name;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.PersonAddress;
import gov.georgia.dhr.dfcs.sacwis.db.PersonId;
import gov.georgia.dhr.dfcs.sacwis.db.PersonPhone;
import gov.georgia.dhr.dfcs.sacwis.db.StagePersonLink;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.intake.SaveRelatePerson;
import gov.georgia.dhr.dfcs.sacwis.structs.input.RelatePersonInRec;
import gov.georgia.dhr.dfcs.sacwis.structs.input.RelatePersonInStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PersonInfoStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.RelatePersonOutRec;

import java.util.Collection;
import java.util.Map;

/* Change History:
Date        User              Description
--------    ----------------  --------------------------------------------------

 09/17/2008   mxpatel          STGAP00008093: changed the condition from >1 to >=1 in 
                                              if (nameDAO.countNameIdNameByIdPerson(idPerson) >= 1)
                                              in method - relatePerson(RelatePersonInRec relatePersonInRec)
                               
*/

public class SaveRelatePersonImpl extends BaseServiceImpl implements SaveRelatePerson {

  private IncomingPersonDAO incomingPersonDAO = null;

  private IncomingAddressDAO incomingAddressDAO = null;

  private IncomingPhoneDAO incomingPhoneDAO = null;

  private IncomingPersonIdDAO incomingPersonIdDAO = null;

  private IncomingRaceDAO incomingRaceDAO = null;

  private IncomingEthnicityDAO incomingEthnicityDAO = null;

  private IncomingNameDAO incomingNameDAO = null;

  private PersonDAO personDAO = null;

  private ComplexStagePersonLinkDAO complexStagePersonLinkDAO = null;

  private ComplexIntakeAllegationDAO complexIntakeAllegationDAO = null;

  private ComplexPersonDAO complexPersonDAO = null;

  private EmployeeDAO employeeDAO = null;

  private PersonPhoneDAO personPhoneDAO = null;

  private PersonIdDAO personIdDAO = null;

  private NameDAO nameDAO = null;

  public void setIncomingPersonDAO(IncomingPersonDAO incomingPersonDAO) {
    this.incomingPersonDAO = incomingPersonDAO;
  }

  public void setIncomingAddressDAO(IncomingAddressDAO incomingAddressDAO) {
    this.incomingAddressDAO = incomingAddressDAO;
  }

  public void setIncomingPhoneDAO(IncomingPhoneDAO incomingPhoneDAO) {
    this.incomingPhoneDAO = incomingPhoneDAO;
  }

  public void setIncomingPersonIdDAO(IncomingPersonIdDAO incomingPersonIdDAO) {
    this.incomingPersonIdDAO = incomingPersonIdDAO;
  }

  public void setIncomingRaceDAO(IncomingRaceDAO incomingRaceDAO) {
    this.incomingRaceDAO = incomingRaceDAO;
  }

  public void setIncomingEthnicityDAO(IncomingEthnicityDAO incomingEthnicityDAO) {
    this.incomingEthnicityDAO = incomingEthnicityDAO;
  }

  public void setIncomingNameDAO(IncomingNameDAO incomingNameDAO) {
    this.incomingNameDAO = incomingNameDAO;
  }

  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }

  public void setComplexStagePersonLinkDAO(ComplexStagePersonLinkDAO complexStagePersonLinkDAO) {
    this.complexStagePersonLinkDAO = complexStagePersonLinkDAO;
  }

  public void setComplexIntakeAllegationDAO(ComplexIntakeAllegationDAO complexIntakeAllegationDAO) {
    this.complexIntakeAllegationDAO = complexIntakeAllegationDAO;
  }

  public void setComplexPersonDAO(ComplexPersonDAO complexPersonDAO) {
    this.complexPersonDAO = complexPersonDAO;
  }

  public void setEmployeeDAO(EmployeeDAO employeeDAO) {
    this.employeeDAO = employeeDAO;
  }

  public void setPersonPhoneDAO(PersonPhoneDAO personPhoneDAO) {
    this.personPhoneDAO = personPhoneDAO;
  }

  public void setPersonIdDAO(PersonIdDAO personIdDAO) {
    this.personIdDAO = personIdDAO;
  }

  public void setNameDAO(NameDAO nameDAO) {
    this.nameDAO = nameDAO;
  }

  /**
   * This is cint08s
   * 
   * @param relatePersonInRec
   * @return A populated {@link RelatePersonOutRec} object.
   * @throws ServiceException
   */
  public RelatePersonOutRec relatePerson(RelatePersonInRec relatePersonInRec) throws ServiceException {

    // The first DAM called errors-out if the following is not true, so just do this check once here (not in every DAM).
    if (!ServiceConstants.REQ_FUNC_CD_ADD.equals(relatePersonInRec.getArchInputStruct().getCReqFuncCd())) {
      throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
    }

    RelatePersonOutRec relatePersonOutRec = new RelatePersonOutRec();
    PersonInfoStruct personInfoStruct = new PersonInfoStruct();
    relatePersonOutRec.setPersonInfoStruct(personInfoStruct);

    // cint27
    RelatePersonInStruct relatePersonInStruct = relatePersonInRec.getRelatePersonInStruct();
    int ulIdIncmgPerson = addIncomingPerson(relatePersonInStruct);
    personInfoStruct.setUlIdIncmgPerson(ulIdIncmgPerson);
    // cint28
    int idPerson = relatePersonInStruct.getUlIdPerson();
    incomingAddressDAO.insertIncomingAddress(ulIdIncmgPerson, idPerson);

    if (personPhoneDAO.findPersonPhoneByIdPerson(idPerson).size() > 0) {
      // cint29
      if (incomingPhoneDAO.insertIncomingPhone(ulIdIncmgPerson, idPerson) == 0) {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }
    }

    // cint30

    if (personIdDAO.countPersonIdByIdPerson(idPerson) > 1) {
      if (incomingPersonIdDAO.insertIncomingPersonID(ulIdIncmgPerson, idPerson) == 0) {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }
    }

    // caudd6d -- Ignores SQL_NOT_FOUND
    incomingRaceDAO.insertIncomingRaceByIdPerson(ulIdIncmgPerson, idPerson);
    // caudd7d -- Ignores SQL_NOT_FOUND
    incomingEthnicityDAO.insertIncomingEthnicityByIdPerson(ulIdIncmgPerson, idPerson);

    // cint31d
    if (nameDAO.countNameIdNameByIdPerson(idPerson) >= 1) {//mxpatel changed from > to >=
      if (incomingNameDAO.insertIncomingName(ulIdIncmgPerson, idPerson) == 0) {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }
    }
    // caud74
    int ulIdRelatedPerson = relatePersonInStruct.getUlIdRelatedPerson();

    if (personDAO.updatePersonCdPersonStatus(ulIdRelatedPerson, CD_ACTIVE) == 0) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }

    // cint32 -- Ignores SQL_NOT_FOUND
    int idStage = relatePersonInStruct.getUlIdStage();
    complexStagePersonLinkDAO.updateIntakeRelateUnrelate(idPerson, ulIdRelatedPerson, idStage, IND_RELATED, false);
    // cint26

    try {

      callComplexCallPerson(relatePersonInRec, relatePersonOutRec);

    } catch (ServiceException ex) {
      if (ex.getErrorCode() == Messages.SQL_NOT_FOUND) {
        // cint33 -- SQL_NOT_FOUND is ignored for this DAM.
        complexIntakeAllegationDAO.updateIntakeAllegation(ulIdRelatedPerson, personInfoStruct.getSzNmPersonFull(),
                                                          ulIdRelatedPerson, idStage);
      }
    }
    
    //added code here to update intake allegations if they exist for this person
    complexIntakeAllegationDAO.updateIntakeAllegation(ulIdRelatedPerson, personInfoStruct.getSzNmPersonFull(),
                                                      relatePersonInStruct.getUlIdPerson(), idStage);
    // cint60 -- Ignores SQL_NOT_FOUND
    complexPersonDAO.deletePerson(idPerson, ArchitectureConstants.N);
    // ccmn69
    relatePersonOutRec.setArchOutputStruct(findEmployee(relatePersonInRec));
    return relatePersonOutRec;
  }

  private ArchOutputStruct findEmployee(RelatePersonInRec relatePersonInRec) {
    // NOTE THE PECULIAR USE FOR THIS INDICATOR VARIABLE!
    ArchOutputStruct archOutputStruct = new ArchOutputStruct();
    // ccmn69
    if (employeeDAO.findEmployeeByIdPerson(relatePersonInRec.getRelatePersonInStruct().getUlIdRelatedPerson()) != null) {
      // This indicates the person IS an employee.
      archOutputStruct.setBMoreDataInd(ArchitectureConstants.Y);
    } else {
      // This indicates the person is NOT an employee.
      archOutputStruct.setBMoreDataInd(ArchitectureConstants.N);
    }
    return archOutputStruct;
  }

  private void callComplexCallPerson(RelatePersonInRec relatePersonInRecSub, RelatePersonOutRec relatePersonOutRecSub)
                                                                                                                      throws ServiceException {
    // cint26
    RelatePersonInStruct relatePersonInStruct = relatePersonInRecSub.getRelatePersonInStruct();
    Map complexCallPersonMap = complexStagePersonLinkDAO.findCallPerson(relatePersonInStruct.getUlIdPerson(),
                                                                        relatePersonInStruct.getUlIdStage());
    if (complexCallPersonMap == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }

    long nbrOfAddress = (Long) complexCallPersonMap.get("nbrOfAddress");
    long nbrOfPhoneNbrs = (Long) complexCallPersonMap.get("nbrOfPhoneNbrs");
    String indAlias = (String) complexCallPersonMap.get("indAlias");
    String indPersIdentifiers = (String) complexCallPersonMap.get("indPersIdentifiers");

    PersonPhone personPhone = (PersonPhone) complexCallPersonMap.get("phone");
    StagePersonLink stagePersonLink = (StagePersonLink) complexCallPersonMap.get("stagePerson");
    AddressPersonLink addressPersonLink = (AddressPersonLink) complexCallPersonMap.get("addressPerson");
    Name name = (Name) complexCallPersonMap.get("name");

    PersonInfoStruct personInfoStruct = relatePersonOutRecSub.getPersonInfoStruct();
    if (complexCallPersonMap.size() > 0) {

      personInfoStruct.setSzCdStagePersType(stagePersonLink.getCdStagePersType());
      personInfoStruct.setUlIdName(name.getIdName() != null ? name.getIdName() : 0);
      personInfoStruct
                      .setLdIdAddress(addressPersonLink.getIdAddrPersonLink() != null ? addressPersonLink
                                                                                                         .getIdAddrPersonLink()
                                                                                     : 0);
      personInfoStruct.setUlIdPhone(personPhone.getIdPersonPhone() != null ? personPhone.getIdPersonPhone() : 0);
      personInfoStruct
                      .setUlIdAddrPersonLink(addressPersonLink.getIdAddrPersonLink() != null ? addressPersonLink
                                                                                                                .getIdAddrPersonLink()
                                                                                            : 0);
      personInfoStruct.setSzCdStagePersRole(stagePersonLink.getCdStagePersRole());
      personInfoStruct.setSzNmNameFirst(name.getNmNameFirst());
      personInfoStruct.setSzNmNameMiddle(name.getNmNameMiddle());
      personInfoStruct.setSzNmNameLast(name.getNmNameLast());
      Person person = stagePersonLink.getPerson();
      personInfoStruct.setSzNmPersonFull(person.getNmPersonFull());
      personInfoStruct.setDtDtPersonBirth(DateHelper.toCastorDate(person.getDtPersonBirth()));
      personInfoStruct.setBIndPersonDobApprox(person.getIndPersonDobApprox());
      personInfoStruct.setLNbrPersonAge(person.getNbrPersonAge() != null ? person.getNbrPersonAge() : 0);
      personInfoStruct.setCCdPersonSex(person.getCdPersonSex());
      personInfoStruct.setSzCdStagePersRelInt(stagePersonLink.getCdStagePersRelInt());
      personInfoStruct.setSzCdStagePersSearchInd(stagePersonLink.getCdStagePersSearchInd());
      personInfoStruct.setBIndStagePersReporter(stagePersonLink.getIndStagePersReporter());
      personInfoStruct.setBIndStagePersInLaw(stagePersonLink.getIndStagePersInLaw());
      personInfoStruct.setSzCdNameSuffix(name.getCdNameSuffix());
      personInfoStruct.setDtDtPersonDeath(DateHelper.toCastorDate(person.getDtPersonDeath()));
      personInfoStruct.setSzNbrPersonIdNumber(person.getNbrPersonIdNumber());
      personInfoStruct.setSzCdPersonMaritalStatus(person.getCdPersonMaritalStatus());
      personInfoStruct.setSzCdPersonLanguage(person.getCdPersonLanguage());
      personInfoStruct.setSzCdPersonEthnicGroup(person.getCdPersonEthnicGroup());
      personInfoStruct.setSzTxtStagePersNotes(stagePersonLink.getTxtStagePersNotes());
      personInfoStruct.setUlIdStage(stagePersonLink.getStage().getIdStage() != null ? stagePersonLink.getStage()
                                                                                                     .getIdStage() : 0);
      personInfoStruct.setUlIdPerson(person.getIdPerson() != null ? person.getIdPerson() : 0);
      PersonAddress personAddress = addressPersonLink.getPersonAddress();
      personInfoStruct.setSzAddrPersAddrStLn1(personAddress.getAddrPersAddrStLn1());
      personInfoStruct.setSzAddrPersAddrStLn2(personAddress.getAddrPersAddrStLn2());
      personInfoStruct.setSzAddrCity(personAddress.getAddrPersonAddrCity());
      personInfoStruct.setSzCdAddrCounty(personAddress.getCdPersonAddrCounty());
      personInfoStruct.setLAddrZip(personAddress.getAddrPersonAddrZip());
      personInfoStruct.setSzCdAddrState(personAddress.getCdPersonAddrState());
      personInfoStruct.setSzCdPersAddrLinkType(addressPersonLink.getCdPersAddrLinkType());
      personInfoStruct.setLNbrPhone(personPhone.getNbrPersonPhone());
      personInfoStruct.setLNbrPhoneExtension(personPhone.getNbrPersonPhoneExtension());
      personInfoStruct.setSzCdPhoneType(personPhone.getCdPersonPhoneType());
      personInfoStruct.setLScrNbrOfAddrs(String.valueOf(nbrOfAddress));
      personInfoStruct.setLScrNbrPhoneNbrs(String.valueOf(nbrOfPhoneNbrs));
      personInfoStruct.setBScrIndAlias(indAlias);
      personInfoStruct.setLNbrPersonAge(person.getNbrPersonAge() != null ? person.getNbrPersonAge() : 0);
      personInfoStruct.setBScrIndPersIdentifiers(indPersIdentifiers);
      personInfoStruct.setSzCdPersonDeath(person.getCdPersonDeath());
      personInfoStruct.setBIndPersonPhoneInvalid(personPhone.getIndPersonPhoneInvalid());
      personInfoStruct.setBIndNameInvalid(name.getIndNameInvalid());
      personInfoStruct.setDtDtNameEndDate(DateHelper.toCastorDate(name.getDtNameEndDate()));
      personInfoStruct.setDtDtNameStartDate(DateHelper.toCastorDate(name.getDtNameStartDate()));
      personInfoStruct.setDtDtPersAddrLinkEnd(DateHelper.toCastorDate(addressPersonLink.getDtPersAddrLinkEnd()));
      personInfoStruct.setDtDtPersAddrLinkStart(DateHelper.toCastorDate(addressPersonLink.getDtPersAddrLinkStart()));

      Collection<PersonId> personIds = person.getPersonIds();
      // There will always be exactly one, and if there is not, we want the NPE.
      PersonId personId = personIds.iterator().next();

      personInfoStruct.setUlIdPersonId(personId.getIdPersonId() != null ? personId.getIdPersonId() : 0);
      personInfoStruct.setDtPersonIDEnd(DateHelper.toCastorDate(personId.getDtPersonIdEnd()));
      personInfoStruct.setBIndPersonIDInvalid(personId.getIndPersonIdInvalid());
      personInfoStruct.setSzDescPersonID(personId.getDescPersonId());
      personInfoStruct.setDtPersonIDStart(DateHelper.toCastorDate(personId.getDtPersonIdStart()));

      personInfoStruct.setDtDtPersonPhoneEnd(DateHelper.toCastorDate(personPhone.getDtPersonPhoneEnd()));
      personInfoStruct.setDtDtPersonPhoneStart(DateHelper.toCastorDate(personPhone.getDtPersonPhoneStart()));
      personInfoStruct.setBIndPersAddrLinkInvalid(addressPersonLink.getIndPersAddrLinkInvalid());
      personInfoStruct.setSzTxtPersAddrCmnts(addressPersonLink.getTxtPersAddrCmnts());
      personInfoStruct.setSzTxtPhoneComments(personPhone.getTxtPersonPhoneComments());
    }
    // If the person's birthday is known, update their age on relate.
    if (!DateHelper.isNull(personInfoStruct.getDtDtPersonBirth().toDate())) {
      int age = DateHelper.getAge(relatePersonOutRecSub.getPersonInfoStruct().getDtDtPersonBirth());
      // caudj8d
      personDAO.updatePersonNbrPersonAge(relatePersonOutRecSub.getPersonInfoStruct().getUlIdPerson(), age);
    }
  }

  private int addIncomingPerson(RelatePersonInStruct relatePersonInStruct) throws ServiceException {
    int idIncomingPerson = commonDAO.getNextval("SEQ_INCOMING_PERSON");
    // cint27
    int rowsInserted = incomingPersonDAO
                                        .insertIncomingPersonWithoutIndInfoSwap(
                                                                                idIncomingPerson,
                                                                                relatePersonInStruct
                                                                                                    .getUlIdRelatedPerson(),
                                                                                relatePersonInStruct.getUlIdPerson(),
                                                                                relatePersonInStruct.getUlIdStage());
    if (rowsInserted == 0) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    return idIncomingPerson;
  }

}
