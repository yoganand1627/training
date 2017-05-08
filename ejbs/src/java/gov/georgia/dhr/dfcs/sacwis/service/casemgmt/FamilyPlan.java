package gov.georgia.dhr.dfcs.sacwis.service.casemgmt;

import gov.georgia.dhr.dfcs.sacwis.core.exception.TimestampMismatchException;
import gov.georgia.dhr.dfcs.sacwis.dao.common.EventValueBean;
import gov.georgia.dhr.dfcs.sacwis.dao.person.PersonValueBean;
import gov.georgia.dhr.dfcs.sacwis.dao.servicedelivery.FamilyPlanItemValueBean;
import gov.georgia.dhr.dfcs.sacwis.dao.servicedelivery.FamilyPlanValueBean;

import java.util.Collection;
import java.util.List;

/**
 * Interface for the FamilyPlanBean.
 * <pre>
 * Change History:
 *  Date      User        Description
 *  --------  ----------  -----------------------------------------------------
 *  06/23/04  RIOSJA      Changed method name from "postFamilyPlanEventSeparateXA"
 *                        to "postEventSeparateXA"
 * </pre>
 */
public interface FamilyPlan {
  /**
   * Checks the given event id to determine whether or not the event was created before the initial launch of IMPACT.
   *
   * @param eventId The id of the family plan to be checked for legacy status.
   * @return Boolean Indicator that indicates whether or not the given event was created in CAPS.
   */
  public Boolean checkIfEventIsLegacy(Integer eventId);

  /**
   * Deletes an entire Family Plan Item. Restores an item to its original state as if the item had never been
   * addressed.
   *
   * @param familyPlanBeanFromState FamilyPlanValueBean containing the family plan data when the page first loaded.
   * @param itemBeanFromRequest     FamilyPlanItemValueBean containing the family plan item details to be saved to the
   *                                database.
   * @throws gov.georgia.dhr.dfcs.sacwis.core.exception.TimestampMismatchException
   *
   * @throws gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException
   *
   */
  public void deleteFamilyPlanItem(FamilyPlanValueBean familyPlanBeanFromState,
                                   FamilyPlanItemValueBean itemBeanFromRequest) throws TimestampMismatchException;

  /**
   * Deletes the selected Family Plan Task.
   *
   * @param familyPlanBeanFromState FamilyPlanValueBean containing the family plan data when the page first loaded.
   * @param itemBean                FamilyPlanItemValueBean containing the family plan item details to be saved to the
   *                                database.
   * @param indexOfTaskToDelete     The index of the task to be deleted from the database.
   * @return FamilyPlanItemValueBean The object containing the family plan item details.
   * @throws gov.georgia.dhr.dfcs.sacwis.core.exception.TimestampMismatchException
   *
   * @throws gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException
   *
   */
  public FamilyPlanItemValueBean deleteFamilyPlanTask(FamilyPlanValueBean familyPlanBeanFromState,
                                                      FamilyPlanItemValueBean itemBean, int indexOfTaskToDelete)
          throws TimestampMismatchException;

  /**
   * Retrieves the event info for the most recent risk assessment in the investigation stage.
   *
   * @param familyPlanBean FamilyPlanValueBean containing the family plan details whose risk assessment from the
   *                       investigation stage will be retrieved from the database.
   * @return EventValueBean The object containing the details of the risk assessment event from the investigation stage
   *         that led to the creation of this family stage.
   */
  public EventValueBean getRiskAssmtEvent(FamilyPlanValueBean familyPlanBean);

  /**
   * Retrieves the event details from the database for the given event id.
   *
   * @param eventId The id of the event to be queried from the database.
   * @return EventValueBean The object containing the event details.
   */
  public EventValueBean queryEvent(Integer eventId);

  /**
   * Retrieves all family plan, family plan evaluation and family assessment events given the event id of a legacy
   * family plan, family plan evalution or family assessment.
   *
   * @param eventId The id of the family plan event whose related events will be queried from the database.
   * @return List The list of events related to the given family plan event.
   */
  public List queryLegacyEvents(Integer eventId);

  /**
   * Retrieves the Family Plan details from the database.
   *
   * @param familyPlanBean FamilyPlanValueBean containing the family plan search parameters.
   * @return FamilyPlanValueBean The object containing the family plan details.
   */
  public FamilyPlanValueBean queryFamilyPlan(FamilyPlanValueBean familyPlanBean);

  /**
   * Retrieves the event id of the family plan to which the given evaluation belongs.
   *
   * @param evalEventId The event id of the evaluation whose corresponding family plan event id will be retrieved.
   * @return familyPlanEventId The event id of the family plan to which the given evaluation belongs.
   */
  public Integer queryFamilyPlanEventId(Integer evalEventId);

  /**
   * Retrieves all approved family plans for the stage that were created in IMPACT.
   *
   * @param familyPlanBean FamilyPlanValueBean containing the family plan search parameters.
   * @return approvedFamilyPlans Collection containing all approved family plans for the stage that were created in
   *         IMPACT.
   */
  public Collection<FamilyPlanValueBean> queryApprovedFamilyPlans(FamilyPlanValueBean familyPlanBean);

  /**
   * Retrieves the Family Plan Item details from the database.
   *
   * @param familyPlanItemBean FamilyPlanItemValueBean containing the family plan item search parameters.
   * @return FamilyPlanItemValueBean The object containing the family plan item details.
   */
  public FamilyPlanItemValueBean queryFamilyPlanItem(FamilyPlanItemValueBean familyPlanItemBean);

  /**
   * Saves the permanency goal for each child in the family plan or family plan evaluation.
   *
   * @param familyPlanBeanFromState   FamilyPlanValueBean containing the family plan data when the page first loaded.
   * @param goalsCommentFromRequest   The new Goal Comment value.
   * @param childrenInPlanFromState   The list of children with the original value of their permanency goal.
   * @param childrenInPlanFromRequest The list of children with the new value of their permanency goal.
   * @throws gov.georgia.dhr.dfcs.sacwis.core.exception.TimestampMismatchException
   *
   * @throws gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException
   *
   */
  public void savePermanencyGoals(FamilyPlanValueBean familyPlanBeanFromState, String goalsCommentFromRequest,
                                  List<PersonValueBean> childrenInPlanFromState,
                                  List<PersonValueBean> childrenInPlanFromRequest)
          throws TimestampMismatchException;

  /**
   * Saves the family plan details to the database. Creates a new family plan event or a new family plan evaluation
   * event, if needed. Otherwise, updates the existing family plan event or family plan evaluation event. Returns the
   * event id of the event being added or updated.
   *
   * @param familyPlanBeanFromState   FamilyPlanValueBean containing the family plan data when the page first loaded.
   * @param familyPlanBeanFromRequest FamilyPlanValueBean containing the family plan data to be saved to the database.
   * @return Integer The event id of the family plan.
   * @throws gov.georgia.dhr.dfcs.sacwis.core.exception.TimestampMismatchException
   *
   * @throws gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException
   *
   */
  public Integer saveFamilyPlan(FamilyPlanValueBean familyPlanBeanFromState,
                                FamilyPlanValueBean familyPlanBeanFromRequest)
          throws TimestampMismatchException;

  /**
   * Saves the family plan item details to the database.
   *
   * @param familyPlanBeanFromState FamilyPlanValueBean containing the family plan data when the page first loaded.
   * @param itemBeanFromRequest     FamilyPlanItemValueBean containing the family plan item details to be saved to the
   *                                database.
   * @throws gov.georgia.dhr.dfcs.sacwis.core.exception.TimestampMismatchException
   *
   * @throws gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException
   *
   */
  public void saveFamilyPlanItem(FamilyPlanValueBean familyPlanBeanFromState,
                                 FamilyPlanItemValueBean itemBeanFromRequest)
          throws TimestampMismatchException;
}