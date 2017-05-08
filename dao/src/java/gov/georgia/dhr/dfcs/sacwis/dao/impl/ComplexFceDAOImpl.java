package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.CommonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexFceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.FceApplicationDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.FceEligibilityDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.FceExpendituresDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.FceIncomeDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.FcePersonDAO;
import gov.georgia.dhr.dfcs.sacwis.db.FceIncome;
import gov.georgia.dhr.dfcs.sacwis.db.FcePerson;

import java.util.List;

public class ComplexFceDAOImpl extends BaseDAOImpl implements ComplexFceDAO {
  final boolean INCOME = true;
  final boolean RESOURCE = !INCOME;
  final boolean CHILD = true;
  final boolean FAMILY = !CHILD;
  
  private FceApplicationDAO fceApplicationDAO = null;
  private FceEligibilityDAO fceEligibilityDAO = null;
  private FcePersonDAO fcePersonDAO = null;
  private FceIncomeDAO fceIncomeDAO = null;
  private FceExpendituresDAO fceExpendituresDAO = null;
  private CommonDAO commonDAO = null;
  
  public void setCommonDAO(CommonDAO commonDAO) {
    this.commonDAO = commonDAO;
  }

  public void setFceApplicationDAO(FceApplicationDAO fceApplicationDAO) {
    this.fceApplicationDAO = fceApplicationDAO;
  }

  public void setFceEligibilityDAO(FceEligibilityDAO fceEligibilityDAO) {
    this.fceEligibilityDAO = fceEligibilityDAO;
  }

  public void setFcePersonDAO(FcePersonDAO fcePersonDAO) {
    this.fcePersonDAO = fcePersonDAO;
  }

  public void setFceIncomeDAO(FceIncomeDAO fceIncomeDAO) {
    this.fceIncomeDAO = fceIncomeDAO;
  }

  public void setFceExpendituresDAO(FceExpendituresDAO fceExpendituresDAO) {
    this.fceExpendituresDAO = fceExpendituresDAO;
  }

  public void updateFceIncome(int idPersMergeForward, int idPersMergeClosed, int idStage) {
    fceApplicationDAO.updateFceApplicationIdPerson(idPersMergeForward, idPersMergeClosed, idStage);
    fceEligibilityDAO.updateFceEligibilityIdPerson(idPersMergeForward, idPersMergeClosed, idStage);
    // Find the FCE_PERSON of the person merged forward so that we can update the FCE_INCOME  
    // of the person merged closed with the ID_FCE_PERSON of the person merged forward
    FcePerson fcePerson = fcePersonDAO.findFcePersonByIdPerson(idPersMergeForward);
    if (fcePerson != null){
      fceIncomeDAO.updateFceIncomeIdPerson(idPersMergeForward, idPersMergeClosed, idStage, fcePerson.getIdFcePerson());
    }
    fceExpendituresDAO.updateFceExpendituresIdPerson(idPersMergeForward, idPersMergeClosed, idStage);
  }
  
  public int saveFcePersonByIdPersonIdFceEligAndCdRelInt(long idFceEligibility, long idPerson, String cdRelInt){
    int idFcePerson = commonDAO.getNextval("seq_FCE_PERSON");
    int numRowsInserted = fcePersonDAO.saveFcePersonByIdPersonIdFceEligAndCdRelInt(idFcePerson, Integer.valueOf(Long.toString(idFceEligibility)), Integer.valueOf(Long.toString(idPerson)), cdRelInt);
    if (numRowsInserted == 0){
      return 0;
    }
    return idFcePerson;
  }
  
  public List<FceIncome> findFceIncomeResources (long idFceEligibility, boolean incomeOrResource, boolean childOrFamily){
    if (isIncome(incomeOrResource)) {
      if (isChild(childOrFamily)) {
        return fceIncomeDAO.findIncomeForChild(idFceEligibility);
      }else {
        return fceIncomeDAO.findIncomeForFamily(idFceEligibility);
      }
    } else {
      if (isChild(childOrFamily)) {
        return fceIncomeDAO.findResourceForChild(idFceEligibility);
      } else {
        return fceIncomeDAO.findResourceForFamily(idFceEligibility);
      }
    }
    
    
  }
  
  // in case someone decides to reassign true/false values to income/resource
  private final boolean isIncome(boolean incomeOrResource) {
    return (incomeOrResource == INCOME);
  }

  //in case someone decides to reassign true/false values to income/resource
  private final boolean isResource(boolean incomeOrResource) {
    return (incomeOrResource == RESOURCE);
  }

  //in case someone decides to reassign true/false values to child/family
  private final boolean isChild(boolean childOrFamily) {
    return (childOrFamily == CHILD);
  }
}
