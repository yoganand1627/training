package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PrsnSearchOutRec;
/***************************************************************************
*                                                                          *
*                      C    H E A D E R    F I L E                         *
*                                                                          *
*                Copyright (C) 1996, Andersen Consulting.                  *
*                          All rights reserved.                            *
*                                                                          *
****************************************************************************
*                                                                          *
*                     Header file for: CINT09S - PERSON SEARCH             *
*                        Generated on: Thu Feb 15 13:42:09 2001            *
*                                  by: GONZALPC                            *
*                   Short Description: CINT09S - ADDRESS VALIDATION        *
*                                                                          *
****************************************************************************/

/***************************************************************************
* Definition for Record Group.CARC00SOG - OUTPUT ARCH MSG HDR
***************************************************************************/
public class CINT09SO {
    ArchOutputStruct ArchOutputStruct;
    PrsnSearchOutRec[] PrsnSearchOutRec = new PrsnSearchOutRec[65];
    public static final int SCR_CD_PERSON_SEARCH_HIT_LEN = 5;
    public static final int SZSCRCDPERSONSEARCHHIT_LEN = 5;
    public static final int CD_COUNTY_LEN = 4;
    public static final int SZCDCOUNTY_LEN = 4;
    public static final int _PERSONSEARCHOUTREC__PRSNSEARCHOUTREC_SIZE = 65;
    static {
        for (int PrsnSearchOutRec1 = 0;PrsnSearchOutRec1 < PrsnSearchOutRec.length;PrsnSearchOutRec1++) {
            PrsnSearchOutRec[PrsnSearchOutRec1] = new PrsnSearchOutRec();
        }
    }

}
