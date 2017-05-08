-- Standard Alter Table SQL

GRANT DELETE ON CAPS.SA_SAFETY_FACTOR TO CAPSBAT
;
GRANT INSERT ON CAPS.SA_SAFETY_FACTOR TO CAPSBAT
;
GRANT SELECT ON CAPS.SA_SAFETY_FACTOR TO CAPSBAT
;
GRANT UPDATE ON CAPS.SA_SAFETY_FACTOR TO CAPSBAT
;
GRANT DELETE ON CAPS.SA_SAFETY_FACTOR TO CAPSON
;
GRANT INSERT ON CAPS.SA_SAFETY_FACTOR TO CAPSON
;
GRANT SELECT ON CAPS.SA_SAFETY_FACTOR TO CAPSON
;
GRANT UPDATE ON CAPS.SA_SAFETY_FACTOR TO CAPSON
;
GRANT SELECT ON CAPS.SA_SAFETY_FACTOR TO OPERATOR
;

-- change STGAP00002949
UPDATE CAPS.FCE_AFDC_INCOME_LIMIT SET AMT_GROSS_INCOME_CEILING = 659  WHERE ID_FCE_AFDC_INCOME_LIMIT = 2;

-- change STGAP00002950
UPDATE CAPS.MESSAGE set TXT_MESSAGE = 'The question "Were any Permanency Review hearings held for the child since the last foster care eligibility determination/redetermination?" must be answered.' where TXT_MESSAGE_NAME = 'MSG_PERMANENCY_REQ' ;
UPDATE CAPS.MESSAGE set TXT_MESSAGE = 'The question, "Is a judicial determination regarding "Reasonable efforts to Finalize the child''s Permanency Plan" due? (Reminder: Permanency must be addressed every 12 months while child is in care, regardless of TPR or extension of custody.)" must be answered.' where TXT_MESSAGE_NAME = 'MSG_JUDICIAL_FINDING_REQ';
UPDATE CAPS.MESSAGE set TXT_MESSAGE = 'The question, "Was a judicial determination regarding "Reasonable Efforts to Finalize the child''s Permanency Plan" made during the past 12 months?" must be answered.' where TXT_MESSAGE_NAME = 'MSG_JUDICIAL_FINDING_12MO_REQ';
UPDATE CAPS.MESSAGE set TXT_MESSAGE = 'This child does not have a current Foster Care Eligibility Application.  Foster Care Redetermination is not available until an Application has been completed for this child.' where TXT_MESSAGE_NAME = 'MSG_NO_APPLICATION_REVIEW_NOT_AVAILABLE';

-- change STGAP00002962
--remove old profiles, but first reassign people
UPDATE caps.emp_sec_class_link
SET cd_security_class_name = 'SUPERVISOR'
WHERE cd_security_class_name = 'SS_ADMNSTRATOR';

UPDATE caps.emp_sec_class_link
SET cd_security_class_name = 'SUPERVISOR'
WHERE cd_security_class_name = 'SS_PROG_DRCTR';

UPDATE caps.emp_sec_class_link
SET cd_security_class_name = 'CONTRACT_LEAD'
WHERE cd_security_class_name = 'OFI_STAFF_MGMT';

UPDATE caps.emp_sec_class_link
SET cd_security_class_name = 'CONTRACTED_CBO'
WHERE cd_security_class_name = 'OFI_STAFF';

UPDATE caps.emp_sec_class_link
SET cd_security_class_name = 'STATE_OFC_CONS'
WHERE cd_security_class_name = 'CHILD_ADVOCATE';

UPDATE caps.emp_sec_class_link
SET cd_security_class_name = 'SHINES_STAFF'
WHERE cd_security_class_name = 'DFCS_TECH_STAFF';

--delete profiles no longer used
delete from caps.security_class where cd_security_class_name in ('CHILD_ADVOCATE','DFCS_TECH_STAFF','OFI_STAFF','OFI_STAFF_MGMT', 'SS_ADMNSTRATOR','SS_PROG_DRCTR');

--update data into security_classupdate caps.security_class set  update caps.security_class set  txt_security_class_profil='00100000000001100000000001000000000000000000000010100110100010000010000000000000000000000' where cd_security_class_name = 'CASE_MANAGER';
update caps.security_class set  txt_security_class_profil='00000000000001100000100000000010000000000000000000000010110000000000000000000000000010000' where cd_security_class_name = 'CONTRACTED_CBO';
update caps.security_class set  txt_security_class_profil='000010101000011000001000100000100000000000000000000000101100000000000000000000000000010000' where cd_security_class_name = 'CONTRACT_LEAD';
update caps.security_class set  txt_security_class_profil='10100010101101110000000011110000000000000000000010100110101010000000000000100000000000000' where cd_security_class_name = 'COUNTY_MGMNT';
update caps.security_class set  txt_security_class_profil='001000000000001000000000000011000000000000000000000000000000000000010000000000000000000000' where cd_security_class_name = 'DJJ_AFCARS';
update caps.security_class set  txt_security_class_profil='101000101011011100000000111100000000000000000000101001101010100000000000010000000000000000' where cd_security_class_name = 'DPTY_CNTY_DRCTR';
update caps.security_class set  txt_security_class_profil='100000101000000000000000001100000000000000000000011101011010110000000000000000000001000000' where cd_security_class_name = 'FSCL_SVC_ST_STF';
update caps.security_class set  txt_security_class_profil='00000000000000000000000000000001000000000000000000000000000000000000000000000000000000000' where cd_security_class_name = 'MAINTAIN_REG_01';
update caps.security_class set  txt_security_class_profil='00000000000000000000000000000000100000000000000000000000000000000000000000000000000000000' where cd_security_class_name = 'MAINTAIN_REG_02';
update caps.security_class set  txt_security_class_profil='00000000000000000000000000000000010000000000000000000000000000000000000000000000000000000' where cd_security_class_name = 'MAINTAIN_REG_03';
update caps.security_class set  txt_security_class_profil='00000000000000000000000000000000001000000000000000000000000000000000000000000000000000000' where cd_security_class_name = 'MAINTAIN_REG_04';
update caps.security_class set  txt_security_class_profil='00000000000000000000000000000000000100000000000000000000000000000000000000000000000000000' where cd_security_class_name = 'MAINTAIN_REG_05';
update caps.security_class set  txt_security_class_profil='00000000000000000000000000000000000010000000000000000000000000000000000000000000000000000' where cd_security_class_name = 'MAINTAIN_REG_06';
update caps.security_class set  txt_security_class_profil='00000000000000000000000000000000000001000000000000000000000000000000000000000000000000000' where cd_security_class_name = 'MAINTAIN_REG_07';
update caps.security_class set  txt_security_class_profil='00000000000000000000000000000000000000100000000000000000000000000000000000000000000000000' where cd_security_class_name = 'MAINTAIN_REG_08';
update caps.security_class set  txt_security_class_profil='000000000000000000000000000000000000000100000000000000000000000000000000000000000000000000' where cd_security_class_name = 'MAINTAIN_REG_09';
update caps.security_class set  txt_security_class_profil='00000000000000000000000000000000000000001000000000000000000000000000000000000000000000000' where cd_security_class_name = 'MAINTAIN_REG_10';
update caps.security_class set  txt_security_class_profil='00000000000000000000000000000000000000000100000000000000000000000000000000000000000000000' where cd_security_class_name = 'MAINTAIN_REG_11';
update caps.security_class set  txt_security_class_profil='00000000000000000000000000000000000000000010000000000000000000000000000000000000000000000' where cd_security_class_name = 'MAINTAIN_REG_12';
update caps.security_class set  txt_security_class_profil='00000000000000000000000000000000000000000001000000000000000000000000000000000000000000000' where cd_security_class_name = 'MAINTAIN_REG_13';
update caps.security_class set  txt_security_class_profil='00000000000000000000000000000000000000000000100000000000000000000000000000000000000000000' where cd_security_class_name = 'MAINTAIN_REG_14';
update caps.security_class set  txt_security_class_profil='00000000000000000000000000000000000000000000010000000000000000000000000000000000000000000' where cd_security_class_name = 'MAINTAIN_REG_15';
update caps.security_class set  txt_security_class_profil='00000000000000000000000000000000000000000000001000000000000000000000000000000000000000000' where cd_security_class_name = 'MAINTAIN_REG_16';
update caps.security_class set  txt_security_class_profil='00000000000000000000000000000000000000000000000100000000000000000000000000000000000000000' where cd_security_class_name = 'MAINTAIN_REG_17';
update caps.security_class set  txt_security_class_profil='000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001' where cd_security_class_name = 'MAINTAIN_REG_99';
update caps.security_class set  txt_security_class_profil='00000000000000000000000010000000000000000000000000000000000000000000000000000000000000001' where cd_security_class_name = 'MES_PROG_ASST';
update caps.security_class set  txt_security_class_profil='100000101000000000000000001100000000000000000000011111011111011000000000000001000000000000' where cd_security_class_name = 'REGNL_ACCT_MGMT';
update caps.security_class set  txt_security_class_profil='000000001000000000000000001100000000000000000000011111011111011000000000000010000000000000' where cd_security_class_name = 'REGNL_ACCT_STF';
update caps.security_class set  txt_security_class_profil='001000101011111100000000110000000000000000000000101001001000100000000000000100000000000000' where cd_security_class_name = 'REGNL_SS_STAFF';
update caps.security_class set  txt_security_class_profil='100001000000010000000000000011000000000000000000000000000000000000000000000000010000000000' where cd_security_class_name = 'REG_FAM_IND_MGT';
update caps.security_class set  txt_security_class_profil='000000000000000000000000000011000000000000000000000000000000000000000000000000100000000000' where cd_security_class_name = 'REG_FAM_IND_STF';
update caps.security_class set  txt_security_class_profil='101011111111111110100010111111111111111111111111111111111111111101000000000000000000000000' where cd_security_class_name = 'SHINES_STAFF';
update caps.security_class set  txt_security_class_profil='00000000000000000001110000000000000000000000000010000000000000000000001000000000000000000' where cd_security_class_name = 'SS_ADMIN_STAFF';
update caps.security_class set  txt_security_class_profil='000000001000010000000000000000000000000000000000001001001000000000000000000000000100000000' where cd_security_class_name = 'STATE_OFC_CONS';
update caps.security_class set  txt_security_class_profil='10000000000000000000000000000000000000000000000000100100100000000000000000000000001000000' where cd_security_class_name = 'STATE_OFC_MGMT';
update caps.security_class set  txt_security_class_profil='101000101011011100000000110000000000000000000000101001101000100000000100000000000000000000' where cd_security_class_name = 'SUPERVISOR';
update caps.security_class set  txt_security_class_profil='11101111111111111110001111111111111111111111111111111111111111111000000000000000000000000' where cd_security_class_name = 'SYS_ADMIN';
update caps.security_class set  txt_security_class_profil='001000101011011100000000110000000000000000000000101001101000100000001000000000000000000000' where cd_security_class_name = 'UNIT_TEAM_LEAD';


--update principal case history so that it won't show for restrict event profile
update caps.metaphor
set txt_filter_path = 'gov.georgia.dhr.dfcs.sacwis.web.metaphor.RestrictEventShowTab'
where id_tab = 1430;

insert into caps.schema_version (id_schema_version, application_version, comments)
                         values (181, 'SacwisRev2', 'static updates');                          
commit;
