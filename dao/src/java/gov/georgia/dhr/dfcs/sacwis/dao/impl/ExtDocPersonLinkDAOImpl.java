/**
 * 
 */
package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.List;


import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.dao.ExtDocPersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.ExtDocPersonLink;
import gov.georgia.dhr.dfcs.sacwis.db.ExtDocumentation;

import org.hibernate.Query;

/**
 * @author ekemini.s.udofiah
 *
 */
public class ExtDocPersonLinkDAOImpl extends BaseDAOImpl implements ExtDocPersonLinkDAO {
	
	@SuppressWarnings( { "unchecked" })
	public  List<Integer> findPersonCheckedByIdExtDocumentation(int idExtDoumentation) {
	    Query query = getSession().createQuery(" select cpc.personByIdPerson.idPerson   " +
	                                           " from ExtDocPersonLink cpc " +
	                                           " where cpc.extDocumentation.idExtDocumentation = :idExtDoumentation"); 
	    query.setInteger("idExtDoumentation", idExtDoumentation);
	    return  (List<Integer>) query.list();
	  }
	
	@SuppressWarnings( { "unchecked" })
	public int deleteExtDocPersonLinkByPerson(int idPerson) {
	    Query query = getSession().createQuery(" delete from ExtDocPersonLink cpc " +
	                                           " where  cpc.idExtDocPersonLink = :idPerson");
	    query.setInteger("idPerson", idPerson);
	    return query.executeUpdate();
	    
	  }
	@SuppressWarnings( { "unchecked" })
	public int deleteExtDocPersonLinkByIdExtDocumentation(int idExtDoumentation) {
	    Query query = getSession().createQuery(" delete from ExtDocPersonLink cpc " +
	                                           " where cpc.extDocumentation.idExtDocumentation = :idExtDoumentation");
	    query.setInteger("idExtDoumentation", idExtDoumentation);
	    return query.executeUpdate();
	    
	}
	
	public void saveOrUpdateExtDocPersonLinkByPerson(ExtDocPersonLink extDocPersonLink){
	      getSession().saveOrUpdate(extDocPersonLink);
	}
	
	public int updateExtDocPersonLinkForPersonMerge(int idForwardPerson, int idClosedPerson){
	    Query query = getSession().createQuery("update ExtDocPersonLink edpl " +
                "set edpl.personByIdPerson.idPerson = :idForwardPerson " +
                "where edpl.personByIdPerson.idPerson = :idClosedPerson");
	    query.setInteger("idForwardPerson", idForwardPerson);
	    query.setDouble("idClosedPerson", idClosedPerson);
	    return query.executeUpdate();
	}
}
