package gov.georgia.dhr.dfcs.sacwis.service.security.impl;

import java.util.Date;
import java.util.Enumeration;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.dao.EmpSecClassLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SecurityClassDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Employee;
import gov.georgia.dhr.dfcs.sacwis.db.SecurityClass;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.security.SaveSecurityClass;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CARC13SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCARC13SIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CARC13SO;

public class SaveSecurityClassImpl extends BaseServiceImpl implements SaveSecurityClass {

  private SecurityClassDAO securityClassDAO = null;
  private EmpSecClassLinkDAO empSecClassLinkDAO = null;

  public void setSecurityClassDAO(SecurityClassDAO securityClassDAO) {
    this.securityClassDAO = securityClassDAO;
  }
  
  public void setEmpSecClassLinkDAO(EmpSecClassLinkDAO empSecClassLinkDAO) {
    this.empSecClassLinkDAO = empSecClassLinkDAO;
  }

  public CARC13SO saveSecurityClass(CARC13SI carc13si) throws ServiceException {
    CARC13SO carc13so = new CARC13SO();

    for (Enumeration rowcarc13sigooEnum = carc13si.getROWCARC13SIG00_ARRAY().enumerateROWCARC13SIG00();
         rowcarc13sigooEnum
                 .hasMoreElements();) {
      ROWCARC13SIG00 rowcarc13sig00 = (ROWCARC13SIG00) rowcarc13sigooEnum.nextElement();
      String szTxtSecurityClassProfil = rowcarc13sig00.getSzTxtSecurityClassProfil();
      String szNmSecurityClass = rowcarc13sig00.getSzNmSecurityClass();
      String szCdEmpSecurityClassNm = rowcarc13sig00.getSzCdEmpSecurityClassNm();
      String cIndRestrict = rowcarc13sig00.getCIndRestrict();
      Date dtLastUpdate = rowcarc13sig00.getTsLastUpdate();
      String cReqFuncCd = rowcarc13sig00.getSzCdSysDataActionOutcome();
      Integer idEmployeeModifiedBy = rowcarc13sig00.getUlIdEmployee();

      if (ServiceConstants.REQ_FUNC_CD_ADD.equals(cReqFuncCd)) {
        
        SecurityClass securityClass = new SecurityClass();        
        securityClass = securityClassDAO.findSecurity(szNmSecurityClass);
        
        if (securityClass != null) {
          throw new ServiceException(Messages.MSG_ARC_SECURITY_CLASS_EXISTS);
        } else {
          SecurityClass securityClassAdd = new SecurityClass(); 
          securityClassAdd.setTxtSecurityClassProfil(szTxtSecurityClassProfil);
          securityClassAdd.setDtLastUpdate(dtLastUpdate);
          securityClassAdd.setIndRestrict(cIndRestrict);
          securityClassAdd.setCdSecurityClassName(szNmSecurityClass);
          securityClassAdd.setEmployee((Employee) getPersistentObject(Employee.class, idEmployeeModifiedBy));
          // caud19d
          securityClassDAO.saveSecurityClass(securityClassAdd);
        }

      } else if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(cReqFuncCd)) {
        // caud19d
        if (0 == securityClassDAO.updateSecurityClass(szTxtSecurityClassProfil, szNmSecurityClass, cIndRestrict,
                                                      szCdEmpSecurityClassNm, dtLastUpdate)) {
          throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
        }
      } else if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(cReqFuncCd)) {
        // caud19d
        //-- retrieve results from EMP_SEC_CLASS_LINK where name=szCdEmpSecurityClassNm
        //-- if no results (0 or null), then continue to delete
        //-- if results, throw new ServiceException(Messages.MSG_ARC_CLASS_IN_USE);
        Long results = empSecClassLinkDAO.findEmpSecClassLink(szCdEmpSecurityClassNm);
        if (results != null && results.intValue() != 0){
          throw new ServiceException(Messages.MSG_ARC_CLASS_IN_USE);
          
        }
        if (0 == securityClassDAO.deleteSecurityClass(szCdEmpSecurityClassNm, dtLastUpdate)) {
          throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
        }
      } else {
        throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
      }
    }
    return carc13so;
  }
}
