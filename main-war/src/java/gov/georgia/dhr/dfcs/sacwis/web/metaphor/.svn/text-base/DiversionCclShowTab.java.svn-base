package gov.georgia.dhr.dfcs.sacwis.web.metaphor;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility;
import gov.georgia.dhr.dfcs.sacwis.web.core.metaphor.ShowTab;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;

import javax.servlet.http.HttpServletRequest;

public class DiversionCclShowTab implements ShowTab {

  public boolean showTab(String tabId, HttpServletRequest request) {
    boolean showMe = false;
    //
    if (CodesTables.CSTAGES_INV.equals(GlobalData.getSzCdStage(request))){
      CaseUtility.Stage priorStage = CaseUtility.getPriorStage(GlobalData.getUlIdStage(request));
      if (CodesTables.CSTAGES_DIV.equals(priorStage.getCdStage())){
        showMe = true;
      }
    }
    return showMe;
  }

}
