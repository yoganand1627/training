package gov.georgia.dhr.dfcs.sacwis.web.core.validation;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.apache.oro.text.perl.Perl5Util;
import org.apache.oro.text.regex.MalformedPatternException;

/**
 * Facilitates regular expression pattern matching by wrapping Apache's ORO product.
 *
 * @author Nick Sharples
 */
public class ValidationPatternMatcher implements Serializable {
  /** Default Constructor */
  private ValidationPatternMatcher() {
  }

  /**
   * Get an instance of a ValidationPatternMatcher
   *
   * @param the ValidationPatternMatcher key
   * @return a ValidationPatternMatcher
   */
  public static ValidationPatternMatcher getInstance(Object key) {
    ValidationPatternMatcher ret = null;

    if (INSTANCES.containsKey(key)) {
      ret = (ValidationPatternMatcher) INSTANCES.get(key);
    } else {
      ret = new ValidationPatternMatcher();
      INSTANCES.put(key, ret);
    }

    return ret;
  }

  /**
   * Validates a regular expression pattern
   *
   * @param pattern
   * @throws MalformedPatternException if the pattern is not a valid perl5 syntax regular expression.
   */
  public void addPattern(String pattern)
          throws MalformedPatternException {
    if (pattern.startsWith("!")) {
      pattern = pattern.substring(1);
    }

    this.m_perl.match(pattern, "");
  }

  /**
   * Determines whether regular expression pattern matches a given string.
   *
   * @param pattern a valid perl5 syntax regular expression
   * @param data    a String that may or may not match the pattern
   * @return true if the pattern matches the datas, false otherwise
   */
  public boolean match(String pattern, String data) {
    boolean inverse = pattern.startsWith("!");
    boolean result = false;

    if (inverse) {
      pattern = pattern.substring(1);
    }

    result = this.m_perl.match(pattern, data);

    if (inverse) {
      result = !result;
    }

    return result;
  }

  /**
   * Runs the substitution regexpr on the given input.
   *
   * @param pattern a valid perl5 syntax substitution regular expression
   * @param input   a String that may or may not match the pattern
   * @return the modified string
   */
  public String substitute(String expression, String input) {
    return m_perl.substitute(expression, input);
  }

  //Static constants
  private static Map INSTANCES = new HashMap();

  //Instance variables
  private Map m_cache = new HashMap();
  private Perl5Util m_perl = new Perl5Util();

}










