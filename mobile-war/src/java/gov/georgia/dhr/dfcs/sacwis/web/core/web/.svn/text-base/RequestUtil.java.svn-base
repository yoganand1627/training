/**
 * Created on Nov 3, 2006 at 4:24:53 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.web.core.web;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletRequest;

public class RequestUtil {
  public static final String APACHE_PACKAGE = "org.apache.";
  public static final String JAVAX_PACKAGE = "javax.";

  static void removeAllAttributesSafe(ServletRequest delegateRequest) {
    Map<String, Object> attributeMap = getSafeAttributeMap(delegateRequest);
    for (Iterator<String> removeIt = attributeMap.keySet().iterator(); removeIt.hasNext();) {
      delegateRequest.removeAttribute(removeIt.next());
    }
  }

  static LinkedHashMap<String, Object> getSafeAttributeMap(ServletRequest request) {
    Enumeration attrbiuteEnum = request.getAttributeNames();
    LinkedHashMap<String, Object> attributeMap = new LinkedHashMap<String, Object>();
    while (attrbiuteEnum.hasMoreElements()) {
      String name = (String) attrbiuteEnum.nextElement();
      // Deliberately ignore Apache and javax attributes.
      if (!name.startsWith(APACHE_PACKAGE) && !name.startsWith(JAVAX_PACKAGE)) {
        attributeMap.put(name, request.getAttribute(name));
      }
    }
    return attributeMap;
  }
}
