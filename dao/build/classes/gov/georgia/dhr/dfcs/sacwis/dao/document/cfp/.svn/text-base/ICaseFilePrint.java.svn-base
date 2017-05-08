/**
 * Created on Feb 24, 2006 at 4:06:35 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao.document.cfp;

import java.io.Serializable;

import org.springframework.beans.factory.BeanFactory;

public interface ICaseFilePrint extends Serializable {
  static final int QUEUE_LIMIT = 2;
  static final String GENERATE_FORM = "GenerateForm";
  static final String GENERATE_REPORT = "GenerateReport";
  static final String GENERATE_DOCUMENT = "GenerateDocument";
  static final String UNSUPPORTED = "UNSUPPORTED";

  void queueJob(BeanFactory beanFactory);
}
