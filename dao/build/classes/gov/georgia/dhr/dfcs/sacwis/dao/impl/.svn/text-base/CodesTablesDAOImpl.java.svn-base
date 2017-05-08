package gov.georgia.dhr.dfcs.sacwis.dao.impl;

/**
 * Created on July 15, 2008 by Vishala Devarakonda
 */

import gov.georgia.dhr.dfcs.sacwis.dao.CodesTablesDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.db.CodesTablesId;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;

/**
 * This is the DAO class used to implement the save and retrieve methods to save and retrieve data from CodesTables
 * table
 */

public class CodesTablesDAOImpl extends BaseDAOImpl implements CodesTablesDAO {

  @SuppressWarnings("rawtypes")
  public Map findCodesTableDetail(String codeType, String code) {

    Query query = getSession().createQuery(
                                           "select new map (c.id.code as code, " + " c.decode as decode, "
                                                           + " c.dtEnd as dtEnd) " + " from CodesTables c "
                                                           + " where c.id.codeType = :codeType"
                                                           + " and c.id.code = :code");
    query.setString("codeType", codeType);
    query.setString("code", code);
    return (Map) query.uniqueResult();
  }
  
  @SuppressWarnings("rawtypes")
  public Map findCodesTableDetailByCodeTypeCodeIgnoreCase(String codeType, String code) {

    Query query = getSession().createQuery(
                                           "select new map (c.id.code as code, " + " c.decode as decode, "
                                                           + " c.dtEnd as dtEnd) " + " from CodesTables c "
                                                           + " where c.id.codeType = :codeType"
                                                           + " and upper(c.id.code) = :code");
    query.setString("codeType", codeType);
    query.setString("code", code.toUpperCase());
    return (Map) query.uniqueResult();
  }

  @SuppressWarnings( { "unchecked" })
  public List<String> findCodesList(String codeType) {
    Query query = getSession().createQuery(" select c.id.code from CodesTables c " 
                                           + "where c.id.codeType = :codeType ");
    query.setString("codeType", codeType);
    return (List<String>) query.list();
  }
  
  @SuppressWarnings( { "unchecked" })
  public List<String> findCodesUpperCaseList(String codeType) {
    Query query = getSession().createQuery(" select upper(c.id.code) from CodesTables c " 
                                           + "where c.id.codeType = :codeType ");
    query.setString("codeType", codeType);
    return (List<String>) query.list();
  }
  
  @SuppressWarnings("unchecked")
  public List<CodesTablesId> findCodesIdsByCodeType(Collection<String> codeTypes) {
    Query query = getSession().createQuery(" select c.id from CodesTables c " 
                                           + "where c.id.codeType in (:codeTypes) ");
    query.setParameterList("codeTypes", codeTypes);
    return (List<CodesTablesId>) query.list();
  }
  
  public CodesTables findCodesTablesById(CodesTablesId id) {
    Query query = getSession().createQuery(" from CodesTables c " 
                                           + "where c.id.code = :code " +
                                           		" and c.id.codeType = :codeType");
    query.setString("code", id.getCode());
    query.setString("codeType", id.getCodeType());
    return (CodesTables) firstResult(query);
  }

  public CodesTablesId saveCodeDetail(CodesTables codesTables) {
    getSession().saveOrUpdate(codesTables);
    return codesTables.getId();
  }

  public int updateCodeDetail(String codeType, String code, String decode) {
    Query query = getSession().createQuery(
                                           "update CodesTables c " + "   set c.decode = :decode "
                                                           + " where c.id.codeType = :codeType "
                                                           + "   and c.id.code = :code");
    query.setString("decode", decode);
    query.setString("codeType", codeType);
    query.setString("code", code);
    return query.executeUpdate();
  }

  public int updateCodeDetail(String codeType, String code, String decode, Date dtEnd) {
    Query query = getSession().createQuery(
                                           "update CodesTables c " + "   set c.decode = :decode, "
                                                           + "   c.dtEnd = :dtEnd "
                                                           + " where c.id.codeType = :codeType "
                                                           + "   and c.id.code = :code");
    query.setString("decode", decode);
    query.setString("codeType", codeType);
    query.setString("code", code);
    query.setDate("dtEnd", dtEnd);
    return query.executeUpdate();
  }
  
  public int updateCodeDetailDtEnd(String codeType, String code, Date dtEnd) {
    Query query = getSession().createQuery(
                                           "update CodesTables c " + "   set c.dtEnd = :dtEnd "
                                                           + " where c.id.codeType = :codeType "
                                                           + "   and c.id.code = :code");
    query.setString("codeType", codeType);
    query.setString("code", code);
    query.setDate("dtEnd", dtEnd);
    return query.executeUpdate();
  }
  
  public void deleteCodeDetail(CodesTables codesTables) {
      getSession().delete(codesTables);
  }
  
  public int deleteCodeDetailByCodeTypeCode(String codeType, String code) {
    Query query = getSession().createQuery(
                                           "delete CodesTables c " 
                                                           + " where c.id.codeType = :codeType "
                                                           + "   and c.id.code = :code");
    query.setString("codeType", codeType);
    query.setString("code", code);
    return query.executeUpdate();
  }
}