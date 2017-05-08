/**
 * Created on Jun 21, 2006 at 1:25:22 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.web.core.web;

import org.grnds.structural.web.GrndsExchangeContext;
import org.grnds.structural.web.GrndsHttpConversation;
import org.grnds.structural.web.GrndsHttpConversationFactory;
import org.grnds.structural.web.config.GrndsConversationInfo;

import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/** Unlike the standard GRNDS conversation factory, this conversation factory */
public class GrndsSpringConversationFactory extends GrndsHttpConversationFactory {
  public GrndsSpringConversationFactory(GrndsConversationInfo info_) {
    super(info_);
  }

  @SuppressWarnings({"ProhibitedExceptionDeclared"})
  protected GrndsHttpConversation doProduceConversation(GrndsExchangeContext geContext) throws Exception {
    GrndsHttpConversation conversation = super.doProduceConversation(geContext);
    WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(geContext.getServletContext());
    AutowireCapableBeanFactory beanFactory = context.getAutowireCapableBeanFactory();
    beanFactory.autowireBeanProperties(conversation, AutowireCapableBeanFactory.AUTOWIRE_BY_TYPE, false);
    return conversation;
  }
}
