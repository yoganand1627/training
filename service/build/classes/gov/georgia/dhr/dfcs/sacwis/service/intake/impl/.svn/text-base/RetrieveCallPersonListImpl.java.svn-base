package gov.georgia.dhr.dfcs.sacwis.service.intake.impl;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexStagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDtlDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.RelationshipDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.AddressPersonLink;
import gov.georgia.dhr.dfcs.sacwis.db.Name;
import gov.georgia.dhr.dfcs.sacwis.db.PersonAddress;
import gov.georgia.dhr.dfcs.sacwis.db.PersonDtl;
import gov.georgia.dhr.dfcs.sacwis.db.PersonPhone;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.intake.RetrieveCallPersonList;
import gov.georgia.dhr.dfcs.sacwis.structs.input.PersListInRec;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT26SO_OTHER_RELATIONSHIP;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT26SO_OTHER_RELATIONSHIP_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PersListOutRec;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PersListRtrvStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PersListRtrvStruct_ARRAY;

import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
* Change History:
* Date      User              Description
* --------  ----------------  --------------------------------------------------
* 09/30/2009  bgehlot         STGAP00015485: MR-56 updates 
* </pre>
*/

public class RetrieveCallPersonListImpl extends BaseServiceImpl implements RetrieveCallPersonList {

  private static final String SECONDARY_CAREGIVER = "SC";

  private ComplexStagePersonLinkDAO complexStagePersonLinkDAO = null;

  private PersonDtlDAO personDtlDAO = null;
  
  private StagePersonLinkDAO stagePersonLinkDAO = null;

  private RelationshipDAO relationshipDAO = null;

  public void setComplexStagePersonLinkDAO(ComplexStagePersonLinkDAO complexStagePersonLinkDAO) {
    this.complexStagePersonLinkDAO = complexStagePersonLinkDAO;
  }

  public void setPersonDtlDAO(PersonDtlDAO personDtlDAO) {
    this.personDtlDAO = personDtlDAO;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public void setRelationshipDAO(RelationshipDAO relationshipDAO) {
    this.relationshipDAO = relationshipDAO;
  }

  public PersListOutRec retrieveCallPersonList(PersListInRec cint26in) throws ServiceException {
    PersListOutRec persListOutRec = new PersListOutRec();

    int idStage = cint26in.getUlIdStage();
    String cdIncmgStatus = cint26in.getCdIncmgStatus();

    Date dtSysTsQuery;
    if (CodesTables.CINCMGST_CLD.equals(cdIncmgStatus)) {
      dtSysTsQuery = cint26in.getTsIncmgCallDisp();
    } else {
      dtSysTsQuery = DateHelper.MAX_JAVA_DATE;
    }

    PersListRtrvStruct_ARRAY persListRtrvStruct_array = new PersListRtrvStruct_ARRAY();
    // cint05d -- ignores SQL_NOT_FOUND
    List<Map> callPersonList = complexStagePersonLinkDAO.findCallPersonList(cdIncmgStatus, idStage, dtSysTsQuery);
    if (callPersonList != null) {
      for (Iterator<Map> it = callPersonList.iterator(); it.hasNext();) {
        Map map = it.next();
        if (map != null) {
          PersListRtrvStruct persListRtrvStruct = createPersListRtrvStruct(map);
          
          
          AddressPersonLink addressPersonLink= (AddressPersonLink) map.get("addressPersonLink");
          
          addAddressPersonLinkInfo(persListRtrvStruct, addressPersonLink);
          
          persListRtrvStruct.setLdIdAddress(addressPersonLink!= null ? addressPersonLink.getPersonAddress().getIdPersonAddr(): 0);
          addName(persListRtrvStruct, (Name) map.get("name"));
          addPersonPhone(persListRtrvStruct, (PersonPhone) map.get("personPhone"));
          persListRtrvStruct.setLScrNbrOfAddrs((String) map.get("lScrNbrOfAddrs"));
          persListRtrvStruct.setLScrNbrPhoneNbrs((String) map.get("lScrNbrPhoneNbrs"));
          persListRtrvStruct.setBScrIndAlias((String) map.get("bScrIndAlias"));
          persListRtrvStruct.setBScrIndPersIdentifiers((String) map.get("bScrIndPersIdentifiers"));
          persListRtrvStruct_array.addPersListRtrvStruct(persListRtrvStruct);
        }
      }
    }
    persListOutRec.setPersListRtrvStruct_ARRAY(persListRtrvStruct_array);

    addRelationshipList(persListOutRec, idStage);
    return persListOutRec;
  }

  private PersListRtrvStruct createPersListRtrvStruct(Map map) {
    PersListRtrvStruct persListRtrvStruct = new PersListRtrvStruct();

    int idPerson = getInt(map.get("idPerson"));

    persListRtrvStruct.setSzCdStagePersType((String) map.get("cdStagePersType"));
    persListRtrvStruct.setSzCdStagePersRole((String) map.get("cdStagePersRole"));
    persListRtrvStruct.setSzNmPersonFull((String) map.get("nmPersonFull"));
    persListRtrvStruct.setDtDtPersonBirth(DateHelper.toCastorDate((Date) map.get("dtPersHistBirth")));
    persListRtrvStruct.setBIndPersonDobApprox((String) map.get("indPersHistDobApprox"));
    persListRtrvStruct.setLNbrPersonAge(getInt(map.get("nbrPersHistAge")));

    persListRtrvStruct.setCCdPersonSex((String) map.get("cdPersHistSex"));
    persListRtrvStruct.setSzCdStagePersRelInt((String) map.get("cdStagePersRelInt"));
    
    //Added new field Member of Primary Caretaker's household
    persListRtrvStruct.setCdPKHouseholdMember((String) map.get("cdPkHshdMember"));
    
    persListRtrvStruct.setBIndStagePersReporter((String) map.get("indStagePersReporter"));
    persListRtrvStruct.setSzCdStagePersSearchInd((String) map.get("cdStagePersSearchInd"));
    persListRtrvStruct.setBIndStagePersInLaw((String) map.get("indStagePersInLaw"));

    persListRtrvStruct.setDtDtPersonDeath(DateHelper.toCastorDate((Date) map.get("dtPersHistDeath")));
    persListRtrvStruct.setSzCdPersonDeath((String) map.get("cdPersHistDeath"));
    persListRtrvStruct.setSzCdPersonMaritalStatus((String) map.get("cdPersHistMaritalStat"));
    persListRtrvStruct.setSzCdPersonLanguage((String) map.get("cdPersHistLanguage"));
    persListRtrvStruct.setSzCdDisasterRlf((String) map.get("cdDisasterRlf"));

    persListRtrvStruct.setSzCdPersonEthnicGroup((String) map.get("cdPersHistEthnic"));
    persListRtrvStruct.setSzTxtStagePersNotes((String) map.get("txtStagePersNotes"));
    persListRtrvStruct.setUlIdStage(getInt(map.get("idStage")));
    persListRtrvStruct.setUlIdPerson(getInt(map.get("idPerson")));
    persListRtrvStruct.setSzCdStagePersLstSort((String) map.get("cdStagePersLstSort"));
    persListRtrvStruct.setSzCdNameSuffix((String) map.get("cdNameSuffix"));
    persListRtrvStruct.setSzCdIncmgPersTitle((String) map.get("cdPersonTitle"));
    persListRtrvStruct.setSzCdIncmgPersMatchType((String) map.get("cdMatchType"));
    persListRtrvStruct.setSzCdIncmgPersPrfCitizenship((String) map.get("cdPersonProofCitizenship"));        
    persListRtrvStruct.setSzNbrPersonIdNumber((String)map.get("personSSN"));
    
    
    int personDtlExist = personDtlDAO.findIdPersonDtlByIdPerson(idPerson);
    PersonDtl personDtl = new PersonDtl();
    if(personDtlExist != 0){
      personDtl = (PersonDtl) (PersonDtl) getPersistentObject(PersonDtl.class, idPerson);
    }
    
    persListRtrvStruct.setSzCdIncmgPersImmgrtnStatus(personDtl.getCdPersonCitizenship());    
    persListRtrvStruct.setCIndIncmgPersUsCitizen(personDtl.getIndPersonNoUsBrn());
    persListRtrvStruct.setSzCdIncmgPersCntryOrigin(personDtl.getCdPersonBirthCountry());
    Integer idRelatePersonSecondaryCaregiver = relationshipDAO.findRelationshipIdRelatedPersonByIdPerson(idPerson,
                                                                                                         SECONDARY_CAREGIVER);
    persListRtrvStruct.setUlIdSecondaryCareGiver(
            idRelatePersonSecondaryCaregiver != null ? idRelatePersonSecondaryCaregiver : 0);
    persListRtrvStruct.setSzTxtStagePersOthRelations((String) map.get("txtOtherRelationships"));

    return persListRtrvStruct;
  }

  private void addAddressPersonLinkInfo(PersListRtrvStruct pers, AddressPersonLink apl) {
    if (apl != null && pers != null) {
      pers.setUlIdAddrPersonLink(apl.getIdAddrPersonLink() != null ? apl.getIdAddrPersonLink() : 0);
      pers.setSzCdPersAddrLinkType(apl.getCdPersAddrLinkType());
      PersonAddress personAddress = apl.getPersonAddress();
    
      pers.setSzAddrPersAddrStLn1(personAddress.getAddrPersAddrStLn1());
      pers.setSzAddrPersAddrStLn2(personAddress.getAddrPersAddrStLn2());
      pers.setSzAddrCity(personAddress.getAddrPersonAddrCity());
      pers.setSzCdAddrState(personAddress.getCdPersonAddrState());
      pers.setSzCdAddrCounty(personAddress.getCdPersonAddrCounty());
      pers.setLAddrZip(personAddress.getAddrPersonAddrZip());
      pers.setBIndPersAddrLinkInvalid(apl.getIndPersAddrLinkInvalid());
      pers.setDtDtPersAddrLinkStart(DateHelper.toCastorDate(apl.getDtPersAddrLinkStart()));
      pers.setDtDtPersAddrLinkEnd(DateHelper.toCastorDate(apl.getDtPersAddrLinkEnd()));
      pers.setSzTxtPersAddrCmnts(apl.getTxtPersAddrCmnts());

    }
  }

  private void addName(PersListRtrvStruct pers, Name name) {

    if (pers != null && name != null) {
      pers.setSzNmNameFirst(name.getNmNameFirst());
      pers.setSzNmNameMiddle(name.getNmNameMiddle());
      pers.setSzNmNameLast(name.getNmNameLast());
      pers.setUlIdName(name.getIdName() != null ? name.getIdName() : 0);
      pers.setDtDtNameStartDate(DateHelper.toCastorDate(name.getDtNameStartDate()));
      pers.setDtDtNameEndDate(DateHelper.toCastorDate(name.getDtNameEndDate()));
      pers.setBIndNameInvalid(name.getIndNameInvalid());
      pers.setSzCdNameSuffix(name.getCdNameSuffix());
     
    }
  }

  private void addPersonPhone(PersListRtrvStruct pers, PersonPhone pp) {
    if (pers != null && pp != null) {
      pers.setUlIdPhone(pp.getIdPersonPhone() != null ? pp.getIdPersonPhone() : 0);
      pers.setLNbrPhoneExtension(pp.getNbrPersonPhoneExtension());
      pers.setLNbrPhone(pp.getNbrPersonPhone());
      pers.setSzCdPhoneType(pp.getCdPersonPhoneType());
      pers.setDtDtPersonPhoneStart(DateHelper.toCastorDate(pp.getDtPersonPhoneStart()));
      pers.setDtDtPersonPhoneEnd(DateHelper.toCastorDate(pp.getDtPersonPhoneEnd()));
      pers.setBIndPersonPhoneInvalid(pp.getIndPersonPhoneInvalid());
      pers.setSzTxtPhoneComments(pp.getTxtPersonPhoneComments());
    }

  }

  private void addRelationshipList(PersListOutRec persListOutRec, int idStage) {
    List<Map> relationshipList = stagePersonLinkDAO.findRelationshipByIdStage(idStage);

    if (relationshipList != null && !relationshipList.isEmpty()) {
      CINT26SO_OTHER_RELATIONSHIP_ARRAY cint06soOtherRelationship_array = new CINT26SO_OTHER_RELATIONSHIP_ARRAY();
      
      //-- array size limited to 100, check number of principals and set message if necessary
      if(relationshipList.size() > 100) {
        relationshipList = Collections.unmodifiableList(relationshipList.subList(0, 100));
        cint06soOtherRelationship_array.setError_message(Messages.MSG_PCH_MORE_THAN_100_PRN);
      }
      
      for(Map row : relationshipList) {
        CINT26SO_OTHER_RELATIONSHIP otherRelationship = new CINT26SO_OTHER_RELATIONSHIP();
        otherRelationship.setUlIdPerson(row.get("idPerson") != null ? (Integer) row.get("idPerson") : 0);
        otherRelationship.setSzNmPersonFull((String) row.get("nmPersonFull"));
        cint06soOtherRelationship_array.addCINT26SO_OTHER_RELATIONSHIP(otherRelationship);
      }
      persListOutRec.setCINT26SO_OTHER_RELATIONSHIP_ARRAY(cint06soOtherRelationship_array);
    }
  }

  private int getInt(Object value) {
    if (value == null) {
      return 0;
    } else {
      return (Integer) value;
    }
  }

}
