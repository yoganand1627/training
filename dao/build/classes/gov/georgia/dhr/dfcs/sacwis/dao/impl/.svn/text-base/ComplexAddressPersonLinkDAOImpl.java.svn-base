package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.Date;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.AddressPersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CommonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexAddressPersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.AddressPersonLink;

public class ComplexAddressPersonLinkDAOImpl extends BaseDAOImpl implements ComplexAddressPersonLinkDAO {
  AddressPersonLinkDAO addressPersonLinkDAO;

  CommonDAO commonDAO;

  public void setAddressPersonLinkDAO(AddressPersonLinkDAO addressPersonLinkDAO) {
    this.addressPersonLinkDAO = addressPersonLinkDAO;
  }

  public void setCommonDAO(CommonDAO commonDAO) {
    this.commonDAO = commonDAO;
  }

  public List<AddressPersonLink> findIntakeOrInvest(boolean intake, int idPerson, Date dtSysTsQuery) {
    List<AddressPersonLink> result;
    if (intake) {
      result = addressPersonLinkDAO.findAddressPersonLinkForIntake(idPerson, dtSysTsQuery, dtSysTsQuery);
    } else {
      result = addressPersonLinkDAO.findAddressPersonLinkForInvest(idPerson);
    }
    return result;
  }

  public int insertAddressPersonLink(Date dtDtPersAddrLinkEnd, int idPerson, int idAddress,
                                     String indPersAddrLinkInvalid, String indPersAddrLinkPrimary,
                                     String txtPersAddrCmnts, String cdPersAddrLinkType, String indRemovalHome) {
    int idAddrPersonLink = commonDAO.getNextval("SEQ_ADDRESS_PERSON_LINK");
    // Typically, DT_PERS_ADDR_LINK_END will be NULL_DATE when passed into the Service. This is fine since a trigger
    // will set it to MAX_DATE for us. However, it is possible for us to have enddated the address at the same time
    // it was created. In this case, we want to set DT_PERS_ADDR_LINK_END to SYSDATE.
    if (DateHelper.isNull(dtDtPersAddrLinkEnd) || DateHelper.MAX_JAVA_DATE.equals(dtDtPersAddrLinkEnd)) {
      addressPersonLinkDAO.insertAddressPersonLink(idAddrPersonLink, dtDtPersAddrLinkEnd, idPerson, idAddress,
                                                   indPersAddrLinkInvalid, indPersAddrLinkPrimary, txtPersAddrCmnts,
                                                   cdPersAddrLinkType, indRemovalHome);
    } else {
      addressPersonLinkDAO.insertAddressPersonLink(idAddrPersonLink, idPerson, idAddress, indPersAddrLinkInvalid,
                                                   indPersAddrLinkPrimary, txtPersAddrCmnts, cdPersAddrLinkType, indRemovalHome);
    }
    return idAddrPersonLink;
  }

  public int updateAddressPersonLink(Date dtDtPersAddrLinkEnd, int idAddrPersonLink, String cdPersAddrLinkType,
                                     String indPersAddrLinkInvalid, String indPersAddrLinkPrimary,
                                     String txtPersAddrCmnts, String indRemovalHome, Date tsSysTsLastUpdate2) {
    // The only time that DT_PERS_ADDR_LINK_END should be updated is if a non-null value is passed into the Service
    // and the row does not already have an end-date on the database. To determine this we need to retrieve the
    // value from the database, and compare it to MAX_DATE.
    Date dtEndDate = null;
    if (!DateHelper.isNull(dtDtPersAddrLinkEnd)) {
      dtEndDate = addressPersonLinkDAO.findAddressPersonLinkDtPersAddrLinkEnd(idAddrPersonLink);
      //if (dtEndDate == null) {
      //  return 0;
      //}
    }
    if ((dtDtPersAddrLinkEnd != null) && !(DateHelper.MAX_JAVA_DATE.equals(dtDtPersAddrLinkEnd)) &&
        (dtEndDate == null || DateHelper.MAX_JAVA_DATE.equals(dtEndDate)))

    //if (!DateHelper.isNull(dtDtPersAddrLinkEnd) && !DateHelper.isNull(dtEndDate)) {
    {  
      return addressPersonLinkDAO.updateAddressPersonLink(cdPersAddrLinkType, indPersAddrLinkInvalid,
                                                          indPersAddrLinkPrimary, txtPersAddrCmnts, idAddrPersonLink,
                                                          indRemovalHome,
                                                          tsSysTsLastUpdate2);
    } else {
      return addressPersonLinkDAO.updateAddressPersonLinkByCdPersAddrLinkType(cdPersAddrLinkType,
                                                                              indPersAddrLinkInvalid,
                                                                              indPersAddrLinkPrimary, txtPersAddrCmnts,
                                                                              idAddrPersonLink, indRemovalHome, tsSysTsLastUpdate2);
    }
  }

}
