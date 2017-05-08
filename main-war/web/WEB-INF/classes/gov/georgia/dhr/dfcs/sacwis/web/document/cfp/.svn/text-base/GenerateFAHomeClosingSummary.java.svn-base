package gov.georgia.dhr.dfcs.sacwis.web.document.cfp;

import java.lang.reflect.InvocationTargetException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Iterator;
import java.util.List;

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

/** Handles C460, F/A Home Closing Summary */
public class GenerateFAHomeClosingSummary extends GenerateSpecialCase {
  public static final String TRACE_TAG = "GenerateFAHomeClosingSummary";
  public static final String DOCTYPE = "ifcl";

  public GenerateFAHomeClosingSummary(BeanFactory beanFactory) {
    super(beanFactory);
  }

  /** Issues multiple requests to look for documents for event ids */
  public void generateSpecialCase()
          throws TooManyRowsReturnedException, CreateException, ValidationException, DuplicateRecordException,
                 NoSuchMethodException, ParseException, IllegalAccessException, InstantiationException,
                 MarshalException, CodeNotFoundException, DocumentStageClosedException, InvocationTargetException,
                 ClassNotFoundException, NoRowsUpdatedException, SQLException, DocumentStageNotFoundException,
                 ReferenceDataLookupException, TableNotFoundException, DuplicateRecordFoundException, RemoteException,
                 DataNotFoundException {
    GrndsTrace.enterScope(TRACE_TAG + ".generateSpecialCase");
    Cfp cfp = getEjb(Cfp.class);
    List vector = cfp.getFAHomeClosingSummaryEventIds(caseId);

    Iterator iterator = vector.iterator();
    while (iterator.hasNext()) {
      String eventId = (String) iterator.next();

      GenerateDocument generateDocument = new GenerateDocument(getBeanFactory());
      generateDocument.setJobDescriptor(jobDescriptor);
      generateDocument.setDocType(DOCTYPE);
      generateDocument.setCaseId(caseId);
      generateDocument.setStageId(selectedStageId);
      generateDocument.setUserId(userId);
      generateDocument.setEventId(Integer.parseInt(eventId));
      generateDocument.setUserLogin(userLogin);
      generateDocument.execute();
    }
    GrndsTrace.exitScope();
  }
}
