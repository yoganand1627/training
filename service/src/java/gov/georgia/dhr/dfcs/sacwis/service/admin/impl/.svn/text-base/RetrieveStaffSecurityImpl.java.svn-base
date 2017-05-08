package gov.georgia.dhr.dfcs.sacwis.service.admin.impl;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.EmpSecClassLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EmpTempAssignDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EmployeeDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SecurityClassDAO;
import gov.georgia.dhr.dfcs.sacwis.db.EmpSecClassLink;
import gov.georgia.dhr.dfcs.sacwis.db.EmpTempAssign;
import gov.georgia.dhr.dfcs.sacwis.db.Employee;
import gov.georgia.dhr.dfcs.sacwis.db.SecurityClass;
import gov.georgia.dhr.dfcs.sacwis.service.admin.RetrieveStaffSecurity;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CARC14SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CARC14SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC14SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC14SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC14SOG01;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC14SOG01_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC14SOG02;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC14SOG02_ARRAY;

public class RetrieveStaffSecurityImpl extends BaseServiceImpl implements RetrieveStaffSecurity {

  private EmpSecClassLinkDAO empSecClassLinkDAO = null;
  private EmployeeDAO employeeDAO = null;
  private SecurityClassDAO securityClassDAO = null;
  private EmpTempAssignDAO empTempAssignDAO = null;

  public void setEmpSecClassLinkDAO(EmpSecClassLinkDAO empSecClassLinkDAO) {
    this.empSecClassLinkDAO = empSecClassLinkDAO;
  }

  public void setEmployeeDAO(EmployeeDAO employeeDAO) {
    this.employeeDAO = employeeDAO;
  }

  public void setSecurityClassDAO(SecurityClassDAO securityClassDAO) {
    this.securityClassDAO = securityClassDAO;
  }

  public void setEmpTempAssignDAO(EmpTempAssignDAO empTempAssignDAO) {
    this.empTempAssignDAO = empTempAssignDAO;
  }

  public CARC14SO findEmployeeSecurityInformation(CARC14SI carc14si) throws ServiceException {
    CARC14SO carc14so = new CARC14SO();
    carc14so.setDtWCDDtSystemDate(DateHelper.toCastorDate(new Date()));
    // Calling clscb3d
    List<EmpSecClassLink> listEmpSecClassLink =
            empSecClassLinkDAO.findEmpSecClassLinkSecurityClassbyIdPerson(carc14si.getUlIdPerson());
    //if (listEmpSecClassLink == null || listEmpSecClassLink.isEmpty()) {
    //  throw new ServiceException(Messages.SQL_NOT_FOUND);
    //}
    if (listEmpSecClassLink != null || !listEmpSecClassLink.isEmpty()) {
    ROWCARC14SOG02_ARRAY rowcarc14sogo2_array = new ROWCARC14SOG02_ARRAY();
    for (Iterator<EmpSecClassLink> it = listEmpSecClassLink.iterator(); it.hasNext();) {
      EmpSecClassLink empSecClassLink = it.next();
      ROWCARC14SOG02 rowcarc14sogo2 = new ROWCARC14SOG02();
      rowcarc14sogo2.setSzNmSecurityClass(empSecClassLink.getSecurityClass().getCdSecurityClassName());
      rowcarc14sogo2.setUlIdPerson(
              empSecClassLink.getPerson().getIdPerson() != null ? empSecClassLink.getPerson().getIdPerson() : 0);
      rowcarc14sogo2.setUlIdEmpSecLink(
              empSecClassLink.getIdEmpSecLink() != null ? empSecClassLink.getIdEmpSecLink() : 0);
      rowcarc14sogo2.setTsLastUpdate(empSecClassLink.getDtLastUpdate());
      rowcarc14sogo2_array.addROWCARC14SOG02(rowcarc14sogo2);
    }
    carc14so.setROWCARC14SOG02_ARRAY(rowcarc14sogo2_array);
    }
    // Caliing cses00d
    Employee employee = employeeDAO.findEmployeeByIdPerson(carc14si.getUlIdPerson());
    // There is no error if nothing is returned, but the rest of the DAM does not execute.
    if (employee == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    carc14so.setSzIdEmployeeLogon(employee.getIdEmployeeLogon());
    carc14so.setTsLastUpdate(employee.getDtLastUpdate());
    //Calling clss12d
    List<SecurityClass> listSecurityClass = securityClassDAO.findListAllSecurityClasses();
    if (listSecurityClass == null || listSecurityClass.isEmpty()) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    ROWCARC14SOG01_ARRAY rowcarc14sogo1_array = new ROWCARC14SOG01_ARRAY();
    for (Iterator<SecurityClass> it = listSecurityClass.iterator(); it.hasNext();) {
      SecurityClass securityClass = it.next();
      ROWCARC14SOG01 rowcarc14sogo1 = new ROWCARC14SOG01();
      rowcarc14sogo1.setSzNmSecurityClass(securityClass.getCdSecurityClassName());
      rowcarc14sogo1.setCIndRestrict(securityClass.getIndRestrict());
      rowcarc14sogo1_array.addROWCARC14SOG01(rowcarc14sogo1);
    }
    carc14so.setROWCARC14SOG01_ARRAY(rowcarc14sogo1_array);
    //Calling clss15d
    List<EmpTempAssign> listEmpTempAssign =
            empTempAssignDAO.findEmpTempAssignmentDesignatorsByIdPerson(carc14si.getUlIdPerson());
    //  if (listEmpTempAssign == null || listEmpTempAssign.isEmpty()) {
    //    throw new ServiceException(Messages.SQL_NOT_FOUND);
    //  }
    if (listEmpTempAssign != null || !(listEmpTempAssign.isEmpty())) {
      ROWCARC14SOG00_ARRAY rowcarc14sog00_array = new ROWCARC14SOG00_ARRAY();
      for (Iterator<EmpTempAssign> it = listEmpTempAssign.iterator(); it.hasNext();) {
        EmpTempAssign empTempAssign = it.next();
        ROWCARC14SOG00 rowcarc14sog00 = new ROWCARC14SOG00();
        rowcarc14sog00.setSzNmPersonFull(empTempAssign.getPersonByIdPersonEmp().getNmPersonFull());
        rowcarc14sog00.setTsLastUpdate(empTempAssign.getDtLastUpdate());
        rowcarc14sog00.setDtDtAssignExpiration(DateHelper.toCastorDate(empTempAssign.getDtAssignExpiration()));
        rowcarc14sog00.setUlIdPerson(empTempAssign.getPersonByIdPersonEmp().getIdPerson() != null ?
                                     empTempAssign.getPersonByIdPersonEmp().getIdPerson() : 0);
        rowcarc14sog00.setUlIdEmpTempAssign(
                empTempAssign.getIdEmpTempAssign() != null ? empTempAssign.getIdEmpTempAssign() : 0);
        rowcarc14sog00.setUlIdPersonDesignee(empTempAssign.getPersonByIdPersonDesignee().getIdPerson() != null ?
                                             empTempAssign.getPersonByIdPersonDesignee().getIdPerson() : 0);
        rowcarc14sog00_array.addROWCARC14SOG00(rowcarc14sog00);

      }
      carc14so.setROWCARC14SOG00_ARRAY(rowcarc14sog00_array);
    }
    return carc14so;
  }
}
