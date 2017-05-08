package gov.georgia.dhr.dfcs.sacwis.web.core.user;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ArchitectureException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.BasePrsException;

public class UserProfileException extends ArchitectureException {
  private boolean displayable = false;

  public UserProfileException(String message, boolean displayable, Exception e) {
    super(message, e, BasePrsException.CRITICAL_PRIORITY);
    setDisplayable(displayable);
  }

  public boolean isDisplayable() {
    return displayable;
  }

  protected void setDisplayable(boolean displayable) {
    this.displayable = displayable;
  }
}



