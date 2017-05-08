package gov.georgia.dhr.dfcs.sacwis.core.lookup;

import gov.georgia.dhr.dfcs.sacwis.core.exception.BasePrsException;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.grnds.facility.log.GrndsTrace;

/**
 * This file contains the Lookup class which provides static methods to the user for codes table lookup functionality.
 *
 * @author Daniel L. Boxwell, September 24, 2001
 */
public abstract class Lookup {
  private static LookupData data;

  /*
   Static initialization block which fetches the LookupData object from the JNDI tree to populate the instance variable.

   Note that this is no longer done; it is done on application init already, and it is redundant here.

   static {
     // Get an initial copy of the codes table data
     Lookup.updateLookupDataFromJndiTree();
   }
   */

  public static void setLookupData(LookupData lookupData) {
    Lookup.data = lookupData;
  }

  /**
   * Encodes a value given the code category and decoded value.
   *
   * @param codeCategory The category of the decode to search for
   * @param decodedValue The decoded value
   * @return Code Attributes object
   * @throws LookupException Thrown when the lookup fails
   */
  public static CodeAttributes encode(String codeCategory, String decodedValue) throws LookupException {
    checkLookupDataState();
    CodeAttributes codeAttributesObject = Lookup.data.encode(codeCategory, decodedValue);
    Lookup.ensureNotNull(codeAttributesObject);
    return codeAttributesObject;
  }

  /**
   * Encodes a value given the code category and decoded value and returns a simple string.
   *
   * @param codeCategory The category of the decode to search for
   * @param decodedValue The decoded value
   * @return The encoded value
   * @throws LookupException Thrown when the lookup fails
   */
  public static String simpleEncode(String codeCategory, String decodedValue) throws LookupException {
    String code = null;
    CodeAttributes attributes = encode(codeCategory, decodedValue);
    if (attributes != null) {
      code = attributes.getCode();
    }
    Lookup.ensureNotNull(code);
    return code;
  }

  /**
   * Decodes a value given the code category and encoded value.
   *
   * @param codeCategory The category of the code to search for
   * @param encodedValue The encoded value
   * @return Code Attributes object
   * @throws LookupException Thrown when the lookup fails
   */
  public static CodeAttributes decode(String codeCategory, String encodedValue) throws LookupException {
    checkLookupDataState();
    CodeAttributes codeAttributesObject = Lookup.data.decode(codeCategory, encodedValue);
    Lookup.ensureNotNull(codeAttributesObject);
    return codeAttributesObject;
  }

  /**
   * Decodes an expired value given the code category and encoded value.
   *
   * @param codeCategory The category of the code to search for
   * @param encodedValue The encoded value
   * @return Code Attributes object
   * @throws LookupException Thrown when the lookup fails
   */
  public static CodeAttributes expiredDecode(String codeCategory, String encodedValue) throws LookupException {
    checkLookupDataState();
    CodeAttributes codeAttributesObject = Lookup.data.expiredDecode(codeCategory, encodedValue);
    Lookup.ensureNotNull(codeAttributesObject);
    return codeAttributesObject;
  }

  /**
   * Decodes a value given the code category and encoded value and returns a simple string.
   *
   * @param codeCategory The category of the code to search for
   * @param encodedValue The encoded value
   * @return The decoded value
   * @throws LookupException Thrown when the lookup fails
   */
  public static String simpleDecode(String codeCategory, String encodedValue) throws LookupException {
    String decode = null;
    try {
      //Check for existence of code in codes table
      CodeAttributes attributes = decode(codeCategory, encodedValue);
      if (attributes != null) {
        decode = attributes.getDecode();
      }
      //If it does not exist, check in expired codes
      else {
        attributes = expiredDecode(codeCategory, encodedValue);
        if (attributes != null) {
          decode = attributes.getDecode();
        }
      }
    }
    catch (LookupException le) {
      //If there is an exception getting the code, try the expired codes.
      CodeAttributes attributes = expiredDecode(codeCategory, encodedValue);
      if (attributes != null) {
        decode = attributes.getDecode();
      }
    }
    Lookup.ensureNotNull(decode);
    return decode;
  }

  /**
   * Decodes a value given the code category and encoded value and returns a simple string.
   *
   * @param codeCategory The category of the code to search for
   * @param encodedValue The encoded value
   * @return The decoded value
   */
  public static String simpleDecodeSafe(String codeCategory, String encodedValue) {
    try {
      return (simpleDecode(codeCategory, encodedValue));
    }
    catch (LookupException e) {
      GrndsTrace.msg("Lookup", 7, "Lookup Exception in simpleDecodeSafe - return blank string");
    }
    return "";
  }

  /**
   * Decodes a value given the code category and encoded value and returns a simple string.
   *
   * @param codeCategory The category of the code to search for
   * @param decodedValue The decoded value
   * @return The decoded value
   */
  public static String simpleEncodeSafe(String codeCategory, String decodedValue) {
    try {
      return (simpleEncode(codeCategory, decodedValue));
    }
    catch (LookupException e) {
      GrndsTrace.msg("Lookup", 7, "Lookup Exception in simpleEncodeSafe - return blank string");
    }
    return "";
  }

  public static boolean isValidCode(String codeCategory, String encodedValue) {
    return Lookup.data != null && (Lookup.data.decode(codeCategory, encodedValue) != null);
  }

  public static boolean isValidExpiredCode(String codeCategory, String encodedValue) {
    return Lookup.data != null && (Lookup.data.expiredDecode(codeCategory, encodedValue) != null);
  }

  /**
   * Used to get a list of all CodeAttribute objects in a given category from encode map
   *
   * @param codeCategory The category of the code to search for
   * @return The resulting list of CodeAttributes objects
   * @throws LookupException Thrown when the lookup fails
   */
  public static Iterator<CodeAttributes> getCategoryListing(String codeCategory) throws LookupException {
    checkLookupDataState();
    Iterator<CodeAttributes> categories = Lookup.data.list(codeCategory).iterator();
    Lookup.ensureNotNull(categories);
    return categories;
  }

  /**
   * Used to get a list of all CodeAttribute objects in a given category
   *
   * @param codeCategory The category of the code to search for
   * @return The resulting list of CodeAttributes objects
   * @throws LookupException Thrown when the lookup fails
   */
  public static CodeAttributes[] getCategoryListingArray(String codeCategory) throws LookupException {
    checkLookupDataState();
    CodeAttributes[] array = Lookup.data.list(codeCategory).toArray(new CodeAttributes[codeCategory.length()]);
    CodeAttributes[] codeAttributes = new CodeAttributes[array.length];
    System.arraycopy(array, 0, codeAttributes, 0, array.length);
    Lookup.ensureNotNull(codeAttributes);
    return codeAttributes;
  }

  /**
   * Used to get a list of all CodeAttribute objects in a given category from decode map
   *
   * @param codeCategory The category of the code to search for
   * @return The resulting list of CodeAttributes objects
   * @throws LookupException Thrown when the lookup fails
   */
  public static Iterator<CodeAttributes> getCategoryListingDecode(String codeCategory) throws LookupException {
    checkLookupDataState();
    Iterator<CodeAttributes> categories = Lookup.data.listDecode(codeCategory).iterator();
    Lookup.ensureNotNull(categories);
    return categories;
  }

  /**
   * Used to get a list of all code <code>String</code> objects in a given category
   *
   * @param codeCategory The category of the code to search for
   * @return The resulting list of Codes <code>String</code> objects
   * @throws LookupException Thrown when the lookup fails
   */
  public static Collection<String> getCategoryCodesCollection(final String codeCategory) throws LookupException {
    checkLookupDataState();
    // Use a local class in order to pull the code out of the collection of CodeAttributes
    // TODO: This is probably a performance problem because this implemention is very slow.
    class CodesCollection extends AbstractCollection<String> {
      Collection<CodeAttributes> codeAttributesColleciton = Lookup.data.list(codeCategory);

      public int size() {
        return codeAttributesColleciton.size();
      }

      public Iterator<String> iterator() {
        return new Iterator<String>() {
          Iterator codeAttributesIterator = codeAttributesColleciton.iterator();

          public boolean hasNext() {
            return codeAttributesIterator.hasNext();
          }

          public String next() {
            CodeAttributes ca = (CodeAttributes) codeAttributesIterator.next();
            return ca.getCode();
          }

          public void remove() {
            codeAttributesIterator.remove();
          }
        };
      }
    }
    return new CodesCollection();
  }

  /**
   * Used to get a list of all CodeAttribute objects in a given category
   *
   * @param codeCategory The category of the code to search for
   * @return The resulting list of CodeAttributes objects
   * @throws LookupException Thrown when the lookup fails
   */
  public static List<CodeAttributes> getCategoryCollectionSortedByDecode(String codeCategory)
          throws LookupException {
    List<CodeAttributes> list = getCategoryCollection(codeCategory);
    CodeAttributes[] codeAttributes = new CodeAttributes[list.size()];
    list.toArray(codeAttributes);
    Arrays.sort(codeAttributes, new Comparator<CodeAttributes>() {
      public int compare(CodeAttributes codeAttributes1, CodeAttributes codeAttributes2) {
        String decode1 = codeAttributes1.getDecode();
        String decode2 = codeAttributes2.getDecode();
        return decode1.compareTo(decode2);
      }

      public boolean equals(Object object) {
        return (object.getClass().equals(getClass()));
      }
    });
    // STGAP00017304: set the ordered list back to list type because Arrays.asList returns an immutable
    // list. This causes error in using excludeCodes in codesCheckbox tag when order = DECODE.
    //return Arrays.asList(codeAttributes);
    list = new ArrayList<CodeAttributes>(list.size());
    Collections.addAll(list, codeAttributes);
    return list;

  }

  /**
   * Used to get a list of all CodeAttribute objects in a given category
   *
   * @param codeCategory The category of the code to search for
   * @return The resulting list of CodeAttributes objects
   * @throws LookupException Thrown when the lookup fails
   */
  public static List<CodeAttributes> getCategoryCollection(String codeCategory) throws LookupException {
    checkLookupDataState();
    Collection<CodeAttributes> collection = Lookup.data.list(codeCategory);
    if (collection instanceof List) {
      return (List<CodeAttributes>) collection;
    }
    List<CodeAttributes> list = new ArrayList<CodeAttributes>(collection.size());
    list.addAll(collection);
    return list;
  }

  /**
   * Used to get a list of all CodeAttribute objects in a given category
   *
   * @param codeCategory The category of the code to search for
   * @return The resulting list of CodeAttributes objects
   * @throws LookupException Thrown when the lookup fails
   */
  public static List<CodeAttributes> getExpiredCategoryCollection(String codeCategory) throws LookupException {
    checkLookupDataState();
    Collection<CodeAttributes> collection = Lookup.data.expiredList(codeCategory);
    if (collection instanceof List) {
      return (List<CodeAttributes>) collection;
    }
    List<CodeAttributes> list = new ArrayList<CodeAttributes>(collection.size());
    list.addAll(collection);
    return list;
  }

  private static void checkLookupDataState() throws LookupException {
    if (Lookup.data == null) {
      throw new LookupException("Codes Table Lookup Data was not initialized properly." +
                                "  Check weblogic.log for details.", BasePrsException.CRITICAL_PRIORITY);
    }
  }

  /**
   * Used to get a list of all child CodeAttribues objects for a given code in a given category.
   *
   * @param parentCodeCategory The category of the code to search for
   * @param parentCode         The code of the parent for who's children are retrieved.
   * @return The resulting list of CodeAttributes objects
   * @throws LookupException Thrown when the lookup fails
   */
  public static Iterator getChildCategoryListing(String parentCodeCategory, String parentCode) throws LookupException {
    checkLookupDataState();
    return getCategoryListing(parentCodeCategory + parentCode);
  }

  static void ensureNotNull(Object object) throws LookupException {
    if (object == null) {
      throw new LookupException("Lookup found no data to match your query.", BasePrsException.WARNING_PRIORITY);
    }
  }
  
  /**
   * Helper method to release the maps used by the update method from the LookupInt class
   */
  public static void setMapsToNull() {
    Lookup.data.setMapsToNull();
  }
}
