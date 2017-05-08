package gov.georgia.dhr.dfcs.sacwis.service.document.impl;


import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.db.CapsResource;
import gov.georgia.dhr.dfcs.sacwis.db.NonComplianceCbx;
import gov.georgia.dhr.dfcs.sacwis.db.RsrcLink;
import gov.georgia.dhr.dfcs.sacwis.db.NonCompliance;
import gov.georgia.dhr.dfcs.sacwis.dao.RsrcLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.service.document.CorrectiveActionPlan;
import gov.georgia.dhr.dfcs.sacwis.service.document.PolicyViolationReport;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CorrectiveActionSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CorrectiveActionSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FormDataGroup;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PreFillData;

/**
 * The CorrectiveActionPlanImpl class is the service for generating the 'Corrective Action Plan' Form.
 * 
 * @see gov.georgia.dhr.dfcs.sacwis.service.document.PolicyViolationReport
 * @see gov.georgia.dhr.dfcs.sacwis.service.document.CorrectiveActionPlan
 * 
 * 
 * @author Stephen Roberts, June 6, 2008
 * 
 * <PRE>
 * 
 * &lt;U&gt;Updated by:&lt;/U&gt; &lt;U&gt;Description:&lt;/U&gt; Update description
 * 
 * </PRE>
 */
public class CorrectiveActionPlanImpl extends PolicyViolationReportImpl implements CorrectiveActionPlan {

  public CorrectiveActionSO retrieveCorrectiveActionPlan(CorrectiveActionSI correctiveActionSI) {
    CorrectiveActionSO correctiveActionSO = new CorrectiveActionSO();
    PreFillData preFillData = new PreFillData();

    int idStage = correctiveActionSI.getUlIdStage();
    int idEvent = correctiveActionSI.getUlIdEvent();
    int idNonCompliance = correctiveActionSI.getUlIdNonCompliance();

    // Call private methods to generate prefill data
    boolean nonDFCSHome = generateHeaderInformation(preFillData, idStage);

    Date violationDate = generateMainFormBookmarks(preFillData, nonDFCSHome, idNonCompliance);
    generateViolationTable(preFillData, idNonCompliance, violationDate);
    generateChildrenInvolvedInViolation(preFillData, idNonCompliance);
    generateApprovalsAndRejections(preFillData, idEvent);

    correctiveActionSO.setPreFillData(preFillData);

    return correctiveActionSO;
  }

  /**
   * The generateHeaderInformation method creates the data for the form heading
   * 
   * @param PreFillData
   * @param idStage
   * @return boolean - returns true if the home is a Non-DFCS Home
   */
  private boolean generateHeaderInformation(PreFillData preFillData, int idStage) {
    boolean nonDFCSHome = false;
    CapsResource capsResource = capsResourceDAO.findResourceByIdRsrcFaHomeStage(idStage);

    if (capsResource == null) {
      throw new ServiceException(Messages.MSG_NO_ROWS_RETURNED);
    } else {

      preFillData.addBookmark(createBookmark(PolicyViolationReport.HOME_NAME, capsResource.getNmResource()));
      preFillData.addBookmark(createBookmarkWithCodesTable(COUNTY_NAME, capsResource.getCdRsrcCnty(),
                                                           CodesTables.CCOUNT));
      preFillData.addBookmark(createBookmark(VENDOR_ID, capsResource.getIdResource()));
      preFillData.addBookmark(createBookmark(PolicyViolationReport.CASE_ID, capsResource.getCapsCase().getIdCase()));

      if (ArchitectureConstants.Y.equals(capsResource.getIndRsrcNonDfcs()))  {
        nonDFCSHome = true;
        RsrcLink rsrcLink = rsrcLinkDAO.findCapsResourceAndRsrcLink(capsResource.getIdResource(), RESOURCE_LINK_TYPE);
        FormDataGroup cpaGroup = createFormDataGroup(TMPLAT_CPA_HEADER, "");
        // First grab the name from the actual Resource Record for the CPA if possible.  If that's not available
        // try the NdfcsCertEntity.  It could be typed in there as well.
        if (rsrcLink != null) {
        CapsResource cpaResource = capsResourceDAO
                                                  .findCapsResourceByIdResc(rsrcLink
                                                                                    .getCapsResourceByIdRsrcLinkParent()
                                                                                    .getIdResource());
        cpaGroup.addBookmark(createBookmark(CPA_NAME, cpaResource.getNmResource()));
      } else {
        cpaGroup.addBookmark(createBookmark(CPA_NAME, capsResource.getNdfcsCertEntity()));
      }
        
      preFillData.addFormDataGroup(cpaGroup);
        
      }

      return nonDFCSHome;
    }
  }

  /**
   * The generateChildrenInvolvedInViolation method creates the data for the 'Children Involved in Violation' section
   * 
   * @param PreFillData
   * @param idNonCompliance
   * @return void
   */
  private void generateChildrenInvolvedInViolation(PreFillData preFillData, int idNonCompliance) {
    List<Map> childrenInViolation = nonComplianceChildDAO.findChildrenInViolation(idNonCompliance);
    for (Iterator<Map> it = childrenInViolation.iterator(); it.hasNext();) {
      FormDataGroup childGroup = createFormDataGroup(TMPLAT_CHILD, "");
      Map child = it.next();
      childGroup.addBookmark(createBookmark(CHILD_NAME, (String) child.get("nmPersonFull")));
      childGroup.addBookmark(createBookmark(PolicyViolationReport.CHILD_DOB,
                                            FormattingHelper.formatDate((Date) child.get("dtPersonBirth"))));
      childGroup.addBookmark(createBookmarkWithCodesTable(CHILD_GENDER, child.get("cdPersonSex"), CodesTables.CSEX));
      childGroup.addBookmark(createBookmark(CHILD_ADOPT, child.get("indAdoptiveProcess")));
      preFillData.addFormDataGroup(childGroup);
    }
  }

  /**
   * The generateMainFormBookmarks method creates the various bookmarks throughout the form that are not in a repeating
   * group.
   * 
   * @param PreFillData
   * @param nonDFCSHome - Boolean indicating if the home is non-DFCS
   * @param idNonCompliance
   * @return Date - Date of Violation
   */
  private Date generateMainFormBookmarks(PreFillData preFillData, boolean nonDFCSHome, int idNonCompliance) {

    if (nonDFCSHome) {
      preFillData.addBookmark(createBookmark(HOME_TYPE, "Non-DFCS"));
      preFillData.addFormDataGroup(createFormDataGroup(TMPLAT_PRU_SIGNATURE, ""));
    } else {
      preFillData.addBookmark(createBookmark(HOME_TYPE, "DFCS"));
    }

    NonCompliance nonCompliance = nonComplianceDAO.findNonComplianceById(idNonCompliance);

    // Set the County
    preFillData.addBookmark(createBookmarkWithCodesTable(COUNTY_PLAN, nonCompliance.getCdCounty(), CodesTables.CCOUNT));

    // Set the Plan Dates
    preFillData.addBookmark(createBookmark(EFFECTIVE_FROM_DATE,
                                           FormattingHelper.formatDate(nonCompliance.getDtEffectFrom())));
    preFillData.addBookmark(createBookmark(EFFECTIVE_TO_DATE,
                                           FormattingHelper.formatDate(nonCompliance.getDtEffectTo())));
    // State Office Signature section.
    if (ArchitectureConstants.Y.equals(nonCompliance.getIndStOffConcurrence())) {
      preFillData.addBookmark(createBookmark(YES_SO_CONCURRENCE, "X"));
      preFillData.addBookmark(createBookmark(DATE_SO_CONCURRENCE,
                                             FormattingHelper.formatDate(nonCompliance.getDtStOffConcurrence())));
    }

    if (ArchitectureConstants.N.equals(nonCompliance.getIndStOffConcurrence())) {
      preFillData.addBookmark(createBookmark(NO_SO_CONCURRENCE, "X"));
      preFillData.addBookmark(createBookmark(DATE_SO_CONCURRENCE,
                                             FormattingHelper.formatDate(nonCompliance.getDtStOffConcurrence())));
    }

    // Show the CPA Concurrence section if a non-dfcs home
    if (nonDFCSHome) {
      FormDataGroup cpaGroup = createFormDataGroup(TMPLAT_CPA_CONCURRENCE, "");
      if (ArchitectureConstants.Y.equals(nonCompliance.getIndCpaConcurrence())) {
        cpaGroup.addBookmark(createBookmark(YES_CPA_CONCURRENCE, "X"));
        cpaGroup.addBookmark(createBookmark(DATE_CPA_CONCURRENCE,
                                               FormattingHelper.formatDate(nonCompliance.getDtStOffConcurrence())));
      }

      if (ArchitectureConstants.N.equals(nonCompliance.getIndCpaConcurrence())) {
        cpaGroup.addBookmark(createBookmark(NO_CPA_CONCURRENCE, "X"));
        cpaGroup.addBookmark(createBookmark(DATE_CPA_CONCURRENCE,
                                               FormattingHelper.formatDate(nonCompliance.getDtCpaConcurrence())));
      } 
      preFillData.addFormDataGroup(cpaGroup);

      cpaGroup = createFormDataGroup(TMPLAT_CPA_TEXT1, "");
      preFillData.addFormDataGroup(cpaGroup);
      
      cpaGroup = createFormDataGroup(TMPLAT_CPA_TEXT2, "");
      preFillData.addFormDataGroup(cpaGroup);
      
    }

    return nonCompliance.getDtOfViolation();
  }
   
}
