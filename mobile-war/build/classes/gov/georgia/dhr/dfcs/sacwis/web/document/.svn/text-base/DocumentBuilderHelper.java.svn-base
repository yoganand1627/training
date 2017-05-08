package gov.georgia.dhr.dfcs.sacwis.web.document;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.log.GrndsTrace;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.utility.Base64;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;

/**
 * DocumentBuilderHelper provides helper methods for converting data into proper xml format.
 * <pre>
 * Change History:
 *  Date      User      Description
 *  --------  --------  --------------------------------------------------
 *  05/12/05  pinkstba  SIR 23567 - Added constructDocumentXml(String documentStr)
 *                      with different signature.  This method will return a narrative
 *                      xml when passed documentStr.
 *  09/28/05  WADESA    SIR 23965 - Added .trim() to get rid of spaces at the end of the
 *                      hiddenSaveString.
 * </pre>
 *
 * @author Barak Pinkston
 */

public class DocumentBuilderHelper {
  public static String constructDocumentXml(HttpServletRequest request) {
    StringBuffer xmlBuf = new StringBuffer(ArchitectureConstants.XML_HEADER);
    try {
      GrndsTrace.msg(TRACE_TAG, 7, "Starting Build of Request XML");
      // start the data element
      xmlBuf.append(TAG_DATA_OPEN);
      // create a buffer for user edits
      StringBuffer userEditsBuf = new StringBuffer(TAG_USER_EDITS_OPEN);
      for (Enumeration en = request.getParameterNames(); en.hasMoreElements();) {
        String requestName = (String) en.nextElement();
        if ("hdnFormInformation".equals(requestName) || "hdnSpellCheckFields".equals(requestName) || "hdnShellMode".equals(requestName)) {
          // do nothing
        } else if ("hdnPrepopulatedBookmarkXML".equals(requestName)) {
          GrndsTrace.msg(TRACE_TAG, 7, "Adding Bookmark Xml");
          //Add the bookmark XML to the document
          String hiddenSaveString = request.getParameter(requestName);
          if (StringHelper.isValid(hiddenSaveString)) {
            // SIR 23965 - added trim()
            String bookmarkXmlString = new String(Base64.decode(hiddenSaveString),
                                                  ArchitectureConstants.CHARACTER_ENCODING).trim();
            GrndsTrace.msg(TRACE_TAG, 7, "Value of bookmark Xml:" + bookmarkXmlString);
            xmlBuf.append(bookmarkXmlString);
          }
        } else {
          userEditsBuf.append(TAG_USER_EDIT_OPEN);
          userEditsBuf.append(TAG_FIELD_NAME_OPEN);
          userEditsBuf.append(requestName);
          userEditsBuf.append(TAG_FIELD_NAME_CLOSE);
          userEditsBuf.append(TAG_FIELD_VALUE_OPEN);
          String requestValue = request.getParameter(requestName);
          String encodedString = Base64.encode(requestValue.getBytes(ArchitectureConstants.CHARACTER_ENCODING));
          userEditsBuf.append(encodedString);
          userEditsBuf.append(TAG_FIELD_VALUE_CLOSE);
          userEditsBuf.append(TAG_USER_EDIT_CLOSE);
        }
      }
      // complete user edits
      userEditsBuf.append(TAG_USER_EDITS_CLOSE);
      // append edits to the xml doc
      xmlBuf.append(userEditsBuf.toString());
      // complete the data element
      xmlBuf.append(TAG_DATA_CLOSE);
    }
    catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception occurred:" + e.getMessage());
    }
    return xmlBuf.toString();
  }

  /* SIR 23567
   * Method constructDocumentXml
   * returns narrative xml when passed documentStr.*/

  public static String constructDocumentXml(String documentStr) {
    StringBuffer xmlBuf = new StringBuffer(ArchitectureConstants.XML_HEADER);
    String narrativeXml = new String();

    try {
      GrndsTrace.msg(TRACE_TAG, 7, "Starting Build of XML");
      // start the data element
      xmlBuf.append(TAG_DATA_OPEN);
      // create a buffer for user edits
      StringBuffer userEditsBuf = new StringBuffer(TAG_USER_EDITS_OPEN);
      userEditsBuf.append(TAG_USER_EDIT_OPEN);
      userEditsBuf.append(TAG_FIELD_NAME_OPEN);
      userEditsBuf.append("txtFullHtml");
      userEditsBuf.append(TAG_FIELD_NAME_CLOSE);
      userEditsBuf.append(TAG_FIELD_VALUE_OPEN);
      userEditsBuf.append(documentStr);
      userEditsBuf.append(TAG_FIELD_VALUE_CLOSE);
      userEditsBuf.append(TAG_USER_EDIT_CLOSE);

      // complete user edits
      userEditsBuf.append(TAG_USER_EDITS_CLOSE);
      // append edits to the xml doc
      xmlBuf.append(userEditsBuf.toString());
      // complete the data element
      xmlBuf.append(TAG_DATA_CLOSE);

      narrativeXml = xmlBuf.toString();
      return narrativeXml;
    }
    catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception occurred:" + e.getMessage());
      return null;
    }//emd try

  }//end  constructDocumentXml(string xx)

  public static final String TRACE_TAG = "DocumentBuilderHelper";

  // Constans for xml constructed by this class
  public static final String TAG_DEF_START = "<?xml version=\"1.0\" encoding=\"windows-1252\" ?>";
  public static final String TAG_DATA_OPEN = "<data>";
  public static final String TAG_DATA_CLOSE = "</data>";
  public static final String TAG_USER_EDITS_OPEN = "<userEdits>";
  public static final String TAG_USER_EDITS_CLOSE = "</userEdits>";
  public static final String TAG_USER_EDIT_OPEN = "<userEdit>";
  public static final String TAG_USER_EDIT_CLOSE = "</userEdit>";
  public static final String TAG_FIELD_NAME_OPEN = "<fieldName>";
  public static final String TAG_FIELD_NAME_CLOSE = "</fieldName>";
  public static final String TAG_FIELD_VALUE_OPEN = "<fieldValue>";
  public static final String TAG_FIELD_VALUE_CLOSE = "</fieldValue>";
  public static final String FIELD_VALUE_PREFILL = "preFillData";

  // No longer used:
  //public static final String IMPACT_NAMESPACE = "http://www.tdprs.state.tx.us";
  //public static final String IMPACT_PREFIX = "IMPACT:";
}
