package gov.georgia.dhr.dfcs.sacwis.service.resource.impl;

import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsCaretakerDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsResourceDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CapsCaretaker;
import gov.georgia.dhr.dfcs.sacwis.db.CapsResource;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES18SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES18SO;
import gov.georgia.dhr.dfcs.sacwis.service.resource.SaveCaretakerDetail;

/**
 * Save service for Caretaker Detail page.
 * @author lata.p.lokhande
 *
 */
public class SaveCaretakerDetailImpl extends BaseServiceImpl implements SaveCaretakerDetail {

  private CapsCaretakerDAO capsCaretakerDAO = null;
  private CapsResourceDAO capsResourceDAO = null;

  
  public void setCapsCaretakerDAO(CapsCaretakerDAO capsCaretakerDAO) {
    this.capsCaretakerDAO = capsCaretakerDAO;
  }
  
  public void setCapsResourceDAO(CapsResourceDAO capsResourceDAO) {
    this.capsResourceDAO = capsResourceDAO;
  }
  
  /**
   * This method saves the Caretaker Detail information in Caps_Caretaker table.
   * 
   */
  public CRES18SO saveCaretakerDetail(CRES18SI cres18SI){
    
    CRES18SO cres18SO = new CRES18SO();
    cres18SO.setDtSysDtGenericSysdate(DateHelper.getTodayCastorDate());
    
    //If updating the existing record, then get the CapsCaretaker object from session and populate and save it.
    //else create new object, if adding new record, and then populate it with caretaker infromation and save in database..
    
       
    CapsCaretaker capsCareTaker = null;
    
    if (cres18SI.getIdCaretaker() == 0 ) {
       capsCareTaker = new CapsCaretaker();
    } else {
       capsCareTaker = this.getPersistentObject(CapsCaretaker.class, cres18SI.getIdCaretaker());
    }
    
    CapsResource capsResource = this.getPersistentObject(CapsResource.class, cres18SI.getUlIdResource());
    
    capsResource.setCdRsrcMaritalStatus(cres18SI.getCd_Home_Marital_Status());
    
    capsCareTaker.setCapsResource(capsResource);
    capsCareTaker.setIdCaretaker(cres18SI.getIdCaretaker());
    capsCareTaker.setNmCaretkrFname(cres18SI.getSzNmCaretkrFname());
    capsCareTaker.setNmCaretkrLname(cres18SI.getSzNmCaretkrLname());
    if(cres18SI.getSzNmCaretkrMname() == null || cres18SI.getSzNmCaretkrMname().trim().equals(""))
    {
      capsCareTaker.setNmCaretkrMname(null);
    }
    else
    {
      capsCareTaker.setNmCaretkrMname(cres18SI.getSzNmCaretkrMname());
    }
    capsCareTaker.setCdCaretkrEthnic(cres18SI.getCdCaretkrEthnic());
    capsCareTaker.setCdCaretkrSex(cres18SI.getCdCaretkrSex());
    capsCareTaker.setDtCaretkrBirth(DateHelper.toJavaDate(cres18SI.getDtCaretkrBirth()));
    capsCareTaker.setDtEnd(DateHelper.toJavaDate(cres18SI.getDtEnd()));
  
    capsCaretakerDAO.saveCapsCaretaker(capsCareTaker);
    
    capsResourceDAO.saveOrUpdateCapsResource(capsResource);
   
    return cres18SO;
    
  }
  
}
