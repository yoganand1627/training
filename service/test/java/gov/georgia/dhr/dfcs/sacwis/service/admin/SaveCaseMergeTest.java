package gov.georgia.dhr.dfcs.sacwis.service.admin;

import java.util.Iterator;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.dao.CaseMergeDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CaseMerge;
import gov.georgia.dhr.dfcs.sacwis.service.BaseServiceTest;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC41SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCFC41SIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCFC41SIG00_ARRAY;
import junit.framework.Test;
import junit.framework.TestSuite;

public class SaveCaseMergeTest extends BaseServiceTest {

  protected SaveCaseMerge saveCaseMerge = null;

  private CaseMergeDAO caseMergeDAO = null;

  public void setCaseMergeDAO(CaseMergeDAO caseMergeDAO) {
    this.caseMergeDAO = caseMergeDAO;
  }

  public SaveCaseMergeTest(String testName) {
    super(testName);
  }

  public void setSaveCaseMerge(SaveCaseMerge saveCaseMerge) {
    this.saveCaseMerge = saveCaseMerge;
  }

  public static Test suite() {
    TestSuite suite = new TestSuite();
    suite.addTest(new SaveCaseMergeTest("testSaveCaseMergeDelete"));
    suite.addTest(new SaveCaseMergeTest("testSaveCaseMergeSplit"));
    suite.addTest(new SaveCaseMergeTest("testSaveCaseMergeMerge"));
    return suite;
  }

  public void testSaveCaseMergeSplit() {
    CCFC41SI ccfc41si = new CCFC41SI();
    ROWCCFC41SIG00_ARRAY rowccfc41sig00_array = new ROWCCFC41SIG00_ARRAY();
    ROWCCFC41SIG00 rowccfc41sig00 = new ROWCCFC41SIG00();
    rowccfc41sig00.setSzCdScrDataAction(SaveCaseMerge.SPLIT);
    rowccfc41sig00.setDtDtCaseMerge(DateHelper.getTodayCastorDate());
    rowccfc41sig00.setDtCaseMergeSplit(DateHelper.getTodayCastorDate());
    rowccfc41sig00.setUlIdCaseMergeFrom(10234);
    rowccfc41sig00.setUlIdCaseMergePersMrg(5606983);
    rowccfc41sig00.setUlIdCaseMergePersSplit(5603092);
    rowccfc41sig00.setUlIdCaseMergeTo(10235);
    rowccfc41sig00.setCIndCaseMergeInv(ArchitectureConstants.Y);
    rowccfc41sig00_array.addROWCCFC41SIG00(rowccfc41sig00);
    ccfc41si.setROWCCFC41SIG00_ARRAY(rowccfc41sig00_array);
    saveCaseMerge.saveCaseMerge(ccfc41si);
  }

  public void testSaveCaseMergeMerge() {
    CCFC41SI ccfc41si = new CCFC41SI();
    ROWCCFC41SIG00_ARRAY rowccfc41sig00_array = new ROWCCFC41SIG00_ARRAY();
    ROWCCFC41SIG00 rowccfc41sig00 = new ROWCCFC41SIG00();
    rowccfc41sig00.setSzCdScrDataAction(SaveCaseMerge.MERGE);
    rowccfc41sig00.setDtDtCaseMerge(DateHelper.getTodayCastorDate());
    rowccfc41sig00.setDtCaseMergeSplit(DateHelper.getTodayCastorDate());
    rowccfc41sig00.setUlIdCaseMergeFrom(5606099);
    rowccfc41sig00.setUlIdCaseMergePersMrg(5500150);
    rowccfc41sig00.setUlIdCaseMergePersSplit(5603092);
    rowccfc41sig00.setUlIdCaseMergeTo(5500034);
    rowccfc41sig00.setCIndCaseMergeInv(ArchitectureConstants.Y);
    rowccfc41sig00_array.addROWCCFC41SIG00(rowccfc41sig00);
    ccfc41si.setROWCCFC41SIG00_ARRAY(rowccfc41sig00_array);
    saveCaseMerge.saveCaseMerge(ccfc41si);
  }

  public void testSaveCaseMergeDelete() {
    CCFC41SI ccfc41si = new CCFC41SI();
    ROWCCFC41SIG00_ARRAY rowccfc41sig00_array = new ROWCCFC41SIG00_ARRAY();
    List<CaseMerge> caseMergeList = caseMergeDAO.findByIdCaseMergeTo(10177);
    for (Iterator<CaseMerge> it = caseMergeList.iterator(); it.hasNext();) {
      CaseMerge caseMerge = it.next();
      ROWCCFC41SIG00 rowccfc41sig00 = new ROWCCFC41SIG00();
      rowccfc41sig00.setSzCdScrDataAction("not split or merge");
      rowccfc41sig00.setUlIdCaseMerge(caseMerge.getIdCaseMerge());
      rowccfc41sig00.setTsLastUpdate(caseMerge.getDtLastUpdate());
      rowccfc41sig00_array.addROWCCFC41SIG00(rowccfc41sig00);
    }
    ccfc41si.setROWCCFC41SIG00_ARRAY(rowccfc41sig00_array);
    saveCaseMerge.saveCaseMerge(ccfc41si);
  }
}
