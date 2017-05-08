
--STGAP00011846 - DBCR: To insert new rows to enable new report

--Note:  no impact to ado model

--New SQR report for 3.0: Children With Overdue Life Histories

--Dev#: STGAP00010328

insert all when not exists(select 'x' from caps.reports where nm_rpt_sqr_name='ChildrenWithOverdueLifeHistories'
and NM_RPT_SQR_VER='00') then
into caps.reports (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_retainage, nm_rpt_type, 
txt_rpt_full_name, nm_rpt_template_name, nm_rpt_orientation, txt_rpt_email_options,
 nm_rpt_desc, nm_rpt_area_type, ind_rpt_page,cd_sec_attr)
select 'ChildrenWithOverdueLifeHistories', '00', 31, 'A', 'Children With Overdue Life Histories Report',
 'ondport', 'P', 'W', 
'A list of children in Adoption stage in DFCS custody with no approved child life history checklist record and it has been more than 60 days since the TPR or Voluntary Surrender of the first parent. Generated for optional Region and County parameters.This report requires SAU staff security attribute.',
 'Adoptions', 'Y',91 from dual;

insert all when not exists(select 'x' from caps.report_parameter where nm_rpt_sqr_name='ChildrenWithOverdueLifeHistories'
and NM_RPT_SQR_VER='00' AND nbr_rpt_parm_seq=1) then
into caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
select 'ChildrenWithOverdueLifeHistories', '00', 1, 2, 'REGIONCD', 'CHAR', 'N','Region' from dual;

insert all when not exists(select 'x' from caps.report_parameter where nm_rpt_sqr_name='ChildrenWithOverdueLifeHistories'
and NM_RPT_SQR_VER='00' AND nbr_rpt_parm_seq=2) then
into caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length, nm_rpt_parm_name, 
txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
select 'ChildrenWithOverdueLifeHistories', '00', 2 ,3, 'COUNTYCD' C, 'CHAR', 'N', 'County' from dual;


--STGAP00011862 - insert statement to enable new report

--Note:  no impact to ado model

--New SQR report for 3.0: Monthly Family Management Report

--Dev#: STGAP00010318

insert all when not exists(select 'x' from caps.reports where nm_rpt_sqr_name='MonthlyFamilyManagement'
and NM_RPT_SQR_VER='00') then
into caps.reports (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_retainage, nm_rpt_type, txt_rpt_full_name, 
nm_rpt_template_name, nm_rpt_orientation, txt_rpt_email_options, nm_rpt_desc, nm_rpt_area_type, ind_rpt_page,cd_sec_attr)
select 'MonthlyFamilyManagement', '00', 31, 'A', 'Monthly Family Management Report', 'ondport', 'L', 'W', 'A list of all active homes registered with the Adoption Exchange in County,Region or Statewide. Generated for optional Region and County parameters.This report requires SAU staff security attribute.',
 'Adoptions', 'Y',91 from dual;

insert all when not exists(select 'x' from caps.report_parameter where nm_rpt_sqr_name='MonthlyFamilyManagement'
and NM_RPT_SQR_VER='00' AND nbr_rpt_parm_seq=1) then
into caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
select 'MonthlyFamilyManagement', '00', 1, 2, 'REGIONCD', 'CHAR', 'N', 'Region'from dual;

insert all when not exists(select 'x' from caps.report_parameter where nm_rpt_sqr_name='MonthlyFamilyManagement'
and NM_RPT_SQR_VER='00' AND nbr_rpt_parm_seq=2) then
into caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length, 
nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
select 'MonthlyFamilyManagement', '00', 2 ,3, 'COUNTYCD' C, 'CHAR', 'N', 'County' from dual;

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (421, 'SacwisRev3', 'Release 3.0 - DBCRs 11878,11846,11862');

commit;


