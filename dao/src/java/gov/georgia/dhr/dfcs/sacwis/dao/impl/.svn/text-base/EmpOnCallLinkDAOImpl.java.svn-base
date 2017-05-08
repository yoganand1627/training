package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.EmpOnCallLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.EmpOnCallLink;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;

public class EmpOnCallLinkDAOImpl extends BaseDAOImpl implements EmpOnCallLinkDAO {

  @SuppressWarnings({"unchecked"})
  public List<Map> findEmployeeOnCallLinkByIdOnCall(int idOnCall, Date maxDate) {
    Query query = getSession().createQuery("   select new map(eocl.person.idPerson as idPerson, " +
                                           "                  eocl.nbrEmpOnCallCntctOrd as nbrEmpOnCallCntctOrd, " +
                                           "                  eocl.cdEmpOnCallDesig as cdEmpOnCallDesig, " +
                                           "                  eocl.nbrEmpOnCallPhone1 as nbrEmpOnCallPhone1, " +
                                           "                  eocl.nbrEmpOnCallExt1 as nbrEmpOnCallExt1, " +
                                           "                  eocl.nbrEmpOnCallPhone2 as nbrEmpOnCallPhone2, " +
                                           "                  eocl.nbrEmpOnCallExt2 as nbrEmpOnCallExt2, " +
                                           "                  eocl.idEmpOnCallLink as idEmpOnCallLink, " +
                                           "                  eocl.onCall.idOnCall as idOnCall, " +
                                           "                  eocl.dtLastUpdate as dtLastUpdate, " +
                                           "                  eocl.person.nmPersonFull as nmPersonFull, " +
                                           "                  eocl.cdTitle as SzCdTitle," +
                                           "                  eocl.cdPrgmCvrg as SzCdOnCallProgram, " +
                                           "                  pp.nbrPersonPhone as nbrPersonPhone) " +
                                           "     from EmpOnCallLink eocl " +
                                           "     join eocl.person p " +
                                           "left join p.personPhones pp " +
                                           "    where eocl.onCall.idOnCall = :idOnCall " +
                                           "      and (pp.cdPersonPhoneType = 'RS' or pp.cdPersonPhoneType is null) " +
                                           "      and (pp.dtPersonPhoneEnd = :maxDate or pp.dtPersonPhoneEnd is null) " +
                                           " order by eocl.nbrEmpOnCallCntctOrd asc,  " +
                                           "          pp.dtPersonPhoneStart desc ");
    query.setInteger("idOnCall", idOnCall);
    query.setTimestamp("maxDate", maxDate);
    return (List<Map>) query.list();
  }

  public Integer findIdOnCallFromEmpOnCallLinkAndOnCallByIdPersonAndDtOnCallEnd(int idPerson, Date dtOnCallEnd) {
    Query query = getSession().createQuery(
            " select e.onCall.idOnCall " +
            "   from EmpOnCallLink  e " +
            "  where e.person.idPerson =  :idPerson " +
            "    and e.onCall.dtOnCallEnd >= :dtOnCallEnd ");
    query.setInteger("idPerson", idPerson);
    query.setTimestamp("dtOnCallEnd", dtOnCallEnd);
    return (Integer) firstResult(query);
  }

  @SuppressWarnings({"unchecked"})
  public List<Map> findEmpOnCallLinkByIdOnCallAndOrderByNbrEmpOnCallCntctOrd(int idOnCall) {
    Query query = getSession()
            .createQuery(
                    "    select new map(g.person.idPerson as idPerson, " +
                    "           f.unit.idUnit as idUnit , " +
                    "           g.cdEmpOnCallDesig as cdEmpOnCallDesig, " +
                    "           g.nbrEmpOnCallPhone1 as nbrEmpOnCallPhone1, " +
                    "           g.nbrEmpOnCallExt1 as nbrEmpOnCallExt1, " +
                    "           g.nbrEmpOnCallCntctOrd as nbrEmpOnCallCntctOrd, " +
                    "           b.nmPersonFull as nmPersonFull, " +
                    "           c.dtEmpLastAssigned as dtEmpLastAssigned, " +
                    "           d.nmOfficeName as nmOfficeName, " +
                    "           e.cdJobBjn as cdJobBjn, " +
                    "           a.nbrPersonPhone as nbrPersonPhone, " +
                    "           a.nbrPersonPhoneExtension as nbrPersonPhoneExtension)" +
                    "     from  PersonPhone a , " +
                    "           Employee c , " +
                    "           Office d , " +
                    "           EmpJobHistory e , " +
                    "           UnitEmpLink f , " +
                    "           EmpOnCallLink g " +
                    "right join a.person b  " +
                    "     where g.onCall.idOnCall = :idOnCall " +
                    "       and g.person.idPerson = b.idPerson " +
                    "       and g.person.idPerson = c.person.idPerson " +
                    "       and d.idOffice = c.office.idOffice " +
                    "       and e.idEmpJobHistory = c.empJobHistory.idEmpJobHistory " +
                    "       and e.indJobAssignable = '" + ArchitectureConstants.Y + "' " +
                    "       and g.person.idPerson = f.person.idPerson " +
                    "       and ( (a.indPersonPhonePrimary = '" + ArchitectureConstants.Y + "' )" +
                    "           or (a.indPersonPhonePrimary is null) )" +
                    "       and ( (a.cdPersonPhoneType = '" + CodesTables.CPHNTYP_BS + "' )" +
                    "           or (a.cdPersonPhoneType is null) )" +
                    "       and ( (a.dtPersonPhoneEnd = :maxDate )" +
                    "           or (a.dtPersonPhoneEnd is null) )" +
                    "       and f.cdUnitMemberInOut = '" + CodesTables.CUMINOUT_IN + "' " +
                    "  order by g.nbrEmpOnCallCntctOrd ");
    query.setInteger("idOnCall", idOnCall);
    query.setTimestamp("maxDate", DateHelper.MAX_JAVA_DATE);
    return (List<Map>) query.list();
  }

  public void saveEmpOnCallLink(EmpOnCallLink empOnCallLink) {
    getSession().saveOrUpdate(empOnCallLink);
  }

  public void deleteEmpOnCallLink(EmpOnCallLink empOnCallLink) {
    getSession().delete(empOnCallLink);
  }

  public int deleteEmpOnCallLinkByIdOnCall(int idOnCall) {
    Query query = getSession().createQuery("delete from EmpOnCallLink" +
                                           "       where onCall.idOnCall = :idOnCall");
    query.setInteger("idOnCall", idOnCall);
    return query.executeUpdate();
  }
  
  public int deleteEmpOnCallLinkByIdEmpOnCallLink(int idEmpOnCallLink) {
    Query query = getSession().createQuery("delete from EmpOnCallLink" +
                                           "       where idEmpOnCallLink = :idEmpOnCallLink");
    query.setInteger("idEmpOnCallLink", idEmpOnCallLink);
    return query.executeUpdate();
  }

  @SuppressWarnings({"unchecked"})
  public List<Integer> findOnCallIdEmpBySecurityClassNm(String cdCounty, String cdEmpSecurityClassNm,
                                                        Date dtSysTsQuery) {

    Query query = getSession().createQuery("select g.person.idPerson as idPerson " +
                                           "  from EmpOnCallLink g, " +
                                           "       EmpSecClassLink es " +
                                           "  join g.onCall.onCallCounties occ " +
                                           " where occ.cdOnCallCounty = :cdCounty  " +
                                           "   and es.securityClass.cdSecurityClassName=:cdEmpSecurityClassNm " +
                                           "   and g.person.idPerson=es.person.idPerson  " +
                                           "   and g.onCall.dtOnCallStart <= :dtSysTsQuery  " +
                                           "   and g.onCall.dtOnCallEnd >= :dtSysTsQuery ");

    query.setString("cdCounty", cdCounty);
    query.setString("cdEmpSecurityClassNm", cdEmpSecurityClassNm);
    query.setTimestamp("dtSysTsQuery", dtSysTsQuery);
    return (List<Integer>) query.list();
  }

  @SuppressWarnings({"unchecked"})
  public List<EmpOnCallLink> findEmpOnCallLinkListByIdOnCall(int idOnCall) {
    Query query = getSession().createQuery("    from EmpOnCallLink eocl " +
                                           "   where eocl.onCall.idOnCall = :idOnCall " +
                                           "order by eocl.nbrEmpOnCallCntctOrd");
    query.setInteger("idOnCall", idOnCall);
    return (List<EmpOnCallLink>) query.list();
  }
}
