-- STGAP00009371

insert all when not exists(select 'x' from caps.reports where nm_rpt_sqr_name='EligibilitySummary' and nm_rpt_sqr_ver='00') then
   into caps.reports (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_retainage, nm_rpt_type, txt_rpt_full_name, nm_rpt_template_name, 
       nm_rpt_orientation, txt_rpt_email_options, nm_rpt_desc, nm_rpt_area_type, ind_rpt_page)
     select 'EligibilitySummry', '00', 31, 'A', 'Eligibility Summary', 'ondport', 'L', 'W', 'Lists the Statewide and Region totals of approved, active eligibility records in each Actual Eligibility type for a specific month and optional Region parameter.If Region is blank, the report runs for statewide', 'Eligibility', 'Y' from dual;

update caps.reports set nm_rpt_sqr_name='EligibilitySummary' where nm_rpt_sqr_name='EligibilitySummry' and nm_rpt_sqr_ver='00' ;

insert all when not exists(select 'x' from caps.report_parameter where nm_rpt_sqr_name='EligibilitySummary' and nm_rpt_sqr_ver='00' and nbr_rpt_parm_seq=1) then
   into caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
     select 'EligibilitySummary','00',1,'7','MONTHYEAR', 'CHAR', 'Y', 'Month/Year' from dual;

insert all when not exists(select 'x' from caps.report_parameter where nm_rpt_sqr_name='EligibilitySummary' and nm_rpt_sqr_ver='00' and nbr_rpt_parm_seq=2) then
   into caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
     select 'EligibilitySummary','00',2,'2','REGIONCD', 'CHAR', 'N', 'Region' from dual;


-- STGAP00009381
Insert into caps.message
   ( DT_LAST_UPDATE, NBR_MESSAGE,
    TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH)
 Values
   (  SYSDATE, 60449,
   'MSG_CSLI_EXISTS',
   'A Service Line Item already exists on this Contract.', 700, 500, 'N');

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (350, 'SacwisRev2', 'DBCRs 9371,9381');
commit;


