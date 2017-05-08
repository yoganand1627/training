package gov.georgia.dhr.dfcs.sacwis.core.utility;

import gov.georgia.dhr.dfcs.sacwis.core.exception.RuntimeWrappedException;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/** User: mkw Date: May 8, 2003 Time: 10:05:39 AM */
public class URLHelper {
  /**
   * This method is a very simple method that encodes URLs using UTF-8.  It simplifies the process of encoding URLs by
   * trapping the checked <tt>UnsupportedEncodingException</tt> and rethrowing it as a <tt>RuntimeWrappedException</tt>.
   * This is acceptable becuase UTF-8 should always be supported.
   *
   * @param url URL to encode
   * @return Encoded URL
   */
  public static String encode(String url) {
    try {
      url = URLEncoder.encode(url, "UTF-8");
    }
    catch (UnsupportedEncodingException e) {
      throw new RuntimeWrappedException(e);
    }
    return url;
  }


  /**
   * This method is a very simple method that decodes URLs using UTF-8.  It simplifies the process of decoding URLs by
   * trapping the checked <tt>UnsupportedEncodingException</tt> and rethrowing it as a <tt>RuntimeWrappedException</tt>.
   * This is acceptable becuase UTF-8 should always be supported.
   *
   * @param url URL to decode
   * @return Decoded URL
   */
  public static String decode(String url) {
    try {
      url = URLDecoder.decode(url, "UTF-8");
    }
    catch (UnsupportedEncodingException e) {
      throw new RuntimeWrappedException(e);
    }
    return url;
  }
}
