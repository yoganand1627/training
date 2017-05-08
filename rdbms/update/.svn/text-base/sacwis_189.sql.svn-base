-- change STGAP00003307
UPDATE CAPS.CODES_TABLES SET DT_END=SYSDATE WHERE CODE_TYPE='CCONPAY' AND CODE='CRM';

-- change STGAP00003314
update caps.message
set txt_message = 'The regional MES Program Assistant not located. Please contact your supervisor.'
where txt_message_name = 'MSG_FCE_MES_PROG_ASST_NOT_FND';

-- change STGAP00003326
UPDATE CAPS.CODES_TABLES SET DECODE='RBWO Provider Waiver' WHERE CODE_TYPE='CWVRTYP' AND CODE='WLC';

-- change STGAP00003338
update caps.codes_tables
set dt_end = to_date('01/01/2006','MM/DD/YYYY')
where code_type = 'CSPCUNTS'
and code in ('ADL','ADP','ADR','ADV','AOC','BGT','BKP','BUS','CAR','CAU','CCL','CDS','CFU','CLS','CMG','COM','CPP',
'CSA','CVS','DDR','DTE','EDR','FAC','FAD','FAR','FAT','FHU','FOC','FOU','FPM','FPS','FPU','FRU','GEN','GUA','HRU','ICP',
'IFP','IFR','INS','IRT','LEG','LPD','MGT','OMB','PAC','PAL','PAS','PDU','PLC','PMG','POS','PPS','PPT','RAT','RCC',
'REA','REC','REG','RSP','SEX','STA','STD','STU','SUB','SUP','SWI','TVL','VOL','YSP');

-- change STGAP00003366
update caps.codes_tables
set dt_end = to_date('01/01/2006','MM/DD/YYYY')
where code_type = 'CEMPJBCL'
and code not in ('14006','14011','14013','14036','14037','14071','14074','14077','14108','14201','14202','14203','14204','14205',
'14211','14212','14439','14606','14901','16087','16927','40015','40037','40602','40604','40803','40806','40807', '40814','40815',
'60068','60104','60112','60113','61083','61105','61502','95027','G1000','G1001','G1002','G1003','G1004','G1005','G1006','G1007',
'G1008','G1009','G1010','G1011','G1012','G1013','G1014','G1015','G1016','G1017','G1018','G1019','G1020','G1021','G1022','G1028',
'G1023','G1024','G1025','G1026','G1027','H1401','H1402','RAC');

UPDATE CAPS.CODES_TABLES SET dt_end = to_date ('01/01/2006','MM/DD/YYYY') where code_type = 'CEMPJBCL';
UPDATE CAPS.CODES_TABLES SET DECODE='Generalist', dt_end = null WHERE CODE_TYPE='CEMPJBCL' AND CODE='14006';
INSERT INTO caps.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CEMPJBCL','14011','DFCS Program Consultant',SYSDATE);
UPDATE CAPS.CODES_TABLES SET DECODE='Medicaid Eligibility Specialist Supr (REV MAX SUP)', dt_end = null  WHERE CODE_TYPE='CEMPJBCL' AND CODE='14013';
UPDATE CAPS.CODES_TABLES SET DECODE='Deputy County Director' , dt_end = null WHERE CODE_TYPE='CEMPJBCL' AND CODE='14036';
INSERT INTO caps.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CEMPJBCL','14037','County Director',SYSDATE);
UPDATE CAPS.CODES_TABLES SET DECODE='Field Operations Mgr', dt_end = null  WHERE CODE_TYPE='CEMPJBCL' AND CODE='14071';
UPDATE CAPS.CODES_TABLES SET DECODE='Field Program Specialist', dt_end = null  WHERE CODE_TYPE='CEMPJBCL' AND CODE='14074';
UPDATE CAPS.CODES_TABLES SET DECODE='Social Services Technician', dt_end = null  WHERE CODE_TYPE='CEMPJBCL' AND CODE='14077';
UPDATE CAPS.CODES_TABLES SET DECODE='Family Services Worker', dt_end = null  WHERE CODE_TYPE='CEMPJBCL' AND CODE='14108';
UPDATE CAPS.CODES_TABLES SET DECODE='Social Services Supervisor', dt_end = null  WHERE CODE_TYPE='CEMPJBCL' AND CODE='14201';
UPDATE CAPS.CODES_TABLES SET DECODE='Social Services Administrator', dt_end = null  WHERE CODE_TYPE='CEMPJBCL' AND CODE='14202';
UPDATE CAPS.CODES_TABLES SET DECODE='Social Services Case Manager', dt_end = null  WHERE CODE_TYPE='CEMPJBCL' AND CODE='14203';
UPDATE CAPS.CODES_TABLES SET DECODE='Social Services Specialist', dt_end = null  WHERE CODE_TYPE='CEMPJBCL' AND CODE='14204';
UPDATE CAPS.CODES_TABLES SET DECODE='Case Manager Adv', dt_end = null  WHERE CODE_TYPE='CEMPJBCL' AND CODE='14205';
UPDATE CAPS.CODES_TABLES SET DECODE='Social Services Program Director', dt_end = null  WHERE CODE_TYPE='CEMPJBCL' AND CODE='14211';
UPDATE CAPS.CODES_TABLES SET DECODE='Case Manager Assoc', dt_end = null  WHERE CODE_TYPE='CEMPJBCL' AND CODE='14212';
UPDATE CAPS.CODES_TABLES SET DECODE='Economic Support Screener', dt_end = null  WHERE CODE_TYPE='CEMPJBCL' AND CODE='14439';
UPDATE CAPS.CODES_TABLES SET DECODE='DFCS Community Resource Specialist', dt_end = null  WHERE CODE_TYPE='CEMPJBCL' AND CODE='14606';
UPDATE CAPS.CODES_TABLES SET DECODE='DFCS Regional Resource Coordinator', dt_end = null  WHERE CODE_TYPE='CEMPJBCL' AND CODE='14901';
UPDATE CAPS.CODES_TABLES SET DECODE='Project Administrator', dt_end = null  WHERE CODE_TYPE='CEMPJBCL' AND CODE='16087';
INSERT INTO caps.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CEMPJBCL','16927','Staff Development/Training',SYSDATE);
INSERT INTO caps.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CEMPJBCL','40015','Fiscal Operations Service Mgr',SYSDATE);  
UPDATE CAPS.CODES_TABLES SET DECODE='Fiscal Operations Mgr', dt_end = null  WHERE CODE_TYPE='CEMPJBCL' AND CODE='40037';
INSERT INTO caps.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CEMPJBCL','40602','Budget Officer',SYSDATE);
INSERT INTO caps.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CEMPJBCL','40604','Budget Analyst',SYSDATE);
INSERT INTO caps.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CEMPJBCL','40803','Accounting Mgr',SYSDATE);
UPDATE CAPS.CODES_TABLES SET DECODE='Paraprofessional Accountant', dt_end = null  WHERE CODE_TYPE='CEMPJBCL' AND CODE='40806';
UPDATE CAPS.CODES_TABLES SET DECODE='Accounting Clerk' , dt_end = null WHERE CODE_TYPE='CEMPJBCL' AND CODE='40807';
INSERT INTO caps.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CEMPJBCL','40814','Accountant Professional',SYSDATE);
INSERT INTO caps.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CEMPJBCL','40815','Accountant',SYSDATE);
INSERT INTO caps.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CEMPJBCL','60068','Project Director',SYSDATE);
UPDATE CAPS.CODES_TABLES SET DECODE='Administrative Assistant', dt_end = null  WHERE CODE_TYPE='CEMPJBCL' AND CODE='60104';
INSERT INTO caps.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CEMPJBCL','60112','Program Assistant',SYSDATE);
INSERT INTO caps.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CEMPJBCL','60113','Program Associate',SYSDATE);
INSERT INTO caps.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CEMPJBCL','61083','Program Director',SYSDATE);
INSERT INTO caps.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CEMPJBCL','61105','Quality Assurance Specialist',SYSDATE);
UPDATE CAPS.CODES_TABLES SET DECODE='Volunteer Resource Coordinator', dt_end = null  WHERE CODE_TYPE='CEMPJBCL' AND CODE='61502';
INSERT INTO caps.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CEMPJBCL','95027','Fiscal Services Manager',SYSDATE);
INSERT INTO caps.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CEMPJBCL','G1000','SHINES Program Specialist',SYSDATE);
INSERT INTO caps.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CEMPJBCL','G1001','Program Manager/Application Development Manager',SYSDATE);
INSERT INTO caps.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CEMPJBCL','G1002','Conversion Lead',SYSDATE);
INSERT INTO caps.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CEMPJBCL','G1003','Implementation Manager',SYSDATE);
INSERT INTO caps.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CEMPJBCL','G1004','OFI Quality Assurance',SYSDATE);
INSERT INTO caps.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CEMPJBCL','G1005','DJJ Staff',SYSDATE);
INSERT INTO caps.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CEMPJBCL','G1006','Regional Director',SYSDATE);
INSERT INTO caps.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CEMPJBCL','G1007','Independent Living Coordinator',SYSDATE);
INSERT INTO caps.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CEMPJBCL','G1008','Medicaid Eligibility Specialist (REV MAX)',SYSDATE);
INSERT INTO caps.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CEMPJBCL','G1009','Quality Assurance Supervisor',SYSDATE);
INSERT INTO caps.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CEMPJBCL','G1010','Operations Support Coordinator(Adoptions Assistance)',SYSDATE);
INSERT INTO caps.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CEMPJBCL','G1011','ICPC Coordinator',SYSDATE);
INSERT INTO caps.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CEMPJBCL','G1012','Placement Coordinator',SYSDATE);
INSERT INTO caps.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CEMPJBCL','G1013','Recruitment Manager',SYSDATE);
INSERT INTO caps.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CEMPJBCL','G1014','Kenney A./IPO Reviewers',SYSDATE);
INSERT INTO caps.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CEMPJBCL','G1015','Policy Specialist',SYSDATE);
INSERT INTO caps.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CEMPJBCL','G1016','DHR Commissioner',SYSDATE); 
INSERT INTO caps.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CEMPJBCL','G1017','DHR Assistant Commissioner',SYSDATE);
INSERT INTO caps.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CEMPJBCL','G1018','Division Director',SYSDATE);
INSERT INTO caps.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CEMPJBCL','G1019','Division Deputy Director',SYSDATE);
INSERT INTO caps.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CEMPJBCL','G1020','Division Director Assistant',SYSDATE);
INSERT INTO caps.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CEMPJBCL','G1021','Director Program Policy and Development',SYSDATE);
INSERT INTO caps.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CEMPJBCL','G1022','Deputy Director Program Policy and Development',SYSDATE);
INSERT INTO caps.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CEMPJBCL','G1028','DFCS FSO-Billing Specialist',SYSDATE);
INSERT INTO caps.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CEMPJBCL','G1023','Adoptions Program Manager',SYSDATE);
INSERT INTO caps.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CEMPJBCL','G1024','Contracted Community Based Organization',SYSDATE);
INSERT INTO caps.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CEMPJBCL','G1025','Contract Lead Agency Provider',SYSDATE);
INSERT INTO caps.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CEMPJBCL','G1026','SHINES System Administrator',SYSDATE);
INSERT INTO caps.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CEMPJBCL','G1027','Unit Team Leader/Lead Worker',SYSDATE);
UPDATE CAPS.CODES_TABLES SET DECODE='Social Services Aide', dt_end = null  WHERE CODE_TYPE='CEMPJBCL' AND CODE='H1401';
INSERT INTO caps.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CEMPJBCL','H1402','OFI Manager',SYSDATE);

-- change STGAP00003367
alter table caps.emp_sec_class_link disable constraint FK_EXP_SEC_CLASS_LINK;    
delete from caps.security_class;

insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('RSRC_DVLPR',sysdate,'001000000011000000000000000000000000000000000001001101100000000000000000000000000100000000','N',2071);
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('CONTRACTED_CBO',sysdate,'000000000010000001000000000111111111111111111100000101100000000000000000000000100000000000','N',2071);
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('CONTRACT_LEAD',sysdate,'000001010010000001000100000111111111111111111100000101100000000000000000000000010000000000','N',2071);
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('COUNTY_MGMNT',sysdate,'111001010111110100000110000000000000000000000001001101100100000000000100000000000000000000','N',2071);
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('DJJ_AFCARS',sysdate,'001000000011000000000000011000000000000000000000000000000000000010000000000000000000000000','N',2071);
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('DPTY_CNTY_DRCTR',sysdate,'111001010111110000000110000000000000000000000001001101000100000000001000000000000000000000','N',2071);
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('FSCL_SVC_ST_STF',sysdate,'110001010000010000000100000000000000000000000001001001000000000000000000000001000000000000','N',2071);
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
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('MES_PROG_ASST',sysdate,'001000000011000000000110011000000000000000000001001001000000000000000000000000001000000000','N',2071);
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('REGNL_ACCT_MGMT',sysdate,'110001010000010000000001100111111111111111111111111111011111000000000000100000000000000000','N',2071);
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('REGNL_ACCT_STF',sysdate,'000001010000000000000001100111111111111111111111101111111111000000000001000000000000000000','N',2071);
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('REGNL_SS_STAFF',sysdate,'101001010011000000000110000000000000000000000001001001000100000000000010000000000000000000','N',2071);
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('REG_FAM_IND_MGT',sysdate,'110011010000010000000100011000000000000000000000000000000000000000000000001000000000000000','N',2071);
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('REG_FAM_IND_STF',sysdate,'000000000000000000000000011000000000000000000000000000000000000000000000010000000000000000','N',2071);
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('SHINES_STAFF',sysdate,'101111111111110100010111111111111111111111111111111111111111111111111111111111111000000000','N',2071);
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('SS_ADMIN_STAFF',sysdate,'000000000000000001000000000000000000000000000000000000000000000000010000000000000000000000','N',2071);
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('STATE_OFC_CONS',sysdate,'100001010010000000000010000000000000000000000001001001000100000000000000000100000000000000','N',2071);
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('STATE_OFC_MGMT',sysdate,'100000010000000000000000000000000000000000000001001001000000000000000000000010000000000000','N',2071);
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('SYS_ADMIN',sysdate,'111111111111111100011111111111111111111111111111111111111111111111111111111111111000000000','Y',2071);
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('UNIT_TEAM_LEAD',sysdate,'101001010011100000000110000000000000000000000001001101000100000001000000000000000000000000','N',2071);
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('CASE_MANAGER',sysdate,'001000000011000000000010000000000000000000000001001101000100000100000000000000000000000000','N',2071);
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('SUPERVISOR',sysdate,'111001010011110000000110000000000000000000000001001101000100000000100000000000000000000000','N',2071);

update caps.emp_sec_class_link escl
set escl.cd_security_class_name = 'CASE_MANAGER'
where escl.cd_security_class_name not in
(select sc.cd_security_class_name from caps.security_class sc);

commit;

alter table caps.emp_sec_class_link enable constraint FK_EXP_SEC_CLASS_LINK;

insert into caps.schema_version (id_schema_version, application_version, comments)
                         values (190, 'SacwisRev2', 'static updates'); 
commit;
