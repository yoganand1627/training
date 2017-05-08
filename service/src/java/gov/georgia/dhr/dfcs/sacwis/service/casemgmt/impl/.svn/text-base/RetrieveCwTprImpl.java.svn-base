//*  Service Class  Name:     RetrieveCwTprImpl
//*  Created by:   Patrick Coogan
//*  Date Created: 12/06/2009
//*
//*  Description:Service Implementation for retrieving Case Watch TPR info.
//*
//** Change History:
//**  Date      User              Description
//**  --------  ----------------  --------------------------------------------------
//**  12/06/09  Patrick Coogan    Created file for ECEM Case Watch page
//**  03/08/11  schoi             SMS #97845: MR-074-2 Updated the code to retrieve the most recent Court Action/Court Order Date 
//**                              among all TPR and VS in the same case for Date TPR Filed and Date TPR/VS Granted fields
//**  03/10/11  schoi             SMS #97845: MR-074-2 Updated the DAO method retrieving the Date TPR Filed field 
//**                              to return to a single Legal Action object instead of the list of the Legal Actions
//**  03/15/11  schoi             SMS #97845: MR-074-2 Updated the comment section and the signature of a DAO method
//**                              findTheMostRecentTprVsLegalActionsDateForCase per code peer review
//**      
package gov.georgia.dhr.dfcs.sacwis.service.casemgmt.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.FosterCareChildrenDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.FccpChildDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.LegalActionDAO;
import gov.georgia.dhr.dfcs.sacwis.db.FosterCareChildren;
import gov.georgia.dhr.dfcs.sacwis.db.LegalAction;
import gov.georgia.dhr.dfcs.sacwis.db.StagePersonLink;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.FccpChild;
import gov.georgia.dhr.dfcs.sacwis.db.FccpChildCbx;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.RetrieveCwTpr;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CaseWatchSI;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CwTprSO;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.TprMonthBean;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.TprPerParentBean;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;

import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class RetrieveCwTprImpl extends BaseServiceImpl implements RetrieveCwTpr {

  // SMS #97845: MR-074-2
  public static final String orderByCourtActionDate = "A";
  
  private FosterCareChildrenDAO fosterCareChildrenDAO = null;

  private StagePersonLinkDAO stagePersonLinkDAO = null;

  private FccpChildDAO fccpChildDAO = null;
  
  private LegalActionDAO legalActionDAO = null;

  public void setFosterCareChildrenDAO(FosterCareChildrenDAO fosterCareChildrenDAO) {
    this.fosterCareChildrenDAO = fosterCareChildrenDAO;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public void setFccpChildDAO(FccpChildDAO fccpChildDAO) {
    this.fccpChildDAO = fccpChildDAO;
  }
  
  public void setLegalActionDAO(LegalActionDAO legalActionDAO) {
    this.legalActionDAO = legalActionDAO;
  }

  @SuppressWarnings("unchecked")
  /**
   * retrieveCwTpr retrieves all information necessary for displaying TPR data on the Case Watch page.
   * 
   * @param context
   *                The CaseWatchSI object.
   * 
   * Returns CwTprSO object.
   */
  public CwTprSO retrieveCwTpr(CaseWatchSI caseWatchSI) {

    CwTprSO cwTprSO = new CwTprSO();
    List<TprMonthBean> last22Months = new ArrayList<TprMonthBean>();
    List<Map> incidentsInCare = new ArrayList<Map>();
    List<TprPerParentBean> mothers = new ArrayList<TprPerParentBean>();
    List<TprPerParentBean> fathers = new ArrayList<TprPerParentBean>();
    List<TprPerParentBean> parents = new ArrayList<TprPerParentBean>();

    // We will check for incidents through date of discharge of current incident, or sysdate for a child in care
    Date throughDate = new Date();
    FosterCareChildren fosterCareChild = new FosterCareChildren();
    Date dischargeDate = null;

    fosterCareChild = fosterCareChildrenDAO.findFosterCareChildByPersonAndCaseId(caseWatchSI.getIdPerson(),
                                                                                 caseWatchSI.getIdCase());

    if (fosterCareChild != null) {

      dischargeDate = fosterCareChild.getDischargeDate();
    }
    if (dischargeDate != null) {
      throughDate = dischargeDate;
    }

    // We want to get incidents through the last 22 months
    Date dtStart = DateHelper.addToDate(DateHelper.getFirstDayOfTheMonth(throughDate), -1, -9, 0);

    int inCareCount = 0;

    incidentsInCare = fosterCareChildrenDAO.findFosterIncidentsByChildThruDate(caseWatchSI.getIdPerson(), dtStart);

    Date tprMonthDate = dtStart;
    int incidentIndex = 0;
    int numberIncidents = incidentsInCare != null ? incidentsInCare.size() : 0;

    for (int monthsIndex = 0; monthsIndex < 22; monthsIndex++) {

      TprMonthBean tprMonth = new TprMonthBean();
      tprMonth.setTprMonth(tprMonthDate);

      tprMonth.setInCare(ArchitectureConstants.N);

      while (incidentIndex < numberIncidents) {

        Map incidentMap = new HashMap();
        incidentMap = incidentsInCare.get(incidentIndex);
        Date custodyStart = (Date) incidentMap.get("removalDate");
        Date discharge = (Date) incidentMap.get("dischargeDate");

        if (((DateHelper.isBefore(custodyStart, DateHelper.getLastDayOfTheMonth(tprMonthDate))) || (DateHelper
                                                                                                              .isEqual(
                                                                                                                       custodyStart,
                                                                                                                       DateHelper
                                                                                                                                 .getLastDayOfTheMonth(tprMonthDate))))
            && ((discharge == null) || DateHelper.isAfter(discharge, tprMonthDate) || DateHelper.isEqual(discharge,
                                                                                                         tprMonthDate))) {
          tprMonth.setInCare(ArchitectureConstants.Y);
          inCareCount++;
          break;
        } else if (DateHelper.isAfter(tprMonthDate, discharge)) {
          incidentIndex++;
        } else {
          break;
        }
      }
      last22Months.add(tprMonth);
      tprMonthDate = DateHelper.addToDate(tprMonthDate, 0, 1, 0);

    }

    cwTprSO.setMonthsLast22(inCareCount);
    cwTprSO.setLast22Months(last22Months);

    List<String> cdStagePersRelInts = new ArrayList<String>();
    cdStagePersRelInts.add(CodesTables.CRPTRINT_AB); // Absent parent
    cdStagePersRelInts.add(CodesTables.CRPTRINT_PT); // Adoptive Parent
    cdStagePersRelInts.add(CodesTables.CRPTRINT_BF); // Biological Father
    cdStagePersRelInts.add(CodesTables.CRPTRINT_BM); // Biological Mother
    cdStagePersRelInts.add(CodesTables.CRPTRINT_BP); // Biological Parent
    cdStagePersRelInts.add(CodesTables.CRPTRINT_BB); // Biological and Legal Father
    cdStagePersRelInts.add(CodesTables.CRPTRINT_CP); // Custodial Parent/Guardian
    cdStagePersRelInts.add(CodesTables.CRPTRINT_LF); // Legal Father
    cdStagePersRelInts.add(CodesTables.CRPTRINT_LM); // Legal Mother
    cdStagePersRelInts.add(CodesTables.CRPTRINT_NC); // Non Custodial Parent
    cdStagePersRelInts.add(CodesTables.CRPTRINT_PA); // Parent
    cdStagePersRelInts.add(CodesTables.CRPTRINT_PK); // Primary Care Taker
    cdStagePersRelInts.add(CodesTables.CRPTRINT_PF); // Putative Father
    cdStagePersRelInts.add(CodesTables.CRPTRINT_SC); // Secondary Care taker

    List<StagePersonLink> stagePersonLinkList = stagePersonLinkDAO
                                                                  .findStagePersonLinkByIdStageByCdStagePersRelInts(
                                                                                                                    caseWatchSI
                                                                                                                               .getIdStage(),
                                                                                                                    cdStagePersRelInts);
    boolean allAppropriateTPR = true;
    if (stagePersonLinkList != null) {

      for (Iterator<StagePersonLink> It = stagePersonLinkList.iterator(); It.hasNext();) {

        StagePersonLink parentLink = It.next();
        Person parentPerson = parentLink.getPerson();

        if (parentPerson != null) {

          TprPerParentBean tprParent = new TprPerParentBean();

          tprParent.setCdRel(parentLink.getCdStagePersRelInt() != null ? parentLink.getCdStagePersRelInt() : "");
          tprParent.setDtDod(parentPerson.getDtPersonDeath());
          tprParent.setNmPersonFull(parentPerson.getNmPersonFull() != null ? parentPerson.getNmPersonFull() : "");

          String gender = parentPerson.getCdPersonSex() != null ? parentPerson.getCdPersonSex() : "";

          if (CodesTables.CSEX_F.equals(gender)) {

            tprParent.setParent("Mother");
            
            String cdLegalActActionFiled = CodesTables.CLEGCPS_PFD;
            
            List<String> filedHearingOrders = new ArrayList<String>();
            filedHearingOrders.add(CodesTables.CLHECOT_TPA);
            filedHearingOrders.add(CodesTables.CLHECOT_TPM);
            
            // SMS #97845: MR-074-2
            // Date TPR Filed should be the most recent Court Action Date within the case for the child
            // with Legal Action of Petition filed and a Hearing/Order Type of any TPRs 
            LegalAction filedAction = legalActionDAO
            .findLegalActionByIdCaseByIdPersonBycdActionByCdHrTypCrtOrds(
                                                                         caseWatchSI
                                                                                    .getIdCase(),
                                                                         caseWatchSI
                                                                                    .getIdPerson(),
                                                                         filedHearingOrders,
                                                                         cdLegalActActionFiled,
                                                                         orderByCourtActionDate);
            
            List<String> grantedActions= new ArrayList<String>();
            List<String> grantedOrders= new ArrayList<String>();
            
            grantedActions.add(CodesTables.CLEGCPS_VLM);
            grantedActions.add(CodesTables.CLEGCPS_VAM);
            
            grantedOrders.add(CodesTables.CLHECOT_TPA);
            grantedOrders.add(CodesTables.CLHECOT_TPM);
             
            // SMS #97845: MR-074-2
            // Retrieve the most recent Court Action/Court Order Date among the following
            // (The event status of Legal Action should be approved or completed) :
            // 1. The most recent Court Action Date for a Legal Action Type - Biological Mother (VLM) 
            //    or Voluntary Surrender - Adoptive Mother (VAM)
            // 2. The most recent Court Order Date for a Legal Action where the Hearing/Court Order Type 
            //    is TPR - Biological Mother (TPM) or TPR - Adoptive Mother (TPA) and the Outcome is TPR Granted (CLEGLOUT_TPG). 
            // 3. The most recent Court Order Date for a Legal Action where the Outcome is 
            //    'Deceased Parents – Permanent Custody to DHR (CLEGLOUT_DPC)'
            Date dtMostRecentTPRVS = null;
            dtMostRecentTPRVS = legalActionDAO.findTheMostRecentTprVsLegalActionsDateForCase(caseWatchSI.getIdCase(),
                                                                                             caseWatchSI.getIdPerson(),
                                                                                             grantedActions,
                                                                                             grantedOrders,                                                                                       
                                                                                             CodesTables.CLEGLOUT_TPG,
                                                                                             CodesTables.CLEGLOUT_DPC);                                               
            
            Date dtFiled = null;
            Date dtGranted = null;
            
            // SMS #97845: MR-074-2
            if (filedAction != null) {
              // dtFiled gets the most recent Court Action Date within the case entered for the child
              dtFiled = filedAction.getDtCrtActDate();
            }            
            
            // SMS #97845: MR-074-2
            if (dtMostRecentTPRVS != null) {
              dtGranted = dtMostRecentTPRVS;
            }
            
            tprParent.setDtTprFiled(dtFiled);
            tprParent.setDtTprGranted(dtGranted);
            
            //Set error flags
            if((dtFiled==null)&&(dtGranted==null)&&(tprParent.getDtDod()==null)&&(inCareCount>=15)){
              
              tprParent.setIndError("W");
              cwTprSO.setIndOverallError("W");
              allAppropriateTPR = false;
            } else {
              tprParent.setIndError("");
            }
            
            mothers.add(tprParent);

          } else {

            tprParent.setParent("Father");
            
            String cdLegalActActionFiled = CodesTables.CLEGCPS_PFD;
            
            List<String> filedHearingOrders = new ArrayList<String>();
            filedHearingOrders.add(CodesTables.CLHECOT_TFF);
            filedHearingOrders.add(CodesTables.CLHECOT_TFL);
            filedHearingOrders.add(CodesTables.CLHECOT_TFB);
            filedHearingOrders.add(CodesTables.CLHECOT_TFA);
            // SMS #97845: MR-074-2 
            filedHearingOrders.add(CodesTables.CLHECOT_TPP); // TPR - Putative Father
            
            // SMS #97845: MR-074-2
            // Date TPR Filed should be the most recent Court Action Date within the case for the child
            // with Legal Action of Petition filed and a Hearing/Order Type of any TPRs (including new TPR-Putative Father)
            LegalAction filedAction = legalActionDAO
                                                           .findLegalActionByIdCaseByIdPersonBycdActionByCdHrTypCrtOrds(
                                                                                                                        caseWatchSI
                                                                                                                                   .getIdCase(),
                                                                                                                        caseWatchSI
                                                                                                                                   .getIdPerson(),
                                                                                                                        filedHearingOrders,
                                                                                                                        cdLegalActActionFiled,
                                                                                                                        orderByCourtActionDate);
            
            List<String> grantedActions= new ArrayList<String>();
            List<String> grantedOrders= new ArrayList<String>();
            
            grantedActions.add(CodesTables.CLEGCPS_VLS);
            grantedActions.add(CodesTables.CLEGCPS_VBF);
            grantedActions.add(CodesTables.CLEGCPS_VAF);
            grantedActions.add(CodesTables.CLEGCPS_VSF);
            // SMS #97845: MR-074-2 
            grantedActions.add(CodesTables.CLEGCPS_VPF); // Voluntary Surrender - Putative Father
            
            grantedOrders.add(CodesTables.CLHECOT_TFF);
            grantedOrders.add(CodesTables.CLHECOT_TFL);
            grantedOrders.add(CodesTables.CLHECOT_TFB);
            grantedOrders.add(CodesTables.CLHECOT_TFA);
            // SMS #97845: MR-074-2 
            grantedOrders.add(CodesTables.CLHECOT_TPP); // TPR - Putative Father
             
            // SMS #97845: MR-074-2
            // Retrieve the most recent Court Action/Court Order Date among the following
            // (The event status of Legal Action should be approved or completed):
            // 1. The most recent Court Action Date for Legal Action Type of Voluntary Surrender - Legal/Biological Father (VSF), 
            //    Voluntary Surrender - Legal Father (VLS), Voluntary Surrender - Biological Father (VBF), 
            //    Voluntary Surrender - Adoptive Father (VAF) or Voluntary Surrender – Putative Father (VPF)
            // 2. The most recent Court Order Date for Legal Action where the Hearing/Court Order Type 
            //    is TPR - Legal/Biological Father (TFL), TPR - Legal Father (TFF), TPR - Biological Father (TFB), TPR - Adoptive Father (TFA), 
            //    TPR - Putative Father (TPP) and the Outcome is TPR Granted (CLEGLOUT_TPG)
            // 3. The most recent Court Order Date for a Legal Action where the Outcome 
            //    is Deceased Parents – Permanent Custody to DHR (CLEGLOUT_DPC)

            Date dtMostRecentTPRVS = null;
            dtMostRecentTPRVS = legalActionDAO.findTheMostRecentTprVsLegalActionsDateForCase(caseWatchSI.getIdCase(),
                                                                                             caseWatchSI.getIdPerson(),
                                                                                             grantedActions,
                                                                                             grantedOrders,
                                                                                             CodesTables.CLEGLOUT_TPG,
                                                                                             CodesTables.CLEGLOUT_DPC); 
            
            Date dtFiled = null;
            Date dtGranted = null;
            
            // SMS #97845: MR-074-2
            if (filedAction != null) {
              // dtFiled gets the most recent Court Action Date within the case entered for the child
              dtFiled = filedAction.getDtCrtActDate();
            }
            
            // SMS #97845: MR-074-2
            if (dtMostRecentTPRVS != null) {
              dtGranted = dtMostRecentTPRVS;
            }
            
            tprParent.setDtTprFiled(dtFiled);
            tprParent.setDtTprGranted(dtGranted);
            
            //Set error flags
            if((dtFiled==null)&&(dtGranted==null)&&(tprParent.getDtDod()==null)&&(inCareCount>=15)){
              
              tprParent.setIndError("W");
              cwTprSO.setIndOverallError("W");
              allAppropriateTPR = false;
            } else {
              tprParent.setIndError("");
            }
            
            fathers.add(tprParent);
          }

        }
      }

    }
    if (((stagePersonLinkList == null)||stagePersonLinkList.isEmpty())&&(inCareCount>=15)) {
      allAppropriateTPR = false;
      cwTprSO.setIndOverallError("W");
    }
    if (mothers.isEmpty()){
      
      TprPerParentBean tprParent = new TprPerParentBean();
      tprParent.setParent("Mother");
      tprParent.setIndError("E");
      
      mothers.add(tprParent);
      
    }
    
    if (fathers.isEmpty()){
      
      TprPerParentBean tprParent = new TprPerParentBean();
      tprParent.setParent("Father");
      tprParent.setIndError("E");
      
      fathers.add(tprParent);
      
    }
    
    parents.addAll(mothers);
    parents.addAll(fathers);
    
    cwTprSO.setTprParents(parents);
    
    cwTprSO.setAsfaFlag("N");
    cwTprSO.setTprComments("N");
    
    FccpChild casePlan = fccpChildDAO.findLatestChildPlanByIdCaseByIdPersonByCdEventType(caseWatchSI.getIdCase(), caseWatchSI.getIdPerson());
    
    if (casePlan != null) {
      
      if (casePlan.getTxtTpr()!=null) {
        cwTprSO.setTprComments("Y");
      }
      
      List<FccpChildCbx> asfaFlags = fccpChildDAO.findchildcheckboxbyIdEventandCbxCodeType(casePlan.getEvent().getIdEvent(), CodesTables.CCPTASF1); 
      
      if (!(asfaFlags ==null)&&!asfaFlags.isEmpty()){
             
        for (Iterator<FccpChildCbx> It = asfaFlags.iterator(); It.hasNext();){
          
          FccpChildCbx check = It.next();
          if (CodesTables.CCPTASF1_CFC.equals(check.getCdCbx())){
            cwTprSO.setAsfaFlag("Y");
          }
        } 
      }
    }
    
    //Set error flags
    
    if ((inCareCount>=15)&&ArchitectureConstants.N.equals(cwTprSO.getAsfaFlag())){
      cwTprSO.setAsfaFlagError("E");
      cwTprSO.setIndOverallError("E");
    }
    if ((inCareCount>=15)&&ArchitectureConstants.N.equals(cwTprSO.getTprComments())&&!allAppropriateTPR){
      cwTprSO.setIndOverallError("E");
      cwTprSO.setTprCommentsError("E");
    }
    return cwTprSO;
  }
}
