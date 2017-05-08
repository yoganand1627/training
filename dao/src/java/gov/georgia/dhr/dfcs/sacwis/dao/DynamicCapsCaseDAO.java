/**
 * Created on May 2, 2006 at 12:44:41 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;

import java.util.List;
import java.util.Map;

public interface DynamicCapsCaseDAO {
  /*public static final int SORT_BY_PROGRAM = 1;
  public static final int SORT_BY_UTC = 2;
  public static final int SORT_BY_STATUS = 3;
  public static final int SORT_BY_CASE_NAME = 4;
  public static final int SORT_BY_COUNTY = 5;*/
  public static final int SORT_BY_CASE_MANAGER = 1;
  public static final int SORT_BY_DATE = 2;
  public static final int SORT_BY_STAGE = 3;

  /**
   * This DAM uses dynamic SQL to retrieve data for the Case List window
   * <p/>
   * At lest one of idPerson, idCase, or nmCase must be populated.
   * <p/>
   * An list of Object Maps with the following keys: cdCaseCounty, idCase, nmCase, indCaseSensitive, cdCaseProgram,
   * dtCaseClosed, idSituation, cdStage, idPerson, idUnit and scrWorkerPrim.
   * <p/>
   *
   * @param idPerson
   * @param idCase
   * @param nmCase
   * @param cdStagePersRole
   * @param scrCdStagePersRole
   * @param nmCaseAppend
   * @param cdCaseProgram
   * @param cdCaseRegion
   * @param cdCaseCounty
   * @param addrMailCodeCity
   * @param sortBy             Must be one of the constants defined in this interface.
   * @param indUseStageDecode TODO
   * @return See description for the structure of the returned array.
   * @throws gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException
   *
   */
  
//** Change History:
//**  Date      User              Description
//**  --------  ----------------  --------------------------------------------------
//**  03/19/08  charden          added List codeCountiesList to the list of parameters

  
  @SuppressWarnings({"unchecked"})
  List<Map> findCases(int idPerson, int idCase, String nmCase, String cdStagePersRole, String scrCdStagePersRole,
                      String nmCaseAppend, String cdCaseProgram, String cdCaseRegion, String cdCaseCounty,
                      String addrMailCodeCity, int idCaseManager, String nmCaseManager, String cdStage,
                      String nbrUnit, String dtLastUpdate, String selRbOpenClose,
                      String cdCpsInvstDtlOvrllDisptn, int sortBy, String sortDir, 
                      int pageNbr, int pageSize, List codeCountiesList, String indUseStageCode) throws ServiceException;
}
