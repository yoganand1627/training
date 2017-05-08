-- Drop Constraint, Rename and Create Table SQL

CREATE TABLE CAPS.TRAIN_MASTER
(
    TRAIN_GLOBAL   VARCHAR2(15) NOT NULL,
    DT_LAST_UPDATE DATE         NOT NULL
)
TABLESPACE DATA01
LOGGING
STORAGE(BUFFER_POOL DEFAULT)
NOPARALLEL
NOCACHE
;
COMMENT ON TABLE CAPS.TRAIN_MASTER IS
'The TRAIN_MASTER table contains master configuration information used only by Training versions of the application. This table is not referenced in production. This table should have ONE and ONLY ONE ROW in it.'
;
COMMENT ON COLUMN CAPS.TRAIN_MASTER.DT_LAST_UPDATE IS
'Date of insert or last update'
;
GRANT DELETE ON CAPS.TRAIN_MASTER TO CAPSBAT
;
GRANT INSERT ON CAPS.TRAIN_MASTER TO CAPSBAT
;
GRANT SELECT ON CAPS.TRAIN_MASTER TO CAPSBAT
;
GRANT UPDATE ON CAPS.TRAIN_MASTER TO CAPSBAT
;
GRANT DELETE ON CAPS.TRAIN_MASTER TO CAPSON
;
GRANT INSERT ON CAPS.TRAIN_MASTER TO CAPSON
;
GRANT SELECT ON CAPS.TRAIN_MASTER TO CAPSON
;
GRANT UPDATE ON CAPS.TRAIN_MASTER TO CAPSON
;
GRANT SELECT ON CAPS.TRAIN_MASTER TO OPERATOR
;

-- Alter Trigger SQL
/
CREATE OR REPLACE TRIGGER CAPS.TUBR_TRAIN_MASTER
BEFORE UPDATE
ON CAPS.TRAIN_MASTER
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
  :NEW.DT_LAST_UPDATE := SYSDATE;
END;
/
/
CREATE OR REPLACE TRIGGER CAPS.TIBR_TRAIN_MASTER
BEFORE INSERT
ON CAPS.TRAIN_MASTER
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
  :NEW.DT_LAST_UPDATE := SYSDATE;
END;
/

insert into caps.train_master (train_global, dt_last_update) values ('trainme07', sysdate);
commit;


-- change STGAP00005281
truncate table caps.sacwis_command;
truncate table caps.sacwis_audit;

{ call dbms_utility.compile_schema('CAPS') };
{ call dbms_utility.compile_schema('CAPSBAT') };
{ call dbms_utility.compile_schema('CAPSON') };
{ call dbms_utility.compile_schema('OPERATOR') };
{ call dbms_utility.compile_schema('SACWISIFC') };

-- change STGAP00005165
UPDATE CAPS.CODES_TABLES SET DECODE = 'Wendy''s Wonderful Kids' WHERE DECODE = 'Wendys Wonderful Kids' AND CODE = 'WWK' AND CODE_TYPE = 'CADRACC';

-- change STGAP00005167
UPDATE CAPS.MESSAGE SET txt_message='The Referral Date must be on or before the Assessment Completion Date.' WHERE txt_message_name='MSG_REF_ASST_DATE';

-- change STGAP00005170
UPDATE CAPS.MESSAGE SET txt_message='Please enter a special add on rate amount between $.50 and $1.75.' WHERE txt_message_name='MSG_ELEV_PDEM_LIMITS';

-- change STGAP00005172
UPDATE CAPS.MESSAGE SET txt_message = 'Enter either SAT test or ACT test.' 
WHERE txt_message_name = 'MSG_ONE_TEST' AND nbr_message = 60305;

-- change STGAP00005191
UPDATE CAPS.MESSAGE SET txt_message='The Start date and time must be before or the same as the End date and time.' WHERE txt_message_name='SSM_START_BEFORE_SAME_END';
UPDATE CAPS.MESSAGE SET txt_message='Verify Child''s Plan Permanency Goal matches this intended to be permanent placement.' WHERE txt_message_name='MSG_CHILD_INTENDED_PERM';
UPDATE CAPS.MESSAGE SET txt_message='The Placement Type selected does not allow selection of a person.' WHERE txt_message_name='MSG_LIV_ARR_PERSON';
UPDATE CAPS.MESSAGE SET txt_message='The Placement Type you have selected requires a Medicaid address, please select the Medicaid and Plcmt Addr Diff checkbox.' WHERE txt_message_name='MSG_LIV_ARR_MED_ADDR';

-- change STGAP00005217
UPDATE CAPS.MESSAGE SET txt_message='When selecting multiple stages from the Workload page, only Primary assignments can be made. ' WHERE txt_message_name='MSG_ASSIGN_SECONARY';

-- change STGAP00005223
UPDATE caps.codes_tables SET DECODE='Non-Relative Legal Guardianship' WHERE (code_Type='CCLOSFCF' or code_Type='CCLOSFCC' )
AND code='LG';

-- change STGAP00005228
-- Per design verification at end of R2 system test

UPDATE CAPS.CODES_TABLES SET DECODE = 'Parent must demonstrate ability to care for child/ren''s medical needs.' WHERE DECODE = 'Parent must demonstrate ability to care for child/rens medical needs.' AND CODE = 'MED' AND CODE_TYPE = 'CCGRU';
UPDATE CAPS.CODES_TABLES SET DECODE = 'Parents must ensure that the child''s educational needs are met.' WHERE DECODE = 'Parent must ensure that child/ren attend school on a daily basis.' AND CODE = 'EDU' AND CODE_TYPE = 'CCGRU';
UPDATE CAPS.CODES_TABLES SET DECODE = 'Youth will study at least ___________ minutes/hours per day, _______ days per week.' WHERE DECODE = 'Youth will study at least ___________ minutes/hours per day, _______ days per wee.' AND CODE = 'ZAC' AND CODE_TYPE = 'CWMHSFF';

-- change STGAP00005236
UPDATE CAPS.MESSAGE SET txt_message='Child must be placed in an adoptive home to progress to PAD.' WHERE txt_message_name='MSG_STG_CLOS_ADO_060';
UPDATE CAPS.MESSAGE SET txt_message='Child''s Legal Status must be ''Adoption Finalized''.' WHERE txt_message_name='MSG_STG_CLOS_ADO_010';
UPDATE CAPS.MESSAGE SET txt_message='Most recent Placement must be Adoptive Home.' WHERE txt_message_name='MSG_STG_CLOS_SUB_110';

-- change STGAP00005246
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES ('CPPTNOST','WRT','Written',SYSDATE);

-- change STGAP00005248
UPDATE CAPS.MESSAGE set TXT_MESSAGE = 'Child is 18 or older and cannot be IV-E.' where TXT_MESSAGE_NAME   = 'SSM_END_AFTER_18' ;

-- change STGAP00005251
UPDATE CAPS.CODES_TABLES SET DECODE = 'Consummation' WHERE DECODE = 'Consummatn' AND CODE = 'ACN' AND CODE_TYPE = 'CCONUNIT';
UPDATE CAPS.CODES_TABLES SET DECODE = 'Deliverable' WHERE DECODE = 'Deliverabl' AND CODE = 'DEL' AND CODE_TYPE = 'CCONUNIT';

-- change STGAP00005252
UPDATE CAPS.MESSAGE set TXT_MESSAGE = 'This Delivered Service has Unit Quantities that total over 100,000. Please modify Delivered Service Data.' where TXT_MESSAGE_NAME   = 'MSG_FIN_UNIT_QTY_MAX' ;
UPDATE CAPS.MESSAGE set TXT_MESSAGE = 'Please enter a Person ID, Month, Year, Service, and County to validate.' where TXT_MESSAGE_NAME   = 'MSG_DEL_NOT_VALIDATED';

-- change STGAP00005254
UPDATE CAPS.MESSAGE set TXT_MESSAGE = 'You have entered a Status Effective date that is greater than the current date.  This date must be on or before the current date.' where TXT_MESSAGE_NAME 
  = 'SSM_STATUS_EFFECTIVE';
  
-- change STGAP00005255
UPDATE CAPS.CODES_TABLES SET DECODE='Day Care (UAS 512 Entitlement Code 17)' WHERE code_type='CSPLSERV' AND code='DCR'; 
UPDATE CAPS.CODES_TABLES SET DECODE='Orthodontics (UAS 512 Entitlement Code 58)' WHERE code_type='CSPLSERV' AND code='ORT'; 
UPDATE CAPS.CODES_TABLES SET DECODE='Respite (UAS 512 Entitlement Code 60)' WHERE code_type='CSPLSERV' AND code='RES'; 
UPDATE CAPS.CODES_TABLES SET DECODE='Therapy/Counseling/Surgery (UAS 512 Entitlement Code 58)' WHERE code_type='CSPLSERV' AND code='TCS'; 
UPDATE CAPS.CODES_TABLES SET DECODE='Other (UAS 512 Entitlement Code 58)' WHERE code_type='CSPLSERV' AND code='XXX'; 

-- change STGAP00005264
INSERT INTO CAPS.CODES_TABLES(code_type,code,DECODE,dt_last_update) VALUES('COTHCNCT','THR','Therapist',SYSDATE); 
INSERT INTO CAPS.CODES_TABLES(code_type,code,DECODE,dt_last_update) VALUES('COTHCNCT','XXX','Other',SYSDATE); 

-- change STGAP00005268
UPDATE CAPS.CODES_TABLES SET DECODE='Invited person to orientation (Inquiry follow up only)' WHERE code_type='CCNTPURP' AND code='IPO'; 
UPDATE CAPS.CODES_TABLES SET DECODE='N/A (Inquiry follow up only)' WHERE code_type='CCNTMETH' AND code='INA'; 
UPDATE CAPS.CODES_TABLES SET DECODE='Interested/Still Considering (Inquiry follow up only)' WHERE code_type='CCNTMETH' AND code='ISC'; 
UPDATE CAPS.CODES_TABLES SET DECODE='Left message (Inquiry follow up only)' WHERE code_type='CCNTMETH' AND code='LEM'; 
UPDATE CAPS.CODES_TABLES SET DECODE='No answer (Inquiry follow up only)' WHERE code_type='CCNTMETH' AND code='NOA'; 
UPDATE CAPS.CODES_TABLES SET DECODE='Not Interested (Inquiry follow up only)' WHERE code_type='CCNTMETH' AND code='NOI'; 
UPDATE CAPS.CODES_TABLES SET DECODE='Phone disconnected (Inquiry follow up only)' WHERE code_type='CCNTMETH' AND code='PHD'; 

-- change STGAP00005276
UPDATE CAPS.MESSAGE SET txt_message = 'Review Date is required to close the Administrative Review.' 
WHERE txt_message_name = 'MSG_RVW_DT_REQ_NOT_RLSE' AND nbr_message = 25332;
UPDATE CAPS.MESSAGE SET txt_message = 'Reviewed Person Notified On date is required to close the Administrative Review.' 
WHERE txt_message_name = 'MSG_PRSN_NTFD_REQ_NOT_RLSE' AND nbr_message = 25333;

-- change STGAP00005299
insert into CAPS.MESSAGE(NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) values (99311, 'MSG_DATE1_NO_GREATER_DATE2', '%s date can not be greater than %s date.', 500, 700, 'N');

-- change STGAP00005314
DELETE FROM CAPS.STAGE_PROG WHERE CD_STAGE_PROG_TODO_INFO = 'SUB002';
DELETE FROM CAPS.TODO_INFO WHERE CD_TODO_INFO = 'SUB002';

-- change STGAP00005346
UPDATE CAPS.CODES_TABLES SET DECODE='Other' WHERE CODE_TYPE='CREMFRHR' AND CODE='XXX' AND DECODE='Other Conservatorship';

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (242, 'SacwisRev2', 'static table updates');                        
commit;
