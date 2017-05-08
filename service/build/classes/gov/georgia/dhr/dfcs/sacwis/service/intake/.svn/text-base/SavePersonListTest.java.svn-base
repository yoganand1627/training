package gov.georgia.dhr.dfcs.sacwis.service.intake;

import java.util.Date;
import java.util.GregorianCalendar;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.service.BaseServiceTest;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT14WLB;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT14WLB_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.PersListAudInRec;
import gov.georgia.dhr.dfcs.sacwis.structs.input.PersListAudStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN31SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN31SI_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN44SIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN44SIG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT02SIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT02SIG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT02SIG01;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT02SIG01_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV26SIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV26SIG00_ARRAY;
import junit.framework.Test;
import junit.framework.TestSuite;

public class SavePersonListTest extends BaseServiceTest {

  protected SavePersonList savePersonList = null;

  public SavePersonListTest(String testName) {
    super(testName);
  }

  public void setSavePersonList(SavePersonList savePersonList) {
    this.savePersonList = savePersonList;
  }

  public static Test suite() {
    TestSuite suite = new TestSuite();

    suite.addTest(new SavePersonListTest("testSavePersonList_Add"));
    suite.addTest(new SavePersonListTest("testSavePersonList_Update"));
    suite.addTest(new SavePersonListTest("testSavePersonList_Delete"));
    return suite;
  }

  public void testSavePersonList_Add() {

    PersListAudInRec cint02si = new PersListAudInRec();
    PersListAudStruct persListAudStruct = new PersListAudStruct();
    persListAudStruct.setUlIdPerson(5600582);
    persListAudStruct.setLNbrPersonAge(10);
    Date dtPersonBirth = new GregorianCalendar(1981, 1, 7).getTime();
    persListAudStruct.setDtDtPersonBirth(DateHelper.toCastorDate(dtPersonBirth));
    persListAudStruct.setDtDtPersonDeath(null);
    persListAudStruct.setCdPersonStatus("A");
    persListAudStruct.setSzCdPersonDeath("");
    persListAudStruct.setSzCdPersonMaritalStatus("M");
    persListAudStruct.setSzCdPersonLanguage(null);
    persListAudStruct.setSzCdDisasterRlf(null);
    persListAudStruct.setCCdPersonSex("M");
    persListAudStruct.setSzNmPersonFull("Mike, Baxter");
    persListAudStruct.setSzCdPersonEthnicGroup("WH");
    persListAudStruct.setBIndPersonDobApprox("N");
    persListAudStruct.setSzCdStagePersRole("NO");
    persListAudStruct.setSzCdStagePersType("COL");
    persListAudStruct.setSzTxtStagePersNotes("TEST Notes");
    persListAudStruct.setSzCdStagePersRelInt("NE");
    persListAudStruct.setBIndStagePersReporter("Y");
    persListAudStruct.setUlIdStage(240);
    persListAudStruct.setBIndStagePersInLaw("N");
    persListAudStruct.setSzCdStagePersLstSort(null);
    persListAudStruct.setSzCdCategoryCategory(null);
    ArchInputStruct archInputStruct = new ArchInputStruct();
    archInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_ADD);
    cint02si.setArchInputStruct(archInputStruct);
    cint02si.setPersListAudStruct(persListAudStruct);

    persListAudStruct.setBScrIndAddrDataChange(ServiceConstants.FND_YES);

    ROWCCMN44SIG00_ARRAY rowccmn44sig00_array = new ROWCCMN44SIG00_ARRAY();
    ROWCCMN44SIG00 row1 = new ROWCCMN44SIG00();
    row1.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_ADD);
    row1.setSzAddrPersAddrStLn1("AddrStLn1_1");
    row1.setSzAddrPersAddrStLn2("AddrStLn2_1");
    row1.setSzAddrCity("Marietta");
    row1.setLAddrZip("30062");
    row1.setSzAddrPersAddrAttn("Jeff Scheing");
    row1.setSzCdAddrCounty("USA");
    row1.setSzCdAddrState("GA");
    row1.setSzCdPersAddrLinkType("RS");
    row1.setBIndPersAddrLinkInvalid("N");
    ROWCCMN44SIG00 row2 = new ROWCCMN44SIG00();
    row2.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_ADD);
    row2.setSzAddrPersAddrStLn1("AddrStLn1_2");
    row2.setSzAddrPersAddrStLn2("AddrStLn2_2");
    row2.setSzAddrCity("Marietta");
    row2.setLAddrZip("30067");
    row2.setSzAddrPersAddrAttn("Jeff Happy");
    row2.setSzCdAddrCounty("USA");
    row2.setSzCdAddrState("GA");
    row2.setSzCdPersAddrLinkType("RS");
    row2.setBIndPersAddrLinkInvalid("N");
    rowccmn44sig00_array.addROWCCMN44SIG00(row1);
    rowccmn44sig00_array.addROWCCMN44SIG00(row2);
    cint02si.setROWCCMN44SIG00_ARRAY(rowccmn44sig00_array);

    // Phone
    persListAudStruct.setBScrIndPhoneDataChange(ServiceConstants.FND_YES);

    ROWCCMN31SI_ARRAY rowccmn31si_array = new ROWCCMN31SI_ARRAY();
    ROWCCMN31SI rowccmn31si = new ROWCCMN31SI();
    rowccmn31si.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_ADD);
    rowccmn31si.setUlIdPhone(0);
    rowccmn31si.setSzCdPhoneType("RS");
    rowccmn31si.setLNbrPhone("6786270175");
    rowccmn31si.setLNbrPhoneExtension("999");
    rowccmn31si.setBIndPersonPhonePrimary("Y");
    rowccmn31si.setBIndPersonPhoneInvalid("N");
    rowccmn31si.setSzTxtPhoneComments("Test Comments");

    rowccmn31si_array.addROWCCMN31SI(rowccmn31si);
    cint02si.setROWCCMN31SI_ARRAY(rowccmn31si_array);

    // nameListAud
    persListAudStruct.setBScrIndNameDataChange(ServiceConstants.FND_YES);
    ROWCINV26SIG00_ARRAY rowcinv26sig00_array = new ROWCINV26SIG00_ARRAY();
    ROWCINV26SIG00 rowcinv26sig00 = new ROWCINV26SIG00();
    rowcinv26sig00.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_ADD);
    rowcinv26sig00.setSzCdNameSuffix(null);
    rowcinv26sig00.setDtDtNameEndDate(DateHelper.MAX_CASTOR_DATE);
    rowcinv26sig00.setUlIdName(0);
    // rowcinv26sig00.setUlIdPerson();
    rowcinv26sig00.setBIndNameInvalid("N");
    rowcinv26sig00.setBIndNamePrimary("Y");
    rowcinv26sig00.setSzNmNameFirst("Kay");
    rowcinv26sig00.setSzNmNameLast("Ruth");
    rowcinv26sig00.setSzNmNameMiddle("Bush");
    rowcinv26sig00_array.addROWCINV26SIG00(rowcinv26sig00);
    cint02si.setROWCINV26SIG00_ARRAY(rowcinv26sig00_array);

    // Race

    persListAudStruct.setBScrIndRaceDataChange(ServiceConstants.FND_YES);
    ROWCINT02SIG00_ARRAY rowcint02sig00_array = new ROWCINT02SIG00_ARRAY();
    ROWCINT02SIG00 rowcint02sig00 = new ROWCINT02SIG00();
    rowcint02sig00.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_ADD);
    rowcint02sig00.setSzCdPersonRace("WT");
    rowcint02sig00_array.addROWCINT02SIG00(rowcint02sig00);
    cint02si.setROWCINT02SIG00_ARRAY(rowcint02sig00_array);

    ROWCINT02SIG01_ARRAY rowcint02sig01_array = new ROWCINT02SIG01_ARRAY();
    ROWCINT02SIG01 rowcint02sig01 = new ROWCINT02SIG01();
    rowcint02sig01.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_ADD);
    rowcint02sig01.setSzCdPersonEthnicity("HS");
    rowcint02sig01_array.addROWCINT02SIG01(rowcint02sig01);
    cint02si.setROWCINT02SIG01_ARRAY(rowcint02sig01_array);

    // IDs
    persListAudStruct.setBScrIndIDDataChange(ServiceConstants.FND_YES);

    CINT14WLB_ARRAY cint14wlb_array = new CINT14WLB_ARRAY();

    CINT14WLB cint14wlb = new CINT14WLB();

    cint14wlb.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_ADD);
    cint14wlb.setUlIdPerson(1988);
    cint14wlb.setUlIdPersonId(0);
    cint14wlb.setSzNbrPersonIdNumber("111-22-3333");
    cint14wlb.setSzCdPersonIdType("SSN");
    cint14wlb.setSzDescPersonID("TEST");
    cint14wlb.setBIndPersonIDInvalid("N");
    cint14wlb.setBIndValidateByInterface(null);
    cint14wlb_array.addCINT14WLB(cint14wlb);
    cint02si.setCINT14WLB_ARRAY(cint14wlb_array);

    cint02si.setPersListAudStruct(persListAudStruct);
    savePersonList.savePersonList(cint02si);

  }

  public void testSavePersonList_Update() {

    PersListAudInRec cint02si = new PersListAudInRec();
    PersListAudStruct persListAudStruct = new PersListAudStruct();

    persListAudStruct.setUlIdPerson(1988);
    persListAudStruct.setLNbrPersonAge(10);
    Date dtPersonBirth = new GregorianCalendar(1981, 1, 7).getTime();
    persListAudStruct.setDtDtPersonBirth(DateHelper.toCastorDate(dtPersonBirth));
    persListAudStruct.setDtDtPersonDeath(null);
    persListAudStruct.setCdPersonStatus("A");
    persListAudStruct.setSzCdPersonDeath("");
    persListAudStruct.setSzCdPersonMaritalStatus("M");
    persListAudStruct.setSzCdPersonLanguage(null);
    persListAudStruct.setSzCdDisasterRlf(null);
    persListAudStruct.setCCdPersonSex("M");
    persListAudStruct.setSzNmPersonFull("Mike, Baxter");
    persListAudStruct.setSzCdPersonEthnicGroup("WH");
    persListAudStruct.setBIndPersonDobApprox("N");
    persListAudStruct.setSzCdStagePersRole("NO");
    persListAudStruct.setSzCdStagePersType("COL");
    persListAudStruct.setSzTxtStagePersNotes("TEST Notes");
    persListAudStruct.setSzCdStagePersRelInt("NE");
    persListAudStruct.setBIndStagePersReporter("Y");
    persListAudStruct.setUlIdStage(240);
    persListAudStruct.setBIndStagePersInLaw("N");
    persListAudStruct.setSzCdStagePersLstSort(null);
    persListAudStruct.setSzCdCategoryCategory(null);
    ArchInputStruct archInputStruct = new ArchInputStruct();
    archInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
    cint02si.setArchInputStruct(archInputStruct);
    persListAudStruct.setBScrIndAddrDataChange(ServiceConstants.FND_YES);
    cint02si.setPersListAudStruct(persListAudStruct);

    // Address
    ROWCCMN44SIG00_ARRAY rowccmn44sig00_array = new ROWCCMN44SIG00_ARRAY();
    ROWCCMN44SIG00 row = new ROWCCMN44SIG00();
    row.setLdIdAddress(1988);
    row.setSzCdPersAddrLinkType("RS");
    row.setBIndPersAddrLinkInvalid("N");
    row.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_UPDATE);
    rowccmn44sig00_array.addROWCCMN44SIG00(row);
    cint02si.setROWCCMN44SIG00_ARRAY(rowccmn44sig00_array);
    savePersonList.savePersonList(cint02si);

    // Phone
    persListAudStruct.setBScrIndPhoneDataChange(ServiceConstants.FND_YES);
    ROWCCMN31SI_ARRAY rowccmn31si_array = new ROWCCMN31SI_ARRAY();
    ROWCCMN31SI rowccmn31si = new ROWCCMN31SI();
    rowccmn31si.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_UPDATE);
    rowccmn31si.setUlIdPhone(5726);
    rowccmn31si.setSzCdPhoneType("RS");
    rowccmn31si.setLNbrPhone("6786270175");
    rowccmn31si.setLNbrPhoneExtension("999");
    rowccmn31si.setBIndPersonPhonePrimary("Y");
    rowccmn31si.setBIndPersonPhoneInvalid("N");
    rowccmn31si.setSzTxtPhoneComments("Test Comments");

    rowccmn31si_array.addROWCCMN31SI(rowccmn31si);
    cint02si.setROWCCMN31SI_ARRAY(rowccmn31si_array);

    // nameListAud
    persListAudStruct.setBScrIndNameDataChange(ServiceConstants.FND_YES);
    ROWCINV26SIG00_ARRAY rowcinv26sig00_array = new ROWCINV26SIG00_ARRAY();

    ROWCINV26SIG00 rowcinv26sig00 = new ROWCINV26SIG00();
    rowcinv26sig00.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_UPDATE);
    rowcinv26sig00.setSzCdNameSuffix(null);
    rowcinv26sig00.setDtDtNameEndDate(DateHelper.MAX_CASTOR_DATE);
    rowcinv26sig00.setUlIdName(853);
    // rowcinv26sig00.setUlIdPerson();
    rowcinv26sig00.setBIndNameInvalid("N");
    rowcinv26sig00.setBIndNamePrimary("Y");
    rowcinv26sig00.setSzNmNameFirst("Kay");
    rowcinv26sig00.setSzNmNameLast("Ruth");
    rowcinv26sig00.setSzNmNameMiddle("Bush");
    rowcinv26sig00_array.addROWCINV26SIG00(rowcinv26sig00);
    cint02si.setROWCINV26SIG00_ARRAY(rowcinv26sig00_array);

    // Race

    persListAudStruct.setBScrIndRaceDataChange(ServiceConstants.FND_YES);
    ROWCINT02SIG00_ARRAY rowcint02sig00_array = new ROWCINT02SIG00_ARRAY();
    ROWCINT02SIG00 rowcint02sig00 = new ROWCINT02SIG00();
    rowcint02sig00.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_ADD);
    rowcint02sig00.setSzCdPersonRace("WT");
    rowcint02sig00_array.addROWCINT02SIG00(rowcint02sig00);
    cint02si.setROWCINT02SIG00_ARRAY(rowcint02sig00_array);

    ROWCINT02SIG01_ARRAY rowcint02sig01_array = new ROWCINT02SIG01_ARRAY();
    ROWCINT02SIG01 rowcint02sig01 = new ROWCINT02SIG01();
    rowcint02sig01.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_ADD);
    rowcint02sig01.setSzCdPersonEthnicity("HS");
    rowcint02sig01_array.addROWCINT02SIG01(rowcint02sig01);
    cint02si.setROWCINT02SIG01_ARRAY(rowcint02sig01_array);

    // IDs
    persListAudStruct.setBScrIndIDDataChange(ServiceConstants.FND_YES);

    CINT14WLB_ARRAY cint14wlb_array = new CINT14WLB_ARRAY();

    CINT14WLB cint14wlb = new CINT14WLB();

    cint14wlb.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_ADD);
    cint14wlb.setUlIdPerson(1988);
    cint14wlb.setUlIdPersonId(1988);
    cint14wlb.setSzNbrPersonIdNumber("111-22-3333");
    cint14wlb.setSzCdPersonIdType("SSN");
    cint14wlb.setSzDescPersonID("TEST");
    cint14wlb.setBIndPersonIDInvalid("N");
    cint14wlb.setBIndValidateByInterface(null);
    cint14wlb_array.addCINT14WLB(cint14wlb);
    cint02si.setCINT14WLB_ARRAY(cint14wlb_array);

    cint02si.setPersListAudStruct(persListAudStruct);
    savePersonList.savePersonList(cint02si);

  }

  public void testSavePersonList_Delete() {
    PersListAudInRec cint02si = new PersListAudInRec();
    PersListAudStruct persListAudStruct = new PersListAudStruct();

    persListAudStruct.setUlIdPerson(1988);
    persListAudStruct.setLNbrPersonAge(10);
    Date dtPersonBirth = new GregorianCalendar(1981, 1, 7).getTime();
    persListAudStruct.setDtDtPersonBirth(DateHelper.toCastorDate(dtPersonBirth));
    persListAudStruct.setDtDtPersonDeath(null);
    persListAudStruct.setCdPersonStatus("A");
    persListAudStruct.setSzCdPersonDeath("");
    persListAudStruct.setSzCdPersonMaritalStatus("M");
    persListAudStruct.setSzCdPersonLanguage(null);
    persListAudStruct.setSzCdDisasterRlf(null);
    persListAudStruct.setCCdPersonSex("M");
    persListAudStruct.setSzNmPersonFull("Mike, Baxter");
    persListAudStruct.setSzCdPersonEthnicGroup("WH");
    persListAudStruct.setBIndPersonDobApprox("N");
    persListAudStruct.setSzCdStagePersRole("NO");
    persListAudStruct.setSzCdStagePersType("COL");
    persListAudStruct.setSzTxtStagePersNotes("TEST Notes");
    persListAudStruct.setSzCdStagePersRelInt("NE");
    persListAudStruct.setBIndStagePersReporter("Y");
    persListAudStruct.setUlIdStage(240);
    persListAudStruct.setBIndStagePersInLaw("N");
    persListAudStruct.setSzCdStagePersLstSort(null);
    persListAudStruct.setSzCdCategoryCategory(null);
    ArchInputStruct archInputStruct = new ArchInputStruct();
    archInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_DELETE);
    cint02si.setArchInputStruct(archInputStruct);
    persListAudStruct.setBScrIndAddrDataChange(ServiceConstants.FND_YES);
    cint02si.setPersListAudStruct(persListAudStruct);

    // Address
    ROWCCMN44SIG00_ARRAY rowccmn44sig00_array = new ROWCCMN44SIG00_ARRAY();
    ROWCCMN44SIG00 rowccmn44sig00 = new ROWCCMN44SIG00();
    rowccmn44sig00.setLdIdAddress(1988);
    rowccmn44sig00.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_DELETE);
    rowccmn44sig00_array.addROWCCMN44SIG00(rowccmn44sig00);
    cint02si.setROWCCMN44SIG00_ARRAY(rowccmn44sig00_array);

    // Phone
    persListAudStruct.setBScrIndPhoneDataChange(ServiceConstants.FND_YES);
    ROWCCMN31SI_ARRAY rowccmn31si_array = new ROWCCMN31SI_ARRAY();
    ROWCCMN31SI rowccmn31si = new ROWCCMN31SI();
    rowccmn31si.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_DELETE);
    rowccmn31si.setUlIdPhone(5726);
    rowccmn31si_array.addROWCCMN31SI(rowccmn31si);
    cint02si.setROWCCMN31SI_ARRAY(rowccmn31si_array);

    // nameListAud
    persListAudStruct.setBScrIndNameDataChange(ServiceConstants.FND_YES);
    ROWCINV26SIG00_ARRAY rowcinv26sig00_array = new ROWCINV26SIG00_ARRAY();
    ROWCINV26SIG00 rowcinv26sig00 = new ROWCINV26SIG00();
    rowcinv26sig00.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_DELETE);
    rowcinv26sig00.setSzCdNameSuffix(null);
    rowcinv26sig00.setDtDtNameEndDate(DateHelper.MAX_CASTOR_DATE);
    rowcinv26sig00.setUlIdName(853);
    rowcinv26sig00_array.addROWCINV26SIG00(rowcinv26sig00);
    cint02si.setROWCINV26SIG00_ARRAY(rowcinv26sig00_array);
    cint02si.setPersListAudStruct(persListAudStruct);

    // Race
    persListAudStruct.setBScrIndRaceDataChange(ServiceConstants.FND_YES);
    ROWCINT02SIG00_ARRAY rowcint02sig00_array = new ROWCINT02SIG00_ARRAY();
    ROWCINT02SIG00 rowcint02sig00 = new ROWCINT02SIG00();
    rowcint02sig00.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_DELETE);
    rowcint02sig00.setSzCdPersonRace("WT");
    rowcint02sig00_array.addROWCINT02SIG00(rowcint02sig00);
    cint02si.setROWCINT02SIG00_ARRAY(rowcint02sig00_array);

    ROWCINT02SIG01_ARRAY rowcint02sig01_array = new ROWCINT02SIG01_ARRAY();
    ROWCINT02SIG01 rowcint02sig01 = new ROWCINT02SIG01();
    rowcint02sig01.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_DELETE);
    rowcint02sig01.setSzCdPersonEthnicity("HS");
    rowcint02sig01_array.addROWCINT02SIG01(rowcint02sig01);
    cint02si.setROWCINT02SIG01_ARRAY(rowcint02sig01_array);

    // IDs
    persListAudStruct.setBScrIndIDDataChange(ServiceConstants.FND_YES);

    CINT14WLB_ARRAY cint14wlb_array = new CINT14WLB_ARRAY();

    CINT14WLB cint14wlb = new CINT14WLB();

    cint14wlb.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_DELETE);
    cint14wlb.setUlIdPerson(1988);
    cint14wlb.setUlIdPersonId(1988);
    cint14wlb_array.addCINT14WLB(cint14wlb);

    cint02si.setCINT14WLB_ARRAY(cint14wlb_array);

    cint02si.setPersListAudStruct(persListAudStruct);
    savePersonList.savePersonList(cint02si);

  }

}
