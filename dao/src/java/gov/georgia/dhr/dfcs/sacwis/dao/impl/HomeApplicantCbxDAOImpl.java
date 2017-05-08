package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.List;

import org.hibernate.Query;

import gov.georgia.dhr.dfcs.sacwis.dao.HomeApplicantCbxDAO;
import gov.georgia.dhr.dfcs.sacwis.db.HomeApplicantCbx;

public class HomeApplicantCbxDAOImpl extends BaseDAOImpl implements HomeApplicantCbxDAO {

  @SuppressWarnings({"unchecked"})
  public List<HomeApplicantCbx> findHomeApplicantCbxByIdHomeApplicantCbxType(int idHomeApplicant, String cbxType) {
    Query query = getSession().createQuery(" from HomeApplicantCbx homeCbx" +
                                           " where homeCbx.homeApplicantInfo.idHomeApplicant = :idHomeApplicant" +
                                           " and homeCbx.cdHomeAplcntCbxType = :cdHomeAplcntCbxType");
    
    query.setInteger("idHomeApplicant", idHomeApplicant);
    query.setString("cdHomeAplcntCbxType", cbxType);
    
    return (List<HomeApplicantCbx>) query.list();
  }

  public void saveHomeApplicantCbx(HomeApplicantCbx homeApplicantCbx) {
    getSession().saveOrUpdate( homeApplicantCbx );
  }

  public void deleteHomeApplicantCbx(HomeApplicantCbx homeApplicantCbx) {
    getSession().delete( homeApplicantCbx );
  }
  
  public int deleteHomeApplicantCbx(int idHomeApplicant, String cbxType, String cbx) {
    Query query = getSession().createQuery("delete from HomeApplicantCbx h " +
                                           "      where h.homeApplicantInfo.idHomeApplicant = :idHomeApplicant " +
                                           "        and h.cdHomeAplcntCbxType = :cbxType " +
                                           "        and h.cdHomeApplicantCbx = :cbx");
    query.setInteger("idHomeApplicant", idHomeApplicant);
    query.setString("cbxType", cbxType);
    query.setString("cbx", cbx);
    return query.executeUpdate();
  }
}
