package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.CompAlgDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CompAlg;

import java.util.List;

import org.hibernate.Query;

public class CompAlgDAOImpl extends BaseDAOImpl implements CompAlgDAO {

  @SuppressWarnings({"unchecked"})
  public List<CompAlg> retrievesCompAlgsByComplaintId(String complaintId) {
    Query query = getSession().createQuery("  from  CompAlg where intakeid =:complaintId");

    query.setString("complaintId", complaintId);
    
    return (List<CompAlg>)query.list();
  }

}
