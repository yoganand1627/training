--STGAP00015484 - MR-056: Add Messgs for validating Unknown selected

INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH)
  VALUES (60586, 'MSG_INV_MBR_HH_UNKNOWN','''Unknown'' is selected for Member of Pri
mary Caretaker''s household on Person Detail for %s',500,700,'N');

INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH)
  VALUES (60587, 'MSG_UNKNOWN_MBR_HH_NO_ADD','A %s can not be added because Unknown
has been selected for Member of Primary Caretaker''s Household on Person Detail
for  %s',500,700,'N');

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (562, 'SacwisRev3', 'Release 3.3 - DBCR 15484');

commit;

