--STGAP00009569 - Per STGAP00009014 :Add Column to Stage Table.

ALTER TABLE CAPS.STAGE
     ADD  TXT_STAGE_RES_TIME_CMNTS VARCHAR2(300);


--STGAP00009611 - CodesTable Maintenance - Metaphor updates

INSERT INTO CAPS.METAPHOR ( ID_TAB, TXT_TAB_URL, TXT_TAB_CONSTANT, TXT_TAB, DT_LAST_UPDATE)
VALUES (1660, '/admin/CodesTablesMnt/displayCodesTablesList', 'CODES_TABLES_MAINTENANCE_CODESTABLESMNT', 'Codes Tables<br>Maintenance',  SYSDATE);

INSERT INTO CAPS.METAPHOR ( ID_TAB, TXT_TAB_URL, TXT_TAB_CONSTANT, TXT_TAB, DT_LAST_UPDATE)
VALUES (1665, '/admin/CodesTablesMnt/displayCodesTablesList', 'CODES_TABLES_MAINTENANCE_3_CODESTABLESMNT', 'Codes Tables Maintenance',  SYSDATE);


--STGAP00009614 - Codes Tables Maintenance - New Messages

INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH)
VALUES (60467, 'MSG_CODES_TABLE_CODE_EXISTS', 'There is already a code with this value in the selected Codes Table.', 700, 500, 'N');

INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH)
VALUES (60468, 'MSG_END_DATE_FUTURE', 'An End-Date must be set in the future.',700, 500, 'N');

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (362, 'SacwisRev2', 'Release 2.6 - DBCRs 9569,9611,9614');

commit;


