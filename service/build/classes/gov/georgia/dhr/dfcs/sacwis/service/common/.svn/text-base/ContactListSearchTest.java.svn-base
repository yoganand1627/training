package gov.georgia.dhr.dfcs.sacwis.service.common;

import junit.framework.Test;
import junit.framework.TestSuite;
import gov.georgia.dhr.dfcs.sacwis.service.BaseServiceTest;
import gov.georgia.dhr.dfcs.sacwis.service.person.SaveCriminalHistoryTest;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSYS04SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSYS04SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSYS04SI_ARRAY;

public class ContactListSearchTest extends BaseServiceTest {
  
  protected ContactListSearch contactListSearch = null;
  
  public ContactListSearchTest(String testName) {
    super(testName);
  }

  public void setContactListSearch(ContactListSearch contactListSearch) {
    this.contactListSearch = contactListSearch;
  }
  
  public static Test suite() {
    TestSuite suite = new TestSuite();
    suite.addTest(new ContactListSearchTest("testContactListSearch"));
    return suite;
  }
  
  public void testContactListSearch(){
    CSYS04SI csys04si = new CSYS04SI();
    csys04si.setUlIdCase(5600122);
    ROWCSYS04SI_ARRAY rowcsys04si_array = new ROWCSYS04SI_ARRAY();
    ROWCSYS04SI rowcsys04si = new ROWCSYS04SI();
    rowcsys04si.setUlIdPerson(5600602);
    rowcsys04si_array.addROWCSYS04SI(rowcsys04si);
    csys04si.setROWCSYS04SI_ARRAY(rowcsys04si_array);
    contactListSearch.contactListSearch(csys04si);
  }

}
