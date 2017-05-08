package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.dao.ProtectiveServiceAlertDAO;
import gov.georgia.dhr.dfcs.sacwis.db.ProtectiveServiceAlert;

import org.hibernate.Query;

public class ProtectiveServiceAlertDAOImpl extends BaseDAOImpl implements ProtectiveServiceAlertDAO {

  public void saveProtectiveServiceAlert(ProtectiveServiceAlert psAlert) {
    getSession().saveOrUpdate(psAlert);
  }
  
  @SuppressWarnings( { "unchecked" })
  public List<Object[]> findPSAByIdStage(int idStage){
    Query query = getSession().createQuery("select psa.idProtectiveServiceAlert as idPSA, " +
                                           "       psa.person.idPerson as idCaseManager, " +
                                           "       psa.person.nmPersonFull as nmCaseManager, " +
                                           "       emp.cdEmployeeClass as cdCaseMgrTitle, " +
                                           "       psa.cdPsaStage as cdPsaStage, " +
                                           "       psa.dtPsaDate as dtPsaDate, " +
                                           "       psa.dtPsaAbsconded as dtPsaAbsconded, " +
                                           "       psa.cdPsaReasonalert as cdPsaReasonalert, " +
                                           "       psa.chPsaAllpesrlocated as indPsaAllPersLocated, " +
                                           "       psa.txtPsaComment as txtPsaComment, " +
                                           "       psa.stage.capsCase.idCase as idCase, " +
                                           "       psa.stage.nmStage as nmStage " +
                                           "  from ProtectiveServiceAlert psa, " +
                                           "       Employee emp " +
                                           " where psa.stage.idStage = :idStage " +
                                           "   and emp.person.idPerson = psa.person.idPerson");
    query.setInteger("idStage", idStage);
    return (List<Object[]>) query.list();
  }
  
  /*
  public Integer findIdPSAByIdStage(int idStage){
    Query query = getSession().createQuery("select max(psa.idProtectiveServiceAlert) " +
                                           "  from ProtectiveServiceAlert psa " +
                                           " where psa.stage.idStage = :idStage");
    query.setInteger("idStage", idStage);
    return (Integer) query.uniqueResult();
  }
  */
}
