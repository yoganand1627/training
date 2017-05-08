/**
 * Created on May 04, 2007 by Kapil Aggarwal - SACWIS Atlanta
 */
package gov.georgia.dhr.dfcs.sacwis.service.fce.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.AgencyCustodialParentsDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ChildSupportReferralOutboundDAO;
import gov.georgia.dhr.dfcs.sacwis.db.AgencyCustodialParents;
import gov.georgia.dhr.dfcs.sacwis.db.ChildsupRefOutbound;
import gov.georgia.dhr.dfcs.sacwis.service.fce.SaveChildSupportReferralOutbound;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSupRefOutboundSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSupRefOutboundSO;

public class SaveChildSupportReferralOutboundImpl extends BaseServiceImpl implements SaveChildSupportReferralOutbound {

  private ChildSupportReferralOutboundDAO childSupportReferralOutboundDAO = null;

  private AgencyCustodialParentsDAO agencyCustodialParentsDAO;

  public void setChildSupportReferralOutboundDAO(ChildSupportReferralOutboundDAO childSupportReferralOutboundDAO) {
    this.childSupportReferralOutboundDAO = childSupportReferralOutboundDAO;
  }

  public void setAgencyCustodialParentsDAO(AgencyCustodialParentsDAO agencyCustodialParentsDAO) {
    this.agencyCustodialParentsDAO = agencyCustodialParentsDAO;
  }

  /*
   * (non-Javadoc)
   * 
   * @see gov.georgia.dhr.dfcs.sacwis.service.fce.SaveChildSupportReferralOutbound#saveChildSupportReferral(gov.georgia.dhr.dfcs.sacwis.structs.input.CSupRefOutboundSI)
   */
  public CSupRefOutboundSO saveChildSupportReferralOutbound(CSupRefOutboundSI cSupRefOutboundSI) {

    Integer id = cSupRefOutboundSI.getAgencyCustodialParentsSO().getIdAgencyCustodialParents();
    AgencyCustodialParents agencyCustodialParent = agencyCustodialParentsDAO.findAgencyCustodialParentById(id);

    ChildsupRefOutbound csro = populate_ChildsupRefOutbound(cSupRefOutboundSI, agencyCustodialParent);
    int tmp = childSupportReferralOutboundDAO.saveChildSupportReferralOutbound(csro);

    CSupRefOutboundSO cSupRefOutboundSO = new CSupRefOutboundSO();
    cSupRefOutboundSO.setIdChildsupRefOutbound(tmp);
    return cSupRefOutboundSO;
  }

  /**
   * Helper to populate the values in the ChildsupRefOutbound DB object. The AgencyCustodialParents table row is created
   * in a separate transaction and prior to this as it involves registering with the CRS system and the ACP row will
   * create a row with the CRS ID for that ACP and that row in ACP table will serve as an audit row as the creation of
   * CRS ID cannot be rolled back as it is relying on an external system.
   * 
   * @param cSupRefOutboundSI
   *          carries all the input values
   * @param agencyCustodialParent
   *          the row created for the Agency Custodial Parent.
   * @return
   */
  private ChildsupRefOutbound populate_ChildsupRefOutbound(CSupRefOutboundSI cSupRefOutboundSI,
                                                           AgencyCustodialParents agencyCustodialParent) {

    ChildsupRefOutbound childsupRefOutbound = new ChildsupRefOutbound();
    childsupRefOutbound.setAgencyCustodialParents(agencyCustodialParent);
    childsupRefOutbound.setInterfaceStatus(cSupRefOutboundSI.getInterfaceStatus());
    childsupRefOutbound.setIdInitiator(Integer.valueOf(cSupRefOutboundSI.getIdInitiator()));
    childsupRefOutbound.setShinesLogonShort(cSupRefOutboundSI.getShinesLogonShort());
    childsupRefOutbound.setDtCsupRequested(cSupRefOutboundSI.getDtCsupRequested());
    childsupRefOutbound.setIdCase(cSupRefOutboundSI.getIdCase());
    childsupRefOutbound.setIdStage(cSupRefOutboundSI.getIdStage());
    childsupRefOutbound.setIdChild(cSupRefOutboundSI.getIdChild());
    childsupRefOutbound.setNbrChildCrsId(cSupRefOutboundSI.getNbrChildCrsId());
    childsupRefOutbound.setIndChildPaternityEst(cSupRefOutboundSI.getIndChildPaternityEst());
    childsupRefOutbound.setNbrPerDiem(cSupRefOutboundSI.getNbrPerDiem());
    childsupRefOutbound.setNbrPerMonth(cSupRefOutboundSI.getNbrPerMonth());
    childsupRefOutbound.setDtEffPerDiem(cSupRefOutboundSI.getDtEffPerDiem());
    childsupRefOutbound.setIndChildSupportOrder(cSupRefOutboundSI.getIndChildSupportOrder());
    childsupRefOutbound.setIdNoncustParent(cSupRefOutboundSI.getIdNoncustParent());
    childsupRefOutbound.setNbrNoncustCrsId(cSupRefOutboundSI.getNbrNoncustCrsId());
    childsupRefOutbound.setAddrNoncustAddrStLn1(buildMax25LengthString(cSupRefOutboundSI.getAddrNoncustAddrStLn1()));
    childsupRefOutbound.setAddrNoncustAddrStLn2(buildMax25LengthString(cSupRefOutboundSI.getAddrNoncustAddrStLn2()));
    childsupRefOutbound.setAddrNoncustAddrCity(cSupRefOutboundSI.getAddrNoncustAddrCity());
    childsupRefOutbound.setCdNoncustAddrState(cSupRefOutboundSI.getCdNoncustAddrState());
    childsupRefOutbound.setAddrNoncustAddrZip(cSupRefOutboundSI.getAddrNoncustAddrZip());
    childsupRefOutbound.setTxtIncRsrcDesc(cSupRefOutboundSI.getTxtIncRsrcDesc());
    childsupRefOutbound.setTxtIncRsrcSrcAddrStLn1(buildMax25LengthString(cSupRefOutboundSI.getTxtIncRsrcSrcAddrStLn1()));
    childsupRefOutbound.setTxtIncRsrcSrcAddrStLn2(buildMax25LengthString(cSupRefOutboundSI.getTxtIncRsrcSrcAddrStLn2()));
    childsupRefOutbound.setTxtIncRsrcSrcAddrCity(cSupRefOutboundSI.getTxtIncRsrcSrcAddrCity());
    childsupRefOutbound.setTxtIncRsrcSrcAddrState(cSupRefOutboundSI.getTxtIncRsrcSrcAddrState());
    childsupRefOutbound.setTxtIncRsrcSrcAddrZip(cSupRefOutboundSI.getTxtIncRsrcSrcAddrZip());
    childsupRefOutbound.setIndSsiNoncust(cSupRefOutboundSI.getIndSsiNoncust());
    childsupRefOutbound.setCdNoncustMaritalStatus(cSupRefOutboundSI.getCdNoncustMaritalStatus());
    childsupRefOutbound.setNbrCustCrsId(cSupRefOutboundSI.getNbrCustCrsId());
    childsupRefOutbound.setCdCounty(cSupRefOutboundSI.getCdCounty());
    childsupRefOutbound.setIdOffice(cSupRefOutboundSI.getIdOffice());
    childsupRefOutbound.setNmOfficeName(cSupRefOutboundSI.getNmOfficeName());
    childsupRefOutbound.setNmCasemanagerFirst(cSupRefOutboundSI.getNmCasemanagerFirst());
    childsupRefOutbound.setNmCasemanagerMiddle(cSupRefOutboundSI.getNmCasemanagerMiddle());
    childsupRefOutbound.setNmCasemanagerLast(cSupRefOutboundSI.getNmCasemanagerLast());
    childsupRefOutbound.setNbrCasemanagerPhone(cSupRefOutboundSI.getNbrCasemanagerPhone());
    childsupRefOutbound.setNbrCasemanagerFax(cSupRefOutboundSI.getNbrCasemanagerFax());
    childsupRefOutbound.setAddrCasemanAddrStLn1(buildMax25LengthString(cSupRefOutboundSI.getAddrCasemanAddrStLn1()));
    childsupRefOutbound.setAddrCasemanAddrStLn2(buildMax25LengthString(cSupRefOutboundSI.getAddrCasemanAddrStLn2()));
    childsupRefOutbound.setAddrCasemanAddrCity(cSupRefOutboundSI.getAddrCasemanAddrCity());
    childsupRefOutbound.setCdCasemanAddrState(cSupRefOutboundSI.getCdCasemanAddrState());
    childsupRefOutbound.setAddrCasemanAddrZip(cSupRefOutboundSI.getAddrCasemanAddrZip());
    childsupRefOutbound.setCdEligibilityType(cSupRefOutboundSI.getEligibilityType());
    return childsupRefOutbound;
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
