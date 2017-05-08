package gov.georgia.dhr.dfcs.sacwis.service.person.impl;

import java.util.Iterator;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.AddressPersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.AddressPersonLink;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.person.RetrievePersonAddressList;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN42SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN42SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN42SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN42SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexStagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;

public class RetrievePersonAddressListImpl extends BaseServiceImpl implements RetrievePersonAddressList {

  private AddressPersonLinkDAO addressPersonLinkDAO = null;

  public void setAddressPersonLinkDAO(AddressPersonLinkDAO addressPersonLinkDAO) {
    this.addressPersonLinkDAO = addressPersonLinkDAO;
  }
  
  private ComplexStagePersonLinkDAO complexStagePersonLinkDAO = null;

  public void setComplexStagePersonLinkDAO(ComplexStagePersonLinkDAO complexStagePersonLinkDAO) {
    this.complexStagePersonLinkDAO = complexStagePersonLinkDAO;
  }

  public CCMN42SO retrievePersonAddressList(CCMN42SI ccmn42si) {

    CCMN42SO ccmn42so = new CCMN42SO();
    List<AddressPersonLink> addressPersonLink = null;

    // Determine if Indicator Intake or Investigation
    // If this is set to anything, execute the first one.
    if (StringHelper.isValid(ccmn42si.getBSysIndIntake())) {
      // call ccmn96d
      addressPersonLink = addressPersonLinkDAO.findAddressPersonLinkForIntake(ccmn42si.getUlIdPerson(),
                                                                              ccmn42si.getTsSysTsQuery(),
                                                                              ccmn42si.getTsSysTsQuery());
    } else {
      addressPersonLink = addressPersonLinkDAO.findAddressPersonLinkForInvest(ccmn42si.getUlIdPerson());
    }
    if (addressPersonLink != null && !addressPersonLink.isEmpty()) {
      ROWCCMN42SOG00_ARRAY rowccmn42s0goo_array = new ROWCCMN42SOG00_ARRAY();
      for (Iterator<AddressPersonLink> it = addressPersonLink.iterator(); it.hasNext();) {
        AddressPersonLink addressPersonLinkInfo = it.next();
        ROWCCMN42SOG00 rowccmn42s0goo = new ROWCCMN42SOG00();
        rowccmn42s0goo.setBIndPersAddrLinkPrimary(addressPersonLinkInfo.getIndPersAddrLinkPrimary());
        rowccmn42s0goo.setBIndPersAddrLinkInvalid(addressPersonLinkInfo.getIndPersAddrLinkInvalid());
        rowccmn42s0goo.setSzCdPersAddrLinkType(addressPersonLinkInfo.getCdPersAddrLinkType());
        rowccmn42s0goo.setSzAddrPersAddrStLn1(addressPersonLinkInfo.getPersonAddress().getAddrPersAddrStLn1());
        rowccmn42s0goo.setSzAddrPersAddrStLn2(addressPersonLinkInfo.getPersonAddress().getAddrPersAddrStLn2());
        rowccmn42s0goo.setSzAddrPersAddrAttn(addressPersonLinkInfo.getPersonAddress().getAddrPersonAddrAttn());
        rowccmn42s0goo.setSzTxtPersonEmail(addressPersonLinkInfo.getPersonAddress().getTxtPersonEmail());
        rowccmn42s0goo.setSzAddrCity(addressPersonLinkInfo.getPersonAddress().getAddrPersonAddrCity());
        rowccmn42s0goo.setLAddrZip(addressPersonLinkInfo.getPersonAddress().getAddrPersonAddrZip());
        rowccmn42s0goo.setSzCdAddrCounty(addressPersonLinkInfo.getPersonAddress().getCdPersonAddrCounty());
        rowccmn42s0goo.setSzCdAddrState(addressPersonLinkInfo.getPersonAddress().getCdPersonAddrState());
        rowccmn42s0goo.setSzTxtPersAddrCmnts(addressPersonLinkInfo.getTxtPersAddrCmnts());
        rowccmn42s0goo.setTsSysTsLastUpdate2(addressPersonLinkInfo.getPersonAddress().getDtLastUpdate());
        rowccmn42s0goo.setTsLastUpdate(addressPersonLinkInfo.getDtLastUpdate());
        rowccmn42s0goo.setDtDtPersAddrLinkStart(DateHelper.toCastorDate(
                addressPersonLinkInfo.getDtPersAddrLinkStart()));
        rowccmn42s0goo.setDtDtPersAddrLinkEnd(DateHelper.toCastorDate(addressPersonLinkInfo.getDtPersAddrLinkEnd()));
        rowccmn42s0goo.setLdIdAddress(
                addressPersonLinkInfo.getPersonAddress().getIdPersonAddr() != null ?
                addressPersonLinkInfo.getPersonAddress().getIdPersonAddr() : 0);
        rowccmn42s0goo.setUlIdAddrPersonLink(
                addressPersonLinkInfo.getIdAddrPersonLink() != null ? addressPersonLinkInfo.getIdAddrPersonLink() : 0);
        rowccmn42s0goo.setSzCdScrDataAction(" ");
        rowccmn42s0goo.setBIndRemovalHome(addressPersonLinkInfo.getIndRemovalHome());
        rowccmn42s0goo_array.addROWCCMN42SOG00(rowccmn42s0goo);
      }
      ccmn42so.setROWCCMN42SOG00_ARRAY(rowccmn42s0goo_array);
    }
    
    // STGAP00007077 - check to see if person is currently in Foster Care Stage
    long fccCount = complexStagePersonLinkDAO.countOpenStagesForIdPerson("O", ccmn42si.getUlIdPerson(), CodesTables.CROLES_PC, CodesTables.CSTAGES_SUB);
    String inCare = ArchitectureConstants.N;
    if (fccCount > 0) {
      inCare=ArchitectureConstants.Y;
    }
    ccmn42so.setBIndCareEntered(inCare);
    return ccmn42so;
  }
}


