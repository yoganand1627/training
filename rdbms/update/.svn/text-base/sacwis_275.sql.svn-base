-- change STGAP00007014
-- insert param row
insert into caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values ('FamilyPreservationMonthlyStatus', '00', 3, 16, 'CASEID', 'NUMBER', 'N', 'Case ID');
insert into caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values ('FosterCareMonthlyStatus', '00', 3, 16, 'CASEID', 'NUMBER', 'N', 'Case ID');
insert into caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values ('CaseloadListingCounty', '00', 3, 16, 'STAFFID', 'NUMBER', 'N', 'Staff ID');
 
-- update report description / name
update caps.reports set NM_RPT_DESC = 'Multiple statistics reported for ongoing cases in the county within the month. Generated for a specific case manager and service month with an optional case ID parameter.' 
where NM_RPT_SQR_NAME = 'FamilyPreservationMonthlyStatus';
update caps.reports set NM_RPT_DESC = 'Multiple statistics reported for foster care cases in the county within the month. Generated for a specific case manager and service month with an optional case ID parameter.' 
where NM_RPT_SQR_NAME = 'FosterCareMonthlyStatus';
update caps.reports set NM_RPT_DESC = 'A list of foster care cases that have been opened for more than 45 days without an approved eligibility determination. Generated for a specific county with an optional unit parameter.' 
where NM_RPT_SQR_NAME = 'OverStandardofPromptness';
update caps.reports set NM_RPT_DESC = 'A comprehensive view of caseloads in a county grouped by unit then by case manager. Generated for a specific county with optional unit and case manager parameters.' 
where NM_RPT_SQR_NAME = 'CaseloadListingCounty';
update caps.reports set TXT_RPT_FULL_NAME = 'Caseload Listing' 
where NM_RPT_SQR_NAME = 'CaseloadListingCounty';

-- delete duplicate
delete from caps.report_parameter where NM_RPT_SQR_NAME = 'CaseloadListing';
delete from caps.reports where NM_RPT_SQR_NAME = 'CaseloadListing';

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (276, 'SacwisRev2', 'static table updates - Report tables');                        
commit;

