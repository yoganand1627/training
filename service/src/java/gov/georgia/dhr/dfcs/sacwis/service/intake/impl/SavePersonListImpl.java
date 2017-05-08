package gov.georgia.dhr.dfcs.sacwis.service.intake.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.NullHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsCaseDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexAddressPersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexIntakeAllegationDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexNameDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexPersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexPersonPhoneDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexStagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.NameDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonAddressDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonEthnicityDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonIdDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonRaceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.WorkloadDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CapsCase;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.PersonAddress;
import gov.georgia.dhr.dfcs.sacwis.db.PersonRace;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.db.Workload;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.intake.SavePersonList;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT14WLB;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT14WLB_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.PersListAudInRec;
import gov.georgia.dhr.dfcs.sacwis.structs.input.PersListAudStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN31SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN31SI_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN44SIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN44SIG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT02SIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT02SIG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT02SIG01;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT02SIG01_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV26SIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV26SIG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.LdIdAddress_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PersListAudOutRec;
import gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdAddrPersonLink_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdName_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdPersonId_ARRAY;

import java.util.Date;
import java.util.Enumeration;
import java.util.List;

/**
* Change History:
* Date      User              Description
* --------  ----------------  --------------------------------------------------
* 09/30/2009  bgehlot         STGAP00015485: MR-56 updates 
* 05/12/2010  wjcochran       SMS #38679: Added null checks in updatePersonRace and updatePersonEthnicity
*                             to prevent NullPointerExceptions
* 06/04/2010  mxpatel         MR-066.1:  added validations to avoid saving duplicate persons       
* 06/17/2020  bgehlot         SMS 57690 Page to display confirmation message if duplicate found in Update mode also.                      
* 06/18/2010 bgehlot          SMS# 57787 Changed the duplicate message.
* 12/01/2010  cwells          SMS# 76324 Updating the county displayed on the workload if the County of the Primary Caretakers Primary address
*			      changes 
* </pre>
*/

public class SavePersonListImpl extends BaseServiceImpl implements SavePersonList {

  private static final String VIEWED = CodesTables.CSRCHSTA_V;

  private static final String RELATED = CodesTables.CSRCHSTA_R;

  private static final String UNRELATED = CodesTables.CSRCHSTA_U;

  private static final String LAUNCHED = CodesTables.CSRCHSTA_L;

  private ComplexAddressPersonLinkDAO complexAddressPersonLinkDAO = null;

  private ComplexIntakeAllegationDAO complexIntakeAllegationDAO = null;

  private ComplexNameDAO complexNameDAO = null;

  private ComplexPersonDAO complexPersonDAO = null;

  private ComplexPersonPhoneDAO complexPersonPhoneDAO = null;

  private ComplexStagePersonLinkDAO complexStagePersonLinkDAO = null;

  private NameDAO nameDAO = null;

  private PersonAddressDAO personAddressDAO = null;

  private PersonEthnicityDAO personEthnicityDAO = null;

  private PersonIdDAO personIdDAO = null;
  
  private PersonDAO personDAO = null;

  private PersonRaceDAO personRaceDAO = null;

  private StagePersonLinkDAO stagePersonLinkDAO = null;
  
  private CapsCaseDAO capsCaseDAO = null;
  
  private StageDAO stageDAO = null;
  
  private WorkloadDAO workloadDAO = null;

  public void setComplexAddressPersonLinkDAO(ComplexAddressPersonLinkDAO complexAddressPersonLinkDAO) {
    this.complexAddressPersonLinkDAO = complexAddressPersonLinkDAO;
  }

  public void setComplexIntakeAllegationDAO(ComplexIntakeAllegationDAO complexIntakeAllegationDAO) {
    this.complexIntakeAllegationDAO = complexIntakeAllegationDAO;
  }

  public void setComplexNameDAO(ComplexNameDAO complexNameDAO) {
    this.complexNameDAO = complexNameDAO;
  }

  public void setComplexPersonDAO(ComplexPersonDAO complexPersonDAO) {
    this.complexPersonDAO = complexPersonDAO;
  }

  public void setComplexPersonPhoneDAO(ComplexPersonPhoneDAO complexPersonPhoneDAO) {
    this.complexPersonPhoneDAO = complexPersonPhoneDAO;
  }

  public void setNameDAO(NameDAO nameDAO) {
    this.nameDAO = nameDAO;
  }

  public void setPersonAddressDAO(PersonAddressDAO personAddressDAO) {
    this.personAddressDAO = personAddressDAO;
  }

  public void setPersonEthnicityDAO(PersonEthnicityDAO personEthnicityDAO) {
    this.personEthnicityDAO = personEthnicityDAO;
  }

  public void setPersonIdDAO(PersonIdDAO personIdDAO) {
    this.personIdDAO = personIdDAO;
  }
  
  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }

  public void setPersonRaceDAO(PersonRaceDAO personRaceDAO) {
    this.personRaceDAO = personRaceDAO;
  }
  
  public void setCapsCaseDAO(CapsCaseDAO capsCaseDAO) {
	    this.capsCaseDAO = capsCaseDAO;
	  }

  public void setComplexStagePersonLinkDAO(ComplexStagePersonLinkDAO complexStagePersonLinkDAO) {
    this.complexStagePersonLinkDAO = complexStagePersonLinkDAO;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }
  
  public void setStageDAO(StageDAO stageDAO) {
	    this.stageDAO = stageDAO;
	  }
  
  public void setWorkloadDAO(WorkloadDAO workloadDAO) {
    this.workloadDAO = workloadDAO;
  }

  
  
  public PersListAudOutRec savePersonList(PersListAudInRec cint02si) throws ServiceException {

    PersListAudOutRec cint02so = new PersListAudOutRec();
    PersListAudStruct persListAudStruct = cint02si.getPersListAudStruct();
    String cdScrDataAction = persListAudStruct.getSzCdScrDataAction();
    String cReqFuncCd = cdScrDataAction;
    // Person and Stage Person Link
    // CallCINT06D
    
    Date dob = DateHelper.toJavaDate(cint02si.getPersListAudStruct().getDtDtPersonBirth());
    //SMS 57690 Page to display confirmation message if duplicate found in Update mode also
    if (ServiceConstants.REQ_FUNC_CD_ADD.equals(cReqFuncCd) || ServiceConstants.REQ_FUNC_CD_UPDATE.equals(cReqFuncCd)) {
      boolean bIndSsnConfirm = cint02si.getPersListAudStruct().getBIndSsnConfirm();
      if (cint02si.getCINT14WLB_ARRAY() != null) {
        Enumeration<CINT14WLB> cint14wlbEnum = cint02si.getCINT14WLB_ARRAY().enumerateCINT14WLB();
        while (cint14wlbEnum.hasMoreElements()) {
          CINT14WLB cint14wlb = cint14wlbEnum.nextElement();
          String ssn = cint14wlb.getSzNbrPersonIdNumber();
          if (bIndSsnConfirm && !("".equals(ssn))) {
            List<Object[]> personsWithSsn = personDAO.findPersonBySsn(ssn);
            if (!personsWithSsn.isEmpty()) {
              throw new ServiceException(Messages.MSG_INT_DUPLICATE_NOT_ALLOWED);
            }
          }
        }
      }
      
      if(ArchitectureConstants.Y.equals(cint02si.getPersListAudStruct().getBScrIndNameDataChange()) ||
                      ArchitectureConstants.Y.equals(cint02si.getPersListAudStruct().getBScrIndDOBDataChange())){
        if(cint02si.getROWCINV26SIG00_ARRAY() != null){
          Enumeration<ROWCINV26SIG00> rowEnumeration = cint02si.getROWCINV26SIG00_ARRAY().enumerateROWCINV26SIG00();
          while (rowEnumeration.hasMoreElements()) {
            ROWCINV26SIG00 rowcinv26sig00 = rowEnumeration.nextElement();
            String firstName = rowcinv26sig00.getSzNmNameFirst();
            String lastName = rowcinv26sig00.getSzNmNameLast();
            if (bIndSsnConfirm && !("".equals(firstName)) && !("".equals(lastName)) && dob != null) {
              List<Person> persons = personDAO.findPersonByFirstNameLastNameDob(firstName, lastName, dob);
              if (!persons.isEmpty()) {
                throw new ServiceException(Messages.MSG_INT_DUPLICATE_NOT_ALLOWED);
              }
            }
          }
        }else{
          String firstName = cint02si.getPersListAudStruct().getSzNmNameFirst();
          String lastName = cint02si.getPersListAudStruct().getSzNmNameLast();
          if (bIndSsnConfirm && !("".equals(firstName)) && !("".equals(lastName)) && dob != null) {
            List<Person> persons = personDAO.findPersonByFirstNameLastNameDob(firstName, lastName, dob);
            if (!persons.isEmpty()) {
              throw new ServiceException(Messages.MSG_INT_DUPLICATE_NOT_ALLOWED);
            }
          }
        }
      }
    }
    
    int idPerson = updatePersonData(cReqFuncCd, cint02si.getPersListAudStruct(), cint02si.getBIndPersCancelHist(),
                                    cint02si.getROWCINV26SIG00_ARRAY(), cint02si.getCINT14WLB_ARRAY());

    cint02so.setUlIdPerson(idPerson);
    cint02so.setLSysNbrUniqueLBKey(persListAudStruct.getLSysNbrUniqueLBKey());

    if (idPerson == 0) {
      idPerson = persListAudStruct.getUlIdPerson();
    } else {
      persListAudStruct.setUlIdPerson(idPerson);
    }
    // Address
    if (ServiceConstants.FND_YES.equals(persListAudStruct.getBScrIndAddrDataChange())) {

      // CallCCMNA8D
      LdIdAddress_ARRAY idArray = addressListAud(cint02si.getROWCCMN44SIG00_ARRAY());
      cint02so.setLdIdAddress_ARRAY(idArray);

      // CallCCMNA9D
      cint02so.setUlIdAddrPersonLink_ARRAY(addressPersonLinkAud(idPerson, idArray, cint02si.getROWCCMN44SIG00_ARRAY()));

      // SMS 76324 Updating the county displayed on the workload if the Primary Caretakers Primary address changes 
      int idStage = persListAudStruct.getUlIdStage();
      Person primaryCaretaker = stagePersonLinkDAO.findStagePersonLinkPrimaryCaretaker(idStage);
      Stage stage = stageDAO.findStageByIdStage(idStage);

      if (primaryCaretaker != null && primaryCaretaker.getIdPerson() == idPerson && CodesTables.CSTAGES_INT.equals(stage.getCdStage())) {     
        String personCounty = null;
        String workloadCounty = null;
        PersonAddress personAddress = personAddressDAO.findPrimaryPersonAddressByIdPerson(idPerson);
        if (personAddress != null) {
          personCounty = personAddress.getCdPersonAddrCounty();
        }
        Workload workload = workloadDAO.findWorkloadByIdStage(idStage);
        if (workload != null) {
          workloadCounty = workload.getCdWkldStageCnty();

          if (personAddress != null && !personCounty.equals(workloadCounty)) {
            workloadDAO.updateWklStageCountyByIdStage(idStage, personCounty);
          }
        }
      }
    }

    // Phone
    if (ServiceConstants.FND_YES.equals(persListAudStruct.getBScrIndPhoneDataChange())) {
      // CallCCMN95D
      cint02so.setUlIdPersonId_ARRAY(phoneListAud(idPerson, cint02si.getROWCCMN31SI_ARRAY()));
    }
    String indNameDataChange = persListAudStruct.getBScrIndNameDataChange();
    // Name: if person is being added, create default entry in Name table
    if (ServiceConstants.FND_YES.equals(indNameDataChange) || ServiceConstants.REQ_FUNC_CD_ADD.equals(cdScrDataAction)) {
      // CallCINV32D
      cint02so.setUlIdName_ARRAY(nameListAud(idPerson, cint02si.getROWCINV26SIG00_ARRAY()));
    }

    // Name: if person's name has changed update entry in intake allegation table
    if (ServiceConstants.FND_YES.equals(indNameDataChange)) {
      // CallCINT78D (String cdNamePersonFull, int idPerson, int idStage)
      complexIntakeAllegationDAO.updateNameByIdStage(persListAudStruct.getSzNmPersonFull(), idPerson,
                                                     persListAudStruct.getUlIdStage());
    }

    // IDs
    if (ServiceConstants.FND_YES.equals(persListAudStruct.getBScrIndIDDataChange())) {
      // CallCINT18D
      cint02so.setUlIdPersonId_ARRAY(updateIds(cint02si.getCINT14WLB_ARRAY()));
    }

    // Race
    int idPerson_race = cint02so.getUlIdPerson();
    if (ServiceConstants.FND_YES.equals(persListAudStruct.getBScrIndRaceDataChange())) {
      // CallCAUDD5D
      updatePersonRace(idPerson_race, cint02si.getROWCINT02SIG00_ARRAY());
      // CallCAUDD4D
      updatePersonEthnicity(idPerson_race, cint02si.getROWCINT02SIG01_ARRAY());
    }

    return cint02so;
  }

  /**
   * Calls DAM to update Person, Stage_Person_Link and Category tables CallCINT06D
   * 
   * @param cReqFuncCd
   * @param persListAudStruct
   * @param bIndPersCancelHist
   * @param rowcinv26sig00_array
   * @param cint14wlb_array
   * @return The idPerson generated or used by the AUD operation.
   */
  private int updatePersonData(String cReqFuncCd, PersListAudStruct persListAudStruct, String bIndPersCancelHist,
                               ROWCINV26SIG00_ARRAY rowcinv26sig00_array, CINT14WLB_ARRAY cint14wlb_array)
                                                                                                          throws ServiceException {
    // CallCINT06D
    // Calls DAM to update Person, Stage_Person_Link and Category tables
    String cdStagePersSearchInd = persListAudStruct.getSzCdStagePersSearchInd();

    if (!(VIEWED.equals(cdStagePersSearchInd) || RELATED.equals(cdStagePersSearchInd)
          || LAUNCHED.equals(cdStagePersSearchInd) || UNRELATED.equals(cdStagePersSearchInd))) {
      // noinspection AssignmentToNull
      cdStagePersSearchInd = null;
    }
    Integer idPerson = persListAudStruct.getUlIdPerson();
    int sAge = persListAudStruct.getLNbrPersonAge();

    // STGAP00000529-2 Check for Primary Caretaker
    if (CodesTables.CRELVICT_PK.equals(persListAudStruct.getSzCdStagePersRelInt())) {
      Person primaryCaretaker = stagePersonLinkDAO
                                                  .findStagePersonLinkPrimaryCaretaker(persListAudStruct.getUlIdStage());
      if ((primaryCaretaker != null)
          && (primaryCaretaker.getIdPerson().intValue() != persListAudStruct.getUlIdPerson())) {

        throw new ServiceException(Messages.MSG_INT_PK_EXIST);
      }
    }

    // cint06d
    if (ServiceConstants.REQ_FUNC_CD_ADD.equals(cReqFuncCd)) {
      idPerson = complexPersonDAO.insertPerson(sAge, DateHelper.toJavaDate(persListAudStruct.getDtDtPersonBirth()),
                                               DateHelper.toJavaDate(persListAudStruct.getDtDtPersonDeath()),
                                               persListAudStruct.getCdPersonStatus(),
                                               persListAudStruct.getSzCdPersonDeath(),
                                               persListAudStruct.getSzCdPersonMaritalStatus(),
                                               persListAudStruct.getSzCdPersonLanguage(),
                                               persListAudStruct.getSzCdDisasterRlf(),
                                               persListAudStruct.getCCdPersonSex(),
                                               persListAudStruct.getSzNmPersonFull(),
                                               persListAudStruct.getSzCdPersonEthnicGroup(),
                                               persListAudStruct.getBIndPersonDobApprox(),
                                               persListAudStruct.getSzCdStagePersRole(),
                                               persListAudStruct.getSzCdStagePersType(), cdStagePersSearchInd,
                                               persListAudStruct.getSzTxtStagePersNotes(),
                                               persListAudStruct.getSzCdStagePersRelInt(),
                                               persListAudStruct.getBIndStagePersReporter(),
                                               persListAudStruct.getUlIdStage(),
                                               persListAudStruct.getBIndStagePersInLaw(),
                                               persListAudStruct.getSzCdStagePersLstSort(),
                                               persListAudStruct.getSzCdCategoryCategory(),
                                               persListAudStruct.getSzCdIncmgPersTitle(),
                                               persListAudStruct.getSzCdIncmgPersMatchType(),
                                               persListAudStruct.getSzCdIncmgPersPrfCitizenship(),
                                               persListAudStruct.getCIndIncmgPersUsCitizen(),
                                               persListAudStruct.getSzCdIncmgPersImmgrtnStatus(),
                                               persListAudStruct.getSzCdIncmgPersCntryOrigin(),
                                               persListAudStruct.getSzTxtStagePersOthRelations(),
                                               persListAudStruct.getUlIdSecondaryCareGiver(),
                                               persListAudStruct.getCdPKHouseholdMember());

    } else if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(cReqFuncCd)) {
      complexPersonDAO.updatePerson(sAge, DateHelper.toJavaDate(persListAudStruct.getDtDtPersonDeath()),
                                    DateHelper.toJavaDate(persListAudStruct.getDtDtPersonBirth()),
                                    persListAudStruct.getSzCdPersonDeath(),
                                    persListAudStruct.getSzCdPersonMaritalStatus(),
                                    persListAudStruct.getSzCdPersonLanguage(), persListAudStruct.getSzCdDisasterRlf(),
                                    persListAudStruct.getCCdPersonSex(), persListAudStruct.getSzNmPersonFull(),
                                    persListAudStruct.getSzCdPersonEthnicGroup(),
                                    persListAudStruct.getBIndPersonDobApprox(), bIndPersCancelHist,
                                    persListAudStruct.getUlIdPerson(), persListAudStruct.getSzCdStagePersRole(),
                                    persListAudStruct.getSzCdStagePersType(), cdStagePersSearchInd,
                                    persListAudStruct.getSzCdStagePersRelInt(),
                                    persListAudStruct.getBIndStagePersReporter(),
                                    persListAudStruct.getBIndStagePersInLaw(), 0, // idStagePersonLink - not needed;
                                    // updated using idPerson and idStage
                                    persListAudStruct.getSzTxtStagePersNotes(), null, persListAudStruct.getUlIdStage(),
                                    persListAudStruct.getSzCdIncmgPersTitle(),
                                    persListAudStruct.getSzCdIncmgPersMatchType(),
                                    persListAudStruct.getSzCdIncmgPersPrfCitizenship(),
                                    persListAudStruct.getCIndIncmgPersUsCitizen(),
                                    persListAudStruct.getSzCdIncmgPersImmgrtnStatus(),
                                    persListAudStruct.getSzCdIncmgPersCntryOrigin(),
                                    persListAudStruct.getSzTxtStagePersOthRelations(),
                                    persListAudStruct.getUlIdSecondaryCareGiver(),
                                    persListAudStruct.getCdPKHouseholdMember());

    } else if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(cReqFuncCd)) {
      complexStagePersonLinkDAO.deleteStagePersonLink(persListAudStruct.getUlIdStage(),
                                                      persListAudStruct.getUlIdPerson());
    } else {
      throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
    }
    // Put valid Person ID and unique key in output message
    if (idPerson != 0) {
      // Populate with ulIdPerson for further AUD
      // Name

      if (rowcinv26sig00_array != null) {
        for (Enumeration rowcinv26sig00_enum = rowcinv26sig00_array.enumerateROWCINV26SIG00(); rowcinv26sig00_enum
                                                                                                                  .hasMoreElements();) {
          ROWCINV26SIG00 row = (ROWCINV26SIG00) rowcinv26sig00_enum.nextElement();
          if ((null != row.getSzCdScrDataAction()) && (idPerson != row.getUlIdPerson())) {
            row.setUlIdPerson(idPerson != null ? idPerson : 0);
          }
        }
      }
      // IDs

      if (cint14wlb_array != null) {
        for (Enumeration cint14wlb_enum = cint14wlb_array.enumerateCINT14WLB(); cint14wlb_enum.hasMoreElements();) {
          CINT14WLB row = (CINT14WLB) cint14wlb_enum.nextElement();
          if ((null != row.getSzCdScrDataAction()) && (idPerson != row.getUlIdPerson())) {
            row.setUlIdPerson(idPerson != null ? idPerson : 0);
          }
        }
      }
    }
    return idPerson;
  }

  /**
   * Calls the Address List AUD CallCCMNA8D
   * 
   * @param rowccmn44sig00_array
   * @return LdIdAddress_ARRAY
   */
  private LdIdAddress_ARRAY addressListAud(ROWCCMN44SIG00_ARRAY rowccmn44sig00_array) throws ServiceException {
    // CallCCMNA8D
    LdIdAddress_ARRAY array = new LdIdAddress_ARRAY();
    for (Enumeration rowccmn44sig00_enum = rowccmn44sig00_array.enumerateROWCCMN44SIG00(); rowccmn44sig00_enum
                                                                                                              .hasMoreElements();) {
      ROWCCMN44SIG00 row = (ROWCCMN44SIG00) rowccmn44sig00_enum.nextElement();
      // ccmna8d
      String cdScrDataAction = row.getSzCdScrDataAction();
      int idAddress = row.getLdIdAddress();
      if (ServiceConstants.REQ_FUNC_CD_ADD.equals(row.getSzCdScrDataAction())) {
        idAddress = personAddressDAO.insertPersonAddressWithSeqPersonAddress(row.getSzAddrPersAddrStLn1(),
                                                                             row.getSzAddrPersAddrStLn2(),
                                                                             row.getSzAddrCity(), row.getLAddrZip(),
                                                                             row.getSzAddrPersAddrAttn(),
                                                                             row.getSzTxtPersonEmail(),
                                                                             row.getSzCdAddrCounty(),
                                                                             row.getSzCdAddrState());
        row.setLdIdAddress(idAddress);
      } else if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(cdScrDataAction)) {
        personAddressDAO.updatePersonAddress(DateHelper.MAX_JAVA_DATE, row.getSzAddrPersAddrStLn1(),
                                             row.getSzAddrPersAddrStLn2(), row.getSzAddrCity(), row.getLAddrZip(),
                                             row.getSzAddrPersAddrAttn(), row.getSzTxtPersonEmail(),
                                             row.getSzCdAddrCounty(), row.getSzCdAddrState(), idAddress);
      } else if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(row.getSzCdScrDataAction())) {
        // Do nothing since there is no DELETE logic in ccmna8d.
      } else {
        throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
      }
      // If we just successfully added a row, we need to get the id address
      if (idAddress != 0) {
        // always add idAddress so that the array remains in sync
        array.addLdIdAddress(idAddress);
      }
    }
    return array;
  }

  /**
   * Calls the Address Person Link AUD CallCCMNA9D
   * 
   * @param idPerson
   * @param idArray
   * @param rowccmn44sig00_array
   * @return A populated {@link UlIdAddrPersonLink_ARRAY} object.
   */
  private UlIdAddrPersonLink_ARRAY addressPersonLinkAud(int idPerson, LdIdAddress_ARRAY idArray,
                                                        ROWCCMN44SIG00_ARRAY rowccmn44sig00_array)
                                                                                                  throws ServiceException {

    // Keep track of the timestamps on the Start and End
    // dates. The primary addresses in the input message are sorted in
    // reverse-modified order (i.e., the most recent primary name added or
    // modified will be at beginning of the input message). To ensure that
    // the addresses receive the timestamps in the proper order, we need to
    // process the list in reverse order. This requires a change to the
    // for loop
    UlIdAddrPersonLink_ARRAY array = new UlIdAddrPersonLink_ARRAY();

    for (int i = rowccmn44sig00_array.getROWCCMN44SIG00Count() - 1; i >= 0; i--) {
      ROWCCMN44SIG00 row = rowccmn44sig00_array.getROWCCMN44SIG00(i);
      // ccmna9d
      int idAPL = row.getUlIdAddrPersonLink();
      if (ServiceConstants.REQ_FUNC_CD_ADD.equals(row.getSzCdScrDataAction())) {

        idAPL = complexAddressPersonLinkDAO
                                           .insertAddressPersonLink(
                                                                    DateHelper.toJavaDate(row.getDtDtPersAddrLinkEnd()),
                                                                    idPerson, idArray.getLdIdAddress(i),
                                                                    row.getBIndPersAddrLinkInvalid(),
                                                                    row.getBIndPersAddrLinkPrimary(),
                                                                    row.getSzTxtPersAddrCmnts(),
                                                                    row.getSzCdPersAddrLinkType(),
                                                                    row.getBIndRemovalHome());
      } else if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(row.getSzCdScrDataAction())) {
        complexAddressPersonLinkDAO.updateAddressPersonLink(DateHelper.toJavaDate(row.getDtDtPersAddrLinkEnd()), idAPL,
                                                            row.getSzCdPersAddrLinkType(),
                                                            row.getBIndPersAddrLinkInvalid(),
                                                            row.getBIndPersAddrLinkPrimary(),
                                                            row.getSzTxtPersAddrCmnts(),
                                                            row.getBIndRemovalHome(),
                                                            DateHelper.MAX_JAVA_DATE);
      } else if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(row.getSzCdScrDataAction())) {
        // Do nothing since there is no DELETE logic in ccmna9d.
      } else {
        throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
      }
      array.addUlIdAddrPersonLink(idAPL);
    }
    return array;
  }

  /**
   * Calls the Phone List AUD CallCCMN95D
   * 
   * @param rowccmn31si_array
   * @return UlIdPersonId_ARRAY
   */
  private UlIdPersonId_ARRAY phoneListAud(int idPerson, ROWCCMN31SI_ARRAY rowccmn31si_array) throws ServiceException {
    /**
     * To ensure that the timestamps are in the proper order, we need to * process the list in reverse order. This
     * requires a change to the * for loop
     */
    UlIdPersonId_ARRAY array = new UlIdPersonId_ARRAY();

    for (Enumeration rowccmn31si_enum = rowccmn31si_array.enumerateROWCCMN31SI(); rowccmn31si_enum.hasMoreElements();) {
      ROWCCMN31SI rowccmn31si = (ROWCCMN31SI) rowccmn31si_enum.nextElement();
      // ccmna8d

      int idPhone = rowccmn31si.getUlIdPhone();
      // ccmn95d
      String szCdScrDataAction = rowccmn31si.getSzCdScrDataAction();
      if (ServiceConstants.REQ_FUNC_CD_ADD.equals(szCdScrDataAction)) {
        idPhone = complexPersonPhoneDAO.insertPersonPhone(DateHelper.toJavaDate(rowccmn31si.getDtDtPersonPhoneEnd()),
                                                          idPerson, rowccmn31si.getSzCdPhoneType(),
                                                          rowccmn31si.getLNbrPhone(),
                                                          rowccmn31si.getLNbrPhoneExtension(),
                                                          rowccmn31si.getBIndPersonPhonePrimary(),
                                                          rowccmn31si.getBIndPersonPhoneInvalid(),
                                                          rowccmn31si.getSzTxtPhoneComments(),
                                                          rowccmn31si.getUlIdPhone(), DateHelper.MAX_JAVA_DATE);

      } else if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(szCdScrDataAction)) {
        complexPersonPhoneDAO.updatePersonPhone(DateHelper.toJavaDate(rowccmn31si.getDtDtPersonPhoneEnd()), idPerson,
                                                rowccmn31si.getSzCdPhoneType(), rowccmn31si.getLNbrPhone(),
                                                rowccmn31si.getLNbrPhoneExtension(),
                                                rowccmn31si.getBIndPersonPhonePrimary(),
                                                rowccmn31si.getBIndPersonPhoneInvalid(),
                                                rowccmn31si.getSzTxtPhoneComments(), idPhone, DateHelper.MAX_JAVA_DATE);
      } else if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(szCdScrDataAction)) {
        // Do nothing since there is no DELETE logic in ccmn95d.
      } else {
        throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
      }
      array.addUlIdPersonId(idPhone);
    }
    return array;
  }

  /**
   * This calls a DAM which will insert or update on the Name table CallCINV32D
   * 
   * @param idPerson
   * @param rowcinv26sig00_array
   * @return A populuated {@link UlIdName_ARRAY} object.
   */
  private UlIdName_ARRAY nameListAud(int idPerson, ROWCINV26SIG00_ARRAY rowcinv26sig00_array) throws ServiceException {
    UlIdName_ARRAY array = new UlIdName_ARRAY();
    if (rowcinv26sig00_array != null) {
      for (int i = rowcinv26sig00_array.getROWCINV26SIG00Count() - 1; i >= 0; i--) {
        ROWCINV26SIG00 rowcinv26sig00 = rowcinv26sig00_array.getROWCINV26SIG00(i);
        int idName = rowcinv26sig00.getUlIdName();
        Date dtLastUpdate = rowcinv26sig00.getTsLastUpdate();
        if (ServiceConstants.REQ_FUNC_CD_ADD.equals(rowcinv26sig00.getSzCdScrDataAction())) {
          // cinv32d
          idName = complexNameDAO
                                 .insertNameCheckDtNameEndDateForNull(
                                                                      rowcinv26sig00.getSzCdNameSuffix(),
                                                                      DateHelper
                                                                                .toJavaDate(rowcinv26sig00
                                                                                                          .getDtDtNameEndDate()),
                                                                      idName, idPerson,
                                                                      rowcinv26sig00.getBIndNameInvalid(),
                                                                      rowcinv26sig00.getBIndNamePrimary(),
                                                                      rowcinv26sig00.getSzNmNameFirst(),
                                                                      rowcinv26sig00.getSzNmNameLast(),
                                                                      rowcinv26sig00.getSzNmNameMiddle());

        } else if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(rowcinv26sig00.getSzCdScrDataAction())) {
          // cinv32d
          complexNameDAO
                        .updateNameCheckDtNameEndDateForNull(
                                                             rowcinv26sig00.getSzCdNameSuffix(),
                                                             DateHelper.toJavaDate(rowcinv26sig00.getDtDtNameEndDate()),
                                                             idName, idPerson, rowcinv26sig00.getBIndNameInvalid(),
                                                             rowcinv26sig00.getBIndNamePrimary(),
                                                             rowcinv26sig00.getSzNmNameFirst(),
                                                             rowcinv26sig00.getSzNmNameLast(),
                                                             rowcinv26sig00.getSzNmNameMiddle(), dtLastUpdate);
        } else if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(rowcinv26sig00.getSzCdScrDataAction())) {
          // NOTE: cinv32d supports delete but since MAX_JAVA_DATE is passed as dtLastUpdate
          // in the original code, any attempted delete would fail. It is included here in order
          // to be consistent with cinv32d.
          // cinv32d
          nameDAO.deleteName(idName, dtLastUpdate);
        } else {
          throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
        }
        array.addUlIdName(idName);
      }
    }
    return array;
  }

  /**
   * update person Ids CallCINT18D
   * 
   * @param cint14wlb_array
   */
  private UlIdPersonId_ARRAY updateIds(CINT14WLB_ARRAY cint14wlb_array) throws ServiceException {
    // cint18d
    UlIdPersonId_ARRAY array = new UlIdPersonId_ARRAY();
    for (Enumeration cint14wlb_enum = cint14wlb_array.enumerateCINT14WLB(); cint14wlb_enum.hasMoreElements();) {
      CINT14WLB row = (CINT14WLB) cint14wlb_enum.nextElement();

      // If the end date host variable is filled with a value then that
      // value is based on the date of the end date sent through the
      // output message only. The exact current date is needed.
      Date dtNow = new Date();
      Date dtPersonIdEnd;
      if (!DateHelper.isNull(row.getDtPersonIDEnd())) {
        dtPersonIdEnd = dtNow;
      } else {
        dtPersonIdEnd = DateHelper.toJavaDate(row.getDtPersonIDEnd());
      }
      int idPersonId = row.getUlIdPersonId();
      if (ServiceConstants.REQ_FUNC_CD_ADD.equals(row.getSzCdScrDataAction())) {
        idPersonId = personIdDAO.insertPersonIdByStartEnd(row.getUlIdPerson(), row.getSzNbrPersonIdNumber(),
                                                          row.getSzCdPersonIdType(), row.getSzDescPersonID(),
                                                          row.getBIndPersonIDInvalid(), dtNow, // dtPersonIdStart
                                                          dtPersonIdEnd, row.getBIndValidateByInterface());
      } else if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(row.getSzCdScrDataAction())) {
        personIdDAO.updatePersonIdEndDate(row.getUlIdPerson(), row.getUlIdPersonId(), row.getSzNbrPersonIdNumber(),
                                          row.getSzCdPersonIdType(), row.getSzDescPersonID(),
                                          row.getBIndPersonIDInvalid(), dtPersonIdEnd,
                                          row.getBIndValidateByInterface(), DateHelper.MAX_JAVA_DATE);

      } else if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(row.getSzCdScrDataAction())) {
        personIdDAO.deletePersonId(row.getUlIdPerson(), DateHelper.MAX_JAVA_DATE);
      } else {
        throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
      }
      array.addUlIdPersonId(idPersonId);
    } // end for
    return (array);
  }

  /**
   * Update PersonRace table CallCAUDD5D
   * 
   * @param idPerson
   * @param rowcint02sig00_array
   * @param cReqFuncCd
   * @throws ServiceException
   */
  private void updatePersonRace(int idPerson, ROWCINT02SIG00_ARRAY rowcint02sig00_array) throws ServiceException {
    
    if (!NullHelper.isEmptyOrNull(rowcint02sig00_array)) {
      Enumeration rowcint02sig00_enum = rowcint02sig00_array.enumerateROWCINT02SIG00();
      while (rowcint02sig00_enum.hasMoreElements()) {
        ROWCINT02SIG00 row = (ROWCINT02SIG00) rowcint02sig00_enum.nextElement();
        String cReqFuncCd = row.getSzCdScrDataAction();

        if (!StringHelper.isValid(row.getSzCdPersonRace())) {
          break;
        }
        // caudd5d
        if (ServiceConstants.REQ_FUNC_CD_ADD.equals(cReqFuncCd)) {
          PersonRace pr = new PersonRace();

          Person person = (Person) getPersistentObject(Person.class, idPerson);
          pr.setPerson(person);

          pr.setCdRace(row.getSzCdPersonRace());
          
          long raceExists = personRaceDAO.findPersonRaceByIdPersonCdPersonRace(idPerson, row.getSzCdPersonRace());
          if(raceExists < 1){
          personRaceDAO.savePersonRace(pr);
          }

        } else if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(cReqFuncCd)) {
          personRaceDAO.deletePersonRaceByIdPersonAndCdPersonRace(idPerson, row.getSzCdPersonRace());
        } else if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(cReqFuncCd)) {
          // Do nothing since there is no UPDATE logic in caudd5d.
        } else {
          throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
        }
      }
    }
  }

  /**
   * Update PersonEthnicity table CallCAUDD4D
   * 
   * @param idPerson
   * @param rowcint02sig01_array
   * @param cReqFuncCd
   * @throws ServiceException
   */
  private void updatePersonEthnicity(int idPerson, ROWCINT02SIG01_ARRAY rowcint02sig01_array) throws ServiceException {
    // always delete from PersonEthnicity table before inserts.

    String cReqFuncCd = ServiceConstants.REQ_FUNC_CD_ADD;
    if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(cReqFuncCd) || ServiceConstants.REQ_FUNC_CD_ADD.equals(cReqFuncCd)) {
      // caudd4d
      personEthnicityDAO.deletePersonEthnicity(idPerson);
      if (!NullHelper.isEmptyOrNull(rowcint02sig01_array)) {
        // Loop through ethnicities
        Enumeration rowcint02sig01_enum = rowcint02sig01_array.enumerateROWCINT02SIG01();
        while (rowcint02sig01_enum.hasMoreElements()) {
          ROWCINT02SIG01 row = (ROWCINT02SIG01) rowcint02sig01_enum.nextElement();
          if (!StringHelper.isValid(row.getSzCdPersonEthnicity())) {
            break;
          }
          personEthnicityDAO.insertPersonEthnicity(idPerson, row.getSzCdPersonEthnicity());
        }
      }

    } else if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(cReqFuncCd)) {
      // Do nothing since there is no UPDATE logic in caudd4d.
    } else {
      throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
    }
  }
}
