package gov.georgia.dhr.dfcs.sacwis.core.utility;

// -- java classes --

import java.io.Serializable;
import java.util.Map;

/**
 * This class provides an implementation of the Map.Entry interface that allows for ordering within a TreeSet based upon
 * the index variable.
 *
 * @see OrderedMap
 */
public class MapEntry implements Map.Entry, Comparable, Serializable {
  /** Constructor. */
  public MapEntry() {
    this.key = null;
    this.value = null;
    this.index = null;
  }

  /**
   * Constructor.
   *
   * @param entry an object implementing the Map.Entry interface
   * @param index the number used to sort this object (i.e. when used with an OrderedMap should represent the order
   *              which the object was added to the Map)
   */
  public MapEntry(Map.Entry entry, int index) {
    this.key = entry.getKey();
    this.value = entry.getValue();
    this.index = index;
  }

  /**
   * Sets the key.
   *
   * @param key the object to be used as the key
   */
  public void setKey(Object key) {
    this.key = key;
  }

  /**
   * Returns the key.
   *
   * @return the object used as the key
   */
  public Object getKey() {
    return this.key;
  }

  /**
   * Sets the value.
   *
   * @param value the object to be used as the new value
   * @return the old value
   */
  public Object setValue(Object value) {
    Object oldValue = this.value;
    this.value = value;
    return oldValue;
  }

  /**
   * Returns the value.
   *
   * @return the object used as the value
   */
  public Object getValue() {
    return this.value;
  }

  /**
   * Sets the index.
   *
   * @param index the value used to sort this entry
   */
  public void setIndex(int index) {
    this.index = index;
  }

  /**
   * Returns the index.
   *
   * @return the value used to sort this entry
   */
  public int getIndex() {
    return this.index;
  }

  /**
   * Method used to compare objects according to the <i>natural ordering</i> of this class.  The natural ordering is
   * based upon the index variable.
   *
   * @param object the Object to be compared
   * @return a negative integer, zero, or a positive integer as this object is less than, equal to, or greater than the
   *         specified object
   */
  public int compareTo(Object object) {
    MapEntry entry = (MapEntry) object;
    return this.index.compareTo(entry.index);
  }

  //Instance variables
  private Object key;
  private Object value;
  private Integer index;
}
