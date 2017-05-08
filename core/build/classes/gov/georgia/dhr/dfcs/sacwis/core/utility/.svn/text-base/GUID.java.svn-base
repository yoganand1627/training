package gov.georgia.dhr.dfcs.sacwis.core.utility;

import gov.georgia.dhr.dfcs.sacwis.core.exception.RuntimeWrappedException;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

public class GUID extends Object {

  private static Random myRand;
  private static SecureRandom mySecureRand;

  private static byte[] s_id;

  private static final char[] HEX_MAP = new char[256];

  public static final String TRACE_TAG = "GUID";

  /*
   * Static block to take care of one time secureRandom seed.
   * It takes a few seconds to initialize SecureRandom.  You might
   * want to consider removing this static block or replacing
   * it with a "time since first loaded" seed to reduce this time.
   * This block will run only once per JVM instance.
   */

  static {
    mySecureRand = new SecureRandom();
    long secureInitializer = mySecureRand.nextLong();
    myRand = new Random(secureInitializer);
    try {
      s_id = InetAddress.getLocalHost().getAddress();
    }
    catch (UnknownHostException e) {
      e.printStackTrace();
    }
    // populate the hex map for quick conversion to a char array
    String hexChars = "0123456789ABCDEF";
    for (int i = 0; i < 256; i++) {
      HEX_MAP[i] = hexChars.charAt(i < 16 ? i : i >> 4);
    }
  }


  /*
   * This class should not be instantiated.
   */
  private GUID() {
    // placeholder
  }


  /*
   * Method to generate the random GUID
   */
  public static String getRandomGUID() {
    MessageDigest md5 = null;
    byte[] valueBeforeMD5 = new byte[12];

    try {
      md5 = MessageDigest.getInstance("MD5");
    }
    catch (NoSuchAlgorithmException e) {
      throw new RuntimeWrappedException(e);
    }

    long time = System.currentTimeMillis();
    long rand = 0;

    rand = myRand.nextLong();

    System.arraycopy(s_id, 0, valueBeforeMD5, 0, 4);
    valueBeforeMD5[4] = (byte) ((time >> 12) & 0xff);
    valueBeforeMD5[5] = (byte) ((time >> 8) & 0xff);
    valueBeforeMD5[6] = (byte) ((time >> 4) & 0xff);
    valueBeforeMD5[7] = (byte) (time & 0xff);
    valueBeforeMD5[8] = (byte) ((rand >> 12) & 0xff);
    valueBeforeMD5[9] = (byte) ((rand >> 8) & 0xff);
    valueBeforeMD5[10] = (byte) ((rand >> 4) & 0xff);
    valueBeforeMD5[11] = (byte) (rand & 0xff);

    // always returns 128 bits
    byte[] valueAfterMD5 = md5.digest(valueBeforeMD5);

    // format the GUID
    char[] guid = new char[]{
            HEX_MAP[valueAfterMD5[0] & 0xf], HEX_MAP[valueAfterMD5[0] & 0xf0],
            HEX_MAP[valueAfterMD5[1] & 0xf], HEX_MAP[valueAfterMD5[1] & 0xf0],
            HEX_MAP[valueAfterMD5[2] & 0xf], HEX_MAP[valueAfterMD5[2] & 0xf0],
            HEX_MAP[valueAfterMD5[3] & 0xf], HEX_MAP[valueAfterMD5[3] & 0xf0], '-',
            HEX_MAP[valueAfterMD5[4] & 0xf], HEX_MAP[valueAfterMD5[4] & 0xf0],
            HEX_MAP[valueAfterMD5[5] & 0xf], HEX_MAP[valueAfterMD5[5] & 0xf0], '-',
            HEX_MAP[valueAfterMD5[6] & 0xf], HEX_MAP[valueAfterMD5[6] & 0xf0],
            HEX_MAP[valueAfterMD5[7] & 0xf], HEX_MAP[valueAfterMD5[7] & 0xf0], '-',
            HEX_MAP[valueAfterMD5[8] & 0xf], HEX_MAP[valueAfterMD5[8] & 0xf0],
            HEX_MAP[valueAfterMD5[9] & 0xf], HEX_MAP[valueAfterMD5[9] & 0xf0], '-',
            HEX_MAP[valueAfterMD5[10] & 0xf], HEX_MAP[valueAfterMD5[10] & 0xf0],
            HEX_MAP[valueAfterMD5[11] & 0xf], HEX_MAP[valueAfterMD5[11] & 0xf0],
            HEX_MAP[valueAfterMD5[12] & 0xf], HEX_MAP[valueAfterMD5[12] & 0xf0],
            HEX_MAP[valueAfterMD5[13] & 0xf], HEX_MAP[valueAfterMD5[13] & 0xf0],
            HEX_MAP[valueAfterMD5[14] & 0xf], HEX_MAP[valueAfterMD5[14] & 0xf0],
            HEX_MAP[valueAfterMD5[15] & 0xf], HEX_MAP[valueAfterMD5[15] & 0xf0]
    };

    return new String(guid);
  }

  /*
  * Demonstraton and self test of class
  */
  //public static void main( String args[] )
  //{
  //  for( int i = 0; i < 100; i++ )
  //  {
  //    System.out.println( "RandomGUID=" + GUID.getRandomGUID() );
  //  }
  //  int testIterations = 100000;
  //  String[] testArray = new String[testIterations];
  //  long startTime = System.currentTimeMillis();
  //  for( int i = 0; i < testIterations; i++ )
  //  {
  //    testArray[i] = GUID.getRandomGUID();
  //  }
  //  System.out.println(
  //          "Total Time for " + testIterations + " GUID generations = " + ( System.currentTimeMillis() - startTime ) );
  //}
}
