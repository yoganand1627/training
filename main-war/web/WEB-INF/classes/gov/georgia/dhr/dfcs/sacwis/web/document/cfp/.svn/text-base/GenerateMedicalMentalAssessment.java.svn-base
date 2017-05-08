package gov.georgia.dhr.dfcs.sacwis.web.document.cfp;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.grnds.facility.log.GrndsTrace;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodeNotFoundException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.DataNotFoundException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.DuplicateRecordFoundException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.ReferenceDataLookupException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.TableNotFoundException;
import gov.georgia.dhr.dfcs.sacwis.dao.document.cfp.MedicalMentalAssessmentDao;
import gov.georgia.dhr.dfcs.sacwis.service.document.Cfp;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.ValidationException;
import org.springframework.beans.factory.BeanFactory;

/** Handles special case: Medical/Mental Assessment Log A160, C520, F110, L090 */
public class GenerateMedicalMentalAssessment extends GenerateSpecialCase {
  public static final String TRACE_TAG = "GenerateMedicalMentalAssessment";
  protected static final char INDICATOR_YES = 'Y';
  protected static final String MEDICAL_MENTAL_DOCTYPE = "civ08o";

  public GenerateMedicalMentalAssessment(BeanFactory beanFactory) {
    super(beanFactory);
  }

  /** ccfc20w.win ran the report once for the first event this is more careful and runs the report once per person */
  public void generateSpecialCase()
          throws RemoteException, MarshalException, CodeNotFoundException, ValidationException,
                 ReferenceDataLookupException, TableNotFoundException, DuplicateRecordFoundException,
                 DataNotFoundException {
    GrndsTrace.enterScope(TRACE_TAG + ".generateSpecialCase");
    Cfp cfp = getEjb(Cfp.class);
    List<Map<String, Object>> allEventPrincipalPairs =
            cfp.getMedicalMentalEventPrincipalPairs(caseId, selectedStageId);
    List<Map<String, Object>> outputList = oneEventPerPrincipal(allEventPrincipalPairs);

    Iterator<Map<String, Object>> iterator = outputList.iterator();
    while (iterator.hasNext()) {
      Map<String, Object> map = iterator.next();
      int idPrincipal = ((Number) map.get(MedicalMentalAssessmentDao.ID_PRINCIPAL)).intValue();
      int idEvent = ((Number) map.get(MedicalMentalAssessmentDao.ID_EVENT)).intValue();

      GenerateReport generateReport = new GenerateReport(getBeanFactory());
      generateReport.setJobDescriptor(jobDescriptor);
      generateReport.setDocType(MEDICAL_MENTAL_DOCTYPE);
      generateReport.setEventId(idEvent);
      generateReport.setPersonId(idPrincipal);
      generateReport.setCaseId(caseId);
      generateReport.setUserId(userId);
      generateReport.setUserLogin(userLogin);
      generateReport.execute();
    }

    GrndsTrace.exitScope();
  }

  /** Go through the sorted list of eventId, principalId pairs and return 1 pair per principal */
  protected static List<Map<String, Object>> oneEventPerPrincipal(List<Map<String, Object>> allEventPrincipalPairs) {
    List<Map<String, Object>> outputList = new ArrayList<Map<String, Object>>();

    int previousPersonId = 0;
    Iterator<Map<String, Object>> iterator = allEventPrincipalPairs.iterator();
    while (iterator.hasNext()) {
      Map<String, Object> map = iterator.next();
      int idPrincipal = ((Number) map.get(MedicalMentalAssessmentDao.ID_PRINCIPAL)).intValue();

      if (idPrincipal == previousPersonId) {
        continue;
      }
      previousPersonId = idPrincipal;
      outputList.add(map);
    }
    return outputList;
  }
}
