package gov.georgia.dhr.dfcs.sacwis.service.admin.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsCaseDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CaseFileManagementDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.OfficeDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.UnitDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CapsCase;
import gov.georgia.dhr.dfcs.sacwis.db.CaseFileManagement;
import gov.georgia.dhr.dfcs.sacwis.db.Office;
import gov.georgia.dhr.dfcs.sacwis.db.Unit;
import gov.georgia.dhr.dfcs.sacwis.service.admin.RetrieveCaseFileManagement;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC21SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC21SO;

public class RetrieveCaseFileManagementImpl extends BaseServiceImpl implements RetrieveCaseFileManagement {

  private CapsCaseDAO capsCaseDAO = null;
  private OfficeDAO officeDAO = null;
  private StageDAO stageDAO = null;
  private UnitDAO unitDAO = null;
  private CaseFileManagementDAO caseFileManagementDAO = null;

  public void setCapsCaseDAO(CapsCaseDAO capsCaseDAO) {
    this.capsCaseDAO = capsCaseDAO;
  }

  public void setOfficeDAO(OfficeDAO officeDAO) {
    this.officeDAO = officeDAO;
  }

  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }

  public void setUnitDAO(UnitDAO unitDAO) {
    this.unitDAO = unitDAO;
  }

  public void setCaseFileManagementDAO(CaseFileManagementDAO caseFileManagementDAO) {
    this.caseFileManagementDAO = caseFileManagementDAO;
  }

  public CCFC21SO retrieveCaseFileManagement(CCFC21SI ccfc21si) throws ServiceException {
    CCFC21SO ccfc21so = new CCFC21SO();

    int idPerson = ccfc21si.getUlIdPerson();
    int idCase = ccfc21si.getUlIdCase();
    // This can't return null (because counts cannot fail in that way),
    //   so no need to check null and throw SQL_NOT_FOUND.
    // rc = cmsc36dQUERYdam(sqlca, pCMSC36DInputRec, pCMSC36DOutputRec);
    long count = stageDAO.countStageByIdPersonIdCase(idPerson, idCase);

    if (count > 0) {
      ccfc21so.setCSysIndPrimaryWorker(ArchitectureConstants.Y);
    } else {
      ccfc21so.setCSysIndPrimaryWorker(ArchitectureConstants.N);
    }

    // rc = ccmnc5dQUERYdam(sqlca, pCCMNC5DInputRec, pCCMNC5DOutputRec);
    CapsCase capsCase = capsCaseDAO.findCapsCaseByIdCase(idCase);

    if (capsCase == null) {
      throw new ServiceException(Messages.MSG_DATABASE_RETRIEVE_FAIL);
    }
    ccfc21so.setSzCdCaseProgram(capsCase.getCdCaseProgram());
    ccfc21so.setDtDtCaseClosed(DateHelper.toCastorDate(capsCase.getDtCaseClosed()));

    // rc = cses57dQUERYdam(sqlca, pCSES57DInputRec, pCSES57DOutputRec);
    CaseFileManagement cfm = caseFileManagementDAO.findCaseFileManagement(idCase);

    if (cfm != null) {
      ccfc21so.setSzAddrCaseFileCity(cfm.getAddrCaseFileCity());
      ccfc21so.setSzAddrCaseFileStLn1(cfm.getAddrCaseFileStLn1());
      ccfc21so.setSzAddrCaseFileStLn2(cfm.getAddrCaseFileStLn2());
      ccfc21so.setSzCdCaseFileOfficeType(cfm.getCdCaseFileOfficeType());
      ccfc21so.setDtDtCaseFileArchCompl(DateHelper.toCastorDate(cfm.getDtCaseFileArchCompl()));
      ccfc21so.setDtDtCaseFileArchElig(DateHelper.toCastorDate(cfm.getDtCaseFileArchElig()));
      ccfc21so.setSzNmCaseFileOffice(cfm.getNmCaseFileOffice());
      ccfc21so.setSztxtCaseFileLocateInfo(cfm.getTxtCaseFileLocateInfo());
      ccfc21so.setSzTxtPriorCmnts(cfm.getTxtPriorCmnts());
      ccfc21so.setTsLastUpdate(cfm.getDtLastUpdate());
      // rc = ccmn00dQUERYdam(sqlca, pCCMN00DInputRec, pCCMN00DOutputRec);
      if(cfm.getOffice() != null){
        Office office = officeDAO.findOfficeByIdOffice(cfm.getOffice().getIdOffice());
        if (office == null) {
          throw new ServiceException(Messages.MSG_DATABASE_RETRIEVE_FAIL);
        }
        if (CodesTables.COFFTYPE_P.equals(ccfc21so.getSzCdCaseFileOfficeType())) {//DFCS Case
          ccfc21so.setSzCdOfficeRegion(office.getCdOfficeRegion());
          ccfc21so.setSzAddrMailCode(office.getMailCode().getCdMailCode());
          
          String cdCounty = officeDAO.findCdCountyByCdMailCode(office.getMailCode().getCdMailCode());
          ccfc21so.setSzCdCounty(cdCounty);
        }else{//Non-DFCS Case
          ccfc21so.setSzAddrMailCode(office.getMailCode().getCdMailCode());
          String cdCounty = officeDAO.findCdCountyByCdMailCode(office.getMailCode().getCdMailCode());
          ccfc21so.setSzCdCounty(cdCounty);
        }
      }
      
      if(cfm.getUnit() != null){
        if (CodesTables.COFFTYPE_P.equals(ccfc21so.getSzCdCaseFileOfficeType())) {
          // rc = ccmna1dQUERYdam(sqlca, pCCMNA1DInputRec, pCCMNA1DOutputRec);
          Unit unit = unitDAO.findUnitByIdUnit(cfm.getUnit().getIdUnit());
          if (unit == null) {
            throw new ServiceException(Messages.MSG_DATABASE_RETRIEVE_FAIL);
          }
          ccfc21so.setSzNbrUnit(unit.getNbrUnit());
        }
      }
    } else {
      ccfc21so.setDtDtCaseFileArchElig(null);
      ccfc21so.setDtDtCaseFileArchCompl(null);
    }
    return ccfc21so;
  }
}

