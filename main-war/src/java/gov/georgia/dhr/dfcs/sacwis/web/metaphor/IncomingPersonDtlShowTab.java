package gov.georgia.dhr.dfcs.sacwis.web.metaphor;

import javax.servlet.http.HttpServletRequest;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.web.core.metaphor.ShowTab;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

/*
Filter Class used for Incoming Person Detail (INCOMING_PERSON_DETAIL_INCOMING tab) in Intake
*/

public class IncomingPersonDtlShowTab implements ShowTab {
  public boolean showTab(String tabId, HttpServletRequest request) {
    boolean showMe = false;
    if ((ArchitectureConstants.Y).equals(request.getAttribute(
            ArchitectureConstants.DISPLAY_INCOMING_PERSON_DETAIL))) {
      showMe = true;
    }
    if (("intake/IncomingPersonDetail".equalsIgnoreCase(String.valueOf(request.getAttribute(
            ArchitectureConstants.CONVERSATION)))
         && "displayIncomingPersonDetail".equalsIgnoreCase(String.valueOf(request.getAttribute(
            ArchitectureConstants.COMMAND))))) {
      showMe = true;
    }
    if ("/intake/IncomingPersonDetail/displayIncomingPersonDetail".equalsIgnoreCase(ContextHelper.getPreviousUrl(
            request))) {
      if (
              ("person/AddressDetail".equalsIgnoreCase(String.valueOf(request.getAttribute(
                      ArchitectureConstants.CONVERSATION)))
               && "addressDetail".equalsIgnoreCase(String.valueOf(request.getAttribute(ArchitectureConstants.COMMAND)))
              )
              ||
              ("person/PhoneConversation".equalsIgnoreCase(String.valueOf(request.getAttribute(
                      ArchitectureConstants.CONVERSATION)))
               && "PhoneDetail".equalsIgnoreCase(String.valueOf(request.getAttribute(ArchitectureConstants.COMMAND)))
              )
              ||
              ("person/NameHistory".equalsIgnoreCase(String.valueOf(request.getAttribute(
                      ArchitectureConstants.CONVERSATION)))
               && "displayNameHistoryDetail".equalsIgnoreCase(String.valueOf(request.getAttribute(
                      ArchitectureConstants.COMMAND)))
              )
              ||
              ("person/PersonIdentifiers".equalsIgnoreCase(String.valueOf(request.getAttribute(
                      ArchitectureConstants.CONVERSATION)))
               && "displayPersonIDsListSubmodule".equalsIgnoreCase(String.valueOf(request.getAttribute(
                      ArchitectureConstants.COMMAND)))
              )
              ) {
        showMe = true;
      }
    }
    return showMe;
  }
}