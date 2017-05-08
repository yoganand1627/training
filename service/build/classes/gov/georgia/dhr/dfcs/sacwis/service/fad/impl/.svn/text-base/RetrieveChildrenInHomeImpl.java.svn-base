package gov.georgia.dhr.dfcs.sacwis.service.fad.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.dao.CapsResourceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.NonComplianceChildDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.NonComplianceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PlacementDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CapsResource;
import gov.georgia.dhr.dfcs.sacwis.db.NonCompliance;
import gov.georgia.dhr.dfcs.sacwis.db.NonComplianceChild;
import gov.georgia.dhr.dfcs.sacwis.service.fad.RetrieveChildrenInHome;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.NonComplianceSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.NcPerson;
import gov.georgia.dhr.dfcs.sacwis.structs.output.NonComplianceSO;

public class RetrieveChildrenInHomeImpl extends BaseServiceImpl implements RetrieveChildrenInHome {
  // offsets into the Object[] returned by the placementDAO lookup
  private static final int OFFSET_dtPlcmtStart = 0;

  private static final int OFFSET_dtPlcmtEnd = 1;

  private static final int OFFSET_cdPlcmtRemovalRsn = 2;

  private static final int OFFSET_idPerson = 3;

  private static final int OFFSET_nmPersonFull = 4;

  private static final int OFFSET_dtPersonBirth = 5;

  private static final int OFFSET_cdLegalStatStatus = 6;

  private static final int OFFSET_idCase = 7;

  private static final int OFFSET_cdPlcmtGender = 8;

  private static final int OFFSET_nbrAge = 9;

  private static final int OFFSET_cdPlcmtType = 10;

  private static final int OFFSET_cdLegalCnty = 11;

  private static final int OFFSET_cdPlcmtSibling = 12;
  
  private CapsResourceDAO capsResourceDAO = null;
  
  private NonComplianceChildDAO nonComplianceChildDAO = null;

  private NonComplianceDAO nonComplianceDAO = null;
  
  private PlacementDAO placementDAO = null;
  
  public void setCapsResourceDAO(CapsResourceDAO capsResourceDAO){
    this.capsResourceDAO = capsResourceDAO;
  }
  
  public void setPlacementDAO(PlacementDAO placementDAO){
    this.placementDAO = placementDAO;
  }
  
  public void setNonComplianceChildDAO(NonComplianceChildDAO nonComplianceChildDAO) {
    this.nonComplianceChildDAO = nonComplianceChildDAO;
  }

  public void setNonComplianceDAO(NonComplianceDAO nonComplianceDAO) {
    this.nonComplianceDAO = nonComplianceDAO;
  }
  public NonComplianceSO retrieveChildrenInHome(NonComplianceSI input) {
    NonComplianceSO nonComplianceSO = new NonComplianceSO();
    List<NcPerson> childrenList = new ArrayList<NcPerson>();
    CapsResource capsResource = capsResourceDAO.findResourceByIdRsrcFaHomeStage(input.getIdStage());
    int idResource = 0;
    if (capsResource != null){
      if (capsResource.getIdResource()!= null){
        idResource = capsResource.getIdResource();
        nonComplianceSO.setIdResource(capsResource.getIdResource());
        nonComplianceSO.setIdEvent(capsResource.getEvent().getIdEvent());
      }
    }    
    if(input.isUpdateFlag()){
      NonCompliance nonCompliance = nonComplianceDAO.findNonComplianceByIdEventIdCase(input.getIdEvent(),
                                                                                      input.getIdCase());
      int idNonCompliance = nonCompliance.getIdNonCompliance();
      List<Map> childrenInNonCompliance = nonComplianceChildDAO.findChildrenInNonCompliance(idNonCompliance);
      for (Iterator<Map> it = childrenInNonCompliance.iterator(); it.hasNext();) {
        Map child = it.next();
        NcPerson ncPerson = new NcPerson();
        ncPerson.setNmPersonFull((String) child.get("nmPersonFull"));
        ncPerson.setIdPerson((Integer)child.get("idPerson"));
        childrenList.add(ncPerson);
      }
    }else{
      List childrenInHomeList = placementDAO.findPlacementByIdRsrcFacilForHomeInChildren(idResource);
      Iterator childrenInHomeItr = childrenInHomeList.iterator();
      Object childInHome[];
  
      while(childrenInHomeItr.hasNext()){
        childInHome = (Object[])childrenInHomeItr.next();
        NcPerson ncPerson = new NcPerson();
        ncPerson.setNmPersonFull((String) childInHome[OFFSET_nmPersonFull]);
        ncPerson.setIdPerson((Integer)childInHome[OFFSET_idPerson]);
        ncPerson.setDtPlacementStart((Date)childInHome[OFFSET_dtPlcmtStart]);
        childrenList.add(ncPerson);
      }
    }
    nonComplianceSO.setChildrenInHome(childrenList);
    return nonComplianceSO;
  }

}
