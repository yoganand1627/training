package gov.georgia.dhr.dfcs.sacwis.web.core.validation;

import gov.georgia.dhr.dfcs.sacwis.core.validation.Constraint;
import gov.georgia.dhr.dfcs.sacwis.core.validation.exception.ConstraintNotFoundException;
import gov.georgia.dhr.dfcs.sacwis.core.validation.exception.DataFormatException;
import gov.georgia.dhr.dfcs.sacwis.core.validation.exception.InvalidTypeException;
import gov.georgia.dhr.dfcs.sacwis.core.validation.exception.NullStringException;
import gov.georgia.dhr.dfcs.sacwis.core.validation.exception.OutOfRangeException;
import gov.georgia.dhr.dfcs.sacwis.core.validation.exception.PatternMismatchException;
import gov.georgia.dhr.dfcs.sacwis.core.validation.exception.StringTooLongException;
import gov.georgia.dhr.dfcs.sacwis.core.validation.exception.StringTooShortException;
import gov.georgia.dhr.dfcs.sacwis.core.validation.exception.ValueNotAllowedException;

import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.grnds.facility.log.GrndsTrace;

import org.apache.oro.text.regex.MalformedPatternException;

/**
 * A set of named Constraints. Based on code examples by Brett McLaughlin.
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
 *
 * @author Nick Sharples
 */
public class Validator implements Serializable {
  // Static constants
  private static final String TRACE_TAG = "Validator";
  private static Map<URL, Validator> INSTANCES = new HashMap<URL, Validator>();
  // Instance variables
  private final Map constraints;
  private final ValidationPatternMatcher patternMatcher;

  /**
   * Default Constructor
   *
   * @param schemaURL the URL of the schema document
   * @throws IOException if an error occurs during parsing
   */
  private Validator(URL schemaURL) throws IOException, MalformedPatternException {
    GrndsTrace.enterScope(TRACE_TAG + ".constructor");
    this.patternMatcher = ValidationPatternMatcher.getInstance(schemaURL);

    SchemaParser parser = new SchemaParser(schemaURL);
    parser.parseSchema();
    this.constraints = parser.getConstraints();

    GrndsTrace.exitScope();
  }

  /**
   * Checks the supplied data against the appropriate contraint. An appropriate <code>DataFormatException</code> is
   * thrown if the data does not conform. A <code>ConstratintNotFoundException</code> is thrown if the named constraint
   * does not exist.
   *
   * @param constraintName the name of the constraint being checked. This my be a the name of a form field
   * @param data           the data entered by the user
   * @return true if the data is valid
   * @throws DataFormatException if the data does not coform to the specified constraint
   */
  public boolean isValid(String constraintName, String data) throws DataFormatException, ConstraintNotFoundException {
    GrndsTrace.enterScope(TRACE_TAG + ".isValid");
    Object o = this.constraints.get(constraintName);
    if (o == null) {
      GrndsTrace.exitScope();
      throw new ConstraintNotFoundException("Constraint '" + constraintName + "' does not exist in schema.");
    }

    Constraint constraint = (Constraint) o;

    if (!isCorrectDataType(data, constraint.getDataType())) {
      GrndsTrace.exitScope();
      throw new InvalidTypeException(constraint, data);
    }

    if ((constraint.hasAllowedValues()) &&
        (!constraint.getAllowedValues().contains(data))) {
      GrndsTrace.exitScope();
      throw new ValueNotAllowedException(constraint, data);
    }

    if ((constraint.hasDisallowedValues()) &&
        (constraint.getDisallowedValues().contains(data))) {
      GrndsTrace.exitScope();
      throw new ValueNotAllowedException(constraint, data);
    }

    if (constraint.hasPattern()) {
      GrndsTrace.msg(TRACE_TAG, 7, "Constraint has Pattern");
      if (data == null) {
        GrndsTrace.exitScope();
        throw new DataFormatException("[" + constraint.getName() + "] null matches no pattern");
      }
      if (!this.patternMatcher.match(constraint.getPattern(), data.trim())) {
        GrndsTrace.msg(TRACE_TAG, 7, "pattern " + constraint.getPattern() + " does not match data " + data);
        GrndsTrace.exitScope();
        throw new PatternMismatchException(constraint, data);
      }

      GrndsTrace.msg(TRACE_TAG, 7, "pattern " + constraint.getPattern() + " matches data " + data);
    }

    if ((data == null) &&
        ((constraint.hasMinLength()) ||
         (constraint.hasMaxLength()))) {
      GrndsTrace.exitScope();
      throw new NullStringException(constraint);
    }
    if ((constraint.hasMinLength()) &&
        (data.length() < (int) constraint.getMinLength())) {
      GrndsTrace.exitScope();
      throw new StringTooShortException(constraint, data);
    }
    if ((constraint.hasMaxLength()) &&
        (data.length() > (int) constraint.getMaxLength())) {
      GrndsTrace.exitScope();
      throw new StringTooLongException(constraint, data);
    }

    if ((constraint.hasMinExclusive()) ||
        (constraint.hasMaxExclusive()) ||
        (constraint.hasMinInclusive()) ||
        (constraint.hasMaxInclusive())) {
      try {
        double doubleValue = new Double(data);
        if ((constraint.hasMinExclusive()) &&
            (doubleValue <= constraint.getMinExclusive())) {
          GrndsTrace.exitScope();
          throw new OutOfRangeException(constraint, data);
        }
        if ((constraint.hasMaxExclusive()) &&
            (doubleValue >= constraint.getMaxExclusive())) {
          GrndsTrace.exitScope();
          throw new OutOfRangeException(constraint, data);
        }
        if ((constraint.hasMinInclusive()) &&
            (doubleValue < constraint.getMinInclusive())) {
          GrndsTrace.exitScope();
          throw new OutOfRangeException(constraint, data);
        }
        if ((constraint.hasMaxInclusive()) &&
            (doubleValue > constraint.getMaxInclusive())) {
          GrndsTrace.exitScope();
          throw new OutOfRangeException(constraint, data);
        }
      } catch (NumberFormatException nfex) {
        GrndsTrace.exitScope();
        throw new DataFormatException("NumberFormatException in " + nfex.getMessage(), nfex);
      }
    }

    GrndsTrace.exitScope();
    return true;
  }

  /**
   * Gets the Constraints attribute of the Validator object
   *
   * @return A Hashmap of named Constraints
   */
  public Map getConstraints() {
    return this.constraints;
  }

  /**
   * Gets a named Constraint from the Validator object
   *
   * @param s the name of the constraint
   * @return The Constraint object bearing that name
   */
  public Constraint getConstraint(String s) {
    if (this.constraints.containsKey(s)) {
      return (Constraint) this.constraints.get(s);
    } else {
      return null;
    }
  }

  /**
   * Checks that the data is of the correct data type
   *
   * @param data     the user entered data
   * @param dataType the string name of the data type
   * @return true if the data can be cast to the specified data type
   */
  private boolean isCorrectDataType(String data, String dataType) {
    GrndsTrace.enterScope(TRACE_TAG + ".isCorrectDataType");
    boolean result = true;
    if (!"String".equals(dataType)) {
      Class dataClass = DataConverter.getJavaClass(dataType);
      try {
        java.lang.reflect.Constructor con = dataClass.getConstructor(String.class);
        if (con != null) {
          con.newInstance(data);
        }
      } catch (Exception ex) {
        result = false;
      }
    }
    GrndsTrace.exitScope(result);
    return result;
  }

  /**
   * Provides access to the configured <code>Validator</code> objects to implement the Singleton pattern
   *
   * @param schemaURL the URL would be used to load the schema
   * @return the configured instance of the schema
   * @throws IOException
   */
  public static Validator getInstance(URL schemaURL) throws IOException, MalformedPatternException {
    GrndsTrace.enterScope(TRACE_TAG + ".gatInstance");
    Validator ret;
    if (INSTANCES.containsKey(schemaURL)) {
      GrndsTrace.msg(TRACE_TAG, 7, "Validator found for " + schemaURL);
      ret = INSTANCES.get(schemaURL);
    } else {
      GrndsTrace.msg(TRACE_TAG, 7, "Validator not found for " + schemaURL);
      ret = new Validator(schemaURL);
      INSTANCES.put(schemaURL, ret);
    }
    GrndsTrace.exitScope();
    return ret;
  }
}
