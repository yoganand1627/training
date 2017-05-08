package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.PersListAudStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PLAUDKeys;
/***************************************************************************
*                                                                          *
*                      C    H E A D E R    F I L E                         *
*                                                                          *
*                Copyright (C) 1996, Andersen Consulting.                  *
*                          All rights reserved.                            *
*                                                                          *
****************************************************************************
*                                                                          *
*                     Header file for: CINT02S - PERS LIST BOX AUD         *
*                        Generated on: Tue Nov 21 11:56:50 2000            *
*                                  by: SMITHAL                             *
*                   Short Description:                                     *
*                                                                          *
****************************************************************************/

/***************************************************************************
* Definition for Record Group.CARC00SIG - INPUT ARCH MSG HDR
***************************************************************************/
public class CINT02SI {
    ArchInputStruct ArchInputStruct;
    ROWCINT02SIG00[] ROWCINT02SIG00 = new ROWCINT02SIG00[10];
    ROWCINT02SIG01[] ROWCINT02SIG01 = new ROWCINT02SIG01[10];
    PersListAudStruct PersListAudStruct;
    ROWCCMN44SIG00[] ROWCCMN44SIG00 = new ROWCCMN44SIG00[15];
    ROWCCMN31SI[] ROWCCMN31SI = new ROWCCMN31SI[15];
    ROWCINV26SIG00[] ROWCINV26SIG00 = new ROWCINV26SIG00[10];
    Cint14wlb[] CINT14WLB = new Cint14wlb[65];
    PLAUDKeys PLAUDKeys;
    String SysLastUpdate = new String();
    String tsLastUpdate = new String();
    int usSysNbrNumberOfRows;
    FndInt3date dtWCDDtSystemDate;
    char bSysIndUpdateFullName;
    char bIndPersCancelHist;
    public static final int _PERSLISTAUDINREC__ROWCINT02SIG00_SIZE = 10;
    public static final int _PERSLISTAUDINREC__ROWCINT02SIG01_SIZE = 10;
    public static final int _PERSLISTAUDINREC__ROWCCMN44SIG00_SIZE = 15;
    public static final int _PERSLISTAUDINREC__ROWCCMN31SI_SIZE = 15;
    public static final int _PERSLISTAUDINREC__ROWCINV26SIG00_SIZE = 10;
    public static final int _PERSLISTAUDINREC__CINT14WLB_SIZE = 65;
    static {
        for (int CINT14WLB1 = 0;CINT14WLB1 < CINT14WLB.length;CINT14WLB1++) {
            CINT14WLB[CINT14WLB1] = new Cint14wlb();
        }
        for (int ROWCINV26SIG001 = 0;ROWCINV26SIG001 < ROWCINV26SIG00.length;ROWCINV26SIG001++) {
            ROWCINV26SIG00[ROWCINV26SIG001] = new ROWCINV26SIG00();
        }
        for (int ROWCCMN31SI1 = 0;ROWCCMN31SI1 < ROWCCMN31SI.length;ROWCCMN31SI1++) {
            ROWCCMN31SI[ROWCCMN31SI1] = new ROWCCMN31SI();
        }
        for (int ROWCCMN44SIG001 = 0;ROWCCMN44SIG001 < ROWCCMN44SIG00.length;ROWCCMN44SIG001++) {
            ROWCCMN44SIG00[ROWCCMN44SIG001] = new ROWCCMN44SIG00();
        }
        for (int ROWCINT02SIG011 = 0;ROWCINT02SIG011 < ROWCINT02SIG01.length;ROWCINT02SIG011++) {
            ROWCINT02SIG01[ROWCINT02SIG011] = new ROWCINT02SIG01();
        }
        for (int ROWCINT02SIG001 = 0;ROWCINT02SIG001 < ROWCINT02SIG00.length;ROWCINT02SIG001++) {
            ROWCINT02SIG00[ROWCINT02SIG001] = new ROWCINT02SIG00();
        }
    }

}
