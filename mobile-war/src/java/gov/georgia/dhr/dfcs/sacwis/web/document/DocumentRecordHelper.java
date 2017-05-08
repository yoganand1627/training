package gov.georgia.dhr.dfcs.sacwis.web.document;

// -- java classes --

import java.io.IOException;
import java.io.StringReader;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.log.GrndsTrace;

import gov.georgia.dhr.dfcs.sacwis.core.base.DuplicateRecordException;
import gov.georgia.dhr.dfcs.sacwis.core.base.NoDataReturnedException;
import gov.georgia.dhr.dfcs.sacwis.core.base.NoRowsUpdatedException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.TooManyRowsReturnedException;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.dao.document.DocumentStageClosedException;
import gov.georgia.dhr.dfcs.sacwis.dao.document.DocumentStageNotFoundException;
import gov.georgia.dhr.dfcs.sacwis.dao.document.InvalidDocumentStatusException;
import gov.georgia.dhr.dfcs.sacwis.dao.document.NewUsingDocumentValueBean;
import gov.georgia.dhr.dfcs.sacwis.service.document.DocumentSave;
import gov.georgia.dhr.dfcs.sacwis.structs.document.Column;
import gov.georgia.dhr.dfcs.sacwis.structs.document.DocumentMetaData;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;

/**
 * <p>Title: </p> <p>Description: </p> <p>Copyright: Copyright (c) 2002</p> <p>Company: </p>
 *
 * @author unascribed
 * @version 1.0
 */

public class DocumentRecordHelper {

  public static NewUsingDocumentValueBean newUseDocumentRecord(DocumentSave documentSave, HttpServletRequest request)
          throws NoDataReturnedException, MarshalException, ValidationException, TooManyRowsReturnedException,
                 IOException, SQLException {

    // Do performance tracing
    PerformanceTrace performanceTrace = new PerformanceTrace("DocumentRecordHelper", "newUseDocumentRecord");
    performanceTrace.enterScope();
    GrndsTrace.enterScope(TRACE_TAG + ".newUseDocumentRecord");

    DocumentMetaData newUsingDocumentMetaData;
    NewUsingDocumentValueBean newUsingDocumentValueBean;
    DocumentUtilityHelpers.changeParameterstoAttributes(request);

    // Get the specific document type requested and lookup in JNDI
    GrndsTrace.msg(TRACE_TAG, 7, "Looking up DocumentMetaData");
    String docType = (String) request.getAttribute("docType");
    docType = docType.trim();
    String docMetaData = DocumentLookup.lookup(docType.toUpperCase());
    if (docMetaData == null) {
      throw new IllegalArgumentException("Document Type not found in the JNDI");
    }
    GrndsTrace.msg(TRACE_TAG, 7, "Found DocumentMetaData");
    StringReader sr = new StringReader(docMetaData);

    // Unmarshall the Xml String into the DocumentMetaData object
    newUsingDocumentMetaData = (DocumentMetaData) Unmarshaller.unmarshal(DocumentMetaData.class, sr);

    // Get the 'New Using' documentMetaData
    newUsingDocumentMetaData = DocumentUtilityHelpers.completeNewUsingDocumentMetaData(request,
                                                                                       newUsingDocumentMetaData);

    // Get the document and template
    newUsingDocumentValueBean = documentSave.selectDocumentBlob(newUsingDocumentMetaData);

    performanceTrace.exitScope();
    GrndsTrace.exitScope();

    return newUsingDocumentValueBean;

  }

  public static String saveNewUseDocumentRecord(DocumentSave documentSave, HttpServletRequest request,
                                                NewUsingDocumentValueBean newUsingDocumentValueBean)
          throws MarshalException, ValidationException, TooManyRowsReturnedException, DocumentStageClosedException,
                 NoRowsUpdatedException, DuplicateRecordException, DocumentStageNotFoundException, SQLException,
                 ParseException, RemoteException, NoDataReturnedException, InvalidDocumentStatusException {
    PerformanceTrace performanceTrace = new PerformanceTrace("DocumentRecordHelper", "newUseDocumentRecord");
    performanceTrace.enterScope();
    GrndsTrace.enterScope(TRACE_TAG + ".saveNewUseDocumentRecord");

    String timeStamp = null;
    DocumentMetaData documentMetaData;

    DocumentUtilityHelpers.changeParameterstoAttributes(request);

    // Get the specific document type requested and lookup in JNDI
    // Get the specific document type requested and lookup in JNDI
    GrndsTrace.msg(TRACE_TAG, 7, "Looking up DocumentMetaData");
    String docType = (String) request.getAttribute("docType");
    docType = docType.trim();
    String docMetaData = DocumentLookup.lookup(docType.toUpperCase());
    if (docMetaData == null) {
      throw new IllegalArgumentException("Document Type not found in the JNDI");
    }
    GrndsTrace.msg(TRACE_TAG, 7, "Found DocumentMetaData");
    StringReader sr = new StringReader(docMetaData);

    // Unmarshall the Xml String into the DocumentMetaData object
    documentMetaData = (DocumentMetaData) Unmarshaller.unmarshal(DocumentMetaData.class, sr);

    // Get the 'New Using' documentMetaData
    documentMetaData = DocumentUtilityHelpers.completeDocumentMetaData(documentSave, request, documentMetaData);

    if (newUsingDocumentValueBean.getTemplateId() != null) {
      documentMetaData.setActualTemplateVersion(newUsingDocumentValueBean.getTemplateId());
      documentMetaData.setLegacy(false);
    } else {
      documentMetaData.setLegacy(true);
    }

    // Get the document and template
    documentMetaData = documentSave.saveDocument(documentMetaData, newUsingDocumentValueBean.getDocumentData());

    // Return the timestamp
    for (int x = 0; x < documentMetaData.getTableMetaData().getTableFields().getColumnCount(); x++) {
      Column column = documentMetaData.getTableMetaData().getTableFields().getColumn(x);
      if ("DT_LAST_UPDATE".equals(column.getName().toUpperCase())) {
        timeStamp = column.getContent();
      }
    }

    performanceTrace.exitScope();
    GrndsTrace.exitScope();

    return timeStamp;
  }

  private static final String TRACE_TAG = "DocumentRecordHelper";
}