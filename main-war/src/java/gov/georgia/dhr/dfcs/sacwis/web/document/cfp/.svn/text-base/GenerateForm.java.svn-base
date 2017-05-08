package gov.georgia.dhr.dfcs.sacwis.web.document.cfp;

import java.io.PrintStream;
import java.io.Serializable;
import java.io.StringReader;
import java.lang.reflect.InvocationTargetException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.ejb.CreateException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.grnds.facility.log.GrndsTrace;

import gov.georgia.dhr.dfcs.sacwis.core.base.DuplicateRecordException;
import gov.georgia.dhr.dfcs.sacwis.core.base.NoRowsUpdatedException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.TooManyRowsReturnedException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodeNotFoundException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.DataNotFoundException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.DuplicateRecordFoundException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.ReferenceDataLookupException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.TableNotFoundException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.dao.document.DocumentStageClosedException;
import gov.georgia.dhr.dfcs.sacwis.dao.document.DocumentStageNotFoundException;
import gov.georgia.dhr.dfcs.sacwis.service.document.DocumentSave;
import gov.georgia.dhr.dfcs.sacwis.service.document.DocumentServiceExecutor;
import gov.georgia.dhr.dfcs.sacwis.structs.document.DocumentMetaData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.document.DocumentLookup;
import gov.georgia.dhr.dfcs.sacwis.web.document.DocumentServiceHelper;
import gov.georgia.dhr.dfcs.sacwis.web.document.DocumentUtilityHelpers;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.ValidationException;
import org.springframework.beans.factory.BeanFactory;

/** Handles GenerateForm requests. Base class for GenerateReport and GenerateDocument */
public class GenerateForm implements Serializable {
  public static final String TRACE_TAG = "GenerateForm";
  public static final int FORM_NOT_CONVERTED_YET = 9999;
  public static final int ARC_MAX_YEAR = 4712;
  public static final int ARC_MIN_YEAR = 1850;

  //different from C because Java is 0-based on months
  public static final int ARC_MAX_MONTH = 11;
  public static final int ARC_MIN_MONTH = 0;

  public static final int ARC_MAX_DAY = 31;
  public static final int ARC_MIN_DAY = 1;

  public static final Date MINIMUM_DATE;
  public static final Date MAXIMUM_DATE;

  protected static final DateFormat dateFormat = new SimpleDateFormat("M/d/yyyy");

  static {
    MINIMUM_DATE = new GregorianCalendar(ARC_MIN_YEAR, ARC_MIN_MONTH, ARC_MIN_DAY).getTime();
    MAXIMUM_DATE = new GregorianCalendar(ARC_MAX_YEAR, ARC_MAX_MONTH, ARC_MAX_DAY).getTime();
  }

  //input
  protected boolean documentExists = false;
  protected JobDescriptor jobDescriptor = null;
  protected String userLogin = null;
  protected int userId = 0;
  protected int caseId = 0;
  protected int eventId = 0;
  protected int stageId = 0;
  protected int personId = 0;
  protected int adoptionSubsidyId = 0;
  protected int criminalHistoryId = 0;
  protected String docType = null;
  protected Date dateFrom = null;
  protected Date dateTo = null;
  //output
  protected DocumentMetaData documentMetaData = null;
  protected String preFillData = null;

  private BeanFactory beanFactory;

  public GenerateForm(BeanFactory beanFactory) {
    this.beanFactory = beanFactory;
  }

  @SuppressWarnings({"unchecked"})
  protected <T extends Object> T getEjb(Class<T> aClass) {
    String simpleName = aClass.getSimpleName();
    String beanName = Character.toLowerCase(simpleName.charAt(0)) + simpleName.substring(1);
    return (T) beanFactory.getBean(beanName);
  }

  /**
   * Gets the documentMetaData for the docType Creates a dummy request. Fills the request with CaseId, EventId, etc.
   * Calls DocumentUtilityHelpers.completeDocumentMetaData Requests for prefilldata if appropriate Creates a
   * DocumentDescriptor Adds DocumentDescriptor to JobDescriptor
   */
  public void execute()
          throws MarshalException, ValidationException, TooManyRowsReturnedException, DocumentStageClosedException,
                 NoRowsUpdatedException, DuplicateRecordException, DocumentStageNotFoundException, SQLException,
                 ParseException, RemoteException, CreateException, InvocationTargetException, ClassNotFoundException,
                 NoSuchMethodException, InstantiationException, IllegalAccessException, CodeNotFoundException,
                 ReferenceDataLookupException, TableNotFoundException, DuplicateRecordFoundException,
                 DataNotFoundException {
    GrndsTrace.enterScope(TRACE_TAG + ".generateSpecialCase");

    checkNecessaryFieldsSet();

    this.documentMetaData = getDocumentMetaData(docType);
    if (documentMetaData == null) {
      trace("SKIPPING " + docType + " as we don't have metadata yet");
      return;
    }
    trace("Generating form for docType '" + docType + "'");
    HttpServletRequest request = initializeRequest();

    if (caseId != 0) {
      trace(" Case: " + caseId);
      request.setAttribute("pCase", "" + caseId);
      request.setAttribute("sCase", "" + caseId);
    }
    if (eventId != 0) {
      trace(" Event: " + eventId);
      request.setAttribute("pEvent", "" + eventId);
      request.setAttribute("sEvent", "" + eventId);
      request.setAttribute("pptEvent", "" + eventId);
    }
    if (stageId != 0) {
      trace(" Stage: " + stageId);
      request.setAttribute("pStage", "" + stageId);
      request.setAttribute("sStage", "" + stageId);
    }
    if (personId != 0) {
      trace(" Person: " + personId);
      request.setAttribute("pPerson", "" + personId);
      request.setAttribute("sPerson", "" + personId);
    }
    if (adoptionSubsidyId != 0) {
      trace(" sAdptSub: " + adoptionSubsidyId);
      request.setAttribute("sAdptSub", "" + adoptionSubsidyId);
    }
    if (criminalHistoryId != 0) {
      trace(" CriminalHistory: " + criminalHistoryId);
      request.setAttribute("pCriminalHistory", "" + criminalHistoryId);
      request.setAttribute("sCriminalHistory", "" + criminalHistoryId);
      request.setAttribute("pCrimHist", "" + criminalHistoryId);
      request.setAttribute("sCrimHist", "" + criminalHistoryId);
    }
    if (dateFrom != null) {
      String dateFromString = dateFormat.format(dateFrom);
      trace(" DateFrom: " + dateFromString);
      request.setAttribute("pDateFrom", dateFromString);
      request.setAttribute("sDateFrom", dateFromString);
      request.setAttribute("pDtSampleFrom", dateFromString);
      request.setAttribute("pDtCPSInvstDtlBegun", dateFromString);
      request.setAttribute("pDtLicngInvstDtlBegun", dateFromString);
    }
    if (dateTo != null) {
      String dateToString = dateFormat.format(dateTo);
      trace(" DateTo: " + dateToString);
      request.setAttribute("pDateTo", dateToString);
      request.setAttribute("sDateTo", dateToString);
      request.setAttribute("pDtSampleTo", dateToString);
    }
    request.setAttribute("renderFormat", "HTML_WITHOUT_SHELL");
    request.setAttribute("docExists", "" + documentExists);

    //adds renderFormat, and docExists to documentMetaData
    DocumentSave documentSave = (DocumentSave) beanFactory.getBean("docmentSave");
    this.documentMetaData = DocumentUtilityHelpers.completeDocumentMetaData(documentSave, request, documentMetaData);

    documentMetaData.setHasFooter(false);

    if (documentMetaData.getPreFillMetaData() != null && documentExists == false) {
      try {
        //call tuxedo
        this.preFillData = DocumentServiceHelper.returnPreFillData(getEjb(DocumentServiceExecutor.class),
                                                                   request, documentMetaData);
      }
      catch (ServiceException e) {
        //no prefill in the database, so there's nothing to generate
        if (e.getErrorCode() == Messages.MSG_NO_ROWS_RETURNED) {
          return;
        }
        throw e;
      }
    }

    //!!! just for logging purposes
    // - commented out 4/3 - SWR 
    //printDocument(documentMetaData, preFillData);

    DocumentDescriptor documentDescriptor =
            new DocumentDescriptor(documentMetaData, preFillData);

    jobDescriptor.addDocumentDescriptor(documentDescriptor);
    GrndsTrace.exitScope();
  }

  /** Sanity check: make sure some parameters like userId are always set */
  protected void checkNecessaryFieldsSet() {
    if (userId == 0) {
      throw new IllegalStateException("userId == 0");
    }
    if (caseId == 0) {
      throw new IllegalStateException("caseId == 0");
    }
    if (jobDescriptor == null) {
      throw new IllegalStateException("jobDescriptor == null");
    }
    if (userLogin == null) {
      throw new IllegalStateException("userLogin == null");
    }
  }

  public JobDescriptor getJobDescriptor() {
    return jobDescriptor;
  }

  public void setJobDescriptor(JobDescriptor jobDescriptor) {
    this.jobDescriptor = jobDescriptor;
  }

  public String getUserLogin() {
    return userLogin;
  }

  public void setUserLogin(String userLogin) {
    this.userLogin = userLogin;
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    trace("GenerateForm.userId: " + userId);
    this.userId = userId;
  }

  public int getCaseId() {
    return caseId;
  }

  public void setCaseId(int caseId) {
    trace("GenerateForm.caseId: " + caseId);
    this.caseId = caseId;
  }

  public int getEventId() {
    return eventId;
  }

  public void setEventId(int eventId) {
    trace("GenerateForm.eventId: " + eventId);
    this.eventId = eventId;
  }

  public int getStageId() {
    return stageId;
  }

  public void setStageId(int stageId) {
    trace("GenerateForm.stageId: " + stageId);
    this.stageId = stageId;
  }

  public int getPersonId() {
    return personId;
  }

  public void setPersonId(int personId) {
    trace("GenerateForm.personId: " + personId);
    this.personId = personId;
  }

  public int getAdoptionSubsidyId() {
    return adoptionSubsidyId;
  }

  public void setAdoptionSubsidyId(int adoptionSubsidyId) {
    trace("GenerateForm.adoptionSubsidyId: " + criminalHistoryId);
    this.adoptionSubsidyId = adoptionSubsidyId;
  }

  public int getCriminalHistoryId() {
    return criminalHistoryId;
  }

  public void setCriminalHistoryId(int criminalHistoryId) {
    trace("GenerateForm.criminalHistoryId: " + criminalHistoryId);
    this.criminalHistoryId = criminalHistoryId;
  }

  public String getDocType() {
    return docType;
  }

  public void setDocType(String docType) {
    trace("GenerateForm.docType: " + docType);
    this.docType = docType;
  }

  public Date getDateTo() {
    return dateTo;
  }

  public void setDateTo(Date dateTo) {
    trace("GenerateForm.dateTo: " + dateTo);
    this.dateTo = dateTo;
  }

  public Date getDateFrom() {
    return dateFrom;
  }

  public void setDateFrom(Date dateFrom) {
    trace("GenerateForm.dateFrom: " + dateFrom);
    this.dateFrom = dateFrom;
  }

  public DocumentMetaData getDocumentMetaData() {
    return documentMetaData;
  }

  public String getPreFillData() {
    return preFillData;
  }

  /** Retrieves the DocumentMetaData for a given docType */
  protected static DocumentMetaData getDocumentMetaData(String docType) throws MarshalException, ValidationException {
    docType = docType.toUpperCase();

    //          String metaDataString = (String) JndiHelper.lookup(docType);
    //          StringReader stringReader = new StringReader(metaDataString);
    //          return DocumentMetaData.unmarshal(stringReader);

    String metaDataString = DocumentLookup.lookup(docType);
    StringReader stringReader = new StringReader(metaDataString);
    return DocumentMetaData.unmarshal(stringReader);

//      InputStream inputStream =
//        CaseFilePrint.class.getResourceAsStream("/DocumentsMetaData.xml");

//      Unmarshaller unmarshaller = new Unmarshaller(Documents.class);

//      Documents documents = (Documents)
//        unmarshaller.unmarshal(new InputStreamReader(inputStream));

//      for (int i = 0; i < (documents.getDocumentMetaData().length); i++)
//      {
//        DocumentMetaData documentMetaData = documents.getDocumentMetaData(i);
//        String documentType = documentMetaData.getDocumentType();
//        if (documentType.equals(docType))
//        {
//          return documentMetaData;
//        }
//      }
//      //!!! could error later
//      return null;
  }

//    protected static int logCount = 0;

//    /**
//     * Just temporary logging for debugging purposes
//     */
//    protected static void
//    printDocument(DocumentMetaData documentMetaData,
//                  String preFillData)
//    {
//      //only need this method for debugging; comment out for production
//      if (true)
//      {
//        return;
//      }
//      try
//      {
//        if (documentMetaData == null)
//        {
//          //!!! no metadata yet
//          return;
//        }

//        String documentMetaDataString =
//          documentMetaDataToString(documentMetaData);

//        DummyRequest request = new DummyRequest();
//        request.setAttribute("preFill", preFillData);
//        request.setAttribute("docMetaData", documentMetaDataString);

//        //call .Net
//        DocumentServicesHandler.showDocument(documentMetaData,
//                                             documentMetaDataString,
//                                             preFillData,
//                                             request);

//        String mimeType = (String) request.getAttribute("mimeType");
//        byte[] document = (byte[]) request.getAttribute("document");

//        if (document == null)
//        {
//          trace(" .Net reports no document available");
//          return;
//        }

//        logToFile(document);
//      }
//      catch (RemoteException e)
//      {
//        //bug 59
//        String noNarrativeFound =
//          "GetNarrativeException.ErrorCode = ARC_DOCS_ERR_DATA_ACCESSOR_FETCH_NARRATIVE";

//        //c:\temp\problem1.txt
//        String noNarrativeFound2 =
//          "ARC_DOCS_ERR_DATA_ACCESSOR_DESERIALIZE_NARRATIVE";

//        String noError1 = "ARC_DOCS_ERR_ENGINE_CREATE_DOC";
//        String noError2 = "ARC_DOCS_ERR_ENGINE_CREATE_COMPOSITE_DOC";

//        if ((e.toString().indexOf(noNarrativeFound) != -1) ||
//            (e.toString().indexOf(noNarrativeFound2) != -1) ||
//            (e.toString().indexOf(noError1) != -1) ||
//            (e.toString().indexOf(noError2) != -1))
//        {
//          trace("Caught NotFoundException");
//          logToFile(e);
//          return;
//        }
//        throw new RuntimeWrappedException(e);
//      }
//      catch (Throwable e)
//      {
//        throw new RuntimeWrappedException(e);
//      }
//    }

//    protected static String documentMetaDataToString(DocumentMetaData documentMetaData)
//      throws Exception
//    {
//      StringWriter stringWriter = new StringWriter();
//      Marshaller.marshal(documentMetaData, stringWriter);
//      return stringWriter.toString();
//    }

//    protected static void logToFile(Object object)
//    {
//      try
//      {
//        logCount++;
//        String fileName = "c:/temp/" + logCount + ".html";
//        trace("WRITING OUT: " + fileName);
//        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
//        PrintStream printStream = new PrintStream(fileOutputStream);

//        if (object instanceof Exception)
//        {
//          Exception exception = (Exception) object;
//          exception.printStackTrace(printStream);
//        }
//        else if (object instanceof byte[])
//        {
//          printStream.write((byte[]) object);
//        }
//        else
//        {
//          printStream.println(object);
//        }

//        printStream.flush();
//        printStream.close();
//      }
//      catch (Throwable e)
//      {
//        throw new RuntimeWrappedException(e);
//      }
//    }

  protected HttpServletRequest initializeRequest() {
    HttpServletRequest request = new DummyRequest();

    UserProfile userProfile = new UserProfile();
    userProfile.setUserLogonID(userLogin);

    HttpSession session = request.getSession();
    session.setAttribute(UserProfileHelper.USER_PROFILE_SESSION_ID,
                         userProfile);

    return request;
  }

  protected static final void trace(String string) {
    if (CaseFilePrint.ENABLE_SYSTEM_OUT) {
      //to avoid Brad's grep
      //noinspection UseOfSystemOutOrSystemErr
      PrintStream out = System.out;
      out.println(string);
    }
    GrndsTrace.msg(TRACE_TAG, 7, string);
  }
}
