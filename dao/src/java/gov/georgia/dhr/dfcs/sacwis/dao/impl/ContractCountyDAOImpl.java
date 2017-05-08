package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.dao.ContractCountyDAO;
import gov.georgia.dhr.dfcs.sacwis.db.ContractCounty;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SQLQuery;

/**
 * This is the DAO class is used for the Contract_County table
 * 
 * <pre>
 *  Change History:
 *  Date        User      Description
 *  --------  --------  --------------------------------------------------
 *  04/08/2009  arege    STGAP00010887 Added method findContractCountyWithinDateRangeSvAuthByidContract
 *  02/08/2010 wjcochran SMS #42024: modified findServicesWithUnitType to check against contract version
 *                       start/end dates rather than contract period start/end dates. This will ensure the
 *                       correct contract version is pulled, rather than the most recent contract version.
 *  11/22/2010  arege    SMS#79227: Added method findContractServices 
 *  09/26/2011  arege    STGAP00017053 : Added method updateContractCounty
 *  
 * </pre>
 */
public class ContractCountyDAOImpl extends BaseDAOImpl implements ContractCountyDAO {

  @SuppressWarnings( { "unchecked" })
  public List<ContractCounty> findContractCountyByIdContactVersionAndPeriod(int idContract, int nbrCncntyPeriod,
                                                                            int nbrCncntyVersion) {
    Query query = getSession().createQuery(
                                           " from ContractCounty c " + "where c.contract.idContract = :idContract "
                                                           + "  and c.nbrCncntyPeriod = :nbrCncntyPeriod "
                                                           + "  and c.nbrCncntyVersion = :nbrCncntyVersion");
    query.setInteger("idContract", idContract);
    query.setInteger("nbrCncntyPeriod", nbrCncntyPeriod);
    query.setInteger("nbrCncntyVersion", nbrCncntyVersion);
    return (List<ContractCounty>) query.list();
  }

  @SuppressWarnings( { "unchecked" })
  public List<ContractCounty> findContractCountyIdCountyLastUpdate(int idContract, int idResource,
                                                                   String cdCncntyService, int nbrCncntyPeriod,
                                                                   int nbrCncntyVersion, int nbrCncntyLineItem,
                                                                   Date dtCncntyEffective, Date dtCncntyEnd) {
    Query query = getSession()
                              .createQuery(
                                           "    from ContractCounty "
                                                           + "   where capsResource.idResource = :idResource "
                                                           + "     and cdCncntyService = :cdCncntyService "
                                                           + "     and contract.idContract = :idContract "
                                                           + "     and nbrCncntyPeriod = :nbrCncntyPeriod "
                                                           + "     and nbrCncntyVersion = :nbrCncntyVersion "
                                                           + "     and nbrCncntyLineItem = :nbrCncntyLineItem "
                                                           + "     and ((    trunc(dtCncntyEffective) >= :dtCncntyEffective "
                                                           + "           and trunc(dtCncntyEffective) <= :dtCncntyEnd "
                                                           + "          ) "
                                                           + "       or (    trunc(dtCncntyEnd) >= :dtCncntyEffective "
                                                           + "           and trunc(dtCncntyEnd) <= :dtCncntyEnd "
                                                           + "          ) "
                                                           + "       or (    trunc(dtCncntyEffective) <= :dtCncntyEffective "
                                                           + "           and trunc(dtCncntyEnd) >= :dtCncntyEnd "
                                                           + "          ) " + "         ) "
                                                           + "     and cdCncntyCounty is not null "
                                                           + "order by cdCncntyCounty");
    query.setInteger("idContract", idContract);
    query.setInteger("idResource", idResource);
    query.setString("cdCncntyService", cdCncntyService);
    query.setInteger("nbrCncntyPeriod", nbrCncntyPeriod);
    query.setInteger("nbrCncntyVersion", nbrCncntyVersion);
    query.setInteger("nbrCncntyLineItem", nbrCncntyLineItem);
    query.setTimestamp("dtCncntyEffective", dtCncntyEffective);
    query.setTimestamp("dtCncntyEnd", dtCncntyEnd);
    return (List<ContractCounty>) query.list();
  }

  @SuppressWarnings( { "unchecked" })
  public List<String> findContractCountyCncntyCounty(int idResource, String cdCncntyService, Date dtCncntyEffective,
                                                     Date dtCncntyEnd) {
    Query query = getSession()
                              .createQuery(
                                           "  select distinct cdCncntyCounty "
                                                           + "    from ContractCounty "
                                                           + "   where capsResource.idResource = :idResource "
                                                           + "     and cdCncntyService = :cdCncntyService "
                                                           + "     and ((    trunc(dtCncntyEffective) >= :dtCncntyEffective "
                                                           + "           and trunc(dtCncntyEffective) <= :dtCncntyEnd "
                                                           + "          ) "
                                                           + "       or (    trunc(dtCncntyEnd) >= :dtCncntyEffective "
                                                           + "           and trunc(dtCncntyEnd) <= :dtCncntyEnd "
                                                           + "          ) "
                                                           + "       or (    trunc(dtCncntyEffective) <= :dtCncntyEffective "
                                                           + "           and trunc(dtCncntyEnd) >= :dtCncntyEnd "
                                                           + "          ) " + "         ) "
                                                           + "     and cdCncntyCounty is not null "
                                                           + "order by cdCncntyCounty");
    query.setInteger("idResource", idResource);
    query.setString("cdCncntyService", cdCncntyService);
    query.setTimestamp("dtCncntyEffective", dtCncntyEffective);
    query.setTimestamp("dtCncntyEnd", dtCncntyEnd);
    return (List<String>) query.list();
  }

  @SuppressWarnings( { "unchecked" })
  public ContractCounty findContractCountyWithinDateRangeSvAuth(int capsResource, String cdCncntyCounty,
                                                                String cdCncntyService, Date dtCncntyEffective) {

    cdCncntyService = cdCncntyService + "%";
    Query query = getSession()
                              .createQuery(
                                           " from ContractCounty cc "
                                                           + "   where cc.capsResource.idResource = :capsResource "
                                                           + "     and cc.cdCncntyCounty = :cdCncntyCounty "
                                                           + "     and cc.cdCncntyService like :cdCncntyService "
                                                           + "     and trunc(:dtCncntyEffective) >= trunc(cc.dtCncntyEffective) "
                                                           + "     and trunc(:dtCncntyEffective) <= trunc(cc.dtCncntyEnd) "
                                                           + "order by cc.nbrCncntyPeriod desc, cc.nbrCncntyVersion desc");

    query.setInteger("capsResource", capsResource);
    query.setString("cdCncntyCounty", cdCncntyCounty);
    query.setString("cdCncntyService", cdCncntyService);
    query.setTimestamp("dtCncntyEffective", dtCncntyEffective);
    return (ContractCounty) firstResult(query);
  }
  
//Per STGAP00010887 Added method 
  @SuppressWarnings( { "unchecked" })
  public ContractCounty findContractCountyWithinDateRangeSvAuthByidContract(int capsResource, String cdCncntyCounty, int idContract,
                                                                String cdCncntyService, Date dtCncntyEffective) {

    cdCncntyService = cdCncntyService + "%";
    Query query = getSession()
                              .createQuery(
                                           " from ContractCounty cc "
                                                           + "   where cc.capsResource.idResource = :capsResource "
                                                           + "     and cc.cdCncntyCounty = :cdCncntyCounty "
                                                           + "     and contract.idContract = :idContract "
                                                           + "     and cc.cdCncntyService like :cdCncntyService "
                                                           + "     and trunc(:dtCncntyEffective) >= trunc(cc.dtCncntyEffective) "
                                                           + "     and trunc(:dtCncntyEffective) <= trunc(cc.dtCncntyEnd) "
                                                           + "order by cc.nbrCncntyPeriod desc, cc.nbrCncntyVersion desc");

    query.setInteger("capsResource", capsResource);
    query.setString("cdCncntyCounty", cdCncntyCounty);
    query.setInteger("idContract", idContract);
    query.setString("cdCncntyService", cdCncntyService);
    query.setTimestamp("dtCncntyEffective", dtCncntyEffective);
    return (ContractCounty) firstResult(query);
  }
  
  public ContractCounty findContractCountyNoDateRangeSvAuth(int capsResource, String cdCncntyCounty,
                                                                String cdCncntyService) {

    cdCncntyService = cdCncntyService + "%";
    Query query = getSession()
                              .createQuery(
                                           " from ContractCounty cc "
                                                           + "   where cc.capsResource.idResource = :capsResource "
                                                           + "     and cc.cdCncntyCounty = :cdCncntyCounty "
                                                           + "     and cc.cdCncntyService like :cdCncntyService "
                                                           + "order by cc.nbrCncntyPeriod desc, cc.nbrCncntyVersion desc");

    query.setInteger("capsResource", capsResource);
    query.setString("cdCncntyCounty", cdCncntyCounty);
    query.setString("cdCncntyService", cdCncntyService);
    return (ContractCounty) firstResult(query);
  }

  @SuppressWarnings( { "unchecked" })
  public ContractCounty findContractCountyForAdoptionSubsidy(int idResource, String cdCncntyCounty,
                                                             Date dtEffectiveForPeriod,
                                                             Collection<String> adoptionServices) {
    Query query = getSession().createQuery(
                                           " from ContractCounty " + "where capsResource.idResource = :idResource "
                                                           + "  and cdCncntyCounty = :cdCncntyCounty "
                                                           + "  and dtCncntyEffective <= :dtEffectiveForPeriod "
                                                           + "  and dtCncntyEnd >= :dtEffectiveForPeriod "
                                                           + "  and cdCncntyService in (:adoptionServices)");

    query.setInteger("idResource", idResource);
    query.setString("cdCncntyCounty", cdCncntyCounty);
    query.setTimestamp("dtEffectiveForPeriod", dtEffectiveForPeriod);
    query.setParameterList("adoptionServices", adoptionServices, Hibernate.STRING);
    return (ContractCounty) firstResult(query);
  }

  @SuppressWarnings( { "unchecked" })
  public List<ContractCounty> findContractCounty(int idContract, int nbrCncntyPeriod, int nbrCncntyVersion) {
    Query query = getSession().createQuery(
                                           " from ContractCounty c " + "where contract.idContract = :idContract "
                                                           + "  and nbrCncntyPeriod = :nbrCncntyPeriod "
                                                           + "  and nbrCncntyVersion = :nbrCncntyVersion ");
    query.setInteger("idContract", idContract);
    query.setInteger("nbrCncntyPeriod", nbrCncntyPeriod);
    query.setInteger("nbrCncntyVersion", nbrCncntyVersion);
    return (List<ContractCounty>) query.list();
  }

  @SuppressWarnings( { "unchecked" })
  public List<ContractCounty> findContractCountyByIdRsrcAndCdCncntyAndDtCncntyEffective(int idResource,
                                                                                        String cdCncntyCounty,
                                                                                        Date dtPlcmtStart) {
    Query query = getSession().createQuery(
                                           " from ContractCounty c " + "where c.capsResource.idResource = :idResource"
                                                           + "  and c.cdCncntyCounty = :cdCncntyCounty "
                                                           + "  and c.dtCncntyEffective <= :dtPlcmtStart "
                                                           + "  and c.dtCncntyEnd >= :dtPlcmtStart");
    query.setInteger("idResource", idResource);
    query.setString("cdCncntyCounty", cdCncntyCounty);
    query.setTimestamp("dtPlcmtStart", dtPlcmtStart);
    return (List<ContractCounty>) query.list();
  }

  @SuppressWarnings( { "unchecked" })
  public List<Integer> findContractCountyIdCncnty(int idContract, Date dtCncntyEnd, Date dtCncntyEffective,
                                                  byte nbrCncntyPeriod, byte nbrCncntyVersion) {
    Query query = getSession()
                              .createQuery(
                                           "select a.idCncnty "
                                                           + "  from ContractCounty a "
                                                           + " where a.capsResource.idResource = (select b.capsResource.idResource "
                                                           + "                                      from Contract b "
                                                           + "                                     where b.idContract = :idContract) "
                                                           + "   and a.dtCncntyEffective <= :dtCncntyEnd "
                                                           + "   and a.dtCncntyEnd >= :dtCncntyEffective "
                                                           + "   and a.contract.idContract != :idContract "
                                                           + "   and (a.cdCncntyService, a.cdCncntyCounty) "
                                                           + "       in (select c.cdCncntyService, "
                                                           + "                  c.cdCncntyCounty "
                                                           + "             from ContractCounty c "
                                                           + "            where c.contract.idContract = :idContract "
                                                           + "              and c.nbrCncntyPeriod = :nbrCncntyPeriod "
                                                           + "              and c.nbrCncntyVersion = :nbrCncntyVersion)");
    query.setInteger("idContract", idContract);
    query.setTimestamp("dtCncntyEnd", dtCncntyEnd);
    query.setTimestamp("dtCncntyEffective", dtCncntyEffective);
    query.setByte("nbrCncntyPeriod", nbrCncntyPeriod);
    query.setByte("nbrCncntyVersion", nbrCncntyVersion);
    return (List<Integer>) query.list();
  }

  /*
   * public int findIdContractByService(String service, String plcmtCnty, int idResource, Date date){ Query query =
   * getSession().createQuery("select cc.contract.idContract " + " from ContractCounty cc, ContractVersion cv,
   * ContractPeriod cp" + " where cc.cdCncntyCounty = :plcmtCnty" + " and cc.cdCncntyService = :service" + " and
   * cc.capsResource.idResource = :idResource" + " and cc.dtCncntyEffective <= :date" + " and cc.dtCncntyEnd>= :date" + "
   * and cc.contract.idContract = cp.contract.idContract" + " and cc.contract.idContract =
   * cv.contractPeriod.contract.idContract" + " and cc.nbrCncntyPeriod = cp.contract.nbrCnperPeriod" + " and
   * cc.nbrCncntyPeriod = cv.contractPeriod.nbrCnperPeriod" + " and cc.nbrCncntyVersion = cv.nbrCnverVersion" + " and
   * cv.indCnVerLock = 'Y'" + " and cp.cdCnperStatus = 'ACT'"); return (Integer)firstResult(query); }
   */
  public int findIdContractByService(String service, String plcmtCnty, int idResource) {
    SQLQuery query = getSession()
                                 .createSQLQuery(
                                                 " SELECT cc.id_contract "
                                                                 + " from Contract_County cc, Contract_Version cv, Contract_Period cp"
                                                                 + "         where cc.cd_Cncnty_County = :plcmtCnty"
                                                                 + "         and cc.cd_Cncnty_Service = :service"
                                                                 + "         and cc.id_Resource = :idResource"
                                                                 + "         and cc.dt_Cncnty_Effective <= sysdate"
                                                                 + "         and cc.dt_Cncnty_End>= sysdate"
                                                                 + "         and cc.id_Contract = cp.id_Contract"
                                                                 + "         and cc.id_Contract = cv.id_Contract"
                                                                 + "         and cc.nbr_Cncnty_Period = cp.nbr_Cnper_Period"
                                                                 + "         and cc.nbr_Cncnty_Period = cv.nbr_Cnver_Period"
                                                                 + "         and cc.nbr_Cncnty_Version = cv.nbr_Cnver_Version"
                                                                 + "         and cv.ind_Cnver_Ver_Lock = 'Y'"
                                                                 + "         and cp.cd_Cnper_Status = 'ACT'");
    query.setString("service", service);
    query.setString("plcmtCnty", plcmtCnty);
    query.setInteger("idResource", idResource);
    
   
    BigDecimal result = (BigDecimal) firstResult(query);
    if (result == null) {
      return 0;
    }
    return Integer.parseInt(String.valueOf(result));

  }
  //STGAP00004607: defined this query for MAAC Placements
  public int findIdResourceByServiceAndCounty(String service, String plcmtCnty) {
    SQLQuery query = getSession()
                                 .createSQLQuery(
                                                 " SELECT cc.id_Resource "
                                                                 + " from Contract_County cc"
                                                                 + "         where cc.cd_Cncnty_County = :plcmtCnty"
                                                                 + "         and cc.cd_Cncnty_Service = :service"
                                                                 + "         and cc.dt_Cncnty_Effective <= sysdate"
                                                                 + "         and cc.dt_Cncnty_End>= sysdate");
    query.setString("service", service);
    query.setString("plcmtCnty", plcmtCnty);
    BigDecimal result = (BigDecimal) firstResult(query);
    if (result == null) {
      return 0;
    }
    return Integer.parseInt(String.valueOf(result));
  }
  
  @SuppressWarnings("unchecked")
  public List<Object[]> findDistinctCountyServiceByIdContract(int idContract) {
    Query query = getSession().createQuery("select distinct cc.cdCncntyCounty, cc.cdCncntyService " +
                                           "from ContractCounty cc " +
                                           "where cc.contract.idContract = :idContract " +
                                           "order by cc.cdCncntyCounty asc, cc.cdCncntyService asc");
    query.setInteger("idContract", idContract);
    return (List<Object[]>) query.list();
  }
  
  @SuppressWarnings("unchecked")
  public List<Object[]> findEffectiveCountyServiceByIdContract(int idContract, Date date) {
    Query query = getSession().createQuery("select distinct cc.cdCncntyCounty, cc.cdCncntyService " +
                                           "from ContractCounty cc " +
                                           "where cc.contract.idContract = :idContract " +
                                           "and cc.dtCncntyEffective <= :date " +
                                           "and cc.dtCncntyEnd >= :date " +
                                           "order by cc.cdCncntyCounty asc, cc.cdCncntyService asc");
    query.setInteger("idContract", idContract);
    query.setDate("date", date);
    return (List<Object[]>) query.list();
  }

  @SuppressWarnings("unchecked")
  public List<String> findEffectiveCountiesByIdContract(int idContract, Date date) {
    Query query = getSession().createQuery(
                                           "select distinct c.cdCncntyCounty " + "           from ContractCounty c "
                                                           + "          where c.contract.idContract = :idContract "
                                                           + "            and c.dtCncntyEffective <= :date "
                                                           + "            and c.dtCncntyEnd >= :date "
                                                           + "       order by c.cdCncntyCounty asc");
    query.setInteger("idContract", idContract);
    query.setDate("date", date);
    return (List<String>) query.list();
  }

  @SuppressWarnings("unchecked")
  public List<String> findServicesByIdContractAndCounty(int idContract, String cdCncntyCounty) {
    Query query = getSession().createQuery(
                                           "select distinct cc.cdCncntyService " + "  from ContractCounty cc "
                                                           + " where cc.contract.idContract = :idContract "
                                                           + "   and cc.cdCncntyCounty = :cdCounty");
    query.setInteger("idContract", idContract);
    query.setString("cdCounty", cdCncntyCounty);
    return (List<String>) query.list();
  }
  
  @SuppressWarnings("unchecked")
  public List<Map> findServicesWithUnitType(int idContract, Date dtRangeStart, Date dtRangeEnd) {
    Query query = getSession().createQuery("select distinct new map(cc.cdCncntyService as cdService, "
                                                           + "cs.cdCnsvcUnitType as cdUnitType) "
                                                           + "from ContractCounty cc, ContractService cs "
                                                           + "where cc.contract = cs.contract "
                                                           + "and cc.nbrCncntyPeriod = cs.nbrCnsvcPeriod "
                                                           + "and cc.nbrCncntyVersion = cs.nbrCnsvcVersion "
                                                           + "and cc.nbrCncntyLineItem = cs.nbrCnsvcLineItem "
                                                           + "and cc.cdCncntyService = cs.cdCnsvcService "
                                                           + "and cc.contract.idContract = :idContract "
                                                           + "and (cc.dtCncntyEffective <= :dtRangeEnd "
                                                           + "and cc.dtCncntyEnd >= :dtRangeStart) "
                                                           + "and cc.nbrCncntyVersion = (select max(cv.nbrCnverVersion) "
                                                           + "from ContractVersion cv "
                                                           + "where cv.indCnverVerLock = :lockedIndicator "
                                                           + "and cv.contractPeriod.contract.idContract = :idContract "
                                                           + "and (cv.dtCnverEffective <= :dtRangeEnd "
                                                           + "and cv.dtCnverEnd >= :dtRangeStart))");
    query.setInteger("idContract", idContract);
    query.setDate("dtRangeStart", dtRangeStart);
    query.setDate("dtRangeEnd", dtRangeEnd);
    query.setString("lockedIndicator", ArchitectureConstants.Y);
    return (List<Map>) query.list();
  }
  
  @SuppressWarnings("unchecked")
  public  List<Object[]> findContractServices(int idResource, String cdNewCounty) {
    SQLQuery query = getSession().createSQLQuery(   " select r.id_resource, c.id_contract, cv.dt_cnver_effective, cv.dt_cnver_end, "
                                                    + " cs.nbr_cnsvc_period, cs.nbr_cnsvc_version ,"
                                                    + " cs.nbr_cnsvc_line_item, cs.id_cntrct_wkr, cs.cd_cnsvc_service "
                                                    + " from caps.caps_resource r,     caps.contract c, "
                                                    + " caps.contract_period cp,     caps.contract_version cv, caps.contract_service cs "
                                                    + " where r.id_resource = :idResource "
                                                    + " and c.id_resource = r.id_resource "
                                                    + " and c.id_contract = cp.id_contract "
                                                    + " and cp.nbr_cnper_period = cv.nbr_cnver_period "
                                                    + " and c.id_contract = cv.id_contract "
                                                    + " and cv.nbr_cnver_period = cs.nbr_cnsvc_period "
                                                    + " and cv.nbr_cnver_version = cs.nbr_cnsvc_version " 
                                                    + " and c.id_contract = cs.id_contract "
                                                    + " and not exists ( "
                                                    + "   select 'x' "
                                                    + "   from caps.contract_county cc "
                                                    + "   where cc.id_contract = cs.id_contract "
                                                    + "  and cc.cd_cncnty_service = cs.cd_cnsvc_service "
                                                    + "  and cc.nbr_cncnty_period = cs.nbr_cnsvc_period "
                                                    + "   and cc.nbr_cncnty_version = cs.nbr_cnsvc_version "
                                                    + "  and cc.nbr_cncnty_line_item = cs.nbr_cnsvc_line_item "
                                                    + " and cc.cd_cncnty_county = :cdNewCounty)" ) ;
                                                       
                                                          
    query.setInteger("idResource", idResource);
    query.setString("cdNewCounty", cdNewCounty);
    return (List<Object[]>) query.list();
    }


  @SuppressWarnings( { "unchecked" })
  public long countContractCountyByIdResource(int idResource) {
    Query query = getSession().createQuery(
                                           "select count(*) " + "  from ContractCounty cc "
                                                           + " where :idResource = cc.capsResource.idResource "
                                                           + "   and (cc.dtCncntyEnd >= trunc(sysdate) "
                                                           + "        or cc.dtCncntyEnd is null ) ");

    query.setInteger("idResource", idResource);
    return (Long) query.uniqueResult();
  }

  @SuppressWarnings( { "unchecked" })
  public void saveContractCounty(ContractCounty contractCounty) {
    getSession().saveOrUpdate(contractCounty);
  }

  @SuppressWarnings( { "unchecked" })
  public List<Map> findContractCountyByIdResourceCdRsrcSvcServiceAndcdRsrcSvcCnty(int idResource,
                                                                                  String cdRsrcSvcService,
                                                                                  String cdRsrcSvcCnty) {
    Query query = getSession().createQuery(
                                           "select new Map(cc.contract.idContract as idContract,"
                                                           + "       cc.dtCncntyEffective as dtCncntyEffective,"
                                                           + "       cc.dtCncntyEnd as dtCncntyEnd)"
                                                           + "  from ContractCounty cc," + "       ContractPeriod cp "
                                                           + " where cc.capsResource.idResource = :idResource "
                                                           + "   and cc.cdCncntyService = :cdRsrcSvcService "
                                                           + "   and cc.cdCncntyCounty = :cdRsrcSvcCnty"
                                                           + "   and cc.contract.idContract = cp.contract.idContract"
                                                           + "   and cc.nbrCncntyPeriod = cp.id.nbrCnperPeriod"
                                                           + "   and upper(cp.cdCnperStatus) = 'ACT'"
                                                           + "   and upper(cp.indCnperSigned) = 'Y'");
    query.setInteger("idResource", idResource);
    query.setString("cdRsrcSvcService", cdRsrcSvcService);
    query.setString("cdRsrcSvcCnty", cdRsrcSvcCnty);
    return (List<Map>) query.list();
  }

  @SuppressWarnings( { "unchecked" })
  public void deleteContractCounty(ContractCounty contractCounty) {
    getSession().delete(contractCounty);
  }

  @SuppressWarnings( { "unchecked" })
  public int deleteContractCounty(int idContract, int nbrCnverPeriod, int nbrCnverVersion) {
    Query query = getSession().createQuery(
                                           "delete ContractCounty cc " + " where cc.contract.idContract = :idContract "
                                                           + "   and cc.nbrCncntyPeriod = :nbrCnverPeriod "
                                                           + "   and cc.nbrCncntyVersion = :nbrCnverVersion ");
    query.setInteger("idContract", idContract);
    query.setInteger("nbrCnverPeriod", nbrCnverPeriod);
    query.setInteger("nbrCnverVersion", nbrCnverVersion);

    return query.executeUpdate();
  }

  @SuppressWarnings( { "unchecked" })
  public int deleteContractCounty(Date dtLastUpdate, int idCnsvc) {
    Query query = getSession()
                              .createQuery(
                                           "delete ContractCounty cc "
                                                           + " where  (cc.contract.idContract, "
                                                           + "         cc.nbrCncntyPeriod, "
                                                           + "         cc.nbrCncntyVersion, "
                                                           + "         cc.nbrCncntyLineItem) in (select cs.contract.idContract, "
                                                           + "                                          cs.nbrCnsvcPeriod, "
                                                           + "                                          cs.nbrCnsvcVersion, "
                                                           + "                                          cs.nbrCnsvcLineItem "
                                                           + "                                   from   ContractService cs "
                                                           + "                                   where  cs.dtLastUpdate = :dtLastUpdate "
                                                           + "                                          and cs.idCnsvc = :idCnsvc) ");
    query.setTimestamp("dtLastUpdate", dtLastUpdate);
    query.setInteger("idCnsvc", idCnsvc);

    return query.executeUpdate();
  }

  @SuppressWarnings( { "unchecked" })
  public int deleteContractCounty(int idContract, int nbrCnperPeriod) {
    Query query = getSession().createQuery(
                                           "delete ContractCounty cc "
                                                           + "  where cc.contract.idContract = :idContract "
                                                           + "    and cc.nbrCncntyPeriod = :nbrCnperPeriod ");
    query.setInteger("idContract", idContract);
    query.setInteger("nbrCnperPeriod", nbrCnperPeriod);

    return query.executeUpdate();
  }
  
  @SuppressWarnings( { "unchecked" })
  public String findContractCounties(int idContract) {
    Query query = getSession().createQuery("select cc.cdCncntyCounty "
                                           + "  from ContractCounty cc"
                                           + "  where cc.contract.idContract = :idContract");
    query.setInteger("idContract", idContract);
    return (String) firstResult(query);
  }
  
  
  @SuppressWarnings( { "unchecked" })
  public int updateContractCounty(int idCntrctWkr, Date dtCncntyEffective, Date dtCncntyEnd,
                                   int idContract, int nbrCncntyPeriod, int nbrCncntyVersion) {

          SQLQuery query = getSession().createSQLQuery(
                                           "update CONTRACT_COUNTY "
                                                           + "   set ID_CNTRCT_WKR = :idCntrctWkr, "
                                                           + "       ID_CONTRACT = :idContract, "
                                                           + "       NBR_CNCNTY_PERIOD = :nbrCncntyPeriod, "
                                                           + "       DT_CNCNTY_EFFECTIVE = :dtCncntyEffective, "
                                                           + "       DT_CNCNTY_END = :dtCncntyEnd, "
                                                           + "       NBR_CNCNTY_VERSION = :nbrCncntyVersion "                                                          
                                                           + " where ID_CONTRACT = :idContract "
                                                           + "   and NBR_CNCNTY_PERIOD = :nbrCncntyPeriod "
                                                           + "   and NBR_CNCNTY_VERSION = :nbrCncntyVersion");
    query.setInteger("idCntrctWkr", idCntrctWkr);
    query.setTimestamp("dtCncntyEffective", dtCncntyEffective);
    query.setTimestamp("dtCncntyEnd", dtCncntyEnd);
    query.setInteger("idContract", idContract);
    query.setInteger("nbrCncntyPeriod", nbrCncntyPeriod);
    query.setInteger("nbrCncntyVersion", nbrCncntyVersion);
    return query.executeUpdate();
  }
}
