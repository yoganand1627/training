/**
 * Created on Apr 27, 2007 at 4:16:53 PM by Kapil Aggarwal
 */
package gov.georgia.dhr.dfcs.sacwis.service.ws.impl;

import java.util.Date;

import gov.georgia.dhr.dfcs.sacwis.dao.CrsAuditDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CrsAudit;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.ws.SaveCrsAuditRow;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CrsAuditSI;

/**
 *
 */
public class SaveCrsAuditRowImpl extends BaseServiceImpl implements SaveCrsAuditRow {

  private CrsAuditDAO crsAuditDAO;

  /**
   * Set the DAO object that has access to the CrsAudit Table
   * @param crsAuditDAO to access CrsAudit Table
   */
  public void setCrsAuditDAO(CrsAuditDAO crsAuditDAO) {
    this.crsAuditDAO = crsAuditDAO;
  }
  
  
  /* (non-Javadoc)
   * @see gov.georgia.dhr.dfcs.sacwis.service.ws.CrsAudit#saveCrsAudit(gov.georgia.dhr.dfcs.sacwis.structs.output.CrsRegistrationSO)
   */
  public void saveCrsAuditRow(CrsAuditSI crsAuditSI) {
    
    CrsAudit crsAudit = new CrsAudit();

    crsAudit.setIdCrsAudit(crsAuditSI.getIdCrsAudit());
    crsAudit.setDtLastUpdate(crsAuditSI.getDtLastUpdate());
    crsAudit.setInterfaceStatus(crsAuditSI.getInterfaceStatus());
    crsAudit.setDtProcess(crsAuditSI.getDtProcess());
    crsAudit.setCdError(crsAuditSI.getCdError());
    crsAudit.setIdInitiator(crsAuditSI.getIdInitiator());
    crsAudit.setShinesLogonShort(crsAuditSI.getShinesLogonShort());
    crsAudit.setDtCrsRequested(crsAuditSI.getDtCrsRequested());
    crsAudit.setCdCrsRequest(crsAuditSI.getCdCrsRequest());
    crsAudit.setIdPerson(crsAuditSI.getIdPerson());
    crsAudit.setNbrCrsId(crsAuditSI.getNbrCrsId());
    crsAudit.setNbrPersonIdNumber(crsAuditSI.getNbrPersonIdNumber());
    crsAudit.setNmPersonLast(crsAuditSI.getNmPersonLast());
    crsAudit.setNmPersonFirst(crsAuditSI.getNmPersonFirst());
    crsAudit.setCdPersonSex(crsAuditSI.getCdPersonSex() != null? crsAuditSI.getCdPersonSex(): "");

    crsAuditDAO.saveCrsAudit(crsAudit);
    
  }

}
