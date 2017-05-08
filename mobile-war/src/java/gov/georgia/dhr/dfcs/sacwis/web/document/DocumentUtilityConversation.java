package gov.georgia.dhr.dfcs.sacwis.web.document;

import java.io.StringReader;
import java.io.StringWriter;
import java.rmi.RemoteException;

import javax.servlet.http.HttpServletRequest;
import javax.xml.rpc.soap.SOAPFaultException;

import org.grnds.facility.config.GrndsConfiguration;
import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.Base64;
import gov.georgia.dhr.dfcs.sacwis.service.document.DocumentSave;
import gov.georgia.dhr.dfcs.sacwis.service.document.DocumentServiceExecutor;
import gov.georgia.dhr.dfcs.sacwis.structs.document.DocumentMetaData;
import gov.georgia.dhr.dfcs.sacwis.structs.document.Error;
import gov.georgia.dhr.dfcs.sacwis.structs.document.ErrorMessages;
import gov.georgia.dhr.dfcs.sacwis.structs.document.types.RenderType;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.ws.document.Document;
import gov.georgia.dhr.dfcs.sacwis.ws.document.DocumentServicesSoap;
import gov.georgia.dhr.dfcs.sacwis.ws.document.DocumentServicesSoap_Stub;
import gov.georgia.dhr.dfcs.sacwis.ws.document.DocumentServices_Impl;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * <pre>
 * Change History:
 * Date      User         Description
 * --------  -----------  ----------------------------------------------
 * 05/09/05  NALLAVS      SIR 23547 - Removed System.out.println statements.
 * </pre>
 */
public class DocumentUtilityConversation extends BaseHiddenFieldStateConversation {
  //private static final String WORD_MIME_TYPE = "application/msword";
  //private static final String LEGACY_PROMPT_BRANCH = "legacyPrompt";
  public static final String CONTENT_REQUEST_NAME = "document";
  public static final String MIMETYPE_REQUEST_NAME = "mimetype";
  //private static final String LEGACY_MESSAGE_REQUEST_NAME = "legacyMessage";
  //private static final String ERROR_MESSAGE_REQUEST_NAME = "errorMessageString";
  //private static final String LEGACY_SAVE_SUCCESS = "SUCCESS";
  //private static final String LEGACY_SAVE_ERROR = "ERROR";
  private static final String DOCUMENT_ERROR_BRANCH = "documentException";
  //private static final String DOCUMENT_SAVE_ERROR_BRANCH = "documentSaveException";
  //private static final String DOCUMENT_LEGACY_ERROR_BRANCH = "legacyDocumentException";
  private static final String TRACE_TAG = "DocumentUtilityConversation";
  public static final boolean PROTECT_AS_PDF =
          Boolean.valueOf(GrndsConfiguration.getInstance().getProperty(ArchitectureConstants.GRNDS_DOMAIN,
                                                                       "ProtectAsPDF"));

  private DocumentSave documentSave;
  private DocumentServiceExecutor documentServiceExecutor;

  public void setDocumentSave(DocumentSave documentSave) {
    this.documentSave = documentSave;
  }

  public void setDocumentServiceExecutor(DocumentServiceExecutor documentServiceExecutor) {
    this.documentServiceExecutor = documentServiceExecutor;
  }

  public void showCurrentUsingBlankDocument_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace("DocumentUtilityConversation",
                                                             "showCurrentUsingBlankDocument_xa");
    performanceTrace.enterScope();

    DocumentMetaData documentMetaData;
    String preFillData = null;
    HttpServletRequest request = context.getRequest();

    String docType = request.getParameter("docType");
    String docMetaDataString = DocumentLookup.lookup(docType);

    // Place each of the request parameter into attributes
    DocumentUtilityHelpers.changeParameterstoAttributes(request);

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
      if (context.getRequest().getParameter("tableName") != null) {
        documentMetaData.getTableMetaData().setTableName(context.getRequest().getParameter("tableName"));
      }
      documentMetaData = DocumentUtilityHelpers.completeDocumentMetaData(documentSave, request, documentMetaData,
                                                                         false);
      documentMetaData.setRenderFormat(RenderType.HTML_WITHOUT_SHELL);
    }
    catch (Exception e) {
      processSevereException(context, e);
    }

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
      GrndsTrace.msg(TRACE_TAG, 7, "Going to show the document");
      byte[] documentArray = Base64.decode(document.getContent());
      request.setAttribute(CONTENT_REQUEST_NAME, documentArray);
      request.setAttribute(MIMETYPE_REQUEST_NAME, document.getMimeType());

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

  public void showCurrentDocument_xa(GrndsExchangeContext context) {
    // Do performance tracing
    PerformanceTrace performanceTrace = new PerformanceTrace("DocumentUtilityConversation", "showCurrentDocument_xa");
    performanceTrace.enterScope();

    // Create local variables
    DocumentMetaData documentMetaData;
    HttpServletRequest request = context.getRequest();

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
      documentMetaData.setRenderFormat(RenderType.HTML_WITHOUT_SHELL);
    }
    catch (Exception e) {
      processSevereException(context, e);
    }

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
      GrndsTrace.msg(TRACE_TAG, 7, "Going to show the document");
      byte[] documentArray = Base64.decode(document.getContent());
      request.setAttribute(CONTENT_REQUEST_NAME, documentArray);
      request.setAttribute(MIMETYPE_REQUEST_NAME, document.getMimeType());

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

  public void getNewDocument_xa(GrndsExchangeContext context) {
    // Do performance tracing
    PerformanceTrace performanceTrace = new PerformanceTrace("DocumentUtilityConversation", "getNewDocument_xa");
    performanceTrace.enterScope();

    // Create local variables
    DocumentMetaData documentMetaData;
    HttpServletRequest request = context.getRequest();

    String docType;
    String preFillData = null;
    String docMetaDataString;

    // Place each of the request parameter into attributes
    DocumentUtilityHelpers.changeParameterstoAttributes(request);

    docType = request.getParameter("docType");
    docMetaDataString = DocumentLookup.lookup(docType);

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

    // Fill in the rest of the documentMetaData from the request
    try {
      documentMetaData = DocumentUtilityHelpers.completeDocumentMetaData(documentSave, request, documentMetaData,
                                                                         false);
      documentMetaData.setRenderFormat(RenderType.HTML_WITH_SHELL);
      documentMetaData.setIsInApproverMode(true);
      documentMetaData.setValidEventStatus(null);
      //if( context.getRequest().getParameter( "tableName" ) != null )
      //{
      //  documentMetaData.getTableMetaData().setTableName( context.getRequest().getParameter( "tableName" ) );
      //}
    }
    catch (Exception e) {
      processSevereException(context, e);
    }

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

      DocumentServices_Impl documentServices_Impl = new DocumentServices_Impl();
      DocumentServicesSoap documentServicesSoap = documentServices_Impl.getDocumentServicesSoap();

      //BindingInfo bInfo = (BindingInfo)
      //        ((DocumentServicesSoap_Stub) documentServicesSoap)._getProperty("weblogic.webservice.bindinginfo");
      //bInfo.setTimeout(DocumentServicesHandler.COMPOSITE_DOCUMENT_TIMEOUT);

      Document document;
      ((DocumentServicesSoap_Stub) documentServicesSoap)._setProperty(javax.xml.rpc.Stub.ENDPOINT_ADDRESS_PROPERTY,
                                                                      DocumentServicesHandler.DOCUMENT_SERVICES_URL);
      GrndsTrace.msg(TRACE_TAG, 7, "Using Url:" + DocumentServicesHandler.DOCUMENT_SERVICES_URL);
      String encodedMetaData = Base64.encode(docMetaDataString.getBytes(ArchitectureConstants.CHARACTER_ENCODING));
      if (preFillData == null) {
        preFillData = "";
      } else {
        preFillData = Base64.encode(preFillData.getBytes(ArchitectureConstants.CHARACTER_ENCODING));
      }

      document = documentServicesSoap.getBlankDocument(encodedMetaData, preFillData);

      // Put document into the request
      GrndsTrace.msg(TRACE_TAG, 7, "Going to show the document");
      byte[] documentArray = Base64.decode(document.getContent());
      request.setAttribute(CONTENT_REQUEST_NAME, documentArray);
      request.setAttribute(MIMETYPE_REQUEST_NAME, document.getMimeType());

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

  public void getNewDocumentUsingBlankTemplate_xa(GrndsExchangeContext context) {
    // Do performance tracing
    PerformanceTrace performanceTrace = new PerformanceTrace("DocumentUtilityConversation",
                                                             "getNewDocumentUsingBlankTemplate_xa");
    performanceTrace.enterScope();

    // Create local variables
    DocumentMetaData documentMetaData;
    HttpServletRequest request = context.getRequest();

    //String preFillData = null;

    String docMetaDataString;

    // Place each of the request parameter into attributes
    DocumentUtilityHelpers.changeParameterstoAttributes(request);

    // Get the specific document type requested and lookup in JNDI

    String docType = request.getParameter("docType");
    docMetaDataString = DocumentLookup.lookup(docType);

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
      if (context.getRequest().getParameter("tableName") != null) {
        documentMetaData.getTableMetaData().setTableName(context.getRequest().getParameter("tableName"));
      }
      documentMetaData = DocumentUtilityHelpers.completeDocumentMetaData(documentSave, request, documentMetaData,
                                                                         false);
      documentMetaData.setRenderFormat(RenderType.HTML_WITH_SHELL);
      documentMetaData.setIsInApproverMode(true);
      documentMetaData.setValidEventStatus(null);
      documentMetaData.setDocumentExists(true);
    }
    catch (Exception e) {
      processSevereException(context, e);
    }

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

      DocumentServices_Impl documentServices_Impl = new DocumentServices_Impl();
      DocumentServicesSoap documentServicesSoap = documentServices_Impl.getDocumentServicesSoap();

      //BindingInfo bInfo = (BindingInfo)
      //        ((DocumentServicesSoap_Stub) documentServicesSoap)._getProperty("weblogic.webservice.bindinginfo");
      //bInfo.setTimeout(240);

      Document document;
      ((DocumentServicesSoap_Stub) documentServicesSoap)._setProperty(javax.xml.rpc.Stub.ENDPOINT_ADDRESS_PROPERTY,
                                                                      DocumentServicesHandler.DOCUMENT_SERVICES_URL);
      GrndsTrace.msg(TRACE_TAG, 7, "Using Url:" + DocumentServicesHandler.DOCUMENT_SERVICES_URL);
      String encodedMetaData = Base64.encode(docMetaDataString.getBytes(ArchitectureConstants.CHARACTER_ENCODING));
      document = documentServicesSoap.getBlankDocument(encodedMetaData, "");

      // Put document into the request
      GrndsTrace.msg(TRACE_TAG, 7, "Going to show the document");
      byte[] documentArray = Base64.decode(document.getContent());
      request.setAttribute(CONTENT_REQUEST_NAME, documentArray);
      request.setAttribute(MIMETYPE_REQUEST_NAME, document.getMimeType());

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

}