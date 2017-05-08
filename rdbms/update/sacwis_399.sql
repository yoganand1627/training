--STGAP00010836 - Delete record from static Stage_Prog table

DELETE FROM CAPS.STAGE_PROG s
WHERE s.CD_STAGE_PROG_RSN_CLOSE = 'TAA'
AND s.CD_STAGE_PROG_PROGRAM = 'CPS'
AND s.CD_STAGE_PROG_STAGE = 'SUB'
AND s.CD_STAGE_PROG_OPEN = 'PFC';

DELETE FROM CAPS.STAGE_PROG s
WHERE s.CD_STAGE_PROG_RSN_CLOSE = 'TAA'
AND s.CD_STAGE_PROG_PROGRAM = 'CPS'
AND s.CD_STAGE_PROG_STAGE = 'PFC';


--STGAP00010903 - (ADAM) End-Date Legal Actions TPR-Father Value


UPDATE CAPS.CODES_TABLES SET DT_END=SYSDATE WHERE CODE_TYPE='CLHECOT' AND CODE='TPF';


--STGAP00010918 - (ADAM) Rename INT Non-Incident Decodes

UPDATE CAPS.CODES_TABLES SET DECODE='PAD' WHERE CODE='PA' AND CODE_TYPE='CNIRTYPE';

UPDATE CAPS.CODES_TABLES SET DECODE='PFC' WHERE CODE='PF' AND CODE_TYPE='CNIRTYPE';


--STGAP00010941 - Create New Foster Home Activity Report

--This is a request to insert new rows into the report static tables to support the new report DFCS Foster Home Activity. 
--These statements have been tested successfully in Dev.

insert all when not exists(select 'x' from caps.reports where nm_rpt_sqr_name='DFCSFosterHomeMonthlyActivity'
and NM_RPT_SQR_VER='00') THEN into CAPS.reports (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_retainage, nm_rpt_type, txt_rpt_full_name, nm_rpt_template_name, nm_rpt_orientation, txt_rpt_email_options, nm_rpt_desc, nm_rpt_area_type, ind_rpt_page)
select 'DFCSFosterHomeMonthlyActivity' a , '00', 31, 'A', 'DFCS Foster Home Monthly Activity', 'ondport', 'L', 'W', 'Monthly activity of DFCS foster homes including counts of inquiries, approvals, closures, and waitlists for a month. Generated for a specific Date with optional Region and County parameters.', 'Resource Development', 'Y' from dual;

insert all when not exists(select 'x' from caps.report_parameter where nm_rpt_sqr_name='DFCSFosterHomeMonthlyActivity'
and NM_RPT_SQR_VER='00') then into CAPS.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
select'DFCSFosterHomeMonthlyActivity', '00', 1, 7, 'MONTHYEAR', 'CHAR', 'Y', 'Month/Year' from dual;

insert all when not exists(select 'x' from caps.report_parameter where nm_rpt_sqr_name='DFCSFosterHomeMonthlyActivity'
and NM_RPT_SQR_VER='00')  then into CAPS.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
select 'DFCSFosterHomeMonthlyActivity', '00', 2 A, 2 B, 'REGIONCD', 'CHAR', 'N', 'Region' from dual;

insert all when not exists(select 'x' from caps.report_parameter where nm_rpt_sqr_name='DFCSFosterHomeMonthlyActivity'
and NM_RPT_SQR_VER='00')  then into CAPS.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
select 'DFCSFosterHomeMonthlyActivity', '00', 3 A, 3 B, 'COUNTYCD', 'CHAR', 'N', 'County' from dual;



--STGAP00011004 - New codes for code type = CPL so that there are on

insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) values ('CPL', 302, 'Family HX of Mental Retardation');

{ call dbms_utility.compile_schema('CAPS') };
{ call dbms_utility.compile_schema('CAPSBAT') };
{ call dbms_utility.compile_schema('CAPSON') };
{ call dbms_utility.compile_schema('OPERATOR') };
{ call dbms_utility.compile_schema('SACWISIFC') };
{ call dbms_utility.compile_schema('ORS') };

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (400, 'SacwisRev3', 'Release 3.0 - DBCRs 10836,10903,10918,10941,11004');

commit;


