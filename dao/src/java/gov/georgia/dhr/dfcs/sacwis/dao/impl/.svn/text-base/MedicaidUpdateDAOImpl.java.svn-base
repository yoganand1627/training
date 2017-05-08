package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.Date;

import gov.georgia.dhr.dfcs.sacwis.dao.MedicaidUpdateDAO;
import gov.georgia.dhr.dfcs.sacwis.db.MedicaidUpdate;
import org.hibernate.Query;

public class MedicaidUpdateDAOImpl extends BaseDAOImpl implements MedicaidUpdateDAO {
  public void saveMedicaidUpdate(MedicaidUpdate medicaidUpdate) {
    getSession().saveOrUpdate(medicaidUpdate);
  }

  public int insertMedicaidUpdate(Date tsLastUpdate, int idMedUpdPerson, int idMedUpdStage,
                                  int idMedUpdRecord, String cdMedUpdType, String cdMedUpdTransTypE) {
    Query query = getSession().createSQLQuery("INSERT INTO MEDICAID_UPDATE (ID_MED_UPD," +
                                              "                             DT_LAST_UPDATE," +
                                              "                             ID_MED_UPD_PERSON," +
                                              "                             ID_MED_UPD_STAGE," +
                                              "                             ID_MED_UPD_RECORD," +
                                              "                             CD_MED_UPD_TYPE," +
                                              "                             CD_MED_UPD_TRANS_TYPE) " +
                                              "                          VALUES(0, " +
                                              "                                 :tsLastUpdate, " +
                                              "                                 :idMedUpdPerson, " +
                                              "                                 :idMedUpdStage, " +
                                              "                                 :idMedUpdRecord, " +
                                              "                                 :cdMedUpdType, " +
                                              "                                 :cdMedUpdTransTypE) ");
    query.setTimestamp("tsLastUpdate", tsLastUpdate);
    query.setInteger("idMedUpdPerson", idMedUpdPerson);
    query.setInteger("idMedUpdStage", idMedUpdStage);
    query.setInteger("idMedUpdRecord", idMedUpdRecord);
    query.setString("cdMedUpdType", cdMedUpdType);
    query.setString("cdMedUpdTransTypE", cdMedUpdTransTypE);
    return query.executeUpdate();
  }
}
