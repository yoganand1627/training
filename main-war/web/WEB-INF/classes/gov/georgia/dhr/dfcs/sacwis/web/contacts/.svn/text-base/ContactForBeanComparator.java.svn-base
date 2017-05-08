package gov.georgia.dhr.dfcs.sacwis.web.contacts;

import gov.georgia.dhr.dfcs.sacwis.structs.output.ContactForBean;

import java.util.Comparator;

public class ContactForBeanComparator implements Comparator<ContactForBean> {

  /**
   * Provides a method to compare objects by full name.  Objects passed in should
   * be ContactForBean
   * 
   * @param bean1
   * @param bean2
   * @return
   */
  public int compare(ContactForBean bean1, ContactForBean bean2){
    
    int x = 0;
    
    if (bean1 != null && bean2 != null){
      String name1 =  bean1.getNmPersonFull();
      String name2 =  bean2.getNmPersonFull();
      if (name1 != null && name2 != null){
        x = name1.compareTo(name2);
      }    
    }
    return x;
  }

}
