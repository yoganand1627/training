ALTER TABLE CAPS.AFCARS_HISTORY ADD DT_RECENT_DISCHARGE_TRANS DATE     NULL;

{ call dbms_utility.compile_schema('CAPS') };
{ call dbms_utility.compile_schema('CAPSBAT') };
{ call dbms_utility.compile_schema('CAPSON') };
{ call dbms_utility.compile_schema('OPERATOR') };
{ call dbms_utility.compile_schema('SACWISIFC') };

-- All changes for version 2.3 of SHINES

-- change STGAP00007631

insert into caps.reports 
(nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_retainage, nm_rpt_type, txt_rpt_full_name, nm_rpt_template_name, nm_rpt_orientation, txt_rpt_email_options, nm_rpt_desc, nm_rpt_area_type, ind_rpt_page)
select
'CPSIntakeLog', '00', 31, 'A', 'CPS Intake Log', 'ondport', 'L', 'W', 'Designed to meet the policy requirements for a call log, this report displays a list of all intakes received for a county within a specified date range.', 'Intake', 'Y'
from dual 
where not exists (select 'x' from caps.reports where nm_rpt_sqr_name='CPSIntakeLog' and nm_rpt_sqr_ver='00');

INSERT INTO caps.report_parameter
(nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
select
'CPSIntakeLog','00','1','3','COUNTYCD', 'CHAR', 'Y', 'County'
from dual
where not exists (select 'x' from caps.report_parameter where nm_rpt_sqr_name='CPSIntakeLog' and nm_rpt_sqr_ver='00' and nbr_rpt_parm_seq='1');

INSERT INTO caps.report_parameter
(nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
select
'CPSIntakeLog','00','2','10','STARTDATE', 'DATE', 'Y', 'Start Date'
from dual
where not exists (select 'x' from caps.report_parameter where nm_rpt_sqr_name='CPSIntakeLog' and nm_rpt_sqr_ver='00' and nbr_rpt_parm_seq='2');

INSERT INTO caps.report_parameter
(nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
select
'CPSIntakeLog','00','3','10','ENDDATE', 'DATE', 'Y', 'End Date'
from dual
where not exists (select 'x' from caps.report_parameter where nm_rpt_sqr_name='CPSIntakeLog' and nm_rpt_sqr_ver='00' and nbr_rpt_parm_seq='3');


insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (295, 'SacwisRev2', 'static table updates, new field for AFCARS_HISTORY');
commit;

