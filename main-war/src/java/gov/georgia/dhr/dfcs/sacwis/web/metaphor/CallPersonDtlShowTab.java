package gov.georgia.dhr.dfcs.sacwis.web.metaphor;

import javax.servlet.http.HttpServletRequest;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.web.core.metaphor.ShowTab;

/*
Filter Class used for Person Detail CALL_PERSON_DETAIL_REDISPLAY tab
*/

public class CallPersonDtlShowTab implements ShowTab {
  public boolean showTab(String tabId, HttpServletRequest request) {
    boolean showMe = false;
    String strConversation = (String) request.getAttribute(ArchitectureConstants.CONVERSATION);
    String strCommand = (String) request.getAttribute(ArchitectureConstants.COMMAND);
    if ("intake/CallInformation".equalsIgnoreCase(strConversation)
        &&
        ("displayCallPersonDetail".equalsIgnoreCase(strCommand)
         || "redisplayCallPersonDetail".equalsIgnoreCase(strCommand)
         || "saveAndStayCallPersonDetail".equalsIgnoreCase(strCommand)
         || "saveAndAddCallPersonDetail".equalsIgnoreCase(strCommand)
         || "newUsingCallPersonDetail".equalsIgnoreCase(strCommand)
         || "updateRelatedAddressPhoneInfo".equalsIgnoreCase(strCommand)
        )
        ||
        ("intake/IncomingPersonDetail".equalsIgnoreCase(strConversation)
         && "displayIncomingPersonDetail".equalsIgnoreCase(strCommand)
        )
        ||
        ("person/AddressDetail".equalsIgnoreCase(strConversation)
         && "addressDetail".equalsIgnoreCase(strCommand)
        )
        ||
        ("person/PhoneConversation".equalsIgnoreCase(strConversation)
         && "PhoneDetail".equalsIgnoreCase(strCommand)
        )
        ||
        ("person/NameHistory".equalsIgnoreCase(strConversation)
         && "displayNameHistoryDetail".equalsIgnoreCase(strCommand)
        )
        ||
        ("person/PersonIdentifiers".equalsIgnoreCase(strConversation)
         && "displayPersonIDsListSubmodule".equalsIgnoreCase(strCommand)
        )
            ) {
      showMe = true;
    }
    
    //if the records check is being used in intake, show intake person detail
    if ("person/RecordsCheck".equalsIgnoreCase(strConversation)){
      showMe = true;
    }

    return showMe;
  }
}

