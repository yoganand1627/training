package gov.georgia.dhr.dfcs.sacwis.service.document;

import gov.georgia.dhr.dfcs.sacwis.structs.input.MANDATEDREPTLETTERFORMSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.MANDATEDREPTLETTERFORMSO;

public interface MandatedReptLetterForm extends DocumentService {

  public MANDATEDREPTLETTERFORMSO retrieveMandatedReptLetterForm(MANDATEDREPTLETTERFORMSI mandatedReptLetterFormSI);
  public static final String REP_SYSTEM_DATE = "REP_SYSTEM_DATE";
  public static final String RPT_LETTER = "RPT_LETTER";
  public static final String NM_INCOMING_CALLER_FIRST = "NM_INCOMING_CALLER_FIRST";
  public static final String NM_INCOMING_CALLER_MIDDLE = "NM_INCOMING_CALLER_MIDDLE";
  public static final String NM_INCOMING_CALLER_LAST = "NM_INCOMING_CALLER_LAST";
  public static final String ADDR_INCMG_STREET_LN_1 = "ADDR_INCMG_STREET_LN_1";
  public static final String ADDR_INCMG_STREET_LN_2 = "ADDR_INCMG_STREET_LN_2";
  public static final String ADDR_INCOMING_CALLER_CITY = "ADDR_INCOMING_CALLER_CITY";
  public static final String ADDR_INCMG_ZIP = "ADDR_INCMG_ZIP";
  public static final String ADDR_INCOMING_CALLER_STATE = "ADDR_INCOMING_CALLER_STATE";
  public static final String DT_INCOMING_CALL = "DT_INCOMING_CALL";
  public static final String CD_STAGE_REASON_CLOSED = "CD_STAGE_REASON_CLOSED";
  public static final String CD_STAGE_CURR_PRIORITY = "CD_STAGE_CURR_PRIORITY";
  public static final String ADDR_MAIL_CODE_COUNTY = "ADDR_MAIL_CODE_COUNTY";
  public static final String SUB_LETTER = "SUB_LETTER";
  
  public static final String CD_STAGE_REASON_CLOSED_DISP_INV = "Assigned for Investigation";
  public static final String CD_STAGE_REASON_CLOSED_DISP_NO_INV = "Not Assigned for Investigation";
  public static final String CD_STAGE_REASON_CLOSED_DISP_DIV = "Diversion";
  public static final String CD_STAGE_REASON_CLOSED_DISP_SCO = "Screened Out ";
  public static final String CD_STAGE_REASON_CLOSED_DISP_SCR = "Screen Out and Referred";
  public static final String SUB_LETTER_INV = "Assigned for Investigation: An intake assigned for investigation indicates the intake report " + 
                                              "contained an allegation that maltreatment has occurred and/or the potential for further maltreatment " + 
                                              "to the child is present. The investigator will gather sufficient evidence to determine" +
  		                              " the validity of the allegations. Based on findings, the case will be substantiated or unsubstantiated " +
  		                              "for maltreatment.";
  public static final String SUB_LETTER_DIV = "Assigned for Diversion:  An intake assigned to diversion indicates the intake report did not contain an allegation of "+
                                              "maltreatment but there is potential risk of maltreatment to the child " +
                                              "or "	+
                                              "the intake report contained an allegation of maltreatment but the potential risk of future maltreatment to the child is low"+
                                              ". The assessor will engage all principals and children to assist the family in identifying service needs to reduce risk.";
  public static final String SUB_LETTER_SCO = "Screened Out: An intake that is screened out indicates that the report contained no allegation of "+
                                              "maltreatment nor indication of risk of maltreatment.";
  
  public static final String SUB_LETTER_SCR = "Screen Out and Referred: An intake that is screened out indicates that the report contained no allegation of maltreatment"+
                                              " nor indication of risk of maltreatment.";
  public static final String RESPONSE_SCO = "None";
  public static final String RESPONSE_SCR = "Preventative referral to community service made. ";

}
