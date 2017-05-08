/**
 * Created on Mar 25, 2006 at 2:20:27 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.db.CpsInvstDetail;

import java.util.Date;
import java.util.List;
import java.util.Map;

/** Change History:
 **  Date        User              Description
 **  --------    ----------------  -------------------------------------------------------------------
 *   06/09/2011  Corey Harden      SMS#109631 Added method findAllCpsInvstDetailByIdResource(int idResource)                     
 *                                 
 **/

public interface CpsInvstDetailDAO {
  /**
   * This method fins all CpsInvstDetails associated with the passed-in resource
   * 
   * @param idResource - the id of the resource
   * @return - return a list of Maps 
   */
  List<Map> findAllCpsInvstDetailByIdResource(int idResource);
  /**
   * This selects a row from CpsInvstDetail given the IdCpsInvstStage.
   *
   * @param IdCpsInvstStage
   * @return CpsInvstDetail
   */
  CpsInvstDetail findCpsInvstDetailByIdStage(int IdCpsInvstStage);

  CpsInvstDetail findCpsInvstDetailByIdStageOnly(int idStage);
  
  /**
   * Finds the Final Disposition for the latest Inv Detail
   * @param idStage
   * @return
   */
  String findFinalDispositionByIdStage(int idStage);
  
  
  /**
   * Finds the latest cps Conclusion by idCase
   * @param IdCpsInvstCase
   * @return
   */
  public CpsInvstDetail findCpsInvstDetailByIdCase(int IdCpsInvstCase);
  
  
  /**
   * Finds the latest cps Conclusion by idCase only
   * @param IdCpsInvstCase
   * @return
   */
  public CpsInvstDetail findCpsInvstDetailByIdCaseOnly(int IdCpsInvstCase);

  /**
   * Retrieves a row from CpsInvstDetail for a given idEvent.
   *
   * @param idEvent
   * @return CpsInvstDetail
   */
  CpsInvstDetail findCpsInvstDetailByIdEvent(int idEvent);

  /**
   * Retrieves a list of idCase values from CpsInvstDetail given a set of idCase selector values.
   *
   * @param idCase0
   * @param idCase1
   * @param idCase2
   * @param idCase3
   * @param idCase4
   * @param idCase5
   * @param idCase6
   * @param idCase7
   * @param idCase8
   * @param idCase9
   * @param idCase10
   * @param idCase11
   * @param idCase12
   * @param idCase13
   * @param idCase14
   * @param idCase15
   * @param idCase16
   * @param idCase17
   * @param idCase18
   * @param idCase19
   * @param idCase20
   * @param idCase21
   * @param idCase22
   * @param idCase23
   * @param idCase24
   * @param idCase25
   * @param idCase26
   * @param idCase27
   * @param idCase28
   * @param idCase29
   * @param idCase30
   * @param idCase31
   * @param idCase32
   * @param idCase33
   * @param idCase34
   * @param idCase35
   * @param idCase36
   * @param idCase37
   * @param idCase38
   * @param idCase39
   * @param idCase40
   * @param idCase41
   * @param idCase42
   * @param idCase43
   * @param idCase44
   * @param idCase45
   * @param idCase46
   * @param idCase47
   * @param idCase48
   * @param idCase49
   * @return List<Integer>
   */
  @SuppressWarnings({"unchecked"})
  public List<Integer> findCpsInvstDetailIdCase(int idCase0, int idCase1, int idCase2, int idCase3, int idCase4,
                                                int idCase5, int idCase6, int idCase7, int idCase8, int idCase9,
                                                int idCase10, int idCase11, int idCase12, int idCase13, int idCase14,
                                                int idCase15, int idCase16, int idCase17, int idCase18, int idCase19,
                                                int idCase20, int idCase21, int idCase22, int idCase23, int idCase24,
                                                int idCase25, int idCase26, int idCase27, int idCase28, int idCase29,
                                                int idCase30, int idCase31, int idCase32, int idCase33, int idCase34,
                                                int idCase35, int idCase36, int idCase37, int idCase38, int idCase39,
                                                int idCase40, int idCase41, int idCase42, int idCase43, int idCase44,
                                                int idCase45, int idCase46, int idCase47, int idCase48, int idCase49);

  /**
   * Updates table CpsInvstDetail with the specified fields
   * <p/>
   *
   * @param idEvent
   * @param cdCpsInvstDtlFamIncm
   * @param cdCpsOverallDisptn
   * @param dtCPSInvstDtlAssigned
   * @param dtCPSInvstDtlBegun
   * @param dtCpsInvstDtlComplt
   * @param dtCPSInvstDtlIntake
   * @param indCpsInvstEaConcl
   * @param indCpsInvstSafetyPln
   * @param indCpsInvstDtlRaNa
   * @param idStage
   * @param tsLastUpdate
   */
  int updateCpsInvstDetail(int idEvent, String cdCpsInvstDtlFamIncm,
                           String cdCpsOverallDisptn, Date dtCPSInvstDtlAssigned,
                           Date dtCPSInvstDtlBegun, Date dtCpsInvstDtlComplt,
                           Date dtCPSInvstDtlIntake, String indCpsInvstEaConcl,
                           String indCpsInvstSafetyPln, String indCpsInvstDtlRaNa,
                           int idStage, Date tsLastUpdate);
  
 
  /**
   * Saves a {@link gov.georgia.dhr.dfcs.sacwis.db.CpsInvstDetail} object to the database.
   *
   * @param cpsInvstDetail A populated {@link gov.georgia.dhr.dfcs.sacwis.db.CpsInvstDetail} object.
   */
  void saveCpsInvstDetail(CpsInvstDetail cpsInvstDetail);
}
