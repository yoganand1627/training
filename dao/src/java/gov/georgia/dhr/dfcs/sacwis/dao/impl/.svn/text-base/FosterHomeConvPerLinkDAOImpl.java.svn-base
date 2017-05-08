package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import gov.georgia.dhr.dfcs.sacwis.dao.FosterHomeConvPerLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.FosterHomeConv;
import gov.georgia.dhr.dfcs.sacwis.db.FosterHomeConvPerLink;

public class FosterHomeConvPerLinkDAOImpl extends BaseDAOImpl implements FosterHomeConvPerLinkDAO {

  @SuppressWarnings( { "unchecked" })
  public int insertFosterHomeConvPerLink(int idFosterHomeConv, int idPerson){
    Session session = getSession();
    FosterHomeConvPerLink f = new FosterHomeConvPerLink((FosterHomeConv) session.load(FosterHomeConv.class, idFosterHomeConv), 
                                                        Integer.valueOf(idPerson)); 
    
    session.saveOrUpdate(f);
    return 1;
  }

  @SuppressWarnings( { "unchecked" })
  public List<Integer> findPersonsByIdFosterHomeConvEvent(int idEvent) {
    Query query = getSession().createQuery("select l.idPerson " +
                                           "from FosterHomeConvPerLink l " +
    		                           "where l.fosterHomeConv.idEvent = :idEvent");
    
    query.setInteger("idEvent", idEvent);
    
    return (List<Integer>)query.list();
  }
  
  public FosterHomeConvPerLink findFosterComeConvPerLinkByIdPersonIdEvent(int idPerson, int idEvent) {
  
    Query query = getSession().createQuery(" from FosterHomeConvPerLink l " +
    		                           "where l.idPerson = :idPerson and l.fosterHomeConv.idEvent = :idEvent");

    query.setInteger("idPerson", idPerson);
    query.setInteger("idEvent", idEvent);
    
    return (FosterHomeConvPerLink) firstResult(query);
  }
  
  @SuppressWarnings( { "unchecked" })
  public List<FosterHomeConvPerLink> findFosterHomeConvPerLinksByIdEvent(int idEvent) {
    Query query = getSession().createQuery(" from FosterHomeConvPerLink l " +
    		                           "where l.fosterHomeConv.idEvent = :idEvent");
    
    query.setInteger("idEvent", idEvent);
    
    return (List<FosterHomeConvPerLink>)query.list();
  }
  
  public int deleteFosterHomeConvPerLinkByIdFosterHomeConvPerLink(int idFosterHomeConvPerLink) {
    Query query = getSession().createQuery("delete from FosterHomeConvPerLink " +
                                           "where idFosterHomeConvPerLink = :idFosterHomeConvPerLink");
    
    query.setInteger("idFosterHomeConvPerLink", idFosterHomeConvPerLink);
    
    return query.executeUpdate();
  }
  public void saveFosterHomeConvPerLink(FosterHomeConvPerLink fosterHomeConvPerLink) {

    getSession().saveOrUpdate(fosterHomeConvPerLink);

  }
  
  public int saveFosterHomeConvPerLinkReturnId(FosterHomeConvPerLink fosterHomeConvPerLink) {
    
    getSession().saveOrUpdate(fosterHomeConvPerLink);
    return fosterHomeConvPerLink.getIdFosterHomeConvPerLink();

  }


}
