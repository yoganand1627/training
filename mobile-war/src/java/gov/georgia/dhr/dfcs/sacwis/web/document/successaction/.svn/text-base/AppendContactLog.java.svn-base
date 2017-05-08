package gov.georgia.dhr.dfcs.sacwis.web.document.successaction;

import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;

import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.log.GrndsTrace;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.BasePrsException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.InformationalPrsException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.Base64;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.document.DocumentMetaData;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSVC06SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSVC06SO;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.document.DocumentLookup;
import gov.georgia.dhr.dfcs.sacwis.web.document.DocumentPresentation;
import gov.georgia.dhr.dfcs.sacwis.web.document.DocumentServicesHandler;
import gov.georgia.dhr.dfcs.sacwis.ws.document.Document;
import gov.georgia.dhr.dfcs.sacwis.ws.document.DocumentServicesSoap;
import gov.georgia.dhr.dfcs.sacwis.ws.document.DocumentServicesSoap_Stub;
import gov.georgia.dhr.dfcs.sacwis.ws.document.DocumentServices_Impl;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * <p>Title: </p> <p>Description: </p> <p>Copyright: Copyright (c) 2002</p> <p>Company: </p>
 *
 * @author unascribed
 * @version 1.0
 */

public class AppendContactLog extends DocumentSuccessAction {
  public void execute(HttpServletRequest request) throws Exception {
    PerformanceTrace performanceTrace = new PerformanceTrace("DocumentUtilityHelpers", "completeDocumentMetaData");
    performanceTrace.enterScope();

    CSVC06SI csvc06si = new CSVC06SI();
    CSVC06SO csvc06so;

    ArchInputStruct archInputStruct = new ArchInputStruct();
    String userId;
    String pStage;

    if (UserProfileHelper.getUserProfile(request) != null) {
      userId = UserProfileHelper.getUserProfile(request).getUserLogonID();
    } else {
      userId = "DOCARCH";
    }

    archInputStruct.setSzUserId(userId);
    archInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_SEARCH);
    archInputStruct.setBPerfInd("Y");
    archInputStruct.setBDataAcsInd("N");
    archInputStruct.setUsPageNbr(0);
    csvc06si.setArchInputStruct(archInputStruct);

    if (request.getParameter("pStage") != null) {
      pStage = String.valueOf(request.getParameter("pStage"));
    } else {
      //Get from global data
      pStage = GlobalData.getUlIdStageAsString(request);
    }
    csvc06si.setUlIdStage(Integer.parseInt(pStage));
    csvc06si.setDtDtSampleTo(DateHelper.getTodayCastorDate());

    GrndsTrace.msg(TRACE_TAG, 7, "Calling the Contact Log Tuxedo Service");
    try {
      csvc06so = (CSVC06SO) WtcHelper.callService("CSVC06S", csvc06si, CSVC06SO.class);
    }
    catch (ServiceException we) {
      //Put the message for the exception
      if (we.getErrorCode() != Messages.MSG_NO_ROWS_RETURNED) {
        we.setPresentationMessage(we.getErrorMessage());
        throw we;
      } else {
        //Don't append the contact log and just show the document.
        return;
      }
    }

    //Get the metadata
    GrndsTrace.msg(TRACE_TAG, 7, "Looking up the metaData in the JNDI");
    String docMetaDataString = DocumentLookup.lookup("CFSD0700");

    if (docMetaDataString == null) {
      String errorMessage = MessageLookup.getMessageByNumber(Messages.ARC_DOCS_JNDI_LOOKUP_FAILED);
      InformationalPrsException ipe = new InformationalPrsException(errorMessage, BasePrsException.CRITICAL_PRIORITY);
      ipe.setPresentationMessage(errorMessage);
      throw ipe;
    }
    GrndsTrace.msg(TRACE_TAG, 7, "Value of metaData:" + docMetaDataString);
    GrndsTrace.msg(TRACE_TAG, 7, "Value of preFill:" + csvc06so.getPreFillData().toString());

    //Get the prefill data w/out xml declaration
    StringWriter stringWriter = new StringWriter();
    PrintWriter printWriter = new PrintWriter(stringWriter);
    Marshaller marshaller = new Marshaller(printWriter);
    marshaller.setMarshalAsDocument(false);
    marshaller.marshal(csvc06so.getPreFillData());
    printWriter.flush();
    String preFillData = stringWriter.toString();
    stringWriter.flush();

    //Get metadata w/out xml declaration
    StringReader stringReader = new StringReader(docMetaDataString);
    DocumentMetaData documentMetaData
            = (DocumentMetaData) Unmarshaller.unmarshal(DocumentMetaData.class, stringReader);
    marshaller.marshal(documentMetaData);
    printWriter.flush();
    docMetaDataString = stringWriter.toString();
    stringWriter.flush();

    StringBuffer xmlDocument = new StringBuffer(ArchitectureConstants.XML_HEADER);
    xmlDocument.append("<documents><document>");
    xmlDocument.append(docMetaDataString);
    xmlDocument.append(preFillData);
    xmlDocument.append("</document></documents>");
    GrndsTrace.msg(TRACE_TAG, 7, "Value of xmlDoc:" + xmlDocument.toString());

    DocumentServices_Impl documentServices_Impl = new DocumentServices_Impl();
    DocumentServicesSoap documentServicesSoap = documentServices_Impl.getDocumentServicesSoap();
    ((DocumentServicesSoap_Stub) documentServicesSoap)._setProperty(javax.xml.rpc.Stub.ENDPOINT_ADDRESS_PROPERTY,
                                                                    DocumentServicesHandler.DOCUMENT_SERVICES_URL);

    //Get the current document structure out of the request
    Document primaryDocument = (Document) request.getAttribute("documentStruct");
    byte[] bytes = xmlDocument.toString().getBytes(ArchitectureConstants.CHARACTER_ENCODING);
    Document completedDocument
            = documentServicesSoap.appendDocuments(primaryDocument, Base64.encode(bytes));

    byte[] documentArray = Base64.decode(completedDocument.getContent());
    // MKW: Commented out because the creation of a string with encoding is expensive
    //String test = new String( documentArray, ArchitectureConstants.CHARACTER_ENCODING );
    //GrndsTrace.msg( TRACE_TAG, 7, "Value of appended doc:" + test );
    request.setAttribute(DocumentPresentation.CONTENT_REQUEST_NAME, documentArray);
    request.setAttribute(DocumentPresentation.MIMETYPE_REQUEST_NAME, completedDocument.getMimeType());

    performanceTrace.exitScope();
  }

  private static final String TRACE_TAG = "AppendContactLog";
}