package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.ContractServiceDAO;
import gov.georgia.dhr.dfcs.sacwis.db.ContractService;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;

/**
 *                                        Change History
 *
 *   Date          User                      Description
 * --------  ----------------  --------------------------------------------------
 * 10/16/11  charden           STGAP00017058: created methods countContractSvcByPrdVersIdContractService() and findMaxCnsvcLineItemByIdContractPeriodVersion()
 *
 *
 *
*/

public class ContractServiceDAOImpl extends BaseDAOImpl implements ContractServiceDAO {

  @SuppressWarnings( { "unchecked" })
  public Double findNbrContractSvcByIdContractAndCdContractSvc(int idContract, String cdCnsvcService) {
    Query query = getSession()
                              .createQuery(
                                           "select cs.nbrCnsvcUnitRate from ContractService cs, ContractVersion cv "
                                                           + " where cs.contract.idContract = :idContract and "
                                                           + " cs.contract.idContract = cv.contractPeriod.id.idContract and"
                                                           + " cs.nbrCnsvcPeriod = cv.contractPeriod.id.nbrCnperPeriod and"
                                                           + " cs.nbrCnsvcVersion = cv.nbrCnverVersion and"
                                                           + " cs.cdCnsvcService = :cdCnsvcService and "
                                                           + " cv.dtCnverEffective <= sysdate and "
                                                           + " cv.dtCnverEnd >= sysdate and "
                                                           + " cv.indCnverVerLock = 'Y'" + "");

    query.setInteger("idContract", idContract);
    query.setString("cdCnsvcService", cdCnsvcService);
    return (Double) firstResult(query);
  }

  @SuppressWarnings( { "unchecked" })
  public ContractService findContractServiceByIdContract(int nbrCnsvcPeriod, int nbrCnsvcVersion, int nbrCnsvcLineItem,
                                                         int idContract, String cdCnsvcService) {
    Query query = getSession().createQuery(
                                           " from ContractService c " + "where c.nbrCnsvcPeriod = :nbrCnsvcPeriod "
                                                           + "  and c.nbrCnsvcVersion = :nbrCnsvcVersion "
                                                           + "  and c.nbrCnsvcLineItem = :nbrCnsvcLineItem "
                                                           + "  and c.contract.idContract = :idContract "
                                                           + "  and c.cdCnsvcService = :cdCnsvcService");

    query.setInteger("nbrCnsvcPeriod", nbrCnsvcPeriod);
    query.setInteger("nbrCnsvcVersion", nbrCnsvcVersion);
    query.setInteger("nbrCnsvcLineItem", nbrCnsvcLineItem);
    query.setInteger("idContract", idContract);
    query.setString("cdCnsvcService", cdCnsvcService);
    return (ContractService) firstResult(query);
  }

  @SuppressWarnings( { "unchecked" })
  public List<ContractService> findContractServiceAll(int nbrCnsvcPeriod, int nbrCnsvcVersion, int idContract) {
    Query query = getSession().createQuery(
                                           " from ContractService cs " + "where cs.contract.idContract = :idContract "
                                                           + "  and cs.nbrCnsvcPeriod = :nbrCnsvcPeriod "
                                                           + "  and cs.nbrCnsvcVersion = :nbrCnsvcVersion");

    query.setInteger("nbrCnsvcPeriod", nbrCnsvcPeriod);
    query.setInteger("nbrCnsvcVersion", nbrCnsvcVersion);
    query.setInteger("idContract", idContract);
    return (List<ContractService>) query.list();
  }

  @SuppressWarnings( { "unchecked" })
  public Integer findMaxCnsvcLineItemByIdContract(int idContract) {
    Query query = getSession().createQuery(
                                           "select max(nbrCnsvcLineItem) " + "  from ContractService c"
                                                           + " where c.contract.idContract = :idContract");
    query.setInteger("idContract", idContract);
    return (Integer) firstResult(query);
  }
  
  @SuppressWarnings( { "unchecked" })
  public Integer findMaxCnsvcLineItemByIdContractPeriodVersion(int idContract, int nbrCnsvcPeriod, int nbrCnsvcVersion) {
    Query query = getSession().createQuery(
                                           "select max(nbrCnsvcLineItem) " + "  from ContractService c "
                                                           + " where c.contract.idContract = :idContract "
                                                           + "   and c.nbrCnsvcPeriod = :nbrCnsvcPeriod"
                                                           + "  and c.nbrCnsvcVersion = :nbrCnsvcVersion");
    query.setInteger("idContract", idContract);
    query.setInteger("nbrCnsvcPeriod", nbrCnsvcPeriod);
    query.setInteger("nbrCnsvcVersion", nbrCnsvcVersion);
    return (Integer) firstResult(query);
  }

  @SuppressWarnings( { "unchecked" })
  public List<ContractService> findConSvcByIdConAndNbrCnsvcPeriodAndNbrCnsvcVersion(int nbrCnsvcPeriod,
                                                                                    int nbrCnsvcVersion, int idContract) {
    Query query = getSession().createQuery(
                                           "   from ContractService c" + "  where c.contract.idContract = :idContract"
                                                           + "   and c.nbrCnsvcPeriod = :nbrCnsvcPeriod"
                                                           + "  and c.nbrCnsvcVersion = :nbrCnsvcVersion"
                                                           + "  order by c.nbrCnsvcLineItem");

    query.setInteger("nbrCnsvcPeriod", nbrCnsvcPeriod);
    query.setInteger("nbrCnsvcVersion", nbrCnsvcVersion);
    query.setInteger("idContract", idContract);
    return (List<ContractService>) query.list();
  }

  @SuppressWarnings( { "unchecked" })
  public List<ContractService> findConSvcByIdConAndNbrCnsvcPeriodMaxAndNbrCnsvcVersionMax(int idContract) {
    Query query = getSession()
                              .createQuery(
                                           " from ContractService cs"
                                                           + " where cs.contract.idContract = :idContract"
                                                           + " and cs.nbrCnsvcPeriod = (select max(cs1.nbrCnsvcPeriod)"
                                                           + "                              from ContractService cs1"
                                                           + "                             where cs1.contract.idContract = :idContract)"
                                                           + "   and nbrCnsvcVersion = (select max(cs2.nbrCnsvcVersion)"
                                                           + "                            from ContractService cs2"
                                                           + "                           where cs2.contract.idContract = :idContract"
                                                           + "                             and cs.nbrCnsvcPeriod = cs2.nbrCnsvcPeriod)"
                                                           + " order by cs.cdCnsvcService");

    query.setInteger("idContract", idContract);
    return (List<ContractService>) query.list();
  }

  @SuppressWarnings( { "unchecked" })
  public List<String> findCdCnsvcServiceByIdContract(int idContract) {
    Query query = getSession().createQuery(
                                           "  select distinct cdCnsvcService" + "     from ContractService"
                                                           + "    where contract.idContract = :idContract"
                                                           + " order by cdCnsvcService");
    query.setInteger("idContract", idContract);
    return (List<String>) query.list();
  }
  
//Per STGAP00008089:Added this method to count if there are any records for given CSLI and ID_CONTRACT
//STGAP00017051: Modified method so as to look for version as well as period of the contract
  @SuppressWarnings( { "unchecked" })
  public Long countConSvcByIdConAndNbrConSvcLineItemAndNbrConVerAndConPeriod(int idContract,int nbrCnsvcLineItem, int nbrCnsvcVersion, int nbrCnsvcPeriod){
    Query query = getSession().createQuery(
                                           "  select count(*) " + "     from ContractService"
                                                           + "    where contract.idContract = :idContract "
                                                           + "    and nbrCnsvcLineItem = :nbrCnsvcLineItem "
                                                           + "    and nbrCnsvcVersion = :nbrCnsvcVersion "
                                                           + "    and nbrCnsvcPeriod = :nbrCnsvcPeriod "
                                                          );
    query.setInteger("idContract", idContract);
    query.setInteger("nbrCnsvcLineItem", nbrCnsvcLineItem);
    query.setInteger("nbrCnsvcVersion", nbrCnsvcVersion);
    query.setInteger("nbrCnsvcPeriod", nbrCnsvcPeriod);
    
    return (Long) query.uniqueResult();
  }
  
  
  @SuppressWarnings( { "unchecked" })
  public Long countContractSvcByPrdVersIdContractService(int idContract, int nbrCnsvcVersion, int nbrCnsvcPeriod, String cdCnsvcService){
    Query query = getSession().createQuery(
                                           "  select count(*) " + "     from ContractService"
                                                           + "    where contract.idContract = :idContract "
                                                           + "    and nbrCnsvcVersion = :nbrCnsvcVersion "
                                                           + "    and nbrCnsvcPeriod = :nbrCnsvcPeriod "
                                                           + "  and cdCnsvcService = :cdCnsvcService");
                                                       
    query.setInteger("idContract", idContract);
    query.setInteger("nbrCnsvcVersion", nbrCnsvcVersion);
    query.setInteger("nbrCnsvcPeriod", nbrCnsvcPeriod);
    query.setString("cdCnsvcService", cdCnsvcService);
    
    return (Long) query.uniqueResult();
  }
    
  
  

  @SuppressWarnings( { "unchecked" })
  public List<Object[]> findServicesContractedInCounty(String szCdCncntyCounty, int idContract, int nbrCnsvcVersion,
                                                       int nbrCnsvcPeriod) {
    Query query = getSession().createQuery(
                                           "    from ContractService cs, " + "         ContractCounty cc "
                                                           + "   where cs.nbrCnsvcLineItem =  cc.nbrCncntyLineItem "
                                                           + "     and cc.cdCncntyCounty =  :szCdCncntyCounty "
                                                           + "     and cs.contract.idContract =  :idContract "
                                                           + "     and cs.nbrCnsvcVersion =  :nbrCnsvcVersion "
                                                           + "     and cs.nbrCnsvcPeriod =  :nbrCnsvcPeriod "
                                                           + "     and cc.contract.idContract =  :idContract "
                                                           + "     and cc.nbrCncntyVersion =  :nbrCnsvcVersion "
                                                           + "     and cc.nbrCncntyPeriod =  :nbrCnsvcPeriod "
                                                           + "order by cs.cdCnsvcService");
    query.setString("szCdCncntyCounty", szCdCncntyCounty);
    query.setInteger("idContract", idContract);
    query.setInteger("nbrCnsvcVersion", nbrCnsvcVersion);
    query.setInteger("nbrCnsvcPeriod", nbrCnsvcPeriod);
    return (List<Object[]>) query.list();
  }
  //STGAP00007334: Modified code to remove the validation of the contract end date against the payment of care 
  //end date and added a check to get the locked latest version.
  public double findContractedRateByIdResourceByDateByService(int idResoucre, Date dtEffDate, String service) {
    Query query = getSession()
                              .createQuery(
                                           "select cs.nbrCnsvcUnitRate from ContractService cs, ContractVersion ver join ver.contractPeriod as cp "
                                                           + " join cs.contract as c "
                                                           + " where c.capsResource.idResource = :idResoucre "
                                                           + " and c.idContract = cp.id.idContract "
                                                           + " and cp.cdCnperStatus = 'ACT' "
                                                           + " and ver.nbrCnverVersion = cs.nbrCnsvcVersion "
                                                           + " and ver.dtCnverEffective <= :dtEffDate " 
                                                           + " and ver.indCnverVerLock = :indCnverLock "
                                                           + " and cs.cdCnsvcService = :service "
                                                           + " order by ver.nbrCnverVersion desc ");

    query.setInteger("idResoucre", idResoucre);
    query.setString("service", service);
    query.setTimestamp("dtEffDate", dtEffDate);
    query.setString("indCnverLock", "Y");

    Double res = (Double) firstResult(query);
    if (res == null) {
      return 0.00;
    }
    return res;
  }
  
  @SuppressWarnings( { "unchecked" })
  public void saveContractService(ContractService contractService) {
    getSession().saveOrUpdate(contractService);
  }

  @SuppressWarnings( { "unchecked" })
  public Object[] findContractServiceAndContractVersion(int idContract, int moSvcDtlSvcMonth, int yrSvcDtlServiceYear,
                                                        String cdCncntyCounty, String cdCnsvcService) {
    Query query = getSession()
                              .createQuery(
                                           " select b.nbrCnsvcLineItem , "
                                                           + "        b.nbrCnsvcUnitRate , "
                                                           + "        b.cdCnsvcUnitType , "
                                                           + "        b.cdCnsvcPaymentType , "
                                                           + "        a.nbrCnverNoShowPct "
                                                           + "   from ContractService b , "
                                                           + "        ContractCounty c , "
                                                           + "        ContractVersion a "
                                                           + "  where a.contractPeriod.contract.idContract = :idContract "
                                                           + "    and b.contract.idContract = a.contractPeriod.contract.idContract "
                                                           + "    and c.contract.idContract = a.contractPeriod.contract.idContract "
                                                           + "    and a.dtCnverEnd = (select max(a2.dtCnverEnd) "
                                                           + "                              from ContractVersion a2 , "
                                                           + "                                   ContractService cs2 "
                                                           + "                             where a2.contractPeriod.contract.idContract = cs2.contract.idContract "
                                                           + "                               and a2.contractPeriod.contract.idContract = :idContract "
                                                           + "                               and a2.contractPeriod.id.idContract = cs2.contract.idContract"
                                                           + "                               and a2.nbrCnverVersion = cs2.nbrCnsvcVersion "
                                                           + "                               and cs2.nbrCnsvcLineItem = b.nbrCnsvcLineItem "
                                                           + "                               and trunc(a2.dtCnverEffective) <= "
                                                           + "                                   trunc(last_Day(to_Date(:moSvcDtlSvcMonth||'/'||:yrSvcDtlServiceYear ,'mm/yyyy'))) "
                                                           + "                               and trunc(a2.dtCnverEnd)  >= "
                                                           + "                                   trunc(to_Date(:moSvcDtlSvcMonth||'/01/'||:yrSvcDtlServiceYear ,'mm/dd/yyyy')) )"
                                                           + "    and c.cdCncntyCounty = :cdCncntyCounty "
                                                           + "    and c.nbrCncntyPeriod = a.contractPeriod.id.nbrCnperPeriod "
                                                           + "    and c.nbrCncntyVersion = a.nbrCnverVersion "
                                                           + "    and c.nbrCncntyVersion = b.nbrCnsvcVersion "
                                                           + "    and c.nbrCncntyPeriod = b.nbrCnsvcPeriod "
                                                           + "    and c.cdCncntyService = :cdCnsvcService "
                                                           + "    and b.nbrCnsvcLineItem = c.nbrCncntyLineItem");

    query.setInteger("idContract", idContract);
    query.setInteger("moSvcDtlSvcMonth", moSvcDtlSvcMonth);
    query.setInteger("yrSvcDtlServiceYear", yrSvcDtlServiceYear);
    query.setString("cdCncntyCounty", cdCncntyCounty);
    query.setString("cdCnsvcService", cdCnsvcService);
    return (Object[]) firstResult(query);
  }

  @SuppressWarnings( { "unchecked" })
  public int updateContractService(int idCntrctWkr, double amtCnsvcEquip, double amtCnsvcFrgBenft,
                                   double amtCnsvcOther, double amtCnsvcSalary, double amtCnsvcSupply,
                                   double amtCnsvcTravel, double amtCnsvcUnitRate, int idCnsvc, Date lastUpdate) {
    Query query = getSession().createQuery(
                                           " update ContractService " + "    set person.idPerson =:idCntrctWkr, "
                                                           + "        amtCnsvcEquip =:amtCnsvcEquip, "
                                                           + "        amtCnsvcFrgBenft =:amtCnsvcFrgBenft, "
                                                           + "        amtCnsvcOther =:amtCnsvcOther, "
                                                           + "        amtCnsvcSalary =:amtCnsvcSalary, "
                                                           + "        amtCnsvcSupply =:amtCnsvcSupply, "
                                                           + "        amtCnsvcTravel =:amtCnsvcTravel, "
                                                           + "        amtCnsvcUnitRate =:amtCnsvcUnitRate "
                                                           + "  where idCnsvc =:idCnsvc "
                                                           + "    and dtLastUpdate =:lastUpdate ");
    query.setInteger("idCntrctWkr", idCntrctWkr);
    query.setDouble("amtCnsvcEquip", amtCnsvcEquip);
    query.setDouble("amtCnsvcFrgBenft", amtCnsvcFrgBenft);
    query.setDouble("amtCnsvcOther", amtCnsvcOther);
    query.setDouble("amtCnsvcSalary", amtCnsvcSalary);
    query.setDouble("amtCnsvcSupply", amtCnsvcSupply);
    query.setDouble("amtCnsvcTravel", amtCnsvcTravel);
    query.setDouble("amtCnsvcUnitRate", amtCnsvcUnitRate);
    query.setInteger("idCnsvc", idCnsvc);
    query.setTimestamp("lastUpdate", lastUpdate);
    return query.executeUpdate();
  }

  @SuppressWarnings( { "unchecked" })
  public int updateContractService(int idContract, int idCntrctWkr, int nbrCnsvcPeriod, int nbrCnsvcVersion,
                                   int nbrCnsvcLineItem, String cdCnsvcService, String cdCnsvcPaymentType,
                                   String indCnsvcNewRow, String cdCnsvcUnitType, int nbrCnsvcFedMatch,
                                   int nbrCnsvcLocalMatch, double nbrCnsvcUnitRate, double amtCnsvcAdminAllUsed,
                                   double amtCnsvcEquip, double amtCnsvcEquipUsed, double amtCnsvcFrgBenft,
                                   double amtCnsvcFrgBenftUsed, double amtCnsvcOffItemUsed, double amtCnsvcOther,
                                   double amtCnsvcOtherUsed, double amtCnsvcSalary, double amtCnsvcSalaryUsed,
                                   double amtCnsvcSupply, double amtCnsvcSupplyUsed, double amtCnsvcTravel,
                                   double amtCnsvcTravelUsed, double amtCnsvcUnitRate, double amtCnsvcUnitRateUsed,
                                   Date dtLastUpdate, int idCnsvc) {

    Query query = getSession().createQuery(
                                           "update ContractService" + "    set contract.idContract = :idContract,"
                                                           + "        person.idPerson = :idCntrctWkr,"
                                                           + "        nbrCnsvcPeriod = :nbrCnsvcPeriod,"
                                                           + "        nbrCnsvcVersion = :nbrCnsvcVersion,"
                                                           + "        nbrCnsvcLineItem = :nbrCnsvcLineItem,"
                                                           + "        cdCnsvcService = :cdCnsvcService,"
                                                           + "        cdCnsvcPaymentType = :cdCnsvcPaymentType,"
                                                           + "        indCnsvcNewRow = :indCnsvcNewRow,"
                                                           + "        cdCnsvcUnitType = :cdCnsvcUnitType,"
                                                           + "        nbrCnsvcFedMatch = :nbrCnsvcFedMatch,"
                                                           + "        nbrCnsvcLocalMatch = :nbrCnsvcLocalMatch,"
                                                           + "        nbrCnsvcUnitRate = :nbrCnsvcUnitRate,"
                                                           + "        amtCnsvcAdminAllUsed = :amtCnsvcAdminAllUsed,"
                                                           + "        amtCnsvcEquip = :amtCnsvcEquip,"
                                                           + "        amtCnsvcEquipUsed = :amtCnsvcEquipUsed,"
                                                           + "        amtCnsvcFrgBenft = :amtCnsvcFrgBenft,"
                                                           + "        amtCnsvcFrgBenftUsed = :amtCnsvcFrgBenftUsed,"
                                                           + "        amtCnsvcOffItemUsed = :amtCnsvcOffItemUsed,"
                                                           + "        amtCnsvcOther = :amtCnsvcOther,"
                                                           + "        amtCnsvcOtherUsed = :amtCnsvcOtherUsed,"
                                                           + "        amtCnsvcSalary = :amtCnsvcSalary,"
                                                           + "        amtCnsvcSalaryUsed = :amtCnsvcSalaryUsed,"
                                                           + "        amtCnsvcSupply = :amtCnsvcSupply,"
                                                           + "        amtCnsvcSupplyUsed = :amtCnsvcSupplyUsed,"
                                                           + "        amtCnsvcTravel = :amtCnsvcTravel,"
                                                           + "        amtCnsvcTravelUsed = :amtCnsvcTravelUsed,"
                                                           + "        amtCnsvcUnitRate = :amtCnsvcUnitRate,"
                                                           + "        amtCnsvcUnitRateUsed = :amtCnsvcUnitRateUsed"
                                                           + "  where dtLastUpdate = :dtLastUpdate"
                                                           + "    and idCnsvc = :idCnsvc");
    query.setInteger("idContract", idContract);
    query.setInteger("idCntrctWkr", idCntrctWkr);
    query.setInteger("nbrCnsvcPeriod", nbrCnsvcPeriod);
    query.setInteger("nbrCnsvcVersion", nbrCnsvcVersion);
    query.setInteger("nbrCnsvcLineItem", nbrCnsvcLineItem);
    query.setString("cdCnsvcService", cdCnsvcService);
    query.setString("cdCnsvcPaymentType", cdCnsvcPaymentType);
    query.setString("indCnsvcNewRow", indCnsvcNewRow);
    query.setString("cdCnsvcUnitType", cdCnsvcUnitType);
    query.setInteger("nbrCnsvcFedMatch", nbrCnsvcFedMatch);
    query.setInteger("nbrCnsvcLocalMatch", nbrCnsvcLocalMatch);
    query.setDouble("nbrCnsvcUnitRate", nbrCnsvcUnitRate);
    query.setDouble("amtCnsvcAdminAllUsed", amtCnsvcAdminAllUsed);
    query.setDouble("amtCnsvcEquip", amtCnsvcEquip);
    query.setDouble("amtCnsvcEquipUsed", amtCnsvcEquipUsed);
    query.setDouble("amtCnsvcFrgBenft", amtCnsvcFrgBenft);
    query.setDouble("amtCnsvcFrgBenftUsed", amtCnsvcFrgBenftUsed);
    query.setDouble("amtCnsvcOffItemUsed", amtCnsvcOffItemUsed);
    query.setDouble("amtCnsvcOther", amtCnsvcOther);
    query.setDouble("amtCnsvcOtherUsed", amtCnsvcOtherUsed);
    query.setDouble("amtCnsvcSalary", amtCnsvcSalary);
    query.setDouble("amtCnsvcSalaryUsed", amtCnsvcSalaryUsed);
    query.setDouble("amtCnsvcSupply", amtCnsvcSupply);
    query.setDouble("amtCnsvcSupplyUsed", amtCnsvcSupplyUsed);
    query.setDouble("amtCnsvcTravel", amtCnsvcTravel);
    query.setDouble("amtCnsvcTravelUsed", amtCnsvcTravelUsed);
    query.setDouble("amtCnsvcUnitRate", amtCnsvcUnitRate);
    query.setDouble("amtCnsvcUnitRateUsed", amtCnsvcUnitRateUsed);
    query.setTimestamp("dtLastUpdate", dtLastUpdate);
    query.setInteger("idCnsvc", idCnsvc);

    return query.executeUpdate();
  }
  
  public int updateContractServiceForContractBudgetLimit(double addUnitRateUsed, int idContract, String cdService,
                                                         Date dtRangeStart, Date dtRangeEnd, Collection<String> allPayableStatuses) {
    Query query = getSession().createQuery("update ContractService cs " +
                                           "   set cs.amtCnsvcUnitRateUsed = nvl(cs.amtCnsvcUnitRateUsed, 0) + :addUnitRateUsed " +
                                           " where cs.contract.idContract = :idContract " +
                                           "   and cs.cdCnsvcService = :cdService " +
                                           "   and (cs.nbrCnsvcPeriod, cs.nbrCnsvcVersion) = ( " +
                                           "        select cv.contractPeriod.id.nbrCnperPeriod, max(cv.nbrCnverVersion) " +
                                           "          from ContractVersion cv " +
                                           "         where cv.contractPeriod.id.idContract = :idContract " +
                                           "           and cv.contractPeriod.id.nbrCnperPeriod = ( " +
                                           "               select max(cp.id.nbrCnperPeriod) " +
                                           "                 from ContractPeriod cp " +
                                           "                where cp.id.idContract = :idContract " +
                                           "                  and cp.dtCnperStart <= :dtRangeEnd " +
                                           "                  and cp.dtCnperTerm >= :dtRangeStart " +
                                           "                  and cp.cdCnperStatus in (:allPayableStatuses) " +
                                           "               ) " +
                                           "         group by cv.contractPeriod.id.nbrCnperPeriod " +
                                           "       )");
    query.setDouble("addUnitRateUsed", addUnitRateUsed);
    query.setInteger("idContract", idContract);
    query.setString("cdService", cdService);
    query.setDate("dtRangeStart", dtRangeStart);
    query.setDate("dtRangeEnd", dtRangeEnd);
    query.setParameterList("allPayableStatuses", allPayableStatuses, Hibernate.STRING);
    return query.executeUpdate();
  }

  @SuppressWarnings( { "unchecked" })
  public int deleteContractService(int idContract, int nbrCnverPeriod, int nbrCnverVersion) {
    Query query = getSession().createQuery(
                                           "delete ContractService cs" + "  where cs.contract.idContract = :idContract"
                                                           + "    and cs.nbrCnsvcPeriod = :nbrCnverPeriod"
                                                           + "    and cs.nbrCnsvcVersion = :nbrCnverVersion");
    query.setInteger("idContract", idContract);
    query.setInteger("nbrCnverPeriod", nbrCnverPeriod);
    query.setInteger("nbrCnverVersion", nbrCnverVersion);

    return query.executeUpdate();
  }

  @SuppressWarnings( { "unchecked" })
  public void deleteContractService(ContractService contractService) {
    getSession().delete(contractService);
  }

  @SuppressWarnings( { "unchecked" })
  public int deleteContractService(int idContract, int nbrCnperPeriod) {
    Query query = getSession().createQuery(
                                           "delete ContractService cs "
                                                           + "  where cs.contract.idContract = :idContract "
                                                           + "    and cs.nbrCnsvcPeriod = :nbrCnperPeriod ");
    query.setInteger("idContract", idContract);
    query.setInteger("nbrCnperPeriod", nbrCnperPeriod);

    return query.executeUpdate();
  }
  
  //STGAP00005989: Added SQLs to give more specific messages on Placement page.
  public Long countHomeCntrctSvc(String cdCnsvcService, int idResource){
    Query query = getSession().createQuery("select count(*) from Contract c, ContractVersion cv, ContractService cs " 
                                                           + "  where  c.idContract = cv.contractPeriod.contract.idContract "
                                                           + "  and c.idContract = cs.contract.idContract "
                                                           + "  and c.capsResource.idResource = :idResource "
                                                           + "  and cv.contractPeriod.id.nbrCnperPeriod = cs.nbrCnsvcPeriod "
                                                           + "  and cv.indCnverVerLock = :indCnverVerLock "
                                                           + "  and cv.dtCnverEffective <= sysdate "
                                                           + "  and cv.dtCnverEnd >= sysdate "
                                                           + "  and cv.contractPeriod.cdCnperStatus = 'ACT' "
                                                           + "  and cs.cdCnsvcService = :cdCnsvcService");
    query.setString("cdCnsvcService", cdCnsvcService);
    query.setInteger("idResource", idResource);
    query.setString("indCnverVerLock", "Y");
    
    return (Long) query.uniqueResult();
  }
  
  public Long countRbwoCntrctSvc(String cdCnsvcService, int idResource){
    Query query = getSession().createQuery("select count(*) from Contract c, ContractVersion cv, ContractService cs " 
                                                           + "  where  c.idContract = cv.contractPeriod.contract.idContract "
                                                           + "  and c.idContract = cs.contract.idContract "
                                                           + "  and c.capsResource.idResource = :idResource "
                                                           + "  and cv.contractPeriod.id.nbrCnperPeriod = cs.nbrCnsvcPeriod "
                                                           + "  and cv.indCnverVerLock = :indCnverVerLock "
                                                           + "  and cv.dtCnverEffective <= sysdate "
                                                           + "  and cv.dtCnverEnd >= sysdate "
                                                           + "  and cv.contractPeriod.cdCnperStatus = 'ACT' "
                                                           + "  and cs.cdCnsvcService like :cdCnsvcService");
    query.setString("cdCnsvcService", cdCnsvcService);
    query.setInteger("idResource", idResource);
    query.setString("indCnverVerLock", "Y");
    
    return (Long) query.uniqueResult();
  }
}
