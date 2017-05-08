package gov.georgia.dhr.dfcs.sacwis.service.ws.impl;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.InitialMedicaidAppDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.MedicaidCoaInboundDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.MedicaidCoareqOutboundDAO;
import gov.georgia.dhr.dfcs.sacwis.db.MedicaidCoaInbound;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.ws.SaveMedicaidCoareq;
import gov.georgia.dhr.dfcs.sacwis.structs.input.MedicaidCoareqInboundSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.MedicaidCoareqInboundSO;

import java.util.Date;

/**
 * SaveMedicaidCoareqImpl
 * 
 * @author Srinivasa Rao Dodda
 * @version 1.0
 * 
 * <pre>
 *             Change History:
 *             Date      User              Description
 *             --------  ----------------  --------------------------------------------------
 * </pre>
 */

public class SaveMedicaidCoareqImpl extends BaseServiceImpl implements SaveMedicaidCoareq{

  private InitialMedicaidAppDAO initialMedicaidAppDAO = null;
  private MedicaidCoareqOutboundDAO medicaidCoareqOutboundDAO = null;
  private MedicaidCoaInboundDAO medicaidCoaInboundDAO = null;
  
  public void setInitialMedicaidAppDAO(InitialMedicaidAppDAO initialMedicaidAppDAO) {
    this.initialMedicaidAppDAO = initialMedicaidAppDAO;
  } 
   
  public void setMedicaidCoareqOutboundDAO(MedicaidCoareqOutboundDAO medicaidCoareqOutboundDAO) {
    this.medicaidCoareqOutboundDAO = medicaidCoareqOutboundDAO;
  }
 public void setMedicaidCoaInboundDAO(MedicaidCoaInboundDAO medicaidCoaInboundDAO) {
    this.medicaidCoaInboundDAO = medicaidCoaInboundDAO;
 }
 @SuppressWarnings("unchecked")
  public MedicaidCoareqInboundSO saveMedicaidCoareq(MedicaidCoareqInboundSI medicaidCoareqInboundSI)throws ServiceException {
    
    MedicaidCoareqInboundSO medicaidCoareqInboundSO = new MedicaidCoareqInboundSO();
    
    String szCdMedicaidClassAssistance;
            
    int idMedicaidCoareqOutbound = medicaidCoareqInboundSI.getUlTransactionId();
    szCdMedicaidClassAssistance = medicaidCoareqInboundSI.getSzCdMedicaidClassAssistance();
    int idEvent = medicaidCoareqOutboundDAO.findIdEventByIdMedicaidCoareqOutbound(idMedicaidCoareqOutbound);
    
    Date dtBenifitMonth = medicaidCoareqInboundSI.getDtBenifitMonth();
    if(idEvent != 0){      
      Date dtSuccClassAssistance = initialMedicaidAppDAO.findDtSuccClassAssiastanceByIdEvent(idEvent);      
      
      if(dtSuccClassAssistance != null){
             if(dtBenifitMonth.after(dtSuccClassAssistance)){
                   dtSuccClassAssistance = dtBenifitMonth;
                 }
      }else {
        
        dtSuccClassAssistance = dtBenifitMonth;
          
      }
     
          int updateStatus = initialMedicaidAppDAO.updateMedicaidCoa(idEvent, szCdMedicaidClassAssistance, dtSuccClassAssistance);
          if(updateStatus == 1){
           
            MedicaidCoaInbound medicaidCoaInbound = new MedicaidCoaInbound();
            int bnfYear = DateHelper.getYear( medicaidCoareqInboundSI.getDtBenifitMonth());
            int bnfMonth = DateHelper.getMonth(medicaidCoareqInboundSI.getDtBenifitMonth());
            String bnftDate = String.valueOf(bnfYear).concat(String.valueOf(bnfMonth));
            int BnftMonthDate = Integer.parseInt(bnftDate);
           
            medicaidCoaInbound.setDtFirstDayLiability(medicaidCoareqInboundSI.getDtFirstDayLbltyDate());
            medicaidCoaInbound.setMedCoa(medicaidCoareqInboundSI.getSzCdMedicaidClassAssistance());
            medicaidCoaInbound.setAmtFirstDayLiability(medicaidCoareqInboundSI.getUlFirstDayLbltyAmount());
            medicaidCoaInbound.setBnftMonth(BnftMonthDate);
            medicaidCoaInbound.setIdMedicaidCoareqOutbound(medicaidCoareqInboundSI.getUlTransactionId());
            medicaidCoaInbound.setNbrCrsId(medicaidCoareqInboundSI.getUlDhrChildId());
            medicaidCoaInboundDAO.saveMedicaidCoaInbound(medicaidCoaInbound);  
            medicaidCoareqInboundSO.setUlTransactionId(idMedicaidCoareqOutbound); 
          return medicaidCoareqInboundSO;
      }
      else{
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }
    }
    else{
    return null;
  }
}
}
