package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.dao.OnCallCountyDAO;
import gov.georgia.dhr.dfcs.sacwis.db.OnCallCounty;
import org.hibernate.Query;

public class OnCallCountyDAOImpl extends BaseDAOImpl implements OnCallCountyDAO {
  @SuppressWarnings({"unchecked"})
  public List<Map> findOnCallCountyByCdOnCallProgramCdOnCallCountyDtOnCallStart(String cdOnCallProgram, String cdOnCallCounty,
                                                                          Date dtOnCallStart) {
    // An explanation for the following SQL statement is probably in order!
    // We are attempting to determine the ID_ON_CALL for a certain date and
    // time. We limit our search to a given program and county.
    // That's the easy part.
    // We don't know if a given time falls in a shift or block.
    // If a block, the date/time must simply fall between the start date/time
    // of the block and the end date/time of the block.
    // A shift is more complicated.
    // If a shift is from Monday to Friday from 8:00 a.m. to 5:00 p.m.,
    // the start time is < the shift end time.  We would select the shift that
    // fell between the two times and between the two dates.
    // If, on the other hand, the shift start time is > the shift end time
    // (i.e. Monday to Friday from 5:00 p.m. to 8:00 a.m. the next day),
    // the selected shift must be between the two dates and either >= the shift
    // start time or < the shift end time.  Thus we would retrieve anything
    // after 5:00 p.m. for a given day or before 8:00 a.m. on the following day.
    // Finally, caution must be used with >, <, >= and <=.
    // Note that one shift can start at 8:00 a.m. while another shift ends
    // at 8:00 a.m.  The formulas below enable the selection of the "starting"
    // shift at exactly 8:00 a.m., not the "ending" shift.
    //
    // sir #13420 added the ON_CALL_COUNTY, the region and all the A's and B's
    // to the SQL. Also added the region in output */
    //
    //
    //
    // SIR #23380 Changed sql logic to account for first and last days of shift period
    //            to ensure that early morning was not selected on first day of overnight shift period
    //            and late night was not selected on last day of overnight shift period.  For example if
    //            a shift period goes from 5/09/2005 5:00:00 PM to 5/12/2005 8:00:00 AM then the times
    //            before  8:00 AM should not be selected on 5/09 and the times after 5:00 PM should
    //            not be selected on 5/12.
    Query query = getSession().createQuery(" select new map(b.cdOnCallRegion as cdOnCallRegion, " +
                                           "                b.cdOnCallCounty as cdOnCallCounty, " +
                                           "                b.onCall.cdOnCallProgram as cdOnCallProgram, " +
                                           "                b.onCall.cdOnCallType as cdOnCallType, " +
                                           "                b.onCall.dtOnCallStart as dtOnCallStart, " +
                                           "                b.onCall.dtOnCallEnd as dtOnCallEnd, " +
                                           "                b.onCall.idOnCall as idOnCall) " +
                                           "   from OnCallCounty b " +
                                           "  where b.cdOnCallCounty = :cdOnCallCounty " +
                                           "    and ((b.onCall.cdOnCallType = 'BL' " +
                                           "          and b.onCall.dtOnCallStart <= :dtOnCallStart " +
                                           "          and b.onCall.dtOnCallEnd > :dtOnCallStart) " +
                                           "          or (b.onCall.cdOnCallType = 'SH' " +
                                           "              and to_char(b.onCall.dtOnCallStart, 'sssss') < to_char(b.onCall.dtOnCallEnd, 'sssss') " +
                                           "              and trunc(b.onCall.dtOnCallStart) <= trunc(:dtOnCallStart) " +
                                           "              and trunc(b.onCall.dtOnCallEnd) >= trunc(:dtOnCallStart) " +
                                           "              and to_char(b.onCall.dtOnCallStart, 'sssss') <= to_char(:dtOnCallStart, 'sssss') " +
                                           "              and to_char(b.onCall.dtOnCallEnd, 'sssss') > to_char(:dtOnCallStart, 'sssss')) " +
                                           "          or (b.onCall.cdOnCallType = 'SH' " +
                                           "              and to_char(b.onCall.dtOnCallStart, 'sssss') > to_char(b.onCall.dtOnCallEnd, 'sssss') " +
                                           "              and trunc(b.onCall.dtOnCallStart) = trunc(:dtOnCallStart) " +
                                           "              and trunc(b.onCall.dtOnCallEnd) > trunc(:dtOnCallStart) " +
                                           "              and (to_char(b.onCall.dtOnCallStart, 'sssss') <= to_char(:dtOnCallStart, 'sssss'))) " +
                                           "          or (b.onCall.cdOnCallType = 'SH' " +
                                           "              and to_char(b.onCall.dtOnCallStart, 'sssss') > to_char(b.onCall.dtOnCallEnd, 'sssss') " +
                                           "              and trunc(b.onCall.dtOnCallStart) < trunc(:dtOnCallStart) " +
                                           "              and trunc(b.onCall.dtOnCallEnd) = trunc(:dtOnCallStart) " +
                                           "              and to_char(b.onCall.dtOnCallEnd, 'sssss') > to_char(:dtOnCallStart, 'sssss')) " +
                                           "          or (b.onCall.cdOnCallType = 'SH' " +
                                           "              and to_char(b.onCall.dtOnCallStart, 'sssss') > to_char(b.onCall.dtOnCallEnd, 'sssss') " +
                                           "              and trunc(b.onCall.dtOnCallStart) < trunc(:dtOnCallStart) " +
                                           "              and trunc(b.onCall.dtOnCallEnd) > trunc(:dtOnCallStart) " +
                                           "              and (to_char(b.onCall.dtOnCallStart, 'sssss') <= to_char(:dtOnCallStart, 'sssss') " +
                                           "                   or to_char(b.onCall.dtOnCallEnd, 'sssss') > to_char(:dtOnCallStart, 'sssss')))) ");
    query.setString("cdOnCallCounty", cdOnCallCounty);
    query.setTimestamp("dtOnCallStart", dtOnCallStart);
    return (List<Map>) query.list();
  }

  @SuppressWarnings({"unchecked"})
  public List<Map> findOnCallCountyByIdOnCallCountyCdOnCallRegion(int idOnCall, String cdOnCallRegion) {
    Query query = getSession().createQuery(" select new map(occ.cdOnCallCounty as cdOnCallCounty, " +
                                           "                occ.dtLastUpdate as dtLastUpdate) " +
                                           "    from OnCallCounty occ " +
                                           "   where occ.cdOnCallRegion = :cdOnCallRegion " +
                                           "     and occ.onCall.idOnCall = :idOnCall " +
                                           "order by occ.cdOnCallCounty ");

    query.setInteger("idOnCall", idOnCall);
    query.setString("cdOnCallRegion", cdOnCallRegion);
    return (List<Map>) query.list();
  }

  public void saveOnCallCounty(OnCallCounty onCallCounty) {
    getSession().saveOrUpdate(onCallCounty);
  }

  public int deleteOnCallCounty(int idOnCall) {
    Query query = getSession().createQuery("delete from OnCallCounty o " +
                                           " where o.onCall.idOnCall = :idOnCall ");
    query.setInteger("idOnCall", idOnCall);
    return query.executeUpdate();
  }

}
