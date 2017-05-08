package gov.georgia.dhr.dfcs.sacwis.core.message;

// java classes

import org.grnds.facility.log.GrndsTrace;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodeNotFoundException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.DataNotFoundException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.DuplicateRecordFoundException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.ReferenceDataLookup;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.ReferenceDataLookupException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.TableNotFoundException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.tabledefs.MessageByNumberTableDefinition;

/**
 * This file contains the LookupData class which encapsulates two HashMaps - one for encoding and one for decoding. This
 * class exists so that we can store all of our data in a single object in the JNDI tree. This is the object that will
 * be stored.
 *
 * @author Daniel W. Webster, May 14, 2002
 */
public abstract class MessageNumberLookup extends ReferenceDataLookup {
  public static final String TRACE_TAG = "MessageNumberLookup";

  public static String getName(String messageNumberString) {
    String name;
    GrndsTrace.enterScope(TRACE_TAG + ".getName()");
    try {
      name = (String) ReferenceDataLookup.get(MessageByNumberTableDefinition.TABLE_ID, messageNumberString,
                                              "TXT_MESSAGE_NAME");
    }
    catch (Exception e) {
      //GrndsLogRecord logRecord = new GrndsLogRecord(GrndsLevel.NOTICE, "In catch" );
      //logRecord.setThrown(e);
      //GrndsTrace.msg(TRACE_TAG, 7, logRecord.getThrownBackTrace());
      name = "No message number " + messageNumberString + " found.";
    }
    GrndsTrace.exitScope();
    return name;
  }

  public static String getMessage(String messageNumberString) {
    String message;
    GrndsTrace.enterScope(TRACE_TAG + ".getMessage()");
    try {
      message = (String) ReferenceDataLookup.get(MessageByNumberTableDefinition.TABLE_ID, messageNumberString,
                                                 "TXT_MESSAGE");
    }
    catch (Exception e) {
      //GrndsLogRecord logRecord = new GrndsLogRecord(GrndsLevel.NOTICE, "In catch" );
      //logRecord.setThrown(e);
      //GrndsTrace.msg(TRACE_TAG, 7, logRecord.getThrownBackTrace());
      message = "No message number " + messageNumberString + " found.";
    }
    GrndsTrace.exitScope();
    return message;
  }

  public static boolean isBatch(String messageNumberString)
          throws ReferenceDataLookupException, TableNotFoundException, DuplicateRecordFoundException,
                 CodeNotFoundException, DataNotFoundException {
    String indString;
    GrndsTrace.enterScope(TRACE_TAG + ".getMessage()");
    indString = (String) ReferenceDataLookup.get(MessageByNumberTableDefinition.TABLE_ID, messageNumberString,
                                                 "TXT_MESSAGE");
    GrndsTrace.exitScope();
    return "Y".equals(indString);
  }

  public static String getPresentation(String messageNumberString) {
    Integer presInt = null;
    String pres;
    GrndsTrace.enterScope(TRACE_TAG + ".getMessage()");
    try {
      presInt = (Integer) ReferenceDataLookup.get(MessageByNumberTableDefinition.TABLE_ID, messageNumberString,
                                                  "CD_PRESENTATION");
    }
    catch (Exception e) {
      // FIXME: Currently, this is essentially ignored.
      //GrndsLogRecord logRecord = new GrndsLogRecord(GrndsLevel.NOTICE, "In catch" );
      //logRecord.setThrown(e);
      //GrndsTrace.msg(TRACE_TAG, 7, logRecord.getThrownBackTrace());
      pres = "No message number " + messageNumberString + " found.";
    }
    try {
      //GrndsTrace.msg( TRACE_TAG+".getPresentation()", 7, "presNum = " + presNum );
      pres = Lookup.simpleDecode("CMSGPRES", "" + presInt);
    }
    catch (Exception e) {
      //GrndsLogRecord logRecord = new GrndsLogRecord(GrndsLevel.NOTICE, "In catch" );
      //logRecord.setThrown(e);
      //GrndsTrace.msg(TRACE_TAG, 7, logRecord.getThrownBackTrace());
      pres = "No presentaton for message number " + messageNumberString + " found.";
    }
    GrndsTrace.exitScope();
    return pres;
  }

  public static String getSource(String messageNumberString) {
    Integer srcInt = null;
    int srcNum;
    String src;
    GrndsTrace.enterScope(TRACE_TAG + ".getMessage()");
    try {
      srcInt = (Integer) ReferenceDataLookup.get(MessageByNumberTableDefinition.TABLE_ID, messageNumberString,
                                                 "CD_SOURCE");
    }
    catch (Exception e) {
      // FIXME: Currently, this is essentially ignored.
      //GrndsLogRecord logRecord = new GrndsLogRecord(GrndsLevel.NOTICE, "In catch" );
      //logRecord.setThrown(e);
      //GrndsTrace.msg(TRACE_TAG, 7, logRecord.getThrownBackTrace());
      src = "No message number " + messageNumberString + " found.";
    }
    try {
      srcNum = srcInt;
      src = Lookup.simpleDecode("CMSGSRC", "" + srcNum);
    }
    catch (Exception e) {
      //GrndsLogRecord logRecord = new GrndsLogRecord(GrndsLevel.NOTICE, "In catch" );
      //logRecord.setThrown(e);
      //GrndsTrace.msg(TRACE_TAG, 7, logRecord.getThrownBackTrace());
      src = "No source for message number " + messageNumberString + " found.";
    }
    GrndsTrace.exitScope();
    return src;
  }

  public static String getMessage(int messageNumber) {
    GrndsTrace.enterScope(TRACE_TAG + ".getMessage()");
    String message = getMessage("" + messageNumber);
    GrndsTrace.exitScope();
    return message;
  }

  public static String getName(int messageNumber) {
    GrndsTrace.enterScope(TRACE_TAG + ".getName()");
    String name = getName("" + messageNumber);
    GrndsTrace.exitScope();
    return name;
  }

  public static String getPresentation(int messageNumber) {
    GrndsTrace.enterScope(TRACE_TAG + ".getPresentation()");
    String pres = getPresentation("" + messageNumber);
    GrndsTrace.exitScope();
    return pres;
  }

  public static String getSource(int messageNumber) {
    GrndsTrace.enterScope(TRACE_TAG + ".getPresentation()");
    String src = getSource("" + messageNumber);
    GrndsTrace.exitScope();
    return src;
  }

  public static boolean isBatch(int messageNumber)
          throws ReferenceDataLookupException, TableNotFoundException, DuplicateRecordFoundException,
                 CodeNotFoundException, DataNotFoundException {
    GrndsTrace.enterScope(TRACE_TAG + ".getPresentation()");
    boolean batch = isBatch("" + messageNumber);
    GrndsTrace.exitScope();
    return batch;
  }
}
