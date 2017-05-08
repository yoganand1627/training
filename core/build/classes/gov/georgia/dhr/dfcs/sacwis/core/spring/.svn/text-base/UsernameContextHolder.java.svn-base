/**
 * Created on Apr 10, 2007 at 11:10:41 AM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.core.spring;

/**
 * This class is located here because the username must be exposed to all layers, not just the web layer.
 */
public class UsernameContextHolder {
  private static final ThreadLocal<String> usernameHolder = new ThreadLocal<String>();

  public static void setUsername(String username) {
    if (username == null) {
      throw new IllegalArgumentException("Username cannot be null.");
    }
    // Use lowercase here for JNDI names.
    usernameHolder.set(username.toLowerCase());
  }

  public static String getUsername() {
    return usernameHolder.get();
  }

  public static void clearUsername() {
    usernameHolder.remove();
  }
}
