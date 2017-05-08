package gov.georgia.dhr.dfcs.sacwis.web.person;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility;
import gov.georgia.dhr.dfcs.sacwis.service.person.Person;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.service.person.Person;
import gov.georgia.dhr.dfcs.sacwis.structs.input.FAPersonDetailRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FAPersonDetailRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.FAPersonDetailSaveSI;

/**
 * FAPersonDetail Custom validation class <p>Description:  This class verifies all of the information in the FA Person Detail
 * conversation </p> <p>Copyright: Copyright (c) 2007</p> <p>Company: Accenture </p>
 *
 * @author Lata Lokhande
 * 
 *          <p/>
 *          Change History: Date         User               Description 
 *                          4/11/2008    Courtney Wells     Doing null check before preforming Date check
 *                          2/24/2011    Hai Nguyen         SMS#97850: MR-075 Removed validation for date field
 *                                                          that is now calculated and read-only.
 */

public class FAPersonDetailCustomValidation extends FormValidation {
  public static final String TRACE_TAG = "FAPersonDetailCustomValidation";
  protected boolean validateForm() {
    boolean valid = true;
    
//  Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".validationForm()");
    performanceTrace.enterScope();

    HttpServletRequest request = this.getRequest();
        
    return valid;

  
  
}
}
