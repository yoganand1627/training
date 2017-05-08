/**
 * Created on Mar 25, 2006 at 2:15:39 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.db.CapsCaretaker;

public interface CapsCaretakerDAO {
  /**
   * Retrieves the info on Care taker from CapsCareTaker table.
   *
   * @param idResource
   * @return keys  idResource, idCaretaker, nbrCaretkr, nmCaretkrFname, nmCaretkrLname, nmCaretkrMname, cdCaretkrEthnic,
   *         cdCaretkrRace, cdCaretkrSex, dtCaretkrBirth, cdRsrcMaritalStatus
   */
  @SuppressWarnings({"unchecked"})
  List<Map> findCapsCaretakerByIdResource(int idResource);

  /**
   * This updates a row in the CapsCaretaker table w/o checking dtLastUpdate.
   *
   * @param idCaretaker
   * @param nmCaretkrFname
   * @param nmCaretkrMname
   * @param nmCaretkrLname
   * @param cdCaretkrSex
   * @param dtCaretkrBirth
   * @param cdCaretkrEthnic
   * @param cdCaretkrRace
   * @return The number of rows updated.
   */
  int updateCapsCaretaker(int idCaretaker, String nmCaretkrFname, String nmCaretkrMname, String nmCaretkrLname,
                          String cdCaretkrSex, Date dtCaretkrBirth, String cdCaretkrEthnic, String cdCaretkrRace);

  /**
   * This is an  update/insert for care taker info.
   *
   * @param capsCaretaker
   */

  void saveCapsCaretaker(CapsCaretaker capsCaretaker);

  /**
   * Delete a {@link gov.georgia.dhr.dfcs.sacwis.db.CapsCaretaker} object without checking dtLastUpdate.
   *
   * @param idCaretaker
   */
  int deleteCapsCaretaker(int idCaretaker);
}
