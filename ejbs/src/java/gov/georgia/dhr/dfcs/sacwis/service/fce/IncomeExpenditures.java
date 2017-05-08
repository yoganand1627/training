package gov.georgia.dhr.dfcs.sacwis.service.fce;

import java.rmi.RemoteException;

import gov.georgia.dhr.dfcs.sacwis.core.exception.EjbValidationException;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.IncomeExpendituresDB;

public interface IncomeExpenditures {
  public IncomeExpendituresDB read(long idStage, long idEvent, long idEmployeePerson) throws EjbValidationException;

  public void save(IncomeExpendituresDB incomeExpendituresDB) throws EjbValidationException;
 
  /** @todo add javadocs */
  public int[] submitApplication(IncomeExpendituresDB incomeExpendituresDB, String securityAttribute)
          throws RemoteException, EjbValidationException;

  /** @todo add javadocs */
  public int[] calculate(IncomeExpendituresDB incomeExpendituresDB, String securityAttribute)
          throws RemoteException, EjbValidationException;
}
