package gov.georgia.dhr.dfcs.sacwis.service.admin;

import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.service.BaseServiceTest;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CARC18SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCARC18SIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCARC18SIG00_ARRAY_CARC18SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCARC18SIG01;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCARC18SIG01_ARRAY;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import junit.framework.Test;
import junit.framework.TestSuite;

public class SaveStaffSecurityTest extends BaseServiceTest {
  protected SaveStaffSecurity saveStaffSecurity = null;

  public SaveStaffSecurityTest(String testName) {
    super(testName);
  }

  public void setSaveStaffSecurity(SaveStaffSecurity saveStaffSecurity) {
    this.saveStaffSecurity = saveStaffSecurity;
  }

  public static Test suite() {
    TestSuite suite = new TestSuite();

    // This will test updateEmployeeByIdPersonAndDtLastUpdate
    suite.addTest(new SaveStaffSecurityTest("testUpdateEmployeeByIdPersonAndDtLastUpdate"));

    // These test add, update, and delete for ROWCARC18SIG00_ARRAY_CARC18SI
    suite.addTest(new SaveStaffSecurityTest("testRowcarc18sig00ArrayUpdate"));
    suite.addTest(new SaveStaffSecurityTest("testRowcarc18sig00ArrayAdd"));
    suite.addTest(new SaveStaffSecurityTest("testRowcarc18sig00ArrayDelete"));

    // These test add and delete for ROWCARC18SIG01_ARRAY_ARRAY_CARC18SI
    suite.addTest(new SaveStaffSecurityTest("testRowCarc18Sig01ArrayAdd"));
    suite.addTest(new SaveStaffSecurityTest("testRowCarc18Sig01ArrayDelete"));
    return suite;
  }

  private CARC18SI getUpdateEmployeeByIdPersonAndDtLastUpdateInfo() {
    CARC18SI carc18si = new CARC18SI();
    ArchInputStruct carc18siArchInputStruct = new ArchInputStruct();
    carc18siArchInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
    carc18si.setArchInputStruct(carc18siArchInputStruct);
    carc18si.setSzIdEmployeeLogon("SACWIS");
    GregorianCalendar dtLastUpdateCal = new GregorianCalendar(2003, Calendar.FEBRUARY, 7, 22, 9, 41);
    Date dtLastUpdate = dtLastUpdateCal.getTime();
    carc18si.setTsLastUpdate(dtLastUpdate);
    carc18si.setUlIdPerson(827);

    return carc18si;
  }

  public void testUpdateEmployeeByIdPersonAndDtLastUpdate() {
    CARC18SI carc18si = getUpdateEmployeeByIdPersonAndDtLastUpdateInfo();

    // empty ROWCARC18SIG00_ARRAY_CARC18SI
    ROWCARC18SIG00_ARRAY_CARC18SI rowcarc18sig00_array = new ROWCARC18SIG00_ARRAY_CARC18SI();
    carc18si.setROWCARC18SIG00_ARRAY_CARC18SI(rowcarc18sig00_array);

    // empty ROWCARC18SIG01_ARRAY
    ROWCARC18SIG01_ARRAY rowCarc18Sig01_array = new ROWCARC18SIG01_ARRAY();
    carc18si.setROWCARC18SIG01_ARRAY(rowCarc18Sig01_array);

    saveStaffSecurity.saveStaffSecurityInformation(carc18si);
  }

  public void testRowcarc18sig00ArrayUpdate() {
    CARC18SI carc18si = getUpdateEmployeeByIdPersonAndDtLastUpdateInfo();

    ROWCARC18SIG00 rowcarc18sig00 = getRowCarc18Sig00(6533, 6533, ServiceConstants.REQ_FUNC_CD_UPDATE, 5600032, 17,
                                                      Calendar.AUGUST, 1998, 17, 2, 20, 17, Calendar.AUGUST, 2010);

    ROWCARC18SIG00_ARRAY_CARC18SI rowcarc18sig00_array = new ROWCARC18SIG00_ARRAY_CARC18SI();
    rowcarc18sig00_array.addROWCARC18SIG00(rowcarc18sig00);
    carc18si.setROWCARC18SIG00_ARRAY_CARC18SI(rowcarc18sig00_array);

    // empty ROWCARC18SIG01_ARRAY
    ROWCARC18SIG01_ARRAY rowCarc18Sig01_array = new ROWCARC18SIG01_ARRAY();
    carc18si.setROWCARC18SIG01_ARRAY(rowCarc18Sig01_array);
    saveStaffSecurity.saveStaffSecurityInformation(carc18si);
  }

  public void testRowcarc18sig00ArrayDelete() {
    CARC18SI carc18si = getUpdateEmployeeByIdPersonAndDtLastUpdateInfo();

    ROWCARC18SIG00 rowcarc18sig00 = getRowCarc18Sig00(6533, 6533, ServiceConstants.REQ_FUNC_CD_DELETE, 5600032, 17,
                                                      Calendar.AUGUST, 1998, 17, 2, 20, 17, Calendar.AUGUST, 2010);

    ROWCARC18SIG00_ARRAY_CARC18SI rowcarc18sig00_array = new ROWCARC18SIG00_ARRAY_CARC18SI();
    rowcarc18sig00_array.addROWCARC18SIG00(rowcarc18sig00);
    carc18si.setROWCARC18SIG00_ARRAY_CARC18SI(rowcarc18sig00_array);

    // empty ROWCARC18SIG01_ARRAY
    ROWCARC18SIG01_ARRAY rowCarc18Sig01_array = new ROWCARC18SIG01_ARRAY();
    carc18si.setROWCARC18SIG01_ARRAY(rowCarc18Sig01_array);

    saveStaffSecurity.saveStaffSecurityInformation(carc18si);
  }

  public void testRowcarc18sig00ArrayAdd() {
    CARC18SI carc18si = getUpdateEmployeeByIdPersonAndDtLastUpdateInfo();
    
    ROWCARC18SIG00 rowcarc18sig00 = getRowCarc18Sig00(9404, 5764, ServiceConstants.REQ_FUNC_CD_ADD, 0, 0, 0, 0, 0, 0,
                                                      0, 27, Calendar.AUGUST, 2020);

    ROWCARC18SIG00_ARRAY_CARC18SI rowcarc18sig00_array = new ROWCARC18SIG00_ARRAY_CARC18SI();
    rowcarc18sig00_array.addROWCARC18SIG00(rowcarc18sig00);
    carc18si.setROWCARC18SIG00_ARRAY_CARC18SI(rowcarc18sig00_array);

    // empty ROWCARC18SIG01_ARRAY
    ROWCARC18SIG01_ARRAY rowCarc18Sig01_array = new ROWCARC18SIG01_ARRAY();
    carc18si.setROWCARC18SIG01_ARRAY(rowCarc18Sig01_array);

    saveStaffSecurity.saveStaffSecurityInformation(carc18si);
  }

  public void testRowCarc18Sig01ArrayAdd() {
    CARC18SI carc18si = getUpdateEmployeeByIdPersonAndDtLastUpdateInfo();

    // empty ROWCARC18SIG00_ARRAY_CARC18SI
    ROWCARC18SIG00_ARRAY_CARC18SI rowcarc18sig00_array = new ROWCARC18SIG00_ARRAY_CARC18SI();
    carc18si.setROWCARC18SIG00_ARRAY_CARC18SI(rowcarc18sig00_array);

    ROWCARC18SIG01 rowcarc18sig01 = getRowcarc18sig01(6435, ServiceConstants.REQ_FUNC_CD_ADD, "ALL", 0, 0, 0,
                                                      0, 0, 0, 0);

    ROWCARC18SIG01_ARRAY rowCarc18Sig01_array = new ROWCARC18SIG01_ARRAY();
    rowCarc18Sig01_array.addROWCARC18SIG01(rowcarc18sig01);
    carc18si.setROWCARC18SIG01_ARRAY(rowCarc18Sig01_array);

    saveStaffSecurity.saveStaffSecurityInformation(carc18si);
  }

  public void testRowCarc18Sig01ArrayDelete() {
    CARC18SI carc18si = getUpdateEmployeeByIdPersonAndDtLastUpdateInfo();

    // empty ROWCARC18SIG00_ARRAY_CARC18SI
    ROWCARC18SIG00_ARRAY_CARC18SI rowcarc18sig00_array = new ROWCARC18SIG00_ARRAY_CARC18SI();
    carc18si.setROWCARC18SIG00_ARRAY_CARC18SI(rowcarc18sig00_array);

    ROWCARC18SIG01 rowcarc18sig01 = getRowcarc18sig01(1173, ServiceConstants.REQ_FUNC_CD_DELETE, "ALL", 6484, 7, Calendar.FEBRUARY,
                                                      2003, 22, 9, 40);

    ROWCARC18SIG01_ARRAY rowCarc18Sig01_array = new ROWCARC18SIG01_ARRAY();
    rowCarc18Sig01_array.addROWCARC18SIG01(rowcarc18sig01);
    carc18si.setROWCARC18SIG01_ARRAY(rowCarc18Sig01_array);

    saveStaffSecurity.saveStaffSecurityInformation(carc18si);
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

  private ROWCARC18SIG01 getRowcarc18sig01(int idPerson, String cdSysDataActionOutcome, String nmSecurityClass,
                                           int idEmpSecLink, int dayDtlastUpdate, int monthDtlastUpdate,
                                           int yearDtlastUpdate, int hourDtlastUpdate, int minuteDtlastUpdate,
                                           int secondDtlastUpdate) {

    ROWCARC18SIG01 rowcarc18sig01 = new ROWCARC18SIG01();
    rowcarc18sig01.setUlIdPerson(idPerson);
    rowcarc18sig01.setSzCdSysDataActionOutcome(cdSysDataActionOutcome);
    rowcarc18sig01.setSzNmSecurityClass(nmSecurityClass);

    // update or delete
    if (idEmpSecLink != 0) {
      rowcarc18sig01.setUlIdEmpSecLink(idEmpSecLink);
    }    
    
    Date dtLastUpdate = null;
    if (yearDtlastUpdate != 0) {
      // update or delete      
      GregorianCalendar dtLastUpdateCal = new GregorianCalendar(yearDtlastUpdate, monthDtlastUpdate, dayDtlastUpdate,
                                                                hourDtlastUpdate, minuteDtlastUpdate,
                                                                secondDtlastUpdate);
      dtLastUpdate = dtLastUpdateCal.getTime();
    } 

    rowcarc18sig01.setTsLastUpdate(dtLastUpdate);

    return rowcarc18sig01;
  }
}
