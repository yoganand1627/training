-- All changes for version 2.4 of SHINES

-- Standard Alter Table SQL

ALTER TABLE CAPS.EMP_TEMP_ASSIGN MODIFY(DT_ASSIGN_EXPIRATION   NULL)
;

-- Alter Index SQL

CREATE INDEX CAPS.IND_CAPS_RESOURCE_8
    ON CAPS.CAPS_RESOURCE(CD_RSRC_CNTY,CD_RSRC_STATE,CD_RSRC_TYPE,CD_RSRC_STATUS)
TABLESPACE INDEX01
STORAGE(BUFFER_POOL DEFAULT)
NOPARALLEL
NOCOMPRESS
;

{ call dbms_utility.compile_schema('CAPS') };
{ call dbms_utility.compile_schema('CAPSBAT') };
{ call dbms_utility.compile_schema('CAPSON') };
{ call dbms_utility.compile_schema('OPERATOR') };
{ call dbms_utility.compile_schema('SACWISIFC') };

-- change STGAP00008014
INSERT INTO caps.MESSAGE
(id_message, dt_last_update, nbr_message, txt_message_name, txt_message, cd_source, cd_presentation, ind_batch)
VALUES
(0,SYSDATE,60408, 'MSG_INT_MULTIPLE_ROWS','Only one row may be selected to complete this action.','700','500','N');

INSERT INTO caps.MESSAGE
(id_message, dt_last_update, nbr_message, txt_message_name, txt_message, cd_source, cd_presentation, ind_batch)
VALUES
(0,SYSDATE,60409, 'MSG_INT_DELETE_REPORTER','You may not delete a person marked as reporter.','700','500','N');

-- change STGAP00008027
INSERT INTO caps.MESSAGE
(id_message, dt_last_update, nbr_message, txt_message_name, txt_message, cd_source, cd_presentation, ind_batch)
VALUES
(0,SYSDATE,60404, 'MSG_INT_SAVE_NI_ALLEGS',' Allegations cannot be recorded for a Non-incident intake. Delete allegations or update Intake Information to remove the Non-incident type.','700','500','N');

INSERT INTO caps.MESSAGE
(id_message, dt_last_update, nbr_message, txt_message_name, txt_message, cd_source, cd_presentation, ind_batch)
VALUES
(0,SYSDATE,60405, 'MSG_INT_SAVE_NI_DISP',' Non-incident intakes cannot be Accepted and Assigned, Diverted, or Screened Out. Remove disposition and Save and Close or Save and Submit from Intake Information page, or update Intake Information to remove the Non-incident type.','700','500','N');

INSERT INTO caps.MESSAGE
(id_message, dt_last_update, nbr_message, txt_message_name, txt_message, cd_source, cd_presentation, ind_batch)
VALUES
(0,SYSDATE,60406, 'MSG_INT_SAVE_NI_DETERM_FACTORS',' Non-incident intakes cannot have determination factors. Remove determination factors or update Intake Information to remove the Non-incident type.','700','500','N');

INSERT INTO caps.MESSAGE
(id_message, dt_last_update, nbr_message, txt_message_name, txt_message, cd_source, cd_presentation, ind_batch)
VALUES
(0,SYSDATE,60407, 'MSG_INT_SAVE_NI_RESP_TIME',' Non-incident intakes do not have a response time. Remove response time or update Intake Information to remove the Non-incident type.','700','500','N');

-- change STGAP00008035

UPDATE CAPS.MESSAGE SET TXT_MESSAGE = 'Service Provider Name and Type of Service must be chosen when selecting a disposition of ''Screen Out & Referred''.' WHERE nbr_message = 60382;

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (311, 'SacwisRev2', 'static table updates, add RESOURCE INDEX 8');                        
commit;
