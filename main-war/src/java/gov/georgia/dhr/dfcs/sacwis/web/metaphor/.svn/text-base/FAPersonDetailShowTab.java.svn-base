package gov.georgia.dhr.dfcs.sacwis.web.metaphor;

import javax.servlet.http.HttpServletRequest;
import gov.georgia.dhr.dfcs.sacwis.web.core.metaphor.ShowTab;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
/*
Filter Class used for the F/A PErson Detail 3rd Level Tab under Person Tabs

*/

public class FAPersonDetailShowTab implements ShowTab {
  public boolean showTab(String tabId, HttpServletRequest request) {
    String stage = GlobalData.getSzCdStage(request);
    boolean showMe = false;
    
    PersonDtlShowTab personDtlShowTab = new PersonDtlShowTab();
    //Show tab only for FAD stage and only when person detail page shows
    if ("FAD".equals(stage)){
    
      showMe = true;
    }
    return showMe; 
  }
}