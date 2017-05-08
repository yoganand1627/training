package gov.georgia.dhr.dfcs.sacwis.service.common.impl;

/**
 * <pre>
 * Change History:
 * Date      User                     Description
 * --------  ----------------         ---------------------------------------------------------
 * 05/24/10  hjbaptiste               Initial creation
 * 
 * </pre>
 *
 * @author Herve Jean-Baptiste May 24, 2010
 */

import gov.georgia.dhr.dfcs.sacwis.dao.AllegationDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.IntakeAllegationDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Allegation;
import gov.georgia.dhr.dfcs.sacwis.db.IntakeAllegation;
import gov.georgia.dhr.dfcs.sacwis.service.common.CheckIfRemovalPriorToAllegIncident;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CheckIfRemovalPriorToAllegIncidentSI;

import java.util.Date;
import java.util.List;

public class CheckIfRemovalPriorToAllegIncidentImpl extends BaseServiceImpl implements
                                                                           CheckIfRemovalPriorToAllegIncident {

  private AllegationDAO allegationDAO = null;
  private IntakeAllegationDAO intakeAllegationDAO = null;
  
  public void setAllegationDAO(AllegationDAO allegationDAO) {
    this.allegationDAO = allegationDAO;
  }

  public void setIntakeAllegationDAO(IntakeAllegationDAO intakeAllegationDAO) {
    this.intakeAllegationDAO = intakeAllegationDAO;
  }


  public boolean checkIfRemovalPriorToAllegIncident(
                                                    CheckIfRemovalPriorToAllegIncidentSI checkIfRemovalPriorToAllegIncidentSI) {
    int idVictim = checkIfRemovalPriorToAllegIncidentSI.getIdVictim();
    Date dtRemoval = checkIfRemovalPriorToAllegIncidentSI.getDtRemoval();
    boolean removalPriorToAllegIncident = false;
    List<IntakeAllegation> intateAllegations = intakeAllegationDAO.findAllegationAfterRemovalByIdPersonAndDtRemoval(idVictim, dtRemoval);
    List<Allegation> allegations = allegationDAO.findAllegationAfterRemovalByIdPersonAndDtRemoval(idVictim, dtRemoval);
    
    if (intateAllegations != null && !intateAllegations.isEmpty()) {
      removalPriorToAllegIncident = true;
    }
    
    if (allegations != null && !allegations.isEmpty()) {
      removalPriorToAllegIncident = true;
    }
    
    return removalPriorToAllegIncident;
  }

}
