/**
 * Created on Aug 14, 2006 at 1:34:03 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.service.document;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import javax.ejb.CreateException;
import javax.ejb.EJBException;

import gov.georgia.dhr.dfcs.sacwis.core.spring.BaseSpringStatelessSessionBean;
import gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean;

public class DocumentServiceExecutorBean extends BaseSpringStatelessSessionBean {

  @SuppressWarnings({"EjbWarningInspection", "FieldAccessedSynchronizedAndUnsynchronized"})
  private static final ConcurrentMap<Class, java.lang.reflect.Method> serviceMethodMap =
          new ConcurrentHashMap<Class, java.lang.reflect.Method>();

  protected void onEjbCreate() throws CreateException {
    // Do nothing.
  }

  /**
   * This method finds the document service and executes it.  It uses reflection, which is usually a bad idea in EJBs,
   * as the security manager may cause exceptions, but if called properly, all classes should be available.
   * <p/>
   * Note that IDEA complains about the use of reflective classes, to the warnings are surpressed with comments, but
   * full class names for java.lang.reflect.* are required becuase there is no way to otherwise surpress the import
   * warnings.
   *
   * @param serviceInterface Only services with interfaces that extend {@link DocumentService} can be used here.
   * @param input
   * @return
   */
  public XmlValueBean callDocumentService(Class<? extends DocumentService> serviceInterface, XmlValueBean input) {
    // First check the method cache to see if this method has already been cached.
    //noinspection EjbWarningInspection
    java.lang.reflect.Method method = serviceMethodMap.get(serviceInterface);
    // If we did not get a method, try to find it via reflection. This id done w/o synchronization because the cost of
    //   double-computation is small, and doing so will never result in an incorrect return value.
    if (method == null) {
      // Only call methods exposed through the service interface; this prevents us from accidentally calling a helper
      //   method inside the service that is erroneously marked public.
      //noinspection EjbWarningInspection
      java.lang.reflect.Method[] methods = serviceInterface.getMethods();
      for (int i = 0; i < methods.length; i++) {
        //noinspection EjbWarningInspection
        java.lang.reflect.Method aMethod = methods[i];
        Class<?>[] params = aMethod.getParameterTypes();
        if (params.length == 1 && params[0].isAssignableFrom(input.getClass())) {
          method = aMethod;
          serviceMethodMap.put(serviceInterface, method);
          break;
        }
      }
      if (method == null) {
        throw new EJBException("Cannot find service method for " + String.valueOf(serviceInterface));
      }
    }
    //noinspection EjbWarningInspection
    try {
      String simpleName = serviceInterface.getSimpleName();
      // Name must be 2 or more characters long.
      String beanName = Character.toLowerCase(simpleName.charAt(0)) + simpleName.substring(1);
      DocumentService service = (DocumentService) getBeanFactory().getBean(beanName);
      return (XmlValueBean) method.invoke(service, input);
    } catch (IllegalAccessException e) {
      throw new EJBException("Cannot access service method", e);
    } catch (java.lang.reflect.InvocationTargetException e) {
      Throwable cause = e.getCause();
      if (cause instanceof RuntimeException) {
        throw (RuntimeException) cause;
      } else {
        throw new EJBException("Exception wile invoking document service.", e);
      }
    }
  }

}
