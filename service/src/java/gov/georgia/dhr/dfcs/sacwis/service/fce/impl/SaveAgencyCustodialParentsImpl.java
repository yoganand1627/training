/**
 * Created on May 07, 2007 by Kapil Aggarwal - SACWIS Atlanta
 */
package gov.georgia.dhr.dfcs.sacwis.service.fce.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.AgencyCustodialParentsDAO;
import gov.georgia.dhr.dfcs.sacwis.db.AgencyCustodialParents;
import gov.georgia.dhr.dfcs.sacwis.service.fce.SaveAgencyCustodialParents;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.AgencyCustodialParentsSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.AgencyCustodialParentsSO;

public class SaveAgencyCustodialParentsImpl extends BaseServiceImpl implements SaveAgencyCustodialParents {

  private AgencyCustodialParentsDAO agencyCustodialParentsDAO = null;
  
  public void setAgencyCustodialParentsDAO(AgencyCustodialParentsDAO agencyCustodialParentsDAO) {
    this.agencyCustodialParentsDAO = agencyCustodialParentsDAO;
  }

  
  /* (non-Javadoc)
   * @see gov.georgia.dhr.dfcs.sacwis.service.fce.SaveChildSupportReferralOutbound#saveChildSupportReferral(gov.georgia.dhr.dfcs.sacwis.structs.input.CSupRefOutboundSI)
   */
  public AgencyCustodialParentsSO saveAgencyCustodialParents(AgencyCustodialParentsSI agencyCustodialParentsSI) {
    
    AgencyCustodialParents custodialParents = new AgencyCustodialParents();
    custodialParents.setCdCounty(agencyCustodialParentsSI.getCdCounty());
    custodialParents.setNmPersonLast(agencyCustodialParentsSI.getNmPersonLast());
    custodialParents.setNmPersonFirst(agencyCustodialParentsSI.getNmPersonFirst());
    custodialParents.setNmPersonMiddle(agencyCustodialParentsSI.getNmPersonMiddle());
    custodialParents.setCdPersonSex(agencyCustodialParentsSI.getCdPersonSex());
    custodialParents.setCdEthnicity(agencyCustodialParentsSI.getCdEthnicity());
    custodialParents.setCdRace(agencyCustodialParentsSI.getCdRace());
    custodialParents.setNbrCrsId(agencyCustodialParentsSI.getNbrCrsId());
    custodialParents.setNbrNcpCrsId(agencyCustodialParentsSI.getNbrNcpCrsId());
    
    int tmp = agencyCustodialParentsDAO.saveAgencyCustodialParents(custodialParents);
    AgencyCustodialParentsSO agencyCustodialParentsSO = new AgencyCustodialParentsSO();
    agencyCustodialParentsSO.setIdAgencyCustodialParents(tmp);
    return agencyCustodialParentsSO;
  }

}
