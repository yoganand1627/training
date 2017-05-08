package gov.georgia.dhr.dfcs.sacwis.web.resource;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.service.resource.Resource;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ProviderAllegationHistorySI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ProviderAllegationHistorySO;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

import javax.servlet.http.HttpServletRequest;

import org.grnds.structural.web.GrndsExchangeContext;

/**
 * Provider Allegation History Conversation
 * Author: Corey Harden
 * Date: 06/06/2011
 * 
 *                                        Change History
 *
 *   Date          User                                         Description
 * --------    ----------------  --------------------------------------------------
 *  06/20/2011 htvo              SMS#112297: set information message when no allegation tied to provider
 *  06/20/2011 htvo              SMS#112295: set program type for INV as it is required by CaseTabs to display 
 *                               second level tab 
 *
 *
 *
 *
*/



public class ProviderAllgtnHistoryConversation extends BaseHiddenFieldStateConversation {
  private Resource resource;
  
  public void setResource(Resource resource) {
    this.resource = resource;
  }



  /**
   * This method displays the Provider Allegation History page
   * @param context - the context of the application
   */
  @SuppressWarnings("unchecked")
  public void displayProviderAllgtnHistory_xa(GrndsExchangeContext context) { 
    
    // set logging information
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayProviderAllgtnHistory()");
    performanceTrace.enterScope();
    
    // get the request object and state object
    HttpServletRequest request = context.getRequest();
    
    // create transport objects
    ProviderAllegationHistorySI providerAllegationHistorySI = new ProviderAllegationHistorySI();
    ProviderAllegationHistorySO providerAllegationHistorySO = new ProviderAllegationHistorySO();
    
    // create plugin so that other pages can link to the Provider Allegation History page 
    // easily by just adding the "idResource" to the request
    String idResourceStr = StringHelper.getSafeString(request.getParameter("idResource"));
    
    // convert idResource into an int safely
    int idResource = idResourceStr != null ? Integer.parseInt(idResourceStr) : 0;
    
    // if idResource is 0, the page is not being loaded from a link... the tab has 
    // been selected from the resource context and idResource will be in the GlobalData
    if(idResource == 0){
      idResource = GlobalData.getUlIdResource(request);
    }
    
    // populate service in object - if we are accessing the page from the FAD context, there will be an idStage in Global Data
    providerAllegationHistorySI.setIdStage(GlobalData.getUlIdStage(request));
    providerAllegationHistorySI.setCdStage(StringHelper.getNonNullString(GlobalData.getSzCdStage(request)));
    providerAllegationHistorySI.setIdResource(idResource);
    
    // retrieve allegation data against home for intake and investigation stages 
    providerAllegationHistorySO = resource.retrieveProviderAllgtnHistory(providerAllegationHistorySI);
    
    // SMS#112297: set information message when no allegation tied to provider
    if (!providerAllegationHistorySO.isAllegationAvail()) {
      setInformationalMessage(Messages.MSG_NO_PROV_ALLEG_HISTORY, request);
    }
    
    // populate global data values
    GlobalData.setUlIdResource(providerAllegationHistorySO.getIdResource(), request);
    GlobalData.setSzNmCase(providerAllegationHistorySO.getNmCase(), request);
    
    // set service out object into the request
    request.setAttribute("providerAllegationHistorySO", providerAllegationHistorySO);
    
    // log time and exit method scope
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }
  
  
  /**
   * This method sets up data to be used to display the Intake Actions page
   * @param context - The GRNDS context object
   */
  public void displayIntakeActions_xa(GrndsExchangeContext context){
    
    // set logging information
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayIntakeActions_xa()");
    performanceTrace.enterScope();
    
    // store url of Records Check List page in a variable
    String forwardUrl = "/intake/IntakeActions/displayIntakeActions";
    
    // get the request
    HttpServletRequest request = context.getRequest();
    
    // set the stage codem into global data 
    GlobalData.setSzCdStage(CodesTables.CSTAGES_INT, request);

    try{
      // forward control to RecordsCheckCoversation to display the Records Check List page
      forward(forwardUrl, request, context.getResponse());
    }catch(Exception e){
      // process any exception
      processSevereException(context, e);
      return;
    }finally{
      // log time and exit method scope
      performanceTrace.getTotalTime();
      performanceTrace.exitScope();
    }
  }
  
  
  /**
   * This method sets up data to be used to display the Cps Investigation Conclusion page
   * @param context - The GRNDS context object
   */
  public void displayCpsInvCnclsn_xa(GrndsExchangeContext context){
    
    // set logging information
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayCpsInvCnclsn_xa()");
    performanceTrace.enterScope();
    
    // store url of Records Check List page in a variable
    String forwardUrl = "/investigation/CPSInvCnclsn/displayCPSInvCnclsn";
    
    // get the request
    HttpServletRequest request = context.getRequest();
    
    // get the stage id, case id and case name from the request
    int idStage = ContextHelper.getIntSafe(context, "invStageId");
    int idCase = ContextHelper.getIntSafe(request, "idCase");
    String nmCase = ContextHelper.getString(request, "nmCase");
    
    // set the stage code, stage id, case name and case id into global data 
    GlobalData.setSzCdStage(CodesTables.CSTAGES_INV, request);
    GlobalData.setUlIdStage(idStage, request);
    GlobalData.setUlIdCase(idCase, request);
    GlobalData.setSzNmCase(nmCase, request);
    //SMS#112295: cdStageProgram needed to form the metaphor tab string for INV stage (required by CaseTabs logic)
    GlobalData.setSzCdStageProgram(CodesTables.CPGRMS_CPS, request);

    // add indicator to request so that cpsInvCnclsn page will no we are coming from provider allegtn history
    request.setAttribute("forwarded", request.getRequestURI());
    
    try{
      // forward control to RecordsCheckCoversation to display the Records Check List page
      forward(forwardUrl, request, context.getResponse());
    }catch(Exception e){
      // process any exception
      processSevereException(context, e);
      return;
    }finally{
      // log time and exit method scope
      performanceTrace.getTotalTime();
      performanceTrace.exitScope();
    }
  }
}
