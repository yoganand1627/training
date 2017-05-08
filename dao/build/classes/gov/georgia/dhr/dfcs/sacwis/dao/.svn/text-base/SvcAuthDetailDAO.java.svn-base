/**
 * Created on Mar 25, 2006 at 3:32:28 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.db.SvcAuthDetail;

/* Change History:
Date        User              Description
--------    ----------------  --------------------------------------------------
 06/15/2009  arege             STGAP00012399: Added new method updateSvcAuthDetailWithIdForward to 
                               update svcAuthDetail table with idForward during person merge.
 01/07/2010  arege             STGAP00015696: Added findActiveServAuthByIdSpcNeedsDetAndCdSvcAuthDtlSvc() and getTotalSvcAuthDetailAmountReq()
 01/08/2010  mxpatel           STGAP00015702: Added methods for MR-52
 01/19/2010  mxpatel           SMS #43772: Added findSvcAuthDtlByIdPerson method
 02/11/2010  wjcochran         SMS #37406: Added new method findSvcAuthDtlByIdPersonIdSvcAuthDtl
 02/10/2010  mxpatel           SMS #44084: added method findSvcAuthDtlByIdPersonForSvcAuthDtl
 02/25/2010  mxpatel           SMS #45293: added method findAllServAuthTermByIdSpcNeedsDet
 02/02/2012  schoi             STGAP00017831: MR-102 Added new method findDistinctPersonByIdSvcAuth
 02/03/2012  schoi             STGAP00017831: MR-102 Added new method findEarliestBeiginDateOfSvcAuthDetailByPersonByIdSvcAuth 
                               
*/
public interface SvcAuthDetailDAO {
  /**
   * This selects a row from SvcAuthDetail. <p/>
   * 
   * @param idSvcAuth
   * @return List<SvcAuthDetail>
   */
  List<SvcAuthDetail> findServiceAuthDetailPersonByIdSvcAuth(int idSvcAuth);
  
  // STGAP00017831: MR-102
  /**
   * This selects distinct personID from SvcAuthDetail(s) under the idSvcAuth
   * 
   * @param idSvcAuth
   * @return List<Integers>
   */
  @SuppressWarnings({ "unchecked" })
  List<Integer> findDistinctPersonByIdSvcAuth(int idSvcAuth);

  // STGAP00017831: MR-102
  /**
   * This selects the earliest Begin Date of Service Authorization Detail by personID and idSvcAuth
   * 
   * @param idPerson
   * @param idSvcAuth
   * @return Date
   */
  @SuppressWarnings({ "unchecked" })  
  Date findEarliestBeiginDateOfSvcAuthDetailByPersonByIdSvcAuth(int idPerson, int idSvcAuth);
  
  /**
   * This selects a row from SvcAuthDetail. <p/>
   * 
   * @param idSvcAuth
   * @return List<SvcAuthDetail>
   */
  SvcAuthDetail findSvcAuthDetail(int idSvcAuthDtl);
  
  
/**
 * Gets all SVC Auth Details attached to a Adoption Assistance Application. 
 * @param idSvcAuth
 * @param todayDate
 * @return List of SvcAuthDetail's
 */
  List<SvcAuthDetail> getLinkedOpenSvcAuthDetailByIdSvcAuth( int idSvcAuth, Date todayDate);

  /**
   * Retrieves SvcAuthDetail object by querying SvcAuthDetail, ServiceAuthorization, SvcAuthEventLink, Event and Stage
   * tables for a given period.
   * 
   * @param idSvcAuthDtl
   * @param idResource
   * @param cdSvcAuthDtlSvc
   * @param idPerson
   * @param dtDtSvcAuthDtlTerm
   * @param dtDtSvcAuthDtlBegin
   * @return SvcAuthDetail
   */

  SvcAuthDetail findSvcAuthDetailByIdPerson(int idSvcAuthDtl, int idResource, String cdSvcAuthDtlSvc, int idPerson,
                                            Date dtDtSvcAuthDtlTerm, Date dtDtSvcAuthDtlBegin);

  List<Object[]> findSvcAuthDetailByIdPersonSQL(int idSvcAuthDtl, int idResource, String cdSvcAuthDtlSvc, int idPerson,
                                                Date dtDtSvcAuthDtlTerm, Date dtDtSvcAuthDtlBegin);

  /**
   * Retrieves SvcAuthDetail object by querying SvcAuthDetail, ServiceAuthorization, and Person tables for a given
   * Person ID.
   * 
   * @param moSvcDtlSvcMonth
   * @param yrSvcDtlServiceYear
   * @param idContract
   * @param cdSvcDtlCounty
   * @param cdSvcDtlService
   * @param idPerson
   */

  SvcAuthDetail findSvcAuthDetailFromSvcAuthDtlSvcAuthPersonByIdPerson(int moSvcDtlSvcMonth, int yrSvcDtlServiceYear,
                                                                       int idContract, String cdSvcDtlCounty,
                                                                       String cdSvcDtlService, int idPerson,
                                                                       Collection<Integer> idSvcAuthDtlList);

  /**
   * This Sql returns the dtae that EA Eligibility should be initiated. In determining this date, the sql grabs the date
   * of all Service Auths in the Investigation stage, the date of the conservatorship removal, and the date of stage
   * closure. It then picks the earliest of these dates as the date that EA eligibility begins. <p/>
   * 
   * @param idStage
   * @return Date
   */
  Date findDtEaEligibilityInitiated(int idStage);

  /**
   * Retrieve dtSvcAuthDtlTerm from the SvcAuthEventLink table
   * 
   * @param idCase
   * @return Date
   */
  Date findDtSvcAuthTerm(int idCase);

  /**
   * Retrieve idSvcAuth from the SvcAuthDetail table for teh given idSvcAuthDtl
   * 
   * @param idSvcAuthDtl
   * @return Integer
   */
  public Integer findIdSvcAuth(int idSvcAuthDtl);
  
  /**
   * Retrieve SvcAuthDetail and ServiceAuthorization rows given idPerson
   * 
   * @param idPerson
   * @return List<Map>
   */
  @SuppressWarnings( { "unchecked" })
  PaginatedHibernateList<Map> findSvcAuthDetailByIdPerson(int idPerson, int pageNbr, int pageSize);

  /**
   * Retrieve the distinct service codes for all the SvcAuthDetail rows for the given idSvcAuth
   * 
   * @param idSvcAuth
   * @return List<String>
   */
  List<String> findDistinctSvcCodes(int idSvcAuth);
  
  /**
   * Increment nbrSvcAuthDtlUnitUsed and amtSvcAuthDtlAmtUsed by the values given for the
   * SvcAuthDetail record.
   * 
   * @param idSvcAuthDtl
   * @param addUnitUsed
   * @param addAmtUsed
   * @return
   */
  int updateSvcAuthDetailAddUsedValues(int idSvcAuthDtl, double addUnitUsed, double addAmtUsed);
  
  //Added for STGAP00012399
  /**
   * Updates SvcAuthDetail with Forward Person id.
   * 
   * @param idPersonForward
   * @param idPersonClosed
   * @return
   */
  public int updateSvcAuthDetailWithIdForward(int idPersonForward, int idPersonClosed);

  /**
   * Inserts/updates an entire row of SvcAuthDetail table.
   * 
   * @param svcAuthDetail
   */
  int saveSvcAuthDetail(SvcAuthDetail svcAuthDetail);

  /**
   * Retrieve SvcAuthDetail and ServiceAuthorization rows for the given idSvcAuth and cdSvcCode
   * 
   * @param idSvcAuth
   * @param cdSvcCode
   * @return List<SvcAuthDetail>
   */
  List<SvcAuthDetail> findSvcAuthDetailByIdSvcAuthBySvcCode(int idSvcAuth, String cdSvcCode);
  
  /**
   * Delete a {@link gov.georgia.dhr.dfcs.sacwis.db.SvcAuthDetail} object.
   * 
   * @param SvcAuthDetail
   */
  void deleteSvcAuthDetail(SvcAuthDetail svcAuthDetail);
  
  Date findDtServiceAuthDetailTermByIdSvcAuthDtl(int idSvcAuthDtl);
  
  /**
   * find all the services that have not been ended or terminated for a person in a specific stage, and the 
   * services are of the type that include a specific key word
   * 
   * @param idStage
   * @param idPerson
   * @param todayDate
   * @param cdSvcAuthDtlSvcFamily
   * @return List<SvcAuthDetail>
   */
  List<SvcAuthDetail> getOpenSvcAuthDetailByIdStageByIdPersonByCdSvcAuthDtlSvc( int idStage, int idPerson,
                                                                                Date todayDate,
                                                                                String cdSvcAuthDtlSvcFamily );
  /**
   * find all the services that have not been ended or terminated for a specific stage, and the 
   * services are of the type that include a specific key word
   * 
   * @param idStage
   * @param todayDate
   * @param cdSvcAuthDtlSvcFamily
   * @return List<SvcAuthDetail>
   */
  List<SvcAuthDetail> getOpenSvcAuthDetailByIdStageByCdSvcAuthDtlSvc( int idStage, Date todayDate,
                                                                      String cdSvcAuthDtlSvcFamily );
  
  /**
   * 
   * @param idAdopAsstAppl
   * @param cdSvcDtlService
   * @param dtToday
   * @return
   */
  List<SvcAuthDetail> findActiveServAuthByIdSpcNeedsDetAndCdSvcAuthDtlSvc(int idAdopAsstAppl, Collection<String>  cdSvcDtlService, Date dtToday);
  
  /**
   * Retrieve all service auth detail associated to an ado application 
   * @param idAdopAsstAppl
   * @return
   */
  List<SvcAuthDetail> findAllServAuthByIdSpcNeedsDet(int idAdopAsstAppl);
  
  /**
   * 
   * @param idAdopAsstAppl
   * @param cdSvcDtlServiceList
   * @param dtToday
   * @param idSvcAuthDtl
   * @return
   */
  Double  getTotalSvcAuthDetailAmountReq(int idAdopAsstAppl, Collection<String> cdSvcDtlServiceList, Date dtToday, int idSvcAuthDtl);

  Integer findIdSpcNeedsDetByIdSvcAuthDtl(int idSvcAuthDtl);List<SvcAuthDetail> findSvcAuthDtlByIdPerson(int idPerson,String cdEventType, int idStage, Collection<String> cdSvcAuthDtlSvc, double amtSvcAuthDtlAmtReq);
  List<SvcAuthDetail> findSvcAuthDtlByIdPersonForSvcAuthDtl(int idPerson, int idSvcAuthDtl, String cdEventType, int idStage, Collection<String> cdSvcAuthDtlSvc, double amtSvcAuthDtlAmtReq);  
  SvcAuthDetail findSvcAuthDtlByIdPersonIdSvcAuthDtl(int idSvcAuthDtl, int idResource, String cdSvcAuthDtlSvc,
                                                            int idPerson, Date dtDtSvcAuthDtlTerm, Date dtDtSvcAuthDtlBegin);

  List<SvcAuthDetail> findAllServAuthTermByIdSpcNeedsDet(int idAdopAsstAppl);
  Double getTotalSvcAuthDetailAmountUsed(int idAdopAsstAppl, Collection<String> cdSvcDtlServiceList, Date dtToday, int idSvcAuthDtl );
  Double getTotalSvcAuthDetailAmountReqFor510(int idAdopAsstAppl, Collection<String> cdSvcDtlServiceList, Date dtToday, int idSvcAuthDtl, String cdEventType );
  Double getTotalSvcAuthDetailAmountReqFor510Term(int idAdopAsstAppl, Collection<String> cdSvcDtlServiceList, Date dtToday, int idSvcAuthDtl, String cdEventType );
  Double getTotalSvcAuthDetailAmountReqFor510ForAgreement(int idAdopAsstAppl, Collection<String> cdSvcDtlServiceList, Date dtToday, String cdEventType );
  Double getTotalSvcAuthDetailAmountReqFor510TermForAgreement(int idAdopAsstAppl, Collection<String> cdSvcDtlServiceList, Date dtToday, String cdEventType );
}
