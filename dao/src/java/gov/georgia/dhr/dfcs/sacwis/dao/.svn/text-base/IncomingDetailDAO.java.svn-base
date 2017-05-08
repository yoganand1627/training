/**
 * Created on Mar 25, 2006 at 2:59:22 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.db.IncomingDetail;


/** Change History:
 **  Date        User              Description
 **  --------    ----------------  -------------------------------------------------------------------
 *   06/09/2011  Corey Harden      SMS#109631 findIncomingDetailProviderAllegByIdResource(int idResource)                         
 *                                 
 **/


public interface IncomingDetailDAO {
  
  List<Map> findIncomingDetailProviderAllegByIdResource(int idResource);
  /**
   * Retrieves DtIncomingCall given the idStage.
   *
   * @param idStage
   * @return Date
   */
  Date findIncomingDetailDtByIdStage(int idStage);

  /**
   * Retrieves DtIncomingCall given the idStage that is not the Intake IdStage.
   *
   * @param idStage
   * @return Date
   */
  IncomingDetail findIncomingDetailFromAnyIdStage(int idStage); 
  
  /**
   * Retrieves IncomingDetail given the idStage of Investigation
   * @param idStage
   * @return
   */
  IncomingDetail findIncomingDetailFromINVIdStage(int idStage) ;
  
  /**
   * Retrieves DtIncomingCall given the idCase.
   *
   * @param idCase
   * @return Date
   */
  Date findIncomingDetailDtByIdCase(int idCase);

  /**
   * Retrieves the earliest DtIncomingCall given the idCase
   * @param idCase
   * @return
   */
  Date findEarliestIncomingDetailDtByIdCase(int idCase);
  
  /**
   * Retrieves IncomingDetail given the idStage.
   *
   * @param idStage
   * @return IncomingDetail
   */
  IncomingDetail findIncomingDetailByIdStage(int idStage);
  
  /**
   * Getting Prior Intakes Given a Date with the disposition of Screened out and Screened out and
   *  Deferred given an idPerson 
   * @param idPerson
   * @param dtPriorInt
   * @return List<IncomingDetail>
   */
  public List<IncomingDetail> findPriorScreenedOutIncomingDtlsByidPerson(int idPerson, Date dtPriorInt);
  
  
/**
 * Getting Prior Intakes Given a Date with the disposition of Screened out and Screened out and
 *  Deferred given an idPersons
 * @param idPersons
 * @param dtPriorInt
 * @return List<IncomingDetail>
 */
  public List<Integer> findPriorScreenedOutIncomingDtlsByidPersons(List<Integer> idPersons, Date dtPriorInt);

  /**
   * Retrieves the earliest intake date. (Note that the select query is done using straight SQL)
   *
   * @param idStage
   * @return Date object
   */
  Object[] findDtIncomingCallIdPriorStageByIdStage(int idStage);

  /**
   * Retrieves IncomingDetail given idStage with some additional information.
   *
   * @param idStage
   * @return An array; the first element is a populated {@link gov.georgia.dhr.dfcs.sacwis.db.IncomingDetail} object;
   *         the second object is the date from the NOT event associated with the stage from the IncomingDetail record,
   *         and the third object is the cdEmpBjnEmp for the associated employee.
   */ 
  Object[] findIncomingDetailAndDtEventOccurred(int idStage);

  /**
   * Updates table IncomingDetail field IND_INCMG_INT_INV_CLS_RECLASS given idStage indirectly through StageLink.
   *
   * @param idStage
   * @param indIncmgIntInvClsReclass
   */
  int updateIncomingDetailIndIncmgIntInvClsReclassByIdStage(int idStage, String indIncmgIntInvClsReclass);

  /**
   * Updates table IncomingDetail field IND_INCMG_INT_INV_CLS_RECLASS given idStage
   *
   * @param idStage
   */
  int updateIncomingDetailIndIncmgIndIncmgIntInvClsReclassToY(int idStage);

  /**
   * Updates table IncomingDetail field IND_INCMG_INT_INV_CLS_RECLASS given idStage
   *
   * @param idStage
   */
  int updateIncomingDetailIndIncmgIndIncmgIntInvClsReclassToN(int idStage);

  /**
   * Inserts the entire row
   *
   * @param incomingDetail
   */
  void saveIncomingDetail(IncomingDetail incomingDetail);

  /**
   * Updates table IncomingDetail field idEvent given idStage
   *
   * @param idStage
   */
  int updateIncomingDetailIdEvent(int idStage);

  /**
   * Updates table IncomingDetail field cdIncmgStatus given idStage  and dtLastUpdate.
   * <p/>
   *
   * @param cdIncmgStatus
   * @param idStage
   * @param dtLastUpdate
   */
  int updateIncomingDetail(String cdIncmgStatus, int idStage, Date dtLastUpdate);
  
  
  /**
   * Updates the IncomingDetail field cdIncmgStatus give the idStage only. 
   * @param cdIncmgStatus
   * @param idStage
   * 
   */
  int updateIncomingDetailStatus(String cdIncmgStatus, int idStage);
  
  
  /**
   * Updates table IncomingDetail field cdIncmgStatus AND cdIncomingDisposition given idStage  and dtLastUpdate.
   * <p/>
   *
   * @param cdIncmgStatus
   * @param cdIncomingDisposition
   * @param idStage
   * @param dtLastUpdate
   */
  int updateIncomingDetailDisposition(String cdIncomingDisposition, int idStage, Date dtLastUpdate);
  
  /**
   * Updates table IncomingDetail field indIncmgMaltreatInCare
   * 
   * @param idStage
   * @param indIncmgMaltreatInCare
   * @return
   */
  int updateIncomingDtlMaltreatInCare(int idStage, String indIncmgMaltreatInCare);

  /**
   * Calls COMPLEX_DELETE.DELETE_INCOMING_DETAIL() to delete an incoming detail record.
   *
   * @param idStage
   * @return
   */
  int deleteIncomingDetail(int idStage);

  /**
   * Finds details about employees for the given stage ids.
   * <pre>
   * person.nmPersonFull as nmPersonFull
   * person.idPerson as idPerson
   * employeeJobHistory.cdJobBjn as cdJobBjn
   * mailCode.addrMailCodeStLn1 as addrMailCodeStLn1
   * mailCode.addrMailCodeStLn2 as addrMailCodeStLn2
   * mailCode.addrMailCodeCity as addrMailCodeCity
   * employee.cdEmployeeClass as cdEmployeeClass
   * employee.dtEmpLastAssigned as dtEmpLastAssigned
   * unit.nbrUnit as nbrUnit
   * unit.cdUnitRegion as cdUnitRegion
   * unit.idUnit as idUnit
   * unitEmployeeLink.cdUnitMemberRole as cdUnitMemberRole
   * office.nmOfficeName as nmOfficeName
   * mailCode.cdMailCode as cdMailCode
   * </pre>
   *
   * @param pageNbr
   * @param pageSize
   * @param idStage
   * @return A list of information about the employee; see description for keys and values.
   */
  PaginatedHibernateList<Map> findIncomingDetailByIdStage(int pageNbr, int pageSize, int idStage);

  /**
   * Retrieves stage ids .
   *
   * @param idPersons
   * @return List of the Stage ids.
   */
  public List<Integer> findIncomingDetailStageByIdPerson(Collection<Integer> idPersons);
  
  /**
   * 
   * @param nmFirst
   * @param nmLast
   * @return
   */
  public List<Integer> findIncomingDetailStageByNmFirstNmLast(String nmFirst, String nmLast);
  
  /**
   * Find incoming call date from the Intake that is associated with given Investigation stage. An Intake can be associated
   * with an Investigation in 2 ways: as progressed directly to Investigation or diverted to a Diversion and then referred 
   * back to Investigation.
   * @param idStage - Investigation
   * @return Intake date
   */
  public Date findDtIncomingCallByIdInvStage(int idStage);
  
  /**
   * Get the resource ID for the Incoming detail is also an Exchange Home
   * @param idStage
   * @return long 
   */
  Integer findIncomingDetailResourceIdIsInExchangeHome(int idStage);
}
