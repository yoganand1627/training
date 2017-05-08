package gov.georgia.dhr.dfcs.sacwis.service.financials;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN14SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN14SO;

/**
 * *********************************************************************** * * Module File:   CFIN14S.src * * Service
 * Name:  Cost Reimbursement Detail Save * * Description:   This service will call dams to do a full row update on the *
 * CostReimDtl table. It will also update DelvrdSvcDtl records *                by IdInvoice and CLSI with computed unit
 * rate and total. If *                the process is successful, the service will call CAUD44D to * update the status
 * of the Invoice record. * * Environment:   HP-UX V9.0 *                FOUNDATION V2.4 for Unix (Construction,
 * Production) *                HP-UX Ansi C Compiler * * Date Created:  12-04-95 * * Programmer:    adkinsmc * *
 * Archive Information: $Revision:   1.1  $ *                      $Date:   17 Sep 1996 17:56:46  $ * $Modtime:   12 Sep
 * 1996 13:50:12  $ *                      $Author:   pvcs  $ * * Change History: *  Date      User Description *
 * --------  --------  -------------------------------------------------- *  01/15/96  GILLESLS Removed comments from
 * the DAM calls * *  02/29/96  MCRAEBS   SIR 3453 - To avoid rounding errors in when the * unit rate is passes to the
 * InputRec from the * InputMsg (double to float) add .005 to the value in * the InputMsg.  BSM * *  03/12/96  MCRAEBS
 * SIR 3771 - Changed .005 to .0005 to avoid rounding * errors in small dollar fee calculations. BSM * *  01/28/03  DWW
 *      moved these free statements inside the *                      if statement where they are malloc'd so that we do
 * not *                      get a segfault on an error condition *  05/17/06  Bittar converted cfin14s to
 * SaveCostReimbursementDetail *************************************************************************
 */

public interface SaveCostReimbursementDetail {

  static final String FIN_CD_INVO_PHASE_PEND1 = CodesTables.CINVPHSE_VLP;

  static final String FIN_CD_INVO_PHASE_PREBILL1 = CodesTables.CINVPHSE_PRB;

  CFIN14SO saveCostReimbursementDetail(CFIN14SI cfin14si);
}
