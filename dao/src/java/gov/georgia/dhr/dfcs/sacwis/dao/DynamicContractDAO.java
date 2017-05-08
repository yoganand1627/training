/**
 * Created on May 21, 2006 at 3:29:52 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;

import java.util.Date;
import java.util.List;

public interface DynamicContractDAO {
  /**
   * This retreieves Paginated contract information using the given criteria. No parameters are required. Use zero's and nulls for
   * parameters that are not used. <p/> It returns a list of object arrays with the following:
   * 
   * <pre>
   *  int ulIdContract = COONTRACT.ID_CONTRACT = row[0]
   *  String szCdCntrctRegion = COONTRACT.CD_CNTRCT_REGION = row[1]
   *  String szCdCntrctFuncType = COONTRACT.CD_CNTRCT_FUNC_TYPE = row[2]
   *  *** String szCdCntrctProgramType = COONTRACT.CD_CNTRCT_PROGRAM_TYPE = row[3]Replaced by szCdCntrctCounty
   *  String szCdCntrctCounty = COONTRACT.CD_CNTRCT_PROGRAM_TYPE = row[3]
   *  String sIndCntrctBudgLimit COONTRACT.IND_CNTRCT_BUDG_LIMIT = row[4]
   *  int ulIdresource = COONTRACT.ID_RESOURCE = row[5]
   *  String szNmResource CAPS_RESOURCE.NM_RESOURCE = row[6]
   *  int ulIdContract = COONTRACT.ID_RSRC_ADDRESS = row[7]
   *  String szNmPersonFull = PERSON.NM_PERSON_FULL = row[8]
   *  String nbrRsrcAddrVid = RESOURCE_ADDRESS.NBR_RSRC_ADDR_VID = row[9]
   * </pre>
   * 
   * @param idContract
   * @param cdCntrctProgramType //
   *          Always CPS for R2
   * @param cdCntrctRegion
   * @param idResource
   * @param cdCntrctFuncType
   * @param dtCnperStart
   * @param dtCnperTerm
   * @param indCntrctBudgLimit
   * @param cdCntrctCounty
   *          //Added for R2
   * @return See description.
   * STGAP00005892: Contract Search: Pagination not working ei 1/17/08
   */
  PaginatedHibernateList<Object[]> findContracts(int idContract, String cdCntrctProgramType, String cdCntrctCounty,
                               String cdCntrctRegion, int idResource, String cdCntrctFuncType, Date dtCnperStart,
                               Date dtCnperTerm, String indCntrctBudgLimit,int pageNbr, int pageSize);
  /**  
   * This retrieves count of the conties on a single contract for use of display
   * @param idContract
   * @param cdCntrctProgramType //
   *          Always CPS for R2
   * @param cdCntrctRegion
   * @param idResource
   * @param cdCntrctFuncType
   * @param dtCnperStart
   * @param dtCnperTerm
   * @param indCntrctBudgLimit
   * @param cdCntrctCounty
   *          //Added for R2
   * @return See description.
   **/
  List<Object[]> findCounts(int idContract, String cdCntrctProgramType, String cdCntrctCounty,
                                   String cdCntrctRegion, int idResource, String cdCntrctFuncType,
                                   Date dtCnperStart, Date dtCnperTerm, String indCntrctBudgLimit);
  
}
