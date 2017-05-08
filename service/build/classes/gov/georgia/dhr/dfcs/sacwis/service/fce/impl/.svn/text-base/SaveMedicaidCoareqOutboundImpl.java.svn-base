package gov.georgia.dhr.dfcs.sacwis.service.fce.impl;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.dao.MedicaidCoareqOutboundDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonAddressDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonIdDAO;
import gov.georgia.dhr.dfcs.sacwis.db.MedicaidCoareqOutbound;
import gov.georgia.dhr.dfcs.sacwis.service.fce.SaveMedicaidCoareqOutbound;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.MedicaidCoareqOutboundSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.MedicaidApplicationSaveSI;
import gov.georgia.dhr.dfcs.sacwis.db.PersonAddress;

import java.util.Date;

/**
 * SaveMedicaidCoareqOutboundImpl
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
public class SaveMedicaidCoareqOutboundImpl extends BaseServiceImpl implements SaveMedicaidCoareqOutbound{
  

public static final String INTERFACE_STATUS = "NEW";
public static final String CD_TARGET_SYSTEM = "SUC";
public static final String CD_REQ_IDENT = "REF";

private MedicaidCoareqOutboundDAO medicaidCoareqOutboundDAO = null;
private PersonAddressDAO personAddressDAO = null;
private PersonIdDAO personIdDAO = null;


  public void setMedicaidCoareqOutboundDAO(MedicaidCoareqOutboundDAO medicaidCoareqOutboundDAO) {
    this.medicaidCoareqOutboundDAO = medicaidCoareqOutboundDAO;
  }
  
  public void setPersonIdDAO(PersonIdDAO personIdDAO) {
  this.personIdDAO = personIdDAO;
  }
  
  public void setPersonAddressDAO(PersonAddressDAO personAddressDAO) {
    this.personAddressDAO = personAddressDAO;
    }

  @SuppressWarnings("serial")
  public int saveMedicaidCoareqOutbound(MedicaidApplicationSaveSI medicaidApplicationSaveSI) throws ServiceException {
    
    int idEvent = 0;
    idEvent = medicaidApplicationSaveSI.getEventId();
    if( idEvent != 0){
      MedicaidCoareqOutbound medicaidCoareqOutbound = new MedicaidCoareqOutbound();
      medicaidCoareqOutbound.setIdEvent(medicaidApplicationSaveSI.getEventId());
      medicaidCoareqOutbound.setIdInitiator(medicaidApplicationSaveSI.getUserId());
      
      int idPerson = 0;
      idPerson = medicaidApplicationSaveSI.getIdPerson();
      medicaidCoareqOutbound.setIdPerson(idPerson);
      
      String nbrCrsId = personIdDAO.findNonEndDatePersonCRSId(idPerson);
      
      if (nbrCrsId == null){
        medicaidCoareqOutbound.setNbrCrsId(0);
        throw new ServiceException(Messages.MSG_CRS_ID_NOT_FND);
      }else{
        try{
          medicaidCoareqOutbound.setNbrCrsId(Integer.parseInt(nbrCrsId));
        }catch(NumberFormatException nfe){
          throw new ServiceException(Messages.MSG_CRS_ID_NOT_A_NUMBER);
        }
      }
      
      String txtPersonEmailAddr = "";
      PersonAddress personAddress = personAddressDAO.findPrimaryPersonAddressByIdPerson(idPerson);
      if(personAddress != null){
        txtPersonEmailAddr = personAddress.getTxtPersonEmail();
        if(txtPersonEmailAddr == null){
          txtPersonEmailAddr ="";
        }
      }
      
      Date dtRmvl = medicaidApplicationSaveSI.getDtRemoval();
      if(dtRmvl == null){
        dtRmvl = new Date();
      }
      
      medicaidCoareqOutbound.setInterfaceStatus(INTERFACE_STATUS);
      medicaidCoareqOutbound.setDtMedRequested(dtRmvl);
      medicaidCoareqOutbound.setCdTargetSystem(CD_TARGET_SYSTEM);
      medicaidCoareqOutbound.setCdReqIdent(CD_REQ_IDENT);
      medicaidCoareqOutbound.setTxtPersonEmail(txtPersonEmailAddr);
      int id = 0;
      
      id = medicaidCoareqOutboundDAO.saveMedicaidCoareqOutbound(medicaidCoareqOutbound);
      return id;
    }
    else
      return 0;
    
  }  
}








