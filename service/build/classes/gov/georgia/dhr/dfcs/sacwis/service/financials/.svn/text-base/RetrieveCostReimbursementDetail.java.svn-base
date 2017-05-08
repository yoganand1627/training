package gov.georgia.dhr.dfcs.sacwis.service.financials;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN13SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN13SO;

/**
 * *********************************************************************** * * Module File:   CFIN13S.src * * Service
 * Name:  Cost Reimbursement Detail Retrieve * * Description:   Cost Reimbursement Detail Retrieve retrieves columns
 * from *                the DelvrdSvcDtl and CostReimDtl tables.  It groups *                DelvrdSvcDtl records by
 * CLSI and compares the quantities *                to the CostReimDtl table and updates line items that have *
 * changed. * * Environment:   HP-UX V9.0 *                FOUNDATION V2.0 for Unix (Construction, Production) * HP-UX
 * Ansi C Compiler * * Date Created:  12-01-95 * * Programmer:    adkinsmc * * * Archive Information: $Revision:   1.6 $
 * *                      $Date:   28 Nov 2000 14:41:40  $ * $Modtime:   28 Nov 2000 10:42:58  $ * $Author:   pvcs  $ *
 * * Change History: *  Date      User Description *  --------  -------- --------------------------------------------------
 * *  12/27/01    KRD     SIR 15960 - The flag to determine if the data was *                      okay was not being
 * set properly if more rows were *                      returned from CMSC20D than were returned from *
 *      CLSS39D. * * 01/17/2003  KRD     IMPACT - In CAPS, it was impossible for this service *                      to
 * be called and return a SQL_NOT_FOUND because the * window could never be accessed.  However, in IMPACT, * we will
 * always call the service.  So, the service * needed to be rewritten to gracefully handle the *
 * SQL_NOT_FOUND error. * 01/27/03  Srini D   Commenting the if statement part so that szCdrDataAction * is always set
 * to REQ_FUNC_CD_UPDATE as per Anna's request. *  01/28/03  Srini D   Moved lines 725-732 to between 416 to 424.
 * Basically moved * the copying of ulRowQty and bMoreData as per Anna's request. * *  05/16/06  Bittar Converted
 * cfin13s to RetrieveCostReimbursementDetail *************************************************************************
 */

public interface RetrieveCostReimbursementDetail {

  public static final String FIN_CD_PAYMENT_TYPE = CodesTables.CCONPAY_CRM;

  CFIN13SO retrieveCostReimbursementDetail(CFIN13SI cfin13si);
}
