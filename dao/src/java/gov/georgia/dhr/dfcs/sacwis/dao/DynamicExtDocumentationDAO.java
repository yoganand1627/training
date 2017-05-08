package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;

import java.util.Date;
import java.util.List;

public interface DynamicExtDocumentationDAO {
	  /**
	   * This retrieves External Documentation information using the given criteria.  idCase is required.  All other
	   * parameters are optional.  Use zero's and nulls for parameters that are not used.
	   * <p/>
	   * It returns a list of object arrays with the following:
	   * <pre>
	   * String szCdExtDocSort = ExtDocumentation.cdExtDocSort = row[0]
	   * Date dtDtExtDocObtained = ExtDocumentation.dtExtDocObtained = row[1]
	   * String szCdDocClass = ExtDocumentation.cdDocClass = row[2]
	   * String szCdExtDocType = ExtDocumentation.cdExtDocType = row[3]
	   * String szTxtExtDocLocation = ExtDocumentation.txtExtDocLocation row[4]
	   * String szTxtExtDocDetails = ExtDocumentation.txtExtDocDetails = row[5]
	   * </pre>
	   *
	   * @param idCase
	   * @param cdExtDocSort
	   * @param cdExtDocType
	   * @param List<String> docTypeList
	   * @param cdDocClass
	   * @param txtExtDocLocation
	   * @param dtScrSearchDateFrom
	   * @param dtScrSearchDateTo
	   * @param List<Integer> personIds
	   * @param List<Integer> sealedPersonIds
	   * @param sortBy
	   * @return See description.
	   */
	  
	  List<Object[]> findExtDocumentations(int idCase, String cdExtDocSort,
	                              List<String> docTypeList, 
	                              String txtExtDocLocation,Date dtScrSearchDateFrom, 
	                              Date dtScrSearchDateTo, List<Integer> personIds,List<Integer> sealedPersonIds, String sortBy, String indICPCDocument);
	  
	  /**
	   * Exactly the same as its predecessor find External Documentation, only implementing pagination on the criteria.
	   * 
	   * @param idCase
	   * @param cdExtDocSort
	   * @param cdExtDocType
	   * @param List<String> docTypeList
	   * @param cdDocClass
	   * @param List<String> docClassList
	   * @param txtExtDocLocation
	   * @param dtScrSearchDateFrom
	   * @param dtScrSearchDateTo
	   * @param List<Integer> personIds
	   * @param List<Integer> sealedPersonIds
	   * @param sortBy
	   * @param pageNbr
	   * @param pageSize
	   * @return
	   */
	//STGAP00014326 MR-024 Modified to accept List<String> cdPurposeList instead of cdContactPurpose
	//STGAP00017827 MR-085 Modified to add new parameter to filter for ICPC Documents  
	  PaginatedHibernateList<Object[]> findExtDocumentationsPaginated(int idCase, String cdExtDocSort, 
              												List<String> docTypeList,
              												String txtExtDocLocation,Date dtScrSearchDateFrom, 
              												Date dtScrSearchDateTo, List<Integer> personIds,List<Integer> sealedPersonIds,
              												String sortBy, String indICPCDocument, int pageNbr, int pageSize);
}
