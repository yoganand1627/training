--STGAP00016178 - Release(4.3) Adding new message for Relative Care Assessment

INSERT INTO CAPS.MESSAGE
(ID_MESSAGE,DT_LAST_UPDATE,NBR_MESSAGE,TXT_MESSAGE_NAME,
TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH)
VALUES
(0,SYSDATE,60871,'MSG_REL_CARE_ASSESS_FORM_REQ',
'Please complete the Relative Care Assessment Form before submitting the Relative Care Assessment for approval.',
700,500,'N');

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1041, 'SacwisRev4', 'Release 4.3 - DBCR 16178');

commit;

