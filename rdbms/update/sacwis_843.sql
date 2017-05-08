--STGAP00015928 - Release(3.6) MR-66: New  confirm message for approval of Intake

--Updates on 6/22/2010
INSERT INTO CAPS.MESSAGE (dt_last_update,NBR_MESSAGE,TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH)
VALUES ( sysdate,60753,'MSG_INT_APPRVL_ALLEG_LOC_MAL_SPCL_INV', '''Where did the Maltreatment occur?'' selection indicates a candidate for a Special Investigation Call Type that may require a Placement/Non-Placement Provier. Click ''Cancel'' to go back and complete the Special Investigation and the Placement/Non-Placement Provider sections. Click ''Ok'' to Approve', 700, 500,'N');


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (844, 'SacwisRev3', 'Release 3.6 - DBCR 15928');

commit;


