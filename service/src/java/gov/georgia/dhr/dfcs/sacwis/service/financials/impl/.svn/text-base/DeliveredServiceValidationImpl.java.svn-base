package gov.georgia.dhr.dfcs.sacwis.service.financials.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.LookupException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.dao.ContractServiceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.DelvrdSvcDtlDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SvcAuthDetailDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.SvcAuthDetail;
import gov.georgia.dhr.dfcs.sacwis.service.financials.DeliveredServiceValidation;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN29SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN29SO;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class DeliveredServiceValidationImpl extends BaseServiceImpl implements DeliveredServiceValidation {

  private ContractServiceDAO contractServiceDAO = null;

  private DelvrdSvcDtlDAO delvrdSvcDtlDAO = null;

  private PersonDAO personDAO = null;

  private SvcAuthDetailDAO svcAuthDetailDAO = null;

  public void setSvcAuthDetailDAO(SvcAuthDetailDAO svcAuthDetailDAO) {
    this.svcAuthDetailDAO = svcAuthDetailDAO;
  }

  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }

  public void setDelvrdSvcDtlDAO(DelvrdSvcDtlDAO delvrdSvcDtlDAO) {
    this.delvrdSvcDtlDAO = delvrdSvcDtlDAO;
  }

  public void setContractServiceDAO(ContractServiceDAO contractServiceDAO) {
    this.contractServiceDAO = contractServiceDAO;
  }

  public CFIN29SO retrieveDeliveredServiceValidation(CFIN29SI cfin29si) throws ServiceException {

    CFIN29SO cfin29so = new CFIN29SO();

    int moSvcDtlSvcMonth = cfin29si.getUMoSvcDtlSvcMonth();
    int yrSvcDtlServiceYear = cfin29si.getUYrSvcDtlServiceYear();
    int idContract = cfin29si.getUlIdContract();
    String cdSvcDtlCounty = cfin29si.getSzCdSvcDtlCounty();
    String cdSvcDtlService = cfin29si.getSzCdSvcDtlService();
    int idPerson = cfin29si.getUlIdPerson();

    boolean checkServiceAuth = !ADOPTION_INVOICES.contains(cfin29si.getSzCdInvoType())
                               && !Lookup.isValidCode(CodesTables.CRELCODE, cdSvcDtlService)
                               && ArchitectureConstants.N.equals(cfin29si.getCIndRsrcTransport());

    if (checkServiceAuth) {

      List<Integer> idSvcAuthDtlList = delvrdSvcDtlDAO.findIdSvcAuthDtl(idPerson, moSvcDtlSvcMonth,
                                                                        yrSvcDtlServiceYear, cdSvcDtlCounty,
                                                                        cdSvcDtlService);
      boolean dsdExists = idSvcAuthDtlList != null && !idSvcAuthDtlList.isEmpty();
      if (!dsdExists) {
        idSvcAuthDtlList = Arrays.asList(0);
      }

      SvcAuthDetail svcAuthDetailInfo = svcAuthDetailDAO
                                                        .findSvcAuthDetailFromSvcAuthDtlSvcAuthPersonByIdPerson(
                                                                                                                moSvcDtlSvcMonth,
                                                                                                                yrSvcDtlServiceYear,
                                                                                                                idContract,
                                                                                                                cdSvcDtlCounty,
                                                                                                                cdSvcDtlService,
                                                                                                                idPerson,
                                                                                                                idSvcAuthDtlList);
      if (svcAuthDetailInfo == null) {
        throw new ServiceException(Messages.SSM_FIN_NO_SVC_AUTH_DTL);
      } else {
        cfin29so.setSzNmPersonFull(svcAuthDetailInfo.getPerson().getNmPersonFull());
        cfin29so.setUlIdSvcAuthDtl(svcAuthDetailInfo.getIdSvcAuthDtl());
      }
    } else {
      Person personInfo = personDAO.findPersonByIdPerson(cfin29si.getUlIdPerson());

      if (personInfo == null) {
        throw new ServiceException(Messages.SSM_FIN_INVALID_PRSN_ID);
      } else {
        cfin29so.setSzNmPersonFull(personInfo.getNmPersonFull());
      }
    }

    String cdSmileClient = personDAO.findSMILEClientByIdPerson(cfin29si.getUlIdPerson());
    if (cdSmileClient == null) {
      throw new ServiceException(Messages.MSG_CLIENT_SMILE);
    }

    Object[] contractServiceInfo = contractServiceDAO.findContractServiceAndContractVersion(idContract,
                                                                                            moSvcDtlSvcMonth,
                                                                                            yrSvcDtlServiceYear,
                                                                                            cdSvcDtlCounty,
                                                                                            cdSvcDtlService);
    if (contractServiceInfo == null) {
      throw new ServiceException(Messages.SSM_FIN_NO_UNIT_RATE);
    } else {
      cfin29so.setUsNbrSvcDtlCsli(getIntSafe((Integer) contractServiceInfo[0]));
      cfin29so.setDAmtSvcDtlUnitRate(getDoubleSafe((Double) contractServiceInfo[1]));
      cfin29so.setSzCdSvcDtlUnitType((String) contractServiceInfo[2]);
      cfin29so.setSzCdCnsvcPaymentType((String) contractServiceInfo[3]);
      cfin29so.setUlNbrCnverNoShowPct(getIntSafe((Integer) contractServiceInfo[4]));
    }
    return cfin29so;
  }

  private int getIntSafe(Integer i) {
    if (i == null) {
      return 0;
    }
    return i;
  }

  private double getDoubleSafe(Double d) {
    if (d == null) {
      return 0.0;
    }
    return d;
  }

}
