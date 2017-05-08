package gov.georgia.dhr.dfcs.sacwis.service.intake.impl;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.IncomingFacilityDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.LegalStatusDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PlacementDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ResourceAddressDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ResourcePhoneDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CapsResource;
import gov.georgia.dhr.dfcs.sacwis.db.ResourceAddress;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.intake.RetrieveIncomingFacilityDetail;
import gov.georgia.dhr.dfcs.sacwis.service.intake.RetrievePlacementForVictimChild;
//import gov.georgia.dhr.dfcs.sacwis.service.resource.impl.LegalStatus;
import gov.georgia.dhr.dfcs.sacwis.db.LegalStatus;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FacDetailEntStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.FacilRtrvInRec;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FacilRtrvOutRec;
import gov.georgia.dhr.dfcs.sacwis.db.Placement;


/**
 * <pre>
 *  Change History:
 *  Date      User              Description
 *  --------  --------          --------------------------------------------------
 *  06/02/11  lata.lokhande     CAPTA 4.3
 *  07/06/11  arege             SMS#113782:CAPTA 4.3 - Intake Information - Provider Type is invalid
 *                              Added CdRsrcFacilType to the output object.
 *  07/07/11  arege             SMS#114343:CAPTA 4.3 - Intake Information - City Not Populating When Relating a Victim
 *  07/09/11  arege             SMS#114623: Auto-population should give same results as Provider Search
 *                         
 *                      
 * </pre>
 */

public class RetrievePlacementForVictimChildImpl extends BaseServiceImpl implements RetrievePlacementForVictimChild {
        private StageDAO stageDAO = null;
        private StagePersonLinkDAO stagePersonLinkDAO = null;
        private LegalStatusDAO legalStatusDAO = null;
        private PlacementDAO placementDAO = null;
        private ResourceAddressDAO resourceAddressDAO = null;
        private ResourcePhoneDAO resourcePhoneDAO = null;
       
        
  public void setStageDAO(StageDAO stageDAO) {
                this.stageDAO = stageDAO;
        }

        public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
                this.stagePersonLinkDAO = stagePersonLinkDAO;
        }

        public void setLegalStatusDAO(LegalStatusDAO legalStatusDAO) {
                this.legalStatusDAO = legalStatusDAO;
        }
        
        public void setResourceAddressDAO(ResourceAddressDAO resourceAddressDAO) {
          this.resourceAddressDAO = resourceAddressDAO;
        }
        
        public void setPlacementDAO(PlacementDAO placementDAO) {
                this.placementDAO = placementDAO;
        }        

        public void setResourcePhoneDAO(ResourcePhoneDAO resourcePhoneDAO) {
          this.resourcePhoneDAO = resourcePhoneDAO;
        }

        public FacilRtrvOutRec retrievePlacementForVictimChild(FacilRtrvInRec facilRtrvInRec) {
                FacilRtrvOutRec facilRtrvOutRec = new FacilRtrvOutRec();
                Integer idChildVictim = null;
                CapsResource capsResource = null;
                //find if the Child is alleged victim and related to intake
                idChildVictim =  stagePersonLinkDAO.findAllegedVictimChildByIdStage(facilRtrvInRec.getFacilRtrvStruc().getUlIdStage());
                
                if(idChildVictim == null){
                        return null; // victim child is not found, don't do anything.
                }
                //find if the child has SUB or ADO stage
                idChildVictim =  stagePersonLinkDAO.findChildWithSubAndAdoStageByIdPerson(idChildVictim.intValue());
                
                if(idChildVictim == null ) {
                  return null; // child is not in SUB or ADO stage, don't do anything.
                }
                
                //victim child is found in the system, find its legal status, child should NOT have a legal status of "Not in  DFCS custody - Adoption finalized"
                
                LegalStatus legalStatus = legalStatusDAO.findMostRecentLegalStatusbyIdPersonAndLegalStatStatus(idChildVictim.intValue(), CodesTables.CLEGSTAT_NAF);
                
                if(legalStatus != null ){
                        return null; //Adoption finalized, do nothing
                }
                
                //victim child is found in the system, and its legal status is not "Not in  DFCS custody - Adoption finalized", get its placement.
                
                Placement placement = placementDAO.findCompAprvPlacementsByIdPerson(new Date(), idChildVictim);
                
                FacDetailEntStruct facDetailEntStruct = new FacDetailEntStruct();
                if(placement != null) {
                  capsResource = placement.getCapsResourceByIdRsrcFacil();
                  
                  if (capsResource != null) {
                    facDetailEntStruct.setUlIdResource(capsResource.getIdResource());
                    facDetailEntStruct.setNmIncmgFacilName(capsResource.getNmResource());
                    facDetailEntStruct.setSzCdRsrcType(capsResource.getCdRsrcType());
                    facDetailEntStruct.setSzCdIncFacilOperBy(capsResource.getCdRsrcOperBy());
                    facDetailEntStruct.setSzCdIncmgFacilType(capsResource.getCdRsrcFacilType()); //SMS#113782
                    //facDetailEntStruct.setSzNmIncmgFacilAffiliated();
                    
                    //get resource address
                    //List<ResourceAddress> resourceAddressList = resourceAddressDAO.findResourceAddressByIdResource(capsResource.getIdResource());
                    ResourceAddress resourceAddress = resourceAddressDAO.findRsrcAddressByAddressTypeOnly(capsResource.getIdResource());
                    if(resourceAddress == null) {
                      throw new ServiceException(Messages.SQL_NOT_FOUND);
                    }
                      facDetailEntStruct.setSzAddrIncmgFacilStLn1(resourceAddress.getAddrRsrcAddrStLn1());
                      facDetailEntStruct.setSzAddrIncmgFacilStLn2(resourceAddress.getAddrRsrcAddrStLn2());
                      facDetailEntStruct.setSzAddrIncmgFacilZip(resourceAddress.getAddrRsrcAddrZip());
                      facDetailEntStruct.setSzCdIncmgFacilCnty(resourceAddress.getCdRsrcAddrCounty());
                      facDetailEntStruct.setSzCdIncmgFacilState(resourceAddress.getCdRsrcAddrState());
                      facDetailEntStruct.setSzAddrIncmgFacilCity(resourceAddress.getAddrRsrcAddrCity()); //SMS#114343
                    
                    if(capsResource.getStage() != null){
                       facDetailEntStruct.setUlIdHomeStage(capsResource.getStage().getIdStage());
                    }
                  //placement phone
                    Map resourcePhoneMap = resourcePhoneDAO.findResourcePhoneInfo(capsResource.getIdResource());
                    String phoneNbr = FormattingHelper.formatPhone((String) resourcePhoneMap.get("nbrRsrcPhone"));
                    String ext = (String) resourcePhoneMap.get("nbrRsrcPhoneExt");
                    if (phoneNbr != null) {
                      facDetailEntStruct.setSzNbrIncmgFacilPhone(phoneNbr);
                      if (ext != null) {
                        facDetailEntStruct.setSzNbrIncmgFacilPhoneExt(ext);
                      }
                    }
                  }
                    
                    //facDetailEntStruct.setSzCdIncmgFacilType(placement.getCdPlcmtType());
                
                    
                    facDetailEntStruct.setSzTxtFacilCmnts(placement.getTxtDocCmnts());
                    facDetailEntStruct.setSzNmIncmgFacilSuprtdant(placement.getNmPlcmtContact());
                    //facDetailEntStruct.setSzAddrIncmgFacilCity(placement.getAddrPlcmtCity());
                    //facDetailEntStruct.setSzCdIncFacilOperBy(capsResource.getCdRsrcOperBy());
                    //facDetailEntStruct.setBIndIncmgFacilAbSupvd(incomingFacility.getIndIncmgFacilAbSupvd());
                    //facDetailEntStruct.setBIndIncmgFacilSearch(incomingFacility.getIndIncmgFacilSearch());
                    
                    //Placement address
                    /*
                    facDetailEntStruct.setSzAddrIncmgFacilStLn1(placement.getAddrPlcmtLn1());
                    facDetailEntStruct.setSzAddrIncmgFacilStLn2(placement.getAddrPlcmtLn2());
                    facDetailEntStruct.setSzAddrIncmgFacilZip(placement.getAddrPlcmtZip());
                    facDetailEntStruct.setSzCdIncmgFacilCnty(placement.getAddrPlcmtCnty());
                    facDetailEntStruct.setSzCdIncmgFacilState(placement.getAddrPlcmtSt());
                    */
                    
                    //facDetailEntStruct.setSzNmUnitWard(placement.getNmIncmgFacilUnitWard());
                    //facDetailEntStruct.setSzNmIncmgFacilAffiliated(placement.getNmPlcmtAgency());
                    //facDetailEntStruct.setNmIncmgFacilName(placement.getNmPlcmtFacil());
                    //facDetailEntStruct.setBIndIncmgOnGrnds(placement.getIndIncmgFacilOffGrnds());
                }
                facilRtrvOutRec.setFacDetailEntStruct(facDetailEntStruct);
                return facilRtrvOutRec;
       }

}
 
        