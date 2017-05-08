/**
 * Created on Aug 8, 2006 at 10:47:36 AM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.service.document;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CONTACTVISITLOGSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CONTACTVISITLOGSO;

public interface ContactVisitationsLog extends DocumentService {
  
  public static final String CD_EVENT_TYPE = "CON"; // cd_event_type for visitation is PVC = Parent/Child Visit
  // Miscellaneous
  public static final String PARENTCHILDVISITCONTACTTYPE = "PVC";
  

  public static final String CONTACT_NARRATIVE = "CONTACT_NARRATIVE";

  // Group Names
  public static final String CFCD0700V = "CFCD0700V";
  public static final String CFCD0700V2 = "CFCD0700V2";
  
  // Form Group Bookmark Names
  public static final String TMPLAT_CONTACT = "TMPLAT_CONTACT";
  public static final String TMPLAT_CONTACT_NAME = "TMPLAT_CONTACT_NAME";
  public static final String TMPLAT_ATTEMPTED = "TMPLAT_ATTEMPTED";
  
  // Bookmark names
  public static final String DT_CNTCT_MNTHLY_SUMM_BEG = "DT_CNTCT_MNTHLY_SUMM_BEG";
  public static final String DT_CNTCT_MNTHLY_SUMM_END = "DT_CNTCT_MNTHLY_SUMM_END";
  public static final String ID_CONTACT = "ID_CONTACT";
  public static final String CONTACT_NAME_FIRST = "CONTACT_NAME_FIRST";
  public static final String CONTACT_NAME_MIDDLE = "CONTACT_NAME_MIDDLE";
  public static final String CONTACT_NAME_LAST = "CONTACT_NAME_LAST";
  public static final String CONTACT_NAME_SUFFIX = "CONTACT_NAME_SUFFIX";
  public static final String DT_CONTACT_OCCURRED = "DT_CONTACT_OCCURRED";
  public static final String CD_CONTACT_TYPE = "CD_CONTACT_TYPE";
  public static final String CD_CONTACT_LOCATION = "CD_CONTACT_LOCATION";
  public static final String CONTACT_NARR_BLOB = "CONTACT_NARR";
  public static final String CONTACT_CONTACT_ID = "CONTACT_CONTACT_ID";
  public static final String CONTACT_TYPE = "CONTACT_TYPE";
  public static final String CONTACT_LOCATION = "CONTACT_LOCATION";
  public static final String CONTACT_DATE_OCCURRED = "CONTACT_DATE_OCCURRED";
  public static final String TEAM_MEET_REVIEW_NARRATIVE_VIEW = "TEAM_MEET_REVIEW_NARRATIVE";

  public CONTACTVISITLOGSO retrieveContactVisitationsLog(CONTACTVISITLOGSI contactVisitLogsi);
}
