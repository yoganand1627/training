--STGAP00016163 - Release(4.3) new codes and messages

--new codes and messages

--CAPTA 4.3 - Intake Actions

-- Inserting new rows for code type CPHYABSE 
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CPHYABSE', 'PCNI', 'No Injuries Observed', null, sysdate);

-- Inserting new rows for code type COTHER 
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('COTHER', 'OMNC', 'Death by Natural Causes', null, sysdate);

insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('COTHER', 'OMAD', 'Accidental Death', null, sysdate);

insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('COTHER', 'OMUC', 'Parent Unable to Cope', null, sysdate);

-- CAPTA 4.3 update Messages for Intake Actions page
update caps.message
set TXT_MESSAGE = 'The system has determined a Maltreatment in care situation based on the Alleged Incident Date and the Maltreator Relationship recorded on the Allegation Detail page, as well as the child''s ''In Custody'' Legal Status. Selections for the Special Investigation Call Type and Placement/Non-Placement Provider Information sections are required.'
where TXT_MESSAGE_NAME = 'MSG_INT_SPCL_INV_PLACEMENT_REQ'
;

--CAPTA 4.3 insert new message for Intake Actions page
INSERT INTO CAPS.MESSAGE
(ID_MESSAGE,DT_LAST_UPDATE,NBR_MESSAGE,TXT_MESSAGE_NAME,
TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH)
VALUES
(0,SYSDATE,60869,'MSG_INT_SPCL_INV_CALL_TYPE_REQ',
'Please select a Special Investigation Call Type when a Placement/Non-Placement Provider has been documented.',
700,500,'N');


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1033, 'SacwisRev4', 'Release 4.3 - DBCR 16163');

commit;

