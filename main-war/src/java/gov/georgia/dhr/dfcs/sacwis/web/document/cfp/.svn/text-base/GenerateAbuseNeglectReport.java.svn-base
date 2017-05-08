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
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.ValidationException;
import org.springframework.beans.factory.BeanFactory;

/** Handles F060, Abuse/Neglect Report special case */
public class GenerateAbuseNeglectReport extends GenerateSpecialCase {
  public static final String TRACE_TAG = "GenerateAbuseNeglectReport";

  public GenerateAbuseNeglectReport(BeanFactory beanFactory) {
    super(beanFactory);
  }

  /**
   * if ulNbrReviewContact &gt; 0, use tableName APS_FACIL_REV_NARR, else APS_FACIL_NARR to generate a form for each
   * stageId returned by CCFC33S
   */
  public void generateSpecialCase()
          throws RemoteException, TooManyRowsReturnedException, CreateException, ValidationException,
                 DuplicateRecordException, NoSuchMethodException, ParseException, IllegalAccessException,
                 InstantiationException, MarshalException, CodeNotFoundException, DocumentStageClosedException,
                 InvocationTargetException, ClassNotFoundException, NoRowsUpdatedException, SQLException,
                 DocumentStageNotFoundException, ReferenceDataLookupException, TableNotFoundException,
                 DuplicateRecordFoundException, DataNotFoundException {
    GrndsTrace.enterScope(TRACE_TAG + ".generateSpecialCase");

    //CINVB8D doesn't handle when stageId == 0
    //So instead of changing the dam and service code
    //I call an EJB
    if ((selectedStageId == 0) &&
        (getEjb(Cfp.class).hasReviewContact(caseId))) {
      ulNbrReviewContact = 1;
    }

    String docType = "cfiv1600"; // tableName = "APS_FACIL_NARR";
    GrndsTrace.msg(TRACE_TAG, 7, "ulNbrReviewContact: " + ulNbrReviewContact);
    if (ulNbrReviewContact > 0) {
      docType = "cfiv1600b"; // tableName = "APS_FACIL_REV_NARR";
    }
    GrndsTrace.msg(TRACE_TAG, 7, "docType: " + docType);

    for (int i = 0; i < stageIds.length; i++) {
      GenerateDocument generateDocument = new GenerateDocument(getBeanFactory());
      generateDocument.setJobDescriptor(jobDescriptor);
      generateDocument.setDocType(docType);
      generateDocument.setCaseId(caseId);
      generateDocument.setUserId(userId);
      generateDocument.setStageId(stageIds[i]);
      generateDocument.setUserLogin(userLogin);
      generateDocument.execute();
    }
    GrndsTrace.exitScope();
  }
}
