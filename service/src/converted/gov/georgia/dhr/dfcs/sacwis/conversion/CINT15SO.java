package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.Code1OutStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CityCountyStruct;
/***************************************************************************
*                                                                          *
*                      C    H E A D E R    F I L E                         *
*                                                                          *
*                Copyright (C) 1996, Andersen Consulting.                  *
*                          All rights reserved.                            *
*                                                                          *
****************************************************************************
*                                                                          *
*                     Header file for: CINT15S - VALIDATE ADDRESS          *
*                        Generated on: Tue May 11 17:50:57 1999            *
*                                  by: SNIDERDL                            *
*                   Short Description:                                     *
*                                                                          *
****************************************************************************/

/***************************************************************************
* Definition for Record Group.CARC00SOG - OUTPUT ARCH MSG HDR
***************************************************************************/
public class CINT15SO {
    ArchOutputStruct ArchOutputStruct;
    CityCountyStruct[] CityCountyStruct = new CityCountyStruct[20];
    String szCdCityTexCnty = new String();
    Code1OutStruct[] Code1OutStruct = new Code1OutStruct[2];
    public static final int SYS_ADDR_CODE1_COUNTY_LEN = 26;
    public static final int SZADDRCODE1COUNTY_LEN = 26;
    public static final int CD_CODE1_CNTY_CODE_LEN = 4;
    public static final int SZSYSCODE1CNTYCODE_LEN = 4;
    public static final int _VALIDADDROUTREC__CITYCOUNTYSTRUCT_SIZE = 20;
    public static final int _VALIDADDROUTREC__CODE1OUTSTRUCT_SIZE = 2;
    static {
        for (int Code1OutStruct1 = 0;Code1OutStruct1 < Code1OutStruct.length;Code1OutStruct1++) {
            Code1OutStruct[Code1OutStruct1] = new Code1OutStruct();
        }
        for (int CityCountyStruct1 = 0;CityCountyStruct1 < CityCountyStruct.length;CityCountyStruct1++) {
            CityCountyStruct[CityCountyStruct1] = new CityCountyStruct();
        }
    }

}
