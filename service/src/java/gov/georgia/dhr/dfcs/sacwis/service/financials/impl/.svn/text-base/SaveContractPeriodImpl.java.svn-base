package gov.georgia.dhr.dfcs.sacwis.service.financials.impl;

/** Change History:
 **  Date        User              Description
 **  --------    ----------------  --------------------------------------------------
 **  08/05/2008  charden           STGAP00009788 - created new methods saveContractCountyInfo() and 
 *                                 saveContractCounty() to populate the ContractCounty table with 
 *                                 info from new period so that the checkboxes on the contractServiceDetail
 *                                 page will automatically be checked 
 *   12/21/2009  mxpatel           SMS# 37346: modified code so that when start date of contract period changes, 
 *                                 contract county also changes.                
 *   11/12/2011  charden           STGAP00017058 - adding code to update period and versions
 *                                 
 **/

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexCapsResourceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexContractPeriodDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ContractCountyDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ContractPeriodDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ContractServiceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ContractVersionDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EquivalencyDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CapsResource;
import gov.georgia.dhr.dfcs.sacwis.db.Contract;
import gov.georgia.dhr.dfcs.sacwis.db.ContractCounty;
import gov.georgia.dhr.dfcs.sacwis.db.ContractPeriod;
import gov.georgia.dhr.dfcs.sacwis.db.ContractPeriodId;
import gov.georgia.dhr.dfcs.sacwis.db.ContractService;
import gov.georgia.dhr.dfcs.sacwis.db.ContractVersion;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.service.financials.SaveContractPeriod;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON06SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCON06SIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON06SO;

import java.util.Date;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

public class SaveContractPeriodImpl extends BaseServiceImpl implements SaveContractPeriod {

  public static final String PERIOD_ADDED = "A new period has been added.";

  private ComplexCapsResourceDAO complexCapsResourceDAO = null;

  private ContractVersionDAO contractVersionDAO = null;

  private ContractPeriodDAO contractPeriodDAO = null;

  private ComplexContractPeriodDAO complexContractPeriodDAO = null;

  private ContractServiceDAO contractServiceDAO = null;

  private EquivalencyDAO equivalencyDAO = null;

  private ContractCountyDAO contractCountyDAO = null;

  public void setContractVersionDAO(ContractVersionDAO contractVersionDAO) {
    this.contractVersionDAO = contractVersionDAO;
  }

  public void setContractCountyDAO(ContractCountyDAO contractCountyDAO) {
    this.contractCountyDAO = contractCountyDAO;
  }

  public void setEquivalencyDAO(EquivalencyDAO equivalencyDAO) {
    this.equivalencyDAO = equivalencyDAO;
  }

  public void setContractPeriodDAO(ContractPeriodDAO contractPeriodDAO) {
    this.contractPeriodDAO = contractPeriodDAO;
  }

  public void setContractServiceDAO(ContractServiceDAO contractServiceDAO) {
    this.contractServiceDAO = contractServiceDAO;
  }

  public void setComplexContractPeriodDAO(ComplexContractPeriodDAO complexContractPeriodDAO) {
    this.complexContractPeriodDAO = complexContractPeriodDAO;
  }

  public CCON06SO saveContractPeriod(CCON06SI ccon06si) throws ServiceException {
    CCON06SO ccon06so = new CCON06SO();
    
    ContractVersion latestContractVersion = null;

    // loop thru list of periods
    for (Enumeration rowccon06sigooEnum = ccon06si.getROWCCON06SIG00_ARRAY().enumerateROWCCON06SIG00(); rowccon06sigooEnum.hasMoreElements();) {
      // get the period
      ROWCCON06SIG00 rowccon06sigoo = (ROWCCON06SIG00) rowccon06sigooEnum.nextElement();
      
      boolean isValidStartDt = DateHelper.isValidDate(rowccon06sigoo.getDtDtCnperStart());
      boolean isValidEndDt = DateHelper.isValidDate(rowccon06sigoo.getDtDtCnperTerm());
      

      //make sure the end date of the period is not before the start date of the version (if so, this method throws a service exception)
      findLatestContractVersion(rowccon06sigoo, ccon06si.getUlIdContract());

      // get the data action (is this an add or an update?)
      String cdScrDataAction = rowccon06sigoo.getSzCdScrDataAction();
      // update/delete the contract period
      if (!ServiceConstants.REQ_FUNC_CD_ADD.equals(cdScrDataAction)) {
        //STGAP00017058 - adding code to update period and versions and validate dates
        if(ServiceConstants.FND_YES.equals(ccon06si.getBIndReview())){
          // get the contract period
          ContractPeriod latestContractPeriod = contractPeriodDAO.findContractPeriodByIdContractAndNbrCnperPeriod(ccon06si.getUlIdContract(), rowccon06sigoo.getUlNbrCnperPeriod());
          //check to see if contract period dates have updated
          if(latestContractPeriod != null && rowccon06sigoo != null && !DateHelper.isNull(rowccon06sigoo.getDtDtCnperClosure())
                          && !DateHelper.isNull(rowccon06sigoo.getDtDtCnperStart()) && !DateHelper.isNull(rowccon06sigoo.getDtDtCnperTerm())){
            if(DateHelper.toJavaDate(rowccon06sigoo.getDtDtCnperClosure()).compareTo(latestContractPeriod.getDtCnperClosure()) != 0 
                            || DateHelper.toJavaDate(rowccon06sigoo.getDtDtCnperStart()).compareTo(latestContractPeriod.getDtCnperStart())  != 0
                            || DateHelper.toJavaDate(rowccon06sigoo.getDtDtCnperTerm()).compareTo(latestContractPeriod.getDtCnperTerm()) != 0){
              
              
              // get the latest version for the contract period
              ContractVersion contractVersionLatest = contractVersionDAO.findLatestContractVersion(ccon06si.getUlIdContract(), rowccon06sigoo.getUlNbrCnperPeriod());
              
              // end date cannot be within two days of current version's effective/start date
              if (isValidEndDt && (DateHelper.toJavaDate(rowccon06sigoo.getDtDtCnperClosure()).compareTo(DateHelper.addToDate(contractVersionLatest.getDtCnverEffective(), 0, 0, 2))) < 0){
                //TODO change message to MSG_END_DT_TWO_DAYS
                throw new ServiceException(Messages.MSG_END_DT_TWO_DAYS);
              }
              
              // get the previous period to make sure start date is not on or the same as the start date of the previous period
              // and that the start date is not the same as the previous period's end date
              if (rowccon06sigoo.getUlNbrCnperPeriod() > 1) {
                ContractPeriod previousContractPeriod = contractPeriodDAO.findContractPeriodByIdContractAndNbrCnperPeriod(ccon06si.getUlIdContract(),rowccon06sigoo.getUlNbrCnperPeriod() - 1);
                if (previousContractPeriod != null) {
                  if (isValidStartDt && DateHelper.toJavaDate(rowccon06sigoo.getDtDtCnperStart()).compareTo(previousContractPeriod.getDtCnperTerm()) == 0) {
                    //TODO change message to MSG_SAME_EFF_AND_END_DT
                    throw new ServiceException(Messages.MSG_SAME_EFF_AND_END_DT);
                  }
                  if (isValidStartDt && DateHelper.toJavaDate(rowccon06sigoo.getDtDtCnperStart()).compareTo(previousContractPeriod.getDtCnperStart()) <= 0) {
                    //TODO change message to MSG_EFF_DT_SAME_PREV_EFF_DT
                    throw new ServiceException(Messages.MSG_EFF_DT_SAME_PREV_EFF_DT);
                  }
                  
                  // get the latest version for the previous contract period
                  ContractVersion prevPeriodLatestContractVersion = contractVersionDAO.findLatestContractVersion(ccon06si.getUlIdContract(), rowccon06sigoo.getUlNbrCnperPeriod() - 1);

                  // update previous period's early termination and end dates
                  if(DateHelper.isValidDate(rowccon06sigoo.getDtDtCnperStart())){
                    contractPeriodDAO.updateContractPeriod((int)previousContractPeriod.getPerson().getIdPerson(), previousContractPeriod.getCdCnperStatus(),
                                                           previousContractPeriod.getDtCnperStart(), DateHelper.toJavaDate(DateHelper.addToDate(rowccon06sigoo.getDtDtCnperStart(), 0, 0, -1)),
                                                           DateHelper.toJavaDate(DateHelper.addToDate(rowccon06sigoo.getDtDtCnperStart(), 0, 0, -1)), previousContractPeriod.getIndCnperRenewal(), previousContractPeriod.getIndCnperSigned(),
                                                           previousContractPeriod.getNbrLegalIdentifier() == null ? 0 : previousContractPeriod.getNbrLegalIdentifier(), new Date(),
                                                           ccon06si.getUlIdContract(), rowccon06sigoo.getUlNbrCnperPeriod() - 1, rowccon06sigoo.getTxtLastUpdatedBy(), rowccon06sigoo.getTxtLastUpdatedBy());
                  
                   // update start and end date of most current version of previous period
                    updateContractVersion(ccon06si.getUlIdContract(), prevPeriodLatestContractVersion, rowccon06sigoo.getUlNbrCnperPeriod() - 1, 
                                          prevPeriodLatestContractVersion.getDtCnverEffective(), DateHelper.toJavaDate(DateHelper.addToDate(rowccon06sigoo.getDtDtCnperStart(), 0, 0, -1)), rowccon06sigoo.getTxtLastUpdatedBy());
                  }
                  
                }
              }

              // get list of contract versions for the period
              List<ContractVersion> contractVersionList = contractVersionDAO.findContractVersionByIdContractAndNbrCnperPeriod(ccon06si.getUlIdContract(), rowccon06sigoo.getUlNbrCnperPeriod());
              
              // If there are multiple versions, update the start date of the first and the end
              // date of the last version. If there is only one version, update the start and end date of the single version
              if(contractVersionList != null && contractVersionList.size() > 1){
                // get the first contract version from the list (contractVersionList is sorted desc so the last ContractVersion in the list is the first one created)
                ContractVersion firstContractVersion = contractVersionList.get(contractVersionList.size() - 1);
                
                // update start date of first version
                updateContractVersion(ccon06si.getUlIdContract(), firstContractVersion, rowccon06sigoo.getUlNbrCnperPeriod(), 
                                      DateHelper.toJavaDate(rowccon06sigoo.getDtDtCnperStart()), firstContractVersion.getDtCnverEnd(), rowccon06sigoo.getTxtLastUpdatedBy());
                
                // update end date of most current version
                updateContractVersion(ccon06si.getUlIdContract(), contractVersionLatest, rowccon06sigoo.getUlNbrCnperPeriod(), 
                                      contractVersionLatest.getDtCnverEffective(), DateHelper.toJavaDate(rowccon06sigoo.getDtDtCnperTerm()), rowccon06sigoo.getTxtLastUpdatedBy());
              }else{
                // update start and end date of most current version
                updateContractVersion(ccon06si.getUlIdContract(), contractVersionLatest, rowccon06sigoo.getUlNbrCnperPeriod(), 
                                      DateHelper.toJavaDate(rowccon06sigoo.getDtDtCnperStart()), DateHelper.toJavaDate(rowccon06sigoo.getDtDtCnperTerm()), rowccon06sigoo.getTxtLastUpdatedBy());
              }
            }
          }
      }
        // End STGAP00017058
        
        updateOrDeleteContractPeriod(rowccon06sigoo, ccon06si.getUlIdContract(), ccon06si.getUlIdCntrctWkr());
      }

      ContractVersion contractVersionLatest = null;

      // If the contract Period to add is not the first one, execute this condition
      if (rowccon06sigoo.getUlNbrCnperPeriod() > 1 && ServiceConstants.REQ_FUNC_CD_ADD.equals(cdScrDataAction)) {
        // get the id of the contract
        int idContract = ccon06si.getUlIdContract();

        // Save the new Contract Period
        saveContractPeriod(rowccon06sigoo, ccon06si.getUlIdContract(), ccon06si.getUlIdCntrctWkr());
        // Get the last contract period number
        int nbrCnverPeriod = rowccon06sigoo.getUlNbrCnperPeriod() - 1;
        // Retrieve the latest contract version from the last period
        contractVersionLatest = contractVersionDAO.findLatestContractVersion(idContract, nbrCnverPeriod);
        // Save the new contract version and contract service with the values from the last contract version.
        saveContractVersionAndContractService(contractVersionLatest, rowccon06sigoo, ccon06si.getUlIdContract(),
                                              ccon06si.getUlIdCntrctWkr(), ccon06si.getSzCdCntrctFuncType());
        
      } else if (rowccon06sigoo.getUlNbrCnperPeriod() == 1 && ServiceConstants.REQ_FUNC_CD_ADD.equals(cdScrDataAction)) {
        // This condition executes when a first contract period is added
        // Save the contract period, then the contract version.
        ContractPeriod newlySavedContractPeriod = saveContractPeriod(rowccon06sigoo, ccon06si.getUlIdContract(),
                                                                     ccon06si.getUlIdCntrctWkr());
        saveContractVersion(newlySavedContractPeriod, rowccon06sigoo, ccon06si.getUlIdContract(),
                            ccon06si.getUlIdCntrctWkr());
      }

      if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(cdScrDataAction) && rowccon06sigoo.getUlNbrCnperPeriod() == 1
          && ArchitectureConstants.Y.equals(ccon06si.getCIndRsrcTransport())) {
        findAndSaveContractCounty(rowccon06sigoo, ccon06si.getUlIdContract(), ccon06si.getUlIdCntrctWkr(), ccon06si.getBIndReview());
      }

      //if this is an update or if this is the first period and it's been signed
      if ((ServiceConstants.REQ_FUNC_CD_UPDATE.equals(cdScrDataAction))
          || (rowccon06sigoo.getUlNbrCnperPeriod() == 1 && ArchitectureConstants.Y == rowccon06sigoo
                                                                                                    .getCIndCnperSigned())) {
        // get the latest version of the contract
        contractVersionLatest = contractVersionDAO.findLatestContractVersion(ccon06si.getUlIdContract(), rowccon06sigoo.getUlNbrCnperPeriod());
        // update the version of the contract
        updateAndSaveContractVersionandContractCounty(contractVersionLatest, rowccon06sigoo,
                                                      ccon06si.getUlIdContract(), ccon06si.getUlIdCntrctWkr(),
                                                      ccon06si.getCIndRsrcTransport(), ccon06si.getBIndReview());
      }
      latestContractVersion = contractVersionLatest;
      //STGAP00009788 - if a period already exists and a new period is being added, call new method, saveContractCountyInfo(), to retrieve info about former
      //period from database and use it to populate the new contractCounty object that will be saved for this period
      if ((rowccon06sigoo.getUlNbrCnperPeriod() > 1)
                      && (ServiceConstants.REQ_FUNC_CD_ADD.equals(rowccon06sigoo.getSzCdScrDataAction()))) {
      saveContractCountyInfo(latestContractVersion.getNbrCnverVersion(), rowccon06sigoo, ccon06si, latestContractVersion );
      }
    }
    
    //update the status of the resource (whether it's active or not) since we just made changes to the period and version
    complexCapsResourceDAO.updateResourceIndRsrcContracted(ccon06si.getUlIdContract());

    return ccon06so;
  }
  
  private void updateContractVersion(int ulIdContract, ContractVersion contractVersion, int ulNbrCnperPeriod, Date dtCnverEffective, Date dtCnverEnd, String lastUpdatedBy) {
    // update the contract version
    contractVersionDAO.updateContractVersion(contractVersion.getPerson().getIdPerson(), dtCnverEffective, dtCnverEnd, contractVersion.getIndCnverVerLock(),
                                             ulIdContract, ulNbrCnperPeriod, contractVersion.getNbrCnverVersion(), lastUpdatedBy);
  }

  //STGAP00009788 - new method to gather info for contrctCounty object to save to contractCounty table
  private void saveContractCountyInfo(int nbrCnsvcVersion, ROWCCON06SIG00 rowccon06sigoo, CCON06SI ccon06si,
                                      ContractVersion latestContractVersion) {
    // Duplicate County information from information
    // from the previous version
    int nbrCnsvcPeriod = rowccon06sigoo.getUlNbrCnperPeriod() > 1 ?  rowccon06sigoo.getUlNbrCnperPeriod() - 1 : rowccon06sigoo.getUlNbrCnperPeriod();

    List<ContractCounty> contractCountyList = contractCountyDAO.findContractCounty(ccon06si.getUlIdContract(),
                                                                                   nbrCnsvcPeriod, nbrCnsvcVersion);
    if (contractCountyList != null && !contractCountyList.isEmpty()) {
      // While county rows exist and no
      // AUD errors occur, continue adding
      // the previous version counties to
      // the new version
      for (Iterator<ContractCounty> it = contractCountyList.iterator(); it.hasNext();) {
        ContractCounty contractCounty = it.next();
        int idCncnty = 0;
        GregorianCalendar gc1 = new GregorianCalendar();
        Date sysDate = gc1.getTime();

        Date dtCncntyEnd = DateHelper.toJavaDate(rowccon06sigoo.getDtDtCnperTerm());
        Date dtCncntyEffective = DateHelper.toJavaDate(rowccon06sigoo.getDtDtCnperStart());
        int nbrCncntyVersion = 1;
        int idContract = contractCounty.getContract().getIdContract();
        int idResource = contractCounty.getCapsResource().getIdResource();
        String cdCncntyCounty = contractCounty.getCdCncntyCounty();
        String cdCncntyService = contractCounty.getCdCncntyService();
        int nbrCncntyPeriod = rowccon06sigoo.getUlNbrCnperPeriod();
        int nbrCncntyLineItem = contractCounty.getNbrCncntyLineItem();
        Date dtLastUpdate = contractCounty.getDtLastUpdate() != null ? contractCounty.getDtLastUpdate() : sysDate;
        saveContractCounty(ccon06si.getUlIdCntrctWkr(), dtCncntyEnd, idCncnty, idContract, idResource, cdCncntyCounty,
                           cdCncntyService, dtCncntyEffective, dtLastUpdate, nbrCncntyPeriod, nbrCncntyVersion,
                           nbrCncntyLineItem);

      }
    }
  }

  private void findLatestContractVersion(ROWCCON06SIG00 rowccon06sigoo, int idContract) throws ServiceException {
    // if this is an update or if this is a signed, first period
    if ((ServiceConstants.REQ_FUNC_CD_UPDATE.equals(rowccon06sigoo.getSzCdScrDataAction()))
        || (rowccon06sigoo.getUlNbrCnperPeriod() == 1 && ArchitectureConstants.Y.equals(rowccon06sigoo.getCIndCnperSigned()))) {
      
      // get the period number
      int nbrCnperPeriod = rowccon06sigoo.getUlNbrCnperPeriod();
      // get the most recent contract version for the contract period
      ContractVersion contractVersion = contractVersionDAO.findLatestContractVersion(idContract, nbrCnperPeriod);

      if (contractVersion != null) {
        // if the end date of the period is less than the start date of the version, throw an error
        Date effectiveDate = contractVersion.getDtCnverEffective();
        Date closureDate = DateHelper.toJavaDate(rowccon06sigoo.getDtDtCnperClosure());
        int result = closureDate.compareTo(effectiveDate);
        if (result <= 0) {
          throw new ServiceException(Messages.SSM_INVD_CLOSURE_DT);
        }
      }
    }
  }

  private void updateOrDeleteContractPeriod(ROWCCON06SIG00 rowccon06sigoo, int idContract, int idCntrctWkr)throws ServiceException {
    // create variable to ensure row is updated
    int rowsUpdated = 0;
    
    // get page data from row
    int nbrCnperPeriod = rowccon06sigoo.getUlNbrCnperPeriod();
    Date dtCnperClosure = DateHelper.toJavaDate(rowccon06sigoo.getDtDtCnperClosure());
    Date dtCnperStart = DateHelper.toJavaDate(rowccon06sigoo.getDtDtCnperStart());
    Date dtCnperTerm = DateHelper.toJavaDate(rowccon06sigoo.getDtDtCnperTerm());
    String cdCnperStatus = rowccon06sigoo.getSzCdCnperStatus();
    int nbrLegalIdentifier = rowccon06sigoo.getUlNbrLegalIdentifier();
    String indCnperRenewal = rowccon06sigoo.getCIndCnperRenewal();
    String indCnperSigned = rowccon06sigoo.getCIndCnperSigned();
    Date dtLastUpdate = rowccon06sigoo.getTsLastUpdate();
    String txtTermComm = rowccon06sigoo.getSzTxtCnperClosureCmt();
    String cdScrDataAction = rowccon06sigoo.getSzCdScrDataAction();
    String lastUpdatedBy = rowccon06sigoo.getTxtLastUpdatedBy();
    
    // update/delete the contract period
    if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(cdScrDataAction)) {
      rowsUpdated = contractPeriodDAO.updateContractPeriod(idCntrctWkr, cdCnperStatus, dtCnperStart, dtCnperTerm,
                                                           dtCnperClosure, indCnperRenewal, indCnperSigned,
                                                           nbrLegalIdentifier, dtLastUpdate, idContract,
                                                           nbrCnperPeriod, txtTermComm, lastUpdatedBy);
    } else if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(cdScrDataAction)) {
      rowsUpdated = complexContractPeriodDAO.deleteContractPeriod(idContract, nbrCnperPeriod, 0, dtLastUpdate);
    }
    if (rowsUpdated == 0) {
      throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
    }
  }

  // create new version for the new period and copy over the services from the previous period's most recent version to this new version
  private void saveContractVersionAndContractService(ContractVersion contractVersionLatest,
                                                     ROWCCON06SIG00 rowccon06sigoo, int idContract, int idCntrctWkr,
                                                     String cdCntrctFuncType) throws ServiceException {
    if (contractVersionLatest != null) {
      if (ArchitectureConstants.Y.equals(contractVersionLatest.getIndCnverVerLock())) {
        int nbrCnverPeriod = rowccon06sigoo.getUlNbrCnperPeriod();
        int nbrCnverVersion = 1;
        Date dtCnverCreate = new Date();

        Date dtCnverEffective = DateHelper.toJavaDate(rowccon06sigoo.getDtDtCnperStart());
        Date dtCnverEnd = DateHelper.toJavaDate(rowccon06sigoo.getDtDtCnperTerm());
        String indCnverVerLock = null;
        if (ArchitectureConstants.N.equals(rowccon06sigoo.getCIndCnperSigned())) {
          indCnverVerLock = ArchitectureConstants.N;
        } else {
          indCnverVerLock = ArchitectureConstants.Y;
        }

        String txtCnverComment = PERIOD_ADDED;
        // caud15dAUDdam
        ContractVersion contractVersion = new ContractVersion();
        ContractPeriod contractPeriod = contractPeriodDAO.findContractPeriodByIdContractAndNbrCnperPeriod(idContract, nbrCnverPeriod);
        contractVersion.setNbrCnverVersion(nbrCnverVersion);
        contractVersion.setPerson(getPersistentObject(Person.class, idCntrctWkr));
        contractVersion.setContractPeriod(contractPeriod);
        contractVersion.setDtCnverCreate(dtCnverCreate);
        contractVersion.setDtCnverEffective(dtCnverEffective);
        contractVersion.setDtCnverEnd(dtCnverEnd);
        contractVersion.setIndCnverVerLock(indCnverVerLock);
        contractVersion.setTxtCnverComment(txtCnverComment);
        contractVersionDAO.saveContractVersion(contractVersion);

        int nbrCnsvcPeriod = rowccon06sigoo.getUlNbrCnperPeriod() - 1;
        int nbrCnsvcVersion = contractVersionLatest.getNbrCnverVersion(); // contractVersion.getNbrCnverVersion();
        // clss11dQUERYdam
        List<ContractService> contractServiceList = contractServiceDAO
                                                                      .findConSvcByIdConAndNbrCnsvcPeriodAndNbrCnsvcVersion(
                                                                                                                            nbrCnsvcPeriod,
                                                                                                                            nbrCnsvcVersion,
                                                                                                                            idContract);
        if (contractServiceList == null || contractServiceList.isEmpty()) {
          throw new ServiceException(Messages.MSG_CON_INVLD_PER);
        }

        // -- iterate thru contractServices for the latest version of the previous period
        // -- and copy them for the new version of the new period
        for (Iterator<ContractService> it = contractServiceList.iterator(); it.hasNext();) {
          ContractService existingCS = it.next();
          long sysNbrGenericCntr = 0;
          if (CodesTables.CCONFUNC_FAD.equals(cdCntrctFuncType) || CodesTables.CCONFUNC_FAC.equals(cdCntrctFuncType)) {
            sysNbrGenericCntr = 1;
          } else {
            String cdEquivSvcDtlService = existingCS.getCdCnsvcService();
            Date dtEquivStartDate = DateHelper.toJavaDate(rowccon06sigoo.getDtDtCnperStart());
            Date dtEquivEndDate = DateHelper.toJavaDate(rowccon06sigoo.getDtDtCnperTerm());
            // cmsc52d
            sysNbrGenericCntr = equivalencyDAO.countExistenceOfServiceCodeFromEquivalency(cdEquivSvcDtlService,
                                                                                          dtEquivStartDate,
                                                                                          dtEquivEndDate);

            if (sysNbrGenericCntr < 1) {
              // cmsc52d
              long nonEquivalencyResult = equivalencyDAO.countExemptServiceCodeFromNonEquivalency(cdEquivSvcDtlService,
                                                                                                  dtEquivStartDate,
                                                                                                  dtEquivEndDate);
              if (nonEquivalencyResult == 0) {
                throw new ServiceException(Messages.SQL_NOT_FOUND);
              }
            }
          }

          if (sysNbrGenericCntr >= 1) {
            nbrCnsvcPeriod = rowccon06sigoo.getUlNbrCnperPeriod();
            nbrCnsvcVersion = 1;
            int nbrCnsvcLineItem = existingCS.getNbrCnsvcLineItem();
            String cdCnsvcService = existingCS.getCdCnsvcService();
            String cdCnsvcPaymentType = existingCS.getCdCnsvcPaymentType();
            String indCnsvcNewRow = existingCS.getIndCnsvcNewRow();
            String cdCnsvcUnitType = existingCS.getCdCnsvcUnitType();

            double nbrCnsvcUnitRate = existingCS.getNbrCnsvcUnitRate();
            // caud17dAUDdam
            ContractService newCS = new ContractService();
            newCS.setPerson(getPersistentObject(Person.class, idCntrctWkr));
            newCS.setContract(getPersistentObject(Contract.class, idContract));
            newCS.setNbrCnsvcPeriod(nbrCnsvcPeriod);
            newCS.setNbrCnsvcVersion(nbrCnsvcVersion);
            newCS.setNbrCnsvcLineItem(nbrCnsvcLineItem);
            newCS.setCdCnsvcService(cdCnsvcService);
            newCS.setCdCnsvcPaymentType(cdCnsvcPaymentType);
            newCS.setIndCnsvcNewRow(indCnsvcNewRow);
            newCS.setCdCnsvcUnitType(cdCnsvcUnitType);
            newCS.setNbrCnsvcFedMatch(existingCS.getNbrCnsvcFedMatch());
            newCS.setNbrCnsvcLocalMatch(existingCS.getNbrCnsvcLocalMatch());
            newCS.setNbrCnsvcUnitRate(nbrCnsvcUnitRate);
            contractServiceDAO.saveContractService(newCS);

          }
        }
      }
    }
  }

  private void saveContractVersion(ContractPeriod newlySavedContractPeriod, ROWCCON06SIG00 rowccon06sigoo,
                                   int idContract, int idCntrctWkr) {
    int nbrCnverVersion = 1;
    Date dtCnverCreate = new Date();
    Date dtCnverEffective = DateHelper.toJavaDate(rowccon06sigoo.getDtDtCnperStart());
    Date dtCnverEnd = DateHelper.toJavaDate(rowccon06sigoo.getDtDtCnperTerm());

    String indCnverVerLock = null;
    if (ArchitectureConstants.N.equals(rowccon06sigoo.getCIndCnperSigned())) {
      indCnverVerLock = ArchitectureConstants.N;
    } else {
      indCnverVerLock = ArchitectureConstants.Y;
    }
    String txtCnverComment = PERIOD_ADDED;
    // caud15dAUDdam
    ContractVersion contractVersion = new ContractVersion();
    contractVersion.setNbrCnverVersion(nbrCnverVersion);
    contractVersion.setPerson(getPersistentObject(Person.class, idCntrctWkr));
    contractVersion.setContractPeriod(newlySavedContractPeriod);
    contractVersion.setDtCnverCreate(dtCnverCreate);
    contractVersion.setDtCnverEffective(dtCnverEffective);
    contractVersion.setDtCnverEnd(dtCnverEnd);
    contractVersion.setIndCnverVerLock(indCnverVerLock);
    contractVersion.setTxtCnverComment(txtCnverComment);
    contractVersionDAO.saveContractVersion(contractVersion);
  }

  private ContractPeriod saveContractPeriod(ROWCCON06SIG00 rowccon06sigoo, int idContract, int idCntrctWkr) {

    Date dtStartDate = DateHelper.toJavaDate(rowccon06sigoo.getDtDtCnperStart());
    Date dtTerm = DateHelper.toJavaDate(rowccon06sigoo.getDtDtCnperTerm());
    Date dtClosure = DateHelper.toJavaDate(rowccon06sigoo.getDtDtCnperClosure());

    String txtCnverComment = "";

    // caud15dAUDdam
    ContractPeriod contractPeriod = new ContractPeriod();

    ContractPeriodId contractPeriodId = new ContractPeriodId();
    contractPeriodId.setIdContract(idContract);
    contractPeriodId.setNbrCnperPeriod(rowccon06sigoo.getUlNbrCnperPeriod());

    contractPeriod.setId(contractPeriodId);
    contractPeriod.setContract(getPersistentObject(Contract.class, idContract));
    // contractPeriod.setDtLastUpdate(rowccon06sigoo.getTsLastUpdate());
    contractPeriod.setPerson(getPersistentObject(Person.class, idCntrctWkr));
    contractPeriod.setCdCnperStatus(rowccon06sigoo.getSzCdCnperStatus());
    contractPeriod.setDtCnperStart(dtStartDate);
    contractPeriod.setDtCnperTerm(dtTerm);
    contractPeriod.setDtCnperClosure(dtClosure);
    contractPeriod.setIndCnperRenewal(rowccon06sigoo.getCIndCnperRenewal());
    contractPeriod.setIndCnperSigned(rowccon06sigoo.getCIndCnperSigned());
    contractPeriod.setNbrLegalIdentifier(rowccon06sigoo.getUlNbrLegalIdentifier());
    contractPeriod.setTxtTermComm(txtCnverComment);
    contractPeriod.setTxtLastUpdatedBy(rowccon06sigoo.getTxtLastUpdatedBy());
    contractPeriodDAO.saveContractPeriod(contractPeriod);
    return contractPeriod;
  }

  private void findAndSaveContractCounty(ROWCCON06SIG00 rowccon06sigoo, int idContract, int idCntrctWkr, String review)
                                                                                                        throws ServiceException {
    byte nbrCncntyPeriod = (byte) 1;
    byte nbrCncntyVersion = (byte) 1;
    Date dtCncntyEffective = DateHelper.toJavaDate(rowccon06sigoo.getDtDtCnperStart());
    Date dtCncntyEnd = DateHelper.toJavaDate(rowccon06sigoo.getDtDtCnperTerm());
    // clss73dQUERYdam

    // -- FIXME: we're always validating against the first version of the first period - is this correct?
    List<Integer> integerList = contractCountyDAO.findContractCountyIdCncnty(idContract, dtCncntyEnd,
                                                                             dtCncntyEffective, nbrCncntyPeriod,
                                                                             nbrCncntyVersion);
    // Analyze return code
    if (integerList != null && !integerList.isEmpty()) {
      throw new ServiceException(Messages.MSG_CON_COUNTY_VIOLATION);
    }
    int nbrCnverPeriod = 1;
    // clss09dQUERYdam

    // -- FIXME: since there is only one period, will this list always contain only one result?
    List<ContractVersion> contractVersionList = contractVersionDAO
                                                                  .findContractVersionByIdContractAndNbrCnperPeriod(
                                                                                                                    idContract,
                                                                                                                    nbrCnverPeriod);

    String indCnverVerLock = null;
    Date dtCnverEnd = null;

    if (contractVersionList != null && !contractVersionList.isEmpty()) {
      for (Iterator<ContractVersion> it = contractVersionList.iterator(); it.hasNext();) {
        ContractVersion contractVersion = it.next();
        if (1 == contractVersion.getNbrCnverVersion()) {
          indCnverVerLock = contractVersion.getIndCnverVerLock();
          dtCnverEnd = contractVersion.getDtCnverEnd();
          break;
        }
      }
      nbrCnverPeriod = 1;
      int nbrCnverVersion = 1;
      Date dtCnperStart = DateHelper.toJavaDate(rowccon06sigoo.getDtDtCnperStart());

      // STGAP00017058
      if(review != null && !ServiceConstants.FND_YES.equals(review)){
        // caud28dAUDdam
        int rowsUpdated = contractVersionDAO.updateContractVersion(idCntrctWkr, dtCnperStart, dtCnverEnd,
                                                                   indCnverVerLock, idContract, nbrCnverPeriod,
                                                                   nbrCnverVersion, rowccon06sigoo.getTxtLastUpdatedBy());

        if (rowsUpdated == 0) {
          throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
        }
      }
      
      //get the list of all Contract Counties for a particular period and version
      List<ContractCounty> contractCounties = contractCountyDAO
                                                               .findContractCountyByIdContactVersionAndPeriod(
                                                                                                              idContract,
                                                                                                              nbrCncntyPeriod,
                                                                                                              nbrCncntyVersion);
      Date dtCnverEffective = DateHelper.toJavaDate(rowccon06sigoo.getDtDtCnperStart());
      if(contractCounties != null && !contractCounties.isEmpty()){
        Iterator<ContractCounty> it = contractCounties.iterator();
        while(it.hasNext()){
          ContractCounty contractCounty = it.next();
          //if the start date of the contract has changed, update the contract county table.
          if(!contractCounty.getDtCncntyEffective().equals(dtCnverEffective)){
            contractCounty.setDtCncntyEffective(dtCnverEffective);
            contractCountyDAO.saveContractCounty(contractCounty);
          }
        }
      }
    }
  }

  private void updateAndSaveContractVersionandContractCounty(ContractVersion contractVersionLatest,
                                                             ROWCCON06SIG00 rowccon06sigoo, int idContract,
                                                             int idCntrctWkr, String indRsrcTransport, String review)
                                                                                                      throws ServiceException {
    // make sure the contract has not been signed without services
    if (rowccon06sigoo.getUlNbrCnperPeriod() == 1) {
      int nbrCnsvcPeriod = rowccon06sigoo.getUlNbrCnperPeriod();
      int nbrCnsvcVersion = contractVersionLatest.getNbrCnverVersion();
      // The Contract Service AUD performs a full row
      // insert to the Contract Service table.
      // clss11dQUERYdam
      List<ContractService> contractServiceList = contractServiceDAO
                                                                    .findConSvcByIdConAndNbrCnsvcPeriodAndNbrCnsvcVersion(
                                                                                                                          nbrCnsvcPeriod,
                                                                                                                          nbrCnsvcVersion,
                                                                                                                          idContract);

      if (contractServiceList == null || contractServiceList.isEmpty()) {
        if ((rowccon06sigoo.getUlNbrCnperPeriod() == 1)
            && (ArchitectureConstants.Y.equals(rowccon06sigoo.getCIndCnperSigned()))) {
          throw new ServiceException(Messages.MSG_CON_PER_SIGN_WO_SERV);
        }
      }
    }
    int nbrCnverPeriod = rowccon06sigoo.getUlNbrCnperPeriod();
    int nbrCnverVersion = contractVersionLatest.getNbrCnverVersion();
    Date dtCnperStart = null;
    if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(rowccon06sigoo.getSzCdScrDataAction())
        && rowccon06sigoo.getUlNbrCnperPeriod() == 1 && ArchitectureConstants.Y.equals(indRsrcTransport)
        && 1 == contractVersionLatest.getNbrCnverVersion()) {
      dtCnperStart = DateHelper.toJavaDate(rowccon06sigoo.getDtDtCnperStart());

    } else {
      dtCnperStart = contractVersionLatest.getDtCnverEffective();
    }
    Date dtCnperTerm = DateHelper.toJavaDate(rowccon06sigoo.getDtDtCnperTerm());
    String indCnverVerLock = contractVersionLatest.getIndCnverVerLock();
    indCnverVerLock = null;
    if (contractVersionLatest.getNbrCnverVersion() == 1) {

      if (ArchitectureConstants.N.equals(rowccon06sigoo.getCIndCnperSigned())) {
        indCnverVerLock = ArchitectureConstants.N;

      } else {
        indCnverVerLock = ArchitectureConstants.Y;
      }
    }

    // caud28dAUDdam
    if(review != null && !ServiceConstants.FND_YES.equals(review)){
      int rowsUpdated = contractVersionDAO.updateContractVersion(idCntrctWkr, dtCnperStart, dtCnperTerm, indCnverVerLock,
                                                                 idContract, nbrCnverPeriod, nbrCnverVersion, rowccon06sigoo.getTxtLastUpdatedBy());

      if (rowsUpdated == 0) {
        throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
      }
    }
  }
  //STGAP00009788 - new method to create and populate a contractCounty object with the new period detail and save it to the contractCounty table
  private void saveContractCounty(int idCntrctWkr, Date dtCncntyEnd, int idCncnty, int idContract, int idResource,
                                  String cdCncntyCounty, String cdCncntyService, Date dtCncntyEffective,
                                  Date dtLastUpdate, int nbrCncntyPeriod, int nbrCncntyVersion, int nbrCncntyLineItem) {

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

  public void setComplexCapsResourceDAO(ComplexCapsResourceDAO complexCapsResourceDAO) {
    this.complexCapsResourceDAO = complexCapsResourceDAO;
  }
}