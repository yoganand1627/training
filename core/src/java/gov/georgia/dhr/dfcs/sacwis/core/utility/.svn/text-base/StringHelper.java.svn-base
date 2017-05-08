package gov.georgia.dhr.dfcs.sacwis.core.utility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
* Date        User      Description
* --------    --------  --------------------------------------------------
* 07/24/2005  werlem    SIR 23728 - MPS Phase II Enhancement to add Contact List and Detail to MPS.
 */

/**
 * Helper class consisting of methods that evaluate strings. This includes validation and translations
 * <pre>
 *   Change History:
 *   Date      User      Description
 *   --------  --------  --------------------------------------------------
 *   3/31/09  wjcochran  Added isEmptyOrNull, isNotEmptyOrNull, isZero, and
 *                       isNotZero functions
 *   9/15/11  htvo       Added toBooleanString(boolean b) to translate true to "true", false to "false", 
 *                       and neither to ""
 *                       Added isTrueString to determine if a string is part of the positive set
 * </pre>
 *
 * @author Ja'Nien Montank, 4 March 2002
 */
public abstract class StringHelper {
  public static final String BOOLEAN_TRUE = "Y";
  public static final String BOOLEAN_FALSE = "N";

  public static final String EMPTY_STRING = "";

  private static final Set<String> positiveSet =
          new HashSet<String>(Arrays.asList(new String[] {"yes", "y", "true", "on"}));

  private static final String ZERO = "0";

  /**
   * Creates an Integer from a string value
   *
   * @param stringValue - the string to translate
   * @return Integer - a numerical value equal to the passed in string
   */
  public static Integer toInteger(String stringValue) {
    Integer integerValue = null;
    if (stringValue != null) {
      String trimmedString = stringValue.trim();

      // checks that string is not empty
      if (trimmedString.length() > 0) {
        integerValue = new Integer(trimmedString);
      }
    }
    return integerValue;
  }

  /**
   * Creates a Double from a String value
   *
   * @param stringValue - the string to translate
   * @return Double - a numerical value equal to the passed in string
   */
  public static Double toDouble(String stringValue) {
    Double doubleValue = null;
    if (stringValue != null) {
      String trimmedString = stringValue.trim();

      // checks that string is not empty
      if (trimmedString.length() > 0) {
        doubleValue = new Double(trimmedString);
      }
    }
    return doubleValue;
  }

  /**
   * Checks to see if a given string is valid. This includes checking that the string is not null or empty.
   *
   * @param value - the string that is being evaluated
   * @return boolean - whether the string is valid
   */
  public static boolean isValid(String value) {
    if (value == null) {
      return false;
    }
    String trimmedString = value.trim();
    return (trimmedString.length() > 0);
  }

  /**
   * Checks to see if a given string is boolean true. This includes checking that the string is not null or empty.
   *
   * @param value - the string that is being evaluated
   * @return boolean - whether the string is true
   */
  public static boolean isTrue(String value) {
    if (isValid(value)) {
      return positiveSet.contains(value.trim().toLowerCase());
    } else {
      return false;
    }
  }

  /**
   * Creates a string from an object
   *
   * @param objectValue - object to be translated
   * @return String - string value equal to the passed in object
   */
  public static String castToString(Object objectValue) {
    String stringValue = null;
    if (objectValue != null) {
      stringValue = (String) objectValue;
    }

    return stringValue;
  }

  /**
   * Helper method that decides if two fields are the same - equal or both null.
   *
   * @param thisString     the first String to be compared
   * @param comparedString the second string to be compared
   * @return true if the two Strings are equal or both null
   */
  public static boolean checkForEquality(String thisString, String comparedString) {
    boolean result;
    if (thisString == null) {
      if (comparedString == null) {
        result = true;
      } else {
        result = false;
      }
    } else {
      result = thisString.equals(comparedString);
    }
    return result;
  }

  /**
   * This method is used to make sure a string is not blank ("").  If a non-blank value is received, it is returned as
   * is. If a null value or blank value is received, a null String is returned.
   *
   * @param value - the string that is being evaluated
   * @return String - either valid value (not blank) or null
   */
  public static String getSafeString(String value) {
    if ((value == null) || (value.equals(EMPTY_STRING))) {
      return null;
    }
    return value;
  }

  /**
   * This method is used to make sure a string is not null.  If a non-null value is received, it is returned as is. If a
   * null value value is received, a blank ("") String is returned.
   *
   * @param value - the string that is being evaluated
   * @return String - either valid value (not null) or blank ("")
   */
  public static String getNonNullString(String value) {
    if ((value == null) || (value.equals(EMPTY_STRING))) {
      return EMPTY_STRING;
    }
    return value;
  }

  /**
   * Deletes spaces within a String
   *
   * @param value - the string to translate
   * @return String - a string value without any spaces
   */
  public static String removeSpaces(String value) {
    StringBuffer stringValue = new StringBuffer(value);
    int deletedCharacters = 0;
    int i = -1;
    String spaceValue = " ";
    while (true) {
      //index of the original String
      i = value.indexOf(spaceValue, i + 1);
      //insures that index is not out of bounds
      if (i < 0) {
        break;
      } else {
        //index of the StringBuffer
        stringValue.deleteCharAt(i - deletedCharacters);
        deletedCharacters++;
      }
    }
    return stringValue.toString();
  }

  /**
   * Returns a Boolean == Boolean.TRUE if the String parameter == "Y", Boolean == Boolean.FALSE if the String parameter
   * == "N", and a null Boolean otherwise.
   *
   * @param yORn A string valued "Y" or "N" for good results, other values give null results
   * @return Boolean a Boolean valued Boolean.TRUE if the parameter was "Y", Boolean.FALSE if the parameter was "N", and
   *         null otherwise
   */
  public static Boolean toBooleanOrNull(String yORn) {
    Boolean bool = null;
    if (yORn.equals(BOOLEAN_TRUE)) {
      bool = true;
    } else if (yORn.equals(BOOLEAN_FALSE)) {
      bool = false;
    }

    return bool;
  }

  /**
   * Returns a boolean == true if the String parameter == "Y", boolean == false otherwise.
   *
   * @param yORn A string valued "Y" for true, other values for false
   * @return a boolean valued true if the parameter was "Y", false if the parameter was any other value
   * @throws IllegalArgumentException if the parameter was not a "Y" or an "N"
   */
  public static boolean toBoolean(String yORn) throws IllegalArgumentException {
    boolean bool;
    if (yORn == null) {
      throw new IllegalArgumentException("The string you passed to toBoolean was null.");
    }

    if (yORn.equals(BOOLEAN_TRUE)) {
      bool = true;
    } else if (yORn.equals(BOOLEAN_FALSE)) {
      bool = false;
    } else {
      throw new IllegalArgumentException("The string you passed to toBoolean was not a legal \"" + BOOLEAN_TRUE +
                                         "\" or \"" + BOOLEAN_FALSE + "\" value: " + yORn);
    }
    return bool;
  }

  /**
   * Returns a boolean == true if the String parameter == "Y", boolean == false otherwise.
   *
   * @param yORn A string valued "Y" for true, other values for false
   * @return a boolean valued true if the parameter was "Y", false if the parameter was any other value
   */
  public static boolean toBooleanSafe(String yORn) {
    boolean bool;
    try {
      bool = StringHelper.toBoolean(yORn);
    }
    catch (Exception e) {
      bool = false;
    }
    return bool;
  }

  /**
   * Returns a String valued "Y" of the boolean bool is true and "N" if bool is false.
   *
   * @param bool The value to convert
   * @return "Y" if the parameter is true, "N" if the parameter is false
   */
  public static String toYorN(boolean bool) {
    if (bool) {
      return BOOLEAN_TRUE;
    } else {
      return BOOLEAN_FALSE;
    }
  }

  /**
   * Returns a String valued "Y" of the Boolean bool==Boolean.TRUE is true and "N" if bool==BOOLEAN is false. If the
   * Boolean bool == null, returns "".
   *
   * @param bool The value to convert
   * @return "Y" if the parameter is Boolean.TRUE, "N" if the parameter is Boolean.FALSE, "" if it is null.
   */
  public static String toYorN(Boolean bool) {
    if (bool == null) {
      return EMPTY_STRING;
    }
    return Boolean.TRUE.equals(bool) ? BOOLEAN_TRUE : BOOLEAN_FALSE;
  }

  /**
   * Returns a copy of the array parameter with all the duplicates removed. The array does not have to be sorted for
   * this method to work. Complites in o(N) time.
   *
   * @param inArray an array of Strings with possible duplicate elements.
   * @return an array with only the first of any duplicate values.
   */
  private static List<String> removeDuplicatesLogic(String[] inArray) {
    Map<String, String> hmap = new HashMap<String, String>();
    List<String> outVector = new ArrayList<String>();

    // iterate through the array
    for (int i = 0; i < inArray.length; i++) {
      String s = inArray[i];
      String key = hmap.get(s);

      // if it does not exist in the hashmap,
      // then add it to the vector and the hashmap
      if (key == null) {
        outVector.add(s);
        hmap.put(s, s);
      }

      // if it is in the hashmap, ignore it
      else {
        // do nothing
      }
    }
    return outVector;
  }

  public static List<String> removeDuplicates(List<String> inVector) {
    String[] inArray = new String[1];
    inArray = inVector.toArray(inArray);
    return StringHelper.removeDuplicatesLogic(inArray);
  }

  public static String[] removeDuplicates(String[] inArray) {
    List<String> outVector = StringHelper.removeDuplicatesLogic(inArray);
    String[] outArray = new String[1];
    outArray = outVector.toArray(outArray);
    return outArray;
  }

  public static String searchAndReplace(String input, String searchFor, String replaceWith) {
    StringBuffer output = new StringBuffer(input);
    int index = output.indexOf(searchFor);
    while (index != -1) {
      output.replace(index, index + searchFor.length(), replaceWith);
      index = output.indexOf(searchFor);
    }
    return output.toString();
  }

  public static String truncate(String string, int maxLength) {
    if (string == null) {
      return null;
    }
    if (string.length() <= maxLength) {
      return string;
    }
    return string.substring(0, maxLength);
  }

  public static int countChar(String string, String searchValue) {
    int i = 0;
    int index = 0;
    do {
      index = string.indexOf(searchValue, index);
      if (index != -1) {
        i++;
        index++;
      }
    }
    while (index != -1) ;
    return i;
  }

  /**
   * Determines if an object is empty or null
   * @param o - any object that requires null/empty testing
   * @return true if object is empty or null, false otherwise
   */
  public static boolean isEmptyOrNull(Object o) {
    if (o == null) {
      return true;
    } else if (o.getClass() == String.class) {
      o = (String) o;
      if (StringHelper.EMPTY_STRING.equals(o) || o == null) {
        return true;
      }
    } else if (List.class.isInstance(o)) {
      List<?> l = (List<?>) o;
      if (l.size() == 0) {
        return true;
      }
    } else {
      if (o == null) {
        return true;
      }
    }
    
    return false;
  }
  
  /**
   * Determines if an object is not empty or not null
   * @param o - any object that requires null/empty testing
   * @return false if object is empty or null, true otherwise
   */
  public static boolean isNotEmptyOrNull(Object o) {
    
    return !isEmptyOrNull(o);
  }
  
  /**
   * Determines if an object is of a zero value
   * @param o - any object that can contain '0'
   * @return true if object is equal to zero, false otherwise
   */
  public static boolean isZero(Object o) {
    if (o.getClass() == String.class) {
      o = (String) o;
      if (ZERO.equals(o)) {
        return true;
      }
    } else if (o.getClass() == Integer.class) {
      o = (Integer) o;
      if (Integer.valueOf(ZERO).equals(o)) {
        return true;
      }
    }
    
    return false;
  }
  
  /**
   * Determines if an object is not of a zero value
   * @param o - any object that can contain '0'
   * @return false if object is equal to zero, true otherwise
   */
  public static boolean isNotZero(Object o) {
    return !isZero(o);
  }
  
  /**
   * return string "true" if the boolean parameter value is true; else false
   * @param b
   * @return
   */
  public static String toBooleanString(boolean b) {
    if (b) 
      return "true";
    return "false";
  }
  
  /**
   * 
   * 
   * @param yORn
   * @return 
   * return the string "true" if the string parameter value is "Y"
   * return the string "false" if the string parameter value is "N"
   * return the empty string if the string parameter value is neither "Y" or "N"
   * throws error if string parameter is null
   */
  public static String toBooleanStringSafe(String yORn) {
    try {
      return toBooleanString(StringHelper.toBoolean(yORn));
    }
    catch (Exception e) {
      return EMPTY_STRING;
    }
  }
  
  /**
   * Checks to see if a given string is boolean true. This includes checking that the string is not null or empty.
   *
   * @param value - the string that is being evaluated
   * @return boolean - whether the string is true
   */
  public static String isTrueString(String value) {
    if (isValid(value) && positiveSet.contains(value.trim().toLowerCase())) {
      return "true";
    } else {
      return "false";
    }
  }
} 