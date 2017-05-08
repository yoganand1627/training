package gov.georgia.dhr.dfcs.sacwis.service.document.impl;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsCaseDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EmployeeDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.db.CapsCase;
import gov.georgia.dhr.dfcs.sacwis.db.IncomingDetail;
import gov.georgia.dhr.dfcs.sacwis.db.Person;

import gov.georgia.dhr.dfcs.sacwis.structs.output.PreFillData;
import gov.georgia.dhr.dfcs.sacwis.structs.input.MANDATEDREPTLETTERFORMSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.MANDATEDREPTLETTERFORMSO;
import gov.georgia.dhr.dfcs.sacwis.service.document.MandatedReptLetterForm;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/*Change History:
Date            User        Description
--------  ----------------  --------------------------------------------------

12/16/2010      arege       SMS#81673: Updated code to display a letter corresponding to the intake disposition
*/

public class MandatedReptLetterFormImpl extends BaseDocumentServiceImpl implements MandatedReptLetterForm {

  private StageDAO stageDAO;

  private EmployeeDAO employeeDAO;
  
  private CapsCaseDAO capsCaseDAO;

  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }

  public void setEmployeeDAO(EmployeeDAO employeeDAO) {
    this.employeeDAO = employeeDAO;
  }
  
  public void setCapsCaseDAO(CapsCaseDAO capsCaseDAO) {
    this.capsCaseDAO = capsCaseDAO;
  }

  public MANDATEDREPTLETTERFORMSO retrieveMandatedReptLetterForm(MANDATEDREPTLETTERFORMSI mandatedReptLetterFormSI) {

    MANDATEDREPTLETTERFORMSO mandatedReptLetterFormso = new MANDATEDREPTLETTERFORMSO();
    int idCase = mandatedReptLetterFormSI.getUlIdCase();
    int idStage = mandatedReptLetterFormSI.getUlIdStage();

    PreFillData preFillData = getIncomingDetail(idCase);
    preFillData
               .addBookmark(createBookmark(
                                           REP_SYSTEM_DATE,
                                           FormattingHelper
                                                           .formatDate(DateHelper
                                                                                 .toJavaDate(DateHelper
                                                                                                       .getTodayCastorDate()))));
    getMailCodeInfo(preFillData, idStage);

    mandatedReptLetterFormso.setPreFillData(preFillData);
    return mandatedReptLetterFormso;
  }

  // Get the incoming Detail based on the case.
  private PreFillData getIncomingDetail(int idCase) {
    PreFillData preFillData = new PreFillData();
    CapsCase capsCase = capsCaseDAO.findCapsCaseByIdCase(idCase);
    preFillData.addBookmark(createBookmark(RPT_LETTER, Lookup.simpleDecodeSafe(CodesTables.CCOUNT,
                                                                               capsCase.getCdCaseCounty())));
    List<Stage> stageList = stageDAO.findStageByIdCase(idCase);

    if (stageList != null && !stageList.isEmpty()) {
      for (Iterator<Stage> it = stageList.iterator(); it.hasNext();) {

        Stage stage = it.next();
        if (stage.getCdStage().equals(CodesTables.CSTAGES_INT)) {
          IncomingDetail incomingDetail = stage.getIncomingDetail();
          if (incomingDetail != null) {
            preFillData
                       .addBookmark(createBookmark(NM_INCOMING_CALLER_FIRST, incomingDetail.getNmIncomingCallerFirst()));
            preFillData.addBookmark(createBookmark(NM_INCOMING_CALLER_MIDDLE,
                                                   incomingDetail.getNmIncomingCallerMiddle()));
            preFillData.addBookmark(createBookmark(NM_INCOMING_CALLER_LAST, incomingDetail.getNmIncomingCallerLast()));
            preFillData.addBookmark(createBookmark(ADDR_INCMG_STREET_LN_1, incomingDetail.getAddrIncmgStreetLn1()));
            preFillData.addBookmark(createBookmark(ADDR_INCMG_STREET_LN_2, incomingDetail.getAddrIncmgStreetLn2()));
            preFillData.addBookmark(createBookmark(ADDR_INCOMING_CALLER_CITY,
                                                   incomingDetail.getAddrIncomingCallerCity()));
            preFillData.addBookmark(createBookmark(ADDR_INCOMING_CALLER_STATE,
                                                   incomingDetail.getCdIncomingCallerState()));
            preFillData.addBookmark(createBookmark(ADDR_INCMG_ZIP, incomingDetail.getAddrIncmgZip()));
            preFillData.addBookmark(createBookmark(DT_INCOMING_CALL,
                                                   FormattingHelper.formatDate(incomingDetail.getDtIncomingCall())));
          }
          if ((CodesTables.CCLOSUR2_01.equals(stage.getCdStageReasonClosed())
               || CodesTables.CCLOSUR2_02.equals(stage.getCdStageReasonClosed()) || CodesTables.CDISP_ACA
                                                                                                         .equals(stage
                                                                                                                      .getCdStageReasonClosed()))) {
            preFillData.addBookmark(createBookmark(CD_STAGE_REASON_CLOSED, CD_STAGE_REASON_CLOSED_DISP_INV));
            preFillData.addBookmark(createBookmark(SUB_LETTER, SUB_LETTER_INV));
            preFillData.addBookmark(createBookmark(CD_STAGE_CURR_PRIORITY,
                                                   Lookup.simpleDecodeSafe(CodesTables.CPRIORTY,
                                                                           stage.getCdStageCurrPriority())));
          } else if (CodesTables.CDISP_DIV.equals(stage.getCdStageReasonClosed())) {
            preFillData.addBookmark(createBookmark(CD_STAGE_REASON_CLOSED, CD_STAGE_REASON_CLOSED_DISP_DIV));
            preFillData.addBookmark(createBookmark(SUB_LETTER, SUB_LETTER_DIV));
            preFillData.addBookmark(createBookmark(CD_STAGE_CURR_PRIORITY,
                                                   Lookup.simpleDecodeSafe(CodesTables.CPRIORTY,
                                                                           stage.getCdStageCurrPriority())));
          } else if (CodesTables.CDISP_SCO.equals(stage.getCdStageReasonClosed())) {
            preFillData.addBookmark(createBookmark(CD_STAGE_REASON_CLOSED,CD_STAGE_REASON_CLOSED_DISP_SCO));
            preFillData.addBookmark(createBookmark(SUB_LETTER, SUB_LETTER_SCO));
            preFillData.addBookmark(createBookmark(CD_STAGE_CURR_PRIORITY,RESPONSE_SCO));
          } else if (CodesTables.CDISP_SCR.equals(stage.getCdStageReasonClosed())) {
            preFillData.addBookmark(createBookmark(CD_STAGE_REASON_CLOSED,CD_STAGE_REASON_CLOSED_DISP_SCR));
            preFillData.addBookmark(createBookmark(SUB_LETTER, SUB_LETTER_SCR));
            preFillData.addBookmark(createBookmark(CD_STAGE_CURR_PRIORITY, RESPONSE_SCR));
          } else {
            preFillData.addBookmark(createBookmark(CD_STAGE_REASON_CLOSED, CD_STAGE_REASON_CLOSED_DISP_NO_INV));
            preFillData.addBookmark(createBookmark(CD_STAGE_CURR_PRIORITY,
                                                   Lookup.simpleDecodeSafe(CodesTables.CDISP,
                                                                           incomingDetail.getCdIncomingDisposition())));
          }
          break;
        }
      }
    }
    return preFillData;
  }

  // Get the Mail code info based on the stage Id
  private PreFillData getMailCodeInfo(PreFillData preFillData, int idStage) {
    Integer personId = stageDAO.findStageByIdStageAndIdPersonAndRole(idStage);
    if (personId != null) {
      Object[] employeeInfo = employeeDAO.findEmployeeInfoByIdPerson(personId);
      preFillData
                 .addBookmark(createBookmark(ADDR_MAIL_CODE_COUNTY, Lookup.simpleDecodeSafe(CodesTables.CCOUNT,
                                                                                            (String) employeeInfo[31])));
    }
    return preFillData;

  }
}
