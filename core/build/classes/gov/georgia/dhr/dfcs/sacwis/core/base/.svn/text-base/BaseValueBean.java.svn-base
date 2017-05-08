package gov.georgia.dhr.dfcs.sacwis.core.base;

import gov.georgia.dhr.dfcs.sacwis.core.exception.RuntimeWrappedException;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;


/**
 * All beans that will be used to carry data from the web tier to the database should subclass this class or the
 * gov.georgia.dhr.dfcs.sacwis.core.pagination.BasePaginationValueBean which subclasses this class. This object will also
 * provide a unified approach towards transferring user data to the database and for holding timestamps for our
 * optimistic locking approach. The BasePaginationValueBean should be used instead of this class if the data being
 * passed to or from the database will generate results and require pagination of such results.
 *
 * @author Randy O'Neil, October 12, 2001 Change History: Date        User      Description --------    --------
 *         -------------------------------------------------- 07/24/05    werlem    SIR 23728 - MPS Phase II Enhancement
 *         to add Contact List and Detail to MPS.
 */
public abstract class BaseValueBean implements Serializable {
  /**
   * Overrides the object toString() method.
   *
   * @return Text string listing values for all of the class's fields
   */
  public String toString() {
    StringBuffer output = new StringBuffer();
    output.append("BASE VALUE BEAN FIELDS:").append("\n");
    output.append("Created by: ").append(this.createdBy).append("\n");
    output.append("Created on: ").append(this.createdOn).append("\n");
    output.append("Updated by: ").append(this.updatedBy).append("\n");
    output.append("Updated on: ").append(this.updatedOn).append("\n\n");
    return output.toString();
  }


  /**
   * Add a single "updated on" timestamp to use for optimistic locking.
   *
   * @param table     The table that this timestamp applies to
   * @param updatedOn The time at which this data was last updated.
   */
  public void setUpdatedOn(String table, Timestamp updatedOn) {
    this.updatedOn.put(table, updatedOn);
  }


  /**
   * Get the "updated on" timestamp to use for optimistic locking.
   *
   * @param table The table that the requested timestamp corresponds to
   * @return The time at which this data was last updated.
   */
  public Timestamp getUpdatedOn(String table) {
    return this.updatedOn.get(table);
  }


  /**
   * Get all timestamps showing when the bean was last updated.
   *
   * @return All timestamps showing when the bean was last updated, in the form of a hashmap with table names as keys
   *         and timestamps as values.
   */
  public Map<String,Timestamp> getUpdatedOn() {
    return this.updatedOn;
  }


  /**
   * Set the identification of the user that is making the change/request
   *
   * @param table     The table that this user applies to
   * @param updatedBy The identification of the user who last updated the record
   * @deprecated
   */
  public void setUpdatedBy(String table, String updatedBy) {
    this.deprecatedUpdatedBy.put(table, updatedBy);
  }


  /**
   * Set the identification of the user that is making the change/request
   *
   * @param updatedBy The identification of the user who last updated the record
   */
  public void setUpdatedBy(String updatedBy) {
    this.updatedBy = updatedBy;
  }


  /**
   * Get the identification of the user that is making the change/request
   *
   * @param table The table that this user is changing
   * @return userID The identification of the user who last updated the record
   * @deprecated
   */
  public String getUpdatedBy(String table) {
    return this.deprecatedUpdatedBy.get(table);
  }


  /**
   * Get the identification of the user that is making the change/request
   *
   * @return userID The identification of the user who last updated the record
   */
  public String getUpdatedBy() {
    return this.updatedBy;
  }


  /**
   * Set the "created on" timestamp.
   *
   * @param table     The table that this timestamp applies to
   * @param createdOn The time at which this data was created
   * @deprecated
   */
  public void setCreatedOn(String table, Timestamp createdOn) {
    this.deprecatedCreatedOn.put(table, createdOn);
  }


  /**
   * Set the "created on" timestamp.
   *
   * @param createdOn The time at which this data was created
   */
  public void setCreatedOn(Timestamp createdOn) {
    this.createdOn = createdOn;
  }


  /**
   * Get the timestamp showing when this record was created within a particular table.
   *
   * @param table The table that this timestamp corresponds to
   * @return updatedOn The time at which this data was created
   * @deprecated
   */
  public Timestamp getCreatedOn(String table) {
    return this.deprecatedCreatedOn.get(table);
  }


  /**
   * Get the timestamp showing when the record corresponding to this bean was created.
   *
   * @return updatedOn The time at which this data was created
   */
  public Timestamp getCreatedOn() {
    return this.createdOn;
  }


  /**
   * Set the identification of the user that is updating the data.
   *
   * @param table     The table that this request corresponds to
   * @param createdBy The identification of the user who created the record
   * @deprecated
   */
  public void setCreatedBy(String table, String createdBy) {
    this.deprecatedCreatedBy.put(table, createdBy);
  }


  /**
   * Set the identification of the user that is updating the data.
   *
   * @param createdBy The identification of the user who created the record
   */
  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }


  /**
   * Get the identification of the user that is updating the data.
   *
   * @param table The table that the user is trying to change
   * @return userID The identification of the user who created the record
   * @deprecated
   */
  public String getCreatedBy(String table) {
    return this.deprecatedCreatedBy.get(table);
  }


  /**
   * Get the identification of the user that is updating the data.
   *
   * @return userID The identification of the user who created the record
   */
  public String getCreatedBy() {
    return this.createdBy;
  }


  /**
   * This class clones xml value beans; it's not fast, but it's fast enough for MPS.
   *
   * @return A deep copy of this object.
   */
  public BaseValueBean copy() {
    ObjectOutputStream oos = null;
    ObjectInputStream ois = null;
    try {
      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      oos = new ObjectOutputStream(baos);
      oos.writeObject(this);
      ois = new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray()));
      return (BaseValueBean) ois.readObject();
    }
    catch (IOException e) {
      // This will only happen if something non-serializable gets stuck in one of the subclasses of this.
      throw new RuntimeWrappedException(e);
    }
    catch (ClassNotFoundException e) {
      // This should really never happen.
      throw new RuntimeWrappedException(e);
    }
    finally {
      try {
        if (oos != null) {
          oos.close();
        }
      }
      catch (IOException e) {
        // This should really never happen, so ignore it.
      }
      try {
        if (ois != null) {
          ois.close();
        }
      }
      catch (IOException e) {
        // This should really never happen, so ignore it.
      }
    }
  }


  // instance variables
  private Map<String,Timestamp> deprecatedCreatedOn = new HashMap<String, Timestamp>(); // key=String, value=Timestamp
  private Timestamp createdOn = null;

  private Map<String,String> deprecatedCreatedBy = new HashMap<String, String>(); // key=String, value=String
  private String createdBy = null;

  private Map<String,String> deprecatedUpdatedBy = new HashMap<String, String>(); // key=String, value=String
  private String updatedBy = null;

  private Map<String,Timestamp> updatedOn = new HashMap<String, Timestamp>(); // key=String, value=Timestamp


  // static constants
  public static final String CREATED_ON_TIME_STAMP = "created.timestamp";
  public static final String UPDATED_ON_TIME_STAMP = "updated.timestamp";
  public static final String CREATED_BY = "created.userId";
  public static final String REQUEST_ATTRIBUTE_NAME = "data.object";
}
