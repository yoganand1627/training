package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.dao.OfficeDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Office;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Hibernate;

public class OfficeDAOImpl extends BaseDAOImpl implements OfficeDAO {
  public Office findOfficeByIdOffice(int idOffice) {

    Query query = getSession().createQuery("from Office" + "  where idOffice = :idOffice");

    query.setInteger("idOffice", idOffice);

    return (Office) firstResult(query);
  }

  public String findOfficeCityByCdCountyIdOffice(int idOffice) {

    Query query = getSession().createQuery(
                                           "select m.addrMailCodeCity "
                                                           + " from Office o, MailCode m, OfficeCountyLink ocl  "
                                                           + " where o.idOffice = :idOffice "
                                                           + " and o.mailCode.cdMailCode = m.cdMailCode "
                                                           + " and o.idOffice = ocl.office.idOffice "
                                                           + " and m.addrMailCodeCounty = ocl.cdCounty "
                                                           + " and m.indMailCodeInvalid <> 'Y'");

    query.setInteger("idOffice", idOffice);

    return (String) firstResult(query);
  }

  @SuppressWarnings( { "unchecked" })
  public Map findOfficeByCdOfficeProgramCdOfficeRegionCdOfficeMail(String cdOfficeProgram, String cdOfficeRegion,
                                                                   String cdOfficeMail) {
    Query query = getSession().createQuery(
                                           " select new map(o.idOffice as idOffice, "
                                                           + "                o.nmOfficeName as nmOfficeName) "
                                                           + "   from Office o "
                                                           + "  where o.cdOfficeRegion = :cdOfficeRegion ");

    query.setString("cdOfficeRegion", cdOfficeRegion);

    return (Map) firstResult(query);
  }

  @SuppressWarnings( { "unchecked" })
  public Object[] findOfficeByIdStageAndPrimaryPhone(int idStage) {
    SQLQuery query = getSession()
                                 .createSQLQuery(
                                                 "SELECT O.NM_OFFICE_NAME as officeName, "
                                                                 + "P.NBR_OFFICE_PHONE as officePhone, "
                                                                 + "P.NBR_OFFICE_PHONE_EXT as officePhoneExt, "
                                                                 + "O.ID_OFFICE as officeId "
                                                                 + "FROM OFFICE_PHONE P, "
                                                                 + "OFFICE O, "
                                                                 + "EMPLOYEE E, "
                                                                 + "UNIT U, "
                                                                 + "STAGE S "
                                                                 + "WHERE S.ID_STAGE = :idStage "
                                                                 + "AND S.ID_UNIT  = U.ID_UNIT "
                                                                 + "AND U.ID_PERSON = E.ID_PERSON "
                                                                 + "AND E.ID_EMP_OFFICE = O.ID_OFFICE "
                                                                 + "AND O.ID_OFFICE = P.ID_OFFICE(+) "
                                                                 + "AND P.IND_OFFICE_PHONE_PRIMARY (+) = :indPrimary "
                                                                 + "AND (P.DT_OFFICE_PHONE_END = TO_DATE('12/31/4712', 'MM/DD/YYYY') "
                                                                 + "OR P.DT_OFFICE_PHONE_END = NULL)");

    query.setInteger("idStage", idStage);
    query.setString("indPrimary", YES_IND);
    query.addScalar("officeName", Hibernate.STRING);
    query.addScalar("officePhone", Hibernate.STRING);
    query.addScalar("officePhoneExt", Hibernate.STRING);
    query.addScalar("officeId", Hibernate.STRING);

    return (Object[]) firstResult(query);
  }

  @SuppressWarnings( { "unchecked" })
  public Object[] findOfficeByIdStage(int idStage) {
    SQLQuery query = getSession().createSQLQuery(
                                                 "SELECT O.NM_OFFICE_NAME as officeName, " + "O.ID_OFFICE as officeId "
                                                                 + "FROM " + "OFFICE O, " + "EMPLOYEE E, " + "UNIT U, "
                                                                 + "STAGE S " + "WHERE S.ID_STAGE = :idStage "
                                                                 + "AND S.ID_UNIT  = U.ID_UNIT "
                                                                 + "AND U.ID_PERSON = E.ID_PERSON "
                                                                 + "AND E.ID_EMP_OFFICE = O.ID_OFFICE ");

    query.setInteger("idStage", idStage);
    query.addScalar("officeName", Hibernate.STRING);
    query.addScalar("officeId", Hibernate.STRING);

    return (Object[]) firstResult(query);
  }

  public String findCdMailCodeByCdCounty(String cdCounty) {

    Query query = getSession().createQuery(
                                           "select m.cdMailCode " + " from MailCode m "
                                                           + " where m.addrMailCodeCounty = :cdCounty ");

    query.setString("cdCounty", cdCounty);

    return (String) firstResult(query);
  }

  public String findCdCountyByCdMailCode(String cdMailCode) {

    Query query = getSession().createQuery(
                                           "select m.addrMailCodeCounty " + " from MailCode m "
                                                           + " where m.cdMailCode = :cdMailCode ");

    query.setString("cdMailCode", cdMailCode);

    return (String) firstResult(query);
  }

  @SuppressWarnings( { "unchecked" })
  public Map findOfficeByCdOfficeRegionCdOfficeMail(String cdOfficeRegion, String cdOfficeMail) {
    Query query = getSession().createQuery(
                                           " select new map(o.idOffice as idOffice, "
                                                           + "                o.nmOfficeName as nmOfficeName) "
                                                           + "   from Office o "
                                                           + "  where o.cdOfficeRegion = :cdOfficeRegion "
                                                           + " and o.mailCode.cdMailCode = :cdOfficeMail");

    query.setString("cdOfficeRegion", cdOfficeRegion);
    query.setString("cdOfficeMail", cdOfficeMail);

    return (Map) firstResult(query);
  }

  public Map findOfficeByCdOfficeMail(String cdOfficeMail) {
    Query query = getSession().createQuery(
                                           " select new map(o.idOffice as idOffice, "
                                                           + "                o.nmOfficeName as nmOfficeName) "
                                                           + "   from Office o "
                                                           + "  where o.mailCode.cdMailCode = :cdOfficeMail");

    query.setString("cdOfficeMail", cdOfficeMail);

    return (Map) firstResult(query);
  }

  // STGAP00010002: Added this sql to retrieve the office address for Special Services Adoption Assistance
  // Agreement form
  @SuppressWarnings( { "unchecked" })
  public Map findOffcAddressByIdPerson(int idPerson) {
    Query query = getSession().createQuery(
                                           "select new map(o.mailCode.addrMailCodeStLn1 as addrMailCodeStLn1,"
                                                           + " o.mailCode.addrMailCodeStLn2 as addrMailCodeStLn2,"
                                                           + " o.mailCode.addrMailCodeCity as addrMailCodeCity,"
                                                           + " o.mailCode.addrMailCodeZip as addrMailCodeZip) "
                                                           + "  from Office o, Employee e "
                                                           + " where e.office.idOffice = o.idOffice"
                                                           + " and e.person.idPerson = :idPerson ");
    query.setInteger("idPerson", idPerson);
    return (Map) query.uniqueResult();
  }
}
