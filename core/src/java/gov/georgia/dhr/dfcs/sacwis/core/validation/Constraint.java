package gov.georgia.dhr.dfcs.sacwis.core.validation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;

/**
 * Represents a set of rules to be applied to a single form input. Based on code examples by Brett McLaughlin.
 * <p/>
 * <pre>
 * Change Log
 * Date        Fixer         Description
 * __________  ____________  ___________________________________________________
 * 05/08/2003  websted       SIR# 17068  Unlike in normal schemas, where the
 *                           enumeration lists possible correct values, the
 *                           enumeration is this implementation can list allowed
 *                           or disallowed values. Allowed values are anything
 *                           in the enumeration that does not start with an !.
 *                           Disallowed values start with a !
 * </pre>
 */
public class Constraint implements Serializable {
  /**
   * Default constructor.
   *
   * @param name the name of this constraint
   */
  public Constraint(String name) {
    this.name = name;
  }

  /**
   * Gets the name of this constraint.
   *
   * @return String the name of this constraint
   */
  public String getName() {
    return this.name;
  }

  /**
   * Find out if this constraint has a minimum (inclusive) value defined.
   *
   * @return true if this constraint has a minimum (inclusive) value defined, false otherwise
   */
  public boolean hasMinInclusive() {
    return (!new Double(this.minIncValue).isNaN());
  }

  /**
   * Set the minimum (inclusive) value of this constraint.
   *
   * @param min the minimum valid value. A value will be valid if min <= value.
   */
  public void setMinInclusive(double min) {
    this.minIncValue = min;
  }

  /**
   * Get the minimum (inclusive) value of this constraint.
   *
   * @return min the minimum valid value. A value will be valid if min <= value.
   */
  public double getMinInclusive() {
    return this.minIncValue;
  }

  /**
   * Find out if this constraint has a minimum (exclusive) value defined.
   *
   * @return true if this constraint has a minimum (exclusive) value defined, false otherwise
   */
  public boolean hasMinExclusive() {
    return (!new Double(this.minExcValue).isNaN());
  }

  /**
   * Set the minimum (exclusive) value of this constraint.
   *
   * @param min the largest value less than any valid value. A value will be valid if min < value.
   */
  public void setMinExclusive(double min) {
    this.minExcValue = min;
  }

  /**
   * Get the minimum (exclusive) value of this constraint.
   *
   * @return min the largest value less than any valid value. A value will be valid if min < value.
   */
  public double getMinExclusive() {
    return this.minExcValue;
  }

  /**
   * Find out if this constraint has a maximum (inclusive) value defined.
   *
   * @return true if this constraint has a maximum (inclusive) value defined, false otherwise
   */
  public boolean hasMaxInclusive() {
    return (!new Double(this.maxIncValue).isNaN());
  }

  /**
   * Set the maximum (inclusive) value of this constraint.
   *
   * @param max the maximum valid value. A value will be valid if value <= max.
   */
  public void setMaxInclusive(double max) {
    this.maxIncValue = max;
  }

  /**
   * Get the maximum (inclusive) value of this constraint.
   *
   * @return max the maximum valid value. A value will be valid if value <= max.
   */
  public double getMaxInclusive() {
    return this.maxIncValue;
  }

  /**
   * Find out if this constraint has a maximum (exclusive) value defined.
   *
   * @return true if this constraint has a maximum (exclusive) value defined, false otherwise
   */
  public boolean hasMaxExclusive() {
    return (!new Double(this.maxExcValue).isNaN());
  }

  /**
   * Set the maximum (exclusive) value of this constraint.
   *
   * @param max the lowest value greater than any valid value. A value will be valid if value < max.
   */
  public void setMaxExclusive(double max) {
    this.maxExcValue = max;
  }

  /**
   * Get the maximum (exclusive) value of this constraint.
   *
   * @return max the lowest value greater than any valid value. A value will be valid if value < max.
   */
  public double getMaxExclusive() {
    return this.maxExcValue;
  }

  /**
   * Find out if this constraint has a minimum length defined.
   *
   * @return true if this constraint has a minimum length defined, false otherwise
   */
  public boolean hasMinLength() {
    return (!new Double(this.minLength).isNaN());
  }

  /**
   * Set the minimum length of this constraint.
   *
   * @param min the minimum length allowed.
   */
  public void setMinLength(double min) {
    this.minLength = min;
  }

  /**
   * Get the minimum length of this constraint.
   *
   * @return min the minimum length allowed.
   */
  public double getMinLength() {
    return this.minLength;
  }

  /**
   * Find out if this constraint has a maximum length defined.
   *
   * @return true if this constraint has a maximum length defined, false otherwise
   */
  public boolean hasMaxLength() {
    return (!new Double(this.maxLength).isNaN());
  }

  /**
   * Set the maximum length of this constraint.
   *
   * @param max the maximum length allowed.
   */
  public void setMaxLength(double max) {
    this.maxLength = max;
  }

  /**
   * Get the maximum length of this constraint.
   *
   * @return max the maximum length allowed.
   */
  public double getMaxLength() {
    return this.maxLength;
  }

  /**
   * Add a value to the list of disallowed values for this constraint.
   *
   * @param value the disallowed value.
   */
  public void addDisallowedValue(String value) {
    this.disallowedValues.add(value);
  }

  /**
   * Add a value to the list of allowed values for this constraint.
   *
   * @param value the allowed value.
   */
  public void addAllowedValue(String value) {
    this.allowedValues.add(value);
  }

  /**
   * Get a list of disallowed values for this constraint.
   *
   * @return List of disallowed values for this input.
   */
  public List<String> getDisallowedValues() {
    return disallowedValues;
  }

  /**
   * Find out if any disallowed values are defined for this constraint.
   *
   * @return true if any disallowed values have been defined for this constraint, false otherwise.
   */
  public boolean hasDisallowedValues() {
    return (this.disallowedValues.size() > 0);
  }

  /**
   * Find out if any disallowed values are defined for this constraint.
   *
   * @return true if any disallowed values have been defined for this constraint, false otherwise.
   */
  public boolean hasAllowedValues() {
    return (this.allowedValues.size() > 0);
  }

  /**
   * Find out if any regular expression pattern has been defined for this constraint.
   *
   * @return true if any regular expression pattern has been defined for this constraint, false otherwise.
   */
  public boolean hasPattern() {
    return this.pattern != null;
  }

  /**
   * Get the regular expression pattern for this constraint.
   *
   * @return String the regular expression pattern.
   */
  public String getPattern() {
    return this.pattern;
  }

  /**
   * Set the regular expression pattern for this constraint.
   *
   * @param pattern the regular expression pattern.
   */
  public void setPattern(String pattern) {
    this.pattern = pattern;
  }

  /**
   * Set the acceptable data type for this constraint.
   *
   * @param type the data type.
   */
  public void setDataType(String type) {
    this.dataType = type;
  }

  /**
   * Get the acceptable data type for this constraint.
   *
   * @return String the data type.
   */
  public String getDataType() {
    return this.dataType;
  }

  /**
   * Find out if this constraint has a custom error message to display if the regular expression pattern match fails.
   *
   * @return true if a message exists, false otherwise
   */
  public boolean hasDescription() {
    return this.description != null;
  }

  /**
   * Set the error message to be displayed if the regular expression pattern match fails.
   *
   * @param desc the custom error message.
   */
  public void setDescription(String desc) {
    this.description = desc;
  }

  /**
   * Get the error message to be displayed if the regular expression pattern match fails.
   *
   * @return String the custom error message.
   */

  public String getDescription() {
    return MessageLookup.getMessageByName(this.description);
  }

  /**
   * Get the error message to be displayed if the regular expression pattern match fails.
   *
   * @return String the custom error message code.
   */
  public String getEncodedDescription() {
    return this.description;
  }

  public List<String> getAllowedValues() {
    return allowedValues;
  }

  //Instance variables
  private String name;
  private String pattern = null;
  private String description;
  private String dataType;
  private List<String> disallowedValues = new ArrayList<String>();
  private List<String> allowedValues = new ArrayList<String>();

  //all numeric constraints are of type double so that we can use the
  // NaN (Not a Number) constant for comparison.
  private double minIncValue = Double.NaN;
  private double maxIncValue = Double.NaN;
  private double minExcValue = Double.NaN;
  private double maxExcValue = Double.NaN;
  private double minLength = Double.NaN;
  private double maxLength = Double.NaN;

}










