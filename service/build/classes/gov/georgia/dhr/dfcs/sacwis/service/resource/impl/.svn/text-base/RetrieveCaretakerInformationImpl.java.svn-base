package gov.georgia.dhr.dfcs.sacwis.service.resource.impl;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsCaretakerDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsResourceDAO;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES03SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES18SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES18SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES55DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES55DO_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.service.resource.RetrieveCaretakerInformation;
import gov.georgia.dhr.dfcs.sacwis.db.CapsResource;

// STGAP00010681
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;

/**
 * Retrieve service for Caretaker Infromation Page.
 * 
 * @author lata.p.lokhande, date: 04/05/2007.
 * 
 * <p/> Change History: 
 *   Date      User              Description
 *   --------  ----------------  ----------------------------------------------- 
 *   01/02/09  Abraham Williams  STGAP00010681: Updated method retrieveCaretakerInformation.
 *                               Populated the Caretaker Information Retrieve output structure.
 *                               If the current resource is a CPA resource then CPA Resource ID
 *                               is set to the current resource ID and Home ID is set to 0. 
 *                               If the current resource is not a CPA resource then determine
 *                               if the current resource is the child of a CPA resource.
 *                               If the current resource is a child of a CPA resource then CPA
 *                               Resource ID is set to the parent resource Id and Home ID is 
 *                               set to the current resource ID (child). If current resource ID
 *                               is not a CPA resource or the child of a CPA resource then set
 *                               CPA Resource ID to 0 and Home ID to the current resource ID.
 *  01/05/09  Abraham Williams   STGAP00010681: Updated method retrieveCaretakerInformation.
 *                               Save Marital Status for non CPA resource.                              
 *                               
 */
public class RetrieveCaretakerInformationImpl extends BaseServiceImpl implements RetrieveCaretakerInformation {
  
  private CapsCaretakerDAO capsCaretakerDAO = null;
  private CapsResourceDAO capsResourceDAO = null;

  public void setCapsCaretakerDAO(CapsCaretakerDAO capsCaretakerDAO) {
    this.capsCaretakerDAO = capsCaretakerDAO;
  }

  public void setCapsResourceDAO(CapsResourceDAO capsResourceDAO) {
    this.capsResourceDAO = capsResourceDAO;
  }

  /**
   * Retrieve service for Caretaker Information page. It retrievs the data from Caps_resource and Caps_Carataker tables.
   * by resource Id and populates the output RetrieveSO object: CRES18SO.
   * @param CRES18SI
   * @return CRES18SO
   * 
   */
  public CRES18SO retrieveCaretakerInformation(CRES18SI cres18SI) {
    CRES18SO cres18SO = new CRES18SO();
    
    ArchOutputStruct archOutputStruct = new ArchOutputStruct();
    
    cres18SO.setDtSysDtGenericSysdate(DateHelper.getTodayCastorDate());
    String cReqFuncCd = cres18SI.getArchInputStruct().getCReqFuncCd();
    
    // STGAP00010681 - Get the current resource Id 
    int ulIdResource = cres18SI.getUlIdResource();
 
    
    if (ServiceConstants.REQ_FUNC_CD_SAVE.equals(cReqFuncCd)) {
      // STGAP00010681 - Get the CPA Resource Name, Resource Name and Marital Status
      // from the current resource 
      CapsResource capsResource = capsResourceDAO.findCapsResourceByIdResourceOnly(ulIdResource);
      if (capsResource == null) {
        throw new ServiceException(Messages.MSG_NO_ROWS_RETURNED);
      }
      String cdRsrcFacilType = capsResource.getCdRsrcFacilType();
      String nmResource = capsResource.getNmResource();
      String cdRsrcMaritalStatus = capsResource.getCdRsrcMaritalStatus();
      
      cres18SO.setSzCpaName(nmResource);
      cres18SO.setSzNmResource(nmResource);
     
      if (CodesTables.CFACTYP4_CP.equals(cdRsrcFacilType)) {
        cres18SO.setUlIdResource(ulIdResource);
        cres18SO.setUlHmResourceId(0);
      } else {  
        // STGAP00010681 - Check if current resource is the child of a CPA resource
        List<Map> capsResourceList = capsResourceDAO.findCapsResourceByIdResource(ulIdResource);
        if (capsResourceList == null) {
          throw new ServiceException(Messages.MSG_NO_ROWS_RETURNED);
        }
  
        boolean isCpaResourceId = false;
        for (Iterator<Map> it = capsResourceList.iterator(); it.hasNext();) {
          Map capsResourceMap = it.next();
          String parentCdRsrcFacilType = (String) capsResourceMap.get("parentCdRsrcFacilType");
          if (CodesTables.CFACTYP4_CP.equals(parentCdRsrcFacilType)) {
            cres18SO.setUlIdResource((Integer) capsResourceMap.get("parentIdResource") != null ?
                                     (Integer) capsResourceMap.get("parentIdResource") : 0);
            cres18SO.setUlHmResourceId((Integer) capsResourceMap.get("childIdResource") != null ?
                                       (Integer) capsResourceMap.get("childIdResource") : 0);
            //cres18SO.setSzCpaName((String) capsResourceMap.get("parentNmResource"));
            isCpaResourceId = true;
            break;
          } 

        }
        
        // STGAP00010681 - If current resource ID is not a CPA Resource or the child of a CPA resource   
        // then set CPA Resource ID to 0, Home ID resource to the current resource ID and Marital Status to
        // Marital Status of the current resource.
        if (!isCpaResourceId) {
          cres18SO.setUlIdResource(0);
          cres18SO.setUlHmResourceId(ulIdResource);
          if(cdRsrcMaritalStatus != null || "".equals(cdRsrcMaritalStatus)) {
            cres18SO.setCd_Home_Marital_Status(cdRsrcMaritalStatus);
          }
        }
        
        int size = capsResourceList.size();
        archOutputStruct.setUlRowQty(size);
        cres18SO.setArchOutputStruct(archOutputStruct);
      }
      
      //get the caretakers information from Caps_Caretaker table.
      List<Map> capsCaretakerList = capsCaretakerDAO.findCapsCaretakerByIdResource(cres18SI.getUlIdResource());

      //if (capsCaretakerList == null || capsCaretakerList.isEmpty()) {
      //  throw new ServiceException(Messages.MSG_NO_ROWS_RETURNED);
      //}
      
      // STGAP00010681
      ROWCRES55DO_ARRAY rowcres55do_array;
      //ROWCRES55DO_ARRAY rowcres55do_array = new ROWCRES55DO_ARRAY();
      if (capsCaretakerList == null || capsCaretakerList.isEmpty()) {
        rowcres55do_array = null;
      } else {
        // STGAP00010681 - Move inside the else
        rowcres55do_array = new ROWCRES55DO_ARRAY();
        for (Iterator<Map> it = capsCaretakerList.iterator(); it.hasNext();) {
          ROWCRES55DO rowcres55do = new ROWCRES55DO();
          Map capsCaretakerMap = it.next();
          rowcres55do.setIdCaretaker((Integer) capsCaretakerMap.get("idCaretaker") != null ?
                                     (Integer) capsCaretakerMap.get("idCaretaker") : 0);
          rowcres55do.setSzNmCaretkrFname((String) capsCaretakerMap.get("nmCaretkrFname"));
          rowcres55do.setSzNmCaretkrLname((String) capsCaretakerMap.get("nmCaretkrLname"));
          if(capsCaretakerMap.get("nmCaretkrMname") == null)
          {
            rowcres55do.setSzNmCaretkrMname("");
          }
          else
          {          
            rowcres55do.setSzNmCaretkrMname((String) capsCaretakerMap.get("nmCaretkrMname"));
          }
          
          rowcres55do.setCdCaretkrEthnic((String) capsCaretakerMap.get("cdCaretkrEthnic"));
          rowcres55do.setCdCaretkrSex((String) capsCaretakerMap.get("cdCaretkrSex"));
          rowcres55do.setDtCaretkrBirth(DateHelper.toCastorDate((Date) capsCaretakerMap.get("dtCaretkrBirth")));
          rowcres55do.setNbrCaretkr((String) capsCaretakerMap.get("nbrCaretkr"));
          rowcres55do.setCd_Home_Marital_Status((String) capsCaretakerMap.get("cdRsrcMaritalStatus"));
          rowcres55do.setDtEnd(DateHelper.toCastorDate((Date) capsCaretakerMap.get("dtEnd")));
          rowcres55do_array.addROWCRES55DO(rowcres55do);
        }
      }
      cres18SO.setROWCRES55DO_ARRAY(rowcres55do_array);
      
    }//if
    
    return cres18SO;
    
  }
}
