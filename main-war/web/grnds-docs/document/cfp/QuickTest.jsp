<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.BasePrsConversation" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.document.cfp.CfpConversation" %>
Jobs that currently are failing:<br>
<%
  try {
    String baseUrl = CfpConversation.CONVERSATION_URL + "QuickTestSubmit";
    for (int i = 0; i < tests.length; i++) {
      String outputCode = tests[i][0];
      String program = tests[i][1];
      String caseId = tests[i][2];

      Map<String, String> hashtable = new HashMap<String, String>();
      hashtable.put("outputCode", outputCode);
      hashtable.put("program", program);
      hashtable.put("caseId", caseId);
      String url = BasePrsConversation.getUrl(baseUrl, hashtable);
      out.println("<a href=\"" + url + "\">" + outputCode + ", " + program + ", " + caseId + "</a><br>");
      if ((i % 5) == 4) {
        out.println("<br>");
      }
    }
  }
  catch (Throwable e) {
    out.println("<pre>");
    e.printStackTrace(new PrintWriter(out));
    out.println("</pre>");
  }
%>
<%!
  protected static String[][] tests = new String[][] {
          //large Log of Contact Narratives
          new String[] {"C500", "CPS", "16015156"},

          //Processing stopped on document [Structured Narrative]
//  System.Data.OracleClient.OracleException: OCI-22060: argument [2] is an invalid or uninitialized number
//     at System.Data.OracleClient.OracleException.Check(OciHandle errorHandle, Int32 rc)
//     at System.Data.OracleClient.OracleNumber.ToInt32(OciHandle errorHandle, Byte[] value)
//     at System.Data.OracleClient.OracleNumber.MarshalToInt32(NativeBuffer buffer,Int32 valueOffset, OracleConnection connection)
//     at System.Data.OracleClient.OracleColumn.GetInt32(NativeBuffer buffer)
//     at System.Data.OracleClient.OracleDataReader.GetInt32(Int32 i)
//     at PRS.Documents.DataAccessor.GetNarrative(String documentMetadata)</string><
new String[] {"C090", "CPS", "23511850"},
new String[] {"C090", "CPS", "23593823"},
new String[] {"C090", "CPS", "23592754"},
new String[] {"C090", "CPS", "23675085"},
new String[] {"C090", "CPS", "23539851"},
new String[] {"C090", "CPS", "23719631"},
new String[] {"C090", "CPS", "23725603"},
new String[] {"C090", "CPS", "23725218"},
new String[] {"C090", "CPS", "23736026"},

new String[] {"C090", "CPS", "23805341"},
new String[] {"C090", "CPS", "24527040"},
new String[] {"C090", "CPS", "23805075"},
new String[] {"C090", "CPS", "23805501"},

new String[] {"C090", "CPS", "6000187"},
new String[] {"C090", "CPS", "6000194"},
new String[] {"C090", "CPS", "6000207"},
new String[] {"C090", "CPS", "6000219"},
new String[] {"C090", "CPS", "6000226"},

new String[] {"F060", "AFC", "5000001"},
new String[] {"F060", "AFC", "5000002"},

new String[] {"F060", "AFC", "5004554"},
new String[] {"F060", "AFC", "23218782"},
new String[] {"F060", "AFC", "23237304"},

new String[] {"F060", "AFC", "23486313"},
new String[] {"F060", "AFC", "23218782"},
new String[] {"F060", "AFC", "23237304"},
new String[] {"F060", "AFC", "23298694"},
new String[] {"F060", "AFC", "23415820"},
new String[] {"F060", "AFC", "23459316"},
new String[] {"F060", "AFC", "23479981"},
new String[] {"F060", "AFC", "23486313"},
new String[] {"F060", "AFC", "23530128"},
new String[] {"F060", "AFC", "23530142"},
new String[] {"F060", "AFC", "23639318"},
new String[] {"F060", "AFC", "23664449"},
new String[] {"F060", "AFC", "23665968"},
new String[] {"F060", "AFC", "23701068"},
new String[] {"F060", "AFC", "23708162"},
new String[] {"F060", "AFC", "23715267"},
new String[] {"F060", "AFC", "23723072"},
new String[] {"F060", "AFC", "5004554"},
new String[] {"F060", "AFC", "23731452"},
new String[] {"F060", "AFC", "23795505"},
new String[] {"F060", "AFC", "23829127"},
new String[] {"F060", "AFC", "23855459"},
new String[] {"F060", "AFC", "23859752"},
new String[] {"F060", "AFC", "23921378"},
new String[] {"F060", "AFC", "23997613"},
new String[] {"F060", "AFC", "24017128"},
new String[] {"F060", "AFC", "24158920"},
new String[] {"F060", "AFC", "24206773"},
new String[] {"F060", "AFC", "24299463"},
new String[] {"F060", "AFC", "24629888"},

//seems to trigger LegacyProcessor's multithreaded issue
new String[] {"F160", "AFC", "23128931"},//failed; access is denied
  };
%>
