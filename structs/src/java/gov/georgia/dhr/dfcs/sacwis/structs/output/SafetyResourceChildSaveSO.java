package gov.georgia.dhr.dfcs.sacwis.structs.output;

import gov.georgia.dhr.dfcs.sacwis.structs.output.SafetyResourceChildErrorBean;

import java.io.Serializable;
import java.util.List;


public class SafetyResourceChildSaveSO  implements Serializable {
   
    private List<SafetyResourceChildErrorBean> safetyResourceChildErrorList;
         
    public List<SafetyResourceChildErrorBean> getSafetyResourceChildList() {
      return safetyResourceChildErrorList;
    }

    public void setSafetyResourceChildList (List<SafetyResourceChildErrorBean> safetyResourceChildErrorList) {
      this.safetyResourceChildErrorList = safetyResourceChildErrorList;
    }

  }