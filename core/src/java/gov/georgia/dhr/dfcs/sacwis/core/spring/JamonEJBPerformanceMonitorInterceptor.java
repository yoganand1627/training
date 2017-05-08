/**
 * Created on Jun 26, 2007 at 5:16:06 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.core.spring;

import org.springframework.aop.interceptor.JamonPerformanceMonitorInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class JamonEJBPerformanceMonitorInterceptor extends JamonPerformanceMonitorInterceptor {
  protected String createInvocationTraceName(MethodInvocation invocation) {
    // TODO: Figure out how to build the name based on the business interface.
    return super.createInvocationTraceName(invocation);
  }
}
