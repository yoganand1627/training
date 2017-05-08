package gov.georgia.dhr.dfcs.sacwis.service.casemgmt.impl;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsResourceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PlacementDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Placement;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.RetrieveAPPLAPersonsConnected;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.APPLAPersonsConnectedRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.APPLAPersonsConnectedRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB25SOG02;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB25SOG02_ARRAY;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


/*Author: bgehlot
11/25/2009  41275 This Service returns the sorted list of the persons connected to the APPLA child
*/

/**
 * <pre>
 *   Change History:
 *   Date      User      Description
 *   --------  --------  -------------------------------------------------------------------------------
 *  03/25/08   bgehlot  SMS#43550 Added code to remove the duplication in the Person Connected Drop down
 *  
 */

public class RetrieveAPPLAPersonsConnectedImpl extends BaseServiceImpl implements RetrieveAPPLAPersonsConnected {
  private CapsResourceDAO capsResourceDAO = null;
  private PlacementDAO placementDAO = null;
  private StagePersonLinkDAO stagePersonLinkDAO = null;

  public void setCapsResourceDAO(CapsResourceDAO capsResourceDAO) {
    this.capsResourceDAO = capsResourceDAO;
  }

  public void setPlacementDAO(PlacementDAO placementDAO) {
    this.placementDAO = placementDAO;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public APPLAPersonsConnectedRetrieveSO retrievePersonsConnected(APPLAPersonsConnectedRetrieveSI APPLAPersonsConnectedRetrieveSI) throws ServiceException {
    APPLAPersonsConnectedRetrieveSO APPLAPersonsConnectedRetrieveSO = new APPLAPersonsConnectedRetrieveSO();
    int idStage = APPLAPersonsConnectedRetrieveSI.getIdStage();
    int idEvent = APPLAPersonsConnectedRetrieveSI.getIdEvent();
    //MR-057 Creating list of Person Connected for APPLA changes
    int idResource = APPLAPersonsConnectedRetrieveSI.getIdResource();
    CSUB25SOG02_ARRAY personConnectedList = populatePersonsConnected(idStage, idEvent, idResource);    
    APPLAPersonsConnectedRetrieveSO.setPersonConnectedList(personConnectedList);
    return APPLAPersonsConnectedRetrieveSO;    
  }

  /**
   * MR-057 This private method returns a list of principals and collaterals over 18 in the stage and the foster parents
   * 
   * @param idStage
   * @param idPlcmtEvent
   * @param idResource
   * @return CSUB25SOG02_ARRAY
   * @throws ServiceException
   */
  @SuppressWarnings( { "unchecked" })
  private CSUB25SOG02_ARRAY populatePersonsConnected(int idStage, int idPlcmtEvent, int idResourceFacil)throws ServiceException {
    CSUB25SOG02_ARRAY personConnectedList = new CSUB25SOG02_ARRAY();
    CSUB25SOG02_ARRAY personConnectedSortedList = new CSUB25SOG02_ARRAY();

    List<Map> personConnectedMapList = new ArrayList<Map>();

    //Get a list of principals and collaterals over 18 in the stage
    personConnectedMapList = stagePersonLinkDAO.findIdPersonAndNmPersonFullOver18FromStagePersonLinkAndPerson(idStage);
    if (personConnectedMapList != null && !personConnectedMapList.isEmpty()) {              
      for (Iterator<Map> newIt = personConnectedMapList.iterator(); newIt.hasNext();) {

        Map personConnectedMapNew = newIt.next();
        CSUB25SOG02 csub25sog02 = new CSUB25SOG02();

        csub25sog02.setUlIdPerson(((Integer)personConnectedMapNew.get("idPerson")).intValue());
        csub25sog02.setSzNmPersonFull((String)personConnectedMapNew.get("nmPersonFull"));

        personConnectedList.addCSUB25SOG02(csub25sog02);
      }
    }

    //Get a list of Foster Parents
    int idResource = 0;
    List<Map> fosterParentsMapList = new ArrayList<Map>();

    //For the existing placements with existing resource (no change in resource) the idResourceFacil will be 0 and need to get
    // the resource id from the database using placement event.
    if(idResourceFacil == 0){
      Placement placement = placementDAO.findPlacementByIdPlcmtEvent(idPlcmtEvent);
      if(placement != null){
        idResource = placement.getCapsResourceByIdRsrcFacil() != null? placement.getCapsResourceByIdRsrcFacil().getIdResource() : 0;
      }
    }else{
      idResource = idResourceFacil; //if user has clicked on Set Resource button then idResourceFacil would be the new Resource
                                    //selected.
    }
    
    Integer idFADStageObj = capsResourceDAO.findIdFadStageByIdResource(idResource);
    int idFADStage = idFADStageObj != null ? idFADStageObj : 0;
    fosterParentsMapList = stagePersonLinkDAO.findIdPersonAndNmPersonFullFosterParentsFromStagePersonLinkAndPerson(idFADStage);
    
    //SMS#43550 Added code to remove the duplication in the Person Connected Drop down
    if (personConnectedMapList != null && !personConnectedMapList.isEmpty()){              
      for (Iterator<Map> newIt = personConnectedMapList.iterator(); newIt.hasNext();) {
        Map personConnectedMapNew = newIt.next();
        if (fosterParentsMapList != null && !fosterParentsMapList.isEmpty() ) {
          for (Iterator<Map> it = fosterParentsMapList.iterator(); it.hasNext();) {
            Map fosterParentsMapNew = it.next();
            if(fosterParentsMapNew.containsValue(personConnectedMapNew.get("idPerson"))){
              it.remove();
              fosterParentsMapList.remove(fosterParentsMapNew);
            }
          }
        }
      }
    }
    
    if (fosterParentsMapList != null && !fosterParentsMapList.isEmpty()) {              
      for (Iterator<Map> newIt = fosterParentsMapList.iterator(); newIt.hasNext();) {

        Map fosterParentsMapNew = newIt.next();
        CSUB25SOG02 csub25sog02 = new CSUB25SOG02();

        csub25sog02.setUlIdPerson(((Integer)fosterParentsMapNew.get("idPerson")).intValue());
        csub25sog02.setSzNmPersonFull((String)fosterParentsMapNew.get("nmPersonFull"));
        
        personConnectedList.addCSUB25SOG02(csub25sog02);
      }
    }
    
    //Sorting the list alphabetically
    if (personConnectedList != null){
      CSUB25SOG02[] csub25sog02Array = personConnectedList.getCSUB25SOG02();
      boolean doMore = true;
      while (doMore) {
        doMore = false;  // assume this is last pass over array
        for(int i = 0; i < csub25sog02Array.length - 1 ; i++){
          if(csub25sog02Array[i].getSzNmPersonFull().compareToIgnoreCase(csub25sog02Array[i+1].getSzNmPersonFull()) > 0){
            CSUB25SOG02 temp = csub25sog02Array[i];
            csub25sog02Array[i] = csub25sog02Array[i+1];     // swapping
            csub25sog02Array[i+1] = temp; 
            doMore = true;  // after an exchange, loop again 
          }
        }
      }
      personConnectedSortedList.setCSUB25SOG02(csub25sog02Array);
    }

    return personConnectedSortedList;
  }
}