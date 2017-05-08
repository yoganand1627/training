//DO NOT MAKE ANY CHANGES TO THIS FILE
//IT IS GENERATED
//see Matthew McClain (PRSmmcclain) if a change needs to be made

package gov.georgia.dhr.dfcs.sacwis.dao.fce;

import java.io.Serializable;
import java.util.Date;

import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;

public class PlacementDB
        implements Serializable {
  public static final String DT_EVENT_OCCURRED_STRING = "dtEventOccurredString";
  public static final String DT_EVENT_OCCURRED_TIME = "dtEventOccurredTime";
  public static final String CD_EVENT_STATUS = "cdEventStatus";
  public static final String TXT_DESCRIPTION = "txtDescription";
  public static final String NM_PERSON_FULL = "nmPersonFull";

  protected boolean hasDtEventOccurred = false;
  protected Date dtEventOccurred = null;
  protected boolean hasCdEventStatus = false;
  protected String cdEventStatus = null;
  protected boolean hasTxtDescription = false;
  protected String txtDescription = null;
  protected boolean hasNmPersonFull = false;
  protected String nmPersonFull = null;

  public boolean hasDtEventOccurred() {
    return hasDtEventOccurred;
  }

  public Date getDtEventOccurred() {
    return dtEventOccurred;
  }

  public Date getDtEventOccurredObject() {
    return dtEventOccurred;
  }

  public String getDtEventOccurredString() {
    return toString(dtEventOccurred);
  }

  public long getDtEventOccurredTime() {
    return toTime(dtEventOccurred);
  }

  public void setDtEventOccurred(Date dtEventOccurred) {
    this.hasDtEventOccurred = true;
    if ((dtEventOccurred != null) &&
        (dtEventOccurred.getTime() == 0)) {
      dtEventOccurred = null;
    }
    this.dtEventOccurred = dtEventOccurred;
  }

  public void setDtEventOccurredString(String dtEventOccurredString) {
    this.hasDtEventOccurred = true;
    this.dtEventOccurred = toDate(dtEventOccurredString);
  }

  public void setDtEventOccurredTime(long dtEventOccurredTime) {
    this.hasDtEventOccurred = true;
    this.dtEventOccurred = toDate(dtEventOccurredTime);
  }

  public boolean hasCdEventStatus() {
    return hasCdEventStatus;
  }

  public String getCdEventStatus() {
    if (cdEventStatus == null) {
      return "";
    }
    return cdEventStatus;
  }

  public String getCdEventStatusObject() {
    return cdEventStatus;
  }

  public void setCdEventStatus(String cdEventStatus) {
    this.hasCdEventStatus = true;
    this.cdEventStatus = cdEventStatus;
  }

  public boolean hasTxtDescription() {
    return hasTxtDescription;
  }

  public String getTxtDescription() {
    if (txtDescription == null) {
      return "";
    }
    return txtDescription;
  }

  public String getTxtDescriptionObject() {
    return txtDescription;
  }

  public void setTxtDescription(String txtDescription) {
    this.hasTxtDescription = true;
    this.txtDescription = txtDescription;
  }

  public boolean hasNmPersonFull() {
    return hasNmPersonFull;
  }

  public String getNmPersonFull() {
    if (nmPersonFull == null) {
      return "";
    }
    return nmPersonFull;
  }

  public String getNmPersonFullObject() {
    return nmPersonFull;
  }

  public void setNmPersonFull(String nmPersonFull) {
    this.hasNmPersonFull = true;
    this.nmPersonFull = nmPersonFull;
  }

  public void copyInto(PlacementDB placementDB) {
    if (hasDtEventOccurred) {
      placementDB.setDtEventOccurred(dtEventOccurred);
    }
    if (hasCdEventStatus) {
      placementDB.setCdEventStatus(cdEventStatus);
    }
    if (hasTxtDescription) {
      placementDB.setTxtDescription(txtDescription);
    }
    if (hasNmPersonFull) {
      placementDB.setNmPersonFull(nmPersonFull);
    }
  }

/*
  public static PlacementDB readFromRequest(HttpServletRequest request) {
    PlacementDB placementDB = new PlacementDB();
    populateWithRequest(placementDB, request);
    return placementDB;
  }


  public static void populateWithRequest(PlacementDB placementDB,
                                         HttpServletRequest request) {

    Map map = request.getParameterMap();
    if (map.containsKey(DT_EVENT_OCCURRED_STRING)) {
      placementDB.setDtEventOccurredString(ContextHelper.getStringSafe(request, DT_EVENT_OCCURRED_STRING));
    }
    if (map.containsKey(DT_EVENT_OCCURRED_TIME)) {
      placementDB.setDtEventOccurredTime(ContextHelper.getLongSafe(request, DT_EVENT_OCCURRED_TIME));
    }
    if (map.containsKey(CD_EVENT_STATUS)) {
      placementDB.setCdEventStatus(ContextHelper.getStringSafe(request, CD_EVENT_STATUS));
    }
    if (map.containsKey(TXT_DESCRIPTION)) {
      placementDB.setTxtDescription(ContextHelper.getStringSafe(request, TXT_DESCRIPTION));
    }
    if (map.containsKey(NM_PERSON_FULL)) {
      placementDB.setNmPersonFull(ContextHelper.getStringSafe(request, NM_PERSON_FULL));
    }
  }
*/

  public String toString() {
    return
            "BEGIN bean: Placement\n" +
            " dtEventOccurred: " + dtEventOccurred + "\n" +
            " cdEventStatus: " + cdEventStatus + "\n" +
            " txtDescription: " + txtDescription + "\n" +
            " nmPersonFull: " + nmPersonFull + "\n" +
            "END bean: Placement\n";
  }

  public static Boolean isTrueBoolean(String string) {
    if (string == null) {
      return null;
    }
    return new Boolean(isTrue(string));
  }

  public static boolean isTrue(String string) {
    return ((string != null) &&
            (string.equals("Y") || string.equals("1")));
  }

  /** Similar to StringHelper.isFalse, except it handles null and "1" */
  public static boolean isFalse(String string) {
    return (isTrue(string) == false);
  }

  /** true  --> "Y" false --> "N" */
  public static String toCharIndicator(boolean value) {
    if (value) {
      return "Y";
    }
    return "N";
  }

  public static String toCharIndicator(Boolean value) {
    if (value == null) {
      return null;
    }
    if (value.booleanValue()) {
      return "Y";
    }
    return "N";
  }

  //copied from PalDB
  protected static Date toDate(String string) {
    return DateHelper.toJavaDateFromInputWithDefault(string, null);
  }

  protected static String toString(Date date) {
    return FormattingHelper.formatDate(date);
  }

  protected static long toTime(Date date) {
    if (date == null) {
      return 0;
    }
    return date.getTime();
  }

  protected static Date toDate(long time) {
    if (time == 0) {
      return null;
    }
    return new Date(time);
  }
}
