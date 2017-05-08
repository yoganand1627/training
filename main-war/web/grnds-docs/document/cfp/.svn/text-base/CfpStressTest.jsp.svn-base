<%@ page import="java.io.IOException" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.rmi.RemoteException" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Random" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.dao.document.cfp.DocumentTypeDB" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.dao.document.cfp.ExceedQueueLimitException" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.dao.document.cfp.ICaseFilePrint" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.dao.document.cfp.StageDB" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.service.document.Cfp" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.document.cfp.CaseFilePrint" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.document.cfp.CfpConversation" %>
<%@ page import="org.springframework.web.context.WebApplicationContext" %>
<%@ page import="org.springframework.web.context.support.WebApplicationContextUtils" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.BasePrsConversation" %>
Hello<br>
<%
  {
//    if (true)
//    {
//      out.println("not now");
//      return;
//    }
    int[] userIds = new int[] {
            3, // WHIPPLWS
            4, // MULLINR
            14, // COFFEYC
            23, // ADAMSCC
            37, // BUENOMM
            54, // DAHLKL
            63, // LEUCHTP
            64, // DORSETLL
            67, // CHINHMT
            86, // QUIGLEM
            92, // THESINCH
            97, // BRYARSEA
            98, // KLEINM
            107, // CUSSONVB
            109, // LOVELLT
            112, // WARETE
            114, // MARTINTA
            118, // WISEMC
            120, // MANDRAD
            122, // BJORKK
            139, // TEUTSCKS
            143, // KEYSLC
            147, // STEINBRU
            150, // FINCHE
            157, // FIREMAS
            188, // TOMLINW1
            203, // ADABASI
            205 // GIVENSM
    };

    int[][] jobs = new int[][] {
            new int[] {24401368, 0}, //large
            new int[] {16101941, 0}, //large
            new int[] {23133019, 0},
            new int[] {23133000, 0},
            new int[] {23132970, 0},
            new int[] {23127091, 0},
            new int[] {23133141, 0},
            new int[] {1000021, 0},
            new int[] {1000001, 0},
            new int[] {23134317, 0},
            new int[] {20064615, 23398497},
            new int[] {20064615, 23398511},
            new int[] {23141007, 23423198},
            new int[] {3001454, 3007040},
            new int[] {1000022, 1000023},
            new int[] {1000001, 1000002},
            new int[] {23090281, 23398513},
            new int[] {23089888, 23398544},
            new int[] {23132986, 23398349},
            new int[] {23132981, 23398442},
            new int[] {23126822, 23398480},
            new int[] {23132680, 23398484},
            new int[] {23133874, 23400607},
            new int[] {23133883, 23400637},
            new int[] {16122488, 23399168},
            new int[] {24288678, 23402657},
            new int[] {23129718, 23398493},
            new int[] {23739724, 23398844}
    };

    int numberOfUsers = ContextHelper.getIntSafe(request, "numberOfUsers");
    if (numberOfUsers <= 0) {
      numberOfUsers = 1;
    }
    if (numberOfUsers > userIds.length) {
      numberOfUsers = userIds.length;
    }
    out.println("numberOfUsers: " + numberOfUsers + "<br>");
    out.flush();

    int jobIndex = 0;

    WebApplicationContext context =
            WebApplicationContextUtils.getWebApplicationContext(getServletConfig().getServletContext());
    Cfp cfp = (Cfp) context.getBean("cfp");
    try {
      while (true) {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
          execute(cfp, out, i, BasePrsConversation.getUserLogonID(request), jobs[2][0], jobs[2][1]);
          Thread.sleep(15 * 1000);
        }

        if (true) {
          continue;
        }

        for (int i = 0; i < numberOfUsers; i++) {
//          boolean executed = execute(out, userIds[i], jobs[jobIndex][0], jobs[jobIndex][1]);

          boolean executed = execute(cfp, out, userIds[i], BasePrsConversation.getUserLogonID(request), jobs[2][0], jobs[2][1]);
          if (executed) {
            jobIndex++;
            jobIndex = (jobIndex % jobs.length);
          }
        }
        Thread.sleep(1000);
      }
    }
    catch (Throwable e) {
      out.println("<pre>");
      //noinspection IOResourceOpenedButNotSafelyClosed
      e.printStackTrace(new PrintWriter(out));
      out.println("</pre>");
    }
  }
%>
<%!
  protected static Random random = new Random();

  public static boolean execute(Cfp cfp, JspWriter out, int userId, String userLogin, int caseId, int stageId)
          throws IOException, ExceedQueueLimitException {
    List vector = cfp.getQueuedCfpStatusForUser(userId);
    if (vector.size() >= ICaseFilePrint.QUEUE_LIMIT) {
      return false;
    }
    out.println(new Date() + ": creating cfp job for {userId, caseId, stageId} = " +
                "{" + userId + ", " + caseId + ", " + stageId + "}<br>");
    out.flush();
    test(cfp, userId, userLogin, caseId, stageId);

    return true;
  }

  public static void test(Cfp cfp, int userId, String userLogin, int caseId, int stageId)
          throws RemoteException, ExceedQueueLimitException {
    long number = random.nextLong();
    String shortFileName = Long.toString(number, 36);

    String destinationFileName =
            CfpConversation.CFP_BASE_FILE_LOCATION + shortFileName + ".pdf";

    StageDB stageDB = cfp.getStageDB(caseId, stageId);

    String caseName = stageDB.getCaseName();
    String jobName = "Case File Print for " + caseName + " (" + caseId + ")";

    DocumentTypeDB[] documentTypes =
            cfp.getDocumentOrder(stageDB.getProgramName(), stageDB.getStageCode(), stageDB.getStageType());

    List<String> outputCodes = new ArrayList<String>();

    for (int i = 0; i < documentTypes.length; i++) {
      String outputCode = documentTypes[i].getOutputCode();
      //skipping documents
      if ("F050".equals(outputCode) ||
          "F060".equals(outputCode) ||
          "F070".equals(outputCode) ||
          "F170".equals(outputCode)) {
        continue;
      }
      outputCodes.add(outputCode);
    }
    String[] outputCodesArray = new String[outputCodes.size()];
    outputCodesArray = outputCodes.toArray(outputCodesArray);

    CaseFilePrint.submitCfp(cfp, userId, userLogin, jobName, destinationFileName, caseId, stageId, outputCodesArray);
  }
%>
