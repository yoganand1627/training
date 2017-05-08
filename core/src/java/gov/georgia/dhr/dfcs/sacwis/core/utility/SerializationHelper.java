package gov.georgia.dhr.dfcs.sacwis.core.utility;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.grnds.facility.log.GrndsTrace;

public abstract class SerializationHelper {

  private static final String TRACE_TAG = "SerializationUtility";

  public static String serializeObject(Object object) throws IOException {
    GrndsTrace.enterScope(TRACE_TAG + ".serializeObject()");
    String formData = null;
    ObjectOutputStream objectOut = null;
    try {
      ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
      objectOut = new ObjectOutputStream(byteOut);
      objectOut.writeObject(object);
      byte[] byteArray = byteOut.toByteArray();
      formData = HTMLEncoder.encode(byteArray);
    } finally {
      if (objectOut != null) {
        objectOut.close();
      }
    }
    GrndsTrace.exitScope();
    return formData;
  }

  public static Object deserializeObject(String formData) throws IOException {
    GrndsTrace.enterScope(TRACE_TAG + ".deserializeObject()");
    Object object = null;
    ObjectInputStream objectIn = null;
    try {
      byte[] serializedBytes = HTMLEncoder.decode(formData);
      ByteArrayInputStream byteArrayIn = new ByteArrayInputStream(serializedBytes);
      objectIn = new ObjectInputStream(byteArrayIn);
      object = objectIn.readObject();
    } catch (ClassNotFoundException e) {
      IOException ioe = new IOException(e.getMessage());
      ioe.initCause(e);
      throw ioe;
    } finally {
      if (objectIn != null) {
        objectIn.close();
      }
    }
    GrndsTrace.exitScope();
    return object;
  }
}
