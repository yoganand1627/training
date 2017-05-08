package gov.georgia.dhr.dfcs.sacwis.core.validation.wtc;


import gov.georgia.dhr.dfcs.sacwis.core.exception.RuntimeWrappedException;
//import weblogic.wtc.jatmi.ApplicationToMonitorInterface;
//import weblogic.wtc.jatmi.CallDescriptor;
//import weblogic.wtc.jatmi.Reply;
//import weblogic.wtc.jatmi.TPException;
//import weblogic.wtc.jatmi.TPReplyException;
//import weblogic.wtc.jatmi.TpacallAsyncReply;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class AsynchCallBean implements Serializable { // implements TpacallAsyncReply, Serializable {

  public static final String TRACE_TAG = "AsynchCallBean";

  private transient Object semaphore;
  private String formattedReply;
  private boolean success;
  private boolean finished = false;
  private Exception exception = null;


  /** Initializes an asynchronous reply object with an object to use for coordination with the Toupper EJB */
  public AsynchCallBean() {
    this.semaphore = new Object(); // use Integer becuase it's serializable and cheap to serialize
  }


  /** The method that will be called by the system on a successful return from the service */
/*
  public void success(ApplicationToMonitorInterface atmi, CallDescriptor cd, Reply successReply) {
    success = true;

    this.formattedReply = WtcHelper.formatReply(successReply);

    synchronized (semaphore) {
      finished = true;

      semaphore.notify();
    }

    return;
  }
*/


  /** The method that will be called by the system on an unsuccessful return from the service */
/*
  public void failure(ApplicationToMonitorInterface atmi, CallDescriptor cd, TPException failureReply) {
    success = false;
    formattedReply = null;

    if (failureReply == null) {
      GrndsTrace.msg(TRACE_TAG, 3, "ERROR: No TPException returned!");
      exception = new Exception("ERROR: No TPException returned.");
      return;
    } else if (failureReply instanceof TPReplyException) {
      TPReplyException tre = (TPReplyException) failureReply;
      try {
        exception = new WtcException(tre);
      }
      catch (WtcException e) {
        // if this happens, there's nothing that can be done to recover,
        // so just handle it as a TPException
        exception = new WtcException(failureReply);
      }
      GrndsTrace.msg(TRACE_TAG, 3, "ERROR: TPReplyException" + tre.getMessage());
    } else {
      exception = new WtcException(failureReply);
    }

    synchronized (semaphore) {
      finished = true;

      semaphore.notify();
    }

    return;
  }
*/


  /** This should only be called after the finisher has been notified */
  public boolean didSucceed() {
    return (success);
  }


  /** This should only be called after the finisher has been notified */
  public String getResponse() throws WtcException {
    if (!finished) {
      return null;
    } else if (!success) {
      if (exception instanceof WtcException) {
        throw (WtcException) exception;
      } else {
        throw new RuntimeWrappedException(exception);
      }
    } else {
      return (formattedReply);
    }
  }


  /** Returns true when the response has been received */
  public boolean gotResponse() {
    synchronized (semaphore) {
      return (finished);
    }
  }


  private void writeObject(ObjectOutputStream out) throws IOException {
    // We have to call defaultWriteObject first.
    out.defaultWriteObject();
  }


  private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
    // We have to call defaultReadObject first.
    in.defaultReadObject();
    // Object is not Serializable, so we need to make a new one when we read the object
    semaphore = new Object();
  }
}
