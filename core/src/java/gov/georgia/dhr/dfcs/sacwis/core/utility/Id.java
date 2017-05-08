package gov.georgia.dhr.dfcs.sacwis.core.utility;

// -- java classes --

import java.io.Serializable;

/**
 * The Id class encapsulates the unique identifier for a database row. ID columns in the database are defined as having
 * type NUMBER, with positive integer values in the range 1..<?>. This range is within the range of values defined for
 * the Java primitive long integer type (-9,223,372,036,854,775,808 to 9,223,372,036,854,775,807). The Id class includes
 * additional checks to ensure that instances correspond to positive integers in the range 1 to <?>.
 *
 * @author Bryan Krofchok, January 28, 2002
 */
public class Id implements Comparable, Serializable {
  //
  // constructors
  //

  /**
   * Constructs an Id object from a given ID value.
   *
   * @param id an ID value
   * @throws IllegalArgumentException if the given ID value is not a positive integer
   */
  protected Id(long id) {
    if (id <= 0) {
      throw new IllegalArgumentException();
    }
    this.id = id;
  }

  //
  // public instance methods
  //

  /**
   * Compares this object against the specified object. The result is true if and only if the argument is not 'null' and
   * is an Id object that has the same ID value as this object.
   *
   * @param object the object to compare with
   * @return boolean  true if the objects have the same ID value; false otherwise
   */
  public boolean equals(Object object) {
    boolean isEqual = false;
    if (object == this) {
      isEqual = true;
    } else if (object instanceof Id) {
      isEqual = (this.id == ((Id) object).id);
    }
    return isEqual;
  }

  /**
   * Computes a hashcode for this Id. The hash function is the same as that used in the Long class.
   *
   * @return int  a hash code value for this object
   */
  public int hashCode() {
    return (int) (this.id ^ (this.id >>> 32));
  }

  /**
   * Returns a String representation of the Id object.
   *
   * @return String  a String representation of the Id object
   */
  public String toString() {
    return "" + this.id;
  }

  /**
   * Returns a Long representation of the Id object.
   *
   * @return Long  a Long representation of the Id object
   */
  public Long toLong() {
    return this.id;
  }


  /**
   * Compares two Ids numerically.
   *
   * @return int        the value 0 if the argument Id is equal to this Id; a value less than 0 if this Id is
   *         numerically less than the Id argument; and a value greater than 0 if this Id is numerically greater than
   *         the Id argument.
   * @parameter object  the Id to be compared
   */
  public int compareTo(Object object) {
    Id otherId = (Id) object;

    int result = 0;
    if (this.id < otherId.id) {
      result = -1;
    } else if (this.id > otherId.id) {
      result = 1;
    }
    return result;
  }

  //
  // static methods
  //

  /**
   * Static factory method for creating a new Id object initialized using a primitive long integer representation of an
   * ID.
   *
   * @param idAsLong a primitive long integer representation of an ID
   * @return Id       a newly-constructed Id object initialized using the given primitive long integer representation of
   *         an ID
   * @throws IllegalArgumentException if the given primitive long integer is not positive
   */
  public static Id valueOf(long idAsLong) {
    return new Id(idAsLong);
  }

  /**
   * Static factory method for creating a new Id object initialized using a String representation of an ID. If the given
   * String is 'null' or has length zero, 'null' is returned. Otherwise, an attempt is made to interpret the given
   * String as a positive long integer.
   *
   * @param idAsString a String representation of an ID
   * @return Id         a newly-constructed Id object initialized using the given String representation of an ID
   * @throws NumberFormatException    if the given String does not contain a parsable long integer
   * @throws IllegalArgumentException if the given String does not parse to a positive integer
   */
  public static Id valueOf(String idAsString) {
    Id id = null;
    if (idAsString != null && idAsString.length() > 0) {
      id = new Id(Long.parseLong(idAsString));
    }
    return id;
  }

  /**
   * Static factory method for creating a new Id object initialized using a Long representation of an ID. If the given
   * Long is 'null', 'null' is returned.
   *
   * @param idAsLong a Long representation of an ID
   * @return Id       a newly-constructed Id object initialized using the given Long representation of an ID
   * @throws IllegalArgumentException if the given Long is not a positive integer
   */
  public static Id valueOf(Long idAsLong) {
    Id id = null;
    if (idAsLong != null) {
      id = new Id(idAsLong);
    }
    return id;
  }


  //
  // instance variables
  //
  private final long id;
}






