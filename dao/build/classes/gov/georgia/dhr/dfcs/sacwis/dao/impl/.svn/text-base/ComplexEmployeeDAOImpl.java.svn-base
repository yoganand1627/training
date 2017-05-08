package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexEmployeeDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EmployeeDAO;

import java.util.Date;

public class ComplexEmployeeDAOImpl extends BaseDAOImpl implements ComplexEmployeeDAO {
  private EmployeeDAO employeeDAO = null;
  
  public void setEmployeeDAO(EmployeeDAO employeeDAO) {
    this.employeeDAO = employeeDAO;
  }

  public int updateEmployee(int idPerson, int nbrEmpActivePct, Date dtEmpHire, int idEmpJobHistory,
                            String idEmployeeLogon, String cdEmployeeClass, int idOffice, Date dtEmpLastAssigned,
                            String cdEmpProgram, String indEmpConfirmedHrmis, String indEmpPendingHrmis,
                            String indActiveStatus, Date dtEmpTermination, Date dtLastUpdate, int idEmployeeModifiedBy) {
    
    String indEmpJobAssignCurr = null; 
    
    if (!DateHelper.isNull(dtEmpTermination)) {
      // indicate that the employee is not able to be assigned Stages. Therefore, the employee will
      // not appear in the availabe staff list on the Assign Page
      indEmpJobAssignCurr = ArchitectureConstants.N;
      return employeeDAO.updateTerminatedEmployee(idPerson, nbrEmpActivePct, dtEmpHire, idEmpJobHistory,
                                                  idEmployeeLogon, cdEmployeeClass, idOffice, dtEmpLastAssigned,
                                                  cdEmpProgram, indEmpConfirmedHrmis, indEmpPendingHrmis,
                                                  indActiveStatus, dtEmpTermination, dtLastUpdate, 
                                                  idEmployeeModifiedBy, indEmpJobAssignCurr);
    }else {
      return employeeDAO.updateEmployee(idPerson, nbrEmpActivePct, dtEmpHire, idEmpJobHistory,
                      idEmployeeLogon, cdEmployeeClass, idOffice, dtEmpLastAssigned,
                      cdEmpProgram, indEmpConfirmedHrmis, indEmpPendingHrmis,
                      indActiveStatus, dtEmpTermination, dtLastUpdate, idEmployeeModifiedBy);
    }
  }

}
