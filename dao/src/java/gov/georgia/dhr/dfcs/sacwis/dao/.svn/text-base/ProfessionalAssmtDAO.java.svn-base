/**
 * Created on Mar 25, 2006 at 3:20:07 PM by Michael K. Werle
 */
/**
 * 
 * <pre>
 *   Change History:
 *   Date         User                     Description
 *   ----------   -------------------      ---------------------------------------------------------
 *   02/24/2011   hnguyen                  Added change history.
 *   02/24/2011   hnguyen                  SMS#97850: MR-075 Added method findProfessionalAssmtByIdPersonByCdProfAssmtApptRsn.
 *   03/27/2011   hnguyen                  SMS#97850: MR-075 Added method findProfessionalAssmtByIdPersonByCdProfAssmtApptRsns.
 *   
 * </pre>
 * 
 */

package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.db.ProfessionalAssmt;

public interface ProfessionalAssmtDAO {
  /**
   * Retrieves ProfessionalAssmt by idEvent
   *
   * @param idEvent
   * @return
   */
  ProfessionalAssmt findProfessionalAssmtByIdEvent(int idEvent);

  /**
   * Retrieves list of ProfessionalAssmt for a person
   *
   * @param idPerson
   * @return List<ProfessionalAssmt>
   */
  List<ProfessionalAssmt> findProfessionalAssmtByIdCaseByIdPersonPrincipal(int idCase, int idPerson) ;
  
  /**
   * Retrieves the latest visit date for a specific type of reason for a person within a case 
   *
   * @param idCase
   * @param idPerson
   * @param cdProfAssmtApptRsns
   * @return ProfessionalAssmt
   */
  ProfessionalAssmt findLastProfessionalAssmtByIdPersonByIdCaseByCdProfAssmtApptRsns(int idCase, int idPerson,
                                                                                     Collection<String> cdProfAssmtApptRsns);
  
  /**
   * Retrieves all the reasons for a person within a case order by latest visit
   *
   * @param idCase
   * @param idPerson
   * @param cdProfAssmtApptRsns
   * @return List<ProfessionalAssmt>
   */
  List<ProfessionalAssmt> findLastProfessionalAssmtByIdPersonByIdCaseByCdProfAssmtApptRsnsList(int idCase, int idPerson,
                                                                                               Collection<String> cdProfAssmtApptRsns);

  /**
   * Retrieves the latest visit date for a specific type of reason type for a person within a case 
   *
   * @param idCase
   * @param idPerson
   * @param cdProfAssmtApptRsn
   * @return ProfessionalAssmt
   */
  ProfessionalAssmt findProfessionalAssmtByIdPersonByIdCaseByCdProfAssmtApptRsn(int idCase, int idPerson,
                                                                                 String cdProfAssmtApptRsn);
  
  /**
   * Retrieves the latest visit date for a specific type of reason type for a person
   *
   * @param idPerson
   * @param cdProfAssmtApptRsn
   * @return ProfessionalAssmt
   */
  ProfessionalAssmt findProfessionalAssmtByIdPersonByCdProfAssmtApptRsn(int idPerson,
                                                                                 String cdProfAssmtApptRsn);
  
  /**
   * Retrieves the latest visit date for the listed reason types for a person
   *
   * @param idPerson
   * @param cdProfAssmtApptRsns
   * @return ProfessionalAssmt
   */
  ProfessionalAssmt findProfessionalAssmtByIdPersonByCdProfAssmtApptRsns(int idPerson,
                                                                         Collection<String> cdProfAssmtApptRsns);
  
  /**
   * Saves a {@link gov.georgia.dhr.dfcs.sacwis.db.ProfessionalAssmt} object to the database.
   *
   * @param professionalAssmt A populated {@link gov.georgia.dhr.dfcs.sacwis.db.ProfessionalAssmt} object.
   */
  void saveProfessionalAssmt(ProfessionalAssmt professionalAssmt);

}
