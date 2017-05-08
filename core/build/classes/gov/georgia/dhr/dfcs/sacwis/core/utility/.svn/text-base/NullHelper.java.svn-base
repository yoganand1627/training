package gov.georgia.dhr.dfcs.sacwis.core.utility;

import java.util.Collection;

/**
 * Compares two objects in a nullsafe way
 *
 * @author Lee Kuo
 */
public class NullHelper {
  /**
   * Compares two objects and returns a boolean value indicating equality. This method invokes the .equals() method on
   * the objects and returns true in the case where both values are equal or both are null.
   *
   * @param object1 The first object to be compared
   * @param object2 The second object to be compared
   * @return Whether or not the objects are equal
   */
  public static boolean nullsafeCompare(Object object1, Object object2) {
    boolean result = false;

    // if the first object is null, check the second
    if (object1 == null) {
      // if the second object is also null mark them equal
      if (object2 == null) {
        result = true;
      }
      // else they are different
      else {
        result = false;
      }
    }
    // now calling .equals() is nullsafe
    else {
      result = object1.equals(object2);
    }

    return result;
  }
  
  /** Updated copy of StringHelper.isEmptyOrNull (Cochran)
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
    } else if (Collection.class.isInstance(o)) {
    	Collection<?> l = (Collection<?>) o;
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
}






