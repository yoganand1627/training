package gov.georgia.dhr.dfcs.sacwis.core.message;

// java classes

import org.grnds.facility.log.GrndsTrace;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodeNotFoundException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.DataNotFoundException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.DuplicateRecordFoundException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.ReferenceDataLookup;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.ReferenceDataLookupException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.TableNotFoundException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.tabledefs.MessageByNameTableDefinition;

/**
 * This file contains the LookupData class which encapsulates two HashMaps - one for encoding and one for decoding. This
 * class exists so that we can store all of our data in a single object in the JNDI tree. This is the object that will
 * be stored.
 *
 * @author Daniel W. Webster, May 14, 2002
 */
public abstract class MessageNameLookup extends ReferenceDataLookup {
  public static int getNumber(String messageName)
          throws ReferenceDataLookupException,
                 TableNotFoundException,
                 DuplicateRecordFoundException,
                 CodeNotFoundException,
                 DataNotFoundException {
    Integer msgInt;
    int msgNum;

    GrndsTrace.enterScope(TRACE_TAG + ".getNumber()");
    msgInt = (Integer) ReferenceDataLookup.get(
            MessageByNameTableDefinition.TABLE_ID,
            messageName,
            "NBR_MESSAGE");
    msgNum = msgInt;
    GrndsTrace.exitScope();
    return msgNum;
  }


  public static String getMessage(String messageName) {
    String message;
    int msgNum = 0;
    GrndsTrace.enterScope(TRACE_TAG + ".getMessage()");
    try {
      msgNum = getNumber(messageName);
    }
    catch (Exception e) {
      StackTraceElement[] stackTrace = e.getStackTrace();
      StringBuffer sb = new StringBuffer();
      message = "No message named " + messageName + " found.";
      sb.append(message).append(ArchitectureConstants.LINE_BREAK);
      sb.append(e.getMessage()).append(ArchitectureConstants.LINE_BREAK);
      for (int i = 0; i < stackTrace.length; i++) {
        StackTraceElement stackTraceElement = stackTrace[i];
        sb.append(stackTraceElement.toString()).append(ArchitectureConstants.LINE_BREAK);
      }
      GrndsTrace.msg(TRACE_TAG, 7, sb.toString());
    }
    try {
      message = MessageNumberLookup.getMessage(msgNum);
    }
    catch (Exception e) {
      StackTraceElement[] stackTrace = e.getStackTrace();
      StringBuffer sb = new StringBuffer();
      message = "No message named " + messageName + " with the number " + msgNum + " found.";
      sb.append(message).append(ArchitectureConstants.LINE_BREAK);
      sb.append(e.getMessage()).append(ArchitectureConstants.LINE_BREAK);
      for (int i = 0; i < stackTrace.length; i++) {
        StackTraceElement stackTraceElement = stackTrace[i];
        sb.append(stackTraceElement.toString()).append(ArchitectureConstants.LINE_BREAK);
      }
      GrndsTrace.msg(TRACE_TAG, 7, sb.toString());
    }

    GrndsTrace.exitScope();
    return message;
  }


  public static String getSource(String messageName) {
    String src;
    int msgNum = 0;
    GrndsTrace.enterScope(TRACE_TAG + ".getMessage()");
    try {
      msgNum = getNumber(messageName);
    }
    catch (Exception e) {
      StackTraceElement[] stackTrace = e.getStackTrace();
      StringBuffer sb = new StringBuffer();
      String message = "No message named " + messageName + " found.";
      sb.append(message).append(ArchitectureConstants.LINE_BREAK);
      sb.append(e.getMessage()).append(ArchitectureConstants.LINE_BREAK);
      for (int i = 0; i < stackTrace.length; i++) {
        StackTraceElement stackTraceElement = stackTrace[i];
        sb.append(stackTraceElement.toString()).append(ArchitectureConstants.LINE_BREAK);
      }
      GrndsTrace.msg(TRACE_TAG, 7, sb.toString());
    }
    try {
      src = MessageNumberLookup.getSource(msgNum);
    }
    catch (Exception e) {
      StackTraceElement[] stackTrace = e.getStackTrace();
      StringBuffer sb = new StringBuffer();
      src = "No message named " + messageName + " with the number " + msgNum + " found.";
      sb.append(src).append(ArchitectureConstants.LINE_BREAK);
      sb.append(e.getMessage()).append(ArchitectureConstants.LINE_BREAK);
      for (int i = 0; i < stackTrace.length; i++) {
        StackTraceElement stackTraceElement = stackTrace[i];
        sb.append(stackTraceElement.toString()).append(ArchitectureConstants.LINE_BREAK);
      }
      GrndsTrace.msg(TRACE_TAG, 7, sb.toString());
    }

    GrndsTrace.exitScope();
    return src;
  }


  public static String getPresentation(String messageName) {
    String pres;
    int msgNum = 0;
    GrndsTrace.enterScope(TRACE_TAG + ".getMessage()");
    try {
      msgNum = getNumber(messageName);
    }
    catch (Exception e) {
      StackTraceElement[] stackTrace = e.getStackTrace();
      StringBuffer sb = new StringBuffer();
      String message = "No message named " + messageName + " found.";
      sb.append(message).append(ArchitectureConstants.LINE_BREAK);
      sb.append(e.getMessage()).append(ArchitectureConstants.LINE_BREAK);
      for (int i = 0; i < stackTrace.length; i++) {
        StackTraceElement stackTraceElement = stackTrace[i];
        sb.append(stackTraceElement.toString()).append(ArchitectureConstants.LINE_BREAK);
      }
      GrndsTrace.msg(TRACE_TAG, 7, sb.toString());
    }
    try {
      pres = MessageNumberLookup.getPresentation(msgNum);
    }
    catch (Exception e) {
      StackTraceElement[] stackTrace = e.getStackTrace();
      StringBuffer sb = new StringBuffer();
      pres = "No message named " + messageName + " with the number " + msgNum + " found.";
      sb.append(pres).append(ArchitectureConstants.LINE_BREAK);
      sb.append(e.getMessage()).append(ArchitectureConstants.LINE_BREAK);
      for (int i = 0; i < stackTrace.length; i++) {
        StackTraceElement stackTraceElement = stackTrace[i];
        sb.append(stackTraceElement.toString()).append(ArchitectureConstants.LINE_BREAK);
      }
      GrndsTrace.msg(TRACE_TAG, 7, sb.toString());
    }

    GrndsTrace.exitScope();
    return pres;
  }


  public static boolean isBatch(String messageName)
          throws ReferenceDataLookupException,
                 TableNotFoundException,
                 DuplicateRecordFoundException,
                 CodeNotFoundException,
                 DataNotFoundException {
    boolean batch;
    int msgNum;
    GrndsTrace.enterScope(TRACE_TAG + ".getMessage()");
    msgNum = getNumber(messageName);
    batch = MessageNumberLookup.isBatch(msgNum);

    GrndsTrace.exitScope();
    return batch;
  }


  public static final String TRACE_TAG = "MessageNameLookup";
}


