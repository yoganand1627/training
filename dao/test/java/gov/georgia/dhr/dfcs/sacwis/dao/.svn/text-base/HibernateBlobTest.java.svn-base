/**
 * Created on Apr 9, 2006 at 6:45:12 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.db.CapsCase;
import gov.georgia.dhr.dfcs.sacwis.db.ExtDocumentation;

import java.sql.Blob;
import java.util.Arrays;
import java.util.Random;

import junit.framework.Test;
import junit.framework.TestSuite;
import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

public class HibernateBlobTest extends BaseDAOTest {

  public HibernateBlobTest(String string) throws Exception {
    super(string);
  }

  public static Test suite() throws Exception {
    TestSuite suite = new TestSuite();
    suite.addTest(new HibernateBlobTest("testUnmappedBlob"));
    suite.addTest(new HibernateBlobTest("testMappedBlob"));
    return suite;
  }

  /**
   * This test was designed to figure out how Hibernate dealt with unmapped blob objects.
   *
   * @throws Exception
   */
  @SuppressWarnings({"unchecked"})
  public void testUnmappedBlob() throws Exception {
    Session session = getSession();
    SQLQuery insertRowQuery = session.createSQLQuery("INSERT INTO EXT_DOCUMENTATION " +
                                                     "          ( ID_EXT_DOCUMENTATION, " +
                                                     "            ID_CASE, " +
                                                     "            BL_EXT_DOC " +
                                                     "          ) " +
                                                     "     VALUES " +
                                                     "          ( :idExtDocumentation, " +
                                                     "            :idCase, " +
                                                     "            :blExtDoc " +
                                                     "          )");
    byte[] bytes = createBytes();
    int id = getBean(CommonDAO.class).getNextval("SEQ_EXT_DOCUMENTATION");
    insertRowQuery.setInteger("idExtDocumentation", id);
    insertRowQuery.setInteger("idCase", findAnyCaseId());
    insertRowQuery.setBinary("blExtDoc", bytes);
    insertRowQuery.executeUpdate();
    SQLQuery query = session.createSQLQuery("SELECT BL_EXT_DOC " +
                                            "  FROM EXT_DOCUMENTATION " +
                                            " WHERE ID_EXT_DOCUMENTATION = :idExtDocumentation");
    query.setInteger("idExtDocumentation", id);
    query.addScalar("BL_EXT_DOC", Hibernate.BLOB);
    Blob blob = (Blob) query.uniqueResult();
    long size = blob.length();
    if (size > Integer.MAX_VALUE) {
      throw new IllegalArgumentException("Blob too big");
    }
    // Note that we start with byte 1 because everything in SQL is 1-based, pretty much.
    byte[] blobBytes = blob.getBytes(1, (int) size);
    assertTrue("Binary data corrupted.", Arrays.equals(bytes, blobBytes));
  }

  /**
   * This test was designed to figure out how Hibernate dealt with mapped blob objects.
   *
   * @throws Exception
   */
  public void testMappedBlob() throws Exception {
    Session session = getSession();
    ExtDocumentation extDocumentation = new ExtDocumentation();
    int idCase = findAnyCaseId();
    extDocumentation.setCapsCase((CapsCase) session.load(CapsCase.class, idCase));
    byte[] bytes = createBytes();
    extDocumentation.setBlExtDoc(bytes);
    session.saveOrUpdate(extDocumentation);
    // Flush to force a write to the DB.
    session.flush();
    int id = extDocumentation.getIdExtDocumentation();
    Blob returnedBlob = getBean(ExtDocumentationDAO.class).findExtDoc(id);
    assertNotNull("Blob missing.", returnedBlob);
    long returnedBlobLength = returnedBlob.length();
    assertEquals("Binary data size mis-match.", returnedBlobLength, bytes.length);
    byte[] returnedBytes = returnedBlob.getBytes(1, (int) returnedBlobLength);
    assertTrue("Binary data corrupted.", Arrays.equals(bytes, returnedBytes));
  }

  private int findAnyCaseId() throws Exception {
    SQLQuery query = getSession().createSQLQuery("SELECT ID_CASE FROM CAPS_CASE WHERE ROWNUM < 2");
    return (Integer) query.addScalar("ID_CASE", Hibernate.INTEGER).uniqueResult();
  }

  private byte[] createBytes() {
    // Make this large enough that it will break Oracle's binary handling if it's a problem.
    byte[] bytes = new byte[2 * 1024 * 1024];
    new Random().nextBytes(bytes);
    return bytes;
  }

  private Session getSession() throws Exception {
    return getBean(SessionFactory.class).getCurrentSession();
  }

  @SuppressWarnings({"unchecked"})
  private <T> T getBean(Class<T> aClass) throws Exception {
    String name = aClass.getSimpleName();
    return ((T) getContext(contextKey()).getBean(name.substring(0, 1).toLowerCase() + name.substring(1), aClass));
  }
}