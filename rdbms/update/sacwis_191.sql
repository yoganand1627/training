-- change STGAP00003376
-- NOT IN DESIGN - Indiv Study Course
UPDATE CAPS.CODES_TABLES SET DT_END=SYSDATE WHERE CODE_TYPE='CFATRAIN' AND CODE='INDV';

-- NOT IN D/B - OLTN	On-line Training
INSERT INTO CAPS.CODES_TABLES VALUES('CFATRAIN', 'OLTN', 'On-line Training', null, SYSDATE);

-- NOT IN DESIGN - Reading - article
UPDATE CAPS.CODES_TABLES SET DT_END=SYSDATE WHERE CODE_TYPE='CFATRAIN' AND CODE='RDAR';

-- NOT IN DESIGN - Reading - book
UPDATE CAPS.CODES_TABLES SET DT_END=SYSDATE WHERE CODE_TYPE='CFATRAIN' AND CODE='RDBK';

-- NOT IN DESIGN - Television
UPDATE CAPS.CODES_TABLES SET DT_END=SYSDATE WHERE CODE_TYPE='CFATRAIN' AND CODE='TELV';

-- NOT IN DESIGN - Training by FPS Staff
-- NOT IN D/B - TPRS	Training by DFCS Staff
UPDATE CAPS.CODES_TABLES SET DECODE='Training by DFCS Staff' WHERE CODE_TYPE='CFATRAIN' AND CODE='TPRS';

-- NOT IN D/B - WSFE	Water Safety
INSERT INTO CAPS.CODES_TABLES VALUES('CFATRAIN', 'WSFE', 'Water Safety', null, SYSDATE);

-- NOT IN D/B - TSFC	Transfer Conference
INSERT INTO CAPS.CODES_TABLES VALUES('CFATRAIN', 'TSFC', 'Transfer Conference', null, SYSDATE);

-- NOT IN D/B - VSTC	Video Satelite Training Conference
INSERT INTO CAPS.CODES_TABLES VALUES('CFATRAIN', 'VSTC', 'Video Satelite Training Conference', null, SYSDATE);

UPDATE CAPS.CODES_TABLES SET DECODE='Infant Alcohol Addition' WHERE CODE_TYPE='CLNCHAR2' AND CODE=40;
UPDATE CAPS.CODES_TABLES SET DECODE='Military Dependent' WHERE CODE_TYPE='CLNCHAR2' AND CODE=54;
UPDATE CAPS.CODES_TABLES SET DECODE='Other Medically Diagnosed' WHERE CODE_TYPE='CLNCHAR2' AND CODE=90;

-- IN DESIGN DOCUMENT, NOT IN D/B
-- 143	Sibling Group
UPDATE CAPS.CODES_TABLES SET CODE=143, DT_END=null WHERE CODE_TYPE='CLNCHAR2' AND DECODE='Sibling Group';

-- IN DESIGN DOCUMENT, NOT IN D/B
-- 43	Limited English proficiency
UPDATE CAPS.CODES_TABLES SET CODE=43, DECODE='Limited English Proficiency', DT_END=null WHERE CODE_TYPE='CLNCHAR2' AND DECODE='Limited English Prof';


-- change STGAP00003397
insert into caps.codes_tables
(code_type, code, decode, dt_last_update)
values
('CSECATTR','BP','IT Security',sysdate);

insert into caps.codes_tables
(code_type, code, decode, dt_last_update)
values
('CSECATTR','EN','Browse County Budget Limit',sysdate);

update caps.codes_tables
set decode = 'Browse Security'
where code = 'BO'
and code_type = 'CSECATTR';

update caps.codes_tables
set decode = 'Restrict Financial'
where code = 'BN'
and code_type = 'CSECATTR';

update caps.codes_tables
set decode = 'Resource Developer'
where code = 'PB'
and code_type = 'CSECATTR';

alter table caps.emp_sec_class_link disable constraint FK_EXP_SEC_CLASS_LINK;    
delete from caps.security_class;

insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('RSRC_DVLPR',sysdate,'001000000011000000000000000000000000000000000000100110110000000000000000000000000001000000','N',2071);
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('CONTRACTED_CBO',sysdate,'000000000010000001010000000011111111111111111110000010110000000000000000000000001000000000','N',2071);
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('CONTRACT_LEAD',sysdate,'000001010010000001010010000011111111111111111110000010110000000000000000000000000100000000','N',2071);
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('COUNTY_MGMNT',sysdate,'111001010111110100000011000000000000000000000000101110110010100000000001000000000000000000','N',2071);
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('DJJ_AFCARS',sysdate,'001000000011000000010000001100000000000000000000000000000000000000100000000000000000000000','N',2071);
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('DPTY_CNTY_DRCTR',sysdate,'111001010111110000000011000000000000000000000000100110100010100000000010000000000000000000','N',2071);
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('FSCL_SVC_ST_STF',sysdate,'110001010000010000000010000000000000000000000000100100100000110000000000000000010000000000','N',2071);
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('MAINTAIN_REG_01',sysdate,'000000000000000000000000000001000000000000000000000000000000000000000000000000000000000000','N',2071);
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('MAINTAIN_REG_02',sysdate,'000000000000000000000000000000100000000000000000000000000000000000000000000000000000000000','N',2071);
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('MAINTAIN_REG_03',sysdate,'000000000000000000000000000000010000000000000000000000000000000000000000000000000000000000','N',2071);
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('MAINTAIN_REG_04',sysdate,'000000000000000000000000000000001000000000000000000000000000000000000000000000000000000000','N',2071);
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('MAINTAIN_REG_05',sysdate,'000000000000000000000000000000000100000000000000000000000000000000000000000000000000000000','N',2071);
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('MAINTAIN_REG_06',sysdate,'000000000000000000000000000000000010000000000000000000000000000000000000000000000000000000','N',2071);
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('MAINTAIN_REG_07',sysdate,'000000000000000000000000000000000001000000000000000000000000000000000000000000000000000000','N',2071);
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('MAINTAIN_REG_08',sysdate,'000000000000000000000000000000000000100000000000000000000000000000000000000000000000000000','N',2071);
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('MAINTAIN_REG_09',sysdate,'000000000000000000000000000000000000010000000000000000000000000000000000000000000000000000','N',2071);
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('MAINTAIN_REG_10',sysdate,'000000000000000000000000000000000000001000000000000000000000000000000000000000000000000000','N',2071);
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('MAINTAIN_REG_11',sysdate,'000000000000000000000000000000000000000100000000000000000000000000000000000000000000000000','N',2071);
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('MAINTAIN_REG_12',sysdate,'000000000000000000000000000000000000000010000000000000000000000000000000000000000000000000','N',2071);
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('MAINTAIN_REG_13',sysdate,'000000000000000000000000000000000000000001000000000000000000000000000000000000000000000000','N',2071);
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('MAINTAIN_REG_14',sysdate,'000000000000000000000000000000000000000000100000000000000000000000000000000000000000000000','N',2071);
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('MAINTAIN_REG_15',sysdate,'000000000000000000000000000000000000000000010000000000000000000000000000000000000000000000','N',2071);
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('MAINTAIN_REG_16',sysdate,'000000000000000000000000000000000000000000001000000000000000000000000000000000000000000000','N',2071);
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('MAINTAIN_REG_17',sysdate,'000000000000000000000000000000000000000000000100000000000000000000000000000000000000000000','N',2071);
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('MAINTAIN_REG_99',sysdate,'000000000000000000000000000000000000000000000010000000000000000000000000000000000000000000','N',2071);
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('MES_PROG_ASST',sysdate,'001000000011000000010011001100000000000000000000000000100000000000000000000000000010000000','N',2071);
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('REGNL_ACCT_MGMT',sysdate,'110001010000010000000000110011111111111111111111111111101111100000000000001000000000000000','N',2071);
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('REGNL_ACCT_STF',sysdate,'000001010000000000000000110011111111111111111111110111111111110000000000010000000000000000','N',2071);
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('REGNL_SS_STAFF',sysdate,'101001010011000000000011000000000000000000000000100100100010000000000000100000000000000000','N',2071);
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('REG_FAM_IND_MGT',sysdate,'110011010000010000010010001100000000000000000000000000000000000000000000000010000000000000','N',2071);
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('REG_FAM_IND_STF',sysdate,'000000000000000000010000001100000000000000000000000000000000000000000000000100000000000000','N',2071);
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('SHINES_STAFF',sysdate,'101111111111110100001011111111111111111111111111111111111111111111111111111111111111000000','N',2071);
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('SS_ADMIN_STAFF',sysdate,'000000000000000001010000000000000000000000000000000000000000000000000100000000000000000000','N',2071);
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('STATE_OFC_CONS',sysdate,'100001010010000000000001000000000000000000000000100100100010100000000000000001000000000000','N',2071);
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('STATE_OFC_MGMT',sysdate,'100000010000000000000000000000000000000000000000100100100000100000000000000000100000000000','N',2071);
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('SYS_ADMIN',sysdate,'111111111111111100001111111111111111111111111111111111111111111111111111111111111111000000','Y',2071);
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('UNIT_TEAM_LEAD',sysdate,'101001010011100000000011000000000000000000000000100110100010000000010000000000000000000000','N',2071);
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('CASE_MANAGER',sysdate,'001000000011000000000001000000000000000000000000100110100010000001000000000000000000000000','N',2071);
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('SUPERVISOR',sysdate,'111001010011110000000011000000000000000000000000100110100010000000001000000000000000000000','N',2071);

update caps.emp_sec_class_link escl
set escl.cd_security_class_name = 'CASE_MANAGER'
where escl.cd_security_class_name not in
(select sc.cd_security_class_name from caps.security_class sc);

commit;

alter table caps.emp_sec_class_link enable constraint FK_EXP_SEC_CLASS_LINK;

insert into caps.schema_version (id_schema_version, application_version, comments)
                         values (192, 'SacwisRev2', 'static updates');
commit;
