package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.List;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.dao.CaseReviewDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CaseReview;
import gov.georgia.dhr.dfcs.sacwis.db.CaseReviewCateg;
import gov.georgia.dhr.dfcs.sacwis.db.CaseReviewCbxResponse;
import gov.georgia.dhr.dfcs.sacwis.db.CaseReviewItem;
import gov.georgia.dhr.dfcs.sacwis.db.CaseReviewQuesResponse;


import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;

/**
 * Created on March 11 2009 by Bhavna Gehlot
 */

/*** Change History:
 **  Date        User              Description
 **  --------    ----------------  ----------------------------------------------------------------
 *   12/23/2009   bgehlot          SMS#42495: Display Question numbers in front of the Question text
 */
public class CaseReviewDAOImpl extends BaseDAOImpl implements CaseReviewDAO {
  @SuppressWarnings("unchecked")
  public List<Map<String, Object>> findCaseReviewQuestions(String cdSurveyCode, String cdSurveyType, String cdSurveyQuestionType, int maxVersion) {
    SQLQuery query = getSession().createSQLQuery("select distinct crcl.cd_Category as cdCategory, "
                                 + "                        crcl.txt_Category as txtCategory,   "
                                 + "                        crcl.nbr_Category_Order as nbrCategoryOrder,  "
                                 + "                        cril.cd_Item as cdItem, "
                                 + "                        cril.txt_Item as txtItem, "
                                 + "                        cril.nbr_Item_Order as nbrItemOrder,  "
                                 + "                        crql.cd_Question as cdQuestion,  "
                                 + "                        crql.txt_Question as txtQuestion, "
                                 + "                        crql.nbr_Question_Order as nbrQuestionOrder, "
                                 + "                        crql.ind_Cbx as indCbx, " 
                                 + "                        crql.ind_Question_Type as indQuestionType, " 
                                 + "                        crql.cd_Survey_Question_Type as cdSurveyQuestionType, " 
                                 + "                        crs.cd_Version as cdVersion, " 
                                 + "                        crql.txt_Ques_Help as txtQuesHelp, "
                                 + "                        crql.txt_question_num as txtQuestionNum "
                                 + "  from ( select c.cd_Question, max(c.cd_Version) as cd_Version "
                                 + "  from Case_Review_Ques_Lookup c GROUP BY c.cd_Question) newcrql, " 
                                 + "       Case_Review_Categ_Lookup crcl,  "
                                 + "       Case_Review_Item_Lookup cril, "
                                 + "       Case_Review_Ques_Lookup crql, "
                                 + "       Case_Review_Survey crs "
                                 + " where cril.cd_Item = crql.cd_Item "
                                 + "   and crcl.cd_Category = cril.cd_Category  "
                                 + "   and newcrql.cd_Question = crs.cd_Question "
                                 + "   and   newcrql.cd_Version  = crs.cd_Version "
                                 + "   and   newcrql.cd_Question = crql.cd_Question  "
                                 + "   and   newcrql.cd_Version = crql.cd_Version "
                                 + "   and crs.cd_Survey_Code = :cdSurveyCode  "
                                 + "   and crs.cd_Survey_Type = :cdSurveyType "
                                 + "   and crql.cd_Survey_Question_Type = :cdSurveyQuestionType "
                                 + "   and crql.cd_version != :maxVersion "
                                 + "   order by crcl.nbr_Category_Order, "
                                 + "          cril.nbr_Item_Order, "
                                 + "          crql.nbr_Question_Order");
    query.addScalar("cdCategory", Hibernate.STRING);
    query.addScalar("txtCategory", Hibernate.STRING);
    query.addScalar("nbrCategoryOrder", Hibernate.INTEGER);
    query.addScalar("cdItem", Hibernate.STRING);
    query.addScalar("txtItem", Hibernate.STRING);
    query.addScalar("nbrItemOrder", Hibernate.INTEGER);
    query.addScalar("cdQuestion", Hibernate.STRING);
    query.addScalar("txtQuestion", Hibernate.STRING);
    query.addScalar("nbrQuestionOrder", Hibernate.INTEGER);
    query.addScalar("indCbx", Hibernate.STRING);
    query.addScalar("indQuestionType", Hibernate.STRING);
    query.addScalar("cdSurveyQuestionType", Hibernate.STRING);
    query.addScalar("cdVersion", Hibernate.INTEGER);
    query.addScalar("txtQuesHelp", Hibernate.STRING);
    query.addScalar("txtQuestionNum", Hibernate.STRING);
    query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
    query.setInteger("maxVersion", maxVersion);
    query.setString("cdSurveyCode", cdSurveyCode);
    query.setString("cdSurveyType", cdSurveyType);
    query.setString("cdSurveyQuestionType", cdSurveyQuestionType);
    return (List<Map<String, Object>>) query.list();
  }
  
  
  public CaseReview findCaseReviewByIdEvent(int idEvent) {
    Query query = getSession().createQuery(" from  CaseReview c " +
                                           " where c.idCsrEvent = :idEvent ");
    query.setInteger("idEvent", idEvent);
    return (CaseReview) firstResult(query);
  }
  
  @SuppressWarnings( { "unchecked" })
  public List<Map<String, Object>> findCaseReviewDetails(int idStage, int idEvent) {
    Query query = getSession().createQuery(
                                           "select new map (rq.idCaseReviewQuestion as idCaseReviewQuestion, "
                                                        + "  rq.cdQuestion as cdQuestion, "
                                                        + "  rq.cdVersion as cdVersion, "
                                                        + "  rq.cdQuesResponse as cdQuesResponse, "
                                                        + "  ri.idCaseReviewItem as idCaseReviewItem, "
                                                        + "  ri.cdItem as cdItem, "
                                                        + "  ri.txtComments as txtComments, "
                                                        + "  rc.idCaseReviewCateg as idCaseReviewCateg, "
                                                        + "  rc.cdCategory as cdCategory, "
                                                        + "  rql.txtQuestion as txtQuestion, "
                                                        + "  rql.nbrQuestionOrder as nbrQuestionOrder, "
                                                        + "  ril.txtItem as txtItem, "
                                                        + "  ril.nbrItemOrder as nbrItemOrder, "
                                                        + "  rcl.txtCategory as txtCategory, "
                                                        + "  rcl.nbrCategoryOrder as nbrCategoryOrder, "
                                                        + "  rql.indCbx as indCbx, " 
                                                        + "  rql.indQuestionType as indQuestionType, " 
                                                        + "  rql.txtQuesHelp as txtQuesHelp, "
                                                        + "  rql.txtQuestionNum as txtQuestionNum, "
                                                        + "  e.cdEventStatus as cdEventStatus) "
                                                        + "  from CaseReviewQuesResponse rq, "
                                                        + "  CaseReviewItem ri, "
                                                        + "  CaseReviewCateg rc, "
                                                        + "  CaseReview cr, "
                                                        + "  CaseReviewQuesLookup rql, "
                                                        + "  CaseReviewItemLookup ril, "
                                                        + "  CaseReviewCategLookup rcl, "
                                                        + "  Event e "
                                                        + "  where rq.caseReviewItem.idCaseReviewItem  = ri.idCaseReviewItem " 
                                                        + "  and rq.caseReviewCateg.idCaseReviewCateg = rc.idCaseReviewCateg " 
                                                        + "  and rq.event.idEvent = cr.idCsrEvent " 
                                                        + "  and rq.cdQuestion = rql.id.cdQuestion " 
                                                        + "  and rq.cdVersion = rql.id.cdVersion "
                                                        + "  and ri.cdItem = ril.cdItem " 
                                                        + "  and rc.cdCategory = rcl.cdCategory " 
                                                        + "  and rq.event.idEvent = e.idEvent " 
                                                        + "  and rq.stage.idStage = :idStage "
                                                        + "  and rq.event.idEvent = :idEvent "
                                                        + "  order by rcl.nbrCategoryOrder, "
                                                        + "  ril.nbrItemOrder, "
                                                        + "  rql.nbrQuestionOrder");
    query.setInteger("idStage", idStage);
    query.setInteger("idEvent", idEvent);

    return (List<Map<String, Object>>) query.list();
  }
    
  @SuppressWarnings( { "unchecked" })
  public List<Map<String, Object>> findCheckboxbyCdQuestionLookup(String cdQuestion, int cdVersion){
    Query query = getSession().createQuery("select new map (c.id.cdQuestion as cdQuestion, "
                                 +  " c.id.cdCbxQuestion as cdCbxQuestion, "   
                                 +  " c.txtCbxQuestion as txtCbxQuestion) " 
                                 +  " from CaseReviewCbxLookup c  "
                                 + " where c.id.cdQuestion = :cdQuestion "
                                 + " and c.id.cdVersion = :cdVersion ");
    
    query.setString("cdQuestion", cdQuestion);
    query.setInteger("cdVersion", cdVersion);
    return (List<Map<String, Object>>) query.list();
  }
  
  @SuppressWarnings( { "unchecked" })
  public List<Map<String, Object>> findCheckboxbyCdQuestion(String cdQuestion, int cdVersion, int idEvent){
    Query query = getSession().createQuery("select new map (c.cdQuestion as cdQuestion, "
                                 +  " cdCbxQuestion as cdCbxQuestion) "   
                                 +  " from CaseReviewCbxResponse c  "
                                 + " where c.cdQuestion = :cdQuestion "
                                 + "  and c.cdVersion = :cdVersion "
                                 + " and c.event.idEvent = :idEvent");
    
    query.setString("cdQuestion", cdQuestion);
    query.setInteger("cdVersion", cdVersion);
    query.setInteger("idEvent", idEvent);
    return (List<Map<String, Object>>) query.list();
  }
  
  public void saveCaseReview(CaseReview caseReview) {
    getSession().saveOrUpdate(caseReview);
  }
  
  public int saveCaseReviewCateg(CaseReviewCateg caseReviewCateg){
    getSession().saveOrUpdate(caseReviewCateg);
    return caseReviewCateg.getIdCaseReviewCateg();
  }
  
  public int saveCaseReviewItem(CaseReviewItem caseReviewItem){
    getSession().saveOrUpdate(caseReviewItem);
    return caseReviewItem.getIdCaseReviewItem();
  }
  
  public void saveCaseReviewQuestions(CaseReviewQuesResponse caseReviewQuesResponse){
    getSession().saveOrUpdate(caseReviewQuesResponse);
  }
  
  public void saveCaseReviewCbxResponse(CaseReviewCbxResponse caseReviewCbxResponse){
    getSession().saveOrUpdate(caseReviewCbxResponse);
  }
  
  public int updateCaseReviewCateg(String cdCategory, int idCaseReviewCateg) {
    Query query = getSession().createQuery("update CaseReviewCateg c "
                                           + " set c.cdCategory = :cdCategory "
                                           + " where c.idCaseReviewCateg = :idCaseReviewCateg ");
    query.setString("cdCategory", cdCategory);
    query.setInteger("idCaseReviewCateg", idCaseReviewCateg);
    query.executeUpdate();
    return idCaseReviewCateg;
  }
  
  public int updateCaseReviewItem(String txtComments, int idCaseReviewItem) {
    Query query = getSession().createQuery("update CaseReviewItem c "
                                           + " set c.txtComments = :txtComments "
                                           + " where c.idCaseReviewItem = :idCaseReviewItem ");
    query.setString("txtComments", txtComments);
    query.setInteger("idCaseReviewItem", idCaseReviewItem);
    query.executeUpdate();
    return idCaseReviewItem;
  }
  
  public void updateCaseReviewQuestion(String cdQuesResponse, int idCaseReviewQuestion) {
    Query query = getSession().createQuery("update CaseReviewQuesResponse c "
                                           + " set c.cdQuesResponse = :cdQuesResponse "
                                           + " where c.idCaseReviewQuestion = :idCaseReviewQuestion ");
    query.setString("cdQuesResponse", cdQuesResponse);
    query.setInteger("idCaseReviewQuestion", idCaseReviewQuestion);
    query.executeUpdate();
  }
    
  public void deleteCaseReviewChkBxByCdQuestion(String cdQuestion, int cdVersion, int idEvent) {
    Query query = getSession().createQuery(
                                           " delete from CaseReviewCbxResponse cbx "
                                                           + " where cbx.cdQuestion = :cdQuestion "
                                                           +"  and cbx.cdVersion = :cdVersion "
                                                           + " and cbx.event.idEvent = :idEvent");
    query.setString("cdQuestion", cdQuestion);
    query.setInteger("cdVersion", cdVersion);
    query.setInteger("idEvent", idEvent);
    query.executeUpdate();
  }
  

  
  public int deleteCaseReviewByIdEvent(int idEvent) {
    Query query = getSession().createQuery("delete from CaseReview c " +
                                           "       where c.idCsrEvent = :idEvent");
    query.setInteger("idEvent", idEvent);
    return query.executeUpdate();
  }
  
  public int deleteCaseReviewCategByIdEvent(int idEvent) {
    Query query = getSession().createQuery("delete from CaseReviewCateg c " +
                                           "       where c.event.idEvent = :idEvent");
    query.setInteger("idEvent", idEvent);
    return query.executeUpdate();
  }
  
  public int deleteCaseReviewItemByIdEvent(int idEvent) {
    Query query = getSession().createQuery("delete from CaseReviewItem c " +
                                           "       where c.event.idEvent = :idEvent");
    query.setInteger("idEvent", idEvent);
    return query.executeUpdate();
  }
  
  public int deleteCaseReviewQuesResponseByIdEvent(int idEvent) {
    Query query = getSession().createQuery("delete from CaseReviewQuesResponse c " +
                                           "       where c.event.idEvent = :idEvent");
    query.setInteger("idEvent", idEvent);
    return query.executeUpdate();
  }
  
  public int deleteCaseReviewCbxResponseByIdEvent(int idEvent) {
    Query query = getSession().createQuery("delete from CaseReviewCbxResponse c " +
                                           "       where c.event.idEvent = :idEvent");
    query.setInteger("idEvent", idEvent);
    return query.executeUpdate();
  }
  
}
