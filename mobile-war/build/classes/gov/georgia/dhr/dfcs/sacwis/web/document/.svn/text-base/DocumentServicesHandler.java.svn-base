package gov.georgia.dhr.dfcs.sacwis.web.document;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.Base64;
import gov.georgia.dhr.dfcs.sacwis.structs.document.DocumentMetaData;
import gov.georgia.dhr.dfcs.sacwis.structs.document.types.CategoryType;
import gov.georgia.dhr.dfcs.sacwis.ws.document.Document;
import gov.georgia.dhr.dfcs.sacwis.ws.document.DocumentServicesSoap;
import gov.georgia.dhr.dfcs.sacwis.ws.document.DocumentServicesSoap_Stub;
import gov.georgia.dhr.dfcs.sacwis.ws.document.DocumentServices_Impl;
import gov.georgia.dhr.dfcs.sacwis.ws.spellcheck.SpellCheckingServicesSoap;
import gov.georgia.dhr.dfcs.sacwis.ws.spellcheck.SpellCheckingServicesSoap_Stub;
import gov.georgia.dhr.dfcs.sacwis.ws.spellcheck.SpellCheckingServices_Impl;
import gov.georgia.dhr.dfcs.sacwis.ws.spellcheck.ArrayOfString;

import java.io.IOException;

import javax.xml.rpc.soap.SOAPFaultException;

import org.grnds.facility.config.GrndsConfiguration;
import org.grnds.facility.log.GrndsTrace;

public class DocumentServicesHandler {
  public static Document showDocument(DocumentMetaData documentMetaData, String docMetaDataString, String preFillData)
          throws SOAPFaultException, IOException {
    PerformanceTrace performanceTrace = new PerformanceTrace("DocumentServicesHandler", "showDocument");
    performanceTrace.enterScope();
    GrndsTrace.msg(TRACE_TAG, 7, "Document Meta Data:" + docMetaDataString);
    GrndsTrace.msg(TRACE_TAG, 7, "Prefill Data:" + preFillData);

    String encodedMetaData = Base64.encode(docMetaDataString.getBytes(ArchitectureConstants.CHARACTER_ENCODING));
    String encodedPreFill;
    int timeOut = 10;

    //Get the timeout
    if (documentMetaData.getDocumentCategory().getType() == CategoryType.NARRATIVE_DOCUMENT.getType()) {
      timeOut = NARRATIVE_TIMEOUT;
    } else if (documentMetaData.getDocumentCategory().getType() == CategoryType.SIMPLE_DOCUMENT.getType()) {
      timeOut = SIMPLE_DOCUMENT_TIMEOUT;
    } else if (documentMetaData.getDocumentCategory().getType() == CategoryType.COMPOSITE_DOCUMENT.getType()) {
      timeOut = COMPOSITE_DOCUMENT_TIMEOUT;
    }
    if (preFillData != null) {
      encodedPreFill = Base64.encode(preFillData.getBytes(ArchitectureConstants.CHARACTER_ENCODING));
    } else {
      encodedPreFill = "";
    }

    DocumentServices_Impl documentServices_Impl = new DocumentServices_Impl();
    DocumentServicesSoap documentServicesSoap = documentServices_Impl.getDocumentServicesSoap();

    // TODO: Readd timeout???
    //BindingInfo bInfo = (BindingInfo)
    //        ((DocumentServicesSoap_Stub) documentServicesSoap)._getProperty("weblogic.webservice.bindinginfo");
    //
    //GrndsTrace.msg(TRACE_TAG, 7, "Value of default timeout:" + String.valueOf(bInfo.getTimeout()));
    //
    //bInfo.setTimeout(timeOut);
    //GrndsTrace.msg(TRACE_TAG, 7, "Value of timeout:" + String.valueOf(bInfo.getTimeout()));

    Document document;
    ((DocumentServicesSoap_Stub) documentServicesSoap)._setProperty(javax.xml.rpc.Stub.ENDPOINT_ADDRESS_PROPERTY,
                                                                    DOCUMENT_SERVICES_URL);
    GrndsTrace.msg(TRACE_TAG, 7, "Using Url:" + DOCUMENT_SERVICES_URL);
    GrndsTrace.msg(TRACE_TAG, 7, "Value of doc exists:" + documentMetaData.getDocumentExists());

    performanceTrace.getElapsedTime();
    if (documentMetaData.getDocumentExists() != false) {
      GrndsTrace.msg(TRACE_TAG, 7, "Calling getForm");
      document = documentServicesSoap.getDocument(encodedMetaData, encodedPreFill);
    } else {
      GrndsTrace.msg(TRACE_TAG, 7, "Calling getBlankForm");
      document = documentServicesSoap.getBlankDocument(encodedMetaData, encodedPreFill);
    }
    performanceTrace.getElapsedTime();

    // Get the mime type
    //String mimeType = document.getMimeType();

    // Get the document
    // byte[] documentArray = Base64.decode( document.getContent() );
    // request.setAttribute( "document", documentArray );
    // request.setAttribute( "mimeType", mimeType );
    // performanceTrace.exitScope();

    return document;
  }

  public static Document reconstructDocument(DocumentMetaData documentMetaData, String docMetaDataString,
                                             String preFillData)
          throws SOAPFaultException, IOException {
    GrndsTrace.enterScope(TRACE_TAG + ".reconstructDocument");
    GrndsTrace.msg(TRACE_TAG, 7, "Document Meta Data:" + docMetaDataString);
    GrndsTrace.msg(TRACE_TAG, 7, "Prefill Data:" + preFillData);

    int timeOut = 10;

    //Get the timeout
    if (documentMetaData.getDocumentCategory().getType() == CategoryType.NARRATIVE_DOCUMENT.getType()) {
      timeOut = NARRATIVE_TIMEOUT;
    } else if (documentMetaData.getDocumentCategory().getType() == CategoryType.SIMPLE_DOCUMENT.getType()) {
      timeOut = SIMPLE_DOCUMENT_TIMEOUT;
    } else if (documentMetaData.getDocumentCategory().getType() == CategoryType.COMPOSITE_DOCUMENT.getType()) {
      timeOut = COMPOSITE_DOCUMENT_TIMEOUT;
    }

    String encodedMetaData = Base64.encode(docMetaDataString.getBytes(ArchitectureConstants.CHARACTER_ENCODING));
    String encodedPreFill;
    if (preFillData != null) {
      encodedPreFill = Base64.encode(preFillData.getBytes(ArchitectureConstants.CHARACTER_ENCODING));
    } else {
      encodedPreFill = "";
    }

    DocumentServices_Impl documentServices_Impl = new DocumentServices_Impl();
    DocumentServicesSoap documentServicesSoap = documentServices_Impl.getDocumentServicesSoap();

    // TODO: Readd timeout???
    //BindingInfo bInfo = (BindingInfo)
    //        ((DocumentServicesSoap_Stub) documentServicesSoap)._getProperty("weblogic.webservice.bindinginfo");
    //
    //GrndsTrace.msg(TRACE_TAG, 7, "Value of default timeout:" + String.valueOf(bInfo.getTimeout()));
    //
    //bInfo.setTimeout(timeOut);
    //GrndsTrace.msg(TRACE_TAG, 7, "Value of timeout:" + String.valueOf(bInfo.getTimeout()));

    ((DocumentServicesSoap_Stub) documentServicesSoap)._setProperty(javax.xml.rpc.Stub.ENDPOINT_ADDRESS_PROPERTY,
                                                                    DOCUMENT_SERVICES_URL);
    GrndsTrace.msg(TRACE_TAG, 7, "Using Url:" + DOCUMENT_SERVICES_URL);

    Document document = documentServicesSoap.reconstructDocument(encodedMetaData, encodedPreFill);
    GrndsTrace.exitScope();
    return document;

  }

  public static Document previewDocument(DocumentMetaData documentMetaData, String docMetaDataString,
                                         String xmlMergeData)
          throws SOAPFaultException, IOException {
    PerformanceTrace performanceTrace = new PerformanceTrace("DocumentServicesHandler", "previewDocument");
    performanceTrace.enterScope();

    int timeOut = 10;

    //Get the timeout
    if (documentMetaData.getDocumentCategory().getType() == CategoryType.NARRATIVE_DOCUMENT.getType()) {
      timeOut = NARRATIVE_TIMEOUT;
    } else if (documentMetaData.getDocumentCategory().getType() == CategoryType.SIMPLE_DOCUMENT.getType()) {
      timeOut = SIMPLE_DOCUMENT_TIMEOUT;
    } else if (documentMetaData.getDocumentCategory().getType() == CategoryType.COMPOSITE_DOCUMENT.getType()) {
      timeOut = COMPOSITE_DOCUMENT_TIMEOUT;
    }

    GrndsTrace.msg(TRACE_TAG, 7, "Document Meta Data:" + docMetaDataString);
    GrndsTrace.msg(TRACE_TAG, 7, "Prefill Data:" + xmlMergeData);

    String encodedMetaData = Base64.encode(docMetaDataString.getBytes(ArchitectureConstants.CHARACTER_ENCODING));
    //String encodedMergeData = null;
    if (xmlMergeData != null) {
      xmlMergeData = Base64.encode(xmlMergeData.getBytes(ArchitectureConstants.CHARACTER_ENCODING));
    } else {
      xmlMergeData = "";
    }

    DocumentServices_Impl documentServices_Impl = new DocumentServices_Impl();
    DocumentServicesSoap documentServicesSoap = documentServices_Impl.getDocumentServicesSoap();

    // TODO: Readd timeout???
    //BindingInfo bInfo = (BindingInfo)
    //        ((DocumentServicesSoap_Stub) documentServicesSoap)._getProperty("weblogic.webservice.bindinginfo");
    //
    //GrndsTrace.msg(TRACE_TAG, 7, "Value of default timeout:" + String.valueOf(bInfo.getTimeout()));
    //
    //bInfo.setTimeout(timeOut);
    //GrndsTrace.msg(TRACE_TAG, 7, "Value of timeout:" + String.valueOf(bInfo.getTimeout()));

    ((DocumentServicesSoap_Stub) documentServicesSoap)._setProperty(javax.xml.rpc.Stub.ENDPOINT_ADDRESS_PROPERTY,
                                                                    DOCUMENT_SERVICES_URL);
    GrndsTrace.msg(TRACE_TAG, 7, "Using Url:" + DOCUMENT_SERVICES_URL);

    performanceTrace.getElapsedTime();
    Document document = documentServicesSoap.previewDocument(encodedMetaData, xmlMergeData);
    performanceTrace.getElapsedTime();
    performanceTrace.exitScope();
    // Get the document
    return document;
  }

  public static String checkSpelling(String[] names, String[] values)
          throws SOAPFaultException, IOException {
    GrndsTrace.enterScope(TRACE_TAG + ".checkSpelling");

    SpellCheckingServices_Impl spellCheckImpl = new SpellCheckingServices_Impl();
    SpellCheckingServicesSoap spellChecker = spellCheckImpl.getSpellCheckingServicesSoap();

    // TODO: Readd timeout???
    //BindingInfo bInfo = (BindingInfo)
    //        ((SpellCheckingServicesSoap_Stub) spellChecker)._getProperty("weblogic.webservice.bindinginfo");
    //bInfo.setCharset(ArchitectureConstants.CHARACTER_ENCODING);
    //
    //GrndsTrace.msg(TRACE_TAG, 7, "Value of default timeout:" + String.valueOf(bInfo.getTimeout()));
    //
    //bInfo.setTimeout(SPELLCHECK_TIMEOUT);

    ((SpellCheckingServicesSoap_Stub) spellChecker)._setProperty(javax.xml.rpc.Stub.ENDPOINT_ADDRESS_PROPERTY,
                                                                 SPELLCHECK_SERVICES_URL);
    GrndsTrace.exitScope(TRACE_TAG + ".checkSpelling_xa");
    ArrayOfString fieldNames = new ArrayOfString( names );
    ArrayOfString fieldValues = new ArrayOfString ( values );

    return spellChecker.getCorrectionsUI(fieldNames, fieldValues);
  }

  public static final String DOCUMENT_SERVICES_URL
          = GrndsConfiguration.getInstance().getProperty(ArchitectureConstants.GRNDS_DOMAIN, "DocumentServicesUrl");
  public static final int NARRATIVE_TIMEOUT
          = Integer.parseInt(GrndsConfiguration.getInstance().getProperty(ArchitectureConstants.GRNDS_DOMAIN,
                                                                          "NarrativeTimeout"));
  public static final int SIMPLE_DOCUMENT_TIMEOUT
          = Integer.parseInt(GrndsConfiguration.getInstance().getProperty(ArchitectureConstants.GRNDS_DOMAIN,
                                                                          "SimpleDocumentTimeout"));
  public static final int COMPOSITE_DOCUMENT_TIMEOUT
          = Integer.parseInt(GrndsConfiguration.getInstance().getProperty(ArchitectureConstants.GRNDS_DOMAIN,
                                                                          "CompositeDocumentTimeout"));
  public static final int SPELLCHECK_TIMEOUT
          = Integer.parseInt(GrndsConfiguration.getInstance().getProperty(ArchitectureConstants.GRNDS_DOMAIN,
                                                                          "SpellCheckTimeout"));
  public static final String SPELLCHECK_SERVICES_URL
          = GrndsConfiguration.getInstance().getProperty(ArchitectureConstants.GRNDS_DOMAIN, "SpellCheckServicesUrl");
  public static final String CASEFILE_SERVICES_URL
          = GrndsConfiguration.getInstance().getProperty(ArchitectureConstants.GRNDS_DOMAIN, "CaseFileServicesUrl");
  private static final String TRACE_TAG = "DocumentServicesHandler";
}