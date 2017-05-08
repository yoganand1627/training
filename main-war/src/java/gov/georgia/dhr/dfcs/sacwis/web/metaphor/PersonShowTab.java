package gov.georgia.dhr.dfcs.sacwis.web.metaphor;

import javax.servlet.http.HttpServletRequest;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.web.core.metaphor.ShowTab;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;

/*
Filter Class NOT USED
*/

public class PersonShowTab implements ShowTab {
  public boolean showTab(String tabId, HttpServletRequest request) {
    if (GlobalData.getUlIdPerson(request) != 0) {
      return true;
    }
    if (
            ("person/PersonIdentifiers".equalsIgnoreCase(String.valueOf(request.getAttribute(
                    ArchitectureConstants.CONVERSATION)))
             && "addPersonIdDetail".equalsIgnoreCase(String.valueOf(request.getAttribute(
                    ArchitectureConstants.COMMAND)))
            )
            ||
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
            ||
            ("person/PersonIdentifiers".equalsIgnoreCase(String.valueOf(request.getAttribute(
                    ArchitectureConstants.CONVERSATION)))
             && "addPersonIdDetail".equalsIgnoreCase(String.valueOf(request.getAttribute(
                    ArchitectureConstants.COMMAND)))
            )
            ||
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
             && ("displayNameHistoryDetail".equalsIgnoreCase(String.valueOf(request.getAttribute(
                    ArchitectureConstants.COMMAND)))
                 || "addName".equalsIgnoreCase(String.valueOf(request.getAttribute(ArchitectureConstants.COMMAND))))
            )
            ||
            ("person/PersonIdentifiers".equalsIgnoreCase(String.valueOf(request.getAttribute(
                    ArchitectureConstants.CONVERSATION)))
             && "displayPersonIDsListSubmodule".equalsIgnoreCase(String.valueOf(request.getAttribute(
                    ArchitectureConstants.COMMAND)))
            )
            ||
            ("person/PersonDetail".equalsIgnoreCase(String.valueOf(request.getAttribute(
                    ArchitectureConstants.CONVERSATION)))
             && ("displayPersonChar".equalsIgnoreCase(String.valueOf(request.getAttribute(
                    ArchitectureConstants.COMMAND)))
                 || "addMergeSplit".equalsIgnoreCase(String.valueOf(request.getAttribute(
                    ArchitectureConstants.COMMAND)))
                 || "addIncRsrc".equalsIgnoreCase(String.valueOf(request.getAttribute(ArchitectureConstants.COMMAND)))
                 || "addEducation".equalsIgnoreCase(String.valueOf(request.getAttribute(
                    ArchitectureConstants.COMMAND))))
            )
            ) {
      return true;
    }
    return false;
  }
}
