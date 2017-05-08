package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CallListInStruct;
/***************************************************************************
*                                                                          *
*                      C    H E A D E R    F I L E                         *
*                                                                          *
*                Copyright (C) 1996, Andersen Consulting.                  *
*                          All rights reserved.                            *
*                                                                          *
****************************************************************************
*                                                                          *
*                     Header file for: CINT07S - CALL LIST SEARCH          *
*                        Generated on: Tue May 11 17:51:21 1999            *
*                                  by: SNIDERDL                            *
*                   Short Description: CINT11S - CALL LIST SEARCH          *
*                                                                          *
* 09/17/04 Sir 22964 -- Added a definition for .szCdInfoAndRefrl           *
*                                                                          *
****************************************************************************/

/***************************************************************************
* Definition for Record Group.CARC00SIG - INPUT ARCH MSG HDR
***************************************************************************/
public class CINT07SI {
    ArchInputStruct ArchInputStruct;
    CallListInStruct CallListInStruct;
    public static final int SCR_CALL_LOG_TIME_FROM_LEN = 9;
    public static final int SZSCRTIMEFROM_LEN = 9;
    public static final int SCR_CALL_LOG_TIME_TO_LEN = 9;
    public static final int SZSCRTMTIMETO_LEN = 9;
}
