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
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.FamilyPlan;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.ValidationException;
import org.springframework.beans.factory.BeanFactory;

/** Handles special case C140, Family Service Plan */
public class GenerateFamilyServicePlan extends GenerateSpecialCase {
  public static final String TRACE_TAG = "GenerateFamilyServicePlan";
  protected static final char INDICATOR_YES = 'Y';
  protected static final String FAMILY_SERVICE_PLAN_CAPS = "cfsd0500";
  protected static final String FAMILY_SERVICE_PLAN_IMPACT = "cfsd0800";

  public static final String CD_TASK_FPR_FAM_PLAN = "7080";
  public static final String CD_TASK_FRE_FAM_PLAN = "5600";
  public static final String CD_TASK_FSU_FAM_PLAN = "4150";

  public GenerateFamilyServicePlan(BeanFactory beanFactory) {
    super(beanFactory);
  }

  /** Perform logic to determine if it was creatd in IMPACT or CAPS. */
  public void generateSpecialCase()
          throws TooManyRowsReturnedException, CreateException, ValidationException, DuplicateRecordException,
                 NoSuchMethodException, ParseException, IllegalAccessException, InstantiationException,
                 MarshalException, CodeNotFoundException, DocumentStageClosedException, InvocationTargetException,
                 ClassNotFoundException, NoRowsUpdatedException, SQLException, DocumentStageNotFoundException,
                 ReferenceDataLookupException, TableNotFoundException, DuplicateRecordFoundException, RemoteException,
                 DataNotFoundException {
    GrndsTrace.enterScope(TRACE_TAG + ".generateSpecialCase");

    FamilyPlan familyPlan = getEjb(FamilyPlan.class);
    for (int i = 0; i < eventIds.length; i++) {
      if (familyPlan.checkIfEventIsLegacy(eventIds[i])) {
        GenerateForm generateForm = new GenerateForm(getBeanFactory());
        generateForm.setJobDescriptor(jobDescriptor);
        generateForm.setDocType(FAMILY_SERVICE_PLAN_CAPS);
        generateForm.setCaseId(caseId);
        generateForm.setUserId(userId);
        generateForm.setStageId(stageIds[i]);
        generateForm.setEventId(eventIds[i]);
        generateForm.setUserLogin(userLogin);
        generateForm.execute();
      } else {
        GenerateForm generateForm = new GenerateForm(getBeanFactory());
        generateForm.setJobDescriptor(jobDescriptor);
        generateForm.setDocType(FAMILY_SERVICE_PLAN_IMPACT);
        generateForm.setCaseId(caseId);
        generateForm.setUserId(userId);
        generateForm.setStageId(stageIds[i]);
        generateForm.setEventId(eventIds[i]);
        generateForm.setUserLogin(userLogin);
        generateForm.execute();
      }
    }
    GrndsTrace.exitScope();
  }
}
