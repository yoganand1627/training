package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.Date;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.dao.ContractPeriodDAO;
import gov.georgia.dhr.dfcs.sacwis.db.ContractPeriod;
import org.hibernate.Query;

/*
 * Change History:
 * Date         User              Description
 * --------     ----------------  --------------------------------------------------
 * 09/12/2011   charden           STGAP00017058 - added txtLastUpdatedBy to updateContractPeriod() methods
 * 01/06/2012	aavila			  INCPS0000173448 - fixing updateContractPeriod() method, adding missing comma
 *
 */

public class ContractPeriodDAOImpl extends BaseDAOImpl implements ContractPeriodDAO {
  @SuppressWarnings( { "unchecked" })
  public Date findDtCnperTermByMaxNbrCnperPeriod(int idContract) {
    Query query = getSession()
                              .createQuery(
                                           "select dtCnperTerm"
                                                           + " from   ContractPeriod c"
                                                           + " where  id.idContract = :idContract"
                                                           + " and c.id.nbrCnperPeriod = (select max(c2.id.nbrCnperPeriod)"
                                                           + "                            from   ContractPeriod c2"
                                                           + "                            where  c2.id.idContract = :idContract)");
    query.setInteger("idContract", idContract);

    return (Date) firstResult(query);
  }

  @SuppressWarnings( { "unchecked" })
  public ContractPeriod findContractPeriodByIdContractAndNbrCnperPeriod(int idContract, int nbrCnperPeriod) {
    Query query = getSession().createQuery(
                                           "      from ContractPeriod cp " + "join fetch cp.contract "
                                                           + "     where cp.contract.idContract = :idContract "
                                                           + "       and cp.id.nbrCnperPeriod = :nbrCnperPeriod");

    query.setInteger("idContract", idContract);
    query.setInteger("nbrCnperPeriod", nbrCnperPeriod);
    return (ContractPeriod) firstResult(query);
  }

  @SuppressWarnings( { "unchecked" })
  public List<ContractPeriod> findListOfContractPeriodByIdContract(int idContract) {
    Query query = getSession().createQuery(
                                           "    from ContractPeriod c"
                                                           + "    where c.contract.idContract = :idContract"
                                                           + "    order by c.id.nbrCnperPeriod desc");

    query.setInteger("idContract", idContract);
    return (List<ContractPeriod>) query.list();
  }

  @SuppressWarnings( { "unchecked" })
  public ContractPeriod findContractPeriodAndContract(int idContract, int nbrCnperPeriod) {
    Query query = getSession().createQuery(
                                           "      from ContractPeriod cp " + "join fetch cp.contract "
                                                           + "     where cp.contract.idContract = :idContract "
                                                           + "       and cp.id.nbrCnperPeriod = :nbrCnperPeriod "
                                                           + "       and (cp.cdCnperStatus <> '"
                                                           + CodesTables.CCONSTAT_PND + "' "
                                                           + "            and cp.cdCnperStatus <> '"
                                                           + CodesTables.CCONSTAT_PSH + "' "
                                                           + "            and cp.cdCnperStatus <> '"
                                                           + CodesTables.CCONSTAT_SVH + "' ) ");

    query.setInteger("idContract", idContract);
    query.setInteger("nbrCnperPeriod", nbrCnperPeriod);
    return (ContractPeriod) firstResult(query);
  }

  @SuppressWarnings( { "unchecked" })
  public ContractPeriod findContractPeriodWithIdContractAndNbrCnperPeriod(int idContract, int nbrCnperPeriod) {
    Query query = getSession().createQuery(
                                           " from ContractPeriod cp " + "where cp.id.idContract = :idContract "
                                                           + "  and cp.id.nbrCnperPeriod = :nbrCnperPeriod ");

    query.setInteger("idContract", idContract);
    query.setInteger("nbrCnperPeriod", nbrCnperPeriod);
    return (ContractPeriod) firstResult(query);
  }

  @SuppressWarnings( { "unchecked" })
  public ContractPeriod findContractPeriodFromContractAndContractPeriod(int idContract, int nbrCnperPeriod) {
    Query query = getSession().createQuery(
                                           "      from ContractPeriod cp " + "join fetch cp.contract "
                                                           + "     where cp.contract.idContract = :idContract "
                                                           + "       and cp.id.nbrCnperPeriod = :nbrCnperPeriod "
                                                           + "       and (cp.cdCnperStatus = '"
                                                           + CodesTables.CCONSTAT_ACT + "' "
                                                           + "            or cp.cdCnperStatus = '"
                                                           + CodesTables.CCONSTAT_CLS + "' "
                                                           + "            or cp.cdCnperStatus = '"
                                                           + CodesTables.CCONSTAT_CLT + "' "
                                                           + "            or cp.cdCnperStatus = '"
                                                           + CodesTables.CCONSTAT_PNT + "' "
                                                           + "            or cp.cdCnperStatus = '"
                                                           + CodesTables.CCONSTAT_PSH + "' "
                                                           + "            or cp.cdCnperStatus = '"
                                                           + CodesTables.CCONSTAT_PYH + "' "
                                                           + "            or cp.cdCnperStatus = '"
                                                           + CodesTables.CCONSTAT_SVH + "' )");

    query.setInteger("idContract", idContract);
    query.setInteger("nbrCnperPeriod", nbrCnperPeriod);
    return (ContractPeriod) firstResult(query);
  }

  @SuppressWarnings( { "unchecked" })
  public ContractPeriod findContractPeriodByIdContract(int idContract) {
    Query query = getSession().createQuery(
                                           " from ContractPeriod cp " + "where cp.contract.idContract = :idContract "
                                                           + "  and cp.dtCnperClosure >= sysdate");
    query.setInteger("idContract", idContract);
    return (ContractPeriod) firstResult(query);
  }

  @SuppressWarnings( { "unchecked" })
  public int updateContractPeriod(int idCntrctWkr, String cdCnperStatus, Date dtCnperStart, Date dtCnperTerm,
                                  Date dtCnperClosure, String indCnperRenewal, String indCnperSigned,
                                  int nbrLegalIdentifier, Date dtLastUpdate, int idContract, int nbrCnperPeriod,
                                  String txtTermComm, String lastUpdatedBy) {

    Query query = getSession().createQuery(
                                           "update ContractPeriod" + "    set person.idPerson = :idCntrctWkr,"
                                                           + "        cdCnperStatus = :cdCnperStatus,"
                                                           + "        dtCnperStart = :dtCnperStart,"
                                                           + "        dtCnperTerm = :dtCnperTerm,"
                                                           + "        dtCnperClosure = :dtCnperClosure,"
                                                           + "        indCnperRenewal = :indCnperRenewal,"
                                                           + "        indCnperSigned = :indCnperSigned,"
                                                           + "        nbrLegalIdentifier = :nbrLegalIdentifier,"
                                                           + "        txtTermComm = :txtTermComm,"
                                                           + "        txtLastUpdatedBy = :lastUpdatedBy"
                                                           + "  where contract.idContract = :idContract"
                                                           + "    and id.nbrCnperPeriod = :nbrCnperPeriod");
    query.setInteger("idCntrctWkr", idCntrctWkr);
    query.setString("cdCnperStatus", cdCnperStatus);
    query.setTimestamp("dtCnperStart", dtCnperStart);
    query.setTimestamp("dtCnperTerm", dtCnperTerm);
    query.setTimestamp("dtCnperClosure", dtCnperClosure);
    query.setString("indCnperRenewal", indCnperRenewal);
    query.setString("indCnperSigned", indCnperSigned);
    query.setInteger("nbrLegalIdentifier", nbrLegalIdentifier);
    query.setInteger("idContract", idContract);
    query.setInteger("nbrCnperPeriod", nbrCnperPeriod);
    query.setString("txtTermComm", txtTermComm);
    query.setString("lastUpdatedBy", lastUpdatedBy);

    return query.executeUpdate();
  }

  public int updateContractPeriod(int idCntrctWkr, String cdCnperStatus, Date dtCnperStart, Date dtCnperTerm,
                                  Date dtCnperClosure, String indCnperRenewal, String indCnperSigned,
                                  int nbrLegalIdentifier, Date dtLastUpdate, int idContract, int nbrCnperPeriod, String lastUpdatedBy) {

    Query query = getSession().createQuery(
                                           "update ContractPeriod" + "    set person.idPerson = :idCntrctWkr,"
                                                           + "        cdCnperStatus = :cdCnperStatus,"
                                                           + "        dtCnperStart = :dtCnperStart,"
                                                           + "        dtCnperTerm = :dtCnperTerm,"
                                                           + "        dtCnperClosure = :dtCnperClosure,"
                                                           + "        indCnperRenewal = :indCnperRenewal,"
                                                           + "        indCnperSigned = :indCnperSigned,"
                                                           + "        nbrLegalIdentifier = :nbrLegalIdentifier,"
                                                           + "        txtLastUpdatedBy = :lastUpdatedBy"
                                                           + "  where dtLastUpdate = :dtLastUpdate"
                                                           + "    and contract.idContract = :idContract"
                                                           + "    and id.nbrCnperPeriod = :nbrCnperPeriod");
    query.setInteger("idCntrctWkr", idCntrctWkr);
    query.setString("cdCnperStatus", cdCnperStatus);
    query.setTimestamp("dtCnperStart", dtCnperStart);
    query.setTimestamp("dtCnperTerm", dtCnperTerm);
    query.setTimestamp("dtCnperClosure", dtCnperClosure);
    query.setString("indCnperRenewal", indCnperRenewal);
    query.setString("indCnperSigned", indCnperSigned);
    query.setInteger("nbrLegalIdentifier", nbrLegalIdentifier);
    query.setTimestamp("dtLastUpdate", dtLastUpdate);
    query.setInteger("idContract", idContract);
    query.setInteger("nbrCnperPeriod", nbrCnperPeriod);
    query.setString("lastUpdatedBy", lastUpdatedBy);

    return query.executeUpdate();
  }

  @SuppressWarnings( { "unchecked" })
  public int deleteContractPeriod(int idContract, int nbrCnperPeriod, Date dtLastUpdate) {
    Query query = getSession().createQuery(
                                           "delete ContractPeriod cp "
                                                           + "  where cp.contract.idContract = :idContract "
                                                           + "    and cp.id.nbrCnperPeriod = :nbrCnperPeriod "
                                                           + "    and cp.dtLastUpdate = :dtLastUpdate ");
    query.setInteger("idContract", idContract);
    query.setInteger("nbrCnperPeriod", nbrCnperPeriod);
    query.setTimestamp("dtLastUpdate", dtLastUpdate);

    return query.executeUpdate();
  }

  @SuppressWarnings( { "unchecked" })
  public void saveContractPeriod(ContractPeriod contractPeriod) {
    getSession().saveOrUpdate(contractPeriod);
  }
  
  @SuppressWarnings( { "unchecked" })
  public List<ContractPeriod> findListOfContractPeriodByIdResource(int idResource) {
    Query query = getSession().createQuery(
                                           "    from ContractPeriod cp, Contract c"
                                                           + "    where cp.cdCnperStatus = 'ACT'"
                                                           + "    and cp.dtCnperClosure > sysdate"
                                                           + "    and cp.contract.idContract = c.idContract "
                                                           + "    and c.capsResource.idResource = :idResource"   
                                                           + "    order by cp.id.nbrCnperPeriod desc");
    
    
    query.setInteger("idResource", idResource);
    return (List<ContractPeriod>) query.list();
  }
  
}
