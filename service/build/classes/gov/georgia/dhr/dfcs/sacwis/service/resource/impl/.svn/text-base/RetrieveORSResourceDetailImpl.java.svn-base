package gov.georgia.dhr.dfcs.sacwis.service.resource.impl;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.codestables.Corscopr;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.codestables.Corscost;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.codestables.Corscoty;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.codestables.Corsopft;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.codestables.Corsopst;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.dao.AdverseActionDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsResourceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CintakeDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CompAlgDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.FacilityDAO;
import gov.georgia.dhr.dfcs.sacwis.db.AdverseAction;
import gov.georgia.dhr.dfcs.sacwis.db.CIntake;
import gov.georgia.dhr.dfcs.sacwis.db.CIntakeResp;
import gov.georgia.dhr.dfcs.sacwis.db.CapsResource;
import gov.georgia.dhr.dfcs.sacwis.db.CompAlg;
import gov.georgia.dhr.dfcs.sacwis.db.FacSrv;
import gov.georgia.dhr.dfcs.sacwis.db.Facility;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.resource.RetrieveORSResourceDetail;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ORSAdverseActionSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ORSAllegationSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ORSComplaintSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ORSResourceDetailSO;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.swing.text.Document;
import javax.swing.text.rtf.RTFEditorKit;

/**
 * <pre>
 *  Change History:
 *  Date        User              Description
 *  --------    ----------------  --------------------------------------------------
 *  07/30/2008  mchillman         STGAP00009801 Added value to SO different message will display 
 *                                for non-residential facilities: 
 *  01/30/2009  mxpatel           STGAP00010438: added an overloaded method - 
 *                                retrieveORSFacilityDetail(String facilityId, int pageNbr, int pageSize)
 *                                to implement pagination for the complaint list.
 */
public class RetrieveORSResourceDetailImpl extends BaseServiceImpl implements RetrieveORSResourceDetail {
  
  public static final String EX_NAME_1 = "BOSTICK";
  public static final String EX_NAME_2 = "WINSTEAD";
  public static final String EX_NAME_3 = "IVORY";
  public static final String EX_NAME_4 = "FEINGOLD";
  
  private FacilityDAO facilityDAO = null;
  private CintakeDAO cintakeDAO = null;
  private AdverseActionDAO adverseActionDAO = null;
  private CompAlgDAO compAlgDAO  = null;
  private CapsResourceDAO capsResourceDAO = null;

  public void setFacilityDAO(FacilityDAO facilityDAO) {
    this.facilityDAO = facilityDAO;
  }
  
  public void setCintakeDAO(CintakeDAO cintakeDAO) {
    this.cintakeDAO = cintakeDAO;
  }

  public void setAdverseActionDAO(AdverseActionDAO adverseActionDAO) {
    this.adverseActionDAO = adverseActionDAO;
  }
  
  public void setCompAlgDAO(CompAlgDAO compAlgDAO) {
    this.compAlgDAO = compAlgDAO;
  }
  
  public void setCapsResourceDAO(CapsResourceDAO capsResourceDAO) {
    this.capsResourceDAO = capsResourceDAO;
  }

  public ORSResourceDetailSO retrieveORSFacilityDetail(String facilityId) {
    ORSResourceDetailSO resourceDetailSO = new ORSResourceDetailSO();
    Facility facility =  facilityDAO.findFacilityByFacilityId(facilityId);
    if(facility != null) {
      resourceDetailSO.setDtLastUpdated(facility.getDtLastUpdate());
      resourceDetailSO.setDtLicenseEffective(facility.getLabsrvyDt());
      resourceDetailSO.setIndLicenseContinuation(setLicContIn(facility.getLictypedesc(), facility.getLiccontin()));
      resourceDetailSO.setSzAddress(getString(facility.getAddress()));
      resourceDetailSO.setSzAgesOfChildrenServed(getString(setAgesOfChildrenServed(facility.getFactype(), facility.getEmercont())));
      resourceDetailSO.setSzCapacity((facility.getBedlictot() != null) ? facility.getBedlictot().toString() : "");
      resourceDetailSO.setSzCity(getString(facility.getFacCity()));
      resourceDetailSO.setSzCounty(getString(facility.getCntyname()));
      resourceDetailSO.setSzLegalName(getString(facility.getLegalname()));
      resourceDetailSO.setSzLicenseType(getString(facility.getLictypedesc()));
      resourceDetailSO.setSzOperatingStatus(Lookup.simpleDecodeSafe(Corsopst.CORSOPST, facility.getOperstat())); 
      resourceDetailSO.setSzORSFacilityID(getString(facility.getFacid()));
      resourceDetailSO.setSzORSFacilityTypeCode(facility.getFactype());
      resourceDetailSO.setSzORSFacilityType(Lookup.simpleDecodeSafe(Corsopft.CORSOPFT, facility.getFactype()));
      resourceDetailSO.setSzORSLicenseNumber(getString(facility.getStateid()));
      resourceDetailSO.setSzResourceName(getString(facility.getName()));
      resourceDetailSO.setSzState(getString(facility.getFacSt()));
      resourceDetailSO.setSzZipCode(facility.getFacZip());
      resourceDetailSO.setSzTypeOfService(setTypesOfService(facility.getFacilityServices()));
      resourceDetailSO.setSzShinesRsrsID("");
      resourceDetailSO.setSzShinesRsrsName("");
      Integer idShinesRsrc = facility.getShinesRsrcId();
      if(idShinesRsrc != null) {
        resourceDetailSO.setSzShinesRsrsID(getString(idShinesRsrc.toString()));
        CapsResource resource = capsResourceDAO.findCapsResourceByIdResourceOnly(idShinesRsrc.intValue());
        if (resource != null) {
          resourceDetailSO.setSzShinesRsrsName(getString(resource.getNmResource()));
        }
      } 
      
      String facType = facility.getFactype();
      if(facType != null && facType.startsWith("4")) {
        List<CIntake> complaints = cintakeDAO.findORSComplaintsByFacilityId(facilityId);
        if(complaints != null && complaints.size() > 0) {
          List<ORSComplaintSO> orsComplaintList = new ArrayList<ORSComplaintSO>();
          Iterator<CIntake> itrCompliants = complaints.iterator();
          while(itrCompliants.hasNext()) {
            CIntake compliant = itrCompliants.next();
            ORSComplaintSO orsComplaint = new ORSComplaintSO();
            orsComplaint.setDtIntake(compliant.getInvtdate());
            orsComplaint.setDtLastUpdate(compliant.getDtLastUpdate());
            orsComplaint.setSzInvestigatorName(setInvestigatorsName(compliant.getcIntakeResps()));
            orsComplaint.setSzNarrative(stripRTFChars(compliant.getSanotepad()));
            orsComplaint.setSzNmItake(getString(compliant.getIntakeid()));
            orsComplaint.setSzORSFacilityID(getString(facilityId));
            orsComplaint.setSzPriority(Lookup.simpleDecodeSafe(Corscopr.CORSCOPR, compliant.getPriority()));
            orsComplaint.setSzResourceName(getString(facility.getName()));
            orsComplaint.setSzStatus(Lookup.simpleDecodeSafe(Corscost.CORSCOST, compliant.getStatus()));
            orsComplaint.setSzType(Lookup.simpleDecodeSafe(Corscoty.CORSCOTY, compliant.getCmptype()));
            orsComplaintList.add(orsComplaint);
          }
          resourceDetailSO.setComplaints(orsComplaintList);
        }
      }
      
      List<AdverseAction> adversActions = adverseActionDAO.findAdverseActionsByFacilityId(facilityId);
      if(adversActions != null && adversActions.size() > 0) {
        List<ORSAdverseActionSO> orsAdversActionsList = new ArrayList<ORSAdverseActionSO>();
        Iterator<AdverseAction> itrAA = adversActions.iterator();
        while(itrAA.hasNext()) {
          AdverseAction adverseAction = itrAA.next();
          ORSAdverseActionSO orsAdverseAction  = new ORSAdverseActionSO();
          orsAdverseAction.setDtInitiated(adverseAction.getAasrcdate());
          orsAdverseAction.setDtLastUpdate(adverseAction.getDtLastUpdate());
          orsAdverseAction.setSzDisposition(getString(adverseAction.getFinaloutcome()));
          orsAdverseAction.setSzReason(getString(adverseAction.getPrtypeid()));
          orsAdverseAction.setSzSurveyIdentifier(getString(adverseAction.getEventid()));
          orsAdverseAction.setSzResourceName(getString(facility.getName()));
          orsAdverseAction.setSzORSFacilityID(getString(facilityId));
          orsAdversActionsList.add(orsAdverseAction);
        }
        resourceDetailSO.setAdverseActions(orsAdversActionsList);
      }
    }
    return resourceDetailSO;
  }
  
// mxpatel added this method for defect #10438
  public ORSResourceDetailSO retrieveORSFacilityDetail(String facilityId, int pageNbr, int pageSize) {
    ORSResourceDetailSO resourceDetailSO = new ORSResourceDetailSO();
    Facility facility = facilityDAO.findFacilityByFacilityId(facilityId);
    if (facility != null) {
      resourceDetailSO.setDtLastUpdated(facility.getDtLastUpdate());
      resourceDetailSO.setDtLicenseEffective(facility.getLabsrvyDt());
      resourceDetailSO.setIndLicenseContinuation(setLicContIn(facility.getLictypedesc(), facility.getLiccontin()));
      resourceDetailSO.setSzAddress(getString(facility.getAddress()));
      resourceDetailSO.setSzAgesOfChildrenServed(getString(setAgesOfChildrenServed(facility.getFactype(),
                                                                                   facility.getEmercont())));
      resourceDetailSO.setSzCapacity((facility.getBedlictot() != null) ? facility.getBedlictot().toString() : "");
      resourceDetailSO.setSzCity(getString(facility.getFacCity()));
      resourceDetailSO.setSzCounty(getString(facility.getCntyname()));
      resourceDetailSO.setSzLegalName(getString(facility.getLegalname()));
      resourceDetailSO.setSzLicenseType(getString(facility.getLictypedesc()));
      resourceDetailSO.setSzOperatingStatus(Lookup.simpleDecodeSafe(Corsopst.CORSOPST, facility.getOperstat()));
      resourceDetailSO.setSzORSFacilityID(getString(facility.getFacid()));
      resourceDetailSO.setSzORSFacilityTypeCode(facility.getFactype());
      resourceDetailSO.setSzORSFacilityType(Lookup.simpleDecodeSafe(Corsopft.CORSOPFT, facility.getFactype()));
      resourceDetailSO.setSzORSLicenseNumber(getString(facility.getStateid()));
      resourceDetailSO.setSzResourceName(getString(facility.getName()));
      resourceDetailSO.setSzState(getString(facility.getFacSt()));
      resourceDetailSO.setSzZipCode(facility.getFacZip());
      resourceDetailSO.setSzTypeOfService(setTypesOfService(facility.getFacilityServices()));
      resourceDetailSO.setSzShinesRsrsID("");
      resourceDetailSO.setSzShinesRsrsName("");
      Integer idShinesRsrc = facility.getShinesRsrcId();
      if (idShinesRsrc != null) {
        resourceDetailSO.setSzShinesRsrsID(getString(idShinesRsrc.toString()));
        CapsResource resource = capsResourceDAO.findCapsResourceByIdResourceOnly(idShinesRsrc.intValue());
        if (resource != null) {
          resourceDetailSO.setSzShinesRsrsName(getString(resource.getNmResource()));
        }
      }
      String facType = facility.getFactype();
      if (facType != null && facType.startsWith("4")) {
        PaginatedHibernateList<CIntake> complaints = cintakeDAO.findORSComplaintsByFacilityId(facilityId, pageNbr,
                                                                                              pageSize);// mxpatel added
                                                                                                        // this for
                                                                                                        // defect #10438
        if (complaints != null && complaints.size() > 0) {
          List<ORSComplaintSO> orsComplaintList = new ArrayList<ORSComplaintSO>();
          Iterator<CIntake> itrCompliants = complaints.iterator();
          while (itrCompliants.hasNext()) {
            CIntake compliant = itrCompliants.next();
            ORSComplaintSO orsComplaint = new ORSComplaintSO();
            orsComplaint.setDtIntake(compliant.getInvtdate());
            orsComplaint.setDtLastUpdate(compliant.getDtLastUpdate());
            orsComplaint.setSzInvestigatorName(setInvestigatorsName(compliant.getcIntakeResps()));
            orsComplaint.setSzNarrative(stripRTFChars(compliant.getSanotepad()));
            orsComplaint.setSzNmItake(getString(compliant.getIntakeid()));
            orsComplaint.setSzORSFacilityID(getString(facilityId));
            orsComplaint.setSzPriority(Lookup.simpleDecodeSafe(Corscopr.CORSCOPR, compliant.getPriority()));
            orsComplaint.setSzResourceName(getString(facility.getName()));
            orsComplaint.setSzStatus(Lookup.simpleDecodeSafe(Corscost.CORSCOST, compliant.getStatus()));
            orsComplaint.setSzType(Lookup.simpleDecodeSafe(Corscoty.CORSCOTY, compliant.getCmptype()));
            orsComplaintList.add(orsComplaint);
          }
          resourceDetailSO.setComplaints(orsComplaintList);
          ArchOutputStruct aos = new ArchOutputStruct();
          aos.setBMoreDataInd(complaints.getBMoreDataInd());
          resourceDetailSO.setArchOutputStruct(aos);
        }
      }
      List<AdverseAction> adversActions = adverseActionDAO.findAdverseActionsByFacilityId(facilityId);
      if (adversActions != null && adversActions.size() > 0) {
        List<ORSAdverseActionSO> orsAdversActionsList = new ArrayList<ORSAdverseActionSO>();
        Iterator<AdverseAction> itrAA = adversActions.iterator();
        while (itrAA.hasNext()) {
          AdverseAction adverseAction = itrAA.next();
          ORSAdverseActionSO orsAdverseAction = new ORSAdverseActionSO();
          orsAdverseAction.setDtInitiated(adverseAction.getAasrcdate());
          orsAdverseAction.setDtLastUpdate(adverseAction.getDtLastUpdate());
          orsAdverseAction.setSzDisposition(getString(adverseAction.getFinaloutcome()));
          orsAdverseAction.setSzReason(getString(adverseAction.getPrtypeid()));
          orsAdverseAction.setSzSurveyIdentifier(getString(adverseAction.getEventid()));
          orsAdverseAction.setSzResourceName(getString(facility.getName()));
          orsAdverseAction.setSzORSFacilityID(getString(facilityId));
          orsAdversActionsList.add(orsAdverseAction);
        }
        resourceDetailSO.setAdverseActions(orsAdversActionsList);
      }
    }
    return resourceDetailSO;
  }

  public List<ORSAllegationSO> retrieveORSAllegations(String compliantId) {
    List<ORSAllegationSO> allegationList = new ArrayList<ORSAllegationSO>();
    List<CompAlg> compAlgList = compAlgDAO.retrievesCompAlgsByComplaintId(compliantId);
    if (compAlgList != null && compAlgList.size() > 0) {
      Iterator<CompAlg> itrCA = compAlgList.iterator();
      while (itrCA.hasNext()) {
        CompAlg compAlg = itrCA.next();
        ORSAllegationSO allegation = new ORSAllegationSO();
        allegation.setDtLastUpdate(compAlg.getDtLastUpdate());
        allegation.setSzFinding(getString(compAlg.getFinddesc()));
        allegation.setSzNarrative(stripRTFChars(compAlg.getAlgfindm()));
        allegation.setSzPrimaryType(getString(compAlg.getTypedesc()));
        allegation.setSzRestatement(stripRTFChars(compAlg.getCdetailm()));
        allegation.setSzSecondaryType(getString(compAlg.getSeriousdesc()));
        allegationList.add(allegation);
      }
    }

    return allegationList;
  }
  
    
  private String getString(String str) {
    return (str != null) ? str : "";
  }
  
  private String stripRTFChars(String rtfString){
    String returnString = rtfString;
    if(rtfString != null && rtfString.length() > 0) {
      StringReader stringReader = new java.io.StringReader(rtfString);
      RTFEditorKit rtfEditor = new RTFEditorKit();
      Document defDoc = rtfEditor.createDefaultDocument();
      try {
        rtfEditor.read(stringReader, defDoc, 0);
        returnString =  defDoc.getText(0, defDoc.getLength());
      } catch(Exception io) {
        //TODO: Add exception throw here
      }
    }
    
    return getString(returnString);
  }
  
  private String setAgesOfChildrenServed(String factype, String fieldValue) {
    return (((factype != null) && ((factype.trim()).startsWith("4") == true)) ? fieldValue : "NA");
  }
  
  private String setInvestigatorsName(Collection<CIntakeResp> cIntakeResps) {
    String rtString = "";
    if(cIntakeResps != null && cIntakeResps.size() > 0){
      Iterator<CIntakeResp> itr = cIntakeResps.iterator();
      while(itr.hasNext()) {
        CIntakeResp resp = itr.next();
        String respName = resp.getStaffnm();
        if(cIntakeResps.size() > 1) {
          if((respName != null) && (respName.startsWith(EX_NAME_1) == false) && (respName.startsWith(EX_NAME_2) == false) && 
                          (respName.startsWith(EX_NAME_3) == false) && (respName.startsWith(EX_NAME_4) == false)) {
            rtString = respName;
            break;
          }
        } else {
          rtString = respName;
        }
      }
    }
    return getString(rtString);
  }
  
  private String setLicContIn(String licdesc, Integer  licntin) {
    String rtString = "";
    if(licdesc != null && licntin != null){
      rtString = (licntin.intValue() == 1) ? "Y" : "N";
    }
    return rtString;
  }
  
  private String setTypesOfService(Collection<FacSrv> facSrvs) {
    String rtString = "";
    if(facSrvs != null && facSrvs.size() > 0) {
      Iterator<FacSrv> itr = facSrvs.iterator();
      while(itr.hasNext()){
        FacSrv facSrv = itr.next();
        rtString = rtString + getString(facSrv.getSrvdesc());
        rtString += (itr.hasNext()) ? ", " : "";
      }
    }
    
    return getString(rtString);
  }
}
