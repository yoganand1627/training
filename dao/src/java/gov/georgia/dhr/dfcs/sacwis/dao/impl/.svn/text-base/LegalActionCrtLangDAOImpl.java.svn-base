package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.List;

import org.hibernate.Query;

import gov.georgia.dhr.dfcs.sacwis.dao.LegalActionCrtLangDAO;
import gov.georgia.dhr.dfcs.sacwis.db.LegalActionCrtLang;

public class LegalActionCrtLangDAOImpl extends BaseDAOImpl implements LegalActionCrtLangDAO {

  public void saveCourtLanguage(LegalActionCrtLang lacl) {
    getSession().saveOrUpdate(lacl);
  }
  
  public void deleteCourtLanguage(LegalActionCrtLang lacl) {
    getSession().delete(lacl);
  }
  
  public int deleteCourtLanguage(int idLegalActEvent, String cdCrtLang) {
    Query query = getSession().createQuery("delete from LegalActionCrtLang lacl "
                                           + "where lacl.legalAction.idLegalActEvent = :idLegalActEvent "
                                           + "and lacl.cdCrtLang = :cdCrtLang");
    query.setInteger("idLegalActEvent", idLegalActEvent);
    query.setString("cdCrtLang", cdCrtLang);
    return query.executeUpdate();
  }
  
  @SuppressWarnings({"unchecked"})
  public List<LegalActionCrtLang> findLegalActionCrtLangList(int idLegalActEvent) {
    Query query = getSession().createQuery("from LegalActionCrtLang lacl "
                                           + "where lacl.legalAction.idLegalActEvent = :idLegalActEvent");
    query.setInteger("idLegalActEvent", idLegalActEvent);
    return (List<LegalActionCrtLang>) query.list();
  }

}
