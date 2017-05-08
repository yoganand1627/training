package gov.georgia.dhr.dfcs.sacwis.service.person.impl;

import java.util.Date;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsCaseDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexNameDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EligibilityDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.NameDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonIdDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Eligibility;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.service.admin.CheckStageEventStatus;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.person.SaveCsupParentDemographicInfo;
import gov.georgia.dhr.dfcs.sacwis.service.person.SaveName;
import gov.georgia.dhr.dfcs.sacwis.service.ws.UpdateClientOutbound;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV26SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ClientOutboundBean;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ClientOutboundSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV26SIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV26SIG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SaveCsupParentDemographicInfoSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SzNmPersonFull_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV26SO;

import gov.georgia.dhr.dfcs.sacwis.service.common.InterfaceServiceConstants;

/*** Change History:
 **  Date        User              Description
 **  --------    ----------------  --------------------------------------------------
 **  04/01/2008  charden           STGAP00006396: called method updateNmNamefstMddlLast() 
 *                                 to update the first, middle and last name in the name table
 *                                 when new primary caretaker is added and created new field
 *                                 ArrayIndex
 *                            
 *   07/17/2008  charden           STGAP00006557 - created new method to save person name history  
 *                                 info to csupParentOutbound when add is being done
 *                                                    
 **/

public class SaveNameImpl extends BaseServiceImpl implements SaveName {

  // 19 is the length of the longest full name minus 6 characters for "et al" minus one for an extra space
  private static final int CASE_NM_ET_AL_LEN = 19;

  private static final String CASE_NM_ET_AL = " et al";

  private static final String NAME_HISTORY = "Name History";
  
  private static final int ARRAY_INDEX = 1;
  
  private CapsCaseDAO capsCaseDAO = null;

  private CheckStageEventStatus checkStageEventStatus = null;

  private ComplexNameDAO complexNameDAO = null;
  
  private EligibilityDAO eligibilityDAO = null;

  private NameDAO nameDAO = null;

  private PersonDAO personDAO = null;
  
  private PersonIdDAO personIdDAO = null;
  
  private SaveCsupParentDemographicInfo saveCsupParentDemographicInfo = null;

  private StageDAO stageDAO = null;

  private UpdateClientOutbound updateClientOutbound = null;
  
  public void setCapsCaseDAO(CapsCaseDAO capsCaseDAO) {
    this.capsCaseDAO = capsCaseDAO;
  }

  public void setCheckStageEventStatus(CheckStageEventStatus checkStageEventStatus) {
    this.checkStageEventStatus = checkStageEventStatus;
  }

  public void setComplexNameDAO(ComplexNameDAO complexNameDAO) {
    this.complexNameDAO = complexNameDAO;
  }

  public void setEligibilityDAO(EligibilityDAO eligibilityDAO) {
    this.eligibilityDAO = eligibilityDAO;
  }
  
  public void setNameDAO(NameDAO nameDAO) {
    this.nameDAO = nameDAO;
  }

  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }

  public void setPersonIdDAO(PersonIdDAO personIdDAO) {
    this.personIdDAO = personIdDAO;
  }
  
  public void setSaveCsupParentDemographicInfo(SaveCsupParentDemographicInfo saveCsupParentDemographicInfo) {
    this.saveCsupParentDemographicInfo = saveCsupParentDemographicInfo;
  }
  
  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }

  public void setUpdateClientOutbound(UpdateClientOutbound updateClientOutbound) {
    this.updateClientOutbound = updateClientOutbound;
  }
  
  public CINV26SO updateNameInformation(CINV26SI cinv26si) throws ServiceException {
    CINV26SO cinv26so = new CINV26SO();

    if (ArchitectureConstants.N.equals(cinv26si.getBSysIndGeneric())) {
      // Common Function: ccmn06u Check Stage/Event common function
      CCMN06UI ccmn06ui = new CCMN06UI();
      ccmn06ui.setArchInputStruct(new ArchInputStruct());
      ccmn06ui.getArchInputStruct().setCReqFuncCd(cinv26si.getArchInputStruct().getCReqFuncCd());
      ccmn06ui.setUlIdStage(cinv26si.getUlIdStage());
      ccmn06ui.setSzCdTask(cinv26si.getSzCdTask());
      // CheckStageEventStatus;
      // this throws an exception that will halt processing with a message if it fails; success is no output.
      checkStageEventStatus.status(ccmn06ui);
    }

    ROWCINV26SIG00_ARRAY rowcinv26sig00_array = cinv26si.getROWCINV26SIG00_ARRAY();

    // cinv32d
    //saveName(rowcinv26sig00_array);
    saveName(cinv26si);
    
    // SIR 14053 added the condition to only do this for F/A Homes
    if (ArchitectureConstants.Y.equals(cinv26si.getBSysIndUpdateFullName())) {
      ROWCINV26SIG00 rowcinv26sig00 = rowcinv26sig00_array.getROWCINV26SIG00(0);
      SzNmPersonFull_ARRAY nmPersonFull_array = cinv26si.getSzNmPersonFull_ARRAY();
      String nmPersonFull1 = nmPersonFull_array.getSzNmPersonFull(1);
      String nmPersonFull0 = nmPersonFull_array.getSzNmPersonFull(0);
      int idPerson = rowcinv26sig00.getUlIdPerson();
      // Update the FULL name on the PERSON TABLE. If this service is to update NM PERSON FULL on the person table,
      // SysIndUpdateFullName must be set to true by the calling window. This is done because Person Detail already
      // has a DAO to update a full row in the Person Table and hopefully this save processing time.
      // cinv50d
      int nbrRowsUpdated = personDAO.updatePersonNamePersonFull(idPerson, nmPersonFull1);
      if (nbrRowsUpdated == 0) {
        throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
      }

      // Change the Case Name for all open APS cases where the original Case Name is equal to a given NM PERSON FULL and
      // the ID PERSON is linked to the case as a victim or client. The update must we done twice, the first time
      // with the names passed in, and the second time with ", et al." appended to take care of APS Facility cases.
      // Update APS Case Name (NM_CASE on CAPS_CASE) given the original Case Name, the new Case Name, and an IdPerson
      // ccmnh4d
      capsCaseDAO.updateCapsCase(nmPersonFull1, nmPersonFull0, DateHelper.MAX_JAVA_DATE, idPerson);

      // ccmnh5d
      stageDAO.updateStage(nmPersonFull1, nmPersonFull0, idPerson, DateHelper.MAX_JAVA_DATE);

      // Append Et. Al to the case names.
      nmPersonFull1 = appendEtAl(nmPersonFull1);
      nmPersonFull0 = appendEtAl(nmPersonFull0);

      // ccmnh4d
      capsCaseDAO.updateCapsCase(nmPersonFull1, nmPersonFull0, DateHelper.MAX_JAVA_DATE, idPerson);

      // ccmnh5d
      stageDAO.updateStage(nmPersonFull1, nmPersonFull0, idPerson, DateHelper.MAX_JAVA_DATE);
    }
    return cinv26so;
  }

  private String appendEtAl(String nmPersonFull) {
    // Update APS case name with ", et al" appended to name
    if (nmPersonFull.length() <= CASE_NM_ET_AL_LEN) {
      // The name is short enough, simply append "et al"
      nmPersonFull += CASE_NM_ET_AL;
    } else {
      // The name is too long, overwrite the end of it
      nmPersonFull = nmPersonFull.substring(CASE_NM_ET_AL_LEN) + CASE_NM_ET_AL;
    }
    return nmPersonFull;
  }

  @SuppressWarnings({"unchecked"})
  
  //private void saveName(ROWCINV26SIG00_ARRAY rowcinv26sig00_array) throws ServiceException {
  private void saveName(CINV26SI cinv26si) throws ServiceException {
    ROWCINV26SIG00_ARRAY rowcinv26sig00_array = cinv26si.getROWCINV26SIG00_ARRAY();
    // Keeps track of the timestamps on the Start and End dates. The primary names in the input message are sorted in
    // reverse-modified order (i.e., the most recent primary name added or modified will be at beginning of the input
    // message). To ensure that the names receive the timestamps in the proper order, we need to process the list in
    // reverse order. This requires the loop to be run backwards.
    for (int i = rowcinv26sig00_array.getROWCINV26SIG00Count() - 1; i >= 0; i--) {
      ROWCINV26SIG00 rowcinv26sig00 = rowcinv26sig00_array.getROWCINV26SIG00(i);
      String cdNameSuffix = rowcinv26sig00.getSzCdNameSuffix();
      Date dtNameEndDate = DateHelper.toJavaDate(rowcinv26sig00.getDtDtNameEndDate());
      int idName = rowcinv26sig00.getUlIdName();
      int idPerson = rowcinv26sig00.getUlIdPerson();
      String indNameInvalid = rowcinv26sig00.getBIndNameInvalid();
      String indNamePrimary = rowcinv26sig00.getBIndNamePrimary();
      String nmNameFirst = rowcinv26sig00.getSzNmNameFirst();
      String nmNameLast = rowcinv26sig00.getSzNmNameLast();
      String nmNameMiddle = rowcinv26sig00.getSzNmNameMiddle();
      Date tsLastUpdate = rowcinv26sig00.getTsLastUpdate();
      String cdScrDataAction = rowcinv26sig00.getSzCdScrDataAction();
      int nbrRowsUpdated;
//      if(i == ARRAY_INDEX && ServiceConstants.REQ_FUNC_CD_ADD.equals(cdScrDataAction)){
//        nameDAO.insertName(cdNameSuffix, idName, idPerson, indNameInvalid, indNamePrimary, nmNameFirst,
//                           nmNameLast, nmNameMiddle);
//      }
      if (ServiceConstants.REQ_FUNC_CD_ADD.equals(cdScrDataAction)) {
        // cinv32d
        complexNameDAO.insertNameCheckDtNameEndDateForNull(cdNameSuffix, dtNameEndDate, idName, idPerson,
                                                           indNameInvalid, indNamePrimary, nmNameFirst, nmNameLast,
                                                           nmNameMiddle);
        //ClientOutbound Interface Update for new primary Name addition if the client
        //information is already sent to SMILE interface.
        Person person = personDAO.findPersonByIdPerson(idPerson);
        String cdSmileClient = person.getCdSmileClient();
        if (null != cdSmileClient){
          if ("Y".equals(indNamePrimary)){
            ClientOutboundBean clientOutboundBean = loadClientOutboundBean(idPerson, nmNameFirst, nmNameLast, nmNameMiddle, 
                                                                           cdNameSuffix, cinv26si.getUlIdPersonId());
            ClientOutboundSaveSI clientOutboundSaveSI = loadClientOutboundSaveSI(cinv26si.getUlIdEvent(), cinv26si.getUlIdPersonId(), 
                                                                                 cinv26si.getUlIdStage(), clientOutboundBean);
            updateClientOutbound.updateClientOutbound(clientOutboundSaveSI);
          }
        }
      } else if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(cdScrDataAction)) {
        // cinv32d
        int numRowsUpdated = complexNameDAO.updateNameCheckDtNameEndDateForNull(cdNameSuffix, dtNameEndDate, idName,
                                                                            idPerson, indNameInvalid, indNamePrimary,
                                                                            nmNameFirst, nmNameLast, nmNameMiddle,
                                                                            tsLastUpdate);
        if (numRowsUpdated == 0) {
          throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
        } 
      } else if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(cdScrDataAction)) {

        // cinv32d
        nameDAO.deleteName(idName, tsLastUpdate);
      } else {
        throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
      }
    }
    //STGAP00006557 - called new method to save name info to CsupParentOutbound table when name is added or updated on Name History page
    ROWCINV26SIG00 rowcinv26sig002 = new ROWCINV26SIG00();
    rowcinv26sig002 = rowcinv26sig00_array.getROWCINV26SIG00(0);
    String cdScrDataAction2 = rowcinv26sig002.getSzCdScrDataAction();
    
    if(ServiceConstants.REQ_FUNC_CD_ADD.equals(cdScrDataAction2)){
      int idPerson2 = rowcinv26sig002.getUlIdPerson();
      String nmNameFirst2 = rowcinv26sig002.getSzNmNameFirst() != null ? rowcinv26sig002.getSzNmNameFirst() : "";
      String nmNameLast2 = rowcinv26sig002.getSzNmNameLast() != null ? rowcinv26sig002.getSzNmNameLast() : "";
      String nmNameMiddle2 = rowcinv26sig002.getSzNmNameMiddle() != null ? rowcinv26sig002.getSzNmNameMiddle() : "";

      Date tsLastUpdate2 = rowcinv26sig002.getTsLastUpdate();
      saveCsup(idPerson2, nmNameFirst2, nmNameLast2, nmNameMiddle2, tsLastUpdate2, rowcinv26sig002, cdScrDataAction2);
    }
  }

  private ClientOutboundBean loadClientOutboundBean(int idPerson, String nmNameFirst, 
                                                    String nmNameLast, String nmNameMiddle, String cdNameSuffix, int idInitiator){
    ClientOutboundBean clientOutboundBean = new ClientOutboundBean();
    clientOutboundBean.setIdPerson(idPerson);
    
    clientOutboundBean.setNmPersonFirst(nmNameFirst);
    clientOutboundBean.setNmPersonLast(nmNameLast);
    clientOutboundBean.setNmPersonMiddle(nmNameMiddle);
    clientOutboundBean.setCdPersonSuffix(cdNameSuffix);
    clientOutboundBean.setIdInitiator(idInitiator);
    clientOutboundBean.setCdOriginatingPage(NAME_HISTORY);
    return clientOutboundBean;
  }
    
  private ClientOutboundSaveSI loadClientOutboundSaveSI(int idEvent, int idPerson, int idStage,  ClientOutboundBean clientOutboundBean){
    ClientOutboundSaveSI clientOutboundSaveSI = new ClientOutboundSaveSI();
    clientOutboundSaveSI.setIdEvent(idEvent);
    clientOutboundSaveSI.setIdInitiator(idPerson);
    clientOutboundSaveSI.setIdStage(idStage);
    clientOutboundSaveSI.setClientOutboundBean(clientOutboundBean);
    return clientOutboundSaveSI;
  }
  
  //STGAP00006557 - created new method to save name info to csupParentOutbound
  private void saveCsup(int idPerson, String nmNameFirst, String nmNameLast, String nmNameMiddle, Date tsLastUpdate,
                        ROWCINV26SIG00 rowcinv26sig00, String cdScrDataAction) {

    // Add code for CSUPParent Update info
    SaveCsupParentDemographicInfoSI saveCsupParentNameRowSI = new SaveCsupParentDemographicInfoSI();
    Object[] parentInfo = personIdDAO.findDistinctParentByStagePersRelId(idPerson);
    if (null != parentInfo && ServiceConstants.REQ_FUNC_CD_ADD.equals(rowcinv26sig00.getSzCdScrDataAction())) {
      saveCsupParentNameRowSI.setIdPersonId(idPerson);
      saveCsupParentNameRowSI.setNmNoncustFirst(nmNameFirst);
      saveCsupParentNameRowSI.setNmNoncustLast(nmNameLast);
      saveCsupParentNameRowSI.setNmNoncustMiddle(nmNameMiddle);
      if (null != tsLastUpdate) {
        saveCsupParentNameRowSI.setDtCsupparRequested(tsLastUpdate);
      }
    }
    saveCsupParentDemographicInfo.saveCsupParentDemographicInfo(saveCsupParentNameRowSI,
                                                                InterfaceServiceConstants.SAVE_PERSON_NAME_DETAIL, cdScrDataAction);
  }
}
