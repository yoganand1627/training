package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.Date;

import gov.georgia.dhr.dfcs.sacwis.dao.OnCallDAO;
import gov.georgia.dhr.dfcs.sacwis.db.OnCall;
import org.hibernate.Query;

public class OnCallDAOImpl extends BaseDAOImpl implements OnCallDAO {

  public Date findDtLastUpdate(int idOnCall) {
    Query query = getSession().createQuery("select dtLastUpdate" +
                                           "   from OnCall" +
                                           "  where idOnCall = :idOnCall");

    query.setInteger("idOnCall", idOnCall);

    return (Date) firstResult(query);
  }

  public OnCall insertOnCall(String cdOnCallProgram, String cdOnCallType,
                             String cdOnCallRegion, String cdOnCallCounty, Date dtOnCallStart, Date dtOnCallEnd,
                             String indOnCallFilled) {
    OnCall onCall = new OnCall();
    onCall.setCdOnCallProgram(cdOnCallProgram);
    onCall.setCdOnCallType(cdOnCallType);
    onCall.setOnCallRegion(cdOnCallRegion);
    onCall.setCdOnCallCounty(cdOnCallCounty);
    onCall.setDtOnCallStart(dtOnCallStart);
    onCall.setDtOnCallEnd(dtOnCallEnd);
    onCall.setIndOnCallFilled(indOnCallFilled);
    getSession().saveOrUpdate(onCall);
    return onCall;
  }

  public int updateOnCall(String cdOnCallProgram, String cdOnCallType,
                          Date dtOnCallStart, Date dtOnCallEnd,
                          int idOnCall, Date dtLastUpdate) {

    Query query = getSession().createQuery("update OnCall oc " +
                                           "    set oc.cdOnCallProgram = :cdOnCallProgram, " +
                                           "        oc.cdOnCallType = :cdOnCallType, " +
                                           "        oc.dtOnCallStart = :dtOnCallStart, " +
                                           "        oc.dtOnCallEnd = :dtOnCallEnd" +
                                           "  where oc.idOnCall = :idOnCall " +
                                           "    and oc.dtLastUpdate = :dtLastUpdate ");

    query.setString("cdOnCallProgram", cdOnCallProgram);
    query.setString("cdOnCallType", cdOnCallType);
    query.setTimestamp("dtOnCallStart", dtOnCallStart);
    query.setTimestamp("dtOnCallEnd", dtOnCallEnd);
    query.setInteger("idOnCall", idOnCall);
    query.setTimestamp("dtLastUpdate", dtLastUpdate);
    return query.executeUpdate();
  }

  public int updateOnCallByIdOnCallDtLastUpdate(String indOnCallFilled, int idOnCall, Date dtLastUpdate) {
    Query query = getSession().createQuery("update OnCall oc " +
                                           "    set oc.indOnCallFilled = :indOnCallFilled " +
                                           "  where oc.idOnCall = :idOnCall " +
                                           "    and oc.dtLastUpdate = :dtLastUpdate ");

    query.setString("indOnCallFilled", indOnCallFilled);
    query.setInteger("idOnCall", idOnCall);
    query.setTimestamp("dtLastUpdate", dtLastUpdate);
    return query.executeUpdate();
  }

  public int deleteOnCall(int idOnCall, Date dtLastUpdate) {
    Query query = getSession().createQuery("delete from OnCall oc " +
                                           "  where oc.idOnCall = :idOnCall " +
                                           "    and oc.dtLastUpdate = :dtLastUpdate ");
    query.setInteger("idOnCall", idOnCall);
    query.setTimestamp("dtLastUpdate", dtLastUpdate);
    return query.executeUpdate();
  }
}
