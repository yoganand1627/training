package gov.georgia.dhr.dfcs.sacwis.web.core.web;

import javax.servlet.ServletRequest;

import org.grnds.foundation.GrndsObject;
import org.grnds.foundation.servlet.GrndsPathInfoQNameFactory;
import org.grnds.foundation.servlet.GrndsServletQNameFactory;
import org.grnds.foundation.util.GrndsQName;
import org.grnds.structural.web.GrndsExchangeContext;

/**
 * Uses the grnds attributes set by the including request in order to product the QName.
 *
 * @author Michael K. Werle
 */
public final class IncludeQNameFactory extends GrndsObject implements GrndsServletQNameFactory {

  public IncludeQNameFactory() {
    super();
  }

  public GrndsQName produceQName(ServletRequest request) {
    String conversation = (String) request.getAttribute(GrndsExchangeContext.CONVERSATION_REQ_ATTRIB);
    String command = (String) request.getAttribute(GrndsExchangeContext.COMAMAND_REQ_ATTRIB);
    if (conversation == null) {
      return grndsPathInfoQNameFactory.produceQName(request);
    }
    return new GrndsQName(conversation, command);
  }

  protected final boolean isEqualsIdentityBased() {
    return true;
  }

  private GrndsPathInfoQNameFactory grndsPathInfoQNameFactory = new GrndsPathInfoQNameFactory();

}
