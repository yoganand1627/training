package gov.georgia.dhr.dfcs.sacwis.service.fce.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.InitialMedicaidAppDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonIdDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.InitialMedParent;
import gov.georgia.dhr.dfcs.sacwis.db.InitialMedicaidApp;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.service.admin.CheckStageEventStatus;
import gov.georgia.dhr.dfcs.sacwis.service.admin.PostEvent;
import gov.georgia.dhr.dfcs.sacwis.service.fce.SaveInitialMedicaid;
import gov.georgia.dhr.dfcs.sacwis.service.fce.SaveMedicaidCoareqOutbound;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.MedicaidApplicationSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.PrincipalsList;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN01UO;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/*** Change History:
 **  Date        User              Description
 **  --------    ----------------  --------------------------------------------------
 *
 *  3/30/09      cwells            STGAP00012033 throwing the Service Exeception for callCheckPersonCRSID
 *
 **/


public class SaveInitialMedicaidImpl  extends BaseServiceImpl implements SaveInitialMedicaid {
  
  private CheckStageEventStatus checkStageEventStatus = null;
  
  private SaveMedicaidCoareqOutbound saveMedicaidCoareqOutbound = null;
  
  private PostEvent postEvent = null;
  
  private PersonIdDAO personIdDAO = null;
  
  private InitialMedicaidAppDAO initialMedicaidAppDAO = null;
  
  private StageDAO stageDAO = null; 
  
  public void setPostEvent(PostEvent postEvent) {
    this.postEvent = postEvent;
  }
  
  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }

  public void setCheckStageEventStatus(CheckStageEventStatus checkStageEventStatus) {
    this.checkStageEventStatus = checkStageEventStatus;
  }
  
  public void setSaveMedicaidCoareqOutbound(SaveMedicaidCoareqOutbound saveMedicaidCoareqOutbound) {
    this.saveMedicaidCoareqOutbound = saveMedicaidCoareqOutbound;
  }
  
  public CheckStageEventStatus getCheckStageEventStatus() {
    return checkStageEventStatus;
  }
  
  public void setInitialMedicaidAppDAO(InitialMedicaidAppDAO initialMedicaidAppDAO) {
    this.initialMedicaidAppDAO = initialMedicaidAppDAO;
  }
  
  public void setPersonIdDAO(PersonIdDAO personIdDAO) {
    this.personIdDAO = personIdDAO;
  }
  
  public int saveInitialMedicaid(MedicaidApplicationSaveSI medicaidApplicationSaveSI) {
    
    int idEvent = medicaidApplicationSaveSI.getEventId();
    InitialMedicaidApp  initialMedicaidApp = new InitialMedicaidApp();
    if (idEvent != 0){
     initialMedicaidApp = initialMedicaidAppDAO.findInitialMedicaidByIdEvent(idEvent);
    }

    Event event = new Event();
    
    try{
      String actionCode = ServiceConstants.REQ_FUNC_CD_ADD;
      if (idEvent != 0) {
        actionCode = ServiceConstants.REQ_FUNC_CD_UPDATE;
      }
      
      // hjbaptiste - Determine whether the stage is open and modifiable. Due to some converted cases having
      // closed FCC stages, we only need to call this check if the stage is not already closed.
      // Else closed converted cases will cause the 'Save failed because the Stage you are working 
      // on has been closed.' message when this check is done.
      Stage stage = stageDAO.findStageByIdStage( medicaidApplicationSaveSI.getStageId());
      if (stage.getDtStageClose() == null){
        callCheckStageEventStatus(medicaidApplicationSaveSI);
      }
      if(medicaidApplicationSaveSI.isSave() || medicaidApplicationSaveSI.isSaveAndSubmit()){
        callCheckPersonCRSID(medicaidApplicationSaveSI);
      }
  
      CCMN01UO ccmn01uo = callPostEvent(actionCode, medicaidApplicationSaveSI);
      if (ccmn01uo != null) {
        idEvent = ccmn01uo.getUlIdEvent();
        event = (Event) getPersistentObject(Event.class, idEvent);
        initialMedicaidApp.setEvent(event);
        initialMedicaidApp.setIdEvent(idEvent);
      }
      
      populateMedicaidApplication_save( medicaidApplicationSaveSI, initialMedicaidApp);
      populateMedicaidParentInd_save(medicaidApplicationSaveSI, initialMedicaidApp);

      idEvent = initialMedicaidAppDAO.saveInitialMedicaidApp(initialMedicaidApp);
      
      if(CodesTables.CEVTSTAT_PEND.equals(medicaidApplicationSaveSI.getCdEventStatus())){
        int status = 0;
        status =  saveMedicaidCoareqOutbound.saveMedicaidCoareqOutbound(medicaidApplicationSaveSI);
      }
      
      return idEvent;
    }catch (ServiceException we){
      throw we;
    }
  }
  
  
  private CCMN01UO callPostEvent(String actionCode, MedicaidApplicationSaveSI medicaidApplicationSaveSI)throws ServiceException {
    
    ROWCCMN01UIG00 rowccmn01uig00 = new ROWCCMN01UIG00();
    ROWCCMN01UIG01_ARRAY rowccmn01uig01_array = new ROWCCMN01UIG01_ARRAY();
    String desc = "";
    int idEvent = medicaidApplicationSaveSI.getEventId();

    if("NEW".equals(medicaidApplicationSaveSI.getCdEventStatus())){
      desc = "Initial Medicaid Application";
    }else if("PROC".equals(medicaidApplicationSaveSI.getCdEventStatus())){
      desc = "Initial Medicaid Application has been started and saved.";
      
    }else if("PEND".equals(medicaidApplicationSaveSI.getCdEventStatus())){
      desc = "Initial Medicaid Application has been saved and submitted.";
      
    }else if("APRV".equals(medicaidApplicationSaveSI.getCdEventStatus())){
      desc = "Initial Medicaid Application has been processed.";
    }

    if(ServiceConstants.REQ_FUNC_CD_UPDATE.equals(actionCode)) {
      rowccmn01uig00.setUlIdEvent(idEvent);
      rowccmn01uig00.setTsLastUpdate(medicaidApplicationSaveSI.getDtEventLastUpdate());
    }

    rowccmn01uig00.setSzCdEventStatus(medicaidApplicationSaveSI.getCdEventStatus());
    rowccmn01uig00.setSzCdEventType(CodesTables.CEVNTTYP_IMA);
    rowccmn01uig00.setSzTxtEventDescr(desc);
    rowccmn01uig00.setSzCdTask(medicaidApplicationSaveSI.getCdTask());
    rowccmn01uig00.setUlIdPerson(medicaidApplicationSaveSI.getUserId());
    rowccmn01uig00.setUlIdStage(medicaidApplicationSaveSI.getStageId());

    if (!DateHelper.isNull(medicaidApplicationSaveSI.getDtEventOccurred()) && idEvent != 0) {
      rowccmn01uig00.setDtDtEventOccurred(DateHelper.toCastorDate(medicaidApplicationSaveSI.getDtEventOccurred()));
    } else {
      rowccmn01uig00.setDtDtEventOccurred(DateHelper.toCastorDate(new Date()));

    }
    gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01 rowccmn01uig01;
    if (medicaidApplicationSaveSI.getIdPerson() != 0) {
      Integer idPerson = medicaidApplicationSaveSI.getIdPerson();
      rowccmn01uig01 = new gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01();
      rowccmn01uig01.setUlIdPerson(idPerson);
      rowccmn01uig01.setSzCdScrDataAction(actionCode);
      rowccmn01uig01_array.addROWCCMN01UIG01(rowccmn01uig01);
    }
    if (idEvent != 0) {
      rowccmn01uig01_array = null;
    }
    rowccmn01uig00.setROWCCMN01UIG01_ARRAY(rowccmn01uig01_array);
    
    
    CCMN01UI ccmn01ui = new CCMN01UI();
    ArchInputStruct archInputStruct = new ArchInputStruct();
    archInputStruct.setCReqFuncCd(actionCode);
    ccmn01ui.setArchInputStruct(archInputStruct);
    ccmn01ui.setROWCCMN01UIG00(rowccmn01uig00);
    return postEvent.postEvent(ccmn01ui);
  }
  
  private void populateMedicaidApplication_save(MedicaidApplicationSaveSI medicaidApplicationSaveSI,
                                                              InitialMedicaidApp initialMedicaidApp) {
    String indChildCoverage = medicaidApplicationSaveSI.getIndChildCoverage();
    String cdType = medicaidApplicationSaveSI.getCdType();
    String nmCompany = medicaidApplicationSaveSI.getNmCompany();
    String nbrPolicy = medicaidApplicationSaveSI.getNbrPolicy();
    String nbrGroup = medicaidApplicationSaveSI.getNbrGroup();
    String addrStreetLn1 = medicaidApplicationSaveSI.getAddrStreetLn1();
    String addrStreetLn2 = medicaidApplicationSaveSI.getAddrStreetLn2();
    String addrCity = medicaidApplicationSaveSI.getAddrCity();
    String addrState = medicaidApplicationSaveSI.getAddrState();
    String addrZip = medicaidApplicationSaveSI.getAddrZip();
    String nbrPhone = medicaidApplicationSaveSI.getNbrPhone();
    String nmPolicyHolder = medicaidApplicationSaveSI.getNmPolicyHolder();
    Date dtBegin = medicaidApplicationSaveSI.getDtBegin();
    Date dtEnd = medicaidApplicationSaveSI.getDtEnd();
    String nmEmployer = medicaidApplicationSaveSI.getNmEmployer();
    String nmEmployeeName = medicaidApplicationSaveSI.getNmEmployeeName();
    Date dtEstDeliveryDate = medicaidApplicationSaveSI.getDtEstDeliveryDate();
    String indChildPregnancy = medicaidApplicationSaveSI.getIndChildPregnancy();
    String indChild = medicaidApplicationSaveSI.getIndHealthInsuranceCard();
    String indMedicalAssistChild = medicaidApplicationSaveSI.getIndMedicalAsstChild();
    String indParent = medicaidApplicationSaveSI.getIndParent();
    String indChildSupportOrder = medicaidApplicationSaveSI.getIndChildSupportOrder();
    String txtMonths = medicaidApplicationSaveSI.getTxtMonths();
    String indCaseManagerApply = medicaidApplicationSaveSI.getIndCaseManagerApply();
    Person caseManager = null;
    if (medicaidApplicationSaveSI.isSigned()){
      caseManager = (Person) getPersistentObject(Person.class, medicaidApplicationSaveSI.getUserId());
      initialMedicaidApp.setPerson(caseManager);
    }
    Date dtCmSigned = medicaidApplicationSaveSI.getDtCmSigned();
    Date dtProcessed = medicaidApplicationSaveSI.getDtProcessed();
    String txtComments = medicaidApplicationSaveSI.getTxtComments();

    //STGAP00010435 - New fields for Out of state assistance information
    String indIcamaIcpc = medicaidApplicationSaveSI.getIndIcamaIcpc();
    String cdIcamaAsstType = medicaidApplicationSaveSI.getCdIcamaAsstType();
    String cdAdoptionType = medicaidApplicationSaveSI.getCdAdoptionType();
    String cdIcamaState = medicaidApplicationSaveSI.getCdIcamaState();
    String txtIcamaComments = medicaidApplicationSaveSI.getTxtIcamaComments();

    
    initialMedicaidApp.setIndChildCoverage(indChildCoverage);
    initialMedicaidApp.setCdType(cdType);
    initialMedicaidApp.setNmCompany(nmCompany); 
    initialMedicaidApp.setNbrPolicy(nbrPolicy);
    initialMedicaidApp.setNbrGroup(nbrGroup);
    initialMedicaidApp.setAddrStreetLn1(addrStreetLn1);
    initialMedicaidApp.setAddrStreetLn2(addrStreetLn2);
    initialMedicaidApp.setAddrCity(addrCity);
    initialMedicaidApp.setAddrState(addrState);
    initialMedicaidApp.setAddrZip(addrZip);
    initialMedicaidApp.setNbrPhone(nbrPhone);
    initialMedicaidApp.setNmPolicyHolder(nmPolicyHolder);
    initialMedicaidApp.setDtBegin(dtBegin);
    initialMedicaidApp.setDtEnd(dtEnd);
    initialMedicaidApp.setNmEmployer(nmEmployer);
    initialMedicaidApp.setNmEmployeeName(nmEmployeeName);
    initialMedicaidApp.setDtEstDeliveryDate(dtEstDeliveryDate); 
    initialMedicaidApp.setIndChildPregnancy(indChildPregnancy); 
    initialMedicaidApp.setIndHealthInsuranceCard(indChild); 
    initialMedicaidApp.setIndMedicalAsstChild(indMedicalAssistChild); 
    initialMedicaidApp.setIndParent(indParent); 
    initialMedicaidApp.setIndChildSupportOrder(indChildSupportOrder); 
    initialMedicaidApp.setTxtMonths(txtMonths); 
    initialMedicaidApp.setIndCaseManagerApply(indCaseManagerApply);

    initialMedicaidApp.setDtCmSigned(dtCmSigned);
    initialMedicaidApp.setDtProcessed(dtProcessed);
    initialMedicaidApp.setTxtComments(txtComments);
    
    initialMedicaidApp.setCdAdoptionType(cdAdoptionType);
    initialMedicaidApp.setCdIcamaAssistanceType(cdIcamaAsstType);
    initialMedicaidApp.setCdIcamaState(cdIcamaState);
    initialMedicaidApp.setTxtIcamaComments(txtIcamaComments);
    initialMedicaidApp.setIndIcamaIcpc(indIcamaIcpc);
  }
  
    private void populateMedicaidParentInd_save(MedicaidApplicationSaveSI medicaidApplicationSaveSI, InitialMedicaidApp initialMedicaidApp) {
      int idPersonParent = 0;

      List<PrincipalsList> principals = medicaidApplicationSaveSI.getPrincipalsBeanList();
      if(!principals.isEmpty() || principals != null){
        List<Map> indParentList = initialMedicaidAppDAO.findIndParent(medicaidApplicationSaveSI.getStageId(), 
                                                                      medicaidApplicationSaveSI.getCaseId(),
                                                                      medicaidApplicationSaveSI.getEventId());
        if(!indParentList.isEmpty()){
          for (int i = 0; i <  principals.size(); i++) {
            InitialMedParent  initialMedParent = new InitialMedParent();
            PrincipalsList principal = (PrincipalsList) principals.get(i);
            Person person = getPersistentObject(Person.class, principal.getIdPerson());
            initialMedParent.setPerson(person);
            initialMedParent.setInitialMedicaidApp(initialMedicaidApp);
            initialMedParent.setIndParent(principal.getIndParent());
            for (Iterator<Map> mapParentIt = indParentList.iterator(); mapParentIt.hasNext();) {
              Map mapParent = mapParentIt.next();
              idPersonParent = Integer.parseInt(((Integer)mapParent.get("idPerson")).toString());
              if(principal.getIdPerson() == idPersonParent ){
                initialMedicaidAppDAO.updateInitialMedParent(principal.getIdPerson(), principal.getIndParent());
              }
            }
          }
          
        }else{
          for (int i = 0; i <  principals.size(); i++) {
            InitialMedParent  initialMedParent = new InitialMedParent();
            PrincipalsList principal = (PrincipalsList) principals.get(i);            
            Person person = getPersistentObject(Person.class, principal.getIdPerson());
            initialMedParent.setPerson(person);
            initialMedParent.setInitialMedicaidApp(initialMedicaidApp);
            initialMedParent.setIndParent(principal.getIndParent());
            initialMedicaidAppDAO.saveInitialMedParent(initialMedParent);
          }
        }
      }
   }
  
  private void callCheckStageEventStatus(MedicaidApplicationSaveSI medicaidApplicationSaveSI) {
    String actionCode = ServiceConstants.REQ_FUNC_CD_ADD;
    int idEvent = medicaidApplicationSaveSI.getEventId();
    int idStage = medicaidApplicationSaveSI.getStageId();
    int idUser = medicaidApplicationSaveSI.getUserId();
    String cdTask = medicaidApplicationSaveSI.getCdTask();
    
    if (idEvent > 0) {
      actionCode = ServiceConstants.REQ_FUNC_CD_UPDATE;
    }
    CCMN06UI ccmn06ui = populateCCMN06UI_CheckStageEventStatus(idStage, idUser, cdTask, actionCode);
    checkStageEventStatus.status(ccmn06ui);
  }
  
  private CCMN06UI populateCCMN06UI_CheckStageEventStatus(int idStage, int idUser, String cdTask, String actionCode) {
    
    CCMN06UI ccmn06ui = new CCMN06UI();
    ArchInputStruct input = new ArchInputStruct();
    
    ccmn06ui.setUlIdStage(idStage);
    ccmn06ui.setSzCdTask(cdTask);
    
    input.setSzUserId(String.valueOf(idUser));
    input.setCReqFuncCd(actionCode);
    
    ccmn06ui.setArchInputStruct(input);
    
    return ccmn06ui;
  }
  
  private void callCheckPersonCRSID(MedicaidApplicationSaveSI medicaidApplicationSaveSI) throws ServiceException {
    int idPerson = medicaidApplicationSaveSI.getIdPerson();
    long count;
    if (idPerson > 0) {
      count = personIdDAO.findPersonIdByType(idPerson);
      if (count == 0){
        // No record found for CRS ID# 
        throw new ServiceException(Messages.MSG_FCE_NO_MEDICNUM_INIT_MA);
      }
      
    }
    
  }
  
  
  
}
