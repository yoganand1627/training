package gov.georgia.dhr.dfcs.sacwis.service.document;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.grnds.facility.log.GrndsTrace;

import gov.georgia.dhr.dfcs.sacwis.core.spring.BaseSpringMessageDrivenBean;
import gov.georgia.dhr.dfcs.sacwis.dao.document.cfp.ICaseFilePrint;

/** Allows CaseFilePrint to be executed in a separate thread. Is implemented as a EJB MessageDrivenBean. */
public class CfpMDB extends BaseSpringMessageDrivenBean implements MessageListener {
  public static final String TRACE_TAG = "CfpMDB";

  /** Is called when the queue receives a message. It takes the CaseFilePrint object it receives and calls run on it. */
  public void onMessage(Message message) {
    GrndsTrace.enterScope(TRACE_TAG + ".onMessage");
    try {
      ObjectMessage objectMessage = (ObjectMessage) message;
      ICaseFilePrint caseFilePrint = (ICaseFilePrint) objectMessage.getObject();
      caseFilePrint.queueJob(getBeanFactory());
    } catch (Exception e) {
      // FIXME: Log this.
      // e.printStackTrace();
    }
    GrndsTrace.exitScope();
  }

}
