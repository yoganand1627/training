package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PersListRtrvStruct;
/***************************************************************************
*                                                                          *
*                      C    H E A D E R    F I L E                         *
*                                                                          *
*                Copyright (C) 1996, Andersen Consulting.                  *
*                          All rights reserved.                            *
*                                                                          *
****************************************************************************
*                                                                          *
*                     Header file for: CINT26S - PERS LIST BOX RTRV        *
*                        Generated on: Wed Jun 23 11:09:27 1999            *
*                                  by: HABIB                               *
*                   Short Description: CINT01S - PERS LIST BOX RETRIEVE    *
*                                                                          *
****************************************************************************/

/***************************************************************************
* Definition for Record Group.CARC00SOG - OUTPUT ARCH MSG HDR
***************************************************************************/
public class CINT26SO {
    ArchOutputStruct ArchOutputStruct;
    PersListRtrvStruct[] PersListRtrvStruct = new PersListRtrvStruct[30];
    public static final int CD_STAGE_PERS_LST_SORT_LEN = 4;
    public static final int SZCDSTAGEPERSLSTSORT_LEN = 4;
    public static final int SCR_NBR_OF_ADDR_LEN = 5;
    public static final int LSCRNBROFADDRS_LEN = 5;
    public static final int SCR_NBR_PHONE_NBRS_LEN = 5;
    public static final int LSCRNBRPHONENBRS_LEN = 5;
    public static final int DESC_PERSON_ID_LEN = 41;
    public static final int SZDESCPERSONID_LEN = 41;
    public static final int _PERSLISTOUTREC__PERSLISTRTRVSTRUCT_SIZE = 30;
    static {
        for (int PersListRtrvStruct1 = 0;PersListRtrvStruct1 < PersListRtrvStruct.length;PersListRtrvStruct1++) {
            PersListRtrvStruct[PersListRtrvStruct1] = new PersListRtrvStruct();
        }
    }

}
