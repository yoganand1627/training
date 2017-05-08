package gov.georgia.dhr.dfcs.sacwis.web.core.validation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.StringTokenizer;

import javax.management.timer.Timer;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.grnds.facility.log.GrndsTrace;

import gov.georgia.dhr.dfcs.sacwis.core.validation.exception.RepostCodeMismatchException;

/**
 * <p>Title: </p> <p>Description: </p> <p>Copyright: Copyright (c) 2002</p> <p>Company: </p>
 *
 * @author unascribed
 * @version 1.0
 */

public final class RepostCheckUtility {

  private RepostCheckUtility() {
    // private no-arg constructor prevents instantiation and subclassing
    //  (this is confusing enough w/o subclasses!!)
  }

  public RepostCheckUtility getInstance() {
    return new RepostCheckUtility();
  }

  /**
   * Retrieve the code for the specified key in the RepostCodes attribute and return it This method is necessary because
   * we can't return both a key and code from the method that creates them.  Therefore, the create method creates a key
   * and code, but only returns the key.
   *
   * @param codeKey
   * @param request
   * @return key for the given code
   */
  public static String getCodeForKey(String codeKey, HttpServletRequest request) {
    HttpSession session = request.getSession();
    //Retrieve the request attribute used to store the repost codes
    postCodes = (Map) request.getAttribute(REPOST_CODES_ATTRIBUTE_NAME);
    //If the postCodes attribute was null, create it and return a blank string for the code
    if (postCodes == null) {
      postCodes = new HashMap();
      request.setAttribute(REPOST_CODES_ATTRIBUTE_NAME, postCodes);
      return "";
    }
    //If the specified codeKey is null or blank, return a blank string for the code
    if (codeKey == null || "".equals(codeKey)) {
      return "";
    }
    if (session == null) {
      throw new IllegalArgumentException("The session must exist in order to get a code for a code key.");
    }

    //If we've made it this far, the postCodes and codeKey are valid.
    //Retrieve the code value for the given key
    Long codeKeyLong = Long.decode(codeKey);
    String code = (String) postCodes.get(codeKeyLong);
    if (code == null) {
      return "";
    }
    return code;
  }

  /**
   * Create a key and corresponding code in the postCodes Can only return one string, so the key is returned.  Another
   * method is used to retrieve the code value for this key.
   *
   * @param request
   * @return the key for the code.
   */
  public static String createCodeKey(HttpServletRequest request) {
    HttpSession session = request.getSession();
    //Retrieve the postCodes from the session - must use session vs. request
    //Using request causes us to lose previously created keys.
    postCodes = (Map) session.getAttribute(REPOST_CODES_ATTRIBUTE_NAME);
    requestPostCodes = (Map) request.getAttribute(REPOST_CODES_ATTRIBUTE_NAME);
    //If postCodes is null, create a new one to prevent NPE later
    if (postCodes == null) {
      postCodes = new HashMap();
    }
    if (requestPostCodes == null) {
      requestPostCodes = new HashMap();
    }
    //Ensure that the random number generator is not null.
    if (random == null) {
      random = new Random(System.currentTimeMillis());
    }

    //Create the key and code values
    Long uniqueKey = createRandomKey(); // method for creating unique incremental keys
    String uniqueCode = createRandomCode(); // method for creating random codes

    //Add the key and code into the postCodes
    postCodes.put(uniqueKey, uniqueCode);
    requestPostCodes.put(uniqueKey, uniqueCode);

    //Set the codes into session also
    session.setAttribute(REPOST_CODES_ATTRIBUTE_NAME, postCodes);
    //Set the updated post codes back into the request
    request.setAttribute(REPOST_CODES_ATTRIBUTE_NAME, requestPostCodes);
    GrndsTrace.msg(TRACE_TAG, 7,
                   "Placing code " + uniqueCode + " into postCodes with key " + uniqueKey + ".");
    return uniqueKey.toString();
  }

  /**
   * Validate the buttons comparing values stored on the page to values stored in a persistent store ( session, cookie,
   * or DB )
   *
   * @param buttonName
   * @param request
   * @throws RepostCodeMismatchException
   */
  public static void validateRepostSubmit(String buttonName, HttpServletRequest request)
          throws RepostCodeMismatchException {
    GrndsTrace.enterScope(TRACE_TAG + ".validateAddDeleteSubmit");
    HttpSession session = request.getSession(false);
    /**
     * If session is not null and we aren't overriding the validation,
     * use keys from session to validate
     */
    if (session != null && request.getAttribute(TIMEOUT_OVERRIDE_ATTRIBUTE) == null
        && session.getAttribute(REPOST_CODES_ATTRIBUTE_NAME) != null) {
      postCodes = (Map) session.getAttribute(REPOST_CODES_ATTRIBUTE_NAME);
      if (postCodes == null) {
        postCodes = new HashMap();
      }
      String validationKeyString = request.getParameter(buttonName + ADD_DEL_SUBMIT_KEY_TAG);
      if (validationKeyString == null || "".equals(validationKeyString)) {
        throw new RepostCodeMismatchException("No validation key posted with Add Button!");
      }
      String validationCode = request.getParameter(buttonName + ADD_DEL_SUBMIT_CODE_TAG);
      if (validationCode == null || "".equals(validationCode)) {
        throw new RepostCodeMismatchException("No validation code posted with Add Button!");
      }
      String correctCode = (String) postCodes.get(Long.decode(validationKeyString));
      if (correctCode == null || !validationCode.equals(correctCode)) {
        throw new RepostCodeMismatchException();
      }
      GrndsTrace.msg(TRACE_TAG, 7,
                     "Matched restrictRepost parameters.  Clearing key " + correctCode + " from postCodes.");
      //If we got to here, the validation info from the page matched what was in
      // postCodes, so we will clear that key and return properly.
      postCodes.remove(Long.decode(validationKeyString));
      session.setAttribute(REPOST_CODES_ATTRIBUTE_NAME, postCodes);
    }
    /**
     * If there's no session, try to pull the repost values from the cookie
     */
    else {
      //If the request has been tagged to ignore this validation, skip it.
      if (request.getAttribute(TIMEOUT_OVERRIDE_ATTRIBUTE) == null) {
        //If there is more than one RepostValidation button, get the existing map
        postCodes = (Map) request.getAttribute(REPOST_CODES_ATTRIBUTE_NAME);
        if (postCodes == null) {
          postCodes = new HashMap();
        }
        String validationKeyString = request.getParameter(buttonName + ADD_DEL_SUBMIT_KEY_TAG);
        if (validationKeyString == null || "".equals(validationKeyString)) {
          throw new RepostCodeMismatchException("No validation key posted with Add Button!");
        }
        String validationCode = request.getParameter(buttonName + ADD_DEL_SUBMIT_CODE_TAG);
        if (validationCode == null || "".equals(validationCode)) {
          throw new RepostCodeMismatchException("No validation code posted with Add Button!");
        }

        //Get the key and code from the cookie and validate against request
        String key = null;
        String correctCode = null;
        Map cookiePostCodes = getPostCodesFromCookie(request);
        if (cookiePostCodes == null) {
          cookiePostCodes = new HashMap();
        }
        Iterator postCodesIterator = cookiePostCodes.keySet().iterator();
        //Loop through postCodes in cookies looking for key and code match
        while (postCodesIterator.hasNext()) {
          Object object = postCodesIterator.next();
          if (object != null) {
            key = (String) object;
            if (validationKeyString.equals(key)) {
              correctCode = (String) cookiePostCodes.get(key);
            }
          }
        }

        //If code found in cookie is Not valid, throw exception
        if (correctCode == null || !validationCode.equals(correctCode)) {
          throw new RepostCodeMismatchException();
        }

        GrndsTrace.msg(TRACE_TAG, 7,
                       "Matched restrictRepost parameters.  Clearing key " + validationKeyString + " from postCodes.");
        //If we got to here, the validation info from the page matched what was in
        // postCodes, so we will clear that key and return properly.
        postCodes.remove(Long.decode(validationKeyString));
        request.setAttribute(REPOST_CODES_ATTRIBUTE_NAME, postCodes);
      }

    }
    GrndsTrace.exitScope(TRACE_TAG + ".validateAddDeleteSubmit");
  }

  /** Method for creating random codes */
  private static String createRandomCode() {
    return String.valueOf(Math.abs(random.nextInt()));
  }

  /** Method for creating unique incremental keys */
  private static Long createRandomKey() {
    try {
      //Use timeNow to create an incremental prefix
      String timeNow = String.valueOf(System.currentTimeMillis());
      String randomSuffix = String.valueOf(Math.abs(random.nextInt()));
      while (randomSuffix.length() < 10) {
        randomSuffix = "0" + randomSuffix;
      }
      return Long.decode(timeNow.substring(0, timeNow.length() - 4) + randomSuffix);
    }
    catch (Exception e) {
      e.printStackTrace(System.out);
      return (long) 0;
    }
  }

  /**
   * Clean Old Repost Codes out of this object
   *
   * @deprecated
   */
  public static void cleanupOldRepostCodes() {
    GrndsTrace.msg(TRACE_TAG, 7,
                   "Inside cleanupOldRepostCodes.");
    StringBuffer stb = new StringBuffer(String.valueOf(System.currentTimeMillis() - Timer.ONE_HOUR));
    stb.delete(stb.length() - 4, stb.length());
    stb.append("0000000000");
    Long compareCode = Long.decode(stb.toString());

    // Find the keys in 1 loop and delete them in the next to minimize
    //   the time spent in the synchronized block below.
    Iterator keyItr = postCodes.keySet().iterator();
    Set delKeySet = new HashSet();
    while (keyItr.hasNext()) {
      Long key = (Long) keyItr.next();
      if (compareCode.compareTo(key) > 0) {
        delKeySet.add(key);
      }
    }

    Iterator delKeyItr = delKeySet.iterator();
    synchronized (postCodes) {
      while (delKeyItr.hasNext()) {
        Long delKey = (Long) delKeyItr.next();
        postCodes.remove(delKey);
        GrndsTrace.msg(TRACE_TAG, 7,
                       "Removed key " + delKey + " from postCodes HashMap.");
      }
    }
  }

  /**
   * Create a string from the key/code pairs in the current request This string will be used as the value for a
   * RestrictRepostCookie.  It is necessary to use one cookie value rather than multiple ones in order to prevent the
   * proliferation of key/code pairs set into the site's cookie.
   *
   * @param request current request containing repost check utility values
   * @return string with key/code pairs
   * @todo Add Error Handling
   */
  public static String getCodeKeyString(HttpServletRequest request) {
    //Get the post codes from request
    postCodes = (Map) request.getAttribute(REPOST_CODES_ATTRIBUTE_NAME);
    //Create a post codes hashmap and put it on request.
    if (postCodes == null) {
      postCodes = new HashMap();
      request.setAttribute(REPOST_CODES_ATTRIBUTE_NAME, postCodes);
      return "";
    }

    //Initialize variables necessary to get key/code values from the postCodes
    Iterator iterator = postCodes.keySet().iterator();
    String key = "";
    Long keyLong = null;
    String code = "";
    StringBuffer codeKeyCookie = new StringBuffer();
    //Loop through all of the postCodes keys
    while (iterator.hasNext()) {
      keyLong = (Long) iterator.next();
      code = (String) postCodes.get(keyLong);
      //Append the postCode key/value pair to the stringbuffer with separators
      codeKeyCookie.append(keyLong.toString());
      codeKeyCookie.append(COOKIE_KEY_VALUE_SEPARATOR);
      codeKeyCookie.append(code);
      codeKeyCookie.append(COOKIE_PAIR_SEPARATOR);
    }
    return codeKeyCookie.toString();
  }

  /**
   * Get the array of Post Codes from the current Restrict Repost cookie
   *
   * @param request
   * @return
   * @todo Add Error Handling
   */
  public static Map getPostCodesFromCookie(HttpServletRequest request) {
    Cookie[] cookies = request.getCookies();
    Cookie cookie = null;
    String key = "";
    String code = "";
    Map postCodes = null;
    //Loop through cookie array to find correct cookie
    for (int i = 0; i < cookies.length; i++) {
      cookie = cookies[i];
      if (COOKIE_NAME.equals(cookie.getName())) {
        postCodes = parseCookieValue(cookie.getValue());
      }
    }
    return postCodes;
  }

  /**
   * Parse a cookie value into a hashmap using the separators defined in this class
   *
   * @param cookieValue
   * @return
   * @todo Add Error Handling
   */
  private static Map parseCookieValue(String cookieValue) {
    Map postCodes = new HashMap();
    String pair, key, code = null;
    String[] pairArray = null;
    StringTokenizer st = new StringTokenizer(cookieValue, COOKIE_PAIR_SEPARATOR);
    //Parse each key/code pair from the cookie
    while (st.hasMoreTokens()) {
      pair = st.nextToken();
      //Split each key/code pair into strings and put into the postCodes hashmap
      pairArray = pair.split(COOKIE_KEY_VALUE_SEPARATOR);
      key = pairArray[0];
      if (key == null) {
        key = "";
      }
      code = pairArray[1];
      if (code == null) {
        code = "";
      }
      //Put the key and code value into the Map
      postCodes.put(key, code);
    }
    return postCodes;
  }

  public static boolean removeSubmittedRepostCodesFromSession(HttpServletRequest request) {
    HttpSession session = request.getSession();
    java.util.Enumeration e = request.getParameterNames();
    int cnt = 0;
    while (e.hasMoreElements()) {
      String parameter = (String) e.nextElement();
      cnt++;
      if (parameter.endsWith(ADD_DEL_SUBMIT_KEY_TAG)) {
        postCodes.remove(Long.decode(request.getParameter(parameter)));
      }
    }
    return true;
  }

  private static Random random = new Random(System.currentTimeMillis());
  private static Map postCodes = null;
  private static Map requestPostCodes = null;
  private static String TRACE_TAG = "RepostCheckUtility";
  public static String REPOST_CODES_ATTRIBUTE_NAME = "RepostCodesMap";
  public static final String ADD_DEL_SUBMIT_KEY_TAG = "RepostValidationKey";
  public static final String ADD_DEL_SUBMIT_CODE_TAG = "RepostValidationCode";
  public static final String TIMEOUT_OVERRIDE_ATTRIBUTE = "TimeoutOverride";
  public static final String COOKIE_PAIR_SEPARATOR = "S";
  public static final String COOKIE_KEY_VALUE_SEPARATOR = "_";
  public static final String COOKIE_NAME = "RepostCodesCookie";
}

