package gov.georgia.dhr.dfcs.sacwis.service.resource;

import org.exolab.castor.types.Date;
import org.grnds.facility.log.GrndsTrace;
import gov.georgia.dhr.dfcs.sacwis.core.base.BaseServiceEjb;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.RuntimeWrappedException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.TooManyRowsReturnedException;
import gov.georgia.dhr.dfcs.sacwis.core.jdbchelper.JdbcHelper;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginationResultBean;
import gov.georgia.dhr.dfcs.sacwis.dao.fad.FAChildSearchBean;
import gov.georgia.dhr.dfcs.sacwis.dao.fad.FAHomeListDao;
import gov.georgia.dhr.dfcs.sacwis.dao.fad.FAHomeValueBean;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 * Used to handle FAHomes
 *  Change History:
 *  Date        User              Description
 *  --------    ----------------  --------------------------------------------------
 *  11/03/11    htvo              STGAP00017477, STGAP00017483, STGAP00017466: map child's characteristic to home search characteristic codes
 *                                STGAP00017485: corrected mapping of child's Adoption Dissolution indicator to home search characteristic
 *                                
 *
 */
public class FAHomeListBean extends BaseServiceEjb {
  public static final String TRACE_TAG = "FAHomeListBean";
    
  /* Retrieve the FAHomes  */
  public PaginationResultBean getFAHomeList(FAHomeValueBean searchBean) throws TooManyRowsReturnedException {
    GrndsTrace.enterScope(TRACE_TAG + ".getFAHomeList function");
    Connection connection = null;

    try {
      connection = JdbcHelper.getConnection();

      FAHomeListDao faHomeListDao = new FAHomeListDao(connection);
      return faHomeListDao.getFAHomeList(searchBean);
    } catch (TooManyRowsReturnedException t) {
      throw t;
    } catch (Exception e) {
      throw new RuntimeWrappedException(e);
    } finally {
      cleanup(connection);
      GrndsTrace.exitScope();
    }
  }
  
  public FAChildSearchBean getChildInformation(Integer idPerson) throws TooManyRowsReturnedException{
	    Connection connection = null;
	  
	  try {
		  
		  connection = JdbcHelper.getConnection();
	  FAChildSearchBean faChildSearchBean = new FAChildSearchBean();
	  FAHomeListDao faHomeListDao = new FAHomeListDao(connection);
	  List<String> charaList = new ArrayList<String>();
	  List<String> races = new ArrayList<String>();
	  faChildSearchBean = faHomeListDao.getFAChildSearch(idPerson);
	  charaList = faHomeListDao.getFAChildChara(idPerson);
	   String indPrevAdopted =  faChildSearchBean.getIndPrevAdopt();
	   String indAdptDis = faChildSearchBean.getIndAdptDis();
	  if(ArchitectureConstants.Y.equals(indPrevAdopted)){
		  charaList.add(CodesTables.CLNCHAR2_02);
	  }
	  // STGAP00017485: map child's Adoption Dissolution indicator to home search characteristic
	  if(ArchitectureConstants.Y.equals(indAdptDis)){
		  charaList.add(CodesTables.OTH2_81);
	  }
	  if(charaList.contains("202")){
		  charaList.add(CodesTables.CLNCHAR2_303);
	  }
	  // STGAP00017477, STGAP00017483, STGAP00017466: map child's characteristic to home search characteristic codes 
	  if (charaList.contains(CodesTables.CME_3)) { // ADD/ADHD
	    charaList.add(CodesTables.EBD2_03);
	  }
          if (charaList.contains(CodesTables.CME_7)) { // Autism
            charaList.add(CodesTables.EBD2_07);
          }
          if (charaList.contains(CodesTables.CHB_8)) { // Animal Cruelty
            charaList.add(CodesTables.EXB2_08);
          }
	  
	 String ethnicity = faHomeListDao.getFAChildEthnicity(idPerson);
	 faChildSearchBean.setEthnicity(ethnicity);
	  
	  
	  races = faHomeListDao.getFAChildRaces(idPerson);
	  faChildSearchBean.setRaces(races);
	  
	  String gender = faChildSearchBean.getGender();
	  faChildSearchBean.setGender(gender);
	  
	  faChildSearchBean.setResourceCharacteristics(charaList);
	  
	  return faChildSearchBean;
  	
	  }catch (TooManyRowsReturnedException t) {
	      throw t;
	    }catch (ServiceException se) {
		      throw  se;
	    } catch (Exception e) {
	      throw new RuntimeWrappedException(e);
	    } finally {
	      cleanup(connection);
	      GrndsTrace.exitScope();
	    }
	  }
	  
  
}
