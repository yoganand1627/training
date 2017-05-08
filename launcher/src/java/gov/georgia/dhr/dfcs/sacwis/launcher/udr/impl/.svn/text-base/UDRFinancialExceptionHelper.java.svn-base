package gov.georgia.dhr.dfcs.sacwis.launcher.udr.impl;

import gov.georgia.dhr.dfcs.sacwis.launcher.udr.UDRBaseObject;
import gov.georgia.dhr.dfcs.sacwis.launcher.udr.UDRConstants;

import java.util.HashMap;
import java.util.Map;

public class UDRFinancialExceptionHelper implements UDRBaseObject {

	private static final String COUNT_SQL_1 = " select count(*) as ROWCOUNT from ( ";

	private static final String COUNT_SQL_2 = " ) ";


	public Map<String, String> getSqlRefMapList() {
		Map<String, String> sqlRefMap = new HashMap<String, String>(UDRFinancialExceptionSqls.sqlRefMap);
		return sqlRefMap;
	}

	public Map<String, Object> buildParamMap(String[] params) {
		// TODO Auto-generated method stub
		return null; // job handles null params
	}

	public String buildSQLQuery(String[] params) {
		return UDRConstants.DEFAULT_BLANK_ROW_SQL; // fail-safe; the report does not use this method
	}

	public String buildSQLQuery(Map<String, Object> params) {
		return UDRConstants.DEFAULT_BLANK_ROW_SQL; // fail-safe; the report does not use this method
	}

	public String queryForRowCount(String[] params) {
		return UDRConstants.DEFAULT_BLANK_ROW_SQL; // fail-safe; the report does not use this method
	}

	public String buildSQLQueryMultiple(String[] params, String sqlName) {
		String sql = getSqlRefMapList().get(sqlName);
		return sql == null? UDRConstants.DEFAULT_BLANK_ROW_SQL : sql; 
	}


	public String queryForRowCountMultiple(String[] params, String sql) {
		return COUNT_SQL_1 + buildSQLQueryMultiple(params, sql) + COUNT_SQL_2;
	}



}
