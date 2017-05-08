package gov.georgia.dhr.dfcs.sacwis.service.resource.impl;

/** Change History:
 **  Date        User              Description
 **  --------    ----------------  -------------------------------------------------------------------------
 *   06/06/11    Hai Nguyen        SMS#111056: Initial Creation.
 *
*/

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsResourceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CapsResource;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.PersonDtl;
import gov.georgia.dhr.dfcs.sacwis.db.StagePersonLink;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.resource.RetrieveResourceHouseholdMembers;
import gov.georgia.dhr.dfcs.sacwis.structs.output.RetrieveResourceHouseholdMembersSO;

public class RetrieveResourceHouseholdMembersImpl extends BaseServiceImpl implements RetrieveResourceHouseholdMembers {
  private CapsResourceDAO capsResourceDAO = null;

  private StagePersonLinkDAO stagePersonLinkDAO = null;
    
  public void setCapsResourceDAO(CapsResourceDAO capsResourceDAO) {
    this.capsResourceDAO = capsResourceDAO;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }
  
  public RetrieveResourceHouseholdMembersSO retrieveResourceHouseholdMembers(int idResource) {
    RetrieveResourceHouseholdMembersSO resourceHhMbrWithRecordChecksDueSO = new RetrieveResourceHouseholdMembersSO();
    List<Integer> rsrcHhMemberList = new ArrayList<Integer>();
    
    CapsResource capsResource = capsResourceDAO.findCapsResourceByIdResc(idResource);

    if( capsResource != null && capsResource.getStage() != null){
      List<String> faHomeParentRel = new ArrayList<String>();
      faHomeParentRel.add(CodesTables.CRELVICT_PT); // Adoptive Parent
      faHomeParentRel.add(CodesTables.CRELVICT_FP); // Foster Parent (DFCS)
      faHomeParentRel.add(CodesTables.CRELVICT_AF); // Foster/Adoptive Parent (Legal Risk)
      faHomeParentRel.add(CodesTables.CRELVICT_FA); // Foster Parent (CPA/CCI)

      int idStage = capsResource.getStage().getIdStage();
      
      List<StagePersonLink> principalList = stagePersonLinkDAO.findAllPrincipalsLinkedToStage(idStage, CodesTables.CPRSNTYP_PRN);
    
      if(principalList != null && !principalList.isEmpty()){
        Iterator<StagePersonLink> it = principalList.iterator();
        
        while(it.hasNext()){
          StagePersonLink relatedPrsn = it.next();
          
          Person p = relatedPrsn.getPerson();
          PersonDtl pd = p.getPersonDtl();

          if(is18AndOver(p)
                          && (isResourceHouseholdMember(pd)
                                          || faHomeParentRel.contains(relatedPrsn.getCdStagePersRelInt()))){
            rsrcHhMemberList.add(p.getIdPerson());
          }
        } // ends while
      } // ends principalList
    } // ends capsResource
    resourceHhMbrWithRecordChecksDueSO.setResourceHouseholdMembers(rsrcHhMemberList);
    return resourceHhMbrWithRecordChecksDueSO;
  }
  
  private boolean is18AndOver(Person p){
    Date dtDob = p.getDtPersonBirth();
    
    if( dtDob != null ){
      if(DateHelper.getAge(dtDob) >= 18){
        return true;
      }
    }else{
      throw new ServiceException(Messages.MSG_DOB_REQ);
    }
    
    return false;
  }
  
  private boolean isResourceHouseholdMember(PersonDtl personDtl){
    if( ServiceConstants.FND_YES.equals(personDtl.getIndPersonRsrcHshdMember())){
      return true;
    }
    return false;
  }
  
}
