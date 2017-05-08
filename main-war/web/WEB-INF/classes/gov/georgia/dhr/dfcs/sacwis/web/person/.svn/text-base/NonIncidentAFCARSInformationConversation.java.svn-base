package gov.georgia.dhr.dfcs.sacwis.web.person;

import javax.servlet.http.HttpServletRequest;
import org.grnds.structural.web.GrndsExchangeContext;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.service.adoexchange.AdoExchange;
import gov.georgia.dhr.dfcs.sacwis.structs.input.NonIncidentAFCARSInformationSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.NonIncidentAFCARSInformationSO;

/**
 * This is the conversation class used to maintain Non-Incident AFCARS Information detail in the system. <p/>
 * 
 * <pre>
 *   Change History:
 *   Date      User      Description
 *   --------  --------  --------------------------------------------------
 *   07/08/08  mchillman Creation
 *   09/22/08  swroberts Added business logic for the display and save methods
 *   02/04/09  wjcochran STGAP00012148: Added Mother Married At Birth Indicator
 *   02/26/09  wjcochran STGAP00012148: Removed logic to save Mother Married at Birth info
 *                       since this information is display-only on the page
 * </pre>
 */
public class NonIncidentAFCARSInformationConversation extends BaseHiddenFieldStateConversation {
  public static final String PAGE_MODE = PageMode.PAGE_MODE_ATTRIBUTE_NAME;

  private AdoExchange adoExchange;

  public void setAdoExchange(AdoExchange adoExchange) {
    this.adoExchange = adoExchange;
  }

  /**
   * This method is used to display the Non-Incident AFCARS Information Page.
   * 
   * @param context
   * @return void
   */  
  public void displayAFCARSInformation_xa(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    UserProfile user = UserProfileHelper.getUserProfile(context);
    
    NonIncidentAFCARSInformationSI nonIncidentAFCARSInformationSI = new NonIncidentAFCARSInformationSI();
    nonIncidentAFCARSInformationSI.setIdPerson(GlobalData.getUlIdPerson(request));
    nonIncidentAFCARSInformationSI.setIdStage(GlobalData.getUlIdStage(request));
    nonIncidentAFCARSInformationSI.setIdCase(GlobalData.getUlIdCase(request));
    int idStage = GlobalData.getUlIdStage(request);
    
    // Call the service to populate the page /
    NonIncidentAFCARSInformationSO nonIncidentAFCARSInformationSO = adoExchange.retrieveNonIncidentAFCARSInformation(nonIncidentAFCARSInformationSI);     
    state.setAttribute("nonIncidentAFCARSInformationSO", nonIncidentAFCARSInformationSO, request);
    
    PageMode.setPageMode(PageModeConstants.VIEW, request);
    
    // Set the page in modifiable mode if (the user has access OR has the SAU profile) and  the stage is open.
    if (CaseUtility.hasStageAccess(user.getUserID(), idStage) || user.hasRight(UserProfile.SEC_SAU_EXCHANGE)) {
      CaseUtility.Stage thisStage = CaseUtility.getStage(idStage);
      if (!StringHelper.isTrue(thisStage.getIndStageClose())) {
        PageMode.setPageMode(PageModeConstants.MODIFY, request);
      }
    }

  }

  /**
   * This method is used to save the Non-Incident AFCARS Information Page.
   * 
   * @param context
   * @return void
   */  
  public void saveAFCARSInformation_xa(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    NonIncidentAFCARSInformationSI nonIncidentAFCARSInformationSI = populateNonIncidentAFCARSInformationSI(context);

    try {
      adoExchange.saveNonIncidentAFCARSInformation(nonIncidentAFCARSInformationSI);
      setInformationalMessage(Messages.MSG_DATABASE_SAVE_SUCCESS, context.getRequest());
    } catch (ServiceException e) {
      if (Messages.MSG_CMN_TMSTAMP_MISMATCH == e.getErrorCode()) {
        setErrorMessage(e.getErrorCode(), request);
      } else {
        processSevereException(context, e);
      }
    }

  }

  /**
   * This method is used to populate the input object when saving the Non-Incident AFCARS Information Page.
   * 
   * @param context
   * @return void
   */    
  private NonIncidentAFCARSInformationSI populateNonIncidentAFCARSInformationSI (GrndsExchangeContext context)
  {
    NonIncidentAFCARSInformationSI nonIncidentAFCARSInformationSI = new NonIncidentAFCARSInformationSI ();
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    
    NonIncidentAFCARSInformationSO nonIncidentAFCARSInformationSO = (NonIncidentAFCARSInformationSO) state.getAttribute("nonIncidentAFCARSInformationSO", request);
    
    nonIncidentAFCARSInformationSI.setDtLastUpdate(nonIncidentAFCARSInformationSO.getDtLastUpdate());
    nonIncidentAFCARSInformationSI.setIdPerson(GlobalData.getUlIdPerson(request));
    nonIncidentAFCARSInformationSI.setIdCase(GlobalData.getUlIdCase(request));
    nonIncidentAFCARSInformationSI.setIdStage(GlobalData.getUlIdStage(request));
    
    // Populate Child Characteristics
    nonIncidentAFCARSInformationSI.setDtApplicationSent(ContextHelper.getJavaDateSafe(context, "dtApplicationSent"));
    nonIncidentAFCARSInformationSI.setIndMentRetard(CheckboxHelper.getCheckboxValue(request, "cbxMntlRetard"));
    nonIncidentAFCARSInformationSI.setIndVisHearImp(CheckboxHelper.getCheckboxValue(request, "cbxVislHearImp"));
    nonIncidentAFCARSInformationSI.setIndPhyDisabled(CheckboxHelper.getCheckboxValue(request, "cbxPhyDisabled"));
    nonIncidentAFCARSInformationSI.setIndEmtDisturbed(CheckboxHelper.getCheckboxValue(request, "cbxEmtDisturbed"));
    nonIncidentAFCARSInformationSI.setIndOthMedDiag(CheckboxHelper.getCheckboxValue(request, "cbxOthMedDiag"));
    
    nonIncidentAFCARSInformationSI.setCdSevMentRetard(ContextHelper.getStringSafe(context, "szCdMntRetSevLevel"));
    nonIncidentAFCARSInformationSI.setCdSevVisHearImp(ContextHelper.getStringSafe(context, "szCdVisHearSevLevel"));
    nonIncidentAFCARSInformationSI.setCdSevPhyDisabled(ContextHelper.getStringSafe(context, "szCdPhyDisSevLevel"));
    nonIncidentAFCARSInformationSI.setCdSevEmtDisturbed(ContextHelper.getStringSafe(context, "szCdEmtDistSevLevel"));
    nonIncidentAFCARSInformationSI.setCdSevOthMedDiag(ContextHelper.getStringSafe(context, "szCdOthMedDiagSevLevel"));
    
    nonIncidentAFCARSInformationSI.setCdPrimSpecNeed(ContextHelper.getStringSafe(context,"szCdPrmSpcNeed"));
    
    // Populate Child Birth Information
    nonIncidentAFCARSInformationSI.setNmBirthNameFirst(ContextHelper.getStringSafe(context, "txtSzNmBirthNameFirst"));
    nonIncidentAFCARSInformationSI.setNmBirthNameMiddle(ContextHelper.getStringSafe(context, "txtSzNmBirthNameMiddle"));
    nonIncidentAFCARSInformationSI.setNmBirthNameLast(ContextHelper.getStringSafe(context, "txtSzNmBirthNameLast"));
    
    // Populate Birth Mother Information
    nonIncidentAFCARSInformationSI.setDtBirthMotherDOB(ContextHelper.getJavaDateSafe(context, "txtDtBMDOB"));
    nonIncidentAFCARSInformationSI.setCdBirthMotherTermType(ContextHelper.getStringSafe(context, "szCdBMTermType"));
    nonIncidentAFCARSInformationSI.setDtBirthMotherRightsTerm(ContextHelper.getJavaDateSafe(context, "txtDtBMRightsTerm"));
    
    String[] motherRaceValues = CheckboxHelper.getCheckedValues(request, "cbxMotherRace");
    
    for (int x=0; x < motherRaceValues.length; x++)
    {
      if (CodesTables.CRACE_AA.equals(motherRaceValues[x]))
        nonIncidentAFCARSInformationSI.setIndBMRaceAA(ArchitectureConstants.Y);
      
      if (CodesTables.CRACE_AN.equals(motherRaceValues[x]))
        nonIncidentAFCARSInformationSI.setIndBMRaceAN(ArchitectureConstants.Y);
      
      if (CodesTables.CRACE_BK.equals(motherRaceValues[x]))
        nonIncidentAFCARSInformationSI.setIndBMRaceBK(ArchitectureConstants.Y);
      
      if (CodesTables.CRACE_HP.equals(motherRaceValues[x]))
        nonIncidentAFCARSInformationSI.setIndBMRaceHP(ArchitectureConstants.Y);      
 
      if (CodesTables.CRACE_UD.equals(motherRaceValues[x]))
        nonIncidentAFCARSInformationSI.setIndBMRaceUD(ArchitectureConstants.Y);   
      
      if (CodesTables.CRACE_WT.equals(motherRaceValues[x]))
        nonIncidentAFCARSInformationSI.setIndBMRaceWT(ArchitectureConstants.Y);     
    }
    
    nonIncidentAFCARSInformationSI.setCdBMEthnicity(ContextHelper.getStringSafe(context, "rbMotherEthnicity"));
    
    // Populate Birth Father Information
    nonIncidentAFCARSInformationSI.setDtBirthFatherDOB(ContextHelper.getJavaDateSafe(context, "txtDtBFDOB"));
    nonIncidentAFCARSInformationSI.setCdBirthFatherTermType(ContextHelper.getStringSafe(context, "szCdBFTermType"));
    nonIncidentAFCARSInformationSI.setDtBirthFatherRightsTerm(ContextHelper.getJavaDateSafe(context, "txtDtBFRightsTerm"));
    
    String[] fatherRaceValues = CheckboxHelper.getCheckedValues(request, "cbxFatherRace");
    
    for (int x=0; x < fatherRaceValues.length; x++)
    {
      if (CodesTables.CRACE_AA.equals(fatherRaceValues[x]))
        nonIncidentAFCARSInformationSI.setIndBFRaceAA(ArchitectureConstants.Y);
      
      if (CodesTables.CRACE_AN.equals(fatherRaceValues[x]))
        nonIncidentAFCARSInformationSI.setIndBFRaceAN(ArchitectureConstants.Y);
      
      if (CodesTables.CRACE_BK.equals(fatherRaceValues[x]))
        nonIncidentAFCARSInformationSI.setIndBFRaceBK(ArchitectureConstants.Y);
      
      if (CodesTables.CRACE_HP.equals(fatherRaceValues[x]))
        nonIncidentAFCARSInformationSI.setIndBFRaceHP(ArchitectureConstants.Y);      
 
      if (CodesTables.CRACE_UD.equals(fatherRaceValues[x]))
        nonIncidentAFCARSInformationSI.setIndBFRaceUD(ArchitectureConstants.Y);   
      
      if (CodesTables.CRACE_WT.equals(fatherRaceValues[x]))
        nonIncidentAFCARSInformationSI.setIndBFRaceWT(ArchitectureConstants.Y);     
    }
    
    nonIncidentAFCARSInformationSI.setCdBFEthnicity(ContextHelper.getStringSafe(context, "rbFatherEthnicity"));    
     
    return nonIncidentAFCARSInformationSI;
  }
}
