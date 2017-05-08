package gov.georgia.dhr.dfcs.sacwis.service.admin.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.AdminAllegationDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.AdminReviewDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.AllegationDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.UnitEmpLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.AdminReview;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.StagePersonLink;
import gov.georgia.dhr.dfcs.sacwis.service.admin.CloseOpenStage;
import gov.georgia.dhr.dfcs.sacwis.service.admin.SaveCreateAdminReview;
import gov.georgia.dhr.dfcs.sacwis.service.admin.TodoCommonFunction;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC42SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN03UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB40UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB40UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.UlIdPerson_ARRAY_CCFC42SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC42SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN03UO;

import java.util.Map;

/**
 * Change History:
*  Date      User      Description
*  --------  --------  --------------------------------------------------
* 09/15/2009  bgehlot  STGAP00015366: If VC or DV is selected then throw the message 
* <pre>
*/

public class SaveCreateAdminReviewImpl extends BaseServiceImpl implements SaveCreateAdminReview {

  private AdminAllegationDAO adminAllegationDAO = null;
  
  private AllegationDAO allegationDAO = null;

  private AdminReviewDAO adminReviewDAO = null;

  private CloseOpenStage closeOpenStage = null;

  private PersonDAO personDAO = null;

  private StageDAO stageDAO = null;

  private StagePersonLinkDAO stagePersonLinkDAO = null;

  private TodoCommonFunction todoCommonFunction = null;

  private UnitEmpLinkDAO unitEmpLinkDAO = null;

  public static final int REQUESTER = 0;

  public static final int USER = 1;

  //public static final String STG_ROLE_CLIENT = "CL";

  //public static final String STG_ROLE_DESIG_VIC_PERP = "DB";

  //public static final String STG_ROLE_DESIG_PERP = "DP";
  
  public static final String STG_ROLE_ALLEG_PERP = "AP";

  //public static final String STG_ROLE_SUSTAIN_PERP = "SP";

  public static final String STAGE_CD_AR_INV = CodesTables.CSTGTYPE_ARI;

  public static final String STAGE_CD_AR_FAD = CodesTables.CSTGTYPE_ARF;

  public static final String TODO_TEXT_CFC012_START = "ARV in Case ";

  public static final String TODO_TXT_CFC012_END = " requested by ";

  public static final String CCFC012 = "CFC012";

  public static final int MIN_PAGE_FOR_CCMNB8 = 1;

  public static final String TODO_TEXT_CFC028_START = "ARV in ";

  public static final String TODO_TXT_CFC028_END = " Case requested re ";

  public static final String CCFC028 = "CFC028";

  public static final String CAPS_PROG_AFC = CodesTables.CPGRMS_AFC;

  public static final String CAPS_PROG_APS = CodesTables.CPGRMS_APS;

  public void setAllegationDAO(AllegationDAO allegationDAO) {
    this.allegationDAO = allegationDAO;
  }
  
  public void setAdminAllegationDAO(AdminAllegationDAO adminAllegationDAO) {
    this.adminAllegationDAO = adminAllegationDAO;
  }

  public void setAdminReviewDAO(AdminReviewDAO adminReviewDAO) {
    this.adminReviewDAO = adminReviewDAO;
  }

  public void setCloseOpenStage(CloseOpenStage closeOpenStage) {
    this.closeOpenStage = closeOpenStage;
  }

  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }

  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public void setTodoCommonFunction(TodoCommonFunction todoCommonFunction) {
    this.todoCommonFunction = todoCommonFunction;
  }

  public void setUnitEmpLinkDAO(UnitEmpLinkDAO unitEmpLinkDAO) {
    this.unitEmpLinkDAO = unitEmpLinkDAO;
  }

  public CCFC42SO saveCreateAdminReview(CCFC42SI ccfc42si) throws ServiceException {
    CCFC42SO ccfc42so = new CCFC42SO();
    UlIdPerson_ARRAY_CCFC42SI idPersonArrayCcfc42Si = ccfc42si.getUlIdPerson_ARRAY_CCFC42SI();
    int idPersonArrayCcfc42SiIdPersonRequester = idPersonArrayCcfc42Si.getUlIdPerson(REQUESTER);
    int idPersonArrayCcfc42SiIdPersonUser = idPersonArrayCcfc42Si.getUlIdPerson(USER);
    int ccfc42siIdStage = ccfc42si.getUlIdStage();
    boolean idFound = false;

    if (idPersonArrayCcfc42SiIdPersonRequester > 0) {

      // cinv39dQUERYdam
      StagePersonLink cinv39dStagePersonLink = stagePersonLinkDAO
              .findStagePersonLinkByIdPersonAndIdStage(
                      idPersonArrayCcfc42SiIdPersonRequester,
                      ccfc42siIdStage);
      if (cinv39dStagePersonLink == null) {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }

      String cinv39dCdStagePersRole = cinv39dStagePersonLink.getCdStagePersRole();

      //STGAP00015366: If VC or DV is selected then throw the message
     if (CodesTables.CINTROLE_VC.equals(cinv39dCdStagePersRole) || CodesTables.CINVROLE_DV.equals(cinv39dCdStagePersRole)) {
        throw new ServiceException(Messages.MSG_ARI_NO_REVIEW_DV_VC);
      }

    } else {

      // csec64dQUERYdam
      // Per STGAP00006397 Changed method name
      Integer csec64dIdStage = adminReviewDAO.findAdminReviewByIdStageDtStageClose(ccfc42siIdStage);
      
      // Per STGAP00006539 to resolve NullPointerException
      if (csec64dIdStage != null) {
        if (csec64dIdStage > 0) {
          idFound = true;
          throw new ServiceException(Messages.MSG_ADMIN_REV_EXISTS);
        }
      }
    }

    if (!idFound) {

      CCMN03UI ccmn03ui = new CCMN03UI();
      ArchInputStruct ccmn03uiArchInputStruct = ccfc42si.getArchInputStruct();
      if ( ccmn03uiArchInputStruct == null)
      {
        ccmn03uiArchInputStruct = new ArchInputStruct();
      }
      ccmn03uiArchInputStruct.setUsPageNbr(MIN_PAGE_FOR_CCMNB8);
      ccmn03ui.setArchInputStruct(ccmn03uiArchInputStruct);
//      ccmn03ui.getArchInputStruct().setUsPageNbr(MIN_PAGE_FOR_CCMNB8);
      ccmn03ui.setUlIdStage(ccfc42siIdStage);
      ccmn03ui.setSzCdStage(ccfc42si.getSzCdStage());
      ccmn03ui.setSzCdStageProgram(ccfc42si.getSzCdStageProgram());
      ccmn03ui.setUlIdPerson(idPersonArrayCcfc42SiIdPersonUser);
      ccmn03ui.setUlScrIdPrimChild(idPersonArrayCcfc42SiIdPersonRequester);
      ccmn03ui.setCSysIndSStgOpenOnly(ArchitectureConstants.Y);

      if (idPersonArrayCcfc42SiIdPersonRequester > 0) {
        ccmn03ui.setSzCdStageOpen(STAGE_CD_AR_INV);
        ccmn03ui.setSzCdStageReasonClosed(STAGE_CD_AR_INV);
        ccmn03ui.setSzNmPersonFull(ccfc42si.getSzNmPersonFull());
      } else {
        ccmn03ui.setSzCdStageOpen(STAGE_CD_AR_FAD);
        ccmn03ui.setSzCdStageReasonClosed(STAGE_CD_AR_FAD);
        ccmn03ui.setSzNmPersonFull(ccfc42si.getSzNmStage());
      }

      CCMN03UO ccmn03uo = closeOpenStage.closeOpenStage(ccmn03ui);

      // cses63dQUERYdam
      AdminReview cses63dAdminReview = adminReviewDAO.findAdminReviewByIdStage(ccmn03uo.getUlIdStage());
      String ccfc42siCdStageProgram = ccfc42si.getSzCdStageProgram();

      if (idPersonArrayCcfc42SiIdPersonRequester > 0) {

        // cmsc43dAUDdam
        int cmsc43dRowsUpdated = adminAllegationDAO.insertAdminAllegation(ccmn03uo.getUlIdStage(),
                                                                          ArchitectureConstants.Y, ccfc42siIdStage,
                                                                          idPersonArrayCcfc42SiIdPersonRequester);

        if (cmsc43dRowsUpdated == 0) {
          throw new ServiceException(Messages.SQL_NOT_FOUND);
        }

        if (CAPS_PROG_APS.equals(ccfc42siCdStageProgram) || CAPS_PROG_AFC.equals(ccfc42siCdStageProgram)) {

          // cauda5dAUDdam
          int cauda5dRowsUpdated = stageDAO.updateStageSetCdStageReasonClosed(ccfc42siIdStage);

          if (cauda5dRowsUpdated == 0) {
            throw new ServiceException(Messages.SQL_NOT_FOUND);
          }
        }

      }

      // ccmn19dQUERYdam
      Map ccmn19dPersonMap = personDAO.findNmPersonAndNmStageByIdStage(ccfc42siIdStage, CodesTables.CSTFROLS_PR);
      int ccmn19dIdPerson = (Integer) ccmn19dPersonMap.get("idPerson");

      if (ccmn19dIdPerson == 0) {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }

      // ccmn60dQUERYdam
      Map ccmn60dUnitEmpLinkMap = unitEmpLinkDAO
              .findNmPersonFullAndIdPersonByIdPersonAndCdUnitMemberIn(ccmn19dIdPerson);

      if (ccmn60dUnitEmpLinkMap == null || ccmn60dUnitEmpLinkMap.isEmpty()) {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }

      int ccmn60dIdPerson = (Integer) ccmn60dUnitEmpLinkMap.get("idPerson");
      CSUB40UI csub40ui = new CSUB40UI();
      ArchInputStruct csub40uiArchInputStruct = ccfc42si.getArchInputStruct();
      csub40ui.setArchInputStruct(csub40uiArchInputStruct);
      CSUB40UIG00 csub40Uig00 = new CSUB40UIG00();

      if (ccfc42siCdStageProgram.equals(CAPS_PROG_AFC)) {
        csub40Uig00.setSzSysCdTodoCf(CCFC028);
      } else {
        csub40Uig00.setSzSysCdTodoCf(CCFC012);
      }

      int cses63dIdStage = cses63dAdminReview.getIdStage();
      Event cses63dEvent = cses63dAdminReview.getEvent();
      int cses63dIdEvent = cses63dEvent.getIdEvent();
      csub40Uig00.setDtSysDtTodoCfDueFrom(DateHelper.getTodayCastorDate());
      csub40Uig00.setUlSysIdTodoCfPersAssgn(ccmn19dIdPerson);
      csub40Uig00.setUlSysIdTodoCfEvent(cses63dIdEvent);
      csub40Uig00.setUlSysIdTodoCfStage(cses63dIdStage);
      csub40Uig00.setUlSysIdTodoCfPersWkr(idPersonArrayCcfc42SiIdPersonUser);
      csub40Uig00.setUlSysIdTodoCfPersCrea(idPersonArrayCcfc42SiIdPersonUser);
      if (CAPS_PROG_AFC.equals(ccfc42siCdStageProgram)) {
        csub40Uig00.setSzSysTxtTodoCfDesc(TODO_TEXT_CFC028_START);
      } else {
        csub40Uig00.setSzSysTxtTodoCfDesc(TODO_TEXT_CFC012_START);
      }

      String csub40uiSysTxtTodoCfDesc = csub40Uig00.getSzSysTxtTodoCfDesc();
      csub40uiSysTxtTodoCfDesc = csub40uiSysTxtTodoCfDesc + ccfc42si.getSzNmCase();
      csub40Uig00.setSzSysTxtTodoCfDesc(csub40uiSysTxtTodoCfDesc);

      if (CAPS_PROG_AFC.equals(ccfc42siCdStageProgram)) {
        csub40uiSysTxtTodoCfDesc = csub40Uig00.getSzSysTxtTodoCfDesc();
        csub40uiSysTxtTodoCfDesc = csub40uiSysTxtTodoCfDesc + TODO_TXT_CFC028_END;
        csub40Uig00.setSzSysTxtTodoCfDesc(csub40uiSysTxtTodoCfDesc);
      } else {
        csub40uiSysTxtTodoCfDesc = csub40Uig00.getSzSysTxtTodoCfDesc();
        csub40uiSysTxtTodoCfDesc = csub40uiSysTxtTodoCfDesc + TODO_TXT_CFC012_END;
        csub40Uig00.setSzSysTxtTodoCfDesc(csub40uiSysTxtTodoCfDesc);
      }

      if (idPersonArrayCcfc42SiIdPersonRequester > 0) {
        csub40uiSysTxtTodoCfDesc = csub40Uig00.getSzSysTxtTodoCfDesc();
        csub40uiSysTxtTodoCfDesc = csub40uiSysTxtTodoCfDesc + ccfc42si.getSzNmPersonFull();
        csub40Uig00.setSzSysTxtTodoCfDesc(csub40uiSysTxtTodoCfDesc);
      } else {
        csub40uiSysTxtTodoCfDesc = csub40Uig00.getSzSysTxtTodoCfDesc();
        csub40uiSysTxtTodoCfDesc = csub40uiSysTxtTodoCfDesc + ccfc42si.getSzNmStage();
        csub40Uig00.setSzSysTxtTodoCfDesc(csub40uiSysTxtTodoCfDesc);
      }

      csub40ui.setCSUB40UIG00(csub40Uig00);
      todoCommonFunction.audTodo(csub40ui);

      // CPS
      if (CAPS_PROG_AFC.equals(ccfc42siCdStageProgram)) {
        csub40Uig00.setSzSysCdTodoCf(CCFC028);
      } else {
        csub40Uig00.setSzSysCdTodoCf(CCFC012);
      }

      csub40Uig00.setDtSysDtTodoCfDueFrom(DateHelper.getTodayCastorDate());
      csub40Uig00.setUlSysIdTodoCfPersAssgn(ccmn60dIdPerson);
      csub40Uig00.setUlSysIdTodoCfEvent(cses63dIdEvent);
      csub40Uig00.setUlSysIdTodoCfStage(cses63dIdStage);
      csub40Uig00.setUlSysIdTodoCfPersWkr(idPersonArrayCcfc42SiIdPersonUser);

      if (CAPS_PROG_AFC.equals(ccfc42siCdStageProgram)) {
        csub40Uig00.setSzSysTxtTodoCfDesc(TODO_TEXT_CFC028_START);
      } else {
        csub40Uig00.setSzSysTxtTodoCfDesc(TODO_TEXT_CFC012_START);
      }

      csub40uiSysTxtTodoCfDesc = csub40Uig00.getSzSysTxtTodoCfDesc();
      csub40uiSysTxtTodoCfDesc = csub40uiSysTxtTodoCfDesc + ccfc42si.getSzNmCase();
      csub40Uig00.setSzSysTxtTodoCfDesc(csub40uiSysTxtTodoCfDesc);

      // Using on the ID EVENT from the overall disposition
      // determine the status of the event. If the status
      // is pending (PEND), return the ID EVENT to the client
      // Else, return null
      if (CAPS_PROG_AFC.equals(ccfc42siCdStageProgram)) {
        csub40uiSysTxtTodoCfDesc = csub40Uig00.getSzSysTxtTodoCfDesc();
        csub40uiSysTxtTodoCfDesc = csub40uiSysTxtTodoCfDesc + TODO_TXT_CFC028_END;
        csub40Uig00.setSzSysTxtTodoCfDesc(csub40uiSysTxtTodoCfDesc);
      } else {
        csub40uiSysTxtTodoCfDesc = csub40Uig00.getSzSysTxtTodoCfDesc();
        csub40uiSysTxtTodoCfDesc = csub40uiSysTxtTodoCfDesc + TODO_TXT_CFC012_END;
        csub40Uig00.setSzSysTxtTodoCfDesc(csub40uiSysTxtTodoCfDesc);
      }

      if (idPersonArrayCcfc42SiIdPersonRequester > 0) {
        csub40uiSysTxtTodoCfDesc = csub40Uig00.getSzSysTxtTodoCfDesc();
        csub40uiSysTxtTodoCfDesc = csub40uiSysTxtTodoCfDesc + ccfc42si.getSzNmPersonFull();
        csub40Uig00.setSzSysTxtTodoCfDesc(csub40uiSysTxtTodoCfDesc);
      } else {
        csub40uiSysTxtTodoCfDesc = csub40Uig00.getSzSysTxtTodoCfDesc();
        csub40uiSysTxtTodoCfDesc = csub40uiSysTxtTodoCfDesc + ccfc42si.getSzNmStage();
        csub40Uig00.setSzSysTxtTodoCfDesc(csub40uiSysTxtTodoCfDesc);
      }

      csub40ui.setCSUB40UIG00(csub40Uig00);
      todoCommonFunction.audTodo(csub40ui);
    }

    return ccfc42so;
  }
}
