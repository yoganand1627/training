package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.SiblingExternalLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.SiblingExternalLink;

import java.util.List;

import org.hibernate.Query;

public class SiblingExternalLinkDAOImpl extends BaseDAOImpl implements SiblingExternalLinkDAO {
  @SuppressWarnings({"unchecked"})
  public List<SiblingExternalLink> findSiblingExternalLinksByIdStage(int idStage) {
    Query query = getSession().createQuery("     from SiblingExternalLink sel "
                                           + " where sel.stage.idStage = :idStage ");
    query.setInteger("idStage", (Integer) idStage);
    return (List<SiblingExternalLink>) query.list();
  }

  @SuppressWarnings({"unchecked"})
  public List<SiblingExternalLink> findSiblingExternalLinksByIdSiblingGroup(int idSiblingGroup) {
    Query query = getSession().createQuery("     from SiblingExternalLink sel "
                                           + " where sel.id.siblingGroup.idSiblingGroup = :idSiblingGroup ");
    query.setInteger("idSiblingGroup", (Integer) idSiblingGroup);
    return (List<SiblingExternalLink>) query.list();
  }

  public void saveSiblingExternalLink(SiblingExternalLink siblingExternalLink) {
    getSession().saveOrUpdate(siblingExternalLink);

  }

  public int deleteAllSiblingExternalLinkByIdSiblingGroup(int idSiblingGroup) {
    Query query = getSession().createQuery("delete from SiblingExternalLink " + 
                                           "      where id.siblingGroup.idSiblingGroup = :idSiblingGroup ");
    query.setInteger("idSiblingGroup", (Integer) idSiblingGroup);
    return query.executeUpdate();
  }

  public int deleteAllSiblingExternalLinkByIdStage(int idStage) {
    Query query = getSession().createQuery("delete from SiblingExternalLink " + 
                                           "      where stage.idStage = :idStage ");
    query.setInteger("idStage", (Integer) idStage);
    return query.executeUpdate();
  }

  public void deleteSiblingExternalLink(SiblingExternalLink siblingExternalLink) {
    getSession().delete(siblingExternalLink);
  }

  public int updateSiblingExternalLinkWithPersonForward(int idPersMergeForward, int idPersMergeClosed) {
    Query query = getSession().createQuery(
                                           "update SiblingExternalLink set id.person.idPerson = :idPersMergeForward "
                                                           + " where id.person.idPerson =  :idPersMergeClosed");
    query.setInteger("idPersMergeForward", (Integer) idPersMergeForward);
    query.setInteger("idPersMergeClosed", (Integer) idPersMergeClosed);
    return query.executeUpdate();
  }

}
