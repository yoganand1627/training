package org.apache.jsp.grnds_002ddocs.document.cfp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import gov.georgia.dhr.dfcs.sacwis.core.utility.ForceNoTimeoutThread;
import gov.georgia.dhr.dfcs.sacwis.dao.document.cfp.ICaseFilePrint;
import gov.georgia.dhr.dfcs.sacwis.service.document.Cfp;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BasePrsConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.web.document.cfp.CaseFilePrint;
import gov.georgia.dhr.dfcs.sacwis.web.document.cfp.CfpConversation;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import gov.georgia.dhr.dfcs.sacwis.dao.document.cfp.ExceedQueueLimitException;
import java.rmi.RemoteException;

public final class ExerciseCfp_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


  public static boolean execute(Cfp cfp, JspWriter out, int userId, String userLogin, String outputCode, String program,
                                String caseId) throws IOException, ExceedQueueLimitException {
    List vector = cfp.getQueuedCfpStatusForUser(userId);
    if (vector.size() >= ICaseFilePrint.QUEUE_LIMIT) {
      return false;
    }
    out.println(new Date() + ": creating cfp job for {userId, outputCode, program, caseId} = " +
                "{" + userId + ", " + outputCode + ", " + program + ", " + caseId + "}<br>");
    out.flush();
    test(cfp, userId, userLogin, outputCode, program, caseId);
    return true;
  }

  public static void test(Cfp cfp, int userId, String userLogin, String outputCode, String program, String caseId)
          throws ExceedQueueLimitException, RemoteException {
    DateFormat dateFormat = new SimpleDateFormat("MMdd_HHmm");

    String jobName = "CFP Test Case " + program + " " + outputCode + " " + caseId;

    String destinationFileName =
            CfpConversation.CFP_BASE_FILE_LOCATION +
            program + "_" +
            outputCode + "_" +
            caseId + "_" +
            dateFormat.format(new Date()) +
            ".pdf";

    String[] outputCodesArray = new String[] {outputCode};

    CaseFilePrint.submitCfp(cfp, userId, userLogin, jobName, destinationFileName, Integer.parseInt(caseId), 0,
                            outputCodesArray);
  }


  protected static String[][] allDocumentTests = new String[][] {
//  CFA05o00 needs tableMetaData.
//  F/A Home Closing Summary Template
//  GenerateDocument
//  foreach event
//  cfa05o00
//  C460       CPS             46
//  -- There's nothing in the table

//  F170 AFC cfiv2300 Referral Form
//  REFERRAL_NARR
//  -NONE

//  csc02o Legal Log (Report)
//    new String[] { "L100", "CCL", "
//    NONE

//    //exercises cfiv2700 - fails because of bug in Documents.cs ?
//    new String[] { "C090", "CPS", "23511850" }, //exercises cfiv2700 and civ19o
//    new String[] { "C090", "CPS", "23593823" }, //exercises cfiv2700 and civ19o
//    new String[] { "C090", "CPS", "23592754" }, //exercises cfiv2700 and civ19o
//    new String[] { "C090", "CPS", "23675085" }, //exercises cfiv2700 and civ19o
//    new String[] { "C090", "CPS", "23539851" }, //exercises cfiv2700 and civ19o

new String[] {"A010", "APS", "23132970"},
new String[] {"A020", "APS", "23132970"},
new String[] {"A030", "APS", "3000001"},
new String[] {"A030", "APS", "3000005"},
new String[] {"A040", "APS", "23128840"},
new String[] {"A050", "APS", "23267226"},
new String[] {"A060", "APS", "23113613"},
new String[] {"A060", "APS", "3000078"},
new String[] {"A060", "APS", "3000397"},
new String[] {"A060", "APS", "3000557"},
new String[] {"A070", "APS", "23146298"},
new String[] {"A080", "APS", "23267232"},
new String[] {"A090", "APS", "23128816"},
new String[] {"A100", "APS", "23132970"},
new String[] {"A110", "APS", "10013782"},
new String[] {"A110", "APS", "10014130"},
new String[] {"A110", "APS", "3002586"},
new String[] {"A110", "APS", "3003491"},
new String[] {"A110", "APS", "3027210"},
new String[] {"A120", "APS", "23128826"},
new String[] {"A130", "APS", "23129403"},
new String[] {"A140", "APS", "23267240"},
new String[] {"A150", "APS", "23128820"},
new String[] {"A160", "APS", "23129525"},
new String[] {"A170", "APS", "3000046"},
new String[] {"A170", "APS", "3000080"},
new String[] {"A170", "APS", "3000120"},
new String[] {"A170", "APS", "3000154"},
new String[] {"A170", "APS", "3000172"},
new String[] {"A170", "APS", "3000198"},
new String[] {"A180", "APS", "23757264"},
new String[] {"A180", "APS", "23778837"},
new String[] {"A180", "APS", "23847923"},
new String[] {"A180", "APS", "23851005"},
new String[] {"A190", "APS", "23132970"},
new String[] {"A210", "APS", "23129153"},
new String[] {"C010", "CPS", "1000022"},
new String[] {"C020", "CPS", "200014"},
new String[] {"C030", "CPS", "1000001"},
new String[] {"C040", "CPS", "23128813"},
new String[] {"C050", "CPS", "23128823"},
new String[] {"C060", "CPS", "23128822"},
new String[] {"C070", "CPS", "23128819"},
new String[] {"C080", "CPS", "23128828"},
new String[] {"C090", "CPS", "23018539"}, //exercises civ30o00
new String[] {"C090", "CPS", "23128825"},
new String[] {"C090", "CPS", "23195408"}, //exercises civ30o00
new String[] {"C090", "CPS", "23328126"}, //exercises civ30o00
new String[] {"C090", "CPS", "23333343"}, //exercises civ30o00
new String[] {"C090", "CPS", "23356517"}, //exercises civ30o00
new String[] {"C090", "CPS", "23501654"}, //exercises civ30o00
new String[] {"C095", "CPS", "23128821"},
new String[] {"C100", "CPS", "23128830"},
new String[] {"C110", "CPS", "6000004"},
new String[] {"C110", "CPS", "6000029"},
new String[] {"C110", "CPS", "6000174"},
new String[] {"C110", "CPS", "6000177"},
new String[] {"C110", "CPS", "6000182"},
new String[] {"C120", "CPS", "6000639"},
new String[] {"C130", "CPS", "23128833"},
new String[] {"C140", "CPS", "6000639"},
new String[] {"C150", "CPS", "6000652"},
new String[] {"C160", "CPS", "20064615"},
new String[] {"C170", "CPS", "7001252"},
new String[] {"C180", "CPS", "6002619"},
new String[] {"C190", "CPS", "6002619"},
new String[] {"C200", "CPS", "6004624"},
new String[] {"C210", "CPS", "6002634"},
new String[] {"C210", "CPS", "6003509"},
new String[] {"C210", "CPS", "6004624"},
new String[] {"C210", "CPS", "6004626"},
new String[] {"C210", "CPS", "6004660"},
new String[] {"C220", "CPS", "6002619"},
new String[] {"C220", "CPS", "6002634"},
new String[] {"C220", "CPS", "6002721"},
new String[] {"C220", "CPS", "6003148"},
new String[] {"C230", "CPS", "6002619"},
new String[] {"C230", "CPS", "6002634"},
new String[] {"C240", "CPS", "6002619"},
new String[] {"C250", "CPS", "6002619"},
new String[] {"C260", "CPS", "6005899"},
new String[] {"C270", "CPS", "23128842"},
new String[] {"C280", "CPS", "6000652"},
new String[] {"C290", "CPS", "6002619"},
new String[] {"C300", "CPS", "200009"},
new String[] {"C310", "CPS", "200002"},
new String[] {"C310", "CPS", "200005"},
new String[] {"C310", "CPS", "200028"},
new String[] {"C310", "CPS", "200035"},
new String[] {"C310", "CPS", "200037"},
new String[] {"C320", "CPS", "200011"},
new String[] {"C330", "CPS", "200001"},
new String[] {"C340", "CPS", "1000000"},
new String[] {"C350", "CPS", "200012"},
new String[] {"C360", "CPS", "6003148"},
new String[] {"C360", "CPS", "6004660"},
new String[] {"C360", "CPS", "6004817"},
new String[] {"C360", "CPS", "6006747"},
new String[] {"C360", "CPS", "6007872"},
new String[] {"C370", "CPS", "200005"},
new String[] {"C380", "CPS", "200022"},
new String[] {"C390", "CPS", "200003"},
new String[] {"C400", "CPS", "200001"},
new String[] {"C400", "CPS", "200003"},
new String[] {"C400", "CPS", "200005"},
new String[] {"C410", "CPS", "200013"},
new String[] {"C420", "CPS", "1000026"},
new String[] {"C430", "CPS", "1000021"},
new String[] {"C430", "CPS", "200000"},
new String[] {"C430", "CPS", "200001"},
new String[] {"C430", "CPS", "200002"},
new String[] {"C430", "CPS", "200003"},
new String[] {"C430", "CPS", "200005"},
new String[] {"C440", "CPS", "10007882"},
new String[] {"C440", "CPS", "7002660"},
new String[] {"C440", "CPS", "7003138"},
new String[] {"C440", "CPS", "7008654"},
new String[] {"C440", "CPS", "8013973"},
new String[] {"C440", "CPS", "8019474"},
new String[] {"C450", "CPS", "200006"},
new String[] {"C460", "CPS", "10002040"},
new String[] {"C460", "CPS", "210516"},
new String[] {"C460", "CPS", "211057"},
new String[] {"C460", "CPS", "211751"},
new String[] {"C460", "CPS", "220583"},
new String[] {"C470", "CPS", "6002634"},
new String[] {"C480", "CPS", "6000639"},
new String[] {"C490", "CPS", "1000023"},
new String[] {"C500", "CPS", "200016"},
new String[] {"C510", "CPS", "200007"},
new String[] {"C520", "CPS", "200015"},
new String[] {"C530", "CPS", "6000177"},
new String[] {"C540", "CPS", "16004145"},
new String[] {"C540", "CPS", "225077"},
new String[] {"C540", "CPS", "7000503"},
new String[] {"C540", "CPS", "7013982"},
new String[] {"C540", "CPS", "7019400"},
new String[] {"C550", "CPS", "23177309"},
new String[] {"C550", "CPS", "23684585"},
new String[] {"C550", "CPS", "23712652"},
new String[] {"C550", "CPS", "23728963"},
new String[] {"C550", "CPS", "23729668"},
new String[] {"C560", "CPS", "6001906"},
new String[] {"C560", "CPS", "6002658"},
new String[] {"C560", "CPS", "6004790"},
new String[] {"C560", "CPS", "6005070"},
new String[] {"C560", "CPS", "6008118"},
new String[] {"C570", "CPS", "6004790"},
new String[] {"C570", "CPS", "6005070"},
new String[] {"C570", "CPS", "7001484"},
new String[] {"C570", "CPS", "7003132"},
new String[] {"C570", "CPS", "7021800"},
new String[] {"C580", "CPS", "1000001"},
new String[] {"C600", "CPS", "200023"},
new String[] {"F010", "AFC", "23128999"},
new String[] {"F020", "AFC", "23128829"},
new String[] {"F030", "AFC", "23129317"},
new String[] {"F040", "AFC", "23128996"},
new String[] {"F050", "AFC", "10000814"},
new String[] {"F050", "AFC", "10004969"},
new String[] {"F050", "AFC", "10006445"},
new String[] {"F050", "AFC", "10006584"},
new String[] {"F050", "AFC", "5000082"},
new String[] {"F060", "AFC", "23129305"},//?none?
new String[] {"F060", "AFC", "23218782"}, //exercises CFIV3000 (when you have stageId)
new String[] {"F060", "AFC", "23237304"}, //exercises CFIV3000 (when you have stageId)
new String[] {"F060", "AFC", "23298694"}, //exercises CFIV3000 (when you have stageId)
new String[] {"F060", "AFC", "23415820"}, //exercises CFIV3000 (when you have stageId)
new String[] {"F060", "AFC", "5000001"},
new String[] {"F060", "AFC", "5000002"},
new String[] {"F060", "AFC", "5000003"},
new String[] {"F060", "AFC", "5000004"},
new String[] {"F060", "AFC", "5000005"},
new String[] {"F060", "AFC", "5004554"}, //exercises CFIV3000 (when you have stageId)
new String[] {"F070", "AFC", "23128958"},
new String[] {"F080", "AFC", "23129831"},
new String[] {"F090", "AFC", "23129290"},
new String[] {"F100", "AFC", "23128857"},
new String[] {"F110", "AFC", "5000064"},
new String[] {"F110", "AFC", "5000138"},
new String[] {"F130", "AFC", "23104731"},
new String[] {"F130", "AFC", "23459459"},
new String[] {"F140", "AFC", "23267239"},
new String[] {"F160", "AFC", "23128931"},//seems to trigger LegacyProcessor's multithreaded issue
new String[] {"L010", "CCL", "23129582"},
new String[] {"L010", "RCL", "23140454"},
new String[] {"L020", "CCL", "23128989"},
new String[] {"L020", "RCL", "23130694"},
new String[] {"L030", "CCL", "23129711"},
new String[] {"L030", "RCL", "10001122"},
new String[] {"L040", "CCL", "23129534"},
new String[] {"L040", "RCL", "23146887"},
new String[] {"L050", "CCL", "23130337"},
new String[] {"L050", "RCL", "23129620"},
new String[] {"L060", "CCL", "23138843"},
new String[] {"L060", "RCL", "23811917"},
new String[] {"L070", "CCL", "10000061"},
new String[] {"L070", "CCL", "10000072"},
new String[] {"L070", "CCL", "23133141"},
new String[] {"L070", "RCL", "10001122"},
new String[] {"L070", "RCL", "10004086"},
new String[] {"L080", "CCL", "23130144"},
new String[] {"L080", "RCL", "23129303"},
new String[] {"L090", "CCL", "23131055"},
new String[] {"L090", "RCL", "23124522"},
new String[] {"L100", "RCL", "10004545"},
new String[] {"L110", "CCL", "23092209"},
new String[] {"L110", "CCL", "24392205"},
new String[] {"L110", "CCL", "24411050"},
new String[] {"L110", "CCL", "24456000"},
new String[] {"L110", "RCL", "23129021"},
new String[] {"L120", "CCL", "24263563"},
new String[] {"L120", "RCL", "24057966"},
new String[] {"L120", "RCL", "24151137"},
new String[] {"L120", "RCL", "24229713"},
new String[] {"L120", "RCL", "24316586"},
new String[] {"L120", "RCL", "24708201"},
new String[] {"L130", "CCL", "10000360"},
new String[] {"L130", "RCL", "23132447"},
new String[] {"L150", "CCL", "23129955"},
new String[] {"L150", "RCL", "23121007"}
  };

  protected static String[][] childPlanTests = new String[][] {
          new String[] {"C160", "CPS", "6003509"},
          new String[] {"C160", "CPS", "7000078"},
          new String[] {"C160", "CPS", "7000539"},
          new String[] {"C160", "CPS", "7001358"},
          new String[] {"C160", "CPS", "7001366"},
          new String[] {"C160", "CPS", "7003594"},
          new String[] {"C160", "CPS", "7004144"},
          new String[] {"C160", "CPS", "7004645"},
          new String[] {"C160", "CPS", "7005030"},
          new String[] {"C160", "CPS", "7005336"},
          new String[] {"C160", "CPS", "7005619"},
          new String[] {"C160", "CPS", "7005740"},
          new String[] {"C160", "CPS", "7010289"},
          new String[] {"C160", "CPS", "7010324"},
          new String[] {"C160", "CPS", "7011244"},
          new String[] {"C160", "CPS", "7011380"},
          new String[] {"C160", "CPS", "7013383"},
          new String[] {"C160", "CPS", "7013518"},
          new String[] {"C160", "CPS", "7013572"},
          new String[] {"C160", "CPS", "7017742"},
          new String[] {"C160", "CPS", "7018882"},
          new String[] {"C160", "CPS", "7027778"},
          new String[] {"C160", "CPS", "7033744"},
          new String[] {"C160", "CPS", "8007777"},
          new String[] {"C160", "CPS", "10000322"},
          new String[] {"C160", "CPS", "10002656"},
          new String[] {"C160", "CPS", "10016247"},
          new String[] {"C160", "CPS", "10021389"},
          new String[] {"C160", "CPS", "14002469"},
          new String[] {"C160", "CPS", "14003781"},
          new String[] {"C160", "CPS", "14010427"},
          new String[] {"C160", "CPS", "15070972"},
          new String[] {"C160", "CPS", "16000342"},
          new String[] {"C160", "CPS", "16000747"},
          new String[] {"C160", "CPS", "16000923"},
          new String[] {"C160", "CPS", "16001562"},
          new String[] {"C160", "CPS", "16001943"},
          new String[] {"C160", "CPS", "16004265"},
          new String[] {"C160", "CPS", "16004968"},
          new String[] {"C160", "CPS", "16005757"},
          new String[] {"C160", "CPS", "16005888"},
          new String[] {"C160", "CPS", "16006161"},
          new String[] {"C160", "CPS", "16006252"},
          new String[] {"C160", "CPS", "16006886"},
          new String[] {"C160", "CPS", "16007208"},
          new String[] {"C160", "CPS", "16007927"},
          new String[] {"C160", "CPS", "16008028"},
          new String[] {"C160", "CPS", "16008109"},
          new String[] {"C160", "CPS", "16008177"},
          new String[] {"C160", "CPS", "16008466"},
          new String[] {"C160", "CPS", "16008591"},
          new String[] {"C160", "CPS", "16009524"},
          new String[] {"C160", "CPS", "16009575"},
          new String[] {"C160", "CPS", "16010979"},
          new String[] {"C160", "CPS", "16011310"},
          new String[] {"C160", "CPS", "16011320"},
          new String[] {"C160", "CPS", "16013638"},
          new String[] {"C160", "CPS", "16015807"},
          new String[] {"C160", "CPS", "16016153"},
          new String[] {"C160", "CPS", "16016924"},
          new String[] {"C160", "CPS", "16017152"},
          new String[] {"C160", "CPS", "16017914"},
          new String[] {"C160", "CPS", "16018055"},
          new String[] {"C160", "CPS", "16018327"},
          new String[] {"C160", "CPS", "16019164"},
          new String[] {"C160", "CPS", "16019355"},
          new String[] {"C160", "CPS", "16019620"},
          new String[] {"C160", "CPS", "16020169"},
          new String[] {"C160", "CPS", "16020377"},
          new String[] {"C160", "CPS", "16022351"},
          new String[] {"C160", "CPS", "16022898"},
          new String[] {"C160", "CPS", "16023167"},
          new String[] {"C160", "CPS", "16023201"},
          new String[] {"C160", "CPS", "16024520"},
          new String[] {"C160", "CPS", "16024897"},
          new String[] {"C160", "CPS", "16026196"},
          new String[] {"C160", "CPS", "16027613"},
          new String[] {"C160", "CPS", "16027771"},
          new String[] {"C160", "CPS", "16027776"},
          new String[] {"C160", "CPS", "16029284"},
          new String[] {"C160", "CPS", "16029458"},
          new String[] {"C160", "CPS", "16030036"},
          new String[] {"C160", "CPS", "16030065"},
          new String[] {"C160", "CPS", "16031273"},
          new String[] {"C160", "CPS", "16032056"},
          new String[] {"C160", "CPS", "16032590"},
          new String[] {"C160", "CPS", "16032694"},
          new String[] {"C160", "CPS", "16032910"},
          new String[] {"C160", "CPS", "16035719"},
          new String[] {"C160", "CPS", "16035776"},
          new String[] {"C160", "CPS", "16035851"},
          new String[] {"C160", "CPS", "16036993"},
          new String[] {"C160", "CPS", "16038442"},
          new String[] {"C160", "CPS", "16039620"},
          new String[] {"C160", "CPS", "16040160"},
          new String[] {"C160", "CPS", "16041636"},
          new String[] {"C160", "CPS", "16041905"},
          new String[] {"C160", "CPS", "16045187"},
          new String[] {"C160", "CPS", "16045587"},
          new String[] {"C160", "CPS", "16045954"},
          new String[] {"C160", "CPS", "16046462"},
          new String[] {"C160", "CPS", "16047324"},
          new String[] {"C160", "CPS", "16048382"},
          new String[] {"C160", "CPS", "16048850"},
          new String[] {"C160", "CPS", "16049122"},
          new String[] {"C160", "CPS", "16049583"},
          new String[] {"C160", "CPS", "16051880"},
          new String[] {"C160", "CPS", "16052067"},
          new String[] {"C160", "CPS", "16052323"},
          new String[] {"C160", "CPS", "16052332"},
          new String[] {"C160", "CPS", "16052588"},
          new String[] {"C160", "CPS", "16055961"},
          new String[] {"C160", "CPS", "16058505"},
          new String[] {"C160", "CPS", "16058625"},
          new String[] {"C160", "CPS", "16059387"},
          new String[] {"C160", "CPS", "16059523"},
          new String[] {"C160", "CPS", "16060140"},
          new String[] {"C160", "CPS", "16060791"},
          new String[] {"C160", "CPS", "16062618"},
          new String[] {"C160", "CPS", "16063492"},
          new String[] {"C160", "CPS", "16064010"},
          new String[] {"C160", "CPS", "16065196"},
          new String[] {"C160", "CPS", "16066145"},
          new String[] {"C160", "CPS", "16067683"},
          new String[] {"C160", "CPS", "16068182"},
          new String[] {"C160", "CPS", "16069037"},
          new String[] {"C160", "CPS", "16069159"},
          new String[] {"C160", "CPS", "16073214"},
          new String[] {"C160", "CPS", "16073717"},
          new String[] {"C160", "CPS", "16075094"},
          new String[] {"C160", "CPS", "16077572"},
          new String[] {"C160", "CPS", "16077795"},
          new String[] {"C160", "CPS", "16078170"},
          new String[] {"C160", "CPS", "16080957"},
          new String[] {"C160", "CPS", "16081799"},
          new String[] {"C160", "CPS", "16092781"},
          new String[] {"C160", "CPS", "16094532"},
          new String[] {"C160", "CPS", "16095635"},
          new String[] {"C160", "CPS", "16098324"},
          new String[] {"C160", "CPS", "16098686"},
          new String[] {"C160", "CPS", "16099710"},
          new String[] {"C160", "CPS", "16101710"},
          new String[] {"C160", "CPS", "16102558"},
          new String[] {"C160", "CPS", "16107508"},
          new String[] {"C160", "CPS", "16109413"},
          new String[] {"C160", "CPS", "16110996"},
          new String[] {"C160", "CPS", "16113792"},
          new String[] {"C160", "CPS", "16115305"},
          new String[] {"C160", "CPS", "16116537"},
          new String[] {"C160", "CPS", "16117268"},
          new String[] {"C160", "CPS", "16121403"},
          new String[] {"C160", "CPS", "16121492"},
          new String[] {"C160", "CPS", "16123544"},
          new String[] {"C160", "CPS", "16133817"},
          new String[] {"C160", "CPS", "17002082"},
          new String[] {"C160", "CPS", "17014375"},
          new String[] {"C160", "CPS", "17034708"},
          new String[] {"C160", "CPS", "17037618"},
          new String[] {"C160", "CPS", "17038629"},
          new String[] {"C160", "CPS", "17040499"},
          new String[] {"C160", "CPS", "17048082"},
          new String[] {"C160", "CPS", "17065785"},
          new String[] {"C160", "CPS", "20025321"},
          new String[] {"C160", "CPS", "20034151"},
          new String[] {"C160", "CPS", "20041646"},
          new String[] {"C160", "CPS", "20062833"},
          new String[] {"C160", "CPS", "20069266"},
          new String[] {"C160", "CPS", "20075718"},
          new String[] {"C160", "CPS", "20095091"},
          new String[] {"C160", "CPS", "20098612"},
          new String[] {"C160", "CPS", "20105989"},
          new String[] {"C160", "CPS", "20107890"},
          new String[] {"C160", "CPS", "23008852"},
          new String[] {"C160", "CPS", "23009636"},
          new String[] {"C160", "CPS", "23011699"},
          new String[] {"C160", "CPS", "23012644"},
          new String[] {"C160", "CPS", "23012927"},
          new String[] {"C160", "CPS", "23016055"},
          new String[] {"C160", "CPS", "23017166"},
          new String[] {"C160", "CPS", "23018857"},
          new String[] {"C160", "CPS", "23022775"},
          new String[] {"C160", "CPS", "23024211"},
          new String[] {"C160", "CPS", "23025600"},
          new String[] {"C160", "CPS", "23039075"},
          new String[] {"C160", "CPS", "23049593"},
          new String[] {"C160", "CPS", "23051721"},
          new String[] {"C160", "CPS", "23053842"},
          new String[] {"C160", "CPS", "23061761"},
          new String[] {"C160", "CPS", "23072233"},
          new String[] {"C160", "CPS", "23076008"},
          new String[] {"C160", "CPS", "23076635"},
          new String[] {"C160", "CPS", "23077916"},
          new String[] {"C160", "CPS", "23085385"},
          new String[] {"C160", "CPS", "23097919"},
          new String[] {"C160", "CPS", "23100732"},
          new String[] {"C160", "CPS", "23108265"},
          new String[] {"C160", "CPS", "23117102"},
          new String[] {"C160", "CPS", "23125337"},
          new String[] {"C160", "CPS", "23136776"},
          new String[] {"C160", "CPS", "23139672"},
          new String[] {"C160", "CPS", "23140370"},
          new String[] {"C160", "CPS", "23141974"},
          new String[] {"C160", "CPS", "23146901"},
          new String[] {"C160", "CPS", "23154573"},
          new String[] {"C160", "CPS", "23158291"},
          new String[] {"C160", "CPS", "23160407"},
          new String[] {"C160", "CPS", "23173156"},
          new String[] {"C160", "CPS", "23176602"},
          new String[] {"C160", "CPS", "23180754"},
          new String[] {"C160", "CPS", "23180908"},
          new String[] {"C160", "CPS", "23183184"},
          new String[] {"C160", "CPS", "23184215"},
          new String[] {"C160", "CPS", "23190110"},
          new String[] {"C160", "CPS", "23192248"},
          new String[] {"C160", "CPS", "23194579"},
          new String[] {"C160", "CPS", "23195518"},
          new String[] {"C160", "CPS", "23204456"},
          new String[] {"C160", "CPS", "23226045"},
          new String[] {"C160", "CPS", "23232406"},
          new String[] {"C160", "CPS", "23234827"},
          new String[] {"C160", "CPS", "23240581"},
          new String[] {"C160", "CPS", "23246235"},
          new String[] {"C160", "CPS", "23247512"},
          new String[] {"C160", "CPS", "23253529"},
          new String[] {"C160", "CPS", "23257801"},
          new String[] {"C160", "CPS", "23266793"},
          new String[] {"C160", "CPS", "23268491"},
          new String[] {"C160", "CPS", "23269977"},
          new String[] {"C160", "CPS", "23279420"},
          new String[] {"C160", "CPS", "23281759"},
          new String[] {"C160", "CPS", "23293225"},
          new String[] {"C160", "CPS", "23298629"},
          new String[] {"C160", "CPS", "23300308"},
          new String[] {"C160", "CPS", "23307077"},
          new String[] {"C160", "CPS", "23308541"},
          new String[] {"C160", "CPS", "23309909"},
          new String[] {"C160", "CPS", "23314794"},
          new String[] {"C160", "CPS", "23317964"},
          new String[] {"C160", "CPS", "23337909"},
          new String[] {"C160", "CPS", "23342934"},
          new String[] {"C160", "CPS", "23355144"},
          new String[] {"C160", "CPS", "23359566"},
          new String[] {"C160", "CPS", "23377060"},
          new String[] {"C160", "CPS", "23377728"},
          new String[] {"C160", "CPS", "23379843"},
          new String[] {"C160", "CPS", "23381446"},
          new String[] {"C160", "CPS", "23396006"},
          new String[] {"C160", "CPS", "23397973"},
          new String[] {"C160", "CPS", "23398049"},
          new String[] {"C160", "CPS", "23413135"},
          new String[] {"C160", "CPS", "23415437"},
          new String[] {"C160", "CPS", "23416889"},
          new String[] {"C160", "CPS", "23418077"},
          new String[] {"C160", "CPS", "23421253"},
          new String[] {"C160", "CPS", "23428199"},
          new String[] {"C160", "CPS", "23436417"},
          new String[] {"C160", "CPS", "23451172"},
          new String[] {"C160", "CPS", "23456654"},
          new String[] {"C160", "CPS", "23471127"},
          new String[] {"C160", "CPS", "23480878"},
          new String[] {"C160", "CPS", "23484881"},
          new String[] {"C160", "CPS", "23485988"},
          new String[] {"C160", "CPS", "23506966"},
          new String[] {"C160", "CPS", "23512268"},
          new String[] {"C160", "CPS", "23520695"},
          new String[] {"C160", "CPS", "23538703"},
          new String[] {"C160", "CPS", "23544859"},
          new String[] {"C160", "CPS", "23573826"},
          new String[] {"C160", "CPS", "23579517"},
          new String[] {"C160", "CPS", "23590922"},
          new String[] {"C160", "CPS", "23600876"},
          new String[] {"C160", "CPS", "23602183"},
          new String[] {"C160", "CPS", "23610728"},
          new String[] {"C160", "CPS", "23611142"},
          new String[] {"C160", "CPS", "23613920"},
          new String[] {"C160", "CPS", "23617671"},
          new String[] {"C160", "CPS", "23619933"},
          new String[] {"C160", "CPS", "23620905"},
          new String[] {"C160", "CPS", "23625345"},
          new String[] {"C160", "CPS", "23631912"},
          new String[] {"C160", "CPS", "23633832"},
          new String[] {"C160", "CPS", "23635152"},
          new String[] {"C160", "CPS", "23647636"},
          new String[] {"C160", "CPS", "23647732"},
          new String[] {"C160", "CPS", "23653891"},
          new String[] {"C160", "CPS", "23695999"},
          new String[] {"C160", "CPS", "23709555"},
          new String[] {"C160", "CPS", "23742605"},
          new String[] {"C160", "CPS", "23747166"},
          new String[] {"C160", "CPS", "23748539"},
          new String[] {"C160", "CPS", "23751188"},
          new String[] {"C160", "CPS", "23766930"},
          new String[] {"C160", "CPS", "23767687"},
          new String[] {"C160", "CPS", "23777966"},
          new String[] {"C160", "CPS", "23786505"},
          new String[] {"C160", "CPS", "23788194"},
          new String[] {"C160", "CPS", "23790754"},
          new String[] {"C160", "CPS", "23790796"},
          new String[] {"C160", "CPS", "23804647"},
          new String[] {"C160", "CPS", "23807623"},
          new String[] {"C160", "CPS", "23833461"},
          new String[] {"C160", "CPS", "23852856"},
          new String[] {"C160", "CPS", "23854992"},
          new String[] {"C160", "CPS", "23859120"},
          new String[] {"C160", "CPS", "23863046"},
          new String[] {"C160", "CPS", "23868124"},
          new String[] {"C160", "CPS", "23869578"},
          new String[] {"C160", "CPS", "23884048"},
          new String[] {"C160", "CPS", "23886086"},
          new String[] {"C160", "CPS", "23918959"},
          new String[] {"C160", "CPS", "23925576"},
          new String[] {"C160", "CPS", "23931192"},
          new String[] {"C160", "CPS", "23932355"},
          new String[] {"C160", "CPS", "23958995"},
          new String[] {"C160", "CPS", "23978214"},
          new String[] {"C160", "CPS", "23982252"},
          new String[] {"C160", "CPS", "23984737"},
          new String[] {"C160", "CPS", "23989502"},
          new String[] {"C160", "CPS", "23997110"},
          new String[] {"C160", "CPS", "24015846"},
          new String[] {"C160", "CPS", "24019657"},
          new String[] {"C160", "CPS", "24048604"},
          new String[] {"C160", "CPS", "24069292"},
          new String[] {"C160", "CPS", "24079011"},
          new String[] {"C160", "CPS", "24113166"},
          new String[] {"C160", "CPS", "24136070"},
          new String[] {"C160", "CPS", "24141430"},
          new String[] {"C160", "CPS", "24203553"},
          new String[] {"C160", "CPS", "24204013"},
          new String[] {"C160", "CPS", "24221448"},
          new String[] {"C160", "CPS", "24303534"},
          new String[] {"C160", "CPS", "24647882"},
          new String[] {"C160", "CPS", "24713403"},
  };

  protected static String[][] contactTests = new String[][] {
          new String[] {"A140", "APS", "23744469"},
          new String[] {"A140", "APS", "23748881"},
          new String[] {"A140", "APS", "23758151"},
          new String[] {"A140", "APS", "23862033"},
          new String[] {"A140", "APS", "23909866"},
          new String[] {"A140", "APS", "23916405"},
          new String[] {"A140", "APS", "23927258"},
          new String[] {"A140", "APS", "23998019"},
          new String[] {"A140", "APS", "24018664"},
          new String[] {"A140", "APS", "24112022"},
          new String[] {"A140", "APS", "24124382"},
          new String[] {"A140", "APS", "24155091"},
          new String[] {"A140", "APS", "24157159"},
          new String[] {"A140", "APS", "24164519"},
          new String[] {"A140", "APS", "24252192"},
          new String[] {"A140", "APS", "24255003"},
          new String[] {"A140", "APS", "24341675"},
          new String[] {"A140", "APS", "24361461"},
          new String[] {"A140", "APS", "24392885"},
          new String[] {"A140", "APS", "24406890"},
          new String[] {"C500", "CPS", "23726173"},
          new String[] {"C500", "CPS", "23727194"},
          new String[] {"C500", "CPS", "23736698"},
          new String[] {"C500", "CPS", "23739724"},
          new String[] {"C500", "CPS", "23740724"},
          new String[] {"C500", "CPS", "23741225"},
          new String[] {"C500", "CPS", "23741579"},
          new String[] {"C500", "CPS", "23742071"},
          new String[] {"C500", "CPS", "23742605"},
          new String[] {"C500", "CPS", "23745611"},
          new String[] {"C500", "CPS", "23746604"},
          new String[] {"C500", "CPS", "23747367"},
          new String[] {"C500", "CPS", "23748539"},
          new String[] {"C500", "CPS", "23749458"},
          new String[] {"C500", "CPS", "23772033"},
          new String[] {"C500", "CPS", "23773037"},
          new String[] {"C500", "CPS", "23773253"},
          new String[] {"C500", "CPS", "23778392"},
          new String[] {"C500", "CPS", "23781486"},
          new String[] {"C500", "CPS", "23781528"},
          new String[] {"C500", "CPS", "23782265"},
          new String[] {"C500", "CPS", "23783271"},
          new String[] {"C500", "CPS", "23783651"},
          new String[] {"C500", "CPS", "23786505"},
          new String[] {"C500", "CPS", "23788001"},
          new String[] {"C500", "CPS", "23790754"},
          new String[] {"C500", "CPS", "23790796"},
          new String[] {"C500", "CPS", "23794066"},
          new String[] {"C500", "CPS", "23797151"},
          new String[] {"C500", "CPS", "23800566"},
          new String[] {"C500", "CPS", "23801128"},
          new String[] {"C500", "CPS", "23801901"},
          new String[] {"C500", "CPS", "23803920"},
          new String[] {"C500", "CPS", "23804647"},
          new String[] {"C500", "CPS", "23806111"},
          new String[] {"C500", "CPS", "23806352"},
          new String[] {"C500", "CPS", "23807547"},
          new String[] {"C500", "CPS", "23807623"},
          new String[] {"C500", "CPS", "23809258"},
          new String[] {"C500", "CPS", "23811051"},
          new String[] {"C500", "CPS", "23811184"},
          new String[] {"C500", "CPS", "23815173"},
          new String[] {"C500", "CPS", "23816389"},
          new String[] {"C500", "CPS", "23818256"},
          new String[] {"C500", "CPS", "23826851"},
          new String[] {"C500", "CPS", "23830645"},
          new String[] {"C500", "CPS", "23831412"},
          new String[] {"C500", "CPS", "23836121"},
          new String[] {"C500", "CPS", "23838626"},
          new String[] {"C500", "CPS", "23842015"},
          new String[] {"C500", "CPS", "23845614"},
          new String[] {"C500", "CPS", "23851049"},
          new String[] {"C500", "CPS", "23851493"},
          new String[] {"C500", "CPS", "23852856"},
          new String[] {"C500", "CPS", "23854992"},
          new String[] {"C500", "CPS", "23859120"},
          new String[] {"C500", "CPS", "23861795"},
          new String[] {"C500", "CPS", "23865908"},
          new String[] {"C500", "CPS", "23866402"},
          new String[] {"C500", "CPS", "23867485"},
          new String[] {"C500", "CPS", "23868124"},
          new String[] {"C500", "CPS", "23869247"},
          new String[] {"C500", "CPS", "23869753"},
          new String[] {"C500", "CPS", "23870674"},
          new String[] {"C500", "CPS", "23874819"},
          new String[] {"C500", "CPS", "23879109"},
          new String[] {"C500", "CPS", "23882071"},
          new String[] {"C500", "CPS", "23882949"},
          new String[] {"C500", "CPS", "23884048"},
          new String[] {"C500", "CPS", "23890968"},
          new String[] {"C500", "CPS", "23891018"},
          new String[] {"C500", "CPS", "23892840"},
          new String[] {"C500", "CPS", "23895260"},
          new String[] {"C500", "CPS", "23900286"},
          new String[] {"C500", "CPS", "23901434"},
          new String[] {"C500", "CPS", "23905625"},
          new String[] {"C500", "CPS", "23906640"},
          new String[] {"C500", "CPS", "23907556"},
          new String[] {"C500", "CPS", "23908596"},
          new String[] {"C500", "CPS", "23912166"},
          new String[] {"C500", "CPS", "23920852"},
          new String[] {"C500", "CPS", "23925409"},
          new String[] {"C500", "CPS", "23928348"},
          new String[] {"C500", "CPS", "23930609"},
          new String[] {"C500", "CPS", "23931086"},
          new String[] {"C500", "CPS", "23945488"},
          new String[] {"C500", "CPS", "23948493"},
          new String[] {"C500", "CPS", "23950021"},
          new String[] {"C500", "CPS", "23952146"},
          new String[] {"C500", "CPS", "23952600"},
          new String[] {"C500", "CPS", "23953928"},
          new String[] {"C500", "CPS", "23959774"},
          new String[] {"C500", "CPS", "23961417"},
          new String[] {"C500", "CPS", "23965760"},
          new String[] {"C500", "CPS", "23969696"},
          new String[] {"C500", "CPS", "23977470"},
          new String[] {"C500", "CPS", "23978453"},
          new String[] {"C500", "CPS", "23979802"},
          new String[] {"C500", "CPS", "23984737"},
          new String[] {"C500", "CPS", "23986799"},
          new String[] {"C500", "CPS", "23987563"},
          new String[] {"C500", "CPS", "23990689"},
          new String[] {"C500", "CPS", "23991178"},
          new String[] {"C500", "CPS", "23992287"},
          new String[] {"C500", "CPS", "23992821"},
          new String[] {"C500", "CPS", "23998951"},
          new String[] {"C500", "CPS", "23998979"},
          new String[] {"C500", "CPS", "23999980"},
          new String[] {"C500", "CPS", "24006976"},
          new String[] {"C500", "CPS", "24008464"},
          new String[] {"C500", "CPS", "24009110"},
          new String[] {"C500", "CPS", "24013116"},
          new String[] {"C500", "CPS", "24015307"},
          new String[] {"C500", "CPS", "24019657"},
          new String[] {"C500", "CPS", "24022707"},
          new String[] {"C500", "CPS", "24024129"},
          new String[] {"C500", "CPS", "24025142"},
          new String[] {"C500", "CPS", "24026361"},
          new String[] {"C500", "CPS", "24029256"},
          new String[] {"C500", "CPS", "24043914"},
          new String[] {"C500", "CPS", "24046255"},
          new String[] {"C500", "CPS", "24048677"},
          new String[] {"C500", "CPS", "24052441"},
          new String[] {"C500", "CPS", "24056312"},
          new String[] {"C500", "CPS", "24062929"},
          new String[] {"C500", "CPS", "24066398"},
          new String[] {"C500", "CPS", "24069292"},
          new String[] {"C500", "CPS", "24070551"},
          new String[] {"C500", "CPS", "24072969"},
          new String[] {"C500", "CPS", "24074024"},
          new String[] {"C500", "CPS", "24077510"},
          new String[] {"C500", "CPS", "24078068"},
          new String[] {"C500", "CPS", "24079011"},
          new String[] {"C500", "CPS", "24080110"},
          new String[] {"C500", "CPS", "24084965"},
          new String[] {"C500", "CPS", "24085615"},
          new String[] {"C500", "CPS", "24089523"},
          new String[] {"C500", "CPS", "24096775"},
          new String[] {"C500", "CPS", "24097637"},
          new String[] {"C500", "CPS", "24098837"},
          new String[] {"C500", "CPS", "24104022"},
          new String[] {"C500", "CPS", "24105659"},
          new String[] {"C500", "CPS", "24106309"},
          new String[] {"C500", "CPS", "24109238"},
          new String[] {"C500", "CPS", "24111435"},
          new String[] {"C500", "CPS", "24112823"},
          new String[] {"C500", "CPS", "24119838"},
          new String[] {"C500", "CPS", "24121382"},
          new String[] {"C500", "CPS", "24127221"},
          new String[] {"C500", "CPS", "24127255"},
          new String[] {"C500", "CPS", "24131732"},
          new String[] {"C500", "CPS", "24136070"},
          new String[] {"C500", "CPS", "24136961"},
          new String[] {"C500", "CPS", "24138156"},
          new String[] {"C500", "CPS", "24139456"},
          new String[] {"C500", "CPS", "24141430"},
          new String[] {"C500", "CPS", "24142964"},
          new String[] {"C500", "CPS", "24152527"},
          new String[] {"C500", "CPS", "24153085"},
          new String[] {"C500", "CPS", "24157578"},
          new String[] {"C500", "CPS", "24159440"},
          new String[] {"C500", "CPS", "24164418"},
          new String[] {"C500", "CPS", "24167987"},
          new String[] {"C500", "CPS", "24169065"},
          new String[] {"C500", "CPS", "24169877"},
          new String[] {"C500", "CPS", "24170964"},
          new String[] {"C500", "CPS", "24177568"},
          new String[] {"C500", "CPS", "24178815"},
          new String[] {"C500", "CPS", "24197204"},
          new String[] {"C500", "CPS", "24199040"},
          new String[] {"C500", "CPS", "24205411"},
          new String[] {"C500", "CPS", "24223863"},
          new String[] {"C500", "CPS", "24228807"},
          new String[] {"C500", "CPS", "24229100"},
          new String[] {"C500", "CPS", "24236955"},
          new String[] {"C500", "CPS", "24241102"},
          new String[] {"C500", "CPS", "24251924"},
          new String[] {"C500", "CPS", "24252951"},
          new String[] {"C500", "CPS", "24255819"},
          new String[] {"C500", "CPS", "24257721"},
          new String[] {"C500", "CPS", "24259501"},
          new String[] {"C500", "CPS", "24274885"},
          new String[] {"C500", "CPS", "24298820"},
          new String[] {"C500", "CPS", "24303777"},
          new String[] {"C500", "CPS", "24305076"},
          new String[] {"C500", "CPS", "24310473"},
          new String[] {"C500", "CPS", "24313149"},
          new String[] {"C500", "CPS", "24330958"},
          new String[] {"C500", "CPS", "24332190"},
          new String[] {"C500", "CPS", "24333290"},
          new String[] {"C500", "CPS", "24336444"},
          new String[] {"C500", "CPS", "24344128"},
          new String[] {"C500", "CPS", "24359612"},
          new String[] {"C500", "CPS", "24361737"},
          new String[] {"C500", "CPS", "24366727"},
          new String[] {"C500", "CPS", "24374460"},
          new String[] {"C500", "CPS", "24378816"},
          new String[] {"C500", "CPS", "24381330"},
          new String[] {"C500", "CPS", "24382161"},
          new String[] {"C500", "CPS", "24387184"},
          new String[] {"C500", "CPS", "24388795"},
          new String[] {"C500", "CPS", "24397136"},
          new String[] {"C500", "CPS", "24403589"},
          new String[] {"C500", "CPS", "24404486"},
          new String[] {"C500", "CPS", "24414186"},
          new String[] {"C500", "CPS", "24414888"},
          new String[] {"C500", "CPS", "24415641"},
          new String[] {"C500", "CPS", "24418067"},
          new String[] {"C500", "CPS", "24419290"},
          new String[] {"C500", "CPS", "24427018"},
          new String[] {"C500", "CPS", "24428420"},
          new String[] {"C500", "CPS", "24457639"},
          new String[] {"C500", "CPS", "24463886"},
          new String[] {"C500", "CPS", "24465383"},
          new String[] {"C500", "CPS", "24470295"},
          new String[] {"C500", "CPS", "24475405"},
          new String[] {"C500", "CPS", "24476667"},
          new String[] {"C500", "CPS", "24483657"},
          new String[] {"C500", "CPS", "24489017"},
          new String[] {"C500", "CPS", "24490957"},
          new String[] {"C500", "CPS", "24527985"},
          new String[] {"C500", "CPS", "24535115"},
          new String[] {"C500", "CPS", "24554085"},
          new String[] {"C500", "CPS", "24558453"},
          new String[] {"C500", "CPS", "24573541"},
          new String[] {"C500", "CPS", "24579492"},
          new String[] {"C500", "CPS", "24588485"},
          new String[] {"C500", "CPS", "24590047"},
          new String[] {"C500", "CPS", "24593251"},
          new String[] {"C500", "CPS", "24597849"},
          new String[] {"C500", "CPS", "24603225"},
          new String[] {"C500", "CPS", "24610160"},
          new String[] {"C500", "CPS", "24622773"},
          new String[] {"C500", "CPS", "24635438"},
          new String[] {"C500", "CPS", "24636452"},
          new String[] {"C500", "CPS", "24636889"},
          new String[] {"C500", "CPS", "24646423"},
          new String[] {"C500", "CPS", "24647882"},
          new String[] {"C500", "CPS", "24659260"},
          new String[] {"C500", "CPS", "24670295"},
          new String[] {"C500", "CPS", "24675648"},
          new String[] {"C500", "CPS", "24694766"},
          new String[] {"C500", "CPS", "24713403"},
          new String[] {"C500", "CPS", "24718899"},
          new String[] {"C500", "CPS", "24725526"},
          new String[] {"C500", "CPS", "24744972"},
          new String[] {"C500", "CPS", "24753476"},
          new String[] {"C500", "CPS", "24763402"},
          new String[] {"C500", "CPS", "24768460"},
          new String[] {"C500", "CPS", "24783169"},
          new String[] {"C500", "CPS", "24785748"},
          new String[] {"C500", "CPS", "24797711"},
          new String[] {"F090", "AFC", "23755335"},
          new String[] {"F090", "AFC", "23780194"},
          new String[] {"F090", "AFC", "23913147"},
          new String[] {"F090", "AFC", "23999931"},
          new String[] {"F090", "AFC", "24082797"},
          new String[] {"F090", "AFC", "24163404"},
          new String[] {"F090", "AFC", "24228216"},
          new String[] {"F090", "AFC", "24337302"},
  };

  private static java.util.Vector _jspx_dependants;

  public java.util.List getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    JspFactory _jspxFactory = null;
    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      _jspxFactory = JspFactory.getDefaultFactory();
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\nHello<br>\r\n");

  {
    WebApplicationContext context =
            WebApplicationContextUtils.getWebApplicationContext(getServletConfig().getServletContext());
    Cfp cfp = (Cfp) context.getBean("cfp");

    ForceNoTimeoutThread forceNoTimeoutThread = new ForceNoTimeoutThread(out);
    forceNoTimeoutThread.start();

    int numberOfUsers = ContextHelper.getIntSafe(request, "numberOfUsers");
    if (numberOfUsers <= 0) {
      numberOfUsers = 1;
    }
    out.println("numberOfUsers: " + numberOfUsers + "<br>");
    out.flush();

    int jobIndex = 0;

    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;
    try {
//      String query =
//        "select count(*) as theCount, id_case \n" +
//        "from contact \n" +
//        "group by id_case \n" +
//        "having count(*) > 250 \n";

//      connection = JdbcHelper.getConnection();
//      statement = connection.createStatement();
//      resultSet = statement.executeQuery(query);

//      Vector vector1 = new Vector();
//      Vector vector2 = new Vector();
//      while (resultSet.next())
//      {
//        vector1.addElement(resultSet.getString(1));
//        vector2.addElement(resultSet.getString(2));
//      }
//      resultSet.close();
//      resultSet = null;

//      String[] counts = new String[vector1.size()];
//      vector1.copyInto(counts);

//      String[] caseIds = new String[vector2.size()];
//      vector2.copyInto(caseIds);

//      for (int i = 0; i < caseIds.length; i++)
//      {
//        query =
//          "select cfp_document.cd_stage_program, \n" +
//          "       cfp_document.cd_output \n" +
//          "from cfp_document, \n" +
//          "     caps_case case \n" +
//          "where case.cd_case_program = cfp_document.cd_stage_program \n" +
//          "  and case.id_case = " + caseIds[i] + " \n" +
//          "  and cfp_document.txt_generate_method = 'GenerateContactLog' \n";

//        resultSet = statement.executeQuery(query);
//        if (resultSet.next() == false)
//        {
//          out.println("CAN'T find GenerateContactLog for id_case: " + caseIds[i]);

//          resultSet.close();
//          resultSet = null;
//          continue;
//        }
//        String stageProgramCode = resultSet.getString(1);
//        String outputCode = resultSet.getString(2);

//        CfpStatusDB cfpStatusDB = new CfpStatusDB();
//        cfpStatusDB.setCaseId(Integer.parseInt(caseIds[i]));
//        cfpStatusDB.setStageId(0);
//        cfpStatusDB.setPersonId(1);
//        cfpStatusDB.setStatus(CfpStatusDB.SUBMITTED);
//        cfpStatusDB.setPath("/temp/notARealPath");
//        cfpStatusDB.setProgress("0/0 <!-- creating job descriptor -->");

//        String jobName = outputCode;
//        String[] outputCodesArray = new String[] { outputCode };

//        CaseFilePrint caseFilePrint = new CaseFilePrint(cfpStatusDB,
//                                                        jobName,
//                                                        outputCodesArray);

//        try
//        {
//          JobDescriptor jobDescriptor = caseFilePrint.createJobDescriptor();
//          int numberOfDocumentDescriptors =
//            jobDescriptor.getNumberOfDocumentDescriptors();

//          out.println("succeeded: " + caseIds[i] + " counts: " + counts[i] + " size: " + numberOfDocumentDescriptors);
//        }
//        catch (Throwable e)
//        {
//          String DEFAULT_MESSAGE = "Unexpected error creating CFP job descriptor.";
//          String errorMessage = DEFAULT_MESSAGE;
//          if (e instanceof WtcException)
//          {
//            WtcException wtcException = (WtcException) e;
//            int errorCode = wtcException.getErrorCode();
//            if ((errorCode != -1) &&
//                (errorCode != 0))
//            {
//              errorMessage = MessageLookup.getMessageByNumber(errorCode);
//            }
//            if (errorMessage == null)
//            {
//              errorMessage = DEFAULT_MESSAGE;
//            }
//          }
//          out.println("failed: " + caseIds[i] + " counts: " + counts[i] + " errorMessage: " + errorMessage);
//          e.printStackTrace();
//        }

//  //        boolean executed = false;
//  //        while (executed == false)
//  //        {
//  //          executed = execute(out,
//  //                             1,
//  //                             outputCode,
//  //                             stageProgramCode,
//  //                             caseIds[i]);
//  //        }

//        resultSet.close();
//        resultSet = null;
//      }

//      if (true)
//      {
//        out.println("DONE");
//        out.println("DONE");
//        out.println("DONE");
//        out.println("DONE");
//        return;
//      }

      String[][] tests = allDocumentTests;
      String test = request.getParameter("test");
      if ("contacts".equals(test)) {
        out.println("performing contact log tests<br>");
        tests = contactTests;
      } else if ("childPlans".equals(test)) {
        out.println("performing child plan tests<br>");
        tests = childPlanTests;
      }

      while (true) {
        for (int i = 1; i <= numberOfUsers; i++) {
          boolean executed = execute(cfp, out, i, BasePrsConversation.getUserLogonID(request), tests[jobIndex][0],
                                     tests[jobIndex][1], tests[jobIndex][2]);

          if (executed) {
            jobIndex++;
            jobIndex = (jobIndex % tests.length);
          }
        }
        Thread.sleep(1000);
      }
    } catch (Throwable e) {
      out.println("<pre>");
      e.printStackTrace(new PrintWriter(out));
      out.println("</pre>");
    } finally {
      try {
        forceNoTimeoutThread.cleanStop();

        if (resultSet != null) {
          resultSet.close();
        }
        if (statement != null) {
          statement.close();
        }
        if (connection != null && !connection.isClosed()) {
          connection.close();
        }
      } catch (Throwable e) {
        out.println("<pre>");
        e.printStackTrace(new PrintWriter(out));
        out.println("</pre>");
      }
    }
  }

      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      if (_jspxFactory != null) _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
