package gov.georgia.dhr.dfcs.sacwis.web.core.user;

import java.io.Serializable;
import java.util.Date;

public class TempAssignment implements Serializable {
  /** Empty constructor for temporary assignemt */
  public TempAssignment() {
  }

  /**
   * This method sets the tempDesignatorID parameter
   *
   * @param userID Contains designator id (ex. 12322313123132)
   */
  public void setTempDesignatorID(String tempDesignatorID) {
    this.tempDesignatorID = tempDesignatorID;
  }

  /**
   * This method returns the tempDesignatorID
   *
   * @return The Designator ID for the temporary assignment
   */
  public String getTempDesignatorID() {
    return this.tempDesignatorID;
  }

  /**
   * This method sets the tempFunction parameter
   *
   * @param tempFunction Contains the function (ex. Supervisor)
   */
  public void setTempFunction(String tempFunction) {
    this.tempFunction = tempFunction;
  }

  /**
   * This method returns the tempFunction
   *
   * @return The function for the temporary assignment
   */
  public String getTempFunction() {
    return this.tempFunction;
  }

  /**
   * This method sets the tempSecurityClass parameter
   *
   * @param tempSecurityClass Contains the security class (ex. Intake Supervisor)
   */
  public void setTempSecurityClass(String tempSecurityClass) {
    this.tempSecurityClass = tempSecurityClass;
  }

  /**
   * This method returns the tempSecurityClass
   *
   * @return The security class for the temporary assignment
   */
  public String getTempSecurityClass() {
    return this.tempSecurityClass;
  }

  /**
   * This method sets the TempExpDate parameter
   *
   * @param tempExpDate Contains the date (ex. 10/23/2002)
   */
  public void setTempExpDate(Date TempExpDate) {
    this.tempExpDate = new Date();
  }

  /**
   * This method returns the tempExpDate
   *
   * @return The expiration date for the temporary assignment
   */
  public Date getTempExpDate() {
    return this.tempExpDate;
  }

  //Instance Variables
  private String tempDesignatorID;
  private String tempFunction;
  private String tempSecurityClass;
  private Date tempExpDate;

}




