/**
 * Created on July 15, 2008 by Vishala Devarakonda
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.db.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.db.CodesTablesId;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * This is the DAO interface used to define the save and retrieve methods to save and retrieve data from CodesTables
 * table
 */
public interface CodesTablesDAO {

  /**
   * @param codeType
   * @param code
   * @return Map
   */
  @SuppressWarnings("rawtypes")
  Map findCodesTableDetail(String codeType, String code);
  /**
   * 
   * @param codeType
   * @param code
   * @return
   */
  @SuppressWarnings("rawtypes")
  Map findCodesTableDetailByCodeTypeCodeIgnoreCase(String codeType, String code);

  /**
   * @param codeType
   * @return List<String>
   */  
  List<String> findCodesList(String codeType);
  
  /**
   * 
   * @param codeType
   * @return code list in upper case
   */
  public List<String> findCodesUpperCaseList(String codeType);
  
  /**
   * 
   * @param codeTypes
   * @return
   */
  public List<CodesTablesId> findCodesIdsByCodeType(Collection<String> codeTypes);
  
  /**
   * 
   * @param id
   * @return
   */
  public CodesTables findCodesTablesById(CodesTablesId id);
  /**
   * @param codesTables
   * @return codesTablesId.
   */
  public CodesTablesId saveCodeDetail(CodesTables codesTables);

  /**
   * @param codeType
   * @param code
   * @param decode
   * @return int
   */
  public int updateCodeDetail(String codeType, String code, String decode);
  
  /**
   * 
   * @param codeType
   * @param code
   * @param dtEnd
   * @return
   */
  public int updateCodeDetailDtEnd(String codeType, String code, Date dtEnd);

  /**
   * @param codeType
   * @param code
   * @param decode
   * @param dtEnd
   * @return int
   */
  public int updateCodeDetail(String codeType, String code, String decode, Date dtEnd);
  
  /**
   * 
   * @param codesTables
   */
  public void deleteCodeDetail(CodesTables codesTables);
  
  /**
   * delete code table by code type and code key combination
   * @param codeType
   * @param code
   * @return
   */
  public int deleteCodeDetailByCodeTypeCode(String codeType, String code);
}
