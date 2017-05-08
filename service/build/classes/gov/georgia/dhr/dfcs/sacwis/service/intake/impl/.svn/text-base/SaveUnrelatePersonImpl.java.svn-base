package gov.georgia.dhr.dfcs.sacwis.service.intake.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexIncomingAddressDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexIncomingNameDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexIntakeAllegationDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexPersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexStagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.IncomingAddressDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.IncomingPersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.NameDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonEthnicityDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonIdDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonPhoneDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonRaceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.RelationshipDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.AddressPersonLink;
import gov.georgia.dhr.dfcs.sacwis.db.Name;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.PersonAddress;
import gov.georgia.dhr.dfcs.sacwis.db.PersonId;
import gov.georgia.dhr.dfcs.sacwis.db.PersonPhone;
import gov.georgia.dhr.dfcs.sacwis.db.StagePersonLink;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.intake.SaveUnrelatePerson;
import gov.georgia.dhr.dfcs.sacwis.structs.input.RelatePersonInStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.UnrelatePersonInRec;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PersonInfoStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.UnrelatePersonOutRec;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* Change History:
Date        User              Description
--------    ----------------  --------------------------------------------------

 09/17/2008   mxpatel          STGAP00008093: removed the IF that threw an exception in
                                              method saveUnrelatedPerson(UnrelatePersonInRec unrelatePersonInRec)
                                              to un-relate persons with no name.
                                              
 11/07/2008   hnguyen          STGAP00010645: Removed code that deletes a related person
                                              when unrelating in method saveUnrelatedPerson().
 05/25/2010   mxpatel           SMS#50561: added code to delete from Relationship table when a person is unrelated                                                                       
*/ 

public class SaveUnrelatePersonImpl extends BaseServiceImpl implements SaveUnrelatePerson {

  public static final String CD_INACTIVE = CodesTables.CINVOADJ_I;

  public static final String IND_UNRELATED = CodesTables.CINVOGEN_U;

  private static final int PAGE_NBR = 1;

  private ComplexIncomingAddressDAO complexIncomingAddressDAO = null;

  private ComplexIncomingNameDAO complexIncomingNameDAO = null;

  private ComplexIntakeAllegationDAO complexIntakeAllegationDAO = null;

  private ComplexPersonDAO complexPersonDAO = null;

  private ComplexStagePersonLinkDAO complexStagePersonLinkDAO = null;

  private IncomingPersonDAO incomingPersonDAO = null;

  private PersonDAO personDAO = null;

  private PersonEthnicityDAO personEthnicityDAO = null;

  private PersonIdDAO personIdDAO = null;

  private PersonPhoneDAO personPhoneDAO = null;

  private PersonRaceDAO personRaceDAO = null;

  private StagePersonLinkDAO stagePersonLinkDAO = null;

  private NameDAO nameDAO = null;

  private IncomingAddressDAO incomingAddressDAO = null;
  
  private RelationshipDAO relationshipDAO = null;
  
  public void setRelationshipDAO(RelationshipDAO relationshipDAO) {
    this.relationshipDAO = relationshipDAO;
  }

  public void setComplexIncomingAddressDAO(ComplexIncomingAddressDAO complexIncomingAddressDAO) {
    this.complexIncomingAddressDAO = complexIncomingAddressDAO;
  }

  public void setComplexIncomingNameDAO(ComplexIncomingNameDAO complexIncomingNameDAO) {
    this.complexIncomingNameDAO = complexIncomingNameDAO;
  }

  public void setComplexIntakeAllegationDAO(ComplexIntakeAllegationDAO complexIntakeAllegationDAO) {
    this.complexIntakeAllegationDAO = complexIntakeAllegationDAO;
  }

  public void setComplexPersonDAO(ComplexPersonDAO complexPersonDAO) {
    this.complexPersonDAO = complexPersonDAO;
  }

  public void setComplexStagePersonLinkDAO(ComplexStagePersonLinkDAO complexStagePersonLinkDAO) {
    this.complexStagePersonLinkDAO = complexStagePersonLinkDAO;
  }

  public void setIncomingPersonDAO(IncomingPersonDAO incomingPersonDAO) {
    this.incomingPersonDAO = incomingPersonDAO;
  }

  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }

  public void setPersonEthnicityDAO(PersonEthnicityDAO personEthnicityDAO) {
    this.personEthnicityDAO = personEthnicityDAO;
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

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public void setNameDAO(NameDAO nameDAO) {
    this.nameDAO = nameDAO;
  }

  public void setIncomingAddressDAO(IncomingAddressDAO incomingAddressDAO) {
    this.incomingAddressDAO = incomingAddressDAO;
  }

  public UnrelatePersonOutRec saveUnrelatedPerson(UnrelatePersonInRec unrelatePersonInRec) throws ServiceException {
    String cReqFuncCd = unrelatePersonInRec.getArchInputStruct().getCReqFuncCd();
    UnrelatePersonOutRec unrelatePersonOutRec = new UnrelatePersonOutRec();
    PersonInfoStruct personInfoStruct = new PersonInfoStruct();
    RelatePersonInStruct relatePersonInStruct = unrelatePersonInRec.getRelatePersonInStruct();
    int idRelatedPerson = relatePersonInStruct.getUlIdRelatedPerson();
    int idStage = relatePersonInStruct.getUlIdStage();
    if (!ServiceConstants.REQ_FUNC_CD_ADD.equals(cReqFuncCd)) {
      throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
    }
    // Adds rows to the PERSON from the INCOMING_PERSON table for an idPerson
    // cint35d
    Map<String, Integer> mapIdPersons = complexPersonDAO.insertPersonFromIncomingPerson(idRelatedPerson, idStage);
    if (mapIdPersons == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    // Return the new idPerson; and the idIncmgPerson for following DAOs idPerson is the new id person created for the
    // unrelate idIncmgPerson is the ID used to link all the incoming tables together.
    int idIncmgPerson = mapIdPersons.get("idIncmgPerson");
    int idPerson = mapIdPersons.get("idPerson");
    personInfoStruct.setUlIdPerson(idPerson);
    personInfoStruct.setUlIdIncmgPerson(idIncmgPerson);

    // Copies rows from the INCOMING_ADDRESS table to the PERSON_ADDRESS table
    // cint36d

    List incomingAddressList = incomingAddressDAO.findIncomingAddressByIdIncmgPerson(idIncmgPerson);

    if (incomingAddressList != null && incomingAddressList.size() > 0 && !incomingAddressList.isEmpty())
      if (0 == complexIncomingAddressDAO.insertPersonAddressAndAddressPersonLink(idIncmgPerson, idPerson)) {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }

    // Adds rows to the PERSON_PHONE table from the INCOMING_PHONE for an ID_PERSON
    // cint37d

    if (personPhoneDAO.findPersonPhoneByIdPerson(idPerson).size() > 0) {
      if (0 == personPhoneDAO.insertPersonPhone(idIncmgPerson, idPerson)) {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }
    }

    // Adds rows to the PERSON_ID from the INCOMING_PERSON_ID table for an ID_PERSON
    // cint38d
    if (personIdDAO.countPersonIdByIdPerson(idPerson) > 1) {
      if (0 == personIdDAO.insertPersonIdByIdPerson(idPerson, idIncmgPerson)) {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }
    }

    // Copies rows from the INCOMING_PERSON_RACE table to the PERSON_RACE table
    // caudd8d
    personRaceDAO.insertPersonRaceByIdPersonIdIncmgPerson(idPerson, idIncmgPerson);

    // Copies rows from the INCOMING_PERSON_ETHNICITY table to the PERSON_ETHNICITY table
    // caudd9d
    personEthnicityDAO.insertPersonEthnicityByIdPersonIdIncmgPerson(idPerson, idIncmgPerson);

    // Copies rows from the INCOMING_NAME table to the NAME table
    // cint39d
    if (nameDAO.countNameIdNameByIdPerson(idRelatedPerson) >= 1) {//mxpatel changed from > to >= 
     /* if (0 == complexIncomingNameDAO.addIncomingNameToName(idPerson, idIncmgPerson)) {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }*/
      complexIncomingNameDAO.addIncomingNameToName(idPerson, idIncmgPerson);
    }

    // Update STAGE_PERSON_LINK changing the ID_PERSON to the ID_RELATED_PERSON
    // The person ids are swapped in order to update the STAGE_PERSON_LINK table to reflect the new id person.
    // cint32d
    complexStagePersonLinkDAO.updateIntakeRelateUnrelate(idRelatedPerson, idPerson, idStage, IND_UNRELATED, true);

    // Retrieves person information for the given idPersob, for list box row; this updates personInfoStruct.
    // cint26d
    updatePersonInfoStruct(idPerson, idStage, personInfoStruct);
    // Update PERSON_ALLEG_LINK changing the idPerson to the idRelatedPerson
    // The idPerson and idRelatedPerson are swapped for the unrelate function.
    // cint33d
    complexIntakeAllegationDAO.updateIntakeAllegation(idPerson, personInfoStruct.getSzNmPersonFull(), idRelatedPerson,
                                                      idStage);
    // Delete the person from the incoming tables if all the previous DAOs were succesful
    // Deletes a person from all the incoming tables.
    // The idPerson and idRelatedPerson are swapped for the unrelate function.
    // cint61d
    // if (0 == incomingPersonDAO.deleteIncomingPerson(idRelatedPerson, idStage)) {
    // throw new ServiceException(Messages.SQL_NOT_FOUND);
    // }

    incomingPersonDAO.deleteIncomingPerson(idRelatedPerson, idStage);
    // If the person is in no other open stages, change the person's status to Inactive, otherwise leave Active.
    // This joins the Stage Person Link and the stage Table to determine all of the active programs
    // and stages that a that a person is involved in
    // cinv33d
    int pageSize = unrelatePersonInRec.getArchInputStruct().getUlPageSizeNbr();
    PaginatedHibernateList<Map> stagePersonLinkList = stagePersonLinkDAO
                                                                        .findStageAndStagePersonLinkByIdPerson(
                                                                                                               idRelatedPerson,
                                                                                                               PAGE_NBR,
                                                                                                               pageSize);
    // List<Map> stagePersonLinkList = stagePersonLinkDAO.findStageAndStagePersonLinkByIdPerson(idRelatedPerson);
    // if Person is in no other open stages. Person may be in system but not in an active case
    // Call DAO to update person status to Inactive
    if (stagePersonLinkList == null || stagePersonLinkList.isEmpty()) {
      // caud74d
      if (0 == personDAO.updatePersonCdPersonStatus(idRelatedPerson, CD_INACTIVE)) {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }
    }

    // 
    // STGAP00010645 Should not delete the related person when unrelating a person whether if
    // person is involved in any stage/event or not.
    // Marked old comments and commented out code.
    //(old) Delete the Unrelated person from the system if she/he is not attached to any other stage.
    //(old) Calls DAO to see if the given idPerson is involved in any other stages or events (besides intake) and if not,
    //(old) deletes the person from the database.
    //(old) cint60d
//(old)    complexPersonDAO.deletePerson(idRelatedPerson, ArchitectureConstants.N);
    unrelatePersonOutRec.setPersonInfoStruct(personInfoStruct);
    return unrelatePersonOutRec;
  }

  /**
   * This updates personInfoStruct.
   * 
   * @param idPerson
   * @param idStage
   * @param personInfoStruct
   *          Updated with infromation returned from complexCallPersonDAO.findCallPerson().
   * @throws ServiceException
   */
  private void updatePersonInfoStruct(int idPerson, int idStage, PersonInfoStruct personInfoStruct)
                                                                                                   throws ServiceException {
    // cint26d
    Map callPersonMap = complexStagePersonLinkDAO.findCallPerson(idStage, idPerson);
    if (callPersonMap == null || callPersonMap.isEmpty()) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    StagePersonLink stagePersonLink = (StagePersonLink) callPersonMap.get("stagePerson");
    AddressPersonLink addressPersonLink = (AddressPersonLink) callPersonMap.get("addressPerson");
    Name personName = (Name) callPersonMap.get("name");
    PersonPhone personPhone = (PersonPhone) callPersonMap.get("phone");
    PersonId personId = (PersonId) callPersonMap.get("personId");

    long addressCount = ((Integer) callPersonMap.get("nbrOfAddress") != null ? (Integer) callPersonMap
                                                                                                      .get("nbrOfAddress")
                                                                            : 0);
    long phoneCount = ((Integer) callPersonMap.get("nbrOfPhoneNbrs") != null ? (Integer) callPersonMap
                                                                                                      .get("nbrOfPhoneNbrs")
                                                                            : 0);
    String indAlias = (String) callPersonMap.get("indAlias");
    String indPersItentifiers = (String) callPersonMap.get("indPersIdentifiers");

    if (addressPersonLink != null) {
      PersonAddress personAddress = addressPersonLink.getPersonAddress();
      personInfoStruct.setLdIdAddress(personAddress.getIdPersonAddr() != null ? personAddress.getIdPersonAddr() : 0);
      personInfoStruct.setSzAddrPersAddrStLn1(personAddress.getAddrPersAddrStLn1());
      personInfoStruct.setSzAddrPersAddrStLn2(personAddress.getAddrPersAddrStLn2());
      personInfoStruct.setSzAddrCity(personAddress.getAddrPersonAddrCity());
      personInfoStruct.setSzCdAddrCounty(personAddress.getCdPersonAddrCounty());
      personInfoStruct.setLAddrZip(personAddress.getAddrPersonAddrZip());
      personInfoStruct.setSzCdAddrState(personAddress.getCdPersonAddrState());
      personInfoStruct
                      .setUlIdAddrPersonLink(addressPersonLink.getIdAddrPersonLink() != null ? addressPersonLink
                                                                                                                .getIdAddrPersonLink()
                                                                                            : 0);
      personInfoStruct.setSzCdPersAddrLinkType(addressPersonLink.getCdPersAddrLinkType());
      personInfoStruct.setDtDtPersAddrLinkEnd(DateHelper.toCastorDate(addressPersonLink.getDtPersAddrLinkEnd()));
      personInfoStruct.setDtDtPersAddrLinkStart(DateHelper.toCastorDate(addressPersonLink.getDtPersAddrLinkStart()));

      personInfoStruct.setBIndPersAddrLinkInvalid(addressPersonLink.getIndPersAddrLinkInvalid());

      personInfoStruct.setSzTxtPersAddrCmnts(addressPersonLink.getTxtPersAddrCmnts());

    }

    if (stagePersonLink != null)

    {
      personInfoStruct.setSzCdStagePersType(stagePersonLink.getCdStagePersType());
      personInfoStruct.setSzCdStagePersRole(stagePersonLink.getCdStagePersRole());
      personInfoStruct.setSzCdStagePersRelInt(stagePersonLink.getCdStagePersRelInt());
      personInfoStruct.setSzCdStagePersSearchInd(stagePersonLink.getCdStagePersSearchInd());
      personInfoStruct.setBIndStagePersReporter(stagePersonLink.getIndStagePersReporter());
      personInfoStruct.setBIndStagePersInLaw(stagePersonLink.getIndStagePersInLaw());
      personInfoStruct.setSzTxtStagePersNotes(stagePersonLink.getTxtStagePersNotes());
    }

    if (personName != null) {
      String nmNameFirst = personName.getNmNameFirst();
      String nmNameMiddle = personName.getNmNameMiddle();
      String nmNameLast = personName.getNmNameLast();
      String nmNameFull = FormattingHelper.formatFullName(nmNameFirst, nmNameMiddle, nmNameLast);
      Person person = personName.getPerson();
      personInfoStruct.setUlIdName(personName.getIdName() != null ? personName.getIdName() : 0);

      personInfoStruct.setSzNmNameFirst(nmNameFirst);
      personInfoStruct.setSzNmNameMiddle(nmNameMiddle);
      personInfoStruct.setSzNmNameLast(nmNameLast);
      personInfoStruct.setSzNmPersonFull(nmNameFull);
      personInfoStruct.setSzCdNameSuffix(personName.getCdNameSuffix());
      personInfoStruct.setDtDtPersonBirth(DateHelper.toCastorDate(person.getDtPersonBirth()));
      personInfoStruct.setBIndPersonDobApprox(person.getIndPersonDobApprox());
      personInfoStruct.setLNbrPersonAge(person.getNbrPersonAge() != null ? person.getNbrPersonAge() : 0);
      personInfoStruct.setCCdPersonSex(person.getCdPersonSex());
      personInfoStruct.setDtDtPersonDeath(DateHelper.toCastorDate(person.getDtPersonDeath()));
      personInfoStruct.setSzNbrPersonIdNumber(person.getNbrPersonIdNumber());
      personInfoStruct.setSzCdPersonMaritalStatus(person.getCdPersonMaritalStatus());
      personInfoStruct.setSzCdPersonLanguage(person.getCdPersonLanguage());
      personInfoStruct.setSzCdPersonEthnicGroup(person.getCdPersonEthnicGroup());
      personInfoStruct.setSzCdPersonDeath(person.getCdPersonDeath());
      personInfoStruct.setBIndNameInvalid(personName.getIndNameInvalid());
      personInfoStruct.setDtDtNameEndDate(DateHelper.toCastorDate(personName.getDtNameEndDate()));
      personInfoStruct.setDtDtNameStartDate(DateHelper.toCastorDate(personName.getDtNameStartDate()));
    }

    if (personId != null) {
      personInfoStruct.setUlIdPersonId(personId.getIdPersonId() != null ? personId.getIdPersonId() : 0);
      personInfoStruct.setSzDescPersonID(personId.getDescPersonId());
      personInfoStruct.setDtPersonIDEnd(DateHelper.toCastorDate(personId.getDtPersonIdEnd()));
      personInfoStruct.setDtPersonIDStart(DateHelper.toCastorDate(personId.getDtPersonIdStart()));
      personInfoStruct.setBIndPersonIDInvalid(personId.getIndPersonIdInvalid());
    }

    if (personPhone != null) {
      personInfoStruct.setUlIdPhone(personPhone.getIdPersonPhone() != null ? personPhone.getIdPersonPhone() : 0);
      personInfoStruct.setLNbrPhone(personPhone.getNbrPersonPhone());
      personInfoStruct.setLNbrPhoneExtension(personPhone.getNbrPersonPhoneExtension());
      personInfoStruct.setSzCdPhoneType(personPhone.getCdPersonPhoneType());
      personInfoStruct.setBIndPersonPhoneInvalid(personPhone.getIndPersonPhoneInvalid());
      personInfoStruct.setDtDtPersonPhoneEnd(DateHelper.toCastorDate(personPhone.getDtPersonPhoneEnd()));
      personInfoStruct.setDtDtPersonPhoneStart(DateHelper.toCastorDate(personPhone.getDtPersonPhoneStart()));
      personInfoStruct.setSzTxtPhoneComments(personPhone.getTxtPersonPhoneComments());

    }

    personInfoStruct.setUlIdStage(idStage);
    personInfoStruct.setUlIdPerson(idPerson);

    personInfoStruct.setLScrNbrOfAddrs(String.valueOf(addressCount));
    personInfoStruct.setLScrNbrPhoneNbrs(String.valueOf(phoneCount));
    personInfoStruct.setBScrIndAlias(indAlias);
    personInfoStruct.setBScrIndPersIdentifiers(indPersItentifiers);

  }
}
