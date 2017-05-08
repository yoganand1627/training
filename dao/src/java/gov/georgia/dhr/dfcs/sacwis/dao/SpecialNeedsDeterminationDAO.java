package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.db.SpecialNeedsDetermination;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

/** @author vishala devarakonda */

/** Change History
 **  Date        User              Description
 **  --------    ----------------  --------------------------------------------------
                 
 * 05/18/2009  bgehlot           STGAP00013779: MR-050: Added method  findLatestApprovedNonRecSpclDetermination.
 * 05/27/2009  bgehlot           STGAP00013924: Added method findLatestApprovedSpclDetermination
 * 06/01/2009  hjbaptiste        STGAP00012521: Renamed findSpclDeterminationsByIdCaseByIdPerson to findSpclDeterminationsByIdCaseIdStageIdPerson
 *                               and passed in the idStage parameter
 * 06/8/2009   bgehlot           STGAP00012194: Added method findSpclDeterminationByIdStageByIdPersonNA
 * 06/12/2009  mxpatel           STGAP00013002: wrote the method findIndAprvByIdAgreement.
 * 12/30/2009  mchillman         Change not pull over any applications that special services only for new agreements  
 * 01/08/2010  mxpatel           STGAP00015702: Added methods for MR-52        
 * 01/06/2011  arege             SMS#77302 Modified return type for method findIndAprvByIdAgreement              
 * 03/09/2011  htvo              SMS#97845 MR-074-2 AFCARS: new method findLatestAprvSpclDeterminationByIdStageIdPerson,
 *                               findIdEventsByIdPersonIdCaseSpcNeedsDetType, findAPRVMonthlyAppByIdCaseIdPerson
 * 04/11/2011  htvo              SMS#97845 MR-074-2 AFCARS: modified findAPRVMonthlyAppByIdCaseIdPerson 
 *                               to findApprovedDeferredMonthlyAppByIdCaseIdPerson                              
 */

public interface SpecialNeedsDeterminationDAO {

  /**
   * Retrieves the Special Needs Determination Information from the Special_Needs_Information table for the given
   * idEvent. <p/>
   * 
   * @param idEvent
   * @return
   */
  SpecialNeedsDetermination findSpecialNeedsDeterminationByIdEvent(int idEvent);

  /**
   * Retrieves the Special Needs Determination Information from the Special_Needs_Information table for the given
   * idCase and idPerson. <p/>
   * 
   * @param idCase
   * @param idPerson
   * @return
   */
  Map findLatestSpecialNeedsDeterminationForADP(int idCase, int idPerson);

  /**
   * Updates Special_Needs_Information table.
   * 
   * @param SpecialNeedsDetermination
   * 
   * @return
   */
  int saveSpecialNeedsDetermination(SpecialNeedsDetermination spNdsDetermination);
  
  /**
   * Gets all non-expired Special Needs Determination records for the given case and person
   * @param idCase
   * @param idStage
   * @param idPerson
   * @return
   */
  List<Integer> findSpclDeterminationsByIdCaseIdStageIdPerson(int idCase, int idStage, int idPerson);
  
  
  /**
   * Gets all non-expired Special Needs Determination records for the given case and person and stage
   * @param idCase
   * @param idPerson
   * @param idStage
   * @return
   */
  List<Integer> findAllSpclDeterminationsByIdCaseByIdPerson(int idCase, int idPerson, int idStage);
  
  /**
   * Gets the most recent approved SpecialNeedsDetermination record with either Basic rate approved or Specialized rate approved
   * @param idStage
   * @param idPerson
   * @return
   */
  SpecialNeedsDetermination findSpclDeterminationByIdStageByIdPerson(int idStage, int idPerson, int idCase);
  
  /**
   * Gets the most recent approved SpecialNeedsDetermination record with NonRecurring any approved
   * @param idStage
   * @param idPerson
   * @param idCase
   * @return
   */
  SpecialNeedsDetermination findAprvNonRecurringByIdStageByIdPerson(int idStage, int idPerson, int idCase);
  
  /**
   * Gets the a list of approved Special Needs Determinations records no approved special services only
   * @param idStage
   * @param pageNbr,
   * @param pageSize
   * @return PaginatedHibernateList<Map> 
   */
  PaginatedHibernateList<Map> findApprovedSpclDeterminationEventsByIdStageNoSpclSer(int idStage, int pageNbr, int pageSize);
  
  /**
   * Gets the a list of approved Special Services Special Needs Determinations records
   * @param idStage
   * @param spclSerTypes list of special service types to search against
   * @param pageNbr,
   * @param pageSize
   * @return PaginatedHibernateList<Map> 
   */  
  public PaginatedHibernateList<Map> findApprovedSpclDeterminationEventsByIdStageSpclSerOnly(int idStage, Collection<String> spclSerTypes, int pageNbr, int pageSize);
  
  /**
   * Gets the a list of approved Non-Recurring Special Needs Determinations records
   * @param idStage
   * @param pageNbr,
   * @param pageSize
   * @return PaginatedHibernateList<Map> 
   */  
  public PaginatedHibernateList<Map> findApprovedSpclDeterminationEventsByIdStageNonRecOnly(int idStage, int pageNbr,int pageSize);
  
  /**
   *   STGAP00013779: Find the latest Approved Non Recurring Application
   * @param idStage
   * @param idPerson
   * @param idCase
   * @return
   */
  SpecialNeedsDetermination findLatestApprovedNonRecSpclDetermination(int idStage, int idPerson, int idCase);
  
  /** 
   * STGAP00013924: Find the latest Approved Special Needs Application
   * @param idStage
   * @param idPerson
   * @param idCase
   * @return
   */
  SpecialNeedsDetermination findLatestApprovedSpclDetermination(int idStage, int idPerson, int idCase);
  
  //STGAP00012194: Retrieves the approved special needs determination
  SpecialNeedsDetermination findSpclDeterminationByIdStageByIdPersonNA(int idStage, int idPerson, int idCase);
  Map findIndAprvByIdAgreement(int idEvent);
  SpecialNeedsDetermination findSpecNeedsDeterByIdSpcNeedsDeter(int idSpecNeedsDeter);
  long findCountAprvSpecServByIdPerosnIdStageType(int idPerson, int idEvent, Date aprvDate, Date expDate, int idStage, String cdSpclSrvType);
  
  /**
   * Find the most recent special needs determination (AA Application) with the selection of Incident/Non-Incident Status
   * 
   * @param idStage
   * @param idPerson
   * @return
   */
  SpecialNeedsDetermination findLatestAprvSpclDeterminationByIdStageIdPerson(int idCase, int idPerson);
  
  /**
   * Find id event adoption assistance application in APRV event status with certain special needs determination types
   * @param idPerson
   * @param idStage
   * @param spcNeedsDetType
   * @return
   */
  List<Integer> findIdEventsByIdPersonIdCaseSpcNeedsDetType(int idPerson, int idStage, Collection spcNeedsDetType);
  
  /**
   * Find monthly AA Application that is in APRV event status. This can be with or without special needs determination 
   * and the application status can be approved, deferred, or denied
   * @param idCase
   * @param idPerson
   * @return
   */
  List<SpecialNeedsDetermination> findApprovedDeferredMonthlyAppByIdCaseIdPerson(int idCase, int idPerson);
}