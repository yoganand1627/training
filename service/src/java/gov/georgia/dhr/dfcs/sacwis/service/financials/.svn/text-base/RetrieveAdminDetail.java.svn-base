package gov.georgia.dhr.dfcs.sacwis.service.financials;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN15SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN15SO;

public interface RetrieveAdminDetail {

  /**
   * *********************************************************************** * * Module File:    CFIN15S.src * * Service
   * Name:   CFIN15S * * Description:   This service will retieve all records from the ADMIN DTL *                table
   * that have an ID INVOICE = to the one passed into the *                service.  Additionally, this service will
   * retrieve all the *                services of a contract.  CLSS13D will be called only on *                the
   * initial call to this service - SYS CARC RQST FUNC CD, *                stored in the input architecture record
   * group, will indicate *                whether to call CLSS13D. * * Environment:   HP-UX V9.0 * FOUNDATION V2.0 for
   * Unix (Construction, Production) *                HP-UX Ansi C Compiler * * Date Created: 11-14-1995 * * Programmer:
   * Tyler L. Chessman * * Archive Information: $Revision:   1.2  $ * $Date:   06 Aug 1997 18:19:22  $ * $Modtime:   06
   * Aug 1997 17:51:16  $ * $Author:   pvcs  $ * * Change History: *  Date      User Description *  --------  --------
   * -------------------------------------------------- *  01/10/96  GLOORJW   Removed references to Obj and Pac
   * variables *  07/25/97  CHESSMTL  We will now call clss75d.pc rather than clss13d.pc * See the comments in
   * clss75d.pc for explanation. *  05/12/2006 Bittar   Conversion from CFIN15S to RetrieveAdminDetail
   * *************************************************************************
   */

  public static final char REQ_FUNC_CD_DTLS_CDS = 'C';

  public static final int FIN_SVC_CD_PAGE_SIZE = 50;

  CFIN15SO retrieveAdminDetail(CFIN15SI cfin15si);
}
