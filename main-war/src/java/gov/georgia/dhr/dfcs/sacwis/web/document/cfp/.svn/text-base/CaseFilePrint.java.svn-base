package gov.georgia.dhr.dfcs.sacwis.web.document.cfp;

import java.io.ByteArrayOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import javax.ejb.CreateException;
import javax.jms.JMSException;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;

import org.grnds.facility.config.GrndsConfiguration;
import org.grnds.facility.log.GrndsTrace;

import gov.georgia.dhr.dfcs.sacwis.core.base.DuplicateRecordException;
import gov.georgia.dhr.dfcs.sacwis.core.base.NoRowsUpdatedException;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.InformationalPrsException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.TooManyRowsReturnedException;
import gov.georgia.dhr.dfcs.sacwis.core.jndihelper.JndiHelper;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodeNotFoundException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.DataNotFoundException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.DuplicateRecordFoundException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.ReferenceDataLookupException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.TableNotFoundException;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.Base64;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility;
import gov.georgia.dhr.dfcs.sacwis.dao.document.CompressionHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.document.DocumentStageClosedException;
import gov.georgia.dhr.dfcs.sacwis.dao.document.DocumentStageNotFoundException;
import gov.georgia.dhr.dfcs.sacwis.dao.document.cfp.CfpStatusDB;
import gov.georgia.dhr.dfcs.sacwis.dao.document.cfp.DocumentGenerationMetaDataDB;
import gov.georgia.dhr.dfcs.sacwis.dao.document.cfp.DocumentTypeDB;
import gov.georgia.dhr.dfcs.sacwis.dao.document.cfp.ExceedQueueLimitException;
import gov.georgia.dhr.dfcs.sacwis.dao.document.cfp.ICaseFilePrint;
import gov.georgia.dhr.dfcs.sacwis.dao.document.cfp.StageDB;
import gov.georgia.dhr.dfcs.sacwis.service.document.Cfp;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC33SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC33SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC33SOG01;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC33SOG02;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC33SOG03;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC33SOG04;
import gov.georgia.dhr.dfcs.sacwis.web.core.exception.handler.ExceptionHandler;
import gov.georgia.dhr.dfcs.sacwis.ws.cfp.Case_x0020_File_x0020_ServicesSoap_Stub;
import gov.georgia.dhr.dfcs.sacwis.ws.cfp.Case_x0020_File_x0020_Services_Impl;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.ValidationException;
import org.springframework.beans.factory.BeanFactory;
import pkware.DCL.InvalidDictionarySizeException;
import pkware.DCL.InvalidModeException;

/**
 * CfpConversation calls submitCfp submitCfp creates a cfp_status row in the database and creates a thread to handle the
 * request
 * <p/>
 * (run) does the following: CFP gets a list of all document codes in a stage Create JobDescriptor for each documentCode
 * in documentCodes metaData = getMetaData(documentCode) generateMethod = metaData.generateMethod if (generateMethod in
 * {'GenerateForm', 'GenerateDocument', 'GenerateReport'}) { call CCFC33S execute `generateMethod` according to
 * metaData.foreach add resulting DocumentDescriptors to JobDescriptor } else { call CCFC33S execute special case
 * `generateMethod` (ccfc33so) add resulting DocumentDescriptors to JobDescriptor }
 * <p/>
 * Have JobDescriptor look up report ids for all DocumentDescriptors which represent reports. Turn JobDescriptor into
 * XML String Send JobDescriptor off to .Net service
 */
public class CaseFilePrint implements Serializable, ICaseFilePrint {
  private static final long serialVersionUID = -1912197480491311230L;

  public static final String TRACE_TAG = "CaseFilePrint";

  public static final boolean ENABLE_SYSTEM_OUT =
          "true".equals(GrndsConfiguration.getInstance().getProperty(ArchitectureConstants.GRNDS_DOMAIN,
                                                                     "enable.system.out.Cfp"));

  protected static final int RETRY_CCFC33S = 5;
  protected static final int FOUR_MEGS = 4000000;

  protected CfpStatusDB cfpStatusDB = null;
  protected String userLogin = null;
  protected String jobName = null;
  protected String[] outputCodesArray = null;

  private static final String QUEUE_JNDI_NAME = "jms/cfpQueue__pm";
  private static final String QUEUE_CONNECTION_FACTORY_JNDI_NAME = "jms/cfpQueueConnectionFactory__pm";

  /** Object which is passed to CfpMDB to be executed */
  public CaseFilePrint(CfpStatusDB cfpStatusDB, String userLogin, String jobName, String[] outputCodesArray) {
    this.cfpStatusDB = cfpStatusDB;
    this.userLogin = userLogin;
    this.jobName = jobName;
    this.outputCodesArray = outputCodesArray;
  }

  /**
   * Errors if user already has QUEUE_LIMIT jobs in queue. Creates a cfp_status row to encapsulate this request.
   * enqueues a CaseFilePrint job to fullfill request.
   */
  public static void submitCfp(Cfp cfp, int userId, String userLogin, String jobName, String destinationFileName,
                               int caseId,
                               int stageId, String[] outputCodesArray)
          throws RemoteException, ExceedQueueLimitException {
    GrndsTrace.enterScope(TRACE_TAG + ".submitCfp: \n" +
                          "\tuserId: " + userId + "\n" +
                          "\tuserLogin: " + userLogin + "\n" +
                          "\tjobName: " + jobName + "\n" +
                          "\tdestinationFileName: " + destinationFileName + "\n" +
                          "\tcaseId: " + caseId + "\n" +
                          "\toutputCodesArray.length: " + outputCodesArray.length + "\n");

    List vector = cfp.getQueuedCfpStatusForUser(userId);
    if (vector.size() >= QUEUE_LIMIT) {
      throw new ExceedQueueLimitException();
    }

    CfpStatusDB cfpStatusDB = new CfpStatusDB();
    cfpStatusDB.setCaseId(caseId);
    cfpStatusDB.setStageId(stageId);

    if (stageId != 0) {
      CaseUtility.Stage stage = CaseUtility.getStage(stageId);
      cfpStatusDB.setStageCode(stage.getCdStage());
    }

    cfpStatusDB.setPersonId(userId);
    cfpStatusDB.setStatus(CfpStatusDB.SUBMITTED);
    cfpStatusDB.setPath(destinationFileName);
    cfpStatusDB.setProgress("0/0 <!-- creating job descriptor -->");

    cfpStatusDB = cfp.createCfpStatus(cfpStatusDB);

    CaseFilePrint caseFilePrint = new CaseFilePrint(cfpStatusDB, userLogin, jobName, outputCodesArray);
    try {
      //execute CFP in a separate thread
      enqueue(caseFilePrint);
    } catch (Exception e) {
      handleCfpError(cfp, cfpStatusDB, e);
    }

    GrndsTrace.exitScope();
  }

  private static void enqueue(ICaseFilePrint caseFilePrint) throws JMSException {
    GrndsTrace.enterScope(TRACE_TAG + ".enqueue");

    QueueConnection queueConnection = null;
    QueueSession queueSession = null;
    QueueSender queueSender = null;
    Queue queue;
    try {
      queue = (Queue) JndiHelper.lookup(QUEUE_JNDI_NAME);
      QueueConnectionFactory factory = (QueueConnectionFactory) JndiHelper.lookup(QUEUE_CONNECTION_FACTORY_JNDI_NAME);
      queueConnection = factory.createQueueConnection();
      queueSession = queueConnection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
      queueSender = queueSession.createSender(queue);
      ObjectMessage objectMessage = queueSession.createObjectMessage(caseFilePrint);
      queueSender.send(objectMessage);
    } finally {
      if (queueSender != null) {
        queueSender.close();
      }
      if (queueSession != null) {
        queueSession.close();
      }
      if (queueConnection != null) {
        queueConnection.close();
      }
      GrndsTrace.exitScope();
    }
  }

  /**
   * Creates JobDescriptor Gets stageDB Gets allowed documents for program, stage, stageType For each allowed document
   * which is in outputCodesArray, calls generateDocuments Calls .Net service with the complete JobDescriptor If an
   * Exception is thrown, it sets error status on the cfp_status row
   */
  public void queueJob(BeanFactory beanFactory) {
    Cfp cfp = (Cfp) beanFactory.getBean("cfp");
    try {
      GrndsTrace.enterScope(TRACE_TAG + ".run: \n" +
                            "\tuserId: " + cfpStatusDB.getPersonId() + "\n" +
                            "\tjobName: " + jobName + "\n" +
                            "\tdestinationFileName: " + cfpStatusDB.getPath() + "\n" +
                            "\tcaseId: " + cfpStatusDB.getCaseId() + "\n" +
                            "\toutputCodesArray.length: " + outputCodesArray.length + "\n");
      JobDescriptor jobDescriptor = createJobDescriptor(beanFactory);
      String jobDescriptorString = jobDescriptor.toXmlString(cfp);
      trace(jobDescriptorString);

      if (ENABLE_SYSTEM_OUT) {
        logToFile(jobDescriptorString);
      }

      //call .Net service
      queueCaseFilePrintJob(jobDescriptorString);

      int numberOfJobs = jobDescriptor.getNumberOfDocumentDescriptors();
      cfp.updateProgress(cfpStatusDB.getStatusId(), "0/" + numberOfJobs + "<!-- submitted to .Net -->");

      GrndsTrace.exitScope();
    } catch (Exception e) {
      handleCfpError(cfp, cfpStatusDB, e);
    }
  }

  /** Creates JobDescriptor for the CaseFilePrint job Refactored to make it easier to build a test harness */
  public JobDescriptor createJobDescriptor(BeanFactory beanFactory)
          throws RemoteException, TooManyRowsReturnedException, CreateException, ValidationException,
                 DuplicateRecordException, NoSuchMethodException, ParseException, IllegalAccessException,
                 InstantiationException, MarshalException, CodeNotFoundException, DocumentStageClosedException,
                 InvocationTargetException, ClassNotFoundException, NoRowsUpdatedException, SQLException,
                 DocumentStageNotFoundException, ReferenceDataLookupException, TableNotFoundException,
                 DuplicateRecordFoundException, DataNotFoundException {
    JobDescriptor jobDescriptor = new JobDescriptor();
    jobDescriptor.setCfpStatus(cfpStatusDB);
    jobDescriptor.setJobName(jobName);

    Set outputCodes = CfpConversation.arrayToSet(outputCodesArray);
    Cfp cfp = (Cfp) beanFactory.getBean("cfp");
    StageDB stageDB = cfp.getStageDB(cfpStatusDB.getCaseId(), cfpStatusDB.getStageId());

    DocumentTypeDB[] documentTypes =
            cfp.getDocumentOrder(stageDB.getProgramName(), stageDB.getStageCode(), stageDB.getStageType());

    for (int i = 0; i < documentTypes.length; i++) {
      if (outputCodes.contains(documentTypes[i].getOutputCode()) == false) {
        continue;
      }
      generateDocuments(beanFactory, jobDescriptor, documentTypes[i].getOutputCode(), cfpStatusDB.getCaseId(),
                        cfpStatusDB.getStageId(), cfpStatusDB.getPersonId(), userLogin);
    }
    return jobDescriptor;
  }

  /** Prints the stack trace; sets the cfp_status row to error */
  protected static void handleCfpError(Cfp cfp, CfpStatusDB cfpStatusDB, Exception e) {
    String DEFAULT_MESSAGE = "Unexpected error creating CFP job descriptor.";
    String errorMessage = DEFAULT_MESSAGE;
    if (e instanceof ServiceException) {
      ServiceException wtcException = (ServiceException) e;
      int errorCode = wtcException.getErrorCode();
      if ((errorCode != -1) &&
          (errorCode != 0)) {
        errorMessage = MessageLookup.getMessageByNumber(errorCode);
      }
      if (errorMessage == null) {
        errorMessage = DEFAULT_MESSAGE;
      }
    }
    ExceptionHandler.handle(e);

    //!!! temporary; because ExceptionHandler.handle isn't printing stack trace
    trace("!!! CFP");
    trace("\n" + ExceptionHandler.getStackTrace(e));

    try {
      //mark error on CfpStatus
      cfp.setError(cfpStatusDB.getStatusId(), errorMessage);
    } catch (Exception t) {
      trace("error calling cfp.setError");
      trace("\n" + ExceptionHandler.getStackTrace(t));
      ExceptionHandler.handle(t);
    }
  }

  protected static int logCount = 0;

  protected static void logToFile(String jobDescriptorString) {
    PrintWriter printWriter = null;
    try {
      logCount++;
      String fileName = "c:/temp/jobDescriptor" + logCount + ".xml";
      trace("WRITING OUT: " + fileName);
      FileWriter fileWriter = new FileWriter(fileName);
      printWriter = new PrintWriter(fileWriter);
      printWriter.println(jobDescriptorString);
      printWriter.flush();
    } catch (IOException e) {
      //logging won't work on Gemini; it's mostly meant for local dev.
      //after all the jobDescriptor is still saved to impact-trace.log
      //which on gemini is: /opt/impact/config/devl/log/impact-trace.log
      //(You can only access via putty ssh to canis [bea/beaadm1n])
      throw new RuntimeException(e);
    } finally {
      if (printWriter != null) {
        printWriter.close();
      }
    }
  }

  /**
   * Retrieves meta data about a given document type, so it knows how to generate documents for a given documentType.
   * <p/>
   * If GenerateMethod not in (GenerateForm, GenerateDocument, GenerateReport) it calls generateSpecialCase and returns
   * Otherwise, it creates either GenerateReport or GenerateForm object sets metadata on it
   * <p/>
   * if ForEach is null, it executes the object once and returns
   * <p/>
   * Otherwise, It calls CCFC33S Depending on the ForEach, it loops over one of the arrays returned by CCFC33S, setting
   * values on GenerateReport/GenerateForm and executes it each time in the loop
   */
  protected void generateDocuments(BeanFactory beanFactory, JobDescriptor jobDescriptor, String outputCode,
                                   int caseId, int stageId, int userId, String userLogin)
          throws RemoteException, TooManyRowsReturnedException, CreateException, ValidationException,
                 DuplicateRecordException, NoSuchMethodException, ParseException, IllegalAccessException,
                 InstantiationException, MarshalException, CodeNotFoundException, DocumentStageClosedException,
                 InvocationTargetException, ClassNotFoundException, NoRowsUpdatedException,
                 ReferenceDataLookupException, DocumentStageNotFoundException, SQLException, TableNotFoundException,
                 DuplicateRecordFoundException, DataNotFoundException {
    GrndsTrace.enterScope(TRACE_TAG + ".generateDocuments \n" +
                          "\t outputCode: " + outputCode + "\n " +
                          "\t caseId: " + caseId + "\n " +
                          "\t stageId: " + stageId + "\n " +
                          "\t userId: " + userId + "\n ");
    Cfp cfp = (Cfp) beanFactory.getBean("cfp");
    DocumentGenerationMetaDataDB metaData = cfp.getDocumentGenerationMetaData(outputCode);

    String generateMethod = metaData.getGenerateMethod();
    if ((generateMethod.equals(GENERATE_FORM) == false) &&
        (generateMethod.equals(GENERATE_DOCUMENT) == false) &&
        (generateMethod.equals(GENERATE_REPORT) == false)) {
      generateSpecialCase(beanFactory, jobDescriptor, metaData, caseId, stageId, userId, userLogin);
      return;
    }
    GenerateForm generateForm;
    if (generateMethod.equals(GENERATE_DOCUMENT)) {
      generateForm = new GenerateDocument(beanFactory);
    } else if (generateMethod.equals(GENERATE_REPORT)) {
      generateForm = new GenerateReport(beanFactory);
    } else {
      generateForm = new GenerateForm(beanFactory);
    }
    generateForm.setJobDescriptor(jobDescriptor);
    generateForm.setDocType(metaData.getDocType());
    generateForm.setCaseId(caseId);
    generateForm.setUserId(userId);
    generateForm.setUserLogin(userLogin);

    if (metaData.isForEachNull()) {
      generateForm.execute();
      return;
    }

    CCFC33SO ccfc33so = callCCFC33S(outputCode, caseId, stageId, userLogin);
    ROWCCFC33SOG01 rowccfc33sog01 = ccfc33so.getROWCCFC33SOG01();
    int[] stageIds = rowccfc33sog01.getUlIdStage_ARRAY().getUlIdStage();
    ROWCCFC33SOG02 rowccfc33sog02 = ccfc33so.getROWCCFC33SOG02();
    int[] eventIds = rowccfc33sog02.getUlIdEvent_ARRAY_CCFC33S().getUlIdEvent();
    ROWCCFC33SOG03 rowccfc33sog03 = ccfc33so.getROWCCFC33SOG03();
    int[] personIds = rowccfc33sog03.getUlIdPerson_ARRAY_CCFC33S().getUlIdPerson();
    ROWCCFC33SOG04 rowccfc33sog04 = ccfc33so.getROWCCFC33SOG04();
    int[] crimHistIds = rowccfc33sog04.getUlIdCrimHist_ARRAY().getUlIdCrimHist();

    int length = 0;
    if (metaData.isForEachStage()) {
      length = stageIds.length;
    }
    //!!! rename to forEachEventStage
    if (metaData.isForEachStageEvent()) {
      //C code loops over eventIds
      // as there might be a stageId
      // even when there isn't an eventId
      length = eventIds.length;
    }
    if (metaData.isForEachEvent()) {
      length = eventIds.length;
    }
    if (metaData.isForEachPerson()) {
      length = personIds.length;
    }
    if (metaData.isForEachCriminalHistory()) {
      length = crimHistIds.length;
    }

    for (int i = 0; i < length; i++) {
      if (metaData.isForEachStage()) {
        generateForm.setStageId(stageIds[i]);
      } else if (metaData.isForEachStageEvent()) {
        generateForm.setStageId(stageIds[i]);
        generateForm.setEventId(eventIds[i]);
      } else if (metaData.isForEachEvent()) {
        generateForm.setEventId(eventIds[i]);
      } else if (metaData.isForEachPerson()) {
        generateForm.setPersonId(personIds[i]);
      } else if (metaData.isForEachCriminalHistory()) {
        generateForm.setCriminalHistoryId(crimHistIds[i]);
      } else {
        throw new IllegalStateException("unexpected foreach case '" + metaData.getForEach() + "'");
      }
      generateForm.execute();
    }
    GrndsTrace.exitScope();
  }

  /**
   * Loads the correct GenerateSpecialCase class by name from the metaData Calls CCFC33S Sets row values of CCFC33S on
   * GenerateSpecialCase Calls GenerateSpecialCase.execute
   */
  protected static void generateSpecialCase(BeanFactory beanFactory, JobDescriptor jobDescriptor,
                                            DocumentGenerationMetaDataDB metaData, int caseId, int stageId, int userId,
                                            String userLogin)
          throws ClassNotFoundException, IllegalAccessException, InstantiationException, MarshalException,
                 ValidationException, TooManyRowsReturnedException, CreateException, DuplicateRecordException,
                 NoSuchMethodException, ParseException, CodeNotFoundException, DocumentStageClosedException,
                 InvocationTargetException, NoRowsUpdatedException, SQLException, DocumentStageNotFoundException,
                 ReferenceDataLookupException, TableNotFoundException, DuplicateRecordFoundException,
                 DataNotFoundException, RemoteException {

    GrndsTrace.enterScope(TRACE_TAG + ".generateSpecialCase \n" +
                          "\t metaData: " + metaData + "\n " +
                          "\t caseId: " + caseId + "\n " +
                          "\t stageId: " + stageId + "\n " +
                          "\t userId: " + userId + "\n " +
                          "\t userLogin: " + userLogin + "\n ");

    String generateMethod = metaData.getGenerateMethod();
    String className = "gov.georgia.dhr.dfcs.sacwis.web.document.cfp." + generateMethod;

    Class<?> specialCaseClass = Class.forName(className);
    Constructor<?> specialCaseConstructor = specialCaseClass.getConstructor(BeanFactory.class);
    GenerateSpecialCase generateSpecialCase = (GenerateSpecialCase) specialCaseConstructor.newInstance(beanFactory);
    generateSpecialCase.setJobDescriptor(jobDescriptor);
    generateSpecialCase.setCaseId(caseId);
    generateSpecialCase.setSelectedStageId(stageId);
    generateSpecialCase.setUserId(userId);
    generateSpecialCase.setUserLogin(userLogin);

    //!!! duplicated from generateDocuments
    CCFC33SO ccfc33so = callCCFC33S(metaData.getOutputCode(), caseId, stageId, userLogin);

    ROWCCFC33SOG01 rowccfc33sog01 = ccfc33so.getROWCCFC33SOG01();
    int[] stageIds = rowccfc33sog01.getUlIdStage_ARRAY().getUlIdStage();
    ROWCCFC33SOG02 rowccfc33sog02 = ccfc33so.getROWCCFC33SOG02();
    int[] eventIds = rowccfc33sog02.getUlIdEvent_ARRAY_CCFC33S().getUlIdEvent();
    int[] ulSysNbrUlongKeys = rowccfc33sog02.getUlSysNbrUlongKey_ARRAY().getUlSysNbrUlongKey();
    ROWCCFC33SOG03 rowccfc33sog03 = ccfc33so.getROWCCFC33SOG03();
    int[] personIds = rowccfc33sog03.getUlIdPerson_ARRAY_CCFC33S().getUlIdPerson();
    ROWCCFC33SOG04 rowccfc33sog04 = ccfc33so.getROWCCFC33SOG04();
    int[] crimHistIds = rowccfc33sog04.getUlIdCrimHist_ARRAY().getUlIdCrimHist();

    String cIndRiskAssmtIntranet = ccfc33so.getCIndRiskAssmtIntranet();
    int ulNbrReviewContact = ccfc33so.getUlNbrReviewContact();

    //          int ulIdSituation = ccfc33so.getUlIdSituation();
    //          int ulSysNbrUlongKey = ccfc33so.getUlSysNbrUlongKey();

    generateSpecialCase.setStageIds(stageIds);
    generateSpecialCase.setEventIds(eventIds);
    generateSpecialCase.setPersonIds(personIds);
    generateSpecialCase.setCriminalHistoryIds(crimHistIds);

    generateSpecialCase.setUlSysNbrUlongKeys(ulSysNbrUlongKeys);
    generateSpecialCase.setCIndRiskAssmtIntranet(cIndRiskAssmtIntranet);
    generateSpecialCase.setUlNbrReviewContact(ulNbrReviewContact);
    generateSpecialCase.generateSpecialCase();
    GrndsTrace.exitScope();
  }

  /** Wraps CCFC33S */
  protected static CCFC33SO callCCFC33S(String reportId, int caseId, int stageId, String userLogin)
          throws MarshalException, ValidationException {
    GrndsTrace.enterScope(TRACE_TAG + ".callCCFC33S \n" +
                          "\t reportId: " + reportId + "\n " +
                          "\t caseId: " + caseId + "\n " +
                          "\t stageId: " + stageId + "\n " +
                          "\t userLogin: " + userLogin + "\n ");

    String cReqFuncCd = "C";

    CCFC33SI ccfc33si = new CCFC33SI();
    ccfc33si.setUlIdCase(caseId);
    if (stageId != 0) {
      cReqFuncCd = "S";
      ccfc33si.setUlIdStage(stageId);
    }
    ccfc33si.setUlIdSituation(0);
    ccfc33si.setSzSysCdCaseFilePrntRpt(reportId);

    ArchInputStruct archInputStruct = new ArchInputStruct();
    archInputStruct.setCReqFuncCd(cReqFuncCd);
    archInputStruct.setSzUserId(userLogin);
    ccfc33si.setArchInputStruct(archInputStruct);

    trace("ccfc33si: " + ccfc33si);

    // FIXME: This service needs to be converted (raw form is in service\src\conversion)
    CCFC33SO ccfc33so = null;
    //CCFC33SO ccfc33so = (CCFC33SO) WtcHelper.callService("CCFC33S", ccfc33si, CCFC33SO.class, RETRY_CCFC33S);

    trace("ccfc33so: " + ccfc33so);

    GrndsTrace.exitScope();
    return ccfc33so;
  }

  /** Wraps call to .Net CaseFileServices.collateCaseFile */
  public static void queueCaseFilePrintJob(String jobDescriptorString)
          throws IOException, InvalidModeException, InformationalPrsException,
                 InvalidDictionarySizeException, InterruptedException {
    GrndsTrace.enterScope(TRACE_TAG + ".queueCaseFilePrintJob");

    Case_x0020_File_x0020_Services_Impl cfpServices_Impl =
            new Case_x0020_File_x0020_Services_Impl();

    Case_x0020_File_x0020_ServicesSoap_Stub cfpServicesSoap =
            (Case_x0020_File_x0020_ServicesSoap_Stub)
                    cfpServices_Impl.getCase_x0020_File_x0020_ServicesSoap();

    //allows me to change it out on the fly
    String caseFileServicesUrl = getProperty("/sacwis.properties", "CaseFileServicesUrl");

    cfpServicesSoap._setProperty(javax.xml.rpc.Stub.ENDPOINT_ADDRESS_PROPERTY, caseFileServicesUrl);

    trace("CASEFILE_SERVICES_URL: " + caseFileServicesUrl);

    ByteArrayOutputStream byteArrayOutputStream =
            CompressionHelper.compressData(jobDescriptorString.getBytes(ArchitectureConstants.CHARACTER_ENCODING));

    byte[] array = byteArrayOutputStream.toByteArray();
    jobDescriptorString = Base64.encode(array);

    if (jobDescriptorString.length() >= FOUR_MEGS) {
      throw new ServiceException(Messages.ARC_DOCS_ERR_CFP_JOB_TOO_LARGE);
    }

    int returnValue = cfpServicesSoap.collateCaseFile(jobDescriptorString);

    trace("returnValue: " + returnValue);
    GrndsTrace.exitScope();
  }

  /** allows me to change property file without reloading */
  protected static String getProperty(String fileName, String propertyName) {
    Properties properties = getProperties(fileName);
    return properties.getProperty(propertyName);
  }

  /** allows me to change property file without reloading */
  protected static Properties getProperties(String fileName) {
    try {
      InputStream inputStream = CaseFilePrint.class.getResourceAsStream(fileName);
      Properties properties = new Properties();
      properties.load(inputStream);
      return properties;
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  /** wrapper around GrndsTrace, which may System.out.println(); */
  protected static final void trace(String string) {
    if (ENABLE_SYSTEM_OUT) {
      //to avoid Brad's grep
      //noinspection UseOfSystemOutOrSystemErr
      PrintStream out = System.out;
      out.println(string);
    }
    GrndsTrace.msg(TRACE_TAG, 7, string);
  }
}
