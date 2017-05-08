-- Standard Alter Table SQL

REVOKE DELETE ON CAPS.DELETE_CASE_HIST FROM OPERATOR
;
REVOKE INSERT ON CAPS.DELETE_CASE_HIST FROM OPERATOR
;
REVOKE UPDATE ON CAPS.DELETE_CASE_HIST FROM OPERATOR
;

-- Drop Constraint, Rename and Create Table SQL

CREATE TABLE CAPS.CPS_CONCLUSION_NARR
(
    ID_EVENT             NUMBER(16) NOT NULL,
    DT_LAST_UPDATE       DATE       NOT NULL,
    ID_CASE              NUMBER(16)     NULL,
    NARRATIVE            LONG RAW       NULL,
    ID_DOCUMENT_TEMPLATE NUMBER(16)     NULL,
    CONSTRAINT PK_CPS_CONCLUSION_NARR
    PRIMARY KEY (ID_EVENT)
    USING INDEX TABLESPACE INDEX01
                STORAGE(BUFFER_POOL DEFAULT)
    ENABLE
    VALIDATE
)
TABLESPACE DATA01
LOGGING
STORAGE(BUFFER_POOL DEFAULT)
NOPARALLEL
NOCACHE
;
COMMENT ON TABLE CAPS.CPS_CONCLUSION_NARR IS
'Contains the narrative blob for the CPS Conclusion Narrative.'
;
COMMENT ON COLUMN CAPS.CPS_CONCLUSION_NARR.DT_LAST_UPDATE IS
'Date of insert or last update'
;
GRANT DELETE ON CAPS.CPS_CONCLUSION_NARR TO CAPSBAT
;
GRANT INSERT ON CAPS.CPS_CONCLUSION_NARR TO CAPSBAT
;
GRANT SELECT ON CAPS.CPS_CONCLUSION_NARR TO CAPSBAT
;
GRANT UPDATE ON CAPS.CPS_CONCLUSION_NARR TO CAPSBAT
;
GRANT DELETE ON CAPS.CPS_CONCLUSION_NARR TO CAPSON
;
GRANT INSERT ON CAPS.CPS_CONCLUSION_NARR TO CAPSON
;
GRANT SELECT ON CAPS.CPS_CONCLUSION_NARR TO CAPSON
;
GRANT UPDATE ON CAPS.CPS_CONCLUSION_NARR TO CAPSON
;
GRANT SELECT ON CAPS.CPS_CONCLUSION_NARR TO OPERATOR
;

-- Add Referencing Foreign Keys SQL

ALTER TABLE CAPS.CPS_CONCLUSION_NARR 
    ADD CONSTRAINT FK_CONCLUSION_NARR_EVENT
FOREIGN KEY (ID_EVENT)
REFERENCES CAPS.EVENT (ID_EVENT)
ENABLE
;

-- Alter Trigger SQL
/
CREATE OR REPLACE TRIGGER CAPS.TIBR_RESOURCE_CHRCTR
BEFORE INSERT
ON CAPS.RESOURCE_CHRCTR
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
DECLARE
  dummy  NUMBER;
  CURSOR C1 (xID NUMBER) IS SELECT
    ID_RESOURCE,
          CD_RSRC_SVC_CATEG_RSRC,
          CD_RSRC_SVC_CNTY,
          CD_RSRC_SVC_PROGRAM,
          CD_RSRC_SVC_REGION,
          CD_RSRC_SVC_SERVICE,
          CD_RSRC_SVC_STATE,
          CD_RSRC_SVC_SERVICE_TYPE,
    SEQ_RESOURCE_CHRCTR.NEXTVAL
  FROM RESOURCE_SERVICE
  WHERE ID_RESOURCE_SERVICE=xID;
        xID_RESOURCE    NUMBER;
        xCD_RSRC_CHAR_CATEG_RSRC  VARCHAR2(3);
        xCD_RSRC_CHAR_CNTY  VARCHAR2(3);
        xCD_RSRC_CHAR_PROGRAM  VARCHAR2(2);
        xCD_RSRC_CHAR_REGION  VARCHAR2(2);
        xCD_RSRC_CHAR_SERVICE  VARCHAR2(6);
        xCD_RSRC_CHAR_STATE  VARCHAR2(2);
        xCD_RSRC_CHAR_SERVICE_TYPE VARCHAR2(1);
  RECORD_NOT_FOUND  EXCEPTION;
BEGIN
  OPEN C1(:new.ID_RESOURCE_SERVICE);
  FETCH C1 INTO  xID_RESOURCE,
      xCD_RSRC_CHAR_CATEG_RSRC,
            xCD_RSRC_CHAR_CNTY,
            xCD_RSRC_CHAR_PROGRAM,
            xCD_RSRC_CHAR_REGION,
            xCD_RSRC_CHAR_SERVICE,
            xCD_RSRC_CHAR_STATE,
            xCD_RSRC_CHAR_SERVICE_TYPE,
      dummy;
  IF C1%FOUND THEN
    --Always get the new values from table RESOURCE_SERVICE, regardless
    --what the user has put into these fields (because these fields are
    --denormalized, thus they must be the same as from the original table)
    :new.ID_RESOURCE    := xID_RESOURCE;
    :new.CD_RSRC_CHAR_CATEG_RSRC  := xCD_RSRC_CHAR_CATEG_RSRC;
    :new.CD_RSRC_CHAR_CNTY    := xCD_RSRC_CHAR_CNTY;
    :new.CD_RSRC_CHAR_PROGRAM  := xCD_RSRC_CHAR_PROGRAM;
    :new.CD_RSRC_CHAR_REGION  := xCD_RSRC_CHAR_REGION;
    :new.CD_RSRC_CHAR_SERVICE  := xCD_RSRC_CHAR_SERVICE;
    :new.CD_RSRC_CHAR_STATE    := xCD_RSRC_CHAR_STATE;
    :new.CD_RSRC_CHAR_SERVICE_TYPE := xCD_RSRC_CHAR_SERVICE_TYPE;
  ELSE
    -- Service is now an optional field, so not an error.
    -- RAISE RECORD_NOT_FOUND;
    SELECT	SEQ_RESOURCE_CHRCTR.NEXTVAL
	INTO	dummy
	FROM	DUAL;
  END IF;
  CLOSE C1;
  :new.DT_LAST_UPDATE := SYSDATE;
  IF (:new.ID_RSRC_CHRCTR = 0) THEN
    :new.ID_RSRC_CHRCTR := dummy;
  END IF;
EXCEPTION
  WHEN OTHERS THEN RAISE;
END;
/
/
CREATE OR REPLACE TRIGGER CAPS.TIBR_CPS_CONCLUSION_NARR
BEFORE INSERT
ON CAPS.CPS_CONCLUSION_NARR
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
   :NEW.DT_LAST_UPDATE := SYSDATE;
   SELECT ID_CASE
   INTO  :NEW.ID_CASE
   FROM  EVENT
   WHERE  ID_EVENT = :NEW.ID_EVENT;
 EXCEPTION
 WHEN OTHERS THEN
   IF SQL%NOTFOUND THEN
     :NEW.ID_CASE := NULL;
   END IF;
 END;
/
/
CREATE OR REPLACE TRIGGER CAPS.TUBR_CPS_CONCLUSION_NARR
BEFORE UPDATE
ON CAPS.CPS_CONCLUSION_NARR
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
    :NEW.DT_LAST_UPDATE := SYSDATE;
 END;
/

{ call dbms_utility.compile_schema('CAPS') };
{ call dbms_utility.compile_schema('CAPSBAT') };
{ call dbms_utility.compile_schema('CAPSON') };
{ call dbms_utility.compile_schema('OPERATOR') };
{ call dbms_utility.compile_schema('SACWISIFC') };

-- change STGAP00003447
INSERT INTO caps.TASK (cd_task, dt_last_update, cd_Task_event_type, cd_task_list_window, cd_task_stage, cd_task_stage_program, cd_task_top_window,
ind_Task_event_create, ind_task_event_navig, ind_task_multiple_instance, ind_task_new_using, ind_task_nu_across_case, ind_task_rtrv_prior_stage, ind_task_show_in_list,
txt_task_decode, txt_1st_tab, txt_2nd_tab, txt_3rd_tab, txt_event_detail_url, ind_Task_code_prefer, ind_task_new_case_todo_enable, ind_task_force_event_link, ind_stage_closure)
VALUES 
('2070',SYSDATE, 'CCL','CCMN51W','PFC','CPS','CSUB50W',1,1,0,0,0,0,1,'Close Post Foster Care Stage','CASE_CASESEARCH','CASE_MANAGEMENT_CASEMNT', 'CLOSE_POST_FC_STAGE_STAGECLOSURE',
'/workload/StageClosure/displayStageClosure',3,1,0,1);

INSERT INTO caps.TASK (cd_task, dt_last_update, cd_Task_event_type, cd_task_list_window, cd_task_stage, cd_task_stage_program, cd_task_top_window,
ind_Task_event_create, ind_task_event_navig, ind_task_multiple_instance, ind_task_new_using, ind_task_nu_across_case, ind_task_rtrv_prior_stage, ind_task_show_in_list,
txt_task_decode, txt_1st_tab, txt_2nd_tab, txt_3rd_tab, txt_event_detail_url, ind_Task_code_prefer, ind_task_new_case_todo_enable, ind_task_force_event_link, ind_stage_closure)
VALUES 
('2080',SYSDATE, 'APP',NULL,'PFC','CPS','CCMN65W',0,1,1,0,0,0,0,'Approve Post Foster Care Closure','CASE_CASESEARCH','CASE_MANAGEMENT_CASEMNT', 'CLOSE_POST_FC_STAGE_STAGECLOSURE',
'/workload/StageClosure/displayStageClosure',0,0,0,1);

UPDATE caps.TASK
SET txt_task_decode = 'Approve Post-Adoption Closure'
WHERE cd_task = '9400';

-- change STGAP00003456
UPDATE CAPS.BATCH_PARAMETERS
SET NM_BATCH_PARAMETER = 'PROVIDER_1', TXT_PARAMETER_VALUE = '000560711A'
WHERE NM_BATCH_PARAMETER = 'PROCEDURE_1';

UPDATE CAPS.BATCH_PARAMETERS
SET NM_BATCH_PARAMETER = 'PROVIDER_2', TXT_PARAMETER_VALUE ='000560722A'
WHERE NM_BATCH_PARAMETER = 'PROCEDURE_2';

UPDATE CAPS.BATCH_PARAMETERS
SET NM_BATCH_PARAMETER = 'PROCEDURE', TXT_PARAMETER_VALUE ='T2023'
WHERE NM_BATCH_PARAMETER = 'PROVIDER';

-- change STGAP00003468
UPDATE caps.message
SET txt_message = 'Please enter a username that contains between 4 and 20 characters.'
WHERE txt_message_name = 'MSG_ARC_CONSTR_NOVELL_USERNAME';

-- change STGAP00003475
UPDATE CAPS.MESSAGE
SET TXT_MESSAGE = 'Payment of Care must be ended.'
WHERE
NBR_MESSAGE = '8186';

UPDATE CAPS.MESSAGE
SET TXT_MESSAGE = 'An open paid placement exists.'
WHERE
NBR_MESSAGE = '8360';

UPDATE CAPS.MESSAGE
SET TXT_MESSAGE = 'Child''s Legal Status must be No Longer in DFCS Custody.'
WHERE
NBR_MESSAGE = '8187';

UPDATE CAPS.MESSAGE
SET TXT_MESSAGE = 'Child''s latest Placement Removal Reason must be Reunification.'
WHERE
NBR_MESSAGE = '8190';

UPDATE CAPS.MESSAGE
SET TXT_MESSAGE = 'Placement closure reason must be Adoption Finalized.'
WHERE 
NBR_MESSAGE = '8192';

UPDATE CAPS.MESSAGE
SET TXT_MESSAGE = 'FCF cannot be closed while FCC or ADO remain open.'
WHERE 
NBR_MESSAGE = '8381';

insert into caps.schema_version (id_schema_version, application_version, comments)
                         values (194, 'SacwisRev2', 'static updates, trigger fix, new narrative table'); 

commit;
