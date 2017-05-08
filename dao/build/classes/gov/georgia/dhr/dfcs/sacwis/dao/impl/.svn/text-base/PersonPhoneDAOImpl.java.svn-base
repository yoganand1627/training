package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonPhoneDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.PersonPhone;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

public class PersonPhoneDAOImpl extends BaseDAOImpl implements PersonPhoneDAO {
  
  @SuppressWarnings({"unchecked"})
  /*
   * This method is used for updating the CSUP_PERSON_OUTBOUND table
   */
  public PersonPhone findDistinctPersonPhoneByIdPerson(int idPerson) {
    Session session = getSession();
    Query query = session.createQuery(" from "
                                      + "PersonPhone p " 
                                      + "where "
                                      + "p.person.idPerson = :idPerson "
                                      + "and "
                                      + "(p.dtPersonPhoneEnd = '12/31/4712' OR p.dtPersonPhoneEnd IS NULL) "
                                      + "and "
                                      + "p.indPersonPhoneInvalid = 'N' "
                                      + "and "
                                      + "p.indPersonPhonePrimary = 'Y' "
                                      + "and "
                                      + "p.cdPersonPhoneType = 'RS' "
                                      + "order by "
                                      + "p.dtPersonPhoneEnd desc, "
                                      + "p.indPersonPhonePrimary desc, "
                                      + "p.cdPersonPhoneType asc");
    query.setInteger("idPerson", idPerson);
    
    return (PersonPhone) firstResult(query);
  }
  
  @SuppressWarnings({"unchecked"})
  public List<PersonPhone> findPersonPhoneByIdPersonDtPersonPhone(int idPerson, Date dtPersonPhone) {
    Session session = getSession();
    Query query = session.createQuery("     from PersonPhone p " + "    where p.person.idPerson = :idPerson "
                                      + "      and p.dtPersonPhoneStart <= :dtPersonPhone "
                                      + "      and p.dtPersonPhoneEnd >= :dtPersonPhone "
                                      + " order by p.dtPersonPhoneEnd desc, "
                                      + "          p.indPersonPhonePrimary desc, "
                                      + "          p.cdPersonPhoneType asc ");
    query.setInteger("idPerson", idPerson);
    query.setTimestamp("dtPersonPhone", dtPersonPhone);
    return (List<PersonPhone>) query.list();
  }

  @SuppressWarnings({"unchecked"})
  public List<PersonPhone> findPersonPhoneByIdPerson(int idPerson) {
    Session session = getSession();
    Query query = session.createQuery("     from PersonPhone p " + "    where p.person.idPerson = :idPerson "
                                      + " order by p.dtPersonPhoneEnd desc, "
                                      + "          p.indPersonPhonePrimary desc, "
                                      + "          p.cdPersonPhoneType asc ");
    query.setInteger("idPerson", idPerson);
    return (List<PersonPhone>) query.list();
  }

  @SuppressWarnings({"unchecked"})
  public PersonPhone findPersonPhoneByIdPersonCdPersonPhoneTypeDtPersonPhoneEnd(int idPerson, String cdPersonPhoneType,
                                                                                Date dtPersonPhoneEnd) {
    Session session = getSession();
    Query query = session.createQuery("     from PersonPhone pp " + "    where pp.person.idPerson = :idPerson "
                                      + "      and pp.cdPersonPhoneType = :cdPersonPhoneType "
                                      + "      and pp.dtPersonPhoneEnd = :dtPersonPhoneEnd "
                                      + " order by pp.dtPersonPhoneStart desc ");
    query.setInteger("idPerson", idPerson);
    query.setString("cdPersonPhoneType", cdPersonPhoneType);
    query.setTimestamp("dtPersonPhoneEnd", dtPersonPhoneEnd);
    return (PersonPhone) firstResult(query);
  }

  @SuppressWarnings({"unchecked"})
  public PersonPhone findPersonPhoneAndOtherInfo(int idPerson, String cdPersonPhoneType, String indPersonPhonePrimary,
                                                 Date dtPersonPhoneEnd) {
    Session session = getSession();
    Query query = session.createQuery("   from PersonPhone pp " + "  where pp.person.idPerson = :idPerson "
                                      + "    and pp.cdPersonPhoneType = :cdPersonPhoneType "
                                      + "    and pp.indPersonPhonePrimary = :indPersonPhonePrimary "
                                      + "    and pp.dtPersonPhoneEnd = :dtPersonPhoneEnd ");
    query.setInteger("idPerson", idPerson);
    query.setString("cdPersonPhoneType", cdPersonPhoneType);
    query.setString("indPersonPhonePrimary", indPersonPhonePrimary);
    query.setTimestamp("dtPersonPhoneEnd", dtPersonPhoneEnd);
    return (PersonPhone) firstResult(query);
  }

  @SuppressWarnings({"unchecked"})

  public List<Map> findPersonPhoneByIdPersonAndCdPersonPhoneType(int idPerson) {
    Query query = getSession().createQuery(
            "  select new map( nbrPersonPhone," + "          nbrPersonPhoneExtension)"
            + "     from PersonPhone"
            + "    where person.idPerson = :idPerson"
            + "      and cdPersonPhoneType in (:phoneTypeBP,"
            + "                                :phoneTypeBC)"
            + "      and (dtPersonPhoneEnd = :maxDate"
            + "            or dtPersonPhoneEnd = null)"
            + " order by cdPersonPhoneType desc");
    query.setInteger("idPerson", idPerson);
    // query.setString("phoneTypeOC", CodesTables.CPHNTYP_OC);
    query.setString("phoneTypeBP", CodesTables.CPHNTYP_BP);
    query.setString("phoneTypeBC", CodesTables.CPHNTYP_BC);
    query.setTimestamp("maxDate", DateHelper.MAX_JAVA_DATE);
    return (List<Map>) query.list();
  }

  @SuppressWarnings({"unchecked"})
  public List<PersonPhone> findPersonPhoneByIdStage(int idStage) {
    Session session = getSession();
    Query query = session.createQuery("  select pp " + "    from PersonPhone pp " + "    join pp.person p "
                                      + "    join p.stagePersonLinks spl " + "    join spl.stage s "
                                      + "    join s.incomingDetail i " + "   where s.idStage = :idStage "
                                      + "     and (spl.cdStagePersType = :cdPrnType "
                                      + "           or spl.cdStagePersType = :cdColType "
                                      + "           or spl.indStagePersReporter = :indStagePersReporter) "
                                      + "     and pp.dtPersonPhoneStart <= nvl(i.dtIncomingCallDisposed, :dtMaxDate) "
                                      + "     and pp.dtPersonPhoneEnd >= nvl(i.dtIncomingCallDisposed, :dtMaxDate) "
                                      + "order by p.idPerson, " + "         pp.indPersonPhonePrimary desc, "
                                      + "         pp.cdPersonPhoneType asc ");
    query.setInteger("idStage", idStage);
    query.setString("cdPrnType", CodesTables.CPRSNTYP_PRN);
    query.setString("cdColType", CodesTables.CPRSNTYP_COL);
    query.setString("indStagePersReporter", ArchitectureConstants.Y);
    query.setTimestamp("dtMaxDate", DateHelper.MAX_JAVA_DATE);
    return (List<PersonPhone>) query.list();
  }

  public Map findPersonPhoneByIndPersAddrLinkPrimary(int idPerson) {
    Query query = getSession()
            .createQuery(
                    "select new map ("
                    + "       a.idPersonAddr as idPersonAddr, "
                    + "       a.dtLastUpdate  as dtLastUpdate, "
                    + "       a.addrPersonAddrZip as addrPersonAddrZip,"
                    + "       a.cdPersonAddrState as cdPersonAddrState,"
                    + "       a.nbrPersonAddrHash as nbrPersonAddrHash,"
                    + "       a.addrPersonAddrCity as addrPersonAddrCity,"
                    + "       a.addrPersonAddrAttn as addrPersonAddrAttn,"
                    + "       a.addrPersAddrStLn1 as addrPersAddrStLn1,"
                    + "       a.addrPersAddrStLn2 as addrPersAddrStLn2,"
                    + "       a.cdPersonAddrCounty as cdPersonAddrCounty,"
                    + "       ph.idPersonPhone as idPersonPhone,"
                    + "       ph.dtLastUpdate as phdtLastUpdate,"
                    + "       ph.person.idPerson as idPerson,"
                    + "       ph.txtPersonPhoneComments as txtPersonPhoneComments,"
                    + "       ph.nbrPersonPhoneExtension as nbrPersonPhoneExtension,"
                    + "       ph.nbrPersonPhone as nbrPersonPhone,"
                    + "       ph.dtPersonPhoneStart as dtPersonPhoneStart,"
                    + "       ph.dtPersonPhoneEnd as dtPersonPhoneEnd,"
                    + "       ph.indPersonPhoneInvalid as indPersonPhoneInvalid,"
                    + "       ph.indPersonPhonePrimary as indPersonPhonePrimary,"
                    + "       ph.cdPersonPhoneType as cdPersonPhoneType,"
                    + "       apl.idAddrPersonLink as idAddrPersonLink,"
                    + "       apl.dtLastUpdate as dtLastUpdate,"
                    + "       apl.cdPersAddrLinkType as cdPersAddrLinkType,"
                    + "       apl.indPersAddrLinkInvalid as indPersAddrLinkInvalid,"
                    + "       apl.indPersAddrLinkPrimary as indPersAddrLinkPrimary,"
                    + "       apl.txtPersAddrCmnts as txtPersAddrCmnts,"
                    + "       apl.dtPersAddrLinkStart as dtPersAddrLinkStart,"
                    + "       apl.dtPersAddrLinkEnd as dtPersAddrLinkEnd )"
                    + " from  PersonAddress a,"
                    + "       PersonPhone ph"
                    + "       right join ph.person p,"
                    + "       AddressPersonLink apl"
                    + "       right join apl.person"
                    + " where p.idPerson =      :idPerson"
                    + "   and a.idPersonAddr =      apl.personAddress.idPersonAddr"
                    + "   and ( apl.indPersAddrLinkPrimary = 'y' OR apl.indPersAddrLinkPrimary  IS NULL )"
                    + "   and ( ph.indPersonPhonePrimary = 'y' OR ph.indPersonPhonePrimary IS NULL )"
                    + "   and ( ph.dtPersonPhoneEnd = :maxDate OR ph.dtPersonPhoneEnd IS NULL )"
                    + "   and ( apl.dtPersAddrLinkEnd = :maxDate  OR  apl.dtPersAddrLinkEnd IS NULL )");
    query.setInteger("idPerson", idPerson);
    query.setTimestamp("maxDate", DateHelper.MAX_JAVA_DATE);
    return (Map) firstResult(query);
  }

  public Map findNameAndPhoneNumberFromPersonPhoneAndPerson(int idPerson, String cdPhoneType,
                                                            String indPersonPhonePrimary) {
    Query query = getSession()
            .createQuery(
                    " select new map (pp.person.nmPersonFull as nmPersonFull , "
                    + "                pp.nbrPersonPhone as nbrPersonPhone ) "
                    + "           from PersonPhone pp "
                    + "     right join pp.person p "
                    + "          where p.idPerson = :idPerson "
                    + "            and ( (pp.indPersonPhonePrimary = :indPersonPhonePrimary) "
                    + "                or (pp.indPersonPhonePrimary is null) ) "
                    + "            and ( (pp.cdPersonPhoneType = :cdPhoneType) "
                    + "                or (pp.cdPersonPhoneType is null) ) "
                    + "            and ( (pp.indPersonPhoneInvalid = 'N') "
                    + "                or (pp.indPersonPhoneInvalid is null) ) "
                    + "       order by pp.dtPersonPhoneEnd desc ");
    query.setInteger("idPerson", idPerson);
    query.setString("indPersonPhonePrimary", indPersonPhonePrimary);
    query.setString("cdPhoneType", cdPhoneType);
    return (Map) firstResult(query);
  }

  @SuppressWarnings({"unchecked"})
  public PersonPhone findPersonPhoneByIdPersonDtSysTsQuery(int idPerson, Date dtSysTsQuery) {
    Session session = getSession();
    Query query = session.createQuery("   from PersonPhone g " + "  where g.person.idPerson = :idPerson "
                                      + "    and g.indPersonPhonePrimary = 'Y' "
                                      + "    and g.dtPersonPhoneStart <= :dtSysTsQuery "
                                      + "    and g.dtPersonPhoneEnd >= :dtSysTsQuery " + "    and rownum = 1 ");
    query.setInteger("idPerson", idPerson);
    query.setTimestamp("dtSysTsQuery", dtSysTsQuery);
    return (PersonPhone) firstResult(query);
  }
  
  @SuppressWarnings({"unchecked"})
  public PersonPhone findPrimaryPersonPhoneByIdPersonDtSysTsQuery(int idPerson, Date dtSysTsQuery) {
    Session session = getSession();
    Query query = session.createQuery("   from PersonPhone g " + "  where g.person.idPerson = :idPerson "
                                      + "    and g.indPersonPhonePrimary = 'Y' "
                                      + "    and g.dtPersonPhoneEnd >= :dtSysTsQuery "
                                      + "    and rownum = 1 ");
    query.setInteger("idPerson", idPerson);
    query.setTimestamp("dtSysTsQuery", dtSysTsQuery);
    return (PersonPhone) firstResult(query);
  }
  public long countPersonPhoneIdPersonPhone(int idPerson, Date dtSysTsQuery) {
    Query query = getSession().createQuery(
            " select count(pp.idPersonPhone) " + "   from PersonPhone pp "
            + "  where pp.person.idPerson = :idPerson "
            + "    and pp.dtPersonPhoneStart <= :dtSysTsQuery "
            + "    and pp.dtPersonPhoneEnd >= :dtSysTsQuery ");
    query.setInteger("idPerson", idPerson);
    query.setTimestamp("dtSysTsQuery", dtSysTsQuery);
    return (Long) query.uniqueResult();
  }

  public PersonPhone findPersonPhoneByIdPersonAndMaxDate(int idPerson, Date maxDate) {
    Query query = getSession().createQuery(
            " from PersonPhone g" + "  where g.person.idPerson = :idPerson"
            + "    and g.indPersonPhonePrimary = 'Y'"
            + "    and g.dtPersonPhoneEnd = :maxDate"
            + "    and rownum = 1");
    query.setInteger("idPerson", idPerson);
    query.setTimestamp("maxDate", maxDate);
    return (PersonPhone) firstResult(query);
  }

  public long countIdPersonPhoneByIdPersonAndMaxDate(int idPerson, Date maxDate) {
    Query query = getSession().createQuery(
            " select count(idPersonPhone)" + "   from PersonPhone"
            + "  where person.idPerson = :idPerson"
            + "    and dtPersonPhoneEnd = :maxDate ");
    query.setInteger("idPerson", idPerson);
    query.setTimestamp("maxDate", maxDate);
    return (Long) query.uniqueResult();
  }

  public Map findPersonPhoneAndExtensionbyIdPersonAndTypes(String cdPersonPhoneType, int idPerson,
                                                           String bIndPersonPhonePrimary,
                                                           String bIndPersonPhoneInvalid) {
    Query query = getSession()
            .createQuery(
                    "select new map ( "
                    + "    p.nbrPersonPhone as nbrPersonPhone,"
                    + "    p.nbrPersonPhoneExtension as nbrPersonPhoneExtension) "
                    + "   from PersonPhone p"
                    + "  where cdPersonPhoneType = :cdPersonPhoneType"
                    + "    and indPersonPhonePrimary = :bIndPersonPhonePrimary"
                    + "    and indPersonPhoneInvalid = :bIndPersonPhoneInvalid"
                    + "    and person.idPerson = :idPerson"
                    + "    and dtPersonPhoneEnd = :dtMaxDate");
    query.setString("cdPersonPhoneType", cdPersonPhoneType);
    query.setString("bIndPersonPhonePrimary", bIndPersonPhonePrimary);
    query.setString("bIndPersonPhoneInvalid", bIndPersonPhoneInvalid);
    query.setInteger("idPerson", idPerson);
    query.setTimestamp("dtMaxDate", DateHelper.MAX_JAVA_DATE);
    return (Map) firstResult(query);
  }

  public Date findPersonPhoneDtPersonPhoneEnd(int idPhone) {
    Query query = getSession().createQuery(
            "select dtPersonPhoneEnd" + "   from PersonPhone"
            + "  where idPersonPhone = :idPhone");
    query.setInteger("idPhone", idPhone);
    return (Date) firstResult(query);
  }
  
  public String findNbrPersonPhoneByIdPersonAndPhoneType(int idPerson, String phoneType){
    Query query = getSession().createQuery("select pph.nbrPersonPhone from PersonPhone pph "
                                           + "where pph.person.idPerson = :idPerson "
                                           + "and (pph.cdPersonPhoneType = :phoneType "
                                           + "or pph.cdPersonPhoneType is null) "
                                           + "and pph.dtLastUpdate = (select max(phone.dtLastUpdate) "
                                           + "from PersonPhone phone "
                                           + "where phone.person.idPerson = :idPerson "
                                           + "and (phone.cdPersonPhoneType = :phoneType "
                                           + "or phone.cdPersonPhoneType is null))");
    query.setInteger("idPerson", idPerson);
    query.setString("phoneType", phoneType);
    return (String) query.uniqueResult();
  }

  public int updatePersonPhoneByDtPersonPhoneEnd(String cdPhoneType, String nbrPhone, String nbrPhoneExtension,
                                                 String indPersonPhonePrimary, String indPersonPhoneInvalid,
                                                 String txtPhoneComments, int idPhone, Date tsLastUpdate) {
    Query query = getSession().createQuery(
            "update PersonPhone" + "    set cdPersonPhoneType = :cdPhoneType,"
            + "        nbrPersonPhone = :nbrPhone,"
            + "        nbrPersonPhoneExtension = :nbrPhoneExtension,"
            + "        dtPersonPhoneEnd = sysdate,"
            + "        indPersonPhonePrimary = :indPersonPhonePrimary,"
            + "        indPersonPhoneInvalid = :indPersonPhoneInvalid,"
            + "        txtPersonPhoneComments = :txtPhoneComments"
            + "  where idPersonPhone = :idPhone"
            + "    and dtLastUpdate <= :tsLastUpdate");
    query.setString("cdPhoneType", cdPhoneType);
    query.setString("nbrPhone", nbrPhone);
    query.setString("nbrPhoneExtension", nbrPhoneExtension);
    query.setString("indPersonPhonePrimary", indPersonPhonePrimary);
    query.setString("indPersonPhoneInvalid", indPersonPhoneInvalid);
    query.setString("txtPhoneComments", txtPhoneComments);
    query.setInteger("idPhone", idPhone);
    query.setTimestamp("tsLastUpdate", tsLastUpdate);
    return query.executeUpdate();
  }

  public int updatePersonPhone(String cdPhoneType, String nbrPhone, String nbrPhoneExtension,
                               String indPersonPhonePrimary, String indPersonPhoneInvalid, String txtPhoneComments,
                               int idPhone, Date tsLastUpdate) {
    Query query = getSession().createQuery(
            "update PersonPhone" + "    set cdPersonPhoneType = :cdPhoneType,"
            + "        nbrPersonPhone = :nbrPhone,"
            + "        nbrPersonPhoneExtension = :nbrPhoneExtension,"
            + "        indPersonPhonePrimary = :indPersonPhonePrimary,"
            + "        indPersonPhoneInvalid = :indPersonPhoneInvalid,"
            + "        txtPersonPhoneComments = :txtPhoneComments"
            + "  where idPersonPhone = :idPhone"
            + "    and dtLastUpdate <= :tsLastUpdate");
    query.setString("cdPhoneType", cdPhoneType);
    query.setString("nbrPhone", nbrPhone);
    query.setString("nbrPhoneExtension", nbrPhoneExtension);
    query.setString("indPersonPhonePrimary", indPersonPhonePrimary);
    query.setString("indPersonPhoneInvalid", indPersonPhoneInvalid);
    query.setString("txtPhoneComments", txtPhoneComments);
    query.setInteger("idPhone", idPhone);
    query.setTimestamp("tsLastUpdate", tsLastUpdate);
    return query.executeUpdate();
  }

  public int insertPersonPhone(int idIncmgPerson, int idPerson) {
    SQLQuery query = getSession().createSQLQuery(
            "insert into PERSON_PHONE " + "(ID_PERSON_PHONE," + "ID_PERSON,"
            + "TXT_PERSON_PHONE_COMMENTS,"
            + "NBR_PERSON_PHONE_EXTENSION," + "NBR_PERSON_PHONE,"
            + "DT_PERSON_PHONE_START," + "DT_PERSON_PHONE_END,"
            + "IND_PERSON_PHONE_INVALID,"
            + "IND_PERSON_PHONE_PRIMARY,"
            + "CD_PERSON_PHONE_TYPE )" + " select 0,"
            + "        :idPerson,"
            + "        TXT_INCMG_PHONE_COMMENTS,"
            + "        NBR_INCMG_PHONE_EXTENSION,"
            + "        NBR_INCMG_PHONE,"
            + "        DT_INCMG_PHONE_START,"
            + "        DT_INCMG_PHONE_END,"
            + "        IND_INCMG_PHONE_INVALID,"
            + "        IND_INCMG_PHONE_PRIMARY,"
            + "        CD_INCMG_PHONE_TYPE"
            + "   from INCOMING_PHONE"
            + "  where ID_INCMG_PERSON = :idIncmgPerson");
    query.setInteger("idIncmgPerson", idIncmgPerson);
    query.setInteger("idPerson", idPerson);
    return query.executeUpdate();
  }

  public int updatePersonPhoneCdPhoneType(String cdPhoneType, int idPhone) {
    Query query = getSession().createQuery(
            "update PersonPhone" + "    set cdPersonPhoneType = :cdPhoneType"
            + "  where idPersonPhone = :idPhone");
    query.setString("cdPhoneType", cdPhoneType);
    query.setInteger("idPhone", idPhone);
    return query.executeUpdate();
  }

  public int updatePersonPhoneNbrPhone(String nbrPhone, int idPhone) {
    Query query = getSession().createQuery(
            "update PersonPhone" + "    set nbrPersonPhone = :nbrPhone"
            + "  where idPersonPhone = :idPhone");
    query.setString("nbrPhone", nbrPhone);
    query.setInteger("idPhone", idPhone);
    return query.executeUpdate();
  }

  public int updatePersonPhoneNbrPhoneExtension(String nbrPhoneExtension, int idPhone) {
    Query query = getSession().createQuery(
            "update PersonPhone"
            + "    set nbrPersonPhoneExtension = :nbrPhoneExtension"
            + "  where idPersonPhone = :idPhone");
    query.setString("nbrPhoneExtension", nbrPhoneExtension);
    query.setInteger("idPhone", idPhone);
    return query.executeUpdate();
  }

  public void insertPersonPhone(int idPerson, String cdPhoneType, String nbrPhone, String nbrPhoneExtension) {
    PersonPhone personPhone = new PersonPhone();
    Person person = (Person) getSession().load(Person.class, idPerson);
    personPhone.setPerson(person);
    personPhone.setCdPersonPhoneType(cdPhoneType);
    personPhone.setNbrPersonPhone(nbrPhone);
    personPhone.setNbrPersonPhoneExtension(nbrPhoneExtension);
    personPhone.setIndPersonPhonePrimary(ArchitectureConstants.Y);
    personPhone.setIndPersonPhoneInvalid(ArchitectureConstants.N);
  }

  public void insertPersonPhonePermanent(int idPerson, int idPersonPhone, String cdPhoneType, String cdNbrPhone,
                                         String cdNbrPhoneExtension, String indPersonPhonePrimary,
                                         String indPersonPhoneInvalid, String cdTxtPhoneComments) {
    PersonPhone personPhone = new PersonPhone();
    Person person = (Person) getSession().load(Person.class, idPerson);
    personPhone.setPerson(person);
    personPhone.setIdPersonPhone(idPersonPhone);
    personPhone.setCdPersonPhoneType(cdPhoneType);
    personPhone.setNbrPersonPhone(cdNbrPhone);
    personPhone.setNbrPersonPhoneExtension(cdNbrPhoneExtension);
    personPhone.setIndPersonPhonePrimary(indPersonPhonePrimary);
    personPhone.setIndPersonPhoneInvalid(indPersonPhoneInvalid);
    personPhone.setTxtPersonPhoneComments(cdTxtPhoneComments);
    getSession().saveOrUpdate(personPhone);
  }

  public void insertPersonPhoneNoEndDate(int idPerson, int idPersonPhone, String cdPhoneType, String cdNbrPhone,
                                         String cdNbrPhoneExtension, String indPersonPhonePrimary,
                                         String indPersonPhoneInvalid, String cdTxtPhoneComments) {
    PersonPhone personPhone = new PersonPhone();
    Person person = (Person) getSession().load(Person.class, idPerson);
    personPhone.setPerson(person);
    personPhone.setIdPersonPhone(idPersonPhone);
    personPhone.setCdPersonPhoneType(cdPhoneType);
    personPhone.setNbrPersonPhone(cdNbrPhone);
    personPhone.setNbrPersonPhoneExtension(cdNbrPhoneExtension);
    personPhone.setIndPersonPhonePrimary(indPersonPhonePrimary);
    personPhone.setIndPersonPhoneInvalid(indPersonPhoneInvalid);
    personPhone.setTxtPersonPhoneComments(cdTxtPhoneComments);
    getSession().saveOrUpdate(personPhone);
  }

  @SuppressWarnings({"unchecked"})
  public List<PersonPhone> findPersonPhoneByIdPersonDtPersonPhoneCdPersonPhoneTypes(int idPerson, 
                                                                                    Date dtPersonPhone,
                                                                                    String indPersonPhoneInValid,
                                                                                    Collection<String> personPhoneTypes) {
    Session session = getSession();
    Query query = session.createQuery("     from PersonPhone p " 
                                      + "    where p.person.idPerson = :idPerson "
                                      + "      and p.dtPersonPhoneEnd >= :dtPersonPhone "
                                      + "      and p.indPersonPhoneInvalid = :indPersonPhoneInValid "
                                      + "      and cdPersonPhoneType in ( :personPhoneTypes ) "
                                      + "      and dtPersonPhoneEnd >= sysdate"
                                      + "   order by p.indPersonPhonePrimary desc ");
    query.setInteger("idPerson", idPerson);
    query.setTimestamp("dtPersonPhone", dtPersonPhone);
    query.setString("indPersonPhoneInValid", indPersonPhoneInValid);
    query.setParameterList("personPhoneTypes", personPhoneTypes);
    
    return (List<PersonPhone>) query.list();
  }}