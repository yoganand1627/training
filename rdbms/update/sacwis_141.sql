
-- Standard Alter Table SQL

ALTER TABLE CAPS.RELATIVE_CARE_ASSMT ADD CD_CAREGIVER_TYPE VARCHAR2(1)     NULL
;
ALTER TABLE CAPS.RELATIVE_CARE_ASSMT ADD TXT_NON_RELATIVES VARCHAR2(300)     NULL
;

{ call dbms_utility.compile_schema('CAPS') };
{ call dbms_utility.compile_schema('CAPSBAT') };
{ call dbms_utility.compile_schema('CAPSON') };
{ call dbms_utility.compile_schema('OPERATOR') };

-- change STGAP00001816
UPDATE CAPS.CODES_TABLES SET CODE= 'INQ', DECODE= 'Inquiry' WHERE CODE_TYPE= 'CFAHMSTA' AND CODE='AINQ' ;
UPDATE CAPS.CODES_TABLES SET CODE= 'APP', DECODE= 'Applicant (Pre-Service Training)' WHERE CODE_TYPE= 'CFAHMSTA' AND CODE='BAPP' ;
UPDATE CAPS.CODES_TABLES SET CODE= 'PFA', DECODE= 'Pending Full Approval' WHERE CODE_TYPE= 'CFAHMSTA' AND CODE='CPFA' ;
UPDATE CAPS.CODES_TABLES SET CODE= 'PSA', DECODE= 'Pending Special Approval' WHERE CODE_TYPE= 'CFAHMSTA' AND CODE='DPSA' ;
UPDATE CAPS.CODES_TABLES SET CODE= 'PTA', DECODE= 'Pending Temporary Approval' WHERE CODE_TYPE= 'CFAHMSTA'  AND CODE='EPTA';
UPDATE CAPS.CODES_TABLES SET CODE= 'AFA', DECODE= 'Approved (Full) - Active' WHERE CODE_TYPE= 'CFAHMSTA'  AND CODE='FAFA';
UPDATE CAPS.CODES_TABLES SET CODE= 'ASA', DECODE= 'Approved (Special) - Active' WHERE CODE_TYPE= 'CFAHMSTA' AND CODE='GASA';
UPDATE CAPS.CODES_TABLES SET CODE= 'ATA', DECODE= 'Approved (Temp) - Active' WHERE CODE_TYPE= 'CFAHMSTA' AND CODE='HATA';
UPDATE CAPS.CODES_TABLES SET CODE= 'PCL', DECODE= 'Pending Closure' WHERE CODE_TYPE= 'CFAHMSTA' AND CODE='IPCL';
UPDATE CAPS.CODES_TABLES SET CODE= 'CSD', DECODE= 'Closed' WHERE CODE_TYPE= 'CFAHMSTA' AND CODE='JCSD';
UPDATE CAPS.CODES_TABLES SET CODE= 'WTL', DECODE= 'Waitlist' WHERE CODE_TYPE= 'CFAHMSTA' AND CODE='KWTL';

-- change STGAP00001817
INSERT INTO CAPS.CODES_TABLES (code_type,code,DECODE) VALUES ('CASMTRES','APP','Approved');
INSERT INTO CAPS.CODES_TABLES(code_type,code,DECODE)VALUES ('CASMTRES','UNA','Unapproved');
INSERT INTO CAPS.CODES_TABLES(code_type,code,DECODE) VALUES ('CASMTRES','AWC','Approved with conditions');
INSERT INTO CAPS.CODES_TABLES(code_type,code,DECODE) VALUES ('CASMTRES','PFV','Pending further verification');
INSERT INTO CAPS.CODES_TABLES(code_type,code,DECODE) VALUES ('CASMTRES','FAW','Family withdrew');

-- change STGAP00001818
INSERT INTO CAPS.MESSAGE (nbr_message, txt_message_name, txt_message, cd_source, cd_presentation, ind_batch) VALUES (60213, 'MSG_SVC_TCM_ELIG', 'Eligibility is required.', '540', '720', 'N');
INSERT INTO CAPS.MESSAGE (nbr_message, txt_message_name, txt_message, cd_source, cd_presentation, ind_batch) VALUES (60214, 'MSG_SVC_TCM_ELIG_PROG', 'Please select the eligible program.', '540', '730', 'N');
INSERT INTO CAPS.MESSAGE (nbr_message, txt_message_name, txt_message, cd_source, cd_presentation, ind_batch) VALUES (60215, 'MSG_SVC_TCM_SVC', 'Please select the services provided.', '540', '730', 'N');
INSERT INTO CAPS.MESSAGE (nbr_message, txt_message_name, txt_message, cd_source, cd_presentation, ind_batch) VALUES (60216, 'MSG_SVC_TCM_DOB', 'Please enter the client''s date of birth on the Person Detail page.', '560', '750', 'N');
INSERT INTO CAPS.MESSAGE (nbr_message, txt_message_name, txt_message, cd_source, cd_presentation, ind_batch) VALUES (60217, 'MSG_SVC_TCM_ID', 'CRS or Member number is required.', '560', '750', 'N');
INSERT INTO CAPS.MESSAGE (nbr_message, txt_message_name, txt_message, cd_source, cd_presentation, ind_batch) VALUES (60218, 'MSG_SVC_TCM_EXISTS', 'A TCM claim has been recorded for the selected client for the same billing month.  Please save as a normal Contact.', '560', '750', 'N');

-- change STGAP00001819
INSERT INTO CAPS.CODES_TABLES(code_type,code,DECODE) VALUES ('CINITSUP','ERR','Enhanced Relative Rate');
INSERT INTO CAPS.CODES_TABLES(code_type,code,DECODE) VALUES ('CINITSUP','RFS','Relative Foster Home');
INSERT INTO CAPS.CODES_TABLES(code_type,code,DECODE) VALUES ('CINITSUP','SUG','Subsidized Guardianship');
INSERT INTO CAPS.CODES_TABLES(code_type,code,DECODE) VALUES ('CINITSUP','ESG','Enhanced Subsidized Guardianship');
INSERT INTO CAPS.CODES_TABLES(code_type,code,DECODE) VALUES ('CINITSUP','RCS','Relative Care Subsidy');
INSERT INTO CAPS.CODES_TABLES(code_type,code,DECODE) VALUES ('CINITSUP','ERC','Enhanced Relative Care Subsidy');
INSERT INTO CAPS.CODES_TABLES(code_type,code,DECODE) VALUES ('CINITSUP','TAN','TANF');
INSERT INTO CAPS.CODES_TABLES(code_type,code,DECODE) VALUES ('CINITSUP','NON','NONE');
INSERT INTO CAPS.CODES_TABLES(code_type,code,DECODE) VALUES ('CINITSUP','NSG','Non-Relative Subsidized Guardianship');
INSERT INTO CAPS.CODES_TABLES(code_type,code,DECODE) VALUES ('CINITSUP','NEG','Non-Relative Enhanced Subsidized Guardianship');

-- change STGAP00001820
INSERT INTO CAPS.CODES_TABLES(code_type,code,DECODE) VALUES ('CPRNTYP','PRC','Primary Caregiver');
INSERT INTO CAPS.CODES_TABLES(code_type,code,DECODE) VALUES ('CPRNTYP','CHP','Child to be Placed');
INSERT INTO CAPS.CODES_TABLES(code_type,code,DECODE) VALUES ('CPRNTYP','HOM','Home Member');

-- change STGAP00001821
insert into caps.task values('9525',SYSDATE,NULL,'ASM',NULL,NULL,'SUB','CPS','CSUB10C',NULL,1,1,NULL,1,NULL,0,0,0,1,NULL,'Relative Care Assessment','CASE_CASESEARCH','PLACEMENT_EVENTLIST','RELATIVE_CARE_ASSESSMENT','/subcare/RelativeCareAssessment/displayRelativeCareAssessment',2,1,0,0);

-- change STGAP00001822
insert into caps.metaphor values(1559,'/workload/EventSearch/displayEventList','RELATIVE_CARE_ASSESSMENT','Relative Care Assessment',NULL,NULL,NULL,SYSDATE);

-- change STGAP00001823
INSERT INTO CAPS.MESSAGE (nbr_message, txt_message_name, txt_message, cd_source, cd_presentation, ind_batch) VALUES (60219, 'MSG_RCA_ICPC_STATE', 'Selection of State is required for ICPC Relative Care Assessment.', '500', '700', 'N');
INSERT INTO CAPS.MESSAGE (nbr_message, txt_message_name, txt_message, cd_source, cd_presentation, ind_batch) VALUES (60220, 'MSG_RCA_DFCS_COUNT', 'Selection of County is required for DFCS Agency Staff Relative Care Assessment.', '500', '700', 'N');
INSERT INTO CAPS.MESSAGE (nbr_message, txt_message_name, txt_message, cd_source, cd_presentation, ind_batch) VALUES (60221, 'MSG_RCA_CCFA_SEL', 'Selection of County and Resource is required for CCFA Provider Relative Care Assessment.', '500', '700', 'N');
INSERT INTO CAPS.MESSAGE (nbr_message, txt_message_name, txt_message, cd_source, cd_presentation, ind_batch) VALUES (60222, 'MSG_RCA_RES_COUNT', 'Selection of County is required to perform resource search.', '500', '700', 'N');
INSERT INTO CAPS.MESSAGE (nbr_message, txt_message_name, txt_message, cd_source, cd_presentation, ind_batch) VALUES (60223, 'MSG_RCA_PERS_REQ', 'A minimum of one person is required.', '500', '700', 'N');
INSERT INTO CAPS.MESSAGE (nbr_message, txt_message_name, txt_message, cd_source, cd_presentation, ind_batch) VALUES (60224, 'MSG_RCA_REL_FOST_REF', 'Please note date potential Relative foster home referred to Resource Development.', '500', '700', 'N');
INSERT INTO CAPS.MESSAGE (nbr_message, txt_message_name, txt_message, cd_source, cd_presentation, ind_batch) VALUES (60225, 'MSG_RCA_REL_SUP_DATE', 'Please enter date Relative support options discussed.', '500', '700', 'N');
INSERT INTO CAPS.MESSAGE (nbr_message, txt_message_name, txt_message, cd_source, cd_presentation, ind_batch) VALUES (60226, 'MSG_RCA_INIT_SUPP', 'If relative is willing to accept child, Initial Choice of Support is required.', '500', '700', 'N');
INSERT INTO CAPS.MESSAGE (nbr_message, txt_message_name, txt_message, cd_source, cd_presentation, ind_batch) VALUES (60227, 'MSG_RCA_PLACE_AGR', 'If relative is willing to accept child, Placement Agreement form signature date is required.', '500', '700', 'N');
INSERT INTO CAPS.MESSAGE (nbr_message, txt_message_name, txt_message, cd_source, cd_presentation, ind_batch) VALUES (60228, 'MSG_RCA_APRV_SUP_NOT_DISC', 'If the Assessment is approved and relative support options have not been discussed, comments are required.', '500', '700', 'N');
INSERT INTO CAPS.MESSAGE (nbr_message, txt_message_name, txt_message, cd_source, cd_presentation, ind_batch) VALUES (60229, 'MSG_RCA_APRV_COMMENTS_REQ', 'If the Assessment is approved and the relative is not willing to accept the child, comments are required.', '500', '700', 'N');
INSERT INTO CAPS.MESSAGE (nbr_message, txt_message_name, txt_message, cd_source, cd_presentation, ind_batch) VALUES (60230, 'MSG_RCA_NON_REL_COMNT', 'For non-relatives, record degree of relationship and establish the existing relationship and bond.', '500', '700', 'N');

-- change STGAP00001826

insert into caps.MESSAGE(NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) values 
(60231, 'MSG_CMN_YDP_DATE_TAKEN_PASSED', 'Date exam taken is after day exam passed.', 700, 500, 'N');

insert into caps.MESSAGE(NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) values 
(60232, 'MSG_ARC_CONSTR_GPA', 'Please enter a valid GPA number with up to 3 decimal digits.', 700, 500, 'N');

insert into caps.schema_version (id_schema_version, application_version, comments)
                         values (142, 'SacwisRev2', 'static updates, schema changes');                      
commit;                         
