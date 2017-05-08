package gov.georgia.dhr.dfcs.sacwis.service.document.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.AllegationDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ApprovalEventLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsResourceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.NonComplianceCbxDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.NonComplianceChildDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.NonComplianceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.RsrcLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Allegation;
import gov.georgia.dhr.dfcs.sacwis.db.CapsResource;
import gov.georgia.dhr.dfcs.sacwis.db.NonCompliance;
import gov.georgia.dhr.dfcs.sacwis.db.NonComplianceCbx;
import gov.georgia.dhr.dfcs.sacwis.db.RsrcLink;
import gov.georgia.dhr.dfcs.sacwis.service.document.CorrectiveActionPlan;
import gov.georgia.dhr.dfcs.sacwis.service.document.PolicyViolationReport;
import gov.georgia.dhr.dfcs.sacwis.service.fad.RetrieveChildrenInHome;
import gov.georgia.dhr.dfcs.sacwis.service.resource.RetrieveFacilityPlacementLog;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD31SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.NonComplianceSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.PolicyViolationSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD31SIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD31SIG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD31SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD31SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD31SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FormDataGroup;
import gov.georgia.dhr.dfcs.sacwis.structs.output.NcPerson;
import gov.georgia.dhr.dfcs.sacwis.structs.output.NonComplianceSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PlacementLogSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PolicyViolationSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PreFillData;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * The PolicyViolationReportImpl class is the service for generating the 'Policy Violation Report' Form.
 * 
 * @see gov.georgia.dhr.dfcs.sacwis.service.document.DocumentService
 * @see gov.georgia.dhr.dfcs.sacwis.service.document.PolicyViolationReport
 * 
 * 
 * @author Stephen Roberts, June 6, 2008
 * 
 * <PRE>
 * 
 *  Date        User              Description
 *  --------    ----------------  --------------------------------------------------
 *  11/18/09    Patrick Coogan    Updated call to the facility placement log to set
 *                                the system indicator = to SHINES to address
 *                                regression issues tied to updates for SHINES Portal
 *  09/12/11    charden           replaced CFAD31SO with placementlogSO
 *  
 * </PRE>
 */
public class PolicyViolationReportImpl extends BaseDocumentServiceImpl implements PolicyViolationReport {

  private static final String SYS_IND_SHINES = "S";
  
  protected CapsResourceDAO capsResourceDAO;

  private StagePersonLinkDAO stagePersonLinkDAO;

  private ApprovalEventLinkDAO approvalEventLinkDAO;

  private RetrieveFacilityPlacementLog retrieveFacilityPlacementLog;

  private RetrieveChildrenInHome retrieveChildrenInHome;

  private AllegationDAO allegationDAO;

  protected NonComplianceChildDAO nonComplianceChildDAO;

  protected NonComplianceDAO nonComplianceDAO;

  protected NonComplianceCbxDAO nonComplianceCbxDAO;

  protected RsrcLinkDAO rsrcLinkDAO;

  public void setRsrcLinkDAO(RsrcLinkDAO rsrcLinkDAO) {
    this.rsrcLinkDAO = rsrcLinkDAO;
  }

  public void setRetrieveChildrenInHome(RetrieveChildrenInHome retrieveChildrenInHome) {
    this.retrieveChildrenInHome = retrieveChildrenInHome;
  }

  public void setRetrieveFacilityPlacementLog(RetrieveFacilityPlacementLog retrieveFacilityPlacementLog) {
    this.retrieveFacilityPlacementLog = retrieveFacilityPlacementLog;
  }

  public void setCapsResourceDAO(CapsResourceDAO capsResourceDAO) {
    this.capsResourceDAO = capsResourceDAO;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public void setApprovalEventLinkDAO(ApprovalEventLinkDAO approvalEventLinkDAO) {
    this.approvalEventLinkDAO = approvalEventLinkDAO;
  }

  public void setAllegationDAO(AllegationDAO allegationDAO) {
    this.allegationDAO = allegationDAO;
  }

  public void setNonComplianceChildDAO(NonComplianceChildDAO nonComplianceChildDAO) {
    this.nonComplianceChildDAO = nonComplianceChildDAO;
  }

  public void setNonComplianceDAO(NonComplianceDAO nonComplianceDAO) {
    this.nonComplianceDAO = nonComplianceDAO;
  }

  public void setNonComplianceCbxDAO(NonComplianceCbxDAO nonComplianceCbxDAO) {
    this.nonComplianceCbxDAO = nonComplianceCbxDAO;
  }

  public PolicyViolationSO retrievePolicyViolationReport(PolicyViolationSI policyViolationSI) {

    PolicyViolationSO policyViolationSO = new PolicyViolationSO();
    PreFillData preFillData = new PreFillData();

    int idStage = policyViolationSI.getUlIdStage();
    int idEvent = policyViolationSI.getUlIdEvent();
    int idNonCompliance = policyViolationSI.getUlIdNonCompliance();

    // Call private methods to generate prefill data
    int idResource = generateHeaderInformation(preFillData, idStage);
    Date violationDate = generateMainFormBookmarks(preFillData, idNonCompliance);
    generateChildrenInPlacement(preFillData, idStage, idResource, idNonCompliance);
    generateHomeMembers(preFillData, idStage);
    generatePlacementHistory(preFillData, idResource);
    generateViolationTable(preFillData, idNonCompliance, violationDate);
    generateCPSAllegationHistory(preFillData, idResource);
    generateApprovalsAndRejections(preFillData, idEvent);

    policyViolationSO.setPreFillData(preFillData);
    return policyViolationSO;
  }

  /**
   * The generateHeaderInformation method creates the data for the form heading
   * 
   * @param PreFillData
   * @param idStage
   * @return idResource
   */
  private int generateHeaderInformation(PreFillData preFillData, int idStage) {

    CapsResource capsResource = capsResourceDAO.findResourceByIdRsrcFaHomeStage(idStage);

    if (capsResource == null) {
      throw new ServiceException(Messages.MSG_NO_ROWS_RETURNED);
    } else {

      preFillData.addBookmark(createBookmark(PolicyViolationReport.HOME_NAME, capsResource.getNmResource()));
      preFillData.addBookmark(createBookmarkWithCodesTable(COUNTY_NAME, capsResource.getCdRsrcCnty(),
                                                           CodesTables.CCOUNT));
      preFillData.addBookmark(createBookmark(VENDOR_ID, capsResource.getIdResource()));
      preFillData.addBookmark(createBookmark(PolicyViolationReport.CASE_ID, capsResource.getCapsCase().getIdCase()));

      if (ArchitectureConstants.Y.equals(capsResource.getIndRsrcNonDfcs())) {
        RsrcLink rsrcLink = rsrcLinkDAO.findCapsResourceAndRsrcLink(capsResource.getIdResource(), RESOURCE_LINK_TYPE);
        FormDataGroup cpaGroup = createFormDataGroup(TMPLAT_CPA_HEADER, "");
        // First grab the name from the actual Resource Record for the
        // CPA if possible. If that's not available
        // try the NdfcsCertEntity. It could be typed in there as well.
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
      return capsResource.getIdResource();
    }

  }

  /**
   * The generateChildrenInPlacement method creates the data for the 'Children Currently In Placement' section.
   * 
   * @param PreFillData
   * @param idStage
   * @return void
   */
  private void generateChildrenInPlacement(PreFillData preFillData, int idStage, int idResource, int idNonCompliance) {
    List<Map> childrenInNonCompliance = nonComplianceChildDAO.findChildrenInNonCompliance(idNonCompliance);
    NonComplianceSI nonComplianceSI = new NonComplianceSI();
    nonComplianceSI.setIdStage(idStage);

    NonComplianceSO nonComplianceSO = retrieveChildrenInHome.retrieveChildrenInHome(nonComplianceSI);
    List<NcPerson> childrenInHome = nonComplianceSO.getChildrenInHome();
    for (Iterator<Map> it = childrenInNonCompliance.iterator(); it.hasNext();) {
      FormDataGroup childGroup = createFormDataGroup(TMPLAT_CHILD, "");
      Map child = it.next();

      // Set up the bookmarks we have in the current object
      childGroup.addBookmark(createBookmark(CHILD_NAME, (String) child.get("nmPersonFull")));
      childGroup.addBookmark(createBookmark(PolicyViolationReport.CHILD_DOB,
                                            FormattingHelper.formatDate((Date) child.get("dtPersonBirth"))));
      childGroup.addBookmark(createBookmarkWithCodesTable(CHILD_GENDER, child.get("cdPersonSex"), CodesTables.CSEX));
      childGroup.addBookmark(createBookmark(CHILD_ADOPT, child.get("indAdoptiveProcess")));
      childGroup.addBookmark(createBookmark(CHILD_INVOLVED, child.get("indHomeViolation")));

      // Placement date isn't easily pulled into the query that finds nonCompliant children. Instead the data
      // from the retrieveChildrenInHome service call will be matched against. This is solely to get the placement date
      // and this was easier than re-creating a highly complex DAO call that combined everything.
      int idChildMatch = (Integer) child.get("idPerson");
      boolean found = false;
      for (Iterator<NcPerson> ncPersIt = childrenInHome.iterator(); ncPersIt.hasNext() && !found;) {
        NcPerson ncPerson = ncPersIt.next();
        if (idChildMatch == ncPerson.getIdPerson()) {
          childGroup.addBookmark(createBookmark(CHILD_PLACEMENT_DATE,
                                                FormattingHelper.formatDate(ncPerson.getDtPlacementStart())));
          found = true;
        }
      }

      preFillData.addFormDataGroup(childGroup);
    }
  }

  /**
   * The generateHomeMembers method creates the data for the Home Members part of the form
   * 
   * @param PreFillData
   * @param idStage
   * @return void
   */
  private void generateHomeMembers(PreFillData preFillData, int idStage) {

    List<Map> homeMembers = stagePersonLinkDAO.findHomeMembersDetailLinkedToStage(idStage);

    for (Iterator<Map> it = homeMembers.iterator(); it.hasNext();) {
      FormDataGroup memberGroup = createFormDataGroup(TMPLAT_MEMBER, "");
      Map member = it.next();
      memberGroup.addBookmark(createBookmark(MEMBER_NAME, (String) member.get("nmPersonFull")));
      memberGroup.addBookmark(createBookmark(MEMBER_DOB,
                                             FormattingHelper.formatDate((Date) member.get("dtPersonBirth"))));
      memberGroup.addBookmark(createBookmarkWithCodesTable(MEMBER_GENDER, member.get("cdPersonSex"), CodesTables.CSEX));

      // Depending if the person is a person or a collateral the relationship decodes change
      if (PRINCIPAL.equals((String) member.get("cdStagePersType"))) {
        memberGroup.addBookmark(createBookmarkWithCodesTable(MEMBER_RELATIONSHIP, member.get("cdStagePersRelInt"),
                                                             CodesTables.CRPTRINT));
      } else {
        memberGroup.addBookmark(createBookmarkWithCodesTable(MEMBER_RELATIONSHIP, member.get("cdStagePersRelInt"),
                                                             CodesTables.CSRCRPTR));
      }

      preFillData.addFormDataGroup(memberGroup);
    }
  }

  /**
   * The generatePlacementHistory method creates the Placement History section
   * 
   * @param PreFillData
   * @param idResource
   * @return void
   */
  private void generatePlacementHistory(PreFillData preFillData, int idResource) {
    CFAD31SI cfad31si = new CFAD31SI();
    ROWCFAD31SIG00 rowcfad31sig00 = new ROWCFAD31SIG00();
    ROWCFAD31SIG00_ARRAY rowrowcfad31sig00List = new ROWCFAD31SIG00_ARRAY();
    ArchInputStruct input = new ArchInputStruct();
    
    input.setUsPageNbr(1);
    input.setUlPageSizeNbr(PAGE_SIZE);
    cfad31si.setArchInputStruct(input);
    cfad31si.setBWcdCdSortBy(SORT_O);
    rowcfad31sig00.setUlIdResource(idResource);
    rowrowcfad31sig00List.addROWCFAD31SIG00(rowcfad31sig00);
    cfad31si.setROWCFAD31SIG00_ARRAY(rowrowcfad31sig00List);
    cfad31si.setIndSystem(SYS_IND_SHINES);

    PlacementLogSO placementLogSO = retrieveFacilityPlacementLog.retrieveLog(cfad31si);
    CFAD31SO cfad31so = placementLogSO.getCfad31so();
    CFAD31SOG00_ARRAY placementLogArray = cfad31so.getCFAD31SOG00_ARRAY();

    if (placementLogArray != null) {

      Enumeration placementLogEnum = placementLogArray.enumerateCFAD31SOG00();

      while (placementLogEnum.hasMoreElements()) {
        CFAD31SOG00 placementRow = (CFAD31SOG00) placementLogEnum.nextElement();
        FormDataGroup placementGroup = createFormDataGroup(TMPLAT_PLACEMENT, "");

        placementGroup.addBookmark(createBookmark(PLACEMENT_NAME, placementRow.getSzNmPersonFull()));
        placementGroup.addBookmark(createBookmark(PLACEMENT_DOB,
                                                  FormattingHelper.formatDate(placementRow.getDtDtPersonBirth())));
        placementGroup.addBookmark(createBookmarkWithCodesTable(PLACEMENT_GENDER, placementRow.getCdPersonSex(),
                                                                CodesTables.CSEX));
        placementGroup.addBookmark(createBookmark(PLACEMENT_START_DATE,
                                                  FormattingHelper.formatDate(placementRow.getDtDtPlcmtStart())));
        placementGroup.addBookmark(createBookmark(PLACEMENT_END_DATE,
                                                  FormattingHelper.formatDate(placementRow.getDtDtPlcmtEnd())));
        placementGroup.addBookmark(createBookmarkWithCodesTable(PLACEMENT_REMOVAL_REASON,
                                                                placementRow.getSzCdPlcmtRemovalRsn(),
                                                                CodesTables.CPLREMRO));
        placementGroup.addBookmark(createBookmarkWithCodesTable(PLACEMENT_TYPE, placementRow.getCdPlcmtType(),
                                                                CodesTables.CPLMNTYP));

        if (ArchitectureConstants.Y.equals(placementRow.getCScrIndAdptnCnsmmtd())) {
          placementGroup.addBookmark(createBookmark(ADOPTION_FINALIZED, ArchitectureConstants.Y));
        }

        if (ArchitectureConstants.Y.equals(placementRow.getSzSblngPlcmt())) {
          placementGroup.addBookmark(createBookmark(PLACEMENT_SIBLING, ArchitectureConstants.Y));
        }
        placementGroup.addBookmark(createBookmarkWithCodesTable(PLACEMENT_LEGAL_COUNTY,
                                                                placementRow.getCdLegalStatCnty(), CodesTables.CCOUNT));
        preFillData.addFormDataGroup(placementGroup);
      }
    }
  }

  /**
   * The generateCPSAllegationHistory method creates the CPS Allegation History form section
   * 
   * @param PreFillData
   * @param idResource
   * @return void
   */
  private void generateCPSAllegationHistory(PreFillData preFillData, int idResource) {

    List<Allegation> allegationList = allegationDAO.findAllegationsForResource(idResource, INTAKE_DISPOSITION);

    for (Iterator<Allegation> it = allegationList.iterator(); it.hasNext();) {
      Allegation allegation = it.next();
      FormDataGroup allegationGroup = createFormDataGroup(PolicyViolationReport.TMPLAT_ALLEGATION, "");
      allegationGroup.addBookmark(createBookmark(ALLEGATION_DATE,
                                                 FormattingHelper.formatDate(allegation.getDtAllegedIncident())));

      allegationGroup.addBookmark(createBookmark(ALLEGATION_CODE, allegation.getCdAllegType()));
      allegationGroup.addBookmark(createBookmarkWithCodesTable(ALLEGATION_DECODE, allegation.getCdAllegType(),
                                                               CodesTables.CMALCODE));
      allegationGroup
                     .addBookmark(createBookmarkWithCodesTable(ALLEGATION_DISPOSITION,
                                                               allegation.getCdAllegDisposition(), CodesTables.CDISPSTN));
      preFillData.addFormDataGroup(allegationGroup);
    }
  }

  /**
   * The generateApprovalsAndRejections method creates the approval and rejection form sections
   * 
   * @param PreFillData
   * @param idEvent
   * @return void
   */
  protected void generateApprovalsAndRejections(PreFillData preFillData, int idEvent) {

    List<Object[]> approvalList = approvalEventLinkDAO.findApprovalsforCaseEvent(idEvent);
    for (Iterator<Object[]> it = approvalList.iterator(); it.hasNext();) {
      Object[] approvalArray = it.next();

      // Create repeating groups for approvals and rejections. Pending approvals will be
      // filtered out.
      if ("APRV".equals(approvalArray[2].toString())) {
        FormDataGroup approvalGroup = createFormDataGroup(TMPLAT_APPROVAL, "");
        approvalGroup.addBookmark(createBookmark(APPROVAL_NAME, approvalArray[0]));
        approvalGroup.addBookmark(createBookmark(APPROVAL_DATE,
                                                 FormattingHelper.formatDate((Timestamp) approvalArray[1])));
        preFillData.addFormDataGroup(approvalGroup);

      } else if ("REJT".equals(approvalArray[2].toString())) {
        FormDataGroup rejectionGroup = createFormDataGroup(TMPLAT_REJECTION, "");
        rejectionGroup.addBookmark(createBookmark(REJECTION_NAME, approvalArray[0]));
        rejectionGroup.addBookmark(createBookmark(REJECTION_DATE,
                                                  FormattingHelper.formatDate((Timestamp) approvalArray[1])));
        rejectionGroup.addBookmark(createBookmark(REJECTION_REASON, approvalArray[3]));
        preFillData.addFormDataGroup(rejectionGroup);
      }
    }
  }

  /**
   * The generateViolationTable method creates the Violation Section.
   * 
   * @param PreFillData
   * @param idNonCompliance
   * @param violationDate
   * @return void
   */
  protected void generateViolationTable(PreFillData preFillData, int idNonCompliance, Date violationDate) {

    preFillData.addBookmark(createBookmark(VIOLATION_DATE, FormattingHelper.formatDate(violationDate)));
    // Get PolicyViolation Check boxes from NonComplianceCbx table.
    List<NonComplianceCbx> nonComplianceCbxes = nonComplianceCbxDAO
                                                                   .findNonCompliancecheckboxbyIdNonComplianceandCbxCodeType(
                                                                                                                             idNonCompliance,
                                                                                                                             CodesTables.CPOLVIOL);
    Iterator<NonComplianceCbx> itrNonCompCbxes = nonComplianceCbxes.iterator();
    while (itrNonCompCbxes.hasNext()) {
      NonComplianceCbx nonComplianceCbx = (NonComplianceCbx) itrNonCompCbxes.next();
      FormDataGroup violationGroup = createFormDataGroup(CorrectiveActionPlan.TMPLAT_VIOLATION, "");
      violationGroup.addBookmark(createBookmarkWithCodesTable(VIOLATION, nonComplianceCbx.getCdNonComplianceCbx(),
                                                              CodesTables.CPOLVIOL));
      preFillData.addFormDataGroup(violationGroup);
    }
  }

  /**
   * The generateMainFormBookmarks method creates the various bookmarks throughout the form that are not in a repeating
   * group.
   * 
   * @param PreFillData
   * @param nonDFCSHome -
   *                Boolean indicating if the home is non-DFCS
   * @param idNonCompliance
   * @return Date - Date of Violation
   */
  private Date generateMainFormBookmarks(PreFillData preFillData, int idNonCompliance) {

    NonCompliance nonCompliance = nonComplianceDAO.findNonComplianceById(idNonCompliance);

    // Set the County
    preFillData.addBookmark(createBookmarkWithCodesTable(COUNTY_OF_VIOLATION, nonCompliance.getCdCounty(),
                                                         CodesTables.CCOUNT));
    preFillData.addBookmark(createBookmark(DATE_OF_VIOLATION,
                                           FormattingHelper.formatDate(nonCompliance.getDtOfViolation())));

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
    return nonCompliance.getDtOfViolation();
  }

}
