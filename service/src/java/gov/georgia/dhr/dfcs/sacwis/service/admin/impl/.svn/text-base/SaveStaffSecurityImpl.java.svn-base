package gov.georgia.dhr.dfcs.sacwis.service.admin.impl;

import java.util.Enumeration;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.EmpSecClassLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EmpTempAssignDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EmployeeDAO;
import gov.georgia.dhr.dfcs.sacwis.db.EmpSecClassLink;
import gov.georgia.dhr.dfcs.sacwis.db.EmpTempAssign;
import gov.georgia.dhr.dfcs.sacwis.db.Employee;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.SecurityClass;
import gov.georgia.dhr.dfcs.sacwis.service.admin.SaveStaffSecurity;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CARC18SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCARC18SIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCARC18SIG01;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CARC18SO;

public class SaveStaffSecurityImpl extends BaseServiceImpl implements SaveStaffSecurity {

  private EmpSecClassLinkDAO empSecClassLinkDAO = null;

  private EmployeeDAO employeeDAO = null;

  private EmpTempAssignDAO empTempAssignDAO = null;

  public void setEmpSecClassLinkDAO(EmpSecClassLinkDAO empSecClassLinkDAO) {
    this.empSecClassLinkDAO = empSecClassLinkDAO;
  }

  public void setEmployeeDAO(EmployeeDAO employeeDAO) {
    this.employeeDAO = employeeDAO;
  }

  public void setEmpTempAssignDAO(EmpTempAssignDAO empTempAssignDAO) {
    this.empTempAssignDAO = empTempAssignDAO;
  }

  public CARC18SO saveStaffSecurityInformation(CARC18SI carc18si) throws ServiceException {
    CARC18SO carc18so = new CARC18SO();
    // Calling DAO caud23d
    String cReqFuncCd = carc18si.getArchInputStruct().getCReqFuncCd();
    if (!ServiceConstants.REQ_FUNC_CD_UPDATE.equals(cReqFuncCd)) {
      throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
    }
    try{
      int rowsUpdated = employeeDAO.updateEmployeeByIdPersonAndDtLastUpdate(carc18si.getSzIdEmployeeLogon(),
                                                                          carc18si.getTsLastUpdate(),
                                                                          carc18si.getUlIdPerson(),
                                                                          carc18si.getUlIdEmployee());

      if (rowsUpdated <= 0) {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }    
    }catch (Exception sqle){
      //There is a constraint violation if someone tries to save a staff
      //with the same login as someone else. 
      throw new ServiceException(Messages.MSG_DUPLICATE_RECORD);
    }

    for (Enumeration rowcarc18sig00Enum = carc18si.getROWCARC18SIG00_ARRAY_CARC18SI().enumerateROWCARC18SIG00();
         rowcarc18sig00Enum
                 .hasMoreElements();) {
      ROWCARC18SIG00 rowcarc18sig00 = (ROWCARC18SIG00) rowcarc18sig00Enum.nextElement();

      // Calling DAO caud22d
      String szCdSysDataActionOutcome = rowcarc18sig00.getSzCdSysDataActionOutcome();
      if (ServiceConstants.REQ_FUNC_CD_ADD.equals(szCdSysDataActionOutcome)
          || ServiceConstants.REQ_FUNC_CD_UPDATE.equals(szCdSysDataActionOutcome)) {
        // populationg the object to be passed in to EmpTempAssignDAO
        EmpTempAssign empTempAssign = new EmpTempAssign();
        empTempAssign.setIdEmpTempAssign(rowcarc18sig00.getUlIdEmpTempAssign());
        empTempAssign.setDtLastUpdate(rowcarc18sig00.getTsLastUpdate());
        empTempAssign.setDtAssignExpiration(DateHelper.toJavaDate(rowcarc18sig00.getDtDtAssignExpiration()));

        //the code below is still in progress
        Person personEmp = (Person) getPersistentObject(Person.class, rowcarc18sig00.getUlIdPerson());
        empTempAssign.setPersonByIdPersonEmp(personEmp);
        Person personDesignee = (Person) getPersistentObject(Person.class, rowcarc18sig00.getUlIdPersonDesignee());
        empTempAssign.setPersonByIdPersonDesignee(personDesignee);

        empTempAssignDAO.saveEmpTempAssign(empTempAssign);
      } else if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(szCdSysDataActionOutcome)) {
        if (0 == empTempAssignDAO.deleteEmpTempAssign(rowcarc18sig00.getUlIdEmpTempAssign(),
                                                      rowcarc18sig00.getTsLastUpdate())) {
          throw new ServiceException(Messages.SQL_NOT_FOUND);
        }
      } else {
        throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
      }
    }

    if (carc18si.getROWCARC18SIG01_ARRAY() != null) {
      for (Enumeration rowcarc18sig01Enum = carc18si.getROWCARC18SIG01_ARRAY().enumerateROWCARC18SIG01();
           rowcarc18sig01Enum
                   .hasMoreElements();) {
        ROWCARC18SIG01 rowcarc18sig01 = (ROWCARC18SIG01) rowcarc18sig01Enum.nextElement();
        String szCdSysDataActionOutcome = rowcarc18sig01.getSzCdSysDataActionOutcome();
        if (ServiceConstants.REQ_FUNC_CD_NO_ACTION.equals(szCdSysDataActionOutcome)) {
          // Skip to the next row if we get
          continue;
        }
        EmpSecClassLink empSecClassLink = new EmpSecClassLink();
        empSecClassLink.setIdEmpSecLink(rowcarc18sig01.getUlIdEmpSecLink());
        empSecClassLink.setDtLastUpdate(rowcarc18sig01.getTsLastUpdate());
        if (ServiceConstants.REQ_FUNC_CD_ADD.equals(szCdSysDataActionOutcome)
            || ServiceConstants.REQ_FUNC_CD_UPDATE.equals(szCdSysDataActionOutcome)) {
          empSecClassLink.setEmployee(getPersistentObject(Employee.class, carc18si.getUlIdEmployee()));
          //rowcarc18sig01.getUlIdPerson());
          empSecClassLink.setPerson(getPersistentObject(Person.class, carc18si.getUlIdPerson()));
          SecurityClass securityClass = getPersistentObject(SecurityClass.class, rowcarc18sig01.getSzNmSecurityClass());
          empSecClassLink.setSecurityClass(securityClass);
          // Calling DAO caude1d
          empSecClassLinkDAO.saveEmpSecClassLink(empSecClassLink);
        } else if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(szCdSysDataActionOutcome)) {

          if (0 == empSecClassLinkDAO.deleteEmpSecClassLink(rowcarc18sig01.getUlIdEmpSecLink(),
                                                            rowcarc18sig01.getTsLastUpdate())) {
            throw new ServiceException(Messages.SQL_NOT_FOUND);
          }

        } else {
          throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
        }
      }
    } // if null # 88
    // This is only necessary to preserve te pattern of services returning their output objects.
    return carc18so;//new CARC18SO();
  }
}

