
-- Standard Alter Table SQL

ALTER TABLE CAPS.FCE_ELIGIBILITY ADD IND_30_ONE_THIRD_TEST_ELGBLTY VARCHAR2(1)     NULL
;
ALTER TABLE CAPS.FCE_ELIGIBILITY ADD IND_30_1_3_CHILD_TEST_ELGBLTY VARCHAR2(1)     NULL
;
ALTER TABLE CAPS.FCE_ELIGIBILITY ADD IND_CTNBL_RES_CHILD_ELGBLTY VARCHAR2(1)     NULL
;
ALTER TABLE CAPS.FCE_ELIGIBILITY ADD IND_GROSS_INC_CEILING_ELGBLTY VARCHAR2(1)     NULL
;
ALTER TABLE CAPS.FCE_ELIGIBILITY ADD IND_GROSS_INC_CHILD_ELGBLTY VARCHAR2(1)     NULL
;
ALTER TABLE CAPS.FCE_ELIGIBILITY ADD IND_SON_CHILD_TEST_ELGBLTY VARCHAR2(1)     NULL
;
ALTER TABLE CAPS.FCE_ELIGIBILITY ADD IND_STD_OF_NEED_TEST_ELGBLTY VARCHAR2(1)     NULL
;

-- Alter Trigger SQL
/
CREATE OR REPLACE TRIGGER CAPS.TAUR_CPRS_EVENT
AFTER UPDATE
ON CAPS.EVENT
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
DECLARE
  SND_FLAG VARCHAR2(1);
  xCD_COUNTY VARCHAR2(3);
  xCD_STAGE  VARCHAR2(3);
BEGIN
    -- DBMS_OUTPUT.put_line('IN TAUR_CPRS_EVENT trigger');
    SND_FLAG := 'N';
    xCD_STAGE := '   ';
    IF ( (:NEW.ID_CASE IS NOT NULL AND :NEW.ID_CASE > 0 ) 
       AND (:NEW.CD_EVENT_TYPE='CSP' OR :NEW.CD_EVENT_TYPE='PLA' OR
             (:NEW.CD_EVENT_TYPE='PLN' AND :NEW.CD_TASK='7065'))
       AND
	    (
		   (:NEW.CD_EVENT_STATUS='APRV' AND 
            (:OLD.CD_EVENT_STATUS IS NULL OR :OLD.CD_EVENT_STATUS <> 'APRV')
           AND(:NEW.CD_EVENT_TYPE='PLA' OR
             (:NEW.CD_EVENT_TYPE='PLN' AND :NEW.CD_TASK='7065')))
           OR (:NEW.CD_EVENT_STATUS='COMP' AND :OLD.CD_EVENT_STATUS <> 'COMP'
		     AND :NEW.CD_EVENT_TYPE='CSP')))
    THEN
	-- DBMS_OUTPUT.put_line('TAUR_CPRS_EVENT - this event is interesting');
        SELECT CD_STAGE
        INTO xCD_STAGE
        FROM STAGE S
        WHERE S.ID_STAGE = :NEW.ID_EVENT_STAGE;
        IF (xCD_STAGE = 'SUB' OR xCD_STAGE = 'FSU')
        THEN
            SND_FLAG := 'Y';
        END IF;
    END IF;
    -- DBMS_OUTPUT.put_line('SND_FLAG is ' || SND_FLAG);
    IF (SND_FLAG = 'Y')
    THEN
       SELECT CD_CASE_COUNTY
       INTO   xCD_COUNTY
       FROM   CAPS_CASE C
       WHERE  C.ID_CASE = :NEW.ID_CASE;
       IF (xCD_COUNTY IS NOT NULL)
       THEN
          UPDATE_CASEPLAN (xCD_COUNTY, :NEW.ID_CASE);  
       END IF;    
    END IF;
	
    EXCEPTION
    	WHEN OTHERS THEN
		    -- DBMS_OUTPUT.put_line(SQLCODE);
    		IF SQL%NOTFOUND THEN
			-- DBMS_OUTPUT.put_line('KABOOM - record not found');
    			xCD_COUNTY := NULL;
		END IF;
END;
/
/
CREATE OR REPLACE TRIGGER CAPS.TAIR_CPRS_STAGE
AFTER INSERT
ON CAPS.STAGE
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
DECLARE
  UPD_FLAG VARCHAR2(1);
  xCD_COUNTY VARCHAR2(3);
BEGIN
    UPD_FLAG := 'N';
    IF (:NEW.CD_STAGE='SUB' AND :NEW.IND_STAGE_CLOSE='N')
    THEN
      UPD_FLAG := 'Y';
    END IF;
    IF (UPD_FLAG = 'Y')
    THEN
	   SELECT CD_CASE_COUNTY
       INTO   xCD_COUNTY
       FROM   CAPS_CASE C
       WHERE  C.ID_CASE = :NEW.ID_CASE;
       IF (xCD_COUNTY IS NOT NULL)
       THEN
          UPDATE_CASEPLAN (xCD_COUNTY, :NEW.ID_CASE);  
       END IF;     
    END IF;
	
    EXCEPTION
    	WHEN OTHERS THEN
		    -- DBMS_OUTPUT.put_line(SQLCODE);
    		IF SQL%NOTFOUND THEN
    			xCD_COUNTY := NULL;
		END IF;
END;
/

alter table caps.emp_sec_class_link disable constraint FK_EXP_SEC_CLASS_LINK;    

delete from caps.security_class;

insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('CONTRACTED_CBO',sysdate,'000000000011000001000010000111111111111111111101001101000100000000000000000010100000000000','N',2071);
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('CONTRACT_LEAD',sysdate,'000001010011000001000110000111111111111111111100000101100100000000000000000000010000000000','N',2071);
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('COUNTY_MGMNT',sysdate,'111001010111110100000110111100000000000000000001001101101100000000000100000000000000000000','N',2071);
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('DJJ_AFCARS',sysdate,'001000000011000000000000011000000000000000000000000000000000000010000000000000000000000000','N',2071);
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('DPTY_CNTY_DRCTR',sysdate,'111000000111011000000110000000000000000000000001001101000000000000001000000000000000000000','N',2071);
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('FSCL_SVC_ST_STF',sysdate,'110101000000010000000101100000000000000000000001001011010000000000000000000001000000000000','N',2071);
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
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('REGNL_ACCT_MGMT',sysdate,'110001010000010000000001100111111111111111111111011011011011000000000000100000000000000000','N',2071);
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('REGNL_ACCT_STF',sysdate,'000000001000000000000001101111111111111111111111111111011111000000000000000010000000000000','N',2071);
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('REGNL_SS_STAFF',sysdate,'001001010011100000000011100000000000000000000001001001010100000000000010000000000000000000','N',2071);
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('REG_FAM_IND_MGT',sysdate,'110011010000010000000100011000000000000000000000000000000000000000000000001000000000000000','N',2071);
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('REG_FAM_IND_STF',sysdate,'000000000000000000000000011000000000000000000000000000000000000000000000010000000000000000','N',2071);
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('SHINES_STAFF',sysdate,'111111111111111100011111111111111111111111111111111111111111111111111111111111111000000000','N',2071);
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('SS_ADMIN_STAFF',sysdate,'000000000000000011100000000000000000000000000000000000000000000000010000000000000000000000','N',2071);
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('STATE_OFC_CONS',sysdate,'000000010011000000000010000000000000000000000001001001000100000000000000000100000000000000','N',2071);
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('STATE_OFC_MGMT',sysdate,'100000010000000000000000000000000000000000000001001000000000000000000000000010000000000000','N',2071);
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('SYS_ADMIN',sysdate,'111111111111111100011111111111111111111111111111111111111111111111111111111111111000000000','N',2071);
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('UNIT_TEAM_LEAD',sysdate,'001001010011100000000110000000000000000000000001001001000100000001000000000000000000000000','N',2071);
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('CASE_MANAGER',sysdate,'001000000011000000000010000000000000000000000001001001000100000100000000000000000000000000','Y',2071);
insert into caps.security_class (cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) values ('SUPERVISOR',sysdate,'101001110011100000000110000000000000000000000001001001000100000000100000000000000000000000','N',2071);

update caps.emp_sec_class_link escl
set escl.cd_security_class_name = 'CASE_MANAGER'
where escl.cd_security_class_name not in
(select sc.cd_security_class_name from caps.security_class sc);

alter table caps.emp_sec_class_link enable constraint FK_EXP_SEC_CLASS_LINK;

-- SACWISIFC CHANGES -- Attention Charles
ALTER TABLE SACWISIFC.MEDICAID_COA_INBOUND ADD NBR_CRS_ID NUMBER(9)     NULL
;
ALTER TABLE SACWISIFC.MEDICAID_COA_INBOUND ADD ID_MEDICAID_COAREQ_OUTBOUND NUMBER(16)     NULL
;

{ call dbms_utility.compile_schema('CAPS') };
{ call dbms_utility.compile_schema('CAPSBAT') };
{ call dbms_utility.compile_schema('CAPSON') };
{ call dbms_utility.compile_schema('OPERATOR') };
{ call dbms_utility.compile_schema('SACWISIFC') };

-- change STGAP00003000
DELETE FROM caps.stage_prog
WHERE cd_stage_prog_program IN ( 'CCL','APS','RCL','AFC');

DELETE FROM caps.stage_prog
WHERE cd_stage_prog_stage IN ('FRE','ARF','PAL');

DELETE FROM caps.stage_prog
WHERE cd_stage_prog_open IN ('FRE','ARF','PAL','AOC','FC');

-- change STGAP00003006
update caps.codes_tables
set dt_end = to_date('01/01/2006','MM/DD/YYYY')
where code_type = 'CEVNTTYP'
and code in ('LOC','TMR');

-- change STGAP00003007
update caps.codes_tables
set dt_end = to_date ('01/01/2006','MM/DD/YYYY')
where code_type = 'CSECATTR'
and code in ('AF','BA','BB','HH','HI','HQ','HW','HX','PB');

update caps.codes_tables
set decode = 'Maintain State Office (99)'
where code_type = 'CSECATTR'
and code = 'DO';

update caps.codes_tables
set decode = 'Contracted Community Based Org'
where code_type = 'CSECATTR'
and code = 'HU';

update caps.codes_tables
set decode = 'Contract Lead Agency Provider'
where code_type = 'CSECATTR'
and code = 'HV';

-- change STGAP00003027
INSERT INTO CAPS.MESSAGE (ID_MESSAGE, NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) VALUES (0, 60338, 'MSG_PLCMT_AFCAR_QUESTN_REQ', 'AFCARS discharge question is required when a placement removal reason is entered and the placement type is Actual', '500', '700', 'N');
INSERT INTO CAPS.MESSAGE (ID_MESSAGE, NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) VALUES (0, 60339, 'MSG_PLCMT_AFCAR_FLD_REQ', 'If AFCARS discharge is yes, the AFCARS Discharge Date and AFCARS Discharge Reason are required.', '500', '700', 'N');

-- change STGAP00003035
Update caps.codes_tables
set dt_end  = to_date('01/01/2006','MM/DD/YYYY')
where code_type = 'CSTATE'
and code in ('AA','AE','AP','XA','XB','ZA','ZB','ZD','ZE','XF','XG','ZF','ZC');

-- change STGAP00003043
--put new service auths for case entry in
UPDATE caps.metaphor
SET txt_tab_url = '/workload/EventSearch/displayEventList',
txt_tab_constant = 'SERVICE_AUTH_FOR_CASE_EVENTLIST',
txt_tab = 'Service Auth for Case'
WHERE id_tab = 1240;

update caps.metaphor
set txt_tab = 'Visitation Plan for Case'
where id_tab = 1395;

--insert into task... Service Authorization for Case  - ONG, FCC, FCF, PFC, ADO, PAD, INV
INSERT INTO caps.TASK(cd_task, dt_last_update, cd_task_event_type, cd_task_prior, cd_task_stage, cd_task_stage_program, ind_task_event_create, ind_task_event_navig,
ind_task_multiple_instance, ind_task_new_using, ind_task_nu_across_case, ind_task_rtrv_prior_stage, ind_task_show_in_list, txt_task_decode, txt_1st_tab,
txt_2nd_tab, txt_3rd_tab, txt_event_detail_url, ind_task_code_prefer, ind_task_new_case_todo_enable, ind_task_force_event_link, ind_stage_closure)
VALUES ('2315',SYSDATE,'AUT','2310','INV','CPS',1,1,1,1,1,0,1,'Service Auth for Case','CASE_CASESEARCH','SERVICE_AUTHORIZATION_EVENTLIST','SERVICE_AUTH_FOR_CASE_EVENTLIST','/financials/ServiceAuth/accessServiceAuth',3,1,0,0);

INSERT INTO caps.TASK(cd_task, dt_last_update, cd_task_event_type, cd_task_prior, cd_task_stage, cd_task_stage_program, ind_task_event_create, ind_task_event_navig,
ind_task_multiple_instance, ind_task_new_using, ind_task_nu_across_case, ind_task_rtrv_prior_stage, ind_task_show_in_list, txt_task_decode, txt_1st_tab,
txt_2nd_tab, txt_3rd_tab, txt_event_detail_url, ind_task_code_prefer, ind_task_new_case_todo_enable, ind_task_force_event_link, ind_stage_closure)
VALUES ('7110',SYSDATE,'AUT','7100','FPR','CPS',1,1,1,1,1,0,1,'Service Auth for Case','CASE_CASESEARCH','SERVICE_AUTHORIZATION_EVENTLIST','SERVICE_AUTH_FOR_CASE_EVENTLIST','/financials/ServiceAuth/accessServiceAuth',3,1,0,0);

INSERT INTO caps.TASK(cd_task, dt_last_update, cd_task_event_type, cd_task_prior, cd_task_stage, cd_task_stage_program, ind_task_event_create, ind_task_event_navig,
ind_task_multiple_instance, ind_task_new_using, ind_task_nu_across_case, ind_task_rtrv_prior_stage, ind_task_show_in_list, txt_task_decode, txt_1st_tab,
txt_2nd_tab, txt_3rd_tab, txt_event_detail_url, ind_task_code_prefer, ind_task_new_case_todo_enable, ind_task_force_event_link, ind_stage_closure)
VALUES ('8535',SYSDATE,'AUT','8530','ADO','CPS',1,1,1,1,1,0,1,'Service Auth for Case','CASE_CASESEARCH','SERVICE_AUTHORIZATION_EVENTLIST','SERVICE_AUTH_FOR_CASE_EVENTLIST','/financials/ServiceAuth/accessServiceAuth',3,1,0,0);

INSERT INTO caps.TASK(cd_task, dt_last_update, cd_task_event_type, cd_task_prior, cd_task_stage, cd_task_stage_program, ind_task_event_create, ind_task_event_navig,
ind_task_multiple_instance, ind_task_new_using, ind_task_nu_across_case, ind_task_rtrv_prior_stage, ind_task_show_in_list, txt_task_decode, txt_1st_tab,
txt_2nd_tab, txt_3rd_tab, txt_event_detail_url, ind_task_code_prefer, ind_task_new_case_todo_enable, ind_task_force_event_link, ind_stage_closure)
VALUES ('4195',SYSDATE,'AUT','4190','FSU','CPS',1,1,1,1,1,0,1,'Service Auth for Case','CASE_CASESEARCH','SERVICE_AUTHORIZATION_EVENTLIST','SERVICE_AUTH_FOR_CASE_EVENTLIST','/financials/ServiceAuth/accessServiceAuth',3,1,0,0);

INSERT INTO caps.TASK(cd_task, dt_last_update, cd_task_event_type, cd_task_prior, cd_task_stage, cd_task_stage_program, ind_task_event_create, ind_task_event_navig,
ind_task_multiple_instance, ind_task_new_using, ind_task_nu_across_case, ind_task_rtrv_prior_stage, ind_task_show_in_list, txt_task_decode, txt_1st_tab,
txt_2nd_tab, txt_3rd_tab, txt_event_detail_url, ind_task_code_prefer, ind_task_new_case_todo_enable, ind_task_force_event_link, ind_stage_closure)
VALUES ('9030',SYSDATE,'AUT','9020','PAD','CPS',1,1,1,1,1,0,1,'Service Auth for Case','CASE_CASESEARCH','SERVICE_AUTHORIZATION_EVENTLIST','SERVICE_AUTH_FOR_CASE_EVENTLIST','/financials/ServiceAuth/accessServiceAuth',3,1,0,0);

INSERT INTO caps.TASK(cd_task, dt_last_update, cd_task_event_type, cd_task_prior, cd_task_stage, cd_task_stage_program, ind_task_event_create, ind_task_event_navig,
ind_task_multiple_instance, ind_task_new_using, ind_task_nu_across_case, ind_task_rtrv_prior_stage, ind_task_show_in_list, txt_task_decode, txt_1st_tab,
txt_2nd_tab, txt_3rd_tab, txt_event_detail_url, ind_task_code_prefer, ind_task_new_case_todo_enable, ind_task_force_event_link, ind_stage_closure)
VALUES ('2010',SYSDATE,'AUT','2000','PFC','CPS',1,1,1,1,1,0,1,'Service Auth for Case','CASE_CASESEARCH','SERVICE_AUTHORIZATION_EVENTLIST','SERVICE_AUTH_FOR_CASE_EVENTLIST','/financials/ServiceAuth/accessServiceAuth',3,1,0,0);

INSERT INTO caps.TASK(cd_task, dt_last_update, cd_task_event_type, cd_task_prior, cd_task_stage, cd_task_stage_program, ind_task_event_create, ind_task_event_navig,
ind_task_multiple_instance, ind_task_new_using, ind_task_nu_across_case, ind_task_rtrv_prior_stage, ind_task_show_in_list, txt_task_decode, txt_1st_tab,
txt_2nd_tab, txt_3rd_tab, txt_event_detail_url, ind_task_code_prefer, ind_task_new_case_todo_enable, ind_task_force_event_link, ind_stage_closure)
VALUES ('3025',SYSDATE,'AUT','3020','SUB','CPS',1,1,1,1,1,0,1,'Service Auth for Case','CASE_CASESEARCH','SERVICE_AUTHORIZATION_EVENTLIST','SERVICE_AUTH_FOR_CASE_EVENTLIST','/financials/ServiceAuth/accessServiceAuth',3,1,0,0);

--udpate task Visitation Plan for Case - ADO
update caps.task
set txt_task_decode = 'Visitation Plan'
where cd_task in ('3190','8690','4390','7250');

update caps.task
set txt_task_decode = 'Visitation Plan for Case',
ind_task_nu_across_case = '1'
where cd_task in ('3195','8695');

--insert into task WTLP and WTLP for Case - ADO
INSERT INTO caps.TASK(cd_task, dt_last_update, cd_task_event_type, cd_task_prior, cd_task_stage, cd_task_stage_program, ind_task_event_create, ind_task_event_navig,
ind_task_multiple_instance, ind_task_new_using, ind_task_nu_across_case, ind_task_rtrv_prior_stage, ind_task_show_in_list, txt_task_decode, txt_1st_tab,
txt_2nd_tab, txt_3rd_tab, txt_event_detail_url, ind_task_code_prefer, ind_task_new_case_todo_enable, ind_task_force_event_link, ind_stage_closure)
VALUES ('8580',SYSDATE, 'WTL',NULL,'ADO','CPS',1,1,1,1,0,0,1,'WTLP','CASE_CASESEARCH','CHILD_PLANS_EVENTLIST','WTLP_EVENTLIST','/subcare/WTLP/displayWTLP',3,1,0,0);

INSERT INTO caps.TASK(cd_task, dt_last_update, cd_task_event_type, cd_task_prior, cd_task_stage, cd_task_stage_program, ind_task_event_create, ind_task_event_navig,
ind_task_multiple_instance, ind_task_new_using, ind_task_nu_across_case, ind_task_rtrv_prior_stage, ind_task_show_in_list, txt_task_decode, txt_1st_tab,
txt_2nd_tab, txt_3rd_tab, txt_event_detail_url, ind_task_code_prefer, ind_task_new_case_todo_enable, ind_task_force_event_link, ind_stage_closure)
VALUES ('8585',SYSDATE, 'WTL','8580','ADO','CPS',1,1,1,1,1,0,1,'WTLP for Case','CASE_CASESEARCH','CHILD_PLANS_EVENTLIST','WTLP_FOR_CASE_EVENTLIST','/subcare/WTLP/displayWTLP',3,1,0,0);

--insert into task Legal Action - PAD
INSERT INTO caps.TASK(cd_task, dt_last_update, cd_task_event_type, cd_task_prior, cd_task_stage, cd_task_stage_program, ind_task_event_create, ind_task_event_navig,
ind_task_multiple_instance, ind_task_new_using, ind_task_nu_across_case, ind_task_rtrv_prior_stage, ind_task_show_in_list, txt_task_decode, txt_1st_tab,
txt_2nd_tab, txt_3rd_tab, txt_event_detail_url, ind_task_code_prefer, ind_task_new_case_todo_enable, ind_task_force_event_link, ind_stage_closure)
VALUES ('9070',SYSDATE, 'LEG',NULL,'PAD','CPS',1,1,1,1,0,0,1,'Legal Actions','CASE_CASESEARCH','LEGAL_EVENTLIST','LEGAL_ACTIONS_EVENTLIST','/subcare/LegalActions/displayLegalActions',3,1,0,0);

update caps.task
set txt_event_detail_url = '/subcare/ChildPlan/displayFccpChild'
where cd_task = '3170';

delete from caps.task
where cd_task in ('8860','9060');

--placement and placement for case in PFC
Insert into caps.Task
   (CD_TASK, CD_TASK_EVENT_TYPE, CD_TASK_LIST_WINDOW, CD_TASK_STAGE, CD_TASK_STAGE_PROGRAM, CD_TASK_TOP_WINDOW, IND_TASK_EVENT_CREATE, IND_TASK_EVENT_NAVIG, IND_TASK_MULTIPLE_INSTANCE, IND_TASK_NEW_USING, IND_TASK_NU_ACROSS_CASE, IND_TASK_RTRV_PRIOR_STAGE, IND_TASK_SHOW_IN_LIST, TXT_TASK_DECODE, TXT_1ST_TAB, TXT_2ND_TAB, TXT_3RD_TAB, TXT_EVENT_DETAIL_URL, IND_TASK_CODE_PREFER, IND_TASK_NEW_CASE_TODO_ENABLE, IND_TASK_FORCE_EVENT_LINK, IND_STAGE_CLOSURE)
 Values
   ('9085',  'PLA', 'CCMN51W', 'PFC', 'CPS', 'CSUB10C', '1', '1', '1', '0', '0', '0', '1', 'Placement', 'CASE_CASESEARCH', 'PLACEMENT_EVENTLIST', 'PLACEMENT_3_EVENTLIST', '/subcare/Placement/displayPlacement', 2, '1', '0', '0');
INSERT INTO caps.TASK
   (CD_TASK, CD_TASK_EVENT_TYPE, CD_TASK_LIST_WINDOW, CD_TASK_PRIOR, CD_TASK_STAGE, CD_TASK_STAGE_PROGRAM, CD_TASK_TOP_WINDOW, IND_TASK_EVENT_CREATE, IND_TASK_EVENT_NAVIG, IND_TASK_MULTIPLE_INSTANCE, IND_TASK_NEW_USING, IND_TASK_NU_ACROSS_CASE, IND_TASK_RTRV_PRIOR_STAGE, IND_TASK_SHOW_IN_LIST, TXT_TASK_DECODE, TXT_1ST_TAB, TXT_2ND_TAB, TXT_3RD_TAB, TXT_EVENT_DETAIL_URL, IND_TASK_CODE_PREFER, IND_TASK_NEW_CASE_TODO_ENABLE, IND_TASK_FORCE_EVENT_LINK, IND_STAGE_CLOSURE)
 VALUES
   ('9086',  'PLA', 'CCMN51W', '9085', 'PFC', 'CPS', 'CSUB10C', '1', '1', '1', '1', '1', '0', '1', 'Placements for Case', 'CASE_CASESEARCH', 'PLACEMENT_EVENTLIST', 'PLACEMENTS_FOR_CASE_EVENTLIST', '/subcare/Placement/displayPlacement', 3, '1', '0', '0');

UPDATE caps.TASK
SET txt_task_decode = 'Foster Care Case Plan Child for Case'
WHERE cd_task = '8670';
   
UPDATE caps.TASK
SET txt_task_decode = 'Foster Care Case Plan Child'
WHERE cd_task = '8660';

--legal action and legal status for PFC
INSERT INTO caps.TASK
   (CD_TASK, CD_TASK_EVENT_TYPE, CD_TASK_LIST_WINDOW, CD_TASK_STAGE, CD_TASK_STAGE_PROGRAM, CD_TASK_TOP_WINDOW, IND_TASK_EVENT_CREATE, IND_TASK_EVENT_NAVIG, IND_TASK_MULTIPLE_INSTANCE, IND_TASK_NEW_USING, IND_TASK_NU_ACROSS_CASE, IND_TASK_RTRV_PRIOR_STAGE, IND_TASK_SHOW_IN_LIST, TXT_TASK_DECODE, TXT_1ST_TAB, TXT_2ND_TAB, TXT_3RD_TAB, TXT_EVENT_DETAIL_URL, IND_TASK_CODE_PREFER, IND_TASK_NEW_CASE_TODO_ENABLE, IND_TASK_FORCE_EVENT_LINK, IND_STAGE_CLOSURE)
 VALUES
   ('2040',  'LES', 'CCMN51W', 'PFC', 'CPS', 'CSUB10C', '1', '1', '1', '0', '0', '0', '1', 'Legal Status', 'CASE_CASESEARCH', 'LEGAL_EVENTLIST', 'LEGAL_STATUS_EVENTLIST', '/subcare/LegalStatus/displayLegalStatus', 3, '1', '0', '0');

INSERT INTO caps.TASK
   (CD_TASK, CD_TASK_EVENT_TYPE, CD_TASK_LIST_WINDOW, CD_TASK_PRIOR, CD_TASK_STAGE, CD_TASK_STAGE_PROGRAM, CD_TASK_TOP_WINDOW, IND_TASK_EVENT_CREATE, IND_TASK_EVENT_NAVIG, IND_TASK_MULTIPLE_INSTANCE, IND_TASK_NEW_USING, IND_TASK_NU_ACROSS_CASE, IND_TASK_RTRV_PRIOR_STAGE, IND_TASK_SHOW_IN_LIST, TXT_TASK_DECODE, TXT_1ST_TAB, TXT_2ND_TAB, TXT_3RD_TAB, TXT_EVENT_DETAIL_URL, IND_TASK_CODE_PREFER, IND_TASK_NEW_CASE_TODO_ENABLE, IND_TASK_FORCE_EVENT_LINK, IND_STAGE_CLOSURE)
 VALUES
   ('2050',  'LES', 'CCMN51W', '2040', 'PFC', 'CPS', 'CSUB10C', '1', '1', '1', '1', '1', '0', '1', 'Legal Status for Case', 'CASE_CASESEARCH', 'LEGAL_EVENTLIST', 'LEGAL_STATUS_FOR_CASE_EVENTLIST', '/subcare/LegalStatus/displayLegalStatus', 3, '1', '0', '0');
   
INSERT INTO caps.TASK
   (CD_TASK, CD_TASK_EVENT_TYPE, CD_TASK_LIST_WINDOW, CD_TASK_STAGE, CD_TASK_STAGE_PROGRAM, CD_TASK_TOP_WINDOW, IND_TASK_EVENT_CREATE, IND_TASK_EVENT_NAVIG, IND_TASK_MULTIPLE_INSTANCE, IND_TASK_NEW_USING, IND_TASK_NU_ACROSS_CASE, IND_TASK_RTRV_PRIOR_STAGE, IND_TASK_SHOW_IN_LIST, TXT_TASK_DECODE, TXT_1ST_TAB, TXT_2ND_TAB, TXT_3RD_TAB, TXT_EVENT_DETAIL_URL, IND_TASK_CODE_PREFER, IND_TASK_NEW_CASE_TODO_ENABLE, IND_TASK_FORCE_EVENT_LINK, IND_STAGE_CLOSURE)
 VALUES
   ('2020',  'LEG', 'CCMN51W', 'PFC', 'CPS', 'CSUB10C', '1', '1', '1', '0', '0', '0', '1', 'Legal Actions', 'CASE_CASESEARCH', 'LEGAL_EVENTLIST', 'LEGAL_ACTIONS_EVENTLIST', '/subcare/LegalActions/displayLegalActions', 2, '1', '0', '0');

INSERT INTO caps.TASK
   (CD_TASK, CD_TASK_EVENT_TYPE, CD_TASK_LIST_WINDOW, CD_TASK_PRIOR, CD_TASK_STAGE, CD_TASK_STAGE_PROGRAM, CD_TASK_TOP_WINDOW, IND_TASK_EVENT_CREATE, IND_TASK_EVENT_NAVIG, IND_TASK_MULTIPLE_INSTANCE, IND_TASK_NEW_USING, IND_TASK_NU_ACROSS_CASE, IND_TASK_RTRV_PRIOR_STAGE, IND_TASK_SHOW_IN_LIST, TXT_TASK_DECODE, TXT_1ST_TAB, TXT_2ND_TAB, TXT_3RD_TAB, TXT_EVENT_DETAIL_URL, IND_TASK_CODE_PREFER, IND_TASK_NEW_CASE_TODO_ENABLE, IND_TASK_FORCE_EVENT_LINK, IND_STAGE_CLOSURE)
 VALUES
   ('2030',  'LEG', 'CCMN51W', '2020', 'PFC', 'CPS', 'CSUB10C', '1', '1', '1', '1', '1', '0', '1', 'Legal Actions for Case', 'CASE_CASESEARCH', 'LEGAL_EVENTLIST', 'LEGAL_ACTIONS_FOR_CASE_EVENTLIST', '/subcare/LegalActions/displayLegalActions', 3, '1', '0', '0');

INSERT INTO caps.TASK
   (CD_TASK, CD_TASK_EVENT_TYPE, CD_TASK_LIST_WINDOW, CD_TASK_STAGE, CD_TASK_STAGE_PROGRAM, CD_TASK_TOP_WINDOW, IND_TASK_EVENT_CREATE, IND_TASK_EVENT_NAVIG, IND_TASK_MULTIPLE_INSTANCE, IND_TASK_NEW_USING, IND_TASK_NU_ACROSS_CASE, IND_TASK_RTRV_PRIOR_STAGE, IND_TASK_SHOW_IN_LIST, TXT_TASK_DECODE, TXT_1ST_TAB, TXT_2ND_TAB, TXT_3RD_TAB, TXT_EVENT_DETAIL_URL, IND_TASK_CODE_PREFER, IND_TASK_NEW_CASE_TODO_ENABLE, IND_TASK_FORCE_EVENT_LINK, IND_STAGE_CLOSURE)
 VALUES
   ('2060',  'MED', 'CCMN51W', 'PFC', 'CPS', 'CSUB10C', '1', '1', '1', '0', '0', '0', '1', 'Medical/Mental Assessment', 'CASE_CASESEARCH', 'PERSON_PERSONLIST', 'MEDICAL_MENTAL_ASSESSMENT_EVENTLIST', '/investigation/MdclMentalAssmt/displayMdclMentalAssmt', 3, '1', '0', '0');


UPDATE caps.TASK
SET txt_2nd_tab = 'PERSON_PERSONLIST', 
txt_3rd_tab = 'MEDICAL_MENTAL_ASSESSMENT_EVENTLIST',
ind_task_code_prefer = '3',
txt_task_decode = 'Medical/Mental Assessment' 
WHERE cd_task_event_type  = 'MED';

UPDATE caps.TASK
SET txt_task_decode = 'Approve Foster Care Child Stage Closure'
WHERE cd_task = '3420';

insert into caps.schema_version (id_schema_version, application_version, comments)
                         values (182, 'SacwisRev2', 'static updates, FCE_ELIGIBILITY columns, CPRS triggers, SACWISIFC update');

commit;

