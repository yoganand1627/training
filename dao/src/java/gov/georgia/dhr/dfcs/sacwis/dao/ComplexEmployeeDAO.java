package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Date;

public interface ComplexEmployeeDAO {
  
  /**
   * <p>Saves an Employee record. If the Employee termination date is not null, it will update the 
   * IND_EMP_JOB_ASSIGN_CURR collumn with 'N' to indicate that the employee can not be
   * assigned Stages. The employee will not appear in the list of the available staff
   * on the Assign Page</p>
   * 
   * @param idPerson
   * @param nbrEmpActivePct
   * @param dtEmpHire
   * @param idEmpJobHistory
   * @param idEmployeeLogon
   * @param cdEmployeeClass
   * @param idOffice
   * @param dtEmpLastAssigned
   * @param cdEmpProgram
   * @param indEmpConfirmedHrmis
   * @param indEmpPendingHrmis
   * @param indActiveStatus
   * @param dtEmpTermination
   * @param dtLastUpdate
   * @param idEmployeeModifiedBy
   * 
   * @return int indicating how many records were modified
   */
  public int updateEmployee(int idPerson, int nbrEmpActivePct, Date dtEmpHire, int idEmpJobHistory,
                            String idEmployeeLogon, String cdEmployeeClass, int idOffice, Date dtEmpLastAssigned,
                            String cdEmpProgram, String indEmpConfirmedHrmis, String indEmpPendingHrmis,
                            String indActiveStatus, Date dtEmpTermination, Date dtLastUpdate,
                            int idEmployeeModifiedBy);
  
}
