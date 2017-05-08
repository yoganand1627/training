package gov.georgia.dhr.dfcs.sacwis.service.admin;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.service.BaseServiceTest;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CARC17SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCARC18SIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCARC18SIG00_ARRAY_CARC17SI;
import junit.framework.Test;
import junit.framework.TestSuite;

public class SaveDesigneesTest extends BaseServiceTest {
  protected SaveDesignees saveDesignees = null;

  public SaveDesigneesTest(String testName) {
    super(testName);
  }

  public void setSaveDesignees(SaveDesignees saveDesignees) {
    this.saveDesignees = saveDesignees;
  }

  public static Test suite() {
    TestSuite suite = new TestSuite();
    suite.addTest(new SaveDesigneesTest("testSaveDesigneesUpdate"));
    suite.addTest(new SaveDesigneesTest("testSaveDesigneesAdd"));
    suite.addTest(new SaveDesigneesTest("testSaveDesigneesDelete"));
    return suite;
  }

  public void testSaveDesigneesUpdate() {
    CARC17SI carc17si = new CARC17SI();
    ROWCARC18SIG00 rowcarc18sig00 = getRowCarc18Sig00(6533, 6533, ServiceConstants.REQ_FUNC_CD_UPDATE, 5600032, 17,
                                                      Calendar.AUGUST, 1998, 17, 2, 20, 17, Calendar.AUGUST, 2010);

    ROWCARC18SIG00_ARRAY_CARC17SI rowcarc18sig00_array = new ROWCARC18SIG00_ARRAY_CARC17SI();
    rowcarc18sig00_array.addROWCARC18SIG00(rowcarc18sig00);
    carc17si.setROWCARC18SIG00_ARRAY_CARC17SI(rowcarc18sig00_array);
    saveDesignees.saveDesigneeAssignments(carc17si);
  }

  public void testSaveDesigneesAdd() {
    CARC17SI carc17si = new CARC17SI();
    ROWCARC18SIG00 rowcarc18sig00 = getRowCarc18Sig00(9404, 5764, ServiceConstants.REQ_FUNC_CD_ADD, 0, 0, 0, 0, 0, 0,
                                                      0, 27, Calendar.AUGUST, 2020);
    ROWCARC18SIG00 rowcarc18sig00_2 = getRowCarc18Sig00(3588, 6666, ServiceConstants.REQ_FUNC_CD_ADD, 0, 0, 0, 0, 0,
                                                        0, 0, 8, Calendar.MAY, 2029);

    ROWCARC18SIG00_ARRAY_CARC17SI rowcarc18sig00_array = new ROWCARC18SIG00_ARRAY_CARC17SI();
    rowcarc18sig00_array.addROWCARC18SIG00(rowcarc18sig00);
    rowcarc18sig00_array.addROWCARC18SIG00(rowcarc18sig00_2);
    carc17si.setROWCARC18SIG00_ARRAY_CARC17SI(rowcarc18sig00_array);
    saveDesignees.saveDesigneeAssignments(carc17si);
  }

  public void testSaveDesigneesDelete() {
    CARC17SI carc17si = new CARC17SI();
    ROWCARC18SIG00 rowcarc18sig00 = getRowCarc18Sig00(6533, 6533, ServiceConstants.REQ_FUNC_CD_DELETE, 5600032, 17,
                                                      Calendar.AUGUST, 1998, 17, 2, 20, 17, Calendar.AUGUST, 2010);
    ROWCARC18SIG00_ARRAY_CARC17SI rowcarc18sig00_array = new ROWCARC18SIG00_ARRAY_CARC17SI();
    rowcarc18sig00_array.addROWCARC18SIG00(rowcarc18sig00);
    carc17si.setROWCARC18SIG00_ARRAY_CARC17SI(rowcarc18sig00_array);
    saveDesignees.saveDesigneeAssignments(carc17si);
  }

  private ROWCARC18SIG00 getRowCarc18Sig00(int idPerson, int idPersonDesignee, String cdSysDataActionOutcome,
                                           int idEmpTempAssign, int dayDtlastUpdate, int monthDtlastUpdate,
                                           int yearDtlastUpdate, int hourDtlastUpdate, int minuteDtlastUpdate,
                                           int secondDtlastUpdate, int dayDtAssignExpiration,
                                           int monthDtAssignExpiration, int yearDtAssignExpiration) {

    ROWCARC18SIG00 rowcarc18sig00 = new ROWCARC18SIG00();
    rowcarc18sig00.setUlIdPerson(idPerson);
    rowcarc18sig00.setUlIdPersonDesignee(idPersonDesignee);
    rowcarc18sig00.setSzCdSysDataActionOutcome(cdSysDataActionOutcome);

    if (idEmpTempAssign != 0) {
      rowcarc18sig00.setUlIdEmpTempAssign(idEmpTempAssign);
    }

    Date dtLastUpdate = null;
    if (yearDtlastUpdate != 0) {
      // update or delete
      dtLastUpdate = new GregorianCalendar(yearDtlastUpdate, monthDtlastUpdate, dayDtlastUpdate, hourDtlastUpdate,
                                           minuteDtlastUpdate, secondDtlastUpdate).getTime();
    }

    rowcarc18sig00.setTsLastUpdate(dtLastUpdate);
    Date dtAssignExpiration =
            new GregorianCalendar(yearDtAssignExpiration, monthDtAssignExpiration, dayDtAssignExpiration).getTime();
    rowcarc18sig00.setDtDtAssignExpiration(DateHelper.toCastorDate(dtAssignExpiration));

    return rowcarc18sig00;
  }
}
