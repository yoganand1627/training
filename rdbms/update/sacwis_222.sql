-- change STGAP00004456
-- The following tables need to be moved to the DATA01 tablespace:

alter table caps.WORKLOAD move tablespace data01;
alter table caps.DELETE_CASE_HIST move tablespace data01;
alter table caps.DELETE_EPL_HIST move tablespace data01;
alter table caps.DELETE_RESOURCES_HIST move tablespace data01;
alter table caps.DELETE_WORKLOAD_HIST move tablespace data01;
alter table caps.ROLLOUT_DATE move tablespace data01;

-- The following indexes need to be moved to the INDEX01 tablespace:

alter index caps.IND_DHS_ELIGIBILITY_1 rebuild tablespace index01;
alter index caps.IND_EVENT_PLAN_LINK_1 rebuild tablespace index01;
alter index caps.IND_FAMILY_PLAN_1 rebuild tablespace index01;
alter index caps.IND_FAMILY_PLAN_2 rebuild tablespace index01;
alter index caps.IND_FAMILY_PLAN_EVAL_1 rebuild tablespace index01;
alter index caps.IND_FAMILY_PLAN_EVAL_2 rebuild tablespace index01;
alter index caps.IND_FAMILY_PLAN_EVAL_3 rebuild tablespace index01;
alter index caps.IND_FAMILY_PLAN_EVAL_ITEM_1 rebuild tablespace index01;
alter index caps.IND_FAMILY_PLAN_EVAL_ITEM_2 rebuild tablespace index01;
alter index caps.IND_FAMILY_PLAN_EVAL_ITEM_3 rebuild tablespace index01;
alter index caps.IND_FAMILY_PLAN_ITEM_1 rebuild tablespace index01;
alter index caps.IND_FAMILY_PLAN_ITEM_2 rebuild tablespace index01;
alter index caps.IND_FAMILY_PLAN_TASK_1 rebuild tablespace index01;
alter index caps.IND_FAMILY_PLAN_TASK_2 rebuild tablespace index01;
alter index caps.IND_FAMILY_PLAN_TASK_3 rebuild tablespace index01;
alter index caps.IND_PAL_FOLLOW_UP_1 rebuild tablespace index01;
alter index caps.IND_PAL_PUBLIC_ASSIST_1 rebuild tablespace index01;
alter index caps.IND_REPORT_LIST_2 rebuild tablespace index01;
alter index caps.IND_REPORT_LIST_3 rebuild tablespace index01;
alter index caps.PK_CASE_BUDGET_LIMIT rebuild tablespace index01;
alter index caps.PK_CASE_BUDGET_LIMIT_WAIVER rebuild tablespace index01;
alter index caps.PK_CPS_CONCLUSION_NARR rebuild tablespace index01;
alter index caps.PK_DIVERSION_CONCLUSION_NARR rebuild tablespace index01;
alter index caps.PK_EVENT_PLAN_LINK rebuild tablespace index01;
alter index caps.PK_EXT_DOCUMENTATION rebuild tablespace index01;
alter index caps.PK_FAMILY_PLAN rebuild tablespace index01;
alter index caps.PK_FAMILY_PLAN_EVAL rebuild tablespace index01;
alter index caps.PK_FAMILY_PLAN_EVAL_ITEM rebuild tablespace index01;
alter index caps.PK_FAMILY_PLAN_ITEM rebuild tablespace index01;
alter index caps.PK_FAMILY_PLAN_TASK rebuild tablespace index01;
alter index caps.PK_FCCP_DTL_FORM_NARR rebuild tablespace index01;
alter index caps.PK_FUNDING_STREAM rebuild tablespace index01;
alter index caps.PK_INITIAL_MED_PARENT rebuild tablespace index01;
alter index caps.PK_PAL_FOLLOW_UP rebuild tablespace index01;
alter index caps.PK_PAL_PUBLIC_ASSIST rebuild tablespace index01;
alter index caps.PK_PGM_LCNSRE_TYPS rebuild tablespace index01;
alter index caps.UK_CODES_TABLES rebuild tablespace index01;
alter index caps.UK_PAL_FOLLOW_UP rebuild tablespace index01;

{ call dbms_utility.compile_schema('CAPS') };
{ call dbms_utility.compile_schema('CAPSBAT') };
{ call dbms_utility.compile_schema('CAPSON') };
{ call dbms_utility.compile_schema('OPERATOR') };
{ call dbms_utility.compile_schema('SACWISIFC') };

-- change STGAP00004450
INSERT INTO CAPS.MESSAGE (nbr_message, txt_message_name, txt_message, cd_source, cd_presentation, ind_batch) VALUES (60360, 'MSG_CMN_NO_PC', 'No Primary Child was found for this stage.', '600', '740', 'N');

-- change STGAP00004461
update caps.codes_tables
set dt_end = sysdate
where code_type = 'CPRGMINT'
and code in ('CLP','CCO');

insert into caps.codes_tables
(code_type, code, decode, dt_last_update)
values
('CPRGMINT','FSG','Foster Sibling Group',sysdate);

insert into caps.codes_tables
(code_type, code, decode, dt_last_update)
values
('CPRGMINT','FAS','Foster Adolescents',sysdate);

insert into caps.codes_tables
(code_type, code, decode, dt_last_update)
values
('CPRGMINT','VOL','Volunteer',sysdate);


insert into caps.schema_version (id_schema_version, application_version, comments)
                         values (223, 'SacwisRev2', 'static updates, move objects to correct tablespaces'); 
commit;
