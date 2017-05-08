package gov.georgia.dhr.dfcs.sacwis.conversion;
public class Rowfromstageinfo {
    int ulIdStage;
    
    /* SIR 20525 - Temp holder for stage close date */
    FndInt3date dtDtStageClose;
    String szCdStageType = new String();
    String szCdStageProgram = new String();
    String szCdStage = new String();
    String szCdStageReasonClosed = new String();
}
