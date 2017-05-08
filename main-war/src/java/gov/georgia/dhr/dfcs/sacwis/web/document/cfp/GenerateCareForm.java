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

/**
 * This is the GenerateCareForm class used to display Care Form & Narrative.
 *
 * @author Vijaya Anand
 * @version 1.0
 *          <p/>
 *          Change History: Date      User     Description -------  --------  ------------------------------------
 *          08/01/05  ANANDV   SIR 23828 - Added to display Care Forms & Narrative
 */

public class GenerateCareForm extends GenerateSpecialCase {

  public static final String TRACE_TAG = "GenerateCareForm";
  protected static final String GENERATE_CARE_FORM_TYPE = "civ35o00";

  public GenerateCareForm(BeanFactory beanFactory) {
    super(beanFactory);
  }

  /** Creates a form for each EVENTID  returned by CINV99S */
  public void generateSpecialCase()
          throws TooManyRowsReturnedException, CreateException, ValidationException, DuplicateRecordException,
                 NoSuchMethodException, ParseException, IllegalAccessException, InstantiationException,
                 MarshalException, CodeNotFoundException, DocumentStageClosedException, InvocationTargetException,
                 ClassNotFoundException, NoRowsUpdatedException, SQLException, DocumentStageNotFoundException,
                 ReferenceDataLookupException, TableNotFoundException, DuplicateRecordFoundException, RemoteException,
                 DataNotFoundException {
    GrndsTrace.enterScope(TRACE_TAG + ".generateSpecialCase");
    for (int i = 0; i < eventIds.length; i++) {
      GenerateForm generateForm = new GenerateForm(getBeanFactory());
      generateForm.setJobDescriptor(jobDescriptor);
      generateForm.setDocType(GENERATE_CARE_FORM_TYPE);
      generateForm.setPersonId(userId);
      generateForm.setUserId(userId);
      generateForm.setCaseId(caseId);
      generateForm.setEventId(eventIds[i]);
      generateForm.setUserLogin(userLogin);
      generateForm.execute();
    }
    GrndsTrace.exitScope();

  } // ending generateSpecialCase()

} // ending GenerateCareForm class
