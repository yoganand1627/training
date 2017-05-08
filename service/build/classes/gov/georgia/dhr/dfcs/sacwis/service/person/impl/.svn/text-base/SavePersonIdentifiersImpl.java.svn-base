package gov.georgia.dhr.dfcs.sacwis.service.person.impl;


/** Change History:
   **  Date        User              Description
   **  --------    ----------------  --------------------------------------------------
   **  07/17/2008  charden           STGAP00006557 - created new method to save person identifier info to csupParentOutbound 
   *                                 when add is being done
   *                                 
   */

import java.util.Date;
import java.util.Enumeration;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexPersonIdDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EligibilityDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonIdDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Eligibility;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.PersonId;
import gov.georgia.dhr.dfcs.sacwis.service.admin.CheckStageEventStatus;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import  gov.georgia.dhr.dfcs.sacwis.service.person.SaveCsupParentDemographicInfo;
import gov.georgia.dhr.dfcs.sacwis.service.person.SavePersonIdentifiers;
import gov.georgia.dhr.dfcs.sacwis.service.ws.UpdateClientOutbound;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT14WLB;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT14WLB_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT23SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ClientOutboundBean;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ClientOutboundSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SaveCsupParentDemographicInfoSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT23SO;

import gov.georgia.dhr.dfcs.sacwis.service.common.InterfaceServiceConstants;

public class SavePersonIdentifiersImpl extends BaseServiceImpl implements SavePersonIdentifiers {
  private static final String PERSON_ID = "Person Id";
  private static final String YES = "Y";
  private CheckStageEventStatus checkStageEventStatus = null;
  private ComplexPersonIdDAO complexPersonIdDAO = null;
  private EligibilityDAO eligibilityDAO = null;
  private PersonIdDAO personIdDAO = null;
  private PersonDAO personDAO = null;
  private SaveCsupParentDemographicInfo saveCsupParentDemographicInfo = null;
  private UpdateClientOutbound updateClientOutbound = null;
  
  public void setCheckStageEventStatus(CheckStageEventStatus checkStageEventStatus) {
    this.checkStageEventStatus = checkStageEventStatus;
  }

  public void setComplexPersonIdDAO(ComplexPersonIdDAO complexPersonIdDAO) {
    this.complexPersonIdDAO = complexPersonIdDAO;
  }
  
  public void setEligibilityDAO(EligibilityDAO eligibilityDAO) {
    this.eligibilityDAO = eligibilityDAO;
  }
  
  public void setPersonIdDAO(PersonIdDAO personIdDAO) {
    this.personIdDAO = personIdDAO;
  }
  
  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }
  
  public void setSaveCsupParentDemographicInfo(SaveCsupParentDemographicInfo saveCsupParentDemographicInfo) {
    this.saveCsupParentDemographicInfo = saveCsupParentDemographicInfo;
  }
  
  public void setUpdateClientOutbound(UpdateClientOutbound updateClientOutbound) {
    this.updateClientOutbound = updateClientOutbound;
  }
  
  public CINT23SO savePersonIdentifiers(CINT23SI cint23si) throws ServiceException {
    CINT23SO cint23so = new CINT23SO();
    int idStage = cint23si.getUlIdStage();

    if (idStage != 0) {
      CCMN06UI ccmn06ui = new CCMN06UI();
      ccmn06ui.setArchInputStruct(cint23si.getArchInputStruct());
      ccmn06ui.getArchInputStruct().setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
      ccmn06ui.setUlIdStage(cint23si.getUlIdStage());
      ccmn06ui.setSzCdTask(cint23si.getSzCdTask());
      checkStageEventStatus.status(ccmn06ui);
    }

    if (cint23si.getArchInputStruct().getUlPageSizeNbr() != 0) {
      updatePersonIds(cint23si);
      //updatePersonIds(cint23si.getCINT14WLB_ARRAY());
    }

    return cint23so;
  }
  
  private void updatePersonIds(CINT23SI cint23si) throws ServiceException {
  //private void updatePersonIds(CINT14WLB_ARRAY cint14wlb_array) throws ServiceException {
    CINT14WLB_ARRAY cint14wlb_array = cint23si.getCINT14WLB_ARRAY();
    Enumeration cint14WLb_enum = cint14wlb_array.enumerateCINT14WLB();
    CINT14WLB cint14WLb2 = cint14wlb_array.getCINT14WLB(0);

    while (cint14WLb_enum.hasMoreElements()) {
      CINT14WLB cint14WLb = (CINT14WLB) cint14WLb_enum.nextElement();
      String cdPersonIdType = cint14WLb.getSzCdPersonIdType();
      String indPersonIDInvalid = cint14WLb.getBIndPersonIDInvalid();
      String descPersonID = cint14WLb.getSzDescPersonID();
      Date dtPersonIDEnd = DateHelper.toJavaDate(cint14WLb.getDtPersonIDEnd());
      String nbrPersonIdNumber = cint14WLb.getSzNbrPersonIdNumber();
      int idPerson = cint14WLb.getUlIdPerson();
      int idPersonId = cint14WLb.getUlIdPersonId();
      Date dtLastUpdate = cint14WLb.getTsSysTsLastUpdate2();
      String indValidateByInterface = cint14WLb.getBIndValidateByInterface();
      int ulIdStage = cint23si.getUlIdStage();

      String szCdScrDataAction = cint14WLb.getSzCdScrDataAction();
      if (ServiceConstants.REQ_FUNC_CD_ADD.equals(szCdScrDataAction)) {
        //Add logic to send a new row for ClientOutbound table if either SSN / CRS ID/MedicAid # gets added
        if (null != cdPersonIdType && ((CodesTables.CNUMTYPE_CRS_IDNUMBER.equals(cdPersonIdType) || CodesTables.CNUMTYPE_SSN.equals(cdPersonIdType) 
                        || CodesTables.CNUMTYPE_MEDICAIDMHN_NUMBER.equals(cdPersonIdType)) && !YES.equals(indPersonIDInvalid))){
          
          Person person = personDAO.findPersonByIdPerson(idPerson);
          String cdSmileClient = person.getCdSmileClient();
          //Checking for SMILE Client not null
          if (null != cdSmileClient){
              
            ClientOutboundBean clientOutboundBean = loadClientOutboundBean(idPerson, nbrPersonIdNumber, cdPersonIdType, cint23si.getUlIdPersonId());
            ClientOutboundSaveSI clientOutboundSaveSI = loadClientOutboundSaveSI(cint23si.getUlIdEvent(), cint23si.getUlIdPersonId(), 
                                                                                cint23si.getUlIdStage(), clientOutboundBean);
            updateClientOutbound.updateClientOutbound(clientOutboundSaveSI);          
            
          }        
        }
        // cint18d
        if (0 == complexPersonIdDAO.insertPersonIdSetEndDate(idPerson, nbrPersonIdNumber, cdPersonIdType, descPersonID,
                                                             indPersonIDInvalid, dtPersonIDEnd,
                                                             indValidateByInterface)) {
          throw new ServiceException(Messages.SQL_NOT_FOUND);
        }
        
      // STGAP00006557 - called new method to save person identifier info to CsupParentOutbound table when info is added
      // or updated
      } else if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(szCdScrDataAction)) {
        // cint18d
        if (0 == complexPersonIdDAO.updatePersonIdsetEndDate(idPerson, idPersonId, nbrPersonIdNumber, cdPersonIdType,
                                                             descPersonID, indPersonIDInvalid, dtPersonIDEnd,
                                                             indValidateByInterface, dtLastUpdate)) {
          throw new ServiceException(Messages.SQL_NOT_FOUND);
        }
      } else if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(szCdScrDataAction)) {
        // cint18d
        if (0 == complexPersonIdDAO.deletePersonId(idPersonId, dtLastUpdate)) {
          throw new ServiceException(Messages.SQL_NOT_FOUND);
        }
      } else {
        throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
      }
    }
    String szCdScrDataAction1 = cint23si.getSzCdTask();
    String cdPersonIdType1 = cint14WLb2.getSzCdPersonIdType();
    String indPersonIDInvalid1 = cint14WLb2.getBIndPersonIDInvalid();

    if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(szCdScrDataAction1) || ServiceConstants.REQ_FUNC_CD_ADD.equals(szCdScrDataAction1)) {
      if (null != cdPersonIdType1
          && ((CodesTables.CNUMTYPE_CRS_IDNUMBER.equals(cdPersonIdType1) || CodesTables.CNUMTYPE_SSN
                                                                                                    .equals(cdPersonIdType1)) && !YES
                                                                                                                                     .equals(indPersonIDInvalid1))) {
        Date dtLastUpdate1 = cint14WLb2.getTsSysTsLastUpdate2();
        int idPerson1 = cint14WLb2.getUlIdPerson();
        saveCsupParentDemogs(idPerson1, dtLastUpdate1, szCdScrDataAction1);
      }
    }
  }

  private ClientOutboundBean loadClientOutboundBean(int idPerson, String nbrPersonIdNumber, String cdPersonIdType,
                                                    int idInitiator) {
    ClientOutboundBean clientOutboundBean = new ClientOutboundBean();
    clientOutboundBean.setIdPerson(idPerson);
    if (CodesTables.CNUMTYPE_SSN.equals(cdPersonIdType)) {
      clientOutboundBean.setNbrPersonId(nbrPersonIdNumber);
      clientOutboundBean.setCdStatus(CodesTables.CNUMTYPE_SSN);
    }else if (CodesTables.CNUMTYPE_CRS_IDNUMBER.equals(cdPersonIdType)){
      try{
        clientOutboundBean.setNbrCRSId(Integer.parseInt(nbrPersonIdNumber));
        clientOutboundBean.setCdStatus(CodesTables.CNUMTYPE_CRS_IDNUMBER);
      }catch(NumberFormatException nfe){
        throw new ServiceException(Messages.MSG_CRS_ID_NOT_A_NUMBER);
      }
    }else if (CodesTables.CNUMTYPE_MEDICAIDMHN_NUMBER.equals(cdPersonIdType)){
      clientOutboundBean.setTxtMedicaidNumber(nbrPersonIdNumber);
      clientOutboundBean.setCdStatus(CodesTables.CNUMTYPE_MEDICAIDMHN_NUMBER);
    }
    clientOutboundBean.setCdOriginatingPage(PERSON_ID);
    clientOutboundBean.setIdInitiator(idInitiator);
    return clientOutboundBean;
  }
  
  private ClientOutboundSaveSI loadClientOutboundSaveSI(int idEvent, int idPerson, int idStage,
                                                        ClientOutboundBean clientOutboundBean){
    ClientOutboundSaveSI clientOutboundSaveSI = new ClientOutboundSaveSI();
    clientOutboundSaveSI.setIdEvent(idEvent);
    clientOutboundSaveSI.setIdInitiator(idPerson);
    clientOutboundSaveSI.setIdStage(idStage);
    clientOutboundSaveSI.setClientOutboundBean(clientOutboundBean);
    return clientOutboundSaveSI;
  }
  

  // STGAP00006557 - created new method to save person identifier info to csupParentOutbound
  private void saveCsupParentDemogs(int idPerson, Date dtLastUpdate, String szCdScrDataAction) {
    // Add code for CSUPParent Update info
    SaveCsupParentDemographicInfoSI saveCsupParentIdRowSI = new SaveCsupParentDemographicInfoSI();
    // cint23si.getUlIdStage();
    Object[] parentInfo = personIdDAO.findDistinctParentByStagePersRelId(idPerson);
    if (null != parentInfo && (ServiceConstants.REQ_FUNC_CD_ADD.equals(szCdScrDataAction) || ServiceConstants.REQ_FUNC_CD_UPDATE.equals(szCdScrDataAction))) {
      Object[] personIdParentCrsIdObj = personIdDAO.findDistinctParentNbrPersonIdCrsIdByIdPerson(idPerson);
      Object[] personIdSsnObj = personIdDAO.findDistinctParentNbrPersonIdSsnByIdPerson(idPerson);
      Object[] personIdChildCrsIdObj = personIdDAO.findDistinctChildNbrPersonIdCrsIdByIdPerson(idPerson);

      if (null != personIdParentCrsIdObj) {
        saveCsupParentIdRowSI.setNbrNoncustCrsId(Integer.parseInt((String) personIdParentCrsIdObj[1]));
      }
      if (null != personIdSsnObj) {
        saveCsupParentIdRowSI.setNbrNoncustNumber((String) personIdSsnObj[1]);
      }
      if (null != personIdChildCrsIdObj) {
        saveCsupParentIdRowSI.setNbrChildCrsId(Integer.parseInt((String) personIdChildCrsIdObj[1]));
      }
      saveCsupParentIdRowSI.setIdPersonId(idPerson);
      if (null != dtLastUpdate) {
        saveCsupParentIdRowSI.setDtCsupparRequested(dtLastUpdate);
      }
      saveCsupParentDemographicInfo
                                   .saveCsupParentDemographicInfo(
                                                                  saveCsupParentIdRowSI,
                                                                  InterfaceServiceConstants.SAVE_PERSON_IDENTIFIERS_DETAIL, szCdScrDataAction);
    }
  }
}