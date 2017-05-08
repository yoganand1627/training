package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.dao.CapsCaretakerDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CapsCaretaker;
import org.hibernate.Query;

public class CapsCaretakerDAOImpl extends BaseDAOImpl implements CapsCaretakerDAO {
  @SuppressWarnings({"unchecked"})
  public List<Map> findCapsCaretakerByIdResource(int idResource) {
    Query query = getSession().createQuery("select new map(cc.capsResource.idResource as idResource, " +
                                           "               cc.idCaretaker as idCaretaker, " +
                                           "               cc.nbrCaretkr as nbrCaretkr," +
                                           "               cc.nmCaretkrFname as nmCaretkrFname, " +
                                           "               cc.nmCaretkrLname as nmCaretkrLname, " +
                                           "               cc.nmCaretkrMname as nmCaretkrMname, " +
                                           "               cc.cdCaretkrEthnic as cdCaretkrEthnic, " +
                                           "               cc.cdCaretkrRace as cdCaretkrRace, " +
                                           "               cc.cdCaretkrSex as cdCaretkrSex, " +
                                           "               cc.dtCaretkrBirth as dtCaretkrBirth, " +
                                           "               cc.capsResource.cdRsrcMaritalStatus as cdRsrcMaritalStatus," +
                                           "               cc.dtEnd as dtEnd ) " +
                                           "               from CapsCaretaker cc " +
                                           "               where cc.capsResource.idResource = :idResource " +
                                           "               order by dtEnd desc " );
    query.setInteger("idResource", idResource);
    return (List<Map>) query.list();
  }

  public int updateCapsCaretaker(int idCaretaker, String nmCaretkrFname, String nmCaretkrMname, String nmCaretkrLname,
                                 String cdCaretkrSex, Date dtCaretkrBirth, String cdCaretkrEthnic,
                                 String cdCaretkrRace) {
    Query query = getSession().createQuery("update CapsCaretaker " +
                                           "   set nmCaretkrFname = :nmCaretkrFname, " +
                                           "       nmCaretkrMname = :nmCaretkrMname, " +
                                           "       nmCaretkrLname = :nmCaretkrLname, " +
                                           "       cdCaretkrSex = :cdCaretkrSex, " +
                                           "       dtCaretkrBirth = :dtCaretkrBirth, " +
                                           "       cdCaretkrEthnic= :cdCaretkrEthnic, " +
                                           "       cdCaretkrRace = :cdCaretkrRace " +
                                           " where idCaretaker = :idCaretaker");
    query.setInteger("idCaretaker", idCaretaker);
    query.setString("nmCaretkrFname", nmCaretkrFname);
    query.setString("nmCaretkrMname", nmCaretkrMname);
    query.setString("nmCaretkrLname", nmCaretkrLname);
    query.setString("cdCaretkrSex", cdCaretkrSex);
    query.setTimestamp("dtCaretkrBirth", dtCaretkrBirth);
    query.setString("cdCaretkrEthnic", cdCaretkrEthnic);
    query.setString("cdCaretkrRace", cdCaretkrRace);
    return query.executeUpdate();
  }

  public void saveCapsCaretaker(CapsCaretaker capsCaretaker) {
    getSession().saveOrUpdate(capsCaretaker);
  }

  public int deleteCapsCaretaker(int idCaretaker) {
    Query query = getSession().createQuery("delete CapsCaretaker " +
                                           " where idCaretaker = :idCaretaker");
    query.setInteger("idCaretaker", idCaretaker);
    return query.executeUpdate();
  }
}
