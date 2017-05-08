--STGAP00016982 - Release(5.0) Database Changes for ECEM (part 1)

--Create Contract Columns
ALTER TABLE caps.contract_period ADD (TXT_LAST_UPDATED_BY VARCHAR (100));

ALTER TABLE caps.contract_version ADD (TXT_LAST_UPDATED_BY VARCHAR (100));

--BACKOUT
--ALTER TABLE caps.contract_period drop column TXT_LAST_UPDATED_BY ;
--ALTER TABLE caps.contract_version drop column TXT_LAST_UPDATED_BY ;

--Create Contract Service Messages
Insert into caps.message (NBR_MESSAGE, DT_LAST_UPDATE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) 
Values (60875, SYSDATE, 'MSG_SVC_CODE_NONE_SELECTED', 'Please select at least one service code.', 500, 700, 'N');

--Create Contract Period Message
Insert into caps.message (NBR_MESSAGE, DT_LAST_UPDATE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) 
Values (60876, SYSDATE, 'MSG_FUTR_EFF_DATE', 'Effective Date cannot be a future date.', 500, 700, 'N');

Insert into caps.message (NBR_MESSAGE, DT_LAST_UPDATE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) 
Values (60877, SYSDATE, 'MSG_END_DT_TWO_DAYS', 'Period end date cannot be prior to two days of the current effective date of the latest version.', 500, 700, 'N');

Insert into caps.message (NBR_MESSAGE, DT_LAST_UPDATE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) 
Values (60878, SYSDATE, 'MSG_VERS_START_DT_CHG', 'Period update will change a version start or end date. Do you still want to proceed?', 500, 700, 'N');

Insert into caps.message (NBR_MESSAGE, DT_LAST_UPDATE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) 
Values (60879, SYSDATE, 'MSG_EARLY_TERM_END_DT', 'You have updated the early termination date. The early termination date must be the same as the end date.', 500, 700, 'N');

--Create Contract Version Messages
Insert into caps.message (NBR_MESSAGE, DT_LAST_UPDATE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) 
Values (60880, SYSDATE, 'MSG_LOCK_CNFRMTN', 'Locking contract will make the contract version unmodifiable.  Are you sure you are ready to lock the contract?', 500, 700, 'N');

Insert into caps.message (NBR_MESSAGE, DT_LAST_UPDATE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) 
Values (60881, SYSDATE, 'MSG_PER_STRT_END_DT_CHG', 'Version update will change a period start or end date. Do you still want to proceed?', 500, 700, 'N');

Insert into caps.message (NBR_MESSAGE, DT_LAST_UPDATE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) 
Values (60882, SYSDATE, 'MSG_EFF_DT_SAME_PREV_EFF_DT', 'Effective date cannot be prior to or on the same day as the previous version''s effective date.', 500, 700, 'N');

Insert into caps.message (NBR_MESSAGE, DT_LAST_UPDATE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) 
Values (60883, SYSDATE, 'MSG_SAME_EFF_AND_END_DT', 'The effective date update you have made results in the effective date and end date to be the same date for the previous version''s record. This is not allowed.', 500, 700, 'N');

Insert into caps.message (NBR_MESSAGE, DT_LAST_UPDATE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) 
Values (60884, SYSDATE, 'MSG_UPDT_VERIF', 'Have you checked your updates before saving?', 500, 700, 'N');

Insert into caps.message (NBR_MESSAGE, DT_LAST_UPDATE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) 
Values (60885, SYSDATE, 'MSG_TWO_DAY_MIN', 'Effective date must be more than two days after the previous version''s effective date.', 500, 700, 'N');

--Create Placement Info Message
Insert into caps.message (NBR_MESSAGE, DT_LAST_UPDATE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) 
Values (60886, SYSDATE, 'MSG_KENNY_A_WARN', 'Placing the child in this home subjects them to Kenny A requirements. Before proceeding, please talk with your Supervisor to identify the appropriate Kenny A coordinators.', 500, 700, 'N');


Insert into caps.message (NBR_MESSAGE, DT_LAST_UPDATE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) 
Values (60887, SYSDATE, 'MSG_CONFIRM_PLCMT_SS_ERR', 'Please confirm that you have viewed the Placement Log and certified the appropriateness of the Placement on the same day that the Placement is submitted for approval.', 500, 700, 'N');


Insert into caps.message (NBR_MESSAGE, DT_LAST_UPDATE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) 
Values (60888, SYSDATE, 'MSG_CONFIRM_PLCMT_LOG_ERR', 'Please view the Placement Log prior to certifying the appropriateness of the placement.', 500, 700, 'N');


Insert into caps.message (NBR_MESSAGE, DT_LAST_UPDATE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) 
Values (60889, SYSDATE, 'MSG_CONFIRM_PLCMT_APPR_APRV_ERR', 'Please confirm that you have viewed the Placement Log and certified the appropriateness of the Placement on the same day that the Placement is approved.', 500, 700, 'N');

--Update CodesTables
update caps.codes_tables
set decode = 'Child History of Sexual Abuse'
where code_type = 'OTH' and code = '202';


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1066, 'SacwisRev5', 'Release 5.0 - DBCR 16982');

commit;

