package gov.georgia.dhr.dfcs.sacwis.core.lookup;

import java.io.Serializable;
import java.util.Hashtable; // Only for javadoc

/**
 * This file contains the CodeKey class which acts as the unique key used to find a code or decode in the codes table
 * cached service.
 * <p/>
 * Note: this class has a natural ordering that may be inconsistent with equals.
 *
 * @author Daniel L. Boxwell, September 24, 2001
 */
public final class CodeKey implements Comparable, Serializable {
  /**
   * Public Constructor
   *
   * @param key       The value of the key itself
   * @param sortOrder The sort order of this code in its category
   */
  public CodeKey(String key, Integer sortOrder) {
    this.key = key;
    if (sortOrder != null) {
      this.sortOrder = sortOrder;
      this.hasSortOrder = true;
    }
  }

  /** @return The key value */
  public String getKey() {
    return this.key;
  }

  /** @return The sort order */
  public Integer getSortOrder() {
    return this.sortOrder;
  }

  /**
   * @param key The object to be compared against this one
   * @return Whether or not the two objects are the same
   */
  public boolean equals(CodeKey key) {
    return this.key.equals(key.getKey());
  }

  /**
   * Indicates whether some other object is "equal to" this one.
   * <p/>
   * The <code>equals</code> method implements an equivalence relation: <ul> <li>It is <i>reflexive</i>: for any
   * reference value <code>x</code>, <code>x.equals(x)</code> should return <code>true</code>. <li>It is
   * <i>symmetric</i>: for any reference values <code>x</code> and <code>y</code>, <code>x.equals(y)</code> should
   * return <code>true</code> if and only if <code>y.equals(x)</code> returns <code>true</code>. <li>It is
   * <i>transitive</i>: for any reference values <code>x</code>, <code>y</code>, and <code>z</code>, if
   * <code>x.equals(y)</code> returns  <code>true</code> and <code>y.equals(z)</code> returns <code>true</code>, then
   * <code>x.equals(z)</code> should return <code>true</code>. <li>It is <i>consistent</i>: for any reference values
   * <code>x</code> and <code>y</code>, multiple invocations of <tt>x.equals(y)</tt> consistently return
   * <code>true</code> or consistently return <code>false</code>, provided no information used in <code>equals</code>
   * comparisons on the object is modified. <li>For any non-null reference value <code>x</code>,
   * <code>x.equals(null)</code> should return <code>false</code>. </ul>
   * <p/>
   * The <tt>equals</tt> method for class <code>Object</code> implements the most discriminating possible equivalence
   * relation on objects; that is, for any reference values <code>x</code> and <code>y</code>, this method returns
   * <code>true</code> if and only if <code>x</code> and <code>y</code> refer to the same object (<code>x==y</code> has
   * the value <code>true</code>).
   *
   * @param obj the reference object with which to compare.
   * @return <code>true</code> if this object is the same as the obj argument; <code>false</code> otherwise.
   * @see Boolean#hashCode()
   * @see Hashtable
   */
  public boolean equals(Object obj) {
    return obj != null && obj instanceof CodeKey ? equals((CodeKey) obj) : false;
  }

  /**
   * Returns a hash code value for the object. This method is supported for the benefit of hashtables such as those
   * provided by <code>java.util.Hashtable</code>.
   * <p/>
   * The general contract of <code>hashCode</code> is: <ul> <li>Whenever it is invoked on the same object more than once
   * during an execution of a Java application, the <tt>hashCode</tt> method must consistently return the same integer,
   * provided no information used in <tt>equals</tt> comparisons on the object is modified. This integer need not remain
   * consistent from one execution of an application to another execution of the same application. <li>If two objects
   * are equal according to the <tt>equals(Object)</tt> method, then calling the <code>hashCode</code> method on each of
   * the two objects must produce the same integer result. <li>It is <em>not</em> required that if two objects are
   * unequal according to the {@link Object#equals(Object)} method, then calling the <tt>hashCode</tt> method on each of
   * the two objects must produce distinct integer results.  However, the programmer should be aware that producing
   * distinct integer results for unequal objects may improve the performance of hashtables. </ul>
   * <p/>
   * As much as is reasonably practical, the hashCode method defined by class <tt>Object</tt> does return distinct
   * integers for distinct objects. (This is typically implemented by converting the internal address of the object into
   * an integer, but this implementation technique is not required by the Java<font size="-2"><sup>TM</sup></font>
   * programming language.)
   *
   * @return a hash code value for this object.
   * @see Object#equals(Object)
   * @see Hashtable
   */
  public int hashCode() {
    return (3 * key.hashCode()) + (hasSortOrder ? (5 * sortOrder) : 0);
  }

  /**
   * Compares this object with the specified object for order.  Returns a negative integer, zero, or a positive integer
   * as this object is less than, equal to, or greater than the specified object.<p>
   * <p/>
   * The implementor must ensure <tt>sgn(x.compareTo(y)) == -sgn(y.compareTo(x))</tt> for all <tt>x</tt> and <tt>y</tt>.
   * (This implies that <tt>x.compareTo(y)</tt> must throw an exception iff <tt>y.compareTo(x)</tt> throws an
   * exception.)<p>
   * <p/>
   * The implementor must also ensure that the relation is transitive: <tt>(x.compareTo(y)&gt;0 &amp;&amp;
   * y.compareTo(z)&gt;0)</tt> implies <tt>x.compareTo(z)&gt;0</tt>.<p>
   * <p/>
   * Finally, the implementer must ensure that <tt>x.compareTo(y)==0</tt> implies that <tt>sgn(x.compareTo(z)) ==
   * sgn(y.compareTo(z))</tt>, for all <tt>z</tt>.<p>
   * <p/>
   * It is strongly recommended, but <i>not</i> strictly required that <tt>(x.compareTo(y)==0) == (x.equals(y))</tt>.
   * Generally speaking, any class that implements the <tt>Comparable</tt> interface and violates this condition should
   * clearly indicate this fact.  The recommended language is "Note: this class has a natural ordering that is
   * inconsistent with equals."
   *
   * @param o the Object to be compared.
   * @return a negative integer, zero, or a positive integer as this object is less than, equal to, or greater than the
   *         specified object.
   * @throws ClassCastException if the specified object's type prevents it from being compared to this Object.
   */
  public int compareTo(Object o) {
    if (o == null) {
      // so null objects will sort at the end
      return -1;
    }
    CodeKey codeKey = (CodeKey) o;
    if (this.hasSortOrder && codeKey.hasSortOrder) {
      return this.sortOrder - codeKey.sortOrder;
    } else {
      if (this.key == null) {
        if (codeKey.key == null) {
          // return 0 for equality if they're both null
          return 0;
        } else {
          // return 1 if this.key is null to force nulls to the end
          return 1;
        }
      } else {
        if (codeKey.key == null) {
          // return -1 if codeKey.key is null to force nulls to the end
          return -1;
        } else {
          // if both are not null, return the string comparison
          return this.key.compareTo(codeKey.key);
        }
      }
    }
  }

  //
  // Instance variables
  //
  private String key;
  private int sortOrder;
  private boolean hasSortOrder = false;
}
