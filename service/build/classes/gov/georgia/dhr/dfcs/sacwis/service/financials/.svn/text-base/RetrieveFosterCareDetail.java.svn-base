package gov.georgia.dhr.dfcs.sacwis.service.financials;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN10SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN10SO;

/**
 * *********************************************************************** * * Module File:    CFIN10S.src * * Service
 * Name:   CFIN10S- Foster Care Detail Retrieval * * Description:   This service will retieve all records from the *
 * DELVRD_SVC_DTL table that have an ID INVOICE = to the one *                passed into the service.  The records will
 * be sorted *                alphabetically into the listbox according to Person Name. * Additionally, this service
 * will retrieve all the *                services of a contract.  CLSS13D will be called only on *                the
 * initial call to this service - SYS CARC RQST FUNC CD, *                stored in the input architecture record group,
 * will indicate *                whether to call CLSS13D. * * Environment:   HP-UX V9.0 *                FOUNDATION
 * V2.0 for Unix (Construction, Production) *                HP-UX Ansi C Compiler * * Date Created:  11--1995 * *
 * Programmer:    Tyler L. Chessman * * Archive Information: $Revision:   1.0  $ * $Date:   27 May 1996 17:26:20  $ *
 * $Modtime:   30 Mar 1996 00:12:20  $ * $Author:   pvcs  $ * * Change History: *  Date      User Description *
 * --------  -------- -------------------------------------------------- *  10/2/2001 Hadjimh   SIR# extension of 15787
 * The Service Code Combobox should *                      be populated with all the service codes of a contract. *
 * CLSS13D is replaced by CLSS75D just to do that. * *      09/03/03  Srini     SIR#19677 - statically setting the
 * pageno to 1 and *                                              pagesizenbr to 100 to fix paginating problem with the
 * *                                              service codes. * 5/18/2006 Bittar     Converted cfin10s to
 * RetrieveFosterCareDetail *************************************************************************
 */

public interface RetrieveFosterCareDetail {

  public static final String REQ_FUNC_CD_DTLS_CDS = ServiceConstants.REQ_FUNC_CD_SAVE_CHANGE;

  CFIN10SO retrieveFosterCareDetail(CFIN10SI cfin10si);
}
