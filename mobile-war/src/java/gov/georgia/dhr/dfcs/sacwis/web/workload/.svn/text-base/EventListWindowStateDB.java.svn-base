package gov.georgia.dhr.dfcs.sacwis.web.workload;

import java.io.Serializable;

/** Keeps track of what actions should be enabled/disabled in EventList */
public class EventListWindowStateDB
        implements Serializable {
  protected boolean newUsingEnabled = false;
  protected boolean newEnabled = false;
  protected boolean eventHistoryEnabled = false;
  protected boolean detailEnabled = false;
  protected boolean disableNew = false;
  protected boolean deleteEnabled = false;
  protected boolean continueEnabled = false;
  protected boolean editEnabled = false;

// SIR 18642 GRIMSHAN -- set a new method so that if the event list has an
// in process event for output launch, the new using pushbutton will not
// be displayed even when pagination occurs.

  public boolean getOutProc() {
    return disableNew;
  }

  public void setOutProc(boolean disableNew) {
    this.disableNew = disableNew;
  }

  public boolean getNewUsingEnabled() {
    return newUsingEnabled;
  }

  public void setNewUsingEnabled(boolean newUsingEnabled) {
    this.newUsingEnabled = newUsingEnabled;
  }
  
  public boolean getDeleteEnabled() {
    return deleteEnabled;
  }

  public void setDeleteEnabled(boolean deleteEnabled) {
    this.deleteEnabled = deleteEnabled;
  }

  public boolean getNewEnabled() {
    return newEnabled;
  }

  public void setNewEnabled(boolean newEnabled) {
    this.newEnabled = newEnabled;
  }

  public boolean getEventHistoryEnabled() {
    return eventHistoryEnabled;
  }

  public void setEventHistoryEnabled(boolean eventHistoryEnabled) {
    this.eventHistoryEnabled = eventHistoryEnabled;
  }

  public boolean getDetailEnabled() {
    return detailEnabled;
  }

  public void setDetailEnabled(boolean detailEnabled) {
    this.detailEnabled = detailEnabled;
  }
  
  public boolean getContinueEnabled() {
    return continueEnabled;
  }

  public void setContinueEnabled(boolean continueEnabled) {
    this.continueEnabled = continueEnabled;
  }
  
  public boolean getEditEnabled() {
    return editEnabled;
  }

  public void setEditEnabled(boolean editEnabled) {
    this.editEnabled = editEnabled;
  }
}


