//
// COPYRIGHT
//

package gov.georgia.dhr.dfcs.sacwis.core.lookup;

// java classes

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.SortedMap;

import org.grnds.facility.log.GrndsTrace;

/**
 * This file contains the LookupData class which encapsulates two HashMaps - one for encoding and one for decoding. This
 * class exists so that we can store all of our data in a single object in the JNDI tree. This is the object that will
 * be stored.
 *
 * @author Daniel L. Boxwell, September 24, 2001
 */
public class LookupData implements Serializable {
  private static String TRACE_TAG = "LookupData.";

  private Map<String, SortedMap<CodeKey, CodeAttributes>> encodeMap;
  private Map<String, SortedMap<CodeKey, CodeAttributes>> decodeMap;

  private Map<String, SortedMap<CodeKey, CodeAttributes>> expiredEncodeMap;
  private Map<String, SortedMap<CodeKey, CodeAttributes>> expiredDecodeMap;

  private static java.util.Date lastUpdate = null;

  /**
   * Package level constructor to deter instantiation
   *
   * @param encodeMap         The Map used for encoding
   * @param decodeMap         The Map used for decoding
   * @param expiredEncodeMap  The Map used for encoding expired codes
   * @param expiredDecodeMap  The Map used for decoding expired codes
   */
  public LookupData(Map<String, SortedMap<CodeKey, CodeAttributes>> encodeMap,
                    Map<String, SortedMap<CodeKey, CodeAttributes>> decodeMap,
                    Map<String, SortedMap<CodeKey, CodeAttributes>> expiredEncodeMap,
                    Map<String, SortedMap<CodeKey, CodeAttributes>> expiredDecodeMap) {
    this.encodeMap = encodeMap;
    this.decodeMap = decodeMap;

    this.expiredEncodeMap = expiredEncodeMap;
    this.expiredDecodeMap = expiredDecodeMap;
    //noinspection AssignmentToStaticFieldFromInstanceMethod
    LookupData.lastUpdate = new java.util.Date();
  }


  /**
   * Package level constructor to deter instantiation
   *
   * @param encodeMap The Map used for encoding
   * @param decodeMap The Map used for decoding
   */
  LookupData(Map<String, SortedMap<CodeKey, CodeAttributes>> encodeMap,
             Map<String, SortedMap<CodeKey, CodeAttributes>> decodeMap) {
    this.encodeMap = encodeMap;
    this.decodeMap = decodeMap;
  }

  /**
   * @param codeCategory The category of the decode to search for
   * @param decodedValue The decoded value
   * @return The code attributes object
   */
  CodeAttributes encode(String codeCategory, String decodedValue) {
    CodeAttributes result = null;
    SortedMap<CodeKey, CodeAttributes> tree = this.decodeMap.get(codeCategory);
    boolean codeCategoryExists = (codeCategory != null) && (tree != null);
    if (codeCategoryExists) {
      CodeKey key = new CodeKey(decodedValue, null);
      CodeAttributes attribute = tree.get(key);
      boolean codeAttributeExists = (attribute != null);
      if (codeAttributeExists) {
        result = attribute;
      }
    }
    return result;
  }

  /**
   * @param codeCategory The category of the decode to search for
   * @param decodedValue The decoded value
   * @return The code attributes object
   */
  CodeAttributes expiredEncode(String codeCategory, String decodedValue) {
    CodeAttributes result = null;
    SortedMap<CodeKey, CodeAttributes> tree = this.expiredDecodeMap.get(codeCategory);
    boolean codeCategoryExists = (codeCategory != null) && (tree != null);
    if (codeCategoryExists) {
      CodeKey key = new CodeKey(decodedValue, null);
      CodeAttributes attribute = tree.get(key);
      boolean codeAttributeExists = (attribute != null);
      if (codeAttributeExists) {
        result = attribute;
      }
    }
    return result;
  }

  /**
   * @param codeCategory The category of the code to search for
   * @param encodedValue The encoded value
   * @return The code attributes object
   */
  CodeAttributes decode(String codeCategory, String encodedValue) {
    CodeAttributes result = null;
    SortedMap<CodeKey, CodeAttributes> tree = this.encodeMap.get(codeCategory);
    boolean codeCategoryExists = (codeCategory != null) && (tree != null);
    if (codeCategoryExists) {
      CodeKey key = new CodeKey(encodedValue, null);
      CodeAttributes attribute = tree.get(key);
      boolean codeAttributeExists = (attribute != null);
      if (codeAttributeExists) {
        result = attribute;
      }
    }
    return result;
  }


  /**
   * @param codeCategory The category of the code to search for
   * @param encodedValue The encoded value
   * @return The code attributes object
   */
  CodeAttributes expiredDecode(String codeCategory, String encodedValue) {
    CodeAttributes result = null;
    if (expiredEncodeMap == null) {
      //Log Info message that there are no expired Codes/Decodes
      GrndsTrace.msg(TRACE_TAG, 3, "expiredEncodeMap is null: " + codeCategory + ", " + encodedValue);
      return null;
    }
    SortedMap<CodeKey, CodeAttributes> tree = this.expiredEncodeMap.get(codeCategory);
    boolean codeCategoryExists = (codeCategory != null) && (tree != null);
    if (codeCategoryExists) {
      CodeKey key = new CodeKey(encodedValue, null);
      CodeAttributes attribute = tree.get(key);
      boolean codeAttributeExists = (attribute != null);
      if (codeAttributeExists) {
        result = attribute;
      }
    }
    return result;
  }


  /**
   * Used to get a list of all CodeAttribues objects in a given category from encode map.
   *
   * @param codeCategory The category of the code to search for
   * @return The resulting list of CodeAttributes objects
   */
  Collection<CodeAttributes> list(String codeCategory) {
    Collection<CodeAttributes> result = new ArrayList<CodeAttributes>();
    SortedMap<CodeKey, CodeAttributes> tree = this.encodeMap.get(codeCategory);
    boolean codeCategoryExists = (codeCategory != null) && (tree != null);
    if (codeCategoryExists) {
      result.addAll(tree.values());
    }
    // Return all of the values
    return result;
  }

  /**
   * Used to get a list of all CodeAttribues objects in a given category from expired encode map.
   *
   * @param codeCategory The category of the code to search for
   * @return The resulting list of CodeAttributes objects
   */
  Collection<CodeAttributes> expiredList(String codeCategory) {
    Collection<CodeAttributes> result = new ArrayList<CodeAttributes>();
    if (this.expiredEncodeMap != null) {
      SortedMap<CodeKey, CodeAttributes> tree = this.expiredEncodeMap.get(codeCategory);
      boolean codeCategoryExists = (codeCategory != null) && (tree != null);
      if (codeCategoryExists) {
        result.addAll(tree.values());
      }
    }
    // Return all of the values
    return result;
  }


  /**
   * Used to get a list of all CodeAttribues objects in a given category from decode map.
   *
   * @param codeCategory The category of the code to search for
   * @return The resulting list of CodeAttributes objects
   */
  Collection<CodeAttributes> listDecode(String codeCategory) {
    Collection<CodeAttributes> result = new ArrayList<CodeAttributes>();
    SortedMap<CodeKey, CodeAttributes> tree = this.decodeMap.get(codeCategory);
    boolean codeCategoryExists = (codeCategory != null) && (tree != null);
    if (codeCategoryExists) {
      result.addAll(tree.values());
    }
    // Return all of the values
    return result;
  }

  /**
   * Used to get a list of all CodeAttribues objects in a given category from the expired decode map.
   *
   * @param codeCategory The category of the code to search for
   * @return The resulting list of CodeAttributes objects
   */
  Collection<CodeAttributes> expiredListDecode(String codeCategory) {
    Collection<CodeAttributes> result = new ArrayList<CodeAttributes>();
    SortedMap<CodeKey, CodeAttributes> tree = this.expiredDecodeMap.get(codeCategory);
    boolean codeCategoryExists = (codeCategory != null) && (tree != null);
    if (codeCategoryExists) {
      result.addAll(tree.values());
    }
    // Return all of the values
    return result;
  }

  public static java.util.Date getLastUpdate() {
    return lastUpdate;
  }
  
  /**
   * release the internal maps references 
   */
  public void setMapsToNull() {
    this.decodeMap = null;
    this.encodeMap = null;
    this.expiredDecodeMap = null;
    this.expiredEncodeMap = null;
  }
}





