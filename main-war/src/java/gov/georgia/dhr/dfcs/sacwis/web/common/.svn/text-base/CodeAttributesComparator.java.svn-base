package gov.georgia.dhr.dfcs.sacwis.web.common;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodeAttributes;

import java.util.Comparator;

public class CodeAttributesComparator implements Comparator<CodeAttributes> {

  /**
   * Provides a method to compare objects by decode. Objects passed in should
   * be CodeAttributes
   * 
   * @param attribute1
   * @param attribute2
   * @return
   */
  public int compare(CodeAttributes attribute1, CodeAttributes attribute2){
    
    int x = 0;
    
    if (attribute1 != null && attribute2 != null){
      String decode1 =  attribute1 .getDecode();
      String decode2 =  attribute2.getDecode();
      if (decode1 != null && decode2 != null){
        x = decode1.compareTo(decode2);
      }    
    }
    return x;
  }
}
