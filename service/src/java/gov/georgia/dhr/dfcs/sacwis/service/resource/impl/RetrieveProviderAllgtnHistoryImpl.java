package gov.georgia.dhr.dfcs.sacwis.service.resource.impl;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.codestables.Cevnttyp;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsResourceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CpsInvstDetailDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.IncomingDetailDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.resource.ProviderAllegation;
import gov.georgia.dhr.dfcs.sacwis.db.CapsResource;
import gov.georgia.dhr.dfcs.sacwis.db.CpsInvstDetail;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.ResourceHistory;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.person.impl.RetrieveRecordsCheckSummaryImpl;
import gov.georgia.dhr.dfcs.sacwis.service.resource.RetrieveProviderAllgtnHistory;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ProviderAllegationHistorySI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ProviderAllegationHistorySO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Retrieve Provider Allegation History Service
 * Author: Corey Harden
 * Date: 06/06/2011
 * 
 *                                        Change History
 *
 *   Date          User                                         Description
 * --------  ----------------  --------------------------------------------------
 *
 *
 *
 *
*/


public class RetrieveProviderAllgtnHistoryImpl extends BaseServiceImpl implements RetrieveProviderAllgtnHistory {
  private CapsResourceDAO capsResourceDAO;
  private IncomingDetailDAO incomingDetailDAO;
  private CpsInvstDetailDAO cpsInvstDetailDAO;

  public void setIncomingDetailDAO(IncomingDetailDAO incomingDetailDAO) {
    this.incomingDetailDAO = incomingDetailDAO;
  }

  public void setCpsInvstDetailDAO(CpsInvstDetailDAO cpsInvstDetailDAO) {
    this.cpsInvstDetailDAO = cpsInvstDetailDAO;
  }

  public void setCapsResourceDAO(CapsResourceDAO capsResourceDAO) {
    this.capsResourceDAO = capsResourceDAO;
  }

  /**
   * This method retrieves allegation data for resource providers
   * @param providerAllegationHistorySI - the Service In object
   * @return - returns the Service Out transport object
   */
  @SuppressWarnings("unchecked")
  public ProviderAllegationHistorySO retrieveProviderAllgtnHistory(ProviderAllegationHistorySI providerAllegationHistorySI){
    // create service out object
    ProviderAllegationHistorySO providerAllegationHistorySO = new ProviderAllegationHistorySO();
    
    // create lists
    List<Map> providerIntakeAllegList = new ArrayList<Map>();
    List<Map> providerInvAllegList = new ArrayList<Map>();
    List providerAllegList = new ArrayList();
    
    // get resource id and stage code
    int idResource = providerAllegationHistorySI.getIdResource();
    String cdStage = providerAllegationHistorySI.getCdStage();
    
    // check for existence of idResource
    if(idResource != 0){
      
      // get a list of intake allegation records for resource
      providerIntakeAllegList = incomingDetailDAO.findIncomingDetailProviderAllegByIdResource(idResource);
      
      // get a list of investigation allegation records for resource
      providerInvAllegList = cpsInvstDetailDAO.findAllCpsInvstDetailByIdResource(idResource);
      
      // combine intake and investigation allegation data into a single record
      providerAllegList = combineLists(providerIntakeAllegList, providerInvAllegList);
    }
    // if idResource isn't present, we are in the FAD stage so we will pull id from the home's information
    else if (CodesTables.CSTAGES_FAD.equals(cdStage)) {
      // get the resource using the stage id
      CapsResource resource = capsResourceDAO.findCapsResourceByIdStage(providerAllegationHistorySI.getIdStage());

      // get the idResource of the home
      idResource = resource != null ? resource.getIdResource() : 0;
        
      // get a list of intake allegation records for resource
      providerIntakeAllegList = incomingDetailDAO.findIncomingDetailProviderAllegByIdResource(idResource);

      // get a list of investigation allegation records for resource
      providerInvAllegList = cpsInvstDetailDAO.findAllCpsInvstDetailByIdResource(idResource);

      // combine intake and investigation allegation data into a single record
      providerAllegList = combineLists(providerIntakeAllegList, providerInvAllegList);
      
      // set name of resource into service out object
      providerAllegationHistorySO.setNmCase(resource.getCapsCase().getNmCase());
    }
    
    // set map into service out object
    providerAllegationHistorySO.setProviderAllegList(providerAllegList);
    
    // set boolean to true if there are allegations
    providerAllegationHistorySO.setAllegationAvail(providerAllegList.isEmpty() ? false : true);
    
    // set resource id into out object
    providerAllegationHistorySO.setIdResource(idResource);
    
    return providerAllegationHistorySO;
  }
  
  
  @SuppressWarnings("unchecked")
  private List<ProviderAllegation> combineLists(List<Map> providerIntakeAllegList, List<Map> providerInvAllegList){
    // create list to hold combined data
    List<ProviderAllegation> providerAllegList = new ArrayList<ProviderAllegation>(); 
    
    // loop thru list to match records on idCase
    for(Map map : providerIntakeAllegList){
      // create new provider allegation bean
      ProviderAllegation providerAllegation = new ProviderAllegation();
      
      // get the case id
      Integer idCase = map.containsKey("idCase") ? (Integer) map.get("idCase") : 0;
      
      // skip to next iteration if idCase is not present... but no worries, there should always be a case
      if(idCase == 0){
        continue;
      }
      
      // set data into map
      providerAllegation.setDateOfCall((Date) map.get("dateOfCall"));
      providerAllegation.setIdStage((Integer) map.get("idStage"));
      providerAllegation.setDisposition((String) map.get("disposition"));
      providerAllegation.setScreenOut((String)map.get("screenOut"));
      providerAllegation.setIsMic((String)map.get("isMic"));
      providerAllegation.setIdCase(idCase);
      providerAllegation.setNmCase((String) map.get("nmCase"));
      
      // loop thru investigation list to match intake to inv on case id
      for(int i = 0; i < providerInvAllegList.size(); i++){
        // get record
        Map cpsInvstDetailMap = providerInvAllegList.get(i);
        
        // compare case id's
        if(cpsInvstDetailMap.containsKey("idCase") && idCase.equals(cpsInvstDetailMap.get("idCase"))){
          // add data to bean
          providerAllegation.setOverallInvDisposition((String)cpsInvstDetailMap.get("overallDisptn"));
          providerAllegation.setConclusionRiskFnd((String)cpsInvstDetailMap.get("cdCnclsnRiskFnd"));
          providerAllegation.setInvMaltreatment((String)cpsInvstDetailMap.get("indInvMaltreatInCare"));
          providerAllegation.setInvIdStage((Integer)cpsInvstDetailMap.get("idStage"));
          
          // remove record from list to save time on remaining iterations
          providerInvAllegList.remove(i);
          
          // break outta loop
          break;
        }
      }
      
      // add provider allegation to list
      providerAllegList.add(providerAllegation);
    }
    
    // if there are any remaining investigation allegations, add them remaining ones to list
    for(Map cpsInvstDetailMap : providerInvAllegList){
      // create new provider allegation bean
      ProviderAllegation providerAllegation = new ProviderAllegation();
      
      // add data to bean
      providerAllegation.setOverallInvDisposition((String)cpsInvstDetailMap.get("overallDisptn"));
      providerAllegation.setConclusionRiskFnd((String)cpsInvstDetailMap.get("cdCnclsnRiskFnd"));
      providerAllegation.setInvMaltreatment((String)cpsInvstDetailMap.get("indInvMaltreatInCare"));
      providerAllegation.setInvIdStage((Integer)cpsInvstDetailMap.get("idStage"));
      providerAllegation.setIdCase((Integer) cpsInvstDetailMap.get("idCase"));
      providerAllegation.setNmCase((String) cpsInvstDetailMap.get("nmCase"));
      
      // add provider allegation to list
      providerAllegList.add(providerAllegation);
    }
    
    return providerAllegList;
  }
  
}
