-- Standard Alter Table SQL

ALTER TABLE CAPS.REPORTS MODIFY(NM_RPT_SQR_NAME  VARCHAR2(50))
;
ALTER TABLE CAPS.REPORT_LIST MODIFY(NM_RPT_SQR_NAME  VARCHAR2(50))
;
ALTER TABLE CAPS.REPORT_PARAMETER MODIFY(NM_RPT_SQR_NAME  VARCHAR2(50))
;
{ call dbms_utility.compile_schema('CAPS') };
{ call dbms_utility.compile_schema('CAPSBAT') };
{ call dbms_utility.compile_schema('CAPSON') };
{ call dbms_utility.compile_schema('OPERATOR') };
{ call dbms_utility.compile_schema('SACWISIFC') };

insert into caps.metaphor values(1591, '/admin/Reports/reportLaunchList', 'REPORT_LAUNCH_REPORTLIST', 'Report<br>Launch', NULL, NULL, NULL, NULL);
insert into caps.metaphor values(1592, '/admin/Reports/displayReportParameterDetail', 'REPORT_LAUNCH_PARAMETERS', 'Report<br>Parameters', NULL, NULL, NULL, NULL);

insert into caps.message (nbr_message, txt_message_name, txt_message, cd_source, cd_presentation, ind_batch) values (99312, 'MSG_ARC_CONSTR_MONTH_YEAR', 'Please enter a month and year in the MM/YYYY format.', 720, 500, 'N');

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (263, 'SacwisRev2', 'static table updates, expand report name in report tables'); 
commit;
