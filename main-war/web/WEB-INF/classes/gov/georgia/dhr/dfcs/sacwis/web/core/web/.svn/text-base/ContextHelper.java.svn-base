package gov.georgia.dhr.dfcs.sacwis.web.core.web;

import java.text.ParseException;
import java.util.Date;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

import gov.georgia.dhr.dfcs.sacwis.core.exception.BasePrsException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.InformationalPrsException;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.URLHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.ServerSideValidationUtility;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.ValidationPatternMatcher;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TimeTag;

public class ContextHelper {
  private ContextHelper() {
    // prevents instantiation
  }

  /**
   * This method returns true or false based on whether or not a specific key was in the request; it does not require
   * that the parameter have a value.
   *
   * @param request The current <tt>HttpServletRequest</tt> object.
   * @param name    The name of the parameter.
   * @return true if the parameter was in the request; false if it was not
   */
  public static boolean isParameterPresent(HttpServletRequest request, String name) {
    Map parameterMap = request.getParameterMap();
    return parameterMap.containsKey(name);
  }

  /**
   * Returns the URL from which the last request was called.  Note that this should <i>only</i> be used to forward back
   * to the calling URL.  It should <b>not</b> be used for determining general page logic.
   *
   * @param context The <tt>GrndsExchangeContext</tt> object associated with the request
   * @return url The URL from which the request was called
   */
  public static String getPreviousUrl(GrndsExchangeContext context) {
    return getStringSafe(context, ServerSideValidationUtility.FORM_VALIDATION_PREV_URL);
  }

  /**
   * Returns the URL from which the last request was called.  Note that this should <i>only</i> be used to forward back
   * to the calling URL.  It should <b>not</b> be used for determining general page logic.
   *
   * @param request The <tt>HttpServletRequest</tt> object associated with the request
   * @return url The URL from which the request was called
   */
  public static String getPreviousUrl(HttpServletRequest request) {
    return getStringSafe(request, ServerSideValidationUtility.FORM_VALIDATION_PREV_URL);
  }

  public static String getString(GrndsExchangeContext context, String parmName) {
    HttpServletRequest request = context.getRequest();
    return getString(request, parmName);
  }

  public static String getStringSafe(GrndsExchangeContext context, String parmName) {
    HttpServletRequest request = context.getRequest();
    return getStringSafe(request, parmName);
  }

  public static String getStringSafe(HttpServletRequest request, String parmName) {
    String s = request.getParameter(parmName);
    if (s == null) {
      return "";
    }
    s = s.trim();
    if ("null".equals(s)) {
      return "";
    }
    return s;
  }

  public static String getString(HttpServletRequest request, String parmName) {
    String s = request.getParameter(parmName);
    if (s != null) {
      s = s.trim();
    }
    return s;
  }

  public static String getPhone(HttpServletRequest request, String phoneName) throws NumberFormatException {
    String phone = request.getParameter(phoneName);
    if (phone == null) {
      return null;
    }
    StringBuffer buff = new StringBuffer();
    StringTokenizer strtok = new StringTokenizer(phone, "()-. ");
    while (strtok.hasMoreTokens()) {
      buff.append(strtok.nextToken());
    }
    return buff.toString();
  }

  public static String getPhone(GrndsExchangeContext context, String phoneName) {
    HttpServletRequest request = context.getRequest();
    return getPhone(request, phoneName);
  }

  public static String getPhoneSafe(HttpServletRequest request, String phoneName) {
    String phone;
    try {
      phone = getPhone(request, phoneName);
      if (phone == null) {
        phone = "";
      } else if (phone.length() != PHONE_LENGTH) {
        phone = "";
      }
    }
    catch (NumberFormatException e) {
      phone = "";
    }
    return phone;
  }

  public static String getPhoneSafe(GrndsExchangeContext context, String phoneName) {
    HttpServletRequest request = context.getRequest();
    return getPhoneSafe(request, phoneName);
  }

  public static String getSSN(HttpServletRequest request, String ssnName) throws NumberFormatException {
    String ssn = request.getParameter(ssnName);
    String outputSSN = null;
    if (ssn != null) {
      if (((ssn.length() == SSN_LENGTH) && (ssn.charAt(3) == '-') && (ssn.charAt(6) == '-'))) {
        outputSSN = ssn;
      } else if (ssn.length() == SSN_LENGTH_NO_DASHES) {
        outputSSN = FormattingHelper.formatSSN(ssn);
      }
    }
    return outputSSN;
  }

  public static String getSSN(GrndsExchangeContext context, String ssnName) {
    HttpServletRequest request = context.getRequest();
    return getSSN(request, ssnName);
  }

  public static String getSSNSafe(HttpServletRequest request, String ssnName) {
    String ssn;
    try {
      ssn = getSSN(request, ssnName);
      if (ssn == null) {
        ssn = "";
      } else if (ssn.length() != SSN_LENGTH) {
        ssn = "";
      }
    }
    catch (NumberFormatException e) {
      ssn = "";
    }
    return ssn;
  }

  public static String getSSNSafe(GrndsExchangeContext context, String ssnName) {
    HttpServletRequest request = context.getRequest();
    return getSSNSafe(request, ssnName);
  }

  public static int getIntSafe(HttpServletRequest request, String parmName) {
    int i;
    try {
      String strI = request.getParameter(parmName);
      strI = strI.trim();
      i = Integer.parseInt(strI);
    }
    catch (Exception e) {
      i = 0;
    }
    return i;
  }

  public static int getInt(HttpServletRequest request, String parmName) throws InformationalPrsException {
    int i;
    try {
      i = Integer.parseInt(request.getParameter(parmName));
    }
    catch (NullPointerException npe) {
      throw new InformationalPrsException("Parameter \"" + parmName + "\" was not in the available in this context.",
                                          npe, BasePrsException.CRITICAL_PRIORITY);
    }
    catch (NumberFormatException nfe) {
      throw new InformationalPrsException("Parameter \"" + parmName + "\" is not a properly formatted number.", nfe,
                                          BasePrsException.CRITICAL_PRIORITY);
    }
    return i;
  }

  public static long getLongSafe(HttpServletRequest request, String parmName) {
    long i;
    try {
      i = Long.parseLong(request.getParameter(parmName));
    }
    catch (Exception e) {
      i = 0;
    }
    return i;
  }

  public static long getLong(HttpServletRequest request, String parmName) throws InformationalPrsException {
    long i;
    try {
      i = Long.parseLong(request.getParameter(parmName));
    }
    catch (NullPointerException npe) {
      throw new InformationalPrsException("Parameter \"" + parmName + "\" was not in the available in this context.",
                                          npe, BasePrsException.CRITICAL_PRIORITY);
    }
    catch (NumberFormatException nfe) {
      throw new InformationalPrsException("Parameter \"" + parmName + "\" is not a properly formatted number.", nfe,
                                          BasePrsException.CRITICAL_PRIORITY);
    }
    return i;
  }

  public static boolean getBooleanSafe(GrndsExchangeContext context, String parmName) {
    HttpServletRequest request = context.getRequest();
    return getBooleanSafe(request, parmName);
  }

  public static boolean getBooleanSafe(HttpServletRequest request, String parmName) {
    try {
      return getBoolean(request, parmName);
    }
    catch (Exception e) {
      return false;
    }
  }

  public static boolean getBoolean(GrndsExchangeContext context, String parmName) throws InformationalPrsException {
    HttpServletRequest request = context.getRequest();
    return getBoolean(request, parmName);
  }

  public static boolean getBoolean(HttpServletRequest request, String parmName) throws InformationalPrsException {
    boolean bool;
    try {
      String boolString = request.getParameter(parmName);
      if ("true".equals(boolString)) {
        bool = true;
      } else if ("false".equals(boolString)) {
        bool = false;
      } else {
        throw new InformationalPrsException(
                "Parameter \"" + parmName + "\" was not a properly formatted boolean: " + boolString,
                BasePrsException.CRITICAL_PRIORITY);
      }
    }
    catch (NullPointerException npe) {
      throw new InformationalPrsException("Parameter \"" + parmName + "\" was not in the available in this context.",
                                          npe, BasePrsException.CRITICAL_PRIORITY);
    }
    return bool;
  }

  public static int getUlIdPerson(HttpServletRequest request) throws InformationalPrsException {
    return getInt(request, "ulIdPerson");
  }

  public static int getUlIdPersonSafe(HttpServletRequest request) {
    return getIntSafe(request, "ulIdPerson");
  }

  public static int getUlIdPerson(GrndsExchangeContext context) throws InformationalPrsException {
    return getUlIdPerson(context.getRequest());
  }

  public static int getUlIdPersonSafe(GrndsExchangeContext context) {
    return getUlIdPersonSafe(context.getRequest());
  }

  public static int getInt(GrndsExchangeContext context, String parmName) throws InformationalPrsException {
    return getInt(context.getRequest(), parmName);
  }

  public static int getIntSafe(GrndsExchangeContext context, String parmName) {
    return getIntSafe(context.getRequest(), parmName);
  }

  public static long getLong(GrndsExchangeContext context, String parmName) throws InformationalPrsException {
    return getLong(context.getRequest(), parmName);
  }

  public static long getLongSafe(GrndsExchangeContext context, String parmName) {
    return getLongSafe(context.getRequest(), parmName);
  }

  public static String getUrlDecodeSafe(HttpServletRequest request, String parmName) {
    GrndsTrace.enterScope(TRACE_TAG + ".getUrlDecodeSafe()");
    String data;
    try {
      data = request.getParameter(parmName);
      data = URLHelper.decode(data);
    }
    catch (NullPointerException npe) {
      GrndsTrace.msg(TRACE_TAG + ".getUrlDecodeSafe()", 7, BasePrsException.getStackTrace(npe));
      data = "";
    }
    catch (ClassCastException cce) {
      GrndsTrace.msg(TRACE_TAG + ".getUrlDecodeSafe()", 7, BasePrsException.getStackTrace(cce));
      data = "";
    }
    catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG + ".getUrlDecodeSafe()", 7, BasePrsException.getStackTrace(e));
      data = "";
    }
    GrndsTrace.exitScope();
    return data;
  }

  public static String getUrlDecodeSafe(GrndsExchangeContext context, String parmName) {
    return getUrlDecodeSafe(context.getRequest(), parmName);
  }

  public static Date getJavaDate(HttpServletRequest request, String dateName) throws ParseException {
    String dtSt = request.getParameter(dateName);
    return DateHelper.toJavaDate(dtSt);
  }

  public static Date getJavaDate(GrndsExchangeContext context, String dateName) throws ParseException {
    HttpServletRequest request = context.getRequest();
    return getJavaDate(request, dateName);
  }

  public static Date getJavaDateSafe(HttpServletRequest request, String dateName) {
    String dtSt = request.getParameter(dateName);
    return DateHelper.toJavaDateSafe(dtSt);
  }

  public static Date getJavaDateSafe(GrndsExchangeContext context, String dateName) {
    HttpServletRequest request = context.getRequest();
    return getJavaDateSafe(request, dateName);
  }

  public static org.exolab.castor.types.Date getCastorDate(HttpServletRequest request, String dateName)
          throws ParseException {
    String dtSt = request.getParameter(dateName);
    return DateHelper.toCastorDate(dtSt);
  }

  public static org.exolab.castor.types.Date getCastorDate(GrndsExchangeContext context, String dateName)
          throws ParseException {
    HttpServletRequest request = context.getRequest();
    return getCastorDate(request, dateName);
  }

  public static org.exolab.castor.types.Date getCastorDateSafe(HttpServletRequest request, String dateName) {
    String dtSt = request.getParameter(dateName);
    return DateHelper.toCastorDateSafe(dtSt);
  }

  public static org.exolab.castor.types.Date getCastorDateSafe(GrndsExchangeContext context, String dateName) {
    HttpServletRequest request = context.getRequest();
    return getCastorDateSafe(request, dateName);
  }

  public static String getTime(GrndsExchangeContext context, String timeName) throws ParseException {
    HttpServletRequest request = context.getRequest();
    return ContextHelper.getTime(request, timeName);
  }

  public static String getTime(HttpServletRequest request, String timeName) throws ParseException {
    String time = request.getParameter(timeName);
    String ampm = request.getParameter("sel" + timeName);
    // Added 5/21/2003 SPB
    return TimeTag.getCorrectTimeString(time, ampm);
  }

  public static String getTimeSafe(HttpServletRequest request, String timeName) {
    try {
      String time = ContextHelper.getTime(request, timeName);
      if (time == null) {
        return "";
      }
      return time;
    }
    catch (Exception e) {
      return "";
    }
  }

  public static String getTimeSafe(GrndsExchangeContext context, String timeName) {
    HttpServletRequest request = context.getRequest();
    return ContextHelper.getTimeSafe(request, timeName);
  }

  public static double getDoubleSafe(GrndsExchangeContext context, String parmName) {
    return getDoubleSafe(context.getRequest(), parmName);
  }

  public static double getDouble(GrndsExchangeContext context, String parmName) throws InformationalPrsException {
    return getDouble(context.getRequest(), parmName);
  }

  public static double getDoubleSafe(HttpServletRequest request, String parmName) {
    double doubleVal;
    try {
      doubleVal = getDouble(request, parmName);
    }
    catch (Exception e) {
      //e.printStackTrace();
      doubleVal = 0.0;
    }
    return doubleVal;
  }

  public static double getDouble(HttpServletRequest request, String parmName) throws InformationalPrsException {
    double doubleVal;
    try {
      doubleVal = Double.parseDouble(request.getParameter(parmName));

    }
    catch (NullPointerException npe) {
      throw new InformationalPrsException("Parameter \"" + parmName + "\" was not in the available in this context.",
                                          npe, BasePrsException.CRITICAL_PRIORITY);
    }
    catch (NumberFormatException nfe) {
      throw new InformationalPrsException("Parameter \"" + parmName + "\" is not a properly formatted double.", nfe,
                                          BasePrsException.CRITICAL_PRIORITY);
    }
    return doubleVal;
  }

  public static float getFloatSafe(GrndsExchangeContext context, String parmName) {
    return getFloatSafe(context.getRequest(), parmName);
  }

  public static float getFloat(GrndsExchangeContext context, String parmName) throws InformationalPrsException {
    return getFloat(context.getRequest(), parmName);
  }

  public static float getFloatSafe(HttpServletRequest request, String parmName) {
    float floatVal;
    try {
      floatVal = getFloat(request, parmName);
    }
    catch (Exception e) {
      //e.printStackTrace();
      floatVal = 0;
    }
    return floatVal;
  }

  public static float getFloat(HttpServletRequest request, String parmName) throws InformationalPrsException {
    float floatVal;
    try {
      floatVal = Float.parseFloat(request.getParameter(parmName));
    }
    catch (NullPointerException npe) {
      throw new InformationalPrsException("Parameter \"" + parmName + "\" was not in the available in this context.",
                                          npe, BasePrsException.CRITICAL_PRIORITY);
    }
    catch (NumberFormatException nfe) {
      throw new InformationalPrsException("Parameter \"" + parmName + "\" is not a properly formatted float.", nfe,
                                          BasePrsException.CRITICAL_PRIORITY);
    }
    return floatVal;
  }

  public static float getMoneyAsFloatSafe(GrndsExchangeContext context, String parmName) {
    return getMoneyAsFloatSafe(context.getRequest(), parmName);
  }

  public static float getMoneyAsFloat(GrndsExchangeContext context, String parmName) {
    return getMoneyAsFloat(context.getRequest(), parmName);
  }

  public static float getMoneyAsFloatSafe(HttpServletRequest request, String parmName) {
    float floatVal;
    try {
      floatVal = getMoneyAsFloat(request, parmName);
    }
    catch (Exception e) {
      //e.printStackTrace();
      floatVal = 0;
    }
    return floatVal;
  }

  public static float getMoneyAsFloat(HttpServletRequest request, String parmName) {
    //parse off $ or $[space] and then convert to float
    String input = request.getParameter(parmName);
    input = ContextHelper.regExpEngine.substitute(ContextHelper.MONEY_REG_EXPR, input);
    return Float.parseFloat(input);
  }

  public static double getMoneyAsDoubleSafe(GrndsExchangeContext context, String parmName) {
    return getMoneyAsDoubleSafe(context.getRequest(), parmName);
  }

  public static double getMoneyAsDouble(GrndsExchangeContext context, String parmName) throws ParseException {
    return getMoneyAsDouble(context.getRequest(), parmName);
  }

  public static double getMoneyAsDoubleSafe(HttpServletRequest request, String parmName) {
    double doubleVal;
    try {
      doubleVal = getMoneyAsDouble(request, parmName);
    }
    catch (Exception e) {
      //e.printStackTrace();
      doubleVal = 0;
    }
    return doubleVal;
  }

  public static double getMoneyAsDouble(HttpServletRequest request, String parmName) throws ParseException {
    //parse off $ or $[space] and then convert to float
    String input = request.getParameter(parmName);
    if (StringHelper.isValid(input)) {
      input = ContextHelper.regExpEngine.substitute(ContextHelper.MONEY_REG_EXPR, input);
    } else {
      throw new ParseException("Specified value is null or blank.", 1);
    }
    return Double.parseDouble(input);
  }

  public static final String TRACE_TAG = "ContextHelper";
  public static final int PHONE_LENGTH = 10;
  public static final int SSN_LENGTH = 11;
  public static final int SSN_LENGTH_NO_DASHES = 9;
  public static final String MONEY_REG_EXPR = "s/\\$?,? *//g";
  public static ValidationPatternMatcher regExpEngine = ValidationPatternMatcher.getInstance("ContextHelper");
}
