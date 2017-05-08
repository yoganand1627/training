package gov.georgia.dhr.dfcs.sacwis.service.security;

import junit.framework.Test;
import junit.framework.TestSuite;
import java.util.Date;

import java.util.GregorianCalendar;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import gov.georgia.dhr.dfcs.sacwis.service.BaseServiceTest;
import gov.georgia.dhr.dfcs.sacwis.service.security.SaveSecurityClass;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CARC13SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCARC13SIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCARC13SIG00_ARRAY;

public class SaveSecurityClassTest extends BaseServiceTest {
  protected SaveSecurityClass saveSecurityClass = null;

  public SaveSecurityClassTest(String testName) {
    super(testName);
  }

  public void setSaveSecurityClass(SaveSecurityClass saveSecurityClass) {
    this.saveSecurityClass = saveSecurityClass;
  }

  public static Test suite() {
    TestSuite suite = new TestSuite();
    suite.addTest(new SaveSecurityClassTest("testSaveSecurityClass_ADD"));
    suite.addTest(new SaveSecurityClassTest("testSaveSecurityClass_UPDATE"));
    suite.addTest(new SaveSecurityClassTest("testSaveSecurityClass_DELETE"));
    return suite;
  }

  public void testSaveSecurityClass_ADD() {
    CARC13SI carc13si = new CARC13SI();
    ROWCARC13SIG00_ARRAY rowcarc13sig00_array = new ROWCARC13SIG00_ARRAY();
    ROWCARC13SIG00 rowcarc13sig00 = new ROWCARC13SIG00();
    rowcarc13sig00.setSzNmSecurityClass("TEST");
    rowcarc13sig00.setSzCdSysDataActionOutcome(ServiceConstants.REQ_FUNC_CD_ADD);
    rowcarc13sig00.setSzTxtSecurityClassProfil("11110000");
    rowcarc13sig00.setSzCdEmpSecurityClassNm("TEST");
    rowcarc13sig00.setCIndRestrict("N");
    rowcarc13sig00.setTsLastUpdate(DateHelper.toJavaDate(DateHelper.getTodayCastorDate()));
    rowcarc13sig00_array.addROWCARC13SIG00(rowcarc13sig00);
    carc13si.setROWCARC13SIG00_ARRAY(rowcarc13sig00_array);
    saveSecurityClass.saveSecurityClass(carc13si);
  }

  // use existing object to test
  public void testSaveSecurityClass_UPDATE() {
    CARC13SI carc13si = new CARC13SI();
    ROWCARC13SIG00_ARRAY rowcarc13sig00_array = new ROWCARC13SIG00_ARRAY();
    ROWCARC13SIG00 rowcarc13sig00 = new ROWCARC13SIG00();
    rowcarc13sig00.setSzCdSysDataActionOutcome(ServiceConstants.REQ_FUNC_CD_UPDATE);

    SqlRowSet row = jdbcTemplate
                                .queryForRowSet("select CD_SECURITY_CLASS_NAME, DT_LAST_UPDATE, TXT_SECURITY_CLASS_PROFIL, IND_RESTRICT from security_class sc where sc.CD_SECURITY_CLASS_NAME = 'ALL'");
    if (row.first()) {
      rowcarc13sig00.setSzNmSecurityClass(row.getString(1));
      Date dtLastUpdate = new GregorianCalendar(2004, 3, 5, 4, 49, 44).getTime();
      rowcarc13sig00.setTsLastUpdate(dtLastUpdate);
      rowcarc13sig00.setSzTxtSecurityClassProfil(row.getString(3));
      rowcarc13sig00.setSzCdEmpSecurityClassNm(row.getString(1));
      rowcarc13sig00.setCIndRestrict(row.getString(4));
      rowcarc13sig00_array.addROWCARC13SIG00(rowcarc13sig00);
      carc13si.setROWCARC13SIG00_ARRAY(rowcarc13sig00_array);
      saveSecurityClass.saveSecurityClass(carc13si);
    }
  }

  // use existing object to test
  public void testSaveSecurityClass_DELETE() {
    CARC13SI carc13si = new CARC13SI();
    ROWCARC13SIG00_ARRAY rowcarc13sig00_array = new ROWCARC13SIG00_ARRAY();
    ROWCARC13SIG00 rowcarc13sig00 = new ROWCARC13SIG00();
    rowcarc13sig00.setSzCdSysDataActionOutcome(ServiceConstants.REQ_FUNC_CD_DELETE);
    SqlRowSet row = jdbcTemplate
                                .queryForRowSet("select CD_SECURITY_CLASS_NAME, DT_LAST_UPDATE, TXT_SECURITY_CLASS_PROFIL, IND_RESTRICT from security_class sc where sc.CD_SECURITY_CLASS_NAME = 'ALL'");
    if (row.first()) {
      rowcarc13sig00.setSzNmSecurityClass(row.getString(1));
      Date dtLastUpdate = new GregorianCalendar(2004, 3, 5, 4, 49, 44).getTime();
      rowcarc13sig00.setTsLastUpdate(dtLastUpdate);
      rowcarc13sig00.setSzTxtSecurityClassProfil(row.getString(3));
      rowcarc13sig00.setSzCdEmpSecurityClassNm(row.getString(1));
      rowcarc13sig00.setCIndRestrict(row.getString(4));
      rowcarc13sig00_array.addROWCARC13SIG00(rowcarc13sig00);
      carc13si.setROWCARC13SIG00_ARRAY(rowcarc13sig00_array);
      saveSecurityClass.saveSecurityClass(carc13si);
    }
  }

}

