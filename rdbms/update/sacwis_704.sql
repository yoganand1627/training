--STGAP00015730 - Release(3.5) Message for OBIEE Shines integration

INSERT INTO CAPS.MESSAGE (NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) VALUES ('60655', 'MSG_NO_SEC_VIEW_CASE', 'You do not have the security to view the case you requested.', '500', '700', 'N');


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (705, 'SacwisRev3', 'Release 3.5 - DBCR 15730');

commit;


