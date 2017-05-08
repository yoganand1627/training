/**
 * Created on Mar 25, 2006 at 2:29:27 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.db.EmpOnCallLink;

public interface EmpOnCallLinkDAO {

  /**
   * Retrieves all rows from EmpOnCallLink table given a particular On Call Id
   * <p/>
   *
   * @param idOnCall
   * @param maxDate
   * @return List of Map's
   */
  @SuppressWarnings({"unchecked"})
  List<Map> findEmployeeOnCallLinkByIdOnCall(int idOnCall, Date maxDate);

  /**
   * Retrieves idOnCall from the OnCall table for the given idPerson and dtOnCallEnd. Returns the idOnCall from the
   * OnCall table where the idPerson has an on-call on the EmpOnCallLink table that has a date greater-than or equal to
   * the given dtOnCallEnd. (i.e., the idPerson still has future on-call status).
   *
   * @param idPerson
   * @param dtOnCallEnd
   * @return Integer
   */
  Integer findIdOnCallFromEmpOnCallLinkAndOnCallByIdPersonAndDtOnCallEnd(int idPerson, Date dtOnCallEnd);

  /**
   * Retrieves columns IdPerson,CdEmpOnCallDesig,NbrEmpOnCallPhone1, NbrEmpOnCallExt1, NbrEmpOnCallCntctOrd from the
   * EmpOnCallLink table; NmPersonFull from the Person table, DtEmpLastAssigned from the Employeetable;CdJobBjn from
   * theEmpJobHistory table; NmOfficeName from the Office table; IdUnit from the UnitEmpLink table; and NbrPersonPhone,
   * NbrPersonPhoneExtension the PersonPhone table for a  given. The output will be ORDERed BY NbrEmpOnCallCntctOrd
   * (from the EmpOnCallLink table). These columns are used for the ON_CALL_VIEW of the Available Staff ListBox on the
   * Assign window.
   *
   * @param idOnCall
   * @return List of Map objects, each Map encapsulating a row of columns retrieved by the query.
   */
  List<Map> findEmpOnCallLinkByIdOnCallAndOrderByNbrEmpOnCallCntctOrd(int idOnCall);

  /**
   * This is an  update/insert for EmpOnCallLink info.
   *
   * @param EmpOnCallLink
   */
  void saveEmpOnCallLink(EmpOnCallLink empOnCallLink);

  /**
   * Delete a {@link gov.georgia.dhr.dfcs.sacwis.db.EmpOnCallLink} object.
   *
   * @param empOnCallLink
   */
  void deleteEmpOnCallLink(EmpOnCallLink empOnCallLink);
  
  /**
   * Delete rows from EMP_ON_CALL_LINK by ID_ON_CALL
   *
   * @param idOnCall
   * @return
   */
  
  int deleteEmpOnCallLinkByIdEmpOnCallLink(int idEmpOnCallLink);
  
  /**
   * Deletes a single row from EMP_ON_CALL_LINK by ID_EMP_ON_CALL_LINK
   * @param idEmpOnCall
   * @return
   */


  int deleteEmpOnCallLinkByIdOnCall(int idOnCall);
  
  
  /**
  * Retrieves On Call IdPerson By SecurityClassNm
  * @param idPerson
  * @return
  */
  List<Integer> findOnCallIdEmpBySecurityClassNm(String cdCounty, String cdEmpSecurityClassNm,Date dtSysTsQuery);
  
  /**
   * Returns all entries in EmpOnCallLink for the given idOnCall, ordered by nbrEmpOnCallCntctOrd.
   * 
   * @param idOnCall
   * @return
   */
  List<EmpOnCallLink> findEmpOnCallLinkListByIdOnCall(int idOnCall);
}
