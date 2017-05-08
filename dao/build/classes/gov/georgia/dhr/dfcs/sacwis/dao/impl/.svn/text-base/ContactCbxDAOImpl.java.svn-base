package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.ContactCbxDAO;
import gov.georgia.dhr.dfcs.sacwis.db.ContactCbx;

import java.util.List;

import org.hibernate.Query;

public class ContactCbxDAOImpl extends BaseDAOImpl implements ContactCbxDAO {
  
  @SuppressWarnings("unchecked")
  public List<ContactCbx> findContactCbx(int idContactEvent) {
    Query query = getSession().createQuery(" from ContactCbx cbx " +
                                           "where cbx.contact.idEvent = :idContactEvent");
    query.setInteger("idContactEvent", idContactEvent);
    return (List<ContactCbx>) query.list();
  }

  public void saveContactCbx(ContactCbx contactCbx) {
    getSession().saveOrUpdate(contactCbx);
  }
  
  public int deleteContactCbx(int idContactEvent, String codeType, String cbxCode) {
    Query query = getSession().createQuery("delete from ContactCbx cbx " +
                                           "where cbx.contact.idEvent = :idContactEvent " +
                                           "and cbx.cdCbxCodeType = :codeType " +
                                           "and cbx.cdContactCbx = :cbxCode");
    query.setInteger("idContactEvent", idContactEvent);
    query.setString("codeType", codeType);
    query.setString("cbxCode", cbxCode);
    return query.executeUpdate();
  }

  public int deleteContactCbxByIdContactEvent(int idContactEvent) {
    Query query = getSession().createQuery("delete from ContactCbx cbx " +
                                           "where cbx.contact.idEvent = :idContactEvent");
    query.setInteger("idContactEvent", idContactEvent);
    return query.executeUpdate();
  }
  
  @SuppressWarnings("unchecked")
  public List<String> findContactCbxByIdEventAndCodeType(int idContactEvent, String codeType) {
    Query query = getSession().createQuery("select cbx.cdContactCbx from ContactCbx cbx " +
                                           "where cbx.contact.idEvent = :idContactEvent " +
                                           "and cbx.cdCbxCodeType = :codeType");
    query.setInteger("idContactEvent", idContactEvent);
    query.setString("codeType", codeType);
    return (List<String>) query.list();
  }

}
