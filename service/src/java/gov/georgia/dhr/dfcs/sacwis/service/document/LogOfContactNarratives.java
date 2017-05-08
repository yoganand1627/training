package gov.georgia.dhr.dfcs.sacwis.service.document;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CSVC06SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSVC06SO;

/**
 * The LogOfContactNarrativesImpl Interface is the service interface for generating the 'Log of Contact Narratives'
 * Form.
 * 
 * @see gov.georgia.dhr.dfcs.sacwis.service.document.DocumentService
 * @see gov.georgia.dhr.dfcs.sacwis.service.document.impl.LogOfContactNarrativesImpl
 * 
 * 
 * @author Stephen Roberts, Septemeber 23, 2007
 * 
 * <PRE>
 * 
 * <U>Updated by:</U> <U>Description:</U> Update description
 * 
 * </PRE>
 */
public interface LogOfContactNarratives extends DocumentService {

  // Blob data table names
  public static final String CONTACT_NARRATIVE = "CONTACT_NARRATIVE";
  
  public static final String SAFETY_RSRC_ASMNT_NARR = "SAFETY_RSRC_ASMNT_NARR";

  public static final String CONTACT_VISITATION_NARRATIVE = "CONTACT_VISITATION_NARRATIVE";
  
  // Form Group Bookmark Names
  public static final String TMPLAT_CONTACT = "TMPLAT_CONTACT";

  public static final String TMPLAT_CONTACT_NAME = "TMPLAT_CONTACT_NAME";

  public static final String TMPLAT_ATTEMPTED = "TMPLAT_ATTEMPTED";
  
  public static final String TMPLAT_PURPOSE = "TMPLAT_PURPOSE";
  
  public static final String TMPLAT_PRIVATE_CONVERSATION = "TMPLAT_PRIVATE_CONVERSATION";
  
  public static final String TMPLAT_TCM = "TMPLAT_TCM";
  
  public static final String TMPLAT_TCM_SERVICES = "TMPLAT_TCM_SERVICES";
  
  public static final String TMPLAT_TCM_PROGRAMS = "TMPLAT_TCM_PROGRAMS";
  
  public static final String TMPLAT_DISCUSSED_PERSON_NAME = "TMPLAT_DISCUSSED_PERSON_NAME";

  // Bookmark names
  public static final String TITLE_LOG = "TITLE_LOG";

  public static final String CONTACT_DATE_FROM = "CONTACT_DATE_FROM";

  public static final String CONTACT_DATE_TO = "CONTACT_DATE_TO";

  public static final String CONTACT_ID = "CONTACT_ID";

  public static final String CONTACTED_BY_FIRST = "CONTACTED_BY_FIRST";

  public static final String CONTACTED_BY_MIDDLE = "CONTACTED_BY_MIDDLE";

  public static final String CONTACTED_BY_LAST = "CONTACTED_BY_LAST";

  public static final String CONTACT_METHOD = "CONTACT_METHOD";
  
  public static final String CONTACT_NAME_FIRST = "CONTACT_NAME_FIRST";

  public static final String CONTACT_NAME_MIDDLE = "CONTACT_NAME_MIDDLE";

  public static final String CONTACT_NAME_LAST = "CONTACT_NAME_LAST";  
  
  public static final String CONTACT_NAME_SUFFIX = "CONTACT_NAME_SUFFIX";

  public static final String CONTACT_OTHERS = "CONTACT_OTHERS";
  
  public static final String CONTACT_TYPE = "CONTACT_TYPE";

  public static final String CONTACT_LOCATION = "CONTACT_LOCATION";

  public static final String CONTACT_DATE_OCCURRED = "CONTACT_DATE_OCCURRED";

  public static final String CONTACT_PURPOSE = "CONTACT_PURPOSE";
  
  public static final String NAME_OF_AGENCY = "NAME_OF_AGENCY";
  
  public static final String PERM_COUNTY_LINES = "PERM_COUNTY_LINES";
  
  public static final String TCM_SERVICE = "TCM_SERVICE";
  
  public static final String TCM_PROGRAM = "TCM_PROGRAM";
  
  public static final String TCM_BILLABLE = "TCM_BILLABLE";
  
  public static final String TCM_ELIGIBLE = "TCM_ELIGIBLE";
  
  public static final String TCM_GUARANTOUR = "TCM_GUARANTOUR";
  
  public static final String DISCUSSED_PERSON_NAME_FIRST = "DISCUSSED_PERSON_NAME_FIRST";

  public static final String DISCUSSED_PERSON_NAME_MIDDLE = "DISCUSSED_PERSON_NAME_MIDDLE";

  public static final String DISCUSSED_PERSON_NAME_LAST = "DISCUSSED_PERSON_NAME_LAST";  
  
  public static final String DISCUSSED_PERSON_NAME_SUFFIX = "DISCUSSED_PERSON_NAME_SUFFIX";
  
  

  /**
   * The retrieveLogOfContactNarratives method is the main entry point for the service.
   * 
   * @param CSVC06SI
   *          Input object which should contain the Stage ID and Dates.
   * @return CSVC06SO Output object which contains prefill data
   */
  public CSVC06SO retrieveLogOfContactNarratives(CSVC06SI csvc06si);
}
