package gov.georgia.dhr.dfcs.sacwis.service.document.impl;

import gov.georgia.dhr.dfcs.sacwis.core.exception.RuntimeWrappedException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.jdbchelper.JdbcHelper;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsCaseDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.investigation.InvCnclsnDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.investigation.InvCnclsnEventValueBean;
import gov.georgia.dhr.dfcs.sacwis.dao.investigation.RiskAssmtDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.investigation.RiskAssmtPriorHistoryValueBean;
import gov.georgia.dhr.dfcs.sacwis.dao.investigation.RiskAssmtValueBean;
import gov.georgia.dhr.dfcs.sacwis.dao.investigation.RiskFactorValueBean;
import gov.georgia.dhr.dfcs.sacwis.service.document.RiskAssmtForm;
import gov.georgia.dhr.dfcs.sacwis.structs.input.RISKASSMTFORMSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FormDataGroup;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PreFillData;
import gov.georgia.dhr.dfcs.sacwis.structs.output.RISKASSMTFORMSO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.facility.log.GrndsLogger;

public class RiskAssmtFormImpl extends BaseDocumentServiceImpl implements RiskAssmtForm {
  private static final String TRACE_TAG = "RiskAssmtFormImpl";

  private CapsCaseDAO capsCaseDAO;

  public void setCapsCaseDAO(CapsCaseDAO capsCaseDAO) {
    this.capsCaseDAO = capsCaseDAO;
  }

  public RISKASSMTFORMSO retrieveContactVisitationsLog(RISKASSMTFORMSI riskAssmtFormsi) {
    RISKASSMTFORMSO riskAssmtFormso = new RISKASSMTFORMSO();
    RiskAssmtValueBean searchBean = new RiskAssmtValueBean();
    RiskAssmtValueBean riskAssmtBean;

    int idCase = riskAssmtFormsi.getUlIdCase();

    String caseName = capsCaseDAO.findNmCaseByIdCase(idCase);
    if (caseName == null) {
      throw new ServiceException(Messages.MSG_NO_ROWS_RETURNED);
    }

    searchBean.setCaseId(idCase);
    searchBean.setStageId(riskAssmtFormsi.getUlIdStage());
    searchBean.setEventId(riskAssmtFormsi.getUlIdEvent());

    riskAssmtBean = getRiskAssmtBean(searchBean);
    if (riskAssmtBean == null) {
      throw new ServiceException(Messages.MSG_NO_ROWS_RETURNED);
    }

    PreFillData preFillData = getRiskAssmtHeadings(idCase, caseName);

    getRiskAssmtPurpose(preFillData, riskAssmtBean);
    getRiskAssmtSummary(preFillData, riskAssmtBean);
    getFactorsByAreaAndCategory(preFillData, riskAssmtBean);
    getPriorHistory(preFillData, riskAssmtBean);
    getInvestigationActions(preFillData, riskAssmtBean);
    getFamilyStrengthAssmnt(preFillData, riskAssmtBean);
    riskAssmtFormso.setPreFillData(preFillData);

    return riskAssmtFormso;

  }

  /*
   * Get the detail data about the heading given a specific case number
   */
  private PreFillData getRiskAssmtHeadings(int idCase, String caseName) {
    PreFillData preFillData = new PreFillData();

    preFillData.addBookmark(createBookmark("TITLE_CASE_NAME", caseName));
    preFillData.addBookmark(createBookmark("TITLE_CASE_NUMBER", idCase));

    return preFillData;
  }

  /**
   * Get from the database the detail of a specific risk assessment given a search criteria.
   *
   * @param searchBean
   * @return
   */
  private RiskAssmtValueBean getRiskAssmtBean(RiskAssmtValueBean searchBean) {
    // TODO: Rewrite this method so it doesn't depend on explicit connection management.
    Connection connection = null;
    RiskAssmtValueBean returnBean = null;
    try {
      connection = JdbcHelper.getConnection();
      RiskAssmtDAO riskAssmtDAO = new RiskAssmtDAO(connection);
      returnBean = riskAssmtDAO.queryRiskAssmtDetails(searchBean);
      List<RiskAssmtPriorHistoryValueBean> reportBean = riskAssmtDAO.queryRiskHistoryReport(searchBean);
      // returnBean.setReports(riskAssmtDAO.queryRiskHistoryReport(searchBean));
      if (returnBean != null) {
        returnBean.setSzUserLoginId(searchBean.getSzUserLoginId());
        returnBean.setUlPersonId(searchBean.getUlPersonId());
        returnBean.setReports(reportBean);
        // Get the data for the Investigation Conclusion Event related to this
        // risk assessment.
        InvCnclsnEventValueBean invCnclsnEventSearchBean = new InvCnclsnEventValueBean();
        invCnclsnEventSearchBean.setCaseId(searchBean.getCaseId());
        invCnclsnEventSearchBean.setStageId(searchBean.getStageId());

        InvCnclsnDAO invCnclsnDAO = new InvCnclsnDAO(connection);
        InvCnclsnEventValueBean invCnclsnEventReturnBean =
                invCnclsnDAO.queryInvestigationConclusionEvent(invCnclsnEventSearchBean);
        returnBean.setInvestigationConclusionEvent(invCnclsnEventReturnBean);

      } // end if( returnBean != null )
    } catch (ServiceException we) {
      GrndsTrace.msg(TRACE_TAG, 7, "ServiceException in queryRiskAssmt(): " + we.getMessage());
      throw we;
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception getting connection and calling DAO: " + e.getMessage());
      throw new RuntimeWrappedException(e);
    } finally {
      try {
        connection.close();
      } catch (SQLException e) {
        // Ignore this
      }
      GrndsTrace.exitScope();
    }
    return returnBean;
  }

  /*
   * Get the Purpose for the specific Risk Assessment.
   */
  private void getRiskAssmtPurpose(PreFillData preFillData, RiskAssmtValueBean riskAssmtBean) {

    if (riskAssmtBean.getPurpose() != null) {
      preFillData
              .addBookmark(createBookmark("RISK_ASSMT_PURPOSE", Lookup.simpleDecodeSafe(CodesTables.CPURPRSK,
                                                                                        riskAssmtBean.getPurpose())));
    }
    if (riskAssmtBean.getDateResponse() != null) {
      preFillData.addBookmark(createBookmark("RISK_ASSMT_RESP_DATE",
                                             FormattingHelper.formatDate(riskAssmtBean.getDateResponse())));
      preFillData.addBookmark(createBookmark("RISK_ASSMT_RESP_TIME", riskAssmtBean.getTmResponse()));
    }
    if (riskAssmtBean.getIndResponse() != null) {
      String indResponse = riskAssmtBean.getIndResponse();
      String response = "No";
      if ("Y".equals(indResponse)) {
        response = "Yes";
      }

      preFillData.addBookmark(createBookmark("RISK_ASSMT_RESP_TIME_MET", response));
    }

  }

  /*
   * Build the summary list of all area of all categories. Start each area with the overall area of concern category
   * followed by the list of categories for that area. Show the result for each of the categories
   */
  private void getRiskAssmtSummary(PreFillData preFillData, RiskAssmtValueBean riskAssmtBean) {
    RiskFactorValueBean riskFactorBean;
    //FormDataGroup group = null;
    FormDataGroup summaryGroup = null;
    String previousAreaCode = null;
    String previousCategoryCode = null;

    Iterator factorBeansIterator = riskAssmtBean.getFactors().iterator();

    while (factorBeansIterator.hasNext()) {
      riskFactorBean = (RiskFactorValueBean) factorBeansIterator.next();
      if (riskFactorBean != null) {
        if (previousAreaCode == null || !previousAreaCode.equals(riskFactorBean.getAreaCode())) {
          summaryGroup = createOverallSummaryRow(riskFactorBean);
          preFillData.addFormDataGroup(summaryGroup);
        } // end AreaCode

        // If 'previousCategoryCode' is null, then display the current Category
        // since it is the very first one for this Area. Also display the Category
        // if is different from the previous one.
        if (previousCategoryCode == null || !previousCategoryCode.equals(riskFactorBean.getCategoryCode())) {
          // group = createSummaryRow(riskFactorBean, "C");
          addSummaryCategoryRow(summaryGroup, riskFactorBean);
        } // end checking categoryCode
        previousAreaCode = riskFactorBean.getAreaCode();
        previousCategoryCode = riskFactorBean.getCategoryCode();
      } // end riskFactorBean != null
    }
  } // end getRiskAssmtSummary

  /*
   * Create the overall category for an area and show it's area of concern result
   */
  private FormDataGroup createOverallSummaryRow(RiskFactorValueBean riskFactorBean) {
    FormDataGroup group = createFormDataGroup(TMPLAT_SUMMARY, CFA02O00);
    String cdScaleOfConcern = riskFactorBean.getAreaScaleOfConcern();
    if (riskFactorBean.getAreaText() != null) {
      String areaOfConcern = "Overall " + riskFactorBean.getAreaText();
      group.addBookmark(createBookmark(SUMMARY_OVRLL_AREA_OF_CONCERN, areaOfConcern));

      // If the Overall Scale of Concern is not null, then display the
      // appropriate decode. If the Overall Scale of Concern is null,
      // display "Not Complete".
      String scaleOfConcern;
      if (cdScaleOfConcern != null) {
        scaleOfConcern = Lookup.simpleDecodeSafe("CRISKSOC", cdScaleOfConcern);
      } else {
        scaleOfConcern = "Not Complete";
      }
      group.addBookmark(createBookmark(SUMMARY_OVRLL_SCALE_OF_CONCERN, scaleOfConcern));
    }
    return group;
  }

  private void addSummaryCategoryRow(FormDataGroup overallSummaryGrp, RiskFactorValueBean riskFactorBean) {

    overallSummaryGrp.addFormDataGroup(createSummaryCategoryRow(riskFactorBean));
  }

  /*
   * Create the category for an area and show it's area of concern result
   */
  private FormDataGroup createSummaryCategoryRow(RiskFactorValueBean riskFactorBean) {
    FormDataGroup group = createFormDataGroup(TMPLAT_SUMMARY_CATEGORY, CFA02O00);
    String areaOfConcern;
    String cdScaleOfConcern;
    String scaleOfConcern;

    // category level
    areaOfConcern = riskFactorBean.getCategoryText();
    cdScaleOfConcern = riskFactorBean.getCategoryScaleOfConcern();

    if (areaOfConcern != null) {
      group.addBookmark(createBookmark(SUMMARY_AREA_OF_CONCERN, areaOfConcern));

      // If the Overall Scale of Concern is not null, then display the
      // appropriate decode. If the Overall Scale of Concern is null,
      // display "Not Complete".
      if (cdScaleOfConcern != null) {
        scaleOfConcern = Lookup.simpleDecodeSafe("CRISKSOC", cdScaleOfConcern);
      } else {
        scaleOfConcern = "Not Complete";
      }
      group.addBookmark(createBookmark(SUMMARY_SCALE_OF_CONCERN, scaleOfConcern));
    }

    return group;
  }

  /*
   * Build the list of factors for an area and sort them by category. End each categor with the overall category area 
   * of concern.
   */
  private void getFactorsByAreaAndCategory(PreFillData preFillData, RiskAssmtValueBean riskAssmtBean) {

    // ---------------------------------
    // --- GROUP THE FACTORS BY AREA ---
    // ---------------------------------
    // Iterate through the factor beans for this Risk Assessment and display
    // each the data as needed. The factor bean will contain data pertaining
    // to the Factor and the Area and Category to which the factor belongs.
    List riskFactorBeansList = (ArrayList) riskAssmtBean.getFactors();
    int numOfFactors = riskFactorBeansList.size();
    RiskFactorValueBean currentRiskFactorBean;
    RiskFactorValueBean nextRiskFactorBean;
    RiskFactorValueBean nextFactorBeanInSameArea;
    List<RiskFactorValueBean> factorBeansInSameArea = new ArrayList<RiskFactorValueBean>();
    List<List<RiskFactorValueBean>> factorBeansByArea = new ArrayList<List<RiskFactorValueBean>>();

    for (int i = 0; i < numOfFactors; i++) {
      // Get the current factor bean.
      currentRiskFactorBean = (RiskFactorValueBean) riskFactorBeansList.get(i);

      // Get the next factor bean if one is available.
      nextRiskFactorBean = null;
      if (i < (numOfFactors - 1)) {
        nextRiskFactorBean = (RiskFactorValueBean) riskFactorBeansList.get(i + 1);
      }

      // If this is the first iteration through the loop, then add the current
      // factor bean to the array of factorBeansInSameArea. It will be the first
      // bean in the array.
      if (i == 0) {
        factorBeansInSameArea.add(currentRiskFactorBean);
      }
      // If the current factor bean is the last bean in the factor beans array,
      // or if the next factor bean is in a different Area from the current factor
      // bean, then the current factor bean is the final bean to be added the
      // factorBeansInSameArea array. Add the bean to the array, and add the array
      // to the factorBeansByArea parent array.
      else if (nextRiskFactorBean == null
               || !currentRiskFactorBean.getAreaCode().equals(nextRiskFactorBean.getAreaCode())) {
        factorBeansInSameArea.add(currentRiskFactorBean);
        factorBeansByArea.add(factorBeansInSameArea);

        // If the current factor bean is not the last bean in the factor beans
        // array, then reset the factorBeansInSameArea array so that we can start
        // adding factor beans to it during the next iteration through the loop.
        factorBeansInSameArea = null;
        if (nextRiskFactorBean != null) {
          factorBeansInSameArea = new ArrayList<RiskFactorValueBean>();
        }
      }
      // Add the current factor bean to the factorBeansInSameArea array.
      else {
        factorBeansInSameArea.add(currentRiskFactorBean);
      }
    }// end for loop

    // -----------------------------------
    // --- DISPLAY THE FACTORS BY AREA ---
    // -----------------------------------
    // Get the total number of Areas in the Risk Assessment.
    int numOfAreas = factorBeansByArea.size();
    FormDataGroup areaGroup;
    FormDataGroup categoryGroup;
    FormDataGroup factorGroup;

    // Loop through the array of factorBeansByArea. Get each factorBeansInSameArea
    // array which contains all the factors in the same area. Then loop through each
    // of those arrays and display the Areas of Concern one at a time. Each Area of
    // Concern will appear in its own expandable section.
    for (int j = 0; j < numOfAreas; j++) {
      factorBeansInSameArea = factorBeansByArea.get(j);
      nextFactorBeanInSameArea = factorBeansInSameArea.get(0);

      // Each iteration through the parent loop will create a new Area of Concern
      // expandable section. Start the expandable section here.
      areaGroup = createAreaOfConcern(nextFactorBeanInSameArea);
      preFillData.addFormDataGroup(areaGroup);

      // Display the header for this Area of Concern's first Category.
      categoryGroup = createAreaCategoryGroup(nextFactorBeanInSameArea);
      areaGroup.addFormDataGroup(categoryGroup);

      numOfFactors = factorBeansInSameArea.size();
      for (int k = 0; k < numOfFactors; k++) {
        // Get the current factor bean.
        currentRiskFactorBean = factorBeansInSameArea.get(k);

        // Get the next factor bean if one is available.
        nextRiskFactorBean = null;
        if (k < (numOfFactors - 1)) {
          nextRiskFactorBean = factorBeansInSameArea.get(k + 1);
        }

        // Display the current factor. (Also, temporarily save the class
        // used for this table row so that if this factor has comments,
        // the comments row, which is the next table row, will have the
        // same background color.)
        factorGroup = createAreaFactor(currentRiskFactorBean);
        categoryGroup.addFormDataGroup(factorGroup);

        // If there are no more factors in the current Category, then finish the
        // Category by displaying the Category Overall Scale of Concern.
        if (nextRiskFactorBean == null
            || !currentRiskFactorBean.getCategoryCode().equals(nextRiskFactorBean.getCategoryCode())) {
          // Dynamically create the name to be used for the Category's
          // Dynamically create the name and label to be used for the
          // Category's Overall Scale of Concern drop-down field.
          addCategoryScaleOfConcern(categoryGroup, currentRiskFactorBean);
        }

        // If a new Category will start in the next iteration of the loop,
        // then display the Category header here.
        if (nextRiskFactorBean != null
            && !currentRiskFactorBean.getCategoryCode().equals(nextRiskFactorBean.getCategoryCode())) {
          categoryGroup = createAreaCategory(nextRiskFactorBean);
          areaGroup.addFormDataGroup(categoryGroup);
        }

      }// end inner for

      // Each iteration through the parent loop will create a new Area of Concern
      // expandable section. End the expandable section here.
      // If there are no more factors in this Area of Concern, then finish
      // the Area of Concern by displaying the Area of Concern's Overall
      // Scale of Concern.
      addAreaScaleOfConcern(areaGroup, nextFactorBeanInSameArea);
    }// end outer for

  } // end getFactorsByAreaAndCategory)()

  /*
   * Create the area of concern for the Area
   */
  private FormDataGroup createAreaOfConcern(RiskFactorValueBean riskFactorBean) {
    FormDataGroup group = createFormDataGroup(TMPLAT_AREA, CFA02O00);
    group.addBookmark(createBookmark(AREA_AREA_OF_CONCERN, riskFactorBean.getAreaText()));

    return group;
  } // end createAreaOfConcern

  /*
   * Create the category group for an area
   */
  private FormDataGroup createAreaCategoryGroup(RiskFactorValueBean riskFactorBean) {
    FormDataGroup group = createFormDataGroup(TMPLAT_AREA_CATEGORY, CFA02O00);
    group.addBookmark(createBookmark(AREA_CATEGORY, riskFactorBean.getCategoryText()));

    return group;
  } // end createAreaCategory

  private FormDataGroup createAreaCategory(RiskFactorValueBean riskFactorBean) {
    FormDataGroup group = createFormDataGroup(TMPLAT_AREA_CATEGORY, CFA02O00);
    group.addBookmark(createBookmark(AREA_CATEGORY, riskFactorBean.getCategoryText()));

    return group;
  } // end createAreaCategory

  /*
   * Create the list of factors from the returned DB object RiskFactorValueBean
   */
  private FormDataGroup createAreaFactor(RiskFactorValueBean riskFactorBean) {
    String FactorText = riskFactorBean.getFactorText();
    String finalFactorAnswer = "";

    FormDataGroup group = createFormDataGroup(TMPLAT_AREA_FACTOR, CFA02O00);

    if (riskFactorBean.getFactorResponse() != null) {
      if ("0".equals(riskFactorBean.getFactorResponse())) {
        finalFactorAnswer = "Y";
      } else if ("1".equals(riskFactorBean.getFactorResponse())) {
        finalFactorAnswer = "N";
      } else if ("2".equals(riskFactorBean.getFactorResponse())) {
        finalFactorAnswer = "U";
      }
    }

    // GET AREA FACTOR
    String finalFactorText;
    int i = FactorText.indexOf('-');
    if (i == 7) {
      finalFactorText = FactorText.substring(i);
    } else {
      finalFactorText = FactorText;
    }

    group.addBookmark(createBookmark(AREA_FACTOR_ANSWER, finalFactorAnswer));
    group.addBookmark(createBookmark(AREA_FACTOR, finalFactorText));

    return group;
  } // end createAreaFactor

  private void addCategoryScaleOfConcern(FormDataGroup categoryGroup, RiskFactorValueBean riskFactorBean) {
    String scaleOfConcern;
    categoryGroup.addBookmark(createBookmark(CATEGORY_OVRL_SCALE_OF_CONCERN, riskFactorBean.getCategoryText()
                                                                             + " Scale of Concern"));
    String cdScaleOfConcern = riskFactorBean.getCategoryScaleOfConcern();
    if (cdScaleOfConcern != null) {
      scaleOfConcern = Lookup.simpleDecodeSafe("CRISKSOC", cdScaleOfConcern);
    } else {
      scaleOfConcern = "Not Complete";
    }

    categoryGroup.addBookmark(createBookmark(CATEGORY_SCALE_OF_CONCERN_RESULT,
                                             FormattingHelper.formatString(scaleOfConcern)));
  } // end getAreaCategoryScaleOfConcer

  /*
   * get area of concern value for that area
   */
  private void addAreaScaleOfConcern(FormDataGroup areaGroup, RiskFactorValueBean riskFactorBean) {
    String areaOfConcernLabel = riskFactorBean.getAreaText();
    String cdScaleOfConcern = riskFactorBean.getAreaScaleOfConcern();
    String scaleOfConcern = "";

    if (areaOfConcernLabel != null) {
      areaGroup.addBookmark(createBookmark(AREA_SCALE_OF_CONCERN_LABEL, areaOfConcernLabel));

      // If the Overall Scale of Concern is not null, then display the
      // appropriate decode. If the Overall Scale of Concern is null,
      // display "Not Complete".
      if (cdScaleOfConcern != null) {
        scaleOfConcern = Lookup.simpleDecodeSafe("CRISKSOC", cdScaleOfConcern);
      }

      areaGroup.addBookmark(createBookmark(AREA_OVRL_SCALE_OF_CONCERN, areaOfConcernLabel));
      areaGroup.addBookmark(createBookmark(AREA_SCALE_OF_CONCERN_RESULT, scaleOfConcern));
      areaGroup.addBookmark(createBookmark(AREA_JUSTIFICATION_FINDINGS,
                                           riskFactorBean.getCategoryJustificationOfFindings()));

    }

  } // end addAreaScaleOfConcern

  private void getPriorHistory(PreFillData preFillData, RiskAssmtValueBean riskAssmtBean) {
    Iterator iter = riskAssmtBean.getReports().iterator();
    while (iter.hasNext()) {
      RiskAssmtPriorHistoryValueBean reportsBean = (RiskAssmtPriorHistoryValueBean) iter.next();
      FormDataGroup group = createFormDataGroup(TMPLAT_PRIOR_HISTORY, CFA02O00);
      // -----------------------
      // --- Date Of Report ----
      // -----------------------
      if (reportsBean.getDateOfReport() != null) {
        String dateOfReport = FormattingHelper.formatDate(reportsBean.getDateOfReport());
        group.addBookmark(createBookmark(HIST_DT_REPORT, dateOfReport));
      }

      // -----------------------------------
      // --- Child death\serious injury ---
      // -----------------------------------

      String indChild = FormattingHelper.formatString(reportsBean.getIndChildHistoryReport());
      group.addBookmark(createBookmark(HIST_CHILD_INJURY, (("".equals(indChild)) || ("N".equals(indChild))) ? "No" :
                                                          "Yes"));

      // ------------------------
      // --- Date Of Closure ----
      // -------------------------
      if (reportsBean.getDateOfClosure() != null) {
        String dtOfClosure = FormattingHelper.formatDate(reportsBean.getDateOfClosure());
        group.addBookmark(createBookmark(HIST_DT_CLOSURE, dtOfClosure));
      }

      // ------------------------
      // --- Summary ----
      // -------------------------
      String summaryFindings = FormattingHelper.formatString(reportsBean.getFindingHistoryReport());
      group.addBookmark(createBookmark(HIST_PRIOR_COMMENTS, summaryFindings));

      preFillData.addFormDataGroup(group);
    }
  }

  private void getInvestigationActions(PreFillData preFillData, RiskAssmtValueBean riskAssmtBean) {
    // Parents guide given
    String ind_ParentsGuide = riskAssmtBean.getIndParentsGuide();
    String parentsGuideResult = "";
    if (ind_ParentsGuide != null) {
      if ("N".equals(ind_ParentsGuide)) {
        parentsGuideResult = "No";
      } else if ("Y".equals(ind_ParentsGuide)) {
        parentsGuideResult = "Yes";
      } else {
        parentsGuideResult = "N/A";
      }
    }
    preFillData.addBookmark(createBookmark(PARENTS_GUIDE_GIVEN, parentsGuideResult));
    // Date parents guide was received
    if (riskAssmtBean.getDateParentsGuide() != null) {
      String dtParentsGuide = FormattingHelper.formatDate(riskAssmtBean.getDateParentsGuide());
      preFillData.addBookmark(createBookmark(DATE_PARENTS_RCVD_GUIDE, dtParentsGuide));
    }
    // Parents Notified
    String ind_ParentNotified = riskAssmtBean.getIndParentsNotified();
    String parentNotifiedResult = "";
    if (ind_ParentNotified != null) {
      if ("N".equals(ind_ParentNotified)) {
        parentNotifiedResult = "No";
      } else if ("Y".equals(ind_ParentNotified)) {
        parentNotifiedResult = "Yes";
      } else {
        parentNotifiedResult = "N/A";
      }
    }
    preFillData.addBookmark(createBookmark(PARENTS_CHILD_EXAM_NOTIF, parentNotifiedResult));
    // date parents notified
    if (riskAssmtBean.getDateParentsNotified() != null) {
      String dtParentNotified = FormattingHelper.formatDate(riskAssmtBean.getDateParentsNotified());
      preFillData.addBookmark(createBookmark(DATE_PARENTS_CHILD_EXAM_NOTIF, dtParentNotified));
    }
    // HIPPA Explained
    String ind_HIPPAPolicyExplained = riskAssmtBean.getIndHIPPAPolicyExp();
    String hippaExplainedResult;
    if (ind_HIPPAPolicyExplained != null) {
      if ("N".equals(ind_HIPPAPolicyExplained)) {
        hippaExplainedResult = "No";
      } else {
        hippaExplainedResult = "Yes";
      }
      preFillData.addBookmark(createBookmark(HIPPA_EXPLAINED, hippaExplainedResult));
    }
    // HIPPA policy signed
    String ind_HIPPASigned = riskAssmtBean.getIndHIPPAPolicySigned();
    String hippaSigned;
    if (ind_HIPPASigned != null) {
      if ("N".equals(ind_HIPPASigned)) {
        hippaSigned = "No";
      } else {
        hippaSigned = "Yes";
      }
      preFillData.addBookmark(createBookmark(PRIM_CARETAKER_SIGNED_AGRMNT, hippaSigned));
    }
    // Primary caretaker signed and acknowledged agreement
    if (riskAssmtBean.getDateHIPPASignedAndAck() != null) {
      String dtHIPPASignedAndAck = FormattingHelper.formatDate(riskAssmtBean.getDateHIPPASignedAndAck());
      preFillData.addBookmark(createBookmark(DATE_HIPPA_AGRMNT_SIGNED, dtHIPPASignedAndAck));
    }
    // HIPPA Comments
    if (riskAssmtBean.getCommentsHIPPA() != null) {
      String commentsHIPPA = FormattingHelper.formatString(riskAssmtBean.getCommentsHIPPA());
      preFillData.addBookmark(createBookmark(HIPPA_COMMENTS, commentsHIPPA));
    }

  } // end getInvestigationActions

  private void getFamilyStrengthAssmnt(PreFillData preFillData, RiskAssmtValueBean riskAssmtBean) {
    String ind_ChildVulnerability = riskAssmtBean.getIndchildVulnerability();
    String childVulnerability;
    if (ind_ChildVulnerability != null) {
      if ("N".equals(ind_ChildVulnerability)) {
        childVulnerability = "No";
      } else {
        childVulnerability = "Yes";
      }
      preFillData.addBookmark(createBookmark(ASSMT_CHILD_VULNERABILITY, childVulnerability));
    }

    String ind_CaregiverCapability = riskAssmtBean.getIndCaregiverCapability();
    String caregiverCapability;
    if (ind_CaregiverCapability != null) {
      if ("N".equals(ind_CaregiverCapability)) {
        caregiverCapability = "No";
      } else {
        caregiverCapability = "Yes";
      }
      preFillData.addBookmark(createBookmark(ASSMT_CAREGIVER_CPBLTY, caregiverCapability));
    }

    String ind_QualityOfCare = riskAssmtBean.getIndQualityOfCare();
    String qualityOfCare;
    if (ind_QualityOfCare != null) {
      if ("N".equals(ind_QualityOfCare)) {
        qualityOfCare = "No";
      } else {
        qualityOfCare = "Yes";
      }
      preFillData.addBookmark(createBookmark(ASSMT_QUALITY_CARE, qualityOfCare));
    }

    String ind_MaltreatmentPattern = riskAssmtBean.getIndMaltreatmentPattern();
    String maltreatmentPattern;
    if (ind_MaltreatmentPattern != null) {
      if ("N".equals(ind_MaltreatmentPattern)) {
        maltreatmentPattern = "No";
      } else {
        maltreatmentPattern = "Yes";
      }
      preFillData.addBookmark(createBookmark(ASSMT_MALTREATMENT_PATTERN, maltreatmentPattern));
    }

    String ind_HomeEnv = riskAssmtBean.getIndHomeEnv();
    String homeEnv;
    if (ind_HomeEnv != null) {
      if ("N".equals(ind_HomeEnv)) {
        homeEnv = "No";
      } else {
        homeEnv = "Yes";
      }
      preFillData.addBookmark(createBookmark(ASSMT_HOME_ENVIRONMENT, homeEnv));
    }

    String ind_SocialEnv = riskAssmtBean.getIndSocialEnv();
    String socialEnv;
    if (ind_SocialEnv != null) {
      if ("N".equals(ind_SocialEnv)) {
        socialEnv = "No";
      } else {
        socialEnv = "Yes";
      }
      preFillData.addBookmark(createBookmark(ASSMT_SOCIAL_ENVIRONMENT, socialEnv));
    }

    String ind_ResponseToIntervention = riskAssmtBean.getIndResponseToIntervention();
    String respToIntervention;
    if (ind_ResponseToIntervention != null) {
      if ("N".equals(ind_ResponseToIntervention)) {
        respToIntervention = "No";
      } else {
        respToIntervention = "Yes";
      }
      preFillData.addBookmark(createBookmark(ASSMT_RESPONSE_INTRVNTION, respToIntervention));
    }

    String ind_childFragilityProtect = FormattingHelper.formatString(riskAssmtBean.getIndChildFragilityProtection());
    String childFragilityProtect;
    if (ind_childFragilityProtect != null) {
      if ("N".equals(ind_childFragilityProtect)) {
        childFragilityProtect = "No";
      } else {
        childFragilityProtect = "Yes";
      }
      preFillData.addBookmark(createBookmark(ASSMT_CHILD_FRGLTY_PRTCTN, childFragilityProtect));
    }

    String ind_childBehaviour = FormattingHelper.formatString(riskAssmtBean.getIndChildBehaviour());
    String childBehaviour;
    if (ind_childBehaviour != null) {
      if ("N".equals(ind_childBehaviour)) {
        childBehaviour = "No";
      } else {
        childBehaviour = "Yes";
      }
      preFillData.addBookmark(createBookmark(ASSMT_CHILD_BEHAVIOR, childBehaviour));
    }

    String ind_knowledgeSkills = FormattingHelper.formatString(riskAssmtBean.getIndKnowledgeSkills());
    String knowledgeSkills;
    if (ind_knowledgeSkills != null) {
      if ("N".equals(ind_knowledgeSkills)) {
        knowledgeSkills = "No";
      } else {
        knowledgeSkills = "Yes";
      }
      preFillData.addBookmark(createBookmark(ASSMT_KNOWLEDGE_SKILLS, knowledgeSkills));
    }

    String ind_control = FormattingHelper.formatString(riskAssmtBean.getIndControl());
    String control;
    if (ind_control != null) {
      if ("N".equals(ind_control)) {
        control = "No";
      } else {
        control = "Yes";
      }
      preFillData.addBookmark(createBookmark(ASSMT_CONTROL, control));
    }

    String ind_functioning = FormattingHelper.formatString(riskAssmtBean.getIndFunctioning());
    String functioning;
    if (ind_functioning != null) {
      if ("N".equals(ind_functioning)) {
        functioning = "No";
      } else {
        functioning = "Yes";
      }
      preFillData.addBookmark(createBookmark(ASSMT_FUNCTIONING, functioning));
    }

    String ind_emotionalCare = FormattingHelper.formatString(riskAssmtBean.getIndEmotionalCare());
    String emotionalCare;
    if (ind_emotionalCare != null) {
      if ("N".equals(ind_emotionalCare)) {
        emotionalCare = "No";
      } else {
        emotionalCare = "Yes";
      }
      preFillData.addBookmark(createBookmark(ASSMT_EMOTIONAL_CARE, emotionalCare));
    }

    String ind_physicalCare = FormattingHelper.formatString(riskAssmtBean.getIndPhysicalCare());
    String physicalCare;
    if (ind_physicalCare != null) {
      if ("N".equals(ind_physicalCare)) {
        physicalCare = "No";
      } else {
        physicalCare = "Yes";
      }
      preFillData.addBookmark(createBookmark(ASSMT_PHYSICAL_CARE, physicalCare));
    }

    String ind_trend = FormattingHelper.formatString(riskAssmtBean.getIndTrend());
    String trend;
    if (ind_trend != null) {
      if ("N".equals(ind_trend)) {
        trend = "No";
      } else {
        trend = "Yes";
      }
      preFillData.addBookmark(createBookmark(ASSMT_TREND, trend));
    }

    String ind_currentSeverity = FormattingHelper.formatString(riskAssmtBean.getIndCurrentSeverity());
    String currentSeverity;
    if (ind_currentSeverity != null) {
      if ("N".equals(ind_currentSeverity)) {
        currentSeverity = "No";
      } else {
        currentSeverity = "Yes";
      }
      preFillData.addBookmark(createBookmark(ASSMT_CURRENT_SEVERITY, currentSeverity));
    }

    String ind_chronicity = FormattingHelper.formatString(riskAssmtBean.getIndChronicity());
    String chronicity;
    if (ind_chronicity != null) {
      if ("N".equals(ind_chronicity)) {
        chronicity = "No";
      } else {
        chronicity = "Yes";
      }
      preFillData.addBookmark(createBookmark(ASSMT_CHRONICITY, chronicity));
    }

    String ind_dangerousExposure = FormattingHelper.formatString(riskAssmtBean.getIndDangerousExposure());
    String dangerousExposure;
    if (ind_dangerousExposure != null) {
      if ("N".equals(ind_dangerousExposure)) {
        dangerousExposure = "No";
      } else {
        dangerousExposure = "Yes";
      }
      preFillData.addBookmark(createBookmark(ASSMT_DANGEROUS_EXPOSURE, dangerousExposure));
    }

    String ind_stressors = FormattingHelper.formatString(riskAssmtBean.getIndStressors());
    String stressors;
    if (ind_stressors != null) {
      if ("N".equals(ind_stressors)) {
        stressors = "No";
      } else {
        stressors = "Yes";
      }
      preFillData.addBookmark(createBookmark(ASSMT_STRESSORS, stressors));
    }

    String ind_socialClimate = FormattingHelper.formatString(riskAssmtBean.getIndSocialClimate());
    String socialClimate;
    if (ind_socialClimate != null) {
      if ("N".equals(ind_socialClimate)) {
        socialClimate = "No";
      } else {
        socialClimate = "Yes";
      }
      preFillData.addBookmark(createBookmark(ASSMT_SOCIAL_CLIMATE, socialClimate));
    }

    String ind_socialViolence = FormattingHelper.formatString(riskAssmtBean.getIndSocialViolence());
    String socialViolence;
    if (ind_socialViolence != null) {
      if ("N".equals(ind_socialViolence)) {
        socialViolence = "No";
      } else {
        socialViolence = "Yes";
      }
      preFillData.addBookmark(createBookmark(ASSMT_SOCIAL_VIOLENCE, socialViolence));
    }

    String ind_deception = FormattingHelper.formatString(riskAssmtBean.getIndDeception());
    String deception;
    if (ind_deception != null) {
      if ("N".equals(ind_deception)) {
        deception = "No";
      } else {
        deception = "Yes";
      }
      preFillData.addBookmark(createBookmark(ASSMT_DECEPTION, deception));
    }

    String ind_attitude = FormattingHelper.formatString(riskAssmtBean.getIndAttitude());
    String attitude;
    if (ind_attitude != null) {
      if ("N".equals(ind_attitude)) {
        attitude = "No";
      } else {
        attitude = "Yes";
      }
      preFillData.addBookmark(createBookmark(ASSMT_ATTITUDE, attitude));
    }

    if (riskAssmtBean.getCommentsAssessmentOfFmlyStr() != null) {
      String justicationOfFindings = FormattingHelper.formatString(riskAssmtBean.getCommentsAssessmentOfFmlyStr());
      preFillData.addBookmark(createBookmark(SUMMARIZE_COMMENTS, justicationOfFindings));
    }
  } // end getFamilyStrengthAssmnt()

}
