package gov.georgia.dhr.dfcs.sacwis.web.document;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.BasePrsException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.ReferenceDataException;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.structs.document.Documents;
import gov.georgia.dhr.dfcs.sacwis.web.core.initialize.Destroyable;
import gov.georgia.dhr.dfcs.sacwis.web.core.initialize.Initializable;

import java.io.InputStream;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;

import org.grnds.facility.config.GrndsConfiguration;
import org.grnds.facility.log.GrndsTrace;

import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;
import org.xml.sax.InputSource;

public class DocumentsInit implements Initializable, Destroyable {

  private static final String DOCUMENT_META_DATA_PATH =
          GrndsConfiguration.getInstance().getProperty(ArchitectureConstants.GRNDS_DOMAIN, "MetaDataPath");
  private static final String TRACE_TAG = "DocumentsInit";

  public void initialize(ServletContext servletContext) throws BasePrsException {
    PerformanceTrace performanceTrace = new PerformanceTrace("DocumentsInit", "initialize");
    performanceTrace.enterScope();
    GrndsTrace.enterScope(TRACE_TAG + ".initialize");

    String path = DOCUMENT_META_DATA_PATH;
    GrndsTrace.msg(TRACE_TAG, 7, "Path for xml file is:" + path);
    //InputStream inStream = this.getClass().getResourceAsStream( path );
    InputStream inStream = servletContext.getResourceAsStream(path);
    Documents documents;

    if (inStream == null) {
      GrndsTrace.msg(TRACE_TAG, 7, "Couldn't find DocumentsMetaData.xml");
    }

    try {
      InputSource is = new InputSource();
      is.setByteStream(inStream);
      documents = (Documents) Unmarshaller.unmarshal(Documents.class, is);
      DocumentLookup.setMetaData(marshallDocuments(documents));
    } catch (MarshalException me) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception in marshalling:" + me.getMessage());
      throw new ReferenceDataException("Exception in marshalling document metadata.", me,
                                       BasePrsException.CRITICAL_PRIORITY);
    } catch (ValidationException ve) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception in Validation:" + ve.getMessage());
      throw new ReferenceDataException("Exception in validating document metadata.", ve,
                                       BasePrsException.CRITICAL_PRIORITY);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Unknown exception in castor:" + e.getMessage());
      throw new ReferenceDataException("Exception initializing document metadata.", e,
                                       BasePrsException.CRITICAL_PRIORITY);
    }
    GrndsTrace.exitScope();
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  private Map<String, String> marshallDocuments(Documents documents) {
    //Loop through each document and marshall the documentMetaData to Xml
    Map<String, String> typeDocMap = new HashMap<String, String>(documents.getDocumentMetaData().length);
    for (int x = 0; x < (documents.getDocumentMetaData().length); x++) {
      String documentType = documents.getDocumentMetaData(x).getDocumentType();
      String docMetaData;
      StringWriter sw = new StringWriter();
      try {
        Marshaller.marshal(documents.getDocumentMetaData(x), sw);
      } catch (MarshalException me) {
        GrndsTrace.msg(TRACE_TAG, 7, "Exception in marshalling:" + me.getMessage());
      } catch (ValidationException ve) {
        GrndsTrace.msg(TRACE_TAG, 7, "Exception in Validation:" + ve.getMessage());
      } catch (Exception e) {
        GrndsTrace.msg(TRACE_TAG, 7, "Unknown exception in castor, marshalling DocumentMetaData:" + e.getMessage());
      }
      docMetaData = sw.toString();
      GrndsTrace.msg(TRACE_TAG, 7, "JNDI Document Type:" + documentType.toUpperCase());
      typeDocMap.put(documentType.toUpperCase(), docMetaData);
    }
    return typeDocMap;
  }

  public void destroy(ServletContext config) throws BasePrsException {
    DocumentLookup.setMetaData(null);
  }
}