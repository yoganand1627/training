package gov.georgia.dhr.dfcs.sacwis.service.admin.impl;

import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.CaseFileManagementDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.OfficeDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.UnitDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CaseFileManagement;
import gov.georgia.dhr.dfcs.sacwis.db.Office;
import gov.georgia.dhr.dfcs.sacwis.db.Unit;
import gov.georgia.dhr.dfcs.sacwis.service.admin.SaveCaseFileManagement;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC22SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC22SO;

public class SaveCaseFileManagementImpl extends BaseServiceImpl implements SaveCaseFileManagement {

  private OfficeDAO officeDAO = null;
  private UnitDAO unitDAO = null;
  private CaseFileManagementDAO caseFileManagementDAO = null;

  public void setOfficeDAO(OfficeDAO officeDAO) {
    this.officeDAO = officeDAO;
  }

  public void setUnitDAO(UnitDAO unitDAO) {
    this.unitDAO = unitDAO;
  }

  public void setCaseFileManagementDAO(CaseFileManagementDAO caseFileManagementDAO) {
    this.caseFileManagementDAO = caseFileManagementDAO;
  }

  public CCFC22SO saveCaseFileManagement(CCFC22SI ccfc22si) throws ServiceException {
    CCFC22SO ccfc22so = new CCFC22SO();

    CaseFileManagement caseFileMgmt = new CaseFileManagement();
    String cdUnitProgram = ccfc22si.getSzCdCaseProgram();
    String cdUnitRegion = ccfc22si.getSzCdOfficeRegion();
    
    if (CodesTables.COFFTYPE_P.equals(ccfc22si.getSzCdCaseFileOfficeType())) {// DFCS Case when region is required
      // rc = ccmnc0dQUERYdam(sqlca, pCCMNC0DInputRec, pCCMNC0DOutputRec);
      String cdNbrUnit = ccfc22si.getSzNbrUnit();
      //TODO: Is this the correct value for County?
      String cdUnitCounty = ccfc22si.getSzCdCounty();

      Unit unit = unitDAO.findUnitFullRowByCdUnitProgramCdUnitRegionNbrUnit(cdUnitProgram, cdUnitRegion, cdUnitCounty, cdNbrUnit);
      if (unit == null) {
        throw new ServiceException(Messages.MSG_CMN_INVALID_UNIT);
      }
      caseFileMgmt.setUnit(unit);

      String cdCounty = ccfc22si.getSzCdCounty();
      String cdOfficeMail = officeDAO.findCdMailCodeByCdCounty(cdCounty);
      
      //rc = ccmna5dQUERYdam(sqlca, pCCMNA5DInputRec, pCCMNA5DOutputRec);
      Map mapoff = officeDAO.findOfficeByCdOfficeRegionCdOfficeMail(cdUnitRegion, cdOfficeMail);
      if (mapoff == null) {
        throw new ServiceException(Messages.MSG_CMN_INVALID_OFFICE);
      }
      Office office = (Office) getPersistentObject(Office.class, (Integer) mapoff.get("idOffice"));
      caseFileMgmt.setOffice(office);
    }else{   //Non-DFCS case when no region is entered on the Page 
      String cdCounty = ccfc22si.getSzCdCounty();
      String cdOfficeMail = officeDAO.findCdMailCodeByCdCounty(cdCounty);
      
      //rc = ccmna5dQUERYdam(sqlca, pCCMNA5DInputRec, pCCMNA5DOutputRec);
      Map mapoff = officeDAO.findOfficeByCdOfficeMail(cdOfficeMail);
      if (mapoff != null) {
        Office office = (Office) getPersistentObject(Office.class, (Integer) mapoff.get("idOffice"));
        caseFileMgmt.setOffice(office);
      }
    }

    //rc = caud76dAUDdam(sqlca, pCAUD76DInputRec, pCAUD76DOutputRec);
    caseFileMgmt.setIdCaseFileCase(ccfc22si.getUlIdCase());
    caseFileMgmt.setDtLastUpdate(ccfc22si.getTsLastUpdate());
    String cReqFuncCd = ccfc22si.getArchInputStruct().getCReqFuncCd();
    if (ServiceConstants.REQ_FUNC_CD_ADD.equals(cReqFuncCd) ||
        ServiceConstants.REQ_FUNC_CD_UPDATE.equals(cReqFuncCd)) {
      caseFileMgmt.setAddrCaseFileCity(ccfc22si.getSzAddrCaseFileCity());
      caseFileMgmt.setAddrCaseFileStLn1(ccfc22si.getSzAddrCaseFileStLn1());
      caseFileMgmt.setAddrCaseFileStLn2(ccfc22si.getSzAddrCaseFileStLn2());
      caseFileMgmt.setCdCaseFileOfficeType(ccfc22si.getSzCdCaseFileOfficeType());
      caseFileMgmt.setDtCaseFileArchCompl(DateHelper.toJavaDate(ccfc22si.getDtDtCaseFileArchCompl()));
      caseFileMgmt.setDtCaseFileArchElig(DateHelper.toJavaDate(ccfc22si.getDtDtCaseFileArchElig()));
      caseFileMgmt.setNmCaseFileOffice(ccfc22si.getSzNmCaseFileOffice());
      caseFileMgmt.setTxtCaseFileLocateInfo(ccfc22si.getSztxtCaseFileLocateInfo());
      caseFileMgmt.setTxtPriorCmnts(ccfc22si.getSzTxtPriorCmnts());
      caseFileManagementDAO.saveCaseFileManagement(caseFileMgmt);
    } else if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(cReqFuncCd)) {
      caseFileManagementDAO.deleteCaseFileManagement(caseFileMgmt);
    } // caud76d ignores bad function codes.
    return ccfc22so;
  }
}


