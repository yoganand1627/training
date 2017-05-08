package gov.georgia.dhr.dfcs.sacwis.core.validation.wtc;

import java.util.StringTokenizer;

import org.grnds.facility.log.GrndsTrace;

import gov.georgia.dhr.dfcs.sacwis.core.exception.BasePrsException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;

/**
 * <pre>
 * Date        User      Description
 * --------    --------  --------------------------------------------------
 * 07/24/2005  werlem    SIR 23728 - MPS Phase II Enhancement to add Contact List and Detail to MPS.
 * </pre>
 */
public class WtcException extends ServiceException {
  public static final String TRACE_TAG = "WtcException";
  public static int UNKNOWN_CODE = -1;
  public static String UNKNOWN_FILE_NAME = "Error Calling Tuxedo, no associated file.";
  public static int UNKNOWN_LINE_NUMBER = -1;
  public static String UNKNOWN_ERROR_NAME = "Unknown C Message Name";
  private int _explain_code = 0;
  private int _rc = 0;
  private String _errorType = null;
  private String _fileName = null;
  private int _lineNumber = 0;
  private String _errorName = null;
  private String _errorPresentation = null;
  private String _tuxId = null;

  public WtcException() {
    this("", null, DEFAULT_PRIORITY_LEVEL);
  }

  /** added by mcclaim on 6/19/2003 to allow java code to throw WtcExceptions with a particular message */
  public WtcException(int messageNumber) {
    this("", null, DEFAULT_PRIORITY_LEVEL);

    this.setErrorCode(messageNumber);
    setErrorMessage(MessageLookup.getMessageByNumber(messageNumber));
  }

  public WtcException(String msg) {
    this(msg, null, DEFAULT_PRIORITY_LEVEL);
  }

  public WtcException(String msg, int priorityLevel) {
    this(msg, null, priorityLevel);
  }

  public WtcException(String msg, Exception e, int priorityLevel) {
    this(msg, e, priorityLevel, BasePrsException.UNKNOWN_ERROR_TYPE);
  }

  public WtcException(String msg, Exception e, int priorityLevel, String errorType) {
    super(msg, e, priorityLevel);

    this.setErrorCode(UNKNOWN_CODE);
    this.setErrorType(errorType);
    setErrorMessage(msg);
    this.setFileName(UNKNOWN_FILE_NAME);
    this.setLineNumber(UNKNOWN_LINE_NUMBER);
    this.setErrorName(UNKNOWN_ERROR_NAME);
  }

  public WtcException(Exception e) {
    this("General Exception Calling Tuxedo: " + e.getMessage(),
         e, DEFAULT_PRIORITY_LEVEL, BasePrsException.UNKNOWN_ERROR_TYPE);
    GrndsTrace.enterScope(TRACE_TAG + ".Econstructor");
    GrndsTrace.exitScope();
  }

  protected void setRc(int rc) {
    _rc = rc;
  }

  protected void setExplain_code(int explain_code) {
    _explain_code = explain_code;
  }

  /**
   * This has to override the super-method because the field is marked private and really, only this exception should
   * override it.
   *
   * @param errorType
   */
  protected void setErrorType(String errorType) {
    if (errorType == null) {
      _errorType = super.getErrorType();
    } else if (!"".equals(errorType)) {
      _errorType = errorType;
    } else {
      _errorType = super.getErrorType();
    }
  }

  protected void setFileName(String fileName) {
    if (fileName == null) {
      _fileName = UNKNOWN_FILE_NAME;
    } else if ("".equals(fileName)) {
      _fileName = UNKNOWN_FILE_NAME;
    } else {
      _fileName = fileName;
    }
  }

  protected void setLineNumber(int lineNumber) {
    _lineNumber = lineNumber;
  }

  protected void setErrorName(String errorName) {
    _errorName = errorName;
  }

  protected void setErrorPresentation(String errorPres) {
    _errorPresentation = errorPres;
  }

  public int getRc() {
    return _rc;
  }

  public int getExplain_code() {
    return _explain_code;
  }

  /** This has to override the super-method because the field is shadowed in the super-class. */
  public String getErrorType() {
    if (_errorType == null) {
      return super.getErrorType();
    } else if ("".equals(_errorType)) {
      return super.getErrorType();
    } else {
      return _errorType;
    }
  }

  public String getErrorPresentation() {
    if (_errorPresentation == null) {
      return "";
    } else {
      return _errorPresentation;
    }
  }

  public String getFileName() {
    if (_fileName == null) {
      return "";
    } else {
      return _fileName;
    }
  }

  public int getLineNumber() {
    return _lineNumber;
  }

  public String getErrorName() {
    if (_errorName == null) {
      return "";
    } else {
      return _errorName;
    }
  }

  public String getMessage() {
    return this.getErrorMessage();
  }

  public String getTuxId() {
    return _tuxId;
  }

  public void setTuxId(String tuxId) {
    this._tuxId = tuxId;
  }

  public String getFileNameOnly() {
    StringTokenizer filenameTokens = new StringTokenizer(this.getFileName(), "/\\");
    String filename = "";
    while (filenameTokens.hasMoreTokens()) {
      filename = filenameTokens.nextToken();
    }
    return filename;
  }

  public String getFilePathOnly() {
    StringTokenizer filenameTokens = new StringTokenizer(this.getFileName(), "/\\");
    String filepath = "";
    int directoryTokensCount = filenameTokens.countTokens() - 1;
    for (int i = 0; i < directoryTokensCount; i++) {
      filepath += "/" + filenameTokens.nextToken();
    }
    return filepath;
  }

  public String toString() {
    return
            "WtcException: \n" +
            " _errorCode: " + _errorCode + "\n" +
            " _explain_code: " + _explain_code + "\n" +
            " _rc: " + _rc + "\n" +
            " _errorType: " + _errorType + "\n" +
            " _errorMessageText: " + _errorMessageText + "\n" +
            " uniqueId: " + super.getUniqueId() + "\n" +
            " _tuxId: " + getTuxId() + "\n" +
            " _fileName: " + _fileName + "\n" +
            " _lineNumber: " + _lineNumber + "\n" +
            " _errorName: " + _errorName + "\n" +
            " _errorPresentation: " + _errorPresentation + "\n";
  }
}
