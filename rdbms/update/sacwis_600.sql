--STGAP00015580 - Release(Undetermined) Message for Portal Registration

INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH)
  VALUES (60626, 'MSG_PORTAL_DUP_REG','The e-mail address entered has already been registered.',500,700,'N');


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (601, 'SacwisRev3', 'Release Undetermined - DBCR 15580');

commit;

