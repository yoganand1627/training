package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import gov.georgia.dhr.dfcs.sacwis.dao.ComplexPersonEligibilityDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonEligibilityDAO;

public class ComplexPersonEligibilityDAOImpl extends BaseDAOImpl implements ComplexPersonEligibilityDAO {
  private PersonEligibilityDAO personEligibilityDAO = null;

  public void setPersonEligibilityDAO(PersonEligibilityDAO personEligibilityDAO) {
    this.personEligibilityDAO = personEligibilityDAO;
  }

  private int determineLeapYear() {

    Date now = new Date();
    Calendar cal = new GregorianCalendar();
    cal.setTime(now);
    cal.roll(Calendar.YEAR, 1); // forward it one year
    cal.roll(Calendar.DAY_OF_YEAR, -1); // back it up one day
    int daysInNextYear = (int) ((cal.getTimeInMillis() - now.getTime()) / (24 * 60 * 60));
    return daysInNextYear;
  }

  public void insertPersonEligibility(Date dtPersEligStart, int idPerson) {

    int daysToSubtract = 0;
    int daysInYear = 365;
    int days = determineLeapYear();
    if (daysInYear == days) {
      daysToSubtract = 1;
    }
    personEligibilityDAO.insertPersonEligibility(dtPersEligStart, daysToSubtract, idPerson);
  }

  public void updatePersonEligibility(int idPersElig, String cdPersEligPrgOpen) {
    personEligibilityDAO.updateCdPersEligPrgOpenByIdPersElig(idPersElig, cdPersEligPrgOpen);
  }

  public void updatePersonEligibility(int idPersElig, String cdPersEligPrgOpen, String cdPersEligPrgClose) {
    personEligibilityDAO.updateCdPersEligPrgOpenCloseByIdPersElig(idPersElig, cdPersEligPrgOpen, cdPersEligPrgClose);
  }

  public void updatePersonEligibility(int idPersElig, Date dtDtPersEligEaDeny, String cdPersEligPrgClose) {
    personEligibilityDAO.updateDtEligDenyAndCdPersEligPrgCloseByIdPersElig(idPersElig, dtDtPersEligEaDeny,
                                                                           cdPersEligPrgClose);
  }

  public void updatePersonEligibility(int idPersElig, Date dtDtPersEligEaDeny, String cdPersEligPrgOpen,
                                      String cdPersEligPrgClose) {
    personEligibilityDAO.updateDtEligDenyAndCdPersEligPrgOpenCloseByIdPersElig(idPersElig, dtDtPersEligEaDeny,
                                                                               cdPersEligPrgOpen, cdPersEligPrgClose);
  }
}
