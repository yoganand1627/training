/**
 *  @author ashwini.rege 
 */
package gov.georgia.dhr.dfcs.sacwis.service.casemgmt.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.IcpcDetailDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.IcpcEnclosedDocCbxDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Employee;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.IcpcDetail;
import gov.georgia.dhr.dfcs.sacwis.db.IcpcEnclosedDocCbx;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.StagePersonLink;
import gov.georgia.dhr.dfcs.sacwis.service.admin.PostEvent;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.SaveIcpcDetail;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.IcpcDetailSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN01UO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.IcpcDetailSaveSO;

import java.util.Date;
import java.util.Iterator;
import java.util.List;


 /**
   * This Service saves data for the Icpc Detail page
   *
   * @param IcpcDetailSaveSI object
   * @return IcpcDetailSaveSO object   
   *
   * Change History:
   *  Date        User              Description
   * --------    ----------------  ----------------------------------------------------------------
   * 01/23/2012	  arege		    STGAP00017827: MR-085 Initial Creation
   * 02/06/2012   arege             STGAP00017827: MR-085 Fixed saving of page when no primary person is selected 
   *                                Added comments and cleaned up the code
   * 02/09/2012   arege             STGAP00017827: Removed unnecessary code as per peer review modified the logic for 
   *                                saving check boxes.
   * 02/13/2012   arege             STGAP00017827: Case Manager's name should not get updated when the event is in COMP status.
   * 02/16/2012   arege             STGAP00017898: The primary person and spouse should be set to null if the user 
   *                                changes primary person and spouse fields to blank.
   * 03/02/2012   arege             STGAP00017967: CaseWorker was not saved if the Complete button was clicked before save
   * 03/11/2012   arege             STGAP00018011: Set correct date event occurred
   */

public class SaveIcpcDetailImpl extends BaseServiceImpl implements SaveIcpcDetail {
  
  public static final String PLACEMENT_STATUS_INITIAL = "I";
  public static final String PLACEMENT_STATUS_CHANGE = "C";

  private PostEvent postEvent = null;

  private IcpcDetailDAO icpcDetailDAO = null;

  private IcpcEnclosedDocCbxDAO icpcEnclosedDocCbxDAO = null;

  private StagePersonLinkDAO stagePersonLinkDAO = null;

  public void setPostEvent(PostEvent postEvent) {
    this.postEvent = postEvent;
  }

  public void setIcpcDetailDAO(IcpcDetailDAO icpcDetailDAO) {
    this.icpcDetailDAO = icpcDetailDAO;
  }

  public void setIcpcEnclosedDocCbxDAO(IcpcEnclosedDocCbxDAO icpcEnclosedDocCbxDAO) {
    this.icpcEnclosedDocCbxDAO = icpcEnclosedDocCbxDAO;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public IcpcDetailSaveSO saveIcpcDetail(IcpcDetailSaveSI icpcDetailSaveSI) throws ServiceException {

    IcpcDetailSaveSO icpcDetailSaveSO = new IcpcDetailSaveSO();

    ROWCCMN01UIG00 icpEvent = icpcDetailSaveSI.getRowccmn01uig00();

    int idEvent = icpEvent.getUlIdEvent();
    int idUser = icpcDetailSaveSI.getIdCaseWorker();
    String cdTask = icpcDetailSaveSI.getCdTask();

    Event event = null;
    icpEvent.setUlIdPerson(idUser);

    String actionCode = ServiceConstants.REQ_FUNC_CD_ADD;
    if (idEvent != 0) {
      actionCode = ServiceConstants.REQ_FUNC_CD_UPDATE;
    }

    IcpcDetail icpcDetail = new IcpcDetail();
    if (idEvent != 0) {
      // Get Icpc detail from the database for the idEvent
      icpcDetail = icpcDetailDAO.findIcpcDetailByIdEvent(idEvent);
      event = (Event) getPersistentObject(Event.class, idEvent);
      icpcDetail.setEvent(event);
      icpcDetailSaveSI.setIdEvent(idEvent);
    }
 
    icpcDetail = populate_IcpcDetail_SaveSI(icpcDetailSaveSI, icpcDetail);

    CCMN01UO ccmn01uo = callPostEvent(icpcDetailSaveSI, actionCode);
    if (ccmn01uo != null) {
      idEvent = ccmn01uo.getUlIdEvent();
      event = (Event) getPersistentObject(Event.class, idEvent);
    }
    icpcDetail.setEvent(event);
    icpcDetailDAO.saveIcpcDetail(icpcDetail);
    icpcDetailSaveSO.setIdEvent(idEvent);
    icpcDetailSaveSO.setCdTask(cdTask);

    // Save rows to the Checkbox table
    // Required checkboxes
    List<String> reqCbxAddList = icpcDetailSaveSI.getReqCbxToAdd();    
    //First delete all the required checkboxes that are in the database for the given idicpcdetail
    icpcEnclosedDocCbxDAO.deleteEnclosedDocCbxByIcpcDetailAndCdCbxCodeType(CodesTables.CDREQCBX, icpcDetail.getIdIcpcDetail());
    //Save the newly added required checkboxes
    if (reqCbxAddList != null && !reqCbxAddList.isEmpty()) {
      addCbx(reqCbxAddList, CodesTables.CDREQCBX, icpcDetail);
    }


    // If Applicable checkboxes
    List<String> aplCbxAddList = icpcDetailSaveSI.getAplCbxToAdd();
    //First delete all the if applicable checkboxes that are in the database for the given idicpcdetail
    icpcEnclosedDocCbxDAO.deleteEnclosedDocCbxByIcpcDetailAndCdCbxCodeType(CodesTables.CDAPLCBX, icpcDetail.getIdIcpcDetail());
    if (aplCbxAddList != null && !aplCbxAddList.isEmpty()) {
      addCbx(aplCbxAddList, CodesTables.CDAPLCBX, icpcDetail);
    }



    return icpcDetailSaveSO;
  }

  /**
   * Populates the icpcDetailDB object for save
   * 
   * @param icpcDetailSaveSI
   * @param icpcDetailDB
   * @return IcpcDetail
   */
  private IcpcDetail populate_IcpcDetail_SaveSI(IcpcDetailSaveSI icpcDetailSaveSI, IcpcDetail icpcDetailDB) {
    Person child = (Person) getPersistentObject(Person.class, icpcDetailSaveSI.getIdChild());
    icpcDetailDB.setChild(child);
    if (icpcDetailSaveSI.getIdPrimaryPerson() > 0) {
      Person primaryPerson = (Person) getPersistentObject(Person.class, icpcDetailSaveSI.getIdPrimaryPerson());
      icpcDetailDB.setPrimaryPerson(primaryPerson);
    }
    //STGAP00017898: The primary person should be set to null if the user does not select primary person field.
    else{
      //STGAP     This will ensure that the page is not saved with the old idPerson if the idPrimary person is changed to nothing (not selected) 
      icpcDetailDB.setPrimaryPerson(null);
    }
    if (icpcDetailSaveSI.getIdSpouse() > 0) {
      Person spouse = (Person) getPersistentObject(Person.class, icpcDetailSaveSI.getIdSpouse());
      icpcDetailDB.setSpouse(spouse);
    }
    //STGAP00017898: The spouse should be set to null if the user does not select primary person field.
    else{
      icpcDetailDB.setSpouse(null);
    }
    if(!CodesTables.CEVTSTAT_COMP.equals(icpcDetailSaveSI.getRowccmn01uig00().getSzCdEventStatus()) 
                    || icpcDetailSaveSI.getIdEvent() == 0){
    Employee employee = (Employee) getPersistentObject(Employee.class, icpcDetailSaveSI.getIdCaseWorker());
    icpcDetailDB.setEmployee(employee);
    }
    icpcDetailDB.setIveDeterm(icpcDetailSaveSI.getIveDeterm());
    icpcDetailDB.setAaFundingDeterm(icpcDetailSaveSI.getAaFundingDeterm());
    icpcDetailDB.setCdIcpcFormType(icpcDetailSaveSI.getCdFormType());
    icpcDetailDB.setIndIcwaElig(icpcDetailSaveSI.getIndICWAEligible());
    icpcDetailDB.setIndCrtOrderAf(icpcDetailSaveSI.getIndCrtOrderAf());
    icpcDetailDB.setIndCrtOrderLcgr(icpcDetailSaveSI.getIndCrtOrderLcgr());
    icpcDetailDB.setIndCrtOrderLcrp(icpcDetailSaveSI.getIndCrtOrderLcrp());
    icpcDetailDB.setTxtOtherSpecify(icpcDetailSaveSI.getTxtOtherSpecify());
    icpcDetailDB.setCdTypeCare(icpcDetailSaveSI.getCdTypeCare());
    icpcDetailDB.setCdInitReportReq(icpcDetailSaveSI.getCdInitReportReq());
    icpcDetailDB.setIndFinalizedIn(icpcDetailSaveSI.getIndFinalizedIn());
    icpcDetailDB.setIndPlcmtStatus(icpcDetailSaveSI.getIndPlcmtStatus());
    //If placement status is Initial then set DtChildPlaced as Date Child Placed in Receiving State
    // and if placement status is Placement Change , set the Date Child Placed column as Effective Date of Change.
    if (PLACEMENT_STATUS_INITIAL.equals(icpcDetailSaveSI.getIndPlcmtStatus())) {
      icpcDetailDB.setDtChildPlaced(icpcDetailSaveSI.getDtPlacedRecState());
    } else if (PLACEMENT_STATUS_CHANGE.equals(icpcDetailSaveSI.getIndPlcmtStatus())) {
      icpcDetailDB.setDtChildPlaced(icpcDetailSaveSI.getDtEffectDtChange());
    }
    icpcDetailDB.setCdPlcmtTermRsn(icpcDetailSaveSI.getCdPlcmtTermRsn());
    icpcDetailDB.setTxtOtherSpecify(icpcDetailSaveSI.getTxtOtherSpecify());
    icpcDetailDB.setDtTermination(icpcDetailSaveSI.getDtTermination());
    icpcDetailDB.setDtCompleted(icpcDetailSaveSI.getDtCompleted());

    return icpcDetailDB;
  }

  /**
   * Creates/updates the event for IcpcDetail
   * 
   * @param icpcDetailSaveSI
   * @param actionCode
   * @return CCMN01UO event object
   */
  private CCMN01UO callPostEvent(IcpcDetailSaveSI icpcDetailSaveSI, String actionCode) {
    ROWCCMN01UIG00 rowccmn01uig00 = new ROWCCMN01UIG00();
    ROWCCMN01UIG01_ARRAY rowccmn01uig01_array = new ROWCCMN01UIG01_ARRAY();
    String desc = StringHelper.EMPTY_STRING;
    int idEvent = icpcDetailSaveSI.getIdEvent();
    int idPerson = icpcDetailSaveSI.getIdChild();
    String eventStatus = icpcDetailSaveSI.getRowccmn01uig00().getSzCdEventStatus();
    String formType = icpcDetailSaveSI.getCdFormType();
    int idPrimaryPerson = icpcDetailSaveSI.getIdPrimaryPerson();
    String resourceName = StringHelper.EMPTY_STRING;
    if (idPrimaryPerson != 0) {
      Person primaryPersonOrResource = getPersistentObject(Person.class, idPrimaryPerson);
      resourceName = primaryPersonOrResource.getNmPersonFull();
    }
    String descr100A = ": " + Lookup.simpleDecodeSafe(CodesTables.CINRPTRQ, icpcDetailSaveSI.getCdInitReportReq());
    desc = formType + " for " + resourceName;
    if ("100A".equals(formType)) {
      desc = desc + descr100A;
    }

    if (idEvent != 0) {
      rowccmn01uig00.setUlIdEvent(idEvent);
      rowccmn01uig00.setTsLastUpdate(icpcDetailSaveSI.getDtEventLastUpdate());
      eventStatus = icpcDetailSaveSI.getRowccmn01uig00().getSzCdEventStatus();
      rowccmn01uig00.setSzCdEventStatus(eventStatus);
    }
    if (desc.length() > 100) {
      desc = desc.substring(0, 99);
    }
    rowccmn01uig00.setSzCdEventStatus(eventStatus);
    rowccmn01uig00.setSzCdEventType(CodesTables.CEVNTTYP_ICP);
    rowccmn01uig00.setSzTxtEventDescr(desc);
    rowccmn01uig00.setSzCdTask(icpcDetailSaveSI.getCdTask());
    if(!CodesTables.CEVTSTAT_COMP.equals(eventStatus) || idEvent == 0){
    rowccmn01uig00.setUlIdPerson(icpcDetailSaveSI.getIdCaseWorker());
    }
    rowccmn01uig00.setUlIdStage(icpcDetailSaveSI.getIdStage());
    if (idEvent != 0 && !DateHelper.isNull(icpcDetailSaveSI.getRowccmn01uig00().getDtDtEventOccurred())) {
      rowccmn01uig00.setDtDtEventOccurred(icpcDetailSaveSI.getRowccmn01uig00().getDtDtEventOccurred());
    } else {
      rowccmn01uig00.setDtDtEventOccurred(DateHelper.toCastorDate(new Date()));

    }
    gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01 rowccmn01uig01;
    if (idPerson != 0) {
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

  /**
   * This private method iterates through the add list to insert new rows to ICPC_ENCLOSED_DOC_CBX for Required document
   * checkboxes newly clicked
   * 
   * @param ID_ICPC_DETAIL
   * @param addList
   * @return
   * @throws ServiceException
   */
  private void addCbx(List<String> addList, String cdCbxCodeType, IcpcDetail icpcDetail) throws ServiceException {

    for (Iterator<String> it = addList.iterator(); it.hasNext();) {
      String cdEnclDoc = it.next();
      IcpcEnclosedDocCbx icpcEnclosedDocCbx = new IcpcEnclosedDocCbx();
      icpcEnclosedDocCbx.setCdCbxCodeType(cdCbxCodeType);
      icpcEnclosedDocCbx.setCdEnclDoc(cdEnclDoc);
      icpcEnclosedDocCbx.setIcpcDetail(icpcDetail);
      icpcEnclosedDocCbxDAO.saveOrUpdateEnclosedDocCbx(icpcEnclosedDocCbx);
    }
  }
}
