package gov.georgia.dhr.dfcs.sacwis.service.intake;

import gov.georgia.dhr.dfcs.sacwis.service.BaseServiceTest;
import gov.georgia.dhr.dfcs.sacwis.structs.input.MUpdIDInStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.MUpdIDInStruct_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.MUpdInRec;
import gov.georgia.dhr.dfcs.sacwis.structs.input.MUpdStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SzNmPersonFull_ARRAY_CINT35SI;
import junit.framework.Test;
import junit.framework.TestSuite;

public class SaveCallPersonListTest extends BaseServiceTest {

  protected SaveCallPersonList saveCallPersonList = null;

  public SaveCallPersonListTest(String testName) {
    super(testName);
  }

  public void setRetrieveUserProfile(SaveCallPersonList saveCallPersonList) {
    this.saveCallPersonList = saveCallPersonList;
  }

  public static Test suite() {
    TestSuite suite = new TestSuite();
    suite.addTest(new SaveCallPersonListTest("testSaveCallPersonList_update_Null_IndStagePersInLaw"));
    suite.addTest(new SaveCallPersonListTest("testSaveCallPersonList_update_Null_PersonEthnicGroup"));
    suite.addTest(new SaveCallPersonListTest("testSaveCallPersonList_update_Null_PersonLanguage"));
    suite.addTest(new SaveCallPersonListTest("testSaveCallPersonList_update_Null_StagePersRelInt"));
    suite.addTest(new SaveCallPersonListTest("testSaveCallPersonList_update_Null_StagePersRole"));
    suite.addTest(new SaveCallPersonListTest("testSaveCallPersonList_update_Null_StagePersType"));
    suite.addTest(new SaveCallPersonListTest("testSaveCallPersonList_update_Null_NmNameLast"));
    suite.addTest(new SaveCallPersonListTest("testSaveCallPersonList_update_Null_AddrPersAddrStLn1"));
    suite.addTest(new SaveCallPersonListTest("testSaveCallPersonList_update_Null_AddrPersAddrStLn2"));
    suite.addTest(new SaveCallPersonListTest("testSaveCallPersonList_update_Null_AddrCity"));
    suite.addTest(new SaveCallPersonListTest("testSaveCallPersonList_update_Null_AddrZip"));
    suite.addTest(new SaveCallPersonListTest("testSaveCallPersonList_update_Null_AddrCounty"));
    suite.addTest(new SaveCallPersonListTest("testSaveCallPersonList_update_Null_AddrState"));
    suite.addTest(new SaveCallPersonListTest("testSaveCallPersonList_update_Null_NbrPhone"));
    suite.addTest(new SaveCallPersonListTest("testSaveCallPersonList_update_Null_NbrPhoneExtension"));
    suite.addTest(new SaveCallPersonListTest("testSaveCallPersonList_update_Null_PhoneType"));
    suite.addTest(new SaveCallPersonListTest("testSaveCallPersonList_update_Null_NmPersonFull"));
    suite.addTest(new SaveCallPersonListTest("testSaveCallPersonList_update_Insert_AddrPersonLink"));
    return suite;
  }

  public void testSaveCallPersonList_update_Null_IndStagePersInLaw() {

    MUpdInRec cint35si = new MUpdInRec();
    MUpdStruct mup = new MUpdStruct();
    MUpdIDInStruct_ARRAY mupdidinstruct_array = new MUpdIDInStruct_ARRAY();
    setUpInitData(mup, mupdidinstruct_array);
    mup.setBIndStagePersInLaw(null);
    cint35si.setMUpdStruct(mup);
    cint35si.setMUpdIDInStruct_ARRAY(mupdidinstruct_array);
    saveCallPersonList.saveCallPersonList(cint35si);

  }

  public void testSaveCallPersonList_update_Null_PersonEthnicGroup() {
    MUpdInRec cint35si = new MUpdInRec();
    MUpdStruct mup = new MUpdStruct();
    MUpdIDInStruct_ARRAY mupdidinstruct_array = new MUpdIDInStruct_ARRAY();
    setUpInitData(mup, mupdidinstruct_array);
    mup.setSzCdPersonEthnicGroup(null);
    cint35si.setMUpdStruct(mup);
    cint35si.setMUpdIDInStruct_ARRAY(mupdidinstruct_array);
    saveCallPersonList.saveCallPersonList(cint35si);

  }

  public void testSaveCallPersonList_update_Null_PersonLanguage() {
    MUpdInRec cint35si = new MUpdInRec();
    MUpdStruct mup = new MUpdStruct();
    MUpdIDInStruct_ARRAY mupdidinstruct_array = new MUpdIDInStruct_ARRAY();
    setUpInitData(mup, mupdidinstruct_array);
    mup.setSzCdPersonLanguage(null);
    cint35si.setMUpdStruct(mup);
    cint35si.setMUpdIDInStruct_ARRAY(mupdidinstruct_array);
    saveCallPersonList.saveCallPersonList(cint35si);

  }

  public void testSaveCallPersonList_update_Null_StagePersRelInt() {
    MUpdInRec cint35si = new MUpdInRec();
    MUpdStruct mup = new MUpdStruct();
    MUpdIDInStruct_ARRAY mupdidinstruct_array = new MUpdIDInStruct_ARRAY();
    setUpInitData(mup, mupdidinstruct_array);
    mup.setSzCdStagePersRelInt(null);
    cint35si.setMUpdStruct(mup);
    cint35si.setMUpdIDInStruct_ARRAY(mupdidinstruct_array);
    saveCallPersonList.saveCallPersonList(cint35si);

  }

  public void testSaveCallPersonList_update_Null_StagePersRole() {
    MUpdInRec cint35si = new MUpdInRec();
    MUpdStruct mup = new MUpdStruct();
    MUpdIDInStruct_ARRAY mupdidinstruct_array = new MUpdIDInStruct_ARRAY();
    setUpInitData(mup, mupdidinstruct_array);
    mup.setSzCdStagePersRole(null);
    cint35si.setMUpdStruct(mup);
    cint35si.setMUpdIDInStruct_ARRAY(mupdidinstruct_array);
    saveCallPersonList.saveCallPersonList(cint35si);
  }

  public void testSaveCallPersonList_update_Null_StagePersType() {
    MUpdInRec cint35si = new MUpdInRec();
    MUpdStruct mup = new MUpdStruct();
    MUpdIDInStruct_ARRAY mupdidinstruct_array = new MUpdIDInStruct_ARRAY();
    setUpInitData(mup, mupdidinstruct_array);
    mup.setSzCdStagePersType(null);
    cint35si.setMUpdStruct(mup);
    cint35si.setMUpdIDInStruct_ARRAY(mupdidinstruct_array);
    saveCallPersonList.saveCallPersonList(cint35si);
  }

  public void testSaveCallPersonList_update_Null_NmNameLast() {
    MUpdInRec cint35si = new MUpdInRec();
    MUpdStruct mup = new MUpdStruct();
    MUpdIDInStruct_ARRAY mupdidinstruct_array = new MUpdIDInStruct_ARRAY();
    setUpInitData(mup, mupdidinstruct_array);
    mup.setSzNmNameLast(null);
    cint35si.setMUpdStruct(mup);
    cint35si.setMUpdIDInStruct_ARRAY(mupdidinstruct_array);
    saveCallPersonList.saveCallPersonList(cint35si);
  }

  public void testSaveCallPersonList_update_Null_AddrPersAddrStLn1() {
    MUpdInRec cint35si = new MUpdInRec();
    MUpdStruct mup = new MUpdStruct();
    MUpdIDInStruct_ARRAY mupdidinstruct_array = new MUpdIDInStruct_ARRAY();
    setUpInitData(mup, mupdidinstruct_array);
    mup.setSzAddrPersAddrStLn1(null);
    cint35si.setMUpdStruct(mup);
    cint35si.setMUpdIDInStruct_ARRAY(mupdidinstruct_array);
    saveCallPersonList.saveCallPersonList(cint35si);
  }

  public void testSaveCallPersonList_update_Null_AddrPersAddrStLn2() {
    MUpdInRec cint35si = new MUpdInRec();
    MUpdStruct mup = new MUpdStruct();
    MUpdIDInStruct_ARRAY mupdidinstruct_array = new MUpdIDInStruct_ARRAY();
    setUpInitData(mup, mupdidinstruct_array);
    mup.setSzAddrPersAddrStLn2(null);
    cint35si.setMUpdStruct(mup);
    cint35si.setMUpdIDInStruct_ARRAY(mupdidinstruct_array);
    saveCallPersonList.saveCallPersonList(cint35si);
  }

  public void testSaveCallPersonList_update_Null_AddrCity() {
    MUpdInRec cint35si = new MUpdInRec();
    MUpdStruct mup = new MUpdStruct();
    MUpdIDInStruct_ARRAY mupdidinstruct_array = new MUpdIDInStruct_ARRAY();
    setUpInitData(mup, mupdidinstruct_array);
    mup.setSzAddrCity(null);
    cint35si.setMUpdStruct(mup);
    cint35si.setMUpdIDInStruct_ARRAY(mupdidinstruct_array);
    saveCallPersonList.saveCallPersonList(cint35si);
  }

  public void testSaveCallPersonList_update_Null_AddrZip() {
    MUpdInRec cint35si = new MUpdInRec();
    MUpdStruct mup = new MUpdStruct();
    MUpdIDInStruct_ARRAY mupdidinstruct_array = new MUpdIDInStruct_ARRAY();
    setUpInitData(mup, mupdidinstruct_array);
    mup.setLAddrZip(null);
    cint35si.setMUpdStruct(mup);
    cint35si.setMUpdIDInStruct_ARRAY(mupdidinstruct_array);
    saveCallPersonList.saveCallPersonList(cint35si);
  }

  public void testSaveCallPersonList_update_Null_AddrCounty() {
    MUpdInRec cint35si = new MUpdInRec();
    MUpdStruct mup = new MUpdStruct();
    MUpdIDInStruct_ARRAY mupdidinstruct_array = new MUpdIDInStruct_ARRAY();
    setUpInitData(mup, mupdidinstruct_array);
    mup.setSzCdAddrCounty(null);
    cint35si.setMUpdStruct(mup);
    cint35si.setMUpdIDInStruct_ARRAY(mupdidinstruct_array);
    saveCallPersonList.saveCallPersonList(cint35si);
  }

  public void testSaveCallPersonList_update_Null_AddrState() {
    MUpdInRec cint35si = new MUpdInRec();
    MUpdStruct mup = new MUpdStruct();
    MUpdIDInStruct_ARRAY mupdidinstruct_array = new MUpdIDInStruct_ARRAY();
    setUpInitData(mup, mupdidinstruct_array);
    mup.setSzCdAddrState(null);
    cint35si.setMUpdStruct(mup);
    cint35si.setMUpdIDInStruct_ARRAY(mupdidinstruct_array);
    saveCallPersonList.saveCallPersonList(cint35si);
  }

  public void testSaveCallPersonList_update_Null_NbrPhone() {
    MUpdInRec cint35si = new MUpdInRec();
    MUpdStruct mup = new MUpdStruct();
    MUpdIDInStruct_ARRAY mupdidinstruct_array = new MUpdIDInStruct_ARRAY();
    setUpInitData(mup, mupdidinstruct_array);
    mup.setLNbrPhone(null);
    cint35si.setMUpdStruct(mup);
    cint35si.setMUpdIDInStruct_ARRAY(mupdidinstruct_array);
    saveCallPersonList.saveCallPersonList(cint35si);
  }

  public void testSaveCallPersonList_update_Null_NbrPhoneExtension() {
    MUpdInRec cint35si = new MUpdInRec();
    MUpdStruct mup = new MUpdStruct();
    MUpdIDInStruct_ARRAY mupdidinstruct_array = new MUpdIDInStruct_ARRAY();
    setUpInitData(mup, mupdidinstruct_array);
    mup.setLNbrPhoneExtension(null);
    cint35si.setMUpdStruct(mup);
    cint35si.setMUpdIDInStruct_ARRAY(mupdidinstruct_array);
    saveCallPersonList.saveCallPersonList(cint35si);
  }

  public void testSaveCallPersonList_update_Null_PhoneType() {
    MUpdInRec cint35si = new MUpdInRec();
    MUpdStruct mup = new MUpdStruct();
    MUpdIDInStruct_ARRAY mupdidinstruct_array = new MUpdIDInStruct_ARRAY();
    setUpInitData(mup, mupdidinstruct_array);
    mup.setSzCdPhoneType(null);
    cint35si.setMUpdStruct(mup);
    cint35si.setMUpdIDInStruct_ARRAY(mupdidinstruct_array);
    saveCallPersonList.saveCallPersonList(cint35si);

  }

  public void testSaveCallPersonList_update_Null_NmPersonFull() {
    MUpdInRec cint35si = new MUpdInRec();
    MUpdStruct mup = new MUpdStruct();
    MUpdIDInStruct_ARRAY mupdidinstruct_array = new MUpdIDInStruct_ARRAY();
    setUpInitData(mup, mupdidinstruct_array);

    SzNmPersonFull_ARRAY_CINT35SI sznmpersonfull_array_cint35si = mup.getSzNmPersonFull_ARRAY_CINT35SI();
    sznmpersonfull_array_cint35si.setSzNmPersonFull(0, null);
    cint35si.setMUpdStruct(mup);
    cint35si.setMUpdIDInStruct_ARRAY(mupdidinstruct_array);
    saveCallPersonList.saveCallPersonList(cint35si);
  }

  public void testSaveCallPersonList_update_Insert_AddrPersonLink() {
    MUpdInRec cint35si = new MUpdInRec();
    MUpdStruct mup = new MUpdStruct();
    MUpdIDInStruct_ARRAY mupdidinstruct_array = new MUpdIDInStruct_ARRAY();
    setUpInitData(mup, mupdidinstruct_array);
    MUpdIDInStruct mUpdIDInStruct = mupdidinstruct_array.getMUpdIDInStruct(0);
    mUpdIDInStruct.setUlIdAddrPersonLink(0);
    mUpdIDInStruct.setLdIdAddress(0);
    mupdidinstruct_array.addMUpdIDInStruct(0, mUpdIDInStruct);
    cint35si.setMUpdStruct(mup);
    cint35si.setMUpdIDInStruct_ARRAY(mupdidinstruct_array);
    saveCallPersonList.saveCallPersonList(cint35si);

  }

  public void setUpInitData(MUpdStruct mup, MUpdIDInStruct_ARRAY mupdidinstruct_array) {

    String cdPersonEthnicGroup = "BL";
    String cdPersonLanguage = "EN";
    String indStagePersInLaw = "N";
    String cdStagePersRelInt = "PA";
    String cdStagePersRole = "PR";
    String cdStagePersType = "PRN";
    String nmNameLast = "PATEL";
    String addrPersAddrStLn1 = "ADDRESS LN1";
    String addrPersAddrStLn2 = "ADDRESS LN2";
    String addrCity = "MARIETTA";
    String addrZip = "30062";
    String cdAddrCounty = "COB";
    String cdAddrState = "GA";
    String cdPersAddrLinkType = "RS";
    String nbrPhone = "6786270175";
    String nbrPhoneExtension = "627";
    String cdPhoneType = "EN";
    String indPersCancelHist = "H";

    // MUpdInRec cint35si = new MUpdInRec();

    mup.setBIndStagePersInLaw(indStagePersInLaw);
    mup.setSzCdPersonEthnicGroup(cdPersonEthnicGroup);
    mup.setSzCdPersonLanguage(cdPersonLanguage);
    mup.setSzCdStagePersRelInt(cdStagePersRelInt);
    mup.setSzCdStagePersRole(cdStagePersRole);
    mup.setSzCdStagePersType(cdStagePersType);
    mup.setSzNmNameLast(nmNameLast);
    mup.setSzAddrPersAddrStLn1(addrPersAddrStLn1);
    mup.setSzAddrPersAddrStLn2(addrPersAddrStLn2);
    mup.setSzAddrCity(addrCity);
    mup.setLAddrZip(addrZip);
    mup.setSzCdAddrCounty(cdAddrCounty);
    mup.setSzCdAddrState(cdAddrState);
    mup.setSzCdPersAddrLinkType(cdPersAddrLinkType);
    mup.setLNbrPhone(nbrPhone);
    mup.setLNbrPhoneExtension(nbrPhoneExtension);
    mup.setSzCdPhoneType(cdPhoneType);
    mup.setBIndPersCancelHist(indPersCancelHist);
    SzNmPersonFull_ARRAY_CINT35SI sznmpersonfull_array_cint35si = new SzNmPersonFull_ARRAY_CINT35SI();
    sznmpersonfull_array_cint35si.addSzNmPersonFull("patel");
    mup.setSzNmPersonFull_ARRAY_CINT35SI(sznmpersonfull_array_cint35si);

    MUpdIDInStruct mUpdIDInStruct = new MUpdIDInStruct();
    mUpdIDInStruct.setUlIdStage(5603243);
    mUpdIDInStruct.setUlIdPerson(1988);
    mUpdIDInStruct.setUlIdName(5600582);
    mUpdIDInStruct.setLdIdAddress(5605789);
    mUpdIDInStruct.setUlIdPhone(5601245);
    mUpdIDInStruct.setUlIdAddrPersonLink(5604681);

    mupdidinstruct_array.addMUpdIDInStruct(0, mUpdIDInStruct);

  }

}
