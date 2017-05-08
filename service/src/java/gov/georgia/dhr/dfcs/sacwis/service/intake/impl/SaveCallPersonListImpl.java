package gov.georgia.dhr.dfcs.sacwis.service.intake.impl;

import java.util.Enumeration;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexStagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.intake.SaveCallPersonList;
import gov.georgia.dhr.dfcs.sacwis.structs.input.MUpdIDInStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.MUpdInRec;
import gov.georgia.dhr.dfcs.sacwis.structs.input.MUpdStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PersListMUpdOutRec;

public class SaveCallPersonListImpl extends BaseServiceImpl implements SaveCallPersonList {

  private ComplexStagePersonLinkDAO complexStagePersonLinkDAO = null;

  public void setComplexStagePersonLinkDAO(ComplexStagePersonLinkDAO complexStagePersonLinkDAO) {
    this.complexStagePersonLinkDAO = complexStagePersonLinkDAO;
  }

  public PersListMUpdOutRec saveCallPersonList(MUpdInRec cint35si) throws ServiceException {
    PersListMUpdOutRec cint35so = new PersListMUpdOutRec();
    // get data which is the same for each row to be updated
    MUpdStruct mup = cint35si.getMUpdStruct();
    String indStagePersInLaw = mup.getBIndStagePersInLaw();
    String cdPersonEthnicGroup = mup.getSzCdPersonEthnicGroup();
    String cdPersonLanguage = mup.getSzCdPersonLanguage();
    String cdStagePersRelInt = mup.getSzCdStagePersRelInt();
    String cdStagePersRole = mup.getSzCdStagePersRole();
    String cdStagePersType = mup.getSzCdStagePersType();
    String nmNameLast = mup.getSzNmNameLast();
    String addrPersAddrStLn1 = mup.getSzAddrPersAddrStLn1();
    String addrPersAddrStLn2 = mup.getSzAddrPersAddrStLn2();
    String addrCity = mup.getSzAddrCity();
    String addrZip = mup.getLAddrZip();
    String cdAddrCounty = mup.getSzCdAddrCounty();
    String cdAddrState = mup.getSzCdAddrState();
    String cdPersAddrLinkType = mup.getSzCdPersAddrLinkType();
    String nbrPhone = mup.getLNbrPhone();
    String nbrPhoneExtension = mup.getLNbrPhoneExtension();
    String cdPhoneType = mup.getSzCdPhoneType();
    String indPersCancelHist = mup.getBIndPersCancelHist();
    //STGAP00015485: Added this field
    String cdPKHouseholdMember = mup.getCdPKHouseholdMember();

    // now loop through the input array and update each row
    Enumeration mUpdIdDInStruct_enum = cint35si.getMUpdIDInStruct_ARRAY().enumerateMUpdIDInStruct();
    Enumeration szNmPersonFull_enum =
            cint35si.getMUpdStruct().getSzNmPersonFull_ARRAY_CINT35SI().enumerateSzNmPersonFull();
    while (mUpdIdDInStruct_enum.hasMoreElements() && szNmPersonFull_enum.hasMoreElements()) {
      String nmPersonFull = (String) szNmPersonFull_enum.nextElement();
      MUpdIDInStruct mUpdIDInStruct = (MUpdIDInStruct) mUpdIdDInStruct_enum.nextElement();
      int idStage = mUpdIDInStruct.getUlIdStage();
      int idPerson = mUpdIDInStruct.getUlIdPerson();
      int idName = mUpdIDInStruct.getUlIdName();
      int idAddress = mUpdIDInStruct.getLdIdAddress();
      int idPhone = mUpdIDInStruct.getUlIdPhone();
      int idAddrPersonLink = mUpdIDInStruct.getUlIdAddrPersonLink();
      if (idPerson == 0) {
        break;
      }
      // cint53d STGAP0015485: Added cdPKHouseholdMember
      complexStagePersonLinkDAO.updateStagePersonLink(indStagePersInLaw, idPerson, idStage, cdPersonEthnicGroup,
                                                      indPersCancelHist, cdPersonLanguage, cdStagePersRelInt,
                                                      cdStagePersRole, cdStagePersType, nmNameLast, idName,
                                                      nmPersonFull, cdPersAddrLinkType, idAddress, idAddrPersonLink,
                                                      addrPersAddrStLn1, addrPersAddrStLn2, addrCity, addrZip,
                                                      cdAddrCounty, cdAddrState, cdPhoneType, nbrPhone,
                                                      nbrPhoneExtension, idPhone, cdPKHouseholdMember);
    }
    return cint35so;
  }
}
