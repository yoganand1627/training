package gov.georgia.dhr.dfcs.sacwis.core.utility;

import java.security.SecureRandom;
/**
 *  * Usage: PasswordGenerator [option] length
 * 
 * Options:
 *          -l For only lowercase
 *          -u For only uppercase
 *          -n For only numbers
 *          -a For only alphanumeric
 *          -p For printable ASCII
 *

 * @author sriram.subramaniam
 *
 */
public class PasswordGenerator {
  String[] args = null;
  public PasswordGenerator(){
    //Generate Random 8 Alpha Numeric Character Password 
    args = new String[]{"-a","8"};
  }
  public PasswordGenerator(String[] arguments){
    //Specify your own flag and number of characters required for the password 
    args = arguments;
  }
  public String generate()throws Exception{
    int passLength = 0;
    SecureRandom wheel = SecureRandom.getInstance("SHA1PRNG");
    StringBuffer randomPassword = new StringBuffer();
    char[] lowerCase = new char[] { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
                                   'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
    char[] upperCase = new char[] { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
                                   'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
    char[] numeric = new char[] { '1', '2', '3', '4', '5', '6', '7', '8', '9', '0' };

    char[] printableAscii = new char[] { '!', '\"', '#', '$', '%', '(', ')', '*', '+', '-', '.', '/', '\'', '1', '2',
                                        '3', '4', '5', '6', '7', '8', '9', '0', ':', '<', '=', '>', '?', '@', 'A', 'B',
                                        'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
                                        'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '[', '\\', ']', '^', '_', '`', '{',
                                        '|', '}', '~', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
                                        'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

    char[] alphaNumberic = new char[] { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
                                       'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f',
                                       'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
                                       'w', 'x', 'y', 'z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0' };

    if (args.length == 2) {
      if (args[0].equals("-l")) {
        passLength = Integer.parseInt(args[1]);
        for (int i = 0; i < passLength; i++) {
          int random = wheel.nextInt(lowerCase.length);
          randomPassword.append(lowerCase[random]);
        }
      } else if (args[0].equals("-u")) {
        passLength = Integer.parseInt(args[1]);
        for (int i = 0; i < passLength; i++) {
          int random = wheel.nextInt(upperCase.length);
          randomPassword.append(upperCase[random]);
        }
      } else if (args[0].equals("-n")) {
        passLength = Integer.parseInt(args[1]);
        for (int i = 0; i < passLength; i++) {
          int random = wheel.nextInt(numeric.length);
          randomPassword.append(numeric[random]);
        }
      } else if (args[0].equals("-a")) {
        passLength = Integer.parseInt(args[1]);
        for (int i = 0; i < passLength; i++) {
          int random = wheel.nextInt(alphaNumberic.length);
          randomPassword.append(alphaNumberic[random]);
        }
      } else if (args[0].equals("-p")) {
        passLength = Integer.parseInt(args[1]);
        for (int i = 0; i < passLength; i++) {
          int random = wheel.nextInt(printableAscii.length);
          randomPassword.append(printableAscii[random]);
        }
      }
    }
    return randomPassword.toString();
  }
  public static void main(String[] args) throws Exception {
    PasswordGenerator pg = new PasswordGenerator();
    System.out.println(pg.generate());
  }
}
