package gov.georgia.dhr.dfcs.sacwis.service.admin;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN29SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN29SO;

public interface RetrieveUnitSummary { 
  /**
   * This service is designed to retrieve Unit Summary information from the database.  It is sent CD UNIT PROGRAM, CD
   * UNIT REGION, NBR UNIT, ID PERSON for the user, and ID PERSON for the user's designees.  It returns data from the
   * Unit Summary View which is built from the EMPLOYEE, PERSON, STAGE, STAGE PERSON LINK, and UNIT EMP LINK tables.
   *
   * @param ccmn29si
   * @return {@link CCMN29SO} object
   */
  public CCMN29SO findUnitSummary(CCMN29SI ccmn29si);
  
  public static final String SYS_ADMIN = "64";//mxpatel added this for defect #7259
}
