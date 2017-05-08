package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.Date;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.dao.PalPublicAssistDAO;
import gov.georgia.dhr.dfcs.sacwis.db.PalPublicAssist;
import org.hibernate.Query;

public class PalPublicAssistDAOImpl extends BaseDAOImpl implements PalPublicAssistDAO {
  @SuppressWarnings({"unchecked"})
  public List<PalPublicAssist> findPalPublicAssist(int idstage) {
    Query query = getSession().createQuery("select id.idPalPublicAssistStge," +
                                           "       id.cdPalPublicAssist," +
                                           "       dtLastUpdate" +
                                           " from PalPublicAssist" +
                                           " where id.idPalPublicAssistStge = :idstage");

    query.setInteger("idstage", idstage);
    return (List<PalPublicAssist>) query.list();
  }

  public void savePalPublicAssist(PalPublicAssist palPublicAssist) {
    getSession().saveOrUpdate(palPublicAssist);
  }

  public int deletePalPublicAssist(int idStage, String cdPalPublicAssist, Date dtLastUpdate) {
    Query query = getSession().createQuery("delete PalPublicAssist" +
                                           "  where id.idPalPublicAssistStge = :idStage" +
                                           "    and id.cdPalPublicAssist = :cdPalPublicAssist" +
                                           "    and dtLastUpdate = :dtLastUpdate");
    query.setInteger("idStage", idStage);
    query.setString("cdPalPublicAssist", cdPalPublicAssist);
    query.setTimestamp("dtLastUpdate", dtLastUpdate);
    return query.executeUpdate();
  }
}
