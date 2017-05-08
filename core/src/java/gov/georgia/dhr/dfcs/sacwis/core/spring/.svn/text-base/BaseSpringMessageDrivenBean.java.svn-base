/**
 * Created on Feb 13, 2007 at 3:55:03 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.core.spring;

import javax.ejb.MessageDrivenContext;

import org.springframework.ejb.support.AbstractMessageDrivenBean;

public class BaseSpringMessageDrivenBean extends AbstractMessageDrivenBean implements SpringConstants {
  protected void onEjbCreate() {
    // Do nothing by default.
  }

  public void setMessageDrivenContext(MessageDrivenContext messageDrivenContext) {
    super.setMessageDrivenContext(messageDrivenContext);
    setBeanFactoryLocator(SJSASContextSingletonBeanFactoryLocator.getInstance(SERVICE_CONTEXT_SELECTOR));
    setBeanFactoryLocatorKey(SERVICE_BEAN_FACTORY);
  }
}
