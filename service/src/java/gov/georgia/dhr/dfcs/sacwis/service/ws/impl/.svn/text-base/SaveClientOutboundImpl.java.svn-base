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
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.ws.RetrievePreAdoptiveChildId;
import gov.georgia.dhr.dfcs.sacwis.service.ws.SaveClientOutbound;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ClientOutboundBean;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ClientOutboundSaveSI;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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


public class SaveClientOutboundImpl extends BaseServiceImpl implements SaveClientOutbound {
  private static final String NEW_SMILE_CLIENT = "Y";
  private static final String TARGET_SYSTEM_SMILE = "SML";
  private static final String NEW = "NEW";
  private static final String SENT_NO_REPLY = "SUB";
  
  private EventPersonLinkDAO eventPersonLinkDAO;
  private PersonDAO personDAO;
  private PersonIdDAO personIdDAO;
  private LegalStatusDAO legalStatusDAO;
  private StageDAO stageDAO;
  private ClientOutboundDAO clientOutboundDAO;
  private RetrievePreAdoptiveChildId retrievePreAdoptiveChildId;
  
  public void saveClientOutbound(ClientOutboundSaveSI clientOutboundSaveSI) throws ServiceException {
    //Get the eventId from the Input object
    int idEvent = clientOutboundSaveSI.getIdEvent();
    //Pass the eventId to the eventPersonLinkDAO to get the Name & Person ID Information
    List<Map> clientList = eventPersonLinkDAO.findPersonsForClientOutboundByIdEvent(idEvent);
    if (clientList == null || clientList.size() == 0) {
      //adoption agreement events have a different structure so test against it before throwing the exception
      clientList = eventPersonLinkDAO.findPersonsForClientOutboundByIdEventForAdoAgreement(idEvent);
      //If nothing returned throw a ServiceException
      if (clientList == null || clientList.size() == 0) {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }
    }
    //Loop through the client list and insert into Client_Outbound table
    for (Iterator<Map> it = clientList.iterator(); it.hasNext();) {
      Map client = it.next();
      //Checking if Person is a SMILE client or not and added to the Client_outbound on if 
      //it is NOT a SMILE client.
      String cdSmileClient = (String) client.get("CD_SMILE_CLIENT");
      //If cdSmileClient is NULL, then insert a row in Client_Outbound table.
      if (cdSmileClient == null){
        ClientOutboundBean row = new ClientOutboundBean();
        row.setIdPerson((Integer)client.get("ID_PERSON") != null ? (Integer) client.get(
          "ID_PERSON") : 0);
        if (0!=row.getIdPerson()) {
          //Set it as New SMILE Client
          row.setIndNewClient(NEW_SMILE_CLIENT);
          //Get the Name information of the client from Person table
          row.setNmPersonFirst((String) client.get("NM_FIRST"));
          row.setNmPersonLast((String) client.get("NM_LAST"));
          row.setNmPersonMiddle((String) client.get("NM_MIDDLE"));
          row.setDtPersonBirth((Date) client.get("DT_PERSON_BIRTH"));
          row.setCdPersonSex((String) client.get("CD_PERSON_SEX"));
          row.setCdPersonSuffix((String) client.get("CD_NAME_SUFFIX"));
          //Get the SSN information of the client from Person_ID table
          row.setNbrPersonId(personIdDAO.findNonEndDatePersonSSN(row.getIdPerson()) != null ?
            personIdDAO.findNonEndDatePersonSSN(row.getIdPerson()):"");
          //Get the CRS_ID information of the client from Person_ID table
          String strCRSId = personIdDAO.findNonEndDatePersonCRSId(row.getIdPerson()) != null ?
            personIdDAO.findNonEndDatePersonCRSId(row.getIdPerson()):null;
          //If CRSId is null, then set null to CRSId or convert to a numeric and set it to CRSId
          if (strCRSId != null){
            try{
              row.setNbrCRSId(Integer.parseInt(strCRSId));
            }catch(NumberFormatException nfe){
              throw new ServiceException(Messages.MSG_CRS_ID_NOT_A_NUMBER);
            }
            }
            //row.setNbrCRSId(0);
          
          //Set the Initiator ID
          row.setIdInitiator(clientOutboundSaveSI.getIdInitiator());
          //Get the Medicaid information of the client from Person_ID table
          row.setTxtMedicaidNumber(personIdDAO.findNonEndDatePersonMedicaid(row.getIdPerson()) != null ?
            personIdDAO.findNonEndDatePersonMedicaid(row.getIdPerson()):"");          
          //Get the legal status county code
          LegalStatus legalStatus = legalStatusDAO.findMostRecentLegalStatusByIdPerson(row.getIdPerson());
          //Check if row exist in legal status for the client from LEGAL_STATUS table and
          //for Most recent effective date and get the Legal Stat county code.
          if (legalStatus != null){
            if (legalStatus.getCdLegalStatCnty() != null){
              row.setCdLegalStatCnty(legalStatus.getCdLegalStatCnty());
            }else{
              //If no legal status row found, then get the stage.cd_stage_cnty
              Stage stage = stageDAO.findStageByIdStage(clientOutboundSaveSI.getIdStage());
              row.setCdLegalStatCnty(stage.getCdStageCnty());
            }
          }else{
            //If no legal status row found, then get the stage.cd_stage_cnty
            Stage stage = stageDAO.findStageByIdStage(clientOutboundSaveSI.getIdStage());
            if (stage != null){
              row.setCdLegalStatCnty(stage.getCdStageCnty());
            }else{
              row.setCdLegalStatCnty("");
            }
          }
          
          //MR-041 get the pre adoptiove Child ID
          Integer idClientPrev = retrievePreAdoptiveChildId.retrievePreAdoptiveChildId(clientOutboundSaveSI.getIdStage());
          //Set the ID
          if(idClientPrev != null){
            row.setIdClientPrev(idClientPrev);
          }

        }
        //Send this BeanList to ClientOutboundDAO where it gets inserted in to Client_Outbound table.
        //clientOutboundBeanList.add(row);
        ClientOutbound clientOutbound = setClientOutbound(row);
        clientOutboundDAO.sendClientOutbound(clientOutbound);
        //Update PersonDAO to get these rows added to the database.
        personDAO.updatePersonByCdSmileClient(SENT_NO_REPLY, row.getIdPerson());
      }
    }

  }

  private ClientOutbound setClientOutbound(ClientOutboundBean clientOutboundBean){
    ClientOutbound clientOutbound = new ClientOutbound();
    clientOutbound.setCdPerCounty(clientOutboundBean.getCdLegalStatCnty());
    clientOutbound.setCdPersonSex(clientOutboundBean.getCdPersonSex());
    clientOutbound.setCdPersonSuffix(clientOutboundBean.getCdPersonSuffix());
    clientOutbound.setDtPersonBirth(clientOutboundBean.getDtPersonBirth());
    //Setting 0 so that while inserting it gets the ID from Sequence
    clientOutbound.setIdClientOutbound(0);
    clientOutbound.setIdClient(clientOutboundBean.getIdPerson());
    clientOutbound.setIdInitiator(clientOutboundBean.getIdInitiator());
    clientOutbound.setIndNewClient(clientOutboundBean.getIndNewClient());
    int crsID = 0 ;
    crsID = clientOutboundBean.getNbrCRSId();
    if(crsID != 0){
    clientOutbound.setNbrCrsId(crsID);
    }
    clientOutbound.setNbrPersonIdNumber(clientOutboundBean.getNbrPersonId());
    clientOutbound.setNmPersonFirst(clientOutboundBean.getNmPersonFirst());
    clientOutbound.setNmPersonLast(clientOutboundBean.getNmPersonLast());
    clientOutbound.setNmPersonMiddle(clientOutboundBean.getNmPersonMiddle());
    clientOutbound.setTxtMedicaidNumber(clientOutboundBean.getTxtMedicaidNumber());
    //CdError, DtClientUpdated and DtProcess will be set to null so that it 
    //will be updated in the inbound service. DtLastUpdate will be updated using the
    //Client_outbound table trigger.
    clientOutbound.setCdTargetSystem(TARGET_SYSTEM_SMILE);
    clientOutbound.setInterfaceStatus(NEW);
    return clientOutbound;
  }
  
/*  public void updateClientOutbound(ClientOutboundSaveSI clientOutboundSaveSI) {
    // TODO Loop through the ClientOutboundSaveSI and get the ClientOutboundBean.
    // For each bean, check the "cdOriginatingPage" and based on that build the actual
    // ClientOutbound hibernate bean.
    // TODO Add logic to get the Name information of the client from Person table
    // TODO Add logic to get the SSN information of the client from Person_ID table
    // TODO Add logic to get the CRS_ID information of the client from Person_ID table
    // TODO Add logic to get the Medicaid information of the client from Person_ID table
    // TODO Add logic to get the legal status information of the client from LEGAL_STATUS table
  }*/

  /**
   * @param eventPersonLinkDAO the eventPersonLinkDAO to set
   */
  public void setEventPersonLinkDAO(EventPersonLinkDAO eventPersonLinkDAO) {
    this.eventPersonLinkDAO = eventPersonLinkDAO;
  }

  /**
   * @param personIdDAO the personIdDAO to set
   */
  public void setPersonIdDAO(PersonIdDAO personIdDAO) {
    this.personIdDAO = personIdDAO;
  }

  /**
   * @param legalStatusDAO the legalStatusDAO to set
   */
  public void setLegalStatusDAO(LegalStatusDAO legalStatusDAO) {
    this.legalStatusDAO = legalStatusDAO;
  }

  /**
   * @param stageDAO the stageDAO to set
   */
  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }

  /**
   * @param personDAO the personDAO to set
   */
  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }

  /**
   * @param clientOutboundDAO the clientOutboundDAO to set
   */
  public void setClientOutboundDAO(ClientOutboundDAO clientOutboundDAO) {
    this.clientOutboundDAO = clientOutboundDAO;
  }
  
  public void setRetrievePreAdoptiveChildId(RetrievePreAdoptiveChildId retrievePreAdoptiveChildId) {
    this.retrievePreAdoptiveChildId = retrievePreAdoptiveChildId;
  }
}
