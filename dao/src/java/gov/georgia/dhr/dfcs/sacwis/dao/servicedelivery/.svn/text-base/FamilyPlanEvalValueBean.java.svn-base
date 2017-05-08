package gov.georgia.dhr.dfcs.sacwis.dao.servicedelivery;

import java.util.Collection;
import java.util.Date;

import gov.georgia.dhr.dfcs.sacwis.core.base.BaseValueBean;
import gov.georgia.dhr.dfcs.sacwis.dao.common.EventValueBean;

/** @todo add javadocs */

/**
 * Holds all data pertaining to a Family Plan Evaluation.
 *
 * @author Jason Rios, February 6th, 2003
 *         <p/>
 *         <pre>
 *                         Change History:
 *                          Date      User      Description
 *                          --------  --------  --------------------------------------------------
 *                          07/01/04  RIOSJA    SIR 14974 - Added interpreterTranslatorIsNeeded property
 *                                              which will be set to true if any principal in the family
 *                                              plan has person characteristics of 'Limited English
 *                                              Proficiency' or 'Hearing Impaired'.
 *                         </pre>
 */
public class FamilyPlanEvalValueBean extends BaseValueBean {
  // instance variables
  private int caseId = 0;
  private int stageId = 0;
  private int familyPlanEventId = 0;
  private int evalId = 0;
  private Date evalDateLastUpdate = null;
  private EventValueBean evalEvent = new EventValueBean();
  private Date dateEvalCompleted = null;
  private Date dateNextEvalDue = null;
  private Collection evalItems = null;
  private boolean interpreterTranslatorIsNeeded = false;  /* RIOSJA, SIR 14974 */

  /** Constructor */
  public FamilyPlanEvalValueBean() {
  }

  /* RIOSJA, SIR 14974 */
  public boolean getInterpreterTranslatorIsNeeded() {
    return interpreterTranslatorIsNeeded;
  }

  public int getCaseId() {
    return caseId;
  }

  public Date getDateEvalCompleted() {
    return dateEvalCompleted;
  }

  public Date getDateNextEvalDue() {
    return dateNextEvalDue;
  }

  public Collection getEvalItems() {
    return evalItems;
  }

  public Date getEvalDateLastUpdate() {
    return evalDateLastUpdate;
  }

  public EventValueBean getEvalEvent() {
    return evalEvent;
  }

  public int getEvalId() {
    return evalId;
  }

  public int getFamilyPlanEventId() {
    return familyPlanEventId;
  }

  public int getStageId() {
    return stageId;
  }

  public void setCaseId(int caseId) {
    this.caseId = caseId;
  }

  public void setDateEvalCompleted(Date dateEvalCompleted) {
    this.dateEvalCompleted = dateEvalCompleted;
  }

  public void setDateNextEvalDue(Date dateNextEvalDue) {
    this.dateNextEvalDue = dateNextEvalDue;
  }

  public void setEvalItems(Collection evalItems) {
    this.evalItems = evalItems;
  }

  public void setEvalDateLastUpdate(Date evalDateLastUpdate) {
    this.evalDateLastUpdate = evalDateLastUpdate;
  }

  public void setEvalEvent(EventValueBean evalEvent) {
    this.evalEvent = evalEvent;
  }

  public void setEvalId(int evalId) {
    this.evalId = evalId;
  }

  public void setFamilyPlanEventId(int familyPlanEventId) {
    this.familyPlanEventId = familyPlanEventId;
  }

  public void setStageId(int stageId) {
    this.stageId = stageId;
  }

  /* RIOSJA, SIR 14974 */
  public void setInterpreterTranslatorIsNeeded(boolean interpreterTranslatorIsNeeded) {
    this.interpreterTranslatorIsNeeded = interpreterTranslatorIsNeeded;
  }
}