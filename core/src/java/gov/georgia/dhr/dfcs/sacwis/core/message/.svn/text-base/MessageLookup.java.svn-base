package gov.georgia.dhr.dfcs.sacwis.core.message;

// architecture classes

import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;

import java.util.StringTokenizer;

/**
 * <p>Title: </p> <p>Description: </p> <p>Copyright: Copyright (c) 2002</p> <p>Company: </p>
 *
 * @author unascribed
 * @version 1.0
 */

public abstract class MessageLookup {

  public static String getMessageByNumber(String msgNum) {
    if ((msgNum == null) || "".equals(msgNum)) {
      return "";
    }
    try {
      return MessageNumberLookup.getMessage(msgNum);
    }
    catch (Exception e) {
      return "";
    }
  }

  public static String getMessageByNumber(int msgNum) {
    if (msgNum == 0) {
      return "";
    }
    try {
      return MessageNumberLookup.getMessage(msgNum);
    }
    catch (Exception e) {
      return "";
    }
  }

  public static String getPresentationByNumber(String msgNum) {
    if ((msgNum == null) || "".equals(msgNum)) {
      return "";
    }
    try {
      return MessageNumberLookup.getPresentation(msgNum);
    }
    catch (Exception e) {
      return "";
    }
  }

  public static String getPresentationByNumber(int msgNum) {
    if (msgNum == 0) {
      return "";
    }
    try {
      return MessageNumberLookup.getPresentation(msgNum);
    }
    catch (Exception e) {
      return "";
    }
  }

  public static String getSourceByNumber(String msgNum) {
    if ((msgNum == null) || "".equals(msgNum)) {
      return "";
    }
    try {
      return MessageNumberLookup.getSource(msgNum);
    }
    catch (Exception e) {
      return "";
    }
  }

  public static String getSourceByNumber(int msgNum) {
    if (msgNum == 0) {
      return "";
    }
    try {
      return MessageNumberLookup.getSource(msgNum);
    }
    catch (Exception e) {
      return "";
    }
  }

  public static String getNameByNumber(int msgNum) {
    if (msgNum == 0) {
      return "";
    }
    try {
      return MessageNumberLookup.getName(msgNum);
    }
    catch (Exception e) {
      return "";
    }
  }

  public static String getMessageByName(String msgName) {
    if ((msgName == null) || "".equals(msgName)) {
      return "";
    }
    try {
      return MessageNameLookup.getMessage(msgName);
    }
    catch (Exception e) {
      return "";
    }
  }

  public static String getSourceByName(String msgName) {
    if ((msgName == null) || "".equals(msgName)) {
      return "";
    }
    try {
      return MessageNameLookup.getSource(msgName);
    }
    catch (Exception e) {
      return "";
    }
  }

  public static String getPresentationByName(String msgName) {
    if ((msgName == null) || "".equals(msgName)) {
      return "";
    }
    try {
      return MessageNameLookup.getPresentation(msgName);
    }
    catch (Exception e) {
      return "";
    }
  }

  /**
   * Replaces the first %s character sequence in msg with the value in param
   *
   * @param msg   a string message with the %s sequence in it
   * @param param the value to replace %s with
   * @return msg with first occurrance of the %ld sequence replaced by the value of param
   */
  public static String addMessageParameter(String msg, String param) {
    return addMessageParameterLogic(msg, param, "s");
  }

  /**
   * Replaces the first %f character sequence in msg with the value in param; The param is formatted to have the number
   * of decimal places passed in.
   *
   * @param msg           a string message with the %ld sequence in it
   * @param param         the value to replace %ld with
   * @param decimalPlaces the number of decimal places printed out
   * @return msg with first occurrance of the %ld sequence replaced by the value of param
   */
  public static String addMessageParameter(String msg, double param, int decimalPlaces) {
    return addMessageParameterLogic(msg, FormattingHelper.formatDouble(param, decimalPlaces), "f");
  }

  /**
   * Replaces the first %f character sequence in msg with the value in param; The param is formatted to have 1 decimal
   * place.
   *
   * @param msg   a string message with the %ld sequence in it
   * @param param the value to replace %ld with
   * @return msg with first occurrance of the %ld sequence replaced by the value of param
   */
  public static String addMessageParameter(String msg, double param) {
    return addMessageParameterLogic(msg, FormattingHelper.formatDouble(param), "f");
  }

  /**
   * Replaces the first %f character sequence in msg with the value in param; The param is formatted to have 1 decimal
   * place.
   *
   * @param msg           a string message with the %ld sequence in it
   * @param param         the value to replace %ld with
   * @param decimalPlaces the number of decimal places printed out by the value of param
   * @return msg with first occurrance of the %ld sequence replaced
   */
  public static String addMessageParameter(String msg, float param, int decimalPlaces) {
    return addMessageParameterLogic(msg, FormattingHelper.formatFloat(param, decimalPlaces), "f");
  }

  /**
   * Replaces the first %f character sequence in msg with the value in param; The param is formatted to have 2 decimal
   * places.
   *
   * @param msg   a string message with the %ld sequence in it
   * @param param the value to replace %ld with
   * @return msg with first occurrance of the %ld sequence replaced by the value of param
   */
  public static String addMessageParameter(String msg, float param) {
    return addMessageParameterLogic(msg, FormattingHelper.formatFloat(param), "f");
  }

  /**
   * Replaces the first %ld character sequence in msg with the value in param
   *
   * @param msg   a string message with the %ld sequence in it
   * @param param the value to replace %ld with
   * @return msg with first occurrance of the %ld sequence replaced by the value of param
   */
  public static String addMessageParameter(String msg, int param) {
    return addMessageParameterLogic(msg, "" + param, "ld");
  }

  /**
   * Partially models sprintf, in that it replaces %s or %ld with a parameter passed to it. Ideally this would be a full
   * sprintf, but right now, it indescriminately replaces a % and characters following % with param, iff the characters
   * following % match the conversion parameter.
   *
   * @param msg        the message text with the escape sequences in it
   * @param param      the string to replace the conversion character
   * @param conversion the conversion sequence that follows the % sign
   * @return a String that represents the %<conversion> replaced by param in the msg
   */
  protected static String addMessageParameterLogic(String msg,
                                                   String param,
                                                   String conversion) {
    String outputMsg = "";
    if ((msg == null) || "".equals(msg)) {
      return "";
    }

    StringTokenizer strTok = new StringTokenizer(msg, "%", true);
    if ((param == null) || "".equals(param) ||
        (conversion == null) || "".equals(conversion) ||
        (strTok.countTokens() < 2)
            ) {
      return msg;
    }

    int conversionLength = conversion.length();
    boolean inserted = false;
    while (strTok.hasMoreTokens()) {
      String token = strTok.nextToken();
      if ((token.charAt(0) == '%') && !inserted && (strTok.hasMoreTokens())) {
        token = strTok.nextToken();
        if (token.regionMatches(0, conversion, 0, conversionLength)) {
          inserted = true;
          token = token.substring(conversionLength);
          outputMsg += param;
          outputMsg += token;
        } else {
          outputMsg += "%" + token;
        }
      } else {
        outputMsg += token;
      }
    }
    return outputMsg;
  }
}