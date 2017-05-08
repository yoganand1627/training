package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.Date;
import java.util.List;
import java.util.Collection;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.AddressPersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.AddressPersonLink;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.PersonAddress;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

class AddressPersonLinkDAOImpl extends BaseDAOImpl implements AddressPersonLinkDAO {
  @SuppressWarnings( { "unchecked" })
  public List<AddressPersonLink> findAddressPersonLinkForIntake(int idPerson, Date dtPersAddrLinkStart,
                                                                Date dtPersAddrLinkEnd) {
    Query query = getSession()
                              .createQuery(
                                           "      from AddressPersonLink b "
                                                           + "join fetch b.personAddress "
                                                           + "     where b.person.idPerson = :idPerson "
                                                           + "       and b.dtPersAddrLinkStart <= :dtPersAddrLinkStart "
                                                           + "       and b.dtPersAddrLinkEnd >= :dtPersAddrLinkEnd "
                                                           + "  order by b.dtPersAddrLinkEnd desc, "
                                                           + "           b.indPersAddrLinkPrimary desc, "
                                                           + "           b.cdPersAddrLinkType asc");
    query.setInteger("idPerson", idPerson);
    query.setTimestamp("dtPersAddrLinkStart", dtPersAddrLinkStart);
    query.setTimestamp("dtPersAddrLinkEnd", dtPersAddrLinkEnd);
    return (List<AddressPersonLink>) query.list();
  }

  @SuppressWarnings( { "unchecked" })
  public List<AddressPersonLink> findAddressPersonLinkForInvest(int idPerson) {
    Query query = getSession().createQuery(
                                           "      from AddressPersonLink b " + "join fetch b.personAddress "
                                                           + "     where b.person.idPerson = :idPerson "
                                                           + "  order by b.dtPersAddrLinkEnd desc, "
                                                           + "           b.indPersAddrLinkPrimary desc, "
                                                           + "           b.cdPersAddrLinkType asc ");
    query.setInteger("idPerson", idPerson);
    return (List<AddressPersonLink>) query.list();
  }

  public AddressPersonLink findAddressPersonLinkByIdPersonDtSysTsQuery(int idPerson, Date dtSysTsQuery) {
    Query query = getSession().createQuery(
                                           "      from AddressPersonLink f " + "join fetch f.personAddress "
                                                           + "     where f.person.idPerson = :idPerson "
                                                           + "       and f.indPersAddrLinkPrimary = 'Y' "
                                                           + "       and f.dtPersAddrLinkStart <= :dtSysTsQuery "
                                                           + "       and f.dtPersAddrLinkEnd >= :dtSysTsQuery "
                                                           + "       and rownum = 1 ");
    query.setInteger("idPerson", idPerson);
    query.setTimestamp("dtSysTsQuery", dtSysTsQuery);

    return (AddressPersonLink) firstResult(query);
  }

  @SuppressWarnings( { "unchecked" })
  public List<AddressPersonLink> findAddressPersonLinkAndPersonAddressByIdStage(int idStage) {
    Session session = getSession();
    Query query = session
                         .createQuery("    select apl "
                                      + "      from AddressPersonLink apl "
                                      + "join fetch apl.personAddress pa "
                                      + "      join apl.person p "
                                      + "      join p.stagePersonLinks spl "
                                      + "      join spl.stage s "
                                      + "      join s.incomingDetail i "
                                      + "     where s.idStage = :idStage "
                                      + "       and apl.dtPersAddrLinkStart <= nvl(i.dtIncomingCallDisposed, :dtMaxDate) "
                                      + "       and apl.dtPersAddrLinkEnd >= nvl(i.dtIncomingCallDisposed, :dtMaxDate) "
                                      + "       and (spl.cdStagePersType = :cdPrnType "
                                      + "            or spl.cdStagePersType = :cdColType "
                                      + "            or spl.indStagePersReporter = :indStagePersReporter) "
                                      + "  order by p.idPerson, " + "           apl.indPersAddrLinkPrimary desc, "
                                      + "           apl.cdPersAddrLinkType asc ");

    query.setInteger("idStage", idStage);
    query.setString("cdPrnType", CodesTables.CPRSNTYP_PRN);
    query.setString("cdColType", CodesTables.CPRSNTYP_COL);
    query.setString("indStagePersReporter", ArchitectureConstants.Y);
    query.setTimestamp("dtMaxDate", DateHelper.MAX_JAVA_DATE);
    return (List<AddressPersonLink>) query.list();
  }

  @SuppressWarnings( { "unchecked" })
  public List<AddressPersonLink> findAddressPersonLinkByIdPersonByCdPersAddrLinkType(int idPerson,
                                                                        Collection<String> cdPersAddrLinkTypes) {
    Query query = getSession().createQuery( " from AddressPersonLink apl " +
                                            " where apl.person.idPerson = :idPerson " +
                                            " and apl.cdPersAddrLinkType in ( :cdPersAddrLinkTypes) " +
                                            " order by cdPersAddrLinkType desc ");
    query.setInteger("idPerson", idPerson);
    query.setParameterList("cdPersAddrLinkTypes", cdPersAddrLinkTypes );
    return (List<AddressPersonLink>) query.list();
  }

  @SuppressWarnings( { "unchecked" })
  public long countAddressPersonLinkIdPersonAddr(int idPerson, Date dtSysTsQuery) {

    Query query = getSession().createQuery(
                                           "select count(personAddress.idPersonAddr) " + "  from AddressPersonLink "
                                                           + " where person.idPerson = :idPerson "
                                                           + "   and dtPersAddrLinkStart <= :dtSysTsQuery "
                                                           + "   and dtPersAddrLinkEnd >= :dtSysTsQuery ");

    query.setInteger("idPerson", idPerson);
    query.setTimestamp("dtSysTsQuery", dtSysTsQuery);

    return (Long) query.uniqueResult();
  }

  public long countAddressPersonLinkByIdPersonAndMaxDate(int idPerson, Date maxDate) {

    Query query = getSession().createQuery(
                                           "select count(personAddress.idPersonAddr) " + "  from AddressPersonLink "
                                                           + " where person.idPerson = :idPerson "
                                                           + "   and dtPersAddrLinkEnd = :maxDate ");

    query.setInteger("idPerson", idPerson);
    query.setTimestamp("maxDate", maxDate);

    return (Long) query.uniqueResult();
  }

  public AddressPersonLink findAddressPersonLinkByIdPersonAndMaxDate(int idPerson, Date maxDate) {

    Query query = getSession().createQuery(
                                           "      from AddressPersonLink f " + "join fetch f.personAddress e "
                                                           + "     where f.person.idPerson = :idPerson "
                                                           + "       and f.indPersAddrLinkPrimary = 'y' "
                                                           + "       and f.personAddress = e.idPersonAddr "
                                                           + "       and f.dtPersAddrLinkEnd = :maxDate "
                                                           + "       and rownum = 1");

    query.setInteger("idPerson", idPerson);
    query.setTimestamp("maxDate", maxDate);
    return (AddressPersonLink) firstResult(query);
  }

  @SuppressWarnings( { "unchecked" })
  public List<Object[]> findPersonAddressAndPersonPhone(int idPerson) {
    if (idPerson == 0) {
      return null;
    }
    SQLQuery query = getSession()
                                 .createSQLQuery(
                                                 "SELECT B.ADDR_PERS_ADDR_ST_LN_1 as addrPersAddrStLn1, "
                                                                 + "                B.ADDR_PERS_ADDR_ST_LN_2 as addrPersAddrStLn2, "
                                                                 + "                B.ADDR_PERSON_ADDR_CITY as addrPersonAddrCity, "
                                                                 + "                B.ADDR_PERSON_ADDR_ZIP as addrPersonAddrZip, "
                                                                 + "                B.CD_PERSON_ADDR_COUNTY as cdPersonAddrCounty, "
                                                                 + "                B.CD_PERSON_ADDR_STATE as cdPersonAddrState, "
                                                                 + "                C.NBR_PERSON_PHONE as nbrPersonPhone, "
                                                                 + "                C.NBR_PERSON_PHONE_EXTENSION as nbrPersonPhoneExtension "
                                                                 + "   FROM PERSON P "
                                                                 + "   LEFT OUTER JOIN ADDRESS_PERSON_LINK A "
                                                                 + "            ON (P.ID_PERSON = A.ID_PERSON "
                                                                 + "            AND A.IND_PERS_ADDR_LINK_INVALID = 'N' "
                                                                 + "            AND A.IND_PERS_ADDR_LINK_PRIMARY = 'Y' "
                                                                 + "            AND A.DT_PERS_ADDR_LINK_END = :maxDate ) "
                                                                 + "   LEFT OUTER JOIN PERSON_ADDRESS B "
                                                                 + "            ON A.ID_PERSON_ADDR = B.ID_PERSON_ADDR "
                                                                 + "   LEFT OUTER JOIN PERSON_PHONE C "
                                                                 + "            ON (P.ID_PERSON = C.ID_PERSON "
                                                                 + "            AND C.DT_PERSON_PHONE_END = :maxDate "
                                                                 + "            AND C.IND_PERSON_PHONE_PRIMARY  = 'Y' ) "
                                                                 + "   WHERE P.ID_PERSON = :idPerson");
    query.setInteger("idPerson", idPerson);
    query.setTimestamp("maxDate", DateHelper.MAX_JAVA_DATE);
    query.addScalar("addrPersAddrStLn1", Hibernate.STRING);
    query.addScalar("addrPersAddrStLn2", Hibernate.STRING);
    query.addScalar("addrPersonAddrCity", Hibernate.STRING);
    query.addScalar("addrPersonAddrZip", Hibernate.STRING);
    query.addScalar("cdPersonAddrCounty", Hibernate.STRING);
    query.addScalar("cdPersonAddrState", Hibernate.STRING);
    query.addScalar("nbrPersonPhone", Hibernate.STRING);
    query.addScalar("nbrPersonPhoneExtension", Hibernate.STRING);
    return (List<Object[]>) query.list();
  }

  public Date findAddressPersonLinkDtPersAddrLinkEnd(int idAddrPersonLink) {
    Query query = getSession().createQuery(
                                           "select dtPersAddrLinkEnd " + "  from AddressPersonLink "
                                                           + " where idAddrPersonLink = :idAddrPersonLink");
    query.setInteger("idAddrPersonLink", idAddrPersonLink);
    return (Date) firstResult(query);
  }

  public void insertAddressPersonLink(int idAddrPersonLink, Date dtDtPersAddrLinkEnd, int idPerson, int idAddress,
                                      String indPersAddrLinkInvalid, String indPersAddrLinkPrimary,
                                      String txtPersAddrCmnts, String cdPersAddrLinkType,  String indRemovalHome) {
    Session session = getSession();
    AddressPersonLink addressPersonLink = new AddressPersonLink();
    addressPersonLink.setCdPersAddrLinkType(cdPersAddrLinkType);
    addressPersonLink.setDtPersAddrLinkEnd(dtDtPersAddrLinkEnd);
    addressPersonLink.setDtPersAddrLinkStart(new Date());
    addressPersonLink.setIdAddrPersonLink(idAddrPersonLink);
    addressPersonLink.setPerson((Person) session.load(Person.class, idPerson));
    addressPersonLink.setPersonAddress((PersonAddress) session.load(PersonAddress.class, idAddress));
    addressPersonLink.setIndPersAddrLinkInvalid(indPersAddrLinkInvalid);
    addressPersonLink.setIndPersAddrLinkPrimary(indPersAddrLinkPrimary);
    addressPersonLink.setTxtPersAddrCmnts(txtPersAddrCmnts);
    addressPersonLink.setIndRemovalHome(indRemovalHome);
    session.save(addressPersonLink);
  }

  public void insertAddressPersonLink(int idAddrPersonLink, int idPerson, int idAddress, String indPersAddrLinkInvalid,
                                      String indPersAddrLinkPrimary, String txtPersAddrCmnts, String cdPersAddrLinkType,  String indRemovalHome) {
    Session session = getSession();
    AddressPersonLink addressPersonLink = new AddressPersonLink();
    addressPersonLink.setCdPersAddrLinkType(cdPersAddrLinkType);
    addressPersonLink.setDtPersAddrLinkEnd(new Date());
    addressPersonLink.setDtPersAddrLinkStart(new Date());
    addressPersonLink.setIdAddrPersonLink(idAddrPersonLink);
    addressPersonLink.setPerson((Person) session.load(Person.class, idPerson));
    addressPersonLink.setPersonAddress((PersonAddress) session.load(PersonAddress.class, idAddress));
    addressPersonLink.setIndPersAddrLinkInvalid(indPersAddrLinkInvalid);
    addressPersonLink.setIndPersAddrLinkPrimary(indPersAddrLinkPrimary);
    addressPersonLink.setTxtPersAddrCmnts(txtPersAddrCmnts);
    addressPersonLink.setIndRemovalHome(indRemovalHome);
    session.save(addressPersonLink);
  }

  public void insertAddressPersonLinkStartEnd(int idPersonAddr, int idPerson, String cdPersAddrLinkType,
                                              String indPersAddrLinkInvalid, String indPersAddrLinkPrimary,
                                              Date dtPersAddrLinkStart, Date dtPersAddrLinkEnd,  String indRemovalHome) {
    Session session = getSession();
    AddressPersonLink addressPersonLink = new AddressPersonLink();
    addressPersonLink.setCdPersAddrLinkType(cdPersAddrLinkType);
    addressPersonLink.setPersonAddress((PersonAddress) session.load(PersonAddress.class, idPersonAddr));
    addressPersonLink.setPerson((Person) session.load(Person.class, idPerson));
    addressPersonLink.setIndPersAddrLinkInvalid(indPersAddrLinkInvalid);
    addressPersonLink.setIndPersAddrLinkPrimary(indPersAddrLinkPrimary);
    addressPersonLink.setDtPersAddrLinkStart(dtPersAddrLinkStart);
    addressPersonLink.setDtPersAddrLinkEnd(dtPersAddrLinkEnd);
    addressPersonLink.setIndRemovalHome(indRemovalHome);
    session.save(addressPersonLink);
  }

  public int updateAddressPersonLink(String cdPersAddrLinkType, String indPersAddrLinkInvalid,
                                     String indPersAddrLinkPrimary, String txtPersAddrCmnts, int idAddrPersonLink, String indRemovalHome,
                                     Date tsSysTsLastUpdate2) {
    Query query = getSession()
                              .createQuery(
                                           "update AddressPersonLink "
                                                           + "    set cdPersAddrLinkType = :cdPersAddrLinkType, "
                                                           + "        dtPersAddrLinkEnd = sysdate, "
                                                           + "        indPersAddrLinkInvalid = :indPersAddrLinkInvalid, "
                                                           + "        indPersAddrLinkPrimary = :indPersAddrLinkPrimary, "
                                                           + "        indRemovalHome = :indRemovalHome, "
                                                           + "        txtPersAddrCmnts = :txtPersAddrCmnts "
                                                           + "  where idAddrPersonLink = :idAddrPersonLink "
                                                           + "    and dtLastUpdate <= :tsSysTsLastUpdate2");
    query.setString("cdPersAddrLinkType", cdPersAddrLinkType);
    query.setString("indPersAddrLinkInvalid", indPersAddrLinkInvalid);
    query.setString("indPersAddrLinkPrimary", indPersAddrLinkPrimary);
    query.setString("txtPersAddrCmnts", txtPersAddrCmnts);
    query.setInteger("idAddrPersonLink", idAddrPersonLink);
    query.setString("indRemovalHome", indRemovalHome);
    query.setTimestamp("tsSysTsLastUpdate2", tsSysTsLastUpdate2);

    return query.executeUpdate();
  }

  public int updateAddressPersonLinkByCdPersAddrLinkType(String cdPersAddrLinkType, String indPersAddrLinkInvalid,
                                                         String indPersAddrLinkPrimary, String txtPersAddrCmnts,
                                                         int idAddrPersonLink,  String indRemovalHome, Date tsSysTsLastUpdate2) {
    Query query = getSession()
                              .createQuery(
                                           "update AddressPersonLink apl"
                                                           + "   set apl.cdPersAddrLinkType = :cdPersAddrLinkType, "
                                                           + "       apl.indPersAddrLinkInvalid = :indPersAddrLinkInvalid, "
                                                           + "       apl.indPersAddrLinkPrimary = :indPersAddrLinkPrimary, "
                                                           + "       apl.indRemovalHome = :indRemovalHome, "
                                                           + "       apl.txtPersAddrCmnts = :txtPersAddrCmnts "
                                                           + " where apl.idAddrPersonLink = :idAddrPersonLink "
                                                           + "   and apl.dtLastUpdate <= :tsSysTsLastUpdate2");
    query.setString("cdPersAddrLinkType", cdPersAddrLinkType);
    query.setString("indPersAddrLinkInvalid", indPersAddrLinkInvalid);
    query.setString("indPersAddrLinkPrimary", indPersAddrLinkPrimary);
    query.setString("txtPersAddrCmnts", txtPersAddrCmnts);
    query.setInteger("idAddrPersonLink", idAddrPersonLink);
    query.setString("indRemovalHome", indRemovalHome);
    query.setTimestamp("tsSysTsLastUpdate2", tsSysTsLastUpdate2);

    return query.executeUpdate();

  }

  public int updateAddressPersonLink(String cdPersAddrLinkType, int idAddrPersonLink) {

    Query query = getSession().createQuery(
                                           "update AddressPersonLink "
                                                           + "    set cdPersAddrLinkType = :cdPersAddrLinkType, "
                                                           + "        indPersAddrLinkInvalid = 'n', "
                                                           + "        indPersAddrLinkPrimary = 'y'"
                                                           + "  where idAddrPersonLink = :idAddrPersonLink");
    query.setString("cdPersAddrLinkType", cdPersAddrLinkType);
    query.setInteger("idAddrPersonLink", idAddrPersonLink);

    return query.executeUpdate();
  }

  public void insertAddressPersonLink(String cdPersAddrLinkType, int idPerson, int idAddress) {
    AddressPersonLink addressPersonLink = new AddressPersonLink();
    addressPersonLink.setCdPersAddrLinkType(cdPersAddrLinkType);
    Person person = (Person) getSession().load(Person.class, idPerson);
    addressPersonLink.setPerson(person);
    PersonAddress personAddress = (PersonAddress) getSession().load(PersonAddress.class, idAddress);
    addressPersonLink.setPersonAddress(personAddress);
    addressPersonLink.setIndPersAddrLinkInvalid("N");
    addressPersonLink.setIndPersAddrLinkPrimary("Y");
    addressPersonLink.setIndPersAddrLinkPrimary("N");
    getSession().saveOrUpdate(addressPersonLink);
  }
}
