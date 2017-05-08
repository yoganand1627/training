package gov.georgia.dhr.dfcs.sacwis.web.core.user;

/**
 * <p>Title: UserRight</p> <p>Description: A simple object class used to compare User Profile rights</p>
 *
 * @author JEH (from MWK code)
 * @version 1.0
 */

public class UserRight implements Comparable {

  public UserRight(String rightName, String rightIndex) {
    this.rightName = rightName;
    this.rightIndex = Integer.parseInt(rightIndex);
  }

  public int compareTo(Object o1) {
    UserRight userRight1 = (UserRight) o1;
    return userRight1.rightIndex - this.rightIndex;
  }

  public String getRightName() {
    return this.rightName;
  }

  public int getRightIndex() {
    return this.rightIndex;
  }

  private String rightName;
  private int rightIndex;
}