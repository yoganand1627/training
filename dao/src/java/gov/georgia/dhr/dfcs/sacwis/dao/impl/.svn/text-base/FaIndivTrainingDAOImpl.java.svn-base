package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.List;
import java.util.Map;
import java.util.Date;

import gov.georgia.dhr.dfcs.sacwis.dao.FaIndivTrainingDAO;
import gov.georgia.dhr.dfcs.sacwis.db.FaIndivTraining;
import org.hibernate.Query;

public class FaIndivTrainingDAOImpl extends BaseDAOImpl implements FaIndivTrainingDAO {
  @SuppressWarnings({"unchecked"})
  /*public List<FaIndivTraining> findFaIndivTrainingByIdPerson(int idPerson) {
    Query query = getSession().createQuery("  select f.cdIndivTrnType," +
                                           "          f.dtIndivTrn," +
                                           "          f.idIndivTraining," +
                                           "          f.person.idPerson," +
                                           "          f.indIndivTrnEc," +
                                           "          f.nbrIndivTrnHrs," +
                                           "          f.nbrIndivTrnSession," +
                                           "          f.txtIndivTrnTitle," +
                                           "          f.dtLastUpdate," +
                                           "          f.cdTrain1Role," +
                                           "          f.cdTrain2Role," +
                                           "          f.cdTrain3Role," +
                                           "          f.cdTrain4Role," +
                                           "          f.nmTrain1," +
                                           "          f.nmTrain2," +
                                           "          f.nmTrain3," +
                                           "          f.nmTrain4," +
                                           "          f.indCoTrain," +
                                           "          f.nmAgency" +
                                           "     from FaIndivTraining f," +
                                           "          PersonMergeView v" +
                                           "    where f.person.idPerson = v.id.idPersonOutput" +
                                           "      and v.id.idPersonInput = :idPerson" +
                                           " order by f.dtIndivTrn desc");
    query.setInteger("idPerson", idPerson);
    return (List<FaIndivTraining>) query.list();
  }*/
  
  public List<Map> findFaIndivTrainingByIdPerson(int idPerson) {
    Query query = getSession().createQuery("  select new map (f.cdIndivTrnType as cdIndivTrnType," +
                                           "          f.dtIndivTrn as dtIndivTrn," +
                                           "          f.idIndivTraining as idIndivTraining," +
                                           "          f.person.idPerson as idPerson," +
                                           "          f.indIndivTrnEc as indIndivTrnEc," +
                                           "          f.nbrIndivTrnHrs as nbrIndivTrnHrs," +
                                           "          f.nbrIndivTrnSession as nbrIndivTrnSession," +
                                           "          f.txtIndivTrnTitle as txtIndivTrnTitle," +
                                           "          f.dtLastUpdate as dtLastUpdate," +
                                           "          f.cdTrain1Role as cdTrain1Role," +
                                           "          f.cdTrain2Role as cdTrain2Role," +
                                           "          f.cdTrain3Role as cdTrain3Role," +
                                           "          f.cdTrain4Role as cdTrain4Role," +
                                           "          f.nmTrain1 as nmTrain1," +
                                           "          f.nmTrain2 as nmTrain2," +
                                           "          f.nmTrain3 as nmTrain3," +
                                           "          f.nmTrain4 as nmTrain4," +
                                           "          f.indCoTrain as indCoTrain," +
                                           "          f.nmAgency as nmAgency)" +
                                           "    from FaIndivTraining f," +
                                           "          PersonMergeView v" +
                                           "    where f.person.idPerson = v.id.idPersonOutput" +
                                           "      and v.id.idPersonInput = :idPerson" +
                                           " order by f.dtIndivTrn desc");
    query.setInteger("idPerson", idPerson);
    return (List<Map>) query.list();
  }
  
  

  public long countFaIndivTrainingByIdPerson(int idPerson, int idNewPerson) {
    Query query = getSession().createQuery("select count(*) " +
                                           "  from FaIndivTraining fa1, " +
                                           "       FaIndivTraining fa2 " +
                                           " where fa1.person.idPerson = :idPerson " +
                                           "   and fa2.person.idPerson = :idNewPerson " +
                                           "   and fa1.cdIndivTrnType = fa2.cdIndivTrnType " +
                                           "   and fa1.dtIndivTrn = fa2.dtIndivTrn ");
    query.setInteger("idPerson", idPerson);
    query.setInteger("idNewPerson", idNewPerson);
    return (Long) query.uniqueResult();
  }

  public long countFaIndivTrainingByIdPersonAndCdIndivTrnType(int idPerson, String cdIndivTrnType) {
    Query query = getSession().createQuery("select count(*) " +
                                           "  from FaIndivTraining f " +
                                           " where f.person.idPerson = :idPerson " +
                                           "   and cdIndivTrnType = :cdIndivTrnType ");
    query.setInteger("idPerson", idPerson);
    query.setString("cdIndivTrnType", cdIndivTrnType);
    return (Long) query.uniqueResult();
  }

  public void saveFaIndivTraining(FaIndivTraining faIndivTraining) {
    getSession().saveOrUpdate(faIndivTraining);
  }

  public int deleteFaIndivTraining(int idIndivTraining) {
    Query query = getSession().createQuery("delete from FaIndivTraining f " +
    "      where f.idIndivTraining = :idIndivTraining ");
    query.setInteger("idIndivTraining", idIndivTraining);

    return query.executeUpdate();
  }
  
  public long countFaIndivTrainingByIdPersonAndCdIndivTrnTypeAndDtIndivTrn(int idPerson, String cdIndivTrnType, Date dtIndivTrn) {
    Query query = getSession().createQuery("select count(*) " +
                                           "  from FaIndivTraining f " +
                                           " where f.person.idPerson = :idPerson " +
                                           "   and cdIndivTrnType = :cdIndivTrnType " +
                                           "   and dtIndivTrn = :dtIndivTrn");
    query.setInteger("idPerson", idPerson);
    query.setString("cdIndivTrnType", cdIndivTrnType);
    query.setDate("dtIndivTrn", dtIndivTrn);
    return (Long) query.uniqueResult();
  }
  
}
