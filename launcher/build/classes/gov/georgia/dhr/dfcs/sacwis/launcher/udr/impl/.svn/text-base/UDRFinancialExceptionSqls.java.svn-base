package gov.georgia.dhr.dfcs.sacwis.launcher.udr.impl;

import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;

import java.util.HashMap;
import java.util.Map;

public class UDRFinancialExceptionSqls {

	// Reference to the sqls. Sql name (ex. UNAPPROVED_SVC_AUTH_SQL) is
	// referenced in the template. Exact spelling required.
	public static final String NO_PLACEMENT = "NO_PLACEMENT_SQL";
	public static final String PLACEMENT_NOT_APPROVED = "PLACEMENT_NOT_APPROVED_SQL";
	public static final String NO_PAYMENT_OF_CARE = "NO_PAYMENT_OF_CARE_SQL";
	public static final String PAYMENT_OF_CARE_NOT_APPROVED = "PAYMENT_OF_CARE_NOT_APPROVED_SQL";
	public static final String POC_PLC_MISMATCH = "POC_PLC_MISMATCH_SQL";
	public static final String NO_ELIG_APP_SUBMITTED = "NO_ELIG_APP_SUBMITTED_SQL";
	public static final String NO_ELIG_180_DAYS = "NO_ELIG_180_DAYS_SQL";
	public static final String POSS_INVALID_ELIG = "POSS_INVALID_ELIG_SQL";
	public static final String NO_LEGAL_STATUS = "NO_LEGAL_STATUS_SQL";
	public static final String NO_CITIZENSHIP = "NO_CITIZENSHIP_SQL";
	public static final String UNAPPROVED_SVC_AUTH = "UNAPPROVED_SVC_AUTH_SQL";
	public static final String DUPLICATE_PEOPLE = "DUPLICATE_PEOPLE_SQL";
	public static final String MISSING_CRS = "MISSING_CRS_SQL";
	public static final String NO_FAMILY_PLAN = "NO_FAMILY_PLAN_SQL";
	public static final String NO_CHILD_PLAN = "NO_CHILD_PLAN_SQL";

	// reference to population queries
	public static final String TOTAL_FCC_STAGES = "TOTAL_FCC_STAGES_SQL";
	public static final String TOTAL_FCF_STAGES = "TOTAL_FCF_STAGES_SQL";
	public static final String TOTAL_PAID_PLACEMENT = "TOTAL_PAID_PLACEMENT_SQL";
	public static final String TOTAL_ACTIVE_FCC_PFC_STAGES = "TOTAL_ACTIVE_FCC_PFC_STAGES_SQL";
	public static final String TOTAL_ACTIVE_SVC_AUTH = "TOTAL_ACTIVE_SVC_AUTH_SQL";

	// All sqls in the report

	public static final String NO_PLACEMENT_SQL = "select distinct * "
			+ "from (            "
			+ "select "
			+ "rtrim(cr.decode) as Region, "
			+ "rtrim(c.decode) as County, "
			+ "p3.nm_person_full as Supervisor,            "
			+ "p2.nm_person_full as CaseManager, "
			+ "p.nm_person_full as ChildName, "
			+ "w.id_wkld_case as CaseID, "
			+ "w.id_wkld_stage as StageID, "
			+ "decode(w.cd_wkld_stage, 'SUB', 'FCC', w.cd_wkld_stage) as StageType "
			+ "from caps.stage_person_link l, "
			+ "     caps.person p, "
			+ "     caps.workload w, "
			+ "     caps.person p2, "
			+ "     caps.ccount c, "
			+ "     caps.person p3, "
			+ "     caps.unit u, "
			+ "     caps.ccntyreg cr "
			+ "where l.id_person = p.id_person  "
			+ "and w.id_wkld_unit = u.id_unit  "
			+ "and u.id_person = p3.id_person " // join to unit supervisor
			+ "and not exists (select * "
			+ "                from placement "
			+ "                where trunc(placement.DT_PLCMT_END) > sysdate "
			+ " and placement.cd_plcmt_act_planned = 'A' "
			+ " and (placement.CD_TEMP_TYPE IS NULL  OR  placement.CD_TEMP_TYPE  NOT IN ('COR','RED','REN'))"
			+ "                and placement.ID_PLCMT_CHILD = l.id_person "
			+ "                and placement.ID_CASE = l.ID_CASE  "
			+ "               ) "
			+ "and l.cd_stage_pers_role = 'PC'  "
			+ "and l.id_stage = w.id_wkld_stage  "
			+ "and w.cd_wkld_stage in ('SUB', 'PFC')  "
			+ "and w.id_wkld_person = p2.id_person  " // case manager
			+ "and w.cd_wkld_stage_cnty = c.CODE " // use workload county to
													// decode to be consistent
													// with other queries
			+ "and w.cd_wkld_stage_pers_role = 'PR' " 
			+ "and c.code = cr.code) "
			+ "order by 1,2,4,5,6";

	public static final String PLACEMENT_NOT_APPROVED_SQL = "select distinct rtrim(cr.decode)  Region, "
			+ "rtrim(c.decode)  County, "
			+ "p3.nm_person_full  Supervisor, "
			+ "p2.nm_person_full  CaseManager, "
			+ "n.nm_person_full  ChildName, "
			+ "w.id_wkld_case  CaseID, "
			+ "w.id_wkld_stage  StageID, "
			+ "rtrim(plm.decode)  PlacementType, "
			+ "trunc(fvd.dt_plcmt_start)  PlacementStart, "
			+ "trunc(fvd.dt_plcmt_end)  PlacementEnd, "
			+ "fvd.plc_event_status  PlacementStatus "
			+ "from caps.stage_person_link l, caps.ccount c, caps.workload w, caps.person p2, caps.person n, "
			+ "caps.person p3, caps.unit u, caps.cplmntyp plm, caps.fin_valid_dtl fvd, caps.ccntyreg cr "
			+ "where n.id_person = l.id_person "
			+ "and l.cd_stage_pers_role = 'PC' "
			+ "and l.id_stage = w.id_wkld_stage "
			+ "and w.cd_wkld_stage in ('PFC', 'SUB') "
			+ "and w.id_wkld_person = p2.id_person  "
			+ "and w.cd_wkld_stage_pers_role = 'PR' "
			+ "and w.cd_wkld_stage_cnty = c.code   "
			+ "and w.id_wkld_unit = u.id_unit "
			+ "and u.id_person = p3.id_person "
			+ "and fvd.cd_plcmt_type = plm.code            "
			+ "and n.id_person = fvd.id_plcmt_child "
			+ " and fvd.id_plcmt_event_stage = w.id_wkld_stage "
			+ "and fvd.result like '%Placement Not Approved%'            "
			+ "and cr.code = c.code "
			+ "order by 1, rtrim(c.decode), p3.nm_person_full, p2.nm_person_full, n.nm_person_full ";

	public static final String NO_PAYMENT_OF_CARE_SQL = "select distinct "
			+ " rtrim(cr.decode) Region, rtrim(c.decode) County, "
			+ " p3.nm_person_full Supervisor, p2.nm_person_full CaseManager, "
			+ " n.nm_person_full ChildName, "
			+ " w.id_wkld_case CaseID, "
			+ " w.id_wkld_stage StageID, "
			+ " rtrim(plm.decode) PlacementType, trunc(fvd.dt_plcmt_start) PlacementStart "
			+ " from caps.stage_person_link l, "
			+ " caps.ccount c, "
			+ " caps.workload w, "
			+ " caps.person p2, "
			+ " caps.person n, "
			+ " caps.person p3, "
			+ " caps.unit u, "
			+ " caps.cplmntyp plm, "
			+ " caps.fin_valid_dtl fvd, "
			+ " caps.ccntyreg cr "
			+ "where n.id_person = l.id_person "
			+ "and l.cd_stage_pers_role = 'PC' "
			+ "and l.id_stage = w.id_wkld_stage "
			+ "and w.cd_wkld_stage in ('PFC', 'SUB') "
			+ "and w.id_wkld_person = p2.id_person "
			+ "and w.cd_wkld_stage_pers_role = 'PR' "
			+ "and w.CD_wkld_stage_CNTY = c.code "
			+ "and w.ID_WKLD_UNIT = u.id_unit "
			+ "and u.id_person = p3.id_person "
			+ "and fvd.cd_plcmt_type = plm.code "
			+ "and fvd.id_plcmt_event_stage = w.ID_WKLD_stage "
			+ "and n.id_person = fvd.id_plcmt_child "
			+ "and fvd.result like '%No Payment of Care%' "
			+ "and cr.code = c.code "
			+ "order by 1,2, p3.nm_person_full, p2.nm_person_full, n.nm_person_full";

	public static final String PAYMENT_OF_CARE_NOT_APPROVED_SQL = "select distinct "
			+ "rtrim(cr.decode) Region, rtrim(c.decode) County, "
			+ "p3.nm_person_full Supervisor, p2.nm_person_full CaseManager, "
			+ "n.nm_person_full ChildName, "
			+ " w.id_wkld_case CaseID, w.id_wkld_stage StageID, "
			+ " e.cd_event_status PoCStatus "
			+ " from caps.stage_person_link l, caps.ccount c, caps.workload w, caps.person p2, caps.person n, caps.person p3, "
			+ "      caps.unit u, caps.event e, caps.fin_valid_dtl fvd, caps.ccntyreg cr "
			+ "	where n.id_person = l.id_person "
			+ "	and l.cd_stage_pers_role = 'PC' "
			+ "and l.id_stage = w.id_wkld_stage "
			+ "and w.cd_wkld_stage in ('PFC', 'SUB') "
			+ "and w.id_wkld_person = p2.id_person "
			+ "and w.cd_wkld_stage_pers_role = 'PR' "
			+ "and w.cd_wkld_stage_cnty = c.code "
			+ "and w.id_wkld_unit = u.id_unit "
			+ " and e.id_event = fvd.id_poc_event "
			+ " and w.id_wkld_stage = fvd.id_plcmt_event_stage "
			+ "and u.id_person = p3.id_person "
			+ "and n.id_person = fvd.id_plcmt_child "
			+ "and fvd.result like '%Payment of Care Not Approved%' "
			+ "and cr.code = c.code "
			+ "order by 1,rtrim(c.decode), p3.nm_person_full, p2.nm_person_full, n.nm_person_full";

	public static final String POC_PLC_MISMATCH_SQL = "select distinct "
			+ " rtrim(cr.decode) Region, rtrim(c.decode)County, "
			+ "p3.nm_person_full Supervisor, p2.nm_person_full CaseManager, "
			+ "n.nm_person_full ChildName, "
			+ " w.id_wkld_case CaseID, w.id_wkld_stage StageID, "
			+ " rtrim(plm.decode) PlacementType, trunc(fvd.dt_plcmt_start) PlacementStart "
			+ " , trunc(fvd.dt_plcmt_end) PlacementEnd, "
			+ " rtrim(cpt.decode) PoCType, "
			+ " trunc(poc.dt_start) PoCStart, trunc(poc.dt_end) PoCEnd "
			+ "from caps.payment_of_care poc, caps.person n, "
			+ "caps.codes_tables cpt, caps.cplmntyp plm, caps.ccount c, caps.workload w, caps.person p2, "
			+ " caps.person p3, caps.unit u, fin_valid_dtl fvd, "
			+ " caps.stage_person_link spl, caps.ccntyreg cr "
			+ "where w.id_wkld_unit = u.id_unit "
			+ "and u.id_person = p3.id_person "
			+ "and w.cd_wkld_stage in ('PFC', 'SUB') "
			+ "and w.id_wkld_stage = spl.id_stage "
			+ "and spl.id_person = n.id_person "
			+ "and spl.cd_stage_pers_role = 'PC' "
			+ "and w.id_wkld_person = p2.id_person "
			+ "and w.cd_wkld_stage_pers_role = 'PR' "
			+ "and w.cd_wkld_stage_cnty = c.code "
			+ "and cpt.code_type = 'CPOCTYPE' "
			+ "and poc.cd_poc_type = cpt.code "
			+ "and fvd.cd_plcmt_type = plm.code "
			+ "and fvd.id_plcmt_child = n.id_person "
			+ " and fvd.id_poc_event = poc.id_poc_event "
			+ " and fvd.id_plcmt_event_stage = w.id_wkld_stage " // poc and
																	// plc
																	// should be
																	// on the
																	// same
																	// stage
			+ "and "
			+ "( "
			+ "(fvd.cd_plcmt_type in ('DFH', 'RFH') "
			+ "and poc.cd_poc_type not in ('RFD' , 'EFD' , 'SFD')) "
			+ "or (fvd.cd_plcmt_type in ('SFH', 'CCI', 'CFH' , 'EMS', 'IFH', 'GRH') "
			+ "and poc.cd_poc_type not in ( 'LOC' , 'RWW')) "
			+ "or (fvd.cd_plcmt_type in ('REP' , 'NRP') "
			+ "and poc.cd_poc_type not in ('ERR', 'RCS', 'ERS', 'SUG', 'ESG', 'NSG' , 'NEG')) "
			+ "or (poc.cd_poc_type in ('RFD' , 'EFD' , 'SFD') and fvd.cd_plcmt_type not in ('DFH', 'RFH')) "
			+ "or (poc.cd_poc_type in ( 'LOC' , 'RWW') and fvd.cd_plcmt_type not in ('SFH', 'CCI', 'CFH', 'EMS', 'IFH', 'GRH')) "
			+ "or (poc.cd_poc_type in ('ERR', 'RCS', 'ERS', 'SUG', 'ESG', 'NSG' , 'NEG') "
			+ "and fvd.cd_plcmt_type not in ('REP', 'NRP')) "
			+ ") "
			+ " and fvd.dt_plcmt_start = (select max(fvd_max.dt_plcmt_start) "
			+ // pull most recent plc b/c fin_validation
			"                           from fin_valid_dtl fvd_max"
			+ // retrieves all plc after last day of last month
			"                           where fvd_max.id_plcmt_child = fvd.id_plcmt_child and "
			+ // not only the most recent poc
			"                           fvd_max.id_plcmt_event_stage = fvd.id_plcmt_event_stage) "
			+ "and cr.code = c.code "
			+ "order by 1,rtrim(c.decode), p3.nm_person_full, p2.nm_person_full, n.nm_person_full";

	public static final String NO_ELIG_APP_SUBMITTED_SQL = "select distinct "
			+ " rtrim(cr.decode) Region, rtrim(c.decode) County, "
			+ "p3.nm_person_full Supervisor, p2.nm_person_full CaseManager, "
			+ "n.nm_person_full ChildName, "
			+ " w.id_wkld_case CaseID, w.id_wkld_stage StageID "
			+ "from caps.stage_person_link l, caps.ccount c, caps.workload w, caps.person p2, caps.person n, caps.person p3, "
			+ "      caps.unit u, caps.fin_valid_dtl fvd, caps.ccntyreg cr "
			+ "where n.id_person = l.id_person "
			+ "and l.cd_stage_pers_role = 'PC' "
			+ "and l.id_stage = w.id_wkld_stage "
			+ "and w.cd_wkld_stage in ('PFC', 'SUB') "
			+ "and w.id_wkld_person = p2.id_person "
			+ "and w.cd_wkld_stage_pers_role = 'PR' "
			+ "and w.cd_wkld_stage_cnty = c.code "
			+ "and w.id_wkld_unit = u.id_unit "
			+ "and u.id_person = p3.id_person "
			+ "and n.id_person = fvd.id_plcmt_child "
			+ "and fvd.result like '%No Elig%' "
			+ " and w.id_wkld_stage = fvd.id_plcmt_event_stage "
			+ "and fvd.days_in_care > 150 "
			+ "and cr.code = c.code "
			+ "order by 1,rtrim(c.decode), p3.nm_person_full, p2.nm_person_full, n.nm_person_full";

	public static final String NO_ELIG_180_DAYS_SQL = " select distinct "
			+ " rtrim(cr.decode) Region, rtrim(c.decode) County, "
			+ "p3.nm_person_full Supervisor, p2.nm_person_full CaseManager, n.nm_person_full ChildName, "
			+ " w.id_wkld_case CaseID, w.id_wkld_stage StageID, "
			+ "rtrim(ce.decode) SelectedEligibility, fvd.days_in_care DaysInCare "
			+ " from caps.stage_person_link l, caps.ccount c, caps.workload w, caps.person p2, caps.person n, caps.person p3, "
			+ "      caps.unit u, caps.eligibility el, caps.celigibi ce, "
			+ "      caps.fin_valid_dtl fvd, caps.ccntyreg cr "
			+ " where n.id_person = l.id_person "
			+ " and l.cd_stage_pers_role = 'PC' "
			+ " and l.id_stage = w.id_wkld_stage "
			+ " and w.cd_wkld_stage in ('PFC', 'SUB') "
			+ " and w.id_wkld_person = p2.id_person "
			+ " and w.cd_wkld_stage_pers_role = 'PR' "
			+ " and w.cd_wkld_stage_cnty = c.code "
			+ " and w.id_wkld_unit = u.id_unit "
			+ " and u.id_person = p3.id_person "
			+ " and el.id_person = n.id_person "
			+ " and el.id_elig_event = fvd.id_elig_event "
			+ " and w.id_wkld_stage = fvd.id_plcmt_event_stage "
			+ " and el.cd_elig_selected = ce.code " // use
													// eligibility.cd_elig_selected
													// b/c fvd.cd_elig_selected
													// is a transform value
			+ " and n.id_person = fvd.id_plcmt_child "
			+ " and fvd.result like '%Inconsistent Eligibility%' "
			+ " and cr.code = c.code "
			+ " order by 1,rtrim(c.decode), p3.nm_person_full, p2.nm_person_full, n.nm_person_full";

	public static final String POSS_INVALID_ELIG_SQL = " select distinct "
			+ " rtrim(cr.decode) Region, rtrim(c.decode) County, "
			+ "p3.nm_person_full Supervisor, p2.nm_person_full CaseManager, n.nm_person_full ChildName, "
			+ " w.id_wkld_case CaseID, w.id_wkld_stage StageID, rtrim(ce.decode) SelectedEligibility "
			+ " from caps.stage_person_link l, caps.ccount c, caps.workload w, caps.person p2, caps.person n, caps.person p3, "
			+ "      caps.unit u, caps.eligibility el, caps.celigibi ce, "
			+ "      caps.fin_valid_dtl fvd, caps.ccntyreg cr "
			+ " where n.id_person = l.id_person "
			+ " and l.cd_stage_pers_role = 'PC' "
			+ " and l.id_stage = w.id_wkld_stage "
			+ " and w.cd_wkld_stage in ('PFC', 'SUB') "
			+ " and w.id_wkld_person = p2.id_person "
			+ " and w.cd_wkld_stage_pers_role = 'PR' "
			+ " and w.cd_wkld_stage_cnty = c.code "
			+ " and w.id_wkld_unit = u.id_unit "
			+ " and u.id_person = p3.id_person "
			+ " and el.id_person = n.id_person "
			+ " and el.cd_elig_selected = ce.code "
			+ " and el.id_elig_event = fvd.id_elig_event "
			+ " and w.id_wkld_stage = fvd.id_plcmt_event_stage "
			+ " and n.id_person = fvd.id_plcmt_child "
			+ " and fvd.result like '%Possible Invalid Eligibility%' "
			+ " and cr.code = c.code "
			+ " order by 1,rtrim(c.decode), p3.nm_person_full, p2.nm_person_full, n.nm_person_full";

	public static final String NO_LEGAL_STATUS_SQL = "select "
			+ " rtrim(cr.decode) Region, rtrim(c.decode) County, p3.nm_person_full Supervisor, p2.nm_person_full CaseManager, "
			+ " p.nm_person_full ChildName, s.id_wkld_case CaseID, s.id_wkld_stage StageID "
			+ " from caps.stage_person_link l, caps.person p, caps.workload s, caps.person p2, caps.ccount c, caps.person p3, "
			+ "      caps.unit u, caps.fin_valid_dtl fvd, caps.ccntyreg cr, event fvd_event "
			+ " where l.id_person = p.id_person "
			+ " and s.id_wkld_unit = u.id_unit "
			+ " and u.id_person = p3.id_person "
			+ " and l.cd_stage_pers_role = 'PC' "
			+ " and l.id_stage = s.id_wkld_stage "
			+ " and s.cd_wkld_stage in ('SUB', 'PFC') "
			+ " and s.id_wkld_person = p2.id_person "
			+ " and s.cd_wkld_stage_cnty = c.CODE "
			+ " and s.cd_wkld_stage_pers_role = 'PR' "
			+ " and p.id_person = fvd.id_plcmt_child "
			+ "and fvd_event.id_event = fvd.id_plcmt_event "
			+ "and s.id_wkld_case = fvd_event.id_case "
			+ " and fvd.result like '%Legal%' "
			+ " and cr.code = c.code "
			+ " order by 1,rtrim(c.decode), p3.nm_person_full, p2.nm_person_full, p.nm_person_full";

	public static final String NO_CITIZENSHIP_SQL = "select "
			+ " rtrim(cr.decode) Region, rtrim(c.decode) County, p3.nm_person_full Supervisor, p2.nm_person_full CaseManager, "
			+ " p.nm_person_full ChildName, w.id_wkld_case CaseID, w.id_wkld_stage StageID "
			+ " from caps.person p, caps.stage_person_link l, caps.workload w, caps.ccount c, caps.ccntyreg cr, "
			+ "      caps.person p2, caps.person p3, caps.unit u, caps.fin_valid_dtl fvd "
			+ " where p.id_person = l.id_person "
			+ " and l.cd_stage_pers_role = 'PC' "
			+ " and l.id_stage = w.id_wkld_stage "
			+ " and w.cd_wkld_stage_cnty = c.code "
			+ " and w.id_wkld_person = p2.id_person "
			+ " and w.id_wkld_unit = u.id_unit "
			+ " and u.id_person = p3.id_person "
			+ " and p.id_person = fvd.id_plcmt_child "
			+ " and w.cd_wkld_stage_pers_role = 'PR' "
			+ " and fvd.result like '%No Citizenship%' "
			+ " and cr.code = c.code "
			+ " order by 1,rtrim(c.decode), p3.nm_person_full, p2.nm_person_full, p.nm_person_full";

	public static final String UNAPPROVED_SVC_AUTH_SQL = "SELECT "
			+ " rtrim(cr.decode) as Region, "
			+ " rtrim(c.decode) as County, "
			+ "p2.nm_person_full as Supervisor, "
			+ "p1.nm_person_full as Casemanager, "
			+ "w.id_wkld_case as CaseID, " + "w.id_wkld_stage as StageID, "
			+ "e.txt_event_descr as Description, " + "e.id_event as EventID "
			+ "FROM CAPS.EVENT E, CAPS.WORKLOAD W, CAPS.UNIT U, "
			+ "CAPS.PERSON P1, CAPS.PERSON P2, CAPS.CCOUNT C,  "
			+ "CAPS.CCNTYREG CR " + "WHERE "
			+ "e.cd_event_type = 'AUT' " + "and e.cd_event_status <> 'APRV' "
			+ "and e.id_event_stage = w.id_wkld_stage "
			+ "and w.cd_wkld_stage_cnty = c.code "
			+ "and w.cd_wkld_stage_pers_role = 'PR' "
			+ "and w.id_wkld_person = p1.id_person "
			+ "and w.id_wkld_unit = u.id_unit "
			+ "and u.id_person = p2.id_person "
			+ "and cr.code = c.code "
			+ "order by 1, 2, 3, 4, 5, 6, 7,8";

	public static final String DUPLICATE_PEOPLE_SQL = "select distinct rtrim(cr.decode) Region, " +
			"rtrim(c.decode) County, " +
			"sup.nm_person_full Supervisor, CM.nm_person_full CaseManager, " +
			"w.id_wkld_case CaseID, " +
			"p1.id_person PersonID , p1.nm_person_full PersonName, " +
			"p2.id_person PersonID2, p2.nm_person_full PersonName2 " +
			"from caps.person_enc p1,caps.person_enc p2, caps.person_enc sup, caps.person_enc CM " +
			", caps.unit u, caps.workload w, caps.ccount c, caps.ccntyreg cr " +
			", (select spl.id_stage, spl.id_person " +
			"from stage_person_link spl " +
			"where spl.cd_stage_pers_role not in ('PR','SE') " +
			"and spl.id_stage = (select max(s2.id_stage) " +
			" from stage s2, stage_person_link spl2 " +
			" where s2.id_stage = spl2.id_stage " +
			" and s2.dt_stage_close is null " +
			" and spl2.id_person = spl.id_person " +
			" and spl2.id_case = spl.id_case " +
			" and s2.dt_stage_start = (select max(s3.dt_stage_start) " +
			"     from stage s3, stage_person_link spl3 " +
			"     where s3.id_stage = spl3.id_stage " +
			"     and s3.dt_stage_close is null " +
			"     and spl2.id_person = spl2.id_person " +
			"     and spl3.id_case = spl2.id_case) " +
			" ) " +
			" ) active " +
			" where " +
			"active.id_stage = w.id_wkld_stage and " +
			"w.id_wkld_unit = u.id_unit and " +
			"sup.id_person = u.id_person and " +
			"cm.id_person = w.id_wkld_person and w.cd_wkld_stage_pers_role = 'PR' and " +
			"p1.id_person = active.id_person and " +
			"p1.id_person < p2.id_person and " +
			"substr(ltrim(rtrim(upper(p1.nm_person_first))),1,3)=substr(ltrim(rtrim(upper(p2.nm_person_first))),1,3) and " +
			"ltrim(rtrim(upper(p1.nm_person_last)))=ltrim(rtrim(upper(p2.nm_person_last))) and " +
			"p1.dt_person_birth=p2.dt_person_birth and " +
			"(p1.cd_person_sex=p2.cd_person_sex or p1.cd_person_sex is null or p2.cd_person_sex is null) and " +
			"NOT substr(ltrim(rtrim(upper(p1.nm_person_first))),1,3) = 'UNK' " +
			"AND NOT EXISTS ( SELECT 'x' " +
			"    FROM CAPS.PERSON_MERGE " +
			"    WHERE ((P1.ID_PERSON = PERSON_MERGE.ID_PERS_MERGE_CLOSED " +
			"    AND PERSON_MERGE.ID_PERS_MERGE_CLOSED <> person_merge.ID_PERS_MERGE_FORWARD) OR " +
			"    (P2.ID_PERSON = PERSON_MERGE.ID_PERS_MERGE_CLOSED " +
			"    AND PERSON_MERGE.ID_PERS_MERGE_CLOSED <> person_merge.ID_PERS_MERGE_FORWARD)) " +
			"    AND PERSON_MERGE.DT_PERS_MERGE_SPLIT IS NULL) " +
			" and c.code = w.cd_wkld_stage_cnty and c.code = cr.code " +
			"order by 1,2,3,4,5,7";
	
	public static final String MISSING_CRS_SQL = " select "
			+ " rtrim(cr.decode) Region, rtrim(c.decode) County, p3.nm_person_full Supervisor, p2.nm_person_full CaseManager, "
			+ " p1.nm_person_full ChildName, s.id_wkld_case CaseID, s.id_wkld_stage StageID, "
			+ " decode(s.cd_wkld_stage,'SUB', 'FCC', s.cd_wkld_stage) StageType "
			+ " from caps.stage_person_link l, caps.workload s, caps.person p1, caps.person p2, "
			+ "      caps.ccount c, caps.person p3, caps.unit u, caps.ccntyreg cr "
			+ " where l.cd_stage_pers_role = 'PC' "
			+ " and l.id_stage = s.id_wkld_stage "
			+ " and not exists " // --exclude ICPC cases: NCS = Not in DFCS
									// Custody - Custody With Other State
			+ " (select 1 from caps.legal_status_view lsv "
			+ "  where lsv.cd_legal_stat_status in ('NCS') and lsv.dt_legal_stat_end > sysdate "
			+ " and l.id_person = lsv.id_person "
			+ " and l.id_case = lsv.id_case) "
			+ " and l.id_person = p1.id_person "
			+ " and s.id_wkld_person = p2.id_person "
			+ " and s.cd_wkld_stage_pers_role = 'PR' "
			+ " and s.id_wkld_unit = u.id_unit "
			+ " and u.id_person = p3.id_person "
			+ " and s.cd_wkld_stage_cnty = c.code "
			+ " and s.cd_wkld_stage = 'SUB' "
			+ " and l.id_person not in "
			+ " (select i.id_person "
			+ " from caps.person_id i "
			+ " where i.cd_person_id_type = 'CRS ID#') "
			+ " and cr.code = c.code "
			+ " order by 1,2, p3.nm_person_full, p2.nm_person_full, p1.nm_person_full";

	public static final String NO_FAMILY_PLAN_SQL = "select "
			+ " rtrim(cr.decode) Region, "
			+ " rtrim(c.decode) County, p3.nm_person_full Supervisor, p2.nm_person_full CaseManager, "
			+ " w.nm_wkld_stage StageName, w.id_wkld_case CaseID, w.id_wkld_stage StageID "
			+ " from caps.workload w, caps.person p2, caps.ccount c, caps.person p3, caps.unit u, caps.stage s "
			+ " ,caps.ccntyreg cr "
			+ " where w.cd_wkld_stage = 'FSU' "
			+ " and not exists "
			+ " ( "
			+ " select e.id_event_stage "
			+ " from caps.event e, caps.fccp_family f "
			+ " where e.id_event = f.id_event "
			+ "and w.id_wkld_stage = e.id_event_stage "
			+ "and f.dt_next_rev > sysdate "
			+ " ) "
			+ " and w.id_wkld_person = p2.id_person "
			+ " and w.cd_wkld_stage_pers_role = 'PR' "
			+ " and w.cd_wkld_stage_cnty = c.code "
			+ " and w.id_wkld_unit = u.id_unit "
			+ " and u.id_person = p3.id_person "
			+ " and cr.code = c.code "
			+ " and exists "
			+ " (select 1 "
			+ " from caps.stage_person_link l, caps.legal_status_view lsv, caps.person_enc p "
			+ " where w.id_wkld_case = l.id_case and l.id_case = lsv.id_case "
			+ " and l.cd_stage_pers_role = 'PC' "
			+ " and l.id_person = p.id_person "
			+ " and ((lsv.in_dfcs_custody = 'Y' and lsv.CD_LEGAL_STAT_STATUS not in ('TVL')) "
			+ "or lsv.cd_legal_stat_status = 'AFS' "
			+ "or (lsv.CD_LEGAL_STAT_STATUS in ('TVL') and months_between(sysdate, p.dt_person_birth) < 12*18)) "
			+ "and lsv.dt_legal_stat_end > sysdate "
			+ " ) "
			+
			// case plan required after 30 days of opening stage, use 1 month is
			// ok
			" and w.id_wkld_stage = s.id_stage "
			+ " and s.dt_stage_start <= add_months(sysdate, -1) "
			+ " order by 1,2, p3.nm_person_full, p2.nm_person_full, w.nm_wkld_stage";

	public static final String NO_CHILD_PLAN_SQL = "select "
			+ "rtrim(cr.decode) Region, rtrim(c.decode) County, p3.nm_person_full Supervisor, p2.nm_person_full CaseManager, "
			+ "w.nm_wkld_stage StageName, w.id_wkld_case CaseID,w.id_wkld_stage StageID "
			+ "from caps.workload w, caps.person p2, caps.ccount c, caps.person p3, "
			+ "caps.unit u, caps.stage s, caps.ccntyreg cr "
			+ "where w.cd_wkld_stage = 'SUB' "
			+ "and not exists "
			+ "( "
			+ "select 1 "
			+ "from caps.event e, caps.fccp_child f "
			+ "where e.id_event = f.id_event and w.id_wkld_stage = e.id_event_stage"
			+ ") "
			+ "and w.id_wkld_person = p2.id_person "
			+ "and w.cd_wkld_stage_pers_role = 'PR' "
			+ "and w.cd_wkld_stage_cnty = c.code "
			+ "and w.id_wkld_unit = u.id_unit "
			+ "and u.id_person = p3.id_person "
			+ "and cr.code = c.code "
			+ "and exists " // child is in DFCS custody - condition to require
							// child plan
			+ "(select 1 "
			+ "from caps.stage_person_link l, caps.legal_status_view lsv "
			+ "where w.id_wkld_stage = l.id_stage "
			+ "and l.cd_stage_pers_role = 'PC' "
			+ "and l.id_person = lsv.id_person and l.id_case = lsv.id_case "
			+ "and lsv.in_dfcs_custody = 'Y' and lsv.dt_legal_stat_end > sysdate "
			+ ") "
			+ " and not exists " // exclude persons in care 18 yrs or older
			+ "	(select 1 "
			+ "	from caps.stage_person_link l2, caps.person p18 "
			+ "	where w.id_wkld_stage = l2.id_stage "
			+ "	and l2.cd_stage_pers_role = 'PC' "
			+ "	and l2.id_person = p18.id_person "
			+ "	and months_between(sysdate, p18.dt_person_birth) >= 12*18 "
			+ "	) "
			+
			// case plan required after 30 days of stage open, use one month ok
			"and w.id_wkld_stage = s.id_stage "
			+ "	and s.dt_stage_start <= add_months(sysdate, -1) "
			+ "	order by 1, 2, p3.nm_person_full, p2.nm_person_full, w.nm_wkld_stage";

	// Total-queries: used as denominator in percentage
	public static final String TOTAL_FCC_STAGES_SQL = " select * from ( "
			+ " select cr.decode REGION, c.decode COUNTY, count(*) FCC_STAGES_CNT "
			+ " from caps.ccntyreg cr, caps.ccount c, caps.workload w, caps.stage_person_link l "
			+ " where w.cd_wkld_stage = 'SUB' "
			+ " and w.cd_wkld_stage_cnty = c.code "
			+ " and cr.code = c.code "
			+ " and w.id_wkld_person = l.id_person "
			+ " and w.id_wkld_stage = l.id_stage "
			+ " and l.cd_stage_pers_role = 'PR' "
			+ " group by cr.decode, c.decode "
			+ " UNION "
			+ " select cr.decode, c.decode, 0 "
			+ " from caps.ccount c,caps.ccntyreg cr where "
			+ " cr.code = c.code and "
			+ " c.code not in "
			+ " (select c.code "
			+ " from caps.ccntyreg cr, caps.ccount c, caps.workload w, caps.stage_person_link l "
			+ " where w.cd_wkld_stage = 'SUB' "
			+ " and w.cd_wkld_stage_cnty = c.code " + " and cr.code = c.code "
			+ " and w.id_wkld_person = l.id_person "
			+ " and w.id_wkld_stage = l.id_stage "
			+ " and l.cd_stage_pers_role = 'PR' " + " group by c.code)) "
			+ " order by 1,2";

	public static final String TOTAL_FCF_STAGES_SQL = " select * from ( "
			+ " select cr.decode REGION, c.decode COUNTY, count(*) FCF_STAGES_CNT "
			+ " from caps.ccntyreg cr, caps.ccount c, caps.workload w, caps.stage_person_link l "
			+ " where w.cd_wkld_stage = 'FSU' "
			+ " and w.cd_wkld_stage_cnty = c.code "
			+ " and cr.code = c.code "
			+ " and w.id_wkld_person = l.id_person "
			+ " and w.id_wkld_stage = l.id_stage "
			+ " and l.cd_stage_pers_role = 'PR' "
			+ " group by cr.decode, c.decode "
			+ " UNION "
			+ " select cr.decode, c.decode, 0 "
			+ " from caps.ccount c,caps.ccntyreg cr where "
			+ " cr.code = c.code and "
			+ " c.code not in "
			+ " (select c.code "
			+ " from caps.ccntyreg cr, caps.ccount c, caps.workload w, caps.stage_person_link l "
			+ " where w.cd_wkld_stage = 'FSU' "
			+ " and w.cd_wkld_stage_cnty = c.code " + " and cr.code = c.code "
			+ " and w.id_wkld_person = l.id_person "
			+ " and w.id_wkld_stage = l.id_stage "
			+ " and l.cd_stage_pers_role = 'PR' " + " group by c.code)) "
			+ " order by 1,2";

	public static final String TOTAL_PAID_PLACEMENT_SQL = " select cr.decode REGION, c.decode COUNTY, count(*) PAID_PLACEMENT_CNT "
			+ " from caps.workload w, caps.ccount c, caps.placement plc, caps.stage_person_link l, caps.ccntyreg cr "
			+ " where w.cd_wkld_stage in ('SUB', 'PFC') "
			+ " and w.cd_wkld_stage_cnty = c.code "
			+ " AND trunc(Plc.DT_PLCMT_END) > last_day(add_months(sysdate, -1)) "
			+ " AND (Plc.CD_TEMP_TYPE IS NULL OR Plc.CD_TEMP_TYPE NOT IN ('RED','REN','COR')) "
			+ " AND Plc.CD_PLCMT_TYPE IN "
			+ " ('REP','NRP','RFH','DFH','CFH','IFH','EMS','GRH','CCI','SFH') "
			+ " and plc.cd_plcmt_act_planned = 'A' "
			+ " and w.cd_wkld_stage_pers_role = 'PR' "
			+ " and w.id_wkld_stage = l.id_stage "
			+ " and l.cd_stage_pers_role = 'PC' "
			+ " and l.id_person = plc.id_plcmt_child "
			+ " and cr.code = c.code "
			+ " and ((plc.ind_plcmt_not_applic <> 'Y') or (plc.ind_plcmt_not_applic is null)) "
			+ " group by cr.decode, c.decode order by cr.decode, c.decode";

	public static final String TOTAL_ACTIVE_FCC_PFC_STAGES_SQL = " select cr.decode REGION, c.decode COUNTY, count(*) ACTIVE_FCC_PFC_STAGES_CNT "
			+ " from caps.ccntyreg cr, caps.ccount c, caps.workload w, caps.stage_person_link l "
			+ " where w.cd_wkld_stage in ('SUB', 'PFC') "
			+ " and w.cd_wkld_stage_cnty = c.code "
			+ " and cr.code = c.code "
			+ " and w.id_wkld_person = l.id_person "
			+ " and w.id_wkld_stage = l.id_stage "
			+ " and l.cd_stage_pers_role = 'PR' "
			+ " group by cr.decode, c.decode order by cr.decode, c.decode";

	public static final String TOTAL_ACTIVE_SVC_AUTH_SQL = "select * from ( "
			+ " select cr.decode REGION, c.decode COUNTY, count(*) ACTIVE_SVC_AUTH_CNT "
			+ " from caps.ccntyreg cr, caps.ccount c, caps.workload w, caps.event e "
			+ " where w.id_wkld_stage = e.id_event_stage "
			+ " and e.cd_event_type = 'AUT' "
			+ " and w.cd_wkld_stage_cnty = c.code "
			+ " and cr.code = c.code "
			+ " and w.cd_wkld_stage_pers_role = 'PR' "
			+ " group by cr.decode, c.decode "
			+ " UNION "
			+ " select cr.decode, c.decode, 0 "
			+ " from caps.ccount c,caps.ccntyreg cr where "
			+ " cr.code = c.code and "
			+ " c.code not in "
			+ " (select c.code "
			+ " from caps.ccntyreg cr, caps.ccount c, caps.workload w, caps.event e "
			+ " where w.id_wkld_stage = e.id_event_stage "
			+ " and e.cd_event_type = 'AUT' "
			+ " and w.cd_wkld_stage_cnty = c.code " + " and cr.code = c.code "
			+ " and w.cd_wkld_stage_pers_role = 'PR' " + " group by c.code )) "
			+ " order by 1, 2";

	// Mapping
	public static final Map<String, String> sqlRefMap = new HashMap<String, String>();
	static {
		sqlRefMap.put(NO_PLACEMENT, NO_PLACEMENT_SQL);
		sqlRefMap.put(PLACEMENT_NOT_APPROVED, PLACEMENT_NOT_APPROVED_SQL);
		sqlRefMap.put(NO_PAYMENT_OF_CARE, NO_PAYMENT_OF_CARE_SQL);
		sqlRefMap.put(PAYMENT_OF_CARE_NOT_APPROVED,
				PAYMENT_OF_CARE_NOT_APPROVED_SQL);
		sqlRefMap.put(POC_PLC_MISMATCH, POC_PLC_MISMATCH_SQL);
		sqlRefMap.put(NO_ELIG_APP_SUBMITTED, NO_ELIG_APP_SUBMITTED_SQL);
		sqlRefMap.put(NO_ELIG_180_DAYS, NO_ELIG_180_DAYS_SQL);
		sqlRefMap.put(UNAPPROVED_SVC_AUTH, UNAPPROVED_SVC_AUTH_SQL);
		sqlRefMap.put(POSS_INVALID_ELIG, POSS_INVALID_ELIG_SQL);
		sqlRefMap.put(NO_CITIZENSHIP, NO_CITIZENSHIP_SQL);
		sqlRefMap.put(NO_LEGAL_STATUS, NO_LEGAL_STATUS_SQL);
		sqlRefMap.put(DUPLICATE_PEOPLE, DUPLICATE_PEOPLE_SQL);
		sqlRefMap.put(MISSING_CRS, MISSING_CRS_SQL);
		sqlRefMap.put(NO_FAMILY_PLAN, NO_FAMILY_PLAN_SQL);
		sqlRefMap.put(NO_CHILD_PLAN, NO_CHILD_PLAN_SQL);

		sqlRefMap.put(TOTAL_FCC_STAGES, TOTAL_FCC_STAGES_SQL);
		sqlRefMap.put(TOTAL_FCF_STAGES, TOTAL_FCF_STAGES_SQL);
		sqlRefMap.put(TOTAL_PAID_PLACEMENT, TOTAL_PAID_PLACEMENT_SQL);
		sqlRefMap.put(TOTAL_ACTIVE_FCC_PFC_STAGES,
				TOTAL_ACTIVE_FCC_PFC_STAGES_SQL);
		sqlRefMap.put(TOTAL_ACTIVE_SVC_AUTH, TOTAL_ACTIVE_SVC_AUTH_SQL);

	}

	// Blank row mapping to each report sheet
	// Catch-all blank row in UDRConstant can also be used instead of populating
	// one for every sheet.
	// Update it with new column if needs to
	public static final Map<String, Object> UNAPPROVED_SVC_AUTH_BLANK_ROW = new HashMap<String, Object>();
	static {
		UNAPPROVED_SVC_AUTH_BLANK_ROW.put("REGION", StringHelper.EMPTY_STRING);
		UNAPPROVED_SVC_AUTH_BLANK_ROW.put("COUNTY", StringHelper.EMPTY_STRING);
		UNAPPROVED_SVC_AUTH_BLANK_ROW.put("SUPERVISOR",
				StringHelper.EMPTY_STRING);
		UNAPPROVED_SVC_AUTH_BLANK_ROW.put("CASEMANAGER",
				StringHelper.EMPTY_STRING);
		UNAPPROVED_SVC_AUTH_BLANK_ROW.put("CASEID", StringHelper.EMPTY_STRING);
		UNAPPROVED_SVC_AUTH_BLANK_ROW.put("STAGEID", StringHelper.EMPTY_STRING);
		UNAPPROVED_SVC_AUTH_BLANK_ROW.put("DESCRIPTION",
				StringHelper.EMPTY_STRING);
		UNAPPROVED_SVC_AUTH_BLANK_ROW.put("EVENTID", StringHelper.EMPTY_STRING);
	}

	public static final Map<String, Object> NO_PLACEMENT_BLANK_ROW = new HashMap<String, Object>();
	static {
		NO_PLACEMENT_BLANK_ROW.put("REGION", StringHelper.EMPTY_STRING);
		NO_PLACEMENT_BLANK_ROW.put("COUNTY", StringHelper.EMPTY_STRING);
		NO_PLACEMENT_BLANK_ROW.put("SUPERVISOR", StringHelper.EMPTY_STRING);
		NO_PLACEMENT_BLANK_ROW.put("CASEMANAGER", StringHelper.EMPTY_STRING);
		NO_PLACEMENT_BLANK_ROW.put("CHILDNAME", StringHelper.EMPTY_STRING);
		NO_PLACEMENT_BLANK_ROW.put("CASEID", StringHelper.EMPTY_STRING);
		NO_PLACEMENT_BLANK_ROW.put("STAGEID", StringHelper.EMPTY_STRING);
		NO_PLACEMENT_BLANK_ROW.put("STAGETYPE", StringHelper.EMPTY_STRING);
	}

}
