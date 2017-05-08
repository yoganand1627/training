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
import gov.georgia.dhr.dfcs.sacwis.service.document.Cfp;
import gov.georgia.dhr.dfcs.sacwis.service.document.DocumentSave;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.ValidationException;
import org.springframework.beans.factory.BeanFactory;

/** Handles Contact Log (A140, C500, F090, L070) special case */
public class GenerateContactLog extends GenerateSpecialCase {
  public static final String TRACE_TAG = "GenerateContactLog";
  protected static final String CONTACT_LOG_REPORT_DOCTYPE = "cfsd03";
  protected static final String CONTACT_LOG_NARRATIVE_DOCTYPE = "cfsd0700";

  public GenerateContactLog(BeanFactory beanFactory) {
    super(beanFactory);
  }

  /** Creates a report and a form for each stageId returned by CCFC33S */
  public void generateSpecialCase()
          throws MarshalException, CodeNotFoundException, ValidationException, ReferenceDataLookupException,
                 TableNotFoundException, DuplicateRecordFoundException, DataNotFoundException, RemoteException,
                 TooManyRowsReturnedException, CreateException, DuplicateRecordException, NoSuchMethodException,
                 ParseException, InstantiationException, IllegalAccessException, DocumentStageClosedException,
                 InvocationTargetException, ClassNotFoundException, NoRowsUpdatedException,
                 DocumentStageNotFoundException, SQLException {
    GrndsTrace.enterScope(TRACE_TAG + ".generateSpecialCase");

    for (int i = 0; i < stageIds.length; i++) {
      GenerateReport generateReport = new GenerateReport(getBeanFactory());
      generateReport.setJobDescriptor(jobDescriptor);
      generateReport.setDocType(CONTACT_LOG_REPORT_DOCTYPE);
      generateReport.setCaseId(caseId);
      generateReport.setUserId(userId);
      generateReport.setStageId(stageIds[i]);
      generateReport.setDateFrom(GenerateForm.MINIMUM_DATE);
      generateReport.setDateTo(GenerateForm.MAXIMUM_DATE);
      generateReport.setUserLogin(userLogin);
      generateReport.execute();

      GenerateForm generateForm = new GenerateForm(getBeanFactory());
      generateForm.setJobDescriptor(jobDescriptor);
      generateForm.setDocType(CONTACT_LOG_NARRATIVE_DOCTYPE);
      generateForm.setCaseId(caseId);
      generateForm.setUserId(userId);
      generateForm.setStageId(stageIds[i]);
      generateForm.setDateFrom(GenerateForm.MINIMUM_DATE);
      generateForm.setDateTo(GenerateForm.MAXIMUM_DATE);
      generateForm.setUserLogin(userLogin);
      generateForm.execute();
    }
    GrndsTrace.exitScope();
  }
}
