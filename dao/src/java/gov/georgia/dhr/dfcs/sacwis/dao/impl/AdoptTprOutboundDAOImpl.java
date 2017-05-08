package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.AdoptTprOutboundDAO;
import gov.georgia.dhr.dfcs.sacwis.db.AdoptTprOutbound;

public class AdoptTprOutboundDAOImpl extends BaseDAOImpl implements AdoptTprOutboundDAO{

  public void saveOrUpdateAdoptTprOutbound(AdoptTprOutbound adoptTpr){
    getSession().saveOrUpdate(adoptTpr);
  }
}
