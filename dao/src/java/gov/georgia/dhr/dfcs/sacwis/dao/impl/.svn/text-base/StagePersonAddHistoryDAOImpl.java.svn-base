/**
 * Created on August 21, 2011 by Seung-eun (Caroline) Choi
 */
package gov.georgia.dhr.dfcs.sacwis.dao.impl;

/**Change History:
 * Date        User              Description
 * --------    ----------------  --------------------------------------------------
 * 08/24/2011  schoi             STGAP00017013: MR-095 Initial Creation
 * 09/07/2011  schoi             STGAP00017013: MR-095 Added new method insertStagePersonAddHistoryAddedFromAddPersonToActiveStages
 * 10/10/2011  schoi             STGAP00017013: MR-095 Added new method deleteStagePersonAddHistoryByIdPerson for Person Merge Split logic change
 * 10/21/2011  schoi             STGAP00017013: MR-095 Added new method deleteStagePersonAddHistoryByIdPersonByIdFromStage 
 *                               to delete record from STAGE_PERSON_ADD_HISTORY table after the person delete is successfully executed
 */

import java.util.List;
import java.util.Date;

import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonAddHistoryDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.impl.BaseDAOImpl;
import gov.georgia.dhr.dfcs.sacwis.db.StagePersonAddHistory;
import org.hibernate.Query;
import org.hibernate.SQLQuery;

public class StagePersonAddHistoryDAOImpl extends BaseDAOImpl implements StagePersonAddHistoryDAO {
  @SuppressWarnings( { "unchecked" })
  public List<StagePersonAddHistory> findStagePersonAddHistorybyIdStageIdPerson(int idStage, int idPerson) {
    Query query = getSession().createQuery(
                                           " from  StagePersonAddHistory s "
                                                           + " where s.stageByIdFromStage.idStage = :idStage "
                                                           + " and s.person.idPerson = :idPerson ");
    query.setInteger("idStage", idStage);
    query.setInteger("idPerson", idPerson);
    return (List<StagePersonAddHistory>) query.list();
  }

  public int insertStagePersonAddHistoryAddedFromAddPersonToActiveStages(int idFromStage, int idToStage, int idCase,
                                                                         int idPerson, String cdStagePersType,
                                                                         String cdStagePersRelInt, Date dtAdded) {
    SQLQuery query = getSession()
                                 .createSQLQuery(
                                                 "INSERT INTO STAGE_PERSON_ADD_HISTORY (ID_FROM_STAGE, "
                                                                 + "                               ID_TO_STAGE, "
                                                                 + "                               ID_CASE, "
                                                                 + "                               ID_PERSON, "
                                                                 + "                               CD_STAGE_PERS_TYPE, "
                                                                 + "                               CD_STAGE_PERS_REL_INT, "
                                                                 + "                               DT_ADDED, "
                                                                 + "                               ID_STAGE_PERSON_ADD_HISTORY ) "
                                                                 + "                        VALUES(:idFromStage, "
                                                                 + "                               :idToStage, "
                                                                 + "                               :idCase, "
                                                                 + "                               :idPerson, "
                                                                 + "                               :cdStagePersType, "
                                                                 + "                               :cdStagePersRelInt, "
                                                                 + "                               :dtAdded, "
                                                                 + "                               SEQ_STAGE_PERSON_ADD_HISTORY.NEXTVAL )");
    query.setInteger("idFromStage", idFromStage);
    query.setInteger("idToStage", idToStage);
    query.setInteger("idCase", idCase);
    query.setInteger("idPerson", idPerson);
    query.setString("cdStagePersType", cdStagePersType);
    query.setString("cdStagePersRelInt", cdStagePersRelInt);
    query.setTimestamp("dtAdded", dtAdded);
    return query.executeUpdate();
  }
  
  @SuppressWarnings( { "unchecked" })
  public void saveStagePersonAddHistory(StagePersonAddHistory stagePersonAddHistory) {
    getSession().saveOrUpdate(stagePersonAddHistory);
  }
  
  @SuppressWarnings( { "unchecked" })
  // Delete StagePersonAddHistory by idPerson where stageByIdFromStage(s) is not closed
  public int deleteStagePersonAddHistoryByIdPerson(int idPerson) {
    Query query = getSession()
                              .createQuery(
                                           "delete StagePersonAddHistory s "
                                                           + " where s.person.idPerson = :idPerson "
                                                           + " and s.stageByIdFromStage.idStage in "
                                                           + " ( select st.idStage from Stage st "
                                                           + " where (st.dtStageClose is null " +
                                           "        or trunc(st.dtStageClose) = to_Date('12/31/4712', 'mm/dd/yyyy'))) ");
    query.setInteger("idPerson", idPerson);
    return query.executeUpdate();
  }

  @SuppressWarnings( { "unchecked" })
  // Delete StagePersonAddHistory by idPerson and idFromStage
  public int deleteStagePersonAddHistoryByIdPersonByIdFromStage(int idPerson, int idFromStage) {
    Query query = getSession()
                              .createQuery(
                                           "delete StagePersonAddHistory s "
                                                           + " where s.person.idPerson = :idPerson "
                                                           + " and s.stageByIdFromStage.idStage = :idFromStage ");
    query.setInteger("idPerson", idPerson);
    query.setInteger("idFromStage", idFromStage);
    return query.executeUpdate();
  }
}
