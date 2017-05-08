package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.Date;

import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexPersonIdDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonIdDAO;

public class ComplexPersonIdDAOImpl extends BaseDAOImpl implements ComplexPersonIdDAO {
  private PersonIdDAO personIdDAO = null;

  public void setPersonIdDAO(PersonIdDAO personIdDAO) {
    this.personIdDAO = personIdDAO;
  }

  public int insertPersonIdSetEndDate(int idPerson, String nbrPersonIdNumber, String cdPersonIdType,
                                      String descPersonID, String indPersonIDInvalid, Date dtPersonIDEnd,
                                      String indValidateByInterface) {
    if (!DateHelper.isNull(dtPersonIDEnd)) {
      dtPersonIDEnd = new Date();
    }
    return personIdDAO.insertPersonIdByStartEnd(idPerson, nbrPersonIdNumber, cdPersonIdType, descPersonID,
                                                indPersonIDInvalid, new Date(), dtPersonIDEnd, indValidateByInterface);
  }

  public int updatePersonIdsetEndDate(int idPerson, int idPersonId, String nbrPersonIdNumber, String cdPersonIdType,
                                      String descPersonID, String indPersonIDInvalid, Date dtPersonIDEnd,
                                      String indValidateByInterface, Date dtLastUpdate) {

    if (!DateHelper.isNull(dtPersonIDEnd)) {
      dtPersonIDEnd = new Date();
    }
    return personIdDAO.updatePersonIdEndDate(idPerson, idPersonId, nbrPersonIdNumber, cdPersonIdType, descPersonID,
                                             indPersonIDInvalid, dtPersonIDEnd, indValidateByInterface, dtLastUpdate);
  }

  public int deletePersonId(int idPersonId, Date dtSysTsLastUpdate2) {
    return personIdDAO.deletePersonId(idPersonId, dtSysTsLastUpdate2);
  }

  public void findPersonIdByIdPerson(boolean[] results, int idPerson, int sysIdNewPerson) {
    String socialA = personIdDAO.findNonEndDatePersonSSN(idPerson);
    String socialB = personIdDAO.findNonEndDatePersonSSN(sysIdNewPerson);
    String medicaA = personIdDAO.findNonEndDatePersonMedicaid(idPerson);
    String medicaB = personIdDAO.findNonEndDatePersonMedicaid(sysIdNewPerson);
    if (socialA == null && socialB == null) {
      results[0] = true;
    } else if (socialA != null && socialB != null) {

      if (socialA.equals(socialB)) {
        results[0] = true;
      } else {
        results[0] = false;
      }
    } else {
      results[0] = false;
    }

    if (medicaA == null && medicaB == null) {
      results[1] = true;
    } else if (medicaA != null && medicaB != null) {

      if (medicaA.equals(medicaB)) {
        results[1] = true;
      } else {
        results[1] = false;
      }
    } else {
      results[1] = false;
    }
  }
}