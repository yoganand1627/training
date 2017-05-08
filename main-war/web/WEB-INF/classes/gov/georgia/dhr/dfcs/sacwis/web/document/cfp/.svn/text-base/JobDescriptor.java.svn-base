package gov.georgia.dhr.dfcs.sacwis.web.document.cfp;

import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.rmi.RemoteException;

import gov.georgia.dhr.dfcs.sacwis.dao.document.cfp.CfpStatusDB;
import gov.georgia.dhr.dfcs.sacwis.service.document.Cfp;
import org.apache.commons.lang.StringEscapeUtils;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.ValidationException;

/**
 * JobDescriptor encapsulates the message sent to the .Net service which kicks off the CFP.
 * <p/>
 * Each call to GenerateForm and GenerateReport gets passed the JobDescriptor.  They add their documentDescriptor to the
 * JobDescriptor. JobDescriptor also provides unique cfp stamps to GenerateReport, to make it easy to look up the report
 * ids later.
 */
public class JobDescriptor
        implements Serializable {
  //Reports only stick around for about a day, so this randomness
  // should be more than sufficient
  //Note: I could have relied on id_rpt_list being a sequence number
  protected static Random random = new Random();
  protected static DateFormat dateFormat = new SimpleDateFormat("M/d/yyyy HH:mm:ss");
  protected static final int MAX_CFP_STAMP = Integer.MAX_VALUE;
  protected static final int MAX_REPORTS_PER_CFP = 100000;
  protected static final int MAX_BASE_CFP_STAMP = MAX_CFP_STAMP / MAX_REPORTS_PER_CFP;
  protected List<DocumentDescriptor> documentDescriptors = new ArrayList<DocumentDescriptor>();
  protected CfpStatusDB cfpStatusDB = null;
  protected String jobName = null;
  protected int baseStamp = 0;
  protected int currentStamp = 0;

  /** Initializes cfp stamps for the JobDescriptor */
  public JobDescriptor() {
    this.baseStamp =
            random.nextInt(MAX_BASE_CFP_STAMP) * MAX_REPORTS_PER_CFP;

    this.currentStamp = baseStamp;
  }

  public int getNumberOfDocumentDescriptors() {
    return documentDescriptors.size();
  }

  /** adds Document Descriptor to list of Document Descriptors for this job */
  public void addDocumentDescriptor(DocumentDescriptor documentDescriptor) {
    int sequenceNumber = documentDescriptors.size() + 1;
    documentDescriptor.setSequenceNumber(sequenceNumber);
    documentDescriptors.add(documentDescriptor);
  }

  /** retrieves report ids returns cfp job descriptor which is later sent to .Net */
  public String toXmlString(Cfp cfp) throws MarshalException, ValidationException, IOException {
    fillInReportIds(cfp);

    String submitTime = dateFormat.format(cfpStatusDB.getSubmissionTimeDate());

    StringWriter stringWriter = new StringWriter();
    //noinspection IOResourceOpenedButNotSafelyClosed
    PrintWriter printWriter = new PrintWriter(stringWriter);

    printWriter.println("<CFP destfile=\"" + cfpStatusDB.getPath() + "\" " +
                        "user=\"" + cfpStatusDB.getPersonId() + "\" " +
                        "cfpId=\"" + cfpStatusDB.getStatusId() + "\" " +
                        "stageId=\"" + cfpStatusDB.getStageId() + "\" " +
                        "caseId=\"" + cfpStatusDB.getCaseId() + "\" " +
                        "name=\"" + StringEscapeUtils.escapeXml(jobName) + "\" " +
                        "submittime=\"" + submitTime + "\">");
    printWriter.println("  <documents quantity=\"" +
                        documentDescriptors.size() + "\">");

    Iterator iterator = documentDescriptors.iterator();
    while (iterator.hasNext()) {
      DocumentDescriptor documentDescriptor = (DocumentDescriptor)
              iterator.next();

      printWriter.println(documentDescriptor.toXmlString());
    }

    printWriter.println("  </documents>");
    printWriter.println("</CFP>");
    printWriter.flush();
    return stringWriter.toString();
  }

  /**
   * Goes through all the Report generated DocumentDescriptors, collects their cfpStamps and matches them up with
   * id_rpt_list in the report_list table.
   */
  protected void fillInReportIds(Cfp cfp) throws RemoteException {
    List vector = getReportDescriptors();
    String[] cfpStamps = new String[vector.size()];
    for (int i = 0; i < cfpStamps.length; i++) {
      DocumentDescriptor documentDescriptor =
              (DocumentDescriptor) vector.get(i);

      cfpStamps[i] = "" + documentDescriptor.getCfpStamp();
    }

    Map reportIds = cfp.getReportIds(cfpStatusDB.getPersonId(), cfpStamps);

    Iterator iterator = vector.iterator();
    while (iterator.hasNext()) {
      DocumentDescriptor documentDescriptor =
              (DocumentDescriptor) iterator.next();

      String cfpStamp = "" + documentDescriptor.getCfpStamp();
      String reportId = (String) reportIds.get(cfpStamp);
      documentDescriptor.setDocumentId(Integer.parseInt(reportId));
    }
  }

  /** Gets all DocumentDescriptors which are generated by GenerateReport */
  protected List getReportDescriptors() {
    List<DocumentDescriptor> documentDescriptors = new ArrayList<DocumentDescriptor>();
    Iterator iterator = this.documentDescriptors.iterator();
    while (iterator.hasNext()) {
      DocumentDescriptor documentDescriptor = (DocumentDescriptor) iterator.next();
      if (documentDescriptor.isReport()) {
        documentDescriptors.add(documentDescriptor);
      }
    }
    return documentDescriptors;
  }

  public void setCfpStatus(CfpStatusDB cfpStatusDB) {
    this.cfpStatusDB = cfpStatusDB;
  }

  public void setJobName(String jobName) {
    this.jobName = jobName;
  }

  public int getBaseStamp() {
    return baseStamp;
  }

  /** Notice it increments the stamp each time called. This is so I can look up the reports individually when I'm done. */
  public int getCurrentStamp() {
    this.currentStamp++;
    return currentStamp;
  }
}
