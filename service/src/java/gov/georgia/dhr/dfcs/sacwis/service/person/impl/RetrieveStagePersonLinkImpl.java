package gov.georgia.dhr.dfcs.sacwis.service.person.impl;

import java.util.Iterator;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.StagePersonLink;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.person.RetrieveStagePersonLink;
import gov.georgia.dhr.dfcs.sacwis.structs.input.StagePersonLinkRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.StagePersonLinkSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.StagePersonLinkDetail_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.StagePersonLinkDetail;

/**
 * 
 * <pre>
 *   Change History:
 *   Date        User      Description
 *   ----------  --------  --------------------------------------------------
 *   05/21/2011  hnguyen   SMS#109407: MR-087 Initial Creation
 *   06/03/2011  hnguyen   SMS#109407: MR-087 Corrected logic to pull list of stage person link if role is specified.
 *                       
 * 
 */
public class RetrieveStagePersonLinkImpl extends BaseServiceImpl implements RetrieveStagePersonLink {

  private StagePersonLinkDAO stagePersonLinkDAO;

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  /*
   * This service is to return a list of persons related in the stage that fit the SI criteria(s).
   */
  public StagePersonLinkSO retrieveStagePersonLink(StagePersonLinkRetrieveSI si) {
    StagePersonLinkSO so = new StagePersonLinkSO();
    StagePersonLinkDetail_ARRAY soRelatedPersons = new StagePersonLinkDetail_ARRAY();
    
    int idStage = si.getUlIdStage();
    String cdPersRole = si.getSzCdStagePersRole();

    so.setStagePersonLinkDetail_ARRAY(soRelatedPersons);

    if( idStage > 0 ){
      // idStage specified only
      if(StringHelper.isEmptyOrNull(cdPersRole)){
        List<StagePersonLink> relatedPersons = stagePersonLinkDAO.findStagePersonLinkRowsByIdStage(idStage);
        
        if( null != relatedPersons){
          Iterator<StagePersonLink> iter = relatedPersons.iterator();
          
          while(iter.hasNext()){
            StagePersonLink stagePersonLink = iter.next();
            StagePersonLinkDetail soDtl = new StagePersonLinkDetail();
            
            setStagePersonLinkStruct(soDtl, stagePersonLink);
            
            soRelatedPersons.addStagePersonLinkDetail(soDtl);
          }
        }
      }else if(StringHelper.isNotEmptyOrNull(cdPersRole)){
        // both idStage and role specified
        List<StagePersonLink> stagePersonLinkList = stagePersonLinkDAO.findStagePersonLinkByIdStageAndCdStagePersRole(idStage, cdPersRole);
        StagePersonLinkDetail soDtl = new StagePersonLinkDetail();

        Iterator<StagePersonLink> itSpl = stagePersonLinkList.iterator();
        
        while(itSpl.hasNext()){
          StagePersonLink stagePersonLink = itSpl.next();
          
          setStagePersonLinkStruct(soDtl, stagePersonLink);
          soRelatedPersons.addStagePersonLinkDetail(soDtl);
        }
      }
    }
    
    return so;
  }
  
  private void setStagePersonLinkStruct(StagePersonLinkDetail soDtl, StagePersonLink spl){
    soDtl.setBIndSafetyRsrc(spl.getIndStagePersSftyResource());
    soDtl.setBIndStagePersEmpNew(spl.getIndStagePersEmpNew());
    soDtl.setBIndStagePersInLaw(spl.getIndStagePersInLaw());
    soDtl.setBIndStagePersPrSecAsgn(spl.getIndStagePersPrSecAsgn());
    soDtl.setBIndStagePersReporter(spl.getIndStagePersReporter());
    soDtl.setCdPKHouseholdMember(spl.getCdPKHshdMember());
    soDtl.setDtDtPersonAddedOrRelated(DateHelper.toCastorDate(spl.getDtPersonAddedOrRelated()));
    soDtl.setDtDtStagePersLink(DateHelper.toCastorDate(spl.getDtStagePersLink()));
    soDtl.setSzCdSideOfFamily(spl.getCdPersonSideOfFamily());
    soDtl.setSzCdStagePersLstSort(spl.getCdStagePersLstSort());
    soDtl.setSzCdStagePersRelInt(spl.getCdStagePersRelInt());
    soDtl.setSzCdStagePersRole(spl.getCdStagePersRole());
    soDtl.setSzCdStagePersSearchInd(spl.getCdStagePersSearchInd());
    soDtl.setSzCdStagePersType(spl.getCdStagePersType());
    soDtl.setSzTxtStagePersNotes(spl.getTxtStagePersNotes());
    soDtl.setSzTxtStagePersOthRelations(spl.getTxtStagePersOthRelations());
    soDtl.setTsLastUpdate(spl.getDtLastUpdate());
    soDtl.setUlIdPersScndryCaretaker(spl.getIdPersScndaryCaretaker() != null ? spl.getIdPersScndaryCaretaker() : 0);

    if(spl.getCapsCase() != null){
      soDtl.setUlIdCase(spl.getCapsCase().getIdCase() != null ? spl.getCapsCase().getIdCase() : 0);
    }

    if(spl.getPerson() != null){
      soDtl.setUlIdCase(spl.getPerson().getIdPerson() != null ? spl.getPerson().getIdPerson() : 0);
      soDtl.setDtDtPersonBirth(DateHelper.toCastorDate(spl.getPerson().getDtPersonBirth()));
    }
    
    if(spl.getStage() != null){
      soDtl.setUlIdCase(spl.getStage().getIdStage() != null ? spl.getStage().getIdStage() : 0);
    }
    
    soDtl.setUlIdStagePersonLink(spl.getIdStagePersonLink() != null ? spl.getIdStagePersonLink() : 0);    
  }
}
