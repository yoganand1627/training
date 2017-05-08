package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.Date;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.dao.AllegEvidenceDAO;
import gov.georgia.dhr.dfcs.sacwis.db.AllegEvidence;
import org.hibernate.Query;

public class AllegEvidenceDAOImpl extends BaseDAOImpl implements AllegEvidenceDAO {

  @SuppressWarnings({"unchecked"})
  public List<AllegEvidence> findAllegEvidenceByIdAllegation(int idAllegation) {
    Query query = getSession().createQuery("from AllegEvidence " +
                                           "where allegation.idAllegation = :idAllegation");
    query.setInteger("idAllegation", idAllegation);
    return (List<AllegEvidence>) query.list();
  }

  public void saveAllegEvidence(AllegEvidence allegEvidence) {
    getSession().saveOrUpdate(allegEvidence);
  }

  public int deleteAllegEvidence(int idAllegEvidence, Date dtLastUpdate) {
    Query query = getSession().createQuery(
            "delete AllegEvidence " +
            " where idAllegEvidence = :idAllegEvidence " +
            "   and dtLastUpdate = :dtLastUpdate");
    query.setInteger("idAllegEvidence", idAllegEvidence);
    query.setTimestamp("dtLastUpdate", dtLastUpdate);
    return query.executeUpdate();
  }

}
