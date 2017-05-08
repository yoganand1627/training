package gov.georgia.dhr.dfcs.sacwis.web.core.web;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import gov.georgia.dhr.dfcs.sacwis.web.core.exception.handler.ExceptionHandler;

/**
 * This class implements the javax.servlet.http.HttpSessionAttributeListener in order to check objects that are placed
 * in session to ensure that they can be serialized correctly.  It will throw an IllegalArgumentException and
 */
public class SerializableSessionAttributeListener implements HttpSessionAttributeListener {
  private void checkSerializable(HttpSessionBindingEvent httpSessionBindingEvent) throws IllegalArgumentException {
    Object eventObject = httpSessionBindingEvent.getValue();
    // attempt to serialize the bound object if it's not null
    if (eventObject != null) {
      try {
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        ObjectOutputStream objectOut = new ObjectOutputStream(byteOut);
        objectOut.writeObject(eventObject);
        byteOut.flush();
        byteOut.close();  // This does the serialization; if we get past this, we're done.
      }
      catch (Throwable t) {
        IllegalArgumentException illegalArgumentException
                = new IllegalArgumentException("Object added to session that is not serializable");
        illegalArgumentException.initCause(t);
        ExceptionHandler.handle(illegalArgumentException); // This forces a log entry to be written
        throw illegalArgumentException;
      }
    }
  }

  public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {
    checkSerializable(httpSessionBindingEvent);
  }

  public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {
    checkSerializable(httpSessionBindingEvent);
  }

  public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {
    checkSerializable(httpSessionBindingEvent);
  }
}
