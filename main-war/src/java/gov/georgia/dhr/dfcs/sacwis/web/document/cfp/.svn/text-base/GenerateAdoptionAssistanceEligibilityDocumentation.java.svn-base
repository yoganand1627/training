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

/**
 * Handles Adoption Assistance Eligibility Documentation [Subsidy Eligibility Report] (C440) special case: this never
 * worked in CAPs
 */
public class GenerateAdoptionAssistanceEligibilityDocumentation
        extends GenerateSpecialCase {
  public static final String TRACE_TAG = "GenerateAdoptionAssistanceEligibilityDocumentation";
  protected static final String DOCTYPE = "cfa13o00";

  public GenerateAdoptionAssistanceEligibilityDocumentation(BeanFactory beanFactory) {
    super(beanFactory);
  }

  /** Queries for all events in your case/stage Looks for a Document for each event id */
  public void generateSpecialCase()
          throws RemoteException, TooManyRowsReturnedException, CreateException, ValidationException,
                 DuplicateRecordException, NoSuchMethodException, ParseException, IllegalAccessException,
                 InstantiationException, MarshalException, CodeNotFoundException, DocumentStageClosedException,
                 InvocationTargetException, ClassNotFoundException, NoRowsUpdatedException, SQLException,
                 DocumentStageNotFoundException, ReferenceDataLookupException, TableNotFoundException,
                 DuplicateRecordFoundException, DataNotFoundException {
    GrndsTrace.enterScope(TRACE_TAG + ".generateSpecialCase");
    Cfp cfp = getEjb(Cfp.class);
    int[] adoptionSubsidyIds = cfp.getAdoptionSubsidyIds(caseId, selectedStageId);

    for (int i = 0; i < adoptionSubsidyIds.length; i++) {
      GenerateDocument generateDocument = new GenerateDocument(getBeanFactory());
      generateDocument.setJobDescriptor(jobDescriptor);
      generateDocument.setDocType(DOCTYPE);
      generateDocument.setCaseId(caseId);
      generateDocument.setUserId(userId);
      generateDocument.setAdoptionSubsidyId(adoptionSubsidyIds[i]);
      generateDocument.setUserLogin(userLogin);
      generateDocument.execute();
    }
    GrndsTrace.exitScope();
  }
}
