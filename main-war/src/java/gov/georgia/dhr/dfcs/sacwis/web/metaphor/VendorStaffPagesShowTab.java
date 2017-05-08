package gov.georgia.dhr.dfcs.sacwis.web.metaphor;

import javax.servlet.http.HttpServletRequest;

import gov.georgia.dhr.dfcs.sacwis.web.core.metaphor.ShowTab;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;

/*
Not used - DELETE
*/

public class VendorStaffPagesShowTab implements ShowTab {
  public boolean showTab(String tabId, HttpServletRequest request) {
    
    UserProfile user = UserProfileHelper.getUserProfile(request);
    
    return (user.hasRight(user.SEC_VENDOR_STAFF_ACCESS));
  }
}


