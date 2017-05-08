package gov.georgia.dhr.dfcs.sacwis.conversion;
/**************************************************************************
**                                    
** Title: 
**  ARCPRFS.H
** 
** Facility: 
**  Performance (PRF) - Server
** 
** Abstract:
**  Prototypes and literals for the Performance facility.
**
** Environment:
**  HP UX 9.04
**  ORCALE Pro*C 1.5
**
** Date Created:
**  11/23/93
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  01/18/94  MJC       Changes per code walkthrough.
**  08/30/94  DKL       CAPS Initial version.
**  11/01/94  kingwr    Moved architecture specific information to
**                      ARCPRFS.C file.
**  06/14/95  wallacbe  change ARC_ERR_ERR_BASE to ARC_PRF_ERR_BASE
**
**************************************************************************/
public class Arcprfs {
    
    /**************************************************************************
    ** Include Files
    **************************************************************************/
    
    
    /**************************************************************************
    ** Constants 
    **************************************************************************/
    
    
    /**************************************************************************
    ** Return Codes
    **************************************************************************/
    public static final int ARC_PRF_ERR_BASE = 10500;
    public static final int ARC_PRF_SUCCESS = 0;
    public static final int ARC_PRF_BACK_END_ERROR = (ARC_PRF_ERR_BASE + 1);
    
}
