/**
 * Created on Apr 9, 2006 at 6:45:12 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import junit.framework.Test;
import junit.framework.TestSuite;

public class DynamicEventDAOTest extends BaseDAOTest {

  // Month in the GregorianCalendar constructor is 0-based.
  private static final Object[] REFERENCE_ROW_1 =
          new Object[] {"COMP", "ASG", "INT", new GregorianCalendar(1996, 4, 31).getTime(), "01", 10001, 2, 1,
                        "Cole,Misty", "Fogarty,Ian S", "Primary Assignment Issued For: Fogarty,Ian S", null, "N"};
  public static final Object[] REFERENCE_ROW_2 =
          new Object[] {"PEND", "CON", "INV", new GregorianCalendar(1996, 4, 31).getTime(), "64", 10001, 7, 2,
                        "Cole,Misty", "Fogarty,Ian S", "Contact - Assessment", "2180", "N"};

  public DynamicEventDAOTest(String string) throws Exception {
    super(string);
  }

  public static Test suite() throws Exception {
    TestSuite suite = new TestSuite();
    suite.addTest(new DynamicEventDAOTest("testNotEnoughInformation"));
    suite.addTest(new DynamicEventDAOTest("testPersonOnly"));
    suite.addTest(new DynamicEventDAOTest("testStageOnly"));
    suite.addTest(new DynamicEventDAOTest("testCaseOnly"));
    suite.addTest(new DynamicEventDAOTest("testAllParameters"));
    return suite;
  }

  public void testNotEnoughInformation() throws Exception {
    DynamicEventDAO dynamicEventDAO = (DynamicEventDAO) getContext(contextKey()).getBean("dynamicEventDAO");
    try {
      dynamicEventDAO.findEvents(false, 0, 0, 0, 0, 0, null, null, null, null, null, null);
      fail("Not enough information was provided for the above to execute.");
    } catch (ServiceException success) {
    }
  }

  public void testPersonOnly() throws Exception {
    DynamicEventDAO dynamicEventDAO = (DynamicEventDAO) getContext(contextKey()).getBean("dynamicEventDAO");
    List<Object[]> results = dynamicEventDAO.findEvents(true, 0, 0, 100001, 0, 0, null, null, null, null, null, null);
    assertNotNull(results);
    // This should produce at least 300 results
    assertTrue(results.size() > 300);
    Object[] row = results.get(0);
    assertEquals(REFERENCE_ROW_1.length, row.length);
    for (int i = 0; i < row.length; i++) {
      assertEquals(REFERENCE_ROW_1[i], row[i]);
    }
    try {
      dynamicEventDAO.findEvents(false, 0, 0, 100001, 0, 0, null, null, null, null, null, null);
      fail("Using person should require the extra tables.");
    } catch (ServiceException success) {
    }
  }

  public void testStageOnly() throws Exception {
    DynamicEventDAO dynamicEventDAO = (DynamicEventDAO) getContext(contextKey()).getBean("dynamicEventDAO");
    List<Object[]> results = dynamicEventDAO.findEvents(false, 0, 1, 0, 0, 0, null, null, null, null, null, null);
    assertNotNull(results);
    assertEquals(4, results.size());
    Object[] row = findReferenceRow1(results);
    assertNotNull("Failed to find expected row.", row);
    assertEquals(REFERENCE_ROW_1.length, row.length);
    for (int i = 0; i < row.length; i++) {
      assertEquals(REFERENCE_ROW_1[i], row[i]);
    }
  }

  public void testCaseOnly() throws Exception {
    DynamicEventDAO dynamicEventDAO = (DynamicEventDAO) getContext(contextKey()).getBean("dynamicEventDAO");
    List<Object[]> results = dynamicEventDAO.findEvents(false, 10001, 0, 0, 0, 0, null, null, null, null, null, null);
    assertNotNull(results);
    assertEquals(14, results.size());
    Object[] row = findReferenceRow1(results);
    assertNotNull("Failed to find expected row.", row);
    assertEquals(REFERENCE_ROW_1.length, row.length);
    for (int i = 0; i < row.length; i++) {
      assertEquals(REFERENCE_ROW_1[i], row[i]);
    }
  }

  private Object[] findReferenceRow1(List<Object[]> results) {
    Object[] row = null;
    for (Iterator<Object[]> it = results.iterator(); it.hasNext();) {
      Object[] tempRow = it.next();
      if ("Primary Assignment Issued For: Fogarty,Ian S".equals(tempRow[10])) {
        row = tempRow;
        break;
      }
    }
    return row;
  }

  public void testAllParameters() throws Exception {
    DynamicEventDAO dynamicEventDAO = (DynamicEventDAO) getContext(contextKey()).getBean("dynamicEventDAO");
    // Month is zero-based, so the months are 1 belwo what would be expected.
    Date dtScrDtStartDt = new GregorianCalendar(1996, 4, 30).getTime();
    Date dtScrDtEventEnd = new GregorianCalendar(1996, 5, 1).getTime();
    String[] status = {"COMP", "PEND"};
    List<Object[]> results = dynamicEventDAO.findEvents(true, 10001, 2, 4012273, 1, 100001, new String[] {"CON"},
                                                        new String[] {"INV"}, "2180", dtScrDtStartDt, dtScrDtEventEnd, status);
    assertNotNull("Results were null.", results);
    assertEquals("Results empty.", false, results.isEmpty());
    assertEquals("Results wrong size.", 1, results.size());
    Object[] row = results.get(0);
    assertNotNull("Failed to find expected row.", row);
    assertEquals(REFERENCE_ROW_2.length, row.length);
    for (int i = 0; i < row.length; i++) {
      assertEquals(REFERENCE_ROW_2[i], row[i]);
    }
  }
}
