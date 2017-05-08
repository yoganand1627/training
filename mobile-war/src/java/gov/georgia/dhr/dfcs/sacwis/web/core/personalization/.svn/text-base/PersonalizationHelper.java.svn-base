package gov.georgia.dhr.dfcs.sacwis.web.core.personalization;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

/** This class is made up of static helper methods that many of the personalization tags use. */
public class PersonalizationHelper {
  /**
   * This method will parse a comma-delimited String into a List of String values.  The values will be "trimmed" such
   * that any whitespace at the start of end of the values will be removed.
   *
   * @param value The String to parse into a list.
   * @return List The parsed list of Strings.
   */
  static List parseCriteria(String value) {
    List parsedCriteria = new ArrayList();

    StringTokenizer tokens = new StringTokenizer(value, ",", false);

    while (tokens.hasMoreTokens()) {
      //Get the token, trim off any spaces the user may have left between items on the list
      String thisToken = tokens.nextToken().trim();
      parsedCriteria.add(thisToken);
    }
    return parsedCriteria;
  }

  /**
   * This method will check to see if a String value from the first Collection given is in the second Collection.  It
   * will iterate through the list and use the contains() method on the Collection to see if the value from the list
   * exists in the collection.  Once an in-common item is found it will stop checking values and return true.
   *
   * @param valuesToFind  The list to iterate through.
   * @param valuesToCheck The collection to use the contains() method on for each item in the valuesToFind list.
   * @return boolean Whether or not a value from the list was found in the Collection.
   */
  static boolean findCommonStringInCollections(Collection valuesToFind,
                                               Collection valuesToCheck) {
    Iterator values = valuesToFind.iterator();
    boolean hasMatch = false;

    while (values.hasNext() && !hasMatch) {
      String value = (String) values.next();
      hasMatch = valuesToCheck.contains(value);
    }

    return hasMatch;
  }

  /**
   * This method will check to see if a String value from the first Collection given is in the Set collection.  It
   * simply uses the functionality of the findCommonStringInCollections() method, however, by using this method we make
   * sure that the optimal search algorithm is used.
   *
   * @param tagValues  The Collection to iterate through.
   * @param userValues The Set to use the contains() method on for each item in the valuesToFind list.
   * @return boolean Whether or not a value from the list was found in the Collection.
   */
  static boolean isStringFromCollectionInSet(Collection tagValues,
                                             Set userValues) {
    // Be sure that the Set is the second parameter because it has a much faster ability
    // to do a lookup using the contains() method than to be iterated.
    return findCommonStringInCollections(tagValues, userValues);
  }

  /**
   * This method will check to see if a String value from the first Collection given is in the userRights array.  The
   * tag values translate into the index of the profile array, which can be quickly checked for a true/false value.
   *
   * @param tagValues  The Collection to iterate through.
   * @param userRights Array from user profile to iterate through
   * @return boolean Whether or not a value from the list was found in the Collection.
   */
  static boolean isStringFromCollectionInSet(Collection tagValues, int[] userRights) {
    Iterator values = tagValues.iterator();
    boolean hasMatch = false;

    while (values.hasNext() && !hasMatch) {
      String valueString = (String) (values.next());
      int value = Integer.parseInt(valueString);
      if (userRights[value] == 1) {
        hasMatch = true;
      }
    }

    return hasMatch;
  }

  /**
   * This method will find the outer tag and get the criteria from it.
   *
   * @param tag The tag to find the outer tag for.
   * @return List The list of criteria from the outer tag.
   * @throws JspException If no outer tag is found.
   */
  static List getCriteriaFromOutsideTag(TagSupport tag) throws JspException {
    List criteria = null;
    Object outerTagObject = tag.findAncestorWithClass(tag, PersonalizationCriteriaTag.class);

    if (outerTagObject == null) {
      throw new JspException("Tag must be nested in a PersonalizationCriteriaTag for 'match' "
                             + "attribute to be set.");
    } else {
      PersonalizationCriteriaTag outerTag = (PersonalizationCriteriaTag) outerTagObject;
      criteria = outerTag.getCriteria();
    }
    return criteria;
  }

  private PersonalizationHelper() {
  } //Do not allow this class to be instantiated
}












