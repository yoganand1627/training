package gov.georgia.dhr.dfcs.sacwis.web.admin;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.web.core.web.PullBackInfo;

/**
 * This is the StaffSearchInput bean used to determine where the user came from and where to return them to with the
 * rows from StaffSearch.
 *
 * @author Jeff Chambers November 11, 2002
 */
/*
  Change History:
   Date        User        Description
   --------  ------------  ---------------------------------------------------
   11/06/03  Todd Reser    SIR 19794 - Added PPTParticipant constant and set
                           function so when going to Staff Search from
                           PPTParticipant Radio Buttons are used instead of
                           Checkboxes.
   07/24/2005  werlem    SIR 23728 - MPS Phase II Enhancement to add Contact List and Detail to MPS.
*/

public class StaffSearchInput implements PullBackInfo, Serializable {
  private int sourcePageCode = 0;
  private boolean secMntFlag = false;
  private String destinationUrl = "";
  private List stageIdVector = new ArrayList(40);
  public static final int STAFF_MAINT = 1;
  public static final int UNIT_MAINT = 2;
  public static final int ON_CALL = 3;
  public static final int ASSIGN = 4;
  public static final int EVENT_SEARCH = 5;
  public static final int OTHER = 6;
  //SIR 18869 Added OTHER_MAINTAIN_SEARCH to handle the Staff Security Mnt page and
  //Mnt Designee
  public static final int OTHER_MAINTAIN_SEARCH = 7;
  // SPB - Added TODO for SIR 19992
  public static final int TODO = 8;
  // SIR 19794 - Added PPTParticipant
  public static final int PPTParticipant = 9;

  public static final String PULL_BACK_KEY = "StaffSearchInput";
  public static final String STAFF_SEARCH_URL = "/admin/StaffSearch/displayStaffSearch";

// Get the Source Page Code

  public int getSourcePageCode() {
    return sourcePageCode;
  }

  public void setSourcePage(int srcPg) {
    switch (srcPg) {
      case STAFF_MAINT:
      case UNIT_MAINT:
      case ON_CALL:
      case ASSIGN:
      case EVENT_SEARCH:
      case OTHER_MAINTAIN_SEARCH:
        //SIR 19794 - Added PPTParticipant
      case PPTParticipant:
      case TODO:
        this.sourcePageCode = srcPg;
        break;
      default:
        this.sourcePageCode = OTHER;
        break;
    }
  }

// Set the Source Page Code

  public void setToStaffMaint() {
    this.sourcePageCode = STAFF_MAINT;
  }

  public void setToUnitMaint() {
    this.sourcePageCode = UNIT_MAINT;
  }

  public void setToOnCall() {
    this.sourcePageCode = ON_CALL;
  }

  public void setToAssign() {
    this.sourcePageCode = ASSIGN;
  }

  public void setToEventSearch() {
    this.sourcePageCode = EVENT_SEARCH;
  }

  //Sir 19794 - Added setToPPTParticipant
  public void setToPPTParticipant() {
    this.sourcePageCode = PPTParticipant;
  }

  public void setToOther() {
    this.sourcePageCode = OTHER;
  }

  // Get and Set the Destination URL
  public String getDestinationUrl() {
    return this.destinationUrl;
  }

  public void setDestinationUrl(String url) {
    this.destinationUrl = url;
  }

  // Get and set the sceMntFlag
  public boolean getSecMntFlag() {
    return this.secMntFlag;
  }

  public void setSecMntFlag(boolean secMntFlag) {
    this.secMntFlag = secMntFlag;
  }

  // Get stage id's for Event Search
  public void addStageId(int stageId) {
    stageIdVector.add("" + stageId);
  }

  public int getStageId(int index) {
    String stageIdString = (String) stageIdVector.get(index);
    int stageId = Integer.parseInt(stageIdString);
    return stageId;
  }

  public int getNumStageIds() {
    return stageIdVector.size();
  }

  public static final String STAFF_PULL_BACK = "StaffPullBack";
}
