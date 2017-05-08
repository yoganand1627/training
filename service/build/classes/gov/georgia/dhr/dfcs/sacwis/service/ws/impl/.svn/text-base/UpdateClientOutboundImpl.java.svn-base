package gov.georgia.dhr.dfcs.sacwis.service.ws.impl;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.dao.ClientOutboundDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventPersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.LegalStatusDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonIdDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.db.ClientOutbound;
import gov.georgia.dhr.dfcs.sacwis.db.LegalStatus;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.ws.RetrievePreAdoptiveChildId;
import gov.georgia.dhr.dfcs.sacwis.service.ws.UpdateClientOutbound;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ClientOutboundBean;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ClientOutboundSaveSI;

import java.util.Date;

/**
 * 
 * 
 * <pre>
 *   Change History:
 *   Date      User           Description
 *   --------  --------       --------------------------------------------------
 
 *  08/06/2010 bgehlot        SMS #65398 MR-041 Set the SHINES Person Id of the existing, pre-adoptive child when the record for the newly 
 *                            created post adoptive child is created
 * 
 */

public class UpdateClientOutboundImpl extends BaseServiceImpl implements UpdateClientOutbound {
  private static final String NOT_NEW_SMILE_CLIENT = "N";

  private static final String TARGET_SYSTEM_SMILE = "SML";

  private static final String NEW = "NEW";

  private static final String NAME_HISTORY = "Name History";

  private static final String PERSON_DETAIL = "Person Detail";

  private static final String PERSON_ID = "Person Id";

  private static final String LEGAL_STATUS = "Legal Status";

  private LegalStatusDAO legalStatusDAO;

  private PersonDAO personDAO;

  private PersonIdDAO personIdDAO;

  private StageDAO stageDAO;

  private ClientOutboundDAO clientOutboundDAO;
  
  private RetrievePreAdoptiveChildId retrievePreAdoptiveChildId;

  public void updateClientOutbound(ClientOutboundSaveSI clientOutboundSaveSI) {
    ClientOutboundBean clientOutboundBean = clientOutboundSaveSI.getClientOutboundBean();
    String originatingPage = clientOutboundBean.getCdOriginatingPage();
    if (NAME_HISTORY.equals(originatingPage)) {
      updateClientOutboundForNameHistory(clientOutboundBean, clientOutboundSaveSI);
    } else if (PERSON_DETAIL.equals(originatingPage)) {
      updateClientOutboundForPersonDetail(clientOutboundBean, clientOutboundSaveSI);
    } else if (PERSON_ID.equals(originatingPage)) {
      updateClientOutboundForPersonId(clientOutboundBean, clientOutboundSaveSI);
    } else if (LEGAL_STATUS.equals(originatingPage)) {
      updateClientOutboundForLegalStatus(clientOutboundBean, clientOutboundSaveSI);
    }
  }

  private void updateClientOutboundForNameHistory(ClientOutboundBean clientOutboundBean,
                                                  ClientOutboundSaveSI clientOutboundSaveSI) {
    int idPerson = clientOutboundBean.getIdPerson();
    Person person = personDAO.findPersonByIdPerson(idPerson);
    clientOutboundBean.setDtPersonBirth(person.getDtPersonBirth());
    clientOutboundBean.setCdPersonSex(person.getCdPersonSex());
    clientOutboundBean.setNbrPersonId(getNbrPersonIdNumber(idPerson));
    int crsId = getCRSId(idPerson);
    if (crsId != 0) {
      clientOutboundBean.setNbrCRSId(crsId);
    }
    clientOutboundBean.setTxtMedicaidNumber(getTxtMedicaidNumber(idPerson));
    clientOutboundBean.setCdLegalStatCnty(getLegalStatusCnty(idPerson, clientOutboundSaveSI));
    // Set it as Not a New SMILE Client
    clientOutboundBean.setIndNewClient(NOT_NEW_SMILE_CLIENT);
    ClientOutbound clientOutbound = setClientOutbound(clientOutboundBean, clientOutboundSaveSI.getIdStage());
    clientOutboundDAO.updateClientOutbound(clientOutbound);
  }

  private void updateClientOutboundForPersonDetail(ClientOutboundBean clientOutboundBean,
                                                   ClientOutboundSaveSI clientOutboundSaveSI) {
    int idPerson = clientOutboundBean.getIdPerson();
    clientOutboundBean.setNbrPersonId(getNbrPersonIdNumber(idPerson));
    int crsId = getCRSId(idPerson);
    if (crsId != 0) {
      clientOutboundBean.setNbrCRSId(crsId);
    }
    clientOutboundBean.setTxtMedicaidNumber(getTxtMedicaidNumber(idPerson));
    clientOutboundBean.setCdLegalStatCnty(getLegalStatusCnty(idPerson, clientOutboundSaveSI));
    // Set it as Not a New SMILE Client
    clientOutboundBean.setIndNewClient(NOT_NEW_SMILE_CLIENT);
    ClientOutbound clientOutbound = setClientOutbound(clientOutboundBean, clientOutboundSaveSI.getIdStage());
    clientOutboundDAO.updateClientOutbound(clientOutbound);
  }

  private void updateClientOutboundForPersonId(ClientOutboundBean clientOutboundBean,
                                               ClientOutboundSaveSI clientOutboundSaveSI) {
    int idPerson = clientOutboundBean.getIdPerson();
    Person person = personDAO.findPersonByIdPerson(idPerson);
    clientOutboundBean.setCdPersonSuffix(person.getCdPersonSuffix());
    clientOutboundBean.setNmPersonFirst(person.getNmPersonFirst());
    clientOutboundBean.setNmPersonLast(person.getNmPersonLast());
    clientOutboundBean.setNmPersonMiddle(person.getNmPersonMiddle());
    clientOutboundBean.setDtPersonBirth(person.getDtPersonBirth());
    clientOutboundBean.setCdPersonSex(person.getCdPersonSex());
    if (CodesTables.CNUMTYPE_SSN.equals(clientOutboundBean.getCdStatus())) {
      int crsId = getCRSId(idPerson);
      if (crsId != 0) {
        clientOutboundBean.setNbrCRSId(crsId);
      }
      clientOutboundBean.setTxtMedicaidNumber(getTxtMedicaidNumber(idPerson));
    } else if (CodesTables.CNUMTYPE_CRS_IDNUMBER.equals(clientOutboundBean.getCdStatus())) {
      clientOutboundBean.setNbrPersonId(getNbrPersonIdNumber(idPerson));
      clientOutboundBean.setTxtMedicaidNumber(getTxtMedicaidNumber(idPerson));
    } else if (CodesTables.CNUMTYPE_MEDICAIDMHN_NUMBER.equals(clientOutboundBean.getCdStatus())) {
      clientOutboundBean.setNbrPersonId(getNbrPersonIdNumber(idPerson));
      int crsId = getCRSId(idPerson);
      if (crsId != 0) {
        clientOutboundBean.setNbrCRSId(crsId);
      }
    }
    clientOutboundBean.setCdLegalStatCnty(getLegalStatusCnty(idPerson, clientOutboundSaveSI));
    // Set it as Not a New SMILE Client
    clientOutboundBean.setIndNewClient(NOT_NEW_SMILE_CLIENT);
    ClientOutbound clientOutbound = setClientOutbound(clientOutboundBean, clientOutboundSaveSI.getIdStage());
    clientOutboundDAO.updateClientOutbound(clientOutbound);
  }

  private void updateClientOutboundForLegalStatus(ClientOutboundBean clientOutboundBean, ClientOutboundSaveSI clientOutboundSaveSI) {
    int idPerson = clientOutboundBean.getIdPerson();
    Person person = personDAO.findPersonByIdPerson(idPerson);
    clientOutboundBean.setCdPersonSuffix(person.getCdPersonSuffix());
    clientOutboundBean.setNmPersonFirst(person.getNmPersonFirst());
    clientOutboundBean.setNmPersonLast(person.getNmPersonLast());
    clientOutboundBean.setNmPersonMiddle(person.getNmPersonMiddle());
    clientOutboundBean.setDtPersonBirth(person.getDtPersonBirth());
    clientOutboundBean.setCdPersonSex(person.getCdPersonSex());
    clientOutboundBean.setDtPersonBirth(person.getDtPersonBirth());
    clientOutboundBean.setCdPersonSex(person.getCdPersonSex());
    clientOutboundBean.setNbrPersonId(getNbrPersonIdNumber(idPerson));
    int crsId = getCRSId(idPerson);
    if (crsId != 0) {
      clientOutboundBean.setNbrCRSId(crsId);
    }
    clientOutboundBean.setTxtMedicaidNumber(getTxtMedicaidNumber(idPerson));
    // Set it as Not a New SMILE Client.
    clientOutboundBean.setIndNewClient(NOT_NEW_SMILE_CLIENT);
    ClientOutbound clientOutbound = setClientOutbound(clientOutboundBean, clientOutboundSaveSI.getIdStage());
    clientOutboundDAO.updateClientOutbound(clientOutbound);
  }

  private String getNbrPersonIdNumber(int personId) {
    return personIdDAO.findNonEndDatePersonSSN(personId) != null ? personIdDAO.findNonEndDatePersonSSN(personId) : "";
  }

  private int getCRSId(int personId) {
    String strCRSId = personIdDAO.findNonEndDatePersonCRSId(personId) != null ? personIdDAO
                                                                                           .findNonEndDatePersonCRSId(personId)
                                                                             : "";
    if (strCRSId.length() > 0) {
      try {
        return Integer.parseInt(strCRSId);
      } catch (NumberFormatException nfe) {
        throw new ServiceException(Messages.MSG_CRS_ID_NOT_A_NUMBER);
      }
    } else {
      return 0;
    }
  }

  private String getTxtMedicaidNumber(int personId) {
    return personIdDAO.findNonEndDatePersonMedicaid(personId) != null ? personIdDAO
                                                                                   .findNonEndDatePersonMedicaid(personId)
                                                                     : "";
  }

  private String getLegalStatusCnty(int personId, ClientOutboundSaveSI clientOutboundSaveSI) {
    String strLegalStatusCnty = null;
    // Get the legal status county code
    LegalStatus legalStatus = legalStatusDAO.findMostRecentLegalStatusByIdPerson(personId);
    // Check if row exist in legal status for the client from LEGAL_STATUS table and
    // for Most recent effective date and get the Legal Stat county code.
    if (legalStatus != null) {
      if (legalStatus.getCdLegalStatCnty() != null) {
        strLegalStatusCnty = legalStatus.getCdLegalStatCnty();
      }
    }

    if (strLegalStatusCnty == null) {
      Stage stage = stageDAO.findStageByIdStage(clientOutboundSaveSI.getIdStage());
      if (stage != null) {
        strLegalStatusCnty = stage.getCdStageCnty();
      }
    }

    if (strLegalStatusCnty == null) {
      strLegalStatusCnty = stageDAO.findStageCountyForPerson(personId);
    }

    return strLegalStatusCnty;
  }

  private ClientOutbound setClientOutbound(ClientOutboundBean clientOutboundBean, int idStage) {
    ClientOutbound clientOutbound = new ClientOutbound();
    clientOutbound.setCdPerCounty(clientOutboundBean.getCdLegalStatCnty());
    clientOutbound.setCdPersonSex(clientOutboundBean.getCdPersonSex());
    clientOutbound.setCdPersonSuffix(clientOutboundBean.getCdPersonSuffix());
    clientOutbound.setDtPersonBirth(clientOutboundBean.getDtPersonBirth());
    // Setting 0 so that while inserting it gets the ID from Sequence
    clientOutbound.setIdClientOutbound(0);
    clientOutbound.setIdClient(clientOutboundBean.getIdPerson());
    clientOutbound.setIdInitiator(clientOutboundBean.getIdInitiator());
    clientOutbound.setIndNewClient(clientOutboundBean.getIndNewClient());
    int crsID = clientOutboundBean.getNbrCRSId();
    if (crsID != 0){
      clientOutbound.setNbrCrsId(clientOutboundBean.getNbrCRSId());
    }
    clientOutbound.setNbrPersonIdNumber(clientOutboundBean.getNbrPersonId());
    clientOutbound.setNmPersonFirst(clientOutboundBean.getNmPersonFirst());
    clientOutbound.setNmPersonLast(clientOutboundBean.getNmPersonLast());
    clientOutbound.setNmPersonMiddle(clientOutboundBean.getNmPersonMiddle());
    clientOutbound.setTxtMedicaidNumber(clientOutboundBean.getTxtMedicaidNumber());
    clientOutbound.setDtClientUpdated(new Date(System.currentTimeMillis()));
    // CdError, DtClientUpdated and DtProcess will be set to null so that it
    // will be updated in the inbound service. DtLastUpdate will be updated using the
    // Client_outbound table trigger.
    clientOutbound.setCdTargetSystem(TARGET_SYSTEM_SMILE);
    clientOutbound.setInterfaceStatus(NEW);
    
    //MR-041 get the pre adoptiove Child ID
    Integer idClientPrev = retrievePreAdoptiveChildId.retrievePreAdoptiveChildId(idStage);
    //Set the ID
    if(idClientPrev != null){
      clientOutbound.setIdClientPrev(idClientPrev);
    }
    
    return clientOutbound;
  }
  
  /**
   * @param personIdDAO
   *          the personIdDAO to set
   */
  public void setPersonIdDAO(PersonIdDAO personIdDAO) {
    this.personIdDAO = personIdDAO;
  }

  /**
   * @param legalStatusDAO
   *          the legalStatusDAO to set
   */
  public void setLegalStatusDAO(LegalStatusDAO legalStatusDAO) {
    this.legalStatusDAO = legalStatusDAO;
  }

  /**
   * @param stageDAO
   *          the stageDAO to set
   */
  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }

  /**
   * @param clientOutboundDAO
   *          the clientOutboundDAO to set
   */
  public void setClientOutboundDAO(ClientOutboundDAO clientOutboundDAO) {
    this.clientOutboundDAO = clientOutboundDAO;
  }

  /**
   * @param personDAO
   *          the personDAO to set
   */
  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }
  
  public void setRetrievePreAdoptiveChildId(RetrievePreAdoptiveChildId retrievePreAdoptiveChildId) {
    this.retrievePreAdoptiveChildId = retrievePreAdoptiveChildId;
  }
}
