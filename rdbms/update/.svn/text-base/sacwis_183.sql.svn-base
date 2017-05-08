-- change STGAP00003086
UPDATE CAPS.CODES_TABLES SET DT_END=SYSDATE WHERE CODE_TYPE='CSRCRPTR' AND CODE='SC' AND DECODE='Secondary Caretaker';
UPDATE CAPS.CODES_TABLES SET DT_END=SYSDATE WHERE CODE_TYPE='CSRCRPTR' AND CODE='SR' AND DECODE='Step-Child';

-- change STGAP00003091
UPDATE caps.security_class SET ind_restrict = 'Y' WHERE cd_security_class_name = 'SYS_ADMIN';
UPDATE caps.security_class SET ind_restrict = 'N' WHERE cd_security_class_name = 'CASE_MANAGER';

-- change STGAP00003095
INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH) VALUES (60344, 'MSG_FCE_TXT_PREG_SENT_NO','Please explain why the proof of child''s pregnancy is not being sent to the Eligibility Specialist in the comments box provided.',500,700,'N');

-- change STGAP00003099
UPDATE CAPS.MESSAGE SET txt_message = 'Services must be authorized in the Foster Care Child stages that exist for this case.' WHERE txt_message_name = 'MSG_SVA_NOT_FROM_INVEST' AND id_message = 16366;

-- change STGAP00003100
update CAPS.TASK SET CD_TASK_EVENT_STATUS = 'APRV', CD_TASK_LIST_WINDOW = 'CCMN51W', CD_TASK_TOP_WINDOW='CSUB01C', IND_TASK_DETAIL_ENABLE=0, IND_TASK_EVENT_CREATE=0, IND_TASK_EVENT_NAVIG=0, IND_TASK_LIST_ENABLE=1, IND_TASK_NEW_ENABLE=0, IND_TASK_NU_ACROSS_CASE=1, IND_TASK_TODO_ENABLE=0, IND_TASK_NEW_CASE_TODO_ENABLE=0 where cd_task in (9511,9505,8585);

-- security profile update
alter table caps.emp_sec_class_link disable constraint FK_EXP_SEC_CLASS_LINK;    

delete from caps.security_class;

insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('CONTRACTED_CBO',sysdate,'000000000011000001000000000111111111111111111100000101100000000000000000000000100000000000','N',2071);
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('CONTRACT_LEAD',sysdate,'000101010011000001000100000111111111111111111100000101100000000000000000000000010000000000','N',2071);
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('COUNTY_MGMNT',sysdate,'111001010111110100000110000100000000000000000001001101100100000000000100000000000000000000','N',2071);
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('DJJ_AFCARS',sysdate,'001000000011000000000000011000000000000000000000000000000000000010000000000000000000000000','N',2071);
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('DPTY_CNTY_DRCTR',sysdate,'111001010111010000000110000000000000000000000001001101000100000000001000000000000000000000','N',2071);
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('FSCL_SVC_ST_STF',sysdate,'110001000000011000000100000000000000000000000001001001000000000000000000000001000000000000','N',2071);
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('MAINTAIN_REG_01',sysdate,'000000000000000000000000000010000000000000000000000000000000000000000000000000000000000000','N',2071);
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('MAINTAIN_REG_02',sysdate,'000000000000000000000000000001000000000000000000000000000000000000000000000000000000000000','N',2071);
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('MAINTAIN_REG_03',sysdate,'000000000000000000000000000000100000000000000000000000000000000000000000000000000000000000','N',2071);
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('MAINTAIN_REG_04',sysdate,'000000000000000000000000000000010000000000000000000000000000000000000000000000000000000000','N',2071);
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('MAINTAIN_REG_05',sysdate,'000000000000000000000000000000001000000000000000000000000000000000000000000000000000000000','N',2071);
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('MAINTAIN_REG_06',sysdate,'000000000000000000000000000000000100000000000000000000000000000000000000000000000000000000','N',2071);
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('MAINTAIN_REG_07',sysdate,'000000000000000000000000000000000010000000000000000000000000000000000000000000000000000000','N',2071);
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('MAINTAIN_REG_08',sysdate,'000000000000000000000000000000000001000000000000000000000000000000000000000000000000000000','N',2071);
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('MAINTAIN_REG_09',sysdate,'000000000000000000000000000000000000100000000000000000000000000000000000000000000000000000','N',2071);
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('MAINTAIN_REG_10',sysdate,'000000000000000000000000000000000000010000000000000000000000000000000000000000000000000000','N',2071);
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('MAINTAIN_REG_11',sysdate,'000000000000000000000000000000000000001000000000000000000000000000000000000000000000000000','N',2071);
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('MAINTAIN_REG_12',sysdate,'000000000000000000000000000000000000000100000000000000000000000000000000000000000000000000','N',2071);
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('MAINTAIN_REG_13',sysdate,'000000000000000000000000000000000000000010000000000000000000000000000000000000000000000000','N',2071);
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('MAINTAIN_REG_14',sysdate,'000000000000000000000000000000000000000001000000000000000000000000000000000000000000000000','N',2071);
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('MAINTAIN_REG_15',sysdate,'000000000000000000000000000000000000000000100000000000000000000000000000000000000000000000','N',2071);
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('MAINTAIN_REG_16',sysdate,'000000000000000000000000000000000000000000010000000000000000000000000000000000000000000000','N',2071);
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('MAINTAIN_REG_17',sysdate,'000000000000000000000000000000000000000000001000000000000000000000000000000000000000000000','N',2071);
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('MAINTAIN_REG_99',sysdate,'000000000000000000000000000000000000000000000100000000000000000000000000000000000000000000','N',2071);
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('MES_PROG_ASST',sysdate,'000000000000000000000100011000000000000000000000000000000000000000000000000000001000000000','N',2071);
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('REGNL_ACCT_MGMT',sysdate,'110001010000010000000001100111111111111111111111011111011111000000000000100000000000000000','N',2071);
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('REGNL_ACCT_STF',sysdate,'000000000000000000000001100111111111111111111111111111111111000000000001000000000000000000','N',2071);
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('REGNL_SS_STAFF',sysdate,'001001010011100000000110000000000000000000000001001001000100000000000010000000000000000000','N',2071);
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('REG_FAM_IND_MGT',sysdate,'110011010000010000000100011000000000000000000000000000000000000000000000001000000000000000','N',2071);
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('REG_FAM_IND_STF',sysdate,'000000000000000000000000011000000000000000000000000000000000000000000000010000000000000000','N',2071);
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('SHINES_STAFF',sysdate,'101111111111110100010111111111111111111111111111111111111111111111111111111111111000000000','N',2071);
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('SS_ADMIN_STAFF',sysdate,'000000000000000011100000000000000000000000000000000000000000000000010000000000000000000000','N',2071);
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('STATE_OFC_CONS',sysdate,'000000010010000000000010000000000000000000000001001001000100000000000000000100000000000000','N',2071);
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('STATE_OFC_MGMT',sysdate,'100000010000000000000000000000000000000000000001001001000000000000000000000010000000000000','N',2071);
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('SYS_ADMIN',sysdate,'111111111111111100011111111111111111111111111111111111111111111111111111111111111000000000','Y',2071);
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('UNIT_TEAM_LEAD',sysdate,'001001010011100000000110000000000000000000000001001001000100000001000000000000000000000000','N',2071);
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('CASE_MANAGER',sysdate,'001000000011000000000010000000000000000000000001001001000100000100000000000000000000000000','N',2071);
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('SUPERVISOR',sysdate,'111001010011110000000110000000000000000000000001001001000100000000100000000000000000000000','N',2071);

update caps.emp_sec_class_link escl
set escl.cd_security_class_name = 'CASE_MANAGER'
where escl.cd_security_class_name not in
(select sc.cd_security_class_name from caps.security_class sc);

alter table caps.emp_sec_class_link enable constraint FK_EXP_SEC_CLASS_LINK;


insert into caps.schema_version (id_schema_version, application_version, comments)
                         values (184, 'SacwisRev2', 'static updates');
commit;