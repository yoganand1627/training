--STGAP00017450 - Release(5.0) ECEM 5.0: updated message for services by area

-- Correction
UPDATE CAPS.MESSAGE SET TXT_MESSAGE = 'At least one County needs to be selected.'
WHERE TXT_MESSAGE_NAME = 'MSG_REQ_CNTY_MIN';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1156, 'SacwisRev5', 'Release 5.0 - DBCR 17450');

commit;
