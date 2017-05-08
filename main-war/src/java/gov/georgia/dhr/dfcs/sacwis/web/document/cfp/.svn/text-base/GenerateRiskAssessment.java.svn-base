package gov.georgia.dhr.dfcs.sacwis.web.document.cfp;

import java.lang.reflect.InvocationTargetException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.text.ParseException;

import javax.ejb.CreateException;

import org.grnds.facility.log.GrndsTrace;

import gov.georgia.dhr.dfcs.sacwis.core.base.DuplicateRecordException;
import gov.georgia.dhr.dfcs.sacwis.core.base.NoRowsUpdatedException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.TooManyRowsReturnedException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodeNotFoundException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.DataNotFoundException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.DuplicateRecordFoundException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.ReferenceDataLookupException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.TableNotFoundException;
import gov.georgia.dhr.dfcs.sacwis.dao.document.DocumentStageClosedException;
import gov.georgia.dhr.dfcs.sacwis.dao.document.DocumentStageNotFoundException;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.ValidationException;
import org.springframework.beans.factory.BeanFactory;

/** Handles special case C090, Risk Assessment Report */
public class GenerateRiskAssessment extends GenerateSpecialCase {
  public static final String TRACE_TAG = "GenerateRiskAssessment";
  protected static final char INDICATOR_YES = 'Y';
  protected static final char INDICATOR_YES_IMPACT = 'M';
  protected static final String INTRANET_RISK_ASSESSMENT_REPORT_DOCTYPE = "civ19o";
  protected static final String IRA_NARRATIVE_DOCTYPE = "civ33o00";
  protected static final String RISK_ASSESSMENT_DOCTYPE = "civ21o00";
  protected static final String RISK_ASSESSMENT_REPORT_DOCTYPE = "civ17o";
  protected static final String RISK_ASSESSMENT_SHORT_FORM_DOCTYPE = "civ30o00";

  public GenerateRiskAssessment(BeanFactory beanFactory) {
    super(beanFactory);
  }

  /** Performs logic similar to ccfc20w.win for C090 to produce both forms and reports as the case requires. */
  public void generateSpecialCase()
          throws TooManyRowsReturnedException, CreateException, ValidationException, DuplicateRecordException,
                 NoSuchMethodException, ParseException, IllegalAccessException, InstantiationException,
                 MarshalException, CodeNotFoundException, DocumentStageClosedException, InvocationTargetException,
                 ClassNotFoundException, NoRowsUpdatedException, SQLException, DocumentStageNotFoundException,
                 ReferenceDataLookupException, TableNotFoundException, DuplicateRecordFoundException, RemoteException,
                 DataNotFoundException {
    GrndsTrace.enterScope(TRACE_TAG + ".generateSpecialCase");

    for (int i = 0; i < stageIds.length; i++) {
      if ((cIndRiskAssmtIntranet != null) &&
          (cIndRiskAssmtIntranet.length() > 0) &&
          ((INDICATOR_YES == cIndRiskAssmtIntranet.charAt(0)) ||
           (INDICATOR_YES_IMPACT == cIndRiskAssmtIntranet.charAt(0)))) {
        for (int j = 0; j < eventIds.length; j++) {
          GenerateDocument generateDocument = new GenerateDocument(getBeanFactory());
          generateDocument.setJobDescriptor(jobDescriptor);
          generateDocument.setDocType(IRA_NARRATIVE_DOCTYPE);
          generateDocument.setCaseId(caseId);
          generateDocument.setUserId(userId);
          generateDocument.setEventId(eventIds[j]);
          generateDocument.setUserLogin(userLogin);
          generateDocument.execute();
        }
        GenerateReport generateReport = new GenerateReport(getBeanFactory());
        generateReport.setJobDescriptor(jobDescriptor);
        generateReport.setDocType(INTRANET_RISK_ASSESSMENT_REPORT_DOCTYPE);
        generateReport.setCaseId(caseId);
        generateReport.setUserId(userId);
        generateReport.setStageId(stageIds[i]);
        generateReport.setUserLogin(userLogin);
        generateReport.execute();
      } else if ((ulSysNbrUlongKeys.length > i) &&
                 (ulSysNbrUlongKeys[i] != 0)) {
        GenerateForm generateForm = new GenerateForm(getBeanFactory());
        generateForm.setJobDescriptor(jobDescriptor);
        generateForm.setDocType(RISK_ASSESSMENT_SHORT_FORM_DOCTYPE);
        generateForm.setCaseId(caseId);
        generateForm.setUserId(userId);
        generateForm.setStageId(stageIds[i]);
        generateForm.setUserLogin(userLogin);
        generateForm.execute();
      } else {
        GenerateReport generateReport = new GenerateReport(getBeanFactory());
        generateReport.setJobDescriptor(jobDescriptor);
        generateReport.setDocType(RISK_ASSESSMENT_REPORT_DOCTYPE);
        generateReport.setCaseId(caseId);
        generateReport.setUserId(userId);
        generateReport.setStageId(stageIds[i]);
        generateReport.setUserLogin(userLogin);
        generateReport.execute();

        GenerateForm generateForm = new GenerateForm(getBeanFactory());
        generateForm.setJobDescriptor(jobDescriptor);
        generateForm.setDocType(RISK_ASSESSMENT_DOCTYPE);
        generateForm.setCaseId(caseId);
        generateForm.setUserId(userId);
        generateForm.setStageId(stageIds[i]);
        generateForm.setUserLogin(userLogin);
        generateForm.execute();
      }
    }
    GrndsTrace.exitScope();
  }
}
