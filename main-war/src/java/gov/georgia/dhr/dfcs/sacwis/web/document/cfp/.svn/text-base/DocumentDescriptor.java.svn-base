package gov.georgia.dhr.dfcs.sacwis.web.document.cfp;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;

import gov.georgia.dhr.dfcs.sacwis.structs.document.DocumentMetaData;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.ValidationException;

/**
 * Encapsulates information about a form/report which gets added to the xml job descriptor sent to the .Net CFP
 * service.
 */
public class DocumentDescriptor implements Serializable {
  protected boolean isReport = false;
  protected String documentName = null;
  protected String documentCategory = null;
  protected int documentId = 0;
  protected int cfpStamp = 0;
  protected int sequenceNumber = 0;

  protected DocumentMetaData documentMetaData = null;
  protected String preFillMetaData = null;

  /** Constructor called by GenerateForm */
  public DocumentDescriptor(DocumentMetaData documentMetaData,
                            String preFillMetaData) {
    this.documentMetaData = documentMetaData;
    this.preFillMetaData = preFillMetaData;

    this.isReport = false;
    this.documentName = documentMetaData.getDocumentDisplayName();
    this.documentCategory = documentMetaData.getDocumentCategory().toString();
  }

  /** Constructor called by GenerateReport */
  public DocumentDescriptor(String documentName, int cfpStamp) {
    this.documentName = documentName;
    this.cfpStamp = cfpStamp;

    this.isReport = true;
    this.documentCategory = "REPORT";
  }

  /** Returns the xml describing the request for a document */
  public String toXmlString() throws IOException, MarshalException, ValidationException {
    if (isReport) {
      return "<document sequence=\"" + sequenceNumber + "\" " +
             "name=\"" + documentName + "\" " +
             "class=\"" + documentCategory + "\" " +
             "id=\"" + documentId + "\" />";
    }
    StringWriter stringWriter = new StringWriter();
    //noinspection IOResourceOpenedButNotSafelyClosed
    PrintWriter printWriter = new PrintWriter(stringWriter);

    printWriter.println("<document sequence=\"" + sequenceNumber + "\" " +
                        "name=\"" + documentName + "\" " +
                        "class=\"" + documentCategory + "\" " +
                        "id=\"\">");

    Marshaller marshaller = new Marshaller(printWriter);
    marshaller.setMarshalAsDocument(false);
    marshaller.marshal(documentMetaData);
    if (preFillMetaData != null) {
      printWriter.println(preFillMetaData);
    }

    printWriter.flush();
    printWriter.println("</document>");

    return stringWriter.toString();
  }

  /** Set sequence number for cfp job descriptor */
  public void setSequenceNumber(int sequenceNumber) {
    this.sequenceNumber = sequenceNumber;
  }

  /** Only valid for Report DocumentDescriptors */
  public boolean isReport() {
    return isReport;
  }

  /** Only valid for Report DocumentDescriptors */
  public void setDocumentId(int documentId) {
    this.documentId = documentId;
  }

  /** Only valid for Report DocumentDescriptors */
  public int getCfpStamp() {
    return cfpStamp;
  }
}
