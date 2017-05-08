--STGAP00017064 - Release(5.0) MR-095 Person Relationships Add New Messages

-- MR-095 Person Relationships Add New Messages

INSERT INTO CAPS.MESSAGE
(ID_MESSAGE,DT_LAST_UPDATE,NBR_MESSAGE,TXT_MESSAGE_NAME,
TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH)
VALUES
(0,SYSDATE,60902,'MSG_ERR_TYPE_AND_REL_REQ',
'Please select the Type and Relationship for the stage selected.',
700,500,'N');

INSERT INTO CAPS.MESSAGE
(ID_MESSAGE,DT_LAST_UPDATE,NBR_MESSAGE,TXT_MESSAGE_NAME,
TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH)
VALUES
(0,SYSDATE,60903,'MSG_RELATHIONSHIP_SELF_EXIST',
'A Relationship of Self or Self/Minor Parent already exists; multiple relationships of Self or Self/Minor Parent are not allowed, except in the FCF stage.',
700,500,'N');

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1082, 'SacwisRev5', 'Release 5.0 - DBCR 17064');

commit;
