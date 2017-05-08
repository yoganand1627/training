package gov.georgia.dhr.dfcs.sacwis.service.financials.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.ContractCountyDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ContractServiceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EquivalencyDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Contract;
import gov.georgia.dhr.dfcs.sacwis.db.ContractService;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.service.financials.SaveContractList;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON12SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCON12SIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON12SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.Csli_ARRAY;

import java.util.Date;
import java.util.Enumeration;

/**
 *                                        Change History
 *
 *   Date          User                     Description
 * --------  ----------------  --------------------------------------------------
 * 06/29/11    charden          STGAP00017058: modified save method to remove hibernate exception during batch save
 *
 *
 *
*/

public class SaveContractListImpl extends BaseServiceImpl implements SaveContractList {

  private EquivalencyDAO equivalencyDAO = null;
  private ContractServiceDAO contractServiceDAO = null;
  private ContractCountyDAO contractCountyDAO = null;

  public void setEquivalencyDAO(EquivalencyDAO equivalencyDAO) {
    this.equivalencyDAO = equivalencyDAO;
  }

  public void setContractServiceDAO(ContractServiceDAO contractServiceDAO) {
    this.contractServiceDAO = contractServiceDAO;
  }

  public void setContractCountyDAO(ContractCountyDAO contractCountyDAO) {
    this.contractCountyDAO = contractCountyDAO;
  }

  public CCON12SO saveContractList(CCON12SI ccon12si) throws ServiceException {

    CCON12SO ccon12so = new CCON12SO();
    //STGAP00017058 - setting service to null and creating new service object for each iteration
    // to get rid of hibernate exception thrown when there is more than one row in ROWCCON12SIG00_ARRAY to save
    ContractService contractService = null;

    for (Enumeration rowccon12sig00Enum = ccon12si.getROWCCON12SIG00_ARRAY().enumerateROWCCON12SIG00();
         rowccon12sig00Enum.hasMoreElements();) {

      //STGAP00017058
      contractService = new ContractService();
      ROWCCON12SIG00 rowccon12sig00 = (ROWCCON12SIG00) rowccon12sig00Enum.nextElement();//
      //int idPhone = rowccon12sig00.getUlIdPhone();
      if ((!CodesTables.CCONFUNC_FAD.equals(ccon12si.getSzCdCntrctFuncType())
           && !CodesTables.CCONFUNC_FAC.equals(ccon12si.getSzCdCntrctFuncType()))
          && (ServiceConstants.REQ_FUNC_CD_ADD.equals(rowccon12sig00.getSzCdScrDataAction()))
          || ((ServiceConstants.REQ_FUNC_CD_UPDATE.equals(rowccon12sig00.getSzCdScrDataAction()))
              && (ArchitectureConstants.Y.equals(rowccon12sig00.getCIndCnsvcNewRow())))) {

        String cdEquivSvcDtlService = rowccon12sig00.getSzCdCnsvcService();
        Date dtEquivStartDate = DateHelper.toJavaDate(ccon12si.getDtDtCncntyEffective());
        Date dtEquivEndDate = DateHelper.toJavaDate(ccon12si.getDtDtCncntyEnd());
        //rc = cmsc52dQUERYdam(sqlca, pCMSC52DInputRec, pCMSC52DOutputRec);

        // Original code
        // Passing in Case #4 for Dam cmsc52d.pc specification (select from equivalency table)
        //pCMSC52DInputRec.getArchInputStruct().setCReqFuncCd((char) (4))
        long idEquiv = equivalencyDAO.countExistenceOfServiceCodeFromEquivalency(cdEquivSvcDtlService,
                                                                                 dtEquivStartDate,
                                                                                 dtEquivEndDate);
        if (idEquiv == 0) {
          // Original code
          // Passing in Case #3 for Dam cmsc52d.pc specification (select from equivalency table)
          // pCMSC52DInputRec.getArchInputStruct().setCReqFuncCd((char) (3));
          // rc = cmsc52dQUERYdam(sqlca, pCMSC52DInputRec, pCMSC52DOutputRec);
          long idNonEquiv = equivalencyDAO.countExemptServiceCodeFromNonEquivalency(cdEquivSvcDtlService,
                                                                                    dtEquivStartDate,
                                                                                    dtEquivEndDate);
          if (idNonEquiv == 0) {
            throw new ServiceException(Messages.MSG_NO_EQUIV_CONTRACT);
          }
        }
      }
      // The following variable values are not being provided
      // by either ccon12si OR rowccon12sig00
      // The eqivalent of this condition is also the case
      // in the CCON12S.src C-code file.
      double amtCnsvcAdminAllUsed = 0.0;
      double amtCnsvcEquipUsed = 0.0;
      double amtCnsvcFrgBenftUsed = 0.0;
      double amtCnsvcOffItemUsed = 0.0;
      double amtCnsvcOtherUsed = 0.0;
      double amtCnsvcSalaryUsed = 0.0;
      double amtCnsvcSupplyUsed = 0.0;
      double amtCnsvcTravelUsed = 0.0;
      double amtCnsvcUnitRateUsed = 0.0;

      int idCntrctWkr = ccon12si.getUlIdCntrctWkr();
      int idContract = ccon12si.getUlIdContract();
      int nbrCnsvcPeriod = ccon12si.getUlNbrCnsvcPeriod();
      int nbrCnsvcVersion = ccon12si.getUlNbrCnsvcVersion();
      String cdCnsvcPaymentType = rowccon12sig00.getSzCdCnsvcPaymentType();
      String cdCnsvcService = rowccon12sig00.getSzCdCnsvcService();
      String cdCnsvcUnitType = rowccon12sig00.getSzNbrCnsvcUnitType();
      String indCnsvcNewRow = rowccon12sig00.getCIndCnsvcNewRow();
      Date dtLastUpdate = rowccon12sig00.getTsLastUpdate();
      double amtCnsvcEquip = rowccon12sig00.getUlAmtCnsvcEquip();
      double amtCnsvcFrgBenft = rowccon12sig00.getUlAmtCnsvcFrgBenft();
      double amtCnsvcOther = rowccon12sig00.getUlAmtCnsvcOther();
      double amtCnsvcSalary = rowccon12sig00.getUlAmtCnsvcSalary();
      double amtCnsvcSupply = rowccon12sig00.getUlAmtCnsvcSupply();
      double amtCnsvcTravel = rowccon12sig00.getUlAmtCnsvcTravel();
      double amtCnsvcUnitRate = rowccon12sig00.getUlAmtCnsvcUnitRate();
      int idCnsvc = rowccon12sig00.getUlIdCnsvc();
      int nbrCnsvcFedMatch = rowccon12sig00.getUlNbrCnsvcFedMatch();
      int nbrCnsvcLineItem = rowccon12sig00.getUlNbrCnsvcLineItem();
      int nbrCnsvcLocalMatch = rowccon12sig00.getUlNbrCnsvcLocalMatch();
      double nbrCnsvcUnitRate = rowccon12sig00.getUlNbrCnsvcUnitRate();
      
      // STGAP00017058 - decrement line item by the number of previous rows that were marked as a duplicate.
      // This will prevent the contract service line item numbers from getting out of sequence
      if(ccon12so.getCsli_ARRAY() != null){
        nbrCnsvcLineItem = nbrCnsvcLineItem - ccon12so.getCsli_ARRAY().getUlRowQty();
      }

      contractService.setAmtCnsvcAdminAllUsed(amtCnsvcAdminAllUsed);
      contractService.setAmtCnsvcEquipUsed(amtCnsvcEquipUsed);
      contractService.setAmtCnsvcFrgBenftUsed(amtCnsvcFrgBenftUsed);
      contractService.setAmtCnsvcFrgBenftUsed(amtCnsvcOffItemUsed);
      contractService.setAmtCnsvcFrgBenftUsed(amtCnsvcOtherUsed);
      contractService.setAmtCnsvcFrgBenftUsed(amtCnsvcSalaryUsed);
      contractService.setAmtCnsvcFrgBenftUsed(amtCnsvcSupplyUsed);
      contractService.setAmtCnsvcFrgBenftUsed(amtCnsvcTravelUsed);
      contractService.setAmtCnsvcFrgBenftUsed(amtCnsvcUnitRateUsed);
      //contractService.getPerson().setIdPerson(idCntrctWkr);
      Person person = this.getPersistentObject(Person.class,idCntrctWkr);
      contractService.setPerson(person);
      //contractService.getContract().setIdContract(idContract);
      Contract contract = this.getPersistentObject(Contract.class,idContract);
      contractService.setContract(contract);
      contractService.setNbrCnsvcPeriod(nbrCnsvcPeriod);
      contractService.setNbrCnsvcVersion(nbrCnsvcVersion);
      contractService.setCdCnsvcPaymentType(cdCnsvcPaymentType);
      contractService.setCdCnsvcService(cdCnsvcService);
      contractService.setCdCnsvcUnitType(cdCnsvcUnitType);
      contractService.setIndCnsvcNewRow(indCnsvcNewRow);
      contractService.setDtLastUpdate(dtLastUpdate);
      contractService.setAmtCnsvcEquip(amtCnsvcEquip);
      contractService.setAmtCnsvcFrgBenft(amtCnsvcFrgBenft);
      contractService.setAmtCnsvcOther(amtCnsvcOther);
      contractService.setAmtCnsvcSalary(amtCnsvcSalary);
      contractService.setAmtCnsvcSupply(amtCnsvcSupply);
      contractService.setAmtCnsvcTravel(amtCnsvcTravel);
      contractService.setAmtCnsvcUnitRate(amtCnsvcUnitRate);
      contractService.setIdCnsvc(idCnsvc);
      contractService.setNbrCnsvcFedMatch(nbrCnsvcFedMatch);
      contractService.setNbrCnsvcLineItem(nbrCnsvcLineItem);
      contractService.setNbrCnsvcLocalMatch(nbrCnsvcLocalMatch);
      contractService.setNbrCnsvcUnitRate(nbrCnsvcUnitRate);

      String reqFuncCd = rowccon12sig00.getSzCdScrDataAction();

      // rc = caud17dAUDdam(sqlca, pCAUD17DInputRec, pCAUD17DOutputRec);

      if (ServiceConstants.REQ_FUNC_CD_ADD.equals(reqFuncCd)) {
             
        // Per STGAP00008089 If it is 'Add' and if the user has come back to the page (Using Back button on the
        // browser)after Saving the Page once
        // under this scenario , we will display a error message that a record with this CSLI exists.
        // STGAP00017051: modified method so as to look at the contract version and period also 
        if (0 < contractServiceDAO.countConSvcByIdConAndNbrConSvcLineItemAndNbrConVerAndConPeriod(idContract, nbrCnsvcLineItem, nbrCnsvcVersion, nbrCnsvcPeriod )) {
          throw new ServiceException(Messages.MSG_CSLI_EXISTS);
        }
        
        // STGAP00017058
        if(0 < contractServiceDAO.countContractSvcByPrdVersIdContractService(idContract, nbrCnsvcVersion, nbrCnsvcPeriod, cdCnsvcService)){
          if(ccon12so.getCsli_ARRAY() == null){
            Csli_ARRAY csliArray = new Csli_ARRAY();
            csliArray.addCsli(rowccon12sig00.getUlNbrCnsvcLineItem());
            csliArray.setUlRowQty(csliArray.getUlRowQty() + 1);
            ccon12so.setCsli_ARRAY(csliArray);
          }else{
            ccon12so.getCsli_ARRAY().addCsli(rowccon12sig00.getUlNbrCnsvcLineItem());
            ccon12so.getCsli_ARRAY().setUlRowQty(ccon12so.getCsli_ARRAY().getUlRowQty() + 1);
          }
          continue;
        }
        
        // caud17d
        contractServiceDAO.saveContractService(contractService);

      } else if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(reqFuncCd)) {
        // caud17d
        if (0 == contractServiceDAO.updateContractService(idContract, idCntrctWkr, nbrCnsvcPeriod, nbrCnsvcVersion,
                                                          nbrCnsvcLineItem, cdCnsvcService, cdCnsvcPaymentType,
                                                          indCnsvcNewRow, cdCnsvcUnitType, nbrCnsvcFedMatch,
                                                          nbrCnsvcLocalMatch, nbrCnsvcUnitRate, amtCnsvcAdminAllUsed,
                                                          amtCnsvcEquip, amtCnsvcEquipUsed, amtCnsvcFrgBenft,
                                                          amtCnsvcFrgBenftUsed, amtCnsvcOffItemUsed, amtCnsvcOther,
                                                          amtCnsvcOtherUsed, amtCnsvcSalary, amtCnsvcSalaryUsed,
                                                          amtCnsvcSupply, amtCnsvcSupplyUsed, amtCnsvcTravel,
                                                          amtCnsvcTravelUsed, amtCnsvcUnitRate, amtCnsvcUnitRateUsed,
                                                          dtLastUpdate, idCnsvc)) {
          throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
        }
      } else if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(reqFuncCd)) {
        // caud17d
        if (0 == contractCountyDAO.deleteContractCounty(dtLastUpdate, idCnsvc)) {
          throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
        }
        contractServiceDAO.deleteContractService(contractService);

      } else {
        // caud17d
        throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
      }
    } // end for (Enumeration rowccon12sig00Enum = ccon12si.getROWCCON12SIG00_ARRAY()
    return ccon12so;
  }

}
