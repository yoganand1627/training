<%
//*  JSP Name:     Determination Factor Questions
//*  Created by:   Vishala Devarakonda
//*  Date Created: 06/08/2008
//*
//*  Description:
//*  This JSP will be used to display Determination Factor questions
//*
//** Change History:
//**  Date      User              Description
//**  --------  ----------------  --------------------------------------------------
//**  
//**                              
%>

<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.URLHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodeAttributes" %>
<%@ page import="java.util.Iterator"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.LookupException"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup"%>

<html>
<head>
  <title>Determination Factor Questions</title>
</head>

<body bgcolor="#FFFFFF" text="#000000">

<%
  String hdnDetFaqType = request.getParameter("hdnDetFaqType");
  hdnDetFaqType = URLHelper.decode(hdnDetFaqType);
  String codeType = "";
  if(CodesTables.CABALTYP_PP.equals(hdnDetFaqType)){
    codeType = CodesTables.CPDETFAQ;
  }else if(CodesTables.CABALTYP_NN.equals(hdnDetFaqType)){
    codeType = CodesTables.CNDETFAQ;
  }else if(CodesTables.CABALTYP_EE.equals(hdnDetFaqType)){
    codeType = CodesTables.CEDETFAQ;
  }else if(CodesTables.CABALTYP_SS.equals(hdnDetFaqType)){
    codeType = CodesTables.CSDETFAQ;
  }
  if(!"".equals(codeType)){
       Iterator<CodeAttributes> codeAttributes = (Iterator<CodeAttributes>)Lookup.getCategoryListing(codeType);
            if(codeAttributes!=null){
            int loopCount = 1;
              while(codeAttributes.hasNext()){
                CodeAttributes codeAttr = codeAttributes.next();
                String decode = codeAttr.getDecode();
                  out.write(loopCount + "." + decode);
                  out.write("<br>");
                  loopCount++;
              }
            }
  }

%>

</body>

</html>
