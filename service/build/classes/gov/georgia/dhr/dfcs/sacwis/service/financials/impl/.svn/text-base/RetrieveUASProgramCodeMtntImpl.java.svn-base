/**
 * Name: RetrieveProgramCodeMtnt
 * Description : This service retrieves UAS program code information for the page UAS Program Code Maintenance.
 * <p/>
 * <p/>
 * 
 * <pre>
 *  Change History:
 *  Date      User      Description
 *  --------  --------  --------------------------------------------------
 *  09/02/11  htvo      STGAP00017019: ECEM 5.0: UAS Program Code Maintenance - new page development
 * 
 * </pre>
 * 
 */
package gov.georgia.dhr.dfcs.sacwis.service.financials.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.financials.UASEntCodeMtntDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.financials.UASProgramCodeMtntDAO;
import gov.georgia.dhr.dfcs.sacwis.db.UasEntCodeMtnt;
import gov.georgia.dhr.dfcs.sacwis.db.UasProgramCodeMtnt;
import gov.georgia.dhr.dfcs.sacwis.service.financials.RetrieveUASProgramCodeMtnt;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.UASProgramCodeMtntRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.UASEntitlementCodeDetail;
import gov.georgia.dhr.dfcs.sacwis.structs.output.UASProgramCodeDetail;
import gov.georgia.dhr.dfcs.sacwis.structs.output.UASProgramCodeListRow;
import gov.georgia.dhr.dfcs.sacwis.structs.output.UASProgramCodeMtntRetrieveSO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 
 * 
 */
public class RetrieveUASProgramCodeMtntImpl extends BaseServiceImpl implements RetrieveUASProgramCodeMtnt {
  private UASProgramCodeMtntDAO uasProgramCodeMtntDAO = null;
  
  private UASEntCodeMtntDAO uasEntCodeMtntDAO = null;

  public void setUasProgramCodeMtntDAO(UASProgramCodeMtntDAO uasProgramCodeMtntDAO) {
    this.uasProgramCodeMtntDAO = uasProgramCodeMtntDAO;
  }

  public void setUasEntCodeMtntDAO(UASEntCodeMtntDAO uasEntCodeMtntDAO) {
    this.uasEntCodeMtntDAO = uasEntCodeMtntDAO;
  }

  public UASProgramCodeMtntRetrieveSO retrieveUASProgramCodeMtnt(UASProgramCodeMtntRetrieveSI uasProgramCodeMtntRetrieveSI) throws ServiceException {
    // Always retrieve the program code list from DB on page display
    List<Map> uasProgramCodeList = uasProgramCodeMtntDAO.findActiveUasProgramCodes();
    int idUasPrgCode = uasProgramCodeMtntRetrieveSI.getIdUasProgramCodeMtnt();
    String cdReqFunc = uasProgramCodeMtntRetrieveSI.getCdReqFunc();
    UASProgramCodeMtntRetrieveSO uasPrgCodeMtntRetrieveSO = new UASProgramCodeMtntRetrieveSO();
    uasPrgCodeMtntRetrieveSO.setCdReqFunc(cdReqFunc);
    
    if (idUasPrgCode == 0) {
      // New mode, just display the list, retrieved above.
      // Need to make sure: if user is adding and click Add Prog does not fall in here (ask user on exit and clear id if confirmed)
      
    } else {
      if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(cdReqFunc)) {
        // User clicks on HL
        UASProgramCodeDetail prgCodeDetail = new UASProgramCodeDetail();
        prgCodeDetail.setIdUasPrgCode(idUasPrgCode);
        prgCodeDetail.setRecordIndex(uasProgramCodeMtntRetrieveSI.getRowIndex());
        uasPrgCodeMtntRetrieveSO.setPrgCodeDetail(prgCodeDetail);
      } else if (ServiceConstants.REQ_FUNC_CD_ADD.equals(cdReqFunc)) {
        // User adding ENT for a prog code (new or existing), only need to display the prog list, retrieved above.
      }
    }
    // populate the retrieveSO with DB data and return.
    return populateUASPrgCodeMtntRetrieveSO(uasPrgCodeMtntRetrieveSO, uasProgramCodeList);
  }

  private UASProgramCodeMtntRetrieveSO populateUASPrgCodeMtntRetrieveSO(UASProgramCodeMtntRetrieveSO prgCodeMtntRetrieveSO , List<Map> prgCodeList) {
    List<UASProgramCodeListRow> prgCodeListSO = new ArrayList<UASProgramCodeListRow>();
    UASProgramCodeDetail prgCodeDetail = prgCodeMtntRetrieveSO.getPrgCodeDetail();
    String nmPersonLastUpdate = StringHelper.EMPTY_STRING;
    String cdReqFunc = prgCodeMtntRetrieveSO.getCdReqFunc();
    // Populate program code list - always in all modes
    if (prgCodeList != null) {
      for (Map prgCodeMtnt : prgCodeList) {
        UASProgramCodeListRow prgCodeListRowSO = new UASProgramCodeListRow();
        prgCodeListRowSO.setCdProgramCode((String)prgCodeMtnt.get("cdUas"));
        prgCodeListRowSO.setTxtProgramDesc((String)prgCodeMtnt.get("txtProgramDesc"));
        prgCodeListRowSO.setDtProgramEffective((Date)prgCodeMtnt.get("dtEffective"));
        prgCodeListRowSO.setDtLastUpdatedBy((Date)prgCodeMtnt.get("dtLastUpdate"));
        prgCodeListRowSO.setIdPersonLastUpdate(prgCodeMtnt.get("idPersonLastUpdate") == null? 0 : (Integer)prgCodeMtnt.get("idPersonLastUpdate"));
        prgCodeListRowSO.setNmPersonLastUpdate(prgCodeMtnt.get("nmPersonLastUpdate") == null? StringHelper.EMPTY_STRING : (String)prgCodeMtnt.get("nmPersonLastUpdate"));
        prgCodeListRowSO.setIdUasPrgCode((Integer)prgCodeMtnt.get("idUasProgramCodeMtnt"));
        // If in UPDATE or ADD_ENT page state, prgCodeDetail should exists, get nmPersonLastUpdate from the 
        // corresponding row of the list, to display in the detail section.
        
        // Null check is not necessary as UPDATE mode always populate code detail object; added here to prevent  
        // unfriendly NPE due to session error (losing state, etc.) so at least page displays minus some information
        if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(cdReqFunc) && prgCodeDetail != null && 
                        prgCodeListRowSO.getIdUasPrgCode() == prgCodeDetail.getIdUasPrgCode()) {
          nmPersonLastUpdate = prgCodeListRowSO.getNmPersonLastUpdate();
        }
        prgCodeListSO.add(prgCodeListRowSO);
      }
    }
    // A program code has been selected (UPDATE or ADD_ENT page state)
    if (prgCodeDetail != null) {
      // Populate program code detail
      int idPrgCode = prgCodeDetail.getIdUasPrgCode();
      if (idPrgCode != 0) {
        UasProgramCodeMtnt uasProgramCodeMtnt = uasProgramCodeMtntDAO.findUasProgramCodeMtnt(idPrgCode);
        if (uasProgramCodeMtnt == null) {
          throw new ServiceException(Messages.SQL_NOT_FOUND);
        }
        prgCodeDetail.setCdProgramCode(uasProgramCodeMtnt.getCdUas());
        prgCodeDetail.setCdProgramType(uasProgramCodeMtnt.getCdProgramType());
        prgCodeDetail.setDtLastUpdatedBy(uasProgramCodeMtnt.getDtLastUpdate());
        prgCodeDetail.setDtProgramEffective(uasProgramCodeMtnt.getDtEffective());
        prgCodeDetail.setIndCCI(uasProgramCodeMtnt.getIndCci());
        prgCodeDetail.setIndCPA(uasProgramCodeMtnt.getIndCpa());
        prgCodeDetail.setIndInvAddOn(uasProgramCodeMtnt.getIndInvAddon());
        prgCodeDetail.setIndPSSF(uasProgramCodeMtnt.getIndPssf());
        prgCodeDetail.setIndServiceAuth(uasProgramCodeMtnt.getIndServAuth());
        prgCodeDetail.setNmPersonLastUpdate(nmPersonLastUpdate);
        prgCodeDetail.setTxtProgramDesc(uasProgramCodeMtnt.getTxtProgramDesc());
        // set display mode for the entitlement codes for the program code
        // UPDATE or ADD_ENT page state, retrieve ENT for display on UPDATE mode and validation on ADD_ENT mode
        if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(cdReqFunc)) {
          // Display existing Entitlement code in Modify mode
          // retrieve ENT for this UAS
          List<UasEntCodeMtnt> uasEntCodeMtntList = uasEntCodeMtntDAO.findEntCodeMtntsByIdProgram(idPrgCode);
          if (uasEntCodeMtntList != null) {
            List<UASEntitlementCodeDetail> entCodeList = new ArrayList<UASEntitlementCodeDetail>();
            for (UasEntCodeMtnt entDB : uasEntCodeMtntList) {
              UASEntitlementCodeDetail entSO = new UASEntitlementCodeDetail();
              // required fields
              entSO.setIdEntRow(entDB.getIdUasEntCodeMtnt());
              entSO.setCdEntCode(entDB.getCdEntCode());
              entSO.setDtEntEff(entDB.getDtEffective());
              entSO.setDtLastUpdate(entDB.getDtLastUpdate());
              entSO.setTxtEntDesc(entDB.getTxtEntDesc());
              // these may not have value
              if (entDB.getAmtCaseBudgetLimit() != null) {
                entSO.setAmtCBL(entDB.getAmtCaseBudgetLimit());
              }
              if (entDB.getAmtLineItemLimit() != null) {
                entSO.setAmtLIL(entDB.getAmtLineItemLimit());
              }
              if (entDB.getAmtUnitRate() != null) {
                entSO.setAmtRate(entDB.getAmtUnitRate());
              }
              if (entDB.getCdPaymentType() != null) {
                entSO.setCdPymtType(entDB.getCdPaymentType());
              }
              if (entDB.getCdUnitType() != null) {
                entSO.setCdUnitType(entDB.getCdUnitType());
              }
              if (entDB.getIndEntHeader() != null) {
                entSO.setIndHeader(entDB.getIndEntHeader());
              }
              if (entDB.getIndMileage() != null) {
                entSO.setIndMileage(entDB.getIndMileage());
              }
              if (entDB.getCdAlpha() != null) {
                entSO.setTxtEntAlpha(entDB.getCdAlpha());
              }
              if (entDB.getEquivalency() != null) {
                entSO.setIdEquiv(entDB.getEquivalency().getIdEquiv());
              }
              entCodeList.add(entSO);
            }
            prgCodeDetail.setEntCodeList(entCodeList);
          }
          
        } else { 
          // Adding Entitlement codes for new UAS; do nothing - display 10 more blank lines 
        }
        
      }
    }
    

    prgCodeMtntRetrieveSO.setPrgCodeList(prgCodeListSO);
    return prgCodeMtntRetrieveSO;

  }

}
