package gov.georgia.dhr.dfcs.sacwis.web.intake;

import java.io.Serializable;

import gov.georgia.dhr.dfcs.sacwis.structs.output.CallEntryRtrvOut;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FacilRtrvOutRec;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PersListRtrvStruct_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT76DO_ARRAY;

/*
* Change History:
*  Date      User      Description
*  --------  --------  --------------------------------------------------
* 07/13/04 ochumd       Sir 22934 - Replaced all references to cint19d with cint76d.
* <pre>
*/

/**
 * <p>Title: Intake Data Bean</p> <p>Description: The Intake Data bean is used by both the Call Information and Intake
 * Actions conversations. When the user attempts to Save and Submit, Save and Close, or Save and Assign, the
 * PopulateDataBean.populate() method is called which retrieves what has been most currently saved to the database in
 * both conversations. The return objects are set into the IntakeDataBean and the entire IntakeDataBean is then passed
 * to the CreateErrorList.create() method for validation.</p> <p>Copyright: Copyright (c) 2002</p>
 *
 * @author Jenn Casdorph
 * @version 1.0
 */
public class IntakeDataBean implements Serializable {
  private CallEntryRtrvOut callEntryDecision = null;
  private PersListRtrvStruct_ARRAY personlistarray = null;
  private FacilRtrvOutRec facility = null;
  private ROWCINT76DO_ARRAY allegListArray = null;
  private boolean hasCallNarr = false;

  public IntakeDataBean() {
  }

  public CallEntryRtrvOut getCallEntryDecision() {
    return callEntryDecision;
  }

  public void setCallEntryDecision(CallEntryRtrvOut callEntryDecision) {
    this.callEntryDecision = callEntryDecision;
  }

  public void setPersonlistarray(PersListRtrvStruct_ARRAY personlistarray) {
    this.personlistarray = personlistarray;
  }

  public PersListRtrvStruct_ARRAY getPersonlistarray() {
    return personlistarray;
  }

  public void setFacility(FacilRtrvOutRec facility) {
    this.facility = facility;
  }

  public FacilRtrvOutRec getFacility() {
    return facility;
  }

  public void setAllegListArray(ROWCINT76DO_ARRAY allegListArray) {
    this.allegListArray = allegListArray;
  }

  public ROWCINT76DO_ARRAY getAllegListArray() {
    return allegListArray;
  }

  public void setHasCallNarr(boolean hasCallNarr) {
    this.hasCallNarr = hasCallNarr;
  }

  public boolean hasCallNarr() {
    return hasCallNarr;
  }
}
