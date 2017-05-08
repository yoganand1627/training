package gov.georgia.dhr.dfcs.sacwis.service.intake;

import gov.georgia.dhr.dfcs.sacwis.structs.input.HierSrchInRec;
import gov.georgia.dhr.dfcs.sacwis.structs.output.HierSrchOutRec;

public interface RetrievePersonSearchAsync {

  public static final int FULL_NAME_LEN = 26;
  public static final String CD_STATUS_MERGED = "M";
  public static final String EMPLOYEE_CATEGORY = "EMP";
  public static final int ARC_UTL_ERR_INPUT_TOO_SMALL = 13006;

  public static final int WW_RANGE_RETURNED = 5;
  public static final int WI_RANGE_RETURNED = 4;
  public static final int W_RANGE_RETURNED = 3;

  public static final int ADULT_AGE_RANGE_START = 18;
  public static final int ADULT_AGE_RANGE_VALUE = 10;
  public static final int CHILD_AGE_RANGE_VALUE = 3;

  /**
   * Asynchronous Hierarchical Background Search Based on the information sent to this service from the Call Person
   * Detail window, the following searches are performed:
   * <pre>
   * On Social Security Number
   * On Phonetic First Name and Street Line 1, City, County
   * On Phonetic Full Name and Street Line 1, City, County
   * On Phonetic Full Name and Age
   * On Phonetic Full Name
   * On Phone Number
   * </pre>
   * If SSN exists, that search is performed.  If data is returned from the SSN search, the service ends and that data
   * is returned to the client.  If no data is returned, the next search for which all data inputs exist is performed.
   * The service continues to launch searches for which all inputs are present until either a search has been successful
   * or no search options are left.
   * <p/>
   *
   * @param hierSrchInRec {@link HierSrchInRec}
   * @return HierSrchOutRec
   */
  HierSrchOutRec retrievePersonSearchAsync(HierSrchInRec hierSrchInRec);
}
