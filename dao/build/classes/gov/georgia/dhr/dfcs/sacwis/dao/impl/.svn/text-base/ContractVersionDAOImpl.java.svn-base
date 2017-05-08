package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.Date;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.dao.ContractVersionDAO;
import gov.georgia.dhr.dfcs.sacwis.db.ContractVersion;
import org.hibernate.Query;

/*
 * Change History:
 * Date         User              Description
 * --------     ----------------  --------------------------------------------------
 * 09/12/2011   charden           STGAP00017058 - added new lastUpdatedBy property to both updateContractVersion() methods
 *
 */
public class ContractVersionDAOImpl extends BaseDAOImpl implements ContractVersionDAO {

  public ContractVersion findLatestContractVersion(int idContract, int nbrCnperPeriod) {
    Query query = getSession()
                              .createQuery(
                                           " from ContractVersion c  "
                                                       + "where c.contractPeriod.id.idContract = :idContract "
                                                       + "  and c.contractPeriod.id.nbrCnperPeriod = :nbrCnperPeriod "
                                                       + "  and c.nbrCnverVersion =  "
                                                       + "      ( select max(c2.nbrCnverVersion) "
                                                       + "          from ContractVersion c2  "
                                                       + "          where c2.contractPeriod.id.idContract = :idContract "
                                                       + "          and c2.contractPeriod.id.nbrCnperPeriod = :nbrCnperPeriod )");

    query.setInteger("idContract", idContract);
    query.setInteger("nbrCnperPeriod", nbrCnperPeriod);
    return (ContractVersion) firstResult(query);
  }
  
  public ContractVersion findPreviousContractVersion(int idContract, int nbrCnperPeriod) {
    Query query = getSession()
                              .createQuery(
                                           " from ContractVersion c  "
                                                       + "where c.contractPeriod.id.idContract = :idContract "
                                                       + "  and c.contractPeriod.id.nbrCnperPeriod = :nbrCnperPeriod "
                                                       + "  and c.nbrCnverVersion =  "
                                                       + "      ( select max(c2.nbrCnverVersion) - 1 "
                                                       + "          from ContractVersion c2  "
                                                       + "          where c2.contractPeriod.id.idContract = :idContract "
                                                       + "          and c2.contractPeriod.id.nbrCnperPeriod = :nbrCnperPeriod )");

    query.setInteger("idContract", idContract);
    query.setInteger("nbrCnperPeriod", nbrCnperPeriod);
    return (ContractVersion) firstResult(query);
  }

  public ContractVersion findCurrentContractVersion(int idContract, int nbrCnperPeriod) {
    Query query = getSession()
                              .createQuery(
                                           " from ContractVersion c "
                                                           + "where c.contractPeriod.contract.idContract = :idContract "
                                                           + "  and c.contractPeriod.id.nbrCnperPeriod = :nbrCnperPeriod "
                                                           + "  and c.dtCnverEnd >= sysdate");

    query.setInteger("idContract", idContract);
    query.setInteger("nbrCnperPeriod", nbrCnperPeriod);
    return (ContractVersion) firstResult(query);
  }

  @SuppressWarnings( { "unchecked" })
  public List<ContractVersion> findContractVersionByIdContractAndNbrCnperPeriod(int idContract, int nbrCnverPeriod) {
    Query query = getSession()
                              .createQuery(
                                           "    from ContractVersion c "
                                                           + "   where c.contractPeriod.id.idContract = :idContract "
                                                           + "     and c.contractPeriod.id.nbrCnperPeriod = :nbrCnverPeriod "
                                                           + "order by c.contractPeriod.id.nbrCnperPeriod, "
                                                           + "         c.nbrCnverVersion desc");
    query.setInteger("idContract", idContract);
    query.setInteger("nbrCnverPeriod", nbrCnverPeriod);
    return (List<ContractVersion>) query.list();
  }

  public void saveContractVersion(ContractVersion contractVersion) {
    getSession().saveOrUpdate(contractVersion);
  }

  public int updateContractVersion(int idContract, int nbrCnverPeriod, int nbrCnverVersion, Date dtLastUpdate,
                                   int idCnver, int idCntrctWkr, int nbrCnverNoShowPct, String indCnverVerLock,
                                   String txtCnverComment, Date dtCnverCreate, Date dtCnverEnd, Date dtCnverEffective, String lastUpdatedBy) {

    Query query = getSession()
                              .createQuery(
                                           "update ContractVersion "
                                                           + "    set idCnver = :idCnver, "
                                                           + "        contractPeriod.id.idContract = :idContract, "
                                                           + "        person.idPerson = :idCntrctWkr, "
                                                           + "        contractPeriod.id.nbrCnperPeriod = :nbrCnverPeriod, "
                                                           + "        nbrCnverVersion = :nbrCnverVersion, "
                                                           + "        nbrCnverNoShowPct = :nbrCnverNoShowPct, "
                                                           + "        indCnverVerLock = :indCnverVerLock, "
                                                           + "        txtCnverComment = :txtCnverComment, "
                                                           + "        dtCnverCreate = :dtCnverCreate, "
                                                           + "        dtCnverEffective = :dtCnverEffective, "
                                                           + "        dtCnverEnd = :dtCnverEnd, "
                                                           + "        dtLastUpdate = :dtLastUpdate, "
                                                           + "        txtLastUpdatedBy = :lastUpdatedBy "
                                                           + "  where contractPeriod.id.idContract = :idContract "
                                                           + "    and contractPeriod.id.nbrCnperPeriod = :nbrCnverPeriod "
                                                           + "    and nbrCnverVersion = :nbrCnverVersion "
                                                           + "    and dtLastUpdate = :dtLastUpdate");
    query.setInteger("idContract", idContract);
    query.setInteger("nbrCnverPeriod", nbrCnverPeriod);
    query.setInteger("nbrCnverVersion", nbrCnverVersion);
    query.setTimestamp("dtLastUpdate", dtLastUpdate);
    query.setInteger("idCnver", idCnver);
    query.setInteger("idCntrctWkr", idCntrctWkr);
    query.setInteger("nbrCnverNoShowPct", nbrCnverNoShowPct);
    query.setString("indCnverVerLock", indCnverVerLock);
    query.setString("txtCnverComment", txtCnverComment);
    query.setTimestamp("dtCnverCreate", dtCnverCreate);
    query.setTimestamp("dtCnverEffective", dtCnverEffective);
    query.setTimestamp("dtCnverEnd", dtCnverEnd);
    query.setString("lastUpdatedBy", lastUpdatedBy);
    return query.executeUpdate();
  }
  
  public int updateContractVersion(int idContract, int nbrCnverPeriod, int nbrCnverVersion, Date dtLastUpdate,
                                   Date dtCnverEnd, String lastUpdatedBy) {

    Query query = getSession()
                              .createQuery(
                                           "update ContractVersion "
                                                           + "    set dtCnverEnd = :dtCnverEnd, "
                                                           + "        dtLastUpdate = :dtLastUpdate, "
                                                           + "        txtLastUpdatedBy = :lastUpdatedBy "
                                                           + "  where contractPeriod.id.idContract = :idContract "
                                                           + "    and contractPeriod.id.nbrCnperPeriod = :nbrCnverPeriod "
                                                           + "    and nbrCnverVersion = :nbrCnverVersion ");
    query.setInteger("idContract", idContract);
    query.setInteger("nbrCnverPeriod", nbrCnverPeriod);
    query.setInteger("nbrCnverVersion", nbrCnverVersion);
    query.setTimestamp("dtLastUpdate", dtLastUpdate);
    query.setTimestamp("dtCnverEnd", dtCnverEnd);
    query.setString("lastUpdatedBy", lastUpdatedBy);
    return query.executeUpdate();
  }

  public int updateContractVersion(int idCntrctWkr, Date dtCnverEffective, Date dtCnverEnd, String indCnverVerLock,
                                   int idContract, int nbrCnverPeriod, int nbrCnverVersion, String lastUpdatedBy) {

    Query query = getSession()
                              .createQuery(
                                           "update ContractVersion "
                                                           + "   set person.idPerson = :idCntrctWkr, "
                                                           + "       contractPeriod.id.idContract = :idContract, "
                                                           + "       contractPeriod.id.nbrCnperPeriod = :nbrCnverPeriod, "
                                                           + "       dtCnverEffective = :dtCnverEffective, "
                                                           + "       dtCnverEnd = :dtCnverEnd, "
                                                           + "       nbrCnverVersion = :nbrCnverVersion, "
                                                           + "       indCnverVerLock = :indCnverVerLock, "
                                                           + "       txtLastUpdatedBy = :lastUpdatedBy "
                                                           + " where contractPeriod.id.idContract = :idContract "
                                                           + "   and contractPeriod.id.nbrCnperPeriod = :nbrCnverPeriod "
                                                           + "   and nbrCnverVersion = :nbrCnverVersion");
    query.setInteger("idCntrctWkr", idCntrctWkr);
    query.setTimestamp("dtCnverEffective", dtCnverEffective);
    query.setTimestamp("dtCnverEnd", dtCnverEnd);
    query.setString("indCnverVerLock", indCnverVerLock);
    query.setInteger("idContract", idContract);
    query.setInteger("nbrCnverPeriod", nbrCnverPeriod);
    query.setInteger("nbrCnverVersion", nbrCnverVersion);
    query.setString("lastUpdatedBy", lastUpdatedBy);
    return query.executeUpdate();
  }

  public int deleteContractVersion(int idContract, int nbrCnverPeriod, int nbrCnverVersion, Date dtLastUpdate) {
    Query query = getSession()
                              .createQuery(
                                           "delete ContractVersion cv "
                                                           + " where cv.contractPeriod.id.idContract = :idContract "
                                                           + "   and cv.contractPeriod.id.nbrCnperPeriod = :nbrCnverPeriod "
                                                           + "   and cv.nbrCnverVersion = :nbrCnverVersion "
                                                           + "   and cv.dtLastUpdate = :dtLastUpdate ");
    query.setInteger("idContract", idContract);
    query.setInteger("nbrCnverPeriod", nbrCnverPeriod);
    query.setInteger("nbrCnverVersion", nbrCnverVersion);
    query.setTimestamp("dtLastUpdate", dtLastUpdate);

    return query.executeUpdate();
  }

}