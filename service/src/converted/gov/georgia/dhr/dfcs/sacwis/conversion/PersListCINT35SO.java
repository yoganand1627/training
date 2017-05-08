package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.MUpdIDInStruct;
public class PersListCINT35SO {
    ArchOutputStruct ArchOutputStruct;
    MUpdIDInStruct[] MUpdIDInStruct = new MUpdIDInStruct[30];
    static {
        for (int MUpdIDInStruct1 = 0;MUpdIDInStruct1 < MUpdIDInStruct.length;MUpdIDInStruct1++) {
            MUpdIDInStruct[MUpdIDInStruct1] = new MUpdIDInStruct();
        }
    }

}
