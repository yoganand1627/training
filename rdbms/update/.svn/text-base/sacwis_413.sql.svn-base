--STGAP00011545 - Add new messages for RCA custom validation

--Note:  no impact on ado model

--Add new messages for custom validation of the following RCA fields when submitting a RCA for approval:
--1. Date Assessment Complete
--2. Date Assessment Received
--3. Assessment Results
--4. Decision Date

--This defect is need for the resolution of defect STGAP00010649

--SQL to insert new messages into the MESSAGE table
------------------------------------------------------------------

INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH)
VALUES (60510, 'MSG_RCA_DATE_ASSESSMENT_COMP_REQ', 'Date Assessment Complete is required to submit an assessment for approval.', 700, 500, 'N');

INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH)
VALUES (60511, 'MSG_RCA_DATE_ASSESSMENT_RECVD_REQ', 'Date Assessment Received is required to submit an assessment for approval.', 700, 500, 'N');

INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH)
VALUES (60512, 'MSG_RCA_ASSESSMENT_RESULTS_REQ', 'Assessment Results is required to submit an assessment for approval.', 700, 500, 'N');

INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH)
VALUES (60513, 'MSG_RCA_DECISION_DATE_REQ', 'Decision Date is required to submit an assessment for approval.', 700, 500, 'N');


--STGAP00011551 - Per STGAP00009725 Insert New Row in Task Table

--Note:  no impact to ado model

--Per STGAP00009725 , we need to add  task code for Team Meetings/Reviews approval
-- event in the ADO stage.

--This will resolve the  IllegalStateException when Save and Submit of Child Plans
-- Team Meetings/Reviews in ADO stage.

--SQL Statements:

INSERT INTO caps.task t
(t.CD_TASK,t.DT_LAST_UPDATE, t.CD_TASK_EVENT_TYPE, t.CD_TASK_STAGE, t.CD_TASK_STAGE_PROGRAM, t.IND_TASK_EVENT_CREATE,
 t.IND_TASK_EVENT_NAVIG, t.IND_TASK_MULTIPLE_INSTANCE, t.IND_TASK_NEW_USING, t.IND_TASK_NU_ACROSS_CASE,
 t.IND_TASK_RTRV_PRIOR_STAGE, t.IND_TASK_SHOW_IN_LIST, t.TXT_TASK_DECODE, t.TXT_1ST_TAB,t.TXT_2ND_TAB,
 t.TXT_3RD_TAB, t.TXT_EVENT_DETAIL_URL )
 VALUES
 ('9480', sysdate , 'APP','ADO','CPS','0',  '1','1','0','0',
  '0','0','Approve Team Meetings/Reviews',  'CASE_CASESEARCH','CHILD_PLANS_EVENTLIST',
  'PERMANENCY_PLANNING_REVIEW_PPT_EVENTLIST','/subcare/PPT/displayPPT');



--STGAP00011556 - Add message for  Placement Info custom validation

--Note:  no impact to ado model

--Add new message for custom validation of the following Placement Information conversation fields when submitting placement information for approval:
--1.Boarding County [checkbox]
--2. Boarding County [county selection dropdown]

--This defect is needed for resolution of defect STGAP00010671

--SQL to insert new messages into the MESSAGE table
----------------------------------------------------------------

INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH)
VALUES (60514, 'MSG_PLCMT_BOARDING_COUNTY_REQ', 'Boarding county is marked. Please select a Boarding County.', 700, 500, 'N');


insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (414, 'SacwisRev3', 'Release 3.1 - DBCRs 11545,11551,11556');

commit;



