package gov.georgia.dhr.dfcs.sacwis.service.financials;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN16SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN16SO;

/**
 * *********************************************************************** * * Module File:   CFIN16S.src * * Service
 * Name:  CFIN16S * * Description:   This service will Add or Update records to the ADMIN DTL *                table. CD
 * ACTION CD will determine Add versus Update.  All *                fields on the ADMIN DTL which are not used in
 * CFIN07W will *                be set to Null or 0 depending upon type. *                Prior to the above AUD, this
 * service will call CMSC13D two *                times to check the number of reversals and adjustments. * *
 * Environment:   HP-UX V9.0 *                FOUNDATION V2.4 for Unix (Construction, Production) *                HP-UX
 * Ansi C Compiler * * Date Created:  11-14-1995 * * Programmer:    Tyler L. Chessman * * Archive Information:
 * $Revision:   1.0  $ *                      $Date:   27 May 1996 17:43:26  $ *                      $Modtime:   30 Mar
 * 1996 00:13:38  $ *                      $Author:   pvcs  $ * * Change History: *  Date      User      Description *
 * --------  --------  -------------------------------------------------- *  12-14-95  TLC       Added an if statement
 * (when counting reversals to be *                      saved to the database) to prevent a modified reversal * row
 * from being counted * *  1/10/96   LEELJ     Added DAM CAUD44D in order to update the Invoice * table with the proper
 * phase and validation flag. *                      The new invoice time stamp will be returned to * the window. * *
 * 1/10/96   GLOORJW   Added if statements around DAMs CAUD44D and *                      CMSC13D that will only allow
 * the DAMS to be *                      called if the previous DAM was successful. * *  01/10/96 GLOORJW   Removed
 * references to Pac and Obj variables * *  01/27/04 CORLEYAN  SIR 22425 Removed MSG_FIN_MORE_REV_THAN_ADJ since it *
 *                   has been deemed unneccesary * 05/12/06  Bittar    Converted CFIN16S to saveAdminDetail *
 * *************************************************************************
 */

public interface SaveAdminDetail {

  public static final String REVERSAL_LI = "R";
  public static final String ADJUSTMENT_LI = "A";
  public static final String FIN_CD_INVO_PHASE_PEND = "VLP";

  CFIN16SO saveAdminDetail(CFIN16SI cfin16si);
}
