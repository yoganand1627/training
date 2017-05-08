package gov.georgia.dhr.dfcs.sacwis.conversion;
/***************************************************************************
*                                                                          *
*                      C    H E A D E R    F I L E                         *
*                                                                          *
*                Copyright (C) 1996, Andersen Consulting.                  *
*                          All rights reserved.                            *
*                                                                          *
****************************************************************************
*                                                                          *
*                     Header file for: CCFC40SL - CASE MRG LOCAL STRUCT    *
*                        Generated on: Wed Jun 30 13:46:43 1999            *
*                                  by: SNIDERDL                            *
*                   Short Description: CAAA04SI - MODEL ELB RTRV           *
*                                                                          *
****************************************************************************/

/***************************************************************************
* Definition for Record Group.ROWCCFC40SLG00 - CASE MRG LOCAL
***************************************************************************/
public class Ccfc40sl {
    Rowtostageinfo[] ROWTOSTAGEINFO = new Rowtostageinfo[100];
    Rowfromstageinfo[] ROWFROMSTAGEINFO = new Rowfromstageinfo[100];
    Rowtopersoninfo[] ROWTOPERSONINFO = new Rowtopersoninfo[150];
    Rowfrompersoninfo[] ROWFROMPERSONINFO = new Rowfrompersoninfo[150];
    public static final int _CCFC40SL__ROWTOSTAGEINFO_SIZE = 100;
    public static final int _CCFC40SL__ROWFROMSTAGEINFO_SIZE = 100;
    public static final int _CCFC40SL__ROWTOPERSONINFO_SIZE = 150;
    public static final int _CCFC40SL__ROWFROMPERSONINFO_SIZE = 150;
    static {
        for (int ROWFROMPERSONINFO1 = 0;ROWFROMPERSONINFO1 < ROWFROMPERSONINFO.length;ROWFROMPERSONINFO1++) {
            ROWFROMPERSONINFO[ROWFROMPERSONINFO1] = new Rowfrompersoninfo();
        }
        for (int ROWTOPERSONINFO1 = 0;ROWTOPERSONINFO1 < ROWTOPERSONINFO.length;ROWTOPERSONINFO1++) {
            ROWTOPERSONINFO[ROWTOPERSONINFO1] = new Rowtopersoninfo();
        }
        for (int ROWFROMSTAGEINFO1 = 0;ROWFROMSTAGEINFO1 < ROWFROMSTAGEINFO.length;ROWFROMSTAGEINFO1++) {
            ROWFROMSTAGEINFO[ROWFROMSTAGEINFO1] = new Rowfromstageinfo();
        }
        for (int ROWTOSTAGEINFO1 = 0;ROWTOSTAGEINFO1 < ROWTOSTAGEINFO.length;ROWTOSTAGEINFO1++) {
            ROWTOSTAGEINFO[ROWTOSTAGEINFO1] = new Rowtostageinfo();
        }
    }

}
