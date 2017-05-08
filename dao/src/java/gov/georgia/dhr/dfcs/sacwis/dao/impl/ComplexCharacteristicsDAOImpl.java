package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.Date;

import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.CharacteristicsDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexCharacteristicsDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Characteristics;

public class ComplexCharacteristicsDAOImpl extends BaseDAOImpl implements ComplexCharacteristicsDAO {
  private CharacteristicsDAO characteristicsDAO = null;
  private PersonDAO personDAO = null;

  public void setCharacteristicsDAO(CharacteristicsDAO characteristicsDAO) {
    this.characteristicsDAO = characteristicsDAO;
  }

  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }

  public int insertCharacteristicsForPersonMerge(int idPerson, String cdCharCategory, String cdCharacteristic,
                                                 Date dtCharStart, Date dtCharEnd) {
    if (0 == characteristicsDAO.insertCharacteristics(idPerson, cdCharCategory, cdCharacteristic, dtCharStart,
                                                      dtCharEnd)) {
      return 0;
    }
    // The results of this update are ignored.
    if (characteristicsDAO.countCharacteristicsByIdPerson(idPerson) > 0) {
      personDAO.updatePersonSetCharToOne(idPerson);
    }
    // Return success if we got here.
    return 1;
  }

  public int updateCharacteristicsForPerson(int idPerson, int nbrPersonAge, String cdCharCategory,
                                            String cdCharacteristic, Date dtCharStart) {
    // search for aged record
    Characteristics characteristics = characteristicsDAO.countAgedCharacteristicsByIdPerson(idPerson);
    // If found then check age, otherwise no record exists so ADD to table; no records found is NOT an error.
    int numrows = -1; // Use something besides 0, as zero will be used for failure below.
    if (characteristics != null) {
      // If person is not 65 or over and we are attempting to ADD to characteristics table then change code to UPDATE
      //   and end date the corresponding record to uncheck.
      if (nbrPersonAge < 65) {
        numrows = characteristicsDAO.updateCharacteristicsEndDate(characteristics.getIdCharacteristics(), new Date());
      }
    } else if (nbrPersonAge >= 65) {
      numrows = characteristicsDAO.insertCharacteristics(idPerson, cdCharCategory, cdCharacteristic, dtCharStart,
                                                         DateHelper.MAX_JAVA_DATE);
    }
    // This method is only called from Person Detail; the Person table must also be updated.
    // Errors here are ignored in the DAM.
    if (characteristicsDAO.countCharacteristicsByIdPerson(idPerson) > 0) {
      personDAO.updatePersonSetCharToOne(idPerson);
    } else {
      personDAO.updatePersonSetCharToZero(idPerson);
    }
    // Return failure here because the update to PERSON occurred whether or not the update to characteristics succeeded.
    if (numrows == 0) {
      return 0;
    }
    // If we got here, we return success, as we either did nothing intentionally, or updated at least 1 row.
    return 1;
  }
}
