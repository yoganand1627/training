package gov.georgia.dhr.dfcs.sacwis.web.document.cfp;

import java.rmi.RemoteException;

import org.grnds.facility.log.GrndsTrace;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodeNotFoundException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.DataNotFoundException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.DuplicateRecordFoundException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.ReferenceDataLookupException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.TableNotFoundException;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelper;
import gov.georgia.dhr.dfcs.sacwis.service.document.Cfp;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CARC07SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CARC07SO;
import gov.georgia.dhr.dfcs.sacwis.web.reports.ReportsLookup;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.ValidationException;
import org.springframework.beans.factory.BeanFactory;

/** Calls necessary logic to Generate a Report */
public class GenerateReport extends GenerateForm {
  public static final String TRACE_TAG = "GenerateReport";
  protected static final int RETRY_CARC07S = 5;
  protected static final String DATE_FROM = "DATE_FROM";
  protected static final String DATE_TO = "DATE_TO";

  protected static final String ID_CASE = "ID_CASE";
  protected static final String ID_STAGE = "ID_STAGE";
  protected static final String ID_PERSON = "ID_PERSON";
  protected static final String ID_EVENT = "ID_EVENT";
  protected static final String ID_REMOVAL_EVENT = "ID_REMOVAL_EVENT";

  protected static final String ID_RESOURCE = "ID_RESOURCE";
  protected static final String ID_PLCMT_CHILD = "ID_PLCMT_CHILD";

  public GenerateReport(BeanFactory beanFactory) {
    super(beanFactory);
  }

  /**
   * Gets the sqrVersion for a given report. Obtains the report parameters. Calls CARC07S to kick off the report Creates
   * a DocumentDescriptor with the reportFullName and cfpStamp Registers the DocumentDescriptor with the JobDescriptor
   */
  public void execute()
          throws MarshalException, ValidationException, CodeNotFoundException, ReferenceDataLookupException,
                 TableNotFoundException, DuplicateRecordFoundException, DataNotFoundException, RemoteException {
    GrndsTrace.enterScope(TRACE_TAG + ".generateSpecialCase");

    checkNecessaryFieldsSet();

    String sqrName = docType;
    String sqrVersion = "00"; //just like the C Code (ccfc20w.win)
    String parameterList = getParameterList(getEjb(Cfp.class), sqrName, sqrVersion);

    int cfpStamp = jobDescriptor.getCurrentStamp();
    String emailMessage = null;

    CARC07SI carc07si = new CARC07SI();

    ArchInputStruct archInputStruct = new ArchInputStruct();
    archInputStruct.setSzUserId(userLogin);
    carc07si.setArchInputStruct(archInputStruct);

    carc07si.setSzNmRptSqrName(sqrName);
    carc07si.setSzNmRptSqrVer(sqrVersion);
    carc07si.setUlIdPerson(userId);
    carc07si.setTxtRptParmList(parameterList);
    carc07si.setUlRptLstCfpStamp(cfpStamp);
    carc07si.setSzTxtEmailMessage(emailMessage);

    GrndsTrace.msg(TRACE_TAG, 7, "GenerateReport");
    GrndsTrace.msg(TRACE_TAG, 7, " sqrName: " + sqrName);
    GrndsTrace.msg(TRACE_TAG, 7, " sqrVersion: " + sqrVersion);
    GrndsTrace.msg(TRACE_TAG, 7, " userId: " + userId);
    GrndsTrace.msg(TRACE_TAG, 7, " parameterList: " + parameterList);
    GrndsTrace.msg(TRACE_TAG, 7, " cfpStamp: " + cfpStamp);
    GrndsTrace.msg(TRACE_TAG, 7, " emailMessage: " + emailMessage);

    GrndsTrace.msg(TRACE_TAG, 7, " carc07si: " + carc07si);

    WtcHelper.callService("CARC07S", carc07si, CARC07SO.class, RETRY_CARC07S);

    String reportName = sqrName + sqrVersion;
    String reportFullName = ReportsLookup.getFullName(reportName);

    DocumentDescriptor documentDescriptor = new DocumentDescriptor(reportFullName, cfpStamp);
    jobDescriptor.addDocumentDescriptor(documentDescriptor);
    GrndsTrace.exitScope();
  }

  /** Orders the parameters according to report_parameters table. */
  protected String getParameterList(Cfp cfp, String sqrName, String sqrVersion) throws RemoteException {
    String[] parameterNames = cfp.getParameterNames(sqrName, sqrVersion);

    StringBuffer parameterList = new StringBuffer();

    for (int i = 0; i < parameterNames.length; i++) {
      if (parameterNames[i].equals(ID_CASE)) {
        parameterList.append(caseId);
        parameterList.append("^");
      } else if (parameterNames[i].equals(ID_STAGE)) {
        parameterList.append(stageId);
        parameterList.append("^");
      } else if (parameterNames[i].equals(ID_PERSON)) {
        parameterList.append(personId);
        parameterList.append("^");
      } else if (parameterNames[i].equals(ID_EVENT) ||
                 parameterNames[i].equals(ID_REMOVAL_EVENT)) {
        parameterList.append(eventId);
        parameterList.append("^");
      } else if (parameterNames[i].equals(DATE_FROM)) {
        if (dateFrom == null) {
          dateFrom = MINIMUM_DATE;
        }
        parameterList.append(dateFormat.format(dateFrom));
        parameterList.append("^");
      } else if (parameterNames[i].equals(DATE_TO)) {
        if (dateTo == null) {
          dateTo = MAXIMUM_DATE;
        }
        parameterList.append(dateFormat.format(dateTo));
        parameterList.append("^");
      } else {
        //CAPS sends in 0 when it's not one of the above
        GrndsTrace.msg(TRACE_TAG, 7, "WARNING: unhandled type: " +
                                     parameterNames[i]);

        parameterList.append("0");
        parameterList.append("^");
      }
    }
    return parameterList.toString();
  }
}
