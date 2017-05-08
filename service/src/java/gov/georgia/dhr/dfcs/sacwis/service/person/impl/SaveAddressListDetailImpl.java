package gov.georgia.dhr.dfcs.sacwis.service.person.impl;

/**
* Title: Save Person Address
*
* Change History: 
* Date      User         Description 
* ------------------------------------------------------------------------------------------------------
* 5/16/08  cjgerry       STGAP00007852 - addUpdatePersonAddress and addUpdateAddressPersonLink were
*                        using the wrong timestamps - they were flip-flopped from the Retrieve object
*                        and sometimes causing a Timestamp Mismatch exception because they were a 
*                        second off.  This should fix the problem.
* 
* 07/17/08 charden       STGAP00006557 - created new method to save person address detail  
*                        info to csupParentOutbound when add is being done                      
* 
* 03/04/2009 bgehlot     STGAP00012734: Added two new methods updateStageCounty() and isGACounty() for MR-019.
* 07/31/2009 bgehlot     STGAP00014611: Only open INV, ONG and INV stages county be updated
* 09/11/2009 cwells      STGAP00014614 : updateStageCounty method should not be called when saving address from 
*                        Staff Detail page.
* 
*/

import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexAddressPersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EligibilityDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonIdDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.MedicaidUpdateDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonAddressDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Eligibility;
import gov.georgia.dhr.dfcs.sacwis.db.MedicaidUpdate;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.PersonId;
import gov.georgia.dhr.dfcs.sacwis.db.PersonRace;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.service.admin.CheckStageEventStatus;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.person.SaveAddressListDetail;
import gov.georgia.dhr.dfcs.sacwis.service.person.SaveCsupParentDemographicInfo;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN44SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN44SIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN44SIG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB46SIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SaveCsupParentDemographicInfoSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN44SO;

import gov.georgia.dhr.dfcs.sacwis.service.common.InterfaceServiceConstants;

public class SaveAddressListDetailImpl extends BaseServiceImpl implements SaveAddressListDetail {

  private CheckStageEventStatus checkStageEventStatus = null;
  private ComplexAddressPersonLinkDAO complexAddressPersonLinkDAO = null;
  private EligibilityDAO eligibilityDAO = null;
  private SaveCsupParentDemographicInfo saveCsupParentDemographicInfo = null;
  private MedicaidUpdateDAO medicaidUpdateDAO = null;
  private PersonAddressDAO personAddressDAO = null;
  private PersonIdDAO personIdDAO = null;
  private StageDAO stageDAO = null;
  private StagePersonLinkDAO stagePersonLinkDAO = null;
  
  public void setCheckStageEventStatus(CheckStageEventStatus checkStageEventStatus) {
    this.checkStageEventStatus = checkStageEventStatus;
  }
  
  public void setComplexAddressPersonLinkDAO(ComplexAddressPersonLinkDAO complexAddressPersonLinkDAO) {
    this.complexAddressPersonLinkDAO = complexAddressPersonLinkDAO;
  }
  
  public void setEligibilityDAO(EligibilityDAO eligibilityDAO) {
    this.eligibilityDAO = eligibilityDAO;
  }
  
  public void setSaveCsupParentDemographicInfo(SaveCsupParentDemographicInfo saveCsupParentDemographicInfo) {
    this.saveCsupParentDemographicInfo = saveCsupParentDemographicInfo;
  }

  public void setMedicaidUpdateDAO(MedicaidUpdateDAO medicaidUpdateDAO) {
    this.medicaidUpdateDAO = medicaidUpdateDAO;
  }
  
  public void setPersonAddressDAO(PersonAddressDAO personAddressDAO) {
    this.personAddressDAO = personAddressDAO;
  }
  
  public void setPersonIdDAO(PersonIdDAO personIdDAO) {
    this.personIdDAO = personIdDAO;
  }
  
  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }
  
  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public CCMN44SO saveAddressListDetail(CCMN44SI ccmn44si) throws ServiceException {

    // (BEGIN): Common Function: ccmn06u  ** Check Stage/Event common function
    // Only run if input Stage ID is not zero (Zero comes from Staff Detail)
    int idStage = ccmn44si.getUlIdStage();
    if (idStage != 0) {
      CCMN06UI ccmn06ui = new CCMN06UI();
      ccmn06ui.setArchInputStruct(new ArchInputStruct());
      ccmn06ui.getArchInputStruct().setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
      ccmn06ui.setUlIdStage(idStage);
      ccmn06ui.setSzCdTask(ccmn44si.getSzCdTask());
      checkStageEventStatus.status(ccmn06ui);
    }
    ROWCCMN44SIG00_ARRAY rowccmn44sig00_array = ccmn44si.getROWCCMN44SIG00_ARRAY();
    // ccmna8d
    int idPersonAddr = addUpdatePersonAddress(rowccmn44sig00_array);
    // ccmna9d
    int idPerson = ccmn44si.getUlIdPerson();
    addUpdateAddressPersonLink(idPersonAddr, idPerson, rowccmn44sig00_array);
    // STGAP00014614 Stage county should not be updated if stage is not = 0.  The Stage
    // will be = to 0 when updating address from the staff detail page. 
    if(idStage!= 0){
    //STGAP00012734: Update the stage county with the county selected on the Address Detail Page.
    updateStageCounty(idPerson, rowccmn44sig00_array, idStage); 
    }

    // Logic to be performed for every row in the list box
    Enumeration rowccmn44sig00_enum_MED = rowccmn44sig00_array.enumerateROWCCMN44SIG00();
    while (rowccmn44sig00_enum_MED.hasMoreElements()) {
      ROWCCMN44SIG00 rowccmn44sig00 = (ROWCCMN44SIG00) rowccmn44sig00_enum_MED.nextElement();
      String cdPersAddrLinkType = rowccmn44sig00.getSzCdPersAddrLinkType();
      String sysIndAddrMedUpdate = rowccmn44sig00.getBSysIndAddrMedUpdate();
      String cReqFuncCd = rowccmn44sig00.getSzCdScrDataAction();

      // Call service to Add or Update the MEDICAID UPDATE table if the address type is 'Medicaid' (MED) and if the
      //   DataAction code is ADD or if the DataAction code is UPDATE and the Medicaid Update flag is TRUE.
      if (CodesTables.CADDRTYP_MD.equals(cdPersAddrLinkType) &&
          ArchitectureConstants.Y.equals(sysIndAddrMedUpdate)) {
        // caud99d
        updateMedicaid(idPerson, idStage, rowccmn44sig00);
      }
    }
    // The output message is always empty.
    return new CCMN44SO();
  }

  private int addUpdatePersonAddress(ROWCCMN44SIG00_ARRAY rowccmn44sig00_array) throws ServiceException {
    Enumeration rowccmn44sig00_enum = rowccmn44sig00_array.enumerateROWCCMN44SIG00();
    int result = 0;
    // Logic to be performed for every row in the list box
    while (rowccmn44sig00_enum.hasMoreElements()) {
      ROWCCMN44SIG00 rowccmn44sig00 = (ROWCCMN44SIG00) rowccmn44sig00_enum.nextElement();
      String addrPersAddrStLn1 = rowccmn44sig00.getSzAddrPersAddrStLn1();
      String addrPersAddrStLn2 = rowccmn44sig00.getSzAddrPersAddrStLn2();
      String addrCity = rowccmn44sig00.getSzAddrCity();
      String addrZip = rowccmn44sig00.getLAddrZip();
      String cdAddrCounty = rowccmn44sig00.getSzCdAddrCounty();
      String addrPersAddrAttn = rowccmn44sig00.getSzAddrPersAddrAttn();
      String txtPersonEmail = rowccmn44sig00.getSzTxtPersonEmail();
      String cdAddrState = rowccmn44sig00.getSzCdAddrState();
      int idAddress = rowccmn44sig00.getLdIdAddress();
      Date tsLastUpdate = rowccmn44sig00.getTsSysTsLastUpdate2();
      String cReqFuncCd = rowccmn44sig00.getSzCdScrDataAction();

      if (ServiceConstants.REQ_FUNC_CD_ADD.equals(cReqFuncCd)) {
        // ccmna8d
        result = personAddressDAO.insertPersonAddressWithSeqPersonAddress(addrPersAddrStLn1, addrPersAddrStLn2,
                                                                          addrCity, addrZip, addrPersAddrAttn,
                                                                          txtPersonEmail,
                                                                          cdAddrCounty, cdAddrState);
        if (result==0) {
          throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
        }
      } else if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(cReqFuncCd)) {
        // ccmna8d
        int result1 = personAddressDAO.updatePersonAddress(tsLastUpdate, addrPersAddrStLn1, addrPersAddrStLn2, addrCity,
                                                      addrZip, addrPersAddrAttn, txtPersonEmail, cdAddrCounty,
                                                      cdAddrState, idAddress);
        if (result1 == 0 ) {
          throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
        }

      } else {
        throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
      }
      
    }
    return result;
  }

  private void addUpdateAddressPersonLink(int idPersonAddr, int idPerson, ROWCCMN44SIG00_ARRAY rowccmn44sig00_array)
          throws ServiceException {
    // Logic to be performed for every row in the list box.  The primary addresses in the input message are sorted in
    //   reverse-modified order (i.e., the most recent primary name added or modified will be at beginning of the input
    //   message). To ensure that the addresses receive the timestamps in the proper order, we need to process the list
    //   in reverse order.
    for (int i = rowccmn44sig00_array.getUlRowQty() - 1; i >= 0; i--) {
      ROWCCMN44SIG00 rowccmn44sig00 = rowccmn44sig00_array.getROWCCMN44SIG00(i);
      String cdPersAddrLinkType = rowccmn44sig00.getSzCdPersAddrLinkType();
      Date dtPersAddrLinkEnd = DateHelper.toJavaDate(rowccmn44sig00.getDtDtPersAddrLinkEnd());
      int idAddress = idPersonAddr;
      int idAddrPersonLink = rowccmn44sig00.getUlIdAddrPersonLink();
      String indPersAddrLinkInvalid = rowccmn44sig00.getBIndPersAddrLinkInvalid();
      String indPersAddrLinkPrimary = rowccmn44sig00.getBIndPersAddrLinkPrimary();
      String txtPersAddrCmnts = rowccmn44sig00.getSzTxtPersAddrCmnts();
      Date sysTsLastUpdate = rowccmn44sig00.getTsLastUpdate();
      String cReqFuncCd = rowccmn44sig00.getSzCdScrDataAction();
      String indRemovalHome = rowccmn44sig00.getBIndRemovalHome();
      int result;
      if (ServiceConstants.REQ_FUNC_CD_ADD.equals(cReqFuncCd)) {
        result = complexAddressPersonLinkDAO.insertAddressPersonLink(dtPersAddrLinkEnd, idPerson, idAddress,
                                                                     indPersAddrLinkInvalid, indPersAddrLinkPrimary,
                                                                     txtPersAddrCmnts, cdPersAddrLinkType, indRemovalHome);
      } else if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(cReqFuncCd)) {
        result = complexAddressPersonLinkDAO.updateAddressPersonLink(dtPersAddrLinkEnd, idAddrPersonLink,
                                                                     cdPersAddrLinkType, indPersAddrLinkInvalid,
                                                                     indPersAddrLinkPrimary, txtPersAddrCmnts, indRemovalHome,
                                                                     sysTsLastUpdate);
      } else {
        throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
      }
      if (result == 0) {
        throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
      } 
    }
    //STGAP00006557 - allow info to be saved on ADD too
    //Add code for CSUPParent Update info
    Object[] parentInfo = personIdDAO.findDistinctParentByStagePersRelId(idPerson);
    SaveCsupParentDemographicInfoSI saveCsupParentNameRowSI = new SaveCsupParentDemographicInfoSI();
    ROWCCMN44SIG00 rowccmn44sig002 = rowccmn44sig00_array.getROWCCMN44SIG00(0);
    String SzCdScrDataAction = rowccmn44sig002.getSzCdScrDataAction();
    if(null != parentInfo &&  ServiceConstants.REQ_FUNC_CD_ADD.equals(SzCdScrDataAction))
    {
      
      saveCsupParentNameRowSI.setIdPersonId(idPerson);
      saveCsupParentNameRowSI.setAddrNoncustAddrStLn1(rowccmn44sig002.getSzAddrPersAddrStLn1() != null ? rowccmn44sig002.getSzAddrPersAddrStLn1() : "");
      saveCsupParentNameRowSI.setAddrNoncustAddrStLn2(rowccmn44sig002.getSzAddrPersAddrStLn2() != null ? rowccmn44sig002.getSzAddrPersAddrStLn2() : "");
      saveCsupParentNameRowSI.setAddrNoncustAddrCity(rowccmn44sig002.getSzAddrCity() != null ? rowccmn44sig002.getSzAddrCity() : "");
      saveCsupParentNameRowSI.setCdNoncustAddrState(rowccmn44sig002.getSzCdAddrState() != null ? rowccmn44sig002.getSzCdAddrState() : "");
      saveCsupParentNameRowSI.setAddrNoncustAddrZip(rowccmn44sig002.getLAddrZip() != null ? rowccmn44sig002.getLAddrZip() : "");
      if (rowccmn44sig002.getTsLastUpdate() != null)
      {
        saveCsupParentNameRowSI.setDtCsupparRequested(rowccmn44sig002.getTsLastUpdate());
      }
      saveCsupParentDemographicInfo.saveCsupParentDemographicInfo(saveCsupParentNameRowSI, InterfaceServiceConstants.SAVE_PERSON_ADDRESS_DETAIL, SzCdScrDataAction);
      //if (0 == saveCsupParentDemographicInfo.saveCsupParentDemographicInfo(saveCsupParentNameRowSI, InterfaceServiceConstants.SAVE_PERSON_ADDRESS_DETAIL)) {
      //  throw new ServiceException(Messages.MSG_NO_ROWS_RETURNED);
      //}
    }
  }

  private void updateMedicaid(int idPerson, int idStage, ROWCCMN44SIG00 rowccmn44sig00) {
    MedicaidUpdate medicaidUpdate = new MedicaidUpdate();
    Stage stage = (Stage) getPersistentObject(Stage.class, idStage);
    medicaidUpdate.setStage(stage);
    Person person = (Person) getPersistentObject(Person.class, idPerson);
    medicaidUpdate.setPerson(person);
    medicaidUpdate.setIdMedUpdRecord(rowccmn44sig00.getLdIdAddress());
    medicaidUpdate.setCdMedUpdType(CodesTables.CEVNTTYP_MED);
    medicaidUpdate.setCdMedUpdTransType(CodesTables.CMEDUPTR_SUS);
    // caud99d
    medicaidUpdateDAO.saveMedicaidUpdate(medicaidUpdate);
  }
  
  //STGAP00012734: MR-019  This method updates the stage county with the County selected on the Address Detail Page
  //               It does that only if the person updated has the relationship of Primary Caretaker on the stage 
  //               and the county selected on the Address Detail Page is a GA County and the address is marked as primary 
  //               and not marked as invalid. Only the open stages are updated.
  
  private void updateStageCounty(int idPerson, ROWCCMN44SIG00_ARRAY rowccmn44sig00_array, int idStageMain){
    Stage stage = stageDAO.findStageByIdStage(idStageMain);
    if (stage == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    String cdStage = stage.getCdStage();
    if((CodesTables.CSTAGES_INV.equals(cdStage)||
                    CodesTables.CSTAGES_DIV.equals(cdStage) ||
                    CodesTables.CSTAGES_FPR.equals(cdStage))){
      int index_num = 0;
      //Get the index number of the address from the array which is not end-dated
      for (int i = rowccmn44sig00_array.getUlRowQty() - 1; i >= 0; i--) {
        ROWCCMN44SIG00 rowccmn44sig00 = rowccmn44sig00_array.getROWCCMN44SIG00(i);
        if(DateHelper.isNull(rowccmn44sig00.getDtDtPersAddrLinkEnd()) || 
                        (DateHelper.MAX_JAVA_DATE.equals(rowccmn44sig00.getDtDtPersAddrLinkEnd()))){
          index_num = i;
          break;
        }
      }
      ROWCCMN44SIG00 rowccmn44sig00 = rowccmn44sig00_array.getROWCCMN44SIG00(index_num);
      if(rowccmn44sig00 != null){
        //Confirm that Person Address is not end-dated for the stages county to get updated.
        if(DateHelper.isNull(rowccmn44sig00.getDtDtPersAddrLinkEnd()) || 
                        (DateHelper.MAX_JAVA_DATE.equals(rowccmn44sig00.getDtDtPersAddrLinkEnd()))){
          String cdAddrCounty = rowccmn44sig00.getSzCdAddrCounty();
          //Get the region of the county
          String countyRegion = Lookup.simpleDecodeSafe(CodesTables.CCNTYREG, cdAddrCounty);
          boolean isGACounty = isGACounty(cdAddrCounty);
          String indPersAddrLinkInvalid = rowccmn44sig00.getBIndPersAddrLinkInvalid();
          String indPersAddrLinkPrimary = rowccmn44sig00.getBIndPersAddrLinkPrimary();
          if(ArchitectureConstants.Y.equals(indPersAddrLinkPrimary) 
                          && (!ArchitectureConstants.Y.equals(indPersAddrLinkInvalid))
                          && isGACounty){
            List<Integer> idStagesList = stagePersonLinkDAO.findIdStageByIdPersonCdStagePersRelInt(idPerson);
            if (idStagesList != null && !idStagesList.isEmpty()) {
              for (Iterator<Integer> it = idStagesList.iterator(); it.hasNext();) {
                Integer idStage = it.next();
                Stage stageInner = stageDAO.findStageByIdStage(idStage);
                if (stageInner == null) {
                  throw new ServiceException(Messages.SQL_NOT_FOUND);
                }
                //STGAP00014611: Only open INV, ONG and INV stages county be updated
                if(stageInner.getDtStageClose() == null && cdStage.equals(stageInner.getCdStage())){
                  stageDAO.updateStageCdStageRegioncCStageCntyByIdStage(idStage, countyRegion, cdAddrCounty);
                }
              }
            }
          }
        }
      }
    }
  }

  //STGAP00012734: This method returns true if the county is GA county.
  private boolean isGACounty(String legalStatCounty){
    boolean gaCounty = false;
    if(StringHelper.isValid(legalStatCounty)){
      if(!(CodesTables.CCOUNT_999.equals(legalStatCounty) || CodesTables.CCOUNT_XXX.equals(legalStatCounty))){
        gaCounty = true;
      }
    } 
    return gaCounty;
  }
}
