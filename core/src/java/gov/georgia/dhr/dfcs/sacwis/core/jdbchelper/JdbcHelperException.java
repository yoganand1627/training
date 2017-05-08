package gov.georgia.dhr.dfcs.sacwis.core.jdbchelper;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ArchitectureException;

public class JdbcHelperException extends ArchitectureException {
  public JdbcHelperException(String message, Exception e) {
    super(message, e, ArchitectureException.WARNING_PRIORITY);
  }
}










