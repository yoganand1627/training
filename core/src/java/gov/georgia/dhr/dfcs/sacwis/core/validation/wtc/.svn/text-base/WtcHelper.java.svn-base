package gov.georgia.dhr.dfcs.sacwis.core.validation.wtc;

import gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.ValidationException;

public abstract class WtcHelper {
  public static final String TRACE_TAG = "WtcHelper";

  public static XmlValueBean callService(String serviceName, XmlValueBean inputBean, Class outputClass)
          throws WtcException {
    throw new UnsupportedOperationException("WtcHelper.callService() requires weblogic.");
  }

  public static String callService(String serviceName, XmlValueBean xmlBean)
          throws WtcException {
    throw new UnsupportedOperationException("WtcHelper.callService() requires weblogic.");
  }

  public static String callService(String serviceName, String xmlInput) throws WtcException {
    throw new UnsupportedOperationException("WtcHelper.callService() requires weblogic.");
  }

  public static String callService(String serviceName, String xmlInput, TuxedoConnection myTux)
          throws WtcException {
    throw new UnsupportedOperationException("WtcHelper.callService() requies Weblogic.");
  }

  public static AsynchCallBean callAsynchService(String serviceName, XmlValueBean xmlBean)
          throws WtcException {
    throw new UnsupportedOperationException("WtcHelper.callAsynchService() requires weblogic.");
  }

  /**
   * Most people should not use this method.  They should use the callService method which takes 3 parameters.  Certain
   * long running processes (CaseFilePrint) call lots of services and in development these services timeout for reasons
   * other than their queries taking a long time (tuxedo only accepts 5 connections?).  It is a pain to constaintly
   * retry the processes as the process may take minutes and it may take several times to get a process to succeed;
   * instead it's easier to automatically retry calling each of those services the developer feels/knows are safe to
   * call a second time upon a tuxedo timeout.
   */
  public static XmlValueBean callService(String serviceName, XmlValueBean inputBean, Class outputClass,
                                         int retryOnTimeout)
          throws WtcException, MarshalException, ValidationException {
    throw new UnsupportedOperationException("WtcHelper.callService() requires weblogic.");
  }

  public static WtcTransactionHandle getTransactionTuxedoConnection() throws WtcException {
    throw new UnsupportedOperationException("WtcHelper.getTransactionTuxedoConnection() requires weblogic.");
  }

  public static void endTuxedoTransaction(WtcTransactionHandle wth) throws WtcException {
    throw new UnsupportedOperationException("WtcHelper.endTuxedoTransaction() requires weblogic.");
  }
}
