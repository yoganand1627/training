package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonAddressDAO;
import gov.georgia.dhr.dfcs.sacwis.db.PersonAddress;
import org.hibernate.*;

/** Change History:
 **  Date        User              Description
 **  --------    ----------------  --------------------------------------------------
 **  04/14/2008  Corey Harden      STGAP00007852: created updateDtLastUpdateByIdPersonAddr() 
 *                                 method to update the dtLastUpdate in personAddress table
 *   10/25/2009  mxpatel           38626: added method findPersonAddressByIdPersonAddress                              
 **/

public class PersonAddressDAOImpl extends BaseDAOImpl implements PersonAddressDAO {

  public int insertPersonAddressWithSeqPersonAddress(String addrPersAddrStLn1, String addrPersAddrStLn2,
                                                     String addrCity, String addrZip, String addrPersAddrAttn,
                                                     String txtPersonEmail, String cdAddrCounty, String cdAddrState) {
    PersonAddress personAddress = new PersonAddress();
    personAddress.setAddrPersAddrStLn1(addrPersAddrStLn1);
    personAddress.setAddrPersAddrStLn2(addrPersAddrStLn2);
    personAddress.setAddrPersonAddrCity(addrCity);
    personAddress.setAddrPersonAddrZip(addrZip);
    personAddress.setAddrPersonAddrAttn(addrPersAddrAttn);
    personAddress.setTxtPersonEmail(txtPersonEmail);
    personAddress.setCdPersonAddrCounty(cdAddrCounty);
    personAddress.setCdPersonAddrState(cdAddrState);
    getSession().save(personAddress);
    return personAddress.getIdPersonAddr();
  }

  public int updatePersonAddress(Date tsLastUpdate, String addrPersAddrStLn1, String addrPersAddrStLn2,
                                 String addrCity, String addrZip, String addrPersAddrAttn, String txtPersonEmail,
                                 String cdAddrCounty, String cdAddrState, int idAddress) {
    Query query = getSession().createQuery(
                                           "update PersonAddress pa "
                                                           + "   set pa.addrPersAddrStLn1 = :addrPersAddrStLn1, "
                                                           + "       pa.addrPersAddrStLn2 = :addrPersAddrStLn2, "
                                                           + "       pa.addrPersonAddrCity = :addrCity, "
                                                           + "       pa.addrPersonAddrZip = :addrZip, "
                                                           + "       pa.cdPersonAddrCounty = :cdAddrCounty, "
                                                           + "       pa.addrPersonAddrAttn = :addrPersAddrAttn, "
                                                           + "       pa.txtPersonEmail = :txtPersonEmail,"
                                                           + "       pa.cdPersonAddrState = :cdAddrState "
                                                           + " where pa.idPersonAddr = :idAddress "
                                                           + "   and pa.dtLastUpdate <= :tsLastUpdate");
    query.setString("addrPersAddrStLn1", addrPersAddrStLn1);
    query.setString("addrPersAddrStLn2", addrPersAddrStLn2);
    query.setString("addrCity", addrCity);
    query.setString("addrZip", addrZip);
    query.setString("cdAddrCounty", cdAddrCounty);
    query.setString("addrPersAddrAttn", addrPersAddrAttn);
    query.setString("txtPersonEmail", txtPersonEmail);
    query.setString("cdAddrState", cdAddrState);
    query.setInteger("idAddress", idAddress);
    query.setTimestamp("tsLastUpdate", tsLastUpdate);

    return query.executeUpdate();
  }
  
  public int updatePersonAddressByidPersonAddr(String addrPersAddrStLn1, String addrPersAddrStLn2,
                                 String addrCity, String addrZip, String addrPersAddrAttn, String txtPersonEmail,
                                 String cdAddrCounty, String cdAddrState, int idAddress) {
    Query query = getSession().createQuery(
                                           "update PersonAddress pa "
                                                           + "   set pa.addrPersAddrStLn1 = :addrPersAddrStLn1, "
                                                           + "       pa.addrPersAddrStLn2 = :addrPersAddrStLn2, "
                                                           + "       pa.addrPersonAddrCity = :addrCity, "
                                                           + "       pa.addrPersonAddrZip = :addrZip, "
                                                           + "       pa.cdPersonAddrCounty = :cdAddrCounty, "
                                                           + "       pa.addrPersonAddrAttn = :addrPersAddrAttn, "
                                                           + "       pa.txtPersonEmail = :txtPersonEmail,"
                                                           + "       pa.cdPersonAddrState = :cdAddrState "
                                                           + " where pa.idPersonAddr = :idAddress ");
    query.setString("addrPersAddrStLn1", addrPersAddrStLn1);
    query.setString("addrPersAddrStLn2", addrPersAddrStLn2);
    query.setString("addrCity", addrCity);
    query.setString("addrZip", addrZip);
    query.setString("cdAddrCounty", cdAddrCounty);
    query.setString("addrPersAddrAttn", addrPersAddrAttn);
    query.setString("txtPersonEmail", txtPersonEmail);
    query.setString("cdAddrState", cdAddrState);
    query.setInteger("idAddress", idAddress);

    return query.executeUpdate();
  }

  public String findPersonEmailAddressByIdPerson(int idPerson) {

    Query query = getSession()
                              .createQuery(
                                           "select txtPersonEmail from PersonAddress pa where pa.idPersonAddr = "
                                                           + " ( select ap.personAddress.idPersonAddr from "
                                                           + " AddressPersonLink  ap where ap.person.idPerson = :idPerson)");
    query.setInteger("idPerson", idPerson);
    return (String) firstResult(query);
  }

  public int updatePersonAddress(String addrPersAddrStLn1, int idAddress) {

    Query query = getSession().createQuery(
                                           "update PersonAddress " + "    set addrPersAddrStLn1 = :addrPersAddrStLn1 "
                                                           + "  where idPersonAddr = :idAddress");
    query.setString("addrPersAddrStLn1", addrPersAddrStLn1);
    query.setInteger("idAddress", idAddress);

    return query.executeUpdate();
  }

  public int updatePersonAddressAddrPersAddrStLn2(String addrPersAddrStLn2, int idAddress) {

    Query query = getSession().createQuery(
                                           "update PersonAddress " + "    set addrPersAddrStLn2 = :addrPersAddrStLn2 "
                                                           + "  where idPersonAddr = :idAddress");
    query.setString("addrPersAddrStLn2", addrPersAddrStLn2);
    query.setInteger("idAddress", idAddress);

    return query.executeUpdate();
  }

  public int updatePersonAddressAddrCity(String addrCity, int idAddress) {

    Query query = getSession().createQuery(
                                           "update PersonAddress " + "    set addrPersonAddrCity = :addrCity "
                                                           + "  where idPersonAddr = :idAddress");
    query.setString("addrCity", addrCity);
    query.setInteger("idAddress", idAddress);

    return query.executeUpdate();
  }

  public int updatePersonAddressAddrZip(String addrZip, int idAddress) {

    Query query = getSession().createQuery(
                                           "update PersonAddress " + "    set addrPersonAddrZip = :addrZip "
                                                           + "  where idPersonAddr = :idAddress");
    query.setString("addrZip", addrZip);
    query.setInteger("idAddress", idAddress);

    return query.executeUpdate();
  }

  public int updatePersonAddressCdAddrCounty(String cdAddrCounty, int idAddress) {

    Query query = getSession().createQuery(
                                           "update PersonAddress " + "    set cdPersonAddrCounty = :cdAddrCounty "
                                                           + "  where idPersonAddr = :idAddress");
    query.setString("cdAddrCounty", cdAddrCounty);
    query.setInteger("idAddress", idAddress);

    return query.executeUpdate();
  }

  public int updatePersonAddressCdAddrState(String cdAddrState, int idAddress) {

    Query query = getSession().createQuery(
                                           "update PersonAddress " + "    set cdPersonAddrState = :cdAddrState "
                                                           + "  where idPersonAddr = :idAddress");
    query.setString("cdAddrState", cdAddrState);
    query.setInteger("idAddress", idAddress);

    return query.executeUpdate();
  }

  public int insertPersonAddress(String addrPersAddrStLn1, String addrPersAddrStLn2, String addrCity, String addrZip,
                                 String cdAddrCounty, String cdAddrState) {

    PersonAddress personAddress = new PersonAddress();
    personAddress.setAddrPersonAddrZip(addrZip);
    personAddress.setCdPersonAddrState(cdAddrState);
    personAddress.setAddrPersonAddrCity(addrCity);
    personAddress.setAddrPersAddrStLn1(addrPersAddrStLn1);
    personAddress.setAddrPersAddrStLn2(addrPersAddrStLn2);
    personAddress.setCdPersonAddrCounty(cdAddrCounty);

    getSession().saveOrUpdate(personAddress);
    return personAddress.getIdPersonAddr();
  }

  public Map findPersonAddressByIdPersonAddr(int idPerson) {
    Query query = getSession()
                              .createQuery(
                                           "     select new map(pm.personByIdPersMergeForward.idPerson as personByIdPersMergeForward, "
                                                           + "                    p.cdPersonSex as cdPersonSex, "
                                                           + "                    p.dtPersonBirth as dtPersonBirth, "
                                                           + "                    p.dtPersonDeath as dtPersonDeath, "
                                                           + "                    p.cdPersonEthnicGroup as cdPersonEthnicGroup, "
                                                           + "                    pi.nbrPersonIdNumber as nbrPersonIdNumber, "
                                                           + "                    pa.addrPersonAddrCity as addrPersonAddrCity, "
                                                           + "                    pa.addrPersAddrStLn1 as addrPersAddrStLn1, "
                                                           + "                    pa.cdPersonAddrCounty as cdPersonAddrCounty, "
                                                           + "                    n.nmNameFirst as nmNameFirst, "
                                                           + "                    n.nmNameMiddle as nmNameMiddle, "
                                                           + "                    n.nmNameLast as nmNameLast) "
                                                           + "       from PersonMerge pm "
                                                           + "       join pm.personByIdPersMergeForward p "
                                                           + "  left join p.addressPersonLinks apl "
                                                           + "  left join apl.personAddress pa "
                                                           + "  left join p.names n "
                                                           + "  left join p.personIds pi "
                                                           + "      where pm.personByIdPersMergeClosed.idPerson = :idPerson "
                                                           + "        and pm.indPersMergeInvalid = 'N'"
                                                           + "        and ( apl.indPersAddrLinkPrimary = 'Y' or apl.indPersAddrLinkPrimary IS NULL ) "
                                                           + "        and ( apl.indPersAddrLinkInvalid = 'N'or apl.indPersAddrLinkPrimary IS NULL ) "
                                                           + "        and ( apl.dtPersAddrLinkEnd = :maxDate or apl.dtPersAddrLinkEnd IS NULL ) "
                                                           + "        and ( n.indNamePrimary = 'Y' or n.indNamePrimary is NULL ) "
                                                           + "        and ( n.indNameInvalid = 'N' or n.indNameInvalid is NULL ) "
                                                           + "        and ( n.dtNameEndDate = :maxDate or n.dtNameEndDate  is NULL ) "
                                                           + "        and ( pi.cdPersonIdType = 'SSN' or pi.cdPersonIdType is NULL ) "
                                                           + "        and ( pi.indPersonIdInvalid = 'N' or pi.indPersonIdInvalid is NULL ) "
                                                           + "        and ( pi.dtPersonIdEnd = :maxDate or pi.dtPersonIdEnd is NULL )");
    query.setInteger("idPerson", idPerson);
    query.setTimestamp("maxDate", DateHelper.MAX_JAVA_DATE);
    return (Map) firstResult(query);
  }

  public PersonAddress findPrimaryPersonAddressByIdPerson(int idPerson) {

    Query query = getSession()
                              .createQuery(
                                           "select pa "
                                                           + "  from PersonAddress pa,"
                                                           + " AddressPersonLink apl "
                                                           + " where  apl.person.idPerson = :idPerson"
                                                           + " and pa.idPersonAddr = apl.personAddress.idPersonAddr "
                                                           + " and ( apl.indPersAddrLinkPrimary = 'Y' or apl.indPersAddrLinkPrimary IS NULL ) "
                                                           + " and ( apl.indPersAddrLinkInvalid = 'N'or apl.indPersAddrLinkInvalid IS NULL ) "
                                                           + " and ( apl.dtPersAddrLinkEnd IS NULL "
                                                           + "       or apl.dtPersAddrLinkEnd = :maxDate ) ");
    query.setInteger("idPerson", idPerson);
    query.setTimestamp("maxDate", DateHelper.MAX_JAVA_DATE);
    return (PersonAddress) firstResult(query);
  }

  @SuppressWarnings( { "unchecked" })
  public List<Map> findPrimaryPersonAddressByIdPerson(Collection<Integer> idPersons) {

    Query query = getSession()
                              .createQuery(
                                           "select new map(apl.person.idPerson as idPerson, pa as personAddress ) "
                                                           + "  from PersonAddress pa,"
                                                           + " AddressPersonLink apl "
                                                           + " where  apl.person.idPerson in ( :idPersons )"
                                                           + " and pa.idPersonAddr = apl.personAddress.idPersonAddr "
                                                           + " and ( apl.indPersAddrLinkPrimary = 'Y' or apl.indPersAddrLinkPrimary IS NULL ) "
                                                           + " and ( apl.indPersAddrLinkInvalid = 'N'or apl.indPersAddrLinkInvalid IS NULL ) "
                                                           + " and ( apl.dtPersAddrLinkEnd IS NULL "
                                                           + "       or apl.dtPersAddrLinkEnd = :maxDate ) ");
    query.setParameterList("idPersons", idPersons);
    query.setTimestamp("maxDate", DateHelper.MAX_JAVA_DATE);
    return (List<Map>) query.list();
  }

  // created for Notification to Law Enforcement - kevin
  public Object[] findPersonAddressByIdStage(int idStage) {
    SQLQuery query = getSession()
                                 .createSQLQuery(
                                                 "SELECT PA.ADDR_PERS_ADDR_ST_LN_1 as ADDR_PERS_ADDR_ST_LN_1, "
                                                                 + "PA.ADDR_PERS_ADDR_ST_LN_2 as ADDR_PERS_ADDR_ST_LN_2, "
                                                                 + "PA.ADDR_PERSON_ADDR_CITY as ADDR_PERSON_ADDR_CITY, "
                                                                 + "PA.CD_PERSON_ADDR_STATE as CD_PERSON_ADDR_STATE, "
                                                                 + "PA.ADDR_PERSON_ADDR_ZIP as ADDR_PERSON_ADDR_ZIP "
                                                                 + "FROM PERSON_ADDRESS PA ,"
                                                                 + "ADDRESS_PERSON_LINK APL, "
                                                                 + "STAGE_PERSON_LINK SPL "
                                                                 + "WHERE SPL.ID_STAGE = :idStage "
                                                                 + "AND SPL.ID_PERSON = APL.ID_PERSON "
                                                                 + "AND APL.DT_PERS_ADDR_LINK_END = TO_DATE('12/31/4712','mm/dd/yyyy') "
                                                                 + "AND APL.ID_PERSON_ADDR = PA.ID_PERSON_ADDR "
                                                                 + "AND APL.IND_PERS_ADDR_LINK_PRIMARY = 'Y' "
                                                                 + "AND SPL.CD_STAGE_PERS_REL_INT = 'PK' ");

    /*
     * "Select pa " + "from AddressPersonLink apl " + "join apl.personAddress pa " + "join apl.person p " + "join
     * p.stagePersonLinks spl " + "where spl.stage.idStage = :idStage " + "and spl.person.idPerson = apl.person.idPerson " +
     * "and apl.dtPersAddrLinkEnd IS NULL " + "and apl.cdPersAddrLinkType = 'RS' " + "and spl.cdStagePersRole = 'VC'");
     */
    query.setInteger("idStage", idStage);
    query.addScalar("ADDR_PERS_ADDR_ST_LN_1", Hibernate.STRING);
    query.addScalar("ADDR_PERS_ADDR_ST_LN_2", Hibernate.STRING);
    query.addScalar("ADDR_PERSON_ADDR_CITY", Hibernate.STRING);
    query.addScalar("CD_PERSON_ADDR_STATE", Hibernate.STRING);
    query.addScalar("ADDR_PERSON_ADDR_ZIP", Hibernate.STRING);

    return (Object[]) firstResult(query);
  }

  // end - kevin

  public PersonAddress findCurrentPrimaryPersonAddressByIdPerson(int idPerson) {

    Query query = getSession()
                              .createQuery(
                                           "select pa "
                                                           + "  from PersonAddress pa,"
                                                           + " AddressPersonLink apl "
                                                           + " where  apl.person.idPerson = :idPerson"
                                                           + " and pa.idPersonAddr = apl.personAddress.idPersonAddr "
                                                           + " and ( apl.indPersAddrLinkPrimary = 'Y' or apl.indPersAddrLinkPrimary IS NULL ) "
                                                           + " and ( apl.indPersAddrLinkInvalid = 'N'or apl.indPersAddrLinkInvalid IS NULL ) "
                                                           + " and ( apl.dtPersAddrLinkEnd =:maxDate or apl.dtPersAddrLinkEnd IS NULL ) ");
    query.setTimestamp("maxDate", DateHelper.MAX_JAVA_DATE);
    query.setInteger("idPerson", idPerson);
    return (PersonAddress) firstResult(query);
  }

  public int updateDtLastUpdateByIdPersonAddr(int idPersonAddr, Date dtLastUpdate) {
    Query query = getSession().createQuery(
                                           "update PersonAddress " + "    set dtLastUpdate = :dtLastUpdate "
                                                           + "  where idPersonAddr = :idPersonAddr");
    query.setDate("dtLastUpdate", dtLastUpdate);
    query.setInteger("idPersonAddr", idPersonAddr);

    return query.executeUpdate();
  }
  
  public PersonAddress findPersonAddressByIdPersonAddress(int idPersonAddress) {
    Query query = getSession().createQuery(
                                           " from PersonAddress pa "
                                                           + " where pa.idPersonAddr = :idPersonAddress");
    query.setInteger("idPersonAddress", idPersonAddress);
    return (PersonAddress) firstResult(query);
  }
}
