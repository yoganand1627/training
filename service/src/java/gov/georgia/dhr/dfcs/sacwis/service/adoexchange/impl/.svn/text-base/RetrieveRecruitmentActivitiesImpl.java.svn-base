package gov.georgia.dhr.dfcs.sacwis.service.adoexchange.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.AdoInfoCbxDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.AdoInfoCbxSentDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ExcChildAdoInfoCbxDAO;
import gov.georgia.dhr.dfcs.sacwis.db.AdoInfoCbx;
import gov.georgia.dhr.dfcs.sacwis.db.AdoInfoCbxSent;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.ExcChildAdoInfoCbx;
import gov.georgia.dhr.dfcs.sacwis.service.adoexchange.RetrieveRecruitmentActivities;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.output.AdoInfoCbxSentStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ExcChildAdoInfoCbxStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.RecruitmentActivitiesSO;

public class RetrieveRecruitmentActivitiesImpl extends BaseServiceImpl implements RetrieveRecruitmentActivities {
  public AdoInfoCbxDAO adoInfoCbxDAO;
  
  public AdoInfoCbxSentDAO adoInfoCbxSentDAO;
  
  public ExcChildAdoInfoCbxDAO excChildAdoInfoCbxDAO;
  
  public void setAdoInfoCbxDAO(AdoInfoCbxDAO adoInfoCbxDAO) {
    this.adoInfoCbxDAO = adoInfoCbxDAO;
  }

  public void setAdoInfoCbxSentDAO(AdoInfoCbxSentDAO adoInfoCbxSentDAO) {
    this.adoInfoCbxSentDAO = adoInfoCbxSentDAO;
  }

  public void setExcChildAdoInfoCbxDAO(ExcChildAdoInfoCbxDAO excChildAdoInfoCbxDAO) {
    this.excChildAdoInfoCbxDAO = excChildAdoInfoCbxDAO;
  }

  @SuppressWarnings( { "unchecked" })
  public RecruitmentActivitiesSO retrieveRecruitmentActivities(int idEvent, String cdCbxCodeType){
    
    RecruitmentActivitiesSO recruitmentActivitiesSO = new RecruitmentActivitiesSO();
    
    Event event = getPersistentObject(Event.class, idEvent);
    
    if(event != null && StringHelper.isNotEmptyOrNull(cdCbxCodeType)){
      if(event.getCdEventType().equals(CodesTables.CEVNTTYP_EXC)){ // retrieve Exchange Child Detail recruitment activities
        List recruitmentActivityDates = new ArrayList();

        // Get the recruitment activity dates for this event
        List<ExcChildAdoInfoCbx> excChildAdoInfoList = excChildAdoInfoCbxDAO.findExcChildAdoInfoByIdEventByCdInfoCbx(idEvent, cdCbxCodeType);

        if (excChildAdoInfoList != null && excChildAdoInfoList.size() > 0) {
          Iterator<ExcChildAdoInfoCbx> it = excChildAdoInfoList.iterator();
          while (it.hasNext()) {
            ExcChildAdoInfoCbx excChildAdoInfoCbx = it.next();
            
            ExcChildAdoInfoCbxStruct excChildAdoInfoCbxSO = new ExcChildAdoInfoCbxStruct();
            excChildAdoInfoCbxSO.setIdEvent(idEvent);
            excChildAdoInfoCbxSO.setCdCbxCodeType(cdCbxCodeType);
            excChildAdoInfoCbxSO.setCdAdoInfoCbx(excChildAdoInfoCbx.getCdAdoInfoCbx());
            excChildAdoInfoCbxSO.setIdInfoChar(excChildAdoInfoCbx.getIdInfoChar());
            excChildAdoInfoCbxSO.setDtPerformed(excChildAdoInfoCbx.getDtPerformed());
            
            recruitmentActivityDates.add(excChildAdoInfoCbxSO);
          }
          
          recruitmentActivitiesSO.setRecruitmentActivityDates(recruitmentActivityDates);
        }
      }else if(event.getCdEventType().equals(CodesTables.CEVNTTYP_ADO)){ // retrieve Adoption Information recruitment activities
        List recruitmentActivityDates = new ArrayList();

        // Get the recruitment activity dates for this event
        List<AdoInfoCbx> adoInfoCbxList = adoInfoCbxDAO.findAdoInfoCheckboxbyIdEventandCbxCodeType(idEvent, cdCbxCodeType);

        if (adoInfoCbxList != null && adoInfoCbxList.size() > 0) {
          Iterator<AdoInfoCbx> it = adoInfoCbxList.iterator();
          while (it.hasNext()) {
            AdoInfoCbx adoInfoCbx = it.next();
            
            List<AdoInfoCbxSent> adoInfoCbxSentList = adoInfoCbxSentDAO.findAdoInfoCbxSentByIdInfoCharIdEvent(adoInfoCbx.getIdInfoChar(), idEvent);
                                                                                                        
            if (adoInfoCbxSentList != null && adoInfoCbxSentList.size() > 0) {
              Iterator<AdoInfoCbxSent> itSent = adoInfoCbxSentList.iterator();
              while (itSent.hasNext()) {
                AdoInfoCbxSent adoInfoCbxSent = itSent.next();
                
                AdoInfoCbxSentStruct adoInfoCbxSentSO = new AdoInfoCbxSentStruct();
                adoInfoCbxSentSO.setIdAdoInfoCbxSent(adoInfoCbxSent.getIdAdoInfoCbxSent().intValue());
                adoInfoCbxSentSO.setIdInfoChar(adoInfoCbx.getIdInfoChar());
                adoInfoCbxSentSO.setIdEvent(idEvent);
                adoInfoCbxSentSO.setCdCbxCodeType(cdCbxCodeType);
                adoInfoCbxSentSO.setCdAdoInfoCbx(adoInfoCbx.getCdAdoInfoCbx());
                adoInfoCbxSentSO.setDtAdoInfoCbxSent(adoInfoCbxSent.getDtAdoInfoCbxSent());
                
                recruitmentActivityDates.add(adoInfoCbxSentSO);                
              }
            }
          }
          
          recruitmentActivitiesSO.setRecruitmentActivityDates(recruitmentActivityDates);
        }
      }
    }

    return recruitmentActivitiesSO;
  }
  
}
