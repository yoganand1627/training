package gov.georgia.dhr.dfcs.sacwis.service.resource.impl;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsResourceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.RsrcLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CapsResource;
import gov.georgia.dhr.dfcs.sacwis.db.RsrcLink;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.resource.RetrieveResourceName;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON17SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON17SO;

/*
* <pre>
*   Change History:
*    Date      User      Description
*    --------  -------- ------------------------------------------------------------------------------------
*   10/21/08   charden  STGAP00010521 - id_resource_link was being pulled from database and used as the id_resource. Wrote code 
*                                       to pull back entire row for the record and get the id_resource from that row
*
* </pre>
*/

public class RetrieveResourceNameImpl extends BaseServiceImpl implements RetrieveResourceName {

  private CapsResourceDAO capsResourceDAO = null;
  private RsrcLinkDAO rsrcLinkDAO = null;
  private static final String OTHER_FACILITY = "06";
  private static final String MHMR_FACILITY = "05";

  public void setCapsResourceDAO(CapsResourceDAO capsResourceDAO) {
    this.capsResourceDAO = capsResourceDAO;
  }
  public void setRsrcLinkDAO(RsrcLinkDAO rsrcLinkDAO) {
    this.rsrcLinkDAO = rsrcLinkDAO;
  }
  
  public CCON17SO retrieveResourceName(CCON17SI ccon17si) {
    CCON17SO ccon17so = null;
    // Calling cres04d
    CapsResource resource = capsResourceDAO.findCapsResourceByIdResourceOnly(ccon17si.getUIdRsrcLinkChild());
    if (resource != null) {
      ccon17so = new CCON17SO();
        //check to make sure it's not already connected to a parent
        //STGAP00010521 - id_resource_link was being pulled from database and used as the id_resource. Wrote code to pull back entire 
        //rsrcLink object and retrieve id_resource from that object
        RsrcLink resourceLink = rsrcLinkDAO.findCapsResourceAndRsrcLink(ccon17si.getUIdRsrcLinkChild(), CodesTables.CRSCLINK_01);
        Integer parent = resourceLink != null ? resourceLink.getCapsResourceByIdRsrcLinkParent().getIdResource() : null;
        
        if (parent == null){
          //set the name to the output for return
          ccon17so.setSzNmResource(resource.getNmResource());
        }        
        else{ 
          ccon17so.setUlIdResource(parent);          
        }      
    }
    return ccon17so;
  }
}
