package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.dao.FosterHomeConvDAO;
import gov.georgia.dhr.dfcs.sacwis.db.FosterHomeConv;

import java.util.Date;

import org.hibernate.Query;


/*Change History:
Date      User      Description
--------  --------  --------------------------------------------------
07/24/09   mxpatel   STGAP00014202: wrote the method findActiveFosterHomeConvByIdResource to find out if
                     a resource has any approved, active foster home conversion event
08/21/09   cwells    STGAP00014796: wrote method  findFosterHomeConvByIdPersonIdResource() so we can find the home 
                     conversion with just the id resource and id person.                    
*/


public class FosterHomeConvDAOImpl extends BaseDAOImpl implements FosterHomeConvDAO {

  public FosterHomeConv findFosterHomeConvDetailsByIdEvent(int idEvent) {
    Query query = getSession().createQuery(
                                           "    from FosterHomeConv f " + "   where f.event.idEvent = :idEvent");

    query.setInteger("idEvent", idEvent);
    return (FosterHomeConv) firstResult(query);
    
  }
  public void saveFosterHomeConvDetails(FosterHomeConv fosterHomeConv) {
    
    getSession().saveOrUpdate(fosterHomeConv);

  }

  
  /** 
   * Retrieves a foster home conversion with the givent resource id, person id and inquiry
   * date.
   * 
   * @param int idResource
   * @param int idPerson
   * @param Date dtInquiry
   * 
   * @return FosterHomeConv
   */
  public Integer findFosterHomeConvByIdPersonIdResource(int idResource, int idPerson){
	   Query query = getSession().createQuery(
			   "   select f.event.idEvent " +
               "   from FosterHomeConv f, FosterHomeConvPerLink fp " + 
               "   where f.event = fp.fosterHomeConv.event " +
               "   and f.capsResourceByIdResource.idResource = :idResource"+
               "   and fp.idPerson = :idPerson "
	   
	   );
	   query.setInteger("idResource", idResource);
	   query.setInteger("idPerson", idPerson);
	   return (Integer) firstResult(query);
	  
  }
  
  
  /** 
   * Retrieves a foster home conversion with the givent resource id, person id and inquiry
   * date.
   * 
   * @param int idResource
   * @param int idPerson
   * @param Date dtInquiry
   * 
   * @return FosterHomeConv
   */
  public FosterHomeConv findFosterHomeConvByIdPersonIdResourceAndInquiryDate(int idResource, int idPerson, 
		  Date dtInquiry){
	   Query query = getSession().createQuery(
               "   from FosterHomeConv f, FosterHomeConvPerLink fp " + 
               "   where f.event = fp.fosterHomeConv.event " +
               "   and f.dtInquiry = :dtInquiry "+
               "   and f.capsResourceByIdResource.idResource = :idResource"+
               "   and fp.idPerson = :idPerson "
	   
	   );

	   query.setInteger("idResource", idResource);
	   query.setInteger("idPerson", idPerson);
	   query.setDate("dtInquiry", dtInquiry);
	   return (FosterHomeConv) firstResult(query);
	  
  }
  
  public FosterHomeConv findFosterHomeConvByIdResource(int idResource) {
    Query query = getSession().createQuery(
                                           "    from FosterHomeConv f " + 
                                           "   where f.capsResourceByIdResource.idResource = :idResource " +
                                           "   and f.event.cdEventStatus = :cdEventStatus " +
                                           "   order by dtApproval desc, f.dtClosure desc");

    query.setInteger("idResource", idResource);
    query.setString("cdEventStatus", CodesTables.CEVTSTAT_APRV);
    return (FosterHomeConv) firstResult(query);
    
  }
  
  //mxpatel STGAP00014202
  //find out if a resource has an active, approved foster home conversion event
  public FosterHomeConv findActiveFosterHomeConvByIdResource(int idResource) {
    Query query = getSession().createQuery(
                                           "    from FosterHomeConv f "
                                                           + "   where f.capsResourceByIdResource.idResource = :idResource "
                                                           + "   and f.event.cdEventStatus = :cdEventStatus "
                                                           + " and ( f.dtClosure is null or f.dtClosure > sysdate) "
                                                           + "   order by f.dtApproval desc, f.dtClosure desc");

    query.setInteger("idResource", idResource);
    query.setString("cdEventStatus", CodesTables.CEVTSTAT_APRV);
    return (FosterHomeConv) firstResult(query);
    
  }
  
  public int updateFosterHomeConvDtInquiry(Date dtInquiry, int idEvent) {
	    Query query = getSession().createQuery("update FosterHomeConv f " +
	                                           "   set f.dtInquiry = :dtInquiry " +
	                                           " where f.event.idEvent= :idEvent ");
	    query.setInteger("idEvent", idEvent);
	    query.setDate("dtInquiry", dtInquiry);
	    return query.executeUpdate();
	  }
  
  public int updateFosterHomeConv(int idEvent, String cdConvAppStatus, Date dtApproval) {
    Query query = getSession().createQuery("update FosterHomeConv f " +
                                           "   set f.cdConvAppStatus = :cdConvAppStatus, " +
                                           "  f.dtApproval = :dtApproval " +
                                           " where f.event.idEvent= :idEvent ");
    query.setInteger("idEvent", idEvent);
    query.setString("cdConvAppStatus", cdConvAppStatus);
    query.setTimestamp("dtApproval", dtApproval);
    return query.executeUpdate();
  }
}
