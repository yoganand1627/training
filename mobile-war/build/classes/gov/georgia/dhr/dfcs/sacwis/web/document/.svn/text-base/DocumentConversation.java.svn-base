package gov.georgia.dhr.dfcs.sacwis.web.document;

// -- java classes --

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.BasePrsException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.InformationalPrsException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.spring.UsernameContextHolder;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.Base64;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.document.CompressionHelper;
import gov.georgia.dhr.dfcs.sacwis.service.document.DocumentSave;
import gov.georgia.dhr.dfcs.sacwis.service.document.DocumentServiceExecutor;
import gov.georgia.dhr.dfcs.sacwis.structs.document.DocumentMetaData;
import gov.georgia.dhr.dfcs.sacwis.structs.document.Error;
import gov.georgia.dhr.dfcs.sacwis.structs.document.ErrorMessages;
import gov.georgia.dhr.dfcs.sacwis.structs.document.types.RenderType;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BasePrsConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.web.document.successaction.DocumentSuccessAction;
import gov.georgia.dhr.dfcs.sacwis.ws.document.Document;

import java.io.ByteArrayOutputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.xml.rpc.soap.SOAPFaultException;

import org.grnds.facility.config.GrndsConfiguration;
import org.grnds.facility.log.GrndsLevel;
import org.grnds.facility.log.GrndsLogger;
import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * <p>Title: </p> <p>Description: </p> <p>Copyright: Copyright (c) 2002</p> <p>Company: </p>
 *
 * @author unascribed
 * @version 1.0
 *          <p/>
 *          Change History: Date      User         Description --------  ----------- ----------------------------------------------
 *          05/09/05  NALLAVS      SIR 23547 - Removed System.out.println statements.
 */

public class DocumentConversation extends BaseHiddenFieldStateConversation {

  private static final GrndsLogger GLOBAL_EXCEPTION_LOGGER =
          GrndsLogger.getLogger(GrndsConfiguration.getInstance().getProperty(ArchitectureConstants.GRNDS_DOMAIN,
                                                                             "exception.globalLogger"));

  private static final String WORD_MIME_TYPE = "application/msword";
  private static final String LEGACY_PROMPT_BRANCH = "legacyPrompt";
  //private static final String ERROR_MESSAGE_REQUEST_NAME = "errorMessageString";
  private static final String DOCUMENT_ERROR_BRANCH = "documentException";
  private static final String DOCUMENT_SAVE_ERROR_BRANCH = "documentSaveException";
  private static final String TRACE_TAG = "DocumentConversation";
  public static final boolean PROTECT_AS_PDF =
          Boolean.valueOf(GrndsConfiguration.getInstance().getProperty(ArchitectureConstants.GRNDS_DOMAIN,
                                                                       "ProtectAsPDF"));
  public static final boolean TRAINING_MODE =
          Boolean.valueOf(GrndsConfiguration.getInstance().getProperty(ArchitectureConstants.GRNDS_DOMAIN,
                                                                       "perUserSchemaSupport"));

  private DocumentSave documentSave;
  private DocumentServiceExecutor documentServiceExecutor;

  public void setDocumentSave(DocumentSave documentSave) {
    this.documentSave = documentSave;
  }

  public void setDocumentServiceExecutor(DocumentServiceExecutor documentServiceExecutor) {
    this.documentServiceExecutor = documentServiceExecutor;
  }

  public void showDocument_xa(GrndsExchangeContext context) {
    // Do performance tracing
    PerformanceTrace performanceTrace = new PerformanceTrace("DocumentConversation", "showDocument_xa");
    performanceTrace.enterScope();

    // Create local variables
    DocumentMetaData documentMetaData;
    HttpServletRequest request = context.getRequest();

    setTrainingMode(request);

    // Check request for error messages.  If there are error messages in the request
    // direct the request to the error page.
    if (request.getAttribute(BasePrsConversation.ERROR_MESSAGES) != null) {
      this.setPresentationBranch(DOCUMENT_ERROR_BRANCH, context);
      return;
    }

    String preFillData = null;
    String docType;
    String docMetaDataString = null;

    // Place each of the request parameter into attributes
    DocumentUtilityHelpers.changeParameterstoAttributes(request);

    // Get the specific document type requested and lookup in JNDI
    if (request.getAttribute("docType") != null) {
      docType = (String) request.getAttribute("docType");
      docMetaDataString = DocumentLookup.lookup(docType.toUpperCase());
    }
    if (docMetaDataString == null) {
      // Set Presentation Branch
      String errorMessageString = MessageLookup.getMessageByNumber(Messages.ARC_DOCS_JNDI_LOOKUP_FAILED);
      setErrorMessage(errorMessageString, request);
      //  request.setAttribute(ERROR_MESSAGE_REQUEST_NAME, errorMessageString);
      this.setPresentationBranch(DOCUMENT_ERROR_BRANCH, context);
      return;
    }

    /****************************************************************************
     * Marshall the string pulled from the JNDI into the DocumentMetaData object
     ****************************************************************************/
    StringReader stringReader = new StringReader(docMetaDataString);
    try {
      // Unmarshall the Xml String into the DocumentMetaData object
      documentMetaData = (DocumentMetaData) Unmarshaller.unmarshal(DocumentMetaData.class, stringReader);
    }
    catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception in marshalling:" + e.getMessage());
      processSevereException(context, e);
      return;
    }

    // Fill in the rest of the documentMetaData from the request
    try {
      documentMetaData = DocumentUtilityHelpers.completeDocumentMetaData(documentSave, request, documentMetaData,
                                                                         false);
    }
    catch (Exception e) {
      processSevereException(context, e);
    }
    
    boolean prefillalways = false;
    if (request.getAttribute("preFillAlways") != null) {
      String strPreFillAlway = (String)request.getAttribute("preFillAlways");
      prefillalways = Boolean.parseBoolean(strPreFillAlway);
    }
    
    if ((documentMetaData.getRenderFormat().getType() == RenderType.HTML_WITH_SHELL.getType()
         && documentMetaData.getTableMetaData() != null) 
         || (prefillalways == true)
         || documentMetaData.getTableMetaData() == null) {
      // If there is preFillMetaData call the tuxedo service
      if (documentMetaData.getPreFillMetaData() != null) {
        try {
          GrndsTrace.msg(TRACE_TAG, 7, "Calling prefill service");
          preFillData = DocumentServiceHelper.returnPreFillData(documentServiceExecutor, request, documentMetaData);
        }
        catch (ServiceException we) {
          GrndsTrace.msg(TRACE_TAG, 7, "Exception calling Tuxedo:" + we.getMessage());
          String errorMessageString = null;

          // Get the errorMessages collection for the tux service
          ErrorMessages errorMessages = documentMetaData.getPreFillMetaData().getErrorMessages();

          // Loop thru the error messages until the constant is found.
          for (int x = 0; x < errorMessages.getErrorCount(); x++) {
            Error error = errorMessages.getError(x);
            GrndsTrace.msg(TRACE_TAG, 7, "Value of Error code:" + error.getErrorCode());
            // TODO: This used to only get displayed if error code and name were the same, which is very weird.
            errorMessageString = MessageLookup.getMessageByName(error.getDisplayMessage());
            if (errorMessageString.equals(we.getMessage())) {
              break;
            }
          }

          //  If the error code could not be found then perform the default behavior
          if (errorMessageString == null) {
            if (!"PROCESS_SEVERE_ERROR".equals(errorMessages.getDefault().getDisplayMessage())) {
              GrndsTrace.msg(TRACE_TAG, 7,
                             "Getting default error message:" + errorMessages.getDefault().getDisplayMessage());
              errorMessageString = MessageLookup.getMessageByName(errorMessages.getDefault().getDisplayMessage());
            } else {
              processSevereException(context, we);
              return;
            }
          }

          //If there was an error message show the exception page.  Some documents will continue
          //processing if there are no rows returned.  For these the error message won't be set and
          //the web service will be called.
          if (errorMessageString != null) {
            setErrorMessage(errorMessageString, request);
            //request.setAttribute(ERROR_MESSAGE_REQUEST_NAME, errorMessageString);
            this.setPresentationBranch(DOCUMENT_ERROR_BRANCH, context);
            return;
          }
        }
        catch (Exception e) {
          GrndsTrace.msg(TRACE_TAG, 7, "Unknown exception getting prefill data:" + e.getMessage());
          processSevereException(context, e);
          return;
        }

      }
    }
    // Get the documentMeta Data into a string format
    //docMetaDataString = null;
    StringWriter stringWriter = new StringWriter();
    try {
      Marshaller.marshal(documentMetaData, stringWriter);
    }
    catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception in marshalling:" + e.getMessage());
      processSevereException(context, e);
      return;
    }

    docMetaDataString = stringWriter.toString();
    // End getting documentMetaData into String format

    try {
      Document document = DocumentServicesHandler.showDocument(documentMetaData, docMetaDataString, preFillData);
      // Put document into the request
      GrndsTrace.msg(TRACE_TAG, 7, document.getMimeType());
      if (document.getMimeType().equals(WORD_MIME_TYPE)
          && (documentMetaData.getRenderFormat().getType() == RenderType.HTML_WITHOUT_SHELL_TYPE)) {
        GrndsTrace.msg(TRACE_TAG, 7, "Going to legacy prompt");
        request.setAttribute(DocumentPresentation.CONTENT_REQUEST_NAME, document.getContent());
        request.setAttribute(DocumentPresentation.MIMETYPE_REQUEST_NAME, document.getMimeType());
        this.setPresentationBranch(LEGACY_PROMPT_BRANCH, context);
        return;
      } else {
        GrndsTrace.msg(TRACE_TAG, 7, "Going to show the document");
        byte[] documentArray = Base64.decode(document.getContent());
        request.setAttribute(DocumentPresentation.CONTENT_REQUEST_NAME, documentArray);
        request.setAttribute(DocumentPresentation.MIMETYPE_REQUEST_NAME, document.getMimeType());
      }
      if (documentMetaData.getSuccessActionClass() != null) {
        // Load the Input class
        request.setAttribute("documentStruct", document);
        String actionClass = documentMetaData.getSuccessActionClass().trim();
        Class succActionClass = Class.forName(actionClass);
        DocumentSuccessAction documentSuccessAction = (DocumentSuccessAction) succActionClass.newInstance();
        documentSuccessAction.execute(request);
      }
    }
    catch (RemoteException re) {
      if (re.detail instanceof SOAPFaultException) {
        SOAPFaultException se = (SOAPFaultException) re.detail;
        this.processSOAPException(context, se);
        return;
      } else {
        processSevereException(context, re);
        return;
      }
    }
    // SIR 23149 - All other exceptions should processSevere
    /* catch ( BasePrsException be )
    {
      setErrorMessage( be.getPresentationMessage(), request );
      this.setPresentationBranch( DOCUMENT_ERROR_BRANCH, context );
      return;
    }
    */
    // End SIR 23149

    catch (Exception e) {
      // Get the error code
      GrndsTrace.msg(TRACE_TAG, 7, "Unknown exception:" + e.getMessage());
      processSevereException(context, e);
      return;
    }

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }

  private void setTrainingMode(HttpServletRequest request) {
    // If in training mode, set the context holder to use the appropriate schema.  This
    // must be explicitly set since the DocumentConversation uses an unauthenticated servlet.
    if (TRAINING_MODE) {
      // Username should come over from the document tags.  We get from there,
      // instead of session since it is reliable.  Session could time out.
      String userName = ContextHelper.getString(request, "userName");
      UsernameContextHolder.setUsername(userName);
    }
  }

  private void setTrainingMode(String userName) {
    // If in training mode, set the context holder to use the appropriate schema.  This
    // must be explicitly set since the DocumentConversation uses an unauthenticated servlet.
    if (TRAINING_MODE) {
      UsernameContextHolder.setUsername(userName);
    }
  }

  public void checkSpelling_xa(GrndsExchangeContext context) {
    GrndsTrace.enterScope(TRACE_TAG + ".checkSpelling_xa");
    HttpServletRequest request = context.getRequest();
    List<String> names = new ArrayList<String>();
    List<String> values = new ArrayList<String>();

    //This variable should be getting widget names delimited by commas
    //that should be spell checked
    String fieldsToCheck = request.getParameter("hdnSpellCheckFields");

    int delimiterIndex = fieldsToCheck.indexOf(",");

    while (delimiterIndex != -1) {
      String parameterName = fieldsToCheck.substring(0, delimiterIndex).trim();
      String parameterValue = "";
      if (!"hdnFormInformation".equals(parameterName) && !"hdnPrepopulatedBookmarkXML".equals(parameterName) &&
          !"hdnSpellCheckFields".equals(parameterName)) {
        if (parameterName.indexOf("reptxt") != -1) {
          GrndsTrace.msg(TRACE_TAG, 7, "Name of parameter:" + parameterName);
          if (request.getParameter(parameterName) != null) {
            parameterValue = request.getParameter(parameterName);
          }
          StringBuffer sb = new StringBuffer(parameterName);
          sb = sb.replace(0, 6, "span");
          parameterName = sb.toString();
          GrndsTrace.msg(TRACE_TAG, 7, "New Name:" + sb.toString());
          names.add(parameterName);
          values.add(parameterValue);

        } else if (parameterName.indexOf("txt") != -1) {
          GrndsTrace.msg(TRACE_TAG, 7, "Name of parameter:" + parameterName);
          if (request.getParameter(parameterName) != null) {
            parameterValue = request.getParameter(parameterName);
          }
          StringBuffer sb = new StringBuffer(parameterName);
          sb = sb.replace(0, 3, "span");
          parameterName = sb.toString();
          GrndsTrace.msg(TRACE_TAG, 7, "New Name:" + sb.toString());
          names.add(parameterName);
          values.add(parameterValue);
        }
      }
      fieldsToCheck = fieldsToCheck.substring(delimiterIndex + 1, fieldsToCheck.length());
      delimiterIndex = fieldsToCheck.indexOf(",");
    }

    //This check will find the last remaining field or if there is only one field
    if (StringHelper.isValid(fieldsToCheck)) {
      String parameterName = fieldsToCheck.trim();
      String parameterValue = "";
      if (request.getParameter(parameterName) != null) {
        parameterValue = request.getParameter(parameterName);
      }
      names.add(parameterName);
      values.add(parameterValue);
    }

    String[] namesArray = new String[names.size()];
    String[] valuesArray = new String[values.size()];

    names.toArray(namesArray);
    values.toArray(valuesArray);

    try {
      String encodedHtml = DocumentServicesHandler.checkSpelling(namesArray, valuesArray);
      byte[] htmlArray = Base64.decode(encodedHtml);
      String htmlDocument = new String(htmlArray, ArchitectureConstants.CHARACTER_ENCODING);
      request.setAttribute("spellCheckDocument", htmlDocument);
    }
    catch (RemoteException re) {
      if (re.detail instanceof SOAPFaultException)
      //if (re.detail.getClass().getName().equals("javax.xml.rpc.soap.SOAPFaultException"))
      {
        SOAPFaultException se = (SOAPFaultException) re.detail;
        this.processSOAPException(context, se);
        return;
      } else {
        processSevereException(context, re);
        return;
      }
    }
    catch (Exception e) {
      // Get the error code
      GrndsTrace.msg(TRACE_TAG, 7, "Unknown exception:" + e.getMessage());
      processSevereException(context, e);
      return;
    }

    GrndsTrace.exitScope(TRACE_TAG + ".checkSpelling_xa");
    return;
  }

  public void checkSpellingForApplicationPage_xa(GrndsExchangeContext context) {
    GrndsTrace.enterScope(TRACE_TAG + ".checkSpellingForApplicationPage_xa");
    HttpServletRequest request = context.getRequest();
    List<String> names = new ArrayList<String>();
    List<String> values = new ArrayList<String>();

    //This variable should be getting widget names delimited by commas
    //that should be spell checked
    String fieldsToCheck = request.getParameter("hidSpellFields");

    int delimiterIndex = fieldsToCheck.indexOf(",");

    //Get the fields and put them into the HashMap
    while (delimiterIndex != -1) {
      String parameterName = fieldsToCheck.substring(0, delimiterIndex).trim();
      String parameterValue = "";
      if (request.getParameter(parameterName) != null) {
        parameterValue = request.getParameter(parameterName);
      }
      names.add(parameterName);
      values.add(parameterValue);
      fieldsToCheck = fieldsToCheck.substring(delimiterIndex + 1, fieldsToCheck.length());
      delimiterIndex = fieldsToCheck.indexOf(",");
    }

    //This check will find the last remaining field or if there is only one field
    if (StringHelper.isValid(fieldsToCheck)) {
      String parameterName = fieldsToCheck.trim();
      String parameterValue = "";
      if (request.getParameter(parameterName) != null) {
        parameterValue = request.getParameter(parameterName);
      }
      names.add(parameterName);
      values.add(parameterValue);
    }

    String[] namesArray = new String[names.size()];
    String[] valuesArray = new String[values.size()];

    names.toArray(namesArray);
    values.toArray(valuesArray);

    try {
      String encodedHtml = DocumentServicesHandler.checkSpelling(namesArray, valuesArray);
      byte[] htmlArray = Base64.decode(encodedHtml);
      String htmlDocument = new String(htmlArray, ArchitectureConstants.CHARACTER_ENCODING);
      request.setAttribute("spellCheckDocument", htmlDocument);
    }
    catch (RemoteException re) {
      if (re.detail instanceof SOAPFaultException)
      //if (re.detail.getClass().getName().equals("javax.xml.rpc.soap.SOAPFaultException"))
      {
        SOAPFaultException se = (SOAPFaultException) re.detail;
        this.processSOAPException(context, se);
        return;
      } else {
        processSevereException(context, re);
        return;
      }
    }
    catch (Exception e) {
      // Get the error code
      GrndsTrace.msg(TRACE_TAG, 7, "Unknown exception:" + e.getMessage());
      processSevereException(context, e);
      return;
    }

    GrndsTrace.exitScope(TRACE_TAG + ".checkSpellingForApplicationPage_xa");
    return;

  }

  public void previewDocument_xa(GrndsExchangeContext context) {
    GrndsTrace.enterScope(TRACE_TAG + ".previewDocument_xa");
    HttpServletRequest request = context.getRequest();

    DocumentMetaData documentMetaData;
    String xmlData;

    // Start of getting document meta data
    String docMetaDataString = request.getParameter("hdnFormInformation");
    try {
      docMetaDataString = new String(Base64.decode(docMetaDataString), ArchitectureConstants.CHARACTER_ENCODING);
    }
    catch (UnsupportedEncodingException e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Encoding Failure:" + e.getMessage());
      processSevereException(context, e);
    }
    GrndsTrace.msg(TRACE_TAG, 7, "Value of hdnFormInformation:" + docMetaDataString);

    // Get the DocumentMetaData
    StringReader stringReader = new StringReader(docMetaDataString);

    try {
      // Unmarshall the Xml String into the DocumentMetaData object
      documentMetaData = (DocumentMetaData) Unmarshaller.unmarshal(DocumentMetaData.class, stringReader);
    }
    catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Unknown exception:" + e.getMessage());
      processSevereException(context, e);
      return;
    }

    if (PROTECT_AS_PDF) {
      documentMetaData.setRenderFormat(RenderType.PDF);
    } else {
      documentMetaData.setRenderFormat(RenderType.HTML_WITHOUT_SHELL);
    }

    // Get the DocumentMetaData into a string
    StringWriter stringWriter = new StringWriter();
    try {
      xmlData = DocumentBuilderHelper.constructDocumentXml(request);
      Marshaller.marshal(documentMetaData, stringWriter);
    }
    catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Unknown exception:" + e.getMessage());
      processSevereException(context, e);
      return;
    }

    docMetaDataString = stringWriter.toString();

    try {
      Document document = DocumentServicesHandler.previewDocument(documentMetaData, docMetaDataString, xmlData);
      byte[] documentArray = Base64.decode(document.getContent());
      String mimeType = document.getMimeType();
      request.setAttribute(DocumentPresentation.CONTENT_REQUEST_NAME, documentArray);
      request.setAttribute(DocumentPresentation.MIMETYPE_REQUEST_NAME, mimeType);
    }
    catch (RemoteException re) {
      if (re.detail instanceof SOAPFaultException)
      //if (re.detail.getClass().getName().equals("javax.xml.rpc.soap.SOAPFaultException"))
      {
        SOAPFaultException se = (SOAPFaultException) re.detail;
        this.processSOAPException(context, se);
        return;
      } else {
        processSevereException(context, re);
        return;
      }
    }
    catch (Exception e) {
      // Get the error code
      GrndsTrace.msg(TRACE_TAG, 7, "Unknown exception:" + e.getMessage());
      processSevereException(context, e);
    }

    GrndsTrace.exitScope();
    return;
  }

  public void saveXmlDocument_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace("DocumentConversation", "saveXmlDocument_xa");
    performanceTrace.enterScope();
    GrndsTrace.enterScope(TRACE_TAG + ".saveXmlDocument");

    HttpServletRequest request = context.getRequest();
    DocumentMetaData documentMetaData = null;
    String xmlData = null;
    String docMetaDataString = null;

    // Start of getting document meta data
    if (request.getParameter("hdnFormInformation") != null) {
      String temp = request.getParameter("hdnFormInformation");
      try {
        docMetaDataString = new String(Base64.decode(temp), ArchitectureConstants.CHARACTER_ENCODING);
      }
      catch (UnsupportedEncodingException e) {
        GrndsTrace.msg(TRACE_TAG, 7, "Encoding Failure:" + e.getMessage());
        processSevereException(context, e);
      }
      GrndsTrace.msg(TRACE_TAG, 7, "Value of hdnFormInformation:" + docMetaDataString);
    }

    // Get the DocumentMetaData
    StringReader stringReader = new StringReader(docMetaDataString);
    try {
      // Unmarshall the Xml String into the DocumentMetaData object
      documentMetaData = (DocumentMetaData) Unmarshaller.unmarshal(DocumentMetaData.class, stringReader);
    }
    catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Unknown exception:" + e.getMessage());
      processSevereException(context, e);
    }
    setTrainingMode(documentMetaData.getUserName());

    try {
      // Get the xmlData to save
      xmlData = DocumentBuilderHelper.constructDocumentXml(request);

      // Added to check for nulls in the string.  SIR 22773
      byte[] xmlByteArray = getByteArray(xmlData, 0);

      ByteArrayOutputStream compressedByteOutputStream
              = CompressionHelper.compressData(xmlByteArray);

      documentMetaData = documentSave.saveDocument(documentMetaData, compressedByteOutputStream.toByteArray());
    }
    catch (ServiceException we) {
      if (we.getErrorCode() == Messages.MSG_CMN_TMSTAMP_MISMATCH) {
        processXmlSaveException(we.getErrorMessage(), context, documentMetaData, xmlData);
        return;
      } else {
        String errorMessageString = MessageLookup.getMessageByNumber(Messages.ARC_DOCS_ERR_UNEXPECTED_XML_SAVE);
        processXmlSaveException(errorMessageString, context, documentMetaData, xmlData);
        return;
      }
    }
    catch (BasePrsException be) {
      processXmlSaveException(be.getPresentationMessage(), context, documentMetaData, xmlData);
      return;
    }
    catch (Exception e) {
      GLOBAL_EXCEPTION_LOGGER.log(GrndsLevel.ALERT, "Failure closing result set.", e);
      String errorMessageString = MessageLookup.getMessageByNumber(Messages.ARC_DOCS_ERR_UNEXPECTED_XML_SAVE);
      processXmlSaveException(errorMessageString, context, documentMetaData, xmlData);
      return;
    }

    // Get the DocumentMetaData into a string
    StringWriter stringWriter = new StringWriter();
    try {
      Marshaller.marshal(documentMetaData, stringWriter);
    }
    catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Unknown exception:" + e.getMessage());
      processSevereException(context, e);
    }

    docMetaDataString = stringWriter.toString();

    try {
      Document document = DocumentServicesHandler.reconstructDocument(documentMetaData, docMetaDataString, xmlData);
      byte[] documentArray = Base64.decode(document.getContent());
      String mimeType = document.getMimeType();
      request.setAttribute(DocumentPresentation.CONTENT_REQUEST_NAME, documentArray);
      request.setAttribute(DocumentPresentation.MIMETYPE_REQUEST_NAME, mimeType);
    }
    catch (RemoteException re) {
      if (re.detail instanceof SOAPFaultException) {
        //SOAPFaultException se = (SOAPFaultException) re.detail;
        //if (se.getClass().getName().equals("javax.xml.rpc.soap.SOAPFaultException"))
        String message = MessageLookup.getMessageByNumber(Messages.ARC_DOCS_ERR_SUCC_SAVE_FAIL_RECONSTRUCT);
        this.processXmlSaveException(message, context, documentMetaData, xmlData);
        return;
      } else {
        String message = MessageLookup.getMessageByNumber(Messages.ARC_DOCS_ERR_SUCC_SAVE_FAIL_RECONSTRUCT);
        this.processXmlSaveException(message, context, documentMetaData, xmlData);
        return;
      }
    }
    catch (Exception e) {
      String errorMessage = MessageLookup.getMessageByNumber(Messages.ARC_DOCS_ERR_SUCC_SAVE_FAIL_RECONSTRUCT);
      this.processXmlSaveException(errorMessage, context, documentMetaData, xmlData);
      return;
    }

    //Exit Conversation Method
    GrndsTrace.exitScope();
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }

  public void recoverDocument_xa(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    DocumentMetaData documentMetaData = (DocumentMetaData) state.getAttribute("documentMetaData", request);
    String xmlData = (String) state.getAttribute("xmlData", request);

    //Marshall the documentMetaData
    StringWriter stringWriter = new StringWriter();
    try {
      Marshaller.marshal(documentMetaData, stringWriter);
    }
    catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Unknown exception:" + e.getMessage());
      processSevereException(context, e);
    }

    String docMetaDataString = stringWriter.toString();

    try {
      Document document = DocumentServicesHandler.reconstructDocument(documentMetaData, docMetaDataString, xmlData);
      byte[] documentArray = Base64.decode(document.getContent());
      String mimeType = document.getMimeType();
      request.setAttribute(DocumentPresentation.CONTENT_REQUEST_NAME, documentArray);
      request.setAttribute(DocumentPresentation.MIMETYPE_REQUEST_NAME, mimeType);
    }
    catch (RemoteException re) {

      if (re.detail instanceof SOAPFaultException)
      //  if (re.detail.getClass().getName().equals("javax.xml.rpc.soap.SOAPFaultException"))
      {
        SOAPFaultException se = (SOAPFaultException) re.detail;
        this.processSOAPException(context, se);
        return;
      } else {
        processSevereException(context, re);
        return;
      }
    }
    catch (Exception e) {
      // Get the error code
      GrndsTrace.msg(TRACE_TAG, 7, "Unknown exception:" + e.getMessage());
      processSevereException(context, e);
      return;
    }
    return;
  }

  public void displayLegacy_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace("DocumentConversation", "displayLegacy_xa");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();

    String encodedDocument = request.getParameter(DocumentPresentation.CONTENT_REQUEST_NAME);
    String mimeType = request.getParameter(DocumentPresentation.MIMETYPE_REQUEST_NAME);

    byte[] documentArray = Base64.decode(encodedDocument);
    request.setAttribute(DocumentPresentation.CONTENT_REQUEST_NAME, documentArray);
    request.setAttribute(DocumentPresentation.MIMETYPE_REQUEST_NAME, mimeType);

    performanceTrace.enterScope();
  }

  private void processXmlSaveException(String message,
                                       GrndsExchangeContext context,
                                       DocumentMetaData documentMetaData,
                                       String xmlData) {
    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();
    state.setAttribute("documentMetaData", documentMetaData, request);
    state.setAttribute("xmlData", xmlData, request);
    setErrorMessage(message, request);
    //request.setAttribute(ERROR_MESSAGE_REQUEST_NAME, message);
    this.setPresentationBranch(DOCUMENT_SAVE_ERROR_BRANCH, context);
  }

  private void processSOAPException(GrndsExchangeContext context, SOAPFaultException se) {
    String errorMessageName = DocumentUtilityHelpers.getErrorMessageName(se.getFaultCode().toString());
    if (errorMessageName != null) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception constant:" + errorMessageName);
      String errorMessageString = MessageLookup.getMessageByName(errorMessageName);
      setErrorMessage(errorMessageString, context.getRequest());
      //context.getRequest().setAttribute(ERROR_MESSAGE_REQUEST_NAME, errorMessageString);
      this.setPresentationBranch(DOCUMENT_ERROR_BRANCH, context);
    } else {
      processSevereException(context, se);
    }
    return;

  }

  // SIR 22773 - dejuanr - This method will run a null check on the byte conversion
  // It will repeat five times if it keeps gettgin the error.
  private byte[] getByteArray(String xmlData, int count)
          throws InformationalPrsException, UnsupportedEncodingException {
    byte[] byteArray = xmlData.getBytes(ArchitectureConstants.CHARACTER_ENCODING);
    String checkString = new String(byteArray);
    if (checkString.indexOf("\0") != -1) {
      if (count < 5) {
        GrndsTrace.msg(TRACE_TAG, 7, "Byte Array Creataion Error - Attempt #:" + count);
        byteArray = getByteArray(xmlData, ++count);
      } else {
        GrndsTrace.msg(TRACE_TAG, 7, "Byte Array Creataion Failed - Attempt #:" + count);
        throw new InformationalPrsException("An encoding error occured.");
      }
    }
    return byteArray;
  }
}