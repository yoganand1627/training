--STGAP00016038 - Release(4.1) MR-074 AFCARS Phase 1 Add New MESSAGE

-- STGAP00016038
-- MR-074 AFCARS Phase 1 Add New MESSAGE

INSERT INTO CAPS.MESSAGE
(ID_MESSAGE,DT_LAST_UPDATE,NBR_MESSAGE,TXT_MESSAGE_NAME,
TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH)
VALUES
(0,SYSDATE,60813,'MSG_PLCMT_GROUP_HOME_ERR',
'Group Home is not a valid Placement Type per Georgia Policy. Please choose Child Care Institution instead.',
700,500,'N');

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (931, 'SacwisRev4', 'Release 4.1 - DBCR 16038');

commit;

