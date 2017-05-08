package gov.georgia.dhr.dfcs.sacwis.service.intake.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.IntakeAllegationDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PlacementDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Placement;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.intake.RetrieveAllegations;
import gov.georgia.dhr.dfcs.sacwis.structs.input.AllegRtrvRecIn;
import gov.georgia.dhr.dfcs.sacwis.structs.output.AllegRtrvRecOut;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT76DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT76DO_ARRAY;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class RetrieveAllegationsImpl extends BaseServiceImpl implements RetrieveAllegations {

  private IntakeAllegationDAO intakeAllegationDAO = null;
  private PlacementDAO placementDAO = null;
  
  public void setIntakeAllegationDAO(IntakeAllegationDAO intakeAllegationDAO) {
    this.intakeAllegationDAO = intakeAllegationDAO;
  }

  public void setPlacementDAO(PlacementDAO placementDAO) {
    this.placementDAO = placementDAO;
  }
  
  
  /**
   * This is cint30s
   *
   * @param AllegRtrvRecIn
   * @return A populated {@link AllegRtrvRecOut} object.
   * @throws ServiceException
   */
  public AllegRtrvRecOut retrieveAllegations(AllegRtrvRecIn allegRtrvRecIn) throws ServiceException {

    AllegRtrvRecOut allegRtrvRecOut = new AllegRtrvRecOut();

    // rc = cint76dQUERYdam(sqlca, pCINT76DInputRec, pCINT76DOutputRec);
    int idStage = allegRtrvRecIn.getUlIdStage();
    List<Map> listAllegs = intakeAllegationDAO.findIntakeAllegationsByIdStage(idStage);

    ROWCINT76DO_ARRAY row_array = new ROWCINT76DO_ARRAY();
    String indTrialHomeVisit = StringHelper.EMPTY_STRING;
    if (listAllegs != null) {
      
      for (Iterator<Map> it = listAllegs.iterator(); it.hasNext();) {
        Map map = it.next();

        ROWCINT76DO row = new ROWCINT76DO();

        row.setUlIdAllegation((Integer) map.get("idAllegation") != null ? (Integer) map.get("idAllegation") : 0);
        int idVictim = (Integer) map.get("personByIdVictim") != null ? (Integer) map.get("personByIdVictim") : 0;
        row.setUlIdVictim(idVictim);
        row.setUlIdAllegedPerpetrator((Integer) map.get("personByIdAllegedPerpetrator") != null ? (Integer) map.get(
                "personByIdAllegedPerpetrator") : 0);
        row.setCTxtIntakeAllegDuration((String) map.get("txtIntakeAllegDuration"));
        row.setSzCdIntakeAllegType((String) map.get("cdIntakeAllegType"));
        row.setSzCdAllegedMalLocation((String) map.get("cdAllegedMalLocation"));
        row.setSzCdIntakeAllegMalCode((String) map.get("cdAllegedMalCode"));
        row.setCIndIncmgMaltreatInCare((String) map.get("indMaltreatInCare")); 
        Date dtAllegedIncident = (Date) map.get("dtAllegedIncident");
        row.setDtDtAllegedIncident(DateHelper.toCastorDate(dtAllegedIncident));
        row.setSzCdMaltreatorRel((String) map.get("cdMaltreatorRel"));
        row.setSzScrPersVictim((String) map.get("nmPersVictim"));
        row.setSzScrAllegPerp((String) map.get("nmPersAllegPerp"));
        
        row_array.addROWCINT76DO(row);
        
        // Check to see if any of the children that are victims on the allegations are in a 'Trial Home Visit'.
        // If there are set the indicator because the Placement/Non-Placement Provider section is not required
        Placement trialHomeVisit = placementDAO.findTrialHomeVisitPlacementByIdPersonDtAllegIncident(idVictim, dtAllegedIncident);
        if (trialHomeVisit != null) {
          indTrialHomeVisit = ServiceConstants.FND_YES;
        }
      }
    }

    allegRtrvRecOut.setROWCINT76DO_ARRAY(row_array);
    allegRtrvRecOut.setCIndTrialHomeVisit(indTrialHomeVisit);

    return allegRtrvRecOut;
  }

}
