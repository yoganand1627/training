package gov.georgia.dhr.dfcs.sacwis.service.financials.impl;

import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexCapsResourceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexContractServiceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ContractCountyDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ContractPeriodDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ContractServiceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ContractVersionDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CapsResource;
import gov.georgia.dhr.dfcs.sacwis.db.Contract;
import gov.georgia.dhr.dfcs.sacwis.db.ContractCounty;
import gov.georgia.dhr.dfcs.sacwis.db.ContractCountyView;
import gov.georgia.dhr.dfcs.sacwis.db.ContractPeriod;
import gov.georgia.dhr.dfcs.sacwis.db.ContractService;
import gov.georgia.dhr.dfcs.sacwis.db.ContractVersion;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.service.financials.SaveContractVersion;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON08SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCON08SIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCON08SIG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON08SO;

/**
 * 
 * <pre>
 *  Change History:
 *  Date        User      Description
 *  --------  --------  --------------------------------------------------
 *  09/26/2011  arege  STGAP00017053 Update the contract_county also when a new version is added to the contract period
 *
 **/
public class SaveContractVersionImpl extends BaseServiceImpl implements SaveContractVersion {

  public static final int FIRST_VERSION = 1;

  public static final int INITIAL_PAGE = 1;

  private ComplexContractServiceDAO complexContractServiceDAO = null;

  private ComplexCapsResourceDAO complexCapsResourceDAO = null;

  private ContractCountyDAO contractCountyDAO = null;

  private ContractPeriodDAO contractPeriodDAO = null;

  private ContractServiceDAO contractServiceDAO = null;

  private ContractVersionDAO contractVersionDAO = null;

  public void setComplexContractServiceDAO(ComplexContractServiceDAO complexContractServiceDAO) {
    this.complexContractServiceDAO = complexContractServiceDAO;
  }

  public void setContractCountyDAO(ContractCountyDAO contractCountyDAO) {
    this.contractCountyDAO = contractCountyDAO;
  }

  public void setContractPeriodDAO(ContractPeriodDAO contractPeriodDAO) {
    this.contractPeriodDAO = contractPeriodDAO;
  }

  public void setContractServiceDAO(ContractServiceDAO contractServiceDAO) {
    this.contractServiceDAO = contractServiceDAO;
  }

  public void setContractVersionDAO(ContractVersionDAO contractVersionDAO) {
    this.contractVersionDAO = contractVersionDAO;
  }

  public CCON08SO saveContractVersion(CCON08SI ccon08si) throws ServiceException {
    CCON08SO ccon08so = new CCON08SO();
    int idContract = ccon08si.getUlIdContract();
    int nbrCnverPeriod = ccon08si.getUlNbrCnverPeriod();
    int idCntrctWkr = ccon08si.getUlIdCntrctWkr();
    
    // check for errors
    findListOfContractPeriod(idContract, nbrCnverPeriod, ccon08si.getROWCCON08SIG00_ARRAY());

    for (Enumeration rowccon08sigooEnum = ccon08si.getROWCCON08SIG00_ARRAY().enumerateROWCCON08SIG00(); rowccon08sigooEnum
                                                                                                                          .hasMoreElements();) {
      ROWCCON08SIG00 rowCCON08SIGOO = (ROWCCON08SIG00) rowccon08sigooEnum.nextElement();

      updateAndSaveContractVersion(rowCCON08SIGOO, idCntrctWkr, idContract, nbrCnverPeriod, ccon08si.getBIndReview());

      if ((ArchitectureConstants.Y.equals(rowCCON08SIGOO.getBSysIndVersionLockMod()) && (ServiceConstants.REQ_FUNC_CD_ADD
                                                                                                                         .equals(rowCCON08SIGOO
                                                                                                                                               .getSzCdScrDataAction())))) {
        findAndUpdateContractService(rowCCON08SIGOO, idContract, nbrCnverPeriod, ccon08si.getCIndCntrctBudgLimit(),
                                     idCntrctWkr);

      }

      if ((ArchitectureConstants.N.equals(rowCCON08SIGOO.getBIndEndDateMod()))) {
        findAndSaveContractCounty(idContract, nbrCnverPeriod, idCntrctWkr, rowCCON08SIGOO);
      }

      if ((rowCCON08SIGOO.getUlNbrCnverVersion() > FIRST_VERSION)
          && (ServiceConstants.REQ_FUNC_CD_ADD.equals(rowCCON08SIGOO.getSzCdScrDataAction()))) {
        saveContractServiceAndContractCounty(idContract, nbrCnverPeriod, idCntrctWkr, rowCCON08SIGOO);
      }

    }// end of Enumeration

    complexCapsResourceDAO.updateResourceIndRsrcContracted(idContract);

    return ccon08so;
  }

  private void saveContractServiceAndContractCounty(int idContract, int nbrCnsvcPeriod, int idCntrctWkr,
                                                    ROWCCON08SIG00 rowCCON08SIGOO) {

    int nbrCnsvcVersion = rowCCON08SIGOO.getUlNbrCnverVersion() - 1;
    // clss11dQUERYdam
    List<ContractService> contractServiceListPreviousVersion = contractServiceDAO
                                                                                 .findConSvcByIdConAndNbrCnsvcPeriodAndNbrCnsvcVersion(
                                                                                                                                       nbrCnsvcPeriod,
                                                                                                                                       nbrCnsvcVersion,
                                                                                                                                       idContract);

    if (contractServiceListPreviousVersion != null && !contractServiceListPreviousVersion.isEmpty()) {
      // While service rows exist, and the AUD is successful
      // continue adding the previous version's
      // service rows to the new version
      for (Iterator<ContractService> it = contractServiceListPreviousVersion.iterator(); it.hasNext();) {
        ContractService contractService = it.next();

        nbrCnsvcVersion = rowCCON08SIGOO.getUlNbrCnverVersion();
        int nbrCnsvcLineItem = contractService.getNbrCnsvcLineItem();
        String cdCnsvcService = contractService.getCdCnsvcService();
        String cdCnsvcPaymentType = contractService.getCdCnsvcPaymentType();
        String cdCnsvcUnitType = contractService.getCdCnsvcUnitType();

        Date dtLastUpdate = contractService.getDtLastUpdate();
        String indCnsvcNewRow = ArchitectureConstants.N;

        // caud17dAUDdam
        ContractService contractServiceToAdd = new ContractService();
        Contract contract = new Contract();
        contract.setIdContract(idContract);
        Person cntrctWkr = new Person();
        cntrctWkr.setIdPerson(idCntrctWkr);
        contract.setPersonByIdCntrctWkr(cntrctWkr);
        contractServiceToAdd.setContract(getPersistentObject(Contract.class, idContract));
        contractServiceToAdd.setPerson(getPersistentObject(Person.class, idCntrctWkr));
        contractServiceToAdd.setNbrCnsvcPeriod(nbrCnsvcPeriod);
        contractServiceToAdd.setNbrCnsvcVersion(nbrCnsvcVersion);
        contractServiceToAdd.setNbrCnsvcLineItem(nbrCnsvcLineItem);
        contractServiceToAdd.setCdCnsvcService(cdCnsvcService);
        contractServiceToAdd.setCdCnsvcPaymentType(cdCnsvcPaymentType);
        contractServiceToAdd.setIndCnsvcNewRow(indCnsvcNewRow);
        contractServiceToAdd.setCdCnsvcUnitType(cdCnsvcUnitType);
        contractServiceToAdd.setNbrCnsvcFedMatch(contractService.getNbrCnsvcFedMatch());
        contractServiceToAdd.setNbrCnsvcLocalMatch(contractService.getNbrCnsvcLocalMatch());
        contractServiceToAdd.setNbrCnsvcUnitRate(contractService.getNbrCnsvcUnitRate());
        contractServiceToAdd.setAmtCnsvcEquip(contractService.getAmtCnsvcEquip());
        contractServiceToAdd.setAmtCnsvcFrgBenft(contractService.getAmtCnsvcFrgBenft());
        contractServiceToAdd.setAmtCnsvcOther(contractService.getAmtCnsvcOther());
        contractServiceToAdd.setAmtCnsvcSalary(contractService.getAmtCnsvcSalary());
        contractServiceToAdd.setAmtCnsvcSupply(contractService.getAmtCnsvcSupply());
        contractServiceToAdd.setAmtCnsvcTravel(contractService.getAmtCnsvcTravel());
        contractServiceToAdd.setAmtCnsvcUnitRate(contractService.getAmtCnsvcUnitRate());
        contractServiceToAdd.setAmtCnsvcAdminAllUsed(contractService.getAmtCnsvcAdminAllUsed());
        contractServiceToAdd.setAmtCnsvcEquipUsed(contractService.getAmtCnsvcEquipUsed());
        contractServiceToAdd.setAmtCnsvcFrgBenftUsed(contractService.getAmtCnsvcFrgBenftUsed());
        contractServiceToAdd.setAmtCnsvcOffItemUsed(contractService.getAmtCnsvcOffItemUsed());
        contractServiceToAdd.setAmtCnsvcOtherUsed(contractService.getAmtCnsvcOtherUsed());
        contractServiceToAdd.setAmtCnsvcSalaryUsed(contractService.getAmtCnsvcSalaryUsed());
        contractServiceToAdd.setAmtCnsvcSupplyUsed(contractService.getAmtCnsvcSupplyUsed());
        contractServiceToAdd.setAmtCnsvcTravelUsed(contractService.getAmtCnsvcTravelUsed());
        contractServiceToAdd.setAmtCnsvcUnitRateUsed(contractService.getAmtCnsvcUnitRateUsed());
        contractServiceToAdd.setDtLastUpdate(dtLastUpdate);
        contractServiceDAO.saveContractService(contractServiceToAdd);

      }
      // Duplicate County information from information
      // from the previous version
      nbrCnsvcVersion = rowCCON08SIGOO.getUlNbrCnverVersion() - 1;
      // clss37dQUERYdam
      List<ContractCounty> contractCountyList = contractCountyDAO.findContractCounty(idContract, nbrCnsvcPeriod,
                                                                                     nbrCnsvcVersion);
      if (contractCountyList != null && !contractCountyList.isEmpty()) {
        // While county rows exist and no
        // AUD errors occur, continue adding
        // the previous version counties to
        // the new version
        for (Iterator<ContractCounty> it = contractCountyList.iterator(); it.hasNext();) {
          ContractCounty contractCounty = it.next();
          int idCncnty = 0;

          Date dtCncntyEnd = DateHelper.toJavaDate(rowCCON08SIGOO.getDtDtCnverEnd());
          Date dtCncntyEffective = DateHelper.toJavaDate(rowCCON08SIGOO.getDtDtCnverEffective());
          int nbrCncntyVersion = rowCCON08SIGOO.getUlNbrCnverVersion();
          idContract = contractCounty.getContract().getIdContract();
          int idResource = contractCounty.getCapsResource().getIdResource();
          String cdCncntyCounty = contractCounty.getCdCncntyCounty();
          String cdCncntyService = contractCounty.getCdCncntyService();
          int nbrCncntyPeriod = contractCounty.getNbrCncntyPeriod();
          int nbrCncntyLineItem = contractCounty.getNbrCncntyLineItem();
          Date dtLastUpdate = contractCounty.getDtLastUpdate();
          // ContractCountyView contractCountyView = new ContractCountyView();
          // contractCountyView = contractCounty.getContractCountyView();
          // Call saveContractCounty() method to Save ContractCounty information
          saveContractCounty(idCntrctWkr, dtCncntyEnd, idCncnty, idContract, idResource, cdCncntyCounty,
                             cdCncntyService, dtCncntyEffective, dtLastUpdate, nbrCncntyPeriod, nbrCncntyVersion,
                             nbrCncntyLineItem);// , contractCountyView

        }
      }
    }
  }

  // This method saves new ContractCounty information
  private void saveContractCounty(int idCntrctWkr, Date dtCncntyEnd, int idCncnty, int idContract, int idResource,
                                  String cdCncntyCounty, String cdCncntyService, Date dtCncntyEffective,
                                  Date dtLastUpdate, int nbrCncntyPeriod, int nbrCncntyVersion, int nbrCncntyLineItem) {
    // removed this line from the method declaration -,ContractCountyView contractCountyView
    // ContractCountyView contractCountyView is a view and as such i dont believe you write to
    // it
    // caud08dAUDdam
    ContractCounty contractCountyToAdd = new ContractCounty();

    contractCountyToAdd.setContract(getPersistentObject(Contract.class, idContract));
    contractCountyToAdd.setPerson(getPersistentObject(Person.class, idCntrctWkr));
    contractCountyToAdd.setDtCncntyEnd(dtCncntyEnd);
    contractCountyToAdd.setIdCncnty(idCncnty);
    contractCountyToAdd.setCapsResource(getPersistentObject(CapsResource.class, idResource));
    contractCountyToAdd.setCdCncntyCounty(cdCncntyCounty);
    contractCountyToAdd.setCdCncntyService(cdCncntyService);
    contractCountyToAdd.setDtCncntyEffective(dtCncntyEffective);
    contractCountyToAdd.setDtLastUpdate(dtLastUpdate);
    contractCountyToAdd.setNbrCncntyPeriod(nbrCncntyPeriod);
    contractCountyToAdd.setNbrCncntyVersion(nbrCncntyVersion);
    contractCountyToAdd.setNbrCncntyLineItem(nbrCncntyLineItem);
    // contractCountyToAdd.setContractCountyView(contractCountyView);
    contractCountyDAO.saveContractCounty(contractCountyToAdd);
  }

  private void findAndSaveContractCounty(int idContract, int nbrCnsvcPeriod, int idCntrctWkr,
                                         ROWCCON08SIG00 rowCCON08SIGOO) {
    int nbrCnsvcVersion = rowCCON08SIGOO.getUlNbrCnverVersion();
    // clss37dQUERYdam
    List<ContractCounty> contractCountyList = contractCountyDAO.findContractCounty(idContract, nbrCnsvcPeriod,
                                                                                   nbrCnsvcVersion);
    if (contractCountyList != null && !contractCountyList.isEmpty()) {

      // While county rows exist and the AUD is successful,
      // continue adding rows for the new version
      for (Iterator<ContractCounty> it = contractCountyList.iterator(); it.hasNext();) {
        ContractCounty contractCounty = it.next();
        Date dtCncntyEnd = DateHelper.toJavaDate(rowCCON08SIGOO.getDtDtCnverEnd());
        int idCncnty = contractCounty.getIdCncnty();
        idContract = contractCounty.getContract().getIdContract();
        int idResource = contractCounty.getCapsResource().getIdResource();
        String cdCncntyCounty = contractCounty.getCdCncntyCounty();
        String cdCncntyService = contractCounty.getCdCncntyService();
        Date dtCncntyEffective = contractCounty.getDtCncntyEffective();

        // ContractCountyView contractCountyView = new ContractCountyView();
        // contractCountyView = contractCounty.getContractCountyView();

        int nbrCncntyPeriod = contractCounty.getNbrCncntyPeriod();
        int nbrCncntyLineItem = contractCounty.getNbrCncntyLineItem();
        int nbrCncntyVersion = contractCounty.getNbrCncntyVersion();
        Date dtLastUpdate = contractCounty.getDtLastUpdate();
        saveContractCounty(idCntrctWkr, dtCncntyEnd, idCncnty, idContract, idResource, cdCncntyCounty, cdCncntyService,
                           dtCncntyEffective, dtLastUpdate, nbrCncntyPeriod, nbrCncntyVersion, nbrCncntyLineItem);
        // , contractCountyView
      }
    }
  }

  private void findListOfContractPeriod(int idContract, int nbrCnverPeriod, ROWCCON08SIG00_ARRAY rowArray)
                                                                                                          throws ServiceException {
    List<ContractPeriod> contractPeriodList = contractPeriodDAO.findListOfContractPeriodByIdContract(idContract);
    if (contractPeriodList != null && !contractPeriodList.isEmpty()) {
      // Find row returned from CLSS06Dam where Period is equal to
      // Period in the Version List Window
      int index = 0;
      int sizeOfList = contractPeriodList.size();
      for (index = 0; index < sizeOfList
                      && (contractPeriodList.get(index).getId().getNbrCnperPeriod() != nbrCnverPeriod); index++) {

      }
      if (index == sizeOfList) {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }
      // The Closure Date of a Period cannot be before the Effective
      // Date of the latest version in that period (i.e. - the
      // version to be added
      for (Enumeration rowccon08sigooEnum = rowArray.enumerateROWCCON08SIG00(); rowccon08sigooEnum.hasMoreElements();) {
        ROWCCON08SIG00 rowCCON08SIGOO = (ROWCCON08SIG00) rowccon08sigooEnum.nextElement();
        Date closureDate = contractPeriodList.get(index).getDtCnperClosure();
        Date effectiveDate = DateHelper.toJavaDate(rowCCON08SIGOO.getDtDtCnverEffective());
        if (closureDate.before(effectiveDate)) {
          throw new ServiceException(Messages.SSM_VERS_BEFORE_CLOSURE);
        }

      }
    }
  }

  private void updateAndSaveContractVersion(ROWCCON08SIG00 rowCCON08SIGOO, int idCntrctWkr, int idContract,
                                            int nbrCnverPeriod, String bIndReview) throws ServiceException {

    int nbrCnverVersion = rowCCON08SIGOO.getUlNbrCnverVersion();
    int idCnver = rowCCON08SIGOO.getUlIdCnver();
    Date dtCnverEffective = DateHelper.toJavaDate(rowCCON08SIGOO.getDtDtCnverEffective());
    Date dtPrevCnverEffective = DateHelper.toJavaDate(rowCCON08SIGOO.getDtDtPrevCnverEffective());
    Date dtCnverEnd = DateHelper.toJavaDate(rowCCON08SIGOO.getDtDtCnverEnd());
    Date dtCnverCreate = DateHelper.toJavaDate(rowCCON08SIGOO.getDtDtCnverCreate());
    String indCnverVerLock = rowCCON08SIGOO.getCIndCnverVerLock();
    int nbrCnverNoShowPct = rowCCON08SIGOO.getUlNbrCnverNoShowPct();
    String txtCnverComment = rowCCON08SIGOO.getSzTxtCnverComment();
    Date dtLastUpdate = rowCCON08SIGOO.getTsLastUpdate();
    String lastUpdatedBy = rowCCON08SIGOO.getTxtLastUpdatedBy();
    // caud15dAUDdam
    String cdScrDataAction = rowCCON08SIGOO.getSzCdScrDataAction();
    if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(cdScrDataAction)) {
      //STGAP00017058 - update contract version
      if(ServiceConstants.FND_YES.equals(bIndReview)){
        if(dtCnverEffective != null && nbrCnverVersion > 1 && dtCnverEffective.compareTo(dtPrevCnverEffective) != 0){   
            int rowsUpdated = contractVersionDAO.updateContractVersion(idContract, nbrCnverPeriod, nbrCnverVersion - 1,
                                                                       dtLastUpdate, DateHelper.addToDate(dtCnverEffective, 0, 0, -1), 
                                                                       lastUpdatedBy);
              if (rowsUpdated == 0) {
                throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
              }  
        }
      }
      //End STGAP00017058
      int rowsUpdated = contractVersionDAO.updateContractVersion(idContract, nbrCnverPeriod, nbrCnverVersion,
                                                               dtLastUpdate, idCnver, idCntrctWkr, nbrCnverNoShowPct,
                                                               indCnverVerLock, txtCnverComment, dtCnverCreate,
                                                               dtCnverEnd, dtCnverEffective, lastUpdatedBy);
      //STGAP00017053 Update the contract_county also when a new version is added to the contract period
      rowsUpdated = contractCountyDAO.updateContractCounty(idCntrctWkr, dtCnverEffective, dtCnverEnd, idContract, nbrCnverPeriod, nbrCnverVersion);
       
      if (rowsUpdated == 0) {
        throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
      }
    } else if (ServiceConstants.REQ_FUNC_CD_ADD.equals(cdScrDataAction)) {
      ContractVersion contractVersion = new ContractVersion();
      ContractPeriod contractPeriod = new ContractPeriod();
      contractPeriod = contractPeriodDAO.findContractPeriodByIdContractAndNbrCnperPeriod(idContract, nbrCnverPeriod);
      Contract contract = new Contract();
      Person cntrctWkr = new Person();
      cntrctWkr.setIdPerson(idCntrctWkr);
      contract.setPersonByIdCntrctWkr(cntrctWkr);
      contract.setIdContract(idContract);
      contractVersion.setContractPeriod(contractPeriod);
      contractVersion.setNbrCnverVersion(nbrCnverVersion);
      contractVersion.setPerson(getPersistentObject(Person.class, idCntrctWkr));
      contractVersion.setDtCnverCreate(dtCnverCreate);
      contractVersion.setDtCnverEffective(dtCnverEffective);
      contractVersion.setDtCnverEnd(dtCnverEnd);
      contractVersion.setIndCnverVerLock(indCnverVerLock);
      contractVersion.setNbrCnverNoShowPct(nbrCnverNoShowPct);
      contractVersion.setTxtCnverComment(txtCnverComment);
      contractVersion.setDtLastUpdate(dtLastUpdate);
      contractVersionDAO.saveContractVersion(contractVersion);

    } else if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(cdScrDataAction)) {
      complexContractServiceDAO.deleteContractCountyServiceAndVersion(idContract, nbrCnverPeriod, nbrCnverVersion,
                                                                      dtLastUpdate);
    }
  }

  private void findAndUpdateContractService(ROWCCON08SIG00 rowCCON08SIGOO, int idContract, int nbrCnsvcPeriod,
                                            String indCntrctBudgLimit, int idCntrctWkr) throws ServiceException {
    List<ContractService> contractServiceListPreviousVersion = null;
    List<ContractService> contractServiceListCurrentVersion = null;
    if (FIRST_VERSION != rowCCON08SIGOO.getUlNbrCnverVersion()) {
      int nbrCnsvcVersion = (rowCCON08SIGOO.getUlNbrCnverVersion() - 1);
      // clss11dQUERYdam
      contractServiceListPreviousVersion = contractServiceDAO
                                                             .findConSvcByIdConAndNbrCnsvcPeriodAndNbrCnsvcVersion(
                                                                                                                   nbrCnsvcPeriod,
                                                                                                                   nbrCnsvcVersion,
                                                                                                                   idContract);
    }

    if (contractServiceListPreviousVersion == null || contractServiceListPreviousVersion.isEmpty()) {
      throw new ServiceException(Messages.MSG_CON_NO_SERVICES);
    }

    int nbrCnsvcVersion = rowCCON08SIGOO.getUlNbrCnverVersion();
    // clss11dQUERYdam
    contractServiceListCurrentVersion = contractServiceDAO
                                                          .findConSvcByIdConAndNbrCnsvcPeriodAndNbrCnsvcVersion(
                                                                                                                nbrCnsvcPeriod,
                                                                                                                nbrCnsvcVersion,
                                                                                                                idContract);

    if (contractServiceListCurrentVersion == null || contractServiceListCurrentVersion.isEmpty()) {
      throw new ServiceException(Messages.MSG_CON_NO_SERVICES);
    }
    int usServiceRow = 0;
    for (usServiceRow = 0; usServiceRow < contractServiceListPreviousVersion.size();) {

      // As long as the record group element is not blank...
      ContractService contractServicePreviousVersion = null;
      ContractService contractServiceCurrentVersion = null;
      if ((FIRST_VERSION != rowCCON08SIGOO.getUlNbrCnverVersion())
          && (ArchitectureConstants.Y.equals(indCntrctBudgLimit))) {
        contractServicePreviousVersion = contractServiceListPreviousVersion.get(usServiceRow);
        contractServiceCurrentVersion = contractServiceListCurrentVersion.get(usServiceRow);

        if (contractServicePreviousVersion.getAmtCnsvcSalaryUsed() > contractServiceCurrentVersion.getAmtCnsvcSalary()) {
          throw new ServiceException(Messages.MSG_CON_INVALID_BUDG);
        }
        if ((contractServicePreviousVersion.getAmtCnsvcEquipUsed() > contractServiceCurrentVersion.getAmtCnsvcEquip())) {
          throw new ServiceException(Messages.MSG_CON_INVALID_BUDG);
        }
        if ((contractServicePreviousVersion.getAmtCnsvcFrgBenftUsed() > contractServiceCurrentVersion
                                                                                                     .getAmtCnsvcFrgBenft())) {
          throw new ServiceException(Messages.MSG_CON_INVALID_BUDG);
        }

        if ((contractServicePreviousVersion.getAmtCnsvcSupplyUsed() > contractServiceCurrentVersion.getAmtCnsvcSupply())) {
          throw new ServiceException(Messages.MSG_CON_INVALID_BUDG);
        }
        if ((contractServicePreviousVersion.getAmtCnsvcTravelUsed() > contractServiceCurrentVersion.getAmtCnsvcTravel())) {
          throw new ServiceException(Messages.MSG_CON_INVALID_BUDG);
        }
        if (!CodesTables.CCONPAY_CRM.equals(contractServiceCurrentVersion.getCdCnsvcPaymentType())) {
          if ((contractServicePreviousVersion.getAmtCnsvcUnitRateUsed() > contractServiceCurrentVersion
                                                                                                       .getAmtCnsvcUnitRate())) {
            throw new ServiceException(Messages.MSG_CON_INVALID_BUDG);
          }
        }
        if ((contractServicePreviousVersion.getAmtCnsvcOtherUsed() > contractServiceCurrentVersion.getAmtCnsvcOther())) {
          throw new ServiceException(Messages.MSG_CON_INVALID_BUDG);
        }
      }
      nbrCnsvcVersion = rowCCON08SIGOO.getUlNbrCnverVersion();
      int nbrCnsvcLineItem = contractServiceCurrentVersion.getNbrCnsvcLineItem();

      int idCnsvc = 0;
      idCnsvc = contractServiceCurrentVersion.getIdCnsvc();
      String cdCnsvcService = contractServiceCurrentVersion.getCdCnsvcService();
      String cdCnsvcPaymentType = contractServiceCurrentVersion.getCdCnsvcPaymentType();
      String cdCnsvcUnitType = contractServiceCurrentVersion.getCdCnsvcUnitType();
      int nbrCnsvcFedMatch = contractServiceCurrentVersion.getNbrCnsvcFedMatch();
      int nbrCnsvcLocalMatch = contractServiceCurrentVersion.getNbrCnsvcLocalMatch();
      double nbrCnsvcUnitRate = contractServiceCurrentVersion.getNbrCnsvcUnitRate();
      double amtCnsvcEquip = contractServiceCurrentVersion.getAmtCnsvcEquip();
      double amtCnsvcFrgBenft = contractServiceCurrentVersion.getAmtCnsvcFrgBenft();
      double amtCnsvcOther = contractServiceCurrentVersion.getAmtCnsvcOther();
      double amtCnsvcSalary = contractServiceCurrentVersion.getAmtCnsvcSalary();
      double amtCnsvcSupply = contractServiceCurrentVersion.getAmtCnsvcSupply();
      double amtCnsvcTravel = contractServiceCurrentVersion.getAmtCnsvcTravel();
      double amtCnsvcUnitRate = contractServiceCurrentVersion.getAmtCnsvcUnitRate();
      Date dtLastUpdate = contractServiceCurrentVersion.getDtLastUpdate();
      double amtCnsvcAdminAllUsed = 0;
      double amtCnsvcEquipUsed = 0;
      double amtCnsvcFrgBenftUsed = 0;
      double amtCnsvcOffItemUsed = 0;
      double amtCnsvcOtherUsed = 0;
      double amtCnsvcSalaryUsed = 0;
      double amtCnsvcSupplyUsed = 0;
      double amtCnsvcTravelUsed = 0;
      double amtCnsvcUnitRateUsed = 0;

      if (FIRST_VERSION != rowCCON08SIGOO.getUlNbrCnverVersion()) {
        amtCnsvcAdminAllUsed = contractServicePreviousVersion.getAmtCnsvcAdminAllUsed();
        amtCnsvcEquipUsed = contractServicePreviousVersion.getAmtCnsvcEquipUsed();
        amtCnsvcFrgBenftUsed = contractServicePreviousVersion.getAmtCnsvcFrgBenftUsed();
        amtCnsvcOffItemUsed = contractServicePreviousVersion.getAmtCnsvcOffItemUsed();
        amtCnsvcOtherUsed = contractServicePreviousVersion.getAmtCnsvcOtherUsed();
        amtCnsvcSalaryUsed = contractServicePreviousVersion.getAmtCnsvcSalaryUsed();
        amtCnsvcSupplyUsed = contractServicePreviousVersion.getAmtCnsvcSupplyUsed();
        amtCnsvcTravelUsed = contractServicePreviousVersion.getAmtCnsvcTravelUsed();
        amtCnsvcUnitRateUsed = contractServicePreviousVersion.getAmtCnsvcUnitRateUsed();
      } else {
        amtCnsvcAdminAllUsed = contractServiceCurrentVersion.getAmtCnsvcAdminAllUsed();
        amtCnsvcEquipUsed = contractServiceCurrentVersion.getAmtCnsvcEquipUsed();
        amtCnsvcFrgBenftUsed = contractServiceCurrentVersion.getAmtCnsvcFrgBenftUsed();
        amtCnsvcOffItemUsed = contractServiceCurrentVersion.getAmtCnsvcOffItemUsed();
        amtCnsvcOtherUsed = contractServiceCurrentVersion.getAmtCnsvcOtherUsed();
        amtCnsvcSalaryUsed = contractServiceCurrentVersion.getAmtCnsvcSalaryUsed();
        amtCnsvcSupplyUsed = contractServiceCurrentVersion.getAmtCnsvcSupplyUsed();
        amtCnsvcTravelUsed = contractServiceCurrentVersion.getAmtCnsvcTravelUsed();
        amtCnsvcUnitRateUsed = contractServiceCurrentVersion.getAmtCnsvcUnitRateUsed();
      }
      String indCnsvcNewRow = ArchitectureConstants.N;
      // caud17dAUDdam
      int rowsUpdated = contractServiceDAO.updateContractService(idContract, idCntrctWkr, nbrCnsvcPeriod,
                                                                 nbrCnsvcVersion, nbrCnsvcLineItem, cdCnsvcService,
                                                                 cdCnsvcPaymentType, indCnsvcNewRow, cdCnsvcUnitType,
                                                                 nbrCnsvcFedMatch, nbrCnsvcLocalMatch,
                                                                 nbrCnsvcUnitRate, amtCnsvcAdminAllUsed, amtCnsvcEquip,
                                                                 amtCnsvcEquipUsed, amtCnsvcFrgBenft,
                                                                 amtCnsvcFrgBenftUsed, amtCnsvcOffItemUsed,
                                                                 amtCnsvcOther, amtCnsvcOtherUsed, amtCnsvcSalary,
                                                                 amtCnsvcSalaryUsed, amtCnsvcSupply,
                                                                 amtCnsvcSupplyUsed, amtCnsvcTravel,
                                                                 amtCnsvcTravelUsed, amtCnsvcUnitRate,
                                                                 amtCnsvcUnitRateUsed, dtLastUpdate, idCnsvc);
      if (rowsUpdated == 0) {
        throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
      }
      usServiceRow++;
    }

    // Service New Row processing
    // At this point all of the services that
    // existed for the previous version have been
    // updated with the necessary worker, new row
    // and amount used fields. Now we need to update
    // any rows that exist for our current version
    // that did not exist for the previous version
    // with the no row of No and the worker informaiton.
    // This section is necessary in order set
    // the contract worker to the current worker
    // and set the new row indicator to No.
    // Note: start counter at CLSS11DPreviousVersion
    // ulRowQty since we are continuing to process
    // service rows that did not exist for the
    // previous version, but exist for our new version
    for (Iterator<ContractService> it = contractServiceListCurrentVersion.iterator(); it.hasNext();) {
      ContractService contractServiceCurrentVersion = it.next();
      nbrCnsvcVersion = rowCCON08SIGOO.getUlNbrCnverVersion();
      int nbrCnsvcLineItem = contractServiceCurrentVersion.getNbrCnsvcLineItem();
      int idCnsvc = contractServiceCurrentVersion.getIdCnsvc();
      String cdCnsvcService = contractServiceCurrentVersion.getCdCnsvcService();
      String cdCnsvcPaymentType = contractServiceCurrentVersion.getCdCnsvcPaymentType();
      String cdCnsvcUnitType = contractServiceCurrentVersion.getCdCnsvcUnitType();
      int nbrCnsvcFedMatch = contractServiceCurrentVersion.getNbrCnsvcFedMatch();
      int nbrCnsvcLocalMatch = contractServiceCurrentVersion.getNbrCnsvcLocalMatch();
      double nbrCnsvcUnitRate = contractServiceCurrentVersion.getNbrCnsvcUnitRate();
      double amtCnsvcEquip = contractServiceCurrentVersion.getAmtCnsvcEquip();
      double amtCnsvcFrgBenft = contractServiceCurrentVersion.getAmtCnsvcFrgBenft();
      double amtCnsvcOther = contractServiceCurrentVersion.getAmtCnsvcOther();
      double amtCnsvcSalary = contractServiceCurrentVersion.getAmtCnsvcSalary();
      double amtCnsvcSupply = contractServiceCurrentVersion.getAmtCnsvcSupply();
      double amtCnsvcTravel = contractServiceCurrentVersion.getAmtCnsvcTravel();
      double amtCnsvcUnitRate = contractServiceCurrentVersion.getAmtCnsvcUnitRate();
      Date dtLastUpdate = contractServiceCurrentVersion.getDtLastUpdate();
      double amtCnsvcAdminAllUsed = contractServiceCurrentVersion.getAmtCnsvcAdminAllUsed();
      double amtCnsvcEquipUsed = contractServiceCurrentVersion.getAmtCnsvcEquipUsed();
      double amtCnsvcFrgBenftUsed = contractServiceCurrentVersion.getAmtCnsvcFrgBenftUsed();
      double amtCnsvcOffItemUsed = contractServiceCurrentVersion.getAmtCnsvcOffItemUsed();
      double amtCnsvcOtherUsed = contractServiceCurrentVersion.getAmtCnsvcOtherUsed();
      double amtCnsvcSalaryUsed = contractServiceCurrentVersion.getAmtCnsvcSalaryUsed();
      double amtCnsvcSupplyUsed = contractServiceCurrentVersion.getAmtCnsvcSupplyUsed();
      double amtCnsvcTravelUsed = contractServiceCurrentVersion.getAmtCnsvcTravelUsed();
      double amtCnsvcUnitRateUsed = contractServiceCurrentVersion.getAmtCnsvcUnitRateUsed();
      String indCnsvcNewRow = ArchitectureConstants.N;
      // caud17dAUDdam
      int rowsUpdated = contractServiceDAO.updateContractService(idContract, idCntrctWkr, nbrCnsvcPeriod,
                                                                 nbrCnsvcVersion, nbrCnsvcLineItem, cdCnsvcService,
                                                                 cdCnsvcPaymentType, indCnsvcNewRow, cdCnsvcUnitType,
                                                                 nbrCnsvcFedMatch, nbrCnsvcLocalMatch,
                                                                 nbrCnsvcUnitRate, amtCnsvcAdminAllUsed, amtCnsvcEquip,
                                                                 amtCnsvcEquipUsed, amtCnsvcFrgBenft,
                                                                 amtCnsvcFrgBenftUsed, amtCnsvcOffItemUsed,
                                                                 amtCnsvcOther, amtCnsvcOtherUsed, amtCnsvcSalary,
                                                                 amtCnsvcSalaryUsed, amtCnsvcSupply,
                                                                 amtCnsvcSupplyUsed, amtCnsvcTravel,
                                                                 amtCnsvcTravelUsed, amtCnsvcUnitRate,
                                                                 amtCnsvcUnitRateUsed, dtLastUpdate, idCnsvc);
      if (rowsUpdated == 0) {
        throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
      }
      usServiceRow++;
    }
  }

  public void setComplexCapsResourceDAO(ComplexCapsResourceDAO complexCapsResourceDAO) {
    this.complexCapsResourceDAO = complexCapsResourceDAO;
  }
}
