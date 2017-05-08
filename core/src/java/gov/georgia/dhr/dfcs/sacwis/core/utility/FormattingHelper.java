package gov.georgia.dhr.dfcs.sacwis.core.utility;

import gov.georgia.dhr.dfcs.sacwis.core.validation.exception.DataFormatException;
import gov.georgia.dhr.dfcs.sacwis.core.validation.exception.StringTooLongException;
import gov.georgia.dhr.dfcs.sacwis.core.validation.exception.StringTooShortException;

import java.text.DecimalFormat;
import java.util.StringTokenizer;

/**
 * Helper class consisting of methods that evaluate strings. This includes validation and translations
 *
 * @author Ja'Nien Montank, 4 March 2002
 */
public abstract class FormattingHelper {

  public static final Date MAX_DATE = new Date();

  static {
    MAX_DATE.setTime(DateHelper.MAX_JAVA_DATE);
    MAX_DATE.addDays(-1);
  }

  public static final Date MIN_DATE = new Date(1, 1, 1800);

  public static final int FIRST_NAME_LENGTH = 8;

  public static final int MIDDLE_NAME_LENGTH = 1;

  public static final int LAST_NAME_LENGTH = 14;

  public static final int ARC_SEC_MAX_REGION = 99;

  public static String formatFloat(float f, int decimalPlaces) {
    return formatDouble((double) f, decimalPlaces);
  }

  public static String formatFloat(float f) {
    return formatDouble((double) f, 1);
  }

  public static String formatDouble(Double d) {
    if (d == null) {
      return "";
    }
    return formatDouble(d.doubleValue());
  }

  public static String formatDouble(double d) {
    return formatDouble(d, 1);
  }

  public static String formatDouble(double d, int decimalPlaces) {
    StringBuffer posPattern = new StringBuffer("#0");
    StringBuffer negPattern = new StringBuffer("-#0");
    if (decimalPlaces > 0) {
      posPattern.append(".");
      negPattern.append(".");
    }
    for (int i = 0; i < decimalPlaces; i++) {
      posPattern.append("0");
      negPattern.append("0");
    }
    String pattern = posPattern.toString() + ";" + negPattern.toString();
    DecimalFormat format = new DecimalFormat(pattern);
    return format.format(d);
  }

  public static String initCaps(String input) {
    if (!StringHelper.isValid(input)) {
      return input;
    }
    String trimmedInput = input.trim();
    int trimmedInputLength = trimmedInput.length();
    StringBuffer output = new StringBuffer(trimmedInputLength);
    String firstLetter = trimmedInput.substring(0, 1);
    firstLetter = firstLetter.toUpperCase();
    output.append(firstLetter);
    if (trimmedInputLength > 1) {
      output.append(trimmedInput.substring(1, trimmedInputLength));
    }
    return output.toString();
  }

  public static String initCapsName(String s) {
    if (!StringHelper.isValid(s)) {
      return s;
    }
    return initCaps(s.toLowerCase());
  }

  /**
   * This method takes in a castor type date from the tuxedo service and converts it into a string in the format
   * MM/DD/YYYY.
   *
   * @param cdate The <code>org.exolab.castor.types.Date</code> to be formatted.
   * @return formatted String
   */
  public static String formatDate(org.exolab.castor.types.Date cdate) {
    if (cdate == null) {
      return "";
    }
    java.util.Date utilDate = cdate.toDate();
    Date max = new Date();
    max.setTime(utilDate);
    String formattedDate = new String();
    try {
      if (DateUtility.isOutside(MIN_DATE, MAX_DATE, max, max)) {
        formattedDate = "";
      } else {
        formattedDate = max.format("MM/dd/yyyy");
      }
    } catch (DateAndTimeException e) {
      // Do nothing
    }
    return formattedDate;
  }

  /**
   * This method takes the castor type date from the service and converts it into a string in the format
   * MM/YYYY
   *
   * @param cdate The <code>org.exolab.castor.types.Date</code> to be formatted.
   * @return formatted String
   */
  public static String formatDateMonthYear(org.exolab.castor.types.Date cdate) {
    if (cdate == null) {
      return "";
    }
    java.util.Date utilDate = cdate.toDate();
    Date max = new Date();
    max.setTime(utilDate);
    String formattedDate = new String();
    try {
      if (DateUtility.isOutside(MIN_DATE, MAX_DATE, max, max)) {
        formattedDate = "";
      } else {
        formattedDate = max.format("MM/yyyy");
      }
    } catch (DateAndTimeException e) {
      // Do nothing
    }
    return formattedDate;
  }

  /**
   * This method takes in a java type date from the tuxedo service and converts it into a string in the format
   * MM/YYYY.
   *
   * @param jdate The <code>java.util.Date</code> to be formatted.
   * @return formatted String
   */
  public static String formatDateMonthYear(java.util.Date jdate) {
    if (jdate == null) {
      return "";
    }

    Date max = new Date();
    max.setTime(jdate);
    String formattedDate = "";
    try {
      if (DateUtility.isOutside(MIN_DATE, MAX_DATE, max, max)) {
        formattedDate = "";
      } else {
        formattedDate = max.format("MM/yyyy");
      }
    } catch (DateAndTimeException e) {

    }
    return formattedDate;
  }

  /**
   * This method takes in a java type date from the tuxedo service and converts it into a string in the format
   * MM/DD/YYYY.
   *
   * @param jdate The <code>java.util.Date</code> to be formatted.
   * @return formatted String
   */
  public static String formatDate(java.util.Date jdate) {
    if (jdate == null) {
      return "";
    }

    Date max = new Date();
    max.setTime(jdate);
    String formattedDate = "";
    try {
      if (DateUtility.isOutside(MIN_DATE, MAX_DATE, max, max)) {
        formattedDate = "";
      } else {
        formattedDate = max.format("MM/dd/yyyy");
      }
    } catch (DateAndTimeException e) {

    }
    return formattedDate;
  }

  /**
   * This method takes in a java type date from the tuxedo service and converts it into a string in the format "hh:mm
   * aa"
   *
   * @param jdate The <code>java.util.Date</code> to be formatted.
   * @return formatted String
   */
  public static String formatTime(java.util.Date jdate) {
    if (jdate == null) {
      return "";
    }

    Date max = new Date();
    max.setTime(jdate);
    String formattedTime = "";
    try {
      if (DateUtility.isOutside(MIN_DATE, MAX_DATE, max, max)) {
        formattedTime = "";
      } else {
        formattedTime = max.format("hh:mm aa");
      }
    } catch (DateAndTimeException e) {

    }
    return formattedTime;
  }

  public static String formatDateTime(java.util.Date jdate) {
    if (jdate == null) {
      return "";
    }

    Date max = new Date();
    max.setTime(jdate);
    String formattedDate = "";
    try {
      if (DateUtility.isOutside(MIN_DATE, MAX_DATE, max, max)) {
        formattedDate = "";
      } else {
        formattedDate = max.format("MM/dd/yyyy hh:mm aa");
        //    formattedTime = max.format("hh:mm aa");
      }
    } catch (DateAndTimeException e) {

    }
    return formattedDate;
  }

  public static String formatTimestamp(java.util.Date jdate) {
    if (jdate == null) {
      return "";
    }

    Date max = new Date();
    max.setTime(jdate);
    String formattedDate = "";
    try {
      if (DateUtility.isOutside(MIN_DATE, MAX_DATE, max, max)) {
        formattedDate = "";
      } else {
        formattedDate = max.format("MM/dd/yyyy HH:mm:ss");
        //    formattedTime = max.format("hh:mm aa");
      }
    } catch (DateAndTimeException e) {

    }
    return formattedDate;
  }  
  
  
  /**
   * getRowCss using the row number
   *
   * @param rowNum The current row we're on
   * @return String
   */
  public static String getRowCss(int rowNum) {
    if (rowNum % 2 == 0) {
      return ("even");
    } else {
      return ("odd");
    }

  }

  /**
   * Creates a formatted phone string
   *
   * @param stringValue -
   *                    the string to translate
   * @return formattedPhone - a phone number in "(xxx) xxx-xxxx" format
   */
  public static String formatPhone(String stringValue) {
    if (stringValue == null) {
      return "";
    }
    if (stringValue.length() != 10) {
      return stringValue.toString();
    }

    StringBuffer formattedPhone = new StringBuffer();
    formattedPhone.append("(");
    formattedPhone.append(stringValue.substring(0, 3));
    formattedPhone.append(") ");
    formattedPhone.append(stringValue.substring(3, 6));
    formattedPhone.append("-");
    formattedPhone.append(stringValue.substring(6, 10));

    return formattedPhone.toString();
  }

  /**
   * Takes a formatted phone string and returns 10-digit String Copied from ContextHelper.getPhone
   *
   * @param formattedPhone -
   *                       a phone number in "(xxx) xxx-xxxx" format
   * @return stringValue - the token-stripped phone number string
   */
  public static String decodeFormattedPhoneString(String formattedPhone) {
    if (formattedPhone == null) {
      return null;
    }
    StringBuffer buff = new StringBuffer();
    StringTokenizer strtok = new StringTokenizer(formattedPhone, "()-. ");
    while (strtok.hasMoreTokens()) {
      buff.append(strtok.nextToken());
    }
    return buff.toString();
  }

  /**
   * Creates a formatted Social Security Number string
   *
   * @param stringValue -
   *                    the string to translate
   * @return ssn - a phone number in "xxx-xx-xxxx" format
   */
  public static String formatSSN(String stringValue) {
    if (stringValue == null) {
      return "";
    } else if (stringValue.length() != 9) {
      return stringValue;
    }

    StringBuffer formatedSSN = new StringBuffer();
    formatedSSN.append(stringValue.substring(0, 3));
    formatedSSN.append("-");
    formatedSSN.append(stringValue.substring(3, 5));
    formatedSSN.append("-");
    formatedSSN.append(stringValue.substring(5, 9));

    return formatedSSN.toString();
  }

  /**
   * Designed to help format a JSP so that any null value Strings are displayed as blanks ("") instead of "null".
   * Displays all other values as the string version of the int value.
   *
   * @param input an integer value that is to be displayed on a jsp
   * @return a string that is "" if value is null, the value otherwise
   */
  public static String formatString(String input) {
    String result;
    if (input == null) {
      result = "";
    } else {
      result = input;
    }
    return result;
  }

  /**
   * Designed to help format a JSP so that any zero values are displayed as blanks "" instead of zeros. Displays all
   * other values as the string version of the int value.
   *
   * @param value an integer value that is to be displayed on a jsp
   * @return a string that is "" if value is 0, the string form of value otherwise
   */
  public static String formatInt(int value) {
    String s = "";
    if (value != 0) {
      s = "" + value;
    }
    return s;
  }

  public static String formatLong(Long value) {
    if (value == null) {
      return "";
    }
    return formatLong(value.longValue());
  }

  /**
   * Designed to help format a JSP so that any zero values are displayed as blanks "" instead of zeros. Displays all
   * other values as the string version of the long value.
   *
   * @param value long value that is to be displayed on a jsp
   * @return a string that is "" if value is 0, the string form of value otherwise
   */
  public static String formatLong(long value) {
    String s = "";
    if (value != 0L) {
      s = "" + value;
    }
    return s;
  }

  /**
   * This function will convert the string to a format where the first letter of every word is capitalized while the
   * rest of the letters are lowercase.
   *
   * @param input The <code>java.lang.String</code> to change case on
   * @return a string that Title Case Capitalized
   */
  public static String changeCase(String input) {
    String trimmedInput = input;
    String specialChars = "\', -";

    if (trimmedInput == null || trimmedInput.length() < 1) {
      return "";
    }
    // NOTE: trim here to make sure length of input and length of string
    // buffer is the same
    trimmedInput = trimmedInput.trim();
    // Check to see if we now have an empty string; if so, return
    if (trimmedInput.length() < 1) {
      return "";
    }
    // Lower case the entire string first.
    StringBuffer sbIn = new StringBuffer(trimmedInput.toLowerCase());
    // Upper case the first character
    sbIn.replace(0, 1, String.valueOf(Character.toUpperCase(sbIn.charAt(0))));
    // Find the first instance of a special character
    int iSpecialChar = strpbrk(trimmedInput, specialChars, 0);
    // Loop through special characters until there are no more
    while (iSpecialChar != -1) {
      // If this is 's don't capitalize it.
      if ((sbIn.charAt(iSpecialChar) == '\'')
              && ((iSpecialChar + 1 >= sbIn.length()) || (sbIn.charAt(iSpecialChar + 1) == 's'))
              && ((iSpecialChar + 2 >= sbIn.length()) || (sbIn.charAt(iSpecialChar + 2) == ' '))) {
        // Do not cap. Just skip this special char.
        iSpecialChar++;
      } else {
        // Capitalize the next character
        iSpecialChar++;
        // Upper case the character following the special char.
        // But first check to make sure special character isn't at the end of the String.
        if ((iSpecialChar < sbIn.length()) && (sbIn.charAt(iSpecialChar) != (char) 0)) {
          sbIn
                  .replace(iSpecialChar, iSpecialChar + 1, String.valueOf(Character.toUpperCase(sbIn.charAt(iSpecialChar))));
        }
      }
      // Find the next special char
      iSpecialChar = strpbrk(trimmedInput, specialChars, iSpecialChar);
    }
    // Return the updated string
    return sbIn.toString();
  }

  /**
   * Combines up to the first 14 characters of the last name, a comma, the first 8 of the first name, a space, and the
   * first letter of the middle name to create a full name string that is 25 characters or less
   *
   * @param firstName  The first name
   * @param middleName The middle name
   * @param lastName   The last name
   * @return A <code>java.lang.String</code> of up to 25 characters of the format LAST,FIRST M, where LAST is up to 14
   *         characters of the lastName, FIRST is up to 8 characters of the firstName, and M is the first character of
   *         the middleName.
   */
  public static String formatFullName(String firstName, String middleName, String lastName) {
    StringBuffer fullName = new StringBuffer("");
    // If the last name is not null put the first 14 characters of it
    // it into the buffer
    if ((lastName != null) && (!"".equals(lastName))) {
      if (lastName.length() > LAST_NAME_LENGTH) {
        fullName.append(lastName.substring(0, LAST_NAME_LENGTH));
      } else {
        fullName.append(lastName);
      }
      fullName.append(",");
    }

    // If the first name is not null put the first 8 characters of
    // it into the buffer
    if ((firstName != null) && (!"".equals(firstName))) {
      if (firstName.length() > FIRST_NAME_LENGTH) {
        fullName.append(firstName.substring(0, FIRST_NAME_LENGTH));
      } else {
        fullName.append(firstName);
      }
    }

    // If the middle name is not null the first character
    // put it into the buffer */
    if ((middleName != null) && (!"".equals(middleName))) {
      fullName.append(" ");
      if (middleName.length() > MIDDLE_NAME_LENGTH) {
        fullName.append(middleName.substring(0, MIDDLE_NAME_LENGTH));
      } else {
        fullName.append(middleName);
      }
    }

    // return a full name that is 25 characters or less
    return fullName.toString();
  }

  /**
   * This method will find the first occurrence of the chars in the string starting with the startIndex. Similar to C
   * function with same name.
   *
   * @param string The <code>java.lang.String</code> in which to find the characters
   * @param chars  The <code>java.lang.String</code> of characters to find
   * @return a string that Title Case Capitalized
   */
  private static int strpbrk(String string, String chars, int startIndex) {
    int firstOccurrence = string.length() + 1;
    // Loop through the special chars and find the first occurrence of one in the string
    for (int i = 0; i < chars.length(); i++) {
      int thisOccurrence = string.indexOf((int) chars.charAt(i), startIndex);
      if (thisOccurrence < firstOccurrence && thisOccurrence != -1) {
        firstOccurrence = thisOccurrence;
      }
    }
    // If we haven't found one, return -1
    if (firstOccurrence == string.length() + 1) {
      firstOccurrence = -1;
    }
    return firstOccurrence;
  }

  public static String formatMoney(float money) {
    String dollars = formatDouble((double) money, 2);
    return "$ " + dollars;
  }

  public static String formatMoney(double money) {
    String dollars = formatDouble(money, 2);
    return "$ " + dollars;
  }

  public static String formatStringConvertTabNewLineToString(String inString) {
    if (inString == null) {
      return null;
    }
    StringBuffer outStringBuf = new StringBuffer();
    String newLineChar = "\n";
    String newLineString = "\\n";
    String tabChar = "\t";
    String tabString = "\\t";
    String tokenList = "\n\t";
    StringTokenizer tokenizer = new StringTokenizer(inString, tokenList, true);
    while (tokenizer.hasMoreTokens()) {
      String token = tokenizer.nextToken();
      if (newLineChar.equals(token)) {
        outStringBuf.append(newLineString);
      } else if (tabChar.equals(token)) {
        outStringBuf.append(tabString);
      } else {
        outStringBuf.append(token);
      }
    }
    return outStringBuf.toString();
  }

  public static String formatStringSpecialChars(String inString, String tokenList) {
    if (inString == null) {
      return null;
    }
    StringBuffer outStringBuf = new StringBuffer();
    StringTokenizer tokenizer = new StringTokenizer(inString, tokenList, true);
    while (tokenizer.hasMoreTokens()) {
      String token = tokenizer.nextToken();
      if (tokenList.indexOf(token) >= 0) {
        outStringBuf.append("\\");
      }
      outStringBuf.append(token);
    }
    return outStringBuf.toString();
  }

  public static String formatUserInitials(String userNameParam) {
    String firstInitial = null;
    String middleInitial = null;
    String lastInitial = null;
    if (userNameParam != null) {
      String userName = userNameParam.trim();
      int userNameLength = userName.length();
      if (userNameLength > 0) {
        lastInitial = String.valueOf(userName.charAt(0)).toUpperCase();
        int index = userName.indexOf(",");
        if (index >= 0) {
          // skip spaces after the comma by looping through index
          // noinspection StatementWithEmptyBody
          while (++index < userNameLength && userName.charAt(index) == ' ') {
          }
          if (index < userNameLength) {
            firstInitial = String.valueOf(userName.charAt(index)).toUpperCase();
            // For middle initial, look for a character followed by a period at the end of the string. If we don't
            // find that, meaning that we might have a spelled-out middle name, search for the last space before the
            // end and see if it's not the first initial.
            if (userName.charAt(userNameLength - 1) == '.' && userName.charAt(userNameLength - 2) != ' ') {
              middleInitial = String.valueOf(userName.charAt(userNameLength - 2)).toUpperCase();
            } else {
              int lastIndex = userName.lastIndexOf(" ");
              if (lastIndex > index && lastIndex < userNameLength) {
                middleInitial = String.valueOf(userName.charAt(lastIndex + 1));
              }
            }
          }
        }
      }
    }
    String initials = firstInitial != null ? firstInitial : "";
    initials += middleInitial != null ? middleInitial : "";
    initials += lastInitial != null ? lastInitial : "";
    return initials;
  }

  /**
   * Converts the given region from a possible region/division code to a standardized region code (3 to 2 digits).
   * Replaces ARC_SECConvertRegionCode
   *
   * @param oldRegionCode 3 digit Region Code to convert
   * @return the new, 2 digit region code
   */
  public static String convertRegionCode(String oldRegionCode) throws DataFormatException {

    // Make sure a region was passed in and that is was 3 characters or less.
    if (oldRegionCode == null) {
      throw new StringTooShortException(null, "The Region Code is null");
    }
    if ("".equals(oldRegionCode)) {
      throw new StringTooShortException(null, "The Region Code is blank");
    } else if (oldRegionCode.length() > 3) {
      throw new StringTooLongException(null, "The Region Code is too long: " + oldRegionCode);
    }

    String newRegionCode;
    try {
      // Convert into a numeric value, removes leading 0
      int iRegion = Integer.parseInt(oldRegionCode);

      // if region is > 99, then
      // the converted region code is 99.
      if (iRegion > ARC_SEC_MAX_REGION) {
        iRegion = ARC_SEC_MAX_REGION;
      }

      // Create the standard region code
      newRegionCode = "" + iRegion;
      if (iRegion < 10) {
        newRegionCode = "0" + newRegionCode;
      }
    } catch (NumberFormatException nfe) {
      //We expect there to be a number here nearly all the time.  Therefore, it is fine
      //to use the exception to deal with the unusual case, as the performance penalty
      //is reasonable.  This does violate the "do not use exceptions for flow control rule"
      //but the code using the exception is so much clearer that this way is better.

      //use the state office region for all the divisions that are state wide - the alpha character ones
      newRegionCode = "" + ARC_SEC_MAX_REGION;
    }
    return newRegionCode;
  }

  public static String prepareTextAreaForNarrative(String input) {
    return StringHelper.searchAndReplace(input, "\n", "<br>");
  }

  public static String prepareNarrativeForTextArea(String input) {
    return StringHelper.searchAndReplace(input, "<br>", "\n");
  }

}
