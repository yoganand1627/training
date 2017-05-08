package gov.georgia.dhr.dfcs.sacwis.service.admin.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsCaseDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.service.admin.CheckStageEventStatus;
import gov.georgia.dhr.dfcs.sacwis.service.admin.PostEvent;
import gov.georgia.dhr.dfcs.sacwis.service.admin.SaveCounty;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN27SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdStageCnty_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN01UO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN27SO;

public class SaveCountyImpl extends BaseServiceImpl implements SaveCounty {

  private final String TXT_TO = " to ";
  private final String TXT_COUNTY_CHANGE = "County name change: ";
  
  private CapsCaseDAO capsCaseDAO = null;
  private CheckStageEventStatus checkStageEventStatus = null;
  private StageDAO stageDAO = null;
  private PostEvent postEvent = null;

  public void setCapsCaseDAO(CapsCaseDAO capsCaseDAO) {
    this.capsCaseDAO = capsCaseDAO;
  }

  public void setCheckStageEventStatus(CheckStageEventStatus checkStageEventStatus) {
    this.checkStageEventStatus = checkStageEventStatus;
  }

  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }
  
  public void setPostEvent(PostEvent postEvent) {
    this.postEvent = postEvent;
  }

  public CCMN27SO updateStageCountyCaseCounty(CCMN27SI ccmn27si) throws ServiceException {
    CCMN27SO ccmn27so = new CCMN27SO();
    CCMN06UI ccmn06ui = new CCMN06UI();
    
    int idStage = ccmn27si.getUlIdStage();
    int idCase = ccmn27si.getUlIdCase();
    int idPerson = ccmn27si.getUlIdPerson();    
    SzCdStageCnty_ARRAY szCdStageCntyArray = ccmn27si.getSzCdStageCnty_ARRAY();
    String szCdStageCnty0 = szCdStageCntyArray.getSzCdStageCnty( 0 );
    String szCdStageCnty1 = szCdStageCntyArray.getSzCdStageCnty( 1 );

    if (idStage != 0) {
      ccmn06ui.setUlIdStage(idStage);
      ccmn06ui.setSzCdTask(null);

      checkStageEventStatus.status(ccmn06ui);
    }
    
    //change county and region
    String stgeCntyName = "";
    String szCdStageRegion = "";
    if( szCdStageCnty0.length() == 3){
      stgeCntyName = Lookup.simpleDecodeSafe( CodesTables.CCOUNT, szCdStageCnty0 );
      szCdStageRegion = Lookup.simpleDecodeSafe(CodesTables.CCNTYREG, szCdStageCnty0); //get the region for the county STGAP00004439
    }

    //posting the county change event
    postEvent( idStage, idPerson, stgeCntyName, szCdStageCnty1 );
 
    // STGAP00004439: Change the county as well as the region of the stage
    int stageRowsAffected = stageDAO.updateStageCdStageRegioncCStageCntyByIdStage( idStage, szCdStageRegion, szCdStageCnty0 );

    if (stageRowsAffected == 0) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }

    if (ccmn27si.getUlIdCase() != 0) {
      int capsCaseRowsAffected = capsCaseDAO.updateCapsCaseCdCaseCountyByIdCase( idCase, szCdStageCnty0 );
      // STGAP00004439: Change the region of the case as well
      capsCaseRowsAffected = capsCaseDAO.updateCapsCaseCdCaseRegion( idCase, szCdStageRegion );
      if (capsCaseRowsAffected == 0) {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }

    }

    return ccmn27so;
  }

  private CCMN01UO postEvent( int idStage, int idPerson, String stgeCntyName, String szCdStageCnty1){
    
    // The input object used as parameter for PostEvent DAO is partially populated here. The String value passed as a
    //   parameter into the helper method below is for populating the SzTxtEventDescr field within ccmn01ui.
    CCMN01UI ccmn01ui = new CCMN01UI();
    ROWCCMN01UIG00 rowccmn01uig00 = new ROWCCMN01UIG00();
    rowccmn01uig00.setSzCdEventStatus(CodesTables.CEVTSTAT_COMP);
    rowccmn01uig00.setSzCdEventType(CodesTables.CEVNTTYP_CAS);
    rowccmn01uig00.setDtDtEventOccurred(DateHelper.getTodayCastorDate());
    rowccmn01uig00.setUlIdStage(idStage);
    rowccmn01uig00.setUlIdPerson(idPerson);
    // The folowing setting of ArchInputStruct is used for the later calls of PostEvent as well.
    ArchInputStruct ccmn01ui_archInputStruct = new ArchInputStruct();
    ccmn01ui_archInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_ADD);
    ccmn01ui.setArchInputStruct(ccmn01ui_archInputStruct);

    //clear text description to ensure that a new string is not being appended to the old string value
    rowccmn01uig00.setSzTxtEventDescr("");
    String newTxtEventDescr = TXT_COUNTY_CHANGE + szCdStageCnty1 + TXT_TO + stgeCntyName;
    rowccmn01uig00.setSzTxtEventDescr(newTxtEventDescr);
    ccmn01ui.setROWCCMN01UIG00(rowccmn01uig00);
    return postEvent.postEvent(ccmn01ui);    
  }

}

