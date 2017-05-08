package gov.georgia.dhr.dfcs.sacwis.launcher.udr;

import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;

import java.util.HashMap;
import java.util.Map;

public class UDRConstants {
	public static final int EXCEL_MAX_FILE_SIZE = 65000;

	// This is catch all blank row. It should have all fields from each UDR
	// query in here.
	public static final Map<String, Object> DEFAULT_BLANK_ROW = new HashMap<String, Object>();
	static {
		DEFAULT_BLANK_ROW.put("REGION", StringHelper.EMPTY_STRING);
		DEFAULT_BLANK_ROW.put("COUNTY", StringHelper.EMPTY_STRING);
		DEFAULT_BLANK_ROW.put("SUPERVISOR", StringHelper.EMPTY_STRING);
		DEFAULT_BLANK_ROW.put("CASEMANAGER", StringHelper.EMPTY_STRING);
		DEFAULT_BLANK_ROW.put("UNIT", StringHelper.EMPTY_STRING);
		DEFAULT_BLANK_ROW.put("CASEID", StringHelper.EMPTY_STRING);
		DEFAULT_BLANK_ROW.put("STAGEID", StringHelper.EMPTY_STRING);
		DEFAULT_BLANK_ROW.put("STAGETYPE", StringHelper.EMPTY_STRING);
		DEFAULT_BLANK_ROW.put("STAGENAME", StringHelper.EMPTY_STRING);
		DEFAULT_BLANK_ROW.put("DESCRIPTION", StringHelper.EMPTY_STRING);
		DEFAULT_BLANK_ROW.put("EVENTID", StringHelper.EMPTY_STRING);
		DEFAULT_BLANK_ROW.put("PERSONID", StringHelper.EMPTY_STRING);
		DEFAULT_BLANK_ROW.put("PERSONID2", StringHelper.EMPTY_STRING);
		DEFAULT_BLANK_ROW.put("PERSONNAME", StringHelper.EMPTY_STRING);
		DEFAULT_BLANK_ROW.put("PERSONNAME2", StringHelper.EMPTY_STRING);
		DEFAULT_BLANK_ROW.put("CHILDNAME", StringHelper.EMPTY_STRING);
		DEFAULT_BLANK_ROW.put("SELECTEDELIGIBILITY", StringHelper.EMPTY_STRING);
		DEFAULT_BLANK_ROW.put("DAYSINCARE", StringHelper.EMPTY_STRING);
		DEFAULT_BLANK_ROW.put("PLACEMENTTYPE", StringHelper.EMPTY_STRING);
		DEFAULT_BLANK_ROW.put("PLACEMENTSTART", StringHelper.EMPTY_STRING);
		DEFAULT_BLANK_ROW.put("PLACEMENTEND", StringHelper.EMPTY_STRING);
		DEFAULT_BLANK_ROW.put("POCTYPE", StringHelper.EMPTY_STRING);
		DEFAULT_BLANK_ROW.put("POCSTART", StringHelper.EMPTY_STRING);
		DEFAULT_BLANK_ROW.put("POCEND", StringHelper.EMPTY_STRING);
		DEFAULT_BLANK_ROW.put("POCSTATUS", StringHelper.EMPTY_STRING);
		
	}

	public static final String DEFAULT_BLANK_ROW_SQL = " SELECT '' as REGION, "
			+ " '' as COUNTY, " + " '' as CASEMANAGER, " + " '' as UNIT, "
			+ " '' as SUPERVISOR, " + " '' as STAGEID, " + " '' as CASEID, "
			+ " '' as STAGETYPE, " + " '' as STAGENAME, "
			+ " '' as DESCRIPTION, " + " '' as EVENTID, " + " '' as PERSONID, "
			+ " '' as PERSONID2, "  + " '' as PERSONNAME, " 
			+ " '' as PERSONNAME2, " + " '' as CHILDNAME, "
			+ " '' as SELECTEDELIGIBILITY, " + " '' as DAYSINCARE, "
			+ " '' as PLACEMENTTYPE, " + " '' as PLACEMENTSTART, "
			+ " '' as PLACEMENTEND, " + " '' as POCTYPE " + " '' as POCSTART, "
			+ " '' as POCEND " + " '' as POCSTATUS " + " FROM dual ";

}
