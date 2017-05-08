package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.DocumentTemplateDAO;

import org.hibernate.Query;

public class DocumentTemplateDAOImpl extends BaseDAOImpl implements DocumentTemplateDAO {

  public Integer retrieveDocumentTemplate(String document, int major, int minor, int revision) {
    Query query = getSession().createQuery("select idDocumentTemplate " +
                                           " from DocumentTemplate " +
                                           " where nbrMinorVersion = :nbrMinorVersion " +
                                           " and nbrMajorVersion = :nbrMajorVersion " +
                                           " and nbrRevision = :nbrRevision " +
                                           " and documentTemplateType = (select idDocumentTemplateType " +
                                           " from DocumentTemplateType where nmDocument = :nmDocument))");
    query.setInteger("nbrMinorVersion", minor);
    query.setInteger("nbrMajorVersion", major);
    query.setInteger("nbrRevision", revision);
    query.setString("nmDocument", document);
    return (Integer) query.uniqueResult();
  }

}
