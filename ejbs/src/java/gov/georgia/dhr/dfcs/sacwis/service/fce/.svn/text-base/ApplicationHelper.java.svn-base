package gov.georgia.dhr.dfcs.sacwis.service.fce;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceEligibilityDB;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;

public class ApplicationHelper implements Serializable {
  protected static boolean getApplicationEligible(Connection connection, long idFceApplication, Fce fce)
          throws SQLException {
    FceEligibilityDB fceEligibilityDB =
            EligibilityHelper.findEligibilityByIdFceApplication(connection, idFceApplication, fce);
    return (ArchitectureConstants.Y.equals(toCharIndicator(fceEligibilityDB.getIndEligibleObject())));
  }

  private static String toCharIndicator(Boolean value) {
    if (value == null) {
      return null;
    }
    if (value) {
      return "Y";
    }
    return "N";
  }
}
