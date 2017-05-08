package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.AdminAllegationDAO;
import org.hibernate.SQLQuery;

/**
 * Change History:
*  Date      User      Description
*  --------  --------  --------------------------------------------------
* 09/16/2009  bgehlot  STGAP00015366: Removed the idPerson in the where clause of method insertAdminAllegation
* <pre>
*/

public class AdminAllegationDAOImpl extends BaseDAOImpl implements AdminAllegationDAO {
  public int insertAdminAllegation(int idAdminAllegARStage, String indAdminAllegPrior,
                                   int idStage, int idPerson) {
    SQLQuery query = getSession().createSQLQuery("INSERT INTO ADMIN_ALLEGATION (" +
                                                 "         ID_ADMIN_ALLEG_STAGE," +
                                                 "         ID_ADMIN_ALLEG_VICTIM," +
                                                 "         ID_ADMIN_ALLEG_PERPETRATR," +
                                                 "         CD_ADMIN_ALLEG_DISPOSTIION," +
                                                 "         CD_ADMIN_ALLEG_INCDNT_STG," +
                                                 "         CD_ADMIN_ALLEG_SEVERITY," +
                                                 "         CD_ADMIN_ALLEG_TYPE," +
                                                 "         TXT_ADMIN_ALLEG_DURATION," +
                                                 "         ID_ADMIN_ALLEG_AR_STAGE," +
                                                 "         IND_ADMIN_ALLEG_PRIOR)" +
                                                 "       SELECT  ID_ALLEGATION_STAGE," +
                                                 "        ID_VICTIM," +
                                                 "       ID_ALLEGED_PERPETRATOR," +
                                                 "        CD_ALLEG_DISPOSITION," +
                                                 "        CD_ALLEG_INCIDENT_STAGE," +
                                                 "        CD_ALLEG_SEVERITY," +
                                                 "        CD_ALLEG_TYPE," +
                                                 "        TXT_ALLEG_DURATION," +
                                                 "        :idAdminAllegARStage," +
                                                 "        :indAdminAllegPrior" +
                                                 "        FROM   ALLEGATION A" +
                                                 " WHERE  ID_ALLEGATION_STAGE    = :idStage");

    query.setInteger("idAdminAllegARStage", idAdminAllegARStage);
    query.setString("indAdminAllegPrior", indAdminAllegPrior);
    query.setInteger("idStage", idStage);
    return query.executeUpdate();
  }
}
