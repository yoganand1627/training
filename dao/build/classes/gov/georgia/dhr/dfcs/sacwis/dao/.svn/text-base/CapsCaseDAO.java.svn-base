/**
 * Created on Mar 25, 2006 at 2:15:07 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;
/**
 * This is the DAO class is used for the CAPS_CASE table
 * 
 * <pre>
 *  Change History:
 *  Date      User      Description
 *  --------  --------  --------------------------------------------------
 *  02/09/12  htvo      STGAP00017831: MR-102 - Added method countByIdCaseDtCaseOpened
 * </pre>
 */
import java.util.Collection;
import java.util.Date;

import gov.georgia.dhr.dfcs.sacwis.db.CapsCase;

public interface CapsCaseDAO {
  /**
   * Find NmCase by idCase
   *
   * @param idCase
   * @return
   */
  String findNmCaseByIdCase(int idCase);

  /**
   * Retrieve one row from the CapsCase table for a given idCase.
   *
   * @param idCase
   * @return CapsCase
   */
  CapsCase findCapsCaseByIdCase(int idCase);

  /**
   * Return the date the case opened by idStage
   *
   * @param idStage
   * @return Date
   */
  Date findDtCaseOpenedByIdStage(int idStage);
  
  
  /**
   * Returns the county of the case given the idStage
   * @param idStage
   * @return cdCaseCounty
   */
  String findCdCaseCountyByIdStage(int idStage);

  /**
   * Retrieve DT CASE OPENEND from the CAPS CASE table for a given idCase.
   *
   * @param idCase
   * @return Date representing dtCaseOpened
   */
  Date findCapsCaseDtCaseOpenedByIdCase(int idCase);

  /**
   * Retrieves nmCase given idCaseMergeTo. <p/>
   *
   * @param idCaseMergeTo
   * @return String
   */
  String findNmCaseByIdCaseMergeTo(int idCaseMergeTo);

  /**
   * Retrieves nmCase given idCaseMergeFrom. <p/>
   *
   * @param idCaseMergeFrom
   * @return String
   */
  String findNmCaseByIdCaseMergeFrom(int idCaseMergeFrom);
  
  /**
   * count number of cases that opened before a certain date
   * @param idCase
   * @param aDate
   * @return
   */
  long countByIdCaseDtCaseOpened(Collection<Integer> idCaseSet, Date aDate);

  /**
   * Updates table CapsCase, fields cdStageRegion and cdStageCnty given idCase <p/>
   *
   * @param idCaseSet
   * @param cdStageRegion
   * @param cdStageCnty
   */
  int updateCapsCaseCdStageRegioncCStageCntyByIdCase(int idCase, String cdCaseRegion, String cdCaseCounty);

  /**
   * Updates table CapsCase, field idCase by finding idCase from the Case table given idUnit <p/>
   *
   * @param idUnit
   */
  int updateCapsCaseByFindingIdCaseInStageByIdUnit(int idUnit);

  /**
   * Updates table CapsCase, field nmCase given idCase <p/>
   *
   * @param idCase
   * @param nmCase
   */
  int updateCapsCaseNmCase(int idCase, String nmCase);
  
  /**
   * </p>Updates table CapsCase, field indCaseSensitive given idCase <p/>
   * 
   * @param idCase
   * @param indCaseSensitive
   * @return number of rows updated
   */
  int updateCapsCaseIndCaseSensitive(int idCase, String indCaseSensitive);

  /**
   * Saves a {@link gov.georgia.dhr.dfcs.sacwis.db.CapsCase} object to the database.
   *
   * @param capsCase A populated {@link gov.georgia.dhr.dfcs.sacwis.db.CapsCase} object.
   */
  void saveCapsCase(CapsCase capsCase);

  /**
   * Updates specified collumns of the CapsCase table.<p/>
   *
   * @param cdCaseProgram
   * @param cdCaseCounty
   * @param cdCaseSpeclHndlg
   * @param indCaseWorkerSafety
   * @param txtCaseWorkerSafety
   * @param txtCaseSensitiveCmnts
   * @param indCaseSensitive
   * @param indCaseArchived
   * @param dtCaseClosed
   * @param cdCaseRegion
   * @param dtCaseOpened
   * @param nmCase
   * @param idCase
   */
  int updateCapsCaseWithoutCaseSuspMeth(String cdCaseProgram, String cdCaseCounty, String cdCaseSpeclHndlg,
                                        String indCaseWorkerSafety, String txtCaseWorkerSafety,
                                        String txtCaseSensitiveCmnts, String indCaseSensitive, String indCaseArchived,
                                        Date dtCaseClosed, String cdCaseRegion, Date dtCaseOpened, String nmCase,
                                        int idCase);

  /**
   * Updates table CapsCase, field cdCaseRegion by given idCase<p/>
   *
   * @param idCase
   * @param cdCaseRegion
   */
  int updateCapsCaseCdCaseRegion(int idCase, String cdCaseRegion);

  /**
   * Update CapsCase
   *
   * @param cdCaseSpeclHndlg
   * @param indCaseWorkerSafety
   * @param txtCaseWorkerSafety
   * @param txtCaseSensitiveCmnts
   * @param indCaseSensitive
   * @param idCase
   * @param tsSysTsLastUpdate2
   * @return
   */
  int updateCapsCase(String cdCaseSpeclHndlg, String indCaseWorkerSafety, String txtCaseWorkerSafety,
                     String txtCaseSensitiveCmnts, String indCaseSensitive, int idCase, Date tsSysTsLastUpdate2);

  /**
   * Change the Case Name for all open APS cases where the original Case Name is equal to a given NM PERSON FULL and the
   * ID PERSON is linked to the case as a victim or client.
   *
   * @param nmCase
   * @param nmPersonFull
   * @param maxDate
   * @param idPerson
   * @return
   */
  int updateCapsCase(String nmCase, String nmPersonFull, Date maxDate, int idPerson);

  /**
   * Updates table CapsCase, field dtCaseClosed given dtCaseClosed and idCase
   *
   * @param dtCaseClosed
   * @param idCase
   */
  int updateCapsCaseDtCaseClosed(Date dtCaseClosed, int idCase);

  /**
   * Partial update of CapsCase table using the supplied parameters(column values).
   *
   * @param idCase
   * @param cdStageCnty
   * @return int The number of entities effected by the 'update' operation.
   */
  int updateCapsCaseCdCaseCountyByIdCase(int idCase, String cdStageCnty);

  /**
   * Delete a {@link gov.georgia.dhr.dfcs.sacwis.db.CapsCase} object.
   *
   * @param capsCase
   */

  void deleteCapsCase(CapsCase capsCase);

  /**
   * Insert a {@link gov.georgia.dhr.dfcs.sacwis.db.CapsCase} object.
   * 
   * @param idCase
   * @param nmCase
   * @param cdProgram
   * @param cdCounty
   * @param cdRegion
   * @param dtOpened
   * @param dtClosed
   * @return
   */
  int insertCapsCaseCdProgramCdCountyCdRegionDtOpenedDtClosed( int idCase, String nmCase, String cdCaseProgram, 
                                                               String cdCaseCounty, String cdCaseRegion, 
                                                               Date dtCaseOpened, Date dtCaseClosed );
  /**
   * Insert a {@link gov.georgia.dhr.dfcs.sacwis.db.CapsCase} object.
   *
   * @param cdCaseProgram
   * @param cdCaseCounty
   * @param cdCaseSpecailHandling
   * @param indCaseWorkSafty
   * @param txtCaseWorkerSafety
   * @param txtCaseSensitiveCmnts
   * @param indCaseSensitive
   * @param indCaseArchived
   * @param dtCaseClosed
   * @param dtCaseOpen
   * @param nmCase
   * @param indCaseSuspMeth
   * @param txtCaseSuspMeth
   * @param idCase
   * @return int The number of entities effected by the 'update' operation.
   */
  public int insertCapsCase(String cdCaseProgram, String cdCaseRegion, String cdCaseCounty,
                            String cdCaseSpecailHandling, String indCaseWorkSafty, String txtCaseWorkerSafety,
                            String txtCaseSensitiveCmnts, String indCaseSensitive, String indCaseArchived,
                            Date dtCaseClosed, Date dtCaseOpen, String nmCase, String indCaseSuspMeth,
                            String txtCaseSuspMeth, int idCase);

  /**
   * Update a {@link gov.georgia.dhr.dfcs.sacwis.db.CapsCase} object.
   *
   * @param cdCaseProgram
   * @param cdCaseCounty
   * @param cdCaseRegion
   * @param cdCaseSpecailHandling
   * @param indCaseWorkSafty
   * @param txtCaseWorkerSafety
   * @param txtCaseSensitiveCmnts
   * @param indCaseSensitive
   * @param indCaseArchived
   * @param dtCaseClosed
   * @param dtCaseOpen
   * @param nmCase
   * @param indCaseSuspMeth
   * @param txtCaseSuspMeth
   * @param idCase
   * @return int The number of entities effected by the 'update' operation.
   */
  public int updateCapsCase(String cdCaseProgram, String cdCaseCounty, String cdCaseRegion,
                            String cdCaseSpecailHandling, String indCaseWorkSafty, String txtCaseWorkerSafety,
                            String txtCaseSensitiveCmnts, String indCaseSensitive, String indCaseArchived,
                            Date dtCaseClosed, Date dtCaseOpened, String nmCase, String indCaseSuspMeth,
                            String txtCaseSuspMeth, int idCase);
  
  /**
   * Save or update Caps Case record
   * @param capsCase
   * @return
   */
  public int saveOrUpdateCapsCase(CapsCase capsCase);
}
