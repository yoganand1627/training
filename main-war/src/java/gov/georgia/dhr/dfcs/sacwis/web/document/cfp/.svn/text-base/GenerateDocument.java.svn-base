package gov.georgia.dhr.dfcs.sacwis.web.document.cfp;

import org.springframework.beans.factory.BeanFactory;

/**
 * This inherits all functionality from GenerateForm It signals to retrieve it's information from the database instead
 * of from a prefill service
 */
public class GenerateDocument extends GenerateForm {
  public GenerateDocument(BeanFactory beanFactory) {
    super(beanFactory);
    super.documentExists = true;
  }
}


