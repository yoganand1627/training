package gov.georgia.dhr.dfcs.sacwis.service.casemgmt.impl;

import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.db.CsupChildleftcareOutbound;
import gov.georgia.dhr.dfcs.sacwis.db.Eligibility;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.StagePersonLink;
import gov.georgia.dhr.dfcs.sacwis.dao.CsupChildleftcareOutboundDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EligibilityDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonIdDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.SaveCsupChildleftcare;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SaveCsupChildleftcareSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SaveCsupChildleftcareSO;
import gov.georgia.dhr.dfcs.sacwis.service.common.InterfaceServiceConstants;

import java.util.Iterator;
import java.util.List;



/**
 * SaveCsupChildleftcareImpl
 * 
 * @author Kalpana Thirumurthy
 * @version 1.0
 * 
 * <pre>
 *              Change History:
 *              Date      User              Description
 *              --------  ----------------  --------------------------------------------------
 * </pre>
 */

public class SaveCsupChildleftcareImpl extends BaseServiceImpl implements SaveCsupChildleftcare {

  //Create local references to DAO's used for the CSUPParent
  private CsupChildleftcareOutboundDAO csupChildleftcareDAO = null;
  private EligibilityDAO eligibilityDAO = null;
  private PersonIdDAO personIdDAO = null;
  private StagePersonLinkDAO stagePersonLinkDAO = null;
  
  //Create setters to set the current DAO instance to the local reference/s
  public void setCsupChildleftcareOutboundDAO(CsupChildleftcareOutboundDAO csupChildleftcareDAO) {
    this.csupChildleftcareDAO = csupChildleftcareDAO;
  }
  
  public void setEligibilityDAO(EligibilityDAO eligibilityDAO) {
    this.eligibilityDAO = eligibilityDAO;
  }
  
  public void setPersonIdDAO(PersonIdDAO personIdDAO) {
    this.personIdDAO = personIdDAO;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }
  
  /**
   * Method used to save data for the Outbound web Service for Stars Child Left DFCS Care
   * This method is called by all others services when an update takes place to the Placemnt - case management
   * information of the child or when a stage is closed.
   * Services that call this service are (is not inclusive): 
   * This method in turn calls helpers methods for each of the DAO calls and also to perform the required
   * business logic before it sets the csupChildleftcare object, which finally calls the CsupChildleftcareOutboundDAO 
   * to make the final insert in the csup_childleftcare_outbound table
   * @param context
   *          Accepts the SI object as the input Returns the number of rows inserted
   *          returns 0 rows if the insert failed. If failed to insert then throw a service
   *          exception in the same service that calls the current service and that triggers
   *          a rollback
   */

  public int saveCsupChildleftcare(SaveCsupChildleftcareSI saveCsupChildleftcareSI, String service) {

    CsupChildleftcareOutbound csupChildleftcare = new CsupChildleftcareOutbound();
    
    int rowNumInserted = 0;
    Object[] stagePersonLinkObj = null;
    Object[] personIdChildCrsIdObj = null;
    Eligibility eligCsupSend = eligibilityDAO.findDistinctEligibilityByIdPersonAndIndCsupSend(saveCsupChildleftcareSI.getIdPersonId());
    List<StagePersonLink> ncps = null;
    Iterator ncpIter = null;
    
    if(null != eligCsupSend)
    {
      if(InterfaceServiceConstants.CSUP_FLAG_Y.equals(eligCsupSend.getIndEligCsupSend()))
      {
        stagePersonLinkObj = retrieveStagePersonLinkDetails(saveCsupChildleftcareSI);
        personIdChildCrsIdObj = retrievePersonIdChildCrsIdDetails(saveCsupChildleftcareSI);
        
        if(null != Integer.valueOf(saveCsupChildleftcareSI.getIdStage()).toString())
        {
          ncps = stagePersonLinkDAO.findNcpsForChild(saveCsupChildleftcareSI.getIdStage());
          ncpIter = ncps.iterator();
          while (ncpIter.hasNext()) 
          {
            StagePersonLink splRow = (StagePersonLink) ncpIter.next();
            Person ncp = splRow.getPerson();
            int ncpPersonId = ncp.getIdPerson();
            Object[] parCrsId = personIdDAO.findDistinctParentNbrPersonIdCrsIdByIdPerson(ncpPersonId);
            
            csupChildleftcare = setObjectValue(stagePersonLinkObj, personIdChildCrsIdObj, saveCsupChildleftcareSI, 
                                               service, parCrsId);
            
            rowNumInserted = insertChildleftcare(csupChildleftcare);
            
            if (0 == rowNumInserted) {
              throw new ServiceException(Messages.MSG_NO_ROWS_RETURNED);
            }
            
          }
        }
      }
    }
    return rowNumInserted;
}
  
  private Object[] retrieveStagePersonLinkDetails(SaveCsupChildleftcareSI saveCsupChildleftcareSI) {
    
    Object[] pLink = null;
    if(null != saveCsupChildleftcareSI)
    {
      if(null != (Integer.toString(saveCsupChildleftcareSI.getIdPersonId())))
      pLink = stagePersonLinkDAO.findIdPersonByIdStagePersRole(saveCsupChildleftcareSI.getIdPersonId());
    }
    return pLink;
  }
  
  private Object[] retrievePersonIdChildCrsIdDetails(SaveCsupChildleftcareSI saveCsupChildleftcareSI) {
    
    Object[] personIdChildCrsIdObj = null;
    if(null != saveCsupChildleftcareSI)
    {
      if(null != (Integer.toString(saveCsupChildleftcareSI.getIdPersonId())))
      personIdChildCrsIdObj = personIdDAO.findDistinctChildCrsIdByIdPerson(saveCsupChildleftcareSI.getIdPersonId());
    }
    return personIdChildCrsIdObj;
  }
  
  private int insertChildleftcare(CsupChildleftcareOutbound csupChildleftcare) {
    //call the csupDAO to do the insert
    return csupChildleftcareDAO.saveCsupChildleftcare(csupChildleftcare);
  }
  
  private CsupChildleftcareOutbound setObjectValue(Object[] stagePersonLinkObj, Object[] personIdChildCrsIdObj, 
                                                   SaveCsupChildleftcareSI saveCsupChildleftcareSI, 
                                                   String service, Object[] parCrsId) {

    CsupChildleftcareOutbound csupChildleftcare = new CsupChildleftcareOutbound();

    if(null != stagePersonLinkObj)
    {
      if(null != stagePersonLinkObj[0])
        csupChildleftcare.setIdInitiator(Integer.valueOf((String)stagePersonLinkObj[0].toString()));
    }
    if(null != saveCsupChildleftcareSI)
    {
      if(null != saveCsupChildleftcareSI.getDtChildHomeRequested())
        csupChildleftcare.setDtChildhomeRequested(saveCsupChildleftcareSI.getDtChildHomeRequested());
      if(null != saveCsupChildleftcareSI.getDtLeftCare())
        csupChildleftcare.setDtLeftCare(saveCsupChildleftcareSI.getDtLeftCare());
      if(null != Integer.toString(saveCsupChildleftcareSI.getIdCase()))
        csupChildleftcare.setIdCase(saveCsupChildleftcareSI.getIdCase());
      csupChildleftcare.setCdReasonCode(buildNonNullString(saveCsupChildleftcareSI.getCdReasonCode()));
      csupChildleftcare.setNmFullName(buildNonNullString(saveCsupChildleftcareSI.getNmFullName()));
      csupChildleftcare.setNbrPlcmtTelephone(buildNonNullString(saveCsupChildleftcareSI.getNbrPlcmtTelephone()));
      csupChildleftcare.setAddrPlcmtLn1(buildMax25LengthString(saveCsupChildleftcareSI.getAddrPlcmtLn1()));
      csupChildleftcare.setAddrPlcmtLn2(buildMax25LengthString(saveCsupChildleftcareSI.getAddrPlcmtLn2()));
      csupChildleftcare.setAddrPlcmtCity(buildNonNullString(saveCsupChildleftcareSI.getAddrPlcmtCity()));
      csupChildleftcare.setAddrPlcmtSt(buildNonNullString(saveCsupChildleftcareSI.getAddrPlcmtState()));
      csupChildleftcare.setAddrPlcmtZip(buildNonNullString(saveCsupChildleftcareSI.getAddrPlcmtZip()));
    }
    if(null != personIdChildCrsIdObj) {
      if(Integer.valueOf((String)personIdChildCrsIdObj[1]) != null)
        csupChildleftcare.setNbrChildCrsId(Integer.valueOf((String)personIdChildCrsIdObj[1]));
    }
    if(null != parCrsId)
    {
       csupChildleftcare.setNbrNcpCrsId(Integer.valueOf(parCrsId[1].toString()));
    }
    
    csupChildleftcare.setInterfaceStatus(InterfaceServiceConstants.INTERFACE_STATUS_INITIAL);
    
    return csupChildleftcare;
  }
  
  String buildMax25LengthString(String str){
    return buildNLengthString(buildNonNullString(str), 25);
  }
  
  String buildNLengthString(String str, int len) {
    String rtString = str;
    if(str.length() > len){
      rtString = str.substring(0, len);
    }
    return rtString;
  }
  
  String buildNonNullString(String str){
    return (str != null ? str.trim() : "");
  }
  
}