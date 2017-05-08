package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.List;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.dao.ContractDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Contract;
import org.hibernate.Query;

public class ContractDAOImpl extends BaseDAOImpl implements ContractDAO {

  @SuppressWarnings( { "unchecked" })
  public long countContractByIdRsrcAddress(int idRsrcAddress) {
    Query query = getSession().createQuery(
                                           "select count(*) " + "  from Contract "
                                                           + " where resourceAddress.idRsrcAddress = :idRsrcAddress");

    query.setInteger("idRsrcAddress", idRsrcAddress);
    return (Long) query.uniqueResult();
  }

  @SuppressWarnings( { "unchecked" })
  public List<Contract> findContractByIdResource(int idResource) {
    Query query = getSession().createQuery(" from Contract c " + "where c.capsResource.idResource = :idResource");
    query.setInteger("idResource", idResource);
    return (List<Contract>) query.list();
  }

  @SuppressWarnings( { "unchecked" })
  public Contract findContractTypes(int idContract) {
    Query query = getSession().createQuery(" from Contract c " + "where c.idContract = :idContract");

    query.setInteger("idContract", idContract);
    return (Contract) firstResult(query);
  }

  @SuppressWarnings( { "unchecked" })
  public Contract findContractIdContract(int idContract) {
    Query query = getSession().createQuery(
                                           "      from Contract c " + "join fetch c.capsResource "
                                                           + "join fetch c.resourceAddress "
                                                           + "     where c.idContract = :idContract");
    query.setInteger("idContract", idContract);
    return (Contract) firstResult(query);
  }

  @SuppressWarnings( { "unchecked" })
  public Map findContractAndMore(int idContract) {
    Query query = getSession()
                              .createQuery(
                                           "select new map (c.idContract as idContract, "
                                                           + "                c.dtLastUpdate as dtLastUpdate, "
                                                           + "                c.cdCntrctFuncType as cdCntrctFuncType, "
                                                           + "                c.cdCntrctProcureType as cdCntrctProcureType, "
                                                           + "                c.cdCntrctProgramType as cdCntrctProgramType, "
                                                           + "                c.cdCntrctRegion as cdCntrctRegion, "
                                                           + "                c.indCntrctBudgLimit as indCntrctBudgLimit, "
                                                           + "                c.indCntrctdRsrc as indCntrctdRsrc, "
                                                           + "                c.personByIdCntrctManager.idPerson as idCntrctManager, "
                                                           + "                r.idResource as idResource, "
                                                           + "                r.nmResource as nmResource, "
                                                           + "                c.resourceAddress.idRsrcAddress as idRsrcAddress, "
                                                           + "                p.nmPersonFull as nmPersonFull) "
                                                           + "  from CapsResource r, "
                                                           + "       ResourceAddress a, "
                                                           + "       Person p, "
                                                           + "       Contract c "
                                                           + " where c.idContract = :idContract "
                                                           + "   and c.capsResource.idResource = r.idResource "
                                                           + "   and c.resourceAddress.idRsrcAddress = a.idRsrcAddress "
                                                           + "   and c.personByIdCntrctManager.idPerson = p.idPerson");

    query.setInteger("idContract", idContract);
    return (Map) firstResult(query);
  }

  @SuppressWarnings( { "unchecked" })
  public void saveContract(Contract contract) {
    getSession().saveOrUpdate(contract);
  }

  @SuppressWarnings( { "unchecked" })
  public void deleteContract(Contract contract) {
    getSession().delete(contract);
  }
}
