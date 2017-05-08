package gov.georgia.dhr.dfcs.sacwis.service.resource.impl;

/** Change History:
 **  Date        User              Description
 **  --------    ----------------  -------------------------------------------------------------------------
 *   03/18/11    Hai Nguyen        SMS#97850: MR-75 Initial Creation.
 *
*/

import java.util.Iterator;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsResourceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CapsResource;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.PersonDtl;
import gov.georgia.dhr.dfcs.sacwis.db.StagePersonLink;
import gov.georgia.dhr.dfcs.sacwis.service.common.SyncFaPersonDetailHealthDetail;
import gov.georgia.dhr.dfcs.sacwis.service.common.SyncFaPersonDetailRecordsCheck;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.resource.SyncResourceHhMbrsFaPersonDtl;

public class SyncResourceHhMbrsFaPersonDtlImpl extends BaseServiceImpl implements SyncResourceHhMbrsFaPersonDtl {
  private CapsResourceDAO capsResourceDAO = null;

  private StagePersonLinkDAO stagePersonLinkDAO = null;

  private SyncFaPersonDetailRecordsCheck syncFaPersonDetailRecordsCheck;

  private SyncFaPersonDetailHealthDetail syncFaPersonDetailHealthDetail;

  public void setCapsResourceDAO(CapsResourceDAO capsResourceDAO) {
    this.capsResourceDAO = capsResourceDAO;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }
  
  public void setSyncFaPersonDetailRecordsCheck(SyncFaPersonDetailRecordsCheck syncFaPersonDetailRecordsCheck) {
    this.syncFaPersonDetailRecordsCheck = syncFaPersonDetailRecordsCheck;
  }

  public void setSyncFaPersonDetailHealthDetail(SyncFaPersonDetailHealthDetail syncFaPersonDetailHealthDetail) {
    this.syncFaPersonDetailHealthDetail = syncFaPersonDetailHealthDetail;
  }

  public void syncResourceHhMbrsFaPersonDtl(int idResource) {
    CapsResource capsResource = capsResourceDAO.findCapsResourceByIdResc(idResource);

    if( capsResource != null && capsResource.getStage() != null){
      int idStage = capsResource.getStage().getIdStage();
      
      List<StagePersonLink> principalList = stagePersonLinkDAO.findAllPrincipalsLinkedToStage(idStage, CodesTables.CPRSNTYP_PRN);
    
      if(principalList != null && !principalList.isEmpty()){
        Iterator<StagePersonLink> it = principalList.iterator();
        
        while(it.hasNext()){
          StagePersonLink relatedPrsn = it.next();
          Person p = relatedPrsn.getPerson();
          PersonDtl pd = p.getPersonDtl();
          
          if(isResourceHouseholdMember(pd)){
            syncFaPersonDetailRecordsCheck.syncFaPersonDetailRecordsCheck(p.getIdPerson());
            syncFaPersonDetailHealthDetail.syncFaPersonDetailHealthDetail(p.getIdPerson());
          }
        }
      }
    }
  }
  
  private boolean isResourceHouseholdMember(PersonDtl personDtl){
    if( ServiceConstants.FND_YES.equals(personDtl.getIndPersonRsrcHshdMember())){
      return true;
    }
    return false;
  }
}
