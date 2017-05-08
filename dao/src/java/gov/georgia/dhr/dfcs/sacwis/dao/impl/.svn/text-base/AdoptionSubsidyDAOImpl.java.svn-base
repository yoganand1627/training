package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.dao.AdoptionSubsidyDAO;
import gov.georgia.dhr.dfcs.sacwis.db.AdoptionSubsidy;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SQLQuery;

/*** Change History:
 **  Date        User              Description
 **  --------    ----------------  --------------------------------------------------
                 
 * 05/18/2009  bgehlot           STGAP00013779: MR-050: Added method findActiveAdoptionSubsidyByIdPersonCdAdoptionType,
 *                               totalNonRecAdoptionSubsidyAmt
 * 06/11/2009 bgehlot            STGAP00014186: Added the method findSpecialServiceForAttachedApp
 * 01/08/2010  mxpatel           STGAP00015702: Added methods for MR-52 - findAdoSubsforSpcNeedsDeter, findAmountAdoSubByIdAdoSub
 * 02/10/2010  mxpatel           SMS #44084: added method findActiveAdoptionSubsidyByIdPersonCdAdoptionTypeOfSvcAuthDtl. Modified the existing
 *                               methods to return only active ado_sub.
 * 02/22/2010  mxpatel           SMS #44084: Added code to consider amount as well when searching for agreements with same type
 * 03/02/2010  mxpatel           SMS #45293: modified the code so that all service auths will copied from ADO to PAD (including end dated and terminated).  Also
 *                               added code to make sure approved amount for Non Recurring services on the Adoption Assistance 
 *                               Application is strictly adhered to by looking to previously approved and paid Assistance Agreements
 * 03/02/2010  mxpatel           SMS #44084: Modified the method to exclude end date and term date validations.
 * 06/10/2010  arege             SMS#53458 : Replaced or condition with an and condition in method findActiveAdoptionSubsidyByIdPersonCdAdoptionType
 *                               to correctly find the overlapping agreements.
 * 04/14/2011  htvo              SMS#105696: MR-074-2 AFCARS: remove join fetch to SpecialNeedsDetermination from findActiveAdoptionSubsidyByIdCaseIdAdptSubPersonCdAdptSubDetermAndDateEffBy
 *                               and findActiveAdoptionSubsidyByIdCaseIdAdptSubPersonAndDateEffBy because converted agreement may not be linked to an application
 *                                                            
 */ 

public class AdoptionSubsidyDAOImpl extends BaseDAOImpl implements AdoptionSubsidyDAO {
  public Integer findIdAdptSubPersonByIdAdptSub(int adptSubPerson, Date dtAdptSubEffective,
                                                Date dtAdptSubEnd, int idAdptSub) {
    Query query = getSession().createQuery("select person.idPerson " +
                                           "  from AdoptionSubsidy " +
                                           " where person.idPerson = :adptSubPerson " +
                                           "   and trunc(dtAdptSubEffective) <= trunc(:dtAdptSubEffective) " +
                                           "   and trunc(dtAdptSubEnd) >= trunc(:dtAdptSubEnd) " +
                                           "   and  not (:dtAdptSubEffective = :dtAdptSubEnd " +
                                           "             and (trunc(dtAdptSubEffective) = trunc(:dtAdptSubEffective) " +
                                           "                  or trunc(dtAdptSubEnd) = trunc(:dtAdptSubEnd))) " +
                                           "   and (cdAdptSubDeterm in ('" + CodesTables.CSUBTYPE_01 +"' , " +
                                           "                 '" + CodesTables.CSUBTYPE_03 + "' , " +
                                           "                 '" + CodesTables.CSUBTYPE_07 + "' , " +
                                           "                 '" + CodesTables.CSUBTYPE_09 + "' )) " +
                                           "   and cdAdptSubCloseRsn is null  " +
                                           "   and idAdptSub <> :idAdptSub");
    query.setInteger("adptSubPerson", adptSubPerson);
    query.setTimestamp("dtAdptSubEffective", dtAdptSubEffective);
    query.setTimestamp("dtAdptSubEnd", dtAdptSubEnd);
    query.setInteger("idAdptSub", idAdptSub);

    return (Integer) firstResult(query);
  }
  public AdoptionSubsidy findAdptSubByIdAdptSub(int idAdptSub){
    Query query = getSession().createQuery(" from AdoptionSubsidy asdy " +
                                           " where asdy.idAdptSub = :idAdptSub ");

    query.setInteger("idAdptSub", idAdptSub);
    return (AdoptionSubsidy) firstResult(query);
  }
  public Integer findIdPersonByAdPtSubAndCdAdptSubCloseRsn(int adptSubPerson, Date dtAdptSubEffective,
                                                           Date dtAdptSubEnd, int idAdptSub) {
    Query query = getSession().createQuery("select person.idPerson " +
                                           "  from AdoptionSubsidy " +
                                           " where person.idPerson = :adptSubPerson " +
                                           "   and trunc(dtAdptSubEffective) > trunc(:dtAdptSubEffective) " +
                                           "   and trunc(dtAdptSubEffective) < trunc(:dtAdptSubEnd) " +
                                           "   and (cdAdptSubDeterm in ('" + CodesTables.CSUBTYPE_01 +"' , " +
                                           "                 '" + CodesTables.CSUBTYPE_03 + "' , " +
                                           "                 '" + CodesTables.CSUBTYPE_07 + "' , " +
                                           "                 '" + CodesTables.CSUBTYPE_09 + "' )) " +
                                           "   and cdAdptSubCloseRsn is null  " +
                                           "   and idAdptSub <> :idAdptSub");
    query.setInteger("adptSubPerson", adptSubPerson);
    query.setTimestamp("dtAdptSubEffective", dtAdptSubEffective);
    query.setTimestamp("dtAdptSubEnd", dtAdptSubEnd);
    query.setInteger("idAdptSub", idAdptSub);
    return (Integer) firstResult(query);
  }

  public Integer findAdptSubPersonByIdAdptSub(int idAdptSub, Date dtAdptSubEnd, Date dtAdptSubEffective,
                                              int adptSubPerson) {
    Query query = getSession().createQuery("select person.idPerson " +
                                           "  from AdoptionSubsidy " +
                                           " where person.idPerson = :adptSubPerson " +
                                           "   and trunc(dtAdptSubEnd) > trunc(:dtAdptSubEffective) " +
                                           "   and trunc(dtAdptSubEnd) < trunc(:dtAdptSubEnd) " +
                                           "   and (cdAdptSubDeterm in ('" + CodesTables.CSUBTYPE_01 +"' , " +
                                           "                 '" + CodesTables.CSUBTYPE_03 + "' , " +
                                           "                 '" + CodesTables.CSUBTYPE_07 + "' , " +
                                           "                 '" + CodesTables.CSUBTYPE_09 + "' )) " +
                                           "   and cdAdptSubCloseRsn is null " +
                                           "   and idAdptSub <> :idAdptSub");
    query.setInteger("adptSubPerson", adptSubPerson);
    query.setTimestamp("dtAdptSubEffective", dtAdptSubEffective);
    query.setTimestamp("dtAdptSubEnd", dtAdptSubEnd);
    query.setInteger("idAdptSub", idAdptSub);
    return (Integer) firstResult(query);
  }

  public Integer findIdPersonByAdptSubPerson(int adptSubPerson, Date dtAdptSubEffective, Date dtAdptSubEnd) {
    Query query = getSession().createQuery("select person.idPerson " +
                                           "   from AdoptionSubsidy " +
                                           "   where person.idPerson = :adptSubPerson " +
                                           "   and trunc(dtAdptSubEffective) <= trunc(:dtAdptSubEffective) " +
                                           "   and trunc(dtAdptSubEnd) >= trunc(:dtAdptSubEnd) " +
                                           "   and not (:dtAdptSubEffective = :dtAdptSubEnd " +
                                           "            and (trunc(dtAdptSubEffective) = trunc(:dtAdptSubEffective) " +
                                           "                 or trunc(dtAdptSubEnd) = trunc(:dtAdptSubEnd))) " +
                                           "   and (cdAdptSubDeterm in ('" + CodesTables.CSUBTYPE_01 +"' , " +
                                           "                 '" + CodesTables.CSUBTYPE_03 + "' , " +
                                           "                 '" + CodesTables.CSUBTYPE_07 + "' , " +
                                           "                 '" + CodesTables.CSUBTYPE_09 + "' )) " +
                                           "   and cdAdptSubCloseRsn is null");
    query.setInteger("adptSubPerson", adptSubPerson);
    query.setTimestamp("dtAdptSubEffective", dtAdptSubEffective);
    query.setTimestamp("dtAdptSubEnd", dtAdptSubEnd);
    return (Integer) firstResult(query);
  }

  public Integer findIdPersonByCdAdptSubCloseRsn(int adptSubPerson, Date dtAdptSubEffective, Date dtAdptSubEnd) {
    Query query = getSession().createQuery("select person.idPerson " +
                                           "  from AdoptionSubsidy " +
                                           " where person.idPerson = :adptSubPerson " +
                                           "   and trunc(dtAdptSubEffective) > trunc(:dtAdptSubEffective) " +
                                           "   and trunc(dtAdptSubEffective) < trunc(:dtAdptSubEnd) " +
                                           "   and (cdAdptSubDeterm in ('" + CodesTables.CSUBTYPE_01 +"' , " +
                                           "                 '" + CodesTables.CSUBTYPE_03 + "' , " +
                                           "                 '" + CodesTables.CSUBTYPE_07 + "' , " +
                                           "                 '" + CodesTables.CSUBTYPE_09 + "' )) " +
                                           "   and cdAdptSubCloseRsn is null ");
    query.setInteger("adptSubPerson", adptSubPerson);
    query.setTimestamp("dtAdptSubEffective", dtAdptSubEffective);
    query.setTimestamp("dtAdptSubEnd", dtAdptSubEnd);

    return (Integer) firstResult(query);
  }

  public Integer findIdPersonByDtAdptSubEnd(int adptSubPerson, Date dtAdptSubEffective, Date dtAdptSubEnd) {
    Query query = getSession().createQuery("select person.idPerson " +
                                           "  from AdoptionSubsidy " +
                                           " where person.idPerson = :adptSubPerson " +
                                           "   and trunc(dtAdptSubEnd) > trunc(:dtAdptSubEffective) " +
                                           "   and trunc(dtAdptSubEnd) < trunc(:dtAdptSubEnd) " +
                                           "   and (cdAdptSubDeterm in ('" + CodesTables.CSUBTYPE_01 +"' , " +
                                                        "                 '" + CodesTables.CSUBTYPE_03 + "' , " +                                                        "                 '" + CodesTables.CSUBTYPE_07 + "' , " +
                                                        "                 '" + CodesTables.CSUBTYPE_09 + "' )) " +
                                           "   and cdAdptSubCloseRsn is null ");
    query.setInteger("adptSubPerson", adptSubPerson);
    query.setTimestamp("dtAdptSubEffective", dtAdptSubEffective);
    query.setTimestamp("dtAdptSubEnd", dtAdptSubEnd);

    return (Integer) firstResult(query);
  }

  @SuppressWarnings({"unchecked"})
  public List<AdoptionSubsidy> findListOfOpenAdoptionSubsidyByIdAdptSubPersonAndDtAdptSubEnd(int idAdptSubPerson,
                                                                                             Date dtPersonDeath) {
    Query query = getSession().createQuery(" from AdoptionSubsidy " +
                                           "where person.idPerson = :idAdptSubPerson " +
                                           "  and dtAdptSubEnd >= :dtPersonDeath " +
                                           "  and cdAdptSubCloseRsn is null ");

    query.setInteger("idAdptSubPerson", idAdptSubPerson);
    query.setTimestamp("dtPersonDeath", dtPersonDeath);
    return (List<AdoptionSubsidy>) query.list();
  }

  public Integer findIdAdptSubPersonByDtAdptSubEndLessEqlDtCurrStartAndGrtrDtAdptSubEffective(int idAdptSubPerson,
                                                                                              int idAdptSub,
                                                                                              String cdAdptAudDeterm,
                                                                                              Date dtCurrStart,
                                                                                              Date dtAdptSubEffective) {
    Query query = getSession().createQuery(" select person.idPerson as idAdptSubPerson" +
                                           "   from AdoptionSubsidy" +
                                           "  where person.idPerson = :idAdptSubPerson" +
                                           "    and idAdptSub <> :idAdptSub" +
                                           "    and cdAdptSubDeterm = :cdAdptAudDeterm" +
                                           "    and trunc(dtAdptSubEnd) <= :dtCurrStart" +
                                           "    and trunc(dtAdptSubEnd) > :dtAdptSubEffective" +
                                           "   and (cdAdptSubDeterm in ('" + CodesTables.CSUBTYPE_01 +"' , " +
                                           "                 '" + CodesTables.CSUBTYPE_03 + "' , " +
                                           "                 '" + CodesTables.CSUBTYPE_07 + "' , " +
                                           "                 '" + CodesTables.CSUBTYPE_09 + "' )) " );

    query.setInteger("idAdptSubPerson", idAdptSubPerson);
    query.setInteger("idAdptSub", idAdptSub);
    query.setString("cdAdptAudDeterm", cdAdptAudDeterm);
    query.setTimestamp("dtCurrStart", dtCurrStart);
    query.setTimestamp("dtAdptSubEffective", dtAdptSubEffective);
    return (Integer) firstResult(query);
  }

  public Integer findIdAdptSubPersonByDtAdptSubEffectiveGrtrEqlDtCurrEndAndLessDtAdptSubEnd(int idAdptSubPerson,
                                                                                            int idAdptSub,
                                                                                            String cdAdptAudDeterm,
                                                                                            Date dtCurrEnd,
                                                                                            Date dtAdptSubEnd) {
    Query query = getSession().createQuery(" select person.idPerson as idAdptSubPerson" +
                                           "   from AdoptionSubsidy" +
                                           "  where person.idPerson = :idAdptSubPerson" +
                                           "    and idAdptSub <> :idAdptSub" +
                                           "    and cdAdptSubDeterm = :cdAdptAudDeterm" +
                                           "    and trunc(dtAdptSubEffective) >= :dtCurrEnd" +
                                           "    and trunc(dtAdptSubEffective) < :dtAdptSubEnd" +
                                           "   and (cdAdptSubDeterm in ('" + CodesTables.CSUBTYPE_01 +"' , " +
                                           "                 '" + CodesTables.CSUBTYPE_03 + "' , " +
                                           "                 '" + CodesTables.CSUBTYPE_07 + "' , " +
                                           "                 '" + CodesTables.CSUBTYPE_09 + "' )) ");

    query.setInteger("idAdptSubPerson", idAdptSubPerson);
    query.setInteger("idAdptSub", idAdptSub);
    query.setString("cdAdptAudDeterm", cdAdptAudDeterm);
    query.setTimestamp("dtCurrEnd", dtCurrEnd);
    query.setTimestamp("dtAdptSubEnd", dtAdptSubEnd);
    return (Integer) firstResult(query);
  }

  public int saveAdoptionSubsidy(AdoptionSubsidy adoptionSubsidy) {
    getSession().saveOrUpdate(adoptionSubsidy);
    return adoptionSubsidy.getIdAdptSub();
  }

  public Object[] findAdoptionSubsidyByIdAdptSubPerson(Date dtAdptSubEffective, Date dtAdptSubEnd, int adptSubPerson,
                                                       Date tsLastUpdate) {
    SQLQuery query = getSession().createSQLQuery("SELECT ID_ADPT_SUB_PERSON AS idAdptSubPerson, " +
                                                 "       TRUNC(DT_ADPT_SUB_EFFECTIVE) AS dEff, " +
                                                 "       TRUNC(DT_ADPT_SUB_END) AS dEnd, " +
                                                 "       TRUNC(:dtAdptSubEffective) AS dAEff, " +
                                                 "       TRUNC(:dtAdptSubEnd) AS dAEnd " +
                                                 "  FROM ADOPTION_SUBSIDY " +
                                                 " WHERE ID_ADPT_SUB_PERSON = :adptSubPerson " +
                                                 "   AND DT_LAST_UPDATE = :tsLastUpdate");
    query.setTimestamp("dtAdptSubEffective", dtAdptSubEffective);
    query.setTimestamp("dtAdptSubEnd", dtAdptSubEnd);
    query.setInteger("adptSubPerson", adptSubPerson);
    query.setTimestamp("tsLastUpdate", tsLastUpdate);
    query.addScalar("idAdptSubPerson", Hibernate.INTEGER);
    query.addScalar("dEff", Hibernate.DATE);
    query.addScalar("dEnd", Hibernate.DATE);
    query.addScalar("dAEFf", Hibernate.DATE);
    query.addScalar("dAEnd", Hibernate.DATE);
    return (Object[]) firstResult(query);
  }

  public void deleteAdoptionSubsidy(AdoptionSubsidy adoptionSubsidy) {
    getSession().delete(adoptionSubsidy);
  }
  
  //STGAP00010749: Find the adoption subsidy record for the given person and the Adoption Assistance Application event.
  public AdoptionSubsidy findAdoptionSubsidyByIdPerson(int idPerson, int idAdoAsstAppEvent) {
    Query query = getSession().createQuery("from AdoptionSubsidy adp " +
                                           "where adp.person.idPerson = :idPerson " +
                                           "and adp.dtAdptSubEffective <= sysdate " +
                                           "and adp.specialNeedsDetermination.idEvent = :idAdoAsstAppEvent " +
                                           "and (adp.dtAdptSubEnd is null or adp.dtAdptSubEnd >= sysdate) " + 
                                           "and (adp.dtAdptSubTerminated is null or adp.dtAdptSubTerminated >= sysdate) " +
                                           " order by adp.dtAdptSubEffective desc");
    query.setInteger("idPerson", idPerson);
    query.setInteger("idAdoAsstAppEvent", idAdoAsstAppEvent);
    return (AdoptionSubsidy) firstResult(query);
  }
 
  //STGAP00010749: Gets the most recent non-end dated Adoption Subsidy record for the given person  
  public AdoptionSubsidy findAdoptionSubsidyByIdPerson(int idPerson) {
    Query query = getSession().createQuery("from AdoptionSubsidy adp " +
                                           "where adp.person.idPerson = :idPerson " +
                                           "and adp.dtAdptSubEffective <= sysdate " +
                                           "and (adp.dtAdptSubEnd is null or adp.dtAdptSubEnd >= sysdate) " + 
                                           "and (adp.dtAdptSubTerminated is null or adp.dtAdptSubTerminated >= sysdate) " +
                                           " order by adp.dtAdptSubEffective desc");
    query.setInteger("idPerson", idPerson);
    return (AdoptionSubsidy) firstResult(query);
  }
  
  //STGAP00013779: Gets the most recent non-end datedAdoption Subsidy record for the given person 
  //SMS#53458 : replaced or condition with an and condition to correctly find the overlapping agreements.
  @SuppressWarnings({"unchecked"})
  public Map<String, Object> findActiveAdoptionSubsidyByIdPersonCdAdoptionType(int idCase, int idEvent, int idPerson, List<String> cdAdoptionType, Date dtAdptSubEffective, Date dtAdptSubEndTerminate) {
    Query query = getSession().createQuery("select new Map ( adp.idAdptSub as idAdptSub, " +
                                           " adp.amtAdptSub as amtAdptSub ) " +
    		                           "from AdoptionSubsidy adp , AdptSubEventLink asel,Event e " +
                                           "where asel.event.idEvent = e.idEvent " +
                                           "and asel.adoptionSubsidy.idAdptSub = adp.idAdptSub " +
                                           "and asel.capsCase.idCase = :idCase " +
                                           "and adp.person.idPerson = :idPerson " +
                                           "and ((trunc(nvl(adp.dtAdptSubTerminated,adp.dtAdptSubEnd)) > trunc(:dtAdptSubEffective))  " + 
                                           "and (trunc(adp.dtAdptSubEffective) < trunc(:dtAdptSubEndTerminate))) " + 
                                           "and adp.cdAdptSubDeterm in(:cdAdoptionType) " +
                                           "and asel.event.idEvent <> :idEvent " +
                                           " order by adp.dtAdptSubEffective desc");
    query.setInteger("idCase", idCase);
    query.setInteger("idEvent", idEvent);
    query.setInteger("idPerson", idPerson);
    query.setParameterList("cdAdoptionType", cdAdoptionType);
    query.setTimestamp("dtAdptSubEffective", dtAdptSubEffective);
    query.setTimestamp("dtAdptSubEndTerminate", dtAdptSubEndTerminate);
    return (Map<String, Object>) firstResult(query);
  }
  
  //STGAP00013779: Gets the total Amount of Non Recurring Adoption Subsidy record for the given person 
  public Double totalNonRecAdoptionSubsidyAmt(int idCase, int idPerson, List<String> cdAdoptionType) {
    Query query = getSession().createQuery("select sum(adp.amtAdptSub) from AdoptionSubsidy adp , AdptSubEventLink asel,Event e " +
                                           "where asel.event.idEvent = e.idEvent " +
                                           "and asel.adoptionSubsidy.idAdptSub = adp.idAdptSub " +
                                           "and asel.capsCase.idCase = :idCase " +
                                           "and adp.person.idPerson = :idPerson " +
                                           "and asel.event.cdEventStatus = '" + CodesTables.CEVTSTAT_COMP + "'" +
                                           "and adp.cdAdptSubDeterm in(:cdAdoptionType) ");
    query.setInteger("idCase", idCase);
    query.setInteger("idPerson", idPerson);
    query.setParameterList("cdAdoptionType", cdAdoptionType);
    return (Double) firstResult(query);
  }
  
  //STGAP00014186: Find the Special Services adoption subsidy record for the given Adoption Application.
  public Integer findSpecialServiceForAttachedApp(int idSpecialNeedsEvent, int idEvent) {
    Query query = getSession().createQuery("select adp.idAdptSub from AdoptionSubsidy adp , AdptSubEventLink asel, Event e " +
                                           "where asel.event.idEvent = e.idEvent " +
                                           "and asel.adoptionSubsidy.idAdptSub = adp.idAdptSub " +
                                           "and adp.specialNeedsDetermination.idEvent = :idSpecialNeedsEvent " +
                                           "and asel.event.idEvent <> :idEvent " +
                                           "and asel.event.cdEventStatus = '" + CodesTables.CEVTSTAT_COMP + "'" +
                                           "and adp.cdAdptSubDeterm in ('" + CodesTables.CSUBTYPE_10 +"' , " +
                                           "                 '" + CodesTables.CSUBTYPE_18 + "' , " +
                                           "                 '" + CodesTables.CSUBTYPE_21 + "' , " +
                                           "                 '" + CodesTables.CSUBTYPE_28 + "' , " +
                                           "                 '" + CodesTables.CSUBTYPE_29 + "' , " +
                                           "                 '" + CodesTables.CSUBTYPE_30 + "') ");
    query.setInteger("idSpecialNeedsEvent", idSpecialNeedsEvent);
    query.setInteger("idEvent", idEvent);
    return (Integer) firstResult(query);
  }
  
  @SuppressWarnings( { "unchecked" })
  public Double getTotalAgreementAmountUsed(int idSpecialNeedsDeter, int idStage, String cdEventStatus,
                                            String cdEventType, String cdPaymentMthd, List<String> cdSpclAsstType) {
    Query query = getSession()
                              .createQuery(
                                           " select sum(asub.amtAdptSub) "
                                                           + " from AdoptionSubsidy asub, AdptSubEventLink ael, Event e "
                                                           + " where ael.adoptionSubsidy.idAdptSub = asub.idAdptSub "
                                                           + " and ael.event.idEvent = e.idEvent "
                                                           + " and asub.specialNeedsDetermination.event.idEvent = :idSpecialNeedsDeter "
                                                           + " and e.cdEventStatus = :cdEventStatus "
                                                           + " and e.cdEventType = :cdEventType "
                                                           + " and asub.cdPaymentMthd = :cdPaymentMthd "
                                                           + " and e.stage.idStage = :idStage"
                                                           + " and asub.cdSpclAsstType in (:cdSpclAsstType) ");
    query.setInteger("idSpecialNeedsDeter", idSpecialNeedsDeter);
    query.setString("cdEventStatus", cdEventStatus);
    query.setString("cdEventType", cdEventType);
    query.setString("cdPaymentMthd", cdPaymentMthd);
    query.setParameterList("cdSpclAsstType", cdSpclAsstType);
    query.setInteger("idStage", idStage);
    return (Double) firstResult(query);
  }
  
  @SuppressWarnings( { "unchecked" })
  public List<AdoptionSubsidy> findActiveAdoptionSubsidyByIdPersonCdAdoptionTypeOfSvcAuthDtl(
                                                                                             int idCase,
                                                                                             int idPerson,
                                                                                             List<String> cdAdoptionType,
                                                                                             Date dtAdptSubEffective,
                                                                                             Date dtAdptSubEndTerminate, double amtAdptSub) {
    String cdPaymentMthd = CodesTables.CPAYMTHD_PAR;
    Query query = getSession()
                              .createQuery(
                                           " select adp "
                                                           + " from AdoptionSubsidy adp , AdptSubEventLink asel,Event e  "
                                                           + " where asel.event.idEvent = e.idEvent  "
                                                           + " and asel.adoptionSubsidy.idAdptSub = adp.idAdptSub  "
                                                           + " and asel.capsCase.idCase = :idCase  "
                                                           + " and adp.person.idPerson = :idPerson  "
                                                           + " and adp.amtAdptSub = :amtAdptSub "
                                                           + " and ((trunc(nvl(adp.dtAdptSubTerminated,adp.dtAdptSubEnd)) > trunc(:dtAdptSubEffective)) "
                                                           + " or (trunc(adp.dtAdptSubEffective) < trunc(:dtAdptSubEndTerminate))) "
                                                           + " and adp.cdAdptSubDeterm in(:cdAdoptionType)  "
                                                           + " and adp.cdPaymentMthd = :cdPaymentMthd");
    query.setInteger("idCase", idCase);
    query.setInteger("idPerson", idPerson);
    query.setString("cdPaymentMthd", cdPaymentMthd);
    query.setParameterList("cdAdoptionType", cdAdoptionType);
    query.setDouble("amtAdptSub", amtAdptSub);
    query.setTimestamp("dtAdptSubEffective", dtAdptSubEffective);
    query.setTimestamp("dtAdptSubEndTerminate", dtAdptSubEndTerminate);
    return (List<AdoptionSubsidy>) query.list();
  }
  
  @SuppressWarnings("unchecked")
  public List<AdoptionSubsidy> findActiveAdoptionSubsidyByIdCaseIdAdptSubPersonCdAdptSubDetermAndDateEffBy(int idCase, int adptSubPerson, Collection<String> cdAdptSubDeterm, Date dtDateEffBy) {
    Query query = getSession().createQuery(" select adp " +
                                           "   from AdoptionSubsidy adp, AdptSubEventLink asel, Event e " +
                                           "   where adp.person.idPerson = :adptSubPerson " +
                                           "   and trunc(adp.dtAdptSubEffective) <= trunc(:dtDateEffBy) " +
                                           "   and trunc(adp.dtAdptSubEnd) >= trunc(:dtDateEffBy) " + 
                                           "   and (adp.dtAdptSubTerminated is null " +
                                           "        or trunc(adp.dtAdptSubTerminated) >= trunc(:dtDateEffBy)) " +
                                           "   and (trunc(adp.dtAdptSubTerminated) is null " +
                                           "        or trunc(adp.dtAdptSubEffective) < trunc(adp.dtAdptSubTerminated)) " + // disregard those that starts and ends on the same day per SSAU
                                           "   and adp.cdAdptSubDeterm in (:cdAdptSubDeterm) " +
                                           "   and e.cdEventStatus = '" +  CodesTables.CEVTSTAT_COMP + "'" +
                                           "   and asel.event.idEvent = e.idEvent " +
                                           "   and e.capsCase.idCase = :idCase  " +
                                           "   and asel.adoptionSubsidy.idAdptSub = adp.idAdptSub " +
                                           "   order by adp.dtAdptSubEffective desc ");
    query.setInteger("adptSubPerson", adptSubPerson);
    query.setInteger("idCase", idCase);
    query.setParameterList("cdAdptSubDeterm", cdAdptSubDeterm);
    query.setTimestamp("dtDateEffBy", dtDateEffBy);
    return (List<AdoptionSubsidy>) query.list();
  }
  @SuppressWarnings("unchecked")
  public List<AdoptionSubsidy> findActiveAdoptionSubsidyByIdCaseIdAdptSubPersonAndDateEffBy(int idCase, int adptSubPerson, Date dtDateEffBy) {
    Query query = getSession().createQuery(" select adp " +
                                           "   from AdoptionSubsidy adp, AdptSubEventLink asel, Event e " +
                                           "   where adp.person.idPerson = :adptSubPerson " +
                                           "   and trunc(adp.dtAdptSubEffective) <= trunc(:dtDateEffBy) " +
                                           "   and trunc(adp.dtAdptSubEnd) >= trunc(:dtDateEffBy) " + 
                                           "   and (trunc(adp.dtAdptSubTerminated) is null " +
                                           "        or trunc(adp.dtAdptSubTerminated) >= trunc(:dtDateEffBy)) " +
                                           "   and (trunc(adp.dtAdptSubTerminated) is null " +
                                           "        or trunc(adp.dtAdptSubEffective) < trunc(adp.dtAdptSubTerminated)) " + // disregard those that starts and ends on the same day per SSAU
                                           "   and e.cdEventStatus = '" +  CodesTables.CEVTSTAT_COMP + "'" +
                                           "   and asel.event.idEvent = e.idEvent " +
                                           "   and e.capsCase.idCase = :idCase " +
                                           "   and asel.adoptionSubsidy.idAdptSub = adp.idAdptSub " +
                                           "   order by adp.dtAdptSubEffective desc ");
    query.setInteger("adptSubPerson", adptSubPerson);
    query.setInteger("idCase", idCase);
    query.setTimestamp("dtDateEffBy", dtDateEffBy);
    return (List<AdoptionSubsidy>) query.list();
  }
  
}
