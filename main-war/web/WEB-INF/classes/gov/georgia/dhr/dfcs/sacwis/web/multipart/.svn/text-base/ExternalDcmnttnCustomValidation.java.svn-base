//Declare your class package
package gov.georgia.dhr.dfcs.sacwis.web.multipart;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.LookupException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV23SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV23SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV23SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

import javax.servlet.http.HttpServletRequest;

import org.grnds.structural.web.GrndsExchangeContext;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

/**
 * This class is used to perform the custom validation on External Docuementation Detail page.
 * 
 * Change History: 
 * Date User Description 
 * -------- ---------------- ----------------------------------------------
 * 04/30/03 Todd Reser       Changed Delete Error message to use MessageLookup. 
 * 08/28/03 Todd Reser       SIR 19625 - Added to if statement && CaseDate != DateHelper.NULL_CASTOR_DATE. 
 * 10/14/03 dickmaec         SIR 19857 -- ContextHelper.get... replaces getInputValue(); 
 * 09/10/09 ssubram          STGAP00015066 - New Validations added 
 * 08/28/09 Ekemini Udofiah   STGAP00015065 ECEM Changes
 * 11/04/09 Patrick Coogan   SMS 39073: Corrected issues where document upload was not restricted
 *                           when document type is changed after a doc is uploaded.
 * 
 * @author Rodrigo DeJuana 12/9/2002
 */

public class ExternalDcmnttnCustomValidation extends FormValidation {

  public static final String PDF_TYPE = "application/pdf";

  public static final String JPEG_TYPE = "image/jpeg";

  public static final String PJPEG_TYPE = "image/pjpeg";

  public static final String JPG_TYPE = "image/jpg";

  public static final String PDF_DIS_TYPE = "PDF";

  public static final String JPEG_PJPEG_DIS_TYPE = "JPEG";

  protected boolean validateForm() {
    HttpServletRequest request = super.getRequest();
    BaseSessionStateManager state = super.getState();
    GrndsExchangeContext context = super.getGrndsExchangeContext();
    boolean result = true;
    String page = ContextHelper.getStringSafe(request, "hdnPageName");
    if ("ExtDocDetail".equals(page)) {
      org.exolab.castor.types.Date extDocDate = ContextHelper.getCastorDateSafe(request, "txtDtDtExtDocObtained");
      org.exolab.castor.types.Date caseDate = ContextHelper.getCastorDateSafe(request, "hdnDtDtCaseOpened");
      // Date Obtained cannot be after today.
      if (DateHelper.isAfterToday(extDocDate)) {
        setErrorMessage("txtDtDtExtDocObtained", Messages.MSG_INV_DT_OBTAIN_GT_TODAY);
        result = false;
      }
      // SIR 19625 - Added check for NULL Case Date to If
      // Date Obtained cannot be before the case date
      if (extDocDate != null && caseDate != null && DateHelper.isAfter(caseDate, extDocDate)) {
        setErrorMessage("txtDtDtExtDocObtained", Messages.MSG_INV_DT_OBTAIN_LT_STAGE);
        result = false;
      }

      String type = ContextHelper.getStringSafe(request, "selSzCdExtDocType");
      String details = ContextHelper.getStringSafe(request, "txtaSzTxtExtDocDetails");
      // String DocClass = ContextHelper.getStringSafe(request, "selSzcdDocClass");

      // If Type is "XX" (XX means Other), details are required.
      if ("XX".equals(type) && "".equals(details)) {
        setErrorMessage("txtaSzTxtExtDocDetails", Messages.MSG_EXTDOC_OTHR_CMT);
        result = false;
      }
      String[] PersonCheckedArray = CheckboxHelper.getCheckedValues(request, "cbxUlIdPerson");
      String NaChecked = ContextHelper.getStringSafe(request, "selIndNaChecked");

      // If no persons or N/A were selected, complain
      if ((PersonCheckedArray.length == 0) && ("".equals(NaChecked))) {
        setErrorMessage(Messages.MSG_EXT_DOC_NO_PERSONS);
        result = false;
      }
      if ((PersonCheckedArray.length != 0) && ("N".equals(NaChecked))) {
        setErrorMessage(Messages.MSG_EXT_DOC_NA_PERSONS);
        result = false;
      }

      // SMS: 39073 Code below changed per due to issues with losing state in system test and
      // because prior code did not validate against changing the doc type after initial upload

      String fileName = ContextHelper.getStringSafe(request, "txtDtDtExtDocFileName");
      boolean upload = false;
      Object tmp = context.getRequest();
      if (tmp instanceof DefaultMultipartHttpServletRequest) {
        DefaultMultipartHttpServletRequest fileRequest = (DefaultMultipartHttpServletRequest) context.getRequest();
        MultipartFile multipartFile = fileRequest.getFile("txttSzTxtExtFile");
        upload = !multipartFile.isEmpty();
      }

      if (!("".equals(fileName)) || upload) {
        try {

          Collection<String> restrictDocs = Lookup.getCategoryCodesCollection(CodesTables.CEXDORST);

          if (restrictDocs.contains(type)) {
            setErrorMessage(Messages.MSG_EXT_DOC_UPLOAD_RESTRICT);
            result = false;
          }
        } catch (LookupException le) {

        }
      }
    } else if ("ExtDocList".equals(page)) {
      if (isButtonPressed("btnSearch")) {
        org.exolab.castor.types.Date fromDate = DateHelper
                                                          .toCastorDateSafe(ContextHelper
                                                                                         .getStringSafe(request,
                                                                                                        "dtScrSearchDateFrom"));

        org.exolab.castor.types.Date toDate = DateHelper
                                                        .toCastorDateSafe(ContextHelper
                                                                                       .getStringSafe(request,
                                                                                                      "dtScrSearchDateTo"));

        // If the From date is after the To date yell at 'em!
        if (fromDate != null && DateHelper.isAfter(fromDate, toDate)) {
          setErrorMessage("dtScrSearchDateFrom", Messages.MSG_SVC_CNTCT_END_DT);
          result = false;
        }

        // If Search is pressed and From wasn't filled in when to date was show that the from is conditionally required
        if (fromDate == null && toDate != null) {
          setErrorMessage("dtScrSearchDateFrom", Messages.SSM_COMPLETE_REQUIRED);
          result = false;
        }

        // If the From Date is in the future and not the "NULL date" yell at them about that too!
        if (fromDate != null && DateHelper.isAfterToday(fromDate)) {
          setErrorMessage("dtScrSearchDateFrom", Messages.MSG_SVC_NO_FUTURE_FROM_DATE);
          result = false;
        }
      } else if (isButtonPressed("btnDelete")) {
        // Get Stage Closed Indicator and Stage Closed Date
        boolean stageClosed = (Boolean) state.getAttribute("stageClosed", request);
        Date stageClosureDate = (Date) state.getAttribute("stageClosureDate", request);
        String rbExtDoc = ContextHelper.getStringSafe(request, "rbExtDoc");
        if (rbExtDoc.length() == 0) {
          setErrorMessage(Messages.MSG_SELECT_ROW_ACTION);
          result = false;
        }
        // External Documentation entered prior to case closure cannot be deleted after case closure.
        if (stageClosed && stageClosureDate != null) {
          CINV23SO ExtDocList = (CINV23SO) state.getAttribute("CINV23SO", request);
          ROWCINV23SOG00_ARRAY ExtDocArray = new ROWCINV23SOG00_ARRAY();
          if (ExtDocList == null) {
            ExtDocList = new CINV23SO();
          }
          if (ExtDocList.getROWCINV23SOG00_ARRAY() != null) {
            ExtDocArray = ExtDocList.getROWCINV23SOG00_ARRAY();
          }
          Enumeration<ROWCINV23SOG00> ExtDocEnum = ExtDocArray.enumerateROWCINV23SOG00();

          Integer selectedExtDoc = Integer.parseInt(rbExtDoc.substring(1));
          boolean disallowDelete = false;
          while (ExtDocEnum.hasMoreElements()) {
            ROWCINV23SOG00 extDocDetail = (ROWCINV23SOG00) ExtDocEnum.nextElement();
            if (selectedExtDoc != null && selectedExtDoc == extDocDetail.getUlIdExtSitInfo()) {
              disallowDelete = DateHelper.isBefore(DateHelper.toJavaDate(extDocDetail.getDtDtExtDocObtained()),
                                                   stageClosureDate);
              break;
            }
          }
          if (disallowDelete) {
            setErrorMessage(Messages.MSG_SVC_EXT_DOC_NO_DELETE);
            result = false;
          }
        }
      }
    }
    return result;
  }

  // static constants
  public static final String TRACE_TAG = "ExternalDcmnttnCustomValidation";
}
