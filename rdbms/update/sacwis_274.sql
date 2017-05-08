-- change STGAP00007009
DELETE FROM CAPS.REPORT_PARAMETER WHERE NM_RPT_SQR_NAME = 'FosterCareDischarge';
DELETE FROM CAPS.REPORTS WHERE NM_RPT_SQR_NAME = 'FosterCareDischarge';

-- change STGAP00007011
update caps.reports set ind_rpt_page = 'Y'  
where NM_RPT_SQR_NAME = 'FosterCareMonthlyStatus';

update caps.report_parameter set NM_RPT_PARM_NAME='STAFFID' 
where nm_rpt_parm_label='Staff ID' and NM_RPT_SQR_NAME = 'FosterCareMonthlyStatus';

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (275, 'SacwisRev2', 'static table updates - Report tables');                        
commit;

