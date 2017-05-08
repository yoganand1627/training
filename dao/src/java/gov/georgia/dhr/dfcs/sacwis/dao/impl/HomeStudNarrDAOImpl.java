package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.HomeStudNarrDAO;

import java.math.BigDecimal;

import org.hibernate.Query;

public class HomeStudNarrDAOImpl extends BaseDAOImpl implements HomeStudNarrDAO {
  public Integer retrieveHomeStudNarr(int idStage){

    Query query = getSession().createSQLQuery("select h.id_document_Template " +
                                           "  from Home_Stud_Narr h " +
                                           " where h.id_Stage = :idStage");

    query.setInteger("idStage", idStage);
    BigDecimal docTemp = (BigDecimal) firstResult(query);
    int i = docTemp != null ? docTemp.intValue() : 0;
    Integer o = (Integer) i;
    return o;
  }
  
  public int deleteHomeStudNarr(int idStage){
    Query query = getSession().createSQLQuery("delete from Home_Stud_Narr h" +
                                           " where h.id_document_Template = 14 " +
                                           " and h.id_Stage = :idStage ");
    
    query.setInteger("idStage", idStage);
    return query.executeUpdate();
  }
}
