--STGAP00011472 - Delete invalid rows from the STAGE_PROG table

--Note:  no impact to ado model

--When a Custody Removal event is created a FCC stage is automatically open but two invalid events are created during the process.
--One event has a null description and the other event is the "Post Foster Care Stage Opened". Delete the following invalid rows from the
--STAGE_PROG tables to allow the FCC stage to successfully open without creating the invalid events. 
--See defect STGAP00009496 for additional information.


-- Delete invalid row that produces the "Post Foster Care Stage Opened" event when attempting to -- open a Foster Care Child (FCC) stage

DELETE FROM CAPS.STAGE_PROG S
   WHERE S.CD_STAGE_PROG_STAGE = 'SUB'
   AND S.CD_STAGE_PROG_RSN_CLOSE = 'SUB'
   AND S.CD_STAGE_PROG_PROGRAM = 'CPS'
   AND S.CD_STAGE_PROG_OPEN = 'PFC'
   AND S.CD_STAGE_PROG_EVENT_TYPE = 'STG';

-- Delete invalid row that produces a "null" event description when attempting to open a Foster Care --Child (FCC) stage
DELETE FROM CAPS.STAGE_PROG S
   WHERE S.CD_STAGE_PROG_STAGE = 'SUB'
   AND S.CD_STAGE_PROG_RSN_CLOSE = 'SUB'
   AND S.CD_STAGE_PROG_PROGRAM = 'CPS'
   AND S.CD_STAGE_PROG_OPEN = 'ADO'
   AND S.CD_STAGE_PROG_EVENT_TYPE = 'STG';


insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (412, 'SacwisRev3', 'Release 3.1 - DBCRs 11472');

commit;


