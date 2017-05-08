-- change STGAP00004042
-- ADDED PUP SERVICE ERROR HYPERLINK FOR SUB STAGE
-- FIRST, correct the sequence!

DROP SEQUENCE CAPS.SEQ_ERROR_LIST;

CREATE SEQUENCE CAPS.SEQ_ERROR_LIST
    START WITH 800
    INCREMENT BY 1
    NOMINVALUE
    NOMAXVALUE
    CACHE 20
    NOORDER
;

GRANT SELECT ON  CAPS.SEQ_ERROR_LIST TO OPERATOR;

GRANT SELECT ON  CAPS.SEQ_ERROR_LIST TO CAPSBAT;

GRANT SELECT ON  CAPS.SEQ_ERROR_LIST TO CAPSON;

INSERT INTO caps.error_list (ID_ERROR_LIST, NBR_MESSAGE, TXT_PRGM_CD, TXT_STAGE_CD, ID_TAB, CD_TASK)
VALUES (0, 60348, 'CPS', 'SUB', 1230, 3020);

-- ADDED PUP SERVICE ERROR HYPERLINK FOR FSU STAGE
INSERT INTO caps.error_list (ID_ERROR_LIST, NBR_MESSAGE, TXT_PRGM_CD, TXT_STAGE_CD, ID_TAB, CD_TASK)
VALUES (0, 60348, 'CPS', 'FSU', 1230, 4190);

-- ADDED PUP SERVICE ERROR HYPERLINK FOR PFC STAGE
INSERT INTO caps.error_list (ID_ERROR_LIST, NBR_MESSAGE, TXT_PRGM_CD, TXT_STAGE_CD, ID_TAB, CD_TASK)
VALUES (0, 60348, 'CPS', 'PFC', 1230, 2000);

-- change STGAP00004024
Insert into CAPS.TASK
   (CD_TASK, DT_LAST_UPDATE, CD_TASK_EVENT_TYPE, CD_TASK_STAGE, CD_TASK_STAGE_PROGRAM, CD_TASK_TOP_WINDOW, IND_TASK_EVENT_CREATE, IND_TASK_EVENT_NAVIG, IND_TASK_MULTIPLE_INSTANCE, IND_TASK_NEW_USING, IND_TASK_NU_ACROSS_CASE, IND_TASK_RTRV_PRIOR_STAGE, IND_TASK_SHOW_IN_LIST, TXT_TASK_DECODE, TXT_1ST_TAB, TXT_2ND_TAB, TXT_3RD_TAB, TXT_EVENT_DETAIL_URL, IND_TASK_CODE_PREFER, IND_TASK_NEW_CASE_TODO_ENABLE, IND_TASK_FORCE_EVENT_LINK, IND_STAGE_CLOSURE)
 Values
   ('8280', sysdate, 'APP', 'FAD', 'CPS', 'CCMN65W', '0', '1', '1', '0', '0', '0', '0', 'Approve Hold Placements Change', 'CASE_CASESEARCH', 'HOME_INFORMATION_HOMEINFRMTN', 'HOME_INFORMATION_3_HOMEINFRMTN', '/fad/HomeInfrmtn/displayInitHomeInformation', 0, '0', '0', '0');

-- change STGAP00004041
update CAPS.MESSAGE set TXT_MESSAGE = 'You must complete Date Approved and the Approved/Denied option for Special Services before saving.' where NBR_MESSAGE = 8372 and TXT_MESSAGE_NAME = 'MSG_ADPT_SUB_DETAIL_INCOMPLETE';

-- change STGAP00004008
update caps.message set txt_message='The Max Interest Age must be greater than or equal to the Max Approved Age.' where nbr_message=7124;
update caps.message set txt_message='The Min Interest Age must be less than or equal to the Min Approved Age.' where nbr_message=7121;


insert into caps.schema_version (id_schema_version, application_version, comments)
                         values (210, 'SacwisRev2', 'static updates');
commit;
