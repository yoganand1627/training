--STGAP00016142 - Release(4.3) MR-082: AA Non-Recurring Only new error message

--MR-082 (SMS#10943): new validation message for Adoption Assistance Application (Non-recurring Only)

INSERT INTO CAPS.MESSAGE
(ID_MESSAGE,DT_LAST_UPDATE,NBR_MESSAGE,TXT_MESSAGE_NAME,
TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH)
VALUES
(0,SYSDATE,60858,'MSG_ADO_APP_SND_REQ_NON_REC',
'Special Needs Determination type must be selected on the Non-Recurring Only application.',
700,500,'N');

INSERT INTO CAPS.MESSAGE
(ID_MESSAGE,DT_LAST_UPDATE,NBR_MESSAGE,TXT_MESSAGE_NAME,
TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH)
VALUES
(0,SYSDATE,60859,'MSG_INCIDENT_NON_REC_ONLY_MISMATCH',
'\"Non-Incident Child\" must be selected for any Application marked \"Non-Recurring Only\".',
700,500,'N');

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1019, 'SacwisRev4', 'Release 4.3 - DBCR 16142');

commit;



