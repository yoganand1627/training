package gov.georgia.dhr.dfcs.sacwis.service.financials.impl;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.dao.CostReimDtlDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.DelvrdSvcDtlDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CostReimDtl;
import gov.georgia.dhr.dfcs.sacwis.service.financials.RetrieveCostReimbursementDetail;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN13SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN13SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN13SOG;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN13SOG_ARRAY;

/**
 * ********************************************************************************************************************
 * * Service Include Files ********************************************************************************************************************
 */

/*
 * * Extern for version control table.
 */

public class RetrieveCostReimbursementDetailImpl extends BaseServiceImpl implements RetrieveCostReimbursementDetail {

  private DelvrdSvcDtlDAO delvrdSvcDtlDAO = null;

  private CostReimDtlDAO costReimDtlDAO = null;

  public void setDelvrdSvcDtlDAO(DelvrdSvcDtlDAO delvrdSvcDtlDAO) {
    this.delvrdSvcDtlDAO = delvrdSvcDtlDAO;
  }

  public void setCostReimDtlDAO(CostReimDtlDAO costReimDtlDAO) {
    this.costReimDtlDAO = costReimDtlDAO;
  }

  public CFIN13SO retrieveCostReimbursementDetail(CFIN13SI cfin13si) throws ServiceException {
    CFIN13SO cfin13so = new CFIN13SO();

    // rc = cmsc20dQUERYdam(sqlca, pCMSC20DInputRec, pCMSC20DOutputRec);
    List<Map> svcDtlList = delvrdSvcDtlDAO.findDelvrdSvcDtlByIdInvoiceCdCnsvcPaymentType(cfin13si.getUlIdInvoInvoice(),
                                                                                         FIN_CD_PAYMENT_TYPE);
    if (svcDtlList != null && !svcDtlList.isEmpty()) {
      ROWCFIN13SOG_ARRAY rowcfin13s0g_array = new ROWCFIN13SOG_ARRAY();
      for (Iterator<Map> it = svcDtlList.iterator(); it.hasNext();) {
        Map delvrdSvcDtl = it.next(); // get next item on the list
        int nbrSvcDtlCsli = (Integer) delvrdSvcDtl.get("nbrSvcDtlCsli");
        if (nbrSvcDtlCsli == 0) {
          break;
        }
        ROWCFIN13SOG rowcfin13s0g = new ROWCFIN13SOG();

        rowcfin13s0g.setSzCdCostReimService((String) delvrdSvcDtl.get("cdSvcDtlService"));
        rowcfin13s0g.setSzCdCostReimLiType(String.valueOf(delvrdSvcDtl.get("cdSvcDtlLiType"))); // field declared a
        // short
        rowcfin13s0g.setUsNbrCostReimCsli(nbrSvcDtlCsli);
        rowcfin13s0g.setUNbrCostReimUnitQty((Double) delvrdSvcDtl.get("nbrSvcDtlUnitQty"));
        rowcfin13s0g.setDAmtCostReimOffItem((Double) delvrdSvcDtl.get("amtSvcDtlFeePaid"));
        rowcfin13s0g.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_ADD);
        rowcfin13s0g_array.addROWCFIN13SOG(rowcfin13s0g);
      } // end for (Iterator<Map> it
      cfin13so.setROWCFIN13SOG_ARRAY(rowcfin13s0g_array);
      cfin13so.getArchOutputStruct().setUlRowQty(svcDtlList.size());

      // CLSS39D- Retrieve from Cost Reimbursement table
      // converted clss39dQUERYdam() to costReimDtlDAO.findCostReimDtl()
      List<CostReimDtl> costReimDtlList = costReimDtlDAO.findCostReimDtl(cfin13si.getUlIdInvoInvoice());

      if (costReimDtlList != null && !costReimDtlList.isEmpty() && (cfin13so.getArchOutputStruct().getUlRowQty() > 0)) {
        // Loop through CLSS39D unitl no more rows
        /*
         * * If rows are returned from either table, compare the two and fill * in the output message
         */
        for (Iterator<CostReimDtl> it = costReimDtlList.iterator(); it.hasNext();) {
          CostReimDtl costReimDtl = it.next();
          int nbrCostReimCsli = costReimDtl.getNbrCostReimCsli();
          if (nbrCostReimCsli == 0) {
            break;
          }
          String costReimDtlType = costReimDtl.getCdCostReimLiType();
          int CLSIcounter = 0; // set the delivered svc to be searched from the beginning

          Enumeration dlvrdSvcList = cfin13so.getROWCFIN13SOG_ARRAY().enumerateROWCFIN13SOG();

          while (dlvrdSvcList.hasMoreElements()) {
            ROWCFIN13SOG rowsfin13sog2 = (ROWCFIN13SOG) dlvrdSvcList.nextElement();
            int dlvrdSrvcNbrCostReimCsli = rowsfin13sog2.getUsNbrCostReimCsli();
            String dlvrdSrvcType = rowsfin13sog2.getSzCdCostReimLiType();
            /*
             * * Copy output if compared CSLI's and LiTypes are equal
             */
            // if the service detail nbr and the its type are the same then the action is an update and update the data
            if (nbrCostReimCsli == dlvrdSrvcNbrCostReimCsli && costReimDtlType.equals(dlvrdSrvcType)) {
              // ROWCFIN13SOG rowsfin13sog2 = cfin13so.getROWCFIN13SOG_ARRAY().getROWCFIN13SOG(CLSIcounter);
              rowsfin13sog2.setSzCdCostReimService(costReimDtl.getCdCostReimService());
              rowsfin13sog2.setSzCdCostReimLiType(costReimDtl.getCdCostReimLiType());
              rowsfin13sog2.setSzCdCostReimInvoDisptn(costReimDtl.getCdCostReimInvoDisptn());
              rowsfin13sog2.setTsLastUpdate(costReimDtl.getDtLastUpdate());
              rowsfin13sog2.setCIndCostReimRejItm(costReimDtl.getIndCostReimRejItm());
              rowsfin13sog2.setUsNbrCostReimCsli(nbrCostReimCsli);
              rowsfin13sog2.setDAmtCostReimAdminAll(costReimDtl.getAmtCostReimAdminAll());
              rowsfin13sog2.setDAmtCostReimEquip(costReimDtl.getAmtCostReimEquip());
              rowsfin13sog2.setDAmtCostReimFrgBenft(costReimDtl.getAmtCostReimFrgBenft());
              rowsfin13sog2.setDAmtCostReimDtlOther(costReimDtl.getAmtCostReimOther());
              rowsfin13sog2.setDAmtCostReimSalary(costReimDtl.getAmtCostReimSalary());
              rowsfin13sog2.setDAmtCostReimSupply(costReimDtl.getAmtCostReimSupply());
              rowsfin13sog2.setDAmtCostReimTravel(costReimDtl.getAmtCostReimTravel());
              rowsfin13sog2.setUlIdCostReim(costReimDtl.getIdCostReim() != null ? costReimDtl.getIdCostReim() : 0);
              rowsfin13sog2.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_UPDATE);
            } // end if (nbrCostReimCsli == dlvrdSrvcNbrCostReimCsli && ...)
            CLSIcounter++;
          } // end for (Iterator<Map> svcit...)
        } // end for(Iterator<CostReimDtl> it ...)
      } // end if (costReimDtlList != null ...)

    } // end if (svcDtlList != null && ...)
    return cfin13so;
  }

}
