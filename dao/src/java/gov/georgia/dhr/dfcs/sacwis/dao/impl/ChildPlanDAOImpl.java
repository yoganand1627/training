package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.dao.ChildPlanDAO;
import gov.georgia.dhr.dfcs.sacwis.db.ChildPlan;
import gov.georgia.dhr.dfcs.sacwis.db.FccpChild;
import gov.georgia.dhr.dfcs.sacwis.db.FccpChildCbx;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;

public class ChildPlanDAOImpl extends BaseDAOImpl implements ChildPlanDAO {

/*  public ChildPlan findChildPlanAndEventByIdPerson(int idPerson) {
    Query query = getSession().createQuery("      from ChildPlan c " +
                                           "join fetch c.event " +
                                           "     where c.person.idPerson = :idPerson " +
                                           "       and c.event.dtEventOccurred = " +
                                           "           (select max(c1.event.dtEventOccurred) " +
                                           "              from ChildPlan c1 " +
                                           "             where c1.person.idPerson = :idPerson )");
    query.setInteger("idPerson", idPerson);
    return (ChildPlan) firstResult(query);
  }

 public int updateChildPlan(int idChildPlanEvent, int idPerson, String cdCspPlanPermGoal, String cdCspPlanType,
                             Date dtCspPermGoalTarget, Date dtCspNextReview, String txtCspLengthOfStay,
                             String txtCspLosDiscrepancy, String txtCspParticipComment, Date dtCspPlanCompleted,
                             Date dtLastUpdate) {
    Query query = getSession().createQuery("update ChildPlan" +
                                           "    set idChildPlanEvent = :idChildPlanEvent," +
                                           "        person.idPerson = :idPerson," +
                                           "        cdCspPlanPermGoal = :cdCspPlanPermGoal," +
                                           "        cdCspPlanType = :cdCspPlanType," +
                                           "        dtCspPermGoalTarget = :dtCspPermGoalTarget," +
                                           "        dtCspNextReview = :dtCspNextReview," +
                                           "        txtCspLengthOfStay = :txtCspLengthOfStay," +
                                           "        txtCspLosDiscrepancy = :txtCspLosDiscrepancy," +
                                           "        txtCspParticipComment = :txtCspParticipComment," +
                                           "        dtCspPlanCompleted = :dtCspPlanCompleted" +
                                           "  where dtLastUpdate = :dtLastUpdate" +
                                           "    and idChildPlanEvent = :idChildPlanEvent");
    query.setInteger("idChildPlanEvent", idChildPlanEvent);
    query.setInteger("idPerson", idPerson);
    query.setString("cdCspPlanPermGoal", cdCspPlanPermGoal);
    query.setString("cdCspPlanType", cdCspPlanType);
    query.setTimestamp("dtCspPermGoalTarget", dtCspPermGoalTarget);
    query.setTimestamp("dtCspNextReview", dtCspNextReview);
    query.setString("txtCspLengthOfStay", txtCspLengthOfStay);
    query.setString("txtCspLosDiscrepancy", txtCspLosDiscrepancy);
    query.setString("txtCspParticipComment", txtCspParticipComment);
    query.setTimestamp("dtCspPlanCompleted", dtCspPlanCompleted);
    query.setTimestamp("dtLastUpdate", dtLastUpdate);
    return query.executeUpdate();
  }*/

}
